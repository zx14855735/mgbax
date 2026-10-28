"""Set the GBoy port field to 26375 (dump-driven, IME-closed verification)."""
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

# The dialog may have been closed by the earlier BACK / retry loop; reopen if needed.
nodes = dump_nodes()
if not any(t == '大厅加入' for t, c, x, y in nodes):
    print('dialog not open; reopening')
    sh('shell', 'input', 'tap', '352', '25'); time.sleep(0.4)
    sh('shell', 'input', 'tap', '751', '33'); time.sleep(1.0)
    for _ in range(2):
        sh('shell', 'input', 'swipe', '600', '400', '600', '120', '350')
        time.sleep(0.8)
    nodes = dump_nodes()

ok = False
for attempt in range(3):
    target = None
    for t, cls, cx, cy in nodes:
        if cls == 'EditText' and t in ('16375', '26375'):
            target = (cx, cy, t)
            break
    if target and target[2] == '26375':
        ok = True
        break
    if target:
        sh('shell', 'input', 'tap', str(target[0]), str(target[1]))
        time.sleep(0.7)
        sh('shell', 'input', 'keyevent', '123')
        for _ in range(8):
            sh('shell', 'input', 'keyevent', '67')
            time.sleep(0.06)
        sh('shell', 'input', 'text', '26375')
        time.sleep(0.4)
        sh('shell', 'input', 'keyevent', '4')
        time.sleep(0.8)
        nodes = dump_nodes()

nodes = dump_nodes()
for t, cls, cx, cy in nodes:
    if cls in ('EditText', 'Button') and t.strip():
        print(f'  {cls:9} {t[:30]!r:34} {cx},{cy}')
print('PORT OK' if ok else 'PORT FAILED')
