package com.bytedance.adsdk.ugeno.kd.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.kd.p;
import com.bytedance.adsdk.ugeno.kd.tf;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import io.dcloud.openapi.core.util.Const;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf {
    protected String c;
    protected String d;
    protected String f;
    protected com.bytedance.adsdk.ugeno.hf.w hf;
    protected Map<String, String> kd;
    protected Context tf;
    protected y.xj u;
    protected com.bytedance.adsdk.ugeno.kd.y w;
    protected p xj;
    protected String y;

    public static class xj {
        public static hf xj(Context context, com.bytedance.adsdk.ugeno.hf.w wVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.kd.y xj;
            y.xj xj2;
            if (wVar == null || jSONObject == null || (xj = com.bytedance.adsdk.ugeno.kd.y.xj(jSONObject, jSONObject2)) == null || (xj2 = xj.xj()) == null) {
                return null;
            }
            String xj3 = xj2.xj();
            if (TextUtils.equals(xj3, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
                w wVar2 = new w(context);
                wVar2.xj(wVar);
                wVar2.xj(xj);
                wVar2.y();
                return wVar2;
            }
            com.bytedance.adsdk.ugeno.kd.c xj4 = (TextUtils.isEmpty(xj3) || TextUtils.equals(xj3, Const.PROVIDER_TYPE_GLOBAL)) ? tf.xj(xj2.hf()) : tf.xj(xj2.kd());
            if (xj4 == null) {
                return null;
            }
            hf xj5 = xj4.xj(context);
            xj5.xj(wVar);
            xj5.xj(xj);
            xj5.y();
            return xj5;
        }
    }

    public hf(Context context) {
        this.tf = context;
    }

    public String c() {
        return this.y;
    }

    public String f() {
        return this.f;
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.hf = wVar;
    }

    public abstract boolean xj(Object... objArr);

    public void y() {
        this.u = this.w.xj();
        com.bytedance.adsdk.ugeno.kd.y yVar = this.w;
        if (yVar == null) {
            return;
        }
        y.xj xj2 = yVar.xj();
        this.u = xj2;
        if (xj2 == null) {
            return;
        }
        this.kd = xj2.w();
        this.y = this.u.hf();
        this.c = this.u.xj();
        this.f = this.u.u();
        this.d = this.u.kd();
    }

    public void xj(com.bytedance.adsdk.ugeno.kd.y yVar) {
        this.w = yVar;
    }

    public void xj(p pVar) {
        this.xj = pVar;
    }
}
