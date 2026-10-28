import json, sys
from ws import WS, fmt

def call(payload, t=2.0):
    try:
        w = WS(path='/', timeout=8)
    except Exception as e:
        return f'CONN ERR {e}'
    try:
        w.send(json.dumps(payload))
        r = w.recv(t)
        return (r[1].decode('utf-8', 'replace') if r else 'no reply')
    except Exception as e:
        return f'ERR {type(e).__name__} {e}'
    finally:
        try: w.close()
        except Exception: pass

def find_keys(action, keys, value='PokemonEmerald'):
    base = call({'action': action})
    print('BASE', base)
    hit = []
    for k in keys:
        rep = call({'action': action, k: value})
        if rep != base:
            print(f'  {k:20s} -> {rep[:200]}')
            hit.append(k)
    return hit

if __name__ == '__main__':
    action = sys.argv[1]
    keys = sys.argv[2:] or """game_name gameName name title rom rom_name romName
game game_title gameTitle gamename GameName romname app_name rom_title
room_name roomName nickname player_name""".split()
    print('HITS', find_keys(action, keys))
