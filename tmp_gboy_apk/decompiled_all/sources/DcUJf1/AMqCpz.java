package DcUJf1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends Drawable.ConstantState {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2320A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f2321A4TApA;

    public /* synthetic */ AMqCpz(int i, Object obj) {
        this.f2320A2egSU = i;
        this.f2321A4TApA = obj;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.f2320A2egSU) {
            case 0:
                return ((Drawable.ConstantState) this.f2321A4TApA).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.f2320A2egSU) {
            case 0:
                return ((Drawable.ConstantState) this.f2321A4TApA).getChangingConfigurations();
            default:
                return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.f2320A2egSU) {
            case 0:
                ARc23Z aRc23Z = new ARc23Z(null);
                Drawable newDrawable = ((Drawable.ConstantState) this.f2321A4TApA).newDrawable();
                aRc23Z.f2331AcNBzu = newDrawable;
                newDrawable.setCallback(aRc23Z.f2327B2KMhB);
                return aRc23Z;
            default:
                return new IJPJ4E.A4TApA(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        switch (this.f2320A2egSU) {
            case 0:
                ARc23Z aRc23Z = new ARc23Z(null);
                Drawable newDrawable = ((Drawable.ConstantState) this.f2321A4TApA).newDrawable(resources);
                aRc23Z.f2331AcNBzu = newDrawable;
                newDrawable.setCallback(aRc23Z.f2327B2KMhB);
                return aRc23Z;
            default:
                return new IJPJ4E.A4TApA(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f2320A2egSU) {
            case 0:
                ARc23Z aRc23Z = new ARc23Z(null);
                Drawable newDrawable = ((Drawable.ConstantState) this.f2321A4TApA).newDrawable(resources, theme);
                aRc23Z.f2331AcNBzu = newDrawable;
                newDrawable.setCallback(aRc23Z.f2327B2KMhB);
                return aRc23Z;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
