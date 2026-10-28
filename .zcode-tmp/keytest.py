import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
B = 'emulator-5556'

subprocess.run([ADB, '-s', B, 'logcat', '-c'], timeout=30)
time.sleep(0.4)
subprocess.run([ADB, '-s', B, 'shell', 'input', 'keyevent', '21'], timeout=30)  # LEFT
time.sleep(1.5)
r = subprocess.run([ADB, '-s', B, 'logcat', '-d', '-s', 'mGBA:*'], capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
print('total lines after clear+LEFT:', len(lines))
for ln in lines[-8:]:
    msg = ln.split('I mGBA    : ')[-1] if 'I mGBA    : ' in ln else ln
    print('  ', msg[:110])
