"""A opens link dialog, taps 局域网创建 (top block, port 8765)."""
import subprocess, time, io, sys, re
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'

def sh(*args, timeout=60):
    subprocess.run([ADB, '-s', A] + list(args), timeout=timeout)

def dump_nodes():
    sh('shell', 'uiautomator', 'dump', '/sdcard/ui.xml')
    xml = subprocess.run([ADB, '-s', A, 'shell', 'cat', '/sdcard/ui.xml'],
                         capture_output=True, timeout=60).stdout.decode('utf-8', 'replace')
    nodes = []
    for m in re.finditer(r'<node[^>]*>', xml):
        tag = m.group(0)
        t = re.search(r'text="([^"]*)"', tag).group(1)
        cls = re.search(r'class="([^"]*)"', tag).group(1)
        b = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', tag)
        if b:
            x1, y1, x2, y2 = map(int, b.groups())
            nodes.append((t, cls.split('.')[-1], (x1 + x2) // 2, (y1 + y2) // 2))
    return nodes

sh('shell', 'input', 'tap', '352', '25'); time.sleep(0.4)
sh('shell', 'input', 'tap', '751', '33'); time.sleep(1.0)
# LAN block is at the TOP of the dialog (no scroll)
nodes = dump_nodes()
target = None
for t, cls, cx, cy in nodes:
    if t == '局域网创建' and cls == 'Button':
        target = (cx, cy)
print('局域网创建 at', target)
if target:
    sh('shell', 'input', 'tap', str(target[0]), str(target[1]))
    time.sleep(1.0)
    print('host tapped')
