#!/usr/bin/env bash
# VictusHub installer supporting multiple init systems
# Moves binaries, sets up passwordless sudo, creates desktop entry and installs service

set -e

APP_NAME="VictusHub"
GUI_BINARY="./VictusHub"
SERVICE_BINARY="./VictusService"
GUI_TARGET="/usr/local/bin/VictusHub"
SERVICE_TARGET="/usr/local/bin/VictusService"

# Desktop entry
DESKTOP_DIR="$HOME/.local/share/applications"
DESKTOP_FILE="$DESKTOP_DIR/victushub.desktop"
ICON_SOURCE="./icon.png"
ICON_TARGET_DIR="$HOME/.local/share/icons/hicolor/128x128/apps"
ICON_TARGET="$ICON_TARGET_DIR/victushub.png"

# Sudoers for service
SUDOERS_FILE="/etc/sudoers.d/victusService-$(whoami)"

# ---------- 0️⃣ Check git ----------
if ! command -v git >/dev/null 2>&1; then
    echo "git is not installed. Please install git manually and re-run this installer."
    exit 1
fi

# ---------- 1️⃣ Clone and build dependency ----------
if [[ ! -d "hp-wmi-fan-and-backlight-control" ]]; then
    echo "Cloning hp-wmi-fan-and-backlight-control..."
    git clone https://github.com/Vilez0/hp-wmi-fan-and-backlight-control
fi
cd hp-wmi-fan-and-backlight-control
echo "Building hp-wmi-fan-and-backlight-control..."
make
sudo make install-dkms
cd ..

# ---------- 2️⃣ Move binaries ----------
for BINARY in "$GUI_BINARY" "$SERVICE_BINARY"; do
    if [[ ! -f "$BINARY" ]]; then
        echo "Error: $BINARY not found in current directory"
        exit 1
    fi
done

# GUI
if [[ ! -f "$GUI_TARGET" ]]; then
    echo "Moving $GUI_BINARY -> $GUI_TARGET (requires sudo)..."
    sudo mv "$GUI_BINARY" "$GUI_TARGET"
    sudo chmod 755 "$GUI_TARGET"
else
    echo "GUI binary already exists at $GUI_TARGET, skipping move."
fi

# Service
if [[ ! -f "$SERVICE_TARGET" ]]; then
    echo "Moving $SERVICE_BINARY -> $SERVICE_TARGET (requires sudo)..."
    sudo mv "$SERVICE_BINARY" "$SERVICE_TARGET"
    sudo chmod 755 "$SERVICE_TARGET"
else
    echo "Service binary already exists at $SERVICE_TARGET, skipping move."
fi

# ---------- 3️⃣ Sudoers setup for service ----------
if [[ ! -f "$SUDOERS_FILE" ]]; then
    read -p "Add passwordless sudo for $SERVICE_TARGET? (y/N): " ans
    if [[ "$ans" == "y" || "$ans" == "Y" ]]; then
        echo "$(whoami) ALL=(root) NOPASSWD: $SERVICE_TARGET" | sudo tee "$SUDOERS_FILE" > /dev/null
        sudo chmod 440 "$SUDOERS_FILE"
        sudo visudo -c -f "$SUDOERS_FILE"
        echo "Sudoers fragment created at $SUDOERS_FILE"
    else
        echo "Skipping sudoers setup."
    fi
else
    echo "Sudoers fragment already exists: $SUDOERS_FILE"
fi

# ---------- 4️⃣ Desktop entry for GUI ----------
mkdir -p "$DESKTOP_DIR"
mkdir -p "$ICON_TARGET_DIR"
if [[ -f "$ICON_SOURCE" ]]; then
    cp "$ICON_SOURCE" "$ICON_TARGET"
    echo "Icon copied to $ICON_TARGET"
else
    echo "No icon found at $ICON_SOURCE, desktop entry will have no icon."
fi

