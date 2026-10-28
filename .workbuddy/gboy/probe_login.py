import json, sys
from ws import WS, fmt

NAMES = """user_login login_user client_login app_login sign_in signin
login_token token_login auth_token verify_token check_login
auth_user user_auth device_login guest_login anon_login
register sign_up signup create_user
user_info get_user_info my_info profile
enter_room room_enter room_join
ready_room set_ready player_ready room_ready
start start_room room_start host_start begin
input_data key_input sync_input pad_data
sio sio_sync link_sync gba_link
save_state load_state rom_hash rom_list upload_rom
get_room_list list_room room_list_get rooms_get
create create_new new create_room
leave leave_room quit_room
chat_send send_chat
speed_test latency pingpong set_name""".split()

def sweep(names, path='/'):
    w = None
    for a in names:
        for attempt in range(2):
            if w is None:
                try:
                    w = WS(path=path, timeout=5)
                except Exception as e:
                    print(f'{a:16s} => CONN ERR {e}', flush=True); break
            try:
                w.send(json.dumps({'action': a}))
                r = w.recv(1.2)
                out = fmt(*r) if r else 'no reply'
                if out != 'no reply' and '未知操作' not in out:
                    print(f'{a:16s} => {out}', flush=True)
                break
            except Exception as e:
                w = None
                if attempt == 1:
                    print(f'{a:16s} => ERR {e}', flush=True)

if __name__ == '__main__':
    sweep(sys.argv[1:] or NAMES)
    print('done')
