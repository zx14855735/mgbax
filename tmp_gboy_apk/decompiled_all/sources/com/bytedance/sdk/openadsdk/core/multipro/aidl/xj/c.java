package com.bytedance.sdk.openadsdk.core.multipro.aidl.xj;

import J3FDQU.A2egSU;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.n;
import com.bytedance.sdk.openadsdk.core.zg;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends xj {
    private static volatile c hf;
    private static Map<String, RemoteCallbackList<zg>> xj = A2egSU.BIYEnU();

    static {
        qlyLx();
    }

    public static c hf() {
        if (hf == null) {
            synchronized (c.class) {
                try {
                    if (hf == null) {
                        hf = new c();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    private static /* synthetic */ void qlyLx() {
        char[] charArray = "kge&oiem&jgq&{`mdd&BfaJzalom".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\b');
        }
        String str = new String(charArray);
        char[] charArray2 = "kdafa|".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private synchronized void w(String str, String str2, Bundle bundle) {
        RemoteCallbackList<zg> remoteCallbackList;
        RemoteCallbackList<zg> remoteCallbackList2;
        try {
            if (xj != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = xj.remove(str);
                    remoteCallbackList2 = xj.remove(n.xj(str));
                } else {
                    remoteCallbackList = xj.get(str);
                    remoteCallbackList2 = null;
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i = 0; i < beginBroadcast; i++) {
                        try {
                            zg broadcastItem = remoteCallbackList.getBroadcastItem(i);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.hf();
                                } else if ("onAdClose".equals(str2)) {
                                    broadcastItem.u();
                                } else if ("onVideoComplete".equals(str2)) {
                                    broadcastItem.kd();
                                } else if ("onVideoError".equals(str2)) {
                                    broadcastItem.y();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    broadcastItem.w();
                                } else if ("onRewardVerify".equals(str2)) {
                                    xj(broadcastItem, bundle);
                                } else if ("onRewardArrived".equals(str2)) {
                                    hf(broadcastItem, bundle);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    broadcastItem.c();
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.xj();
                                }
                            }
                        } catch (Throwable th) {
                            pl.w("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
                if (remoteCallbackList2 != null) {
                    int beginBroadcast2 = remoteCallbackList2.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast2; i2++) {
                        try {
                            zg broadcastItem2 = remoteCallbackList2.getBroadcastItem(i2);
                            if (broadcastItem2 != null && "recycleRes".equals(str2)) {
                                broadcastItem2.xj();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackList2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList2.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            pl.w("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public synchronized void xj(String str, zg zgVar) {
        RemoteCallbackList<zg> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(zgVar);
        xj.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj, com.bytedance.sdk.openadsdk.core.am
    public void xj(String str, String str2, Bundle bundle) {
        w(str, str2, bundle);
    }

    private void xj(zg zgVar, Bundle bundle) {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        zgVar.xj(z, i, string != null ? string : "", i2, string2 != null ? string2 : "");
    }

    private void hf(zg zgVar, Bundle bundle) {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_type");
        zgVar.xj(z, i, wo.xj(i, bundle));
    }
}
