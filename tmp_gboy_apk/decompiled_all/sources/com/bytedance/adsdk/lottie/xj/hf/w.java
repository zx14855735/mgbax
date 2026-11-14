package com.bytedance.adsdk.lottie.xj.hf;

import android.graphics.Color;
import android.graphics.Paint;
import com.bytedance.adsdk.lottie.xj.hf.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements xj.InterfaceC0024xj {
    private boolean c = true;
    private final xj<Integer, Integer> hf;
    private final xj<Float, Float> kd;
    private final xj<Float, Float> u;
    private final xj<Float, Float> w;
    private final xj.InterfaceC0024xj xj;
    private final xj<Float, Float> y;

    public w(xj.InterfaceC0024xj interfaceC0024xj, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.u.tf tfVar) {
        this.xj = interfaceC0024xj;
        xj<Integer, Integer> xj = tfVar.xj().xj();
        this.hf = xj;
        xj.xj(this);
        wVar.xj(xj);
        xj<Float, Float> xj2 = tfVar.hf().xj();
        this.w = xj2;
        xj2.xj(this);
        wVar.xj(xj2);
        xj<Float, Float> xj3 = tfVar.w().xj();
        this.u = xj3;
        xj3.xj(this);
        wVar.xj(xj3);
        xj<Float, Float> xj4 = tfVar.u().xj();
        this.kd = xj4;
        xj4.xj(this);
        wVar.xj(xj4);
        xj<Float, Float> xj5 = tfVar.kd().xj();
        this.y = xj5;
        xj5.xj(this);
        wVar.xj(xj5);
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        this.c = true;
        this.xj.xj();
    }

    public void xj(Paint paint) {
        if (this.c) {
            this.c = false;
            double floatValue = this.u.c().floatValue() * 0.017453292519943295d;
            float floatValue2 = this.kd.c().floatValue();
            float sin = ((float) Math.sin(floatValue)) * floatValue2;
            float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = this.hf.c().intValue();
            paint.setShadowLayer(this.y.c().floatValue(), sin, cos, Color.argb(Math.round(this.w.c().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }
}
