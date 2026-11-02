#!/usr/bin/env python3
"""一次性邮箱实测：gboy.top 的验证码邮件里是否出现 gboy 字样。

用 mail.tm 建一个可读的临时邮箱 -> 向 gboy.top 申请验证码 -> 读取真实邮件
的标题/正文，判定 gboy 是否出现，并打印上下文。
"""
import json, time, random, re, ssl, sys, urllib.request, urllib.error

CTX = ssl.create_default_context()
CTX.check_hostname = False
CTX.verify_mode = ssl.CERT_NONE


def jreq(method, url, data=None, tok=None, tries=6):
    last = None
    for i in range(tries):
        req = urllib.request.Request(
            url, data=(json.dumps(data).encode() if data is not None else None),
            headers={"Content-Type": "application/json"}, method=method)
        if tok:
            req.add_header("Authorization", "Bearer " + tok)
        try:
            with urllib.request.urlopen(req, context=CTX, timeout=25) as r:
                return json.loads(r.read().decode())
        except urllib.error.HTTPError as e:
            return {"_http": e.code, "_body": e.read().decode()[:200]}
        except Exception as e:
            last = {"_err": str(e)}
            time.sleep(1.5 + i)
    return last or {}


def main():
    dom = jreq("GET", "https://api.mail.tm/domains")
    doms = dom.get("hydra:member") or dom.get("member") or []
    if not doms:
        print("取域名失败:", json.dumps(dom, ensure_ascii=False)[:200])
        return 1
    d = doms[0]["domain"] if isinstance(doms[0], dict) else doms[0]
    addr = "lobbyp%s@%s" % (random.randint(100000, 999999), d)
    pwd = "Lp!%dxyz" % random.randint(10000, 99999)
    acc = jreq("POST", "https://api.mail.tm/accounts", {"address": addr, "password": pwd})
    print("临时邮箱:", addr, "id=", acc.get("id"))

    tok = None
    for i in range(8):
        tokr = jreq("POST", "https://api.mail.tm/token", {"address": addr, "password": pwd}, tries=2)
        tok = tokr.get("token")
        if tok:
            break
        print("  取 token 第 %d 次失败: %s" % (i + 1, json.dumps(tokr, ensure_ascii=False)[:120]))
        time.sleep(2)
    if not tok:
        print("无法取得邮箱 token，放弃")
        return 1
    print("取 token: OK")

    sys.path.insert(0, r"D:/mgba-android-version/tools")
    import gboy_cloud as gc
    body = {"action": "send_verification_code", "email": addr}
    extra = {}
    if len(sys.argv) > 1:
        try:
            extra = json.loads(sys.argv[1])
        except Exception:
            print("额外字段解析失败:", sys.argv[1])
            return 1
        body.update(extra)
    print("请求体:", json.dumps(body, ensure_ascii=False))
    r = gc.post(body)
    print("服务端回复:", json.dumps(r, ensure_ascii=False))

    items = []
    for i in range(10):
        time.sleep(6)
        msgs = jreq("GET", "https://api.mail.tm/messages", None, tok)
        items = msgs.get("hydra:member") or msgs.get("member") or []
        if items:
            break
    print("收到邮件数:", len(items))
    if not items:
        print("未收到邮件，无法判定正文")
        return 1

    hit = False
    for it in items[:3]:
        full = jreq("GET", "https://api.mail.tm/messages/" + it["id"], None, tok)
        html = full.get("html") or ""
        if isinstance(html, list):
            html = "\n".join(str(x) for x in html)
        body = ((full.get("text") or "") + "\n" + html)
        subj = full.get("subject") or ""
        low = body.lower()
        has = "gboy" in low or "gboy" in subj.lower()
        hit = hit or has
        print("--- 主题:", subj)
        print("--- 含 gboy:", has)
        for m in re.finditer(r"gboy", low):
            s = max(0, m.start() - 60)
            print("      上下文: ...%s..." % body[s:m.start() + 60].replace("\n", " | "))
        print("--- 正文(前600):", body[:600].replace("\n", " | "))
    print("\n结论: 验证码邮件%s gboy 字样" % ("包含" if hit else "不包含"))
    return 0


if __name__ == "__main__":
    sys.exit(main())
