import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'


def adb(serial, *args):
    subprocess.run([ADB, '-s', serial, 'shell'] + list(args), timeout=30)


serial = sys.argv[1]
# expand the menu bar, then hit 联机 before it auto-hides
adb(serial, 'input', 'tap', '352', '25')
time.sleep(0.4)
adb(serial, 'input', 'tap', '778', '32')
print('link dialog opened on', serial)
