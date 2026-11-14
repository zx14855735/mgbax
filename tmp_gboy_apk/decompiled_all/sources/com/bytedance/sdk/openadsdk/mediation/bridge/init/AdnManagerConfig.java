package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.constants.ErrorCode;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdnManagerConfig {
    private static volatile Function<SparseArray<Object>, Object> c;
    private static volatile Function<SparseArray<Object>, Object> f;
    private static volatile Function<SparseArray<Object>, Object> hf;
    private static volatile Function<SparseArray<Object>, Object> kd;
    private static volatile Function<SparseArray<Object>, Object> u;
    private static volatile Function<SparseArray<Object>, Object> w;
    private static volatile Function<SparseArray<Object>, Object> xj;
    private static volatile Function<SparseArray<Object>, Object> y;

    public static Function<SparseArray<Object>, Object> getAdapterManager(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    public static boolean initAdnManager(String str, String str2) {
        return xj(str, str2);
    }

    private static boolean xj(String str, String str2) {
        Object apply;
        char c2;
        if (str2 != null) {
            try {
                Object newInstance = Class.forName(str).newInstance();
                if (BpkvW3.BmvVmW(newInstance)) {
                    Function AYUAbz2 = AaHO0E.AYUAbz(newInstance);
                    SparseArray sparseArray = new SparseArray();
                    sparseArray.put(-99999987, Integer.valueOf(ErrorCode.PrivateError.LOAD_TIME_OUT));
                    sparseArray.put(-99999985, Object.class);
                    apply = AYUAbz2.apply(sparseArray);
                    if (BpkvW3.BmvVmW(apply)) {
                        Function<SparseArray<Object>, Object> AYUAbz3 = AaHO0E.AYUAbz(apply);
                        switch (str2.hashCode()) {
                            case -902468465:
                                if (str2.equals("sigmob")) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -759499589:
                                if (str2.equals(MediationConstant.ADN_XIAOMI)) {
                                    c2 = 7;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3432:
                                if (str2.equals("ks")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 102199:
                                if (str2.equals("gdt")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 92668925:
                                if (str2.equals(MediationConstant.ADN_ADMOB)) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 93498907:
                                if (str2.equals("baidu")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 111433589:
                                if (str2.equals(MediationConstant.ADN_UNITY)) {
                                    c2 = 6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1126045977:
                                if (str2.equals(MediationConstant.ADN_MINTEGRAL)) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                                u = AYUAbz3;
                                break;
                            case 1:
                                w = AYUAbz3;
                                break;
                            case 2:
                                hf = AYUAbz3;
                                break;
                            case 3:
                                kd = AYUAbz3;
                                break;
                            case 4:
                                xj = AYUAbz3;
                                break;
                            case 5:
                                y = AYUAbz3;
                                break;
                            case 6:
                                c = AYUAbz3;
                                break;
                            case 7:
                                f = AYUAbz3;
                                break;
                        }
                        return true;
                    }
                }
            } catch (Throwable th) {
                y.xj(th);
            }
        }
        return false;
    }
}
