package com.bytedance.adsdk.hf.hf.w.xj;

import ADYaiT.CtFAbx;
import com.bytedance.adsdk.hf.hf.hf.xj.zg;
import java.util.Deque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends y {
    @Override // com.bytedance.adsdk.hf.hf.w.xj.y
    public int xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque, com.bytedance.adsdk.hf.hf.w.xj xjVar) {
        if (!com.bytedance.adsdk.hf.hf.kd.xj.u(xj(i, str))) {
            return xjVar.xj(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{xj(i, str), xj(i2, str)});
        if (com.bytedance.adsdk.hf.hf.u.w.xj(str2) != null) {
            deque.push(new zg(com.bytedance.adsdk.hf.hf.u.w.xj(str2)));
            return i + 2;
        }
        String valueOf = String.valueOf(xj(i, str));
        if (com.bytedance.adsdk.hf.hf.u.w.xj(valueOf) != null) {
            deque.push(new zg(com.bytedance.adsdk.hf.hf.u.w.xj(valueOf)));
            return i2;
        }
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Unrecognized:", valueOf, "examine:");
        B3GDIM2.append(str.substring(0, i));
        throw new IllegalArgumentException(B3GDIM2.toString());
    }
}
