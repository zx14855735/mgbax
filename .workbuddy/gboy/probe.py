import socket, ssl, base64, zlib, gzip, bz2, lzma, os, json, sys

OUT = os.path.dirname(os.path.abspath(__file__))

def http_get(path, host='gboy.top', port=443, headers=None):
    ctx = ssl.create_default_context(); ctx.check_hostname = False; ctx.verify_mode = ssl.CERT_NONE
    s = socket.create_connection((host, port), 10)
    t = ctx.wrap_socket(s, server_hostname=host)
    h = f"GET {path} HTTP/1.1\r\nHost: {host}\r\nUser-Agent: okhttp/3.12.0\r\nAccept: */*\r\nConnection: close\r\n"
    if headers:
        for k, v in headers.items():
            h += f"{k}: {v}\r\n"
    t.sendall((h + "\r\n").encode())
    data = b''
    while True:
        try:
            b = t.recv(65536)
        except Exception:
            break
        if not b:
            break
        data += b
    return data

def split_http(data):
    head, _, body = data.partition(b'\r\n\r\n')
    hdrs = {}
    lines = head.decode('latin1').split('\r\n')
    for ln in lines[1:]:
        if ':' in ln:
            k, v = ln.split(':', 1)
            hdrs[k.strip().lower()] = v.strip()
    if hdrs.get('transfer-encoding', '').lower() == 'chunked':
        out = b''
        rest = body
        while rest:
            line, _, rest = rest.partition(b'\r\n')
            try:
                n = int(line.split(b';')[0], 16)
            except Exception:
                break
            if n == 0:
                break
            out += rest[:n]
            rest = rest[n + 2:]
        body = out
    return lines[0] if lines else '', hdrs, body

if __name__ == '__main__':
    path = sys.argv[1] if len(sys.argv) > 1 else '/RoomConfig.php'
    raw = http_get(path)
    status, hdrs, body = split_http(raw)
    print('STATUS', status, 'hdr', hdrs)
    print('BODY len', len(body))
    open(os.path.join(OUT, 'body.bin'), 'wb').write(body)
    print(repr(body[:120]))
    # try base64
    try:
        pad = body + b'=' * (-len(body) % 4)
        b64 = base64.b64decode(pad)
        print('b64 decoded len', len(b64), b64[:24].hex())
        open(os.path.join(OUT, 'body_b64.bin'), 'wb').write(b64)
        for name, fn in [('zlib', zlib.decompress), ('gzip', gzip.decompress), ('bz2', bz2.decompress), ('lzma', lzma.decompress)]:
            try:
                d = fn(b64)
                print(name, 'OK', len(d), d[:400])
            except Exception as e:
                print(name, 'fail', type(e).__name__)
    except Exception as e:
        print('b64 fail', e)
