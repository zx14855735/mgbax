package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.m;
import com.bytedance.embedapplog.tf;
import com.bytedance.embedapplog.zg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class qf implements m {
    private xv<Boolean> hf;
    private final m xj;

    public qf() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[Catch: Exception -> 0x0052, TryCatch #1 {Exception -> 0x0052, blocks: (B:11:0x0028, B:13:0x0030, B:15:0x003c, B:17:0x0054), top: B:10:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String w(android.content.Context r8) {
        /*
            r7 = this;
            r0 = 0
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch: java.lang.Exception -> L14
            java.lang.String r8 = r8.getPackageName()     // Catch: java.lang.Exception -> L14
            r2 = 64
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r2)     // Catch: java.lang.Exception -> L14
            if (r8 == 0) goto L16
            android.content.pm.Signature[] r8 = r8.signatures     // Catch: java.lang.Exception -> L14
            goto L1c
        L14:
            r8 = move-exception
            goto L18
        L16:
            r8 = r0
            goto L1c
        L18:
            com.bytedance.embedapplog.cu.xj(r8)
            goto L16
        L1c:
            if (r8 == 0) goto L5c
            int r1 = r8.length
            if (r1 <= 0) goto L5c
            r1 = 0
            r8 = r8[r1]
            byte[] r8 = r8.toByteArray()
            java.lang.String r2 = "SHA1"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Exception -> L52
            if (r2 == 0) goto L5c
            byte[] r8 = r2.digest(r8)     // Catch: java.lang.Exception -> L52
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L52
            r2.<init>()     // Catch: java.lang.Exception -> L52
            int r3 = r8.length     // Catch: java.lang.Exception -> L52
        L3a:
            if (r1 >= r3) goto L54
            r4 = r8[r1]     // Catch: java.lang.Exception -> L52
            r4 = r4 & 255(0xff, float:3.57E-43)
            r4 = r4 | 256(0x100, float:3.59E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch: java.lang.Exception -> L52
            r5 = 3
            r6 = 1
            java.lang.String r4 = r4.substring(r6, r5)     // Catch: java.lang.Exception -> L52
            r2.append(r4)     // Catch: java.lang.Exception -> L52
            int r1 = r1 + 1
            goto L3a
        L52:
            r8 = move-exception
            goto L59
        L54:
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Exception -> L52
            return r8
        L59:
            com.bytedance.embedapplog.cu.xj(r8)
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.qf.w(android.content.Context):java.lang.String");
    }

    @Override // com.bytedance.embedapplog.m
    public m.xj hf(final Context context) {
        if (this.xj != null && !this.hf.hf(new Object[0]).booleanValue()) {
            return this.xj.hf(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new tf(context, intent, new tf.hf<zg, String>() { // from class: com.bytedance.embedapplog.qf.2
            @Override // com.bytedance.embedapplog.tf.hf
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public zg xj(IBinder iBinder) {
                return zg.xj.xj(iBinder);
            }

            @Override // com.bytedance.embedapplog.tf.hf
            public String xj(zg zgVar) {
                if (zgVar == null) {
                    return null;
                }
                String w = qf.this.w(context);
                if (TextUtils.isEmpty(w)) {
                    return null;
                }
                return zgVar.xj(context.getPackageName(), w, "OUID");
            }
        }).xj();
        m.xj xjVar = new m.xj();
        xjVar.hf = str;
        return xjVar;
    }

    public qf(m mVar) {
        this.hf = new xv<Boolean>() { // from class: com.bytedance.embedapplog.qf.1
            @Override // com.bytedance.embedapplog.xv
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public Boolean xj(Object... objArr) {
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    cu.xj(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.xj = mVar;
    }

    @Override // com.bytedance.embedapplog.m
    public boolean xj(Context context) {
        if (context == null) {
            return false;
        }
        Boolean hf = this.hf.hf(context);
        return (this.xj == null || hf.booleanValue()) ? hf.booleanValue() : this.xj.xj(context);
    }
}
