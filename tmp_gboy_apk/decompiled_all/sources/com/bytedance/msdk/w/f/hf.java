package com.bytedance.msdk.w.f;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static void hf(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar) {
        new com.bytedance.sdk.gromore.xj.xj.c.w.c(context, xjVar, uVar).xj();
    }

    public static void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y yVar, boolean z) {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf ai;
        if (xjVar != null && (ai = xjVar.ai()) != null && ai.tf() == null) {
            com.bytedance.msdk.xj.kd.w.u("TMe", "使用聚合信息流广告自渲染模版混用场景时，需设置MediationNativeToBannerListener监听回调否则会影响相关功能使用，具体可以参考接入文档，若不能及时设置，建议修改瀑布流配置为模版信息流广告暂不进行混用。");
        }
        new com.bytedance.sdk.gromore.xj.xj.c.u.kd(context, xjVar, yVar, z).xj();
    }

    public static void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w wVar, boolean z) {
        new com.bytedance.sdk.gromore.xj.xj.c.u.y(context, xjVar, wVar, z).xj();
    }

    public static void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf hfVar) {
        new com.bytedance.sdk.gromore.xj.xj.c.hf.w(context, xjVar, hfVar).xj();
    }

    public static void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c cVar) {
        new com.bytedance.sdk.gromore.xj.xj.c.kd.w(context, xjVar, cVar).xj();
    }

    public static void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.gromore.xj.xj.xj.xj xjVar2, boolean z) {
        new com.bytedance.sdk.gromore.xj.xj.c.xj.w(context, xjVar, xjVar2, z).xj();
    }

    public static void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.gromore.xj.xj xjVar2, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj xjVar3, boolean z) {
        com.bytedance.sdk.gromore.xj.xj.c.y.w wVar = new com.bytedance.sdk.gromore.xj.xj.c.y.w(context, xjVar, xjVar3, z);
        if (xjVar2 != null && xjVar2.d() != 0) {
            wVar.xj(xjVar2.d());
        } else {
            wVar.xj();
        }
    }

    public static void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar) {
        new com.bytedance.sdk.gromore.xj.xj.c.w.w(context, xjVar, uVar).xj();
    }
}
