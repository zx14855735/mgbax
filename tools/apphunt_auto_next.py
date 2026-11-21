#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""APPHUNT auto-next E2E watcher.

Polls the PC dist md5; when ROOTHUNT rebuilds it, rebuilds the debug APK from the
current working tree, installs it on the AVD, and launches the next cross-device
E2E with --app-nav. This implements the "run E2E repeatedly as new builds land"
mission item without manual round-trips.

Owns only app/device/driver artifacts; never touches C source or ROOTHUNT processes.
"""
import hashlib
import os
import subprocess
import sys
import time

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
DIST = os.path.join(ROOT, "build-win", "dist", "mGBA.exe")
APK = os.path.join(ROOT, "android", "app", "build", "outputs", "apk", "debug", "app-debug.apk")
ADB = r"D:\Android\Sdk\platform-tools\adb.exe"
SERIAL = "emulator-5554"
PY = sys.executable
POLL = 15
MAX_WAIT = 60 * 60
TAG = "APPHUNT-AUTO"


def md5(path):
    h = hashlib.md5()
    with open(path, "rb") as f:
        for chunk in iter(lambda: f.read(1 << 20), b""):
            h.update(chunk)
    return h.hexdigest().upper()


def run(cmd, cwd=None, timeout=None):
    print("[AUTO] RUN %s" % " ".join(cmd), flush=True)
    r = subprocess.run(cmd, cwd=cwd, capture_output=True, text=True,
                       encoding="utf-8", errors="replace", timeout=timeout)
    print("[AUTO] rc=%s" % r.returncode, flush=True)
    if r.stdout:
        print(r.stdout[-2000:].encode("ascii", "replace").decode("ascii"), flush=True)
    if r.stderr:
        print(r.stderr[-800:].encode("ascii", "replace").decode("ascii"), flush=True)
    return r.returncode


def main():
    baseline = md5(DIST)
    print("[AUTO] watching dist md5=%s (baseline); max %ds" % (baseline, MAX_WAIT), flush=True)
    t0 = time.time()
    new_md5 = None
    while time.time() - t0 < MAX_WAIT:
        time.sleep(POLL)
        try:
            cur = md5(DIST)
        except OSError:
            continue
        if cur != baseline:
            new_md5 = cur
            print("[AUTO] dist CHANGED %s -> %s" % (baseline, cur), flush=True)
            break
    if not new_md5:
        print("[AUTO] TIMEOUT: dist unchanged; no E2E launched", flush=True)
        return 2

    # Rebuild APK from current working tree (picks up any app-side fix/instrumentation).
    rc = run(["cmd", "/c", "gradlew.bat", ":app:assembleDebug", "--offline"],
             cwd=os.path.join(ROOT, "android"), timeout=420)
    if rc != 0:
        print("[AUTO] APK BUILD FAILED; aborting", flush=True)
        return 3
    print("[AUTO] APK md5=%s" % md5(APK), flush=True)

    # adb daemon can restart between the gradle build and install and leave the
    # device "offline" (observed 05:56: daemon restart -> install rc=1). Reconnect
    # and retry a few times before giving up; never touch the emulator process.
    rc = 1
    for attempt in range(1, 4):
        rc = run([ADB, "-s", SERIAL, "install", "-r", APK], timeout=180)
        if rc == 0:
            break
        print("[AUTO] install attempt %d failed; restart adb server + retry" % attempt,
              flush=True)
        # "device offline" and "device not found" both clear with a full adb server
        # restart (qemu stays alive). reconnect offline alone does not fix the latter.
        run([ADB, "kill-server"], timeout=30)
        run([ADB, "start-server"], timeout=30)
        time.sleep(5)
    if rc != 0:
        print("[AUTO] APK INSTALL FAILED after 3 attempts; aborting", flush=True)
        return 4

    # Launch cross-device E2E in the foreground of this (background) shell.
    tag = "%s-%s" % (TAG, time.strftime("%H%M%S"))
    # ROOTHUNT iteration 6/8: CONNECT_POLL=1 (default) breaks MASTER block receive;
    # CONNECT_POLL=0 + SIO_FAST=0 is the config that first gave rem=1 in proxy E2E.
    rc = run([PY, os.path.join(ROOT, "tools", "cloud2p_avd.py"),
              "--tag", tag, "--mode", "A", "--runsec", "480",
              "--no-emulator", "--serial", SERIAL, "--app-nav",
              "--fast-early", "--fast-min-ok-slave", "8", "--fast-slave-align", "4",
              "--env", "MGBAX_SIO_CONNECT_POLL=0", "--env", "MGBAX_SIO_FAST=0",
              "--env", "MGBAX_SEAT_ASSIST=1",
              "--env", "MGBAX_CLOSE_GRACE=1",
              "--env", "MGBAX_GBOY_BATTLE_LO=080B30C0",
              "--env", "MGBAX_GBOY_BATTLE_HI=080BCA78"],
             cwd=ROOT, timeout=1200)
    print("[AUTO] E2E DONE tag=%s dist=%s rc=%s" % (tag, new_md5, rc), flush=True)
    return rc


if __name__ == "__main__":
    sys.exit(main())
