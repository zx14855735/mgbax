#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""cross_device_identity_check.py — 跨设备身份硬核验（只读验收工具）。

用户硬要求：两端「不同 IP + 不同邮箱」登录，缺一不可。
判据详见 docs/architecture/ADR-006-cross-device-identity.md。

本工具 **只读** 一个 run 目录（summary.txt + 两端日志），不改 driver、不写文件：

  * EMAIL_DISTINCT —— summary 的 accounts_distinct（邮箱级断言），或新增的
    email_app/email_pc 明文邮箱字段（别名 app_email/pc_email 等）。
  * IP_DISTINCT   —— 从两端 `[direct] 候选 ... / 本地端口` / `[MGBAX_P2P]
    event=announce ... list=` 提取本端候选地址，用 ipaddress.is_global 取公网出口 IP；
    中继 node_address（如 47.103.87.123）显式排除。两端明文公网 IP 都在 → STRONG
    （相同即 FAIL：同机同 NAT，不算跨设备）；否则 candidate 差异 + p2p 直连 → MEDIUM。

输出：IDENTITY / EMAIL_DISTINCT / IP_DISTINCT / EVIDENCE_LEVEL + 证据行。
退出码：0=PASS, 1=FAIL, 3=UNOBSERVED, 2=输入错误。

Examples
--------
  python tools/cross_device_identity_check.py .zcode-tmp/cloud2p/APPHUNT-FINAL
  python tools/cross_device_identity_check.py .zcode-tmp/cloud2p/AC4808ED-FINAL --json
