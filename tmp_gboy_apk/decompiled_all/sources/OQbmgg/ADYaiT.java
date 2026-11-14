package OQbmgg;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends Drawable.ConstantState {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Drawable.ConstantState f6440A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f6441A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f6442A5SV6n;

    public ADYaiT(Drawable.ConstantState constantState, int i, int i2) {
        this.f6440A2egSU = constantState;
        this.f6441A4TApA = i;
        this.f6442A5SV6n = i2;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        Drawable.ConstantState constantState = this.f6440A2egSU;
        if (constantState != null) {
            return constantState.getChangingConfigurations();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new AMqCpz(this.f6440A2egSU.newDrawable(), this.f6441A4TApA, this.f6442A5SV6n);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new AMqCpz(this.f6440A2egSU.newDrawable(resources), this.f6441A4TApA, this.f6442A5SV6n);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        return new AMqCpz(this.f6440A2egSU.newDrawable(resources, theme), this.f6441A4TApA, this.f6442A5SV6n);
    }
}
