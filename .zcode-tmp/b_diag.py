import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
B = 'emulator-5556'

def sh(*args, timeout=60):
    r = subprocess.run([ADB, '-s', B] + list(args), capture_output=True, timeout=timeout)
    return r.stdout.decode('utf-8', 'replace')

top = sh('shell', 'dumpsys', 'activity', 'activities')
for line in top.splitlines():
    if 'topResumedActivity' in line or 'ResumedActivity' in line:
        print('TOP:', line.strip()[:200])

crash = sh('shell', 'logcat', '-d', '-b', 'crash', '-t', '100')
print('--- crash buffer tail ---')
print(crash[-2500:])

mgba = sh('shell', 'logcat', '-d', '-s', 'mGBA:*', '-t', '40')
print('--- mGBA tail ---')
print(mgba[-2500:])
