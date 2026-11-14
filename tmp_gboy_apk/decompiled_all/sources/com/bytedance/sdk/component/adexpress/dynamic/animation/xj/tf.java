package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf extends u {
    private float kd;
    private xj u;
    private float y;

    public class xj {
        private View hf;

        public xj(View view) {
            this.hf = view;
        }

        public void xj(int i) {
            if (!"top".equals(tf.this.hf.xj())) {
                ViewGroup.LayoutParams layoutParams = this.hf.getLayoutParams();
                layoutParams.height = i;
                this.hf.setLayoutParams(layoutParams);
                this.hf.requestLayout();
                return;
            }
            if (tf.this.w instanceof ViewGroup) {
                for (int i2 = 0; i2 < ((ViewGroup) tf.this.w).getChildCount(); i2++) {
                    ((ViewGroup) tf.this.w).getChildAt(i2).setTranslationY(i - tf.this.kd);
                }
            }
            tf tfVar = tf.this;
            tfVar.w.setTranslationY(tfVar.kd - i);
        }
    }

    public tf(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    public List<ObjectAnimator> xj() {
        int i;
        String str;
        View view = this.w;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicBaseWidget)) {
            this.w = (View) this.w.getParent();
        }
        this.w.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "alpha", 0.0f, 1.0f).setDuration((int) (this.hf.tf() * 1000.0d));
        this.u = new xj(this.w);
        final int i2 = this.w.getLayoutParams().height;
        this.kd = i2;
        this.y = this.w.getLayoutParams().width;
        if ("left".equals(this.hf.xj()) || "right".equals(this.hf.xj())) {
            i = (int) this.y;
            str = MediaFormat.KEY_WIDTH;
        } else {
            str = MediaFormat.KEY_HEIGHT;
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.u, str, 0, i).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        arrayList.add(xj(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.xj.tf.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                tf.this.u.xj(i2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }
        });
        return arrayList;
    }
}
