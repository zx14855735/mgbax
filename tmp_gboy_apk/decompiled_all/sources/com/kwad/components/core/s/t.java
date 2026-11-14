package com.kwad.components.core.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.r;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class t {
    public static final String TAG = "t";
    private static final String acZ = "com.kwad.components.core.s.t";
    private static volatile t ada;
    private boolean adb = false;
    private r.a adc;

    private t() {
    }

    private static void O(long j) {
        com.kwad.sdk.core.d.c.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    private boolean a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        return true;
                    }
                }
            }
        }
        com.kwad.sdk.n.b.QF().c(stackTrace);
        return a(list2, stackTrace);
    }

    private static boolean aU(String str) {
        return (str.startsWith("android") || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(acZ) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean aV(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean aW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static t uI() {
        if (ada == null) {
            synchronized (t.class) {
                try {
                    if (ada == null) {
                        ada = new t();
                    }
                } finally {
                }
            }
        }
        return ada;
    }

    private void uK() {
        r.a aVar = this.adc;
        if (aVar == null) {
            return;
        }
        if (!this.adb && aVar.aHh.size() > 0) {
            Iterator<String> it = this.adc.aHh.iterator();
            while (it.hasNext()) {
                boolean aW = aW(it.next());
                this.adb = aW;
                if (aW) {
                    break;
                }
            }
        }
        if (this.adb) {
            ArrayList arrayList = new ArrayList();
            if (this.adc.aHe.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.adc.aHe.entrySet()) {
                    if (aW(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            r.a aVar2 = this.adc;
            com.kwad.components.core.o.a.tz().a(a(aVar2.aHf, aVar2.aHg), arrayList);
        }
    }

    public final boolean b(SceneImpl sceneImpl, String str) {
        boolean z;
        if (this.adb) {
            r.a aVar = this.adc;
            z = a(aVar.aHf, aVar.aHg);
        } else {
            z = false;
        }
        com.kwad.components.core.o.a.tz().a(sceneImpl, z, str);
        return z;
    }

    public final void init() {
        r.a aVar = (r.a) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aDZ);
        this.adc = aVar;
        if (aVar != null) {
            uK();
        }
    }

    public final int uJ() {
        r.a aVar = this.adc;
        if (aVar != null) {
            return aVar.aHi;
        }
        return 0;
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.c.d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && aU(className) && aV(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            O(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            O(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            O(elapsedRealtime);
        }
        return false;
    }

    private static boolean a(List<String> list, Class cls) {
        int i = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i++;
            if (i >= 4) {
                break;
            }
        }
        return false;
    }
}
