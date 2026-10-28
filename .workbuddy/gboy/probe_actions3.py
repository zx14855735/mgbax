import json, sys, time
from ws import WS, fmt

def sweep(actions, path='/'):
    w = WS(path=path, timeout=6)
    for a in actions:
        try:
            w.send(json.dumps({'action': a}))
            r = w.recv(1.5)
            out = fmt(*r) if r else 'no reply'
        except Exception as e:
            out = f'ERR {type(e).__name__} {e}'
            try:
                w = WS(path=path, timeout=6)
            except Exception as e2:
                print('reconnect failed', e2); return
        print(f'{a:16s} => {out}', flush=True)

ACTIONS = """create_room room_list get_rooms rooms_list list_rooms
join_room leave_room exit_room close_room
ready unready start_game game_start end_game
player_join player_leave player_ready player_list
sync sync_data send_data link_data sio_data
input_data key_data frame_data heartbeat
room_info get_room room_status
chat send_message
set_name rename
match_game quick_match""".split()

if __name__ == '__main__':
    sweep(sys.argv[1:] or ACTIONS)
