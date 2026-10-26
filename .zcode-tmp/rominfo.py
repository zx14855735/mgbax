import sys, hashlib, os
path = sys.argv[1]
size = os.path.getsize(path)
print('file size:', size)
with open(path, 'rb') as f:
    head = f.read(0x100)
print('rom header len code:', head[0x15] if size > 0x15 else '?')
print('title:', head[0xA0:0xAC])
print('code:', head[0xAC:0xB0])
print('maker:', head[0xB0:0xB2])
print('unit code:', head[0xB2:0xB4].hex())
print('version:', head[0xBC:0xBD].hex())
print('complement crc:', head[0xBD:0xBE].hex())
h = hashlib.md5()
with open(path, 'rb') as f:
    for chunk in iter(lambda: f.read(1 << 20), b''):
        h.update(chunk)
print('md5:', h.hexdigest())
