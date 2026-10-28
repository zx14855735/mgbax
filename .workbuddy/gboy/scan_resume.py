"""Threaded action-name scanner with resume support (records every scanned name)."""
import json, sys, time, os, threading, queue
from ws import WS

UNKNOWN = '未知操作'
lock = threading.Lock()


def worker(q, out, scanned, base_path='/'):
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
                r = w.recv(1.0)
                rep = '' if r is None else r[1].decode('utf-8', 'replace')
                break
            except Exception:
                try: w.close()
                except Exception: pass
                w = None
                rep = None
                time.sleep(0.2)
        with lock:
            scanned.write(a + '\n')
            if rep and UNKNOWN not in rep:
                print(f'HIT {a:26s} {rep[:240]}', flush=True)
                out.write(f'{a}\t{rep}\n'); out.flush()
            if rep is None:
                scanned.write('!RETRY\t' + a + '\n')
        time.sleep(0.12)


def main(src, threads=6):
    cands = [l.strip() for l in open(src, encoding='utf-8') if l.strip()]
    done = set()
    if os.path.exists('scanned.txt'):
        done = {l.strip() for l in open('scanned.txt', encoding='utf-8') if l.strip()}
    todo = [c for c in cands if c not in done]
    print(f'{len(todo)} todo / {len(cands)} total, {threads} threads', flush=True)
    q = queue.Queue()
    for c in todo:
        q.put(c)
    out = open('valid_actions.txt', 'a', encoding='utf-8')
    scanned = open('scanned.txt', 'a', encoding='utf-8')
    t0 = time.time()
    ths = [threading.Thread(target=worker, args=(q, out, scanned), daemon=True) for _ in range(threads)]
    for t in ths: t.start()
    for t in ths: t.join()
    print(f'done {len(todo)} in {time.time()-t0:.0f}s', flush=True)


if __name__ == '__main__':
    main(sys.argv[1] if len(sys.argv) > 1 else 'cand_all.txt',
         int(sys.argv[2]) if len(sys.argv) > 2 else 6)
