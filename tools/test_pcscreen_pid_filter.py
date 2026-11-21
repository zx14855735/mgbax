#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""pcscreen 窗口选择过滤逻辑单测 —— 模拟"多个 mGBA 并存"场景。

不依赖真实窗口：替换 pcscreen.enumerate_windows / _mgba_pids 注入假窗口。
可直接运行：

    python tools/test_pcscreen_pid_filter.py

回归目标（APPHUNT3 事实链）：EnumWindows 先枚举到别的 agent 的 PyInstaller
mGBA(28736)，本轮 PC(31076) 在后。旧版 find_window() 取第一个 → 抓错窗口。
"""
import os
import sys
import unittest

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import pcscreen  # noqa: E402

OTHER_PID, OUR_PID = 28736, 31076
# 顺序刻意让"别的 agent 的 mGBA"排在前面，复现抢到 EnumWindows 首位的情况
OTHER = (0x1001, OTHER_PID, "mGBA 0.11-9601-e34796963")
OURS = (0x2002, OUR_PID, "mGBA 0.11-10027-83f88fd39-dirty")
NOT_MGBA = (0x3003, 40000, "Some Other App - not mGBA")


class TestPidFilter(unittest.TestCase):
    def setUp(self):
        self._orig_enum = pcscreen.enumerate_windows
        self._orig_pids = pcscreen._mgba_pids

    def tearDown(self):
        pcscreen.enumerate_windows = self._orig_enum
        pcscreen._mgba_pids = self._orig_pids

    def _inject(self, windows, pids=None):
        pcscreen.enumerate_windows = lambda: list(windows)
        pcscreen._mgba_pids = lambda exe_name="mGBA.exe": list(
            pids if pids is not None else [OTHER_PID, OUR_PID])

    def test_pid_picks_our_window_even_when_other_is_first(self):
        """核心回归：别的 mGBA 在前，仍必须选中本轮 PC 的窗口。"""
        self._inject([OTHER, OURS])
        self.assertEqual(pcscreen.find_window(pid=OUR_PID), 0x2002)
        hwnd, pid, title = pcscreen.find_window_info(pid=OUR_PID)
        self.assertEqual((hwnd, pid), (0x2002, OUR_PID))
        self.assertIn("0.11-10027", title)

    def test_no_pid_keeps_legacy_behavior(self):
        """向后兼容：无 PID 时仍是旧行为（第一个 mGBA 窗口）。"""
        self._inject([OTHER, OURS])
        self.assertEqual(pcscreen.find_window(), 0x1001)

    def test_pid_not_found_returns_none_no_fallback(self):
        """找不到本轮 PID 时必须返回 None，绝不退回别的 mGBA（假 FAIL 根因）。"""
        self._inject([OTHER, OURS])
        self.assertIsNone(pcscreen.find_window(pid=99999))
        self.assertEqual(pcscreen.find_window_info(pid=99999), (None, None, None))

    def test_title_contains_fallback_when_no_pid(self):
        """无 PID 时用标题里的版本/ROM 标识兜底。"""
        self._inject([OTHER, OURS])
        self.assertEqual(pcscreen.find_window(title_contains="0.11-10027"), 0x2002)

    def test_pid_and_title_combined(self):
        """title_contains 可与 pid 叠加做双重校验。"""
        self._inject([OTHER, OURS])
        self.assertEqual(
            pcscreen.find_window(pid=OUR_PID, title_contains="0.11-10027"), 0x2002)
        self.assertIsNone(
            pcscreen.find_window(pid=OUR_PID, title_contains="0.11-9601"))

    def test_non_mgba_window_never_selected_by_pid(self):
        """请求本轮 PID 时，无关窗口（不同 PID / 非 mGBA）一律被跳过。"""
        self._inject([NOT_MGBA, OTHER, OURS])
        self.assertEqual(pcscreen.find_window(pid=OUR_PID), 0x2002)
        # 旧行为（无 pid）按 tasklist 的 mGBA PID 集合过滤，非 mGBA 窗口(40000)不在集合里
        self.assertNotEqual(pcscreen.find_window(), 0x3003)
        self.assertEqual(pcscreen.find_window(), 0x1001)

    def test_bad_pid_falls_back_to_legacy(self):
        """pid 非法时退化为旧行为，不报错。"""
        self._inject([OTHER, OURS])
        self.assertEqual(pcscreen.find_window(pid="not-an-int"), 0x1001)


if __name__ == "__main__":
    unittest.main(verbosity=2)
