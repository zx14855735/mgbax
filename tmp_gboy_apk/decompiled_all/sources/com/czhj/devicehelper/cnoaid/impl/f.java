package com.czhj.devicehelper.cnoaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.czhj.devicehelper.cnoaid.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import com.czhj.devicehelper.cnoaid.impl.n;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class f implements com.czhj.devicehelper.cnoaid.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10496a;

    public f(Context context) {
        this.f10496a = context;
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f10496a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        n.a(this.f10496a, intent, cVar, new n.a() { // from class: com.czhj.devicehelper.cnoaid.impl.f.1
            @Override // com.czhj.devicehelper.cnoaid.impl.n.a
            public String a(IBinder iBinder) {
                IAdvertisingIdService asInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
                if (asInterface.isLimitAdTrackingEnabled(true)) {
                    com.czhj.devicehelper.cnoaid.g.a("User has disabled advertising identifier");
                }
                return asInterface.getId();
            }
        });
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        Context context = this.f10496a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
            return false;
        }
    }
}
