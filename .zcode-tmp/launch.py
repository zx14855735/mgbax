import subprocess, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

for s in ('emulator-5554', 'emulator-5556'):
    subprocess.run([ADB, '-s', s, 'shell',
                    'am start -n io.mgba.android/.EmulatorActivity -a android.intent.action.VIEW '
                    '-d file:///sdcard/Android/data/io.mgba.android/files/quetzal.gba'], timeout=30)

# wait until both report the ROM loaded
deadline = time.time() + 90
pending = {'emulator-5554', 'emulator-5556'}
while pending and time.time() < deadline:
    for s in list(pending):
        out = subprocess.run([ADB, '-s', s, 'shell', 'logcat -d -s mGBA:* | tail -n 5'],
                             capture_output=True, timeout=30).stdout.decode('utf-8', errors='replace')
        if 'Loaded /sdcard' in out:
            print(s, 'ROM loaded')
            pending.discard(s)
    if pending:
        time.sleep(3)
for s in pending:
    print(s, 'TIMEOUT')
