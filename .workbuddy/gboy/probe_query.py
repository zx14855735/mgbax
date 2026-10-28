import json, sys
from ws import WS, fmt

def try_path(path):
    try:
        w = WS(path=path, timeout=5)
    except Exception as e:
        return f'CONN ERR {e}'
    try:
        w.send(json.dumps({'action': 'ready'}))
        r = w.recv(2.0)
        return fmt(*r) if r else 'no reply'
    except Exception as e:
        return f'ERR {e}'
    finally:
        try: w.close()
        except Exception: pass

QUERIES = ['token=t1', 'uid=1', 'user=1', 'user_id=1', 'name=tester', 'nickname=tester',
           'sid=1', 'session=1', 'sign=1', 'id=1', 'player=1', 'device=1',
           'token=t1&name=tester', 'name=tester&room=1234']

if __name__ == '__main__':
    base = sys.argv[1] if len(sys.argv) > 1 else '/'
    for q in QUERIES:
        print(f'{q:28s} => {try_path(base + "?" + q)}', flush=True)
