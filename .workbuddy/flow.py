"""Interactive flow helpers for the two link-test AVDs."""
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.workbuddy')
import barmenu
import drv


def top_activity(serial):
    out = drv.sh(serial, 'dumpsys', 'activity', 'activities').stdout.decode('utf-8', 'replace')
    tail = out.split('topResumedActivity=')[-1]
    return tail.split()[0] if tail else ''


def in_app(serial):
    return 'io.mgba.android/.EmulatorActivity' in top_activity(serial)


def ensure_app(serial, wait=20):
    if in_app(serial):
        return True
    print(serial, 'bringing the emulator app back up')
    drv.launch(serial)
    for _ in range(wait):
        if in_app(serial):
            return True
        time.sleep(2)
    return in_app(serial)


def dialog_rows(serial):
    xml = drv.dump(serial)
    return xml, drv.nodes(xml)


def tap_row(serial, prefix, wait=2.0):
    """Tap the first dialog row whose text starts with prefix."""
    xml, ns = dialog_rows(serial)
    for n in ns:
        if n.get('text', '').startswith(prefix):
            x, y = drv.bounds(n)
            print(serial, 'row tap', repr(n.get('text', ''))[:30], x, y)
            drv.tap(serial, x, y, wait)
            return True
    print(serial, 'row not found:', prefix)
    return False


def load_slot(serial, slot=1):
    barmenu.tap_item(serial, '读档')
    time.sleep(0.5)
    return tap_row(serial, '槽位 %d' % slot)


def save_slot(serial, slot=1):
    barmenu.tap_item(serial, '存档')
    time.sleep(0.5)
    return tap_row(serial, '槽位 %d' % slot)


def tap_text(serial, needle, wait=1.5):
    xml, ns = dialog_rows(serial)
    for n in ns:
        if needle in n.get('text', ''):
            x, y = drv.bounds(n)
            print(serial, 'tap text', repr(n.get('text', ''))[:30], x, y)
            drv.tap(serial, x, y, wait)
            return True
    print(serial, 'text not found:', needle)
    return False


def texts(serial, needles=()):
    xml, ns = dialog_rows(serial)
    out = []
    for n in ns:
        t = n.get('text', '')
        rid = n.get('resource-id', '').split('/')[-1]
        if t and (not needles or any(s in t for s in needles)):
            out.append((rid, t, n.get('bounds')))
    return out


if __name__ == '__main__':
    cmd = sys.argv[1]
    s = drv.serial_of(sys.argv[2])
    if cmd == 'load':
        print(load_slot(s, int(sys.argv[3]) if len(sys.argv) > 3 else 1))
    elif cmd == 'app':
        print(ensure_app(s))
    elif cmd == 'texts':
        for rid, t, b in texts(s):
            print(f'{rid:20} {t[:50]!r:54} {b}')
