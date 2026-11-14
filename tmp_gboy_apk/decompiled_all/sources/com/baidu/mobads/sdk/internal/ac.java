package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.cb;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ac implements cb.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f9728a;

    public ac(aa aaVar) {
        this.f9728a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cb.c
    public void a(boolean z) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z) {
            try {
                cb cbVar = g.f9837a;
                if (cbVar != null) {
                    this.f9728a.b = cbVar.i();
                    iXAdContainerFactory = this.f9728a.b;
                    if (iXAdContainerFactory != null) {
                        this.f9728a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f9728a.a("加载dex异常");
                return;
            }
        }
        g.f9837a = null;
        this.f9728a.a("加载dex失败");
    }
}
