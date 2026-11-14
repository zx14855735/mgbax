package com.bytedance.msdk.core.f;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf {
    private static final String xj = "TTMediationSDK_tf";
    private Map<String, d> hf;
    private com.bytedance.msdk.kd.xj.w<d> w;

    public static class xj {
        private static tf xj = new tf();

        static {
            KgUOUK();
        }

        private static /* synthetic */ void KgUOUK() {
            char[] charArray = "´¸ºù°¶º²ùµ¸®ù¤¿²»»ù\u009d¹¾\u0095¥¾³°²".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 215);
            }
            String str = new String(charArray);
            char[] charArray2 = "´»¾¹¾£".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 215);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static tf xj() {
        return xj.xj;
    }

    public d hf(String str) {
        if (this.w == null) {
            return null;
        }
        Map<String, d> map = this.hf;
        d dVar = map != null ? map.get(str) : null;
        if (dVar != null) {
            return dVar;
        }
        d query = this.w.query(str);
        if (query != null) {
            this.hf.put(query.hf(), query);
        }
        return query;
    }

    private tf() {
        this.w = new com.bytedance.msdk.kd.xj.u(com.bytedance.msdk.core.hf.getContext());
        this.hf = new ConcurrentHashMap();
    }

    public void xj(String str, long j) {
        if (this.w != null) {
            Map<String, d> map = this.hf;
            d dVar = map != null ? map.get(str) : null;
            if (dVar != null) {
                dVar.xj(j);
            }
            this.w.xj(str, j);
        }
    }

    public d hf(String str, String str2) {
        d dVar = null;
        if (this.w == null) {
            return null;
        }
        Map<String, d> map = this.hf;
        if (map != null) {
            dVar = map.get(str + "_" + str2);
        }
        if (dVar != null) {
            return dVar;
        }
        d query = this.w.query(str, str2);
        if (query != null) {
            this.hf.put(query.u(), query);
        }
        return query;
    }

    public void xj(String str, String str2, long j) {
        d dVar;
        if (this.w != null) {
            Map<String, d> map = this.hf;
            if (map != null) {
                dVar = map.get(str + "_" + str2);
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.xj(j);
            }
            this.w.xj(str, str2, j);
        }
    }

    public void xj(String str) {
        if (this.w != null) {
            Map<String, d> map = this.hf;
            if (map != null) {
                map.remove(str);
            }
            this.w.delete(str);
        }
    }

    public void xj(String str, String str2) {
        if (this.w != null) {
            Map<String, d> map = this.hf;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.w.delete(str, str2);
        }
    }

    public void xj(d dVar) {
        if (this.w == null || TextUtils.isEmpty(dVar.tf())) {
            return;
        }
        Map<String, d> map = this.hf;
        if (map != null) {
            map.put(dVar.u(), dVar);
        }
        this.w.hf(dVar);
    }
}
