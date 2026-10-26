import io, re, sys
path, pat = sys.argv[1], sys.argv[2]
maxn = int(sys.argv[3]) if len(sys.argv) > 3 else 200
rx = re.compile(pat, re.I)
with io.open(path, encoding='utf-8', errors='replace') as f:
    lines = f.read().splitlines()
hits = 0
for i, l in enumerate(lines):
    if rx.search(l):
        print(i + 1, l[:160])
        hits += 1
        if hits >= maxn:
            break
print('---', hits, 'hits in', path)
