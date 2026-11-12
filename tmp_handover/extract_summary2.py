import json, sys, io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

path = r"C:\Users\lenovo\.workbuddy\projects\d-mgba-android-version\36ebaba4-5b7d-4446-b6ea-891093414cd5.jsonl"

msgs = []
with open(path, encoding='utf-8') as f:
    for line in f:
        try:
            o = json.loads(line)
        except Exception:
            continue
        if o.get('type') != 'message':
            continue
        role = o.get('role')
        content = o.get('content') or []
        texts = []
        for c in content:
            if not isinstance(c, dict):
                continue
            t = c.get('type')
            if t in ('input_text', 'text', 'output_text'):
                txt = c.get('text') or ''
                if role == 'user' and txt.lstrip().startswith('<system-reminder'):
                    continue
                texts.append(txt)
        if texts:
            msgs.append((role, '\n'.join(texts)))

for role, txt in msgs:
    if role == 'user' and '<cb_summary>' in txt:
        print(txt[12000:30000])
        break
