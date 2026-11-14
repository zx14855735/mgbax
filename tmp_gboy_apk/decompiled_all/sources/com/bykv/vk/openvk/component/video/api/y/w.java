package com.bykv.vk.openvk.component.video.api.y;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static int hf = 4;
    private static String w = "";
    private static boolean xj;

    public static boolean hf() {
        return xj;
    }

    public static void w(String str, String str2) {
        if (xj && str2 != null && hf <= 6) {
            pl.u(w(str), str2);
        }
    }

    public static void xj(int i) {
        hf = i;
    }

    public static void hf(String str, String str2) {
        if (xj && str2 != null && hf <= 5) {
            pl.hf(w(str), str2);
        }
    }

    public static void xj() {
        xj = true;
        xj(3);
    }

    public static void w(String str, String str2, Throwable th) {
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 6) {
                pl.w(w(str), str2, th);
            }
        }
    }

    public static void xj(String str) {
        if (xj) {
            xj("Logger", str);
        }
    }

    public static void hf(String str, String str2, Throwable th) {
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 5) {
                pl.hf(w(str), str2, th);
            }
        }
    }

    public static void xj(String str, String str2) {
        if (xj && str2 != null && hf <= 4) {
            pl.xj(w(str), str2);
        }
    }

    private static String w(String str) {
        return TextUtils.isEmpty(w) ? str : xj(A2egSU.AzWtSf(new StringBuilder("["), w, "]-[", str, "]"));
    }

    public static void hf(String str, Object... objArr) {
        if (xj && objArr != null && hf <= 5) {
            w(str);
            xj(objArr);
        }
    }

    public static void xj(String str, String str2, Throwable th) {
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 4) {
                pl.xj(w(str), str2, th);
            }
        }
    }

    public static void hf(String str) {
        if (xj) {
            w("Logger", str);
        }
    }

    public static void xj(String str, Object... objArr) {
        if (xj && objArr != null && hf <= 4) {
            w(str);
            xj(objArr);
        }
    }

    private static String xj(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                } else {
                    sb.append(" null ");
                }
                sb.append(" ");
            }
            return sb.toString();
        }
        return "";
    }
}
