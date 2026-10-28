import subprocess, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
serial = 'emulator-5556'
deadline = time.time() + 100
out = ''
while time.time() < deadline:
    out = subprocess.run([ADB, '-s', serial, 'shell', 'logcat -d -s mGBA:* | tail -n 5'],
                         capture_output=True, timeout=30).stdout.decode('utf-8', errors='replace')
    if 'Loaded /sdcard' in out:
        print('B ROM loaded')
        break
    time.sleep(4)
else:
    print('TIMEOUT')
print(out[-400:])
