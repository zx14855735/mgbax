import sys, re, struct
sys.path.insert(0,'.')
from dex import Dex, split_multidex
from dalvik import OPS

def load_all(path):
    d=open(path,'rb').read()
    return [(o,Dex(data=b)) for o,b in split_multidex(d)]

def dump_class(dx, cn, out=sys.stdout):
    for ci,cd in enumerate(dx.classes):
        if dx.types[cd['type_idx']] != cn: continue
        out.write('===== CLASS %s (part) super=%s =====\n' % (cn, dx.types[cd['superclass_idx']] if cd['superclass_idx']!=0xffffffff else '?'))
        for kind, midx, af, code_off in dx.class_methods(ci):
            try: ms = dx.method_str(midx)
            except Exception: ms = 'method#%d' % midx
            out.write('  --- %s %s (kind=%s af=0x%x) ---\n' % (kind, ms, kind, af))
            if not code_off: 
                out.write('      (no code)\n'); continue
            for (off, name, ops, fmt, op) in dx.disasm(code_off):
                out.write('      %04x %-24s %-10s %s\n' % (off, name, ops.hex(), dx.describe(name, ops, fmt, op)))

if __name__=='__main__':
    path=sys.argv[1]; pat=sys.argv[2]
    rx=re.compile(pat)
    for o,dx in load_all(path):
        for ci,cd in enumerate(dx.classes):
            if rx.search(dx.types[cd['type_idx']]):
                dump_class(dx, dx.types[cd['type_idx']])
