package androidx.appcompat.widget;

import AaHO0E.A4TApA;
import AaHO0E.G2rdQT;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f8077AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public View f8078AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public View f8079AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Drawable f8080AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Drawable f8081B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Drawable f8082B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final boolean f8083B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f8084B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final int f8085B7CMnp;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new A4TApA(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8014A2egSU);
        boolean z = false;
        this.f8080AzWtSf = obtainStyledAttributes.getDrawable(0);
        this.f8081B25kr6 = obtainStyledAttributes.getDrawable(2);
        this.f8085B7CMnp = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == 2131298010) {
            this.f8083B3GDIM = true;
            this.f8082B2KMhB = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f8083B3GDIM ? !(this.f8080AzWtSf != null || this.f8081B25kr6 != null) : this.f8082B2KMhB == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8080AzWtSf;
        if (drawable != null && drawable.isStateful()) {
            this.f8080AzWtSf.setState(getDrawableState());
        }
        Drawable drawable2 = this.f8081B25kr6;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f8081B25kr6.setState(getDrawableState());
        }
        Drawable drawable3 = this.f8082B2KMhB;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f8082B2KMhB.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8080AzWtSf;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f8081B25kr6;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f8082B2KMhB;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f8078AlLFFp = findViewById(2131296319);
        this.f8079AmA8tU = findViewById(2131296330);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f8077AcNBzu || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = true;
        if (this.f8083B3GDIM) {
            Drawable drawable = this.f8082B2KMhB;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f8080AzWtSf == null) {
                z2 = false;
            } else if (this.f8078AlLFFp.getVisibility() == 0) {
                this.f8080AzWtSf.setBounds(this.f8078AlLFFp.getLeft(), this.f8078AlLFFp.getTop(), this.f8078AlLFFp.getRight(), this.f8078AlLFFp.getBottom());
            } else {
                View view = this.f8079AmA8tU;
                if (view == null || view.getVisibility() != 0) {
                    this.f8080AzWtSf.setBounds(0, 0, 0, 0);
                } else {
                    this.f8080AzWtSf.setBounds(this.f8079AmA8tU.getLeft(), this.f8079AmA8tU.getTop(), this.f8079AmA8tU.getRight(), this.f8079AmA8tU.getBottom());
                }
            }
            this.f8084B4ZgIw = false;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        if (this.f8078AlLFFp == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.f8085B7CMnp) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f8078AlLFFp == null) {
            return;
        }
        View.MeasureSpec.getMode(i2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f8080AzWtSf;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f8080AzWtSf);
        }
        this.f8080AzWtSf = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f8078AlLFFp;
            if (view != null) {
                this.f8080AzWtSf.setBounds(view.getLeft(), this.f8078AlLFFp.getTop(), this.f8078AlLFFp.getRight(), this.f8078AlLFFp.getBottom());
            }
        }
        boolean z = false;
        if (!this.f8083B3GDIM ? !(this.f8080AzWtSf != null || this.f8081B25kr6 != null) : this.f8082B2KMhB == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f8082B2KMhB;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f8082B2KMhB);
        }
        this.f8082B2KMhB = drawable;
        boolean z = this.f8083B3GDIM;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.f8082B2KMhB) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.f8080AzWtSf != null || this.f8081B25kr6 != null) : this.f8082B2KMhB == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f8081B25kr6;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f8081B25kr6);
        }
        this.f8081B25kr6 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f8084B4ZgIw && this.f8081B25kr6 != null) {
                throw null;
            }
        }
        boolean z = false;
        if (!this.f8083B3GDIM ? !(this.f8080AzWtSf != null || this.f8081B25kr6 != null) : this.f8082B2KMhB == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(G2rdQT g2rdQT) {
    }

    public void setTransitioning(boolean z) {
        this.f8077AcNBzu = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f8080AzWtSf;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f8081B25kr6;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f8082B2KMhB;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f8080AzWtSf;
        boolean z = this.f8083B3GDIM;
        if (drawable == drawable2 && !z) {
            return true;
        }
        if (drawable == this.f8081B25kr6 && this.f8084B4ZgIw) {
            return true;
        }
        return (drawable == this.f8082B2KMhB && z) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }
}
