#!/usr/bin/env python3
# GBoy gboy.top 房间服务器客户端（与 APK 的 GBoyCloudLink 等价，仅信令部分）
# 用于：登录/注册账号、以房主身份建房并返回房号、以加入者身份按房号进入。
# 实际的对战字节仍由 APK 通过中继节点收发，本脚本只负责"建房/进房"这部分信令。
import sys, json, ssl, urllib.request, urllib.error

API = "https://gboy.top/api/api.php"

# 与 APK 一致：信任任意证书（gboy.top 用的是过期/错配证书）
CTX = ssl.create_default_context()
CTX.check_hostname = False
CTX.verify_mode = ssl.CERT_NONE

def post(body):
    data = json.dumps(body).encode("utf-8")
    req = urllib.request.Request(API, data=data, headers={"Content-Type": "application/json"})
    try:
        with urllib.request.urlopen(req, context=CTX, timeout=15) as r:
            raw = r.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        raw = e.read().decode("utf-8", "replace")
    # api.php 可能在 JSON 前回显一些提示，取最后一行 JSON
    for line in reversed(raw.splitlines()):
        line = line.strip()
        if line.startswith("{"):
            try:
                return json.loads(line)
            except Exception:
                pass
    return {"_raw": raw}

def login(email, password):
    return post({"action": "login", "email_or_username": email, "password": password})

def send_verification_code(email):
    return post({"action": "send_verification_code", "email": email})

def register(username, email, password, code):
    return post({"action": "register", "username": username,
                 "email": email, "password": password, "verification_code": code})

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("用法:")
        print("  login <email> <password>")
        print("  code  <email>          # 申请注册验证码")
        sys.exit(1)
    cmd = sys.argv[1]
    if cmd == "login":
        print(json.dumps(login(sys.argv[2], sys.argv[3]), ensure_ascii=False, indent=2))
    elif cmd == "code":
        print(json.dumps(send_verification_code(sys.argv[2]), ensure_ascii=False, indent=2))
    else:
        print("未知命令", cmd)
