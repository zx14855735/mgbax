package com.bytedance.sdk.openadsdk.core.wo.xj;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTM;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.lang.reflect.Method;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {

    public interface xj {
        void hf(String str, String str2);

        void hf(String str, String str2, Throwable th);

        void kd(String str, String str2);

        void u(String str, String str2);

        void w(String str, String str2);

        void xj();

        void xj(String str, String str2);

        void xj(String str, String str2, Throwable th);

        void xj(String str, Throwable th);
    }

    public static boolean hf(Object obj) {
        Object apply;
        Boolean bool;
        if (obj == null || !BpkvW3.BmvVmW(obj)) {
            return false;
        }
        try {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -99999986);
            sparseArray.put(-99999985, SparseArray.class);
            apply = AaHO0E.AYUAbz(obj).apply(sparseArray);
            SparseArray sparseArray2 = (SparseArray) apply;
            if (sparseArray2 == null || (bool = (Boolean) sparseArray2.get(-99999978)) == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Exception e) {
            pl.xj(e);
            return false;
        }
    }

    private static String u(Object obj) {
        if (obj == null) {
            return "";
        }
        TTC ttc = obj instanceof Class ? (TTC) ((Class) obj).getAnnotation(TTC.class) : (TTC) obj.getClass().getAnnotation(TTC.class);
        return ttc == null ? "" : ttc.value();
    }

    public static void w(Object obj) {
        Object apply;
        String str = "";
        try {
            if (hf(obj)) {
                Function AYUAbz2 = AaHO0E.AYUAbz(obj);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999923);
                sparseArray.put(-99999985, String.class);
                apply = AYUAbz2.apply(sparseArray);
                str = (String) apply;
            } else {
                TTC ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
                if (ttc != null) {
                    str = u(ttc);
                }
            }
        } catch (Throwable unused) {
        }
        str.getClass();
        if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            com.bytedance.sdk.openadsdk.c.w.xj = null;
        }
    }

    public static void xj(Object obj) {
        Object apply;
        Object apply2;
        try {
            if (!hf(obj)) {
                if (obj != null) {
                    xj(null, obj, u(obj), false);
                    return;
                }
                return;
            }
            Function AYUAbz2 = AaHO0E.AYUAbz(obj);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -8999924);
            sparseArray.put(-99999985, Object.class);
            apply = AYUAbz2.apply(sparseArray);
            if (apply != null) {
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(-99999987, -8999923);
                sparseArray2.put(-99999985, String.class);
                apply2 = AYUAbz2.apply(sparseArray2);
                xj(AYUAbz2, apply, (String) apply2, true);
            }
        } catch (Throwable th) {
            pl.hf("HookObject", "register object  " + obj + " failed for: " + th.getMessage());
        }
    }

    public static class hf implements xj {
        Function hf;
        Object xj;

        public hf(Object obj) {
            this.xj = obj;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void hf(String str, String str2) {
            if (this.hf != null) {
                xj(-8999901, str, str2, null);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).d(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void kd(String str, String str2) {
            if (this.hf != null) {
                xj(-8999905, str, str2, null);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).e(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void u(String str, String str2) {
            if (this.hf != null) {
                xj(-8999903, str, str2, null);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).w(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void w(String str, String str2) {
            if (this.hf != null) {
                xj(-8999902, str, str2, null);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).i(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void xj(String str, String str2) {
            if (this.hf != null) {
                xj(-8999900, str, str2, null);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).v(str, str2);
            }
        }

        public hf(Function<SparseArray<Object>, Object> function) {
            this.hf = function;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void hf(String str, String str2, Throwable th) {
            if (this.hf != null) {
                xj(-8999905, str, str2, th);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).e(str, str2, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void xj(String str, String str2, Throwable th) {
            if (this.hf != null) {
                xj(-8999903, str, str2, th);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).w(str, str2, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void xj(String str, Throwable th) {
            if (this.hf != null) {
                xj(-8999905, str, null, th);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).e(str, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
        public void xj() {
            if (this.hf != null) {
                SparseArray sparseArray = new SparseArray();
                A2egSU.B2KMhB(-8999907, sparseArray, -99999987, -99999985, Void.class);
                this.hf.apply(sparseArray);
            }
            Object obj = this.xj;
            if (obj != null) {
                ((TTILog) obj).flush();
            }
        }

        private void xj(int i, String str, String str2, Throwable th) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(i, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(-8999920, str);
            sparseArray.put(-8999921, str2);
            sparseArray.put(-8999922, th);
            this.hf.apply(sparseArray);
        }
    }

    private static void hf(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        Object apply;
        if (pl.w()) {
            com.bytedance.sdk.openadsdk.c.w wVar = new com.bytedance.sdk.openadsdk.c.w();
            com.bytedance.sdk.openadsdk.c.w.xj = wVar;
            try {
                for (Method method : obj.getClass().getDeclaredMethods()) {
                    if (z) {
                        SparseArray sparseArray = new SparseArray();
                        sparseArray.put(-99999987, -8999909);
                        sparseArray.put(-99999985, Integer.class);
                        sparseArray.put(-8999925, method);
                        apply = function.apply(sparseArray);
                        Integer num = (Integer) apply;
                        if (num != null) {
                            method.setAccessible(true);
                            wVar.xj(num.intValue(), method);
                        }
                    } else {
                        TTM ttm = (TTM) method.getAnnotation(TTM.class);
                        if (ttm != null) {
                            method.setAccessible(true);
                            wVar.xj(ttm.value(), method);
                        }
                    }
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
            wVar.xj(obj);
        }
    }

    private static void xj(Function<SparseArray<Object>, Object> function, Object obj, String str, boolean z) {
        if (obj == null) {
            return;
        }
        str.getClass();
        if (str.equals("log")) {
            xj(function, obj, z);
        } else if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            hf(function, obj, z);
        }
        pl.hf("HookObject", "register object  " + obj + " successed~ ");
    }

    private static void xj(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        try {
            if (z) {
                LogAdapter.xj((xj) new hf(function), true);
            } else if (obj instanceof TTILog) {
                LogAdapter.xj((xj) new hf(obj), true);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public static com.bytedance.sdk.openadsdk.c.hf xj(String str) {
        str.getClass();
        if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            return com.bytedance.sdk.openadsdk.c.w.xj;
        }
        return null;
    }
}
