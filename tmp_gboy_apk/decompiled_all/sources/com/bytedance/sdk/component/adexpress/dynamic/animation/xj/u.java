package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class u implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kd {
    com.bytedance.sdk.component.adexpress.dynamic.w.xj hf;
    public View w;
    private Set<ScheduledFuture<?>> u = new HashSet();
    public List<ObjectAnimator> xj = xj();

    public class xj implements Runnable {
        ScheduledFuture<?> hf;
        ObjectAnimator xj;

        public xj(ObjectAnimator objectAnimator) {
            this.xj = objectAnimator;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() != null) {
                com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().hf().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u.xj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.xj.resume();
                    }
                });
                if (this.hf != null) {
                    u.this.u.remove(this.hf);
                }
            }
        }

        public void xj(ScheduledFuture<?> scheduledFuture) {
            this.hf = scheduledFuture;
        }
    }

    public u(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        this.w = view;
        this.hf = xjVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kd
    public void hf() {
        List<ObjectAnimator> list = this.xj;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public void w() {
        List<ObjectAnimator> list = this.xj;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.hf.e() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        xj xjVar = u.this.new xj(objectAnimator);
                        ScheduledFuture<?> xj2 = com.bytedance.sdk.component.adexpress.u.kd.xj(xjVar, (long) (u.this.hf.e() * 1000.0d), TimeUnit.MILLISECONDS);
                        xjVar.xj(xj2);
                        u.this.u.add(xj2);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    public abstract List<ObjectAnimator> xj();

    public ObjectAnimator xj(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.hf.am() * 1000.0d));
        if (this.hf.qt() > 0) {
            objectAnimator.setRepeatCount(this.hf.qt() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!PrerollVideoResponse.NORMAL.equals(this.hf.zg())) {
            if ("alternate".equals(this.hf.zg()) || "alternate-reverse".equals(this.hf.zg())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.hf.g())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.hf.zg())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.hf.zg())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    u.this.w.setVisibility(0);
                    if (u.this.w.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) u.this.w.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }
}
