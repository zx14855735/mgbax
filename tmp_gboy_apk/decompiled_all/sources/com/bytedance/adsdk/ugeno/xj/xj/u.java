package com.bytedance.adsdk.ugeno.xj.xj;

import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.adsdk.ugeno.y.xj;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends xj {
    private static final float am;
    private static final float e;
    private static final float qt;
    private static final float zg;
    private int c;
    private float d;
    private int f;
    private Path g;
    private Path kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10091pl;
    private int tf;
    private Paint u;
    private int w;
    private xj.C0035xj y;
    private float yo;

    static {
        float radians = (float) Math.toRadians(30.0d);
        am = radians;
        qt = (float) Math.tan(radians);
        zg = (float) Math.cos(radians);
        e = (float) Math.sin(radians);
        xGILw();
    }

    public u(com.bytedance.adsdk.ugeno.hf.w wVar, JSONObject jSONObject) {
        super(wVar, jSONObject);
        this.f10091pl = true;
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
        this.kd = new Path();
        this.d = this.hf.pz();
        this.g = new Path();
    }

    private static /* synthetic */ void xGILw() {
        char[] charArray = "BNL\u000fF@LD\u000fCNX\u000fRIDMM\u000fkOHcSHEFD".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '!');
        }
        String str = new String(charArray);
        char[] charArray2 = "BMHOHU".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '!');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void hf() {
        this.w = (int) f.xj(this.hf.d().getContext(), this.xj.optInt("shineWidth", 30));
        String optString = this.xj.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(optString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : optString;
        if (str.startsWith("linear")) {
            this.y = com.bytedance.adsdk.ugeno.y.xj.hf(str);
        } else {
            int xj = com.bytedance.adsdk.ugeno.y.xj.xj(str);
            this.c = xj;
            this.f = com.bytedance.adsdk.ugeno.y.xj.xj(xj, 32);
            this.f10091pl = false;
        }
        this.yo = zg * this.w;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public List<PropertyValuesHolder> w() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(u(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    @SuppressLint({"DrawAllocation"})
    public void xj(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.hf.hl() > 0.0f) {
                int i = this.tf;
                float f = qt;
                float hl = ((i * f) + i) * this.hf.hl();
                this.g.reset();
                this.g.moveTo(hl, 0.0f);
                int i2 = this.p;
                float f2 = hl - (i2 * f);
                this.g.lineTo(f2, i2);
                this.g.lineTo(f2 + this.w, this.p);
                this.g.lineTo(this.w + hl, 0.0f);
                this.g.close();
                float f3 = this.yo;
                float f4 = zg * f3;
                float f5 = f3 * e;
                if (!this.f10091pl || this.y == null) {
                    int i3 = this.f;
                    linearGradient = new LinearGradient(hl, 0.0f, hl + f4, f5, new int[]{i3, this.c, i3}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(hl, 0.0f, hl + f4, f5, this.y.hf, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.u.setShader(linearGradient);
                Path path = this.kd;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.g, this.u);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void xj(int i, int i2) {
        this.tf = i;
        this.p = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.kd;
            float f = this.d;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }
}
