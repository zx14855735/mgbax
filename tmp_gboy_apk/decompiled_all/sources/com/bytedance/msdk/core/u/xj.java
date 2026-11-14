package com.bytedance.msdk.core.u;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static Map<String, C0060xj> xj = new ConcurrentHashMap();

    /* renamed from: com.bytedance.msdk.core.u.xj$xj, reason: collision with other inner class name */
    public static class C0060xj {
        String hf;
        Map<String, String> u;
        double w;
        String xj;

        public C0060xj(String str, String str2, double d, Map<String, String> map) {
            this.xj = str2;
            this.w = d;
            this.u = map;
            this.hf = str;
        }
    }

    static {
        rZjE();
    }

    private static /* synthetic */ void rZjE() {
        char[] charArray = "\u001a\u0016\u0014W\u001e\u0018\u0014\u001cW\u001b\u0016\u0000W\n\u0011\u001c\u0015\u0015W3\u0017\u0010;\u000b\u0010\u001d\u001e\u001c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'y');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001a\u0015\u0010\u0017\u0010\r".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(com.bytedance.msdk.api.xj.hf hfVar, tf tfVar, Map<String, Object> map) {
        C0060xj c0060xj;
        if (hfVar == null || tfVar == null || map == null || !tfVar.j() || !"baidu".equals(tfVar.qt()) || (c0060xj = xj.get(hfVar.ra())) == null) {
            return;
        }
        map.put(MediationConstant.BIDDING_WIN_ADN, c0060xj.xj);
        map.put(MediationConstant.BIDDING_WIN_PRICE, Double.valueOf(c0060xj.w));
        boolean qd = com.bytedance.msdk.core.hf.hf().qd();
        map.put(MediationConstant.BIDDING_IS_OPEN_ECPM, Boolean.valueOf(qd));
        if (qd) {
            map.put(MediationConstant.BIDDING_REQUEST_ID_MAP, c0060xj.u);
            map.put(MediationConstant.BIDDING_WIN_ADN_ID, c0060xj.hf);
        }
    }

    public static void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.tf.hf hfVar2, List<com.bytedance.msdk.hf.w> list, List<com.bytedance.msdk.hf.w> list2) {
        HashMap hashMap;
        com.bytedance.msdk.hf.w wVar;
        if (hfVar == null || hfVar2 == null || list == null || list.size() == 0 || !hfVar.wo() || !xj(hfVar2)) {
            return;
        }
        Iterator<com.bytedance.msdk.hf.w> it = list.iterator();
        while (true) {
            hashMap = null;
            if (!it.hasNext()) {
                wVar = null;
                break;
            }
            wVar = it.next();
            if (wVar != null && "baidu".equals(wVar.lw())) {
                break;
            }
        }
        if (wVar == null) {
            wVar = list.get(0);
        }
        if (wVar != null) {
            if (com.bytedance.msdk.core.hf.hf().qd() && (list2 != null || list2.size() != 0)) {
                hashMap = new HashMap();
                for (com.bytedance.msdk.hf.w wVar2 : list2) {
                    hashMap.put(wVar2.cy(), wVar2.ir());
                }
            }
            xj.put(hfVar2.ff(), new C0060xj(wVar.cy(), wVar.lw(), wVar.da(), hashMap));
        }
    }

    private static boolean xj(com.bytedance.msdk.core.tf.hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        for (tf tfVar : hfVar.yy()) {
            if (TextUtils.equals(tfVar.qt(), "baidu") && tfVar.j()) {
                return true;
            }
        }
        return false;
    }
}
