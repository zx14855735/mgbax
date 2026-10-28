import sys, re, importlib.util
spec=importlib.util.spec_from_file_location('dp','dexparse.py'); m=importlib.util.module_from_spec(spec); spec.loader.exec_module(m)
pat = re.compile(sys.argv[2], re.I)
for f in sys.argv[1:-1]:
    dx = m.Dex(f)
    for i,s in enumerate(dx.strings):
        if pat.search(s):
            print('%s STR[%d] = %r' % (f, i, s))
