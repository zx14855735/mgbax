import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
APK = r'D:\mgba-android-version\android\app\build\outputs\apk\debug\app-debug.apk'

for s in ('emulator-5554', 'emulator-5556'):
    r = subprocess.run([ADB, '-s', s, 'install', '-r', APK], capture_output=True, timeout=300)
    out = (r.stdout + r.stderr).decode('utf-8', 'replace').strip()
    print(s, '->', out[-200:])
