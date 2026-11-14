package com.bytedance.adsdk.hf.hf.w.xj;

import java.util.Deque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class y {
    public int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char xj = xj(i3, str);
            if (!com.bytedance.adsdk.hf.hf.kd.xj.hf(xj) && !com.bytedance.adsdk.hf.hf.kd.xj.w(xj)) {
                return i3;
            }
            i2++;
        }
    }

    public int hf(int i, String str) {
        while (com.bytedance.adsdk.hf.hf.kd.xj.xj(xj(i, str))) {
            i++;
        }
        return i;
    }

    public char xj(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    public abstract int xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque, com.bytedance.adsdk.hf.hf.w.xj xjVar);
}
