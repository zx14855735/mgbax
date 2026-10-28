import subprocess, time, sys
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}
for whom in sys.argv[1:]:
    s = SER[whom]
    path = r'D:\mgba-android-version\.workbuddy' + '\\' + whom + '_step.png'
    with open(path, 'wb') as f:
        subprocess.run([ADB, '-s', s, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
    print('saved', path)
