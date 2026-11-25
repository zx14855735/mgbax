# -*- coding: utf-8 -*-
r"""预测回滚算法独立模拟器（纯 Python，零编译器依赖，父会话 2026-11-25）。

用途：编译链全阻断（EDR 拦 MinGW / 无 MSVC / NDK clang 不兼容）时，用 Python 独立
复现 R2-PREDSTATEFUL-JUDGE 的四断言 + E4-N4-BUDGET 的 N4 预算，针对实测真实 RTT 重算
架构 A（预测-回滚）是否能让"帧率=单机 + party 正确交叉"。

这不是 C 侧自测的替代——它验证的是算法层可行性（抽象模型），非真 SIO 字、非翻门。
门 FAIL/0/9/CROSSED 一分不动。

用法：
  python tools/pred_rollback_sim.py --rtt-ms 500 --frames 120 --predict-acc 0.999
"""
import argparse, json

FRAME_MS = 16.7
BEATS_PER_FRAME = 9
# I1 复核修正：C4§3/E4§2 的 0.5-1ms 是 per-frame 重放1帧成本，不是 per-beat！
# 原脚本误当 per-beat，×9 高估 6.75-13.5×。改为 per-frame。
REPLAY_MS_PER_FRAME = 0.75   # 重放1帧成本静态估计（C4 0.5-1ms，非实测）


def simulate(rtt_ms, frames, predict_acc, seed=1, forced_diverge=3, party_stall=True):
    """抽象预测回滚：本地立即推进(预测字)，真字到达后校验，分歧则回滚重放。

    forced_diverge: 强制注入的分歧数（0=纯精度/1=单次/3=保守burst；独立场景）。
    party_stall: E4 §4 红线——party 160B 不能预测，须等真字，一次性停顿=RTT。
    """
    import random
    random.seed(seed)
    frame_window = rtt_ms / FRAME_MS              # RTT 窗=多少帧
    beat_window = frame_window * BEATS_PER_FRAME  # RTT 窗=多少 SIO 拍
    divergences = 0
    total_replay_frames = 0
    max_burst_replay_ms = 0
    frame_times = []
    # I1 复核：forced_diverge 作为独立场景参数（0=纯精度, 1=单次, 3=保守burst）。
    forced = set(int((i + 1) * frames / (forced_diverge + 1)) for i in range(forced_diverge))
    for f in range(frames):
        diverged = (f in forced) or (random.random() > predict_acc)
        frame_ms = FRAME_MS
        if diverged:
            divergences += 1
            # 重放整个 RTT 窗 = frame_window 帧 × 每帧 0.75ms（I1 单位修正）
            replay_frames = frame_window
            replay_ms = replay_frames * REPLAY_MS_PER_FRAME
            total_replay_frames += replay_frames
            max_burst_replay_ms = max(max_burst_replay_ms, replay_ms)
            frame_ms += replay_ms
        # party 一次性停顿（红线：不可预测）——单独记 burst，不淡化为 RTT/frames
        if party_stall and f == 0:
            frame_ms += rtt_ms
        frame_times.append(frame_ms)
    avg_frame = sum(frame_times) / len(frame_times)   # 含 party 均摊
    max_frame = max(frame_times)
    # 拆分判据：纯 replay burst（不含 party）vs party 单次冻结
    replay_only_avg = FRAME_MS + (total_replay_frames * REPLAY_MS_PER_FRAME) / frames
    return {
        "rtt_ms": rtt_ms,
        "frame_window": round(frame_window, 2),
        "beat_window": round(beat_window, 1),
        "frames": frames,
        "predict_acc": predict_acc,
        "forced_diverge": forced_diverge,
        "divergences": divergences,
        "total_replay_frames": round(total_replay_frames, 1),
        "replay_only_avg_ms": round(replay_only_avg, 2),
        "max_replay_burst_ms": round(max_burst_replay_ms, 2),
        "party_stall_ms": rtt_ms if party_stall else 0,
        "avg_frame_ms_incl_party": round(avg_frame, 2),
        "max_frame_ms": round(max_frame, 2),
        "frame_budget_ms": FRAME_MS,
        "replay_avg_ok": replay_only_avg <= FRAME_MS * 1.05,
        "replay_burst_ok": max_burst_replay_ms <= FRAME_MS * 1.05,
    }


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--rtt-ms", type=float, default=500, help="实测 RTT（mode A ~500ms）")
    ap.add_argument("--frames", type=int, default=120)
    ap.add_argument("--predict-acc", type=float, default=0.999)
    a = ap.parse_args()

    print("=" * 76)
    print("预测回滚 N4 可行性独立模拟（I1 单位修正版，纯算法，非真 SIO，非翻门）")
    print("=" * 76)
    print("每 RTT 分三场景：forced=0(纯精度) / 1(单次burst) / 3(保守burst)，acc=0.999")
    for rtt in [46, 500, 1792]:
        for forced in [0, 1, 3]:
            r = simulate(rtt, a.frames, 0.999, forced_diverge=forced)
            atag = "OK" if r["replay_avg_ok"] else "FAIL"
            btag = "OK" if r["replay_burst_ok"] else "FAIL"
            print("RTT=%4dms forced=%d | 窗=%6.1f拍 | 分歧=%2d | replay_avg=%6.2fms[%s] "
                  "replay_burst=%7.2fms[%s] party_stall=%dms" %
                  (rtt, forced, r["beat_window"], r["divergences"],
                   r["replay_only_avg_ms"], atag, r["max_replay_burst_ms"], btag,
                   r["party_stall_ms"]))
    print("=" * 76)
    print("判据：N4 需 replay_avg + replay_burst 都 ≤16.7ms；party_stall 是不可预测真字硬停顿。")
    print("I1 复核修正：①0.75ms 是 per-frame 非 per-beat(原高估6.75x) ②forced独立场景 ③party单列")
    print("诚实：抽象模型，0.75ms/帧静态估计非实测；不证真SIO/party交叉/翻门。门FAIL/0/9/CROSSED不动。")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
