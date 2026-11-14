package com.bytedance.sdk.openadsdk.core.component.reward;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.tf.tf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.am;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.kd;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.u;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    protected static HashMap<Integer, am> xj = new HashMap<>();
    private static final ExecutorService hf = com.bytedance.sdk.component.tf.w.xj(new tf("RewardFullCallback"));

    static {
        emXsZO();
    }

    private static /* synthetic */ void emXsZO() {
        char[] charArray = "xtv5|zv~5ytb5hs~ww5QurYir\u007f|~".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 27);
        }
        String str = new String(charArray);
        char[] charArray2 = "xwruro".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 27);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(final int i, final String str, final String str2, final Bundle bundle) {
        hf.execute(new d("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.1
            @Override // java.lang.Runnable
            public void run() {
                am amVar = xj.xj.get(Integer.valueOf(i));
                if (amVar == null) {
                    amVar = am.xj.xj(com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext()).xj(i));
                    xj.xj.put(Integer.valueOf(i), amVar);
                }
                if (amVar == null) {
                    return;
                }
                try {
                    int i2 = i;
                    if (i2 == 0) {
                        amVar.xj(str, str2, bundle);
                    } else if (i2 == 1) {
                        amVar.xj(str, str2);
                    } else {
                        if (i2 != 5) {
                            return;
                        }
                        amVar.hf(str, str2, bundle);
                    }
                } catch (RemoteException e) {
                    pl.xj(e);
                }
            }
        });
    }

    public static void xj(final String str, final com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar) {
        hf.execute(new d("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.xj xj2 = com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext());
                if (xjVar != null) {
                    kd kdVar = new kd(xjVar);
                    am xj3 = am.xj.xj(xj2.xj(0));
                    if (xj3 != null) {
                        try {
                            xj3.xj(str, kdVar);
                        } catch (RemoteException e) {
                            pl.xj(e);
                        }
                    }
                }
            }
        });
    }

    public static void xj(final String str, final com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf hfVar) {
        hf.execute(new d("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.xj xj2 = com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext());
                if (hfVar != null) {
                    u uVar = new u(hfVar);
                    am xj3 = am.xj.xj(xj2.xj(5));
                    if (xj3 != null) {
                        try {
                            xj3.xj(str, uVar);
                        } catch (RemoteException e) {
                            pl.xj(e);
                        }
                    }
                }
            }
        });
    }

    public static void xj(final String str, final com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar) {
        hf.execute(new d("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.xj xj2 = com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext());
                if (xjVar != null) {
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.w wVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.w(xjVar);
                    am xj3 = am.xj.xj(xj2.xj(1));
                    if (xj3 != null) {
                        try {
                            xj3.xj(str, wVar);
                        } catch (RemoteException e) {
                            pl.xj(e);
                        }
                    }
                }
            }
        });
    }
}
