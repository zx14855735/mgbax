package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B7CMnp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final View f635A2egSU;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public GJee0v f638ADYaiT;
    public GJee0v AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public GJee0v f639ARc23Z;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f637A5SV6n = -1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final BNL6CD f636A4TApA = BNL6CD.A2egSU();

    public B7CMnp(View view) {
        this.f635A2egSU = view;
    }

    public final void A2egSU() {
        View view = this.f635A2egSU;
        Drawable background = view.getBackground();
        if (background != null) {
            int i = Build.VERSION.SDK_INT;
            if (i <= 21 ? i == 21 : this.f638ADYaiT != null) {
                if (this.f639ARc23Z == null) {
                    this.f639ARc23Z = new GJee0v();
                }
                GJee0v gJee0v = this.f639ARc23Z;
                gJee0v.f879A2egSU = null;
                gJee0v.f882ADYaiT = false;
                gJee0v.f880A4TApA = null;
                gJee0v.f881A5SV6n = false;
                WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                ColorStateList ASJ6gh2 = COJEAR.CmUvjW.ASJ6gh(view);
                if (ASJ6gh2 != null) {
                    gJee0v.f882ADYaiT = true;
                    gJee0v.f879A2egSU = ASJ6gh2;
                }
                PorterDuff.Mode AYUAbz2 = COJEAR.CmUvjW.AYUAbz(view);
                if (AYUAbz2 != null) {
                    gJee0v.f881A5SV6n = true;
                    gJee0v.f880A4TApA = AYUAbz2;
                }
                if (gJee0v.f882ADYaiT || gJee0v.f881A5SV6n) {
                    BNL6CD.AMqCpz(background, gJee0v, view.getDrawableState());
                    return;
                }
            }
            GJee0v gJee0v2 = this.AMqCpz;
            if (gJee0v2 != null) {
                BNL6CD.AMqCpz(background, gJee0v2, view.getDrawableState());
                return;
            }
            GJee0v gJee0v3 = this.f638ADYaiT;
            if (gJee0v3 != null) {
                BNL6CD.AMqCpz(background, gJee0v3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList A4TApA() {
        GJee0v gJee0v = this.AMqCpz;
        if (gJee0v != null) {
            return gJee0v.f879A2egSU;
        }
        return null;
    }

    public final PorterDuff.Mode A5SV6n() {
        GJee0v gJee0v = this.AMqCpz;
        if (gJee0v != null) {
            return gJee0v.f880A4TApA;
        }
        return null;
    }

    public final void ADYaiT(AttributeSet attributeSet, int i) {
        ColorStateList AZOQYO2;
        View view = this.f635A2egSU;
        Context context = view.getContext();
        int[] iArr = R$styleable.f8039BPw6Q8;
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(context, attributeSet, iArr, i);
        TypedArray typedArray = ARc23Z2.f884A4TApA;
        View view2 = this.f635A2egSU;
        COJEAR.DG07BK.B3GDIM(view2, view2.getContext(), iArr, attributeSet, ARc23Z2.f884A4TApA, i);
        try {
            if (typedArray.hasValue(0)) {
                this.f637A5SV6n = typedArray.getResourceId(0, -1);
                BNL6CD bnl6cd = this.f636A4TApA;
                Context context2 = view.getContext();
                int i2 = this.f637A5SV6n;
                synchronized (bnl6cd) {
                    AZOQYO2 = bnl6cd.f663A2egSU.AZOQYO(context2, i2);
                }
                if (AZOQYO2 != null) {
                    ASJ6gh(AZOQYO2);
                }
            }
            if (typedArray.hasValue(1)) {
                COJEAR.DG07BK.B9tovu(view, ARc23Z2.A2egSU(1));
            }
            if (typedArray.hasValue(2)) {
                PorterDuff.Mode A5SV6n2 = EGM26s.A5SV6n(typedArray.getInt(2, -1), null);
                int i3 = Build.VERSION.SDK_INT;
                COJEAR.CmUvjW.B3GDIM(view, A5SV6n2);
                if (i3 == 21) {
                    Drawable background = view.getBackground();
                    boolean z = (COJEAR.CmUvjW.ASJ6gh(view) == null && COJEAR.CmUvjW.AYUAbz(view) == null) ? false : true;
                    if (background != null && z) {
                        if (background.isStateful()) {
                            background.setState(view.getDrawableState());
                        }
                        view.setBackground(background);
                    }
                }
            }
            ARc23Z2.ASJ6gh();
        } catch (Throwable th) {
            ARc23Z2.ASJ6gh();
            throw th;
        }
    }

    public final void AMqCpz() {
        this.f637A5SV6n = -1;
        ASJ6gh(null);
        A2egSU();
    }

    public final void ARc23Z(int i) {
        ColorStateList colorStateList;
        this.f637A5SV6n = i;
        BNL6CD bnl6cd = this.f636A4TApA;
        if (bnl6cd != null) {
            Context context = this.f635A2egSU.getContext();
            synchronized (bnl6cd) {
                colorStateList = bnl6cd.f663A2egSU.AZOQYO(context, i);
            }
        } else {
            colorStateList = null;
        }
        ASJ6gh(colorStateList);
        A2egSU();
    }

    public final void ASJ6gh(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f638ADYaiT == null) {
                this.f638ADYaiT = new GJee0v();
            }
            GJee0v gJee0v = this.f638ADYaiT;
            gJee0v.f879A2egSU = colorStateList;
            gJee0v.f882ADYaiT = true;
        } else {
            this.f638ADYaiT = null;
        }
        A2egSU();
    }

    public final void AYUAbz(ColorStateList colorStateList) {
        if (this.AMqCpz == null) {
            this.AMqCpz = new GJee0v();
        }
        GJee0v gJee0v = this.AMqCpz;
        gJee0v.f879A2egSU = colorStateList;
        gJee0v.f882ADYaiT = true;
        A2egSU();
    }

    public final void AZOQYO(PorterDuff.Mode mode) {
        if (this.AMqCpz == null) {
            this.AMqCpz = new GJee0v();
        }
        GJee0v gJee0v = this.AMqCpz;
        gJee0v.f880A4TApA = mode;
        gJee0v.f881A5SV6n = true;
        A2egSU();
    }
}
