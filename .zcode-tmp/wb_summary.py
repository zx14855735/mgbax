import json, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

path = r'C:\Users\lenovo\.workbuddy\projects\d-mgba-android-version\fe520b24-beb5-4809-8061-c6c6664ff67a.jsonl'
with open(path, encoding='utf-8', errors='replace') as f:
    lines = f.readlines()

# print the full summary at line 2287 and last assistant messages
for i in (2287,):
    d = json.loads(lines[i])
    for c in d.get('content', []):
        if c.get('type') in ('input_text', 'text'):
            print(c.get('text', ''))

print('=' * 60)
print('LAST 10 assistant text outputs:')
count = 0
for i in range(len(lines) - 1, -1, -1):
    try:
        d = json.loads(lines[i])
    except Exception:
        continue
    if d.get('type') != 'message' or d.get('role') != 'assistant':
        continue
    for c in d.get('content', []):
        if isinstance(c, dict) and c.get('type') == 'output_text':
            t = c.get('text', '')
            if t.strip() and '429' not in t[:20]:
                print(f'--- [line {i}] ---')
                print(t[:2500])
                count += 1
    if count >= 6:
        break
