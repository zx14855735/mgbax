package com.bytedance.sdk.component.utils;

import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl {
    private static int hf = 4;
    private static String u = "";
    private static com.bytedance.sdk.component.xj w;
    private static boolean xj;

    public static void hf() {
        xj = true;
        xj(3);
    }

    public static void u(String str, String str2) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.w(u(str), str2);
        }
        if (xj && str2 != null && hf <= 6) {
            u(str);
        }
    }

    public static boolean w() {
        return xj;
    }

    public static void xj(com.bytedance.sdk.component.xj xjVar) {
        w = xjVar;
    }

    public static void w(String str, String str2) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.xj(u(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        u(str);
    }

    public static void xj(int i) {
        hf = i;
    }

    public static void hf(String str) {
        if (xj) {
            hf("Logger", str);
        }
    }

    public static boolean xj() {
        return hf <= 3;
    }

    public static void xj(String str) {
        if (xj) {
            xj("Logger", str);
        }
    }

    public static void hf(String str, String str2) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.hf(u(str), str2);
        }
        if (xj && str2 != null && hf <= 5) {
            u(str);
        }
    }

    public static String u(String str) {
        return TextUtils.isEmpty(u) ? str : xj(A2egSU.AzWtSf(new StringBuilder("["), u, "]-[", str, "]"));
    }

    public static void w(String str) {
        if (xj) {
            u("Logger", str);
        }
    }

    public static void xj(String str, String str2) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.xj(u(str), str2);
        }
        if (xj && str2 != null && hf <= 4) {
            u(str);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.hf(u(str), str2, th);
        }
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 6) {
                u(str);
            }
        }
    }

    public static void hf(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.xj(u(str), str2, th);
        }
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 5) {
                u(str);
            }
        }
    }

    public static void xj(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            String u2 = u(str);
            StringBuilder A4TApA2 = AYUAbz.A4TApA(str2);
            A4TApA2.append(Log.getStackTraceString(th));
            xjVar.xj(u2, A4TApA2.toString());
        }
        if (xj) {
            if (!(str2 == null && th == null) && hf <= 4) {
                u(str);
            }
        }
    }

    public static void w(String str, Object... objArr) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.w(u(str), xj(objArr));
        }
        if (xj && objArr != null && hf <= 6) {
            u(str);
            xj(objArr);
        }
    }

    public static void hf(String str, Object... objArr) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.hf(u(str), xj(objArr));
        }
        if (xj && objArr != null && hf <= 5) {
            u(str);
            xj(objArr);
        }
    }

    public static void xj(String str, Object... objArr) {
        com.bytedance.sdk.component.xj xjVar = w;
        if (xjVar != null) {
            xjVar.xj(u(str), xj(objArr));
        }
        if (xj && objArr != null && hf <= 4) {
            u(str);
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

    public static void xj(Throwable th) {
        hf(u, "", th);
    }

    public static void xj(int i, String str, String str2) {
        xj(str, str2);
    }
}
