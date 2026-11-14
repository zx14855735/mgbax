package com.bytedance.sdk.component.hf.xj.xj.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends pl {

    /* renamed from: pl, reason: collision with root package name */
    public u f10209pl;

    public w(pl.xj xjVar) {
        super(xjVar);
        this.f10209pl = new u();
    }

    @Override // com.bytedance.sdk.component.hf.xj.pl
    public com.bytedance.sdk.component.hf.xj.u xj() {
        return this.f10209pl;
    }

    @Override // com.bytedance.sdk.component.hf.xj.pl
    public com.bytedance.sdk.component.hf.xj.hf xj(am amVar) {
        amVar.xj(this);
        if (amVar.hf() == null || amVar.hf().xj() == null || TextUtils.isEmpty(amVar.hf().xj().toString())) {
            return null;
        }
        return new xj(amVar, this.f10209pl);
    }
}
