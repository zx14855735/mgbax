import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
serial = 'emulator-5554'

subprocess.run([ADB, '-s', serial, 'logcat', '-c'], timeout=30)
time.sleep(0.5)
subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', '108'], timeout=30)
time.sleep(2.5)
r = subprocess.run([ADB, '-s', serial, 'logcat', '-d', '-s', 'mGBA:*'], capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
keys = [ln.split('I mGBA    : ')[-1] for ln in lines if 'Held' in ln or 'FrameKeys' in ln or 'Latched' in ln]
sio = [ln.split('I mGBA    : ')[-1] for ln in lines if 'SIO' in ln]
print('key lines:', len(keys))
for k in keys[-8:]:
    print('  ', k)
print('sio lines:', len(sio))
for k in sio[-4:]:
    print('  ', k)
