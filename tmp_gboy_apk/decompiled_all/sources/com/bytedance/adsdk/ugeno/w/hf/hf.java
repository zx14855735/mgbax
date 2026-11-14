package com.bytedance.adsdk.ugeno.w.hf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.adsdk.ugeno.y.d;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements d.xj {
    private yo hf;
    private com.bytedance.adsdk.ugeno.hf.w kd;
    private zg u;
    private Context w;
    private int xj;
    private Handler y = new d(Looper.getMainLooper(), this);

    public hf(Context context, zg zgVar, com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.w = context;
        this.u = zgVar;
        this.kd = wVar;
    }

    public void xj(yo yoVar) {
        this.hf = yoVar;
    }

    public void xj() {
        zg zgVar = this.u;
        if (zgVar == null) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(com.bytedance.adsdk.ugeno.u.hf.xj(zgVar.w().optString("delay"), this.kd.tf()));
            this.xj = parseInt;
            this.y.sendEmptyMessageDelayed(1001, parseInt);
        } catch (NumberFormatException e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.y.d.xj
    public void xj(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject w = this.u.w();
        if (TextUtils.equals(w.optString(PointParamKey.TYPE), "onAnimation")) {
            String optString = w.optString("nodeId");
            com.bytedance.adsdk.ugeno.hf.w wVar = this.kd;
            com.bytedance.adsdk.ugeno.hf.w u = wVar.hf(wVar).u(optString);
            new g(u.d(), com.bytedance.adsdk.ugeno.w.xj.xj(w.optJSONObject("animatorSet"), u)).xj();
        } else {
            yo yoVar = this.hf;
            if (yoVar != null) {
                zg zgVar = this.u;
                com.bytedance.adsdk.ugeno.hf.w wVar2 = this.kd;
                yoVar.xj(zgVar, wVar2, wVar2);
            }
        }
        this.y.removeMessages(1001);
    }
}
