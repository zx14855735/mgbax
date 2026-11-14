package com.octopus.ad.utils.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.octopus.ad.utils.a.a.a.g.a.a.a;
import com.octopus.ad.utils.a.b.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12682a;
    private String b;

    public f(Context context) {
        this.f12682a = context;
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        Context context = this.f12682a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
                return true;
            }
            if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
                return true;
            }
            this.b = "com.huawei.hms";
            return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        Context context = this.f12682a;
        if (context == null || cVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    com.octopus.ad.utils.a.f.a("Get oaid from global settings: " + string);
                    cVar.a(string);
                    return;
                }
            } catch (Exception e) {
                com.octopus.ad.utils.a.f.a(e);
            }
        }
        if (TextUtils.isEmpty(this.b) && !a()) {
            cVar.a(new com.octopus.ad.utils.a.e("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        l.a(this.f12682a, intent, cVar, new l.a() { // from class: com.octopus.ad.utils.a.b.f.1
            @Override // com.octopus.ad.utils.a.b.l.a
            public String a(IBinder iBinder) {
                com.octopus.ad.utils.a.a.a.g.a.a.a a2 = a.AbstractBinderC0438a.a(iBinder);
                if (a2.b()) {
                    throw new com.octopus.ad.utils.a.e("User has disabled advertising identifier");
                }
                return a2.a();
            }
        });
    }
}
