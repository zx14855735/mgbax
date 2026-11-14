package Oay4Bh;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BPw6Q8 extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Drawable f6576AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Rect f6577AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Rect f6578AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f6579AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f6580B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f6581B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f6582B3GDIM;

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f6577AlLFFp == null || this.f6576AcNBzu == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        boolean z = this.f6579AzWtSf;
        Rect rect = this.f6578AmA8tU;
        if (z) {
            rect.set(0, 0, width, this.f6577AlLFFp.top);
            this.f6576AcNBzu.setBounds(rect);
            this.f6576AcNBzu.draw(canvas);
        }
        if (this.f6580B25kr6) {
            rect.set(0, height - this.f6577AlLFFp.bottom, width, height);
            this.f6576AcNBzu.setBounds(rect);
            this.f6576AcNBzu.draw(canvas);
        }
        if (this.f6581B2KMhB) {
            Rect rect2 = this.f6577AlLFFp;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f6576AcNBzu.setBounds(rect);
            this.f6576AcNBzu.draw(canvas);
        }
        if (this.f6582B3GDIM) {
            Rect rect3 = this.f6577AlLFFp;
            rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
            this.f6576AcNBzu.setBounds(rect);
            this.f6576AcNBzu.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f6576AcNBzu;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f6576AcNBzu;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.f6580B25kr6 = z;
    }

    public void setDrawLeftInsetForeground(boolean z) {
        this.f6581B2KMhB = z;
    }

    public void setDrawRightInsetForeground(boolean z) {
        this.f6582B3GDIM = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.f6579AzWtSf = z;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f6576AcNBzu = drawable;
    }
}
