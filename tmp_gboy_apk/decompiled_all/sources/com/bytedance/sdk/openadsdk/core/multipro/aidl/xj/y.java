package com.bytedance.sdk.openadsdk.core.multipro.aidl.xj;

import J3FDQU.A2egSU;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.bytedance.sdk.openadsdk.core.qt;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends xj {
    private static volatile y hf;
    private static final Map<String, RemoteCallbackList<qt>> xj = A2egSU.BIYEnU();

    static {
        qZRSX();
    }

    public static y hf() {
        if (hf == null) {
            synchronized (y.class) {
                try {
                    if (hf == null) {
                        hf = new y();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    private static /* synthetic */ void qZRSX() {
        char[] charArray = "æêè«âäèà«çêü«öíàéé«ÏëìÇ÷ìáâà".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 133);
        }
        String str = new String(charArray);
        char[] charArray2 = "æéìëìñ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 133);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private synchronized Bundle w(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<qt>> map = xj;
            if (map != null) {
                RemoteCallbackList<qt> remove = "recycleRes".equals(str2) ? map.remove(str) : map.get(str);
                if (remove != null) {
                    int beginBroadcast = remove.beginBroadcast();
                    for (int i = 0; i < beginBroadcast; i++) {
                        try {
                            qt broadcastItem = remove.getBroadcastItem(i);
                            if (broadcastItem != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = broadcastItem.xj(bundle.getInt("callback_extra_key_next_play_again_count"));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remove.kill();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return bundle2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void xj(String str, qt qtVar) {
        RemoteCallbackList<qt> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(qtVar);
        xj.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public Bundle hf(String str, String str2, Bundle bundle) {
        return w(str, str2, bundle);
    }
}
