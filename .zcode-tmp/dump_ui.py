import subprocess, io, sys, re
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

serial = SER[sys.argv[1]]
r = subprocess.run([ADB, '-s', serial, 'shell', 'uiautomator', 'dump', '/sdcard/ui.xml'],
                   capture_output=True, timeout=60)
xml = subprocess.run([ADB, '-s', serial, 'shell', 'cat', '/sdcard/ui.xml'],
                     capture_output=True, timeout=60).stdout.decode('utf-8', 'replace')
for m in re.finditer(r'<node[^>]*>', xml):
    tag = m.group(0)
    text = re.search(r'text="([^"]*)"', tag)
    bounds = re.search(r'bounds="([^"]*)"', tag)
    clickable = 'clickable="true"' in tag
    cls = re.search(r'class="([^"]*)"', tag)
    t = text.group(1) if text else ''
    if t.strip() or clickable:
        c = (cls.group(1).split('.')[-1] if cls else '')
        print(f'{t[:36]!r:40} {c:14} click={str(clickable):5} {bounds.group(1) if bounds else ""}')
