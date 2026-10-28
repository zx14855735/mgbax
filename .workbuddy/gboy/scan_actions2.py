"""Threaded action-name scanner: each worker keeps one WS connection."""
import json, sys, time, os, threading, queue
from ws import WS

UNKNOWN = '未知操作'
print_lock = threading.Lock()

def worker(idx, q, out, base_path='/'):
    w = None
    while True:
        try:
            a = q.get_nowait()
        except queue.Empty:
            return
        rep = None
        for attempt in range(2):
            try:
                if w is None:
                    w = WS(path=base_path, timeout=8)
                w.send(json.dumps({'action': a}))
                r = w.recv(1.2)
                rep = '' if r is None else r[1].decode('utf-8', 'replace')
                break
            except Exception:
                try: w.close()
                except Exception: pass
                w = None
                rep = None
        if rep is None:
            continue
        if rep and UNKNOWN not in rep:
            with print_lock:
                print(f'HIT {a:26s} {rep[:240]}', flush=True)
                out.write(f'{a}\t{rep}\n'); out.flush()

def main(src, threads=12):
    cands = [l.strip() for l in open(src, encoding='utf-8') if l.strip()]
    outpath = 'valid_actions.txt'
    done = set()
    if os.path.exists(outpath):
        done = {l.split('\t')[0] for l in open(outpath, encoding='utf-8') if '\t' in l}
    todo = [c for c in cands if c not in done]
    print(f'{len(todo)} candidates, {threads} threads', flush=True)
    q = queue.Queue()
    for c in todo:
        q.put(c)
    out = open(outpath, 'a', encoding='utf-8')
    t0 = time.time()
    ths = [threading.Thread(target=worker, args=(i, q, out), daemon=True) for i in range(threads)]
    for t in ths: t.start()
    for t in ths: t.join()
    print(f'done in {time.time()-t0:.0f}s', flush=True)

if __name__ == '__main__':
    main(sys.argv[1] if len(sys.argv) > 1 else 'cand_kw.txt',
         int(sys.argv[2]) if len(sys.argv) > 2 else 12)
