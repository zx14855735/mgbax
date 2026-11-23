# -*- coding: utf-8 -*-
"""
context_checkpoint.py — 上下文检查点生成器（用户工作流：上下文临近上限时先总结再续）

边界（诚实）：真实对话 token 计数/清零由 harness 管理，本脚本无法直接清零上下文。
它实现的是「状态外置检查点」：把当前全部关键状态固化为一份紧凑快照，后续新会话
（干净上下文）读取本文件即可恢复，等价于逻辑上的上下文清零 —— 不必携带本轮全部历史。

用法：
  python tools/context_checkpoint.py                 # 生成 .zcode-tmp/CONTEXT-CHECKPOINT.md
  python tools/context_checkpoint.py --estimate      # 额外打印体量估算(代理指标)
  python tools/context_checkpoint.py --out <path>    # 自定义输出
"""
import argparse
import datetime
import glob
import os
import subprocess

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

# 门状态：固定不变量，任何检查点都原样写入，不随进度变化
GATE = "FAIL / 对手真实性 0/9 / 零注入 CROSSED（APP 0006↔PC 00D5）从未产出；选 A=立项非翻门"

# 关键成果文件（存在即摘要其首行/关键结论）
KEY_FILES = [
    "FINAL-VERDICT-2026-11-23.md",
    "PHASE0-CLOSEOUT.md",
    "ARCH-PILOT-BRIEF.md",
    "ARCH-MIDCOURSE-N4-FINDING.md",
    "PREDROLLBACK-SELTEST-RESULT.md",
    "NETSMOKE-01-RESULT.md",
    "MACRO-NAMING-VERDICT.md",
    "ROOTHUNT2-BATCH1.md",
    "E4-N4-BUDGET.md",
    "F17-SEMANTICS-FINAL.md",
    "F22-USER-DECISION-SUMMARY.md",
    "F12-DELIVERABLES-INDEX.md",
    "FINAL-DELIVERABLES.md",
    "GATE-PHYSICAL-WALL.md",
    "S2-REALE2E-EXEC.md",
]


def sh(cmd, cwd=None):
    r = subprocess.run(cmd, cwd=cwd, capture_output=True, text=True,
                       encoding="utf-8", errors="replace")
    return (r.stdout or "").strip()


def size_estimate():
    """代理指标：统计 .zcode-tmp 报告总字节与文件数（非真实对话 token）。"""
    total = 0
    n = 0
    for p in glob.glob(os.path.join(BASE, ".zcode-tmp", "*.md")):
        try:
            total += os.path.getsize(p)
            n += 1
        except OSError:
            pass
    return n, total


