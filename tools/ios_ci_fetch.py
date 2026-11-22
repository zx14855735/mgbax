#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""推送 GitHub 后：等 iOS CI 编译完成，把 IPA artifact 拉回本地。

流程（写入 AGENTS.md §7）：
  1. 从 git credential(manager) 读 GitHub OAuth token（不写死、不打印）。
  2. 按 head_sha 找到对应的 macOS CI run（iOS Simulator / ios-build.yml）。
  3. 轮询等 run 完成（默认 ≤20 分钟，可 --timeout 调）；CI 红/超时如实报告。
  4. 下载 `mgbax-unsigned-ipa` artifact（zip），解出 .ipa 到 ios_ci_artifacts/，
     文件名带 sha8，打印 md5 供磁盘实测核对。

用法：
  python tools/ios_ci_fetch.py                # 拉主仓 HEAD 对应 run
  python tools/ios_ci_fetch.py <sha8-or-full> # 指定 commit
  python tools/ios_ci_fetch.py --no-wait      # 只查一次，不轮询
"""
import hashlib
import json
import os
import subprocess
import sys
import time
import zipfile

REPO = "zx14855735/mgbax"
OUT_DIR = r"D:\mgba-android-version\ios_ci_artifacts"
ARTIFACT = "mgbax-unsigned-ipa"
POLL_SEC = 30


def git_token():
    cred = subprocess.run(
        ["git", "credential", "fill"],
        input="protocol=https\nhost=github.com\n\n",
        capture_output=True, text=True, encoding="utf-8", errors="replace",
    ).stdout
    tok = next((l.split("=", 1)[1] for l in cred.strip().splitlines()
                if l.startswith("password=")), None)
    if not tok:
        print("无法从 git credential 读取 GitHub token")
        sys.exit(2)
    return tok


TOKEN = git_token()
HDR = ["-H", "Authorization: Bearer " + TOKEN,
       "-H", "Accept: application/vnd.github+json",
       "-H", "X-GitHub-Api-Version: 2022-11-28"]


def api(url):
    p = subprocess.run(["curl.exe", "-s", "-L"] + HDR + [url],
                       capture_output=True, text=True, encoding="utf-8", errors="replace")
    try:
        return json.loads(p.stdout)
    except Exception:
        print("API 解析失败:", repr(p.stdout[:200]), repr(p.stderr[:200]))
        sys.exit(3)


def github_head():
    """GitHub 实况 HEAD——可能落后主仓（gitee 全量 vs GitHub 白名单）。"""
    d = api("https://api.github.com/repos/%s/commits/main" % REPO)
    return d.get("sha", "")


def find_run(sha):
    d = api("https://api.github.com/repos/%s/actions/runs?per_page=30" % REPO)
    for r in d.get("workflow_runs", []):
        if r["head_sha"].startswith(sha):
            return r
    return None


def wait_run(run_id, timeout_sec):
    deadline = time.time() + timeout_sec
    while True:
        r = api("https://api.github.com/repos/%s/actions/runs/%d" % (REPO, run_id))
        status = r.get("status")
        conclusion = r.get("conclusion")
        print("run %d status=%s conclusion=%s" % (run_id, status, conclusion))
        if status == "completed":
            return conclusion
        if time.time() >= deadline:
            print("等待超时（%ds），CI 仍未完成" % timeout_sec)
            return None
        time.sleep(POLL_SEC)


def find_artifact(run_id, name):
    d = api("https://api.github.com/repos/%s/actions/runs/%d/artifacts" % (REPO, run_id))
    for a in d.get("artifacts", []):
        if a["name"] == name and not a.get("expired"):
            return a
    return None


def download_artifact(artifact_id, dest_zip):
    url = "https://api.github.com/repos/%s/actions/artifacts/%d/zip" % (REPO, artifact_id)
    p = subprocess.run(["curl.exe", "-s", "-L", "-o", dest_zip] + HDR + [url],
                       capture_output=True, text=True, encoding="utf-8", errors="replace")
    if p.returncode != 0 or not os.path.exists(dest_zip) or os.path.getsize(dest_zip) < 1000:
        print("artifact 下载失败:", p.stderr[:200])
        return False
    return True


def main():
    args = [a for a in sys.argv[1:] if not a.startswith("--")]
    no_wait = "--no-wait" in sys.argv
    timeout = 20 * 60
    sha = args[0] if args else github_head()
    print("目标 commit:", sha)

    run = find_run(sha)
    if not run:
        print("未找到该 commit 对应的 CI run（可能尚未触发）")
        return 4
    run_id = run["id"]
    print("CI run:", run_id, run.get("html_url"))

    conclusion = None
    if not no_wait:
        conclusion = wait_run(run_id, timeout)
        if conclusion is None:
            return 5
        if conclusion != "success":
            print("CI 结论=%s，不拉 IPA（如实报告，不伪造）" % conclusion)
            return 6

    art = find_artifact(run_id, ARTIFACT)
    if not art:
        print("run %d 无 artifact '%s'" % (run_id, ARTIFACT))
        return 7
    print("artifact:", art["id"], "size:", art.get("size_in_bytes"))

    os.makedirs(OUT_DIR, exist_ok=True)
    dest_zip = os.path.join(OUT_DIR, "artifact-%d.zip" % art["id"])
    if not download_artifact(art["id"], dest_zip):
        return 8

    ipas = []
    with zipfile.ZipFile(dest_zip) as z:
        for n in z.namelist():
            if n.lower().endswith(".ipa"):
                data = z.read(n)
                out = os.path.join(OUT_DIR, "mGBAx-%s.ipa" % sha[:8])
                with open(out, "wb") as f:
                    f.write(data)
                md5 = hashlib.md5(data).hexdigest()
                ipas.append((out, len(data), md5))
    if not ipas:
        print("zip 内无 .ipa；条目:", [n for n in zipfile.ZipFile(dest_zip).namelist()][:10])
        return 9
    for out, size, md5 in ipas:
        print("IPA: %s  size=%d  md5=%s" % (out, size, md5))
    return 0


if __name__ == "__main__":
    sys.exit(main())
