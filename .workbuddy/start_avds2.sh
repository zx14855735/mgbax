#!/bin/bash
# Keep the two Android link-test emulators running under the sandbox.
export ANDROID_AVD_HOME='D:\avd-home\avd'
export TEMP='D:\avd-temp'
export TMP='D:\avd-temp'
ADB='D:/Android/Sdk/platform-tools/adb.exe'
EMU='D:/Android/Sdk/emulator/emulator.exe'
LOG='D:/mgba-android-version/.workbuddy'

mkdir -p /d/avd-temp
"$ADB" start-server

"$EMU" -avd mgba_test -no-snapshot -no-boot-anim -no-audio -no-window \
       -gpu swiftshader_indirect -memory 1536 -cores 2 -port 5554 > "$LOG/emu_a.log" 2>&1 &
A=$!

"$EMU" -avd zx_link_test -no-snapshot -no-boot-anim -no-audio -no-window \
       -gpu swiftshader_indirect -memory 1536 -cores 2 -port 5556 > "$LOG/emu_b.log" 2>&1 &
B=$!

echo "emu A pid $A, emu B pid $B"
wait $A
wait $B
