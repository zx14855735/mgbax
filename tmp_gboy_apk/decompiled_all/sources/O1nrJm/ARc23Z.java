package O1nrJm;

import CtFAbx.AYUAbz;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import PCV8se.BPw6Q8;
import PCV8se.C2rE4F;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.button.MaterialButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final MaterialButton f6172A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public B2KMhB f6173A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public C2rE4F f6174A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AYUAbz f6175ADYaiT;
    public Cd8JRx.ADYaiT AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f6176ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f6177ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f6178AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f6179AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f6180AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f6181AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public PorterDuff.Mode f6182AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ColorStateList f6183AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ColorStateList f6184AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ColorStateList f6185AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AaHO0E f6186B25kr6;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f6190B7CMnp;

    /* renamed from: BChYOn, reason: collision with root package name */
    public RippleDrawable f6192BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f6193BI9f7h;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f6187B2KMhB = false;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f6188B3GDIM = false;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f6189B4ZgIw = false;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f6191B9tovu = true;

    public ARc23Z(MaterialButton materialButton, B2KMhB b2KMhB) {
        this.f6172A2egSU = materialButton;
        this.f6173A4TApA = b2KMhB;
    }

    public final AaHO0E A2egSU(boolean z) {
        RippleDrawable rippleDrawable = this.f6192BChYOn;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (AaHO0E) ((LayerDrawable) ((InsetDrawable) this.f6192BChYOn.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void A4TApA(int i, int i2) {
        MaterialButton materialButton = this.f6172A2egSU;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i3 = this.f6178AYUAbz;
        int i4 = this.f6179AZOQYO;
        this.f6179AZOQYO = i2;
        this.f6178AYUAbz = i;
        if (!this.f6188B3GDIM) {
            A5SV6n();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public final void A5SV6n() {
        AaHO0E aaHO0E = new AaHO0E(this.f6173A4TApA);
        C2rE4F c2rE4F = this.f6174A5SV6n;
        if (c2rE4F != null) {
            aaHO0E.BI9f7h(c2rE4F);
        }
        AYUAbz aYUAbz = this.f6175ADYaiT;
        if (aYUAbz != null) {
            aaHO0E.B25kr6(aYUAbz);
        }
        Cd8JRx.ADYaiT aDYaiT = this.AMqCpz;
        if (aDYaiT != null) {
            aaHO0E.f7070Cd8JRx = aDYaiT;
        }
        MaterialButton materialButton = this.f6172A2egSU;
        aaHO0E.AmA8tU(materialButton.getContext());
        aaHO0E.setTintList(this.f6183AlLFFp);
        PorterDuff.Mode mode = this.f6182AcNBzu;
        if (mode != null) {
            aaHO0E.setTintMode(mode);
        }
        float f = this.f6181AaHO0E;
        ColorStateList colorStateList = this.f6184AmA8tU;
        aaHO0E.BJ7GGh(f);
        aaHO0E.BIYEnU(colorStateList);
        AaHO0E aaHO0E2 = new AaHO0E(this.f6173A4TApA);
        C2rE4F c2rE4F2 = this.f6174A5SV6n;
        if (c2rE4F2 != null) {
            aaHO0E2.BI9f7h(c2rE4F2);
        }
        AYUAbz aYUAbz2 = this.f6175ADYaiT;
        if (aYUAbz2 != null) {
            aaHO0E2.B25kr6(aYUAbz2);
        }
        aaHO0E2.setTint(0);
        float f2 = this.f6181AaHO0E;
        int ASJ6gh2 = this.f6187B2KMhB ? OLy1FW.AYUAbz.ASJ6gh(2130968895, materialButton) : 0;
        aaHO0E2.BJ7GGh(f2);
        aaHO0E2.BIYEnU(ColorStateList.valueOf(ASJ6gh2));
        AaHO0E aaHO0E3 = new AaHO0E(this.f6173A4TApA);
        this.f6186B25kr6 = aaHO0E3;
        C2rE4F c2rE4F3 = this.f6174A5SV6n;
        if (c2rE4F3 != null) {
            aaHO0E3.BI9f7h(c2rE4F3);
        }
        AYUAbz aYUAbz3 = this.f6175ADYaiT;
        if (aYUAbz3 != null) {
            this.f6186B25kr6.B25kr6(aYUAbz3);
        }
        this.f6186B25kr6.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(P5yM7D.A4TApA.A5SV6n(this.f6185AzWtSf), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{aaHO0E2, aaHO0E}), this.f6176ARc23Z, this.f6178AYUAbz, this.f6177ASJ6gh, this.f6179AZOQYO), this.f6186B25kr6);
        this.f6192BChYOn = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        AaHO0E A2egSU2 = A2egSU(false);
        if (A2egSU2 != null) {
            A2egSU2.B2KMhB(this.f6193BI9f7h);
            A2egSU2.setState(materialButton.getDrawableState());
        }
    }

    public final void ADYaiT() {
        if (Build.VERSION.SDK_INT < 23 && !this.f6188B3GDIM) {
            MaterialButton materialButton = this.f6172A2egSU;
            int paddingStart = materialButton.getPaddingStart();
            int paddingTop = materialButton.getPaddingTop();
            int paddingEnd = materialButton.getPaddingEnd();
            int paddingBottom = materialButton.getPaddingBottom();
            A5SV6n();
            materialButton.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        AaHO0E A2egSU2 = A2egSU(false);
        if (A2egSU2 != null) {
            C2rE4F c2rE4F = this.f6174A5SV6n;
            if (c2rE4F != null) {
                A2egSU2.BI9f7h(c2rE4F);
            } else {
                A2egSU2.setShapeAppearanceModel(this.f6173A4TApA);
            }
            AYUAbz aYUAbz = this.f6175ADYaiT;
            if (aYUAbz != null) {
                A2egSU2.B25kr6(aYUAbz);
            }
        }
        AaHO0E A2egSU3 = A2egSU(true);
        if (A2egSU3 != null) {
            C2rE4F c2rE4F2 = this.f6174A5SV6n;
            if (c2rE4F2 != null) {
                A2egSU3.BI9f7h(c2rE4F2);
            } else {
                A2egSU3.setShapeAppearanceModel(this.f6173A4TApA);
            }
            AYUAbz aYUAbz2 = this.f6175ADYaiT;
            if (aYUAbz2 != null) {
                A2egSU3.B25kr6(aYUAbz2);
            }
        }
        RippleDrawable rippleDrawable = this.f6192BChYOn;
        BPw6Q8 bPw6Q8 = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.f6192BChYOn.getNumberOfLayers() > 2 ? (BPw6Q8) this.f6192BChYOn.getDrawable(2) : (BPw6Q8) this.f6192BChYOn.getDrawable(1);
        if (bPw6Q8 != null) {
            bPw6Q8.setShapeAppearanceModel(this.f6173A4TApA);
            if (bPw6Q8 instanceof AaHO0E) {
                AaHO0E aaHO0E = (AaHO0E) bPw6Q8;
                C2rE4F c2rE4F3 = this.f6174A5SV6n;
                if (c2rE4F3 != null) {
                    aaHO0E.BI9f7h(c2rE4F3);
                }
                AYUAbz aYUAbz3 = this.f6175ADYaiT;
                if (aYUAbz3 != null) {
                    aaHO0E.B25kr6(aYUAbz3);
                }
            }
        }
    }

    public final void AMqCpz() {
        AaHO0E A2egSU2 = A2egSU(false);
        AaHO0E A2egSU3 = A2egSU(true);
        if (A2egSU2 != null) {
            float f = this.f6181AaHO0E;
            ColorStateList colorStateList = this.f6184AmA8tU;
            A2egSU2.BJ7GGh(f);
            A2egSU2.BIYEnU(colorStateList);
            if (A2egSU3 != null) {
                float f2 = this.f6181AaHO0E;
                int ASJ6gh2 = this.f6187B2KMhB ? OLy1FW.AYUAbz.ASJ6gh(2130968895, this.f6172A2egSU) : 0;
                A2egSU3.BJ7GGh(f2);
                A2egSU3.BIYEnU(ColorStateList.valueOf(ASJ6gh2));
            }
        }
    }
}
