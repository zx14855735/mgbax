"""按键助手：走 io.mgba.android.action.KEYS 广播，直接写 held 掩码（能真正按住）。

ControlsView 位：A=1 B=2 SELECT=4 START=8 RIGHT=16 LEFT=32 UP=64 DOWN=128
"""
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.workbuddy')
import lt

A_KEY, B_KEY, SELECT, START = 1, 2, 4, 8
RIGHT, LEFT, UP, DOWN = 16, 32, 64, 128

BOTH = (lt.A, lt.B)


def setkeys(serial, mask):
    lt.raw('-s', serial, 'shell', 'am', 'broadcast',
           '-a', 'io.mgba.android.action.KEYS',
           '--ei', 'mask', str(int(mask)), '-p', 'io.mgba.android', timeout=30)


def press(serial, mask, hold=0.22, gap=0.5):
    setkeys(serial, mask)
    time.sleep(hold)
    setkeys(serial, 0)
    time.sleep(gap)


def both_press(mask, hold=0.22, gap=0.5, serials=BOTH):
    for s in serials:
        setkeys(s, mask)
    time.sleep(hold)
    for s in serials:
        setkeys(s, 0)
    time.sleep(gap)


def hold(serials, mask):
    for s in serials:
        setkeys(s, mask)


def release(serials=BOTH):
    for s in serials:
        setkeys(s, 0)


def snap_both(tag):
    lt.snap(lt.A, tag + '_a')
    lt.snap(lt.B, tag + '_b')


if __name__ == '__main__':
    mask = int(sys.argv[1])
    hold_s = float(sys.argv[2]) if len(sys.argv) > 2 else 0.22
    gap = float(sys.argv[3]) if len(sys.argv) > 3 else 0.5
    both_press(mask, hold_s, gap)
    print('sent', mask)
