import json, sys
from ws import WS, fmt

def call(payload, t=2.0):
    w = WS(path='/')
    w.send(json.dumps(payload) if not isinstance(payload, str) else payload)
    r = w.recv(t)
    w.close()
    return fmt(*r) if r else 'no reply'

ACTIONS = """create_room room_list get_rooms rooms_list list_rooms
join_room leave_room exit_room close_room kick_room
ready unready start_game game_start stop_game end_game
player_join player_leave player_ready player_list get_players
sync sync_data send_data recv_data link_data sio_data
input_data key_data frame_data tick pulse heartbeat
room_info get_room room_status set_room update_room
chat message send_message broadcast report
set_name rename name user_info player_info
match_game quick_match auto_match random_match
list_servers server_list get_server config get_config
upload download rom_info game_info""".split()

if __name__ == '__main__':
    for a in ACTIONS:
        try:
            print(f'{a:16s} => {call({"action": a})}')
        except Exception as e:
            print(f'{a:16s} => ERR {type(e).__name__} {e}')
