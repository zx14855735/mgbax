package com.bytedance.adsdk.ugeno.xj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.xj.w;
import com.bytedance.adsdk.ugeno.xj.xj.xj;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends AnimatorListenerAdapter {
    private com.bytedance.adsdk.ugeno.xj.xj.xj c;
    private hf d;
    private String f;
    private w hf;
    private int kd;
    private Context u;
    private ValueAnimator w;
    private com.bytedance.adsdk.ugeno.hf.w xj;
    private int y = 1;

    public xj(Context context, com.bytedance.adsdk.ugeno.hf.w wVar, w wVar2) {
        this.xj = wVar;
        this.hf = wVar2;
        this.u = context;
    }

    public void hf() {
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public String kd() {
        return this.f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        hf hfVar = this.d;
        if (hfVar != null) {
            hfVar.hf();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        hf hfVar = this.d;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    public ValueAnimator u() {
        String key;
        com.bytedance.adsdk.ugeno.xj.hf.xj wVar;
        w wVar2 = this.hf;
        if (wVar2 == null || this.xj == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> hf = wVar2.hf();
        ArrayList arrayList = new ArrayList();
        if (hf != null && !hf.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : hf.entrySet()) {
                if (entry != null) {
                    key = entry.getKey();
                    String w = kd.xj(key).w();
                    w.getClass();
                    switch (w) {
                        case "int":
                            wVar = new com.bytedance.adsdk.ugeno.xj.hf.w(this.u, this.xj, key, entry.getValue());
                            break;
                        case "float":
                            wVar = new com.bytedance.adsdk.ugeno.xj.hf.hf(this.u, this.xj, key, entry.getValue());
                            break;
                        case "point":
                            wVar = new com.bytedance.adsdk.ugeno.xj.hf.u(this.u, this.xj, key, entry.getValue());
                            break;
                        default:
                            wVar = null;
                            break;
                    }
                    if (wVar != null) {
                        arrayList.addAll(wVar.kd());
                    }
                }
            }
        }
        JSONObject xj = this.hf.xj();
        if (xj != null) {
            com.bytedance.adsdk.ugeno.xj.xj.xj xj2 = xj.C0034xj.xj(this.xj, xj);
            this.c = xj2;
            if (xj2 != null) {
                arrayList.addAll(xj2.w());
            }
        }
        final View d = this.xj.d();
        if (d == null) {
            return null;
        }
        final w.xj c = this.hf.c();
        if (c != null) {
            d.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.xj.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = d.getWidth();
                    int height = d.getHeight();
                    d.setPivotX(u.xj(c.xj, width));
                    d.setPivotY(u.xj(c.hf, height));
                }
            });
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(d, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.kd = u.xj(this.hf.u());
        ofPropertyValuesHolder.setDuration(this.hf.w());
        int i = this.kd;
        if (i != -2) {
            ofPropertyValuesHolder.setRepeatCount(i);
        }
        this.y = this.hf.tf();
        this.f = this.hf.d();
        ofPropertyValuesHolder.setStartDelay(this.hf.y());
        ofPropertyValuesHolder.setRepeatMode(u.xj(this.hf.kd()));
        ofPropertyValuesHolder.setInterpolator(u.hf(this.hf.f()));
        ofPropertyValuesHolder.addListener(this);
        this.w = ofPropertyValuesHolder;
        return ofPropertyValuesHolder;
    }

    public void w() {
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void xj() {
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator == null || this.kd == -2 || this.y == 0) {
            return;
        }
        valueAnimator.start();
    }

    public void xj(hf hfVar) {
        this.d = hfVar;
    }

    public void xj(Canvas canvas) {
        com.bytedance.adsdk.ugeno.xj.xj.xj xjVar = this.c;
        if (xjVar != null) {
            xjVar.xj(canvas);
        }
    }

    public void xj(int i, int i2) {
        com.bytedance.adsdk.ugeno.xj.xj.xj xjVar = this.c;
        if (xjVar != null) {
            xjVar.xj(i, i2);
        }
    }
}
