import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

def sh(serial, *args, timeout=60):
    r = subprocess.run([ADB, '-s', serial] + list(args), capture_output=True, timeout=timeout)
    return r.stdout.decode('utf-8', 'replace')

for s in ('emulator-5554', 'emulator-5556'):
    w = sh(s, 'shell', 'dumpsys', 'window')
    lines = [ln.strip()[:170] for ln in w.splitlines() if 'Focus' in ln or 'mFocused' in ln]
    print(s)
    for ln in lines[:6]:
        print('   ', ln)
