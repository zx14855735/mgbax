package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.widget.e;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ar {
    private static Handler aWC = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.config.d beV;

    public static final class a {
        private static final ar beZ = new ar();

        static {
            aUpYiw();
        }

        private static /* synthetic */ void aUpYiw() {
            char[] charArray = "ÎÂÀ\u0083ÊÌÀÈ\u0083ÏÂÔ\u0083ÞÅÈÁÁ\u0083çÃÄïßÄÉÊÈ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 173);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÎÁÄÃÄÙ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 173);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        RgNAaEB();
    }

    private static /* synthetic */ void RgNAaEB() {
        char[] charArray = "«§¥æ¯©¥\u00adæª§±æ» \u00ad¤¤æ\u0082¦¡\u008aº¡¬¯\u00ad".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 200);
        }
        String str = new String(charArray);
        char[] charArray2 = "«¤¡¦¡¼".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 200);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ar SN() {
        return a.beZ;
    }

    private com.kwad.sdk.core.config.d SO() {
        if (this.beV == null) {
            this.beV = new com.kwad.sdk.core.config.d();
        }
        return this.beV;
    }

    private static boolean SQ() {
        return j.Rz() || j.RA();
    }

    private static int SR() {
        String h = ag.h("ksadsdk_perf", "install_permission_times_per_day", "");
        if (TextUtils.isEmpty(h)) {
            return 0;
        }
        String[] split = h.split("_");
        try {
            if (split[0].equals(SV())) {
                return Integer.parseInt(split[1]);
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void SS() {
        try {
            String h = ag.h("ksadsdk_perf", "install_permission_times_per_day", "");
            if (TextUtils.isEmpty(h)) {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", SV() + "_1");
                return;
            }
            String[] split = h.split("_");
            if (!split[0].equals(SV())) {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", SV() + "_1");
                return;
            }
            ag.g("ksadsdk_perf", "install_permission_times_per_day", SV() + "_" + (Integer.parseInt(split[1]) + 1));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ST() {
        try {
            ag.b("ksadsdk_perf", "install_permission_times", ag.c("ksadsdk_perf", "install_permission_times", 0) + 1);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
        }
    }

    private static int SU() {
        try {
            return ag.c("ksadsdk_perf", "install_permission_times", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String SV() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
    }

    public static com.kwad.sdk.core.config.d hu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.core.config.d dVar = new com.kwad.sdk.core.config.d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", e);
            return null;
        }
    }

    private static boolean q(Activity activity) {
        return Build.VERSION.SDK_INT >= 26 ? activity.getPackageManager().canRequestPackageInstalls() : Settings.Secure.getInt(activity.getContentResolver(), "install_non_market_apps", 0) == 1;
    }

    public final void SP() {
        try {
            com.kwad.sdk.core.c.b.Ji();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.ar.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityStopped */
                public final void f(Activity activity) {
                    super.f(activity);
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onActivityStopped:" + activity);
                    if (ar.aWC != null) {
                        ar.aWC.removeCallbacksAndMessages(null);
                    }
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onBackToBackground:");
                    if (ar.aWC != null) {
                        ar.aWC.removeCallbacksAndMessages(null);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void df(final String str) {
        GlobalThreadPools.Lq().execute(new Runnable() { // from class: com.kwad.sdk.utils.ar.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("PackageInstallHelper", "init configStr:" + str);
                if (TextUtils.isEmpty(str)) {
                    com.kwad.sdk.core.d.c.w("PackageInstallHelper", "config is empty");
                } else {
                    ar.this.beV = ar.hu(str);
                }
            }
        });
    }

    public final void p(final Activity activity) {
        com.kwad.sdk.core.config.d SO = SO();
        if (SO == null || SO.aGO == 0) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "config is null or enableDialog is false");
            return;
        }
        int i = SO.aGP;
        if (i < 0) {
            return;
        }
        if (!SQ()) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "not support");
            return;
        }
        if (a(SO)) {
            return;
        }
        if (SU() >= SO.aGR) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show times is over max");
            return;
        }
        if (q(activity)) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "has install permission");
            return;
        }
        Handler handler = aWC;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            aWC.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.ar.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        final Activity activity2 = (Activity) com.kwad.sdk.o.m.wrapContextIfNeed(activity);
                        if (!activity2.isFinishing() && !activity2.isDestroyed()) {
                            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show dialog");
                            e.a aVar = new e.a(activity2);
                            aVar.ib("去授权").ic("残忍拒绝").ia("需要授予安装其他应用权限");
                            aVar.a(new e.b() { // from class: com.kwad.sdk.utils.ar.3.1
                                @Override // com.kwad.sdk.widget.e.b
                                public final void a(DialogInterface dialogInterface) {
                                    bw.e(dialogInterface);
                                    j.cJ(activity2);
                                }

                                @Override // com.kwad.sdk.widget.e.b
                                public final void b(DialogInterface dialogInterface) {
                                    bw.e(dialogInterface);
                                }

                                @Override // com.kwad.sdk.widget.e.b
                                public final void c(DialogInterface dialogInterface) {
                                    bw.e(dialogInterface);
                                }
                            });
                            try {
                                aVar.UG().show();
                                ar arVar = ar.this;
                                ar.SS();
                                ar arVar2 = ar.this;
                                ar.ST();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception e) {
                        ServiceProvider.reportSdkCaughtException(e);
                    }
                }
            }, i);
        }
    }

    private boolean a(com.kwad.sdk.core.config.d dVar) {
        int SR = SR();
        if (SR <= dVar.aGQ) {
            return false;
        }
        A2egSU.BChYOn(J3FDQU.A2egSU.B9tovu(SR, "todayShow:", " > showTimesPerDay:"), dVar.aGQ, "PackageInstallHelper");
        return true;
    }
}
