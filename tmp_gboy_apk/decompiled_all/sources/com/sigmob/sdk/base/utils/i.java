package com.sigmob.sdk.base.utils;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import J3FDQU.A2egSU;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.windad.natives.AdAppInfo;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13218a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    private static final String f = "SigAds";
    private static final boolean g = true;
    private static boolean h = true;
    private static final int i = 1;
    private static final int j = 1;
    private static final int k = 4;
    private static final Set<String> l = new HashSet();

    static {
        xDQU();
    }

    private static int a(StackTraceElement[] stackTraceElementArr) {
        for (int i2 = 1; i2 < stackTraceElementArr.length; i2++) {
            if (!stackTraceElementArr[i2].getClassName().split("\\$")[0].equals(i.class.getName())) {
                return i2;
            }
        }
        return -1;
    }

    private static String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int a2 = a(stackTrace);
        int i2 = a2 + 4;
        int i3 = a2 + 5;
        if (i2 >= stackTrace.length) {
            i2 = stackTrace.length - 1;
        }
        if (i3 > stackTrace.length) {
            i3 = stackTrace.length;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            String a3 = a(stackTrace[i4]);
            sb.append((CharSequence) sb2);
            sb.append(a3);
            sb.append('\n');
            sb2.append("  ");
        }
        return sb.toString();
    }

    public static void c(String str, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    public static void d(String str, String str2, Object... objArr) {
        if (!h) {
            l.contains(str);
            return;
        }
        String a2 = a(str2, objArr);
        if (a2.length() < 3000) {
            b(str);
            return;
        }
        synchronized (i.class) {
            int length = a2.length();
            int i2 = 0;
            int i3 = 0;
            do {
                i2 += 3000;
                if (i2 >= length) {
                    i2 = length - 1;
                }
                b(str);
                a2.substring(i3, i2);
                i3 = i2 + 1;
            } while (i2 != length - 1);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    public static void f(String str, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    private static /* synthetic */ void xDQU() {
        char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ '}');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ '}');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String a() {
        return Thread.currentThread().getName();
    }

    private static String b(String str) {
        return CtFAbx.BChYOn("SigAds#", str);
    }

    public static void c(String str, Throwable th, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    private static String a(StackTraceElement stackTraceElement) {
        return "(" + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + ')';
    }

    private static String a(String str) {
        return A2egSU.B3GDIM(AYUAbz.A5SV6n(str, " ["), a(), "] ", b());
    }

    public static void b(int i2, String str, String str2, BaseAdUnit baseAdUnit, Map<String, Object> map) {
        if (baseAdUnit == null) {
            f(str, CtFAbx.AcNBzu(str2, ": adUnit is null."), new Object[0]);
            return;
        }
        AdAppInfo adAppInfo = baseAdUnit.getAdAppInfo();
        a(i2, str, str2 + ": placementId = " + baseAdUnit.getAdslot_id() + ", adType = " + com.sigmob.sdk.base.common.d.a(baseAdUnit.getAd_type()) + ", appInfo = " + adAppInfo + ", params = " + map, new Object[0]);
    }

    public static void b(String str, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    public static String a(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    public static void a(int i2, String str, String str2, BaseAdUnit baseAdUnit, Map<String, Object> map) {
        if (baseAdUnit == null) {
            f(str, CtFAbx.AcNBzu(str2, ": adUnit is null."), new Object[0]);
            return;
        }
        String vid = baseAdUnit.getVid();
        int playMode = baseAdUnit.getPlayMode();
        String requestId = baseAdUnit.getRequestId();
        String adslot_id = baseAdUnit.getAdslot_id();
        boolean disableAutoLoad = baseAdUnit.getDisableAutoLoad();
        a(i2, str, str2 + ": placementId = " + adslot_id + ", sceneType = " + baseAdUnit.getRequestSceneType() + ", requestId = " + requestId + ", playMode = " + playMode + ", autoLoad = " + disableAutoLoad + ", adType = " + com.sigmob.sdk.base.common.d.a(baseAdUnit.getAd_type()) + ", vid = " + vid + ", params = " + map, new Object[0]);
    }

    public static void a(int i2, String str, String str2, LoadAdRequest loadAdRequest, Map<String, Object> map) {
        if (loadAdRequest == null) {
            f(str, CtFAbx.AcNBzu(str2, ": request is null."), new Object[0]);
            return;
        }
        String loadId = loadAdRequest.getLoadId();
        String userId = loadAdRequest.getUserId();
        String bidToken = loadAdRequest.getBidToken();
        String requestId = loadAdRequest.getRequestId();
        String placementId = loadAdRequest.getPlacementId();
        int request_scene_type = loadAdRequest.getRequest_scene_type();
        String a2 = com.sigmob.sdk.base.common.d.a(loadAdRequest.getAdType());
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(": placementId = ");
        sb.append(placementId);
        sb.append(", sceneType = ");
        sb.append(request_scene_type);
        com.bykv.vk.component.ttvideo.player.A2egSU.BIYEnU(sb, ", requestId = ", requestId, ", loadId = ", loadId);
        com.bykv.vk.component.ttvideo.player.A2egSU.BIYEnU(sb, ", userId = ", userId, ", adType = ", a2);
        sb.append(", bidToken = ");
        sb.append(bidToken);
        sb.append(", params = ");
        sb.append(map);
        a(i2, str, sb.toString(), new Object[0]);
    }

    public static void a(int i2, String str, String str2, Object... objArr) {
        if (i2 == 2) {
            a(str, str2, objArr);
            return;
        }
        if (i2 == 3) {
            c(str, str2, objArr);
            return;
        }
        if (i2 == 4) {
            b(str, str2, objArr);
            return;
        }
        if (i2 == 5) {
            e(str, str2, objArr);
        } else if (i2 != 6) {
            f(str, "level is unknown.", new Object[0]);
        } else {
            f(str, str2, objArr);
        }
    }

    public static void a(Class<?> cls) {
        l.add(cls.getSimpleName());
    }

    public static void a(String str, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    public static void a(String str, Throwable th) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (!h || l.contains(str)) {
            return;
        }
        b(str);
        a(a(str2, objArr));
    }

    public static void a(boolean z) {
        h = z;
    }
}
