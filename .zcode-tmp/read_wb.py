import json, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

path = sys.argv[1]
tail_n = int(sys.argv[2]) if len(sys.argv) > 2 else 0  # if >0, only last N lines

with open(path, encoding='utf-8', errors='replace') as f:
    lines = f.readlines()

print(f'total lines: {len(lines)}')
if tail_n:
    lines = lines[-tail_n:]

for i, ln in enumerate(lines):
    try:
        d = json.loads(ln)
    except Exception as e:
        print(f'[{i}] PARSE ERR {e}')
        continue
    t = d.get('type')
    msg = d.get('message', d)
    role = msg.get('role', '')
    content = msg.get('content', '')
    if isinstance(content, list):
        parts = []
        for c in content:
            ct = c.get('type')
            if ct == 'text':
                parts.append(c.get('text', ''))
            elif ct == 'tool_use':
                parts.append(f"[tool_use {c.get('name')}] {json.dumps(c.get('input',{}), ensure_ascii=False)[:200]}")
            elif ct == 'tool_result':
                cc = c.get('content')
                s = json.dumps(cc, ensure_ascii=False)[:150] if cc else ''
                parts.append(f"[tool_result] {s}")
            elif ct == 'thinking':
                parts.append(f"[thinking {len(c.get('thinking',''))} chars]")
        content = '\n'.join(parts)
    print(f'[{i}] type={t} role={role} ts={d.get("timestamp", msg.get("timestamp",""))}')
    print(content[:1500])
    print('---')
