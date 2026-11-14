package com.bytedance.adsdk.ugeno.w;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.w.xj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g {
    private String c;
    private xj hf;
    private int kd;
    private View u;
    private AnimatorSet w = new AnimatorSet();
    Paint xj;
    private int y;

    public g(View view, xj xjVar) {
        this.u = view;
        this.hf = xjVar;
        Paint paint = new Paint();
        this.xj = paint;
        paint.setAntiAlias(true);
    }

    public void hf() {
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void xj() {
        ObjectAnimator objectAnimator;
        ArrayList arrayList = new ArrayList();
        List<xj.C0029xj> w = this.hf.w();
        if (w == null || w.size() <= 0) {
            return;
        }
        for (xj.C0029xj c0029xj : w) {
            if (c0029xj != null) {
                objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0029xj.xj());
                if (TextUtils.equals(c0029xj.getType(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0029xj.getType(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0029xj.getType());
                }
                objectAnimator.setStartDelay(c0029xj.u());
                objectAnimator.setTarget(this.u);
                if (TextUtils.equals(c0029xj.getType(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0029xj.kd(), (int) c0029xj.y());
                } else {
                    objectAnimator.setFloatValues(c0029xj.kd(), c0029xj.y());
                }
                int hf = (int) this.hf.hf();
                if (hf != 0) {
                    objectAnimator.setRepeatCount(hf);
                } else {
                    objectAnimator.setRepeatCount((int) c0029xj.hf());
                }
                if (TextUtils.equals(c0029xj.getType(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String y = this.hf.y();
                if (TextUtils.isEmpty(y)) {
                    y = c0029xj.w();
                }
                if (TextUtils.equals(y, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0029xj.c() != null && c0029xj.c().length > 0) {
                    objectAnimator.setFloatValues(c0029xj.c());
                }
                if (TextUtils.equals(c0029xj.getType(), "rotationX")) {
                    this.u.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.w.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.u.setPivotX(g.this.u.getWidth() / 2.0f);
                            g.this.u.setPivotY(g.this.u.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0029xj.getType(), "ripple")) {
                    this.c = c0029xj.d();
                }
                String f = c0029xj.f();
                f.getClass();
                switch (f) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.hf.u() != 0) {
            this.w.setDuration(this.hf.u());
        }
        this.w.setStartDelay(this.hf.kd());
        if (TextUtils.equals(this.hf.xj(), "sequentially")) {
            this.w.playSequentially(arrayList);
        } else {
            this.w.playTogether(arrayList);
        }
        this.w.start();
    }

    public void xj(Canvas canvas, kd kdVar) {
        try {
            if (kdVar.getRipple() == 0.0f || TextUtils.isEmpty(this.c)) {
                return;
            }
            this.xj.setColor(com.bytedance.adsdk.ugeno.y.xj.xj(this.c));
            this.xj.setAlpha(90);
            ((ViewGroup) this.u.getParent()).setClipChildren(true);
            canvas.drawCircle(this.kd, this.y, Math.min(r0, r2) * 2 * kdVar.getRipple(), this.xj);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void xj(int i, int i2) {
        this.kd = i / 2;
        this.y = i2 / 2;
    }
}
