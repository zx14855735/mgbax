package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private static List<String> aUH = null;
    private static List<String> aUI = null;
    private static int aUJ = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aUH = new ArrayList();
        List<String> list = aVar.aUU;
        if (list == null || list.isEmpty()) {
            aUH.add("com.kwad");
            aUH.add("com.kwai");
            aUH.add("com.ksad");
            aUH.add("tkruntime");
            aUH.add("tachikoma");
            aUH.add("kuaishou");
        } else {
            aUH.addAll(aVar.aUU);
        }
        aUJ = aVar.aUZ;
        aUI = new ArrayList();
        List<String> list2 = aVar.aUT;
        if (list2 != null && !list2.isEmpty()) {
            aUI.addAll(aVar.aUT);
            return;
        }
        aUI.add("android.");
        aUI.add("androidx.");
        aUI.add("org.");
        aUI.add("java.");
    }

    private static boolean fW(String str) {
        List<String> list = aUI;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean fX(String str) {
        List<String> list = aUH;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String fY(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\n");
        A2egSU.BChYOn(new StringBuilder("stacks after split:"), split.length, "perfMonitor.Filter");
        boolean z = false;
        int i = 0;
        for (String str2 : split) {
            if (z || !fW(str2)) {
                if (i >= aUJ) {
                    return "";
                }
                if (fX(str2)) {
                    return str;
                }
                i++;
                z = true;
            }
        }
        return "";
    }
}
