package com.bytedance.adsdk.lottie.model.layer;

import I3HV03.ADYaiT;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.jk;
import com.bytedance.adsdk.lottie.kd.hf;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends c {
    private final Runnable am;
    private float d;
    private float f;
    private final Handler g;
    private Drawable p;

    /* renamed from: pl, reason: collision with root package name */
    private LottieAnimationView f10055pl;
    private ImageView tf;

    public xj(com.bytedance.adsdk.lottie.f fVar, f fVar2, Context context) {
        super(fVar, fVar2);
        this.f = -1.0f;
        this.d = -1.0f;
        this.g = new Handler(Looper.getMainLooper());
        this.am = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.xj.5
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.f10055pl != null && xj.this.f10055pl.kd()) {
                    xj.this.f10055pl.invalidate();
                }
                xj.this.g.postDelayed(xj.this.am, 40L);
            }
        };
        if (((c) this).c == null || fVar == null) {
            return;
        }
        LottieAnimationView hf = fVar.hf();
        this.f10055pl = hf;
        if (hf == null) {
            return;
        }
        float xj = com.bytedance.adsdk.lottie.kd.d.xj();
        this.f = (int) (((c) this).c.xj() * xj);
        this.d = (int) (((c) this).c.hf() * xj);
        jk et = fVar.et();
        String xj2 = et != null ? et.xj(((c) this).c.pl()) : null;
        if (TextUtils.isEmpty(xj2)) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.tf = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.tf.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.xj.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (xj.this.tf == view) {
                    xj.this.zg();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (xj.this.tf == view) {
                    xj.this.am();
                    if (Build.VERSION.SDK_INT < 28 || !ADYaiT.BI9f7h(xj.this.p)) {
                        return;
                    }
                    ADYaiT.AaHO0E(xj.this.p).stop();
                }
            }
        });
        this.f10055pl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.xj.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (xj.this.f10055pl == view) {
                    if (xj.this.hf()) {
                        xj.this.f10055pl.removeOnAttachStateChangeListener(this);
                    } else {
                        xj.this.xj(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.xj.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                xj.this.e();
                            }
                        });
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (xj.this.f10055pl == view) {
                    xj.this.xj(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.xj.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewParent parent = xj.this.tf.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(xj.this.tf);
                            }
                        }
                    });
                }
            }
        });
        xj(xj2, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        this.g.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.p != null) {
            ViewParent parent = this.tf.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.tf);
            }
            ViewParent parent2 = this.f10055pl.getParent();
            if (parent2 instanceof ViewGroup) {
                this.tf.setTranslationX(2.14748365E9f);
                this.tf.setImageDrawable(this.p);
                ((ViewGroup) parent2).addView(this.tf);
            }
        }
    }

    private void qt() {
        am();
        if (this.f10055pl != null) {
            this.g.postDelayed(this.am, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg() {
        boolean isRunning;
        if (Build.VERSION.SDK_INT < 28 || !ADYaiT.BNL6CD(this.p)) {
            return;
        }
        isRunning = ADYaiT.AcNBzu(this.p).isRunning();
        if (isRunning) {
            return;
        }
        ADYaiT.AcNBzu(this.p).setRepeatCount(-1);
        ADYaiT.AcNBzu(this.p).start();
        qt();
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
        canvas.clipRect(0.0f, 0.0f, this.f, this.d);
        this.tf.draw(canvas);
        canvas.restore();
    }

    private void xj(String str, Context context) {
        File file = new File(com.bytedance.adsdk.lottie.kd.hf.xj(context), com.bytedance.sdk.component.utils.kd.hf(str));
        if (file.exists()) {
            xj(file);
        } else {
            com.bytedance.adsdk.lottie.kd.hf.xj(str, context, new hf.xj<File>() { // from class: com.bytedance.adsdk.lottie.model.layer.xj.3
                @Override // com.bytedance.adsdk.lottie.kd.hf.xj
                public void xj(File file2) {
                    xj.this.xj(file2);
                }

                @Override // com.bytedance.adsdk.lottie.kd.hf.xj
                public void xj(int i, String str2) {
                    com.bytedance.sdk.component.utils.pl.xj("TMe", "--==--- webp: " + i + ", " + str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(File file) {
        ImageDecoder.Source createSource;
        Drawable decodeDrawable;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                if (ADYaiT.BNL6CD(this.p)) {
                    ADYaiT.AcNBzu(this.p).stop();
                }
                createSource = ImageDecoder.createSource(file);
                decodeDrawable = ImageDecoder.decodeDrawable(createSource);
                this.p = decodeDrawable;
                this.g.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.xj.4
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.e();
                    }
                });
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    private static void xj(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