"""

import argparse
import glob
import ipaddress
import json
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

# summary 字段别名（新 run 里 APPHUNT 可能补落明文邮箱 / 公网 IP）
EMAIL_APP_KEYS = ("app_email", "email_app", "app_user", "app_account", "app_acc")
EMAIL_PC_KEYS = ("pc_email", "email_pc", "pc_user", "pc_account", "pc_acc")
EMAIL_BOOL_KEYS = ("accounts_distinct", "accounts_distinct_email")
IP_APP_KEYS = ("app_public_ip", "public_ip_app", "app_wan_ip", "wan_ip_app", "app_egress_ip")
IP_PC_KEYS = ("pc_public_ip", "public_ip_pc", "pc_wan_ip", "wan_ip_pc", "pc_egress_ip")
# driver 新落的启发式字段：仅作交叉核对，绝不作为判据（详见 ADR-006 §3.4）
DRIVER_LOCAL_PC_KEYS = ("ip_local_PC", "local_ip_PC", "ip_pc_local")
DRIVER_LOCAL_APP_KEYS = ("ip_local_APP", "local_ip_APP", "ip_app_local")

PC_LOG_NAMES = ("mgba_lobby_debug.log", "lobby_debug.log", "lobby.log", "mgba_lobby.log")
APP_LOG_NAMES = ("app_logcat_full.log", "app_logcat.log", "app_link_startup.log", "logcat.log")

KV_RE = re.compile(r"([A-Za-z_][A-Za-z0-9_]*)=([^\s#]+)")
IPV4_RE = re.compile(r"\b(\d{1,3}(?:\.\d{1,3}){3})\b")
ENDPOINT_RE = re.compile(r"\b(\d{1,3}(?:\.\d{1,3}){3}):(\d{1,5})\b")
# 本端候选段：`候选 1.2.3.4:1,5.6.7.8:2 / 本地端口 45147`（app 侧列表额外带 []）
CAND_SECTION_RE = re.compile(r"候选\s*\[?([^\]\n]*?)\]?\s*/\s*本地端口")
# 回退：PC 的 `event=announce ... list=<本端候选>`（peer-candidates 是对端，绝不能用）
ANNOUNCE_RE = re.compile(r"\[MGBAX_P2P\][^\n]*event=announce[^\n]*\blist=([0-9.,: ]+)")
# 中继节点地址（两端都连它，不是端 IP）
RELAY_RE = re.compile(
    r'(?:node_address|advertised\s+relay|relay)"?\s*[:=]?\s*"?(\d{1,3}(?:\.\d{1,3}){3})')


def read_text(path):
    with open(path, "r", encoding="utf-8", errors="replace") as fh:
        return fh.read()


def parse_summary(path):
    """把 summary.txt 的所有 key=value 收进 dict（同一行多对也收）。"""
    d = {}
    for line in read_text(path).splitlines():
        for k, v in KV_RE.findall(line.split("#", 1)[0]):
            d[k] = v
    return d


def as_bool(v):
    if v is None:
        return None
    s = str(v).strip().lower()
    if s in ("true", "1", "yes", "ok", "pass"):
        return True
    if s in ("false", "0", "no", "fail"):
        return False
    return None


def first_existing(d, keys):
    for k in keys:
        v = d.get(k)
        if v and v not in ("-", "<unset>", "None", "none"):
            return k, v
    return None, None


def norm_email(v):
    """去密码、去空白、小写归一化；不是邮箱则返回 None。"""
    if not v:
        return None
    s = str(v).strip().split()[0].split(":", 1)[0].strip().lower()
    return s if "@" in s else None


def norm_ip(v):
    if not v:
        return None
    m = IPV4_RE.search(str(v))
    return m.group(1) if m else None


def is_public(ip):
    """公网出口 IP = is_global；排除 loopback/link-local/CGNAT。"""
    try:
        a = ipaddress.ip_address(ip)
    except ValueError:
        return False
    if a.version != 4 or not a.is_global:
        return False
    parts = ip.split(".")
    if parts[0] == "100" and 64 <= int(parts[1]) <= 127:  # CGNAT 不算公网出口
        return False
    return True


def discover(run_dir, explicit, names):
    if explicit:
        return explicit if os.path.isfile(explicit) else None
    for name in names:
        hit = glob.glob(os.path.join(run_dir, "**", name), recursive=True)
        if hit:
            return hit[0]
    return None


def extract_candidates(text):
    """返回 [(ip, port, lineno, rawline)]，只取本端候选。"""
    out = []
    for n, line in enumerate(text.splitlines(), 1):
        for m in CAND_SECTION_RE.finditer(line):
            for ip, port in ENDPOINT_RE.findall(m.group(1)):
                out.append((ip, int(port), n, line.strip()))
        if not CAND_SECTION_RE.search(line):
            m = ANNOUNCE_RE.search(line)
            if m:
                for ip, port in ENDPOINT_RE.findall(m.group(1)):
                    out.append((ip, int(port), n, line.strip()))
    return out


def p2p_direct(text, label):
    """找到 p2p 直连成功证据 → (True, '文件:行', 原文)。"""
    for n, line in enumerate(text.splitlines(), 1):
        if ("event=result" in line and "result=ok" in line
                and ("directEnabled=1" in line or re.search(r"\bdirect=1\b", line))):
            return True, "%s:%d" % (label, n), line.strip()
        if "P2P 已启用" in line:
            return True, "%s:%d" % (label, n), line.strip()
    return False, None, None


def check(run_dir, pc_log_arg=None, app_log_arg=None):
    summary_path = os.path.join(run_dir, "summary.txt")
    if not os.path.isfile(summary_path):
        raise SystemExit("ERROR: 找不到 %s" % summary_path)
    s = parse_summary(summary_path)

    ev = []
    ev.append("RUN_DIR=%s" % os.path.abspath(run_dir))
    ev.append("SUMMARY=%s" % summary_path)

    # ---------- 邮箱 ----------
    k_app, v_app = first_existing(s, EMAIL_APP_KEYS)
    k_pc, v_pc = first_existing(s, EMAIL_PC_KEYS)
    email_app, email_pc = norm_email(v_app), norm_email(v_pc)
    if email_app and email_pc:
        email_distinct = email_app != email_pc
        email_level = "STRONG"
        ev.append("EMAIL_APP=%s  # summary.%s" % (email_app, k_app))
        ev.append("EMAIL_PC=%s  # summary.%s" % (email_pc, k_pc))
        ev.append("EMAIL_EVIDENCE=STRONG plaintext emails compared character-by-character")
    elif any(k in s for k in EMAIL_BOOL_KEYS):
        bk = next(k for k in EMAIL_BOOL_KEYS if k in s)
        email_distinct = as_bool(s[bk])
        email_level = "MEDIUM"
        other_bk = [k for k in EMAIL_BOOL_KEYS if k in s and k != bk]
        if other_bk and as_bool(s[other_bk[0]]) != email_distinct:
            ev.append("EMAIL_BOOL_MISMATCH=%s=%s vs %s=%s"
                      % (bk, s[bk], other_bk[0], s[other_bk[0]]))
        masked = [k for k in ("email_app", "email_pc") if "***" in str(s.get(k, ""))]
        if masked:
            ev.append("EMAIL_DRIVER_FIELDS_MASKED=%s  # driver masks emails (***); "
                      "cannot be used for plaintext email comparison" % ",".join(masked))
        else:
            ev.append("EMAIL_APP=<not in plaintext>  # ask APPHUNT to log email_app")
            ev.append("EMAIL_PC=<not in plaintext>  # ask APPHUNT to log email_pc")
        ev.append("EMAIL_EVIDENCE=MEDIUM summary.%s=%s is driver email-level assertion "
                  "(app_user != pc_acc email part)" % (bk, s[bk]))
    else:
        email_distinct = None
        email_level = "NONE"
        ev.append("EMAIL_EVIDENCE=NONE no accounts_distinct / plaintext emails")

    # UUID 是补充证据，不能替代邮箱
    ua, up = s.get("uuid_app"), s.get("uuid_pc")
    if ua or up:
        ev.append("UUID_SUPPLEMENT uuid_app=%s uuid_pc=%s uuids_distinct=%s "
                  "# supplementary only; cannot replace email/IP"
                  % (ua, up, s.get("uuids_distinct", "-")))

    # ---------- IP ----------
    pc_log = discover(run_dir, pc_log_arg, PC_LOG_NAMES)
    app_log = discover(run_dir, app_log_arg, APP_LOG_NAMES)
    pc_text = read_text(pc_log) if pc_log else ""
    app_text = read_text(app_log) if app_log else ""
    ev.append("PC_LOG=%s" % (pc_log or "<none>"))
    ev.append("APP_LOG=%s" % (app_log or "<none>"))

    relay_ips = sorted(set(RELAY_RE.findall(pc_text + "\n" + app_text)))
    ev.append("RELAY_EXCLUDED=%s  # node_address: both ends connect to it; NOT an endpoint IP"
              % (",".join(relay_ips) if relay_ips else "<none>"))

    pc_cands = extract_candidates(pc_text)
    app_cands = extract_candidates(app_text)

    def publics(cands):
        return sorted({ip for ip, _port, _n, _l in cands
                       if ip not in relay_ips and is_public(ip)})

    k_ip_app, v_ip_app = first_existing(s, IP_APP_KEYS)
    k_ip_pc, v_ip_pc = first_existing(s, IP_PC_KEYS)
    app_pub = ([norm_ip(v_ip_app)] if norm_ip(v_ip_app) else publics(app_cands))
    pc_pub = ([norm_ip(v_ip_pc)] if norm_ip(v_ip_pc) else publics(pc_cands))
    if k_ip_app:
        ev.append("IP_APP_PUBLIC=%s  # summary.%s" % (",".join(app_pub), k_ip_app))
    elif app_pub:
        ev.append("IP_APP_PUBLIC=%s  # %s:%d %s" % (
            ",".join(app_pub), os.path.basename(app_log),
            next(n for ip, _p, n, _l in app_cands if ip == app_pub[0]),
            next(l for ip, _p, _n, l in app_cands if ip == app_pub[0])))
    else:
        ev.append("IP_APP_PUBLIC=<none>  # app has no global candidate (private only / no log)")
    if k_ip_pc:
        ev.append("IP_PC_PUBLIC=%s  # summary.%s" % (",".join(pc_pub), k_ip_pc))
    elif pc_pub:
        ev.append("IP_PC_PUBLIC=%s  # %s:%d %s" % (
            ",".join(pc_pub), os.path.basename(pc_log),
            next(n for ip, _p, n, _l in pc_cands if ip == pc_pub[0]),
            next(l for ip, _p, _n, l in pc_cands if ip == pc_pub[0])))
    else:
        ev.append("IP_PC_PUBLIC=<none>  # PC has no global candidate (private only / no log)")

    app_set = {ip for ip, _p, _n, _l in app_cands}
    pc_set = {ip for ip, _p, _n, _l in pc_cands}
    cand_diff = bool(app_set and pc_set and app_set != pc_set)
    ev.append("IP_APP_CANDIDATES=%s" % (",".join(sorted(app_set)) if app_set else "<none>"))
    ev.append("IP_PC_CANDIDATES=%s" % (",".join(sorted(pc_set)) if pc_set else "<none>"))
    ev.append("CANDIDATES_DISTINCT=%s" % cand_diff)

    p2c = p2p_direct(pc_text, os.path.basename(pc_log) if pc_log else "pc")
    p2a = p2p_direct(app_text, os.path.basename(app_log) if app_log else "app")
    p2p_ok, p2p_ref, p2p_line = p2c if p2c[0] else p2a
    ev.append("P2P_DIRECT_OK=%s%s" % (p2p_ok, ("  # %s %s" % (p2p_ref, p2p_line)) if p2p_ok else ""))

    both_known = bool(app_pub and pc_pub)
    if both_known:
        ip_distinct = set(app_pub) != set(pc_pub)
        ip_level = "STRONG"
        if not ip_distinct:
            ev.append("IP_EVIDENCE=STRONG both plaintext public egress IPs EQUAL (%s): "
                      "same NAT / same physical host; differing ports or candidate lists "
                      "do NOT count as different IP login"
                      % ",".join(sorted(set(app_pub) & set(pc_pub))))
        else:
            ev.append("IP_EVIDENCE=STRONG plaintext public egress IPs differ: app=%s pc=%s"
                      % (",".join(app_pub), ",".join(pc_pub)))
    elif cand_diff and p2p_ok:
        ip_distinct = True
        ip_level = "MEDIUM"
        ev.append("IP_EVIDENCE=MEDIUM no plaintext public IP for both ends, but candidate "
                  "sets differ + p2p direct OK (not same-process loopback); weak evidence, "
                  "labelled honestly")
    else:
        ip_distinct = None
        ip_level = "NONE"
        ev.append("IP_EVIDENCE=NONE cannot extract both public egress IPs and no "
                  "candidate-diff + p2p combo")

    # ---------- driver 启发式字段：只交叉核对，不作判据 ----------
    d_pc_k, d_pc_v = first_existing(s, DRIVER_LOCAL_PC_KEYS)
    d_app_k, d_app_v = first_existing(s, DRIVER_LOCAL_APP_KEYS)
    d_ip_distinct = s.get("ip_distinct")
    if d_pc_v or d_app_v or d_ip_distinct:
        ev.append("DRIVER_CLAIM %s=%s %s=%s ip_distinct=%s  # heuristic scraped from "
                  "[direct] lines (may be PEER IPs); NOT authoritative"
                  % (d_pc_k or "ip_local_PC", d_pc_v or "<none>",
                     d_app_k or "ip_local_APP", d_app_v or "<none>",
                     d_ip_distinct or "<none>"))
        mismatch = False
        if d_pc_v and norm_ip(d_pc_v) not in pc_pub:
            mismatch = True
        if d_app_v and norm_ip(d_app_v) not in app_pub:
            mismatch = True
        if (as_bool(d_ip_distinct) is not None and ip_distinct is not None
                and as_bool(d_ip_distinct) != ip_distinct):
            mismatch = True
        ev.append("DRIVER_IP_MISMATCH=%s  # True = driver claim contradicts "
                  "candidate-list-derived evidence; this tool trusts the latter" % mismatch)

    # ---------- 汇总 ----------
    if email_distinct is False or ip_distinct is False:
        identity = "FAIL"
    elif email_distinct is True and ip_distinct is True:
        identity = "PASS"
    else:
        identity = "UNOBSERVED"

    if ip_level == "STRONG":
        level = "STRONG"
    elif ip_level == "MEDIUM":
        level = "MEDIUM"
    elif email_distinct is not None:
        level = "WEAK"
    else:
        level = "NONE"

    return {
        "IDENTITY": identity,
        "EMAIL_DISTINCT": email_distinct,
        "IP_DISTINCT": ip_distinct,
        "EVIDENCE_LEVEL": level,
        "EMAIL_EVIDENCE_LEVEL": email_level,
        "IP_EVIDENCE_LEVEL": ip_level,
        "evidence": ev,
    }


def main(argv=None):
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("run_dir", help="含 summary.txt 的 run 目录")
    ap.add_argument("--pc-log", help="显式指定 PC lobby log 路径")
    ap.add_argument("--app-log", help="显式指定 app logcat 路径")
    ap.add_argument("--json", action="store_true", help="机器可读 JSON 输出")
    args = ap.parse_args(argv)

    r = check(args.run_dir, args.pc_log, args.app_log)
    if args.json:
        print(json.dumps(r, ensure_ascii=False, indent=2))
    else:
        for line in r["evidence"]:
            print(line)
        print("")
        tri = lambda v: "PASS" if v is True else ("FAIL" if v is False else "UNOBSERVED")
        print("EMAIL_DISTINCT=%s" % tri(r["EMAIL_DISTINCT"]))
        print("IP_DISTINCT=%s" % tri(r["IP_DISTINCT"]))
        print("IDENTITY=%s" % r["IDENTITY"])
        print("EVIDENCE_LEVEL=%s" % r["EVIDENCE_LEVEL"])

    return {"PASS": 0, "FAIL": 1, "UNOBSERVED": 3}[r["IDENTITY"]]


if __name__ == "__main__":
    sys.exit(main())
