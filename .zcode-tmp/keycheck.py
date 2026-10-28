import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

r = subprocess.run([ADB, '-s', 'emulator-5554', 'logcat', '-d', '-s', 'mGBA:*', '-t', '200'],
                   capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
keys = [ln.split('I mGBA    : ')[-1] for ln in lines if 'Held' in ln or 'FrameKeys' in ln or 'Latched' in ln]
print('A key events (last 12):')
for k in keys[-12:]:
    print('  ', k)
mgba = [ln.split('I mGBA    : ')[-1] for ln in lines if 'SIO' in ln]
print('A SIO events (last 6):')
for k in mgba[-6:]:
    print('  ', k)
