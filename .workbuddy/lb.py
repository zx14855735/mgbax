"""联机大厅驱动（本仓库 io.mgba.android）：工具栏 → 联机对话框 → 填中继 → 建房/加入。

工具栏按钮都带文字，直接按 text 定位，不用猜坐标。
"""
import re
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.workbuddy')
import lt


def _items(serial):
    xml = lt.dump(serial)
    return [(n.get('text', ''), n) for n in lt.nodes(xml)]


def _tap(serial, node, wait=0.6):
    x, y = lt.center(node)
    lt.tap(serial, x, y, wait)
    return x, y


def open_link(serial, tries=6):
    for i in range(tries):
        items = _items(serial)
        menu = next((n for t, n in items if '菜单' in t), None)
        if menu is None:
            time.sleep(1)
            continue
        _tap(serial, menu, 0.4)
        items = _items(serial)
        btn = next((n for t, n in items if t.strip() == '联机'), None)
        if btn is None:
            time.sleep(1)
            continue
        _tap(serial, btn, 1.0)
        items = _items(serial)
        if any('局域网创建' in t for t, _ in items):
            return True
        time.sleep(1.2)
    return False


def _visible_texts(serial):
    return [t for t, _ in _items(serial)]


def scroll_view_bounds(serial):
    """对话框里那个可滚动的 ScrollView（内容区，不含底部按钮面板）。"""
    xml = lt.dump(serial)
    for m in re.finditer(r'<node ([^>]*ScrollView[^>]*)>', xml):
        d = dict(re.findall(r'([\w-]+)="([^"]*)"', m.group(1)))
        if d.get('scrollable') != 'true':
            continue
        b = re.search(r'\[(\d+),(\d+)\]\[(\d+),(\d+)\]', d.get('bounds', ''))
        if b:
            return tuple(int(v) for v in b.groups())
    return None


def scroll(serial, down=True, steps=1):
    """在对话框内容区里滚动（触点必须落在 ScrollView 内，否则会点到按钮上）。"""
    bb = scroll_view_bounds(serial)
    if bb is None:
        return False
    x1, y1, x2, y2 = bb
    cx = (x1 + x2) // 2
    top = y1 + 12
    bot = y2 - 12
    for _ in range(steps):
        if down:
            lt.sh(serial, 'input', 'swipe', cx, bot, cx, top, '450')
        else:
            lt.sh(serial, 'input', 'swipe', cx, top, cx, bot, '450')
        time.sleep(0.9)
    return True


def scroll_to(serial, needle, tries=8):
    """滚动到能看见 needle 为止（向下滚，滚到底再回滚一次从头找）。"""
    for i in range(tries):
        items = _items(serial)
        hit = next((n for t, n in items if needle in t), None)
        if hit is not None:
            return True
        scroll(serial, down=(i < tries - 3), steps=1)
    items = _items(serial)
    return any(needle in t for t, _ in items)


def edits(serial):
    """EditText 顺序：0 对方IP 1 端口 2 中继 3 房间号 4 GBoy IP 5 GBoy 端口"""
    return [n for n in lt.nodes(lt.dump(serial)) if n.get('class', '').endswith('EditText')]


def _find_edit(serial, pred):
    for t, n in _items(serial):
        if n.get('class', '').endswith('EditText') and pred(t):
            return n
    return None


