package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.adsdk.lottie.pz;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g extends c {
    private int d;
    private int f;
    private final Map<String, Object> tf;

    public g(com.bytedance.adsdk.lottie.f fVar, f fVar2, Context context) {
        super(fVar, fVar2);
        this.f = -1;
        this.d = -1;
        HashMap hashMap = new HashMap();
        this.tf = hashMap;
        if (((c) this).c != null) {
            float xj = com.bytedance.adsdk.lottie.kd.d.xj();
            this.f = (int) (((c) this).c.xj() * xj);
            this.d = (int) (((c) this).c.hf() * xj);
            hashMap.put("ugen_url", ((c) this).c.u());
            hashMap.put("ugen_md5", ((c) this).c.kd());
            hashMap.put("ugen_v", ((c) this).c.y());
            hashMap.put("ugen_w", Integer.valueOf(this.f));
            hashMap.put("ugen_h", Integer.valueOf(this.d));
        }
    }

    private static void xj(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.c, com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        pz xj = this.hf.xj();
        View xj2 = xj != null ? xj.xj("view:", this.tf) : null;
        if (this.f <= 0 || xj2 == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        xj(i);
        float f = f();
        xj(xj2, this.f, this.d);
        xj2.setAlpha(f);
        xj2.draw(canvas);
        canvas.restore();
    }
}
