"""Open the lobby on A (host 6374) and B (join 10.0.2.2:16374)."""
import re
import subprocess
import time

import dev

ADB = dev.ADB
A = dev.A
B = dev.B


def close_dialogs(serial):
    for _ in range(3):
        xml = dev.dump(serial)
        n = dev.find(xml, 'Wait')
        if n:
            x, y = dev.bounds(n)
            dev.tap(serial, x, y, 0.5)
            continue
        n = dev.find(xml, '联机')
        if n:
            dev.sh(serial, 'input', 'keyevent', '4')
            time.sleep(0.5)
            continue
        break


def open_link_dialog(serial):
    # The menu handle sits just right of the on-screen START key. Its location
    # differs per screen; use the accessibility node so both AVDs work.
    xml = dev.dump(serial)
    n = dev.find(xml, None, 'btn_menu')
    if not n:
        print(serial, 'no menu handle')
        return False
    x, y = dev.bounds(n)
    dev.tap(serial, x, y, 0.6)
    # 联机 is the 10th button in the bar; at A's 1200-wide screen it is at
    # x=752. On B the bar is 2340 wide, so compute from the bar buttons.
    xml = dev.dump(serial)
    n = dev.find(xml, None, 'btn_link')
    if not n:
        print(serial, 'no link button')
        return False
    x, y = dev.bounds(n)
    dev.tap(serial, x, y, 1.2)
    return True


def scroll_dialog(serial, times=4):
    for _ in range(times):
        dev.sh(serial, 'input', 'swipe', '600', '430', '600', '120', '250')
        time.sleep(0.35)


def set_field(serial, old_text, new_text):
    xml = dev.dump(serial)
    n = dev.find(xml, old_text)
    if not n:
        print(serial, 'field not found', old_text)
        return False
    x, y = dev.bounds(n)
    dev.tap(serial, x, y, 0.8)
    # The dialog grows a full-screen text editor when a field is focused.
    for _ in range(10):
        dev.sh(serial, 'input', 'keyevent', '123')  # MOVE_END
        dev.sh(serial, 'input', 'keyevent', '67')   # DEL
    dev.sh(serial, 'input', 'text', new_text)
    time.sleep(0.3)
    dev.sh(serial, 'input', 'keyevent', '66')       # ENTER
    time.sleep(0.8)
    return True


def main():
    for port in range(16374, 16378):
        subprocess.run([ADB, '-s', A, 'forward', f'tcp:{port}', f'tcp:{port - 10000}'],
                       capture_output=True)

    close_dialogs(A)
    close_dialogs(B)
    if not open_link_dialog(A):
        return
    scroll_dialog(A)
    dev.snap(A, 'lobby_a_dialog')
    if not dev.tap_text(A, '大厅创建', 1.0):
        return

    if not open_link_dialog(B):
        return
    scroll_dialog(B)
    dev.snap(B, 'lobby_b_dialog')
    if not set_field(B, '6374', '16374'):
        return
    dev.snap(B, 'lobby_b_after_port')
    # The text editor closes on ENTER; re-scroll in case the dialog reset.
    scroll_dialog(B, 3)
    dev.snap(B, 'lobby_b_ready')
    if not dev.tap_text(B, '大厅加入', 1.0):
        return

    time.sleep(6)
    dev.snap(A, 'lobby_a_after')
    dev.snap(B, 'lobby_b_after')
    print('--- A log ---')
    print('\n'.join(l for l in dev.logcat(A).splitlines() if 'mGBA' in l or 'GBoyLink' in l)[-4000:])
    print('--- B log ---')
    print('\n'.join(l for l in dev.logcat(B).splitlines() if 'mGBA' in l or 'GBoyLink' in l)[-4000:])


if __name__ == '__main__':
    main()
