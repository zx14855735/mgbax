package com.bytedance.adsdk.ugeno.xj.xj;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends xj {
    private Paint c;
    private PorterDuffXfermode d;
    private Paint f;
    private float kd;
    private Matrix p;
    private LinearGradient tf;
    private float u;
    private String w;
    private View y;

    public w(com.bytedance.adsdk.ugeno.hf.w wVar, JSONObject jSONObject) {
        super(wVar, jSONObject);
        this.y = this.hf.d();
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.y.setLayerType(2, null);
        this.d = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f = new Paint();
        this.p = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void hf() {
        this.w = this.xj.optString("direction", "left");
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public List<PropertyValuesHolder> w() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.xj.kd.ALPHA.hf(), 0.0f, 1.0f));
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void xj(Canvas canvas) {
        char c;
        try {
            if (this.hf.dc() > 0.0f) {
                int dc = (int) (this.u * this.hf.dc());
                int dc2 = (int) (this.kd * this.hf.dc());
                this.c.setXfermode(this.d);
                String str = this.w;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (str.equals("bottom")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 115029:
                        if (str.equals("top")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3317767:
                        if (str.equals("left")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 108511772:
                        if (str.equals("right")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    float f = dc;
                    canvas.drawRect(f, 0.0f, this.u, this.kd, this.c);
                    this.p.setTranslate(f, this.kd);
                    this.tf.setLocalMatrix(this.p);
                    this.f.setShader(this.tf);
                    if (this.hf.dc() <= 1.0f && this.hf.dc() > 0.9f) {
                        this.f.setAlpha((int) (255.0f - (this.hf.dc() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, f, this.kd, this.f);
                    return;
                }
                if (c == 1) {
                    float f2 = dc;
                    canvas.drawRect(0.0f, 0.0f, this.u - f2, this.kd, this.c);
                    this.p.setTranslate(this.u - f2, 0.0f);
                    this.tf.setLocalMatrix(this.p);
                    this.f.setShader(this.tf);
                    if (this.hf.dc() <= 1.0f && this.hf.dc() > 0.9f) {
                        this.f.setAlpha((int) (255.0f - (this.hf.dc() * 255.0f)));
                    }
                    float f3 = this.u;
                    canvas.drawRect(f3, this.kd, f3 - f2, 0.0f, this.f);
                    return;
                }
                if (c == 2) {
                    float f4 = dc2;
                    canvas.drawRect(0.0f, f4, this.u, this.kd, this.c);
                    this.p.setTranslate(0.0f, f4);
                    this.tf.setLocalMatrix(this.p);
                    this.f.setShader(this.tf);
                    if (this.hf.dc() <= 1.0f && this.hf.dc() > 0.9f) {
                        this.f.setAlpha((int) (255.0f - (this.hf.dc() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, this.u, f4, this.f);
                    return;
                }
                if (c != 3) {
                    return;
                }
                float f5 = dc2;
                canvas.drawRect(0.0f, 0.0f, this.u, this.kd - f5, this.c);
                this.p.setTranslate(0.0f, this.kd - f5);
                this.tf.setLocalMatrix(this.p);
                this.f.setShader(this.tf);
                if (this.hf.dc() <= 1.0f && this.hf.dc() > 0.9f) {
                    this.f.setAlpha((int) (255.0f - (this.hf.dc() * 255.0f)));
                }
                float f6 = this.u;
                float f7 = this.kd;
                canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.f);
            }
        } catch (Throwable th) {
            pl.u("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void xj(int i, int i2) {
        this.u = i;
        this.kd = i2;
        String str = this.w;
        str.getClass();
        switch (str) {
            case "bottom":
                this.tf = new LinearGradient(0.0f, -this.kd, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.tf = new LinearGradient(0.0f, this.kd, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.tf = new LinearGradient(this.u, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.tf = new LinearGradient(-this.u, 0.0f, 0.0f, this.kd, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }
}
