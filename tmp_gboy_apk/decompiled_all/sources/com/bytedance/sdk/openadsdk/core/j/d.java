package com.bytedance.sdk.openadsdk.core.j;

import P8ccfD.AaHO0E;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    private static com.bytedance.sdk.openadsdk.core.w hf;
    private static PluginValueSet w;
    private static final AtomicInteger xj = new AtomicInteger(com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), "sync_switch", 0).getInt("status", 1));

    static {
        EcLsd();
    }

    private static /* synthetic */ void EcLsd() {
        char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 135);
        }
        String str = new String(charArray);
        char[] charArray2 = "äëîéîó".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 135);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean xj() {
        return xj.get() == 1;
    }

    public static void xj(int i) {
        com.bytedance.sdk.openadsdk.core.w wVar;
        if (i == 1 || i == 2) {
            com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), "sync_switch", 0).edit().putInt("status", i).apply();
            AtomicInteger atomicInteger = xj;
            int i2 = atomicInteger.get();
            atomicInteger.set(i);
            if (i2 != 2 || i != 1 || (wVar = hf) == null || wVar.xj()) {
                return;
            }
            try {
                hf.xj(pz.getContext(), w, new com.bytedance.sdk.openadsdk.core.wo.w(AaHO0E.AYUAbz(w.objectValue(15, AaHO0E.ARc23Z()))));
                hf = null;
                w = null;
            } catch (Throwable th) {
                pl.w("SdkSwitch", "init sdk error", th);
            }
        }
    }
}
