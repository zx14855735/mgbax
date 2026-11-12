#!/bin/bash
cd /d/mgba-android-version || exit 1
unset http_proxy https_proxy HTTP_PROXY HTTPS_PROXY all_proxy ALL_PROXY
SWIFTC='/c/Users/lenovo/AppData/Local/Programs/Swift/Toolchains/6.0.3+Asserts/usr/bin/swiftc'
for f in ios/mGBA/GBoyConsoleSet.swift ios/mGBA/EmulatorViewController.swift; do
  if "$SWIFTC" -parse "$f"; then
    echo "PARSE_OK: $f"
  else
    echo "PARSE_FAIL: $f"
  fi
done
