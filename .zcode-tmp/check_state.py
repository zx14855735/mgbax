import subprocess, sys, io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

for s in ('emulator-5554', 'emulator-5556'):
    r = subprocess.run([ADB, '-s', s, 'shell', 'dumpsys', 'activity', 'activities'],
                       capture_output=True, timeout=60)
    out = r.stdout.decode('utf-8', 'replace')
    top = out.split('topResumedActivity=')[-1].split()[0] if 'topResumedActivity=' in out else '?'
    r2 = subprocess.run([ADB, '-s', s, 'shell', 'ls', '/sdcard/Android/data/io.mgba.android/files/'],
                        capture_output=True, timeout=60)
    files = r2.stdout.decode('utf-8', 'replace').strip().replace('\r', '')
    print(s, 'top:', top)
    print(s, 'files dir:', files[:400])
    print()
