package PCV8se;

import PCV8se.B2KMhB;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.StateSet;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AaHO0E extends Drawable implements BmvVmW.AZOQYO, BPw6Q8 {

    /* renamed from: CikNvS, reason: collision with root package name */
    public static final Paint f7039CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public static final AZkASS[] f7040CkXcdM;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final NGepWW.A2egSU f7041AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AZOQYO f7042AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final BNL6CD[] f7043AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final BNL6CD[] f7044AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final BitSet f7045B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f7046B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f7047B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Matrix f7048B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Path f7049B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final Path f7050B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final RectF f7051BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final RectF f7052BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final Region f7053BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final Region f7054BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final Paint f7055BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final Paint f7056BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final P94amq.A2egSU f7057BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final IQ76hF.AmA8tU f7058BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final B7CMnp f7059BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public PorterDuffColorFilter f7060BniPrB;
    public PorterDuffColorFilter BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f7061C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final RectF f7062C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public boolean f7063CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f7064CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public B2KMhB f7065COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public CtFAbx.AYUAbz f7066CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final CtFAbx.ASJ6gh[] f7067CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public float[] f7068CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public float[] f7069CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public Cd8JRx.ADYaiT f7070Cd8JRx;

    static {
        B2KMhB.A2egSU a2egSU = new B2KMhB.A2egSU();
        int i = 0;
        AMqCpz BV3sI02 = NOd7IU.AlLFFp.BV3sI0(0);
        a2egSU.f7094A2egSU = BV3sI02;
        float A4TApA2 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA2 != -1.0f) {
            a2egSU.ARc23Z(A4TApA2);
        }
        a2egSU.f7095A4TApA = BV3sI02;
        float A4TApA3 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA3 != -1.0f) {
            a2egSU.ASJ6gh(A4TApA3);
        }
        a2egSU.f7096A5SV6n = BV3sI02;
        float A4TApA4 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA4 != -1.0f) {
            a2egSU.AMqCpz(A4TApA4);
        }
        a2egSU.f7097ADYaiT = BV3sI02;
        float A4TApA5 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA5 != -1.0f) {
            a2egSU.ADYaiT(A4TApA5);
        }
        a2egSU.A5SV6n(0.0f);
        a2egSU.A2egSU();
        Paint paint = new Paint(1);
        f7039CikNvS = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        f7040CkXcdM = new AZkASS[4];
        while (true) {
            AZkASS[] aZkASSArr = f7040CkXcdM;
            if (i >= aZkASSArr.length) {
                sJtZYw();
                return;
            } else {
                aZkASSArr[i] = new AZkASS(i);
                i++;
            }
        }
    }

    public AaHO0E() {
        this(new B2KMhB());
    }

    public static float A5SV6n(RectF rectF, B2KMhB b2KMhB, float[] fArr) {
        if (fArr == null) {
            if (b2KMhB.ARc23Z(rectF)) {
                return b2KMhB.AMqCpz.A2egSU(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f = fArr[0];
            for (int i = 1; i < fArr.length; i++) {
                if (fArr[i] != f) {
                    return -1.0f;
                }
            }
        }
        if (b2KMhB.AMqCpz()) {
            return fArr[0];
        }
        return -1.0f;
    }

    private static /* synthetic */ void sJtZYw() {
        char[] charArray = "\u0012\u001e\u001c_\u0016\u0010\u001c\u0014_\u0013\u001e\b_\u0002\u0019\u0014\u001d\u001d_;\u001f\u00183\u0003\u0018\u0015\u0016\u0014".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'q');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0012\u001d\u0018\u001f\u0018\u0005".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'q');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void A2egSU() {
        invalidateSelf();
    }

    public final void A4TApA(RectF rectF, Path path) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        this.f7059BmvVmW.A2egSU(azoqyo.f7021A2egSU, this.f7068CTkVKb, azoqyo.f7029AZkASS, rectF, this.f7058BV3sI0, path);
        if (this.f7042AlLFFp.f7028AZOQYO != 1.0f) {
            Matrix matrix = this.f7048B4ZgIw;
            matrix.reset();
            float f = this.f7042AlLFFp.f7028AZOQYO;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f7062C4FrIb, true);
    }

    public final int ADYaiT(int i) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        float f = azoqyo.f7033AmA8tU + 0.0f + azoqyo.f7032AlLFFp;
        OSA5Fl.A2egSU a2egSU = azoqyo.f7023A5SV6n;
        return a2egSU != null ? a2egSU.A2egSU(f, i) : i;
    }

    public final void AMqCpz(Canvas canvas) {
        this.f7045B25kr6.cardinality();
        int i = this.f7042AlLFFp.f7036B2KMhB;
        Path path = this.f7049B7CMnp;
        P94amq.A2egSU a2egSU = this.f7057BTvldC;
        if (i != 0) {
            canvas.drawPath(path, a2egSU.f7008A2egSU);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            BNL6CD bnl6cd = this.f7043AmA8tU[i2];
            int i3 = this.f7042AlLFFp.f7035B25kr6;
            Matrix matrix = BNL6CD.f7138A4TApA;
            bnl6cd.A2egSU(matrix, a2egSU, i3, canvas);
            this.f7044AzWtSf[i2].A2egSU(matrix, a2egSU, this.f7042AlLFFp.f7035B25kr6, canvas);
        }
        if (this.f7063CASmeH) {
            int sin = (int) (Math.sin(Math.toRadians(0)) * this.f7042AlLFFp.f7036B2KMhB);
            int AZkASS2 = AZkASS();
            canvas.translate(-sin, -AZkASS2);
            canvas.drawPath(path, f7039CikNvS);
            canvas.translate(sin, AZkASS2);
        }
    }

    public final void ARc23Z(Canvas canvas, Paint paint, Path path, B2KMhB b2KMhB, float[] fArr, RectF rectF) {
        float A5SV6n2 = A5SV6n(rectF, b2KMhB, fArr);
        if (A5SV6n2 < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f = A5SV6n2 * this.f7042AlLFFp.f7029AZkASS;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public void ASJ6gh(Canvas canvas) {
        Paint paint = this.f7056BPw6Q8;
        Path path = this.f7050B9tovu;
        B2KMhB b2KMhB = this.f7065COJEAR;
        float[] fArr = this.f7069CcAIMM;
        RectF rectF = this.f7052BI9f7h;
        rectF.set(AYUAbz());
        float AaHO0E2 = AaHO0E();
        rectF.inset(AaHO0E2, AaHO0E2);
        ARc23Z(canvas, paint, path, b2KMhB, fArr, rectF);
    }

    public final RectF AYUAbz() {
        RectF rectF = this.f7051BChYOn;
        rectF.set(getBounds());
        return rectF;
    }

    public final float AZOQYO() {
        float[] fArr = this.f7068CTkVKb;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF AYUAbz2 = AYUAbz();
        B2KMhB b2KMhB = this.f7042AlLFFp.f7021A2egSU;
        B7CMnp b7CMnp = this.f7059BmvVmW;
        b7CMnp.getClass();
        float A2egSU2 = b2KMhB.AMqCpz.A2egSU(AYUAbz2);
        B2KMhB b2KMhB2 = this.f7042AlLFFp.f7021A2egSU;
        b7CMnp.getClass();
        float A2egSU3 = b2KMhB2.f7089AYUAbz.A2egSU(AYUAbz2) + A2egSU2;
        B2KMhB b2KMhB3 = this.f7042AlLFFp.f7021A2egSU;
        b7CMnp.getClass();
        float A2egSU4 = A2egSU3 - b2KMhB3.f7088ASJ6gh.A2egSU(AYUAbz2);
        B2KMhB b2KMhB4 = this.f7042AlLFFp.f7021A2egSU;
        b7CMnp.getClass();
        return (A2egSU4 - b2KMhB4.f7087ARc23Z.A2egSU(AYUAbz2)) / 2.0f;
    }

    public final int AZkASS() {
        return (int) (Math.cos(Math.toRadians(0)) * this.f7042AlLFFp.f7036B2KMhB);
    }

    public final float AaHO0E() {
        if (AlLFFp()) {
            return this.f7056BPw6Q8.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final float AcNBzu() {
        float[] fArr = this.f7068CTkVKb;
        return fArr != null ? fArr[3] : this.f7042AlLFFp.f7021A2egSU.AMqCpz.A2egSU(AYUAbz());
    }

    public final boolean AlLFFp() {
        Paint.Style style = this.f7042AlLFFp.f7037B3GDIM;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f7056BPw6Q8.getStrokeWidth() > 0.0f;
    }

    public final void AmA8tU(Context context) {
        this.f7042AlLFFp.f7023A5SV6n = new OSA5Fl.A2egSU(context);
        BV3sI0();
    }

    public final boolean AzWtSf() {
        if (!this.f7042AlLFFp.f7021A2egSU.ARc23Z(AYUAbz())) {
            float[] fArr = this.f7068CTkVKb;
            if (fArr != null) {
                if (fArr.length > 1) {
                    float f = fArr[0];
                    for (int i = 1; i < fArr.length; i++) {
                        if (fArr[i] != f) {
                            break;
                        }
                    }
                }
                if (this.f7042AlLFFp.f7021A2egSU.AMqCpz()) {
                }
            }
            return false;
        }
        return true;
    }

    public final void B25kr6(CtFAbx.AYUAbz aYUAbz) {
        if (this.f7066CQhlFr == aYUAbz) {
            return;
        }
        this.f7066CQhlFr = aYUAbz;
        int i = 0;
        while (true) {
            CtFAbx.ASJ6gh[] aSJ6ghArr = this.f7067CSDoyG;
            if (i >= aSJ6ghArr.length) {
                BPw6Q8(getState(), true);
                invalidateSelf();
                return;
            }
            if (aSJ6ghArr[i] == null) {
                aSJ6ghArr[i] = new CtFAbx.ASJ6gh(this, f7040CkXcdM[i]);
            }
            CtFAbx.ASJ6gh aSJ6gh = aSJ6ghArr[i];
            CtFAbx.AYUAbz aYUAbz2 = new CtFAbx.AYUAbz();
            aYUAbz2.A2egSU((float) aYUAbz.f1909A4TApA);
            double d = aYUAbz.f1908A2egSU;
            aYUAbz2.A4TApA((float) (d * d));
            aSJ6gh.f1905AaHO0E = aYUAbz2;
            i++;
        }
    }

    public final void B2KMhB(float f) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        if (azoqyo.f7033AmA8tU != f) {
            azoqyo.f7033AmA8tU = f;
            BV3sI0();
        }
    }

    public final void B3GDIM(ColorStateList colorStateList) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        if (azoqyo.f7024ADYaiT != colorStateList) {
            azoqyo.f7024ADYaiT = colorStateList;
            onStateChange(getState());
        }
    }

    public final void B4ZgIw(float f) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        if (azoqyo.f7029AZkASS != f) {
            azoqyo.f7029AZkASS = f;
            this.f7046B2KMhB = true;
            this.f7047B3GDIM = true;
            invalidateSelf();
        }
    }

    public final void B7CMnp() {
        this.f7042AlLFFp.f7037B3GDIM = Paint.Style.FILL;
        super.invalidateSelf();
    }

    public final void B9tovu() {
        this.f7057BTvldC.A2egSU(-12303292);
        this.f7042AlLFFp.getClass();
        super.invalidateSelf();
    }

    public final void BChYOn(int i) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        if (azoqyo.f7034AzWtSf != i) {
            azoqyo.f7034AzWtSf = i;
            super.invalidateSelf();
        }
    }

    public final void BI9f7h(C2rE4F c2rE4F) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        if (azoqyo.f7022A4TApA != c2rE4F) {
            azoqyo.f7022A4TApA = c2rE4F;
            BPw6Q8(getState(), true);
            invalidateSelf();
        }
    }

    public final void BIYEnU(ColorStateList colorStateList) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        if (azoqyo.AMqCpz != colorStateList) {
            azoqyo.AMqCpz = colorStateList;
            onStateChange(getState());
        }
    }

    public final void BJ7GGh(float f) {
        this.f7042AlLFFp.f7030AaHO0E = f;
        invalidateSelf();
    }

    public final boolean BNL6CD(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f7042AlLFFp.f7024ADYaiT == null || color2 == (colorForState2 = this.f7042AlLFFp.f7024ADYaiT.getColorForState(iArr, (color2 = (paint2 = this.f7055BNL6CD).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.f7042AlLFFp.AMqCpz == null || color == (colorForState = this.f7042AlLFFp.AMqCpz.getColorForState(iArr, (color = (paint = this.f7056BPw6Q8).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void BPw6Q8(int[] iArr, boolean z) {
        int i;
        int[][] iArr2;
        B2KMhB A2egSU2;
        RectF AYUAbz2 = AYUAbz();
        if (this.f7042AlLFFp.f7022A4TApA == null || AYUAbz2.isEmpty()) {
            return;
        }
        int i2 = 0;
        boolean z2 = z | (this.f7066CQhlFr == null);
        if (this.f7068CTkVKb == null) {
            this.f7068CTkVKb = new float[4];
        }
        C2rE4F c2rE4F = this.f7042AlLFFp.f7022A4TApA;
        int i3 = 0;
        while (true) {
            int i4 = c2rE4F.f7150A2egSU;
            i = -1;
            iArr2 = c2rE4F.f7152A5SV6n;
            if (i3 >= i4) {
                i3 = -1;
                break;
            } else if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int i5 = 0;
            while (true) {
                if (i5 >= c2rE4F.f7150A2egSU) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr2[i5], iArr3)) {
                    i = i5;
                    break;
                }
                i5++;
            }
            i3 = i;
        }
        B2KMhB[] b2KMhBArr = c2rE4F.f7153ADYaiT;
        BpkvW3 bpkvW3 = c2rE4F.f7156AYUAbz;
        BpkvW3 bpkvW32 = c2rE4F.f7155ASJ6gh;
        BpkvW3 bpkvW33 = c2rE4F.f7154ARc23Z;
        BpkvW3 bpkvW34 = c2rE4F.AMqCpz;
        if (bpkvW34 == null && bpkvW33 == null && bpkvW32 == null && bpkvW3 == null) {
            A2egSU2 = b2KMhBArr[i3];
        } else {
            B2KMhB.A2egSU ASJ6gh2 = b2KMhBArr[i3].ASJ6gh();
            if (bpkvW34 != null) {
                ASJ6gh2.AMqCpz = bpkvW34.A5SV6n(iArr);
            }
            if (bpkvW33 != null) {
                ASJ6gh2.f7098ARc23Z = bpkvW33.A5SV6n(iArr);
            }
            if (bpkvW32 != null) {
                ASJ6gh2.f7100AYUAbz = bpkvW32.A5SV6n(iArr);
            }
            if (bpkvW3 != null) {
                ASJ6gh2.f7099ASJ6gh = bpkvW3.A5SV6n(iArr);
            }
            A2egSU2 = ASJ6gh2.A2egSU();
        }
        while (i2 < 4) {
            this.f7059BmvVmW.getClass();
            float A2egSU3 = (i2 != 1 ? i2 != 2 ? i2 != 3 ? A2egSU2.f7087ARc23Z : A2egSU2.AMqCpz : A2egSU2.f7089AYUAbz : A2egSU2.f7088ASJ6gh).A2egSU(AYUAbz2);
            if (z2) {
                this.f7068CTkVKb[i2] = A2egSU3;
            }
            CtFAbx.ASJ6gh[] aSJ6ghArr = this.f7067CSDoyG;
            CtFAbx.ASJ6gh aSJ6gh = aSJ6ghArr[i2];
            if (aSJ6gh != null) {
                aSJ6gh.A2egSU(A2egSU3);
                if (z2) {
                    aSJ6ghArr[i2].ADYaiT();
                }
            }
            i2++;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public final boolean BTvldC() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f7060BniPrB;
        PorterDuffColorFilter porterDuffColorFilter3 = this.BpkvW3;
        AZOQYO azoqyo = this.f7042AlLFFp;
        ColorStateList colorStateList = azoqyo.f7025ARc23Z;
        PorterDuff.Mode mode = azoqyo.f7026ASJ6gh;
        Paint paint = this.f7055BNL6CD;
        if (colorStateList == null || mode == null) {
            int color = paint.getColor();
            int ADYaiT2 = ADYaiT(color);
            this.f7061C2rE4F = ADYaiT2;
            porterDuffColorFilter = ADYaiT2 != color ? new PorterDuffColorFilter(ADYaiT2, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int ADYaiT3 = ADYaiT(colorStateList.getColorForState(getState(), 0));
            this.f7061C2rE4F = ADYaiT3;
            porterDuffColorFilter = new PorterDuffColorFilter(ADYaiT3, mode);
        }
        this.f7060BniPrB = porterDuffColorFilter;
        this.f7042AlLFFp.getClass();
        this.BpkvW3 = null;
        this.f7042AlLFFp.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.f7060BniPrB) && Objects.equals(porterDuffColorFilter3, this.BpkvW3)) ? false : true;
    }

    public final void BV3sI0() {
        AZOQYO azoqyo = this.f7042AlLFFp;
        float f = azoqyo.f7033AmA8tU + 0.0f;
        azoqyo.f7035B25kr6 = (int) Math.ceil(0.75f * f);
        this.f7042AlLFFp.f7036B2KMhB = (int) Math.ceil(f * 0.25f);
        BTvldC();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.f7055BNL6CD;
        paint.setColorFilter(this.f7060BniPrB);
        int alpha = paint.getAlpha();
        int i = this.f7042AlLFFp.f7031AcNBzu;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        Paint paint2 = this.f7056BPw6Q8;
        paint2.setColorFilter(this.BpkvW3);
        paint2.setStrokeWidth(this.f7042AlLFFp.f7030AaHO0E);
        int alpha2 = paint2.getAlpha();
        int i2 = this.f7042AlLFFp.f7031AcNBzu;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        Paint.Style style = this.f7042AlLFFp.f7037B3GDIM;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            boolean z = this.f7046B2KMhB;
            Path path = this.f7049B7CMnp;
            if (z) {
                A4TApA(AYUAbz(), path);
                this.f7046B2KMhB = false;
            }
            AZOQYO azoqyo = this.f7042AlLFFp;
            int i3 = azoqyo.f7034AzWtSf;
            if (i3 != 1 && azoqyo.f7035B25kr6 > 0 && (i3 == 2 || (!AzWtSf() && !path.isConvex() && Build.VERSION.SDK_INT < 29))) {
                canvas.save();
                canvas.translate((int) (Math.sin(Math.toRadians(0)) * this.f7042AlLFFp.f7036B2KMhB), AZkASS());
                if (this.f7063CASmeH) {
                    RectF rectF = this.f7062C4FrIb;
                    int width = (int) (rectF.width() - getBounds().width());
                    int height = (int) (rectF.height() - getBounds().height());
                    if (width < 0 || height < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap createBitmap = Bitmap.createBitmap((this.f7042AlLFFp.f7035B25kr6 * 2) + ((int) rectF.width()) + width, (this.f7042AlLFFp.f7035B25kr6 * 2) + ((int) rectF.height()) + height, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    float f = (getBounds().left - this.f7042AlLFFp.f7035B25kr6) - width;
                    float f2 = (getBounds().top - this.f7042AlLFFp.f7035B25kr6) - height;
                    canvas2.translate(-f, -f2);
                    AMqCpz(canvas2);
                    canvas.drawBitmap(createBitmap, f, f2, (Paint) null);
                    createBitmap.recycle();
                    canvas.restore();
                } else {
                    AMqCpz(canvas);
                    canvas.restore();
                }
            }
            ARc23Z(canvas, paint, path, this.f7042AlLFFp.f7021A2egSU, this.f7068CTkVKb, AYUAbz());
        }
        if (AlLFFp()) {
            if (this.f7047B3GDIM) {
                this.f7065COJEAR = this.f7042AlLFFp.f7021A2egSU.AYUAbz(this.f7041AcNBzu);
                float[] fArr = this.f7068CTkVKb;
                if (fArr != null) {
                    if (this.f7069CcAIMM == null) {
                        this.f7069CcAIMM = new float[fArr.length];
                    }
                    float AaHO0E2 = AaHO0E();
                    int i4 = 0;
                    while (true) {
                        float[] fArr2 = this.f7068CTkVKb;
                        if (i4 >= fArr2.length) {
                            break;
                        }
                        this.f7069CcAIMM[i4] = Math.max(0.0f, fArr2[i4] - AaHO0E2);
                        i4++;
                    }
                } else {
                    this.f7069CcAIMM = null;
                }
                B2KMhB b2KMhB = this.f7065COJEAR;
                float[] fArr3 = this.f7069CcAIMM;
                float f3 = this.f7042AlLFFp.f7029AZkASS;
                RectF rectF2 = this.f7052BI9f7h;
                rectF2.set(AYUAbz());
                float AaHO0E3 = AaHO0E();
                rectF2.inset(AaHO0E3, AaHO0E3);
                this.f7059BmvVmW.A2egSU(b2KMhB, fArr3, f3, rectF2, null, this.f7050B9tovu);
                this.f7047B3GDIM = false;
            }
            ASJ6gh(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f7042AlLFFp.f7031AcNBzu;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f7042AlLFFp;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f7042AlLFFp.f7034AzWtSf == 2) {
            return;
        }
        RectF AYUAbz2 = AYUAbz();
        if (AYUAbz2.isEmpty()) {
            return;
        }
        float A5SV6n2 = A5SV6n(AYUAbz2, this.f7042AlLFFp.f7021A2egSU, this.f7068CTkVKb);
        if (A5SV6n2 >= 0.0f) {
            outline.setRoundRect(getBounds(), A5SV6n2 * this.f7042AlLFFp.f7029AZkASS);
            return;
        }
        boolean z = this.f7046B2KMhB;
        Path path = this.f7049B7CMnp;
        if (z) {
            A4TApA(AYUAbz2, path);
            this.f7046B2KMhB = false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            OQbmgg.A5SV6n.A2egSU(outline, path);
            return;
        }
        if (i >= 29) {
            try {
                OQbmgg.A4TApA.A2egSU(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            OQbmgg.A4TApA.A2egSU(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f7042AlLFFp.f7027AYUAbz;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f7053BIYEnU;
        region.set(bounds);
        RectF AYUAbz2 = AYUAbz();
        Path path = this.f7049B7CMnp;
        A4TApA(AYUAbz2, path);
        Region region2 = this.f7054BJ7GGh;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f7046B2KMhB = true;
        this.f7047B3GDIM = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f7042AlLFFp.f7025ARc23Z;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f7042AlLFFp.getClass();
        ColorStateList colorStateList2 = this.f7042AlLFFp.AMqCpz;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f7042AlLFFp.f7024ADYaiT;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        C2rE4F c2rE4F = this.f7042AlLFFp.f7022A4TApA;
        return c2rE4F != null && c2rE4F.ADYaiT();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f7042AlLFFp = new AZOQYO(this.f7042AlLFFp);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f7046B2KMhB = true;
        this.f7047B3GDIM = true;
        super.onBoundsChange(rect);
        if (this.f7042AlLFFp.f7022A4TApA != null && !rect.isEmpty()) {
            BPw6Q8(getState(), this.f7064CNPG0E);
        }
        this.f7064CNPG0E = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable, Oay4Bh.BmvVmW
    public boolean onStateChange(int[] iArr) {
        if (this.f7042AlLFFp.f7022A4TApA != null) {
            BPw6Q8(iArr, false);
        }
        boolean z = BNL6CD(iArr) || BTvldC();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        if (azoqyo.f7031AcNBzu != i) {
            azoqyo.f7031AcNBzu = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7042AlLFFp.getClass();
        super.invalidateSelf();
    }

    @Override // PCV8se.BPw6Q8
    public final void setShapeAppearanceModel(B2KMhB b2KMhB) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        azoqyo.f7021A2egSU = b2KMhB;
        azoqyo.f7022A4TApA = null;
        this.f7068CTkVKb = null;
        this.f7069CcAIMM = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f7042AlLFFp.f7025ARc23Z = colorStateList;
        BTvldC();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        AZOQYO azoqyo = this.f7042AlLFFp;
        if (azoqyo.f7026ASJ6gh != mode) {
            azoqyo.f7026ASJ6gh = mode;
            BTvldC();
            super.invalidateSelf();
        }
    }

    public AaHO0E(B2KMhB b2KMhB) {
        this(new AZOQYO(b2KMhB));
    }

    public AaHO0E(AZOQYO azoqyo) {
        B7CMnp b7CMnp;
        this.f7041AcNBzu = new NGepWW.A2egSU(8, this);
        this.f7043AmA8tU = new BNL6CD[4];
        this.f7044AzWtSf = new BNL6CD[4];
        this.f7045B25kr6 = new BitSet(8);
        this.f7048B4ZgIw = new Matrix();
        this.f7049B7CMnp = new Path();
        this.f7050B9tovu = new Path();
        this.f7051BChYOn = new RectF();
        this.f7052BI9f7h = new RectF();
        this.f7053BIYEnU = new Region();
        this.f7054BJ7GGh = new Region();
        Paint paint = new Paint(1);
        this.f7055BNL6CD = paint;
        Paint paint2 = new Paint(1);
        this.f7056BPw6Q8 = paint2;
        this.f7057BTvldC = new P94amq.A2egSU();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            b7CMnp = B4ZgIw.f7105A2egSU;
        } else {
            b7CMnp = new B7CMnp();
        }
        this.f7059BmvVmW = b7CMnp;
        this.f7062C4FrIb = new RectF();
        this.f7063CASmeH = true;
        this.f7064CNPG0E = true;
        this.f7067CSDoyG = new CtFAbx.ASJ6gh[4];
        this.f7042AlLFFp = azoqyo;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        BTvldC();
        BNL6CD(getState());
        this.f7058BV3sI0 = new IQ76hF.AmA8tU(26, this);
    }

    public AaHO0E(Context context, AttributeSet attributeSet, int i, int i2) {
        this(B2KMhB.A5SV6n(context, attributeSet, i, i2).A2egSU());
    }
}
