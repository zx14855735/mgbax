package com.bytedance.adsdk.xj.xj.xj;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class kd {
    int c;
    int kd;
    int u;
    int y;

    public void hf(com.bytedance.adsdk.xj.xj.hf.xj xjVar) {
        int u = xjVar.u();
        xj(xjVar);
        int u2 = u - xjVar.u();
        int i = this.u;
        if (u2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (u2 < i) {
            xjVar.xj(i - u2);
        }
    }

    public void xj(com.bytedance.adsdk.xj.xj.hf.xj xjVar) {
    }

    public static int xj(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }
}
