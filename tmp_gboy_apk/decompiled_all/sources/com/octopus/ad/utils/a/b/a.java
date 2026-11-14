package com.octopus.ad.utils.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.octopus.ad.utils.a.a.a.b.a.a.a;
import com.octopus.ad.utils.a.b.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12675a;

    public a(Context context) {
        this.f12675a = context;
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        Context context = this.f12675a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12675a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        l.a(this.f12675a, intent, cVar, new l.a() { // from class: com.octopus.ad.utils.a.b.a.1
            @Override // com.octopus.ad.utils.a.b.l.a
            public String a(IBinder iBinder) {
                com.octopus.ad.utils.a.a.a.b.a.a.a a2 = a.AbstractBinderC0428a.a(iBinder);
                if (a2 == null) {
                    throw new com.octopus.ad.utils.a.e("IDidAidlInterface is null");
                }
                if (a2.a()) {
                    return a2.c();
                }
                throw new com.octopus.ad.utils.a.e("IDidAidlInterface#isSupport return false");
            }
        });
    }
}
