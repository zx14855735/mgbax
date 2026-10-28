"""Fill mGBAx(A) GBoy join fields precisely; --go also taps 大厅加入."""
import subprocess, time, io, sys, re
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'
GO = len(sys.argv) > 1 and sys.argv[1] == 'go'

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

def tap(x, y, wait=0.8):
    sh('shell', 'input', 'tap', str(x), str(y))
    time.sleep(wait)

def fill(cx, cy, value, dels):
    tap(cx, cy, 0.6)
    sh('shell', 'input', 'keyevent', '123')
    for _ in range(dels):
        sh('shell', 'input', 'keyevent', '67')
    time.sleep(0.2)
    sh('shell', 'input', 'text', value)
    time.sleep(0.4)
    tap(600, 73, 0.8)   # tap the dialog title: drop focus, hide IME, dialog stays

if not GO:
    tap(352, 25, 0.4)
    tap(751, 33, 1.0)
    for _ in range(2):
        sh('shell', 'input', 'swipe', '600', '400', '600', '120', '350')
        time.sleep(0.8)

nodes = dump_nodes()
done_ip = done_port = False
for t, cls, cx, cy in nodes:
    if cls != 'EditText':
        continue
    if '或本机' in t and '10.0.2.2' not in t:
        fill(cx, cy, '10.0.2.2', 8)
        done_ip = True
    elif t == '6374':
        fill(cx, cy, '16375', 6)
        done_port = True
nodes = dump_nodes()
print('ip:', done_ip, 'port:', done_port)
for t, cls, cx, cy in nodes:
    if cls in ('EditText', 'Button'):
        print(f'  {cls:9} {t[:30]!r:34} {cx},{cy}')
