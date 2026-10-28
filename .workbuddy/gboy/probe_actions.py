"""Adaptive black-box probe: discover GBoy room-server JSON schema via error messages."""
import json, time, sys, itertools
from ws import WS, fmt

ACTIONS = [
    'ping', 'Ping',
    'login', 'auth', 'hello', 'init', 'connect',
    'list', 'roomList', 'room_list', 'getRoomList', 'get_room_list', 'rooms',
    'create', 'createRoom', 'create_room', 'newRoom', 'host',
    'join', 'joinRoom', 'join_room', 'enter', 'enterRoom',
    'match', 'matching', 'quickMatch', 'random',
    'leave', 'exit', 'close', 'closeRoom',
    'ready', 'start', 'startGame', 'gameStart',
    'link', 'data', 'input', 'frame', 'sync', 'send',
]

def one(action, extra=None):
    w = WS(path='/')
    payload = {'action': action}
    if extra:
        payload.update(extra)
    w.send(json.dumps(payload))
    r = w.recv(2.0)
    w.close()
    return fmt(*r) if r else 'no reply'

if __name__ == '__main__':
    for a in ACTIONS:
        try:
            print(f'{a:14s} => {one(a)}')
        except Exception as e:
            print(f'{a:14s} => ERR {type(e).__name__} {e}')
