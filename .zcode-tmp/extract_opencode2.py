import sqlite3, json

con = sqlite3.connect(r'C:\Users\lenovo\.local\share\opencode\opencode.db')
cur = con.cursor()
rows = cur.execute(
    "SELECT seq, type, data FROM session_message WHERE session_id='ses_e82dafb7bffe4IyBOfN17PoEfe' ORDER BY seq"
).fetchall()

by_seq = {s: (t, d) for s, t, d in rows}

# full raw of first user message (look for attachments)
t, d = by_seq[15]
print("===== USER 15 RAW =====")
print(json.dumps(json.loads(d), ensure_ascii=False, indent=1)[:10000])
print()

# system message 14
t, d = by_seq[14]
print("===== SYSTEM 14 =====")
print(d[:3000])
print()

# first assistant messages: 16, 25
for seq in (16, 25):
    t, d = by_seq[seq]
    dd = json.loads(d)
    print(f"===== ASSISTANT {seq} =====")
    if isinstance(dd.get('content'), list):
        for c in dd['content']:
            ct = c.get('type')
            if ct == 'text':
                print('[text]', c.get('text', '')[:2000])
            elif ct == 'tool':
                st = c.get('state', {})
                print(f"[tool {c.get('tool')}] input={json.dumps(st.get('input',{}), ensure_ascii=False)[:500]}")
            elif ct == 'step-start':
                print('[step-start]')
    else:
        print(str(dd)[:2000])
    print()

# idle messages
for seq, t, d in rows:
    if t == 'idle':
        print(f"===== IDLE seq={seq} =====")
        print(d[:600])
        print()
