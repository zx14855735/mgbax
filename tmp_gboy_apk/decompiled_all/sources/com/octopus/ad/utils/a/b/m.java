package com.octopus.ad.utils.a.b;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.a.a.e.a.a;
import com.octopus.ad.utils.a.b.l;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class m implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12692a;
    private String b;

    public m(Context context) {
        if (context instanceof Application) {
            this.f12692a = context;
        } else {
            this.f12692a = context.getApplicationContext();
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        Context context = this.f12692a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12692a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        l.a(this.f12692a, intent, cVar, new l.a() { // from class: com.octopus.ad.utils.a.b.m.1
            @Override // com.octopus.ad.utils.a.b.l.a
            public String a(IBinder iBinder) {
                try {
                    return m.this.a(iBinder);
                } catch (RemoteException e) {
                    throw e;
                } catch (com.octopus.ad.utils.a.e e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new com.octopus.ad.utils.a.e(e3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public String a(IBinder iBinder) {
        String packageName = this.f12692a.getPackageName();
        String str = this.b;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f12692a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            String sb2 = sb.toString();
            this.b = sb2;
            return a(iBinder, packageName, sb2);
        }
        return a(iBinder, packageName, str);
    }

    private String a(IBinder iBinder, String str, String str2) {
        com.octopus.ad.utils.a.a.a.e.a.a a2 = a.AbstractBinderC0434a.a(iBinder);
        if (a2 != null) {
            return a2.a(str, str2, "OUID");
        }
        throw new com.octopus.ad.utils.a.e("IOpenID is null");
    }
}
