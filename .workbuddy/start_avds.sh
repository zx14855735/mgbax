#!/bin/bash
# 在网络/沙箱环境下保持两个 Android 测试模拟器常驻运行。
#
# 联机延迟关键参数：
#   -cores 4      客户机 4 个 vCPU。mGBA 的模拟线程会占满一个核，App 的
#                  Java 网络线程（联机中继的 pump）必须有自己的核，否则
#                  每次收发的唤醒延迟会到好几毫秒 —— GBA 联机要求一轮往返
#                  压在 1ms 以内。
#   AVD 的 hw.lcd.width/height 已改成 480x800：QEMU 的 SwiftShader 软件
#                  光栅化是宿主 CPU 的第一大消耗，1080x2400 时两个模拟器
#                  合计吃掉 1000%+ 的 CPU，会把 QEMU 里的网络栈调度
#                  延迟一起推高。
export ANDROID_AVD_HOME='D:\avd-home\avd'
export TEMP='D:\avd-temp'
export TMP='D:\avd-temp'
ADB='D:/Android/Sdk/platform-tools/adb.exe'
EMU='D:/Android/Sdk/emulator/emulator.exe'
LOG='D:/mgba-android-version/.workbuddy'

mkdir -p /d/avd-temp
"$ADB" start-server

"$EMU" -avd mgba_test -no-snapshot -no-boot-anim -no-audio -no-window \
       -gpu swiftshader_indirect -memory 1536 -cores 4 -port 5554 > "$LOG/emu_a.log" 2>&1 &
A=$!

"$EMU" -avd zx_link_test -no-snapshot -no-boot-anim -no-audio -no-window \
       -gpu swiftshader_indirect -memory 1536 -cores 4 -port 5556 > "$LOG/emu_b.log" 2>&1 &
B=$!

echo "emu A pid $A, emu B pid $B"
wait $A
wait $B
