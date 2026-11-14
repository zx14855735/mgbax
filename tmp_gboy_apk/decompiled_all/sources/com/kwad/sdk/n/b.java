package com.kwad.sdk.n;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.p;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {
    public static final String TAG = "Ranger_b";
    private List<com.kwad.sdk.n.a.a> bbS;

    public static class a {
        private static final b bbW = new b();

        static {
            AlNs();
        }

        private static /* synthetic */ void AlNs() {
            char[] charArray = "ÜÐÒ\u0091ØÞÒÚ\u0091ÝÐÆ\u0091Ì×ÚÓÓ\u0091õÑÖýÍÖÛØÚ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 191);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÜÓÖÑÖË".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 191);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private static void C(int i, String str) {
        ag.g("ksadsdk_perf_ranger_v2", "aggregation_version" + CtFAbx.ARc23Z(i, "_"), str);
    }

    private boolean N(List<String> list) {
        int i;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String[] gV = gV(it.next());
            int length = gV.length;
            boolean z2 = false;
            while (i < length) {
                z2 = gU(gV[i]);
                i = z2 ? 0 : i + 1;
            }
            z &= z2;
        }
        return z;
    }

    public static b QF() {
        return a.bbW;
    }

    private void QG() {
        long RE = p.RE();
        if (RE <= 0) {
            return;
        }
        aV(RE);
    }

    private static void QI() {
        ag.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", 0L);
    }

    private static void aV(long j) {
        ag.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", j);
    }

    private static void eQ(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "aggregation_sdk" + CtFAbx.ARc23Z(i, "_"), 1);
    }

    private static boolean eR(int i) {
        String ARc23Z2 = CtFAbx.ARc23Z(i, "_");
        StringBuilder sb = new StringBuilder("aggregation_sdk");
        sb.append(ARc23Z2);
        return ag.c("ksadsdk_perf_ranger_v2", sb.toString(), -1) == 1;
    }

    private static com.kwad.sdk.n.b.a.a eS(int i) {
        com.kwad.sdk.n.b.a.a aVar = new com.kwad.sdk.n.b.a.a();
        String str = "_" + i;
        aVar.fa(i);
        aVar.gY(ag.h("ksadsdk_perf_ranger_v2", "aggregation_version" + str, ""));
        aVar.fb(ag.c("ksadsdk_perf_ranger_v2", "crash_times" + str, 0));
        aVar.fc(ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, 0));
        aVar.aW(ag.b("ksadsdk_perf_ranger_v2", "ks_launch_delay", -1L));
        aVar.aX(ag.b("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + str, -1L));
        return aVar;
    }

    private static void eT(int i) {
        ag.g("ksadsdk_perf_ranger_v2", "aggregation_version" + CtFAbx.ARc23Z(i, "_"), "");
    }

    public static void eU(int i) {
        String ARc23Z2 = CtFAbx.ARc23Z(i, "_");
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + ARc23Z2, ag.c("ksadsdk_perf_ranger_v2", "crash_times" + ARc23Z2, -1) + 1);
    }

    private static void eV(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + CtFAbx.ARc23Z(i, "_"), 0);
    }

    public static void eW(int i) {
        String ARc23Z2 = CtFAbx.ARc23Z(i, "_");
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + ARc23Z2, ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + ARc23Z2, -1) + 1);
    }

    private static void eX(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + CtFAbx.ARc23Z(i, "_"), 0);
    }

    private static void eY(int i) {
        ag.a("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + CtFAbx.ARc23Z(i, "_"), 0L);
    }

    private static boolean gU(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String[] gV(String str) {
        return str.contains("_") ? str.split("_") : new String[]{str};
    }

    public final void QH() {
        boolean z = false;
        for (int i = 0; i < this.bbS.size(); i++) {
            com.kwad.sdk.n.a.a aVar = this.bbS.get(i);
            if (eR(aVar.bcj)) {
                com.kwad.sdk.commercial.c.v(eS(aVar.bcj));
                z = true;
            }
        }
        if (z) {
            return;
        }
        com.kwad.sdk.commercial.c.v(eS(-1));
    }

    public final void clearAll() {
        for (int i = 0; i < this.bbS.size(); i++) {
            eT(i);
            eV(i);
            eX(i);
            QI();
            eY(i);
        }
    }

    public final void gW(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GlobalThreadPools.Lf().execute(new Runnable() { // from class: com.kwad.sdk.n.b.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.bbS != null && !b.this.bbS.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : b.this.bbS) {
                            if (b.b(str, aVar.bcm)) {
                                b.eU(aVar.bcj);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    public final void start() {
        QG();
        List<com.kwad.sdk.n.a.a> list = this.bbS;
        if (list == null) {
            com.kwad.sdk.core.d.c.w(TAG, "aggregationCheckConfigList is null");
            return;
        }
        for (com.kwad.sdk.n.a.a aVar : list) {
            try {
                if (N(aVar.bck)) {
                    eQ(aVar.bcj);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
            }
            try {
                if (aVar.bcl != null) {
                    a(aVar);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e2));
            }
        }
    }

    private void a(com.kwad.sdk.n.a.a aVar) {
        String a2 = c.QK().a(aVar.bcl);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        C(aVar.bcj, a2);
    }

    public final void b(d dVar) {
        List<com.kwad.sdk.n.a.a> list = dVar.bbS;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.bbS = list;
    }

    public final void c(final StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        GlobalThreadPools.Lf().execute(new Runnable() { // from class: com.kwad.sdk.n.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.bbS != null && !b.this.bbS.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : b.this.bbS) {
                            if (b.a(stackTraceElementArr, aVar.bcn)) {
                                b.eW(aVar.bcj);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(StackTraceElement[] stackTraceElementArr, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (p.a(stackTraceElement).contains(str)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
