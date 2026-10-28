"""端到端联机对战：装包 → 载入存档 → 联机大厅建房/加入 → 游戏内进大竞技场。

两端走**不同 IP**：A 用 10.0.2.2（模拟器到宿主的网关地址），B 用宿主 LAN 地址。
"""
import re
import subprocess
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.workbuddy')
import kk
import lb
import lt

APK = r'D:\mgba-android-version\android\app\build\outputs\apk\debug\app-debug.apk'
ROM = '/sdcard/Android/data/io.mgba.android/files/rom.gba'
SAV = '/sdcard/Android/data/io.mgba.android/files/rom.sav'
PKG = 'io.mgba.android'

RELAY_A = '10.0.2.2:18766'
RELAY_B = '192.168.2.7:18766'


def install():
    for s in (lt.A, lt.B):
        p = lt.raw('-s', s, 'install', '-r', '-g', APK, timeout=600)
        print(s, 'install', (p.stdout or b'').decode('utf-8', 'replace').strip()[-30:], flush=True)


def push():
    for s in (lt.A, lt.B):
        lt.raw('-s', s, 'push', r'D:\gen8\rom.gba', ROM, timeout=300)
        lt.raw('-s', s, 'push', r'D:\gen8\rom.sav', SAV, timeout=300)
    print('rom+sav pushed', flush=True)


def launch(serial):
    lt.raw('-s', serial, 'shell', 'am', 'force-stop', PKG, timeout=60)
    lt.sh(serial, 'wm', 'dismiss-keyguard')
    p = lt.sh(serial, 'am', 'start', '-n', PKG + '/.EmulatorActivity',
              '-a', 'android.intent.action.VIEW', '-d', 'file://' + ROM)
    time.sleep(9)
    act = lt.sh(serial, 'dumpsys', 'activity', 'activities').stdout.decode('utf-8', 'replace')
    ok = any('topResumedActivity' in l and PKG in l for l in act.splitlines())
    print(serial, 'foreground', ok, (p.stdout or b'').decode('utf-8', 'replace').strip()[:80], flush=True)
    return ok


def into_game():
    """标题 → 继续游戏（存档在精灵中心二楼）。"""
    kk.both_press(kk.START, 0.3, 3.0)
    kk.both_press(kk.A_KEY, 0.3, 3.0)
    kk.both_press(kk.A_KEY, 0.3, 3.0)
    time.sleep(2)
    kk.snap_both('b0')


def find_room(serial):
    for _ in range(10):
        for t, _n in lb._items(serial):
            m = re.search(r'房间号?\s*([A-Z0-9]{6})', t)
            if m:
                return m.group(1)
        lb.scroll(serial, down=True, steps=1)
    return None


def link():
    print('A open', lb.open_link(lt.A), flush=True)
    print('A relay', lb.set_relay(lt.A, RELAY_A), flush=True)
    print('A create', lb.tap_button(lt.A, '远程创建', 4.0), flush=True)
    code = find_room(lt.A)
    print('room', code, flush=True)
    if not code:
        return None
    print('B open', lb.open_link(lt.B), flush=True)
    print('B relay', lb.set_relay(lt.B, RELAY_B), flush=True)
    print('B room', lb.set_room(lt.B, code), flush=True)
    print('B join', lb.tap_button(lt.B, '远程加入', 4.0), flush=True)
    time.sleep(4)
    return code


def dialog_bottom(serial):
    lb.scroll(serial, down=True, steps=8)
    return [t for t, _ in lb._items(serial) if '接通' in t or '房间' in t or '失败' in t]


def arena():
    """在精灵中心二楼：和柜台对话 → 大竞技场 → 保存 → 等对方确认。"""
    kk.both_press(kk.A_KEY, 0.3, 2.5)      # 欢迎词
    kk.snap_both('b1')
    kk.both_press(kk.A_KEY, 0.3, 2.5)      # 进菜单
    kk.both_press(kk.A_KEY, 0.3, 2.5)
    kk.snap_both('b2')
    kk.both_press(kk.DOWN, 0.3, 1.5)       # 选「大竞技场」
    kk.both_press(kk.A_KEY, 0.3, 3.0)
    kk.snap_both('b3')
    kk.both_press(kk.A_KEY, 0.3, 4.0)      # 覆盖存档确认
    time.sleep(1)
    kk.snap_both('b4')


if __name__ == '__main__':
    step = sys.argv[1] if len(sys.argv) > 1 else 'all'
    if step in ('all', 'setup'):
        install()
        push()
        for s in (lt.A, lt.B):
            launch(s)
        into_game()
    if step in ('all', 'link'):
        code = link()
        print('CODE', code, flush=True)
        for s in (lt.A, lt.B):
            print(s, dialog_bottom(s), flush=True)
    if step in ('all', 'battle'):
        for s in (lt.A, lt.B):
            lb.tap_button(s, 'CANCEL', 1.0)
        arena()
