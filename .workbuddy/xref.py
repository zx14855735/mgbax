"""Cross-reference: which methods reference strings matching a pattern."""
import sys, re, struct
from dex import Dex, split_multidex

def scan(dx, pat, show=False, out=sys.stdout):
    hits = {i for i, s in enumerate(dx.strings) if pat.search(s)}
    if not hits: return False
    out.write('### matching strings (%d):\n' % len(hits))
    for i in sorted(hits):
        out.write('    STR[%d] = %r\n' % (i, dx.strings[i]))
    for ci, cd in enumerate(dx.classes):
        try: meths = dx.class_methods(ci)
        except Exception: continue
        for kind, midx, af, code_off in meths:
            if not code_off: continue
            found = set()
            try:
                for (off, name, ops, fmt, op) in dx.disasm(code_off):
                    if name == 'const-string':
                        si = struct.unpack_from('<H', ops, 0)[0]
                        if si in hits: found.add(si)
                    elif name == 'const-string/jumbo':
                        si = struct.unpack_from('<I', ops, 0)[0]
                        if si in hits: found.add(si)
            except Exception:
                continue
            if found:
                try: ms = dx.method_str(midx)
                except Exception: ms = 'method#%d (bad idx)' % midx
                out.write('  -> %s   refs=%s\n' % (ms, [dx.strings[x] for x in sorted(found)]))
                if show:
                    dump(dx, code_off, out)
    return True

def dump(dx, code_off, out=sys.stdout):
    for (off, name, ops, fmt, op) in dx.disasm(code_off):
        out.write('      %04x %-24s %-10s %s\n' % (off, name, ops.hex(), dx.describe(name, ops, fmt, op)))

if __name__ == '__main__':
    args = sys.argv[1:]
    show = False
    if args and args[0] == '--show':
        show = True; args = args[1:]
    pat = re.compile(args[0], re.I)
    for f in args[1:]:
        data = open(f, 'rb').read()
        for o, blob in split_multidex(data):
            dx = Dex(data=blob)
            sys.stdout.write('\n===== %s  (dex @ 0x%x) =====\n' % (f, o))
            scan(dx, pat, show)