def hide_kb(serial):
    """收起输入法。

    不能用 ESC/BACK：这个对话框是 Dialog，按键会把它整个 dismiss 掉，
    之后所有点击都落到游戏画面上（曾经因此误触「打开」弹出文件选择器、
    进程被重启，表现为游戏莫名其妙回到标题）。点一下对话框标题最安全。
    """
    for t, n in _items(serial):
        if t.strip() == '联机':
            _tap(serial, n, 0.4)
            return True
    b = scroll_view_bounds(serial)
    if b:
        x0, y0, x1, y1 = b
        lt.tap(serial, (x0 + x1) // 2, y0 + 8, 0.4)
        return True
    return False


def set_relay(serial, value):
    """中继地址框：填过之后 hint 就没了，只能按「像 ip:port 的内容」去找。"""
    def is_relay(t):
        t = t.strip()
        return bool(re.match(r'^\d+\.\d+\.\d+\.\d+(:\d+)?$', t)) or '中继地址' in t
    for _ in range(8):
        n = _find_edit(serial, is_relay)
        if n is None:
            scroll(serial, down=(len(_items(serial)) < 8), steps=1)
            # 先向下找，找不到再回头向上
            n = _find_edit(serial, is_relay)
        if n is not None:
            _tap(serial, n, 0.5)
            lt.sh(serial, 'input', 'keyevent', '123')
            for _ in range(48):
                lt.sh(serial, 'input', 'keyevent', '67')
            lt.sh(serial, 'input', 'text', value)
            time.sleep(0.5)
            hide_kb(serial)
            time.sleep(0.4)
            return True
        scroll(serial, down=True, steps=1)
    return False


def set_room(serial, value):
    def is_room(t):
        t = t.strip()
        return '房间号' in t or bool(re.match(r'^[A-Z0-9]{6}$', t))
    n = _find_edit(serial, is_room)
    if n is None:
        scroll(serial, down=True, steps=1)
        n = _find_edit(serial, is_room)
    if n is None:
        return False
    _tap(serial, n, 0.5)
    lt.sh(serial, 'input', 'keyevent', '123')
    for _ in range(20):
        lt.sh(serial, 'input', 'keyevent', '67')
    lt.sh(serial, 'input', 'text', value)
    time.sleep(0.5)
    lt.sh(serial, 'input', 'keyevent', '111')
    time.sleep(0.5)
    return True


def fill(serial, idx, value):
    es = edits(serial)
    if len(es) <= idx:
        print(serial, 'no edit', idx, 'have', len(es), flush=True)
        return False
    _tap(serial, es[idx], 0.4)
    lt.sh(serial, 'input', 'keyevent', '123')
    for _ in range(48):
        lt.sh(serial, 'input', 'keyevent', '67')
    lt.sh(serial, 'input', 'text', value)
    time.sleep(0.4)
    lt.sh(serial, 'input', 'keyevent', '111')
    time.sleep(0.4)
    return True


def fill_hint(serial, hint, value):
    """按输入框的 hint 定位并填写（滚动后可见的输入框数量会变，用 hint 更稳）。"""
    for _ in range(6):
        items = _items(serial)
        box = next((n for t, n in items
                    if hint in t and n.get('class', '').endswith('EditText')), None)
        if box is not None:
            _tap(serial, box, 0.5)
            lt.sh(serial, 'input', 'keyevent', '123')
            for _ in range(48):
                lt.sh(serial, 'input', 'keyevent', '67')
            lt.sh(serial, 'input', 'text', value)
            time.sleep(0.5)
            hide_kb(serial)
            time.sleep(0.4)
            return True
        scroll(serial, down=False, steps=1)
    print(serial, 'input not found:', hint, flush=True)
    return False


def tap_button(serial, text, wait=1.5):
    items = _items(serial)
    btn = next((n for t, n in items if text in t and n.get('class', '').endswith('Button')), None)
    if btn is None:
        print(serial, 'button missing', text, flush=True)
        return False
    _tap(serial, btn, wait)
    return True


def status_text(serial):
    items = _items(serial)
    return '\n'.join(t for t, _ in items
                     if re.search(r'房间|中继|连接|接通|本机|等待|1P|2P|端口|失败', t))


def room_code(serial):
    m = re.search(r'房间\s*([A-Z0-9]{6})', status_text(serial))
    return m.group(1) if m else None


if __name__ == '__main__':
    s = lt.A if sys.argv[1].upper() == 'A' else lt.B
    print('opened', open_link(s))
    print('status:', status_text(s).replace('\n', ' | '))