def main():
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--out", default=os.path.join(BASE, ".zcode-tmp", "CONTEXT-CHECKPOINT.md"))
    ap.add_argument("--estimate", action="store_true")
    args = ap.parse_args()

    out = []
    out.append("# 上下文检查点（CONTINUITY CHECKPOINT）")
    out.append("")
    out.append("> 生成时间：%s" % datetime.datetime.now().isoformat(timespec="seconds"))
    out.append("> 用途：上下文临近上限时外置全部关键状态；后续新会话（干净上下文）读本文件即可接续。")
    out.append("> 诚实边界：真实对话 token 计数/清零由 harness 管理，本检查点实现的是逻辑接续，非强制清 token。")
    out.append("")

    out.append("## 0. 门状态（不变量）")
    out.append(GATE)
    out.append("")

    out.append("## 1. git 状态")
    out.append("HEAD=%s" % sh(["git", "rev-parse", "--short", "HEAD"], cwd=BASE))
    out.append("branch=%s" % sh(["git", "rev-parse", "--abbrev-ref", "HEAD"], cwd=BASE))
    log = sh(["git", "log", "--oneline", "-6"], cwd=BASE)
    out.append("recent commits:")
    out.append("```")
    out.append(log)
    out.append("```")
    st = sh(["git", "status", "--short"], cwd=BASE)
    out.append("working tree:")
    out.append("```")
    out.append(st)
    out.append("```")
    out.append("")

    out.append("## 2. 用户方向与当前阶段")
    out.append("- 总目标：悠GBA 三端移植（含音乐倍速不变）+ 联机攻克。")
    out.append("- 联机：用户 2026-11-23 裁决「大改架构」→ 选档1 全量实施 A 预测回滚。")
    out.append("- 最新 ROM 为准（用户明示）：以 gen8 当前 ROM 为准，随时改代码，不乱同步、不替换他人编译的 ROM。")
    out.append("- 工作流脚本：tools/build_netgate_latest.py（独立 worktree 门开重编+冻结+reanchor，写保护拒写 gen8 主树）。")
    out.append("")

    out.append("## 3. 已完成成果（磁盘实测）")
    out.append("- L1 地基：HMAC 9/9、TX tag 真值、tag_ok 函数因果 A-F（双重复核）。")
    out.append("- ROM 产物级：NGLOG-04 冻结判读 PASS、reanchor 真 PASS 18/18。")
    out.append("- 三端编译：PC/Android/iOS 均 PASS（历轮）。")
    out.append("- 档1 L1：sio_cmd_sim.py --predrollback 测试桩 4/4 PASS（已强化：A3 实测帧闭合、A4 关饥饿盲区、replayed 真实计数），commit 6dc8ed6c7。")
    out.append("- 档1 第一批地基：ROOTHUNT2 完成 7 文件（宏/类型/host TX 搬运/裸500修复/三端门面），静态复核 5 项 PASS；编译 bug GNP_PREDICT_MODE→MGBAX_PREDICT_MODE 已修；mgbaMobileRollbackSet 定义已补；GBoyFrames 裸500 已修为 GNP_FRAME_SIZE=532。")
    out.append("- PC 编译 PASS（修复后）；Android 编译因 mgbaMobileRollbackSet 缺定义失败——现已补定义，待重编验证。")
    out.append("- 双远端同步：历轮已推 GitHub/gitee + iOS IPA 最新。")
    out.append("")

    out.append("## 4. 决定性发现（必须继承，不可隐瞒）")
    out.append("- N4 同倍速结构性不可达：cloud relay 1792ms≈107帧≈963 SIO 拍，回滚重放远超 16.7ms 帧预算（E4-N4-BUDGET 量化）。")
    out.append("- party 块字不可预测（猜=造假红线）→ 预测回滚消解不了 CROSSED 关键路径延迟墙（C3）。")
    out.append("- F7 风险总审计 + F13 设计复核 + F17 语义终审 + C13 阶段0裁决一致：全量代码落地也不能翻门，且 N4 破坏用户「同倍速语义不降」裁决。")
    out.append("- F21：§3.6 硬约束下档1框架内无解，须用户重新裁决方向。已备 F22 用户裁决摘要。")
    out.append("- 0 物理真机是零注入 CROSSED 唯一裁决路径的物理硬墙。")
    out.append("")

    out.append("## 5. 在途 / 待办")
    out.append("- 在途：gen8 门开重编（独立 worktree D:\\mgbax-ng8-latest，脱离式 PID 记录于对话）→ 冻结→reanchor→manifest。服务器重启曾中断两次，资源缓存已积累（2608 asset/128.o），增量重编中。")
    out.append("- 待办：编译完成→冻结五件→judge_frozen→reanchor 真PASS→manifest 落盘→三端串行编译（PC 已过/Android 待验证/iOS typecheck）→commit→推送→IPA。")
    out.append("- 待办：判据回归扩 13 用例（E4-JUDGE-EXT）、STALE 四向（E9）、L2 AVD tag_ok 读值（E5）。")
    out.append("- 用户裁决点：是否按 F22 重新裁决方向（继续档1 / 改架构 / 收口）。")
    out.append("")

    out.append("## 6. 关键文件索引（恢复入口）")
    out.append("- 裁决与收口：FINAL-VERDICT-2026-11-23.md / PHASE0-CLOSEOUT.md / F22-USER-DECISION-SUMMARY.md")
    out.append("- 架构方向：C1-ARCH-OPTIONS.md / ARCH-PILOT-BRIEF.md / MACRO-NAMING-VERDICT.md")
    out.append("- 决定性风险：E4-N4-BUDGET.md / F7-MASTER-RISK.md / F13-BATCH2-DESIGN-REVIEW.md / F17-SEMANTICS-FINAL.md / ARCH-MIDCOURSE-N4-FINDING.md")
    out.append("- 实施：ROOTHUNT2-BATCH1.md / F20-BATCH2-DISPATCH.md / tools/build_netgate_latest.py / build_netgate_latest 工作流日志 .zcode-tmp/wt_latest_build.log")
    out.append("- 测试桩：tools/sio_cmd_sim.py / PREDROLLBACK-SELTEST-RESULT.md / F15-HARNESS-WEAKNESS-FIX.md")
    out.append("- 成果总索引：F12-DELIVERABLES-INDEX.md（77 份报告导航）")
    out.append("")

    out.append("## 7. 恢复指引（新会话第一步）")
    out.append("1. 读本文件 + FINAL-VERDICT + PHASE0-CLOSEOUT + F22。")
    out.append("2. 查 git HEAD/status 与编译日志 BUILD_EXIT，确认在途编译是否完成。")
    out.append("3. 遵守纪律：CPU≤70%、单 AVD、账号互斥、结果到达闸门、不造 party/信任位/CROSSED、不碰 gen8 主树 ROM、门 FAIL/0/9 不动。")
    out.append("")

    out.append("## 8. 关键成果文件存在性")
    for k in KEY_FILES:
        p = os.path.join(BASE, ".zcode-tmp", k)
        size = os.path.getsize(p) if os.path.exists(p) else -1
        out.append("- %s : %s" % (k, ("%d B" % size) if size >= 0 else "MISSING"))
    out.append("")

    if args.estimate:
        n, total = size_estimate()
        out.append("## 9. 体量估算（代理指标，非对话 token）")
        out.append("报告文件数=%d 总字节=%d（约 %.1f KB）" % (n, total, total / 1024.0))
        out.append("")

    with open(args.out, "w", encoding="utf-8") as f:
        f.write("\n".join(out))
    print("CHECKPOINT_WRITTEN=%s" % args.out)
    print("bytes=%d" % os.path.getsize(args.out))
    if args.estimate:
        n, total = size_estimate()
        print("report_files=%d total_bytes=%d (proxy only, NOT conversation tokens)" % (n, total))


if __name__ == "__main__":
    main()
