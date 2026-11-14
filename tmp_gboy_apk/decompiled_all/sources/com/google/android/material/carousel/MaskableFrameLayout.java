package com.google.android.material.carousel;

import COJEAR.AZOQYO;
import NdEzCJ.A2egSU;
import OCUYV2.AzWtSf;
import PCV8se.B2KMhB;
import PCV8se.BPw6Q8;
import PCV8se.BTvldC;
import PCV8se.BV3sI0;
import PCV8se.BmvVmW;
import PCV8se.BniPrB;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.bumptech.glide.AMqCpz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaskableFrameLayout extends FrameLayout implements AzWtSf, BPw6Q8 {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final /* synthetic */ int f11514B7CMnp = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public float f11515AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final RectF f11516AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Rect f11517AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public B2KMhB f11518AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final BTvldC f11519B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Boolean f11520B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public View.OnHoverListener f11521B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f11522B4ZgIw;

    public MaskableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11515AcNBzu = -1.0f;
        this.f11516AlLFFp = new RectF();
        this.f11517AmA8tU = new Rect();
        int i = Build.VERSION.SDK_INT;
        this.f11519B25kr6 = i >= 33 ? new BniPrB(this) : i >= 22 ? new BmvVmW(this) : new BV3sI0();
        this.f11520B2KMhB = null;
        this.f11522B4ZgIw = false;
        setShapeAppearanceModel(B2KMhB.A5SV6n(context, attributeSet, 0, 0).A2egSU());
    }

    public final void A2egSU() {
        if (this.f11515AcNBzu != -1.0f) {
            float A4TApA2 = A2egSU.A4TApA(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.f11515AcNBzu);
            setMaskRectF(new RectF(A4TApA2, 0.0f, getWidth() - A4TApA2, getHeight()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        BTvldC bTvldC = this.f11519B25kr6;
        if (bTvldC.A4TApA()) {
            Path path = bTvldC.AMqCpz;
            if (!path.isEmpty()) {
                canvas.save();
                canvas.clipPath(path);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public final void getFocusedRect(Rect rect) {
        RectF rectF = this.f11516AlLFFp;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public RectF getMaskRectF() {
        return this.f11516AlLFFp;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.f11515AcNBzu;
    }

    public B2KMhB getShapeAppearanceModel() {
        return this.f11518AzWtSf;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f11520B2KMhB;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            BTvldC bTvldC = this.f11519B25kr6;
            if (booleanValue != bTvldC.f7140A2egSU) {
                bTvldC.f7140A2egSU = booleanValue;
                bTvldC.A2egSU(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        BTvldC bTvldC = this.f11519B25kr6;
        this.f11520B2KMhB = Boolean.valueOf(bTvldC.f7140A2egSU);
        if (true != bTvldC.f7140A2egSU) {
            bTvldC.f7140A2egSU = true;
            bTvldC.A2egSU(this);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        RectF rectF = this.f11516AlLFFp;
        if (!rectF.isEmpty() && ((action == 9 || action == 10 || action == 7) && !rectF.contains(motionEvent.getX(), motionEvent.getY()))) {
            if (this.f11522B4ZgIw && this.f11521B3GDIM != null) {
                motionEvent.setAction(10);
                this.f11521B3GDIM.onHover(this, motionEvent);
            }
            this.f11522B4ZgIw = false;
            return false;
        }
        if (this.f11521B3GDIM != null) {
            if (!this.f11522B4ZgIw && action == 7) {
                motionEvent.setAction(9);
                this.f11522B4ZgIw = true;
            }
            if (action == 7 || action == 9) {
                this.f11522B4ZgIw = true;
            }
            this.f11521B3GDIM.onHover(this, motionEvent);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        Rect rect = this.f11517AmA8tU;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        float x = getX();
        RectF rectF = this.f11516AlLFFp;
        if (x > 0.0f) {
            rect.left = (int) (rect.left + rectF.left);
        }
        if (getY() > 0.0f) {
            rect.top = (int) (rect.top + rectF.top);
        }
        rect.right = Math.round(rectF.width()) + rect.left;
        rect.bottom = Math.round(rectF.height()) + rect.top;
        accessibilityNodeInfo.setBoundsInScreen(rect);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        RectF rectF = this.f11516AlLFFp;
        if (rectF.isEmpty() || rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f11515AcNBzu != -1.0f) {
            A2egSU();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        RectF rectF = this.f11516AlLFFp;
        if (rectF.isEmpty() || motionEvent.getAction() != 0 || rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setForceCompatClipping(boolean z) {
        BTvldC bTvldC = this.f11519B25kr6;
        if (z != bTvldC.f7140A2egSU) {
            bTvldC.f7140A2egSU = z;
            bTvldC.A2egSU(this);
        }
    }

    @Override // OCUYV2.AzWtSf
    public void setMaskRectF(RectF rectF) {
        RectF rectF2 = this.f11516AlLFFp;
        rectF2.set(rectF);
        BTvldC bTvldC = this.f11519B25kr6;
        bTvldC.f7143ADYaiT = rectF2;
        bTvldC.A5SV6n();
        bTvldC.A2egSU(this);
    }

    @Deprecated
    public void setMaskXPercentage(float f) {
        float B2KMhB2 = AMqCpz.B2KMhB(f, 0.0f, 1.0f);
        if (this.f11515AcNBzu != B2KMhB2) {
            this.f11515AcNBzu = B2KMhB2;
            A2egSU();
        }
    }

    @Override // android.view.View
    public void setOnHoverListener(View.OnHoverListener onHoverListener) {
        this.f11521B3GDIM = onHoverListener;
    }

    public void setOnMaskChangedListener(OCUYV2.B2KMhB b2KMhB) {
    }

    @Override // PCV8se.BPw6Q8
    public void setShapeAppearanceModel(B2KMhB b2KMhB) {
        B2KMhB AYUAbz2 = b2KMhB.AYUAbz(new AZOQYO(12));
        this.f11518AzWtSf = AYUAbz2;
        BTvldC bTvldC = this.f11519B25kr6;
        bTvldC.f7142A5SV6n = AYUAbz2;
        bTvldC.A5SV6n();
        bTvldC.A2egSU(this);
    }
}
