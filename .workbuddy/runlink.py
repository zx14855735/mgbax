"""重跑一次完整联机对战流程：装载 → 大厅建链 → 大竞技场 → 双方按住 A 确认。"""
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.workbuddy')
import lt
import opendlg


def both(code, w=0.0):
    for s in (lt.A, lt.B):
        lt.key(s, code, 0)
    time.sleep(w)


def shot(tag):
    lt.snap(lt.A, tag + '_a')
    lt.snap(lt.B, tag + '_b')


def main():
    # 0. 先把可能的系统弹窗收掉，回到桌面
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
    both(108, 2.0)
    both(108, 2.0)
    both(96, 3.5)
    time.sleep(3)
    shot('s1')

    # 2. 建链
    for attempt in range(3):
        print('A dialog', opendlg.open_dialog(lt.A))
        print('A host', lt.tap_text(lt.A, '局域网创建', 'Button', 3.0))
        print('B dialog', opendlg.open_dialog(lt.B))
        print('B join', lt.tap_text(lt.B, '局域网加入', 'Button', 5.0))
        ok = all('Link attached' in lt.sh(s, 'logcat', '-d', '-t', '400', '-s', 'mGBA')
                 .stdout.decode('utf-8', 'replace') for s in (lt.A, lt.B))
        if ok:
            break
        print('link not up, retry', attempt)
    lt.tap_text(lt.A, 'CANCEL', 'Button', 1.2)
    lt.tap_text(lt.B, 'CANCEL', 'Button', 1.2)

    # 3. 走到大竞技场
    both(96, 2.5)      # 与柜台对话
    both(96, 2.5)      # 进菜单
    both(20, 1.5)      # 交换中心 -> 大竞技场
    shot('s2')
    both(96, 3.0)      # 进入大竞技场
    shot('s3')
    both(96, 3.0)      # 单打对战 -> 保存提示
    both(96, 7.0)      # 保存
    both(96, 8.0)      # 覆盖
    time.sleep(4)
    shot('s4')

    # 4. 双方先点一次 A（进入确认），再同时按住 A
    both(96, 3.0)
    shot('s5')
    print('holding A on both')
    lt.sh(lt.A, 'input', 'motionevent', 'DOWN', '1010', '220')
    lt.sh(lt.B, 'input', 'motionevent', 'DOWN', '1980', '430')
    time.sleep(8)
    shot('s6')
    lt.sh(lt.A, 'input', 'motionevent', 'UP', '1010', '220')
    lt.sh(lt.B, 'input', 'motionevent', 'UP', '1980', '430')
    time.sleep(3)
    shot('s7')
    for s, tag in ((lt.A, 'A'), (lt.B, 'B')):
        out = lt.sh(s, 'logcat', '-d', '-s', 'mGBA', '-v', 'brief').stdout.decode('utf-8', 'replace')
        with open(r'D:\mgba-android-version\.workbuddy\log_' + tag + '.txt', 'w', encoding='utf-8') as f:
            f.write(out)
        print(tag, 'log lines', len(out.splitlines()))


if __name__ == '__main__':
    main()
