package com.bytedance.adsdk.hf.hf.w.xj;

import java.util.Deque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends y {
    @Override // com.bytedance.adsdk.hf.hf.w.xj.y
    public int xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque, com.bytedance.adsdk.hf.hf.w.xj xjVar) {
        char xj;
        int i2 = i;
        while (true) {
            xj = xj(i2, str);
            if (!com.bytedance.adsdk.hf.hf.kd.xj.hf(xj) && !com.bytedance.adsdk.hf.hf.kd.xj.w(xj)) {
                break;
            }
            i2++;
        }
        if (xj != '(') {
            return xjVar.xj(str, i, deque);
        }
        deque.push(new com.bytedance.adsdk.hf.hf.hf.xj.tf(str.substring(i, i2)));
        return i2 + 1;
    }
}
