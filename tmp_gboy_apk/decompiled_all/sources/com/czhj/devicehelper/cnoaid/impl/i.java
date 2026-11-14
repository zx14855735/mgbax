package com.czhj.devicehelper.cnoaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.czhj.devicehelper.cnoaid.com.zui.deviceidservice.IDeviceidInterface;
import com.czhj.devicehelper.cnoaid.impl.n;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class i implements com.czhj.devicehelper.cnoaid.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10508a;

    public i(Context context) {
        this.f10508a = context;
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f10508a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        n.a(this.f10508a, intent, cVar, new n.a() { // from class: com.czhj.devicehelper.cnoaid.impl.i.1
            @Override // com.czhj.devicehelper.cnoaid.impl.n.a
            public String a(IBinder iBinder) {
                IDeviceidInterface asInterface = IDeviceidInterface.Stub.asInterface(iBinder);
                if (asInterface == null) {
                    throw new com.czhj.devicehelper.cnoaid.f("IDeviceidInterface is null");
                }
                if (asInterface.isSupport()) {
                    return asInterface.getOAID();
                }
                throw new com.czhj.devicehelper.cnoaid.f("IDeviceidInterface#isSupport return false");
            }
        });
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        Context context = this.f10508a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
            return false;
        }
    }
}
