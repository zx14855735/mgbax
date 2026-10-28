import sqlite3, json, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

con = sqlite3.connect(r'C:\Users\lenovo\.local\share\opencode\opencode.db')
cur = con.cursor()
seq = int(sys.argv[1])
data = cur.execute(
    "SELECT data FROM session_message WHERE session_id='ses_e82dafb7bffe4IyBOfN17PoEfe' AND seq=?",
    (seq,)
).fetchone()[0]
dd = json.loads(data)
# print top-level keys and content item types
print('top keys:', list(dd.keys()))
for c in dd.get('content', []):
    print('item type:', c.get('type'), '| keys:', list(c.keys()))
# print full JSON but truncated
print(json.dumps(dd, ensure_ascii=False)[:5000])
