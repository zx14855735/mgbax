"""GBoy account flow: register/login via api.php and extract the token.

Runs slowly (1 request / 1.2s) to avoid tripping the edge WAF.
"""
import json, time, sys, os, random, string
sys.path.insert(0, r'D:/mgba-android-version/.workbuddy/pylibs')
from http_scan import Conn

STATE = 'account.json'


def post(payload, conn=None, retries=2):
    own = conn is None
    for _ in range(retries):
        try:
            c = Conn(timeout=15) if own else conn
            raw = c.post('/api/api.php', json.dumps(payload).encode()).decode('utf-8', 'replace')
            if own:
                c.close()
            body = raw.strip().splitlines()[-1] if raw.strip() else ''
            try:
                return json.loads(body)
            except Exception:
                return {'_raw': body[:300]}
        except Exception as e:
            if own:
                time.sleep(3)
                continue
            raise
    return {'_error': 'connect failed'}


REGISTER_ACTIONS = ['register', 'signup', 'sign_up', 'email_register', 'register_email',
                    'user_register', 'create_account', 'account_register', 'reg',
                    'register_by_email', 'email_signup', 'signup_email']
LOGIN_FIELDS = [
    {'email_or_username': 'probe@example.com', 'password': 'x'},
    {'email': 'probe@example.com', 'password': 'x'},
    {'username': 'probe', 'password': 'x'},
]

if __name__ == '__main__':
    mode = sys.argv[1] if len(sys.argv) > 1 else 'discover'
    if mode == 'discover':
        print('== login field shapes ==')
        for f in LOGIN_FIELDS:
            p = {'action': 'login', **f}
            print(' ', json.dumps(p, ensure_ascii=False)[:90], '=>', post(p))
            time.sleep(1.2)
        print('== register action names ==')
        for a in REGISTER_ACTIONS:
            p = {'action': a, 'email': 'probe@example.com', 'password': 'Abc12345', 'email_or_username': 'probe@example.com'}
            r = post(p)
            if '错误。' not in json.dumps(r, ensure_ascii=False):
                print(' ', a, '=>', r)
            time.sleep(1.2)
        print('done')
