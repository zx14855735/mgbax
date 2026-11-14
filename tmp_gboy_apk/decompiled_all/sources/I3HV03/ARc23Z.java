package I3HV03;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z implements HXc4pW.BTvldC, HXc4pW.BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3814AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f3815AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f3816AmA8tU;

    public ARc23Z(HZUvgL.ADYaiT aDYaiT, Bitmap bitmap) {
        ItGa5w.ARc23Z.A5SV6n(bitmap, "Bitmap must not be null");
        this.f3815AlLFFp = bitmap;
        ItGa5w.ARc23Z.A5SV6n(aDYaiT, "BitmapPool must not be null");
        this.f3816AmA8tU = aDYaiT;
    }

    public static ARc23Z A5SV6n(HZUvgL.ADYaiT aDYaiT, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new ARc23Z(aDYaiT, bitmap);
    }

    @Override // HXc4pW.BTvldC
    public final void A2egSU() {
        switch (this.f3814AcNBzu) {
            case 0:
                ((HZUvgL.ADYaiT) this.f3816AmA8tU).A4TApA((Bitmap) this.f3815AlLFFp);
                break;
            default:
                ((HXc4pW.BTvldC) this.f3816AmA8tU).A2egSU();
                break;
        }
    }

    @Override // HXc4pW.BTvldC
    public final Class A4TApA() {
        switch (this.f3814AcNBzu) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // HXc4pW.BTvldC
    public final Object get() {
        switch (this.f3814AcNBzu) {
            case 0:
                return (Bitmap) this.f3815AlLFFp;
            default:
                return new BitmapDrawable((Resources) this.f3815AlLFFp, (Bitmap) ((HXc4pW.BTvldC) this.f3816AmA8tU).get());
        }
    }

    @Override // HXc4pW.BTvldC
    public final int getSize() {
        switch (this.f3814AcNBzu) {
            case 0:
                return ItGa5w.AlLFFp.A5SV6n((Bitmap) this.f3815AlLFFp);
            default:
                return ((HXc4pW.BTvldC) this.f3816AmA8tU).getSize();
        }
    }

    @Override // HXc4pW.BIYEnU
    public final void initialize() {
        switch (this.f3814AcNBzu) {
            case 0:
                ((Bitmap) this.f3815AlLFFp).prepareToDraw();
                break;
            default:
                HXc4pW.BTvldC bTvldC = (HXc4pW.BTvldC) this.f3816AmA8tU;
                if (bTvldC instanceof HXc4pW.BIYEnU) {
                    ((HXc4pW.BIYEnU) bTvldC).initialize();
                    break;
                }
                break;
        }
    }

    public ARc23Z(Resources resources, HXc4pW.BTvldC bTvldC) {
        ItGa5w.ARc23Z.A5SV6n(resources, "Argument must not be null");
        this.f3815AlLFFp = resources;
        ItGa5w.ARc23Z.A5SV6n(bTvldC, "Argument must not be null");
        this.f3816AmA8tU = bTvldC;
    }
}
