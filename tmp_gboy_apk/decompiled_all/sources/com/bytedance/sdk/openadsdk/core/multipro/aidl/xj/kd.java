package com.bytedance.sdk.openadsdk.core.multipro.aidl.xj;

import J3FDQU.A2egSU;
import android.os.RemoteCallbackList;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.g;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends xj {
    private static volatile kd hf;
    private static Map<String, RemoteCallbackList<g>> xj = A2egSU.BIYEnU();

    static {
        fBxm();
    }

    private static /* synthetic */ void fBxm() {
        char[] charArray = "ÑÝß\u009cÕÓß×\u009cÐÝË\u009cÁÚ×ÞÞ\u009cøÜÛðÀÛÖÕ×".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 178);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÑÞÛÜÛÆ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 178);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static kd hf() {
        if (hf == null) {
            synchronized (kd.class) {
                try {
                    if (hf == null) {
                        hf = new kd();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    private synchronized void w(String str, String str2) {
        try {
            if (xj != null) {
                RemoteCallbackList<g> remove = "recycleRes".equals(str2) ? xj.remove(str) : xj.get(str);
                if (remove != null) {
                    int beginBroadcast = remove.beginBroadcast();
                    for (int i = 0; i < beginBroadcast; i++) {
                        try {
                            g broadcastItem = remove.getBroadcastItem(i);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.hf();
                                } else if ("onAdClose".equals(str2)) {
                                    broadcastItem.u();
                                } else if ("onVideoComplete".equals(str2)) {
                                    broadcastItem.kd();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    broadcastItem.y();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    broadcastItem.w();
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.xj();
                                }
                            }
                        } catch (Throwable th) {
                            pl.w("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            pl.w("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public synchronized void xj(String str, g gVar) {
        RemoteCallbackList<g> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(gVar);
        xj.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void xj(String str, String str2) {
        w(str, str2);
    }
}
