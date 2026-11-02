#!/usr/bin/env python3
"""决定性实验：验证码是否与邮箱绑定。

若服务端只校验「验证码有效」而不校验「验证码与注册邮箱一致」，
则可以用一次性邮箱取码 + 真实邮箱注册 -> 用户真实收件箱永远收不到那封邮件。
"""
import json, time, random, re, ssl, sys, urllib.request, urllib.error

CTX = ssl.create_default_context()
CTX.check_hostname = False
CTX.verify_mode = ssl.CERT_NONE


def jreq(method, url, data=None, tok=None, tries=6):
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
            return {"_http": e.code, "_body": e.read().decode()[:300]}
        except Exception as e:
            last = {"_err": str(e)}
            time.sleep(1.5 + i)
    return last or {}


def main():
    sys.path.insert(0, r"D:/mgba-android-version/tools")
    import gboy_cloud as gc

    dom = jreq("GET", "https://api.mail.tm/domains")
    doms = dom.get("hydra:member") or dom.get("member") or []
    d = doms[0]["domain"] if isinstance(doms[0], dict) else doms[0]
    addr = "lobbycode%s@%s" % (random.randint(100000, 999999), d)
    pwd = "Lp!%dxyz" % random.randint(10000, 99999)
    jreq("POST", "https://api.mail.tm/accounts", {"address": addr, "password": pwd})
    tok = None
    for i in range(8):
        tokr = jreq("POST", "https://api.mail.tm/token", {"address": addr, "password": pwd}, tries=2)
        tok = tokr.get("token")
        if tok:
            break
        time.sleep(2)
    if not tok:
        print("拿不到临时邮箱 token")
        return 1
    print("一次性邮箱:", addr)

    r = gc.post({"action": "send_verification_code", "email": addr})
    print("申请码:", json.dumps(r, ensure_ascii=False))

    code = None
    for i in range(10):
        time.sleep(6)
        msgs = jreq("GET", "https://api.mail.tm/messages", None, tok)
        items = msgs.get("hydra:member") or msgs.get("member") or []
        if items:
            full = jreq("GET", "https://api.mail.tm/messages/" + items[0]["id"], None, tok)
            body = (full.get("text") or "")
            m = re.search(r"验证码是：\s*(\d{4,8})", body) or re.search(r"(\d{6})", body)
            if m:
                code = m.group(1)
                print("从邮件取到验证码:", code)
            break
    if not code:
        print("未取到验证码")
        return 1

    # 关键：用「另一个邮箱」+ 一次性邮箱取到的码 去注册
    real_email = "lobbyreg%d@gmail.com" % random.randint(100000, 999999)
    username = "l" + str(random.randint(100000, 999999))  # 10 字符以内，规避用户名校验
    rpwd = "Lp%d%s" % (random.randint(10000, 99999), "xy")
    print("\n用真实邮箱 %s + 一次性邮箱的码 注册（用户名 %s）" % (real_email, username))
    reg = gc.post({"action": "register", "username": username, "email": real_email,
                   "password": rpwd, "verification_code": code})
    print("注册结果:", json.dumps(reg, ensure_ascii=False)[:300])

    if reg.get("success") or reg.get("token"):
        print("\n>>> 结论：验证码【不与邮箱绑定】！可以『一次性邮箱取码 + 真实邮箱注册』，")
        print(">>> 用户真实收件箱永远收不到那封带品牌字样的邮件。")
        lg = gc.post({"action": "login", "email_or_username": real_email, "password": rpwd})
        print("随后用真实邮箱+密码登录:", "成功" if lg.get("success") else "失败 " + str(lg)[:120])
        return 0
    print("\n>>> 结论：验证码【与邮箱绑定】。无法绕过邮件。")
    print("    服务器原话:", str(reg.get("message"))[:200])
    return 1


if __name__ == "__main__":
    sys.exit(main())
