import io, subprocess
d = io.open(r'.zcode-tmp/emu_b.log', encoding='utf-8', errors='replace').read()
print('EMU B LOG TAIL:')
print(d[-700:])
out = subprocess.run(['tasklist'], capture_output=True)
t = out.stdout.decode('gbk', errors='replace')
lines = [l for l in t.splitlines() if 'emulator' in l.lower() or 'qemu' in l.lower()]
print('PROCS:')
print('\n'.join(lines))
