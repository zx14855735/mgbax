package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.components.ad.reward.A2egSU;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class af {
    private static AtomicInteger beA = new AtomicInteger(0);
    private static volatile boolean beB = false;
    private static volatile boolean beC;

    static {
        fWuoFt();
    }

    private static int RT() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int Ds = hVar.Ds();
        A2egSU.A4TApA(Ds, "config mode:", "Ks_UnionHelper");
        return Ds;
    }

    private static void RU() {
        if (beB) {
            return;
        }
        beA.set(RX());
        beC = bo.m("kssdk_kv_mode", "downgrade", false);
        beB = true;
    }

    public static void RV() {
        if (RY() || RT() == 0) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.utils.b.a RW = af.RW();
                if (RW == null) {
                    return;
                }
                af.c(RW);
                com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                if (bVar != null) {
                    bVar.a(RW);
                }
            }
        });
    }

    public static com.kwad.sdk.utils.b.a RW() {
        Map<String, ?> all;
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences hF = bo.hF("ksadsdk_kv_perf");
        if (hF == null) {
            return null;
        }
        try {
            all = hF.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Integer) it.next().getValue()).intValue();
        }
        aVar.bhQ = i;
        SharedPreferences.Editor edit = hF.edit();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            edit.putInt(it2.next().getKey(), 0);
        }
        edit.apply();
        d(aVar);
        e(aVar);
        return aVar;
    }

    private static int RX() {
        int c = bo.c("kssdk_kv_mode", "mode", 0);
        A2egSU.A4TApA(c, "local mode:", "Ks_UnionHelper");
        return c;
    }

    private static boolean RY() {
        RU();
        return beA.get() == 0;
    }

    private static boolean RZ() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static int Sa() {
        RU();
        int RT = (beC || !RZ()) ? 0 : RT();
        A2egSU.A4TApA(RT, "targetMode:", "Ks_UnionHelper");
        return RT;
    }

    public static void Sb() {
        RU();
        int i = beA.get();
        int Sa = Sa();
        boolean z = i != Sa;
        com.bykv.vk.component.ttvideo.player.A2egSU.B9tovu("needTransfer:", "Ks_UnionHelper", z);
        if (z) {
            transfer(Sa);
        }
    }

    private static void Sc() {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                Context context;
                try {
                    context = ag.getContext();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                if (context == null) {
                    return;
                }
                Iterator<String> it = i.a.awr.iterator();
                while (it.hasNext()) {
                    af.U(context, it.next());
                }
                af.fh(0);
                af.beA.set(0);
            }
        });
    }

    private static void Sd() {
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "transferToKv");
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    Context context = ag.getContext();
                    if (context != null) {
                        Iterator<String> it = i.a.awr.iterator();
                        while (it.hasNext()) {
                            af.T(context, it.next());
                        }
                        af.fh(1);
                        af.beA.set(1);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(Context context, String str) {
        SharedPreferences hF;
        com.kwad.sdk.utils.a.c aB = com.kwad.sdk.utils.a.e.aB(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (hF = bo.hF(str)) == null) {
            SharedPreferences.Editor edit = hF.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (aB.contains("sp_to_kv_transfer_flag")) {
            return;
        }
        SharedPreferences hF2 = bo.hF(str);
        if (hF2 == null) {
            aB.putBoolean("sp_to_kv_transfer_flag", true);
            return;
        }
        aB.putAll(hF2.getAll());
        aB.putBoolean("sp_to_kv_transfer_flag", true);
        bo.ax(str, "kv_to_sp_transfer_flag");
        a(str, aB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void U(Context context, String str) {
        SharedPreferences hF = bo.hF(str);
        if (hF == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor edit = hF.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (hF.contains("kv_to_sp_transfer_flag")) {
            return;
        }
        com.kwad.sdk.utils.a.c aB = com.kwad.sdk.utils.a.e.aB(context, str);
        Map<String, Object> all = aB.getAll();
        if (all.isEmpty()) {
            bo.l(str, "kv_to_sp_transfer_flag", true);
            return;
        }
        bo.a(str, all);
        bo.l(str, "kv_to_sp_transfer_flag", true);
        aB.remove("sp_to_kv_transfer_flag");
        aB.release();
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (i.a.aws.contains(str)) {
            return;
        }
        cVar.release();
    }

    public static void au(final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    int c = bo.c("ksadsdk_kv_perf", str, 0);
                    if (TextUtils.isEmpty(str2)) {
                        bo.ax("ksadsdk_kv_perf", str);
                    } else {
                        bo.b("ksadsdk_kv_perf", str, c + 1);
                    }
                } catch (Exception e) {
                    bo.ax("ksadsdk_kv_perf", str);
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        });
    }

    public static void av(final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                SharedPreferences hF = bo.hF("ksadsdk_kv_perf");
                if (hF != null && hF.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bo.b("ksadsdk_kv_perf_failed", str, bo.c("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        bo.b("ksadsdk_kv_perf_success", str, bo.c("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(com.kwad.sdk.utils.b.a aVar) {
        if (aVar.bhR / (r0 + aVar.bhS) > 0.10000000149011612d) {
            beC = true;
            com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "need downgrade");
            bo.l("kssdk_kv_mode", "downgrade", true);
        }
        if (beC) {
            Sb();
        }
    }

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences hF = bo.hF("ksadsdk_kv_perf_failed");
        int i = 0;
        if (hF == null) {
            aVar.bhR = 0;
            return;
        }
        Map<String, ?> all = hF.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                i += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.bhR = i;
        SharedPreferences.Editor edit = hF.edit();
        edit.clear();
        edit.apply();
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences hF = bo.hF("ksadsdk_kv_perf_success");
        int i = 0;
        if (hF == null) {
            aVar.bhS = 0;
            return;
        }
        Map<String, ?> all = hF.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                i += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.bhS = i;
        SharedPreferences.Editor edit = hF.edit();
        edit.clear();
        edit.apply();
    }

    private static /* synthetic */ void fWuoFt() {
        char[] charArray = ">20s:<08s?2$s.5811s\u001734\u001f/49:8".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ']');
        }
        String str = new String(charArray);
        char[] charArray2 = ">1434)".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ']');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void fh(int i) {
        bo.b("kssdk_kv_mode", "mode", i);
    }

    private static boolean hm(String str) {
        return i.a.awr.contains(str);
    }

    public static boolean hn(String str) {
        boolean z = RY() || !hm(str);
        com.bykv.vk.component.ttvideo.player.A2egSU.B9tovu("shouldUseModeSp:", "Ks_UnionHelper", z);
        return z;
    }

    private static void transfer(int i) {
        if (i == 0) {
            Sc();
        } else if (i == 1) {
            Sd();
        }
    }
}
