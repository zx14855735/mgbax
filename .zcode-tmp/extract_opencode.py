import sqlite3, json

con = sqlite3.connect(r'C:\Users\lenovo\.local\share\opencode\opencode.db')
cur = con.cursor()
rows = cur.execute(
    "SELECT seq, type, data FROM session_message WHERE session_id='ses_e82dafb7bffe4IyBOfN17PoEfe' ORDER BY seq"
).fetchall()

def text_of(data):
    d = json.loads(data)
    parts = []
    if d.get('type') == 'text':
        parts.append(d.get('text', ''))
    elif isinstance(d.get('content'), list):
        for c in d['content']:
            if c.get('type') == 'text':
                parts.append(c.get('text', ''))
            elif c.get('type') == 'tool':
                st = c.get('state', {})
                parts.append(f"[tool {c.get('tool')}] input={json.dumps(st.get('input',{}), ensure_ascii=False)[:300]}")
            elif c.get('type') == 'reasoning':
                pass
    else:
        t = d.get('text')
        if t:
            parts.append(t)
    return '\n'.join(parts)

targets = [15, 799, 1099, 1476]  # user messages
for seq, typ, data in rows:
    if seq in targets:
        print(f"===== USER seq={seq} =====")
        print(text_of(data)[:6000])
        print()

# last assistant text messages
asst = [(s, d) for s, t, d in rows if t == 'assistant']
for seq, data in asst[-4:]:
    print(f"===== ASSISTANT seq={seq} =====")
    print(text_of(data)[:8000])
    print()
