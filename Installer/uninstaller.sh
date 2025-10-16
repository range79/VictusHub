#!/usr/bin/env bash
# VictusHub full uninstall/restore script: move binary back, remove sudoers, desktop entry, icon

set -e

APP_NAME="VictusHub"
TARGET="/usr/local/bin/victusHub"
RESTORE_DIR="$PWD"  # script hangi klasörde çalıştırılırsa oraya taşır
RESTORED_BINARY="$RESTORE_DIR/victusHub"

SUDOERS_FILE="/etc/sudoers.d/victusHub-$(whoami)"
DESKTOP_DIR="$HOME/.local/share/applications"
DESKTOP_FILE="$DESKTOP_DIR/victushub.desktop"
ICON_TARGET_DIR="$HOME/.local/share/icons/hicolor/128x128/apps"
ICON_TARGET="$ICON_TARGET_DIR/victushub.png"

echo "Starting full uninstall/restore of $APP_NAME..."

# ---------- 1️⃣ Move binary ----------
if [[ -f "$TARGET" ]]; then
    echo "Moving $TARGET -> $RESTORED_BINARY (requires sudo)..."
    sudo mv "$TARGET" "$RESTORED_BINARY"
    sudo chmod 755 "$RESTORED_BINARY"
    echo "Binary restored to $RESTORED_BINARY"
else
    echo "Binary not found in $TARGET, skipping move."
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

echo "Full uninstall/restore complete. $APP_NAME binary is back in $RESTORE_DIR."
