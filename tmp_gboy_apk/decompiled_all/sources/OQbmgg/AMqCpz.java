package OQbmgg;

import ARc23Z.AZOQYO;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz extends AZOQYO {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ADYaiT f6443AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f6444AmA8tU;

    public AMqCpz(Drawable drawable, int i, int i2) {
        super(drawable);
        this.f6443AlLFFp = new ADYaiT(drawable != null ? drawable.getConstantState() : null, i, i2);
    }

    @Override // ARc23Z.AZOQYO
    public final void A2egSU(Drawable drawable) {
        super.A2egSU(drawable);
        ADYaiT aDYaiT = this.f6443AlLFFp;
        if (aDYaiT != null) {
            aDYaiT.f6440A2egSU = drawable != null ? drawable.getConstantState() : null;
            this.f6444AmA8tU = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        ADYaiT aDYaiT = this.f6443AlLFFp;
        if (aDYaiT.f6440A2egSU != null) {
            return aDYaiT;
        }
        return null;
    }

    @Override // ARc23Z.AZOQYO, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6443AlLFFp.f6442A5SV6n;
    }

    @Override // ARc23Z.AZOQYO, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f6443AlLFFp.f6441A4TApA;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f6444AmA8tU && super.mutate() == this) {
            Drawable drawable = this.f303AcNBzu;
            if (drawable != null) {
                drawable.mutate();
            }
            Drawable.ConstantState constantState = drawable != null ? drawable.getConstantState() : null;
            ADYaiT aDYaiT = this.f6443AlLFFp;
            this.f6443AlLFFp = new ADYaiT(constantState, aDYaiT.f6441A4TApA, aDYaiT.f6442A5SV6n);
            this.f6444AmA8tU = true;
        }
        return this;
    }
}
