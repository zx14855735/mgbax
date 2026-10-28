import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

r = subprocess.run([ADB, 'forward', '--list'], capture_output=True, timeout=30)
print('forwards:', r.stdout.decode('utf-8', 'replace').strip())

with open(r'D:\mgba-android-version\.workbuddy\b_step2.png', 'wb') as f:
    subprocess.run([ADB, '-s', 'emulator-5556', 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
print('B screenshot retaken')
