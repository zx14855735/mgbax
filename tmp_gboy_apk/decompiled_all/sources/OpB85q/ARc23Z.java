package OpB85q;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.BaselineLayout;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ARc23Z extends FrameLayout implements AZOQYO {

    /* renamed from: DuwtYk, reason: collision with root package name */
    public static final int[] f6665DuwtYk = {R.attr.state_checked};

    /* renamed from: DvK7DB, reason: collision with root package name */
    public static final OLy1FW.AzWtSf f6666DvK7DB = new OLy1FW.AzWtSf(3, (byte) 0);

    /* renamed from: DyaChj, reason: collision with root package name */
    public static final AMqCpz f6667DyaChj = new AMqCpz(3, (byte) 0);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f6668AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ColorStateList f6669AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Drawable f6670AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f6671AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f6672B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f6673B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f6674B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public float f6675B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public float f6676B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public float f6677B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public float f6678BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public float f6679BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public float f6680BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f6681BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f6682BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final LinearLayout f6683BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final LinearLayout f6684BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final View f6685BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final FrameLayout f6686BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final ImageView f6687BniPrB;
    public final BaselineLayout BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final TextView f6688C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final TextView f6689C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final BaselineLayout f6690CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final TextView f6691CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final TextView f6692COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public BaselineLayout f6693CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int f6694CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f6695CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f6696CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public int f6697Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public int f6698CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public ColorStateList f6699CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public boolean f6700CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public AZkASS.B25kr6 f6701CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public ColorStateList f6702CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public Drawable f6703CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public Drawable f6704CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public ValueAnimator f6705D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public OLy1FW.AzWtSf f6706D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public float f6707D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public boolean f6708D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public int f6709D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public int f6710D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public int f6711DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public int f6712DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public boolean f6713DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public int f6714DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public int f6715DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public NpX2pY.A2egSU f6716DXnQ0V;
    public int DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public int f6717DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public int f6718DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public boolean f6719DdagTj;
    public boolean Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public boolean f6720De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public boolean f6721DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public Rect f6722Dphsd2;

    static {
        HeGrj();
    }

    public ARc23Z(Context context) {
        super(context);
        this.f6668AcNBzu = false;
        this.f6694CSDoyG = -1;
        this.f6695CTkVKb = 0;
        this.f6696CcAIMM = 0;
        this.f6697Cd8JRx = 0;
        this.f6698CikNvS = 0;
        this.f6700CmUvjW = false;
        this.f6706D6DOie = f6666DvK7DB;
        this.f6707D6yqiO = 0.0f;
        this.f6708D8MqeW = false;
        this.f6709D8cQ8b = 0;
        this.f6710D9tr6l = 0;
        this.f6711DAk1zC = -2;
        this.f6712DG07BK = 0;
        this.f6713DRlcZ9 = false;
        this.f6714DUi7mC = 0;
        this.f6715DV2E8K = 0;
        this.f6717DaOi9o = 0;
        this.f6718DcUJf1 = 49;
        this.f6719DdagTj = false;
        this.Ddcejp = false;
        this.f6720De4eam = false;
        this.f6721DjONCG = false;
        this.f6722Dphsd2 = new Rect();
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f6683BPw6Q8 = (LinearLayout) findViewById(2131297691);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131297694);
        this.f6684BTvldC = linearLayout;
        this.f6685BV3sI0 = findViewById(2131297690);
        this.f6686BmvVmW = (FrameLayout) findViewById(2131297692);
        this.f6687BniPrB = (ImageView) findViewById(2131297693);
        BaselineLayout baselineLayout = (BaselineLayout) findViewById(2131297695);
        this.BpkvW3 = baselineLayout;
        TextView textView = (TextView) findViewById(2131297697);
        this.f6688C2rE4F = textView;
        TextView textView2 = (TextView) findViewById(2131297696);
        this.f6689C4FrIb = textView2;
        float dimension = getResources().getDimension(2131165284);
        float dimension2 = getResources().getDimension(2131165283);
        BaselineLayout baselineLayout2 = new BaselineLayout(getContext(), null, 0);
        baselineLayout2.f11685AcNBzu = -1;
        this.f6690CASmeH = baselineLayout2;
        baselineLayout2.setVisibility(8);
        this.f6690CASmeH.setDuplicateParentStateEnabled(true);
        this.f6690CASmeH.setMeasurePaddingFromBaseline(this.f6720De4eam);
        TextView textView3 = new TextView(getContext());
        this.f6691CNPG0E = textView3;
        textView3.setMaxLines(1);
        TextView textView4 = this.f6691CNPG0E;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.f6691CNPG0E.setDuplicateParentStateEnabled(true);
        this.f6691CNPG0E.setIncludeFontPadding(false);
        this.f6691CNPG0E.setGravity(16);
        this.f6691CNPG0E.setTextSize(dimension);
        TextView textView5 = new TextView(getContext());
        this.f6692COJEAR = textView5;
        textView5.setMaxLines(1);
        this.f6692COJEAR.setEllipsize(truncateAt);
        this.f6692COJEAR.setDuplicateParentStateEnabled(true);
        this.f6692COJEAR.setVisibility(4);
        this.f6692COJEAR.setIncludeFontPadding(false);
        this.f6692COJEAR.setGravity(16);
        this.f6692COJEAR.setTextSize(dimension2);
        this.f6690CASmeH.addView(this.f6691CNPG0E);
        this.f6690CASmeH.addView(this.f6692COJEAR);
        this.f6693CQhlFr = baselineLayout;
        setBackgroundResource(getItemBackgroundResId());
        this.f6671AzWtSf = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f6672B25kr6 = baselineLayout.getPaddingBottom();
        this.f6673B2KMhB = 0;
        this.f6674B3GDIM = 0;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        this.f6691CNPG0E.setImportantForAccessibility(2);
        this.f6692COJEAR.setImportantForAccessibility(2);
        setFocusable(true);
        A4TApA();
        this.f6712DG07BK = getResources().getDimensionPixelSize(2131166093);
        linearLayout.addOnLayoutChangeListener(new OCUYV2.A5SV6n(2, this));
    }

    public static void AZOQYO(int i, int i2, int i3, View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private static /* synthetic */ void HeGrj() {
        char[] charArray = ", \"a(.\"*a- 6a<'*##a\u0005!&\r=&+(*".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'O');
        }
        String str = new String(charArray);
        char[] charArray2 = ",#&!&;".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'O');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < indexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof ARc23Z) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private int getSuggestedIconWidth() {
        NpX2pY.A2egSU a2egSU = this.f6716DXnQ0V;
        int minimumWidth = a2egSU == null ? 0 : a2egSU.getMinimumWidth() - this.f6716DXnQ0V.f6076B25kr6.f6116A4TApA.f6106C4FrIb.intValue();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6686BmvVmW.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.f6687BniPrB.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    private void setLabelPivots(TextView textView) {
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
    }

    @Override // AZkASS.BPw6Q8
    public final void A2egSU(AZkASS.B25kr6 b25kr6) {
        this.f6701CqNSpT = b25kr6;
        setCheckable(b25kr6.isCheckable());
        setChecked(b25kr6.isChecked());
        setEnabled(b25kr6.isEnabled());
        setIcon(b25kr6.getIcon());
        setTitle(b25kr6.f524B25kr6);
        setId(b25kr6.f520AcNBzu);
        if (!TextUtils.isEmpty(b25kr6.f536BTvldC)) {
            setContentDescription(b25kr6.f536BTvldC);
        }
        CharSequence charSequence = !TextUtils.isEmpty(b25kr6.f537BV3sI0) ? b25kr6.f537BV3sI0 : b25kr6.f524B25kr6;
        if (Build.VERSION.SDK_INT > 23) {
            JrXYwF.A4TApA.DV2E8K(this, charSequence);
        }
        AcNBzu();
        this.f6668AcNBzu = true;
    }

    public final void A4TApA() {
        float textSize = this.f6688C2rE4F.getTextSize();
        float textSize2 = this.f6689C4FrIb.getTextSize();
        this.f6675B4ZgIw = textSize - textSize2;
        this.f6676B7CMnp = (textSize2 * 1.0f) / textSize;
        this.f6677B9tovu = (textSize * 1.0f) / textSize2;
        float textSize3 = this.f6691CNPG0E.getTextSize();
        float textSize4 = this.f6692COJEAR.getTextSize();
        this.f6678BChYOn = textSize3 - textSize4;
        this.f6679BI9f7h = (textSize4 * 1.0f) / textSize3;
        this.f6680BIYEnU = (textSize3 * 1.0f) / textSize4;
    }

    public final void A5SV6n() {
        Drawable drawable = this.f6670AmA8tU;
        RippleDrawable rippleDrawable = null;
        boolean z = true;
        if (this.f6669AlLFFp != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.f6708D8MqeW && getActiveIndicatorDrawable() != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(P5yM7D.A4TApA.A5SV6n(this.f6669AlLFFp), null, activeIndicatorDrawable);
                z = false;
            } else if (drawable == null) {
                drawable = new RippleDrawable(P5yM7D.A4TApA.A2egSU(this.f6669AlLFFp), null, null);
            }
        }
        FrameLayout frameLayout = this.f6686BmvVmW;
        frameLayout.setPadding(0, 0, 0, 0);
        frameLayout.setForeground(rippleDrawable);
        setBackground(drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z);
        }
    }

    public final void ADYaiT(float f, float f2) {
        OLy1FW.AzWtSf azWtSf = this.f6706D6DOie;
        azWtSf.getClass();
        float A2egSU2 = NdEzCJ.A2egSU.A2egSU(0.4f, 1.0f, f);
        View view = this.f6685BV3sI0;
        view.setScaleX(A2egSU2);
        view.setScaleY(azWtSf.ADYaiT(f));
        view.setAlpha(NdEzCJ.A2egSU.A4TApA(0.0f, 1.0f, f2 == 0.0f ? 0.8f : 0.0f, f2 == 0.0f ? 1.0f : 0.2f, f));
        this.f6707D6yqiO = f;
    }

    public final void AMqCpz() {
        int i = this.f6687BniPrB.getLayoutParams().width > 0 ? this.f6674B3GDIM : 0;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6690CASmeH.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.rightMargin = getLayoutDirection() == 1 ? i : 0;
            layoutParams.leftMargin = getLayoutDirection() != 1 ? i : 0;
        }
    }

    public final void ARc23Z(TextView textView, TextView textView2, float f, float f2) {
        AZOQYO(this.DXuj49 == 0 ? (int) (this.f6671AzWtSf + f2) : 0, 0, this.f6718DcUJf1, this.f6683BPw6Q8);
        int i = this.DXuj49;
        AZOQYO(i == 0 ? 0 : this.f6722Dphsd2.top, i == 0 ? 0 : this.f6722Dphsd2.bottom, i == 0 ? 17 : 8388627, this.f6684BTvldC);
        int i2 = this.f6672B25kr6;
        BaselineLayout baselineLayout = this.BpkvW3;
        baselineLayout.setPadding(baselineLayout.getPaddingLeft(), baselineLayout.getPaddingTop(), baselineLayout.getPaddingRight(), i2);
        this.f6693CQhlFr.setVisibility(0);
        textView.setScaleX(1.0f);
        textView.setScaleY(1.0f);
        textView.setVisibility(0);
        textView2.setScaleX(f);
        textView2.setScaleY(f);
        textView2.setVisibility(4);
    }

    public final void ASJ6gh() {
        int i = this.f6671AzWtSf;
        AZOQYO(i, i, this.DXuj49 == 0 ? 17 : this.f6718DcUJf1, this.f6683BPw6Q8);
        AZOQYO(0, 0, 17, this.f6684BTvldC);
        BaselineLayout baselineLayout = this.BpkvW3;
        baselineLayout.setPadding(baselineLayout.getPaddingLeft(), baselineLayout.getPaddingTop(), baselineLayout.getPaddingRight(), 0);
        this.f6693CQhlFr.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AYUAbz(android.widget.TextView r5, int r6) {
        /*
            r4 = this;
            boolean r0 = r4.f6721DjONCG
            if (r0 == 0) goto L8
            JrXYwF.A4TApA.DRlcZ9(r5, r6)
            return
        L8:
            JrXYwF.A4TApA.DRlcZ9(r5, r6)
            android.content.Context r0 = r5.getContext()
            r1 = 0
            if (r6 != 0) goto L13
            goto L27
        L13:
            int[] r2 = androidx.appcompat.R$styleable.f8036BIYEnU
            android.content.res.TypedArray r6 = r0.obtainStyledAttributes(r6, r2)
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            boolean r3 = r6.getValue(r1, r2)
            r6.recycle()
            if (r3 != 0) goto L29
        L27:
            r6 = 0
            goto L60
        L29:
            int r6 = android.os.Build.VERSION.SDK_INT
            r3 = 22
            if (r6 < r3) goto L34
            int r6 = BPw6Q8.AMqCpz.A5SV6n(r2)
            goto L38
        L34:
            int r6 = r2.data
            r6 = r6 & 15
        L38:
            r3 = 2
            if (r6 != r3) goto L52
            int r6 = r2.data
            float r6 = android.util.TypedValue.complexToFloat(r6)
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r6 = r6 * r0
            int r6 = java.lang.Math.round(r6)
            goto L60
        L52:
            int r6 = r2.data
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r6 = android.util.TypedValue.complexToDimensionPixelSize(r6, r0)
        L60:
            if (r6 == 0) goto L66
            float r6 = (float) r6
            r5.setTextSize(r1, r6)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: OpB85q.ARc23Z.AYUAbz(android.widget.TextView, int):void");
    }

    public final void AZkASS(int i) {
        if (i > 0 || getVisibility() != 0) {
            int min = Math.min(this.f6709D8cQ8b, i - (this.f6714DUi7mC * 2));
            int i2 = this.f6710D9tr6l;
            if (this.DXuj49 == 1) {
                int i3 = i - (this.f6715DV2E8K * 2);
                int i4 = this.f6711DAk1zC;
                if (i4 != -1) {
                    i3 = i4 == -2 ? this.f6683BPw6Q8.getMeasuredWidth() : Math.min(i4, i3);
                }
                min = i3;
                i2 = Math.max(this.f6712DG07BK, this.f6684BTvldC.getMeasuredHeight());
            }
            View view = this.f6685BV3sI0;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (this.f6713DRlcZ9 && this.f6681BJ7GGh == 2) {
                i2 = min;
            }
            layoutParams.height = i2;
            layoutParams.width = Math.max(0, min);
            view.setLayoutParams(layoutParams);
        }
    }

    public final void AaHO0E(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        AYUAbz(textView, i);
        A4TApA();
        textView.setMinimumHeight(com.bumptech.glide.AMqCpz.BmvVmW(textView.getContext(), i));
        ColorStateList colorStateList = this.f6699CkXcdM;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.f6689C4FrIb;
        textView2.setTypeface(textView2.getTypeface(), this.f6700CmUvjW ? 1 : 0);
        TextView textView3 = this.f6692COJEAR;
        textView3.setTypeface(textView3.getTypeface(), this.f6700CmUvjW ? 1 : 0);
    }

    public final void AcNBzu() {
        AZkASS.B25kr6 b25kr6 = this.f6701CqNSpT;
        if (b25kr6 != null) {
            setVisibility((!b25kr6.isVisible() || (!this.f6719DdagTj && this.Ddcejp)) ? 8 : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f6708D8MqeW) {
            this.f6686BmvVmW.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Drawable getActiveIndicatorDrawable() {
        return this.f6685BV3sI0.getBackground();
    }

    public NpX2pY.A2egSU getBadge() {
        return this.f6716DXnQ0V;
    }

    public BaselineLayout getExpandedLabelGroup() {
        return this.f6690CASmeH;
    }

    public int getItemBackgroundResId() {
        return 2131231380;
    }

    @Override // AZkASS.BPw6Q8
    public AZkASS.B25kr6 getItemData() {
        return this.f6701CqNSpT;
    }

    public int getItemDefaultMarginResId() {
        return 2131166462;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f6694CSDoyG;
    }

    public BaselineLayout getLabelGroup() {
        return this.BpkvW3;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        LinearLayout linearLayout = this.f6683BPw6Q8;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        return linearLayout.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        if (this.DXuj49 == 1) {
            LinearLayout linearLayout = this.f6684BTvldC;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            return linearLayout.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        BaselineLayout baselineLayout = this.BpkvW3;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) baselineLayout.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), baselineLayout.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        AZkASS.B25kr6 b25kr6 = this.f6701CqNSpT;
        if (b25kr6 != null && b25kr6.isCheckable() && this.f6701CqNSpT.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f6665DuwtYk);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        NpX2pY.A2egSU a2egSU = this.f6716DXnQ0V;
        if (a2egSU != null && a2egSU.isVisible()) {
            AZkASS.B25kr6 b25kr6 = this.f6701CqNSpT;
            CharSequence charSequence = b25kr6.f524B25kr6;
            if (!TextUtils.isEmpty(b25kr6.f536BTvldC)) {
                charSequence = this.f6701CqNSpT.f536BTvldC;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.f6716DXnQ0V.ADYaiT()));
        }
        accessibilityNodeInfo.setCollectionItemInfo(CQhlFr.ASJ6gh.A2egSU(0, 1, getItemVisiblePosition(), 1, false, isSelected()).f1771A2egSU);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) CQhlFr.A5SV6n.f1758ASJ6gh.f1767A2egSU);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(2131886389));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new C4FrIb.A4TApA(i, 4, this));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        this.f6685BV3sI0.setBackground(drawable);
        A5SV6n();
    }

    public void setActiveIndicatorEnabled(boolean z) {
        this.f6708D8MqeW = z;
        A5SV6n();
        this.f6685BV3sI0.setVisibility(z ? 0 : 8);
        requestLayout();
    }

    public void setActiveIndicatorExpandedHeight(int i) {
        this.f6712DG07BK = i;
        AZkASS(getWidth());
    }

    public void setActiveIndicatorExpandedMarginHorizontal(int i) {
        this.f6715DV2E8K = i;
        if (this.DXuj49 == 1) {
            setPadding(i, 0, i, 0);
        }
        AZkASS(getWidth());
    }

    public void setActiveIndicatorExpandedPadding(Rect rect) {
        this.f6722Dphsd2 = rect;
    }

    public void setActiveIndicatorExpandedWidth(int i) {
        this.f6711DAk1zC = i;
        AZkASS(getWidth());
    }

    public void setActiveIndicatorHeight(int i) {
        this.f6710D9tr6l = i;
        AZkASS(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i) {
        if (this.f6673B2KMhB != i) {
            this.f6673B2KMhB = i;
            ((LinearLayout.LayoutParams) this.BpkvW3.getLayoutParams()).topMargin = i;
            if (this.f6690CASmeH.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6690CASmeH.getLayoutParams();
                layoutParams.rightMargin = getLayoutDirection() == 1 ? i : 0;
                if (getLayoutDirection() == 1) {
                    i = 0;
                }
                layoutParams.leftMargin = i;
                requestLayout();
            }
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i) {
        this.f6714DUi7mC = i;
        AZkASS(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z) {
        this.f6713DRlcZ9 = z;
    }

    public void setActiveIndicatorWidth(int i) {
        this.f6709D8cQ8b = i;
        AZkASS(getWidth());
    }

    public void setBadge(NpX2pY.A2egSU a2egSU) {
        NpX2pY.A2egSU a2egSU2 = this.f6716DXnQ0V;
        if (a2egSU2 == a2egSU) {
            return;
        }
        boolean z = a2egSU2 != null;
        ImageView imageView = this.f6687BniPrB;
        if (z && imageView != null && a2egSU2 != null) {
            setClipChildren(true);
            setClipToPadding(true);
            NpX2pY.A2egSU a2egSU3 = this.f6716DXnQ0V;
            if (a2egSU3 != null) {
                if (a2egSU3.AMqCpz() != null) {
                    a2egSU3.AMqCpz().setForeground(null);
                } else {
                    imageView.getOverlay().remove(a2egSU3);
                }
            }
            this.f6716DXnQ0V = null;
        }
        this.f6716DXnQ0V = a2egSU;
        int i = this.f6717DaOi9o;
        NpX2pY.A5SV6n a5SV6n = a2egSU.f6076B25kr6;
        if (a5SV6n.f6125AcNBzu != i) {
            a5SV6n.f6125AcNBzu = i;
            a2egSU.AaHO0E();
        }
        if (imageView == null || this.f6716DXnQ0V == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        NpX2pY.A2egSU a2egSU4 = this.f6716DXnQ0V;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        a2egSU4.setBounds(rect);
        a2egSU4.AZkASS(imageView, null);
        if (a2egSU4.AMqCpz() != null) {
            a2egSU4.AMqCpz().setForeground(a2egSU4);
        } else {
            imageView.getOverlay().add(a2egSU4);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.f6689C4FrIb;
        setLabelPivots(textView);
        TextView textView2 = this.f6688C2rE4F;
        setLabelPivots(textView2);
        TextView textView3 = this.f6692COJEAR;
        setLabelPivots(textView3);
        TextView textView4 = this.f6691CNPG0E;
        setLabelPivots(textView4);
        float f = z ? 1.0f : 0.0f;
        if (this.f6708D8MqeW && this.f6668AcNBzu && isAttachedToWindow()) {
            ValueAnimator valueAnimator = this.f6705D07BeM;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f6705D07BeM = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f6707D6yqiO, f);
            this.f6705D07BeM = ofFloat;
            ofFloat.addUpdateListener(new ADYaiT(this, f));
            this.f6705D07BeM.setInterpolator(com.bumptech.glide.A5SV6n.D6DOie(getContext(), 2130969633, NdEzCJ.A2egSU.f6037A4TApA));
            this.f6705D07BeM.setDuration(com.bumptech.glide.A5SV6n.D07BeM(getContext(), 2130969617, getResources().getInteger(2131361834)));
            this.f6705D07BeM.start();
        } else {
            ADYaiT(f, f);
        }
        float f2 = this.f6675B4ZgIw;
        float f3 = this.f6676B7CMnp;
        float f4 = this.f6677B9tovu;
        if (this.DXuj49 == 1) {
            f2 = this.f6678BChYOn;
            f3 = this.f6679BI9f7h;
            f4 = this.f6680BIYEnU;
            textView = textView3;
            textView2 = textView4;
        }
        int i = this.f6681BJ7GGh;
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        ASJ6gh();
                    }
                } else if (z) {
                    ARc23Z(textView, textView2, f3, f2);
                } else {
                    ARc23Z(textView2, textView, f4, 0.0f);
                }
            } else if (z) {
                ARc23Z(textView, textView2, f3, 0.0f);
            } else {
                ASJ6gh();
            }
        } else if (this.f6682BNL6CD) {
            if (z) {
                ARc23Z(textView, textView2, f3, 0.0f);
            } else {
                ASJ6gh();
            }
        } else if (z) {
            ARc23Z(textView, textView2, f3, f2);
        } else {
            ARc23Z(textView2, textView, f4, 0.0f);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6688C2rE4F.setEnabled(z);
        this.f6689C4FrIb.setEnabled(z);
        this.f6691CNPG0E.setEnabled(z);
        this.f6692COJEAR.setEnabled(z);
        this.f6687BniPrB.setEnabled(z);
    }

    @Override // OpB85q.AZOQYO
    public void setExpanded(boolean z) {
        this.f6719DdagTj = z;
        AcNBzu();
    }

    public void setHorizontalTextAppearanceActive(int i) {
        this.f6697Cd8JRx = i;
        TextView textView = this.f6692COJEAR;
        if (i == 0) {
            i = this.f6695CTkVKb;
        }
        AaHO0E(textView, i);
    }

    public void setHorizontalTextAppearanceInactive(int i) {
        this.f6698CikNvS = i;
        TextView textView = this.f6691CNPG0E;
        if (i == 0) {
            i = this.f6696CcAIMM;
        }
        if (textView == null) {
            return;
        }
        AYUAbz(textView, i);
        A4TApA();
        textView.setMinimumHeight(com.bumptech.glide.AMqCpz.BmvVmW(textView.getContext(), i));
        ColorStateList colorStateList = this.f6699CkXcdM;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.f6703CtFAbx) {
            return;
        }
        this.f6703CtFAbx = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
            this.f6704CtxOCS = drawable;
            ColorStateList colorStateList = this.f6702CrfGsy;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.f6687BniPrB.setImageDrawable(drawable);
    }

    public void setIconLabelHorizontalSpacing(int i) {
        if (this.f6674B3GDIM != i) {
            this.f6674B3GDIM = i;
            AMqCpz();
            requestLayout();
        }
    }

    public void setIconSize(int i) {
        ImageView imageView = this.f6687BniPrB;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        imageView.setLayoutParams(layoutParams);
        AMqCpz();
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f6702CrfGsy = colorStateList;
        if (this.f6701CqNSpT == null || (drawable = this.f6704CtxOCS) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.f6704CtxOCS.invalidateSelf();
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : getContext().getDrawable(i));
    }

    public void setItemGravity(int i) {
        this.f6718DcUJf1 = i;
        requestLayout();
    }

    public void setItemIconGravity(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.DXuj49 != i) {
            this.DXuj49 = i;
            this.f6717DaOi9o = 0;
            BaselineLayout baselineLayout = this.BpkvW3;
            this.f6693CQhlFr = baselineLayout;
            LinearLayout linearLayout = this.f6684BTvldC;
            int i8 = 8;
            if (i == 1) {
                if (this.f6690CASmeH.getParent() == null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    linearLayout.addView(this.f6690CASmeH, layoutParams);
                    AMqCpz();
                }
                Rect rect = this.f6722Dphsd2;
                int i9 = rect.left;
                int i10 = rect.right;
                int i11 = rect.top;
                i2 = rect.bottom;
                this.f6717DaOi9o = 1;
                int i12 = this.f6715DV2E8K;
                this.f6693CQhlFr = this.f6690CASmeH;
                i7 = i11;
                i6 = i10;
                i5 = i9;
                i4 = i12;
                i3 = 0;
            } else {
                i2 = 0;
                i8 = 0;
                i3 = 8;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
            }
            baselineLayout.setVisibility(i8);
            this.f6690CASmeH.setVisibility(i3);
            ((FrameLayout.LayoutParams) this.f6683BPw6Q8.getLayoutParams()).gravity = this.f6718DcUJf1;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.leftMargin = i5;
            layoutParams2.rightMargin = i6;
            layoutParams2.topMargin = i7;
            layoutParams2.bottomMargin = i2;
            setPadding(i4, 0, i4, 0);
            AZkASS(getWidth());
            A5SV6n();
        }
    }

    public void setItemPaddingBottom(int i) {
        if (this.f6672B25kr6 != i) {
            this.f6672B25kr6 = i;
            AZkASS.B25kr6 b25kr6 = this.f6701CqNSpT;
            if (b25kr6 != null) {
                setChecked(b25kr6.isChecked());
            }
        }
    }

    public void setItemPaddingTop(int i) {
        if (this.f6671AzWtSf != i) {
            this.f6671AzWtSf = i;
            AZkASS.B25kr6 b25kr6 = this.f6701CqNSpT;
            if (b25kr6 != null) {
                setChecked(b25kr6.isChecked());
            }
        }
    }

    public void setItemPosition(int i) {
        this.f6694CSDoyG = i;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f6669AlLFFp = colorStateList;
        A5SV6n();
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.f6721DjONCG = z;
        setTextAppearanceActive(this.f6695CTkVKb);
        setTextAppearanceInactive(this.f6696CcAIMM);
        setHorizontalTextAppearanceActive(this.f6697Cd8JRx);
        setHorizontalTextAppearanceInactive(this.f6698CikNvS);
    }

    public void setLabelMaxLines(int i) {
        TextView textView = this.f6688C2rE4F;
        textView.setMaxLines(i);
        TextView textView2 = this.f6689C4FrIb;
        textView2.setMaxLines(i);
        this.f6691CNPG0E.setMaxLines(i);
        this.f6692COJEAR.setMaxLines(i);
        if (Build.VERSION.SDK_INT > 34) {
            textView.setGravity(17);
            textView2.setGravity(17);
        } else if (i > 1) {
            textView.setEllipsize(null);
            textView2.setEllipsize(null);
            textView.setGravity(17);
            textView2.setGravity(17);
        } else {
            textView.setGravity(16);
            textView2.setGravity(16);
        }
        requestLayout();
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f6681BJ7GGh != i) {
            this.f6681BJ7GGh = i;
            if (this.f6713DRlcZ9 && i == 2) {
                this.f6706D6DOie = f6667DyaChj;
            } else {
                this.f6706D6DOie = f6666DvK7DB;
            }
            AZkASS(getWidth());
            AZkASS.B25kr6 b25kr6 = this.f6701CqNSpT;
            if (b25kr6 != null) {
                setChecked(b25kr6.isChecked());
            }
        }
    }

    public void setMeasureBottomPaddingFromLabelBaseline(boolean z) {
        this.f6720De4eam = z;
        this.BpkvW3.setMeasurePaddingFromBaseline(z);
        this.f6688C2rE4F.setIncludeFontPadding(z);
        this.f6689C4FrIb.setIncludeFontPadding(z);
        this.f6690CASmeH.setMeasurePaddingFromBaseline(z);
        this.f6691CNPG0E.setIncludeFontPadding(z);
        this.f6692COJEAR.setIncludeFontPadding(z);
        requestLayout();
    }

    @Override // OpB85q.AZOQYO
    public void setOnlyShowWhenExpanded(boolean z) {
        this.Ddcejp = z;
        AcNBzu();
    }

    public void setShifting(boolean z) {
        if (this.f6682BNL6CD != z) {
            this.f6682BNL6CD = z;
            AZkASS.B25kr6 b25kr6 = this.f6701CqNSpT;
            if (b25kr6 != null) {
                setChecked(b25kr6.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i) {
        this.f6695CTkVKb = i;
        AaHO0E(this.f6689C4FrIb, i);
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z) {
        this.f6700CmUvjW = z;
        setTextAppearanceActive(this.f6695CTkVKb);
        setHorizontalTextAppearanceActive(this.f6697Cd8JRx);
        TextView textView = this.f6689C4FrIb;
        textView.setTypeface(textView.getTypeface(), this.f6700CmUvjW ? 1 : 0);
        TextView textView2 = this.f6692COJEAR;
        textView2.setTypeface(textView2.getTypeface(), this.f6700CmUvjW ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i) {
        this.f6696CcAIMM = i;
        TextView textView = this.f6688C2rE4F;
        if (textView == null) {
            return;
        }
        AYUAbz(textView, i);
        A4TApA();
        textView.setMinimumHeight(com.bumptech.glide.AMqCpz.BmvVmW(textView.getContext(), i));
        ColorStateList colorStateList = this.f6699CkXcdM;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f6699CkXcdM = colorStateList;
        if (colorStateList != null) {
            this.f6688C2rE4F.setTextColor(colorStateList);
            this.f6689C4FrIb.setTextColor(colorStateList);
            this.f6691CNPG0E.setTextColor(colorStateList);
            this.f6692COJEAR.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f6688C2rE4F.setText(charSequence);
        this.f6689C4FrIb.setText(charSequence);
        this.f6691CNPG0E.setText(charSequence);
        this.f6692COJEAR.setText(charSequence);
        AZkASS.B25kr6 b25kr6 = this.f6701CqNSpT;
        if (b25kr6 == null || TextUtils.isEmpty(b25kr6.f536BTvldC)) {
            setContentDescription(charSequence);
        }
        AZkASS.B25kr6 b25kr62 = this.f6701CqNSpT;
        if (b25kr62 != null && !TextUtils.isEmpty(b25kr62.f537BV3sI0)) {
            charSequence = this.f6701CqNSpT.f537BV3sI0;
        }
        if (Build.VERSION.SDK_INT > 23) {
            JrXYwF.A4TApA.DV2E8K(this, charSequence);
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f6670AmA8tU = drawable;
        A5SV6n();
    }
}
