package com.bytedance.sdk.openadsdk.core.multipro.aidl.xj;

import android.os.RemoteCallbackList;
import com.bytedance.sdk.openadsdk.core.pl;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends xj {
    private static volatile u hf;
    private static HashMap<String, RemoteCallbackList<pl>> xj = new HashMap<>();

    static {
        hFfKi();
    }

    private static /* synthetic */ void hFfKi() {
        char[] charArray = "\u0081\u008d\u008fÌ\u0085\u0083\u008f\u0087Ì\u0080\u008d\u009bÌ\u0091\u008a\u0087\u008e\u008eÌ¨\u008c\u008b \u0090\u008b\u0086\u0085\u0087".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 226);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0081\u008e\u008b\u008c\u008b\u0096".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 226);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static u hf() {
        if (hf == null) {
            synchronized (u.class) {
                try {
                    if (hf == null) {
                        hf = new u();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void xj(String str, pl plVar) {
        if (plVar == null) {
            return;
        }
        RemoteCallbackList<pl> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(plVar);
        xj.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void hf(String str, String str2) {
        RemoteCallbackList<pl> remove = xj.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            pl broadcastItem = remove.getBroadcastItem(i);
            if (broadcastItem != null) {
                if (str2 == null) {
                    broadcastItem.xj();
                } else {
                    broadcastItem.xj(str2);
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }
}
