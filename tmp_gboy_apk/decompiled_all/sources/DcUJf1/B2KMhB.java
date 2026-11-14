package DcUJf1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB extends Drawable.ConstantState {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Drawable.ConstantState f2381A2egSU;

    public B2KMhB(Drawable.ConstantState constantState) {
        this.f2381A2egSU = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f2381A2egSU.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f2381A2egSU.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        B3GDIM b3gdim = new B3GDIM();
        b3gdim.f2331AcNBzu = (VectorDrawable) this.f2381A2egSU.newDrawable();
        return b3gdim;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        B3GDIM b3gdim = new B3GDIM();
        b3gdim.f2331AcNBzu = (VectorDrawable) this.f2381A2egSU.newDrawable(resources);
        return b3gdim;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        B3GDIM b3gdim = new B3GDIM();
        b3gdim.f2331AcNBzu = (VectorDrawable) this.f2381A2egSU.newDrawable(resources, theme);
        return b3gdim;
    }
}
