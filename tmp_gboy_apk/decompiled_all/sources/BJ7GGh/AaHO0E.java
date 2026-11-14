package BJ7GGh;

import BChYOn.AlLFFp;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AaHO0E extends androidx.constraintlayout.widget.A2egSU {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f1422B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f1423B7CMnp;

    @Override // androidx.constraintlayout.widget.A2egSU
    public final void AMqCpz(ConstraintLayout constraintLayout) {
        ADYaiT(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.A2egSU
    public void ASJ6gh(AttributeSet attributeSet) {
        super.ASJ6gh(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f8417A4TApA);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 6) {
                    this.f1422B4ZgIw = true;
                } else if (index == 22) {
                    this.f1423B7CMnp = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public abstract void AZkASS(AlLFFp alLFFp, int i, int i2);

    @Override // androidx.constraintlayout.widget.A2egSU, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1422B4ZgIw || this.f1423B7CMnp) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i = 0; i < this.f8278AlLFFp; i++) {
                    View view = (View) constraintLayout.f8399AcNBzu.get(this.f8277AcNBzu[i]);
                    if (view != null) {
                        if (this.f1422B4ZgIw) {
                            view.setVisibility(visibility);
                        }
                        if (this.f1423B7CMnp && elevation > 0.0f) {
                            view.setTranslationZ(view.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ADYaiT((ConstraintLayout) parent);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ADYaiT((ConstraintLayout) parent);
    }
}
