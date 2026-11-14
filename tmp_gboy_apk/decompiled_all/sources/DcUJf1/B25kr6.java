package DcUJf1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class B25kr6 extends Drawable.ConstantState {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f2370A2egSU;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public Bitmap f2374ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public ColorStateList f2375ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public PorterDuff.Mode f2376AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f2377AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f2378AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public boolean f2379AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Paint f2380AcNBzu;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public ColorStateList f2372A5SV6n = null;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public PorterDuff.Mode f2373ADYaiT = B3GDIM.f2382B9tovu;

    /* renamed from: A4TApA, reason: collision with root package name */
    public AzWtSf f2371A4TApA = new AzWtSf();

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f2370A2egSU;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new B3GDIM(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new B3GDIM(this);
    }
}
