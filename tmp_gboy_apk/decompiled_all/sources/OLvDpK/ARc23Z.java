package OLvDpK;

import Oay4Bh.BmvVmW;
import Oay4Bh.BniPrB;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.chip.Chip;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends AaHO0E implements Drawable.Callback, BmvVmW {

    /* renamed from: G58fqA, reason: collision with root package name */
    public static final int[] f6277G58fqA = {R.attr.state_enabled};

    /* renamed from: GEYgCP, reason: collision with root package name */
    public static final ShapeDrawable f6278GEYgCP = new ShapeDrawable(new OvalShape());

    /* renamed from: CmUvjW, reason: collision with root package name */
    public ColorStateList f6279CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public ColorStateList f6280CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public float f6281CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public float f6282CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public ColorStateList f6283CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public float f6284D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public ColorStateList f6285D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public CharSequence f6286D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public boolean f6287D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public Drawable f6288D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public ColorStateList f6289D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public float f6290DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public boolean f6291DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public boolean f6292DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public Drawable f6293DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public RippleDrawable f6294DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public ColorStateList f6295DXnQ0V;
    public float DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public SpannableStringBuilder f6296DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public boolean f6297DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public boolean f6298DdagTj;
    public Drawable Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public ColorStateList f6299De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public NdEzCJ.A5SV6n f6300DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public NdEzCJ.A5SV6n f6301Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public float f6302DuwtYk;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public float f6303DvK7DB;

    /* renamed from: DyaChj, reason: collision with root package name */
    public float f6304DyaChj;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public float f6305ECyGFg;

    /* renamed from: EGM26s, reason: collision with root package name */
    public float f6306EGM26s;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public float f6307EH1KK8;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public float f6308EPdU4G;

    /* renamed from: EQurEW, reason: collision with root package name */
    public float f6309EQurEW;

    /* renamed from: EUIRHA, reason: collision with root package name */
    public final Context f6310EUIRHA;

    /* renamed from: EY4UKY, reason: collision with root package name */
    public final Paint f6311EY4UKY;
    public final Paint.FontMetrics EdQ5bb;

    /* renamed from: EdhSi6, reason: collision with root package name */
    public final RectF f6312EdhSi6;

    /* renamed from: EiK8oA, reason: collision with root package name */
    public final PointF f6313EiK8oA;

    /* renamed from: EicXu4, reason: collision with root package name */
    public final Path f6314EicXu4;

    /* renamed from: EmJGcg, reason: collision with root package name */
    public final BniPrB f6315EmJGcg;

    /* renamed from: ErKPGd, reason: collision with root package name */
    public int f6316ErKPGd;

    /* renamed from: EsrwYR, reason: collision with root package name */
    public int f6317EsrwYR;

    /* renamed from: EwN40Z, reason: collision with root package name */
    public int f6318EwN40Z;

    /* renamed from: ExjC7D, reason: collision with root package name */
    public int f6319ExjC7D;

    /* renamed from: F1loUV, reason: collision with root package name */
    public int f6320F1loUV;

    /* renamed from: F32kj0, reason: collision with root package name */
    public int f6321F32kj0;

    /* renamed from: F508T2, reason: collision with root package name */
    public boolean f6322F508T2;

    /* renamed from: FG7pZc, reason: collision with root package name */
    public int f6323FG7pZc;

    /* renamed from: FM663C, reason: collision with root package name */
    public int f6324FM663C;

    /* renamed from: FOAO9d, reason: collision with root package name */
    public ColorFilter f6325FOAO9d;

    /* renamed from: FSFw2u, reason: collision with root package name */
    public PorterDuffColorFilter f6326FSFw2u;

    /* renamed from: FZu94u, reason: collision with root package name */
    public ColorStateList f6327FZu94u;

    /* renamed from: FdMWEC, reason: collision with root package name */
    public PorterDuff.Mode f6328FdMWEC;

    /* renamed from: Ff5QvW, reason: collision with root package name */
    public int[] f6329Ff5QvW;

    /* renamed from: Fmmv0E, reason: collision with root package name */
    public ColorStateList f6330Fmmv0E;

    /* renamed from: FmyuN2, reason: collision with root package name */
    public WeakReference f6331FmyuN2;

    /* renamed from: FpcJKS, reason: collision with root package name */
    public TextUtils.TruncateAt f6332FpcJKS;

    /* renamed from: Fyurov, reason: collision with root package name */
    public boolean f6333Fyurov;
    public int G16Pvp;
    public boolean G2rdQT;

    static {
        nUYJl();
    }

    public ARc23Z(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130968805, 2131952844);
        this.f6282CtFAbx = -1.0f;
        this.f6311EY4UKY = new Paint(1);
        this.EdQ5bb = new Paint.FontMetrics();
        this.f6312EdhSi6 = new RectF();
        this.f6313EiK8oA = new PointF();
        this.f6314EicXu4 = new Path();
        this.f6324FM663C = 255;
        this.f6328FdMWEC = PorterDuff.Mode.SRC_IN;
        this.f6331FmyuN2 = new WeakReference(null);
        AmA8tU(context);
        this.f6310EUIRHA = context;
        BniPrB bniPrB = new BniPrB(this);
        this.f6315EmJGcg = bniPrB;
        this.f6286D6yqiO = "";
        bniPrB.f6599A2egSU.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f6277G58fqA;
        setState(iArr);
        D8cQ8b(iArr);
        this.f6333Fyurov = true;
        f6278GEYgCP.setTint(-1);
    }

    public static boolean CASmeH(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean CNPG0E(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void DaOi9o(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private static /* synthetic */ void nUYJl() {
        char[] charArray = "âîì¯æàìä¯ãîø¯òéäíí¯ËïèÃóèåæä".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 129);
        }
        String str = new String(charArray);
        char[] charArray2 = "âíèïèõ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 129);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // PCV8se.AaHO0E, Oay4Bh.BmvVmW
    public final void A2egSU() {
        COJEAR();
        invalidateSelf();
    }

    public final void BmvVmW(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        com.bumptech.glide.A5SV6n.D8cQ8b(drawable, com.bumptech.glide.A5SV6n.BPw6Q8(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f6293DUi7mC) {
            if (drawable.isStateful()) {
                drawable.setState(this.f6329Ff5QvW);
            }
            drawable.setTintList(this.f6295DXnQ0V);
            return;
        }
        Drawable drawable2 = this.f6288D8cQ8b;
        if (drawable == drawable2 && this.f6291DG07BK) {
            drawable2.setTintList(this.f6289D9tr6l);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void BniPrB(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (DXnQ0V() || DV2E8K()) {
            float f = this.f6302DuwtYk + this.f6303DvK7DB;
            Drawable drawable = this.f6322F508T2 ? this.Ddcejp : this.f6288D8cQ8b;
            float f2 = this.f6290DAk1zC;
            if (f2 <= 0.0f && drawable != null) {
                f2 = drawable.getIntrinsicWidth();
            }
            if (com.bumptech.glide.A5SV6n.BPw6Q8(this) == 0) {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + f2;
            } else {
                float f4 = rect.right - f;
                rectF.right = f4;
                rectF.left = f4 - f2;
            }
            Drawable drawable2 = this.f6322F508T2 ? this.Ddcejp : this.f6288D8cQ8b;
            float f5 = this.f6290DAk1zC;
            if (f5 <= 0.0f && drawable2 != null) {
                f5 = (float) Math.ceil(C4FrIb.AYUAbz(this.f6310EUIRHA, 24));
                if (drawable2.getIntrinsicHeight() <= f5) {
                    f5 = drawable2.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f5 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f5;
        }
    }

    public final float BpkvW3() {
        if (!DXnQ0V() && !DV2E8K()) {
            return 0.0f;
        }
        float f = this.f6303DvK7DB;
        Drawable drawable = this.f6322F508T2 ? this.Ddcejp : this.f6288D8cQ8b;
        float f2 = this.f6290DAk1zC;
        if (f2 <= 0.0f && drawable != null) {
            f2 = drawable.getIntrinsicWidth();
        }
        return f2 + f + this.f6304DyaChj;
    }

    public final float C2rE4F() {
        if (DXuj49()) {
            return this.f6307EH1KK8 + this.DXuj49 + this.f6308EPdU4G;
        }
        return 0.0f;
    }

    public final float C4FrIb() {
        return this.G2rdQT ? AcNBzu() : this.f6282CtFAbx;
    }

    public final void COJEAR() {
        AMqCpz aMqCpz = (AMqCpz) this.f6331FmyuN2.get();
        if (aMqCpz != null) {
            Chip chip = (Chip) aMqCpz;
            chip.A5SV6n(chip.f11561BTvldC);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean CQhlFr(int[] r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OLvDpK.ARc23Z.CQhlFr(int[], int[]):boolean");
    }

    public final void CSDoyG(boolean z) {
        if (this.f6297DcUJf1 != z) {
            this.f6297DcUJf1 = z;
            float BpkvW3 = BpkvW3();
            if (!z && this.f6322F508T2) {
                this.f6322F508T2 = false;
            }
            float BpkvW32 = BpkvW3();
            invalidateSelf();
            if (BpkvW3 != BpkvW32) {
                COJEAR();
            }
        }
    }

    public final void CTkVKb(Drawable drawable) {
        if (this.Ddcejp != drawable) {
            float BpkvW3 = BpkvW3();
            this.Ddcejp = drawable;
            float BpkvW32 = BpkvW3();
            DaOi9o(this.Ddcejp);
            BmvVmW(this.Ddcejp);
            invalidateSelf();
            if (BpkvW3 != BpkvW32) {
                COJEAR();
            }
        }
    }

    public final void CcAIMM(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f6299De4eam != colorStateList) {
            this.f6299De4eam = colorStateList;
            if (this.f6298DdagTj && (drawable = this.Ddcejp) != null && this.f6297DcUJf1) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Cd8JRx(boolean z) {
        if (this.f6298DdagTj != z) {
            boolean DV2E8K2 = DV2E8K();
            this.f6298DdagTj = z;
            boolean DV2E8K3 = DV2E8K();
            if (DV2E8K2 != DV2E8K3) {
                if (DV2E8K3) {
                    BmvVmW(this.Ddcejp);
                } else {
                    DaOi9o(this.Ddcejp);
                }
                invalidateSelf();
                COJEAR();
            }
        }
    }

    public final void CikNvS(float f) {
        if (this.f6282CtFAbx != f) {
            this.f6282CtFAbx = f;
            B2KMhB.A2egSU ASJ6gh2 = this.f7042AlLFFp.f7021A2egSU.ASJ6gh();
            ASJ6gh2.A5SV6n(f);
            setShapeAppearanceModel(ASJ6gh2.A2egSU());
        }
    }

    public final void CkXcdM(Drawable drawable) {
        Drawable drawable2 = this.f6288D8cQ8b;
        Drawable DdagTj2 = drawable2 != null ? com.bumptech.glide.A5SV6n.DdagTj(drawable2) : null;
        if (DdagTj2 != drawable) {
            float BpkvW3 = BpkvW3();
            this.f6288D8cQ8b = drawable != null ? com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate() : null;
            float BpkvW32 = BpkvW3();
            DaOi9o(DdagTj2);
            if (DXnQ0V()) {
                BmvVmW(this.f6288D8cQ8b);
            }
            invalidateSelf();
            if (BpkvW3 != BpkvW32) {
                COJEAR();
            }
        }
    }

    public final void CmUvjW(float f) {
        if (this.f6290DAk1zC != f) {
            float BpkvW3 = BpkvW3();
            this.f6290DAk1zC = f;
            float BpkvW32 = BpkvW3();
            invalidateSelf();
            if (BpkvW3 != BpkvW32) {
                COJEAR();
            }
        }
    }

    public final void CqNSpT(ColorStateList colorStateList) {
        this.f6291DG07BK = true;
        if (this.f6289D9tr6l != colorStateList) {
            this.f6289D9tr6l = colorStateList;
            if (DXnQ0V()) {
                this.f6288D8cQ8b.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void CrfGsy(boolean z) {
        if (this.f6287D8MqeW != z) {
            boolean DXnQ0V2 = DXnQ0V();
            this.f6287D8MqeW = z;
            boolean DXnQ0V3 = DXnQ0V();
            if (DXnQ0V2 != DXnQ0V3) {
                if (DXnQ0V3) {
                    BmvVmW(this.f6288D8cQ8b);
                } else {
                    DaOi9o(this.f6288D8cQ8b);
                }
                invalidateSelf();
                COJEAR();
            }
        }
    }

    public final void CtFAbx(ColorStateList colorStateList) {
        if (this.f6283CtxOCS != colorStateList) {
            this.f6283CtxOCS = colorStateList;
            if (this.G2rdQT) {
                BIYEnU(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void CtxOCS(float f) {
        if (this.f6284D07BeM != f) {
            this.f6284D07BeM = f;
            this.f6311EY4UKY.setStrokeWidth(f);
            if (this.G2rdQT) {
                BJ7GGh(f);
            }
            invalidateSelf();
        }
    }

    public final void D07BeM(Drawable drawable) {
        Drawable drawable2 = this.f6293DUi7mC;
        Drawable DdagTj2 = drawable2 != null ? com.bumptech.glide.A5SV6n.DdagTj(drawable2) : null;
        if (DdagTj2 != drawable) {
            float C2rE4F2 = C2rE4F();
            this.f6293DUi7mC = drawable != null ? com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate() : null;
            this.f6294DV2E8K = new RippleDrawable(P5yM7D.A4TApA.A5SV6n(this.f6285D6DOie), this.f6293DUi7mC, f6278GEYgCP);
            float C2rE4F3 = C2rE4F();
            DaOi9o(DdagTj2);
            if (DXuj49()) {
                BmvVmW(this.f6293DUi7mC);
            }
            invalidateSelf();
            if (C2rE4F2 != C2rE4F3) {
                COJEAR();
            }
        }
    }

    public final void D6DOie(float f) {
        if (this.f6308EPdU4G != f) {
            this.f6308EPdU4G = f;
            invalidateSelf();
            if (DXuj49()) {
                COJEAR();
            }
        }
    }

    public final void D6yqiO(float f) {
        if (this.DXuj49 != f) {
            this.DXuj49 = f;
            invalidateSelf();
            if (DXuj49()) {
                COJEAR();
            }
        }
    }

    public final void D8MqeW(float f) {
        if (this.f6307EH1KK8 != f) {
            this.f6307EH1KK8 = f;
            invalidateSelf();
            if (DXuj49()) {
                COJEAR();
            }
        }
    }

    public final boolean D8cQ8b(int[] iArr) {
        if (Arrays.equals(this.f6329Ff5QvW, iArr)) {
            return false;
        }
        this.f6329Ff5QvW = iArr;
        if (DXuj49()) {
            return CQhlFr(getState(), iArr);
        }
        return false;
    }

    public final void D9tr6l(ColorStateList colorStateList) {
        if (this.f6295DXnQ0V != colorStateList) {
            this.f6295DXnQ0V = colorStateList;
            if (DXuj49()) {
                this.f6293DUi7mC.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void DAk1zC(boolean z) {
        if (this.f6292DRlcZ9 != z) {
            boolean DXuj49 = DXuj49();
            this.f6292DRlcZ9 = z;
            boolean DXuj492 = DXuj49();
            if (DXuj49 != DXuj492) {
                if (DXuj492) {
                    BmvVmW(this.f6293DUi7mC);
                } else {
                    DaOi9o(this.f6293DUi7mC);
                }
                invalidateSelf();
                COJEAR();
            }
        }
    }

    public final void DG07BK(float f) {
        if (this.f6304DyaChj != f) {
            float BpkvW3 = BpkvW3();
            this.f6304DyaChj = f;
            float BpkvW32 = BpkvW3();
            invalidateSelf();
            if (BpkvW3 != BpkvW32) {
                COJEAR();
            }
        }
    }

    public final void DRlcZ9(float f) {
        if (this.f6303DvK7DB != f) {
            float BpkvW3 = BpkvW3();
            this.f6303DvK7DB = f;
            float BpkvW32 = BpkvW3();
            invalidateSelf();
            if (BpkvW3 != BpkvW32) {
                COJEAR();
            }
        }
    }

    public final void DUi7mC(ColorStateList colorStateList) {
        if (this.f6285D6DOie != colorStateList) {
            this.f6285D6DOie = colorStateList;
            this.f6330Fmmv0E = null;
            onStateChange(getState());
        }
    }

    public final boolean DV2E8K() {
        return this.f6298DdagTj && this.Ddcejp != null && this.f6322F508T2;
    }

    public final boolean DXnQ0V() {
        return this.f6287D8MqeW && this.f6288D8cQ8b != null;
    }

    public final boolean DXuj49() {
        return this.f6292DRlcZ9 && this.f6293DUi7mC != null;
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int i2;
        int i3;
        int saveLayerAlpha;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.f6324FM663C) == 0) {
            return;
        }
        if (i < 255) {
            float f = bounds.left;
            float f2 = bounds.top;
            float f3 = bounds.right;
            float f4 = bounds.bottom;
            if (Build.VERSION.SDK_INT > 21) {
                canvas2 = canvas;
                saveLayerAlpha = canvas2.saveLayerAlpha(f, f2, f3, f4, i);
            } else {
                canvas2 = canvas;
                saveLayerAlpha = canvas2.saveLayerAlpha(f, f2, f3, f4, i, 31);
            }
            i2 = saveLayerAlpha;
        } else {
            canvas2 = canvas;
            i2 = 0;
        }
        boolean z = this.G2rdQT;
        Paint paint = this.f6311EY4UKY;
        RectF rectF = this.f6312EdhSi6;
        if (!z) {
            paint.setColor(this.f6316ErKPGd);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, C4FrIb(), C4FrIb(), paint);
        }
        if (!this.G2rdQT) {
            paint.setColor(this.f6317EsrwYR);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.f6325FOAO9d;
            if (colorFilter == null) {
                colorFilter = this.f6326FSFw2u;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, C4FrIb(), C4FrIb(), paint);
        }
        if (this.G2rdQT) {
            super.draw(canvas);
        }
        if (this.f6284D07BeM > 0.0f && !this.G2rdQT) {
            paint.setColor(this.f6319ExjC7D);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.G2rdQT) {
                ColorFilter colorFilter2 = this.f6325FOAO9d;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f6326FSFw2u;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f5 = bounds.left;
            float f6 = this.f6284D07BeM / 2.0f;
            rectF.set(f5 + f6, bounds.top + f6, bounds.right - f6, bounds.bottom - f6);
            float f7 = this.f6282CtFAbx - (this.f6284D07BeM / 2.0f);
            canvas2.drawRoundRect(rectF, f7, f7, paint);
        }
        paint.setColor(this.f6320F1loUV);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.G2rdQT) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.f6314EicXu4;
            PCV8se.AZOQYO azoqyo = this.f7042AlLFFp;
            this.f7059BmvVmW.A2egSU(azoqyo.f7021A2egSU, this.f7068CTkVKb, azoqyo.f7029AZkASS, rectF2, this.f7058BV3sI0, path);
            ARc23Z(canvas2, paint, path, this.f7042AlLFFp.f7021A2egSU, this.f7068CTkVKb, AYUAbz());
        } else {
            canvas2.drawRoundRect(rectF, C4FrIb(), C4FrIb(), paint);
        }
        if (DXnQ0V()) {
            BniPrB(bounds, rectF);
            float f8 = rectF.left;
            float f9 = rectF.top;
            canvas2.translate(f8, f9);
            this.f6288D8cQ8b.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f6288D8cQ8b.draw(canvas2);
            canvas2.translate(-f8, -f9);
        }
        if (DV2E8K()) {
            BniPrB(bounds, rectF);
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas2.translate(f10, f11);
            this.Ddcejp.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.Ddcejp.draw(canvas2);
            canvas2.translate(-f10, -f11);
        }
        if (this.f6333Fyurov && this.f6286D6yqiO != null) {
            PointF pointF = this.f6313EiK8oA;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f6286D6yqiO;
            BniPrB bniPrB = this.f6315EmJGcg;
            if (charSequence != null) {
                float BpkvW3 = BpkvW3() + this.f6302DuwtYk + this.f6305ECyGFg;
                if (com.bumptech.glide.A5SV6n.BPw6Q8(this) == 0) {
                    pointF.x = bounds.left + BpkvW3;
                } else {
                    pointF.x = bounds.right - BpkvW3;
                    align = Paint.Align.RIGHT;
                }
                float centerY = bounds.centerY();
                TextPaint textPaint = bniPrB.f6599A2egSU;
                Paint.FontMetrics fontMetrics = this.EdQ5bb;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.f6286D6yqiO != null) {
                float BpkvW32 = BpkvW3() + this.f6302DuwtYk + this.f6305ECyGFg;
                float C2rE4F2 = C2rE4F() + this.f6309EQurEW + this.f6306EGM26s;
                if (com.bumptech.glide.A5SV6n.BPw6Q8(this) == 0) {
                    rectF.left = bounds.left + BpkvW32;
                    rectF.right = bounds.right - C2rE4F2;
                } else {
                    rectF.left = bounds.left + C2rE4F2;
                    rectF.right = bounds.right - BpkvW32;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            P3rngT.AMqCpz aMqCpz = bniPrB.f6604ASJ6gh;
            TextPaint textPaint2 = bniPrB.f6599A2egSU;
            if (aMqCpz != null) {
                textPaint2.drawableState = getState();
                bniPrB.f6604ASJ6gh.ADYaiT(this.f6310EUIRHA, textPaint2, bniPrB.f6600A4TApA);
            }
            textPaint2.setTextAlign(align);
            boolean z2 = Math.round(bniPrB.A2egSU(this.f6286D6yqiO.toString())) > Math.round(rectF.width());
            if (z2) {
                int save = canvas2.save();
                canvas2.clipRect(rectF);
                i3 = save;
            } else {
                i3 = 0;
            }
            CharSequence charSequence2 = this.f6286D6yqiO;
            if (z2 && this.f6332FpcJKS != null) {
                charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF.width(), this.f6332FpcJKS);
            }
            canvas.drawText(charSequence2, 0, charSequence2.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z2) {
                canvas2.restoreToCount(i3);
            }
        }
        if (DXuj49()) {
            rectF.setEmpty();
            if (DXuj49()) {
                float f12 = this.f6309EQurEW + this.f6308EPdU4G;
                if (com.bumptech.glide.A5SV6n.BPw6Q8(this) == 0) {
                    float f13 = bounds.right - f12;
                    rectF.right = f13;
                    rectF.left = f13 - this.DXuj49;
                } else {
                    float f14 = bounds.left + f12;
                    rectF.left = f14;
                    rectF.right = f14 + this.DXuj49;
                }
                float exactCenterY = bounds.exactCenterY();
                float f15 = this.DXuj49;
                float f16 = exactCenterY - (f15 / 2.0f);
                rectF.top = f16;
                rectF.bottom = f16 + f15;
            }
            float f17 = rectF.left;
            float f18 = rectF.top;
            canvas2.translate(f17, f18);
            this.f6293DUi7mC.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f6294DV2E8K.setBounds(this.f6293DUi7mC.getBounds());
            this.f6294DV2E8K.jumpToCurrentState();
            this.f6294DV2E8K.draw(canvas2);
            canvas2.translate(-f17, -f18);
        }
        if (this.f6324FM663C < 255) {
            canvas2.restoreToCount(i2);
        }
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6324FM663C;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f6325FOAO9d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f6281CrfGsy;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(C2rE4F() + this.f6315EmJGcg.A2egSU(this.f6286D6yqiO.toString()) + BpkvW3() + this.f6302DuwtYk + this.f6305ECyGFg + this.f6306EGM26s + this.f6309EQurEW), this.G16Pvp);
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.G2rdQT) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f6281CrfGsy, this.f6282CtFAbx);
        } else {
            outline.setRoundRect(bounds, this.f6282CtFAbx);
            outline2 = outline;
        }
        outline2.setAlpha(this.f6324FM663C / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (CASmeH(this.f6279CmUvjW) || CASmeH(this.f6280CqNSpT) || CASmeH(this.f6283CtxOCS)) {
            return true;
        }
        P3rngT.AMqCpz aMqCpz = this.f6315EmJGcg.f6604ASJ6gh;
        if (aMqCpz == null || (colorStateList = aMqCpz.f6951AaHO0E) == null || !colorStateList.isStateful()) {
            return (this.f6298DdagTj && this.Ddcejp != null && this.f6297DcUJf1) || CNPG0E(this.f6288D8cQ8b) || CNPG0E(this.Ddcejp) || CASmeH(this.f6327FZu94u);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (DXnQ0V()) {
            onLayoutDirectionChanged |= com.bumptech.glide.A5SV6n.D8cQ8b(this.f6288D8cQ8b, i);
        }
        if (DV2E8K()) {
            onLayoutDirectionChanged |= com.bumptech.glide.A5SV6n.D8cQ8b(this.Ddcejp, i);
        }
        if (DXuj49()) {
            onLayoutDirectionChanged |= com.bumptech.glide.A5SV6n.D8cQ8b(this.f6293DUi7mC, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (DXnQ0V()) {
            onLevelChange |= this.f6288D8cQ8b.setLevel(i);
        }
        if (DV2E8K()) {
            onLevelChange |= this.Ddcejp.setLevel(i);
        }
        if (DXuj49()) {
            onLevelChange |= this.f6293DUi7mC.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable, Oay4Bh.BmvVmW
    public final boolean onStateChange(int[] iArr) {
        if (this.G2rdQT) {
            super.onStateChange(iArr);
        }
        return CQhlFr(iArr, this.f6329Ff5QvW);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f6324FM663C != i) {
            this.f6324FM663C = i;
            invalidateSelf();
        }
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f6325FOAO9d != colorFilter) {
            this.f6325FOAO9d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f6327FZu94u != colorStateList) {
            this.f6327FZu94u = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.f6328FdMWEC != mode) {
            this.f6328FdMWEC = mode;
            ColorStateList colorStateList = this.f6327FZu94u;
            this.f6326FSFw2u = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (DXnQ0V()) {
            visible |= this.f6288D8cQ8b.setVisible(z, z2);
        }
        if (DV2E8K()) {
            visible |= this.Ddcejp.setVisible(z, z2);
        }
        if (DXuj49()) {
            visible |= this.f6293DUi7mC.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
