import json, sys
from ws import WS, fmt

KEYS = ['room_id', 'roomId', 'room', 'code', 'room_code', 'roomCode', 'id', 'rid',
        'name', 'nickname', 'player', 'player_name', 'playerName', 'user', 'username',
        'uid', 'user_id', 'userId', 'token', 'password', 'pwd', 'game', 'game_id',
        'rom', 'rom_name', 'version', 'type', 'count', 'max', 'players', 'open']

def call(payload, t=2.5, path='/'):
    try:
        w = WS(path=path, timeout=6)
    except Exception as e:
        return f'CONN ERR {e}'
    try:
        w.send(json.dumps(payload))
        r = w.recv(t)
        return fmt(*r) if r else 'no reply'
    except Exception as e:
        return f'ERR {type(e).__name__} {e}'
    finally:
        try: w.close()
        except Exception: pass

if __name__ == '__main__':
    action = sys.argv[1] if len(sys.argv) > 1 else 'join_room'
    # shotgun: all keys at once
    full = {'action': action}
    for k in KEYS:
        full[k] = '1234' if 'room' in k or k in ('code', 'id', 'rid', 'roomId') else 'tester'
    print('SHOTGUN =>', call(full))
