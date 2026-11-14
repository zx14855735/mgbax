package com.bytedance.sdk.openadsdk.core.pl;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static final LruCache<String, com.bytedance.sdk.openadsdk.core.ra.u> xj = new LruCache<>(10);

    static {
        ySQopF();
    }

    public static void xj(String str, com.bytedance.sdk.openadsdk.core.ra.u uVar) {
        if (pz.hf().lt() && !TextUtils.isEmpty(str) && uVar != null && uVar.kd()) {
            xj.put(str, uVar);
        }
    }

    private static /* synthetic */ void ySQopF() {
        char[] charArray = ";75v?95=v:7!v+0=44v\u001261\u001a*1<?=".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'X');
        }
        String str = new String(charArray);
        char[] charArray2 = ";4161,".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'X');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.bytedance.sdk.openadsdk.core.ra.u xj(String str) {
        com.bytedance.sdk.openadsdk.core.ra.u uVar;
        if (pz.hf().lt() && (uVar = xj.get(str)) != null && uVar.kd()) {
            return uVar;
        }
        return null;
    }

    public static void xj(final ws wsVar) {
        if (pz.hf().lt() && wsVar != null) {
            final String hf = wsVar.vh() != null ? wsVar.vh().hf() : "";
            if (!TextUtils.isEmpty(hf) && wsVar.vw() == 4 && TextUtils.isEmpty(wsVar.lp())) {
                if ((wsVar.kc() == null || wsVar.kc().hf() == 0) && tf.xj(wsVar) == 2) {
                    com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("preloadAppInfo") { // from class: com.bytedance.sdk.openadsdk.core.pl.xj.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pz.xj().xj(wsVar, hf);
                        }
                    });
                }
            }
        }
    }
}
