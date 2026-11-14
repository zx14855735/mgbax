package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CSDoyG extends C4FrIb {
    public final CQhlFr AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public Drawable f688ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public ColorStateList f689ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public PorterDuff.Mode f690AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f691AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f692AZkASS;

    public CSDoyG(CQhlFr cQhlFr) {
        super(cQhlFr);
        this.f689ASJ6gh = null;
        this.f690AYUAbz = null;
        this.f691AZOQYO = false;
        this.f692AZkASS = false;
        this.AMqCpz = cQhlFr;
    }

    @Override // AaHO0E.C4FrIb
    public final void A4TApA(AttributeSet attributeSet, int i) {
        super.A4TApA(attributeSet, 2130969826);
        CQhlFr cQhlFr = this.AMqCpz;
        Context context = cQhlFr.getContext();
        int[] iArr = R$styleable.f8019ASJ6gh;
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(context, attributeSet, iArr, 2130969826);
        COJEAR.DG07BK.B3GDIM(cQhlFr, cQhlFr.getContext(), iArr, attributeSet, ARc23Z2.f884A4TApA, 2130969826);
        Drawable A5SV6n2 = ARc23Z2.A5SV6n(0);
        if (A5SV6n2 != null) {
            cQhlFr.setThumb(A5SV6n2);
        }
        Drawable A4TApA2 = ARc23Z2.A4TApA(1);
        Drawable drawable = this.f688ARc23Z;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f688ARc23Z = A4TApA2;
        if (A4TApA2 != null) {
            A4TApA2.setCallback(cQhlFr);
            com.bumptech.glide.A5SV6n.D8cQ8b(A4TApA2, cQhlFr.getLayoutDirection());
            if (A4TApA2.isStateful()) {
                A4TApA2.setState(cQhlFr.getDrawableState());
            }
            ARc23Z();
        }
        cQhlFr.invalidate();
        TypedArray typedArray = ARc23Z2.f884A4TApA;
        if (typedArray.hasValue(3)) {
            this.f690AYUAbz = EGM26s.A5SV6n(typedArray.getInt(3, -1), this.f690AYUAbz);
            this.f692AZkASS = true;
        }
        if (typedArray.hasValue(2)) {
            this.f689ASJ6gh = ARc23Z2.A2egSU(2);
            this.f691AZOQYO = true;
        }
        ARc23Z2.ASJ6gh();
        ARc23Z();
    }

    public final void ARc23Z() {
        Drawable drawable = this.f688ARc23Z;
        if (drawable != null) {
            if (this.f691AZOQYO || this.f692AZkASS) {
                Drawable DvK7DB2 = com.bumptech.glide.A5SV6n.DvK7DB(drawable.mutate());
                this.f688ARc23Z = DvK7DB2;
                if (this.f691AZOQYO) {
                    BmvVmW.A2egSU.AYUAbz(DvK7DB2, this.f689ASJ6gh);
                }
                if (this.f692AZkASS) {
                    BmvVmW.A2egSU.AZOQYO(this.f688ARc23Z, this.f690AYUAbz);
                }
                if (this.f688ARc23Z.isStateful()) {
                    this.f688ARc23Z.setState(this.AMqCpz.getDrawableState());
                }
            }
        }
    }

    public final void ASJ6gh(Canvas canvas) {
        if (this.f688ARc23Z != null) {
            int max = this.AMqCpz.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f688ARc23Z.getIntrinsicWidth();
                int intrinsicHeight = this.f688ARc23Z.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f688ARc23Z.setBounds(-i, -i2, i, i2);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f688ARc23Z.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
