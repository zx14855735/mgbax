package com.bytedance.sdk.openadsdk.core.multipro.aidl.xj;

import J3FDQU.A2egSU;
import android.os.RemoteCallbackList;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.e;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    private static volatile hf hf;
    private static Map<String, RemoteCallbackList<e>> xj = A2egSU.BIYEnU();

    static {
        Gtoy();
    }

    private static /* synthetic */ void Gtoy() {
        char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 6);
        }
        String str = new String(charArray);
        char[] charArray2 = "ejohor".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 6);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static hf hf() {
        if (hf == null) {
            synchronized (hf.class) {
                try {
                    if (hf == null) {
                        hf = new hf();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void xj(String str, e eVar) {
        RemoteCallbackList<e> remoteCallbackList = xj.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(eVar);
        xj.put(str, remoteCallbackList);
        pl.u("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        pl.u("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + xj.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void hf(String str, e eVar) {
        Map<String, RemoteCallbackList<e>> map = xj;
        if (map == null) {
            pl.u("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        RemoteCallbackList<e> remove = map.remove(str);
        if (remove == null) {
            pl.u("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        xj(remove);
        pl.u("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        pl.u("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + xj.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void xj(String str, String str2, long j, long j2, String str3, String str4) {
        hf(str, str2, j, j2, str3, str4);
    }

    private void xj(RemoteCallbackList<e> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        e broadcastItem = remoteCallbackList.getBroadcastItem(i);
                        if (broadcastItem != null) {
                            ((com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y) broadcastItem).w();
                        }
                    } catch (Throwable th) {
                        pl.w("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                pl.w("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }

    private synchronized void hf(String str, String str2, long j, long j2, String str3, String str4) {
        e broadcastItem;
        try {
            if (xj == null) {
                return;
            }
            if ("recycleRes".equals(str2)) {
                xj(xj.remove(str));
                pl.u("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:".concat(String.valueOf(str)));
                pl.u("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + xj.size());
                return;
            }
            RemoteCallbackList<e> remoteCallbackList = xj.get(str);
            if (remoteCallbackList != null) {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        broadcastItem = remoteCallbackList.getBroadcastItem(i);
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (broadcastItem != null) {
                        if ("onIdle".equals(str2)) {
                            broadcastItem.xj();
                        } else if ("onDownloadActive".equals(str2)) {
                            broadcastItem.xj(j, j2, str3, str4);
                        } else if ("onDownloadPaused".equals(str2)) {
                            broadcastItem.hf(j, j2, str3, str4);
                        } else {
                            if ("onDownloadFailed".equals(str2)) {
                                try {
                                    broadcastItem.w(j, j2, str3, str4);
                                } catch (Throwable th2) {
                                    th = th2;
                                    pl.w("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                }
                            } else if ("onDownloadFinished".equals(str2)) {
                                broadcastItem.xj(j, str3, str4);
                            } else if ("onInstalled".equals(str2)) {
                                broadcastItem.xj(str3, str4);
                            }
                        }
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th3) {
            pl.w("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th3);
        }
    }
}
