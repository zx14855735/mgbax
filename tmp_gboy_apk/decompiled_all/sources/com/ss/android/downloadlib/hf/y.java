package com.ss.android.downloadlib.hf;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.xj.xj;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    private static Handler xj = new Handler(Looper.getMainLooper());

    static {
        eoBpLL();
    }

    private static int d(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("app_link_check_delay", 1);
    }

    private static /* synthetic */ void eoBpLL() {
        char[] charArray = "HDF\u0005LJFN\u0005IDR\u0005XCNGG\u0005aEBiYBOLN".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '+');
        }
        String str = new String(charArray);
        char[] charArray2 = "HGBEB_".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '+');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long f(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("app_link_check_timeout", 300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final com.ss.android.downloadad.api.xj.hf hfVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.hf.y.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (!g.w(com.ss.android.downloadad.api.xj.hf.this.kd())) {
                    y.hf(com.ss.android.downloadad.api.xj.hf.this, i - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!com.ss.android.downloadad.api.xj.hf.this.bl()) {
                        i2 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                } catch (JSONException e) {
                    pl.xj(e);
                }
                com.ss.android.downloadlib.u.xj.xj().xj("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.xj.hf.this);
            }
        }, d(hfVar) * 1000);
    }

    public static long kd(com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("app_link_opt_back_time_limit", 3) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int tf(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("app_link_check_count", 10);
    }

    public static boolean u(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).hf("app_link_opt_dialog_switch") == 1;
    }

    public static boolean w(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).hf("app_link_opt_invoke_switch") == 1;
    }

    public static void xj(final com.ss.android.downloadad.api.xj.hf hfVar, final f fVar) {
        boolean hf = com.ss.android.socialbase.downloader.xj.xj.xj().hf();
        if (!hf && Build.VERSION.SDK_INT >= 29) {
            g.w();
        }
        boolean hf2 = com.ss.android.socialbase.downloader.xj.xj.xj().hf();
        boolean z = !hf && hf2;
        if (hfVar != null) {
            hfVar.pl(z);
        }
        fVar.xj(z);
        if (hfVar == null) {
            return;
        }
        hf(hfVar, tf(hfVar));
        if (hf2) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(new xj.InterfaceC0510xj() { // from class: com.ss.android.downloadlib.hf.y.1
            @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
            public void hf() {
                com.ss.android.socialbase.downloader.xj.xj.xj().hf(this);
                com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.hf.y.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean w = g.w(com.ss.android.downloadad.api.xj.hf.this.kd());
                        long kd = y.kd(com.ss.android.downloadad.api.xj.hf.this);
                        if (!w || kd >= System.currentTimeMillis() - currentTimeMillis) {
                            long f = y.f(com.ss.android.downloadad.api.xj.hf.this);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (currentTimeMillis2 - currentTimeMillis > f) {
                                com.ss.android.downloadlib.u.xj.xj().xj("deeplink_delay_timeout", com.ss.android.downloadad.api.xj.hf.this);
                                return;
                            }
                            com.ss.android.downloadad.api.xj.hf.this.pl(true);
                            com.ss.android.downloadlib.u.xj.xj().xj("deeplink_delay_invoke", com.ss.android.downloadad.api.xj.hf.this);
                            fVar.xj(true);
                            com.ss.android.downloadad.api.xj.hf hfVar2 = com.ss.android.downloadad.api.xj.hf.this;
                            y.hf(hfVar2, y.tf(hfVar2));
                        }
                    }
                });
            }

            @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
            public void w() {
            }
        });
    }

    public static boolean hf(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).hf("app_link_opt_install_switch") == 1;
    }

    public static boolean xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.c.kd.xj((com.ss.android.downloadad.api.xj.xj) hfVar).hf("app_link_opt_switch") == 1;
    }
}
