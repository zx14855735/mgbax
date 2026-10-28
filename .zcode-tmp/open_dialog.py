"""Open the lobby dialog with fixed coordinates (the menu auto-hides too
fast for a uiautomator dump between the two taps)."""
import subprocess
import time

import dev


def open_link(serial):
    if serial == dev.A:
        menu, link = (481, 410), (752, 33)
    else:
        menu, link = (1019, 820), (1517, 60)
    dev.tap(serial, *menu, 0.5)
    dev.tap(serial, *link, 1.2)


def scroll(serial, times=4):
    for _ in range(times):
        dev.sh(serial, 'input', 'swipe', '600', '430', '600', '120', '250')
        time.sleep(0.3)


if __name__ == '__main__':
    import sys
    serial = sys.argv[1]
    open_link(serial)
    scroll(serial)
    dev.snap(serial, 'dialog_' + serial[-4:])
    dev.show(serial)
