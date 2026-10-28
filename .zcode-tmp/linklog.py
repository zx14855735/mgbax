import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

whom = sys.argv[1] if len(sys.argv) > 1 else 'A'
tail = int(sys.argv[2]) if len(sys.argv) > 2 else 30
serial = SER[whom]
r = subprocess.run([ADB, '-s', serial, 'logcat', '-d', '-s', 'mGBA:*', 'Link:*', 'GBoyLink:*'],
                   capture_output=True, timeout=60)
lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
print(f'--- {whom} last {tail} lines ---')
for ln in lines[-tail:]:
    print(ln)
