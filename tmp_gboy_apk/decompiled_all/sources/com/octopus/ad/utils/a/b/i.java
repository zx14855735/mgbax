package com.octopus.ad.utils.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.octopus.ad.utils.a.a.a.c.a.a;
import com.octopus.ad.utils.a.b.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12687a;

    public i(Context context) {
        this.f12687a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f12687a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f12687a.startService(intent);
            } else {
                this.f12687a.startForegroundService(intent);
            }
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        Context context = this.f12687a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12687a == null || cVar == null) {
            return;
        }
        b();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.f12687a.getPackageName());
        l.a(this.f12687a, intent, cVar, new l.a() { // from class: com.octopus.ad.utils.a.b.i.1
            @Override // com.octopus.ad.utils.a.b.l.a
            public String a(IBinder iBinder) {
                com.octopus.ad.utils.a.a.a.c.a.a a2 = a.AbstractBinderC0430a.a(iBinder);
                if (a2 == null) {
                    throw new com.octopus.ad.utils.a.e("MsaIdInterface is null");
                }
                if (a2.a()) {
                    return a2.c();
                }
                throw new com.octopus.ad.utils.a.e("MsaIdInterface#isSupported return false");
            }
        });
    }
}
