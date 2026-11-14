package com.bytedance.sdk.openadsdk.core.multipro.aidl.xj;

import android.os.RemoteCallbackList;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    private static volatile w hf;
    public static HashMap<String, RemoteCallbackList<p>> xj = new HashMap<>();

    static {
        dnYLcKO();
    }

    private static /* synthetic */ void dnYLcKO() {
        char[] charArray = "ÕÙÛ\u0098Ñ×ÛÓ\u0098ÔÙÏ\u0098ÅÞÓÚÚ\u0098üØßôÄßÒÑÓ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 182);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÕÚßØßÂ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 182);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static w hf() {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new w();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void xj(String str, p pVar) {
        if (pVar == null) {
            return;
        }
        RemoteCallbackList<p> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(pVar);
        xj.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void xj(String str, int i) {
        RemoteCallbackList<p> remove = xj.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            p broadcastItem = remove.getBroadcastItem(i2);
            if (broadcastItem != null) {
                if (i == 1) {
                    broadcastItem.xj();
                } else if (i == 2) {
                    broadcastItem.hf();
                } else if (i != 3) {
                    broadcastItem.w();
                } else {
                    broadcastItem.w();
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }
}
