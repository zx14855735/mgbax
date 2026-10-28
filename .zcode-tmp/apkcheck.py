import subprocess, io, sys, os, time
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

for s in ('emulator-5554', 'emulator-5556'):
    r = subprocess.run([ADB, '-s', s, 'shell', 'dumpsys', 'package', 'io.mgba.android'],
                       capture_output=True, timeout=60)
    out = r.stdout.decode('utf-8', 'replace')
    for line in out.splitlines():
        if 'lastUpdateTime' in line or 'versionName' in line:
            print(s, line.strip())
    print()

apk = r'D:\mgba-android-version\android\app\build\outputs\apk\debug\app-debug.apk'
if os.path.exists(apk):
    mt = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(os.path.getmtime(apk)))
    print('local app-debug.apk mtime:', mt, 'size:', os.path.getsize(apk))
else:
    print('no local apk built')
