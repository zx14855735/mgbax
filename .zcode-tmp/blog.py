import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

r = subprocess.run([ADB, '-s', 'emulator-5556', 'logcat', '-d', '-s', 'mGBA:*'],
                   capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
out = []
for ln in lines:
    msg = ln.split('I mGBA    : ')[-1] if 'I mGBA    : ' in ln else ln
    if msg.startswith('SIO poll'):
        continue
    out.append(msg)
print(f'B non-poll lines: {len(out)}')
for m in out:
    print('  ', m[:130])
