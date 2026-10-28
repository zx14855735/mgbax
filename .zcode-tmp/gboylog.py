import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

r = subprocess.run([ADB, '-s', 'emulator-5554', 'logcat', '-d', '-s', 'GBoyLink:*', 'Link:*'],
                   capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
print('GBoyLink/Link lines:', len(lines))
for ln in lines[-15:]:
    print('  ', ln[:130])
