import subprocess, io, sys, collections
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

for k, s in (('A', 'emulator-5554'), ('B', 'emulator-5556')):
    r = subprocess.run([ADB, '-s', s, 'logcat', '-d', '-s', 'mGBA:*'], capture_output=True, timeout=60)
    lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
    begins = []
    kicks = 0
    multi = []
    for ln in lines:
        msg = ln.split('I mGBA    : ')[-1] if 'I mGBA    : ' in ln else ln
        if msg.startswith('SIO begin'):
            begins.append(msg)
        elif msg.startswith('SIO kick'):
            kicks += 1
        elif msg.startswith('SIO multi me='):
            multi.append(msg)
    locals_ = collections.Counter(b.split('local=')[-1] for b in begins)
    print(f'==== {k}: kicks={kicks} begins={len(begins)} ====')
    print('  begin local values:', dict(locals_))
    for m in multi[-3:]:
        print('  ', m)
    print()
