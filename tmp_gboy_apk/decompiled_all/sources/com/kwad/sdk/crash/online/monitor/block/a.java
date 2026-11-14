package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static List<String> aUA;
    private static volatile boolean aUB;
    private static volatile boolean aUC;
    private static volatile boolean aUx;
    private static String aUy;
    private static List<String> aUz;

    public static boolean NC() {
        if (aUx) {
            return false;
        }
        try {
            return ((Printer) z.getField(Looper.getMainLooper(), "mLogging")) != null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            aUx = true;
            return false;
        }
    }

    public static boolean ND() {
        if (aUC) {
            return aUB;
        }
        try {
            String str = new String(com.kwad.sdk.core.a.c.Jb().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "hasMatrix after:".concat(str));
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            aUB = false;
            aUC = true;
            return aUB;
        }
    }

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aUz = aVar.aUV;
        aUA = aVar.aUW;
    }

    public static boolean bL(boolean z) {
        List<String> list = aUz;
        return (list == null || list.isEmpty()) ? h("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true) : a(aUz, true);
    }

    public static boolean bM(boolean z) {
        List<String> list = aUA;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return a(aUA, false);
    }

    private static boolean h(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList, z);
    }

    private static boolean a(List<String> list, boolean z) {
        if (aUx) {
            return false;
        }
        try {
            Printer printer = (Printer) z.getField(Looper.getMainLooper(), "mLogging");
            if (printer == null) {
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer not hook");
            } else {
                aUy = printer.getClass().getName();
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "originPrinter name:".concat(printer.getClass().getName()));
                if (z) {
                    f.gb(aUy);
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String str = new String(com.kwad.sdk.core.a.c.Jb().decode(it.next()));
                    com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer after:" + str);
                    if (printer.getClass().getName().contains(str)) {
                        com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            aUx = true;
        }
        return false;
    }
}
