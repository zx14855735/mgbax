package com.bytedance.msdk.api.u;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.msdk.f.dk;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class tf {
    private static xj hf = null;
    private static long u = -1;
    private static long w = -1;
    private static Context xj;

    public static String c() {
        return com.bytedance.msdk.core.xj.p().qt();
    }

    public static boolean d() {
        return com.bytedance.msdk.core.xj.p().jk();
    }

    public static Map<String, String> f() {
        return com.bytedance.msdk.core.xj.p().zg();
    }

    public static Map<String, Object> g() {
        return com.bytedance.msdk.core.xj.p().ff();
    }

    public static long hf() {
        return w;
    }

    public static String kd() {
        return com.bytedance.msdk.hf.hf.hf();
    }

    public static String p() {
        return com.bytedance.msdk.core.xj.p().pl();
    }

    @Deprecated
    public static void pl() {
        com.bytedance.msdk.core.hf.hf().w(com.bytedance.msdk.c.xj.xj().w("if_test"));
    }

    public static String tf() {
        return com.bytedance.msdk.core.xj.p().yo();
    }

    public static void u() {
        if (xj == null || hf == null) {
            return;
        }
        if (u == -1) {
            u = System.currentTimeMillis();
            com.bytedance.msdk.xj.kd.w.hf("TMe", "call start up time " + u);
        }
        hf(xj, hf);
        com.bytedance.msdk.y.u.hf();
    }

    public static long w() {
        return u;
    }

    public static void xj(final Activity activity, final List<g> list, final int i, final int i2) {
        xj(new zg() { // from class: com.bytedance.msdk.api.u.tf.1
            @Override // com.bytedance.msdk.api.u.zg
            public void xj() {
                com.bytedance.msdk.core.kd.hf.u.xj().xj(activity, list, i, i2);
            }
        });
    }

    public static boolean y() {
        return com.bytedance.msdk.core.xj.p().am();
    }

    private static void hf(Context context, xj xjVar) {
        com.bytedance.msdk.core.xj.p().w(xjVar.xj());
        com.bytedance.msdk.core.xj.p().w(xjVar.qt());
        com.bytedance.msdk.c.hf.xj.xj().y();
        com.bytedance.msdk.y.w.xj(xjVar, context.getApplicationContext());
        com.bytedance.msdk.c.hf.xj.xj().c();
    }

    @Deprecated
    public static com.bytedance.msdk.api.u.xj.hf.y.xj kd(String str) {
        return com.bytedance.msdk.y.hf.xj.xj(str);
    }

    public static String w(String str) {
        str.getClass();
        switch (str) {
            case "tt_pangle_preview_ext":
                return com.bytedance.msdk.f.u.u.w();
            case "tt_pangle_preview_creative_id":
                return com.bytedance.msdk.f.u.u.hf();
            case "tt_pangle_preview_ad_id":
                return com.bytedance.msdk.f.u.u.xj();
            default:
                return null;
        }
    }

    public static void xj(zg zgVar) {
        com.bytedance.msdk.core.hf.hf().xj(zgVar);
    }

    @Deprecated
    public static com.bytedance.msdk.xj.xj.u y(String str) {
        return com.bytedance.msdk.y.hf.hf.xj().xj(str);
    }

    public static boolean xj() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.xj.p().pl())) {
            return false;
        }
        return com.bytedance.msdk.core.hf.hf().q();
    }

    public static void xj(Context context, xj xjVar) {
        if (w == -1) {
            w = System.currentTimeMillis();
            if (xjVar != null && xjVar.w()) {
                com.bytedance.msdk.xj.kd.w.xj();
                com.bytedance.sdk.component.d.xj.xj();
            }
            com.bytedance.msdk.xj.kd.w.hf("TMe", "call init time " + w);
            xj = context;
            hf = xjVar;
        }
    }

    public static void hf(String str) {
        com.bytedance.msdk.core.xj.p().kd(str);
    }

    public static String hf(Context context) {
        return dk.hf();
    }

    @Deprecated
    public static boolean u(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(com.bytedance.msdk.core.xj.p().pl())) {
            return false;
        }
        return com.bytedance.msdk.core.hf.hf().w(str);
    }

    public static boolean hf(String str, String str2) {
        return com.bytedance.msdk.y.xj.hf(str, str2);
    }

    @Deprecated
    public static void hf(int i) {
        com.bytedance.msdk.core.hf.hf().w(i);
    }

    public static void xj(y yVar) {
        com.bytedance.msdk.core.xj.p().xj(yVar, false);
    }

    public static void xj(String str) {
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "app运行中setPulisherDid: ".concat(String.valueOf(str)));
        com.bytedance.msdk.core.xj.p().u(str);
    }

    public static void xj(com.bytedance.sdk.openadsdk.zg.w.w.u uVar) {
        com.bytedance.msdk.core.xj.p().hf().hf(com.bytedance.msdk.y.hf.kd.xj(uVar));
        com.bytedance.msdk.core.xj.p().dk();
        com.bytedance.msdk.y.w.xj(com.bytedance.msdk.y.hf.kd.xj(uVar));
    }

    public static void xj(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 3);
        com.bytedance.msdk.f.u.xj(context, intent, null);
    }

    public static void xj(Context context, int[] iArr) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 1);
        intent.putExtra("permissions", iArr);
        if (context != null) {
            com.bytedance.msdk.f.u.xj(context, intent, null);
        }
    }

    public static void xj(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.bytedance.msdk.xj.xj.xj.kd, Integer.valueOf(i));
        Map<String, com.bytedance.msdk.xj.xj.u> hf2 = com.bytedance.msdk.y.hf.hf.xj().hf();
        if (hf2 == null || hf2.size() == 0) {
            return;
        }
        for (com.bytedance.msdk.xj.xj.u uVar : com.bytedance.msdk.y.hf.hf.xj().w()) {
            if (uVar != null) {
                uVar.xj(hashMap);
            }
        }
    }

    public static int xj(w wVar) {
        com.bytedance.msdk.xj.xj.u xj2 = com.bytedance.msdk.y.hf.hf.xj().xj("gdt");
        if (xj2 == null) {
            return 0;
        }
        return xj2.xj(wVar);
    }

    public static boolean xj(String str, String str2) {
        return com.bytedance.msdk.y.xj.xj(str, str2);
    }

    public static void xj(com.bytedance.msdk.api.u.xj.d.xj xjVar) {
        if (!com.bytedance.msdk.y.w.hf()) {
            com.bytedance.msdk.core.xj.p().xj(xjVar);
        } else if (xjVar != null) {
            xjVar.xj();
        }
    }
}
