package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.e;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static Set<String> aTT;

    static {
        HashSet hashSet = new HashSet();
        aTT = hashSet;
        hashSet.add("commonHT");
        aTT.add("reportHT");
        aTT.add("IpDirectHelper");
        aTT.add("filedownloader serial thread");
        aTT.add("RemitHandoverToDB");
        aTT.add("source-status-callback");
        aTT.add("ObiwanMMAPTracer");
        aTT.add("FrameSequence decoding thread");
        FStPQw();
    }

    private static /* synthetic */ void FStPQw() {
        char[] charArray = "BNL\u000fF@LD\u000fCNX\u000fRIDMM\u000fkOHcSHEFD".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '!');
        }
        String str = new String(charArray);
        char[] charArray2 = "BMHOHU".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '!');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static boolean I(List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] Nk = e.Nj().Nk();
        if (Nk == null || Nk.length == 0) {
            return true;
        }
        boolean z = false;
        for (String str : Nk) {
            z = a(stackTraceElementArr, str);
            if (z) {
                break;
            }
        }
        if (z) {
            for (String str2 : e.Nj().Nl()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    private static boolean fQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return fR(str) || str.startsWith("ksad-") || str.startsWith("filedownloader serial thread");
    }

    private static boolean fR(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("kwad.kwadsdk")) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadStr:".concat(str));
        return true;
    }

    public static boolean fS(String str) {
        if (fQ(str) || i.cd(str)) {
            return true;
        }
        Set<String> set = aTT;
        if (set == null || !set.contains(str)) {
            return false;
        }
        A2egSU.B7CMnp("needReportByThreadName:", str, "CrashFilter");
        return true;
    }

    public static boolean fT(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] Nk = e.Nj().Nk();
        if (Nk == null || Nk.length == 0) {
            return true;
        }
        boolean z = false;
        for (String str2 : Nk) {
            z = str.contains(str2);
            if (z) {
                break;
            }
        }
        if (z) {
            for (String str3 : e.Nj().Nl()) {
                if (str.contains(str3)) {
                    return false;
                }
            }
        }
        return z;
    }

    public static boolean o(Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return I(arrayList);
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}
