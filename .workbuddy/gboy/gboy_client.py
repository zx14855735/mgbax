"""GBoy room-server client (protocol reverse-engineered from com.game.boy).

Wire format : WebSocket text frames carrying JSON {"action": "...", ...}
Endpoint    : wss://gboy.top:23459  (Workerman 4.2.1, any path upgrades)
Auth        : every room action requires a `token` obtained from
              https://gboy.top/api/api.php (POST JSON {"action": "login", ...})

Known actions and their replies (observed):
  ping                 -> {"action":"pong","time":<unix>}
  create_game_room     -> needs token + game_name (+ optional room settings)
  join_room            -> needs token + room_id
  leave_room           -> {"type":"leave_room",...,"error":"您不在任何游戏房间中"}
  ready                -> needs token + room id/seat
  query_room           -> needs token
  accept_invite        -> needs token
  invite_player        -> needs token + target
  update_room_settings -> needs token

Server errors: {"type":"error","success":false,"error":"..."} for unknown/invalid
messages, {"type":"<action>","success":false,"error":"..."} for rejected actions.
"""
import json
import time
from ws import WS


class GBoyClient:
    def __init__(self, token=None, host='gboy.top', port=23459, path='/', timeout=10):
        self.token = token
        self.host, self.port = host, port
        self.ws = WS(host=host, port=port, path=path, timeout=timeout)
        self.token = token
        self.log = []

    # ---------- low level ----------
    def send_action(self, action, **fields):
        msg = {'action': action}
        if self.token and 'token' not in fields:
            msg['token'] = self.token
        msg.update(fields)
        self.ws.send(json.dumps(msg, ensure_ascii=False))
        self.log.append(('>', msg))
        return msg

    def recv_json(self, timeout=3.0):
        """Return the next JSON frame, or None on timeout."""
        while True:
            frame = self.ws.recv(timeout)
            if frame is None:
                return None
            op, payload = frame
            if op == 9:            # ping -> pong
                self.ws.send(payload, opcode=10)
                continue
            if op == 8:            # close
                raise ConnectionError('server closed: %r' % payload[:64])
            try:
                msg = json.loads(payload.decode('utf-8'))
            except Exception:
                msg = {'_binary': payload.hex()[:400], '_len': len(payload)}
            self.log.append(('<', msg))
            return msg

    def call(self, action, timeout=5.0, **fields):
        self.send_action(action, **fields)
        return self.recv_json(timeout)

    # ---------- protocol ----------
    def ping(self):
        return self.call('ping')

    def create_room(self, game_name, **opts):
        return self.call('create_game_room', game_name=game_name, **opts)

    def join_room(self, room_id, **opts):
        return self.call('join_room', room_id=room_id, **opts)

    def ready(self, **opts):
        return self.call('ready', **opts)

    def query_room(self, room_id=None):
        fields = {} if room_id is None else {'room_id': room_id}
        return self.call('query_room', **fields)

    def accept_invite(self, **opts):
        return self.call('accept_invite', **opts)

    def invite(self, **opts):
        return self.call('invite_player', **opts)

    def leave(self):
        return self.call('leave_room')

    def close(self):
        self.ws.close()


if __name__ == '__main__':
    import sys
    token = sys.argv[1] if len(sys.argv) > 1 else None
    c = GBoyClient(token)
    print('connected, handshake:', c.ws.handshake.splitlines()[0])
    print('ping ->', c.ping())
    print('create ->', c.create_room('POKEMON EMER'))
    c.close()
