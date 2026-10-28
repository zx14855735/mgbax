import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

deadline = time.time() + 240
seen = set()
while time.time() < deadline:
    r = subprocess.run([ADB, 'devices'], capture_output=True, timeout=30)
    out = r.stdout.decode()
    devs = [l.split()[0] for l in out.splitlines() if l.endswith('device')]
    for d in devs:
        if d not in seen:
            seen.add(d)
            print(f'{time.strftime("%H:%M:%S")} {d} online', flush=True)
    if 'emulator-5554' in seen and 'emulator-5556' in seen:
        ok = True
        for d in ('emulator-5554', 'emulator-5556'):
            rb = subprocess.run([ADB, '-s', d, 'shell', 'getprop', 'sys.boot_completed'],
                                capture_output=True, timeout=30)
            if rb.stdout.decode().strip() != '1':
                ok = False
        if ok:
            print(f'{time.strftime("%H:%M:%S")} both booted', flush=True)
            break
    time.sleep(5)
else:
    print('TIMEOUT waiting for emulators; seen =', seen)
