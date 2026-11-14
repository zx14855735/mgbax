package O616TD;

import COJEAR.Ddcejp;
import PCV8se.AMqCpz;
import PCV8se.ARc23Z;
import PCV8se.AaHO0E;
import PCV8se.B25kr6;
import PCV8se.B2KMhB;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.R$styleable;
import androidx.cardview.widget.CardView;
import com.google.android.material.card.MaterialCardView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public static final double f6194BJ7GGh = Math.cos(Math.toRadians(45.0d));

    /* renamed from: BNL6CD, reason: collision with root package name */
    public static final ColorDrawable f6195BNL6CD;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final MaterialCardView f6196A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AaHO0E f6198A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final AaHO0E f6199ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f6200ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f6201ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f6202AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public Drawable f6203AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public Drawable f6204AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public ColorStateList f6205AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ColorStateList f6206AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public B2KMhB f6207AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ColorStateList f6208AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public RippleDrawable f6209AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public LayerDrawable f6210B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public AaHO0E f6211B2KMhB;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f6213B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public ValueAnimator f6214B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final TimeInterpolator f6215B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final int f6216BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final int f6217BI9f7h;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Rect f6197A4TApA = new Rect();

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f6212B3GDIM = false;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public float f6218BIYEnU = 0.0f;

    static {
        f6195BNL6CD = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
        GvVIpq();
    }

    public A5SV6n(MaterialCardView materialCardView, AttributeSet attributeSet) {
        this.f6196A2egSU = materialCardView;
        AaHO0E aaHO0E = new AaHO0E(materialCardView.getContext(), attributeSet, 2130969557, 2131952842);
        this.f6198A5SV6n = aaHO0E;
        aaHO0E.AmA8tU(materialCardView.getContext());
        aaHO0E.B9tovu();
        B2KMhB.A2egSU ASJ6gh2 = aaHO0E.f7042AlLFFp.f7021A2egSU.ASJ6gh();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.f8268A2egSU, 2130969557, 2131951913);
        if (obtainStyledAttributes.hasValue(3)) {
            ASJ6gh2.A5SV6n(obtainStyledAttributes.getDimension(3, 0.0f));
        }
        this.f6199ADYaiT = new AaHO0E();
        AYUAbz(ASJ6gh2.A2egSU());
        this.f6215B9tovu = com.bumptech.glide.A5SV6n.D6DOie(materialCardView.getContext(), 2130969635, NdEzCJ.A2egSU.f6036A2egSU);
        this.f6216BChYOn = com.bumptech.glide.A5SV6n.D07BeM(materialCardView.getContext(), 2130969625, 300);
        this.f6217BI9f7h = com.bumptech.glide.A5SV6n.D07BeM(materialCardView.getContext(), 2130969624, 300);
        obtainStyledAttributes.recycle();
    }

    public static float A4TApA(AMqCpz aMqCpz, float f) {
        if (aMqCpz instanceof B25kr6) {
            return (float) ((1.0d - f6194BJ7GGh) * f);
        }
        if (aMqCpz instanceof ARc23Z) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    private static /* synthetic */ void GvVIpq() {
        char[] charArray = "UY[\u0018QW[S\u0018TYO\u0018E^SZZ\u0018|X_tD_RQS".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '6');
        }
        String str = new String(charArray);
        char[] charArray2 = "UZ_X_B".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '6');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final float A2egSU() {
        AMqCpz aMqCpz = this.f6207AlLFFp.f7083A2egSU;
        AaHO0E aaHO0E = this.f6198A5SV6n;
        float A4TApA2 = A4TApA(aMqCpz, aaHO0E.AcNBzu());
        AMqCpz aMqCpz2 = this.f6207AlLFFp.f7084A4TApA;
        float[] fArr = aaHO0E.f7068CTkVKb;
        float max = Math.max(A4TApA2, A4TApA(aMqCpz2, fArr != null ? fArr[0] : aaHO0E.f7042AlLFFp.f7021A2egSU.f7087ARc23Z.A2egSU(aaHO0E.AYUAbz())));
        AMqCpz aMqCpz3 = this.f6207AlLFFp.f7085A5SV6n;
        float[] fArr2 = aaHO0E.f7068CTkVKb;
        float A4TApA3 = A4TApA(aMqCpz3, fArr2 != null ? fArr2[1] : aaHO0E.f7042AlLFFp.f7021A2egSU.f7088ASJ6gh.A2egSU(aaHO0E.AYUAbz()));
        AMqCpz aMqCpz4 = this.f6207AlLFFp.f7086ADYaiT;
        float[] fArr3 = aaHO0E.f7068CTkVKb;
        return Math.max(max, Math.max(A4TApA3, A4TApA(aMqCpz4, fArr3 != null ? fArr3[2] : aaHO0E.f7042AlLFFp.f7021A2egSU.f7089AYUAbz.A2egSU(aaHO0E.AYUAbz()))));
    }

    public final LayerDrawable A5SV6n() {
        if (this.f6209AzWtSf == null) {
            this.f6211B2KMhB = new AaHO0E(this.f6207AlLFFp);
            this.f6209AzWtSf = new RippleDrawable(this.f6205AaHO0E, null, this.f6211B2KMhB);
        }
        if (this.f6210B25kr6 == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f6209AzWtSf, this.f6199ADYaiT, this.f6204AZkASS});
            this.f6210B25kr6 = layerDrawable;
            layerDrawable.setId(2, 2131297669);
        }
        return this.f6210B25kr6;
    }

    public final A4TApA ADYaiT(Drawable drawable) {
        int i;
        int i2;
        if (this.f6196A2egSU.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (AZOQYO() ? A2egSU() : 0.0f));
            i = (int) Math.ceil(r0.getMaxCardElevation() + (AZOQYO() ? A2egSU() : 0.0f));
            i2 = ceil;
        } else {
            i = 0;
            i2 = 0;
        }
        return new A4TApA(drawable, i, i2, i, i2);
    }

    public final void AMqCpz(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.f6210B25kr6 != null) {
            MaterialCardView materialCardView = this.f6196A2egSU;
            if (materialCardView.getUseCompatPadding()) {
                i3 = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (AZOQYO() ? A2egSU() : 0.0f)) * 2.0f);
                i4 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (AZOQYO() ? A2egSU() : 0.0f)) * 2.0f);
            } else {
                i3 = 0;
                i4 = 0;
            }
            int i7 = this.f6201ASJ6gh;
            int i8 = (i7 & 8388613) == 8388613 ? ((i - this.AMqCpz) - this.f6200ARc23Z) - i4 : this.AMqCpz;
            int i9 = (i7 & 80) == 80 ? this.AMqCpz : ((i2 - this.AMqCpz) - this.f6200ARc23Z) - i3;
            int i10 = (i7 & 8388613) == 8388613 ? this.AMqCpz : ((i - this.AMqCpz) - this.f6200ARc23Z) - i4;
            int i11 = (i7 & 80) == 80 ? ((i2 - this.AMqCpz) - this.f6200ARc23Z) - i3 : this.AMqCpz;
            if (materialCardView.getLayoutDirection() == 1) {
                i6 = i10;
                i5 = i8;
            } else {
                i5 = i10;
                i6 = i8;
            }
            this.f6210B25kr6.setLayerInset(2, i6, i11, i5, i9);
        }
    }

    public final void ARc23Z(boolean z, boolean z2) {
        int i = 1;
        Drawable drawable = this.f6204AZkASS;
        if (drawable != null) {
            if (!z2) {
                drawable.setAlpha(z ? 255 : 0);
                this.f6218BIYEnU = z ? 1.0f : 0.0f;
                return;
            }
            float f = z ? 1.0f : 0.0f;
            float f2 = z ? 1.0f - this.f6218BIYEnU : this.f6218BIYEnU;
            ValueAnimator valueAnimator = this.f6214B7CMnp;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f6214B7CMnp = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f6218BIYEnU, f);
            this.f6214B7CMnp = ofFloat;
            ofFloat.addUpdateListener(new Ddcejp(i, this));
            this.f6214B7CMnp.setInterpolator(this.f6215B9tovu);
            this.f6214B7CMnp.setDuration((long) ((z ? this.f6216BChYOn : this.f6217BI9f7h) * f2));
            this.f6214B7CMnp.start();
        }
    }

    public final void ASJ6gh(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
            this.f6204AZkASS = mutate;
            mutate.setTintList(this.f6206AcNBzu);
            ARc23Z(this.f6196A2egSU.f11499B9tovu, false);
        } else {
            this.f6204AZkASS = f6195BNL6CD;
        }
        LayerDrawable layerDrawable = this.f6210B25kr6;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(2131297669, this.f6204AZkASS);
        }
    }

    public final void AYUAbz(B2KMhB b2KMhB) {
        this.f6207AlLFFp = b2KMhB;
        AaHO0E aaHO0E = this.f6198A5SV6n;
        aaHO0E.setShapeAppearanceModel(b2KMhB);
        aaHO0E.f7063CASmeH = !aaHO0E.AzWtSf();
        AaHO0E aaHO0E2 = this.f6199ADYaiT;
        if (aaHO0E2 != null) {
            aaHO0E2.setShapeAppearanceModel(b2KMhB);
        }
        AaHO0E aaHO0E3 = this.f6211B2KMhB;
        if (aaHO0E3 != null) {
            aaHO0E3.setShapeAppearanceModel(b2KMhB);
        }
    }

    public final boolean AZOQYO() {
        MaterialCardView materialCardView = this.f6196A2egSU;
        return materialCardView.getPreventCornerOverlap() && this.f6198A5SV6n.AzWtSf() && materialCardView.getUseCompatPadding();
    }

    public final boolean AZkASS() {
        View view = this.f6196A2egSU;
        if (view.isClickable()) {
            return true;
        }
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final void AaHO0E() {
        Drawable drawable = this.f6203AZOQYO;
        Drawable A5SV6n2 = AZkASS() ? A5SV6n() : this.f6199ADYaiT;
        this.f6203AZOQYO = A5SV6n2;
        if (drawable != A5SV6n2) {
            int i = Build.VERSION.SDK_INT;
            MaterialCardView materialCardView = this.f6196A2egSU;
            if (i < 23 || !(materialCardView.getForeground() instanceof InsetDrawable)) {
                materialCardView.setForeground(ADYaiT(A5SV6n2));
            } else {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(A5SV6n2);
            }
        }
    }

    public final void AcNBzu() {
        MaterialCardView materialCardView = this.f6196A2egSU;
        float f = 0.0f;
        float A2egSU2 = ((materialCardView.getPreventCornerOverlap() && !this.f6198A5SV6n.AzWtSf()) || AZOQYO()) ? A2egSU() : 0.0f;
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            f = (float) ((1.0d - f6194BJ7GGh) * materialCardView.getCardViewRadius());
        }
        int i = (int) (A2egSU2 - f);
        Rect rect = this.f6197A4TApA;
        materialCardView.f8273AmA8tU.set(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
        K1Z3yj.A2egSU a2egSU = materialCardView.f8275B25kr6;
        if (!((CardView) a2egSU.f4175AmA8tU).getUseCompatPadding()) {
            a2egSU.B7CMnp(0, 0, 0, 0);
            return;
        }
        AzWtSf.A2egSU a2egSU2 = (AzWtSf.A2egSU) ((Drawable) a2egSU.f4174AlLFFp);
        float f2 = a2egSU2.AMqCpz;
        float f3 = a2egSU2.f957A2egSU;
        CardView cardView = (CardView) a2egSU.f4175AmA8tU;
        int ceil = (int) Math.ceil(AzWtSf.A4TApA.A2egSU(f2, f3, cardView.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(AzWtSf.A4TApA.A4TApA(f2, f3, cardView.getPreventCornerOverlap()));
        a2egSU.B7CMnp(ceil, ceil2, ceil, ceil2);
    }

    public final void AlLFFp() {
        boolean z = this.f6212B3GDIM;
        MaterialCardView materialCardView = this.f6196A2egSU;
        if (!z) {
            materialCardView.setBackgroundInternal(ADYaiT(this.f6198A5SV6n));
        }
        materialCardView.setForeground(ADYaiT(this.f6203AZOQYO));
    }
}
