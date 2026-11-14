package PSeUZ5;

import ADYaiT.CtFAbx;
import BPw6Q8.ASJ6gh;
import COJEAR.DG07BK;
import COJEAR.Ddcejp;
import Dphsd2.AZkASS;
import OLy1FW.AYUAbz;
import Oay4Bh.BniPrB;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.game.boy.view.SliderPreference;
import com.google.android.material.R$styleable;
import com.google.android.material.slider.Slider;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ADYaiT extends View {

    /* renamed from: GGG1xW, reason: collision with root package name */
    public static final /* synthetic */ int f7180GGG1xW = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Paint f7181AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Paint f7182AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Paint f7183AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Paint f7184AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Paint f7185B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Paint f7186B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Paint f7187B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final A4TApA f7188B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final AccessibilityManager f7189B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public C4FrIb.A4TApA f7190B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final int f7191BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final ArrayList f7192BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final ArrayList f7193BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final ArrayList f7194BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f7195BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public ValueAnimator f7196BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public ValueAnimator f7197BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final int f7198BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final int f7199BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final int f7200BniPrB;
    public final int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final int f7201C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final int f7202C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final int f7203CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final int f7204CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public int f7205COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final int f7206CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int f7207CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f7208CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f7209CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public int f7210Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public int f7211CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public int f7212CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public int f7213CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public int f7214CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public int f7215CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public int f7216CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public int f7217CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public int f7218D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public int f7219D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public boolean f7220D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public Drawable f7221D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public boolean f7222D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public Drawable f7223D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public boolean f7224DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public ColorStateList f7225DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public Drawable f7226DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public boolean f7227DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public Drawable f7228DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public boolean f7229DXnQ0V;
    public ColorStateList DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public int f7230DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public final int f7231DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public final int f7232DdagTj;
    public float Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public float f7233De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public MotionEvent f7234DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public boolean f7235Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public float f7236DuwtYk;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public float f7237DvK7DB;

    /* renamed from: DyaChj, reason: collision with root package name */
    public ArrayList f7238DyaChj;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public int f7239ECyGFg;

    /* renamed from: EGM26s, reason: collision with root package name */
    public int f7240EGM26s;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public float f7241EH1KK8;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public float[] f7242EPdU4G;

    /* renamed from: EQurEW, reason: collision with root package name */
    public int f7243EQurEW;

    /* renamed from: EUIRHA, reason: collision with root package name */
    public int f7244EUIRHA;

    /* renamed from: EY4UKY, reason: collision with root package name */
    public int f7245EY4UKY;
    public int EdQ5bb;

    /* renamed from: EdhSi6, reason: collision with root package name */
    public boolean f7246EdhSi6;

    /* renamed from: EiK8oA, reason: collision with root package name */
    public boolean f7247EiK8oA;

    /* renamed from: EicXu4, reason: collision with root package name */
    public ColorStateList f7248EicXu4;

    /* renamed from: EmJGcg, reason: collision with root package name */
    public ColorStateList f7249EmJGcg;

    /* renamed from: ErKPGd, reason: collision with root package name */
    public ColorStateList f7250ErKPGd;

    /* renamed from: EsrwYR, reason: collision with root package name */
    public ColorStateList f7251EsrwYR;

    /* renamed from: EwN40Z, reason: collision with root package name */
    public ColorStateList f7252EwN40Z;

    /* renamed from: ExjC7D, reason: collision with root package name */
    public final Path f7253ExjC7D;

    /* renamed from: F1loUV, reason: collision with root package name */
    public final RectF f7254F1loUV;

    /* renamed from: F32kj0, reason: collision with root package name */
    public final RectF f7255F32kj0;

    /* renamed from: F508T2, reason: collision with root package name */
    public final RectF f7256F508T2;

    /* renamed from: FG7pZc, reason: collision with root package name */
    public final RectF f7257FG7pZc;

    /* renamed from: FM663C, reason: collision with root package name */
    public final Rect f7258FM663C;

    /* renamed from: FOAO9d, reason: collision with root package name */
    public final RectF f7259FOAO9d;

    /* renamed from: FSFw2u, reason: collision with root package name */
    public final Rect f7260FSFw2u;

    /* renamed from: FZu94u, reason: collision with root package name */
    public final Matrix f7261FZu94u;

    /* renamed from: FdMWEC, reason: collision with root package name */
    public final AaHO0E f7262FdMWEC;

    /* renamed from: Ff5QvW, reason: collision with root package name */
    public Drawable f7263Ff5QvW;

    /* renamed from: Fmmv0E, reason: collision with root package name */
    public List f7264Fmmv0E;

    /* renamed from: FmyuN2, reason: collision with root package name */
    public float f7265FmyuN2;

    /* renamed from: FpcJKS, reason: collision with root package name */
    public int f7266FpcJKS;

    /* renamed from: Fyurov, reason: collision with root package name */
    public final int f7267Fyurov;
    public final A2egSU G16Pvp;
    public final AZkASS G2rdQT;

    /* renamed from: G58fqA, reason: collision with root package name */
    public final CtFAbx.A2egSU f7268G58fqA;

    /* renamed from: GEYgCP, reason: collision with root package name */
    public boolean f7269GEYgCP;

    /* JADX WARN: Type inference failed for: r1v11, types: [PSeUZ5.A2egSU] */
    public ADYaiT(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130969887, 2131952900), attributeSet, 2130969887);
        int recommendedTimeoutMillis;
        this.f7192BI9f7h = new ArrayList();
        this.f7193BIYEnU = new ArrayList();
        this.f7194BJ7GGh = new ArrayList();
        this.f7195BNL6CD = false;
        this.f7215CrfGsy = -1;
        this.f7216CtFAbx = -1;
        this.f7220D6yqiO = false;
        this.f7222D8cQ8b = false;
        this.f7224DAk1zC = false;
        this.f7227DUi7mC = false;
        this.f7229DXnQ0V = false;
        this.f7235Dphsd2 = false;
        this.f7238DyaChj = new ArrayList();
        this.f7239ECyGFg = -1;
        this.f7240EGM26s = -1;
        this.f7241EH1KK8 = 0.0f;
        this.f7246EdhSi6 = false;
        this.f7253ExjC7D = new Path();
        this.f7254F1loUV = new RectF();
        this.f7255F32kj0 = new RectF();
        this.f7256F508T2 = new RectF();
        this.f7257FG7pZc = new RectF();
        this.f7258FM663C = new Rect();
        this.f7259FOAO9d = new RectF();
        this.f7260FSFw2u = new Rect();
        this.f7261FZu94u = new Matrix();
        AaHO0E aaHO0E = new AaHO0E();
        this.f7262FdMWEC = aaHO0E;
        this.f7264Fmmv0E = Collections.EMPTY_LIST;
        this.f7266FpcJKS = 0;
        final Slider slider = (Slider) this;
        this.G16Pvp = new ViewTreeObserver.OnScrollChangedListener() { // from class: PSeUZ5.A2egSU
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                Slider.this.BV3sI0();
            }
        };
        this.G2rdQT = new AZkASS(1, slider);
        this.f7268G58fqA = new CtFAbx.A2egSU(9, slider);
        Context context2 = getContext();
        this.f7269GEYgCP = isShown();
        this.f7181AcNBzu = new Paint();
        this.f7182AlLFFp = new Paint();
        Paint paint = new Paint(1);
        this.f7183AmA8tU = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.f7184AzWtSf = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f7185B25kr6 = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f7186B2KMhB = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.f7187B3GDIM = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.f7206CQhlFr = resources.getDimensionPixelSize(2131166505);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131166504);
        this.f7199BmvVmW = dimensionPixelOffset;
        this.f7210Cd8JRx = dimensionPixelOffset;
        this.f7200BniPrB = resources.getDimensionPixelSize(2131166500);
        this.BpkvW3 = resources.getDimensionPixelSize(2131166503);
        this.f7201C2rE4F = resources.getDimensionPixelSize(2131166502);
        this.f7202C4FrIb = resources.getDimensionPixelSize(2131166502);
        this.f7203CASmeH = resources.getDimensionPixelSize(2131166501);
        this.f7232DdagTj = resources.getDimensionPixelSize(2131166496);
        this.f7231DcUJf1 = resources.getDimensionPixelOffset(2131166149);
        int[] iArr = R$styleable.f11258CtxOCS;
        C4FrIb.ADYaiT(context2, attributeSet, 2130969887, 2131952900);
        C4FrIb.AMqCpz(context2, attributeSet, iArr, 2130969887, 2131952900, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, 2130969887, 2131952900);
        setOrientation(obtainStyledAttributes.getInt(2, 0));
        this.f7191BChYOn = obtainStyledAttributes.getResourceId(10, 2131952934);
        this.f7236DuwtYk = obtainStyledAttributes.getFloat(4, 0.0f);
        this.f7237DvK7DB = obtainStyledAttributes.getFloat(5, 1.0f);
        setValues(Float.valueOf(this.f7236DuwtYk));
        setCentered(obtainStyledAttributes.getBoolean(6, false));
        this.f7241EH1KK8 = obtainStyledAttributes.getFloat(3, 0.0f);
        this.f7204CNPG0E = (int) Math.ceil(obtainStyledAttributes.getDimension(11, P3rngT.A4TApA.A5SV6n(context2)));
        boolean hasValue = obtainStyledAttributes.hasValue(27);
        int i = hasValue ? 27 : 29;
        int i2 = hasValue ? 27 : 28;
        ColorStateList BPw6Q82 = com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, i);
        setTrackInactiveTintList(BPw6Q82 == null ? ASJ6gh.A5SV6n(context2, 2131100558) : BPw6Q82);
        ColorStateList BPw6Q83 = com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, i2);
        setTrackActiveTintList(BPw6Q83 == null ? ASJ6gh.A5SV6n(context2, 2131100555) : BPw6Q83);
        aaHO0E.B3GDIM(com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 12));
        if (obtainStyledAttributes.hasValue(16)) {
            setThumbStrokeColor(com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 16));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(17, 0.0f));
        ColorStateList BPw6Q84 = com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 7);
        setHaloTintList(BPw6Q84 == null ? ASJ6gh.A5SV6n(context2, 2131100556) : BPw6Q84);
        this.f7243EQurEW = obtainStyledAttributes.hasValue(25) ? obtainStyledAttributes.getInt(25, -1) : obtainStyledAttributes.getBoolean(26, true) ? 0 : 2;
        boolean hasValue2 = obtainStyledAttributes.hasValue(20);
        int i3 = hasValue2 ? 20 : 22;
        int i4 = hasValue2 ? 20 : 21;
        ColorStateList BPw6Q85 = com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, i3);
        setTickInactiveTintList(BPw6Q85 == null ? ASJ6gh.A5SV6n(context2, 2131100557) : BPw6Q85);
        ColorStateList BPw6Q86 = com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, i4);
        setTickActiveTintList(BPw6Q86 == null ? ASJ6gh.A5SV6n(context2, 2131100554) : BPw6Q86);
        setThumbTrackGapSize(obtainStyledAttributes.getDimensionPixelSize(18, 0));
        setTrackStopIndicatorSize(obtainStyledAttributes.getDimensionPixelSize(40, 0));
        setTrackCornerSize(obtainStyledAttributes.getDimensionPixelSize(30, -1));
        setTrackInsideCornerSize(obtainStyledAttributes.getDimensionPixelSize(39, 0));
        setTrackIconActiveStart(com.bumptech.glide.AMqCpz.BV3sI0(context2, obtainStyledAttributes, 34));
        setTrackIconActiveEnd(com.bumptech.glide.AMqCpz.BV3sI0(context2, obtainStyledAttributes, 33));
        setTrackIconActiveColor(com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 32));
        setTrackIconInactiveStart(com.bumptech.glide.AMqCpz.BV3sI0(context2, obtainStyledAttributes, 37));
        setTrackIconInactiveEnd(com.bumptech.glide.AMqCpz.BV3sI0(context2, obtainStyledAttributes, 36));
        setTrackIconInactiveColor(com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 35));
        setTrackIconSize(obtainStyledAttributes.getDimensionPixelSize(38, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(15, 0) * 2;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(19, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(14, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(8, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(13, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(31, 0));
        setTickActiveRadius(obtainStyledAttributes.getDimensionPixelSize(23, this.f7217CtxOCS / 2));
        setTickInactiveRadius(obtainStyledAttributes.getDimensionPixelSize(24, this.f7217CtxOCS / 2));
        setLabelBehavior(obtainStyledAttributes.getInt(9, 0));
        if (!obtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        aaHO0E.BChYOn(2);
        this.f7198BV3sI0 = ViewConfiguration.get(context2).getScaledTouchSlop();
        A4TApA a4TApA = new A4TApA(slider);
        this.f7188B4ZgIw = a4TApA;
        DG07BK.B4ZgIw(this, a4TApA);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f7189B7CMnp = accessibilityManager;
        if (Build.VERSION.SDK_INT < 29) {
            this.f7267Fyurov = 120000;
        } else {
            recommendedTimeoutMillis = accessibilityManager.getRecommendedTimeoutMillis(10000, 6);
            this.f7267Fyurov = recommendedTimeoutMillis;
        }
    }

    public final void A2egSU(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.f7211CikNvS, this.f7212CkXcdM);
        } else {
            float max = Math.max(this.f7211CikNvS, this.f7212CkXcdM) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
        }
    }

    public final void A4TApA(Canvas canvas, RectF rectF, Drawable drawable, boolean z) {
        if (drawable != null) {
            RectF rectF2 = this.f7259FOAO9d;
            int i = this.f7230DaOi9o;
            int i2 = this.f7231DcUJf1;
            if (rectF.right - rectF.left >= (i2 * 2) + i) {
                float f = z ^ (B2KMhB() || B3GDIM()) ? rectF.left + i2 : (rectF.right - i2) - i;
                float f2 = i;
                float A5SV6n2 = A5SV6n() - (f2 / 2.0f);
                rectF2.set(f, A5SV6n2, f + f2, f2 + A5SV6n2);
            } else {
                rectF2.setEmpty();
            }
            if (rectF2.isEmpty()) {
                return;
            }
            if (B3GDIM()) {
                this.f7261FZu94u.mapRect(rectF2);
            }
            Rect rect = this.f7260FSFw2u;
            rectF2.round(rect);
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
    }

    public final int A5SV6n() {
        int i = this.f7207CSDoyG / 2;
        int i2 = this.f7208CTkVKb;
        return i + ((i2 == 1 || i2 == 3) ? ((PcHFaG.A4TApA) this.f7192BI9f7h.get(0)).getIntrinsicHeight() : 0);
    }

    public final ValueAnimator ADYaiT(boolean z) {
        int D07BeM2;
        TimeInterpolator D6DOie2;
        float f = z ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z ? this.f7197BTvldC : this.f7196BPw6Q8;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, z ? 1.0f : 0.0f);
        if (z) {
            D07BeM2 = com.bumptech.glide.A5SV6n.D07BeM(getContext(), 2130969623, 83);
            D6DOie2 = com.bumptech.glide.A5SV6n.D6DOie(getContext(), 2130969633, NdEzCJ.A2egSU.AMqCpz);
        } else {
            D07BeM2 = com.bumptech.glide.A5SV6n.D07BeM(getContext(), 2130969626, 117);
            D6DOie2 = com.bumptech.glide.A5SV6n.D6DOie(getContext(), 2130969631, NdEzCJ.A2egSU.f6038A5SV6n);
        }
        ofFloat.setDuration(D07BeM2);
        ofFloat.setInterpolator(D6DOie2);
        ofFloat.addUpdateListener(new Ddcejp(10, this));
        return ofFloat;
    }

    public final void AMqCpz(float f, float f2, float f3, float f4, Canvas canvas, RectF rectF, int i) {
        if (f2 - f > getTrackCornerSize() - this.f7214CqNSpT) {
            rectF.set(f, f3, f2, f4);
        } else {
            rectF.setEmpty();
        }
        C2rE4F(canvas, this.f7181AcNBzu, rectF, getTrackCornerSize(), i);
    }

    public final void ARc23Z(Canvas canvas, float f, float f2) {
        Iterator it = this.f7238DyaChj.iterator();
        while (it.hasNext()) {
            float CcAIMM2 = CcAIMM(((Float) it.next()).floatValue());
            float f3 = (this.f7211CikNvS / 2.0f) + this.f7214CqNSpT;
            if (f >= CcAIMM2 - f3 && f <= CcAIMM2 + f3) {
                return;
            }
        }
        boolean B3GDIM2 = B3GDIM();
        Paint paint = this.f7187B3GDIM;
        if (B3GDIM2) {
            canvas.drawPoint(f2, f, paint);
        } else {
            canvas.drawPoint(f, f2, paint);
        }
    }

    public final void ASJ6gh(Canvas canvas, int i, int i2, float f, Drawable drawable) {
        canvas.save();
        if (B3GDIM()) {
            canvas.concat(this.f7261FZu94u);
        }
        canvas.translate((this.f7210Cd8JRx + ((int) (B9tovu(f) * i))) - (drawable.getBounds().width() / 2.0f), i2 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void AYUAbz(int i, int i2, Canvas canvas, Paint paint) {
        while (i < i2) {
            float f = B3GDIM() ? this.f7242EPdU4G[i + 1] : this.f7242EPdU4G[i];
            float f2 = (this.f7211CikNvS / 2.0f) + this.f7214CqNSpT;
            Iterator it = this.f7238DyaChj.iterator();
            if (it.hasNext()) {
                float CcAIMM2 = CcAIMM(((Float) it.next()).floatValue());
                if (f >= CcAIMM2 - f2 && f <= CcAIMM2 + f2) {
                    i += 2;
                }
            }
            if (this.f7220D6yqiO) {
                float f3 = (this.f7211CikNvS / 2.0f) + this.f7214CqNSpT;
                float f4 = ((this.f7210Cd8JRx * 2) + this.EdQ5bb) / 2.0f;
                if (f >= f4 - f3 && f <= f4 + f3) {
                    i += 2;
                }
            }
            float[] fArr = this.f7242EPdU4G;
            canvas.drawPoint(fArr[i], fArr[i + 1], paint);
            i += 2;
        }
    }

    public final void AZOQYO(Canvas canvas, RectF rectF, RectF rectF2) {
        if (this.f7221D8MqeW == null && this.f7223D9tr6l == null && this.f7226DRlcZ9 == null && this.f7228DV2E8K == null) {
            return;
        }
        this.f7238DyaChj.size();
        A4TApA(canvas, rectF, this.f7221D8MqeW, true);
        A4TApA(canvas, rectF2, this.f7226DRlcZ9, true);
        A4TApA(canvas, rectF, this.f7223D9tr6l, false);
        A4TApA(canvas, rectF2, this.f7228DV2E8K, false);
    }

    public final void AZkASS() {
        if (!this.f7195BNL6CD) {
            this.f7195BNL6CD = true;
            ValueAnimator ADYaiT2 = ADYaiT(true);
            this.f7196BPw6Q8 = ADYaiT2;
            this.f7197BTvldC = null;
            ADYaiT2.start();
        }
        ArrayList arrayList = this.f7192BI9f7h;
        Iterator it = arrayList.iterator();
        for (int i = 0; i < this.f7238DyaChj.size() && it.hasNext(); i++) {
            if (i != this.f7240EGM26s) {
                BI9f7h((PcHFaG.A4TApA) it.next(), ((Float) this.f7238DyaChj.get(i)).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.f7238DyaChj.size())));
        }
        BI9f7h((PcHFaG.A4TApA) it.next(), ((Float) this.f7238DyaChj.get(this.f7240EGM26s)).floatValue());
    }

    public final void AaHO0E() {
        if (this.f7195BNL6CD) {
            this.f7195BNL6CD = false;
            ValueAnimator ADYaiT2 = ADYaiT(false);
            this.f7197BTvldC = ADYaiT2;
            this.f7196BPw6Q8 = null;
            ADYaiT2.addListener(new AaHO0E.A5SV6n(13, this));
            this.f7197BTvldC.start();
        }
    }

    public final float[] AcNBzu() {
        float floatValue = ((Float) this.f7238DyaChj.get(0)).floatValue();
        float floatValue2 = ((Float) CtFAbx.ADYaiT(this.f7238DyaChj, 1)).floatValue();
        if (this.f7238DyaChj.size() == 1) {
            floatValue = this.f7236DuwtYk;
        }
        float B9tovu2 = B9tovu(floatValue);
        float B9tovu3 = B9tovu(floatValue2);
        if (this.f7220D6yqiO) {
            float min = Math.min(0.5f, B9tovu3);
            B9tovu3 = Math.max(0.5f, B9tovu3);
            B9tovu2 = min;
        }
        return (this.f7220D6yqiO || !(B2KMhB() || B3GDIM())) ? new float[]{B9tovu2, B9tovu3} : new float[]{B9tovu3, B9tovu2};
    }

    public final int AlLFFp(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean AmA8tU(double d) {
        double doubleValue = new BigDecimal(Double.toString(d)).divide(new BigDecimal(Float.toString(this.f7241EH1KK8)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    public final boolean AzWtSf(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollHorizontally(1) || viewGroup.canScrollHorizontally(-1)) && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B25kr6(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B2KMhB() {
        return getLayoutDirection() == 1;
    }

    public final boolean B3GDIM() {
        return this.f7205COJEAR == 1;
    }

    public final boolean B4ZgIw(int i) {
        int i2 = this.f7240EGM26s;
        long j = i2 + i;
        long size = this.f7238DyaChj.size() - 1;
        if (j < 0) {
            j = 0;
        } else if (j > size) {
            j = size;
        }
        int i3 = (int) j;
        this.f7240EGM26s = i3;
        if (i3 == i2) {
            return false;
        }
        if (this.f7239ECyGFg != -1) {
            this.f7239ECyGFg = i3;
        }
        BTvldC();
        postInvalidate();
        return true;
    }

    public final void B7CMnp(int i) {
        if (B2KMhB() || B3GDIM()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        B4ZgIw(i);
    }

    public final float B9tovu(float f) {
        float f2 = this.f7236DuwtYk;
        float f3 = (f - f2) / (this.f7237DvK7DB - f2);
        return (B2KMhB() || B3GDIM()) ? 1.0f - f3 : f3;
    }

    public final void BChYOn() {
        Iterator it = this.f7194BJ7GGh.iterator();
        if (it.hasNext()) {
            throw CtFAbx.A5SV6n(it);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void BI9f7h(PcHFaG.A4TApA r7, float r8) {
        /*
            r6 = this;
            r0 = 1
            int r1 = r6.f7232DdagTj
            int r2 = (int) r8
            float r2 = (float) r2
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 != 0) goto Lc
            java.lang.String r2 = "%.0f"
            goto Le
        Lc:
            java.lang.String r2 = "%.2f"
        Le:
            java.lang.Float r3 = java.lang.Float.valueOf(r8)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r5 = 0
            r4[r5] = r3
            java.lang.String r2 = java.lang.String.format(r2, r4)
            java.lang.CharSequence r3 = r7.f7409CmUvjW
            boolean r3 = android.text.TextUtils.equals(r3, r2)
            if (r3 != 0) goto L2c
            r7.f7409CmUvjW = r2
            Oay4Bh.BniPrB r2 = r7.f7412CtFAbx
            r2.AMqCpz = r0
            r7.invalidateSelf()
        L2c:
            boolean r0 = r6.B3GDIM()
            if (r0 == 0) goto L73
            int r0 = r6.f7210Cd8JRx
            float r8 = r6.B9tovu(r8)
            int r2 = r6.EdQ5bb
            float r2 = (float) r2
            float r8 = r8 * r2
            int r8 = (int) r8
            int r0 = r0 + r8
            int r8 = r7.getIntrinsicHeight()
            int r8 = r8 / 2
            int r0 = r0 - r8
            int r8 = r7.getIntrinsicHeight()
            int r8 = r8 + r0
            boolean r2 = r6.B2KMhB()
            if (r2 == 0) goto L62
            int r2 = r6.A5SV6n()
            int r3 = r6.f7212CkXcdM
            int r3 = r3 / 2
            int r3 = r3 + r1
            int r2 = r2 - r3
            int r1 = r7.getIntrinsicWidth()
        L5f:
            int r1 = r2 - r1
            goto L9b
        L62:
            int r2 = r6.A5SV6n()
            int r3 = r6.f7212CkXcdM
            int r3 = r3 / 2
            int r3 = r3 + r1
            int r1 = r3 + r2
            int r2 = r7.getIntrinsicWidth()
            int r2 = r2 + r1
            goto L9b
        L73:
            int r0 = r6.f7210Cd8JRx
            float r8 = r6.B9tovu(r8)
            int r2 = r6.EdQ5bb
            float r2 = (float) r2
            float r8 = r8 * r2
            int r8 = (int) r8
            int r0 = r0 + r8
            int r8 = r7.getIntrinsicWidth()
            int r8 = r8 / 2
            int r0 = r0 - r8
            int r8 = r7.getIntrinsicWidth()
            int r8 = r8 + r0
            int r2 = r6.A5SV6n()
            int r3 = r6.f7212CkXcdM
            int r3 = r3 / 2
            int r3 = r3 + r1
            int r2 = r2 - r3
            int r1 = r7.getIntrinsicHeight()
            goto L5f
        L9b:
            android.graphics.Rect r3 = r6.f7258FM663C
            r3.set(r0, r1, r8, r2)
            boolean r8 = r6.B3GDIM()
            if (r8 == 0) goto Lb3
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>(r3)
            android.graphics.Matrix r0 = r6.f7261FZu94u
            r0.mapRect(r8)
            r8.round(r3)
        Lb3:
            android.view.ViewGroup r8 = Oay4Bh.C4FrIb.AZkASS(r6)
            Oay4Bh.AMqCpz.A4TApA(r8, r6, r3)
            r7.setBounds(r3)
            android.view.ViewGroup r8 = Oay4Bh.C4FrIb.AZkASS(r6)
            if (r8 != 0) goto Lc5
            r8 = 0
            goto Lc9
        Lc5:
            android.view.ViewOverlay r8 = r8.getOverlay()
        Lc9:
            if (r8 != 0) goto Lcc
            return
        Lcc:
            r8.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: PSeUZ5.ADYaiT.BI9f7h(PcHFaG.A4TApA, float):void");
    }

    public final void BIYEnU(ArrayList arrayList) {
        ViewGroup AZkASS2;
        int resourceId;
        ViewGroup AZkASS3;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.f7238DyaChj.size() == arrayList.size() && this.f7238DyaChj.equals(arrayList)) {
            return;
        }
        this.f7238DyaChj = arrayList;
        this.f7247EiK8oA = true;
        this.f7240EGM26s = 0;
        BTvldC();
        ArrayList arrayList2 = this.f7192BI9f7h;
        if (arrayList2.size() > this.f7238DyaChj.size()) {
            List<PcHFaG.A4TApA> subList = arrayList2.subList(this.f7238DyaChj.size(), arrayList2.size());
            for (PcHFaG.A4TApA a4TApA : subList) {
                if (isAttachedToWindow() && (AZkASS3 = C4FrIb.AZkASS(this)) != null) {
                    AZkASS3.getOverlay().remove(a4TApA);
                    AZkASS3.removeOnLayoutChangeListener(a4TApA.f7413CtxOCS);
                }
            }
            subList.clear();
        }
        while (arrayList2.size() < this.f7238DyaChj.size()) {
            Context context = getContext();
            int i = this.f7191BChYOn;
            PcHFaG.A4TApA a4TApA2 = new PcHFaG.A4TApA(context, i);
            TypedArray AmA8tU2 = C4FrIb.AmA8tU(a4TApA2.f7410CqNSpT, null, R$styleable.f11266DG07BK, 0, i, new int[0]);
            Context context2 = a4TApA2.f7410CqNSpT;
            a4TApA2.f7420DAk1zC = context2.getResources().getDimensionPixelSize(2131166528);
            boolean z = AmA8tU2.getBoolean(8, true);
            a4TApA2.f7419D9tr6l = z;
            if (z) {
                B2KMhB.A2egSU ASJ6gh2 = a4TApA2.f7042AlLFFp.f7021A2egSU.ASJ6gh();
                ASJ6gh2.f7103AaHO0E = a4TApA2.BniPrB();
                a4TApA2.setShapeAppearanceModel(ASJ6gh2.A2egSU());
            } else {
                a4TApA2.f7420DAk1zC = 0;
            }
            CharSequence text = AmA8tU2.getText(6);
            boolean equals = TextUtils.equals(a4TApA2.f7409CmUvjW, text);
            BniPrB bniPrB = a4TApA2.f7412CtFAbx;
            if (!equals) {
                a4TApA2.f7409CmUvjW = text;
                bniPrB.AMqCpz = true;
                a4TApA2.invalidateSelf();
            }
            P3rngT.AMqCpz aMqCpz = (!AmA8tU2.hasValue(0) || (resourceId = AmA8tU2.getResourceId(0, 0)) == 0) ? null : new P3rngT.AMqCpz(context2, resourceId);
            if (aMqCpz != null && AmA8tU2.hasValue(1)) {
                aMqCpz.f6951AaHO0E = com.bumptech.glide.AMqCpz.BPw6Q8(context2, AmA8tU2, 1);
            }
            bniPrB.A5SV6n(aMqCpz, context2);
            a4TApA2.B3GDIM(ColorStateList.valueOf(AmA8tU2.getColor(7, BV3sI0.A2egSU.A5SV6n(BV3sI0.A2egSU.AMqCpz(AYUAbz.AZOQYO(context2, 2130968857, PcHFaG.A4TApA.class.getCanonicalName()), MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT), BV3sI0.A2egSU.AMqCpz(AYUAbz.AZOQYO(context2, R.attr.colorBackground, PcHFaG.A4TApA.class.getCanonicalName()), 229)))));
            a4TApA2.BIYEnU(ColorStateList.valueOf(AYUAbz.AZOQYO(context2, 2130968895, PcHFaG.A4TApA.class.getCanonicalName())));
            a4TApA2.f7415D6DOie = AmA8tU2.getDimensionPixelSize(2, 0);
            a4TApA2.f7416D6yqiO = AmA8tU2.getDimensionPixelSize(4, 0);
            a4TApA2.f7417D8MqeW = AmA8tU2.getDimensionPixelSize(5, 0);
            a4TApA2.f7418D8cQ8b = AmA8tU2.getDimensionPixelSize(3, 0);
            AmA8tU2.recycle();
            arrayList2.add(a4TApA2);
            if (isAttachedToWindow() && (AZkASS2 = C4FrIb.AZkASS(this)) != null) {
                int[] iArr = new int[2];
                AZkASS2.getLocationOnScreen(iArr);
                a4TApA2.f7421DG07BK = iArr[0];
                AZkASS2.getWindowVisibleDisplayFrame(a4TApA2.f7414D07BeM);
                AZkASS2.addOnLayoutChangeListener(a4TApA2.f7413CtxOCS);
            }
        }
        int i2 = arrayList2.size() == 1 ? 0 : 1;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((PcHFaG.A4TApA) it.next()).BJ7GGh(i2);
        }
        Iterator it2 = this.f7193BIYEnU.iterator();
        while (it2.hasNext()) {
            MlRYy2.A4TApA a4TApA3 = (MlRYy2.A4TApA) it2.next();
            Iterator it3 = this.f7238DyaChj.iterator();
            while (it3.hasNext()) {
                ((Float) it3.next()).getClass();
                a4TApA3.getClass();
            }
        }
        postInvalidate();
    }

    public final boolean BJ7GGh(float f, int i) {
        this.f7240EGM26s = i;
        if (Math.abs(f - ((Float) this.f7238DyaChj.get(i)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.f7266FpcJKS == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f2 = this.f7236DuwtYk;
                minSeparation = CtFAbx.A4TApA(f2, this.f7237DvK7DB, (minSeparation - this.f7210Cd8JRx) / this.EdQ5bb, f2);
            }
        }
        if (B2KMhB() || B3GDIM()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        int i3 = i - 1;
        this.f7238DyaChj.set(i, Float.valueOf(com.bumptech.glide.AMqCpz.B2KMhB(f, i3 < 0 ? this.f7236DuwtYk : minSeparation + ((Float) this.f7238DyaChj.get(i3)).floatValue(), i2 >= this.f7238DyaChj.size() ? this.f7237DvK7DB : ((Float) this.f7238DyaChj.get(i2)).floatValue() - minSeparation)));
        Iterator it = this.f7193BIYEnU.iterator();
        while (it.hasNext()) {
            MlRYy2.A4TApA a4TApA = (MlRYy2.A4TApA) it.next();
            float floatValue = ((Float) this.f7238DyaChj.get(i)).floatValue();
            a4TApA.getClass();
            SliderPreference sliderPreference = a4TApA.f5457A2egSU;
            if (sliderPreference.f11134DcUJf1 != null) {
                int i4 = (int) floatValue;
                sliderPreference.BmvVmW(i4, true);
                sliderPreference.BpkvW3(i4);
            }
        }
        AccessibilityManager accessibilityManager = this.f7189B7CMnp;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            Runnable runnable = this.f7190B9tovu;
            if (runnable == null) {
                this.f7190B9tovu = new C4FrIb.A4TApA(this);
            } else {
                removeCallbacks(runnable);
            }
            C4FrIb.A4TApA a4TApA2 = this.f7190B9tovu;
            a4TApA2.f1548AlLFFp = i;
            postDelayed(a4TApA2, 200L);
        }
        return true;
    }

    public final void BNL6CD() {
        double d;
        float f = this.f7265FmyuN2;
        float f2 = this.f7241EH1KK8;
        if (f2 > 0.0f) {
            d = Math.round(f * r1) / ((int) ((this.f7237DvK7DB - this.f7236DuwtYk) / f2));
        } else {
            d = f;
        }
        if (B2KMhB() || B3GDIM()) {
            d = 1.0d - d;
        }
        float f3 = this.f7237DvK7DB;
        BJ7GGh((float) ((d * (f3 - r1)) + this.f7236DuwtYk), this.f7239ECyGFg);
    }

    public final void BPw6Q8(int i, Rect rect) {
        int B9tovu2 = this.f7210Cd8JRx + ((int) (B9tovu(getValues().get(i).floatValue()) * this.EdQ5bb));
        int A5SV6n2 = A5SV6n();
        int max = Math.max(this.f7211CikNvS / 2, this.f7204CNPG0E / 2);
        int max2 = Math.max(this.f7212CkXcdM / 2, this.f7204CNPG0E / 2);
        RectF rectF = new RectF(B9tovu2 - max, A5SV6n2 - max2, B9tovu2 + max, A5SV6n2 + max2);
        if (B3GDIM()) {
            this.f7261FZu94u.mapRect(rectF);
        }
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public final void BTvldC() {
        if (!(getBackground() instanceof RippleDrawable) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            float B9tovu2 = (B9tovu(((Float) this.f7238DyaChj.get(this.f7240EGM26s)).floatValue()) * this.EdQ5bb) + this.f7210Cd8JRx;
            int A5SV6n2 = A5SV6n();
            float f = this.f7213CmUvjW;
            float[] fArr = {B9tovu2 - f, A5SV6n2 - r7, B9tovu2 + f, A5SV6n2 + r7};
            if (B3GDIM()) {
                this.f7261FZu94u.mapPoints(fArr);
            }
            background.setHotspotBounds((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT >= 24 ? r4.f7269GEYgCP : isShown()) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void BV3sI0() {
        /*
            r4 = this;
            boolean r0 = r4.B3GDIM()
            boolean r1 = r4.B2KMhB()
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L17
            if (r1 == 0) goto L17
            r0 = -1102263091(0xffffffffbe4ccccd, float:-0.2)
            r1 = 1056964608(0x3f000000, float:0.5)
            r2 = -1102263091(0xffffffffbe4ccccd, float:-0.2)
            goto L21
        L17:
            r1 = 1067030938(0x3f99999a, float:1.2)
            if (r0 == 0) goto L21
            r1 = 1056964608(0x3f000000, float:0.5)
            r2 = 1067030938(0x3f99999a, float:1.2)
        L21:
            java.util.ArrayList r0 = r4.f7192BI9f7h
            java.util.Iterator r0 = r0.iterator()
        L27:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L3b
            java.lang.Object r3 = r0.next()
            PcHFaG.A4TApA r3 = (PcHFaG.A4TApA) r3
            r3.f7424DV2E8K = r2
            r3.f7425DXnQ0V = r1
            r3.invalidateSelf()
            goto L27
        L3b:
            int r0 = r4.f7208CTkVKb
            if (r0 == 0) goto L95
            r1 = 1
            if (r0 == r1) goto L95
            r2 = 2
            if (r0 == r2) goto L91
            r2 = 3
            if (r0 != r2) goto L7b
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L77
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.ViewGroup r2 = Oay4Bh.C4FrIb.AZkASS(r4)
            r2.getHitRect(r0)
            boolean r0 = r4.getLocalVisibleRect(r0)
            if (r0 == 0) goto L70
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r0 < r2) goto L69
            boolean r0 = r4.f7269GEYgCP
            goto L6d
        L69:
            boolean r0 = r4.isShown()
        L6d:
            if (r0 == 0) goto L70
            goto L71
        L70:
            r1 = 0
        L71:
            if (r1 == 0) goto L77
            r4.AZkASS()
            return
        L77:
            r4.AaHO0E()
            return
        L7b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected labelBehavior: "
            r1.<init>(r2)
            int r2 = r4.f7208CTkVKb
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            r4.AaHO0E()
            return
        L95:
            int r0 = r4.f7239ECyGFg
            r1 = -1
            if (r0 == r1) goto La4
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto La4
            r4.AZkASS()
            return
        La4:
            r4.AaHO0E()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: PSeUZ5.ADYaiT.BV3sI0():void");
    }

    public final void BmvVmW() {
        int i = this.f7214CqNSpT;
        if (i > 0) {
            int i2 = this.f7211CikNvS;
            this.f7215CrfGsy = i2;
            this.f7216CtFAbx = i;
            int round = Math.round(i2 * 0.5f);
            int i3 = this.f7211CikNvS - round;
            setThumbWidth(round);
            setThumbTrackGapSize(this.f7214CqNSpT - (i3 / 2));
        }
    }

    public final void BniPrB() {
        CSDoyG();
        float f = this.f7241EH1KK8;
        int i = 0;
        if (f <= 0.0f) {
            BpkvW3(0);
            return;
        }
        int i2 = this.f7243EQurEW;
        if (i2 == 0) {
            i = Math.min((int) (((this.f7237DvK7DB - this.f7236DuwtYk) / f) + 1.0f), (this.EdQ5bb / this.f7203CASmeH) + 1);
        } else if (i2 == 1) {
            int i3 = (int) (((this.f7237DvK7DB - this.f7236DuwtYk) / f) + 1.0f);
            if (i3 <= (this.EdQ5bb / this.f7203CASmeH) + 1) {
                i = i3;
            }
        } else if (i2 != 2) {
            throw new IllegalStateException("Unexpected tickVisibilityMode: " + this.f7243EQurEW);
        }
        BpkvW3(i);
    }

    public final void BpkvW3(int i) {
        if (i == 0) {
            this.f7242EPdU4G = null;
            return;
        }
        float[] fArr = this.f7242EPdU4G;
        if (fArr == null || fArr.length != i * 2) {
            this.f7242EPdU4G = new float[i * 2];
        }
        float f = this.EdQ5bb / (i - 1);
        float A5SV6n2 = A5SV6n();
        for (int i2 = 0; i2 < i * 2; i2 += 2) {
            float[] fArr2 = this.f7242EPdU4G;
            fArr2[i2] = ((i2 / 2.0f) * f) + this.f7210Cd8JRx;
            fArr2[i2 + 1] = A5SV6n2;
        }
        if (B3GDIM()) {
            this.f7261FZu94u.mapPoints(this.f7242EPdU4G);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C2rE4F(android.graphics.Canvas r21, android.graphics.Paint r22, android.graphics.RectF r23, float r24, int r25) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: PSeUZ5.ADYaiT.C2rE4F(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, float, int):void");
    }

    public final void C4FrIb() {
        Drawable drawable = this.f7223D9tr6l;
        if (drawable != null) {
            if (!this.f7224DAk1zC && this.f7225DG07BK != null) {
                this.f7223D9tr6l = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
                this.f7224DAk1zC = true;
            }
            if (this.f7224DAk1zC) {
                this.f7223D9tr6l.setTintList(this.f7225DG07BK);
            }
        }
    }

    public final void CASmeH() {
        Drawable drawable = this.f7221D8MqeW;
        if (drawable != null) {
            if (!this.f7222D8cQ8b && this.f7225DG07BK != null) {
                this.f7221D8MqeW = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
                this.f7222D8cQ8b = true;
            }
            if (this.f7222D8cQ8b) {
                this.f7221D8MqeW.setTintList(this.f7225DG07BK);
            }
        }
    }

    public final void CNPG0E() {
        Drawable drawable = this.f7228DV2E8K;
        if (drawable != null) {
            if (!this.f7229DXnQ0V && this.DXuj49 != null) {
                this.f7228DV2E8K = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
                this.f7229DXnQ0V = true;
            }
            if (this.f7229DXnQ0V) {
                this.f7228DV2E8K.setTintList(this.DXuj49);
            }
        }
    }

    public final void COJEAR() {
        Drawable drawable = this.f7226DRlcZ9;
        if (drawable != null) {
            if (!this.f7227DUi7mC && this.DXuj49 != null) {
                this.f7226DRlcZ9 = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
                this.f7227DUi7mC = true;
            }
            if (this.f7227DUi7mC) {
                this.f7226DRlcZ9.setTintList(this.DXuj49);
            }
        }
    }

    public final void CQhlFr(boolean z) {
        int paddingTop;
        int paddingBottom;
        boolean z2;
        if (B3GDIM()) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i = paddingBottom + paddingTop;
        int max = Math.max(this.f7206CQhlFr, Math.max(this.f7209CcAIMM + i, this.f7212CkXcdM + i));
        boolean z3 = false;
        if (max == this.f7207CSDoyG) {
            z2 = false;
        } else {
            this.f7207CSDoyG = max;
            z2 = true;
        }
        int max2 = Math.max(Math.max(Math.max((this.f7211CikNvS / 2) - this.f7200BniPrB, 0), Math.max((this.f7209CcAIMM - this.BpkvW3) / 2, 0)), Math.max(Math.max(this.f7244EUIRHA - this.f7201C2rE4F, 0), Math.max(this.f7245EY4UKY - this.f7202C4FrIb, 0))) + this.f7199BmvVmW;
        if (this.f7210Cd8JRx != max2) {
            this.f7210Cd8JRx = max2;
            if (isLaidOut()) {
                this.EdQ5bb = Math.max((B3GDIM() ? getHeight() : getWidth()) - (this.f7210Cd8JRx * 2), 0);
                BniPrB();
            }
            z3 = true;
        }
        if (B3GDIM()) {
            float A5SV6n2 = A5SV6n();
            Matrix matrix = this.f7261FZu94u;
            matrix.reset();
            matrix.setRotate(90.0f, A5SV6n2, A5SV6n2);
        }
        if (z2 || z) {
            requestLayout();
        } else if (z3) {
            postInvalidate();
        }
    }

    public final void CSDoyG() {
        if (this.f7247EiK8oA) {
            if (this.f7236DuwtYk >= this.f7237DvK7DB) {
                throw new IllegalStateException("valueFrom(" + this.f7236DuwtYk + ") must be smaller than valueTo(" + this.f7237DvK7DB + ")");
            }
            Iterator it = this.f7238DyaChj.iterator();
            while (it.hasNext()) {
                Float f = (Float) it.next();
                if (f.floatValue() < this.f7236DuwtYk || f.floatValue() > this.f7237DvK7DB) {
                    throw new IllegalStateException("Slider value(" + f + ") must be greater or equal to valueFrom(" + this.f7236DuwtYk + "), and lower or equal to valueTo(" + this.f7237DvK7DB + ")");
                }
                if (this.f7241EH1KK8 > 0.0f && !CTkVKb(f.floatValue())) {
                    float f2 = this.f7236DuwtYk;
                    float f3 = this.f7241EH1KK8;
                    throw new IllegalStateException("Value(" + f + ") must be equal to valueFrom(" + f2 + ") plus a multiple of stepSize(" + f3 + ") when using stepSize(" + f3 + ")");
                }
            }
            if (this.f7241EH1KK8 > 0.0f && !CTkVKb(this.f7237DvK7DB)) {
                throw new IllegalStateException("The stepSize(" + this.f7241EH1KK8 + ") must be 0, or a factor of the valueFrom(" + this.f7236DuwtYk + ")-valueTo(" + this.f7237DvK7DB + ") range");
            }
            float minSeparation = getMinSeparation();
            if (minSeparation < 0.0f) {
                throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
            }
            float f4 = this.f7241EH1KK8;
            if (f4 > 0.0f && minSeparation > 0.0f) {
                if (this.f7266FpcJKS != 1) {
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + this.f7241EH1KK8 + ")");
                }
                if (minSeparation < f4 || !AmA8tU(minSeparation)) {
                    float f5 = this.f7241EH1KK8;
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + f5 + ") when using stepSize(" + f5 + ")");
                }
            }
            if (this.f7241EH1KK8 != 0.0f) {
                int i = (((int) r0) > this.f7237DvK7DB ? 1 : (((int) r0) == this.f7237DvK7DB ? 0 : -1));
            }
            this.f7247EiK8oA = false;
        }
    }

    public final boolean CTkVKb(float f) {
        return AmA8tU(new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.f7236DuwtYk)), MathContext.DECIMAL64).doubleValue());
    }

    public final float CcAIMM(float f) {
        return (B9tovu(f) * this.EdQ5bb) + this.f7210Cd8JRx;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f7188B4ZgIw.AlLFFp(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f7181AcNBzu.setColor(AlLFFp(this.f7252EwN40Z));
        this.f7182AlLFFp.setColor(AlLFFp(this.f7251EsrwYR));
        this.f7185B25kr6.setColor(AlLFFp(this.f7250ErKPGd));
        this.f7186B2KMhB.setColor(AlLFFp(this.f7249EmJGcg));
        this.f7187B3GDIM.setColor(AlLFFp(this.f7250ErKPGd));
        Iterator it = this.f7192BI9f7h.iterator();
        while (it.hasNext()) {
            PcHFaG.A4TApA a4TApA = (PcHFaG.A4TApA) it.next();
            if (a4TApA.isStateful()) {
                a4TApA.setState(getDrawableState());
            }
        }
        AaHO0E aaHO0E = this.f7262FdMWEC;
        if (aaHO0E.isStateful()) {
            aaHO0E.setState(getDrawableState());
        }
        Paint paint = this.f7184AzWtSf;
        paint.setColor(AlLFFp(this.f7248EicXu4));
        paint.setAlpha(63);
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f7188B4ZgIw.f1828AaHO0E;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public abstract int getThumbRadius();

    public abstract int getTrackCornerSize();

    public List<Float> getValues() {
        return new ArrayList(this.f7238DyaChj);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7269GEYgCP = isShown();
        getViewTreeObserver().addOnScrollChangedListener(this.G16Pvp);
        getViewTreeObserver().addOnGlobalLayoutListener(this.G2rdQT);
        Iterator it = this.f7192BI9f7h.iterator();
        while (it.hasNext()) {
            PcHFaG.A4TApA a4TApA = (PcHFaG.A4TApA) it.next();
            ViewGroup AZkASS2 = C4FrIb.AZkASS(this);
            if (AZkASS2 == null) {
                a4TApA.getClass();
            } else {
                a4TApA.getClass();
                int[] iArr = new int[2];
                AZkASS2.getLocationOnScreen(iArr);
                a4TApA.f7421DG07BK = iArr[0];
                AZkASS2.getWindowVisibleDisplayFrame(a4TApA.f7414D07BeM);
                AZkASS2.addOnLayoutChangeListener(a4TApA.f7413CtxOCS);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        C4FrIb.A4TApA a4TApA = this.f7190B9tovu;
        if (a4TApA != null) {
            removeCallbacks(a4TApA);
        }
        this.f7195BNL6CD = false;
        Iterator it = this.f7192BI9f7h.iterator();
        while (it.hasNext()) {
            PcHFaG.A4TApA a4TApA2 = (PcHFaG.A4TApA) it.next();
            ViewGroup AZkASS2 = C4FrIb.AZkASS(this);
            if (AZkASS2 != null) {
                AZkASS2.getOverlay().remove(a4TApA2);
                AZkASS2.removeOnLayoutChangeListener(a4TApA2.f7413CtxOCS);
            }
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.G16Pvp);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.G2rdQT);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0295  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: PSeUZ5.ADYaiT.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        A4TApA a4TApA = this.f7188B4ZgIw;
        if (!z) {
            this.f7239ECyGFg = -1;
            a4TApA.AZkASS(this.f7240EGM26s);
            return;
        }
        if (i == 1) {
            B4ZgIw(Integer.MAX_VALUE);
        } else if (i == 2) {
            B4ZgIw(Integer.MIN_VALUE);
        } else if (i == 17) {
            B7CMnp(Integer.MAX_VALUE);
        } else if (i == 66) {
            B7CMnp(Integer.MIN_VALUE);
        }
        a4TApA.BI9f7h(this.f7240EGM26s);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(false);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f7238DyaChj.size() == 1) {
            this.f7239ECyGFg = 0;
        }
        Float f = null;
        Boolean valueOf = null;
        f = null;
        f = null;
        if (this.f7239ECyGFg == -1) {
            if (i != 61) {
                if (i != 66) {
                    if (i != 81) {
                        if (i == 69) {
                            B4ZgIw(-1);
                            valueOf = Boolean.TRUE;
                        } else if (i != 70) {
                            switch (i) {
                                case 21:
                                    B7CMnp(-1);
                                    valueOf = Boolean.TRUE;
                                    break;
                                case 22:
                                    B7CMnp(1);
                                    valueOf = Boolean.TRUE;
                                    break;
                            }
                        }
                    }
                    B4ZgIw(1);
                    valueOf = Boolean.TRUE;
                }
                this.f7239ECyGFg = this.f7240EGM26s;
                postInvalidate();
                valueOf = Boolean.TRUE;
            } else {
                valueOf = keyEvent.hasNoModifiers() ? Boolean.valueOf(B4ZgIw(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(B4ZgIw(-1)) : Boolean.FALSE;
            }
            return valueOf != null ? valueOf.booleanValue() : super.onKeyDown(i, keyEvent);
        }
        boolean isLongPress = this.f7246EdhSi6 | keyEvent.isLongPress();
        this.f7246EdhSi6 = isLongPress;
        if (isLongPress) {
            float f2 = this.f7241EH1KK8;
            r10 = f2 != 0.0f ? f2 : 1.0f;
            if ((this.f7237DvK7DB - this.f7236DuwtYk) / r10 > 20) {
                r10 *= Math.round(r0 / r11);
            }
        } else {
            float f3 = this.f7241EH1KK8;
            if (f3 != 0.0f) {
                r10 = f3;
            }
        }
        if (i == 69) {
            f = Float.valueOf(-r10);
        } else if (i != 70 && i != 81) {
            switch (i) {
                case 19:
                    if (B3GDIM()) {
                        f = Float.valueOf(r10);
                        break;
                    }
                    break;
                case 20:
                    if (B3GDIM()) {
                        f = Float.valueOf(-r10);
                        break;
                    }
                    break;
                case 21:
                    if (!B2KMhB()) {
                        r10 = -r10;
                    }
                    f = Float.valueOf(r10);
                    break;
                case 22:
                    if (B2KMhB()) {
                        r10 = -r10;
                    }
                    f = Float.valueOf(r10);
                    break;
            }
        } else {
            f = Float.valueOf(r10);
        }
        if (f != null) {
            if (BJ7GGh(f.floatValue() + ((Float) this.f7238DyaChj.get(this.f7239ECyGFg)).floatValue(), this.f7239ECyGFg)) {
                BTvldC();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return B4ZgIw(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return B4ZgIw(-1);
                }
                return false;
            }
            if (i != 66) {
                return super.onKeyDown(i, keyEvent);
            }
        }
        this.f7239ECyGFg = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.f7246EdhSi6 = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3 = this.f7208CTkVKb;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f7207CSDoyG + ((i3 == 1 || i3 == 3) ? ((PcHFaG.A4TApA) this.f7192BI9f7h.get(0)).getIntrinsicHeight() : 0), 1073741824);
        if (B3GDIM()) {
            super.onMeasure(makeMeasureSpec, i2);
        } else {
            super.onMeasure(i, makeMeasureSpec);
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        A5SV6n a5SV6n = (A5SV6n) parcelable;
        super.onRestoreInstanceState(a5SV6n.getSuperState());
        this.f7236DuwtYk = a5SV6n.f7175AcNBzu;
        this.f7237DvK7DB = a5SV6n.f7176AlLFFp;
        BIYEnU(a5SV6n.f7177AmA8tU);
        this.f7241EH1KK8 = a5SV6n.f7178AzWtSf;
        if (a5SV6n.f7179B25kr6) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        A5SV6n a5SV6n = new A5SV6n(super.onSaveInstanceState());
        a5SV6n.f7175AcNBzu = this.f7236DuwtYk;
        a5SV6n.f7176AlLFFp = this.f7237DvK7DB;
        a5SV6n.f7177AmA8tU = new ArrayList(this.f7238DyaChj);
        a5SV6n.f7178AzWtSf = this.f7241EH1KK8;
        a5SV6n.f7179B25kr6 = hasFocus();
        return a5SV6n;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        if (B3GDIM()) {
            i = i2;
        }
        this.EdQ5bb = Math.max(i - (this.f7210Cd8JRx * 2), 0);
        BniPrB();
        BTvldC();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        if (r3 != 3) goto L87;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: PSeUZ5.ADYaiT.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        this.f7269GEYgCP = z;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            ViewGroup AZkASS2 = C4FrIb.AZkASS(this);
            ViewOverlay overlay = AZkASS2 == null ? null : AZkASS2.getOverlay();
            if (overlay == null) {
                return;
            }
            Iterator it = this.f7192BI9f7h.iterator();
            while (it.hasNext()) {
                overlay.remove((PcHFaG.A4TApA) it.next());
            }
        }
    }

    public void setActiveThumbIndex(int i) {
        this.f7239ECyGFg = i;
    }

    public abstract void setCentered(boolean z);

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public abstract void setHaloRadius(int i);

    public abstract void setHaloTintList(ColorStateList colorStateList);

    public abstract void setLabelBehavior(int i);

    public abstract void setOrientation(int i);

    public void setSeparationUnit(int i) {
        this.f7266FpcJKS = i;
        this.f7247EiK8oA = true;
        postInvalidate();
    }

    public abstract void setThumbElevation(float f);

    public abstract void setThumbHeight(int i);

    public abstract void setThumbStrokeColor(ColorStateList colorStateList);

    public abstract void setThumbStrokeWidth(float f);

    public abstract void setThumbTrackGapSize(int i);

    public abstract void setThumbWidth(int i);

    public abstract void setTickActiveRadius(int i);

    public abstract void setTickActiveTintList(ColorStateList colorStateList);

    public abstract void setTickInactiveRadius(int i);

    public abstract void setTickInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackActiveTintList(ColorStateList colorStateList);

    public abstract void setTrackCornerSize(int i);

    public abstract void setTrackHeight(int i);

    public abstract void setTrackIconActiveColor(ColorStateList colorStateList);

    public abstract void setTrackIconActiveEnd(Drawable drawable);

    public abstract void setTrackIconActiveStart(Drawable drawable);

    public abstract void setTrackIconInactiveColor(ColorStateList colorStateList);

    public abstract void setTrackIconInactiveEnd(Drawable drawable);

    public abstract void setTrackIconInactiveStart(Drawable drawable);

    public abstract void setTrackIconSize(int i);

    public abstract void setTrackInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackInsideCornerSize(int i);

    public abstract void setTrackStopIndicatorSize(int i);

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        BIYEnU(arrayList);
    }

    public void setValues(List<Float> list) {
        BIYEnU(new ArrayList(list));
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.f7263Ff5QvW = null;
        this.f7264Fmmv0E = new ArrayList();
        for (Drawable drawable : drawableArr) {
            List list = this.f7264Fmmv0E;
            Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
            A2egSU(newDrawable);
            list.add(newDrawable);
        }
        postInvalidate();
    }
}
