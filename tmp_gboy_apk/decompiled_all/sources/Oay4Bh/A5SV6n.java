package Oay4Bh;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.animation.LinearInterpolator;
import com.google.android.material.textfield.TextInputLayout;
import com.qq.e.comm.adevent.AdEventType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TextInputLayout f6457A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public float f6458A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Rect f6459A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Rect f6460ADYaiT;
    public final RectF AMqCpz;

    /* renamed from: AZkASS, reason: collision with root package name */
    public ColorStateList f6465AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public ColorStateList f6466AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f6467AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f6468AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f6469AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public float f6470AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public float f6471B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public float f6472B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public float f6473B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public Typeface f6474B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Typeface f6475B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public Typeface f6476B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public Typeface f6477BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public Typeface f6478BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public Typeface f6479BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public Typeface f6480BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public P3rngT.A2egSU f6481BNL6CD;

    /* renamed from: BTvldC, reason: collision with root package name */
    public CharSequence f6483BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public CharSequence f6484BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f6485BmvVmW;
    public float BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public float f6487C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public float f6488C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public float f6489CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public float f6490CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public int f6491COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public int f6492CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int[] f6493CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public boolean f6494CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public final TextPaint f6495CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public final TextPaint f6496Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public LinearInterpolator f6497CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public LinearInterpolator f6498CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public float f6499CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public float f6500CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public float f6501CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public ColorStateList f6502CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public float f6503CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public float f6504D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public float f6505D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public StaticLayout f6506D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public float f6507D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public float f6508D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public float f6509D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public CharSequence f6510DAk1zC;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public boolean f6516DaOi9o;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f6461ARc23Z = 16;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f6462ASJ6gh = 16;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f6463AYUAbz = 15.0f;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public float f6464AZOQYO = 15.0f;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final TextUtils.TruncateAt f6482BPw6Q8 = TextUtils.TruncateAt.END;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final boolean f6486BniPrB = true;

    /* renamed from: DG07BK, reason: collision with root package name */
    public int f6511DG07BK = 1;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public int f6512DRlcZ9 = 1;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final float f6513DUi7mC = 1.0f;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public final int f6514DV2E8K = BV3sI0.f6583AmA8tU;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public int f6515DXnQ0V = -1;
    public int DXuj49 = -1;

    public A5SV6n(TextInputLayout textInputLayout) {
        this.f6457A2egSU = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.f6495CcAIMM = textPaint;
        this.f6496Cd8JRx = new TextPaint(textPaint);
        this.f6460ADYaiT = new Rect();
        this.f6459A5SV6n = new Rect();
        this.AMqCpz = new RectF();
        AZOQYO(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int A2egSU(float f, int i, int i2) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), Math.round((Color.red(i2) * f) + (Color.red(i) * f2)), Math.round((Color.green(i2) * f) + (Color.green(i) * f2)), Math.round((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static float AYUAbz(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return NdEzCJ.A2egSU.A2egSU(f, f2, f3);
    }

    public final void A4TApA() {
        float f = this.f6458A4TApA;
        float f2 = this.f6459A5SV6n.left;
        Rect rect = this.f6460ADYaiT;
        float AYUAbz2 = AYUAbz(f2, rect.left, f, this.f6497CikNvS);
        RectF rectF = this.AMqCpz;
        rectF.left = AYUAbz2;
        rectF.top = AYUAbz(this.f6468AlLFFp, this.f6469AmA8tU, f, this.f6497CikNvS);
        rectF.right = AYUAbz(r1.right, rect.right, f, this.f6497CikNvS);
        rectF.bottom = AYUAbz(r1.bottom, rect.bottom, f, this.f6497CikNvS);
        this.f6472B2KMhB = AYUAbz(this.f6470AzWtSf, this.f6471B25kr6, f, this.f6497CikNvS);
        this.f6473B3GDIM = AYUAbz(this.f6468AlLFFp, this.f6469AmA8tU, f, this.f6497CikNvS);
        ADYaiT(f, false);
        TextInputLayout textInputLayout = this.f6457A2egSU;
        textInputLayout.postInvalidateOnAnimation();
        D8cQ8b.A4TApA a4TApA = NdEzCJ.A2egSU.f6037A4TApA;
        this.f6508D8cQ8b = 1.0f - AYUAbz(0.0f, 1.0f, 1.0f - f, a4TApA);
        textInputLayout.postInvalidateOnAnimation();
        this.f6509D9tr6l = AYUAbz(1.0f, 0.0f, f, a4TApA);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f6466AaHO0E;
        ColorStateList colorStateList2 = this.f6465AZkASS;
        TextPaint textPaint = this.f6495CcAIMM;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(A2egSU(f, ASJ6gh(colorStateList2), ASJ6gh(this.f6466AaHO0E)));
        } else {
            textPaint.setColor(ASJ6gh(colorStateList));
        }
        float f3 = this.f6503CtxOCS;
        float f4 = this.f6504D07BeM;
        if (f3 != f4) {
            textPaint.setLetterSpacing(AYUAbz(f4, f3, f, a4TApA));
        } else {
            textPaint.setLetterSpacing(f3);
        }
        this.f6488C4FrIb = NdEzCJ.A2egSU.A2egSU(0.0f, this.f6499CmUvjW, f);
        this.f6489CASmeH = NdEzCJ.A2egSU.A2egSU(0.0f, this.f6500CqNSpT, f);
        this.f6490CNPG0E = NdEzCJ.A2egSU.A2egSU(0.0f, this.f6501CrfGsy, f);
        int A2egSU2 = A2egSU(f, 0, ASJ6gh(this.f6502CtFAbx));
        this.f6491COJEAR = A2egSU2;
        textPaint.setShadowLayer(this.f6488C4FrIb, this.f6489CASmeH, this.f6490CNPG0E, A2egSU2);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final boolean A5SV6n(CharSequence charSequence) {
        boolean z = this.f6457A2egSU.getLayoutDirection() == 1;
        if (this.f6486BniPrB) {
            return (z ? CASmeH.AaHO0E.f1609ADYaiT : CASmeH.AaHO0E.f1608A5SV6n).ADYaiT(charSequence, charSequence.length());
        }
        return z;
    }

    public final void ADYaiT(float f, boolean z) {
        float f2;
        Typeface typeface;
        float f3;
        if (this.f6483BTvldC == null) {
            return;
        }
        float width = this.f6460ADYaiT.width();
        float width2 = this.f6459A5SV6n.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f2 = AzWtSf() ? this.f6464AZOQYO : this.f6463AYUAbz;
            f3 = AzWtSf() ? this.f6503CtxOCS : this.f6504D07BeM;
            this.BpkvW3 = AzWtSf() ? 1.0f : AYUAbz(this.f6463AYUAbz, this.f6464AZOQYO, f, this.f6498CkXcdM) / this.f6463AYUAbz;
            if (!AzWtSf()) {
                width = width2;
            }
            typeface = this.f6474B4ZgIw;
            width2 = width;
        } else {
            f2 = this.f6463AYUAbz;
            float f4 = this.f6504D07BeM;
            typeface = this.f6477BChYOn;
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                this.BpkvW3 = 1.0f;
            } else {
                this.BpkvW3 = AYUAbz(this.f6463AYUAbz, this.f6464AZOQYO, f, this.f6498CkXcdM) / this.f6463AYUAbz;
            }
            float f5 = this.f6464AZOQYO / this.f6463AYUAbz;
            float f6 = width2 * f5;
            if (!z && f6 > width && AzWtSf()) {
                width2 = Math.min(width / f5, width2);
            }
            f3 = f4;
        }
        int i = f < 0.5f ? this.f6511DG07BK : this.f6512DRlcZ9;
        TextPaint textPaint = this.f6495CcAIMM;
        if (width2 > 0.0f) {
            boolean z2 = this.f6487C2rE4F != f2;
            boolean z3 = this.f6505D6DOie != f3;
            boolean z4 = this.f6480BJ7GGh != typeface;
            StaticLayout staticLayout = this.f6506D6yqiO;
            boolean z5 = z2 || z3 || (staticLayout != null && (width2 > ((float) staticLayout.getWidth()) ? 1 : (width2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z4 || (this.f6492CQhlFr != i) || this.f6494CTkVKb;
            this.f6487C2rE4F = f2;
            this.f6505D6DOie = f3;
            this.f6480BJ7GGh = typeface;
            this.f6494CTkVKb = false;
            this.f6492CQhlFr = i;
            textPaint.setLinearText(this.BpkvW3 != 1.0f);
            r6 = z5;
        }
        if (this.f6484BV3sI0 == null || r6) {
            textPaint.setTextSize(this.f6487C2rE4F);
            textPaint.setTypeface(this.f6480BJ7GGh);
            textPaint.setLetterSpacing(this.f6505D6DOie);
            boolean A5SV6n2 = A5SV6n(this.f6483BTvldC);
            this.f6485BmvVmW = A5SV6n2;
            if ((this.f6511DG07BK <= 1 && this.f6512DRlcZ9 <= 1) || A5SV6n2) {
                i = 1;
            }
            StaticLayout AMqCpz = AMqCpz(i, textPaint, this.f6483BTvldC, (AzWtSf() ? 1.0f : this.BpkvW3) * width2, this.f6485BmvVmW);
            this.f6506D6yqiO = AMqCpz;
            this.f6484BV3sI0 = AMqCpz.getText();
        }
    }

    public final StaticLayout AMqCpz(int i, TextPaint textPaint, CharSequence charSequence, float f, boolean z) {
        Layout.Alignment alignment;
        StaticLayout staticLayout = null;
        try {
            if (i == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = Gravity.getAbsoluteGravity(this.f6461ARc23Z, this.f6485BmvVmW ? 1 : 0) & 7;
                alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.f6485BmvVmW ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f6485BmvVmW ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
            }
            BV3sI0 bV3sI0 = new BV3sI0(charSequence, textPaint, (int) f);
            bV3sI0.f6597AcNBzu = this.f6482BPw6Q8;
            bV3sI0.f6596AaHO0E = z;
            bV3sI0.AMqCpz = alignment;
            bV3sI0.f6595AZkASS = false;
            bV3sI0.f6591ARc23Z = i;
            float f2 = this.f6513DUi7mC;
            bV3sI0.f6592ASJ6gh = 0.0f;
            bV3sI0.f6593AYUAbz = f2;
            bV3sI0.f6594AZOQYO = this.f6514DV2E8K;
            bV3sI0.f6598AlLFFp = null;
            staticLayout = bV3sI0.A2egSU();
        } catch (BTvldC e) {
            e.getCause().getMessage();
        }
        staticLayout.getClass();
        return staticLayout;
    }

    public final float ARc23Z() {
        int i = this.f6515DXnQ0V;
        if (i != -1) {
            return i;
        }
        TextPaint textPaint = this.f6496Cd8JRx;
        textPaint.setTextSize(this.f6464AZOQYO);
        textPaint.setTypeface(this.f6474B4ZgIw);
        textPaint.setLetterSpacing(this.f6503CtxOCS);
        return -textPaint.ascent();
    }

    public final int ASJ6gh(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f6493CSDoyG;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void AZOQYO(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f6476B9tovu;
            if (typeface != null) {
                this.f6475B7CMnp = JrXYwF.A4TApA.CkXcdM(configuration, typeface);
            }
            Typeface typeface2 = this.f6479BIYEnU;
            if (typeface2 != null) {
                this.f6478BI9f7h = JrXYwF.A4TApA.CkXcdM(configuration, typeface2);
            }
            Typeface typeface3 = this.f6475B7CMnp;
            if (typeface3 == null) {
                typeface3 = this.f6476B9tovu;
            }
            this.f6474B4ZgIw = typeface3;
            Typeface typeface4 = this.f6478BI9f7h;
            if (typeface4 == null) {
                typeface4 = this.f6479BIYEnU;
            }
            this.f6477BChYOn = typeface4;
            AZkASS(true);
        }
    }

    public final void AZkASS(boolean z) {
        float measureText;
        TextInputLayout textInputLayout = this.f6457A2egSU;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z) {
            return;
        }
        ADYaiT(1.0f, z);
        CharSequence charSequence = this.f6484BV3sI0;
        TextPaint textPaint = this.f6495CcAIMM;
        if (charSequence != null && this.f6506D6yqiO != null) {
            this.f6510DAk1zC = AzWtSf() ? TextUtils.ellipsize(this.f6484BV3sI0, textPaint, this.f6506D6yqiO.getWidth(), this.f6482BPw6Q8) : this.f6484BV3sI0;
        }
        CharSequence charSequence2 = this.f6510DAk1zC;
        if (charSequence2 != null) {
            this.f6507D8MqeW = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f6507D8MqeW = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f6462ASJ6gh, this.f6485BmvVmW ? 1 : 0);
        int i = absoluteGravity & AdEventType.AD_TICK;
        Rect rect = this.f6460ADYaiT;
        if (i == 48) {
            this.f6469AmA8tU = rect.top;
        } else if (i != 80) {
            this.f6469AmA8tU = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f6469AmA8tU = textPaint.ascent() + rect.bottom;
        }
        int i2 = absoluteGravity & 8388615;
        if (i2 == 1) {
            this.f6471B25kr6 = rect.centerX() - (this.f6507D8MqeW / 2.0f);
        } else if (i2 != 5) {
            this.f6471B25kr6 = rect.left;
        } else {
            this.f6471B25kr6 = rect.right - this.f6507D8MqeW;
        }
        if (this.f6507D8MqeW <= rect.width()) {
            float f = this.f6471B25kr6;
            float max = Math.max(0.0f, rect.left - f) + f;
            this.f6471B25kr6 = max;
            this.f6471B25kr6 = Math.min(0.0f, rect.right - (this.f6507D8MqeW + max)) + max;
        }
        TextPaint textPaint2 = this.f6496Cd8JRx;
        textPaint2.setTextSize(this.f6464AZOQYO);
        textPaint2.setTypeface(this.f6474B4ZgIw);
        textPaint2.setLetterSpacing(this.f6503CtxOCS);
        if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
            float f2 = this.f6469AmA8tU;
            float max2 = Math.max(0.0f, rect.top - f2) + f2;
            this.f6469AmA8tU = max2;
            this.f6469AmA8tU = Math.min(0.0f, rect.bottom - (ARc23Z() + max2)) + max2;
        }
        ADYaiT(0.0f, z);
        float height = this.f6506D6yqiO != null ? r15.getHeight() : 0.0f;
        StaticLayout staticLayout = this.f6506D6yqiO;
        if (staticLayout == null || this.f6511DG07BK <= 1) {
            CharSequence charSequence3 = this.f6484BV3sI0;
            measureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            measureText = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.f6506D6yqiO;
        this.f6467AcNBzu = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f6461ARc23Z, this.f6485BmvVmW ? 1 : 0);
        int i3 = absoluteGravity2 & AdEventType.AD_TICK;
        Rect rect2 = this.f6459A5SV6n;
        if (i3 == 48) {
            this.f6468AlLFFp = rect2.top;
        } else if (i3 != 80) {
            this.f6468AlLFFp = rect2.centerY() - (height / 2.0f);
        } else {
            this.f6468AlLFFp = (rect2.bottom - height) + (this.f6516DaOi9o ? textPaint.descent() : 0.0f);
        }
        int i4 = absoluteGravity2 & 8388615;
        if (i4 == 1) {
            this.f6470AzWtSf = rect2.centerX() - (measureText / 2.0f);
        } else if (i4 != 5) {
            this.f6470AzWtSf = rect2.left;
        } else {
            this.f6470AzWtSf = rect2.right - measureText;
        }
        ADYaiT(this.f6458A4TApA, false);
        textInputLayout.postInvalidateOnAnimation();
        A4TApA();
    }

    public final void AaHO0E(ColorStateList colorStateList) {
        if (this.f6466AaHO0E == colorStateList && this.f6465AZkASS == colorStateList) {
            return;
        }
        this.f6466AaHO0E = colorStateList;
        this.f6465AZkASS = colorStateList;
        AZkASS(false);
    }

    public final boolean AcNBzu(Typeface typeface) {
        P3rngT.A2egSU a2egSU = this.f6481BNL6CD;
        if (a2egSU != null) {
            a2egSU.f6935A5SV6n = true;
        }
        if (this.f6476B9tovu == typeface) {
            return false;
        }
        this.f6476B9tovu = typeface;
        Typeface CkXcdM2 = JrXYwF.A4TApA.CkXcdM(this.f6457A2egSU.getContext().getResources().getConfiguration(), typeface);
        this.f6475B7CMnp = CkXcdM2;
        if (CkXcdM2 == null) {
            CkXcdM2 = this.f6476B9tovu;
        }
        this.f6474B4ZgIw = CkXcdM2;
        return true;
    }

    public final void AlLFFp(float f) {
        float B2KMhB2 = com.bumptech.glide.AMqCpz.B2KMhB(f, 0.0f, 1.0f);
        if (B2KMhB2 != this.f6458A4TApA) {
            this.f6458A4TApA = B2KMhB2;
            A4TApA();
        }
    }

    public final void AmA8tU(Typeface typeface) {
        boolean z;
        boolean AcNBzu2 = AcNBzu(typeface);
        if (this.f6479BIYEnU != typeface) {
            this.f6479BIYEnU = typeface;
            Typeface CkXcdM2 = JrXYwF.A4TApA.CkXcdM(this.f6457A2egSU.getContext().getResources().getConfiguration(), typeface);
            this.f6478BI9f7h = CkXcdM2;
            if (CkXcdM2 == null) {
                CkXcdM2 = this.f6479BIYEnU;
            }
            this.f6477BChYOn = CkXcdM2;
            z = true;
        } else {
            z = false;
        }
        if (AcNBzu2 || z) {
            AZkASS(false);
        }
    }

    public final boolean AzWtSf() {
        return this.f6512DRlcZ9 == 1;
    }
}
