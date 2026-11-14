package com.bytedance.adsdk.hf.hf.w.xj;

import com.bytedance.adsdk.hf.hf.hf.xj.ht;
import java.util.Deque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends y {
    @Override // com.bytedance.adsdk.hf.hf.w.xj.y
    public int xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque, com.bytedance.adsdk.hf.hf.w.xj xjVar) {
        char xj = xj(i, str);
        return (com.bytedance.adsdk.hf.hf.kd.xj.hf(xj) || xj == '$') ? xj(str, i, deque) : xjVar.xj(str, i, deque);
    }

    private int xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char xj = xj(i2, str);
            if (!com.bytedance.adsdk.hf.hf.kd.xj.hf(xj) && !com.bytedance.adsdk.hf.hf.kd.xj.w(xj) && '.' != xj && '[' != xj && ']' != xj && '_' != xj && '-' != xj && '$' != xj) {
                break;
            }
            i3++;
        }
        String substring = str.substring(i, i2);
        if (com.bytedance.adsdk.hf.hf.u.xj.xj(substring) != null) {
            deque.push(new com.bytedance.adsdk.hf.hf.hf.xj.c(substring));
            return i2;
        }
        deque.push(new ht(substring));
        return i2;
    }
}
