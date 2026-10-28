import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'


def adb(*args, serial=None):
    cmd = [ADB]
    if serial:
        cmd += ['-s', serial]
    cmd += list(args)
    return subprocess.run(cmd, capture_output=True, text=True, timeout=30).stdout.strip()


serials = sys.argv[1:]
deadline = time.time() + 180
pending = set(serials)
while pending and time.time() < deadline:
    for s in list(pending):
        out = subprocess.run([ADB, '-s', s, 'shell', 'getprop', 'sys.boot_completed'],
                             capture_output=True, text=True, timeout=30).stdout.strip()
        if out == '1':
            print(s, 'BOOTED')
            pending.discard(s)
    if pending:
        time.sleep(3)
for s in pending:
    print(s, 'TIMEOUT')
