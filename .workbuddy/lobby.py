"""建立/查询 mGBAx 联机大厅（GBoy 那一路：localhost 6374 + 串口隧道 +1）。

用法:
  python lobby.py A host         A 端创建大厅（端口 6374）
  python lobby.py B join         B 端加入 A（10.0.2.2:16374）
  python lobby.py A status       打印对话框里的状态文字
  python lobby.py A cancel       只关对话框，不断开
  python lobby.py A close        点「断开」
"""
import subprocess
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

A, B = dev.A, dev.B
MENU = {A: (481, 410), B: (1019, 820)}
LINK = {A: (752, 33), B: (1517, 60)}
SWIPE = {A: ('600', '420', '600', '80'), B: ('1200', '870', '1200', '170')}


def open_dialog(serial):
    dev.tap(serial, *MENU[serial], 0.6)
    dev.tap(serial, *LINK[serial], 1.5)
    time.sleep(1.0)


def scroll_down(serial, times=3):
    x1, y1, x2, y2 = SWIPE[serial]
    for _ in range(times):
        dev.sh(serial, 'input', 'swipe', x1, y1, x2, y2, '700')
        time.sleep(0.9)


def texts(serial):
    out = []
    for n in dev.nodes(dev.dump(serial)):
        t = (n.get('text') or '').strip()
        if t:
            out.append((t, n.get('bounds')))
    return out


def fill(serial, label, value):
    """点击某个 hint 输入框并输入内容。"""
    for t, b in texts(serial):
        if label in t:
            x, y = dev.bounds({'bounds': b})
            dev.tap(serial, x, y, 0.8)
            dev.sh(serial, 'input', 'keyevent', '123')      # 光标到行尾
            for _ in range(len(value) + 4):
                dev.sh(serial, 'input', 'keyevent', '67')   # DEL 清空
            dev.sh(serial, 'input', 'text', value)
            time.sleep(0.5)
            dev.sh(serial, 'input', 'keyevent', '111')      # ESC 收起键盘
            return True
    print(serial, 'NOT FOUND input', label)
    return False


def main():
    s = A if sys.argv[1] == 'A' else B
    cmd = sys.argv[2]
    open_dialog(s)
    if cmd in ('host', 'join'):
        scroll_down(s, 3)
        if cmd == 'join':
            have = [t for t, _ in texts(s)]
            if not any('10.0.2.2' in t for t in have):
                fill(s, '本机', '10.0.2.2')
            have = [t for t, _ in texts(s)]
            if not any(t.strip() == '16374' for t in have):
                fill(s, '6374', '16374')
        target = '大厅创建' if cmd == 'host' else '大厅加入'
        if not dev.tap_text(s, target, 3.0):
            return
    elif cmd == 'close':
        scroll_down(s, 3)
        dev.tap_text(s, '断开', 1.5)
    elif cmd == 'cancel':
        dev.tap_text(s, 'CANCEL', 1.0)
        return
    else:
        scroll_down(s, 3)
    print('==== %s ====' % s)
    for t, b in texts(s):
        print(' ', repr(t[:130]))


if __name__ == '__main__':
    main()
