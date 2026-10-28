"""mGBAx(A) joins a GBoy-protocol server at 10.0.2.2:16375.
Opens the link dialog, scrolls to the GBoy block, fills IP/port, taps 大厅加入."""
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
            nodes.append((t, cls.split('.')[-1], (x1 + x2) // 2, (y1 + y2) // 2, (x1, y1, x2, y2)))
    return nodes

def tap(x, y, wait=0.8):
    sh('shell', 'input', 'tap', str(x), str(y))
    time.sleep(wait)

def field_set(nodes, hint, value):
    for t, cls, cx, cy, bb in nodes:
        if hint in t and cls == 'EditText':
            tap(cx, cy, 0.6)
            sh('shell', 'input', 'keyevent', '123')  # MOVE_END
            for _ in range(20):
                sh('shell', 'input', 'keyevent', '67')  # DEL
            time.sleep(0.3)
            sh('shell', 'input', 'text', value)
            time.sleep(0.5)
            return True
    return False

# open the dialog
tap(352, 25, 0.4)
tap(751, 33, 1.0)
# scroll to the GBoy block
for _ in range(2):
    sh('shell', 'input', 'swipe', '600', '400', '600', '120', '350')
    time.sleep(0.8)

nodes = dump_nodes()
ok_ip = field_set(nodes, 'IP', '10.0.2.2')
nodes = dump_nodes()
ok_port = field_set(nodes, '6374', '16375')
if not ok_port:
    ok_port = field_set(nodes, '端口', '16375')
print('ip set:', ok_ip, 'port set:', ok_port)

nodes = dump_nodes()
target = None
for t, cls, cx, cy, bb in nodes:
    if t == '大厅加入' and cls == 'Button':
        target = (cx, cy)
print('大厅加入 at', target)
if target:
    tap(target[0], target[1], 1.5)
    print('join tapped')
else:
    print('ERROR: join button not found; nodes:')
    for n in nodes:
        if n[1] in ('Button', 'EditText'):
            print('   ', n[1], repr(n[0][:30]), n[2], n[3])
