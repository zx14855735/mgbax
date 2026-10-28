"""Pipelined action-name scanner against the GBoy room server.

Sends {"action":"<cand>"} for each candidate on a reused connection and records
every reply that is not the generic '未知操作' (unknown action) error.
"""
import json, sys, time, os
from ws import WS

UNKNOWN = '未知操作'
BATCH = 40

def scan(cands, out_path='valid_actions.txt', path='/'):
    done = set()
    if os.path.exists(out_path):
        done = {l.split('\t')[0] for l in open(out_path, encoding='utf-8') if '\t' in l}
    todo = [c for c in cands if c not in done]
    print(f'{len(todo)} to scan ({len(done)} cached)', flush=True)
    w = None
    out = open(out_path, 'a', encoding='utf-8')
    i = 0
    t0 = time.time()
    while i < len(todo):
        batch = todo[i:i + BATCH]
        try:
            if w is None:
                w = WS(path=path, timeout=10)
            for a in batch:
                w.send(json.dumps({'action': a}))
            replies = []
            for _ in batch:
                r = w.recv(3.0)
                if r is None:
                    break
                op, p = r
                if op == 8:
                    break
                replies.append(p.decode('utf-8', 'replace'))
        except Exception as e:
            print('reconnect after', type(e).__name__, flush=True)
            try: w.close()
            except Exception: pass
            w = None
            continue
        for a, rep in zip(batch, replies):
            if UNKNOWN not in rep:
                print(f'  HIT {a:24s} {rep[:220]}', flush=True)
                out.write(f'{a}\t{rep}\n'); out.flush()
        i += len(replies) if replies else len(batch)
        if i % 400 < BATCH:
            el = time.time() - t0
            print(f'progress {i}/{len(todo)} {i/max(el,1):.0f}/s', flush=True)
    out.close()
    print('scan done', flush=True)

if __name__ == '__main__':
    src = sys.argv[1] if len(sys.argv) > 1 else 'cand_kw.txt'
    cands = [l.strip() for l in open(src, encoding='utf-8') if l.strip()]
    scan(cands)
