package com.bytedance.adsdk.ugeno.xj.xj;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends xj {
    private String c;
    private boolean d;
    private boolean f;
    private PorterDuffXfermode g;
    private Paint kd;
    private Path p;

    /* renamed from: pl, reason: collision with root package name */
    private Path f10090pl;
    private Path tf;
    private float u;
    private float w;
    private float y;

    public kd(com.bytedance.adsdk.ugeno.hf.w wVar, JSONObject jSONObject) {
        super(wVar, jSONObject);
        this.f = true;
        this.d = true;
        Paint paint = new Paint();
        this.kd = paint;
        paint.setAntiAlias(true);
        this.hf.d().setLayerType(2, null);
        this.g = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.tf = new Path();
        this.p = new Path();
        this.f10090pl = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void hf() {
        this.y = (float) this.xj.optDouble("start", 0.0d);
        this.c = this.xj.optString("direction", "center");
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public List<PropertyValuesHolder> w() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(u(), this.y, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void xj(Canvas canvas) {
        int vm;
        int vm2;
        if (this.hf.vm() > 0.0f) {
            vm = (int) (this.hf.vm() * this.w);
            vm2 = (int) (this.hf.vm() * this.u);
            this.kd.setXfermode(this.g);
            String str = this.c;
            str.getClass();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, vm2, this.w, this.u, this.kd);
                    break;
                case "center":
                    this.tf.reset();
                    this.p.reset();
                    this.f10090pl.reset();
                    Path.Direction direction = Path.Direction.CW;
                    this.tf.addCircle(this.w / 2.0f, this.u / 2.0f, vm, direction);
                    Path path = this.p;
                    float f = this.w;
                    path.addRect(f / 2.0f, 0.0f, f, this.u, direction);
                    Path path2 = this.p;
                    Path path3 = this.tf;
                    Path.Op op = Path.Op.DIFFERENCE;
                    path2.op(path3, op);
                    this.f10090pl.addRect(0.0f, 0.0f, this.w / 2.0f, this.u, direction);
                    this.f10090pl.op(this.tf, op);
                    canvas.drawPath(this.p, this.kd);
                    canvas.drawPath(this.f10090pl, this.kd);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.w, this.u - vm2, this.kd);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.w - vm, this.u, this.kd);
                    break;
                case "right":
                    canvas.drawRect(vm, 0.0f, this.w, this.u, this.kd);
                    break;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void xj(int i, int i2) {
        if (i > 0 && this.f) {
            this.w = i;
            this.f = false;
        }
        if (i2 <= 0 || !this.d) {
            return;
        }
        this.u = i2;
        this.d = false;
    }
}
