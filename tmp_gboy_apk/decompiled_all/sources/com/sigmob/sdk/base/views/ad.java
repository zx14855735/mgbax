package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ad extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13249a = 1;
    public static final int b = 2;
    private ImageView c;
    private TextView d;
    private TextView e;
    private AnimatorSet f;
    private ObjectAnimator g;
    private ObjectAnimator h;
    private View i;
    private boolean j;

    /* renamed from: com.sigmob.sdk.base.views.ad$1, reason: invalid class name */
    public class AnonymousClass1 implements Animator.AnimatorListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (ad.this.j) {
                return;
            }
            ad.this.g.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            new Handler(Looper.getMainLooper()).postDelayed(new A4TApA(1, this), 300L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ad(Context context) {
        super(context);
        a(context);
    }

    private int b(Context context) {
        return ResourceUtil.getLayoutId(context, "sig_shake_view_layout");
    }

    private void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i, "translationY", 0.0f, 30.0f, 0.0f, -30.0f, 0.0f);
        this.h = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.h.setRepeatCount(2);
        this.h.setDuration(400L);
    }

    public void a() {
        this.h.start();
    }

    public ad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(int i) {
        ObjectAnimator objectAnimator;
        if (i != 1) {
            this.j = true;
            this.g.cancel();
            objectAnimator = this.h;
        } else {
            objectAnimator = this.g;
        }
        objectAnimator.start();
    }

    public ad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, b(context), this);
        this.c = (ImageView) findViewById(ResourceUtil.getId(context, "sig_shakeImageView"));
        this.d = (TextView) findViewById(ResourceUtil.getId(context, "sig_shakeTitleView"));
        this.e = (TextView) findViewById(ResourceUtil.getId(context, "sig_shakeDescView"));
        this.i = findViewById(ResourceUtil.getId(context, "sig_shake_view"));
        c();
        b();
    }

    private void b() {
        int i = this.c.getLayoutParams().height;
        this.c.setPivotX(this.c.getLayoutParams().width);
        this.c.setPivotY(i * 0.8f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, com.sigmob.sdk.base.common.a.B, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f);
        this.g = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.g.addListener(new AnonymousClass1());
        this.g.setDuration(1500L);
    }
}
