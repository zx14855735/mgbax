import io, subprocess
for name in ('emu_a', 'emu_b'):
    d = io.open(rf'.zcode-tmp/{name}.log', encoding='utf-8', errors='replace').read()
    print(f'=== {name} tail:')
    print(d[-500:])
out = subprocess.run(['tasklist'], capture_output=True)
t = out.stdout.decode('gbk', errors='replace')
lines = [l for l in t.splitlines() if 'emulator' in l.lower() or 'qemu' in l.lower()]
print('PROCS:', lines if lines else 'NONE')
out2 = subprocess.run([r'D:\Android\Sdk\platform-tools\adb.exe', 'devices'], capture_output=True)
print('ADB:', out2.stdout.decode(errors='replace'))
