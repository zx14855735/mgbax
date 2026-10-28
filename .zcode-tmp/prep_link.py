import subprocess, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
from PIL import Image

for name in ('a_now3.png', 'b_step2.png'):
    img = Image.open(r'D:\mgba-android-version\.workbuddy' + '\\' + name)
    print(name, img.size)

# re-establish forwards toward A (lobby host)
for local, remote in (('16374', '6374'), ('16375', '6375'), ('16376', '6376')):
    subprocess.run([ADB, 'forward', f'tcp:{local}', f'tcp:{remote}'], capture_output=True, timeout=30)
r = subprocess.run([ADB, 'forward', '--list'], capture_output=True, timeout=30)
print('forwards now:', r.stdout.decode().strip())
