import re, sys, os
def strings(data, minlen=3):
    for m in re.finditer(rb'[\x20-\x7e]{%d,}' % minlen, data):
        yield m.start(), m.group().decode('ascii')
p=sys.argv[1]
out=sys.argv[2]
data=open(p,'rb').read()
with open(out,'w',encoding='utf-8') as f:
    for off,s in strings(data):
        f.write('0x%08x  %s\n' % (off, s))
print('wrote', out, os.path.getsize(out))
