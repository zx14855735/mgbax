package com.bytedance.sdk.openadsdk.core.live.u;

import com.bytedance.sdk.openadsdk.core.ht;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public final List<String> hf = new ArrayList();
    public final String xj;

    public xj(String str) {
        this.xj = str;
    }

    public static void xj(String str, String str2) {
        xj xjVar = (xj) ht.xj(str, xj.class);
        if (xjVar != null) {
            xjVar.xj(str2);
            return;
        }
        xj xjVar2 = new xj(str);
        xjVar2.xj(str2);
        ht.xj(str, xjVar2, xj.class);
    }

    public void xj(String str) {
        this.hf.add(str);
    }
}
