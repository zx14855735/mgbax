"""Black-box probe of the GBoy room server protocol."""
import json, time, sys
from ws import WS, fmt

CANDIDATES = [
    'ping',
    '{"type":"ping"}',
    '{"cmd":"ping"}',
    '{"action":"ping"}',
    '{"type":"login","name":"tester"}',
    '{"type":"join","room":""}',
    '{"type":"list"}',
    '{"type":"getRoomList"}',
    '{"type":"create"}',
    '{"type":"createRoom"}',
    '{"cmd":"create","room":"1234"}',
    'hello',
]

def probe(path='/'):
    w = WS(path=path)
    print(f'--- path {path} connected')
    g = w.recv(1.5)
    print('  greeting:', fmt(*g) if g else 'none')
    for c in CANDIDATES:
        try:
            w.send(c)
            r = w.recv(2.0)
            print(f'  >> {c[:60]:60s} => {fmt(*r) if r else "no reply"}')
        except Exception as e:
            print(f'  >> {c[:60]:60s} => ERR {type(e).__name__} {e}')
            break
    w.close()

if __name__ == '__main__':
    for p in (sys.argv[1:] or ['/']):
        try:
            probe(p)
        except Exception as e:
            print('--- path', p, 'ERR', type(e).__name__, e)
