import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

for k, s in (('A', 'emulator-5554'), ('B', 'emulator-5556')):
    r = subprocess.run([ADB, '-s', s, 'logcat', '-d', '-s', 'mGBA:*'], capture_output=True, timeout=60)
    lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
    out = []
    for ln in lines:
        msg = ln.split('I mGBA    : ')[-1] if 'I mGBA    : ' in ln else ln
        if msg.startswith('SIO poll'):
            continue
        out.append(msg)
    print(f'==== {k}: {len(out)} non-poll lines ====')
    for m in out[-18:]:
        print('  ', m[:120])
    print()
