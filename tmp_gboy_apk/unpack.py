import struct, hmac, hashlib, zlib, os, sys
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes

KEY16 = bytes.fromhex("e35af6205c30381d5a747f3c6e763025")
BUILD_KEY = "e8847a55e441d84"
PKG = "com.game.boy"

def rc4(key, data):
    S = list(range(256)); j = 0
    for i in range(256):
        j = (j + S[i] + key[i % len(key)]) & 0xff; S[i], S[j] = S[j], S[i]
    o = bytearray(); i = j = 0
    for b in data:
        i = (i + 1) & 0xff; j = (j + S[i]) & 0xff
        S[i], S[j] = S[j], S[i]; o.append(b ^ S[(S[i] + S[j]) & 0xff])
    return bytes(o)

def uleb(buf, off):
    r = 0; s = 0
    while True:
        b = buf[off]; off += 1
        r |= (b & 0x7f) << s; s += 7
        if not (b & 0x80): return r, off

def load_codeitems(path):
    d = open(path, "rb").read()
    ver, cnt = struct.unpack_from("<HH", d, 0)
    offs = [struct.unpack_from("<I", d, 4 + 4 * i)[0] for i in range(cnt)]
    out = []
    for o in offs:
        n = struct.unpack_from("<H", d, o)[0]; p = o + 2; items = []
        for _ in range(n):
            midx, sz = struct.unpack_from("<II", d, p); enc = d[p + 8:p + 8 + sz]
            items.append((midx, enc)); p += 8 + sz
        out.append(items)
    return out

def dex_method_codeoffs(buf):
    """map method_idx -> code_off (insns offset)"""
    (class_defs_size, class_defs_off) = struct.unpack_from("<II", buf, 0x60)
    m = {}
    for i in range(class_defs_size):
        base = class_defs_off + i * 32
        (class_idx, access, superclass, interfaces, source_file,
         annotations, class_data_off, static_values) = struct.unpack_from("<IIIIIIII", buf, base)
        if class_data_off == 0: continue
        p = class_data_off
        sf, p = uleb(buf, p); inf, p = uleb(buf, p)
        dm, p = uleb(buf, p); vm, p = uleb(buf, p)
        for _ in range(sf):
            _, p = uleb(buf, p); _, p = uleb(buf, p)
        for _ in range(inf):
            _, p = uleb(buf, p); _, p = uleb(buf, p)
        for _ in range(dm + vm):
            midx_delta, p = uleb(buf, p)
            _, p = uleb(buf, p)
            code_off, p = uleb(buf, p)
            if code_off:
                m[midx_delta] = code_off  # placeholder; filled below
        # 上面 delta 需要在循环内累积，重做
    # 正确的累积式解析
    m = {}
    for i in range(class_defs_size):
        base = class_defs_off + i * 32
        class_data_off = struct.unpack_from("<I", buf, base + 24)[0]
        if class_data_off == 0: continue
        p = class_data_off
        sf, p = uleb(buf, p); inf, p = uleb(buf, p)
        dm, p = uleb(buf, p); vm, p = uleb(buf, p)
        for _ in range(sf + inf):
            _, p = uleb(buf, p); _, p = uleb(buf, p)
        for group in (dm, vm):
            idx = 0
            for _ in range(group):
                delta, p = uleb(buf, p); idx += delta
                _, p = uleb(buf, p)
                code_off, p = uleb(buf, p)
                if code_off: m[idx] = code_off
    return m

def fix_dex(buf):
    b = bytearray(buf)
    sha = hashlib.sha1(bytes(b[32:])).digest()
    b[12:32] = sha
    chk = zlib.adler32(bytes(b[12:])) & 0xffffffff
    struct.pack_into("<I", b, 8, chk)
    return bytes(b)

def main():
    aes_key = hmac.new(KEY16, ("%s_%s" % (PKG, BUILD_KEY)).encode(), hashlib.sha256).digest()
    items = load_codeitems("assets/OoooooOooo")
    os.makedirs("decoded", exist_ok=True)
    for i, lst in enumerate(items):
        src = "inner/classes%s.dex" % ("" if i == 0 else str(i + 1))
        if not os.path.exists(src):
            print("skip", src); continue
        buf = bytearray(open(src, "rb").read())
        m = dex_method_codeoffs(bytes(buf))
        patched = miss = 0
        for midx, enc in lst:
            co = m.get(midx)
            if co is None: miss += 1; continue
            plain = rc4(aes_key + struct.pack("<I", midx), enc)
            buf[co + 16:co + 16 + len(plain)] = plain
            patched += 1
        out = "decoded/classes%s.dex" % ("" if i == 0 else str(i + 1))
        open(out, "wb").write(fix_dex(bytes(buf)))
        print("%-28s methods=%5d patched=%5d missed=%5d" % (src, len(lst), patched, miss))

main()
