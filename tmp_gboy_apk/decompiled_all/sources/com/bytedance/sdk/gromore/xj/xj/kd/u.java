package com.bytedance.sdk.gromore.xj.xj.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static void xj(com.bytedance.msdk.api.w.xj xjVar, String str) {
        com.bytedance.msdk.xj.kd.w.hf("TMe_reward", "RewardUtils  ".concat(String.valueOf(str)));
        if (xjVar == null) {
            com.bytedance.msdk.xj.kd.w.hf("TMe_reward", "rewardItem is null ");
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf("TMe_reward", "rewardItem.getRewardName " + xjVar.w());
        com.bytedance.msdk.xj.kd.w.hf("TMe_reward", "rewardItem.getAmount " + xjVar.hf());
        com.bytedance.msdk.xj.kd.w.hf("TMe_reward", "rewardItem.getCustomData() " + xjVar.u());
        com.bytedance.msdk.xj.kd.w.hf("TMe_reward", "rewardItem.rewardVerify() " + xjVar.xj());
    }
}
