package com.bytedance.msdk.y;

import android.text.TextUtils;
import com.bytedance.msdk.api.u.tf;
import com.bytedance.msdk.core.xj.xj.kd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.t;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static synchronized void hf() {
        synchronized (xj.class) {
            if (com.bytedance.msdk.core.hf.getContext() == null) {
                return;
            }
            com.bytedance.msdk.c.xj.hf.xj().kd();
        }
    }

    private static boolean u(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0 || str.length() > str2.length()) {
            return false;
        }
        if (str.startsWith(t.c) || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith(t.c) || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() == split[i].length() && split[i].compareTo(split2[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    private static int w(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith(t.c) || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith(t.c) || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i = 0; i < min; i++) {
            if (split[i].length() != split2[i].length()) {
                return split[i].length() > split2[i].length() ? 1 : -1;
            }
            int compareTo = split[i].compareTo(split2[i]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (split.length == split2.length) {
            return 0;
        }
        return split.length > split2.length ? 1 : -1;
    }

    public static void xj() {
        try {
            if (com.bytedance.msdk.xj.kd.w.hf() && tf.xj()) {
                hf();
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.equals("baidu") && !str.equals(MediationConstant.ADN_ADMOB) && !str.equals(MediationConstant.ADN_PANGLE)) {
            switch (str) {
                case "klevin":
                    if (w(str2, "2.11.0.3") != 0) {
                        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", "klevin版本不符合, 要求版本等于2.11.0.3，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_InitChecker", "klevin版本正常, 要求版本等于2.11.0.3，当前是" + str2);
                    break;
                case "sigmob":
                    if (w(str2, "4.24.0") != 0) {
                        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", "sigmob版本不符合, 要求版本等于4.24.0，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_InitChecker", "sigmob版本正常, 要求版本等于4.24.0，当前是" + str2);
                    return true;
                case "xiaomi":
                    if (w(str2, "2.11.0.3.32") != 0) {
                        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", "xiaomi版本不符合, 要求版本等于2.11.0.3.32，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_InitChecker", "xiaomi版本正常, 要求版本等于2.11.0.3.32，当前是" + str2);
                    return true;
                case "ks":
                    if (w(str2, "4.6.30.1") != 0) {
                        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", "快手版本不符合, 要求版本等于4.6.30.1，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_InitChecker", "快手版本正常, 要求版本等于4.6.30.1，当前是" + str2);
                    return true;
                case "gdt":
                    if (w(str2, "4.642.1512") != 0) {
                        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", "gdt版本不符合，要求等于4.642.1512，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_InitChecker", "gdt版本正常，要求等于4.642.1512，当前是" + str2);
                    return true;
                case "unity":
                    if (w(str2, "4.3.0") != 0) {
                        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", "unity版本不符合，要求等于4.3.0，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_InitChecker", "unity版本正常，要求等于4.3.0，当前是" + str2);
                    return true;
                case "mintegral":
                    if (!TextUtils.isEmpty(str2) && str2.contains("16.6.57")) {
                        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_InitChecker", "Mintegral版本正常, 要求版本等于16.6.57，当前是".concat(str2));
                        return true;
                    }
                    com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", "Mintegral版本不符合, 要求版本等于16.6.57，当前是" + str2);
                    return false;
                default:
                    return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean hf(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals(MediationConstant.ADN_PANGLE)) {
                return true;
            }
            switch (str) {
                case "klevin":
                    if (u("2.11.0.3", str2)) {
                        xj("klevinAdapter", "2.11.0.3", str2);
                        break;
                    } else {
                        hf("klevinAdapter", "2.11.0.3", str2);
                        break;
                    }
                case "sigmob":
                    if (u("4.24.0", str2)) {
                        xj("sigmobAdapter", "4.24.0", str2);
                        break;
                    } else {
                        hf("sigmobAdapter", "4.24.0", str2);
                        break;
                    }
                case "xiaomi":
                    if (u("2.11.0.3.32", str2)) {
                        xj("xiaomiAdapter", "2.11.0.3.32", str2);
                        break;
                    } else {
                        hf("xiaomiAdapter", "2.11.0.3.32", str2);
                        break;
                    }
                case "ks":
                    if (kd.w("ks") == null) {
                        if (u("4.6.30.1", str2)) {
                            xj("ksAdapter", "4.6.30.1", str2);
                            break;
                        } else {
                            hf("ksAdapter", "4.6.30.1", str2);
                            break;
                        }
                    }
                    break;
                case "gdt":
                    if (kd.w("gdt") == null) {
                        if (u("4.642.1512", str2)) {
                            xj("gdtAdapter", "4.642.1512", str2);
                            break;
                        } else {
                            hf("gdtAdapter", "4.642.1512", str2);
                            break;
                        }
                    }
                    break;
                case "admob":
                    if (u("17.2.0", str2)) {
                        xj("admobAdapter", "17.2.0", str2);
                        break;
                    } else {
                        hf("admobAdapter", "17.2.0", str2);
                        break;
                    }
                case "baidu":
                    if (u("9.3941", str2)) {
                        xj("baiduAdapter", "9.3941", str2);
                        break;
                    } else {
                        hf("baiduAdapter", "9.3941", str2);
                        break;
                    }
                case "unity":
                    if (u("4.3.0", str2)) {
                        xj("unityAdapter", "4.3.0", str2);
                        break;
                    } else {
                        hf("unityAdapter", "4.3.0", str2);
                        break;
                    }
                case "mintegral":
                    if (u("16.6.57", str2)) {
                        xj("mtgAdapter", "16.6.57", str2);
                        break;
                    } else {
                        hf("mtgAdapter", "16.6.57", str2);
                        break;
                    }
            }
            return true;
        }
        return false;
    }

    private static void xj(String str, String str2, String str3) {
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_InitChecker", str + "接入版本正常, 要求版为：" + str2 + "，当前版本为：" + str3);
    }

    private static void hf(String str, String str2, String str3) {
        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_InitChecker", str + "接入版本不符合, 要求版为：" + str2 + ".x，当前版本为：" + str3);
    }
}
