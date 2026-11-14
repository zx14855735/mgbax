package PCV8se;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AZOQYO extends Drawable.ConstantState {

    /* renamed from: A2egSU, reason: collision with root package name */
    public B2KMhB f7021A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public C2rE4F f7022A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public OSA5Fl.A2egSU f7023A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ColorStateList f7024ADYaiT;
    public ColorStateList AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public ColorStateList f7025ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public PorterDuff.Mode f7026ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public Rect f7027AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final float f7028AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public float f7029AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public float f7030AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f7031AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f7032AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f7033AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f7034AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f7035B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f7036B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Paint.Style f7037B3GDIM;

    public AZOQYO(B2KMhB b2KMhB) {
        this.f7024ADYaiT = null;
        this.AMqCpz = null;
        this.f7025ARc23Z = null;
        this.f7026ASJ6gh = PorterDuff.Mode.SRC_IN;
        this.f7027AYUAbz = null;
        this.f7028AZOQYO = 1.0f;
        this.f7029AZkASS = 1.0f;
        this.f7031AcNBzu = 255;
        this.f7032AlLFFp = 0.0f;
        this.f7033AmA8tU = 0.0f;
        this.f7034AzWtSf = 0;
        this.f7035B25kr6 = 0;
        this.f7036B2KMhB = 0;
        this.f7037B3GDIM = Paint.Style.FILL_AND_STROKE;
        this.f7021A2egSU = b2KMhB;
        this.f7023A5SV6n = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        AaHO0E aaHO0E = new AaHO0E(this);
        aaHO0E.f7046B2KMhB = true;
        aaHO0E.f7047B3GDIM = true;
        return aaHO0E;
    }

    public AZOQYO(AZOQYO azoqyo) {
        this.f7024ADYaiT = null;
        this.AMqCpz = null;
        this.f7025ARc23Z = null;
        this.f7026ASJ6gh = PorterDuff.Mode.SRC_IN;
        this.f7027AYUAbz = null;
        this.f7028AZOQYO = 1.0f;
        this.f7029AZkASS = 1.0f;
        this.f7031AcNBzu = 255;
        this.f7032AlLFFp = 0.0f;
        this.f7033AmA8tU = 0.0f;
        this.f7034AzWtSf = 0;
        this.f7035B25kr6 = 0;
        this.f7036B2KMhB = 0;
        this.f7037B3GDIM = Paint.Style.FILL_AND_STROKE;
        this.f7021A2egSU = azoqyo.f7021A2egSU;
        this.f7022A4TApA = azoqyo.f7022A4TApA;
        this.f7023A5SV6n = azoqyo.f7023A5SV6n;
        this.f7030AaHO0E = azoqyo.f7030AaHO0E;
        this.f7024ADYaiT = azoqyo.f7024ADYaiT;
        this.AMqCpz = azoqyo.AMqCpz;
        this.f7026ASJ6gh = azoqyo.f7026ASJ6gh;
        this.f7025ARc23Z = azoqyo.f7025ARc23Z;
        this.f7031AcNBzu = azoqyo.f7031AcNBzu;
        this.f7028AZOQYO = azoqyo.f7028AZOQYO;
        this.f7036B2KMhB = azoqyo.f7036B2KMhB;
        this.f7034AzWtSf = azoqyo.f7034AzWtSf;
        this.f7029AZkASS = azoqyo.f7029AZkASS;
        this.f7032AlLFFp = azoqyo.f7032AlLFFp;
        this.f7033AmA8tU = azoqyo.f7033AmA8tU;
        this.f7035B25kr6 = azoqyo.f7035B25kr6;
        this.f7037B3GDIM = azoqyo.f7037B3GDIM;
        if (azoqyo.f7027AYUAbz != null) {
            this.f7027AYUAbz = new Rect(azoqyo.f7027AYUAbz);
        }
    }
}
