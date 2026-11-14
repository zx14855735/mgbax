package com.bytedance.adsdk.hf.hf.w.xj;

import com.bytedance.adsdk.hf.hf.hf.xj.jk;
import java.util.Deque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends y {
    @Override // com.bytedance.adsdk.hf.hf.w.xj.y
    public int xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque, com.bytedance.adsdk.hf.hf.w.xj xjVar) {
        if ('\'' != xj(i, str)) {
            return xjVar.xj(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && xj(i3, str) != '\'') {
            i3++;
        }
        if (xj(i3, str) != '\'') {
            throw new com.bytedance.adsdk.hf.xj.xj("String expression not surrounded by '", str.substring(i));
        }
        deque.push(new jk(str.substring(i2, i3)));
        return i3 + 1;
    }
}
