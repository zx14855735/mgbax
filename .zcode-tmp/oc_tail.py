import sqlite3, json, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

con = sqlite3.connect(r'C:\Users\lenovo\.local\share\opencode\opencode.db')
cur = con.cursor()
rows = cur.execute(
    "SELECT seq, type, data FROM session_message WHERE session_id='ses_e82dafb7bffe4IyBOfN17PoEfe' ORDER BY seq"
).fetchall()

import datetime
def ts(ms):
    return datetime.datetime.fromtimestamp(ms / 1000).strftime('%m-%d %H:%M:%S')

# timeline of last 20 messages: reasoning (truncated) + tool calls
for seq, typ, data in rows[-20:]:
    d = json.loads(data)
    created = d.get('time', {}).get('created')
    if typ == 'user':
        print(f"[{ts(created)}] USER seq={seq}: {json.dumps(d, ensure_ascii=False)[:200]}")
        continue
    if typ != 'assistant':
        print(f"[{ts(created)}] {typ.upper()} seq={seq}: {data[:200]}")
        continue
    for c in d.get('content', []):
        t = c.get('type')
        if t == 'reasoning':
            txt = (c.get('text') or '').strip()
            if txt:
                print(f"[{ts(created)}] seq={seq} REASONING: {txt[:900]}")
        elif t == 'tool':
            name = c.get('name')
            st = c.get('state', {})
            inp = json.dumps(st.get('input', {}), ensure_ascii=False)[:250]
            print(f"[{ts(created)}] seq={seq} TOOL {name}: {inp}")
