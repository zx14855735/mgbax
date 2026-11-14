package BmvVmW;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu extends Drawable.ConstantState {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f1527A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Drawable.ConstantState f1528A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public ColorStateList f1529A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public PorterDuff.Mode f1530ADYaiT;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        int i = this.f1527A2egSU;
        Drawable.ConstantState constantState = this.f1528A4TApA;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        AaHO0E aaHO0E = new AaHO0E();
        aaHO0E.f1524AzWtSf = this;
        Drawable.ConstantState constantState = this.f1528A4TApA;
        if (constantState != null) {
            aaHO0E.ASJ6gh(constantState.newDrawable(resources));
        }
        if (AaHO0E.f1520B4ZgIw == null) {
            try {
                AaHO0E.f1520B4ZgIw = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
        return aaHO0E;
    }
}
