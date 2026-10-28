import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
serial = 'emulator-5554'

subprocess.run([ADB, '-s', serial, 'logcat', '-c'], timeout=30)
time.sleep(0.4)
subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', '103'], timeout=30)
time.sleep(2.2)
r = subprocess.run([ADB, '-s', serial, 'logcat', '-d', '-s', 'mGBA:*'], capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
keys = [ln.split('I mGBA    : ')[-1] for ln in lines if 'Held' in ln or 'FrameKeys' in ln or 'Latched' in ln]
print('after R keyevent 103:')
for k in keys[-8:]:
    print('  ', k)