cat > "$DESKTOP_FILE" <<EOL
[Desktop Entry]
Type=Application
Name=$APP_NAME
Exec=$GUI_TARGET %U
Icon=$ICON_TARGET
Terminal=false
Categories=Utility;Network;
StartupNotify=true
EOL
chmod 644 "$DESKTOP_FILE"
if command -v update-desktop-database >/dev/null 2>&1; then
    update-desktop-database "$DESKTOP_DIR" || true
fi
echo "Desktop entry created at $DESKTOP_FILE"

# ---------- 5️⃣ Detect init system ----------
INIT_SYSTEM=""
if command -v systemctl >/dev/null 2>&1; then
    INIT_SYSTEM="systemd"
elif [[ -d "/etc/init.d" ]]; then
    if command -v rc-status >/dev/null 2>&1; then
        INIT_SYSTEM="openrc"
    else
        INIT_SYSTEM="sysvinit"
    fi
elif [[ -d "/etc/runit" ]]; then
    INIT_SYSTEM="runit"
elif [[ -d "/etc/dinit.d" ]]; then
    INIT_SYSTEM="dinit"
else
    echo "No supported init system detected"
    exit 1
fi
echo "Detected init system: $INIT_SYSTEM"

# ---------- 6️⃣ Install service ----------
case "$INIT_SYSTEM" in
    systemd)
        SERVICE_FILE="/etc/systemd/system/victusservice.service"
        sudo tee "$SERVICE_FILE" > /dev/null <<EOL
[Unit]
Description=VictusService background service
After=network.target

[Service]
ExecStart=$SERVICE_TARGET
Restart=always
User=root
Environment=PATH=/usr/local/bin:/usr/bin:/bin

[Install]
WantedBy=multi-user.target
EOL
        sudo systemctl daemon-reload
        sudo systemctl enable victusservice.service
        sudo systemctl start victusservice.service
        ;;
    sysvinit)
        SERVICE_FILE="/etc/init.d/victusservice"
        sudo tee "$SERVICE_FILE" > /dev/null <<'EOL'
#!/bin/sh
### BEGIN INIT INFO
# Provides:          victusservice
# Required-Start:    $remote_fs $network
# Required-Stop:     $remote_fs $network
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: VictusService background service
### END INIT INFO
case "$1" in
    start)
        $SERVICE_TARGET &
        ;;
    stop)
        pkill -f "$SERVICE_TARGET"
        ;;
    restart)
        pkill -f "$SERVICE_TARGET"
        $SERVICE_TARGET &
        ;;
    *)
        echo "Usage: $0 {start|stop|restart}"
        exit 1
        ;;
esac
exit 0
EOL
        sudo chmod +x "$SERVICE_FILE"
        sudo update-rc.d victusservice defaults
        sudo service victusservice start
        ;;
    openrc)
        SERVICE_FILE="/etc/init.d/victusservice"
        sudo tee "$SERVICE_FILE" > /dev/null <<EOL
#!/sbin/openrc-run
name="victusservice"
command="$SERVICE_TARGET"
command_background=true
pidfile="/run/victusservice.pid"
EOL
        sudo chmod +x "$SERVICE_FILE"
        sudo rc-update add victusservice default
        sudo rc-service victusservice start
        ;;
    runit)
        SERVICE_DIR="/etc/sv/victusservice"
        sudo mkdir -p "$SERVICE_DIR"
        sudo tee "$SERVICE_DIR/run" > /dev/null <<EOL
#!/bin/sh
exec $SERVICE_TARGET
EOL
        sudo chmod +x "$SERVICE_DIR/run"
        sudo ln -s "$SERVICE_DIR" /etc/service/
        ;;
    dinit)
        SERVICE_FILE="/etc/dinit.d/victusservice"
        sudo tee "$SERVICE_FILE" > /dev/null <<EOL
#!/bin/sh
# VictusService dinit script
exec $SERVICE_TARGET
EOL
        sudo chmod +x "$SERVICE_FILE"
        sudo dinitctl reload
        sudo dinitctl start victusservice
        ;;
esac

echo "Installation complete. GUI is ready and service installed under $INIT_SYSTEM"
