import sys, json, time
sys.path.insert(0, '.')
from ws import WS

def attempt(payload, t=3.0):
    try:
        w = WS(path='/', timeout=6)
        w.recv(0.8)
        w.send(json.dumps(payload))
        r = w.recv(t)
        w.close()
        if not r: return 'no reply / closed'
        try: return r[1].decode('utf-8')
        except: return 'BIN len=%d' % len(r[1])
    except Exception as e:
        return 'ERR %s' % e

keys = ['game_name','game','rom_name','name','room_name','title','max_players',
        'players','token','rom_md5','md5','game_id','type','mode','rom_hash']
base = {'action':'create_game_room'}
for k in keys:
    v = 2 if k in ('max_players','players') else ('x' if k in ('token','game_id','uid') else 'POKEMON')
    res = attempt({**base, k:v})
    print(f'{k:12s} => {res[:140]}', flush=True)
    time.sleep(0.2)

combos = [
  {'action':'create_game_room','game_name':'POKEMON','rom_name':'POKEMON','max_players':2},
  {'action':'create_game_room','name':'POKEMON','game_name':'POKEMON'},
  {'action':'create_game_room','rom_name':'POKEMON'},
]
for c in combos:
    print('COMBO', c, '=>', attempt(c), flush=True)
    time.sleep(0.2)
print('DONE')
