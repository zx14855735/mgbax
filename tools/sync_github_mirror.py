#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""把主仓 HEAD 的白名单内容增量同步到 GitHub 镜像仓并推送。

方法抄自 zcode 的 mgba-ios-ci-mirror 记忆（项目长期工作方式）：
  1. 三端公开仓 github.com/zx14855735/mgbax.git 只能经独立镜像仓 D:\\mgba-ios-mirror
     中转（主仓 remote github 历史无关、直推无效）；绝不 force-push。
  2. 以远端为基线做增量跟拍：每轮先 fetch；远端若前进/重写 ->
     `git reset --hard origin/main` 采用之，再把主仓 HEAD 的白名单目录增量叠上。
  3. 白名单目录 android/src/ios/include/res/cinema/tools/doc + 根文件；
     永久排除 tmp_*、.workbuddy、.zcode*、cloud2p 产物、ROM、拆解文档。
  4. .github/workflows 只在镜像存在，绝不 /MIR 删除（用 git checkout 天然不碰）。
  5. push 带重试环（GitHubDesktop 句柄锁 / EDR 拦 git.exe 会间歇失败，不杀用户进程）。

用法：
  python tools/sync_github_mirror.py --dry-run   # 只打印范围，不动
  python tools/sync_github_mirror.py              # 执行同步+推送
"""
import os
import subprocess
import sys
import tempfile
import time

DEV = r"D:\mgba-android-version"
MIRROR = r"D:\mgba-ios-mirror"
DEV_REF = "dev/master"  # 镜像的 dev remote 指向主仓
REMOTE = "origin"
BRANCH = "main"

# 白名单目录（记忆 line 21）
DIRS = ["android", "src", "ios", "include", "res", "cinema", "tools", "doc"]
# 根文件（记忆 line 21 + 本次音频文档）
ROOT_FILES = [
    "CMakeLists.txt", "version.cmake", "CMakePresets.json", ".clang-format",
    ".gitignore", "CHANGES", "LICENSE", "PORTING.md", "CONTRIBUTING.md",
    "privacy.html", "AppIcon1024.png", "AGENTS.md", "使用说明.md",
    "PC版完整使用教程.md", "PC版完整使用教程.html",
    "安卓版完整使用教程.md", "安装版完整使用教程.md",
    "mGBAx-v3.1-ios版.ipa", "mGBA模拟器ios版V3.2.ipa",
]


def run(args, cwd, check=True):
    p = subprocess.run(args, cwd=cwd, capture_output=True, text=True,
                       encoding="utf-8", errors="replace")
    if check and p.returncode != 0:
        print("[FAIL] %s -> %s" % (" ".join(args), p.stderr.strip()[:400]))
    return p


def whitelist_paths():
    """从主仓 HEAD tree 取白名单路径；core.quotepath=false 保证中文名不被转义。"""
    out = run(["git", "-c", "core.quotepath=false", "-C", DEV,
               "ls-tree", "-r", "--name-only", "HEAD"], MIRROR).stdout
    paths = []
    for p in out.splitlines():
        p = p.strip()
        if not p:
            continue
        top = p.split("/")[0]
        if top in DIRS or p in ROOT_FILES or p.startswith("README"):
            paths.append(p)
    return paths


def main():
    dry = "--dry-run" in sys.argv
    # 0. git 可用性（EDR/AV 拦截检测：git --version 都拒 => 等，非仓库问题）
    if run(["git", "--version"], MIRROR).returncode != 0:
        print("git 被 EDR/AV 拦截，本次退出（数小时后自行解除，勿杀用户进程）")
        return 2

    # 1. fetch dev(主仓) + origin(GitHub)
    run(["git", "fetch", "dev"], MIRROR)
    run(["git", "fetch", REMOTE], MIRROR)

    # 2. 远端基线：远端前进/重写则采用远端（绝不 force-push）
    local = run(["git", "rev-parse", BRANCH], MIRROR, False).stdout.strip()
    remote = run(["git", "rev-parse", "%s/%s" % (REMOTE, BRANCH)], MIRROR, False).stdout.strip()
    if local != remote:
        print("远端前进/重写 %s -> %s，reset --hard 采用远端为基线" %
              (local[:8], remote[:8]))
        if not dry:
            run(["git", "reset", "--hard", "%s/%s" % (REMOTE, BRANCH)], MIRROR)

    paths = whitelist_paths()
    print("白名单路径 %d 个；本次主仓 HEAD=%s" %
          (len(paths), run(["git", "-C", DEV, "rev-parse", "--short", "HEAD"],
                           MIRROR).stdout.strip()))
    if dry:
        for p in paths:
            if "/" not in p or p.startswith(("android/", "ios/", "src/platform/mobile/")):
                print("  " + p)
        return 0

    # 3. 增量叠加：checkout 只检出主仓 tree 中存在的白名单文件，天然不删镜像独有文件
    #    （尤其不碰 .github/workflows）。路径数可达数千，用 pathspec-file 规避
    #    Windows 命令行长度上限；NUL 分隔避免中文名/转义歧义。
    fd, spec = tempfile.mkstemp(prefix="zcode-pathspec-", suffix=".txt")
    os.close(fd)
    try:
        with open(spec, "w", encoding="utf-8", newline="") as f:
            f.write("\0".join(paths))
        pf = "--pathspec-from-file=" + spec
        if run(["git", "checkout", DEV_REF, pf, "--pathspec-file-nul"], MIRROR).returncode != 0:
            print("checkout 失败")
            return 5
        run(["git", "add", "-A", pf, "--pathspec-file-nul"], MIRROR)
    finally:
        os.remove(spec)

    st = run(["git", "status", "--porcelain"], MIRROR).stdout.strip()
    if not st:
        print("镜像与远端白名单 0 差异，无需推送")
        return 0
    print("改动文件数: %d" % len(st.splitlines()))

    dev_head = run(["git", "-C", DEV, "rev-parse", "--short", "HEAD"],
                   MIRROR).stdout.strip()
    msg = "sync from %s: audio full-PC-clone (WSOLA 2-stage+rate) + 3-end UI + docs" % dev_head
    if run(["git", "commit", "-m", msg], MIRROR).returncode != 0:
        print("commit 失败")
        return 3

    # 4. push 重试环（GitHubDesktop 句柄锁 / EDR 拦截）
    for i in range(1, 9):
        p = run(["git", "push", REMOTE, BRANCH], MIRROR, False)
        if p.returncode == 0:
            print("push 成功（第 %d 次）" % i)
            break
        print("push 第 %d 次失败: %s；10s 后重试" % (i, p.stderr.strip()[:200]))
        time.sleep(10)
    else:
        print("push 重试耗尽，需人工处理（GitHubDesktop/EDR）")
        return 4

    new_head = run(["git", "rev-parse", "--short", BRANCH], MIRROR).stdout.strip()
    print("完成：主仓 %s -> 镜像/远端 %s" % (dev_head, new_head))
    return 0


if __name__ == "__main__":
    sys.exit(main())
