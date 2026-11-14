package com.octopus.ad.utils.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.octopus.ad.utils.a.a.a.h.a.a;
import com.octopus.ad.utils.a.b.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12684a;

    public g(Context context) {
        this.f12684a = context;
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        Context context = this.f12684a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12684a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        l.a(this.f12684a, intent, cVar, new l.a() { // from class: com.octopus.ad.utils.a.b.g.1
            @Override // com.octopus.ad.utils.a.b.l.a
            public String a(IBinder iBinder) {
                com.octopus.ad.utils.a.a.a.h.a.a a2 = a.AbstractBinderC0440a.a(iBinder);
                if (a2 == null) {
                    throw new com.octopus.ad.utils.a.e("IDeviceidInterface is null");
                }
                if (a2.c()) {
                    return a2.a();
                }
                throw new com.octopus.ad.utils.a.e("IDeviceidInterface#isSupport return false");
            }
        });
    }
}
