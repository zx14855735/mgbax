package com.bykv.vk.openvk.component.video.xj.xj.hf;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.kd.xj;
import com.bykv.vk.openvk.component.video.api.w.u;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public static final ConcurrentHashMap<String, hf> xj = new ConcurrentHashMap<>();

    static {
        MlnV();
    }

    private static /* synthetic */ void MlnV() {
        char[] charArray = "\u0084\u0088\u008aÉ\u0080\u0086\u008a\u0082É\u0085\u0088\u009eÉ\u0094\u008f\u0082\u008b\u008bÉ\u00ad\u0089\u008e¥\u0095\u008e\u0083\u0080\u0082".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 231);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0084\u008b\u008e\u0089\u008e\u0093".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 231);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized void xj(Context context, u uVar, xj.InterfaceC0012xj interfaceC0012xj) {
        synchronized (w.class) {
            if (uVar == null) {
                com.bykv.vk.openvk.component.video.api.y.w.xj(" url、dir and hash is must property   in VideoInfoModel");
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                ConcurrentHashMap<String, hf> concurrentHashMap = xj;
                hf hfVar = concurrentHashMap.get(uVar.e());
                if (hfVar == null) {
                    hfVar = new hf(context, uVar);
                    concurrentHashMap.put(uVar.e(), hfVar);
                    uVar.y();
                    uVar.e();
                }
                hfVar.xj(interfaceC0012xj);
            }
            uVar.y();
            uVar.e();
        }
    }

    public static synchronized void xj(u uVar) {
        synchronized (w.class) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    hf remove = xj.remove(uVar.e());
                    if (remove != null) {
                        remove.xj(true);
                    }
                    uVar.y();
                    uVar.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
