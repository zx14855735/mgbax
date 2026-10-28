import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'

def sh(*args, timeout=60):
    subprocess.run([ADB, '-s', A] + list(args), capture_output=True, timeout=timeout)

# dismiss anything on top, go home
sh('shell', 'input', 'keyevent', '4')
time.sleep(1.5)
sh('shell', 'input', 'keyevent', '3')
time.sleep(2)
# launch quetzal in mGBAx
sh('shell', 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
   '-a', 'android.intent.action.VIEW',
   '-d', 'file:///sdcard/Android/data/io.mgba.android/files/quetzal.gba')
print('A launched, wait 20s')
time.sleep(20)
with open(r'D:\mgba-android-version\.workbuddy\a_reset.png', 'wb') as f:
    subprocess.run([ADB, '-s', A, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
from PIL import Image
print('shot size:', Image.open(r'D:\mgba-android-version\.workbuddy\a_reset.png').size)
