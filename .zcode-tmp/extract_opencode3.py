import sqlite3, json

con = sqlite3.connect(r'C:\Users\lenovo\.local\share\opencode\opencode.db')
cur = con.cursor()
rows = cur.execute(
    "SELECT seq, type, data FROM session_message WHERE session_id='ses_e82dafb7bffe4IyBOfN17PoEfe' ORDER BY seq"
).fetchall()

# dump all text nodes from assistant messages (skip tool calls), to find task description / summaries
for seq, typ, data in rows:
    if typ != 'assistant':
        continue
    dd = json.loads(data)
    for c in dd.get('content', []):
        if c.get('type') == 'text' and c.get('text', '').strip():
            txt = c['text'].strip()
            print(f"----- ASSISTANT text seq={seq} ({len(txt)} chars) -----")
            print(txt[:2500])
            print()
