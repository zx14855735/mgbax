import os
base = os.path.expandvars(r'%USERPROFILE%\.android\avd')
total = 0
for name in sorted(os.listdir(base)):
    p = os.path.join(base, name)
    if os.path.isdir(p):
        n = sum(os.path.getsize(os.path.join(r, f)) for r, _, fs in os.walk(p) for f in fs)
        total += n
        print('%-18s %8.1f MB' % (name, n / 2**20))
print('total %.1f GB' % (total / 2**30))
for ini in ('mgba_test.ini', 'zx_link_test.ini'):
    p = os.path.join(base, ini)
    if os.path.exists(p):
        print('---', ini)
        print(open(p, encoding='utf-8', errors='replace').read())
