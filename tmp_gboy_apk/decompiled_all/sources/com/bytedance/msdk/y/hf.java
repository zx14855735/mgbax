package com.bytedance.msdk.y;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.kd.y;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static final Map<String, Boolean> xj = new ConcurrentHashMap();

    static {
        DZzIM();
    }

    private static /* synthetic */ void DZzIM() {
        char[] charArray = "\u0098\u0094\u0096Õ\u009c\u009a\u0096\u009eÕ\u0099\u0094\u0082Õ\u0088\u0093\u009e\u0097\u0097Õ±\u0095\u0092¹\u0089\u0092\u009f\u009c\u009e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 251);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0098\u0097\u0092\u0095\u0092\u008f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 251);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static final synchronized boolean hf(String str) {
        synchronized (hf.class) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = xj.get(str);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    public static final synchronized void xj(String str) {
        synchronized (hf.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            xj.put(str, Boolean.TRUE);
        }
    }

    public static synchronized void xj(Context context, List<com.bytedance.msdk.core.tf.xj> list) {
        synchronized (hf.class) {
            if (list != null) {
                for (com.bytedance.msdk.core.tf.xj xjVar : list) {
                    final com.bytedance.msdk.api.u.xj.hf.w.hf u = xjVar.u();
                    try {
                        if (!hf(xjVar.y())) {
                            xj(context, u, new com.bytedance.msdk.xj.xj.w() { // from class: com.bytedance.msdk.y.hf.1
                                @Override // com.bytedance.msdk.xj.xj.w
                                public void xj() {
                                    com.bytedance.msdk.y.hf.xj.xj(com.bytedance.msdk.api.u.xj.hf.w.hf.this.hf(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
                                }

                                @Override // com.bytedance.msdk.xj.xj.w
                                public void xj(com.bytedance.msdk.api.xj xjVar2) {
                                    if (xjVar2 != null) {
                                        com.bytedance.msdk.y.hf.xj.xj(com.bytedance.msdk.api.u.xj.hf.w.hf.this.hf(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + xjVar2.xj + " errorMessage = " + xjVar2.hf));
                                    }
                                }
                            });
                            xj(xjVar.y());
                        }
                    } catch (Exception e) {
                        pl.xj(e);
                        com.bytedance.msdk.y.hf.xj.xj(u.hf(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, e.toString()));
                        y.xj(u.hf(), (com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, (tf) null, new com.bytedance.msdk.api.xj(49013, e.toString()));
                    }
                }
                return;
            }
            y.xj("", (com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, (tf) null, new com.bytedance.msdk.api.xj(49013, "获取的自定义Adapter总配置为null"));
        }
    }

    private static com.bytedance.msdk.api.u.xj.hf.y.xj xj(com.bytedance.msdk.api.u.xj.hf.w.hf hfVar, com.bytedance.msdk.xj.xj.w wVar) {
        com.bytedance.msdk.api.u.xj.hf.y.xj xj2 = com.bytedance.msdk.y.hf.xj.u().xj(hfVar.hf());
        if (xj2 != null) {
            return xj2;
        }
        com.bytedance.msdk.api.u.xj.hf.y.xj xjVar = new com.bytedance.msdk.api.u.xj.hf.y.xj();
        com.bytedance.msdk.y.hf.xj.u().xj(hfVar.hf(), xjVar);
        return xjVar;
    }

    private static void xj(Context context, com.bytedance.msdk.api.u.xj.hf.w.hf hfVar, com.bytedance.msdk.xj.xj.w wVar) {
        if (hfVar == null || TextUtils.isEmpty(hfVar.w())) {
            if (hfVar == null) {
                throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置为null");
            }
            throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置初始化类名为空");
        }
        com.bytedance.msdk.api.u.xj.hf.y.xj xj2 = xj(hfVar, wVar);
        if (xj2 != null) {
            if (!xj2.hf()) {
                xj(context, hfVar, xj2);
            }
            wVar.xj();
            return;
        }
        throw new Exception("GMCustomAdapterConfiguration is null");
    }

    private static void xj(Context context, com.bytedance.msdk.api.u.xj.hf.w.hf hfVar, com.bytedance.msdk.api.u.xj.hf.y.xj xjVar) {
        if (context == null) {
            y.xj(hfVar.hf(), (com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, (tf) null, new com.bytedance.msdk.api.xj(49013, "context为null"));
            return;
        }
        try {
            xjVar.xj(context.getApplicationContext(), hfVar, com.bytedance.msdk.core.xj.p().et());
        } catch (Exception e) {
            y.xj(hfVar.hf(), (com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, (tf) null, new com.bytedance.msdk.api.xj(49013, "调用自定义Adapter初始化方法出现异常 ".concat(e.getClass().getName())));
            pl.xj(e);
        }
    }

    public static synchronized void xj(Context context, String str) {
        synchronized (hf.class) {
            if (!hf(str)) {
                xj(context, com.bytedance.msdk.c.xj.hf.xj().hf());
            }
        }
    }
}
