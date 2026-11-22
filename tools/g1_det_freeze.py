#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""G1 E2E 冻结产物 + md5 自证工具（务实版：起止双次校验，非逐帧自证）。

目的（P10/P11）：gen8 ROM/exe 是移动靶（并发会话持续重编 + version.c -dirty 戳），
历史双进程 E2E 证据全部失效。本工具把四件产物复制到私有目录，静置后双次 md5 确认，
生成单一真源 manifest，并在 run 前后校验 md5 未变——使 A/B 至少能自证"同源"。

诚实边界：
  - 只检测不阻止移动靶；真机物理隔离才根治。
  - 本工具是"起止双次校验"，不是"逐帧自证"（逐帧需 C harness 内 gate，代价 80GB I/O）。
  - 证据强度 = SAMPLING；不得据此声称逐帧同源。
  - 不写游戏内存/party/信任位/握手字；门 FAIL/0/9/CROSSED 从未产出不动。

用法：
  python tools/g1_det_freeze.py freeze --tag T --rom <abs> --map <abs> --exe <abs> [--sav <abs>] [--wait 45]
  python tools/g1_det_freeze.py check --dir <冻结目录>
"""
import argparse, hashlib, json, os, shutil, subprocess, sys, time
from datetime import datetime

def now():
    return datetime.now().astimezone().isoformat()

def md5(path):
    h = hashlib.md5()
    with open(path, "rb") as f:
        for chunk in iter(lambda: f.read(1 << 20), b""):
            h.update(chunk)
    return h.hexdigest()

def stat_info(path):
    st = os.stat(path)
    return {"size": st.st_size, "mtime": datetime.fromtimestamp(st.st_mtime).astimezone().isoformat()}

def git_head(repo):
    try:
        return subprocess.run(["git", "-C", repo, "rev-parse", "HEAD"],
                              capture_output=True, text=True).stdout.strip()
    except Exception:
        return "N/A"

def cpu_avg():
    if os.name == "nt":
        try:
            ps = ("Get-CimInstance Win32_Processor | Measure-Object LoadPercentage -Average | "
                  "Select-Object -ExpandProperty Average")
            out = subprocess.run(["powershell", "-NoProfile", "-Command", ps],
                                 capture_output=True, text=True).stdout.strip()
            return float(out)
        except Exception:
            return -1.0
    try:
        return float(os.getloadavg()[0] * 100 / os.cpu_count())
    except Exception:
        return -1.0

FILES = {
    "rom": "rom.gba", "map": "rom.map", "exe": "mgba_mobile_test.exe", "sav": "rom.sav",
}

def sample(paths):
    out = {}
    for key, p in paths.items():
        if not p:
            continue
        out[key] = {"path": os.path.abspath(p), "md5": md5(p), **stat_info(p)}
    return out

def cmd_freeze(args):
    # 同 tag 铁律：目录已存在则拒绝
    root = os.path.join(os.environ.get("TEMP", "/tmp"), "mgbax-frozen-" + args.tag)
    if os.path.exists(root):
        print("REFUSE: tag already exists: %s (同 tag 铁律，换 TAG)" % root)
        return 2
    cpu = cpu_avg()
    print("CPU avg = %s%%" % cpu)
    if cpu > 70:
        print("REFUSE: CPU>70 (AGENTS 2.5)")
        return 2

    src = {"rom": args.rom, "map": args.map, "exe": args.exe, "sav": args.sav}
    os.makedirs(root, exist_ok=False)
    copied = {}
    for key in ("rom", "map", "exe", "sav"):
        if src[key]:
            dst = os.path.join(root, FILES[key])
            shutil.copy2(src[key], dst)
            copied[key] = dst
            print("copied %s -> %s" % (src[key], dst))

    s1 = sample(copied)
    t1 = now()
    print("sample 1 done, waiting %ss ..." % args.wait)
    time.sleep(args.wait)
    s2 = sample(copied)
    t2 = now()

    confirm = "PASS" if s1 == s2 else "FAIL"
    if confirm != "PASS":
        print("FREEZE FAIL: md5 drifted during wait; discard %s and use a NEW tag" % root)
        shutil.rmtree(root, ignore_errors=True)
        return 3

    manifest = {
        "schema": "g1det-md5gate/1-sampling",
        "tag": args.tag,
        "time": t1,
        "md5_double_confirm": confirm,
        "evidence_tier": "SAMPLING",  # 起止双次，非逐帧
        "md5_sample_1_time": t1,
        "md5_sample_2_time": t2,
        "files": s2,
        "gen8_head": git_head(args.gen8 or r"D:\gen8"),
        "main_head": git_head(args.repo or os.getcwd()),
        "cpu_avg": cpu,
        "note": "起止双次 md5 一致；非逐帧自证。真机物理隔离才根治移动靶。",
    }
    mf = os.path.join(root, "manifest.json")
    with open(mf, "w", encoding="utf-8") as f:
        json.dump(manifest, f, ensure_ascii=False, indent=2)
    print("FREEZE OK -> %s" % mf)
    for k, v in s2.items():
        print("  %s md5=%s size=%d" % (k, v["md5"], v["size"]))
    return 0

def cmd_check(args):
    mf = os.path.join(args.dir, "manifest.json")
    if not os.path.exists(mf):
        print("CHECK FAIL: no manifest.json in %s" % args.dir)
        return 2
    manifest = json.load(open(mf, encoding="utf-8"))
    if manifest.get("md5_double_confirm") != "PASS":
        print("CHECK FAIL: manifest md5_double_confirm != PASS")
        return 2
    cur = sample({k: os.path.join(args.dir, FILES[k]) for k in manifest["files"]})
    ok = cur == manifest["files"]
    print("CHECK %s (tier=%s)" % ("PASS" if ok else "FAIL", manifest.get("evidence_tier")))
    for k in manifest["files"]:
        exp, got = manifest["files"][k]["md5"], cur.get(k, {}).get("md5")
        print("  %s expected=%s measured=%s %s" %
              (k, exp[:12], (got or "MISSING")[:12], "OK" if exp == got else "DRIFT"))
    return 0 if ok else 3

def main():
    p = argparse.ArgumentParser(description=__doc__)
    sub = p.add_subparsers(dest="cmd", required=True)
    f = sub.add_parser("freeze")
    f.add_argument("--tag", required=True)
    f.add_argument("--rom", required=True)
    f.add_argument("--map", required=True)
    f.add_argument("--exe", required=True)
    f.add_argument("--sav")
    f.add_argument("--wait", type=int, default=45)
    f.add_argument("--gen8", default=r"D:\gen8")
    f.add_argument("--repo", default=os.getcwd())
    c = sub.add_parser("check")
    c.add_argument("--dir", required=True)
    args = p.parse_args()
    return cmd_freeze(args) if args.cmd == "freeze" else cmd_check(args)

if __name__ == "__main__":
    sys.exit(main())
