package androidx.appcompat.widget;

import AaHO0E.HMGPfW;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f8264AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f8265AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public WeakReference f8266AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public LayoutInflater f8267AzWtSf;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f8264AcNBzu = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8040BTvldC, 0, 0);
        this.f8265AlLFFp = obtainStyledAttributes.getResourceId(2, -1);
        this.f8264AcNBzu = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View A2egSU() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f8264AcNBzu == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflater = this.f8267AzWtSf;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        View inflate = layoutInflater.inflate(this.f8264AcNBzu, viewGroup, false);
        int i = this.f8265AlLFFp;
        if (i != -1) {
            inflate.setId(i);
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        this.f8266AmA8tU = new WeakReference(inflate);
        return inflate;
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f8265AlLFFp;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f8267AzWtSf;
    }

    public int getLayoutResource() {
        return this.f8264AcNBzu;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f8265AlLFFp = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f8267AzWtSf = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f8264AcNBzu = i;
    }

    public void setOnInflateListener(HMGPfW hMGPfW) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference weakReference = this.f8266AmA8tU;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            A2egSU();
        }
    }
}
