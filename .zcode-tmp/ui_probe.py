import subprocess, io, sys, time
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

def sh(serial, *args, timeout=60):
    r = subprocess.run([ADB, '-s', serial] + list(args), capture_output=True, timeout=timeout)
    return r.stdout.decode('utf-8', 'replace')

for s in ('emulator-5554', 'emulator-5556'):
    print(s, 'wm size:', sh(s, 'shell', 'wm', 'size').strip(),
          '| wm density:', sh(s, 'shell', 'wm', 'density').strip())

# dump UI on A and list clickable nodes with bounds
xml = sh('emulator-5554', 'shell', 'uiautomator', 'dump', '/sdcard/ui.xml')
print('dump:', xml.strip()[:100])
pull = sh('emulator-5554', 'shell', 'cat', '/sdcard/ui.xml')
import re
# node lines
for m in re.finditer(r'<node[^>]*>', pull):
    tag = m.group(0)
    text = re.search(r'text="([^"]*)"', tag)
    rid = re.search(r'resource-id="([^"]*)"', tag)
    bounds = re.search(r'bounds="([^"]*)"', tag)
    clickable = 'clickable="true"' in tag
    t = text.group(1) if text else ''
    r_ = rid.group(1).split('/')[-1] if rid else ''
    if t or clickable:
        print(f'text={t[:24]!r:28} id={r_[:28]:30} click={clickable} bounds={bounds.group(1) if bounds else "?"}')
