package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.ht;
import com.ss.android.download.api.config.jk;
import com.ss.android.download.api.config.yo;
import com.ss.android.download.api.config.zg;
import com.ss.android.download.api.model.xj;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class pl {
    private static zg am;
    private static com.ss.android.download.api.config.d c;
    private static com.ss.android.download.api.model.xj d;
    private static com.ss.android.download.api.config.qt e;
    private static com.ss.android.download.api.config.p f;
    private static com.ss.android.download.api.config.kd g;
    private static Context hf;
    private static jk ht;
    private static com.ss.android.download.api.hf.xj jk;
    private static com.ss.android.download.api.config.g kd;
    private static com.ss.android.socialbase.appdownloader.w.d p;

    /* renamed from: pl, reason: collision with root package name */
    private static com.ss.android.download.api.config.u f13834pl;
    private static yo pz;
    private static com.ss.android.download.api.config.pl qt;
    private static com.ss.android.download.api.config.tf ra;
    private static com.ss.android.download.api.config.hf tf;
    private static com.ss.android.download.api.config.w u;
    private static e v;
    private static com.ss.android.download.api.config.c w;
    public static final JSONObject xj = new JSONObject();
    private static com.ss.android.download.api.config.f y;
    private static com.ss.android.download.api.config.am yo;
    private static ht zg;

    static {
        BjyvF();
    }

    private static /* synthetic */ void BjyvF() {
        char[] charArray = "r~|?vp|t?s~h?byt}}?[\u007fxScxuvt".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 17);
        }
        String str = new String(charArray);
        char[] charArray2 = "r}x\u007fxe".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 17);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String am() {
        return "1.7.0";
    }

    public static zg c() {
        return am;
    }

    public static JSONObject d() {
        com.ss.android.download.api.config.p pVar = f;
        return (pVar == null || pVar.xj() == null) ? xj : f.xj();
    }

    public static boolean dk() {
        return (w == null || y == null || f == null || tf == null || pz == null) ? false : true;
    }

    public static com.ss.android.download.api.config.pl e() {
        return qt;
    }

    public static e f() {
        if (v == null) {
            v = new e() { // from class: com.ss.android.downloadlib.addownload.pl.3
            };
        }
        return v;
    }

    public static com.ss.android.download.api.config.qt g() {
        return e;
    }

    public static Context getContext() {
        Context context = hf;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void hf(Context context) {
        if (hf != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        hf = context.getApplicationContext();
    }

    public static com.ss.android.download.api.config.tf ht() {
        return ra;
    }

    public static com.ss.android.download.api.hf.xj jk() {
        if (jk == null) {
            jk = new com.ss.android.download.api.hf.xj() { // from class: com.ss.android.downloadlib.addownload.pl.4
                @Override // com.ss.android.download.api.hf.xj
                public void xj(Throwable th, String str) {
                }
            };
        }
        return jk;
    }

    public static com.ss.android.download.api.config.d kd() {
        if (c == null) {
            c = new com.ss.android.download.api.xj.hf();
        }
        return c;
    }

    public static com.ss.android.download.api.config.am p() {
        return yo;
    }

    public static com.ss.android.download.api.config.hf pl() {
        return tf;
    }

    public static jk pz() {
        if (ht == null) {
            ht = new jk() { // from class: com.ss.android.downloadlib.addownload.pl.5
            };
        }
        return ht;
    }

    public static com.ss.android.download.api.config.u qt() {
        return f13834pl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r0 > 29) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r1 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        return getContext().getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String ra() {
        /*
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L52
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: java.lang.Throwable -> L52
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Throwable -> L52
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L52
            r2 = 29
            if (r1 < r2) goto L29
            if (r0 != r2) goto L18
            boolean r1 = DaOi9o.COJEAR.BIYEnU()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L1a
        L18:
            if (r0 <= r2) goto L29
        L1a:
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L52
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L52
            return r0
        L29:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r0.<init>()     // Catch: java.lang.Throwable -> L52
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            org.json.JSONObject r1 = d()     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "default_save_dir_name"
            java.lang.String r3 = "ByteDownload"
            java.lang.String r1 = r1.optString(r2, r3)     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52
            return r0
        L52:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.pl.ra():java.lang.String");
    }

    public static com.ss.android.download.api.model.xj tf() {
        if (d == null) {
            d = new xj.C0465xj().xj();
        }
        return d;
    }

    public static com.ss.android.download.api.config.f u() {
        return y;
    }

    public static ht v() {
        return zg;
    }

    public static com.ss.android.download.api.config.g w() {
        if (kd == null) {
            kd = new com.ss.android.download.api.xj.xj();
        }
        return kd;
    }

    public static void xj(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        hf = context.getApplicationContext();
    }

    public static com.ss.android.socialbase.appdownloader.w.d y() {
        if (p == null) {
            p = new com.ss.android.socialbase.appdownloader.w.d() { // from class: com.ss.android.downloadlib.addownload.pl.2
                @Override // com.ss.android.socialbase.appdownloader.w.d
                public void xj(DownloadInfo downloadInfo, BaseException baseException, int i) {
                }
            };
        }
        return p;
    }

    public static yo yo() {
        return pz;
    }

    public static com.ss.android.download.api.config.kd zg() {
        return g;
    }

    public static com.ss.android.download.api.config.w hf() {
        if (u == null) {
            u = new com.ss.android.download.api.config.w() { // from class: com.ss.android.downloadlib.addownload.pl.1
            };
        }
        return u;
    }

    public static void xj(com.ss.android.download.api.config.c cVar) {
        w = cVar;
    }

    public static void xj(com.ss.android.download.api.config.g gVar) {
        kd = gVar;
    }

    public static void xj(com.ss.android.download.api.config.f fVar) {
        y = fVar;
    }

    public static void xj(com.ss.android.download.api.config.d dVar) {
        c = dVar;
    }

    public static void xj(com.ss.android.download.api.config.p pVar) {
        f = pVar;
    }

    public static void xj(com.ss.android.download.api.model.xj xjVar) {
        d = xjVar;
    }

    public static void xj(com.ss.android.download.api.config.hf hfVar) {
        tf = hfVar;
    }

    public static com.ss.android.download.api.config.c xj() {
        return w;
    }

    public static void xj(String str) {
        com.ss.android.socialbase.appdownloader.u.p().xj(str);
    }

    public static void xj(com.ss.android.socialbase.appdownloader.w.w wVar) {
        com.ss.android.socialbase.appdownloader.u.p().xj(wVar);
    }

    public static void xj(yo yoVar) {
        pz = yoVar;
    }

    public static void xj(com.ss.android.download.api.hf.xj xjVar) {
        jk = xjVar;
    }

    public static void xj(com.ss.android.download.api.config.tf tfVar) {
        ra = tfVar;
    }
}
