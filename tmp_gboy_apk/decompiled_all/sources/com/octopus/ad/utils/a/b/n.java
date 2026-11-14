package com.octopus.ad.utils.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.octopus.ad.utils.a.a.a.f.a.a.a;
import com.octopus.ad.utils.a.b.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class n implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12694a;

    public n(Context context) {
        this.f12694a = context;
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        Context context = this.f12694a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12694a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        l.a(this.f12694a, intent, cVar, new l.a() { // from class: com.octopus.ad.utils.a.b.n.1
            @Override // com.octopus.ad.utils.a.b.l.a
            public String a(IBinder iBinder) {
                com.octopus.ad.utils.a.a.a.f.a.a.a a2 = a.AbstractBinderC0436a.a(iBinder);
                if (a2 != null) {
                    return a2.a();
                }
                throw new com.octopus.ad.utils.a.e("IDeviceIdService is null");
            }
        });
    }
}
