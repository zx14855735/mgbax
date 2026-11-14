package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BmvVmW {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ImageView f670A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public GJee0v f671A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public GJee0v f672A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f673ADYaiT = 0;

    public BmvVmW(ImageView imageView) {
        this.f670A2egSU = imageView;
    }

    public final void A2egSU() {
        ImageView imageView = this.f670A2egSU;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            EGM26s.A2egSU(drawable);
        }
        if (drawable != null) {
            int i = Build.VERSION.SDK_INT;
            if (i <= 21 && i == 21) {
                if (this.f672A5SV6n == null) {
                    this.f672A5SV6n = new GJee0v();
                }
                GJee0v gJee0v = this.f672A5SV6n;
                gJee0v.f879A2egSU = null;
                gJee0v.f882ADYaiT = false;
                gJee0v.f880A4TApA = null;
                gJee0v.f881A5SV6n = false;
                ColorStateList A2egSU2 = CikNvS.ARc23Z.A2egSU(imageView);
                if (A2egSU2 != null) {
                    gJee0v.f882ADYaiT = true;
                    gJee0v.f879A2egSU = A2egSU2;
                }
                PorterDuff.Mode A4TApA2 = CikNvS.ARc23Z.A4TApA(imageView);
                if (A4TApA2 != null) {
                    gJee0v.f881A5SV6n = true;
                    gJee0v.f880A4TApA = A4TApA2;
                }
                if (gJee0v.f882ADYaiT || gJee0v.f881A5SV6n) {
                    BNL6CD.AMqCpz(drawable, gJee0v, imageView.getDrawableState());
                    return;
                }
            }
            GJee0v gJee0v2 = this.f671A4TApA;
            if (gJee0v2 != null) {
                BNL6CD.AMqCpz(drawable, gJee0v2, imageView.getDrawableState());
            }
        }
    }

    public final void A4TApA(AttributeSet attributeSet, int i) {
        Drawable drawable;
        Drawable drawable2;
        int resourceId;
        ImageView imageView = this.f670A2egSU;
        Context context = imageView.getContext();
        int[] iArr = R$styleable.f8018ARc23Z;
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(context, attributeSet, iArr, i);
        COJEAR.DG07BK.B3GDIM(imageView, imageView.getContext(), iArr, attributeSet, ARc23Z2.f884A4TApA, i);
        try {
            Drawable drawable3 = imageView.getDrawable();
            TypedArray typedArray = ARc23Z2.f884A4TApA;
            if (drawable3 == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable3 = NOd7IU.AlLFFp.CQhlFr(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                EGM26s.A2egSU(drawable3);
            }
            if (typedArray.hasValue(2)) {
                ColorStateList A2egSU2 = ARc23Z2.A2egSU(2);
                int i2 = Build.VERSION.SDK_INT;
                CikNvS.ARc23Z.A5SV6n(imageView, A2egSU2);
                if (i2 == 21 && (drawable2 = imageView.getDrawable()) != null && CikNvS.ARc23Z.A2egSU(imageView) != null) {
                    if (drawable2.isStateful()) {
                        drawable2.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable2);
                }
            }
            if (typedArray.hasValue(3)) {
                PorterDuff.Mode A5SV6n2 = EGM26s.A5SV6n(typedArray.getInt(3, -1), null);
                int i3 = Build.VERSION.SDK_INT;
                CikNvS.ARc23Z.ADYaiT(imageView, A5SV6n2);
                if (i3 == 21 && (drawable = imageView.getDrawable()) != null && CikNvS.ARc23Z.A2egSU(imageView) != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
            ARc23Z2.ASJ6gh();
        } catch (Throwable th) {
            ARc23Z2.ASJ6gh();
            throw th;
        }
    }
}
