package com.octopus.ad.utils.a.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.octopus.ad.utils.a.a.a.d.a.a;
import com.octopus.ad.utils.a.b.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12677a;

    public b(Context context) {
        if (context instanceof Application) {
            this.f12677a = context;
        } else {
            this.f12677a = context.getApplicationContext();
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        Context context = this.f12677a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12677a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        l.a(this.f12677a, intent, cVar, new l.a() { // from class: com.octopus.ad.utils.a.b.b.1
            @Override // com.octopus.ad.utils.a.b.l.a
            public String a(IBinder iBinder) {
                com.octopus.ad.utils.a.a.a.d.a.a a2 = a.AbstractBinderC0432a.a(iBinder);
                if (a2 != null) {
                    return a2.b(b.this.f12677a.getPackageName());
                }
                throw new com.octopus.ad.utils.a.e("IDeviceIdManager is null");
            }
        });
    }
}
