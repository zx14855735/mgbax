package com.bytedance.msdk.y;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.msdk.core.hf;
import com.bytedance.msdk.f.io;
import com.bytedance.msdk.f.l;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static long c;
    private static long hf;
    private static boolean w;
    private static long y;
    private static AtomicBoolean u = new AtomicBoolean(false);
    static Runnable xj = new Runnable() { // from class: com.bytedance.msdk.y.w.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) y.y()).getQueue().size());
            y.xj(w.xj, PushUIConfig.dismissTime);
        }
    };
    private static final ComponentCallbacks kd = new ComponentCallbacks() { // from class: com.bytedance.msdk.y.w.3
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.bytedance.msdk.core.kd.xj.xj.xj().hf();
        }
    };

    public interface hf {
        public static final String xj = l.xj() + ".openadsdk.permission.TT_PANGOLIN";

        static {
            NzThz();
        }

        private static /* synthetic */ void NzThz() {
            char[] charArray = "àìî\u00adäâîæ\u00adáìú\u00adðëæïï\u00adÉíêÁñêçäæ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 131);
            }
            String str = new String(charArray);
            char[] charArray2 = "àïêíê÷".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 131);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class xj extends BroadcastReceiver {
        private xj() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || f.zg().z()) {
                return;
            }
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- event multi receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (io.xj(context)) {
                        com.bytedance.msdk.kd.w.w();
                    } else {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- event multi receiver not in main proc");
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }
    }

    static {
        QDrvk();
    }

    private static /* synthetic */ void QDrvk() {
        char[] charArray = "\u0080\u008c\u008eÍ\u0084\u0082\u008e\u0086Í\u0081\u008c\u009aÍ\u0090\u008b\u0086\u008f\u008fÍ©\u008d\u008a¡\u0091\u008a\u0087\u0084\u0086".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 227);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0080\u008f\u008a\u008d\u008a\u0097".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 227);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void am() {
        Application xj2 = hf.xj.xj();
        if (xj2 == null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "lowMemoryListener注册失败, app = null");
            return;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "lowMemoryListener注册成功");
        ComponentCallbacks componentCallbacks = kd;
        xj2.unregisterComponentCallbacks(componentCallbacks);
        xj2.registerComponentCallbacks(componentCallbacks);
    }

    private static void e() {
        try {
            com.bytedance.msdk.core.hf.hf().xj(true);
        } catch (Throwable th) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }

    private static void g() {
        com.bytedance.msdk.api.u.xj.d.xj wo;
        if (!w || (wo = com.bytedance.msdk.core.xj.p().wo()) == null) {
            return;
        }
        wo.xj();
        com.bytedance.msdk.core.xj.p().xj((com.bytedance.msdk.api.u.xj.d.xj) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jk() {
        if (com.bytedance.msdk.core.hf.hf().j()) {
            Map<String, String> en = com.bytedance.msdk.core.hf.hf().en();
            com.bytedance.msdk.kd.y.xj((com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, v.xj(), 1);
            com.bytedance.msdk.kd.y.xj(v.xj(en));
        }
    }

    public static void kd() {
        com.bytedance.msdk.core.hf.hf().hf(1);
        if (!u.get()) {
            u();
        }
        Context context = com.bytedance.msdk.core.hf.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.msdk.xj.kd.w.hf("TNCManager_GroMore", "尝试刷新TNC tryRefreshTNCConfig");
            com.bytedance.msdk.u.hf.xj().hf().xj(context, false);
        } catch (Exception unused) {
        }
    }

    private static void qt() {
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "AppStateListener开始注册");
        com.bytedance.sdk.openadsdk.core.a.xj u2 = f.zg().u();
        if (u2 != null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "AppStateListener注册成功");
            u2.xj(new xj.hf() { // from class: com.bytedance.msdk.y.w.4
                @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
                public void hf() {
                    if (f.zg().z()) {
                        return;
                    }
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- AppStateListener on background");
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - w.y;
                    com.bytedance.msdk.kd.y.hf(j);
                    com.bytedance.msdk.core.xj.p().hf(j);
                    com.bytedance.msdk.kd.hf.hf.xj = true;
                    if (elapsedRealtime - w.c < 3000) {
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "badkground too frequently ms: " + (elapsedRealtime - w.c));
                    } else if (com.bytedance.msdk.kd.w.hf()) {
                        long unused = w.c = elapsedRealtime;
                        if (io.xj(com.bytedance.msdk.core.hf.getContext())) {
                            com.bytedance.msdk.kd.w.w();
                        } else {
                            w.zg();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
                public void xj() {
                    if (f.zg().z()) {
                        return;
                    }
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- AppStateListener on foreground");
                    long unused = w.y = SystemClock.elapsedRealtime();
                    com.bytedance.msdk.core.hf.xj.w();
                }
            });
        }
        if (com.bytedance.msdk.core.xj.p().g()) {
            try {
                com.bytedance.msdk.core.hf.getContext().registerReceiver(new xj(), new IntentFilter("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver"), hf.xj, null);
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    public static void u() {
        Context context;
        if (u.get()) {
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf("TNCManager_GroMore", "初始化TNC initTTAdNetTNC：supportTNC：" + com.bytedance.msdk.core.hf.hf().z());
        if (com.bytedance.msdk.core.hf.hf().z() && (context = com.bytedance.msdk.core.hf.getContext()) != null) {
            try {
                com.bytedance.msdk.u.hf.xj().hf().xj(context, true, new com.bytedance.msdk.u.xj(context));
            } catch (Exception unused) {
            }
            u.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v() {
        if (com.bytedance.msdk.core.hf.hf().ai()) {
            jk();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.msdk.y.w.5
                @Override // java.lang.Runnable
                public void run() {
                    w.jk();
                }
            }, 2000L);
        }
    }

    private static void w(Context context) {
        com.bytedance.msdk.kd.w.xj(context);
        com.bytedance.msdk.kd.w.xj();
    }

    private static void yo() {
        com.bytedance.msdk.core.am.hf.xj(com.bytedance.msdk.core.hf.hf()).xj(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zg() {
        if (com.bytedance.msdk.core.hf.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(l.xj());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.bytedance.msdk.core.hf.getContext().sendBroadcast(intent, hf.xj);
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    public static boolean hf() {
        return w;
    }

    private static void hf(final Context context) {
        com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        xj(true);
        hf = SystemClock.elapsedRealtime();
        qt();
        u.xj(context.getApplicationContext());
        com.bytedance.msdk.f.f.xj().w();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pre_time", elapsedRealtime - hf);
        } catch (Throwable unused) {
        }
        e();
        try {
            jSONObject.put("cfg_time", SystemClock.elapsedRealtime() - elapsedRealtime);
        } catch (Throwable unused2) {
        }
        w(context);
        com.bytedance.msdk.core.hf.hf().xj(true, jSONObject, new com.bytedance.msdk.core.y.hf() { // from class: com.bytedance.msdk.y.w.1
            @Override // com.bytedance.msdk.core.y.hf
            public void xj() {
                com.bytedance.msdk.core.hf.hf().xj((com.bytedance.msdk.core.y.hf) null);
                y.u(new Runnable() { // from class: com.bytedance.msdk.y.w.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.kd.w.hf(com.bytedance.msdk.core.hf.getContext());
                        w.hf(context, w.hf);
                        w.am();
                    }
                });
                w.v();
            }
        });
        yo();
    }

    public static String w() {
        try {
            com.bytedance.msdk.xj.xj.u xj2 = com.bytedance.msdk.y.hf.hf.xj().xj(MediationConstant.ADN_PANGLE);
            if (xj2 != null) {
                return xj2.w();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long xj() {
        return hf;
    }

    private static void xj(boolean z) {
        w = z;
        g();
    }

    public static void xj(com.bytedance.msdk.api.u.xj xjVar, Context context) {
        xj(context);
        xj(xjVar);
        hf(context);
    }

    @SuppressLint({"WrongConstant"})
    private static void xj(com.bytedance.msdk.api.u.xj xjVar) {
        com.bytedance.msdk.core.xj.p().xj(xjVar.am());
        com.bytedance.msdk.core.xj.p().xj(System.currentTimeMillis());
        com.bytedance.msdk.core.xj.p().w(xjVar.xj());
        com.bytedance.msdk.core.xj.p().y(xjVar.hf());
        com.bytedance.msdk.core.xj.p().w(xjVar.qt());
        com.bytedance.msdk.core.xj.p().kd(xjVar.y().w());
        com.bytedance.msdk.core.xj.p().y(xjVar.y().u());
        com.bytedance.msdk.core.xj.p().xj(xjVar.y().hf());
        com.bytedance.msdk.core.xj.p().xj(xjVar.y().kd());
        com.bytedance.msdk.core.xj.p().xj(xjVar.y().y());
        com.bytedance.msdk.core.xj.p().u(xjVar.y().xj());
        com.bytedance.msdk.core.xj.p().u(xjVar.u());
        com.bytedance.msdk.core.xj.p().hf(xjVar.kd());
        com.bytedance.msdk.core.xj.p().kd(xjVar.y().c());
        com.bytedance.msdk.core.xj.p().xj(xjVar.y().f());
        com.bytedance.msdk.core.xj.p().xj(xjVar.d(), true);
        com.bytedance.msdk.core.xj.p().c(xjVar.y().d());
        com.bytedance.msdk.core.xj.p().hf(xjVar.tf());
        com.bytedance.msdk.core.xj.p().w(xjVar.g());
        com.bytedance.msdk.core.xj.p().c(xjVar.p());
        com.bytedance.msdk.core.xj.p().xj(xjVar.pl());
        com.bytedance.msdk.core.xj.p().f(xjVar.c().hf());
        com.bytedance.msdk.core.xj.p().f(xjVar.c().xj());
        com.bytedance.msdk.core.xj.p().d(xjVar.c().w());
        com.bytedance.msdk.core.xj.p().tf(xjVar.c().u());
        if (xjVar.g() != null) {
            try {
                com.bytedance.msdk.core.xj.p().xj((List<String>) xjVar.g().get(MediationConstant.GM_EXTRA_KEY_PRIME_RIT_LIST));
            } catch (Throwable unused) {
            }
        }
        if (xjVar.f() != null) {
            com.bytedance.msdk.core.xj.p().hf(xjVar.f().xj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Context context, long j) {
        if (!u.xj()) {
            com.bytedance.msdk.xj.kd.w.xj("TMe", "-----==---- 延时上报sdk_init");
            u.xj(j);
        } else {
            com.bytedance.msdk.xj.kd.w.xj("TMe", "-----==---- 正常上报sdk_init");
            u.hf(j);
        }
    }

    public static void xj(SparseArray<Object> sparseArray) {
        for (com.bytedance.msdk.xj.xj.u uVar : com.bytedance.msdk.y.hf.hf.xj().w()) {
            if (uVar != null) {
                try {
                    uVar.xj(com.bytedance.msdk.core.xj.p().ra(), sparseArray);
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }
    }

    public static void xj(Context context) {
        if (context != null) {
            com.bytedance.msdk.core.hf.xj(context);
        }
    }
}
