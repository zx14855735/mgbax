package com.bytedance.adsdk.ugeno.w.hf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.adsdk.ugeno.y.d;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements d.xj {
    private Handler c = new d(Looper.getMainLooper(), this);
    private int hf;
    private zg kd;
    private Context u;
    private yo w;
    private boolean xj;
    private com.bytedance.adsdk.ugeno.hf.w y;

    public y(Context context, zg zgVar, com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.u = context;
        this.kd = zgVar;
        this.y = wVar;
    }

    public void xj(yo yoVar) {
        this.w = yoVar;
    }

    public void xj() {
        zg zgVar = this.kd;
        if (zgVar == null) {
            return;
        }
        JSONObject w = zgVar.w();
        try {
            this.hf = Integer.parseInt(com.bytedance.adsdk.ugeno.u.hf.xj(w.optString("interval", "8000"), this.y.tf()));
            this.xj = w.optBoolean("repeat");
            this.c.sendEmptyMessageDelayed(1001, this.hf);
        } catch (NumberFormatException e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.y.d.xj
    public void xj(Message message) {
        if (message.what != 1001) {
            return;
        }
        yo yoVar = this.w;
        if (yoVar != null) {
            zg zgVar = this.kd;
            com.bytedance.adsdk.ugeno.hf.w wVar = this.y;
            yoVar.xj(zgVar, wVar, wVar);
        }
        if (this.xj) {
            this.c.sendEmptyMessageDelayed(1001, this.hf);
        } else {
            this.c.removeMessages(1001);
        }
    }
}
