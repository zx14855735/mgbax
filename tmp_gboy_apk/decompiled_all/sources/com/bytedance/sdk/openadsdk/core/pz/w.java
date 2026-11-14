package com.bytedance.sdk.openadsdk.core.pz;

import android.content.Context;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.am.f;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private com.bytedance.sdk.openadsdk.am.xj hf;
    private f xj;

    public f xj(Context context, SSWebView sSWebView, com.bytedance.sdk.openadsdk.am.w wVar, com.bytedance.sdk.openadsdk.am.xj xjVar, Set<String> set, f.xj xjVar2) {
        com.bytedance.sdk.openadsdk.am.xj xjVar3;
        if (this.xj == null) {
            xjVar3 = xjVar;
            f xj = f.xj(context, sSWebView, wVar, xjVar3, set, xjVar2, true);
            this.xj = xj;
            xj.u(false);
        } else {
            xjVar3 = xjVar;
        }
        this.hf = xjVar3;
        return this.xj;
    }
}
