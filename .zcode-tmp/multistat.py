import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

r = subprocess.run([ADB, '-s', 'emulator-5554', 'logcat', '-d', '-s', 'mGBA:*'], capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
multi = [ln.split('I mGBA    : ')[-1] for ln in lines if 'SIO multi me=' in ln]
print('A SIO multi lines:', len(multi))
for m in multi[-6:]:
    print('  ', m)
poll = [ln.split('I mGBA    : ')[-1] for ln in lines if 'SIO poll' in ln]
for m in poll[-3:]:
    print('  ', m)
