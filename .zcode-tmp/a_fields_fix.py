"""Dump-driven field fixing with IME-closed verification loops."""
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

def fix_field(find_pred, value, dels=20, tries=3):
    for _ in range(tries):
        nodes = dump_nodes()
        target = None
        for t, cls, cx, cy in nodes:
            if cls == 'EditText' and find_pred(t):
                target = (cx, cy)
                break
        if not target:
            print('  field not found')
            time.sleep(1)
            continue
        sh('shell', 'input', 'tap', str(target[0]), str(target[1]))
        time.sleep(0.7)   # IME opens, layout shifts — irrelevant now
        sh('shell', 'input', 'keyevent', '123')
        for _ in range(dels):
            sh('shell', 'input', 'keyevent', '67')
            time.sleep(0.06)
        time.sleep(0.2)
        sh('shell', 'input', 'text', value)
        time.sleep(0.4)
        sh('shell', 'input', 'keyevent', '4')   # BACK closes the IME only
        time.sleep(0.8)
        nodes = dump_nodes()
        for t, cls, cx, cy in nodes:
            if cls == 'EditText' and t == value:
                return True
        print('  retry; current texts:', [t for t, c, x, y in nodes if c == 'EditText'])
    return False

print('IP:', fix_field(lambda t: ('或本机' in t) or t.startswith(('10.', '11637', '16375', '6374')) and t != '6374', '10.0.2.2'))
print('PORT:', fix_field(lambda t: t == '6374' or t == '16375', '16375'))
nodes = dump_nodes()
for t, cls, cx, cy in nodes:
    if cls in ('EditText', 'Button') and t.strip():
        print(f'  {cls:9} {t[:30]!r:34} {cx},{cy}')
