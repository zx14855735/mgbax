package com.octopus.ad.b.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.octopus.ad.b.h.c;
import com.octopus.ad.b.h.g;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public c f12369a = null;
    public String b = null;
    public String c = null;
    public Object d = new Object();
    public ServiceConnection e = new d(this);

    /* renamed from: com.octopus.ad.b.h.a$a, reason: collision with other inner class name */
    public static class C0402a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f12371a = new a(null);

        static {
            hdVFMiV();
        }

        private static /* synthetic */ void hdVFMiV() {
            char[] charArray = "\u0019\u0015\u0017T\u001d\u001b\u0017\u001fT\u0018\u0015\u0003T\t\u0012\u001f\u0016\u0016T0\u0014\u00138\b\u0013\u001e\u001d\u001f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'z');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0019\u0016\u0013\u0014\u0013\u000e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'z');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public a(d dVar) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if (r7.versionCode >= 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 0
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L26
            java.lang.String r1 = "com.heytap.openid"
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r1, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L26
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L26
            r2 = 28
            r3 = 1
            if (r1 < r2) goto L1f
            if (r7 == 0) goto L26
            long r1 = I3HV03.ADYaiT.ADYaiT(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L26
            r4 = 1
            int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r7 < 0) goto L26
            goto L25
        L1f:
            if (r7 == 0) goto L26
            int r7 = r7.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L26
            if (r7 < r3) goto L26
        L25:
            return r3
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.b.h.a.a(android.content.Context):boolean");
    }

    public synchronized String b(Context context, String str) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot run on MainThread");
            }
            if (this.f12369a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.e, 1)) {
                    synchronized (this.d) {
                        try {
                            this.d.wait(3000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.f12369a == null) {
                    return "";
                }
            }
            return a(context, str);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String a(Context context, String str) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        String str2 = null;
        if (TextUtils.isEmpty(this.c)) {
            this.c = new g(new g.a() { // from class: com.octopus.ad.b.h.a.1
                @Override // com.octopus.ad.b.h.g.a
                public String a(String str3, String str4, String str5) {
                    return str4;
                }
            }).a(context, null);
        }
        try {
            str2 = ((c.a.C0403a) this.f12369a).a(this.b, this.c, str);
        } catch (RemoteException unused) {
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
