package com.bytedance.msdk.core.f;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private static final String xj = "TTMediationSDK_f";
    private Map<String, c> hf;
    private com.bytedance.msdk.kd.xj.xj<c> w;

    public static class xj {
        private static f xj = new f();

        static {
            wAIirFs();
        }

        private static /* synthetic */ void wAIirFs() {
            char[] charArray = "?31r;=19r>3%r/4900r\u001625\u001e.58;9".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '\\');
            }
            String str = new String(charArray);
            char[] charArray2 = "?0525(".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '\\');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static f xj() {
        return xj.xj;
    }

    public c hf(String str) {
        if (this.w != null) {
            Map<String, c> map = this.hf;
            c cVar = map != null ? map.get(str) : null;
            if (cVar != null) {
                return cVar;
            }
            c query = this.w.query(str);
            if (query != null) {
                Map<String, c> map2 = this.hf;
                if (map2 != null) {
                    map2.put(query.u(), query);
                }
                return query;
            }
        }
        return null;
    }

    private f() {
        this.w = new com.bytedance.msdk.kd.xj.hf(com.bytedance.msdk.core.hf.getContext());
        this.hf = new ConcurrentHashMap();
    }

    public void xj(String str) {
        if (this.w != null) {
            Map<String, c> map = this.hf;
            if (map != null) {
                map.remove(str);
            }
            this.w.delete(str);
        }
    }

    public void xj(String str, String str2) {
        if (this.w != null) {
            Map<String, c> map = this.hf;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.w.delete(str, str2);
        }
    }

    public c hf(String str, String str2) {
        c cVar;
        if (this.w != null) {
            Map<String, c> map = this.hf;
            if (map != null) {
                cVar = map.get(str + "_" + str2);
            } else {
                cVar = null;
            }
            if (cVar != null) {
                return cVar;
            }
            c query = this.w.query(str, str2);
            if (query != null) {
                Map<String, c> map2 = this.hf;
                if (map2 != null) {
                    map2.put(query.u(), query);
                }
                return query;
            }
        }
        return null;
    }

    public void xj(c cVar) {
        c hf;
        kd kdVar;
        if (cVar.xj()) {
            hf = hf(cVar.hf(), cVar.w());
        } else {
            hf = hf(cVar.hf());
        }
        if (hf == null) {
            if (this.w != null) {
                Map<String, c> map = this.hf;
                if (map != null) {
                    map.put(cVar.u(), cVar);
                }
                this.w.hf(cVar);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        for (kd kdVar2 : hf.p()) {
            hashMap.put(kdVar2.w(), kdVar2);
        }
        for (kd kdVar3 : cVar.p()) {
            if (hashMap.containsKey(kdVar3.w()) && (kdVar = (kd) hashMap.get(kdVar3.w())) != null) {
                kdVar3.xj(kdVar);
            }
        }
        Map<String, c> map2 = this.hf;
        if (map2 != null) {
            map2.put(cVar.u(), cVar);
        }
        hf(cVar);
    }

    public void hf(c cVar) {
        if (this.w != null) {
            Map<String, c> map = this.hf;
            if (map != null) {
                map.put(cVar.u(), cVar);
            }
            this.w.xj(cVar);
        }
    }

    public void xj(c cVar, String str, int i) {
        if (this.w != null) {
            cVar.xj(str, i);
            Map<String, c> map = this.hf;
            if (map != null) {
                map.put(cVar.u(), cVar);
            }
            this.w.xj(cVar);
        }
    }

    public void xj(c cVar, String str, long j) {
        if (this.w != null) {
            cVar.xj(str, j);
            Map<String, c> map = this.hf;
            if (map != null) {
                map.put(cVar.u(), cVar);
            }
            this.w.xj(cVar);
        }
    }
}
