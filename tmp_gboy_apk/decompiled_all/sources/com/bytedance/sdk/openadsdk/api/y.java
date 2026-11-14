package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private static int hf = 4;
    private static boolean xj;

    public static void hf(String str, String str2) {
    }

    public static void kd(String str, String str2) {
        if (xj && str2 != null && hf <= 6) {
            pl.u(str, str2);
        }
    }

    public static void u(String str, String str2) {
        if (xj && str2 != null && hf <= 5) {
            pl.hf(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (xj && str2 != null && hf <= 4) {
            pl.xj(str, str2);
        }
    }

    public static void xj(String str, String str2) {
    }

    public static void hf(String str, String str2, Throwable th) {
    }

    public static void xj(String str, String str2, Throwable th) {
    }

    public static void hf(String str) {
        if (xj) {
            u("TTLogger", str);
        }
    }

    public static void xj(int i) {
        hf = i;
    }

    public static void kd(String str, String str2, Throwable th) {
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 6) {
                pl.w(str, str2, th);
            }
        }
    }

    public static void u(String str, String str2, Throwable th) {
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 5) {
                pl.hf(str, str2, th);
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 4) {
                pl.xj(str, str2, th);
            }
        }
    }

    public static void xj() {
        xj = true;
        xj(3);
    }

    public static void hf(String str, Object... objArr) {
        if (xj && objArr != null && hf <= 5) {
            xj(objArr);
        }
    }

    public static void xj(String str, Object... objArr) {
        if (xj && objArr != null && hf <= 3) {
            xj(objArr);
        }
    }

    public static void w(String str) {
        if (xj) {
            kd("TTLogger", str);
        }
    }

    public static void xj(String str) {
        if (xj) {
            w("TTLogger", str);
        }
    }

    public static void xj(Throwable th) {
        u("TTLogger", "", th);
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
