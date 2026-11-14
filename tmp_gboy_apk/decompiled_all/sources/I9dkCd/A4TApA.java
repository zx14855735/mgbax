package I9dkCd;

import HXc4pW.BIYEnU;
import HXc4pW.BTvldC;
import HZUvgL.AaHO0E;
import IJPJ4E.AMqCpz;
import IJPJ4E.AYUAbz;
import ItGa5w.ARc23Z;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.AzWtSf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements BTvldC, BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Drawable f3878AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f3879AlLFFp;

    public A4TApA(Drawable drawable, int i) {
        this.f3879AlLFFp = i;
        ARc23Z.A5SV6n(drawable, "Argument must not be null");
        this.f3878AcNBzu = drawable;
    }

    private final void A5SV6n() {
    }

    @Override // HXc4pW.BTvldC
    public final void A2egSU() {
        AaHO0E aaHO0E;
        AaHO0E aaHO0E2;
        AaHO0E aaHO0E3;
        switch (this.f3879AlLFFp) {
            case 0:
                break;
            default:
                IJPJ4E.A4TApA a4TApA = (IJPJ4E.A4TApA) this.f3878AcNBzu;
                a4TApA.stop();
                a4TApA.f3891AzWtSf = true;
                AYUAbz aYUAbz = (AYUAbz) a4TApA.f3888AcNBzu.f2321A4TApA;
                aYUAbz.f3907A5SV6n.clear();
                Bitmap bitmap = aYUAbz.f3915AcNBzu;
                if (bitmap != null) {
                    aYUAbz.AMqCpz.A4TApA(bitmap);
                    aYUAbz.f3915AcNBzu = null;
                }
                aYUAbz.f3909ARc23Z = false;
                AMqCpz aMqCpz = aYUAbz.f3912AZOQYO;
                AzWtSf azWtSf = aYUAbz.f3908ADYaiT;
                if (aMqCpz != null) {
                    azWtSf.A5SV6n(aMqCpz);
                    aYUAbz.f3912AZOQYO = null;
                }
                AMqCpz aMqCpz2 = aYUAbz.f3914AaHO0E;
                if (aMqCpz2 != null) {
                    azWtSf.A5SV6n(aMqCpz2);
                    aYUAbz.f3914AaHO0E = null;
                }
                AMqCpz aMqCpz3 = aYUAbz.f3916AlLFFp;
                if (aMqCpz3 != null) {
                    azWtSf.A5SV6n(aMqCpz3);
                    aYUAbz.f3916AlLFFp = null;
                }
                HPJABZ.ADYaiT aDYaiT = aYUAbz.f3905A2egSU;
                aDYaiT.f3448AcNBzu = null;
                byte[] bArr = aDYaiT.f3445AZOQYO;
                I3HV03.A4TApA a4TApA2 = aDYaiT.f3440A5SV6n;
                if (bArr != null && (aaHO0E3 = (AaHO0E) a4TApA2.f3809AmA8tU) != null) {
                    aaHO0E3.AYUAbz(bArr);
                }
                int[] iArr = aDYaiT.f3446AZkASS;
                if (iArr != null && (aaHO0E2 = (AaHO0E) a4TApA2.f3809AmA8tU) != null) {
                    aaHO0E2.AYUAbz(iArr);
                }
                Bitmap bitmap2 = aDYaiT.f3449AlLFFp;
                if (bitmap2 != null) {
                    ((HZUvgL.ADYaiT) a4TApA2.f3808AlLFFp).A4TApA(bitmap2);
                }
                aDYaiT.f3449AlLFFp = null;
                aDYaiT.f3441ADYaiT = null;
                aDYaiT.f3455B4ZgIw = null;
                byte[] bArr2 = aDYaiT.AMqCpz;
                if (bArr2 != null && (aaHO0E = (AaHO0E) a4TApA2.f3809AmA8tU) != null) {
                    aaHO0E.AYUAbz(bArr2);
                }
                aYUAbz.f3913AZkASS = true;
                break;
        }
    }

    @Override // HXc4pW.BTvldC
    public final Class A4TApA() {
        switch (this.f3879AlLFFp) {
            case 0:
                return this.f3878AcNBzu.getClass();
            default:
                return IJPJ4E.A4TApA.class;
        }
    }

    @Override // HXc4pW.BTvldC
    public final Object get() {
        Drawable drawable = this.f3878AcNBzu;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    @Override // HXc4pW.BTvldC
    public final int getSize() {
        switch (this.f3879AlLFFp) {
            case 0:
                Drawable drawable = this.f3878AcNBzu;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                AYUAbz aYUAbz = (AYUAbz) ((IJPJ4E.A4TApA) this.f3878AcNBzu).f3888AcNBzu.f2321A4TApA;
                HPJABZ.ADYaiT aDYaiT = aYUAbz.f3905A2egSU;
                return (aDYaiT.f3446AZkASS.length * 4) + aDYaiT.f3441ADYaiT.limit() + aDYaiT.f3445AZOQYO.length + aYUAbz.f3917AmA8tU;
        }
    }

    @Override // HXc4pW.BIYEnU
    public void initialize() {
        switch (this.f3879AlLFFp) {
            case 1:
                ((AYUAbz) ((IJPJ4E.A4TApA) this.f3878AcNBzu).f3888AcNBzu.f2321A4TApA).f3915AcNBzu.prepareToDraw();
                break;
            default:
                Drawable drawable = this.f3878AcNBzu;
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof IJPJ4E.A4TApA) {
                        ((AYUAbz) ((IJPJ4E.A4TApA) drawable).f3888AcNBzu.f2321A4TApA).f3915AcNBzu.prepareToDraw();
                        break;
                    }
                } else {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                    break;
                }
                break;
        }
    }
}
