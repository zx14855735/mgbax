"""One-pass build: string-index -> referencing methods, and class inventory."""
import sys, os, re, struct, pickle
from dex import Dex, split_multidex

def build(path, outpath):
    data = open(path,'rb').read()
    parts = split_multidex(data)
    xref = {}   # str_idx -> set of (class, method)
    classes = {}
    for pi,(o, blob) in enumerate(parts):
        dx = Dex(data=blob)
        print('part %d @0x%x: %d strings %d classes' % (pi, o, len(dx.strings), len(dx.classes)), file=sys.stderr)
        for ci, cd in enumerate(dx.classes):
            cn = dx.types[cd['type_idx']]
            classes.setdefault(cn, []).append(('part%d' % pi, cd.get('source_file')))
            try: meths = dx.class_methods(ci)
            except Exception: continue
            for kind, midx, af, code_off in meths:
                if not code_off: continue
                try:
                    regs, ins, outs, raw, base = dx.code_info(code_off)
                except Exception: continue
                p = 0; n = len(raw)
                from dalvik import OPS
                while p < n:
                    op = raw[p]
                    ent = OPS.get(op)
                    ln = ent[2] if ent else 1
                    if op == 0x1a:
                        if p+4 <= n:
                            si = struct.unpack_from('<H', raw, p+2)[0]
                            xref.setdefault(si, set()).add((cn, midx, pi))
                    elif op == 0x1b:
                        if p+6 <= n:
                            si = struct.unpack_from('<I', raw, p+2)[0]
                            xref.setdefault(si, set()).add((cn, midx, pi))
                    p += ln*2
    pickle.dump({'xref': {k: sorted(v) for k,v in xref.items()},
                 'classes': classes,
                 'parts': [(o, len(b)) for o,b in parts]}, open(outpath,'wb'))
    print('saved', outpath, 'xref entries', len(xref), file=sys.stderr)

if __name__ == '__main__':
    build(sys.argv[1], sys.argv[2])
