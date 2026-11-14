package com.bytedance.sdk.component.adexpress.dynamic.interact;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    public static c xj(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar, com.bytedance.sdk.component.adexpress.dynamic.w.tf tfVar, com.bytedance.sdk.component.adexpress.hf.g gVar) {
        String eu;
        String x;
        if (context == null || dynamicBaseWidget == null || cVar == null) {
            return null;
        }
        eu = cVar.eu();
        x = gVar.x();
        eu.getClass();
        switch (eu) {
            case "0":
                return new kd(context, dynamicBaseWidget, cVar);
            case "1":
                return new w(context, dynamicBaseWidget, cVar);
            case "2":
                return new hf(context, dynamicBaseWidget, cVar);
            case "5":
                return cVar.n() == 1 ? new e(context, dynamicBaseWidget, cVar, cVar.lw()) : new zg(context, dynamicBaseWidget, cVar);
            case "6":
            case "11":
                return new g(context, dynamicBaseWidget, cVar);
            case "7":
            case "14":
                return new p(context, dynamicBaseWidget, cVar);
            case "8":
                return new pl(context, dynamicBaseWidget, cVar);
            case "9":
            case "16":
                return new am(context, dynamicBaseWidget, cVar, eu, tfVar, gVar.d(), gVar.q());
            case "10":
                return new u(context, dynamicBaseWidget, cVar);
            case "12":
                return new zg(context, dynamicBaseWidget, cVar);
            case "13":
                return new e(context, dynamicBaseWidget, cVar);
            case "17":
            case "18":
                return new v(context, dynamicBaseWidget, cVar, eu, tfVar, gVar.d(), gVar.q());
            case "20":
                String str = null;
                if (com.bytedance.sdk.component.adexpress.u.xj()) {
                    return new tf(context, dynamicBaseWidget, cVar, CtFAbx.AcNBzu(x, "static/lotties/glass-swipe/glass-swipe.json"), "20");
                }
                if (!TextUtils.isEmpty(x)) {
                    str = CtFAbx.AcNBzu(x, "brush_mask.json");
                }
                return new tf(context, dynamicBaseWidget, cVar, str, "20");
            case "22":
                return com.bytedance.sdk.component.adexpress.u.xj() ? new tf(context, dynamicBaseWidget, cVar, CtFAbx.AcNBzu(x, "static/lotties/202327swiper-up-star/index.json"), "22") : new yo(context, dynamicBaseWidget, cVar);
            case "23":
                if (com.bytedance.sdk.component.adexpress.u.xj()) {
                    return new tf(context, dynamicBaseWidget, cVar, CtFAbx.AcNBzu(x, "static/lotties/202327swiper-up-star/click.json"), "23");
                }
                return null;
            case "24":
                String str2 = null;
                if (com.bytedance.sdk.component.adexpress.u.xj()) {
                    return new xj(context, dynamicBaseWidget, cVar);
                }
                if (!TextUtils.isEmpty(x)) {
                    str2 = CtFAbx.AcNBzu(x, "swiper_up_star.json");
                }
                return new tf(context, dynamicBaseWidget, cVar, str2, "24");
            case "25":
                if (com.bytedance.sdk.component.adexpress.u.xj()) {
                    return new tf(context, dynamicBaseWidget, cVar, CtFAbx.AcNBzu(x, "static/lotties/gesture-slide.json"), "25");
                }
                break;
            case "29":
                return new y(context, dynamicBaseWidget, cVar, tfVar, gVar.d(), gVar.q());
        }
        return null;
    }
}
