"""分步驱动：重启两端、等待 ROM 真正进入标题画面，再截图确认。"""
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.workbuddy')
import lt


def restart():
    for s in (lt.A, lt.B):
        lt.raw('-s', s, 'shell', 'am', 'force-stop', 'io.mgba.android')
        lt.raw('-s', s, 'shell', 'logcat', '-c')
        lt.raw('-s', s, 'shell', 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
               '-a', 'android.intent.action.VIEW',
               '-d', 'file:///sdcard/Android/data/io.mgba.android/files/rom.gba')


def main():
    restart()
    time.sleep(40)
    lt.snap(lt.A, 'r1_a')
    lt.snap(lt.B, 'r1_b')


if __name__ == '__main__':
    main()
