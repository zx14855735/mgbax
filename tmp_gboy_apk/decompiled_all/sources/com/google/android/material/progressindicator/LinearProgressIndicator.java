package com.google.android.material.progressindicator;

import ADYaiT.CcAIMM;
import OvgpEe.ADYaiT;
import OvgpEe.AMqCpz;
import OvgpEe.AZOQYO;
import OvgpEe.AaHO0E;
import OvgpEe.AcNBzu;
import OvgpEe.AlLFFp;
import OvgpEe.AzWtSf;
import OvgpEe.B25kr6;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class LinearProgressIndicator extends ADYaiT {
    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B25kr6 b25kr6 = this.f6825AcNBzu;
        AcNBzu acNBzu = new AcNBzu(b25kr6);
        acNBzu.f6878ARc23Z = 300.0f;
        acNBzu.f6887AzWtSf = new Pair(new AZOQYO(), new AZOQYO());
        Context context2 = getContext();
        CcAIMM alLFFp = b25kr6.f6921AzWtSf == 0 ? new AlLFFp(b25kr6) : new AzWtSf(context2, b25kr6);
        AaHO0E aaHO0E = new AaHO0E(context2, b25kr6);
        aaHO0E.f6876BJ7GGh = acNBzu;
        aaHO0E.f6877BNL6CD = alLFFp;
        alLFFp.f135AcNBzu = aaHO0E;
        setIndeterminateDrawable(aaHO0E);
        setProgressDrawable(new AMqCpz(getContext(), b25kr6, acNBzu));
        this.f6832B4ZgIw = true;
    }

    @Override // OvgpEe.ADYaiT
    public final void A2egSU(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6 != null && b25kr6.f6921AzWtSf == 0 && isIndeterminate()) {
            return;
        }
        super.A2egSU(i);
    }

    public int getIndeterminateAnimationType() {
        return this.f6825AcNBzu.f6921AzWtSf;
    }

    public int getIndicatorDirection() {
        return this.f6825AcNBzu.f6922B25kr6;
    }

    public int getTrackInnerCornerRadius() {
        return this.f6825AcNBzu.f6926B7CMnp;
    }

    public Integer getTrackStopIndicatorPadding() {
        return this.f6825AcNBzu.f6925B4ZgIw;
    }

    public int getTrackStopIndicatorSize() {
        return this.f6825AcNBzu.f6924B3GDIM;
    }

    @Override // OvgpEe.ADYaiT, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        B25kr6 b25kr6 = this.f6825AcNBzu;
        boolean z2 = true;
        if (b25kr6.f6922B25kr6 != 1 && ((getLayoutDirection() != 1 || b25kr6.f6922B25kr6 != 2) && (getLayoutDirection() != 0 || b25kr6.f6922B25kr6 != 3))) {
            z2 = false;
        }
        b25kr6.f6923B2KMhB = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i2 - (getPaddingBottom() + getPaddingTop());
        AaHO0E indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        AMqCpz progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6921AzWtSf == i) {
            return;
        }
        if (A4TApA() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        b25kr6.f6921AzWtSf = i;
        b25kr6.ADYaiT();
        if (i == 0) {
            AaHO0E indeterminateDrawable = getIndeterminateDrawable();
            AlLFFp alLFFp = new AlLFFp(b25kr6);
            indeterminateDrawable.f6877BNL6CD = alLFFp;
            alLFFp.f135AcNBzu = indeterminateDrawable;
        } else {
            AaHO0E indeterminateDrawable2 = getIndeterminateDrawable();
            AzWtSf azWtSf = new AzWtSf(getContext(), b25kr6);
            indeterminateDrawable2.f6877BNL6CD = azWtSf;
            azWtSf.f135AcNBzu = indeterminateDrawable2;
        }
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f6877BNL6CD.AaHO0E(this.f6835BChYOn);
        }
        invalidate();
    }

    @Override // OvgpEe.ADYaiT
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        this.f6825AcNBzu.ADYaiT();
    }

    public void setIndicatorDirection(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        b25kr6.f6922B25kr6 = i;
        boolean z = true;
        if (i != 1 && ((getLayoutDirection() != 1 || b25kr6.f6922B25kr6 != 2) && (getLayoutDirection() != 0 || i != 3))) {
            z = false;
        }
        b25kr6.f6923B2KMhB = z;
        invalidate();
    }

    @Override // OvgpEe.ADYaiT
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        this.f6825AcNBzu.ADYaiT();
        invalidate();
    }

    public void setTrackInnerCornerRadius(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6926B7CMnp != i) {
            b25kr6.f6926B7CMnp = Math.round(Math.min(i, b25kr6.f6908A2egSU / 2.0f));
            b25kr6.f6928BChYOn = false;
            b25kr6.f6929BI9f7h = true;
            b25kr6.ADYaiT();
            invalidate();
        }
    }

    public void setTrackInnerCornerRadiusFraction(float f) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6927B9tovu != f) {
            b25kr6.f6927B9tovu = Math.min(f, 0.5f);
            b25kr6.f6928BChYOn = true;
            b25kr6.f6929BI9f7h = true;
            b25kr6.ADYaiT();
            invalidate();
        }
    }

    public void setTrackStopIndicatorPadding(Integer num) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (Objects.equals(b25kr6.f6925B4ZgIw, num)) {
            return;
        }
        b25kr6.f6925B4ZgIw = num;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6924B3GDIM != i) {
            b25kr6.f6924B3GDIM = Math.min(i, b25kr6.f6908A2egSU);
            b25kr6.ADYaiT();
            invalidate();
        }
    }
}
