package com.bytedance.sdk.openadsdk.core.x;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl {
    private static final HashMap<String, g> xj = new HashMap<>();

    static {
        ToPN();
    }

    private static /* synthetic */ void ToPN() {
        char[] charArray = "fjh+bdh`+gj|+vm`ii+OklGwlab`".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 5);
        }
        String str = new String(charArray);
        char[] charArray2 = "filklq".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 5);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(ws wsVar) {
        w wVar = (w) com.bytedance.sdk.openadsdk.ats.w.xj("pitaya");
        if (wVar != null && wVar.isPitayaInitSuccess() && wVar.isPitayaEnvAvailable() && p.hf() && wsVar != null && wsVar.gh() != null) {
            String zf = wsVar.zf();
            String jq = wsVar.jq();
            String u = wsVar.gh().u();
            if (TextUtils.isEmpty(u)) {
                return;
            }
            g gVar = new g();
            gVar.xj(1);
            gVar.xj(zf);
            gVar.hf(jq);
            xj.put(u, gVar);
        }
    }
}
