import subprocess, io, sys, re
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'

subprocess.run([ADB, '-s', A, 'shell', 'uiautomator', 'dump', '/sdcard/ui.xml'], capture_output=True, timeout=60)
xml = subprocess.run([ADB, '-s', A, 'shell', 'cat', '/sdcard/ui.xml'],
                     capture_output=True, timeout=60).stdout.decode('utf-8', 'replace')
for m in re.finditer(r'<node[^>]*>', xml):
    tag = m.group(0)
    t = re.search(r'text="([^"]*)"', tag).group(1)
    cls = re.search(r'class="([^"]*)"', tag).group(1).split('.')[-1]
    b = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', tag)
    clickable = 'clickable="true"' in tag
    if t.strip() or clickable:
        print(f'{t[:34]!r:38} {cls:12} click={str(clickable):5} {b.group(1) if b else ""}')
