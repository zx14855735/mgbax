package NpX2pY;

import ADYaiT.CtFAbx;
import Oay4Bh.C4FrIb;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A4TApA f6115A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A4TApA f6116A4TApA = new A4TApA();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final float f6117A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final float f6118ADYaiT;
    public final float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final float f6119ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final float f6120ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f6121AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final int f6122AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final int f6123AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final int f6124AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f6125AcNBzu;

    public A5SV6n(Context context, A4TApA a4TApA) {
        AttributeSet attributeSet;
        int i;
        Locale locale;
        int next;
        Locale.Category unused;
        A4TApA a4TApA2 = a4TApA == null ? new A4TApA() : a4TApA;
        int i2 = a4TApA2.f6085AcNBzu;
        if (i2 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i2);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                attributeSet = asAttributeSet;
                i = asAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(CtFAbx.AzWtSf(new StringBuilder("Can't load badge resource ID #0x"), i2));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            i = 0;
        }
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context, attributeSet, R$styleable.f11214A5SV6n, 2130968674, i == 0 ? 2131952821 : i, new int[0]);
        Resources resources = context.getResources();
        this.f6117A5SV6n = AmA8tU2.getDimensionPixelSize(5, -1);
        this.f6122AZOQYO = context.getResources().getDimensionPixelSize(2131166342);
        this.f6123AZkASS = context.getResources().getDimensionPixelSize(2131166345);
        this.f6118ADYaiT = AmA8tU2.getDimensionPixelSize(15, -1);
        this.AMqCpz = AmA8tU2.getDimension(13, resources.getDimension(2131165636));
        this.f6120ASJ6gh = AmA8tU2.getDimension(18, resources.getDimension(2131165640));
        this.f6119ARc23Z = AmA8tU2.getDimension(4, resources.getDimension(2131165636));
        this.f6121AYUAbz = AmA8tU2.getDimension(14, resources.getDimension(2131165640));
        this.f6124AaHO0E = AmA8tU2.getInt(25, 1);
        this.f6125AcNBzu = AmA8tU2.getInt(2, 0);
        A4TApA a4TApA3 = this.f6116A4TApA;
        int i3 = a4TApA2.f6093B7CMnp;
        a4TApA3.f6093B7CMnp = i3 == -2 ? 255 : i3;
        int i4 = a4TApA2.f6095BChYOn;
        if (i4 != -2) {
            a4TApA3.f6095BChYOn = i4;
        } else if (AmA8tU2.hasValue(24)) {
            this.f6116A4TApA.f6095BChYOn = AmA8tU2.getInt(24, 0);
        } else {
            this.f6116A4TApA.f6095BChYOn = -1;
        }
        String str = a4TApA2.f6094B9tovu;
        if (str != null) {
            this.f6116A4TApA.f6094B9tovu = str;
        } else if (AmA8tU2.hasValue(8)) {
            this.f6116A4TApA.f6094B9tovu = AmA8tU2.getString(8);
        }
        A4TApA a4TApA4 = this.f6116A4TApA;
        a4TApA4.f6099BNL6CD = a4TApA2.f6099BNL6CD;
        CharSequence charSequence = a4TApA2.f6100BPw6Q8;
        a4TApA4.f6100BPw6Q8 = charSequence == null ? context.getString(2131886549) : charSequence;
        A4TApA a4TApA5 = this.f6116A4TApA;
        int i5 = a4TApA2.f6101BTvldC;
        a4TApA5.f6101BTvldC = i5 == 0 ? 2131755008 : i5;
        int i6 = a4TApA2.f6102BV3sI0;
        a4TApA5.f6102BV3sI0 = i6 == 0 ? 2131886564 : i6;
        Boolean bool = a4TApA2.f6104BniPrB;
        a4TApA5.f6104BniPrB = Boolean.valueOf(bool == null || bool.booleanValue());
        A4TApA a4TApA6 = this.f6116A4TApA;
        int i7 = a4TApA2.f6096BI9f7h;
        a4TApA6.f6096BI9f7h = i7 == -2 ? AmA8tU2.getInt(22, -2) : i7;
        A4TApA a4TApA7 = this.f6116A4TApA;
        int i8 = a4TApA2.f6097BIYEnU;
        a4TApA7.f6097BIYEnU = i8 == -2 ? AmA8tU2.getInt(23, -2) : i8;
        A4TApA a4TApA8 = this.f6116A4TApA;
        Integer num = a4TApA2.f6089B25kr6;
        a4TApA8.f6089B25kr6 = Integer.valueOf(num == null ? AmA8tU2.getResourceId(6, 2131952090) : num.intValue());
        A4TApA a4TApA9 = this.f6116A4TApA;
        Integer num2 = a4TApA2.f6090B2KMhB;
        a4TApA9.f6090B2KMhB = Integer.valueOf(num2 == null ? AmA8tU2.getResourceId(7, 0) : num2.intValue());
        A4TApA a4TApA10 = this.f6116A4TApA;
        Integer num3 = a4TApA2.f6091B3GDIM;
        a4TApA10.f6091B3GDIM = Integer.valueOf(num3 == null ? AmA8tU2.getResourceId(16, 2131952090) : num3.intValue());
        A4TApA a4TApA11 = this.f6116A4TApA;
        Integer num4 = a4TApA2.f6092B4ZgIw;
        a4TApA11.f6092B4ZgIw = Integer.valueOf(num4 == null ? AmA8tU2.getResourceId(17, 0) : num4.intValue());
        A4TApA a4TApA12 = this.f6116A4TApA;
        Integer num5 = a4TApA2.f6086AlLFFp;
        a4TApA12.f6086AlLFFp = Integer.valueOf(num5 == null ? AMqCpz.BPw6Q8(context, AmA8tU2, 1).getDefaultColor() : num5.intValue());
        A4TApA a4TApA13 = this.f6116A4TApA;
        Integer num6 = a4TApA2.f6088AzWtSf;
        a4TApA13.f6088AzWtSf = Integer.valueOf(num6 == null ? AmA8tU2.getResourceId(9, 2131952268) : num6.intValue());
        Integer num7 = a4TApA2.f6087AmA8tU;
        if (num7 != null) {
            this.f6116A4TApA.f6087AmA8tU = num7;
        } else if (AmA8tU2.hasValue(10)) {
            this.f6116A4TApA.f6087AmA8tU = Integer.valueOf(AMqCpz.BPw6Q8(context, AmA8tU2, 10).getDefaultColor());
        } else {
            int intValue = this.f6116A4TApA.f6088AzWtSf.intValue();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(intValue, androidx.appcompat.R$styleable.f8036BIYEnU);
            obtainStyledAttributes.getDimension(0, 0.0f);
            ColorStateList BPw6Q82 = AMqCpz.BPw6Q8(context, obtainStyledAttributes, 3);
            AMqCpz.BPw6Q8(context, obtainStyledAttributes, 4);
            AMqCpz.BPw6Q8(context, obtainStyledAttributes, 5);
            obtainStyledAttributes.getInt(2, 0);
            obtainStyledAttributes.getInt(1, 1);
            int i9 = obtainStyledAttributes.hasValue(12) ? 12 : 10;
            obtainStyledAttributes.getResourceId(i9, 0);
            obtainStyledAttributes.getString(i9);
            obtainStyledAttributes.getBoolean(14, false);
            AMqCpz.BPw6Q8(context, obtainStyledAttributes, 6);
            obtainStyledAttributes.getFloat(7, 0.0f);
            obtainStyledAttributes.getFloat(8, 0.0f);
            obtainStyledAttributes.getFloat(9, 0.0f);
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(intValue, R$styleable.f11243C4FrIb);
            obtainStyledAttributes2.hasValue(0);
            obtainStyledAttributes2.getFloat(0, 0.0f);
            if (Build.VERSION.SDK_INT >= 26) {
                obtainStyledAttributes2.getString(obtainStyledAttributes2.hasValue(3) ? 3 : 1);
            }
            obtainStyledAttributes2.recycle();
            this.f6116A4TApA.f6087AmA8tU = Integer.valueOf(BPw6Q82.getDefaultColor());
        }
        A4TApA a4TApA14 = this.f6116A4TApA;
        Integer num8 = a4TApA2.f6103BmvVmW;
        a4TApA14.f6103BmvVmW = Integer.valueOf(num8 == null ? AmA8tU2.getInt(3, 8388661) : num8.intValue());
        A4TApA a4TApA15 = this.f6116A4TApA;
        Integer num9 = a4TApA2.BpkvW3;
        a4TApA15.BpkvW3 = Integer.valueOf(num9 == null ? AmA8tU2.getDimensionPixelSize(12, resources.getDimensionPixelSize(2131166343)) : num9.intValue());
        A4TApA a4TApA16 = this.f6116A4TApA;
        Integer num10 = a4TApA2.f6105C2rE4F;
        a4TApA16.f6105C2rE4F = Integer.valueOf(num10 == null ? AmA8tU2.getDimensionPixelSize(11, resources.getDimensionPixelSize(2131165642)) : num10.intValue());
        A4TApA a4TApA17 = this.f6116A4TApA;
        Integer num11 = a4TApA2.f6106C4FrIb;
        a4TApA17.f6106C4FrIb = Integer.valueOf(num11 == null ? AmA8tU2.getDimensionPixelOffset(19, 0) : num11.intValue());
        A4TApA a4TApA18 = this.f6116A4TApA;
        Integer num12 = a4TApA2.f6107CASmeH;
        a4TApA18.f6107CASmeH = Integer.valueOf(num12 == null ? AmA8tU2.getDimensionPixelOffset(26, 0) : num12.intValue());
        A4TApA a4TApA19 = this.f6116A4TApA;
        Integer num13 = a4TApA2.f6108CNPG0E;
        a4TApA19.f6108CNPG0E = Integer.valueOf(num13 == null ? AmA8tU2.getDimensionPixelOffset(20, a4TApA19.f6106C4FrIb.intValue()) : num13.intValue());
        A4TApA a4TApA20 = this.f6116A4TApA;
        Integer num14 = a4TApA2.f6109COJEAR;
        a4TApA20.f6109COJEAR = Integer.valueOf(num14 == null ? AmA8tU2.getDimensionPixelOffset(27, a4TApA20.f6107CASmeH.intValue()) : num14.intValue());
        A4TApA a4TApA21 = this.f6116A4TApA;
        Integer num15 = a4TApA2.f6112CTkVKb;
        a4TApA21.f6112CTkVKb = Integer.valueOf(num15 == null ? AmA8tU2.getDimensionPixelOffset(21, 0) : num15.intValue());
        A4TApA a4TApA22 = this.f6116A4TApA;
        Integer num16 = a4TApA2.f6110CQhlFr;
        a4TApA22.f6110CQhlFr = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        A4TApA a4TApA23 = this.f6116A4TApA;
        Integer num17 = a4TApA2.f6111CSDoyG;
        a4TApA23.f6111CSDoyG = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        A4TApA a4TApA24 = this.f6116A4TApA;
        Boolean bool2 = a4TApA2.f6113CcAIMM;
        a4TApA24.f6113CcAIMM = Boolean.valueOf(bool2 == null ? AmA8tU2.getBoolean(0, false) : bool2.booleanValue());
        AmA8tU2.recycle();
        Locale locale2 = a4TApA2.f6098BJ7GGh;
        if (locale2 == null) {
            A4TApA a4TApA25 = this.f6116A4TApA;
            if (Build.VERSION.SDK_INT >= 24) {
                unused = Locale.Category.FORMAT;
                locale = Locale.getDefault(Locale.Category.FORMAT);
            } else {
                locale = Locale.getDefault();
            }
            a4TApA25.f6098BJ7GGh = locale;
        } else {
            this.f6116A4TApA.f6098BJ7GGh = locale2;
        }
        this.f6115A2egSU = a4TApA2;
    }
}
