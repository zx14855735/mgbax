import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'


def adb(serial, *args):
    subprocess.run([ADB, '-s', serial, 'shell'] + list(args), timeout=30)


def tap(serial, x, y):
    adb(serial, 'input', 'tap', str(x), str(y))


def key(serial, keycode):
    adb(serial, 'input', 'keyevent', str(keycode))


if __name__ == '__main__':
    serial = sys.argv[1]
    op = sys.argv[2]
    if op == 'tap':
        tap(serial, int(sys.argv[3]), int(sys.argv[4]))
    elif op == 'key':
        key(serial, sys.argv[3])
    print('done', serial, op)
