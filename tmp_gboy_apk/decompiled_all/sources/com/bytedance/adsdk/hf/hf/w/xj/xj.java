package com.bytedance.adsdk.hf.hf.w.xj;

import com.bytedance.adsdk.hf.hf.hf.xj.pz;
import java.util.Deque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends y {
    @Override // com.bytedance.adsdk.hf.hf.w.xj.y
    public int xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque, com.bytedance.adsdk.hf.hf.w.xj xjVar) {
        if (',' != xj(i, str)) {
            return xjVar.xj(str, i, deque);
        }
        deque.push(new pz(com.bytedance.adsdk.hf.hf.u.u.COMMA));
        return i + 1;
    }
}
