"""Fast const-string xref: scan raw code bytes for 0x1a <u16 stridx> pattern."""
import sys, re, struct
sys.path.insert(0,'.')
from dex import Dex, split_multidex

def find_refs(path, needles):
    d=open(path,'rb').read()
    parts=split_multidex(d)
    for pi,(o,blob) in enumerate(parts):
        dx=Dex(data=blob)
        hits={i for i,s in enumerate(dx.strings) if s in needles}
        if not hits: continue
        # build class_data -> list of code_off
        codeoffs=[]
        for ci,cd in enumerate(dx.classes):
            cn=dx.types[cd['type_idx']]
            try: ms=dx.class_methods(ci)
            except Exception: continue
            for kind,midx,af,code_off in ms:
                if code_off: codeoffs.append((cn, midx, kind, code_off))
        print('=== part%d @0x%x : %d code items' % (pi,o,len(codeoffs)))
        for cn, midx, kind, code_off in codeoffs:
            try: regs,ins,outs,raw,base=dx.code_info(code_off)
            except Exception: continue
            found=set()
            for si in hits:
                pat = b'\x1a'+struct.pack('<H',si)
                if pat in raw: found.add(si)
                pat2 = b'\x1b'+struct.pack('<I',si)
                if pat2 in raw: found.add(si)
            if found:
                print('  CLASS %-45s midx=%-6d %-7s code=0x%-8x refs=%s' % (cn, midx, kind, code_off, sorted(dx.strings[x] for x in found)))
if __name__=='__main__':
    needles=set(sys.argv[2:])
    find_refs(sys.argv[1], needles)
