import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

r = subprocess.run([ADB, '-s', 'emulator-5556', 'logcat', '-d', '-s', 'GBoyLink:*', 'Link:*'],
                   capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
print('B GBoyLink/Link lines:', len(lines))
for ln in lines[-12:]:
    print('  ', ln[:130])
