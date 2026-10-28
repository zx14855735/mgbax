import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

r = subprocess.run([ADB, '-s', 'emulator-5556', 'logcat', '-d', '-s', 'mGBA:*', '-t', '60'],
                   capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
out = [ln.split('I mGBA    : ')[-1] for ln in lines if 'Held' in ln or 'FrameKeys' in ln or 'Latched' in ln]
for k in out[-14:]:
    print('  ', k)
