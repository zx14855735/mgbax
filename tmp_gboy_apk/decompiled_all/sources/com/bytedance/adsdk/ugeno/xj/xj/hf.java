package com.bytedance.adsdk.ugeno.xj.xj;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends xj {
    private static final int c = Color.parseColor("#7ed321");
    private int kd;
    private int u;
    private int w;
    private Paint y;

    static {
        oGprYc();
    }

    public hf(com.bytedance.adsdk.ugeno.hf.w wVar, JSONObject jSONObject) {
        super(wVar, jSONObject);
        Paint paint = new Paint();
        this.y = paint;
        paint.setAntiAlias(true);
    }

    private static /* synthetic */ void oGprYc() {
        char[] charArray = "\u00ad¡£à©¯£«à¬¡·à½¦«¢¢à\u0084 §\u008c¼§ª©«".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 206);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u00ad¢§ §º".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 206);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void hf() {
        this.w = com.bytedance.adsdk.ugeno.y.xj.xj(this.xj.optString("backgroundColor"), c);
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public List<PropertyValuesHolder> w() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(u(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void xj(Canvas canvas) {
        try {
            if (this.hf.yy() > 0.0f) {
                this.y.setColor(this.w);
                this.y.setAlpha((int) ((1.0f - this.hf.yy()) * 255.0f));
                ((ViewGroup) this.hf.d().getParent()).setClipChildren(true);
                canvas.drawCircle(this.u, this.kd, Math.min(r0, r2) * 2 * this.hf.yy(), this.y);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xj.xj.xj
    public void xj(int i, int i2) {
        this.u = i / 2;
        this.kd = i2 / 2;
    }
}
