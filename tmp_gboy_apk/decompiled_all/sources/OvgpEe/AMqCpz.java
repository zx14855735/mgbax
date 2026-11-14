package OvgpEe;

import ADYaiT.CtFAbx;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz extends ASJ6gh {

    /* renamed from: CNPG0E, reason: collision with root package name */
    public static final O1nrJm.A2egSU f6837CNPG0E = new O1nrJm.A2egSU(2);

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final AcNBzu f6838BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final CtFAbx.AYUAbz f6839BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final CtFAbx.ASJ6gh f6840BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final AYUAbz f6841BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public float f6842BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f6843BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final ValueAnimator f6844BniPrB;
    public ValueAnimator BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public TimeInterpolator f6845C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public TimeInterpolator f6846C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public TimeInterpolator f6847CASmeH;

    static {
        zFkN();
    }

    public AMqCpz(Context context, B25kr6 b25kr6, AcNBzu acNBzu) {
        super(context, b25kr6);
        this.f6843BmvVmW = false;
        this.f6838BJ7GGh = acNBzu;
        AYUAbz aYUAbz = new AYUAbz();
        this.f6841BTvldC = aYUAbz;
        aYUAbz.f6868ASJ6gh = true;
        CtFAbx.AYUAbz aYUAbz2 = new CtFAbx.AYUAbz();
        this.f6839BNL6CD = aYUAbz2;
        aYUAbz2.A2egSU(1.0f);
        aYUAbz2.A4TApA(50.0f);
        CtFAbx.ASJ6gh aSJ6gh = new CtFAbx.ASJ6gh(this, f6837CNPG0E);
        this.f6840BPw6Q8 = aSJ6gh;
        aSJ6gh.f1905AaHO0E = aYUAbz2;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f6844BniPrB = valueAnimator;
        valueAnimator.setDuration(1000L);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new Nm94Z2.A4TApA(this, 1, b25kr6));
        if (b25kr6.A5SV6n(true) && b25kr6.f6919AlLFFp != 0) {
            valueAnimator.start();
        }
        if (this.f6859B7CMnp != 1.0f) {
            this.f6859B7CMnp = 1.0f;
            invalidateSelf();
        }
    }

    private static /* synthetic */ void zFkN() {
        char[] charArray = "\u0085\u0089\u008bÈ\u0081\u0087\u008b\u0083È\u0084\u0089\u009fÈ\u0095\u008e\u0083\u008a\u008aÈ¬\u0088\u008f¤\u0094\u008f\u0082\u0081\u0083".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 230);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0085\u008a\u008f\u0088\u008f\u0092".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 230);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // OvgpEe.ASJ6gh
    public final boolean AMqCpz(boolean z, boolean z2, boolean z3) {
        boolean AMqCpz = super.AMqCpz(z, z2, z3);
        A2egSU a2egSU = this.f6853AmA8tU;
        ContentResolver contentResolver = this.f6851AcNBzu.getContentResolver();
        a2egSU.getClass();
        float A2egSU2 = A2egSU.A2egSU(contentResolver);
        if (A2egSU2 == 0.0f) {
            this.f6843BmvVmW = true;
            return AMqCpz;
        }
        this.f6843BmvVmW = false;
        this.f6839BNL6CD.A4TApA(50.0f / A2egSU2);
        return AMqCpz;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.f6862BI9f7h)) {
            canvas.save();
            AcNBzu acNBzu = this.f6838BJ7GGh;
            Rect bounds = getBounds();
            float A4TApA2 = A4TApA();
            ObjectAnimator objectAnimator = this.f6854AzWtSf;
            boolean z = objectAnimator != null && objectAnimator.isRunning();
            ObjectAnimator objectAnimator2 = this.f6855B25kr6;
            acNBzu.A5SV6n(canvas, bounds, A4TApA2, z, objectAnimator2 != null && objectAnimator2.isRunning());
            float A5SV6n2 = A5SV6n();
            AYUAbz aYUAbz = this.f6841BTvldC;
            aYUAbz.f6867ARc23Z = A5SV6n2;
            Paint paint = this.f6860B9tovu;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            paint.setAntiAlias(true);
            B25kr6 b25kr6 = this.f6852AlLFFp;
            aYUAbz.f6865A5SV6n = b25kr6.AMqCpz[0];
            int i = b25kr6.f6915AZOQYO;
            if (i > 0) {
                if (!CtFAbx.B9tovu(this.f6838BJ7GGh)) {
                    i = (int) ((com.bumptech.glide.AMqCpz.B2KMhB(aYUAbz.f6864A4TApA, 0.0f, 0.01f) * i) / 0.01f);
                }
                this.f6838BJ7GGh.ASJ6gh(canvas, paint, aYUAbz.f6864A4TApA, 1.0f, b25kr6.f6912ARc23Z, this.f6861BChYOn, i);
            } else {
                this.f6838BJ7GGh.ASJ6gh(canvas, paint, 0.0f, 1.0f, b25kr6.f6912ARc23Z, this.f6861BChYOn, 0);
            }
            AcNBzu acNBzu2 = this.f6838BJ7GGh;
            int i2 = this.f6861BChYOn;
            acNBzu2.getClass();
            int ADYaiT2 = OLy1FW.AYUAbz.ADYaiT(aYUAbz.f6865A5SV6n, i2);
            acNBzu2.f6885AlLFFp = aYUAbz.f6868ASJ6gh;
            float f = aYUAbz.f6863A2egSU;
            float f2 = aYUAbz.f6864A4TApA;
            int i3 = aYUAbz.f6866ADYaiT;
            acNBzu2.AMqCpz(canvas, paint, f, f2, ADYaiT2, i3, i3, aYUAbz.AMqCpz, aYUAbz.f6867ARc23Z, true);
            AcNBzu acNBzu3 = this.f6838BJ7GGh;
            int i4 = b25kr6.AMqCpz[0];
            int i5 = this.f6861BChYOn;
            acNBzu3.getClass();
            int ADYaiT3 = OLy1FW.AYUAbz.ADYaiT(i4, i5);
            acNBzu3.f6885AlLFFp = false;
            B25kr6 b25kr62 = acNBzu3.f6872A2egSU;
            if (b25kr62.f6924B3GDIM > 0 && ADYaiT3 != 0) {
                paint.setStyle(style);
                paint.setColor(ADYaiT3);
                Integer num = b25kr62.f6925B4ZgIw;
                AZOQYO azoqyo = new AZOQYO(new float[]{(acNBzu3.f6878ARc23Z / 2.0f) - (num != null ? (b25kr62.f6924B3GDIM / 2.0f) + num.floatValue() : acNBzu3.f6879ASJ6gh / 2.0f), 0.0f}, new float[]{1.0f, 0.0f});
                float f3 = b25kr62.f6924B3GDIM;
                acNBzu3.ARc23Z(canvas, paint, azoqyo, f3, f3, (acNBzu3.f6880AYUAbz * f3) / acNBzu3.f6879ASJ6gh, null, 0.0f, 0.0f, 0.0f, false);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6838BJ7GGh.A2egSU();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        this.f6838BJ7GGh.getClass();
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f6840BPw6Q8.ADYaiT();
        this.f6841BTvldC.f6864A4TApA = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        float f = i;
        float f2 = (f < 1000.0f || f > 9000.0f) ? 0.0f : 1.0f;
        boolean z = this.f6843BmvVmW;
        AYUAbz aYUAbz = this.f6841BTvldC;
        CtFAbx.ASJ6gh aSJ6gh = this.f6840BPw6Q8;
        if (!z) {
            aSJ6gh.f1897A4TApA = aYUAbz.f6864A4TApA * 10000.0f;
            aSJ6gh.f1898A5SV6n = true;
            aSJ6gh.A2egSU(f);
            return true;
        }
        aSJ6gh.ADYaiT();
        aYUAbz.f6864A4TApA = f / 10000.0f;
        invalidateSelf();
        aYUAbz.AMqCpz = f2;
        invalidateSelf();
        return true;
    }
}
