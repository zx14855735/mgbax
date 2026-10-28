import json, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
path = sys.argv[1]
with open(path, encoding='utf-8', errors='replace') as f:
    lines = f.readlines()
for i, ln in enumerate(lines):
    try:
        d = json.loads(ln)
    except Exception:
        print(f'[{i}] <unparseable>')
        continue
    s = json.dumps(d, ensure_ascii=False)
    print(f'[{i}] {s[:2500]}')
    print('---')
