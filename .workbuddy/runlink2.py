"""重跑一次完整联机对战流程：装载 → 大厅建链 → 大竞技场 → 双方确认。

与 runlink.py 的差别：按键全部走新增的 io.mgba.android.action.KEYS 广播，
直接写 held 掩码。adb 的 `input keyevent` 只能发出一瞬间的 down/up，永远满足
不了游戏里 JOY_HELD(x) 的轮询；之前靠 `input motionevent DOWN` 去按住屏幕上的
A 键，坐标经常点不中，导致确认框关不掉、状态机卡在 Task_LinkupTryConfirmation。

ControlsView 位：A=1 B=2 SELECT=4 START=8 RIGHT=16 LEFT=32 UP=64 DOWN=128
"""
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.workbuddy')
import lt
import opendlg

A_KEY = 1
START_KEY = 8
DOWN_KEY = 128


def setkeys(serial, mask):
    lt.raw('-s', serial, 'shell', 'am', 'broadcast', '-a', 'io.mgba.android.action.KEYS',
           '--ei', 'mask', str(mask), '-p', 'io.mgba.android')


def press(serial, mask, hold=0.25, gap=0.6):
    """按一下：置掩码 -> 保持 -> 松开。产生一次完整的按下/抬起边沿。"""
    setkeys(serial, mask)
    time.sleep(hold)
    setkeys(serial, 0)
    time.sleep(gap)


def both(mask, hold=0.25, gap=0.6):
    for s in (lt.A, lt.B):
        setkeys(s, mask)
    time.sleep(hold)
    for s in (lt.A, lt.B):
        setkeys(s, 0)
    time.sleep(gap)


def hold_both(mask):
    for s in (lt.A, lt.B):
        setkeys(s, mask)


def release_both():
    for s in (lt.A, lt.B):
        setkeys(s, 0)


def shot(tag):
    lt.snap(lt.A, tag + '_a')
    lt.snap(lt.B, tag + '_b')


def dump_logs(tag):
    for s, t in ((lt.A, 'A'), (lt.B, 'B')):
        out = lt.sh(s, 'logcat', '-d', '-s', 'mGBA', '-v', 'brief').stdout.decode('utf-8', 'replace')
        with open(r'D:\mgba-android-version\.workbuddy\rl2_' + tag + '_' + t + '.log', 'w',
                  encoding='utf-8') as f:
            f.write(out)
        print(t, 'log lines', len(out.splitlines()), flush=True)


def main():
    # 0. 回到桌面
    for s in (lt.A, lt.B):
        for _i in range(4):
            lt.key(s, 4, 0.4)
        lt.key(s, 3, 0.8)

    # 1. 重启两端并继续游戏
    for s in (lt.A, lt.B):
        lt.raw('-s', s, 'shell', 'am', 'force-stop', 'io.mgba.android')
        lt.raw('-s', s, 'shell', 'logcat', '-c')
        lt.raw('-s', s, 'shell', 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
               '-a', 'android.intent.action.VIEW',
               '-d', 'file:///sdcard/Android/data/io.mgba.android/files/rom.gba')
    time.sleep(18)
    both(START_KEY, 0.3, 2.0)
    both(START_KEY, 0.3, 2.0)
    both(A_KEY, 0.3, 3.5)
    time.sleep(3)
    shot('r1')

    # 2. 建链
    for attempt in range(3):
        print('A dialog', opendlg.open_dialog(lt.A), flush=True)
        print('A host', lt.tap_text(lt.A, '局域网创建', 'Button', 3.0), flush=True)
        print('B dialog', opendlg.open_dialog(lt.B), flush=True)
        print('B join', lt.tap_text(lt.B, '局域网加入', 'Button', 5.0), flush=True)
        ok = all('Link attached' in lt.sh(s, 'logcat', '-d', '-t', '400', '-s', 'mGBA')
                 .stdout.decode('utf-8', 'replace') for s in (lt.A, lt.B))
        if ok:
            break
        print('link not up, retry', attempt, flush=True)
    lt.tap_text(lt.A, 'CANCEL', 'Button', 1.2)
    lt.tap_text(lt.B, 'CANCEL', 'Button', 1.2)

    # 3. 走到大竞技场
    both(A_KEY, 0.3, 2.5)      # 与柜台对话
    both(A_KEY, 0.3, 2.5)      # 进菜单
    both(DOWN_KEY, 0.3, 1.5)   # 交换中心 -> 大竞技场
    shot('r2')
    both(A_KEY, 0.3, 3.0)      # 进入大竞技场
    shot('r3')
    both(A_KEY, 0.3, 3.0)      # 单打对战 -> 保存提示
    both(A_KEY, 0.3, 7.0)      # 保存
    both(A_KEY, 0.3, 8.0)      # 覆盖
    time.sleep(4)
    shot('r4')

    # 4. 双方各按一次 A 进入确认（主机出「与玩家2开始连接。」）
    both(A_KEY, 0.3, 3.0)
    shot('r5')

    # 5. 关掉确认框（第一次 A 结束打字），再按住 A 让状态机推进
    print('press A again to close box', flush=True)
    both(A_KEY, 0.3, 1.5)
    shot('r6')
    print('holding A on both', flush=True)
    hold_both(A_KEY)
    for i in range(8):
        time.sleep(2)
        shot('h%d' % i)
    release_both()
    time.sleep(2)
    shot('r7')
    dump_logs('final')


if __name__ == '__main__':
    main()
