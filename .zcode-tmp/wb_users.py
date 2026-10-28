import json, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

# Extract USER messages from the big workbuddy session to find the original task
path = r'C:\Users\lenovo\.workbuddy\projects\d-mgba-android-version\fe520b24-beb5-4809-8061-c6c6664ff67a.jsonl'
with open(path, encoding='utf-8', errors='replace') as f:
    lines = f.readlines()
print('total lines:', len(lines))

n_shown = 0
for i, ln in enumerate(lines):
    try:
        d = json.loads(ln)
    except Exception:
        continue
    if d.get('type') != 'message' or d.get('role') != 'user':
        continue
    content = d.get('content', [])
    texts = []
    for c in content if isinstance(content, list) else []:
        if isinstance(c, dict) and c.get('type') in ('input_text', 'text'):
            t = c.get('text', '')
            # skip system-reminder blobs
            if t.startswith('<system-reminder') or '<user_query>' in t:
                # extract user_query if present
                import re
                m = re.search(r'<user_query>(.*?)</user_query>', t, re.S)
                if m:
                    texts.append(m.group(1).strip())
                continue
            texts.append(t)
    if not texts:
        continue
    joined = ' | '.join(texts)
    print(f'[line {i}] {joined[:500]}')
    n_shown += 1
    if n_shown > 60:
        print('...(truncated)')
        break
