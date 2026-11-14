package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.q;
import com.sigmob.sdk.base.n;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ImageFlipSlideGroup extends FrameLayout {
    boolean c;
    private String d;
    private ImageFlipSlide f;
    private List<String> g;
    BookPageView hf;
    ObjectAnimator kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10198pl;
    private String tf;
    float u;
    ImageView w;
    FrameLayout xj;
    boolean y;

    public ImageFlipSlideGroup(Context context, boolean z) {
        super(context);
        this.u = 0.0f;
        this.c = z;
        u();
        setVisibility(4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    private void u() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.c);
        this.f = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.xj = frameLayout;
        addView(frameLayout);
        if (!this.c) {
            BookPageView bookPageView = new BookPageView(getContext());
            this.hf = bookPageView;
            this.xj.addView(bookPageView);
            return;
        }
        View view = new View(getContext());
        view.setBackgroundColor(-1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(q.xj(getContext(), 2.0f), -1);
        layoutParams.gravity = 17;
        this.xj.addView(view, layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(jk.kd(getContext(), "tt_im_fs_handle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(q.xj(getContext(), 44.0f), q.xj(getContext(), 44.0f));
        layoutParams2.gravity = 17;
        this.xj.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        this.w = imageView2;
        imageView2.setImageResource(jk.kd(getContext(), "tt_im_fs_tip"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(q.xj(getContext(), 196.0f), q.xj(getContext(), 300.0f));
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = q.xj(getContext(), 6.0f);
        this.xj.addView(this.w, layoutParams3);
    }

    public float getRatio() {
        return this.u;
    }

    public void hf() {
        ObjectAnimator objectAnimator = this.kd;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void setFilterColors(List<String> list) {
        this.g = list;
    }

    public void setRatio(float f) {
        this.u = f;
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup imageFlipSlideGroup = ImageFlipSlideGroup.this;
                if (imageFlipSlideGroup.c) {
                    imageFlipSlideGroup.f.xj(ImageFlipSlideGroup.this.u);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.xj.getLayoutParams();
                    layoutParams.leftMargin = (int) (((1.0f - ImageFlipSlideGroup.this.u) - 0.5f) * r1.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.xj.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                float width = ImageFlipSlideGroup.this.getWidth();
                float width2 = ImageFlipSlideGroup.this.getWidth();
                ImageFlipSlideGroup imageFlipSlideGroup2 = ImageFlipSlideGroup.this;
                point.x = ((int) (width - (width2 * imageFlipSlideGroup2.u))) - 100;
                float height = imageFlipSlideGroup2.getHeight();
                float width3 = ImageFlipSlideGroup.this.getWidth();
                ImageFlipSlideGroup imageFlipSlideGroup3 = ImageFlipSlideGroup.this;
                float f2 = imageFlipSlideGroup3.u;
                point.y = ((int) (height - (width3 * f2))) - 100;
                if (f2 > 0.3f) {
                    double d = point.x;
                    double width4 = imageFlipSlideGroup3.getWidth() * 2;
                    ImageFlipSlideGroup imageFlipSlideGroup4 = ImageFlipSlideGroup.this;
                    point.x = (int) (d - ((imageFlipSlideGroup4.u - 0.3d) * width4));
                    point.y = (int) (((ImageFlipSlideGroup.this.u - 0.3d) * (imageFlipSlideGroup4.getHeight() / 2)) + point.y);
                }
                ImageFlipSlideGroup.this.hf.xj(point);
                ImageFlipSlideGroup imageFlipSlideGroup5 = ImageFlipSlideGroup.this;
                imageFlipSlideGroup5.hf.setAlpha(1.0f - (imageFlipSlideGroup5.u - 0.3f));
                ImageFlipSlideGroup.this.f.xj(ImageFlipSlideGroup.this.hf.getFilterAreaPath());
            }
        });
    }

    public void w() {
        if (TextUtils.isEmpty(this.tf)) {
            this.f.xj(this.d, this.p, this.g);
        } else {
            this.f.xj(this.tf, this.f10198pl, (List<String>) null);
        }
    }

    public void xj(final DynamicImageFlipSlide.xj xjVar) {
        if (this.y) {
            if (xjVar != null) {
                xjVar.xj();
                return;
            }
            return;
        }
        this.y = true;
        this.kd.cancel();
        if (this.w != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.w.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, n.C, this.u, this.c ? 1.1f : 1.3f);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ImageFlipSlideGroup.this.xj.setVisibility(8);
                DynamicImageFlipSlide.xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    public void hf(String str, String str2) {
        this.tf = str;
        this.f10198pl = str2;
    }

    public void xj() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, n.C, 0.15f, 0.25f);
        this.kd = ofFloat;
        ofFloat.setDuration(700L);
        this.kd.setInterpolator(new LinearInterpolator());
        this.kd.setRepeatCount(-1);
        this.kd.setRepeatMode(2);
        this.kd.start();
    }

    public void xj(String str, String str2) {
        this.d = str;
        this.p = str2;
    }
}
