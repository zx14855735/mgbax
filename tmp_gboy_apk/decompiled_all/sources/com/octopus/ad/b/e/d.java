package com.octopus.ad.b.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    private static volatile d e;
    private static boolean f;
    private BroadcastReceiver g;

    /* renamed from: a, reason: collision with root package name */
    b f12364a = new b("udid");
    b b = new b("oaid");
    b c = new b("vaid");
    b d = new b("aaid");
    private e h = new e();

    private d() {
    }

    public static final d a() {
        if (e == null) {
            synchronized (d.class) {
                try {
                    if (e == null) {
                        e = new d();
                    }
                } finally {
                }
            }
        }
        return e;
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private String b(Context context, b bVar) {
        String str = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{bVar.c}, null);
            if (query != null) {
                f a2 = a(query);
                str = a2.f12366a;
                bVar.a(str);
                bVar.a(a2.c);
                bVar.a(a2.b);
                if (a2.b != 1000) {
                    b(context);
                    a(context, false);
                }
            } else {
                a(context, false);
            }
            if (query != null) {
                query.close();
            }
            return str;
        } catch (Exception unused) {
            return str;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static f a(Cursor cursor) {
        f fVar = new f(null, 0);
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                fVar.f12366a = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex(PluginConstants.KEY_ERROR_CODE);
            if (columnIndex2 >= 0) {
                fVar.b = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                fVar.c = cursor.getLong(columnIndex3);
            }
        }
        return fVar;
    }

    private synchronized void b(Context context) {
        if (this.g != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        g gVar = new g();
        this.g = gVar;
        context.registerReceiver(gVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    public final boolean a(Context context, boolean z) {
        if (this.h.a() && !z) {
            return this.h.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String a2 = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String b = b(packageManager, a2);
        if (this.h.a() && this.h.a(b)) {
            return this.h.b();
        }
        this.h.b(b);
        boolean a3 = a(context);
        this.h.a(a3);
        return a3;
    }

    public final String a(Context context, b bVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar.a()) {
            return bVar.b;
        }
        if (a(context, true)) {
            return b(context, bVar);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        if (com.czhj.sdk.common.Constants.FAIL.equals(r8.f12366a) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(android.content.Context r8) {
        /*
            r0 = 0
            r1 = 0
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.lang.String r8 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r3 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.lang.String r8 = "supported"
            java.lang.String[] r6 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            if (r1 != 0) goto L21
            if (r1 == 0) goto L20
            r1.close()
        L20:
            return r0
        L21:
            com.octopus.ad.b.e.f r8 = a(r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            int r2 = r8.b     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r2) goto L3b
            java.lang.String r2 = "0"
            java.lang.String r8 = r8.f12366a     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            boolean r8 = r2.equals(r8)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            if (r8 != 0) goto L3c
            goto L3b
        L36:
            r0 = move-exception
            r8 = r0
            goto L40
        L39:
            goto L46
        L3b:
            r0 = 1
        L3c:
            r1.close()
            return r0
        L40:
            if (r1 == 0) goto L45
            r1.close()
        L45:
            throw r8
        L46:
            if (r1 == 0) goto L4b
            r1.close()
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.b.e.d.a(android.content.Context):boolean");
    }
}
