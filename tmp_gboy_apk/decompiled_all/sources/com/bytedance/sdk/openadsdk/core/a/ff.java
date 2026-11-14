package com.bytedance.sdk.openadsdk.core.a;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ff {
    private static final Set<Integer> xj = new CopyOnWriteArraySet();
    private static final com.bytedance.sdk.component.utils.ra hf = new com.bytedance.sdk.component.utils.ra() { // from class: com.bytedance.sdk.openadsdk.core.a.ff.1
        @Override // com.bytedance.sdk.component.utils.ra
        public boolean xj(int i) {
            if (com.bytedance.sdk.openadsdk.core.pz.hf().oz()) {
                return ff.xj.contains(Integer.valueOf(i));
            }
            return true;
        }
    };

    static {
        ekOhJn();
    }

    private static /* synthetic */ void ekOhJn() {
        char[] charArray = "ÏÃÁ\u0082ËÍÁÉ\u0082ÎÃÕ\u0082ßÄÉÀÀ\u0082æÂÅîÞÅÈËÉ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 172);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÏÀÅÂÅØ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 172);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.bytedance.sdk.component.widget.hf.xj xj(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        com.bytedance.sdk.component.widget.hf.xj xjVar = new com.bytedance.sdk.component.widget.hf.xj();
        xjVar.xj(wsVar.kd());
        xjVar.xj(wsVar.jf());
        xjVar.hf(wsVar.ho());
        return xjVar;
    }

    public static void hf(int i) {
        xj.remove(Integer.valueOf(i));
        hf.hf(i);
    }

    public static void xj() {
        if (com.bytedance.sdk.openadsdk.core.pz.hf().oz()) {
            com.bytedance.sdk.component.utils.ht.xj(hf);
        } else {
            xj.clear();
        }
    }

    public static void xj(int i) {
        if (com.bytedance.sdk.openadsdk.core.pz.hf().oz()) {
            xj.add(Integer.valueOf(i));
        }
        hf.w(i);
    }
}
