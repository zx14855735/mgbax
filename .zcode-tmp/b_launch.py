import subprocess, time, sys

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
B = 'emulator-5556'

def sh(*args, timeout=60):
    r = subprocess.run([ADB, '-s', B] + list(args), capture_output=True, timeout=timeout)
    return r.stdout.decode('utf-8', 'replace')

# dismiss the "Open with" chooser
sh('input', 'keyevent', '4')
time.sleep(2)
# go home to be safe
sh('input', 'keyevent', '3')
time.sleep(2)
# launch quetzal directly in mGBAx
sh('shell', 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
   '-a', 'android.intent.action.VIEW',
   '-d', 'file:///sdcard/Android/data/io.mgba.android/files/quetzal.gba')
print('launched, waiting 18s for boot')
time.sleep(18)
with open(r'D:\mgba-android-version\.workbuddy\b_launch.png', 'wb') as f:
    subprocess.run([ADB, '-s', B, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
print('screenshot saved')
