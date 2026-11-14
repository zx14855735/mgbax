package com.bytedance.msdk.y.hf;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private boolean c;
    protected com.bytedance.msdk.core.y.hf w;
    private boolean y;
    private static final com.bytedance.msdk.core.y.xj u = new com.bytedance.msdk.core.y.xj();
    private static Map<String, Pair<Boolean, String>> kd = new ConcurrentHashMap();
    private static final Map<String, Boolean> f = new ConcurrentHashMap();
    protected final AtomicBoolean xj = new AtomicBoolean(false);
    protected final AtomicBoolean hf = new AtomicBoolean(false);

    static {
        mZEt();
    }

    public static xj hf() {
        return new xj();
    }

    private static /* synthetic */ void mZEt() {
        char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 250);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 250);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.bytedance.msdk.core.y.xj u() {
        return u;
    }

    public static synchronized void w() {
        synchronized (xj.class) {
            com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.y.hf.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 start ---------------------");
                    for (Map.Entry entry : xj.kd.entrySet()) {
                        if (entry.getValue() != null) {
                            if (!((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                                com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化失败 " + ((String) ((Pair) entry.getValue()).second));
                            } else if (com.bytedance.msdk.core.hf.hf().w((String) entry.getKey())) {
                                com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 自定义ADN调用初始化方法成功，请开发者确保接入的自定义ADN初始化结果");
                            } else {
                                com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化成功");
                            }
                        }
                    }
                    com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 end ---------------------");
                }
            });
        }
    }

    public static void xj(String str, Pair<Boolean, String> pair) {
        kd.put(str, pair);
    }

    public void kd() {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.y.hf.xj.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.core.y.hf hfVar = xj.this.w;
                if (hfVar != null) {
                    hfVar.xj();
                }
            }
        });
    }

    public void y() {
        if (!this.y && this.c && this.xj.get() && this.hf.get()) {
            com.bytedance.msdk.y.xj.xj();
            w();
        }
    }

    public static Map<String, Object> hf(Map<String, Object> map, String str) {
        return u.hf(com.bytedance.msdk.core.hf.getContext(), map, str);
    }

    public static final synchronized boolean u(String str) {
        Boolean bool;
        synchronized (xj.class) {
            if (TextUtils.isEmpty(str) || (bool = f.get(str)) == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    public static int xj() {
        return kd.size();
    }

    public static final synchronized void w(String str) {
        synchronized (xj.class) {
            if (!TextUtils.isEmpty(str)) {
                f.put(str, Boolean.TRUE);
            }
        }
    }

    public static String xj(Map<String, Object> map, String str) {
        return u.xj(com.bytedance.msdk.core.hf.getContext(), map, str);
    }

    public void hf(Map<String, com.bytedance.msdk.core.tf.xj> map) {
        if (map == null) {
            return;
        }
        com.bytedance.msdk.core.tf.xj remove = map.remove(MediationConstant.ADN_MINTEGRAL);
        final ArrayList arrayList = new ArrayList();
        if (remove != null) {
            arrayList.add(remove);
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.msdk.y.hf.xj.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    new com.bytedance.msdk.y.xj.xj((com.bytedance.msdk.core.tf.xj) it.next()).u();
                }
                xj.this.xj.set(true);
                xj.this.y();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.bytedance.msdk.xj.kd.y.w(runnable);
        }
    }

    public static com.bytedance.msdk.api.u.xj.hf.y.xj xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return u.xj(str);
    }

    public void xj(Map<String, com.bytedance.msdk.core.tf.xj> map) {
        com.bytedance.msdk.core.tf.xj remove;
        if (map == null || (remove = map.remove("gdt")) == null) {
            return;
        }
        new com.bytedance.msdk.y.xj.xj(remove).u();
    }

    public void xj(final Context context, Map<String, com.bytedance.msdk.core.tf.xj> map) {
        if (map == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.msdk.core.tf.xj>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.tf.xj value = it.next().getValue();
            if (value != null) {
                if (value.kd()) {
                    arrayList.add(value);
                } else {
                    arrayList2.add(value);
                }
            }
        }
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.y.hf.xj.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    new com.bytedance.msdk.y.xj.xj((com.bytedance.msdk.core.tf.xj) it2.next()).u();
                }
                com.bytedance.msdk.y.hf.xj(context, (List<com.bytedance.msdk.core.tf.xj>) arrayList);
                xj.this.hf.set(true);
                xj.this.y();
            }
        });
    }

    public static void hf(String str) {
        com.bytedance.msdk.core.tf.xj xj;
        if (TextUtils.isEmpty(str) || TextUtils.equals(MediationConstant.ADN_PANGLE, str) || u(str) || (xj = com.bytedance.msdk.core.hf.hf().xj(str)) == null) {
            return;
        }
        final com.bytedance.msdk.y.xj.xj xjVar = new com.bytedance.msdk.y.xj.xj(xj);
        if ((TextUtils.equals(MediationConstant.ADN_MINTEGRAL, str) || TextUtils.equals(MediationConstant.ADN_KLEVIN, str)) && !com.bytedance.msdk.xj.kd.y.kd()) {
            com.bytedance.msdk.xj.kd.y.hf(new Runnable() { // from class: com.bytedance.msdk.y.hf.xj.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.y.xj.xj.this.u();
                }
            });
        } else {
            xjVar.u();
        }
    }

    public void xj(Context context, boolean z, boolean z2, com.bytedance.msdk.core.y.hf hfVar) {
        this.w = hfVar;
        this.xj.set(false);
        this.hf.set(false);
        this.y = z;
        this.c = z2;
        xj(context);
    }

    public void xj(Context context) {
        Map<String, com.bytedance.msdk.core.tf.xj> w = com.bytedance.msdk.c.xj.hf.xj().w();
        xj(w);
        kd();
        hf(w);
        xj(context, w);
    }
}
