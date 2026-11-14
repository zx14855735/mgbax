package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.swiper.Swiper;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.y.f;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends com.bytedance.adsdk.ugeno.hf.xj<Swiper> {
    private float cu;
    private float ey;
    private JSONArray he;
    private float ic;
    private boolean kc;
    private boolean lm;
    private int mg;
    private String my;
    private float no;
    private float nt;
    private String qi;
    private float ut;
    private boolean vi;
    private int zd;
    private com.bytedance.adsdk.ugeno.hf.w zm;

    public hf(Context context) {
        super(context);
        this.lm = true;
        this.vi = true;
        this.cu = 0.0f;
        this.no = 2000.0f;
        this.qi = PrerollVideoResponse.NORMAL;
        this.kc = true;
        this.zd = Color.parseColor("#666666");
        this.mg = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        JSONArray jSONArray = this.he;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.kd).u((int) this.ey).kd((int) this.nt).y((int) this.ic).w(this.kc).hf(this.mg).w(this.zd).hf(this.qi).u(this.lm).xj(this.ut).xj(this.vi).xj((int) this.no).w(this.kc);
        for (int i = 0; i < this.he.length(); i++) {
            qt qtVar = new qt(this.hf);
            qtVar.xj(this.da);
            com.bytedance.adsdk.ugeno.hf.w<View> hf = qtVar.hf(this.zm.ai(), null);
            qtVar.hf(this.he.optJSONObject(i));
            ((Swiper) this.kd).xj((Swiper) hf);
        }
        if (this.vi) {
            ((Swiper) this.kd).hf();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public View xj() {
        Swiper swiper = new Swiper(this.hf);
        this.kd = swiper;
        swiper.xj((w) this);
        return this.kd;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.zm = wVar;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        switch (str) {
            case "delayStart":
                this.cu = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case "indicatorColor":
                this.zd = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "nextMargin":
                this.ic = f.xj(this.hf, com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f));
                break;
            case "effect":
                this.qi = str2;
                break;
            case "direction":
                this.my = str2;
                break;
            case "indicator":
                this.kc = com.bytedance.adsdk.ugeno.y.w.xj(str2, true);
                break;
            case "previousMargin":
                this.nt = f.xj(this.hf, com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f));
                break;
            case "loop":
                this.lm = com.bytedance.adsdk.ugeno.y.w.xj(str2, true);
                break;
            case "speed":
                this.no = com.bytedance.adsdk.ugeno.y.w.xj(str2, 500.0f);
                break;
            case "pageCount":
                this.ut = com.bytedance.adsdk.ugeno.y.w.xj(str2, 1.0f);
                break;
            case "pageMargin":
                this.ey = f.xj(this.hf, com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.mg = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "autoplay":
                this.vi = com.bytedance.adsdk.ugeno.y.w.xj(str2, true);
                break;
            case "dataList":
                this.he = com.bytedance.adsdk.ugeno.y.hf.xj(str2, (JSONArray) null);
                break;
        }
    }
}
