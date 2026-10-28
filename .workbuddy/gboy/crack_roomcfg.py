"""Try to decrypt RoomConfig ciphertext with candidate keys harvested from the dex string pool."""
import os, sys, hashlib, itertools
sys.path.insert(0, r'D:/mgba-android-version/.workbuddy/pylibs')
from Crypto.Cipher import AES

CT = open('roomcfg.bin', 'rb').read()
print('ciphertext', len(CT), 'blocks', len(CT) // 16, 'mod16', len(CT) % 16)

def score(pt):
    if not pt:
        return -1
    ok = sum(1 for ch in pt if 32 <= ch < 127)
    ratio = ok / len(pt)
    if ratio < 0.92:
        return 0
    return int(ratio * 100) + (20 if pt[:1] in (b'{', b'[') else 0)

def try_key(key, iv=b'\x00' * 16, mode='ecb'):
    for k in {key, key[:16], key[:32], key[:24]}:
        if len(k) not in (16, 24, 32):
            continue
        # ECB: no IV involved, judge from the very first block
        try:
            c = AES.new(k, AES.MODE_ECB)
            pt = c.decrypt(CT[:96])
            sc = score(pt)
            if sc >= 90:
                print('HIT ecb', k, 'score', sc, pt[:48])
                return (k, 'ecb', pt)
        except Exception:
            pass
        # CBC with unknown IV: blocks 2+ are still self-consistent
        try:
            c = AES.new(k, AES.MODE_CBC, b'\x00' * 16)
            pt = c.decrypt(CT[:96])
            sc = score(pt[16:])
            if sc >= 90:
                print('HIT cbc', k, 'score', sc, pt[16:64])
                return (k, 'cbc', pt)
        except Exception:
            pass
    return None

if __name__ == '__main__':
    raw = [l.rstrip('\n') for l in open('dex_strings.txt', encoding='utf-8', errors='replace')]
    print('pool', len(raw))
    cands = []
    for s in raw:
        b = s.encode('utf-8', 'ignore')
        if len(b) in (16, 24, 32):
            cands.append(b)
    print('len-exact candidates', len(cands))
    seen = set()
    n = 0
    for k in cands:
        if k in seen:
            continue
        seen.add(k)
        n += 1
        r = try_key(k)
        if r:
            print('FOUND', r[0]); break
        if n % 3000 == 0:
            print('tried', n, flush=True)
    print('done', n)
