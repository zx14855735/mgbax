package com.bytedance.sdk.openadsdk.core.pl.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.pl.hf.u;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf implements com.bytedance.sdk.openadsdk.core.pl.hf.u {

    /* renamed from: io, reason: collision with root package name */
    private u.xj f10390io;

    public xj(Context context, ws wsVar, String str, boolean z) {
        super(context, wsVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd, com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void hf() {
        super.hf();
        this.f10390io = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.u
    public void xj(u.xj xjVar) {
        this.f10390io = xjVar;
    }
}
