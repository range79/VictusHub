#!/usr/bin/env bash
# VictusHub restore/uninstall script
# Moves GUI and Service binaries back, cleans sudoers and desktop entry

set -e

APP_NAME="VictusHub"
RESTORE_DIR="$PWD"  # Scriptin çalıştığı dizin
GUI_TARGET="/usr/local/bin/VictusHub"
SERVICE_TARGET="/usr/local/bin/VictusService"
RESTORED_GUI="$RESTORE_DIR/VictusHub"
RESTORED_SERVICE="$RESTORE_DIR/VictusService"

# Desktop entry & icon
DESKTOP_DIR="$HOME/.local/share/applications"
DESKTOP_FILE="$DESKTOP_DIR/victushub.desktop"
ICON_TARGET_DIR="$HOME/.local/share/icons/hicolor/128x128/apps"
ICON_TARGET="$ICON_TARGET_DIR/victushub.png"

# Sudoers
SUDOERS_FILE="/etc/sudoers.d/victusService-$(whoami)"

echo "Starting restore/uninstall of $APP_NAME..."

# ---------- 1️⃣ Move binaries back ----------
if [[ -f "$GUI_TARGET" ]]; then
    echo "Moving $GUI_TARGET -> $RESTORED_GUI (requires sudo)..."
    sudo mv "$GUI_TARGET" "$RESTORED_GUI"
    sudo chmod 755 "$RESTORED_GUI"
    echo "GUI binary restored to $RESTORE_DIR"
else
    echo "GUI binary not found at $GUI_TARGET, skipping move."
fi

if [[ -f "$SERVICE_TARGET" ]]; then
    echo "Moving $SERVICE_TARGET -> $RESTORED_SERVICE (requires sudo)..."
    sudo mv "$SERVICE_TARGET" "$RESTORED_SERVICE"
    sudo chmod 755 "$RESTORED_SERVICE"
    echo "Service binary restored to $RESTORE_DIR"
else
    echo "Service binary not found at $SERVICE_TARGET, skipping move."
fi

# ---------- 2️⃣ Remove sudoers ----------
if [[ -f "$SUDOERS_FILE" ]]; then
    echo "Removing sudoers fragment at $SUDOERS_FILE (requires sudo)..."
    sudo rm -f "$SUDOERS_FILE"
    echo "Sudoers fragment removed."
else
    echo "Sudoers fragment not found, skipping."
fi

# ---------- 3️⃣ Remove desktop entry ----------
if [[ -f "$DESKTOP_FILE" ]]; then
    echo "Removing desktop entry at $DESKTOP_FILE..."
    rm -f "$DESKTOP_FILE"
    echo "Desktop entry removed."
else
    echo "Desktop entry not found, skipping."
fi

# ---------- 4️⃣ Remove icon ----------
if [[ -f "$ICON_TARGET" ]]; then
    echo "Removing icon at $ICON_TARGET..."
    rm -f "$ICON_TARGET"
    echo "Icon removed."
else
    echo "Icon file not found, skipping."
fi

# Optional: refresh desktop cache
if command -v update-desktop-database >/dev/null 2>&1; then
    update-desktop-database "$DESKTOP_DIR" || true
fi

echo "Restore/uninstall complete. Binaries are back in $RESTORE_DIR."
