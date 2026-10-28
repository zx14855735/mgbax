"""打开某端的「联机」对话框（顶部工具栏会自动回滚，必须快滚后立即点）。"""
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.workbuddy')
import lt

# 每台机器：滚动起止点 + 联机按钮的 x/y
SWIPE = {
    lt.A: ('820', '30', '300', '30', '110', 30),
    lt.B: ('1750', '45', '650', '45', '340', 50),
}


def open_dialog(serial, tries=12):
    x1, y1, x2, y2, bx, by = SWIPE[serial]
    bx = int(bx)
    cands = (bx, bx - 40, bx + 40, bx - 80, bx + 80)
    for i in range(tries):
        for _i in range(3):
            lt.sh(serial, 'input', 'swipe', x1, y1, x2, y2, '120')
            time.sleep(0.05)
        lt.tap(serial, cands[i % len(cands)], by, 0.0)
        time.sleep(0.7)
        xml = lt.dump(serial)
        if any('局域网创建' in n.get('text', '') for n in lt.nodes(xml)):
            return True
    return False


if __name__ == '__main__':
    s = lt.A if sys.argv[1] == 'A' else lt.B
    print('opened' if open_dialog(s) else 'FAILED')
