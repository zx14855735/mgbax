package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends c {
    private float d;
    private float f;
    private LottieAnimationView p;

    /* renamed from: pl, reason: collision with root package name */
    private d.xj.C0021xj f10048pl;
    private VideoFrame tf;

    public kd(com.bytedance.adsdk.lottie.f fVar, f fVar2, Context context, d.xj.C0021xj c0021xj) {
        super(fVar, fVar2);
        this.f = -1.0f;
        this.d = -1.0f;
        this.f10048pl = c0021xj;
        if (((c) this).c == null || fVar == null) {
            return;
        }
        LottieAnimationView hf = fVar.hf();
        this.p = hf;
        if (hf == null) {
            return;
        }
        float xj = com.bytedance.adsdk.lottie.kd.d.xj();
        this.f = (int) (((c) this).c.xj() * xj);
        this.d = (int) (((c) this).c.hf() * xj);
        pz xj2 = fVar.xj();
        View xj3 = xj2 != null ? xj2.xj("videoview:", null) : null;
        if (xj3 instanceof TextureView) {
            this.tf = new VideoFrame(context, (TextureView) xj3, c0021xj);
        }
        this.p.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.kd.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (kd.this.p == view) {
                    kd.this.am();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        am();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        VideoFrame videoFrame = this.tf;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.tf);
            }
            ViewParent parent2 = this.p.getParent();
            if (parent2 instanceof ViewGroup) {
                this.tf.setTranslationX(2.14748365E9f);
                ((ViewGroup) parent2).addView(this.tf);
            }
        }
    }

    private static void xj(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.c, com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        if (this.f <= 0.0f || this.tf == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        xj(i);
        float f = f();
        xj(this.tf, (int) this.f, (int) this.d);
        this.tf.setAlpha(f);
        this.tf.draw(canvas);
        canvas.restore();
    }
}
