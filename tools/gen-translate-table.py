#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""由 .zcode-tmp/i18n_zh.json 生成 src/platform/qt/MgbaTranslate.cpp。

单一来源：所有译文都在 JSON 里，改完重新跑本脚本即可，避免「手工追加到 cpp 后被覆盖」。
"""
import json
import os

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SRC = os.path.join(ROOT, ".zcode-tmp", "i18n_zh.json")
DST = os.path.join(ROOT, "src", "platform", "qt", "MgbaTranslate.cpp")


def cpp_lit(s):
    s = s.replace("\\n", "\n").replace('\\"', '"').replace("\\\\", "\\")
    out = s.replace("\\", "\\\\").replace('"', '\\"').replace("\n", "\\n").replace("\t", "\\t")
    return '"' + out + '"'


rows = sorted(json.load(open(SRC, encoding="utf-8")).items(), key=lambda kv: kv[0])
head = open(os.path.join(ROOT, "tools", "_translate_head.txt"), encoding="utf-8").read()
body = "\n".join("\t{ %s, %s }," % (cpp_lit(k), cpp_lit(v)) for k, v in rows)
tail = open(os.path.join(ROOT, "tools", "_translate_tail.txt"), encoding="utf-8").read()
open(DST, "w", encoding="utf-8", newline="\n").write(head + body + tail)
print("生成 %d 条 → %s" % (len(rows), DST))
