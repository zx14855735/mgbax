package com.bytedance.sdk.openadsdk.core.hf.xj.hf;

import J3FDQU.A2egSU;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.io;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.c;
import com.sigmob.sdk.base.n;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class u {
    private static volatile u xj;
    private boolean hf;
    private Object w;
    private AtomicBoolean u = new AtomicBoolean(false);
    private AtomicInteger kd = new AtomicInteger(3);
    private AtomicBoolean y = new AtomicBoolean(false);

    private u() {
        this.hf = false;
        try {
            Object obj = Build.class.getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                Locale locale = Locale.ROOT;
                this.hf = "android 5.3.1".toLowerCase(locale).compareTo(((String) obj).toLowerCase(locale)) <= 0;
            }
        } catch (Throwable unused) {
            this.hf = false;
        }
    }

    private void kd() {
        c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.u.2
            @Override // java.lang.Runnable
            public void run() {
                x.hf(pz.getContext(), "跳转微信失败。", 1, 17, 0, 0);
            }
        });
    }

    private boolean u() {
        Context context = pz.getContext();
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        if (tf.xj(intent, 0).size() > 0) {
            return true;
        }
        if (wo.hf(context)) {
            return false;
        }
        return wo.xj("com.tencent.mm");
    }

    public static u w() {
        if (xj == null) {
            synchronized (u.class) {
                try {
                    if (xj == null) {
                        xj = new u();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public int hf() {
        return this.hf ? 1 : 0;
    }

    public boolean xj() {
        return this.hf;
    }

    private void xj(String str) {
        Method xj2;
        if (!this.u.get() && this.kd.getAndDecrement() > 0) {
            if (TextUtils.isEmpty(str)) {
                xj("wc_init_fail", "error_appid");
                return;
            }
            if (!u()) {
                xj("wc_init_fail", "error_no_wechat");
                return;
            }
            if (!this.hf) {
                xj("wc_init_fail", "error_no_sdk");
                return;
            }
            try {
                Method xj3 = io.xj("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
                if (xj3 != null) {
                    Function<SparseArray<Object>, Object> aq = f.zg().aq();
                    Object apply = aq != null ? aq.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(3).xj(Context.class).hf()) : null;
                    if (apply == null) {
                        apply = pz.getContext();
                    }
                    if (apply == null && (xj2 = io.xj("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        apply = xj2.invoke(null, new Object[0]);
                    }
                    if (apply == null) {
                        xj("wc_init_fail", "error_sdk");
                        return;
                    }
                    this.w = xj3.invoke(null, apply, str);
                    xj("wc_init_suc", "");
                    this.u.set(true);
                }
            } catch (Throwable th) {
                xj("wc_init_fail", A2egSU.B4ZgIw(th, new StringBuilder("error_sdk_")));
            }
        }
    }

    private void xj(String str, String str2) {
        try {
            final com.bytedance.sdk.openadsdk.core.ht.xj.hf<com.bytedance.sdk.openadsdk.core.ht.xj.hf> hf = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf();
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error_message", str2);
                hf.hf(jSONObject.toString());
            }
            hf.xj(str);
            am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.u.1
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    return hf;
                }
            }, str);
        } catch (Throwable unused) {
        }
    }

    public void xj(ws wsVar, String str, String str2, final kd.xj xjVar, String str3, boolean z) {
        try {
            if (wsVar == null) {
                xjVar.hf();
                kd();
                return;
            }
            ne kt = wsVar.kt();
            if (kt == null) {
                xj("wc_init_fail", "wechat data is null");
                xjVar.hf();
                kd();
                return;
            }
            xj(kt.f());
            if (this.w == null) {
                xjVar.hf();
                kd();
                return;
            }
            Object newInstance = WXLaunchMiniProgram.Req.class.newInstance();
            Field declaredField = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, str);
            Field declaredField2 = WXLaunchMiniProgram.Req.class.getDeclaredField("path");
            declaredField2.setAccessible(true);
            declaredField2.set(newInstance, str2);
            Field declaredField3 = WXLaunchMiniProgram.Req.class.getDeclaredField("miniprogramType");
            declaredField3.setAccessible(true);
            try {
                declaredField3.set(newInstance, WXLaunchMiniProgram.Req.class.getDeclaredField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            } catch (Throwable unused) {
                declaredField3.set(newInstance, 0);
            }
            Method method = this.w.getClass().getMethod("sendReq", WXLaunchMiniProgram.Req.class.getSuperclass());
            kt.hf(2);
            com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, str3, "deeplink_success_realtime", (Throwable) null);
            HashMap hashMap = new HashMap();
            hashMap.put(n.l, "WeChatOpenSdkProcessor");
            com.bytedance.sdk.openadsdk.core.am.u.f(wsVar, str3, "open_url_app", hashMap);
            com.bytedance.sdk.openadsdk.core.am.c.xj().xj(wsVar, str3, z);
            method.invoke(this.w, newInstance);
            c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.u.3
                @Override // java.lang.Runnable
                public void run() {
                    xjVar.xj();
                }
            });
        } catch (Throwable th) {
            xj("wc_init_fail", A2egSU.B4ZgIw(th, new StringBuilder("invoke:")));
            xjVar.hf();
            kd();
        }
    }
}
