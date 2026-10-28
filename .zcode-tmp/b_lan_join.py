"""B opens link dialog, fills LAN fields (10.0.2.2 / 8765), taps 局域网加入."""
import subprocess, time, io, sys, re
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
B = 'emulator-5556'

def sh(*args, timeout=60):
    subprocess.run([ADB, '-s', B] + list(args), timeout=timeout)

def dump_nodes():
    sh('shell', 'uiautomator', 'dump', '/sdcard/ui.xml')
    xml = subprocess.run([ADB, '-s', B, 'shell', 'cat', '/sdcard/ui.xml'],
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

def tap(x, y, wait=0.7):
    sh('shell', 'input', 'tap', str(x), str(y))
    time.sleep(wait)

sh('shell', 'input', 'tap', '782', '47'); time.sleep(0.4)
sh('shell', 'input', 'tap', '1522', '64'); time.sleep(1.0)
nodes = dump_nodes()
# LAN block is at the top; the dialog opens at the top edge
ip = port = joinbtn = None
for t, cls, cx, cy in nodes:
    if cls == 'EditText' and 'IP' in t:
        ip = (cx, cy)
    if t == '局域网加入' and cls == 'Button':
        joinbtn = (cx, cy)
print('ip field:', ip, 'join btn:', joinbtn)
if ip:
    tap(ip[0], ip[1], 0.6)
    sh('shell', 'input', 'keyevent', '123')
    for _ in range(8):
        sh('shell', 'input', 'keyevent', '67')
        time.sleep(0.05)
    sh('shell', 'input', 'text', '10.0.2.2')
    time.sleep(0.3)
    sh('shell', 'input', 'keyevent', '4')   # close IME
    time.sleep(0.8)
# find the LAN port field (text 8765) and leave as-is; find 局域网加入
nodes = dump_nodes()
for t, cls, cx, cy in nodes:
    if cls == 'EditText':
        print('  field', repr(t[:30]), cx, cy)
    if t == '局域网加入' and cls == 'Button':
        joinbtn = (cx, cy)
print('join btn now:', joinbtn)
if joinbtn:
    tap(joinbtn[0], joinbtn[1], 1.0)
    print('join tapped')
