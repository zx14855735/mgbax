"""Open the emulator's menu bar and tap an item.

The bar auto-hides 4 s after it was last touched, which is less than a
screencap or uiautomator dump costs on these AVDs. The bar always opens
scrolled to its left edge, so the item positions are measured once from a
screencap of an open bar (bar_<serial>.png, see `measure`) and cached here.
Tapping an item is then two taps back to back, well inside the window.
"""
import subprocess
import time

import numpy as np
from PIL import Image

import drv

BAR_ORDER = ['打开', '暂停', '1倍', '复位', '槽位', '存档', '读档', 'BIOS',
             '画质', '联机', '键位', '金手指', '游戏库', '倒带', '皮肤',
             '每ROM', '备份', '翻译', '截图', 'GIF', '设置']

# The ☰ handle does not move, so a uiautomator dump would only cost seconds.
HANDLE = {drv.A: (481, 410), drv.B: (1019, 820)}

# Label centres of the open bar, in BAR_ORDER, measured on the two AVDs.
POSITIONS = {
    drv.A: [(41, 33), (119, 33), (198, 33), (275, 33), (356, 33), (439, 33),
            (517, 33), (596, 33), (673, 33), (751, 33), (829, 33), (913, 33),
            (1004, 33), (1087, 33), (1165, 33)],
    drv.B: [(212, 64), (355, 64), (499, 64), (641, 64), (790, 64), (944, 64),
            (1087, 64), (1231, 64), (1374, 64), (1517, 64), (1659, 64),
            (1814, 64), (1980, 64), (2134, 64), (2277, 64)],
}


def shot(serial, name):
    path = drv.OUT + '\\' + name + '.png'
    with open(path, 'wb') as f:
        subprocess.run([drv.ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                       stdout=f, timeout=120)
    return path


def _runs(mask_1d, gap=1):
    runs = []
    start = None
    for i, v in enumerate(mask_1d):
        if v and start is None:
            start = i
        elif not v and start is not None:
            runs.append((start, i - 1))
            start = None
    if start is not None:
        runs.append((start, len(mask_1d) - 1))
    merged = []
    for a, b in runs:
        if merged and a - merged[-1][1] <= gap:
            merged[-1] = (merged[-1][0], b)
        else:
            merged.append((a, b))
    return merged


def bar_band(img):
    """Rows of the dark bar, where both screen edges are dark."""
    w = img.shape[1]
    edges = (img[:, 3, :].max(axis=1) < 60) & (img[:, w - 3, :].max(axis=1) < 60)
    rows = np.nonzero(edges)[0]
    if len(rows) < 8:
        return None
    start = rows[0]
    end = start
    for r in rows:
        if r - end <= 2:
            end = r
        else:
            break
    return start, end


def items(path):
    """Label groups of the menu bar, left to right, as (x, y, x1, x2)."""
    img = np.array(Image.open(path).convert('RGB'))
    band = bar_band(img)
    if not band:
        return []
    y1, y2 = band
    light = img[y1:y2, :, :].min(axis=2) > 130
    best = []
    for r1, r2 in _runs(light.any(axis=1), gap=2):
        rows = light[r1:r2 + 1, :]
        groups = []
        for a, b in _runs(rows.any(axis=0), gap=12):
            if b - a >= 6:
                groups.append(((a + b) // 2, y1 + (r1 + r2) // 2, a, b))
        if len(groups) > len(best):
            best = groups
    return best


def measure(serial, name=None):
    """Tap the handle and grab the bar before it hides; returns the path."""
    x, y = HANDLE[serial]
    drv.tap(serial, x, y, 0.15)
    return shot(serial, name or ('bar_' + serial[-4:]))


def tap_index(serial, index):
    x, y = HANDLE[serial]
    ix, iy = POSITIONS[serial][index]
    drv.sh(serial, 'input', 'tap', x, y, timeout=30)
    time.sleep(0.3)
    drv.sh(serial, 'input', 'tap', ix, iy, timeout=30)
    time.sleep(0.8)
    return True


def tap_item(serial, name):
    return tap_index(serial, BAR_ORDER.index(name))


if __name__ == '__main__':
    import sys
    s = drv.serial_of(sys.argv[1])
    if sys.argv[2] == 'measure':
        p = measure(s)
        for i, (c, y, a, b) in enumerate(items(p)):
            label = BAR_ORDER[i] if i < len(BAR_ORDER) else '?'
            print(i, label, 'x', c, 'y', y, 'span', a, b)
    else:
        print(tap_item(s, sys.argv[2]))
