package com.bytedance.adsdk.ugeno.kd.w;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.y.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends hf implements d.xj {
    private int am;
    private Handler g;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10076pl;

    public y(Context context) {
        super(context);
        this.f10076pl = 0;
        this.g = new d(Looper.getMainLooper(), this);
        this.am = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.kd.w.hf
    public boolean xj(Object... objArr) {
        Map<String, String> map = this.kd;
        if (map != null) {
            int xj = com.bytedance.adsdk.ugeno.y.w.xj(map.get("loop"), 0);
            this.p = xj;
            if (xj <= 0) {
                this.am = -1;
            } else {
                this.am = xj;
            }
            this.f10076pl = com.bytedance.adsdk.ugeno.y.w.xj(this.kd.get(MediationConstant.EXTRA_DURATION), 0);
        }
        this.g.sendEmptyMessageDelayed(1001, this.f10076pl);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.y.d.xj
    public void xj(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        this.xj.xj(this.hf, this.y, this.w.hf());
        int i3 = this.am - 1;
        this.am = i3;
        if (i3 < 0 && (i2 = this.f10076pl) != 0) {
            this.g.sendEmptyMessageDelayed(1001, i2);
        } else if (i3 > 0 && (i = this.f10076pl) != 0) {
            this.g.sendEmptyMessageDelayed(1001, i);
        } else {
            this.g.removeMessages(1001);
        }
    }
}
