package P3rngT;

import BTvldC.B4ZgIw;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.R$styleable;
import com.sigmob.sdk.base.blurkit.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ColorStateList f6942A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f6943A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f6944A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f6945ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final float f6946ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final float f6947ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f6948AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final boolean f6949AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final float f6950AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public ColorStateList f6951AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public float f6952AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f6953AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f6954AmA8tU = false;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f6955AzWtSf = false;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Typeface f6956B25kr6;

    public AMqCpz(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.f8036BIYEnU);
        this.f6952AcNBzu = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f6951AaHO0E = com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 3);
        com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 4);
        com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 5);
        this.f6945ADYaiT = obtainStyledAttributes.getInt(2, 0);
        this.AMqCpz = obtainStyledAttributes.getInt(1, 1);
        int i2 = obtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f6953AlLFFp = obtainStyledAttributes.getResourceId(i2, 0);
        this.f6943A4TApA = obtainStyledAttributes.getString(i2);
        obtainStyledAttributes.getBoolean(14, false);
        this.f6942A2egSU = com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 6);
        this.f6946ARc23Z = obtainStyledAttributes.getFloat(7, 0.0f);
        this.f6947ASJ6gh = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f6948AYUAbz = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.f11243C4FrIb);
        this.f6949AZOQYO = obtainStyledAttributes2.hasValue(0);
        this.f6950AZkASS = obtainStyledAttributes2.getFloat(0, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6944A5SV6n = obtainStyledAttributes2.getString(obtainStyledAttributes2.hasValue(3) ? 3 : 1);
        }
        obtainStyledAttributes2.recycle();
    }

    public final void A2egSU() {
        String str;
        Typeface typeface = this.f6956B25kr6;
        int i = this.f6945ADYaiT;
        if (typeface == null && (str = this.f6943A4TApA) != null) {
            this.f6956B25kr6 = Typeface.create(str, i);
        }
        if (this.f6956B25kr6 == null) {
            int i2 = this.AMqCpz;
            if (i2 == 1) {
                this.f6956B25kr6 = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.f6956B25kr6 = Typeface.SERIF;
            } else if (i2 != 3) {
                this.f6956B25kr6 = Typeface.DEFAULT;
            } else {
                this.f6956B25kr6 = Typeface.MONOSPACE;
            }
            this.f6956B25kr6 = Typeface.create(this.f6956B25kr6, i);
        }
    }

    public final void A4TApA(Context context, ARc23Z aRc23Z) {
        if (!A5SV6n(context)) {
            A2egSU();
        }
        int i = this.f6953AlLFFp;
        if (i == 0) {
            this.f6954AmA8tU = true;
        }
        if (this.f6954AmA8tU) {
            aRc23Z.A4TApA(this.f6956B25kr6, true);
            return;
        }
        try {
            A5SV6n a5SV6n = new A5SV6n(this, aRc23Z);
            ThreadLocal threadLocal = B4ZgIw.f1468A2egSU;
            if (context.isRestricted()) {
                a5SV6n.A2egSU(-4);
            } else {
                B4ZgIw.A4TApA(context, i, new TypedValue(), 0, a5SV6n, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f6954AmA8tU = true;
            aRc23Z.A2egSU(1);
        } catch (Exception unused2) {
            this.f6954AmA8tU = true;
            aRc23Z.A2egSU(-3);
        }
    }

    public final boolean A5SV6n(Context context) {
        Context context2;
        Typeface A4TApA2;
        String str;
        Typeface create;
        if (this.f6954AmA8tU) {
            return true;
        }
        int i = this.f6953AlLFFp;
        if (i != 0) {
            ThreadLocal threadLocal = B4ZgIw.f1468A2egSU;
            Typeface typeface = null;
            if (context.isRestricted()) {
                context2 = context;
                A4TApA2 = null;
            } else {
                context2 = context;
                A4TApA2 = B4ZgIw.A4TApA(context2, i, new TypedValue(), 0, null, false, true);
            }
            if (A4TApA2 != null) {
                this.f6956B25kr6 = A4TApA2;
                this.f6954AmA8tU = true;
                return true;
            }
            if (!this.f6955AzWtSf) {
                this.f6955AzWtSf = true;
                Resources resources = context2.getResources();
                int i2 = this.f6953AlLFFp;
                if (i2 != 0 && resources.getResourceTypeName(i2).equals("font")) {
                    try {
                        XmlResourceParser xml = resources.getXml(i2);
                        while (xml.getEventType() != 1) {
                            if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R$styleable.f8469A4TApA);
                                str = obtainAttributes.getString(6);
                                obtainAttributes.recycle();
                                break;
                            }
                            xml.next();
                        }
                    } catch (Throwable unused) {
                    }
                }
                str = null;
                if (str != null && (create = Typeface.create(str, 0)) != Typeface.DEFAULT) {
                    typeface = Typeface.create(create, this.f6945ADYaiT);
                }
            }
            if (typeface != null) {
                this.f6956B25kr6 = typeface;
                this.f6954AmA8tU = true;
                return true;
            }
        }
        return false;
    }

    public final void ADYaiT(Context context, TextPaint textPaint, ARc23Z aRc23Z) {
        AMqCpz(context, textPaint, aRc23Z);
        ColorStateList colorStateList = this.f6951AaHO0E;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : d.f13043a);
        ColorStateList colorStateList2 = this.f6942A2egSU;
        textPaint.setShadowLayer(this.f6948AYUAbz, this.f6946ARc23Z, this.f6947ASJ6gh, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void AMqCpz(Context context, TextPaint textPaint, ARc23Z aRc23Z) {
        Typeface typeface;
        if (A5SV6n(context) && this.f6954AmA8tU && (typeface = this.f6956B25kr6) != null) {
            ARc23Z(context, textPaint, typeface);
            return;
        }
        A2egSU();
        ARc23Z(context, textPaint, this.f6956B25kr6);
        A4TApA(context, new ADYaiT(this, context, textPaint, aRc23Z));
    }

    public final void ARc23Z(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface CkXcdM2 = JrXYwF.A4TApA.CkXcdM(context.getResources().getConfiguration(), typeface);
        if (CkXcdM2 != null) {
            typeface = CkXcdM2;
        }
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.f6945ADYaiT;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f6952AcNBzu);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(this.f6944A5SV6n);
        }
        if (this.f6949AZOQYO) {
            textPaint.setLetterSpacing(this.f6950AZkASS);
        }
    }
}
