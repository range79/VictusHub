#!/usr/bin/env bash
# VictusHub installer: move binary, setup passwordless sudo, create desktop entry with icon

set -e

APP_NAME="VictusHub"
BINARY="./victusHub"
TARGET="/usr/local/bin/victusHub"

# Desktop entry
DESKTOP_DIR="$HOME/.local/share/applications"
DESKTOP_FILE="$DESKTOP_DIR/victushub.desktop"

# Icon
ICON_SOURCE="./icon.png"                       # Aynı klasördeki icon
ICON_TARGET_DIR="$HOME/.local/share/icons/hicolor/128x128/apps"
ICON_TARGET="$ICON_TARGET_DIR/victushub.png"  # .desktop uyumlu isim

# Sudoers
SUDOERS_FILE="/etc/sudoers.d/victusHub-$(whoami)"

# ---------- 1️⃣ Move binary ----------
if [[ ! -f "$BINARY" ]]; then
    echo "Error: $BINARY not found in current directory"
    exit 1
fi

if [[ ! -f "$TARGET" ]]; then
    echo "Moving $BINARY -> $TARGET (requires sudo)..."
    sudo mv "$BINARY" "$TARGET"
    sudo chmod 755 "$TARGET"
    echo "Binary moved and executable at $TARGET"
else
    echo "Binary already exists at $TARGET, skipping move."
fi

# ---------- 2️⃣ Sudoers setup ----------
if [[ ! -f "$SUDOERS_FILE" ]]; then
    read -p "Add passwordless sudo for $TARGET? (y/N): " ans
    if [[ "$ans" == "y" || "$ans" == "Y" ]]; then
        echo "$(whoami) ALL=(root) NOPASSWD: $TARGET" | sudo tee "$SUDOERS_FILE" > /dev/null
        sudo chmod 440 "$SUDOERS_FILE"
        sudo visudo -c -f "$SUDOERS_FILE"
        echo "Sudoers fragment created at $SUDOERS_FILE"
    else
        echo "Skipping sudoers setup."
    fi
else
    echo "Sudoers fragment already exists: $SUDOERS_FILE"
fi

# ---------- 3️⃣ Desktop entry ----------
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
Exec=$TARGET %U
Icon=$ICON_TARGET
Terminal=false
Categories=Utility;Network;
StartupNotify=true
EOL

chmod 644 "$DESKTOP_FILE"
echo "Desktop entry created at $DESKTOP_FILE"

# Optional: refresh desktop cache
if command -v update-desktop-database >/dev/null 2>&1; then
    update-desktop-database "$DESKTOP_DIR" || true
fi

echo "Installation complete. You can now launch $APP_NAME from application menu or via terminal using:"
echo "sudo $TARGET   # if sudo needed"
echo "or simply $TARGET   # if passwordless sudo is set"
