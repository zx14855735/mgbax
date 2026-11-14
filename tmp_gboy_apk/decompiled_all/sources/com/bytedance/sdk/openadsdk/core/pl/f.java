package com.bytedance.sdk.openadsdk.core.pl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    public static com.bytedance.sdk.openadsdk.core.pl.hf.u hf(Context context, ws wsVar, String str, boolean z) {
        return wo.hf(context) ? new com.bytedance.sdk.openadsdk.core.pl.w.u(context, wsVar, str, z) : new com.bytedance.sdk.openadsdk.core.pl.w.xj(context, wsVar, str, z);
    }

    public static com.bytedance.sdk.openadsdk.core.pl.hf.w xj(Context context, ws wsVar, String str, boolean z) {
        return new com.bytedance.sdk.openadsdk.core.pl.w.c(context, wsVar, str, z);
    }

    public static com.bytedance.sdk.openadsdk.core.pl.hf.w xj(Context context, String str, ws wsVar, String str2) {
        return new com.bytedance.sdk.openadsdk.core.pl.w.d(context, str, wsVar, str2, wo.ht(wsVar));
    }
}
