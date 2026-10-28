import sqlite3, json, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

con = sqlite3.connect(r'C:\Users\lenovo\.local\share\opencode\opencode.db')
cur = con.cursor()
rows = cur.execute(
    "SELECT seq, type, data FROM session_message WHERE session_id='ses_e82dafb7bffe4IyBOfN17PoEfe' ORDER BY seq"
).fetchall()

out = []
type_count = {}
for seq, typ, data in rows:
    if typ != 'assistant':
        continue
    dd = json.loads(data)
    for c in dd.get('content', []):
        t = c.get('type')
        type_count[t] = type_count.get(t, 0) + 1
        if t == 'text' and c.get('text', '').strip():
            out.append((seq, c['text'].strip()))

print('content item type counts:', type_count)
print('text nodes:', len(out))
with open(r'D:\mgba-android-version\.zcode-tmp\oc_texts.txt', 'w', encoding='utf-8') as f:
    for seq, txt in out:
        f.write(f"----- ASSISTANT text seq={seq} ({len(txt)} chars) -----\n{txt}\n\n")
print('written to oc_texts.txt')
