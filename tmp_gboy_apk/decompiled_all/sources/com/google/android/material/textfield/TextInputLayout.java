package com.google.android.material.textfield;

import ADYaiT.CtFAbx;
import AaHO0E.BNL6CD;
import AaHO0E.EGM26s;
import AaHO0E.GYpKKt;
import COJEAR.AZOQYO;
import COJEAR.DG07BK;
import Cd8JRx.ADYaiT;
import DaOi9o.ASJ6gh;
import DaOi9o.BJ7GGh;
import JrXYwF.A4TApA;
import NOd7IU.AlLFFp;
import OLy1FW.AYUAbz;
import Oay4Bh.A5SV6n;
import Oay4Bh.BTvldC;
import Oay4Bh.BV3sI0;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import PWr3nF.ARc23Z;
import PWr3nF.AZkASS;
import PWr3nF.AcNBzu;
import PWr3nF.AmA8tU;
import PWr3nF.B3GDIM;
import PWr3nF.B9tovu;
import PWr3nF.BChYOn;
import PWr3nF.BI9f7h;
import PWr3nF.BIYEnU;
import PXXBzr.A2egSU;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.AMqCpz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: F32kj0, reason: collision with root package name */
    public static final int[][] f11906F32kj0 = {new int[]{R.attr.state_pressed}, new int[0]};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final FrameLayout f11907AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final B9tovu f11908AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AmA8tU f11909AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f11910AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public EditText f11911B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public CharSequence f11912B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f11913B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f11914B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f11915B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f11916B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final B3GDIM f11917BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f11918BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f11919BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f11920BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public BIYEnU f11921BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public AppCompatTextView f11922BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f11923BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f11924BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public CharSequence f11925BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f11926BniPrB;
    public AppCompatTextView BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public ColorStateList f11927C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public int f11928C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public ASJ6gh f11929CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public ASJ6gh f11930CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public ColorStateList f11931COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public ColorStateList f11932CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public ColorStateList f11933CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public ColorStateList f11934CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public boolean f11935CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public CharSequence f11936Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public boolean f11937CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public AaHO0E f11938CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public AaHO0E f11939CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public StateListDrawable f11940CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public boolean f11941CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public AaHO0E f11942CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public AaHO0E f11943CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public B2KMhB f11944D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public boolean f11945D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public final int f11946D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public int f11947D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public int f11948D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public int f11949D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public int f11950DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public int f11951DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public int f11952DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public int f11953DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public final Rect f11954DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public final Rect f11955DXnQ0V;
    public final RectF DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public Typeface f11956DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public ColorDrawable f11957DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public int f11958DdagTj;
    public final LinkedHashSet Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public ColorDrawable f11959De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public int f11960DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public Drawable f11961Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public ColorStateList f11962DuwtYk;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public ColorStateList f11963DvK7DB;

    /* renamed from: DyaChj, reason: collision with root package name */
    public int f11964DyaChj;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public int f11965ECyGFg;

    /* renamed from: EGM26s, reason: collision with root package name */
    public int f11966EGM26s;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public ColorStateList f11967EH1KK8;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public int f11968EPdU4G;

    /* renamed from: EQurEW, reason: collision with root package name */
    public int f11969EQurEW;

    /* renamed from: EUIRHA, reason: collision with root package name */
    public int f11970EUIRHA;

    /* renamed from: EY4UKY, reason: collision with root package name */
    public int f11971EY4UKY;
    public int EdQ5bb;

    /* renamed from: EdhSi6, reason: collision with root package name */
    public int f11972EdhSi6;

    /* renamed from: EiK8oA, reason: collision with root package name */
    public boolean f11973EiK8oA;

    /* renamed from: EicXu4, reason: collision with root package name */
    public final A5SV6n f11974EicXu4;

    /* renamed from: EmJGcg, reason: collision with root package name */
    public boolean f11975EmJGcg;

    /* renamed from: ErKPGd, reason: collision with root package name */
    public boolean f11976ErKPGd;

    /* renamed from: EsrwYR, reason: collision with root package name */
    public ValueAnimator f11977EsrwYR;

    /* renamed from: EwN40Z, reason: collision with root package name */
    public boolean f11978EwN40Z;

    /* renamed from: ExjC7D, reason: collision with root package name */
    public boolean f11979ExjC7D;

    /* renamed from: F1loUV, reason: collision with root package name */
    public boolean f11980F1loUV;

    static {
        SFIqoUs();
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130970065, 2131952608), attributeSet, 2130970065);
        this.f11913B3GDIM = -1;
        this.f11914B4ZgIw = -1;
        this.f11915B7CMnp = -1;
        this.f11916B9tovu = -1;
        this.f11917BChYOn = new B3GDIM(this);
        this.f11921BNL6CD = new AZOQYO(17);
        this.f11954DV2E8K = new Rect();
        this.f11955DXnQ0V = new Rect();
        this.DXuj49 = new RectF();
        this.Ddcejp = new LinkedHashSet();
        A5SV6n a5SV6n = new A5SV6n(this);
        this.f11974EicXu4 = a5SV6n;
        this.f11980F1loUV = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f11907AcNBzu = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = NdEzCJ.A2egSU.f6036A2egSU;
        a5SV6n.f6498CkXcdM = linearInterpolator;
        a5SV6n.AZkASS(false);
        a5SV6n.f6497CikNvS = linearInterpolator;
        a5SV6n.AZkASS(false);
        if (a5SV6n.f6462ASJ6gh != 8388659) {
            a5SV6n.f6462ASJ6gh = 8388659;
            a5SV6n.AZkASS(false);
        }
        GYpKKt AzWtSf2 = C4FrIb.AzWtSf(context2, attributeSet, R$styleable.f11264D9tr6l, 2130970065, 2131952608, 22, 20, 40, 45, 50);
        B9tovu b9tovu = new B9tovu(this, AzWtSf2);
        this.f11908AlLFFp = b9tovu;
        TypedArray typedArray = AzWtSf2.f884A4TApA;
        this.f11935CcAIMM = typedArray.getBoolean(48, true);
        setHint(typedArray.getText(4));
        this.f11976ErKPGd = typedArray.getBoolean(47, true);
        this.f11975EmJGcg = typedArray.getBoolean(42, true);
        if (typedArray.hasValue(6)) {
            setMinEms(typedArray.getInt(6, -1));
        } else if (typedArray.hasValue(3)) {
            setMinWidth(typedArray.getDimensionPixelSize(3, -1));
        }
        if (typedArray.hasValue(5)) {
            setMaxEms(typedArray.getInt(5, -1));
        } else if (typedArray.hasValue(2)) {
            setMaxWidth(typedArray.getDimensionPixelSize(2, -1));
        }
        this.f11944D07BeM = B2KMhB.A5SV6n(context2, attributeSet, 2130970065, 2131952608).A2egSU();
        this.f11946D6yqiO = context2.getResources().getDimensionPixelOffset(2131166520);
        this.f11948D8cQ8b = typedArray.getDimensionPixelOffset(9, 0);
        this.f11910AzWtSf = getResources().getDimensionPixelSize(2131166086);
        this.f11950DAk1zC = typedArray.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(2131166521));
        this.f11951DG07BK = typedArray.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(2131166522));
        this.f11949D9tr6l = this.f11950DAk1zC;
        float dimension = typedArray.getDimension(13, -1.0f);
        float dimension2 = typedArray.getDimension(12, -1.0f);
        float dimension3 = typedArray.getDimension(10, -1.0f);
        float dimension4 = typedArray.getDimension(11, -1.0f);
        B2KMhB.A2egSU ASJ6gh2 = this.f11944D07BeM.ASJ6gh();
        if (dimension >= 0.0f) {
            ASJ6gh2.ARc23Z(dimension);
        }
        if (dimension2 >= 0.0f) {
            ASJ6gh2.ASJ6gh(dimension2);
        }
        if (dimension3 >= 0.0f) {
            ASJ6gh2.AMqCpz(dimension3);
        }
        if (dimension4 >= 0.0f) {
            ASJ6gh2.ADYaiT(dimension4);
        }
        this.f11944D07BeM = ASJ6gh2.A2egSU();
        ColorStateList BNL6CD2 = AMqCpz.BNL6CD(context2, AzWtSf2, 7);
        if (BNL6CD2 != null) {
            int defaultColor = BNL6CD2.getDefaultColor();
            this.f11968EPdU4G = defaultColor;
            this.f11953DUi7mC = defaultColor;
            if (BNL6CD2.isStateful()) {
                this.f11969EQurEW = BNL6CD2.getColorForState(new int[]{-16842910}, -1);
                this.f11970EUIRHA = BNL6CD2.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f11971EY4UKY = BNL6CD2.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f11970EUIRHA = this.f11968EPdU4G;
                ColorStateList A5SV6n2 = BPw6Q8.ASJ6gh.A5SV6n(context2, 2131100588);
                this.f11969EQurEW = A5SV6n2.getColorForState(new int[]{-16842910}, -1);
                this.f11971EY4UKY = A5SV6n2.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f11953DUi7mC = 0;
            this.f11968EPdU4G = 0;
            this.f11969EQurEW = 0;
            this.f11970EUIRHA = 0;
            this.f11971EY4UKY = 0;
        }
        if (typedArray.hasValue(1)) {
            ColorStateList A2egSU2 = AzWtSf2.A2egSU(1);
            this.f11963DvK7DB = A2egSU2;
            this.f11962DuwtYk = A2egSU2;
        }
        ColorStateList BNL6CD3 = AMqCpz.BNL6CD(context2, AzWtSf2, 14);
        this.f11966EGM26s = typedArray.getColor(14, 0);
        this.f11964DyaChj = BPw6Q8.ASJ6gh.A4TApA(context2, 2131100615);
        this.EdQ5bb = BPw6Q8.ASJ6gh.A4TApA(context2, 2131100616);
        this.f11965ECyGFg = BPw6Q8.ASJ6gh.A4TApA(context2, 2131100619);
        if (BNL6CD3 != null) {
            setBoxStrokeColorStateList(BNL6CD3);
        }
        if (typedArray.hasValue(15)) {
            setBoxStrokeErrorColor(AMqCpz.BNL6CD(context2, AzWtSf2, 15));
        }
        if (typedArray.getResourceId(50, -1) != -1) {
            setHintTextAppearance(typedArray.getResourceId(50, 0));
        }
        this.f11933CSDoyG = AzWtSf2.A2egSU(24);
        this.f11934CTkVKb = AzWtSf2.A2egSU(25);
        int resourceId = typedArray.getResourceId(40, 0);
        CharSequence text = typedArray.getText(35);
        int i = typedArray.getInt(34, 1);
        boolean z = typedArray.getBoolean(36, false);
        int resourceId2 = typedArray.getResourceId(45, 0);
        boolean z2 = typedArray.getBoolean(44, false);
        CharSequence text2 = typedArray.getText(43);
        int resourceId3 = typedArray.getResourceId(58, 0);
        CharSequence text3 = typedArray.getText(57);
        boolean z3 = typedArray.getBoolean(18, false);
        setCounterMaxLength(typedArray.getInt(19, -1));
        this.f11924BV3sI0 = typedArray.getResourceId(22, 0);
        this.f11923BTvldC = typedArray.getResourceId(20, 0);
        setBoxBackgroundMode(typedArray.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i);
        setCounterOverflowTextAppearance(this.f11923BTvldC);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f11924BV3sI0);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArray.hasValue(41)) {
            setErrorTextColor(AzWtSf2.A2egSU(41));
        }
        if (typedArray.hasValue(46)) {
            setHelperTextColor(AzWtSf2.A2egSU(46));
        }
        if (typedArray.hasValue(51)) {
            setHintTextColor(AzWtSf2.A2egSU(51));
        }
        if (typedArray.hasValue(23)) {
            setCounterTextColor(AzWtSf2.A2egSU(23));
        }
        if (typedArray.hasValue(21)) {
            setCounterOverflowTextColor(AzWtSf2.A2egSU(21));
        }
        if (typedArray.hasValue(59)) {
            setPlaceholderTextColor(AzWtSf2.A2egSU(59));
        }
        AmA8tU amA8tU = new AmA8tU(this, AzWtSf2);
        this.f11909AmA8tU = amA8tU;
        boolean z4 = typedArray.getBoolean(0, true);
        setHintMaxLines(typedArray.getInt(49, 1));
        AzWtSf2.ASJ6gh();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(b9tovu);
        frameLayout.addView(amA8tU);
        addView(frameLayout);
        setEnabled(z4);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
    }

    public static void AlLFFp(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                AlLFFp((ViewGroup) childAt, z);
            }
        }
    }

    private static /* synthetic */ void SFIqoUs() {
        char[] charArray = "æêè«âäèà«çêü«öíàéé«ÏëìÇ÷ìáâà".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 133);
        }
        String str = new String(charArray);
        char[] charArray2 = "æéìëìñ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 133);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f11911B25kr6;
        if (!(editText instanceof AutoCompleteTextView) || AMqCpz.CASmeH(editText)) {
            return this.f11938CkXcdM;
        }
        int ASJ6gh2 = AYUAbz.ASJ6gh(2130968853, this.f11911B25kr6);
        int i = this.f11947D8MqeW;
        int[][] iArr = f11906F32kj0;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            AaHO0E aaHO0E = this.f11938CkXcdM;
            int i2 = this.f11953DUi7mC;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{AYUAbz.AaHO0E(0.1f, ASJ6gh2, i2), i2}), aaHO0E, aaHO0E);
        }
        Context context = getContext();
        AaHO0E aaHO0E2 = this.f11938CkXcdM;
        int AZOQYO2 = AYUAbz.AZOQYO(context, 2130968895, "TextInputLayout");
        AaHO0E aaHO0E3 = new AaHO0E(aaHO0E2.f7042AlLFFp.f7021A2egSU);
        int AaHO0E2 = AYUAbz.AaHO0E(0.1f, ASJ6gh2, AZOQYO2);
        aaHO0E3.B3GDIM(new ColorStateList(iArr, new int[]{AaHO0E2, 0}));
        aaHO0E3.setTint(AZOQYO2);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{AaHO0E2, AZOQYO2});
        AaHO0E aaHO0E4 = new AaHO0E(aaHO0E2.f7042AlLFFp.f7021A2egSU);
        aaHO0E4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, aaHO0E3, aaHO0E4), aaHO0E2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f11940CqNSpT == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f11940CqNSpT = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f11940CqNSpT.addState(new int[0], AYUAbz(false));
        }
        return this.f11940CqNSpT;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f11939CmUvjW == null) {
            this.f11939CmUvjW = AYUAbz(true);
        }
        return this.f11939CmUvjW;
    }

    private void setEditText(EditText editText) {
        if (this.f11911B25kr6 != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3) {
            boolean z = editText instanceof TextInputEditText;
        }
        this.f11911B25kr6 = editText;
        int i = this.f11913B3GDIM;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.f11915B7CMnp);
        }
        int i2 = this.f11914B4ZgIw;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.f11916B9tovu);
        }
        this.f11941CrfGsy = false;
        AaHO0E();
        setTextInputAccessibilityDelegate(new BI9f7h(this));
        Typeface typeface = this.f11911B25kr6.getTypeface();
        A5SV6n a5SV6n = this.f11974EicXu4;
        a5SV6n.AmA8tU(typeface);
        float textSize = this.f11911B25kr6.getTextSize();
        if (a5SV6n.f6463AYUAbz != textSize) {
            a5SV6n.f6463AYUAbz = textSize;
            a5SV6n.AZkASS(false);
        }
        float letterSpacing = this.f11911B25kr6.getLetterSpacing();
        if (a5SV6n.f6504D07BeM != letterSpacing) {
            a5SV6n.f6504D07BeM = letterSpacing;
            a5SV6n.AZkASS(false);
        }
        int gravity = this.f11911B25kr6.getGravity();
        int i3 = (gravity & (-113)) | 48;
        if (a5SV6n.f6462ASJ6gh != i3) {
            a5SV6n.f6462ASJ6gh = i3;
            a5SV6n.AZkASS(false);
        }
        if (a5SV6n.f6461ARc23Z != gravity) {
            a5SV6n.f6461ARc23Z = gravity;
            a5SV6n.AZkASS(false);
        }
        this.f11972EdhSi6 = editText.getMinimumHeight();
        this.f11911B25kr6.addTextChangedListener(new BChYOn(this, editText));
        if (this.f11962DuwtYk == null) {
            this.f11962DuwtYk = this.f11911B25kr6.getHintTextColors();
        }
        if (this.f11935CcAIMM) {
            if (TextUtils.isEmpty(this.f11936Cd8JRx)) {
                CharSequence hint = this.f11911B25kr6.getHint();
                this.f11912B2KMhB = hint;
                setHint(hint);
                this.f11911B25kr6.setHint((CharSequence) null);
            }
            this.f11937CikNvS = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            B3GDIM();
        }
        if (this.f11922BPw6Q8 != null) {
            B25kr6(this.f11911B25kr6.getText());
        }
        B7CMnp();
        this.f11917BChYOn.A4TApA();
        this.f11908AlLFFp.bringToFront();
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.bringToFront();
        Iterator it = this.Ddcejp.iterator();
        while (it.hasNext()) {
            ((AcNBzu) it.next()).A2egSU(this);
        }
        amA8tU.AlLFFp();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        BI9f7h(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f11936Cd8JRx)) {
            return;
        }
        this.f11936Cd8JRx = charSequence;
        A5SV6n a5SV6n = this.f11974EicXu4;
        if (charSequence == null || !TextUtils.equals(a5SV6n.f6483BTvldC, charSequence)) {
            a5SV6n.f6483BTvldC = charSequence;
            a5SV6n.f6484BV3sI0 = null;
            a5SV6n.AZkASS(false);
        }
        if (this.f11973EiK8oA) {
            return;
        }
        AcNBzu();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.f11926BniPrB == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = this.BpkvW3;
            if (appCompatTextView != null) {
                this.f11907AcNBzu.addView(appCompatTextView);
                this.BpkvW3.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.BpkvW3;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.BpkvW3 = null;
        }
        this.f11926BniPrB = z;
    }

    public final void A2egSU() {
        if (this.f11911B25kr6 != null) {
            if (this.f11947D8MqeW != 1) {
                return;
            }
            if (!(getHintMaxLines() == 1)) {
                EditText editText = this.f11911B25kr6;
                editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.f11974EicXu4.ARc23Z() + this.f11910AzWtSf), this.f11911B25kr6.getPaddingEnd(), getResources().getDimensionPixelSize(2131166314));
            } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText2 = this.f11911B25kr6;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(2131166317), this.f11911B25kr6.getPaddingEnd(), getResources().getDimensionPixelSize(2131166316));
            } else if (AMqCpz.CNPG0E(getContext())) {
                EditText editText3 = this.f11911B25kr6;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(2131166315), this.f11911B25kr6.getPaddingEnd(), getResources().getDimensionPixelSize(2131166314));
            }
        }
    }

    public final void A4TApA(float f) {
        A5SV6n a5SV6n = this.f11974EicXu4;
        if (a5SV6n.f6458A4TApA == f) {
            return;
        }
        if (this.f11977EsrwYR == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f11977EsrwYR = valueAnimator;
            valueAnimator.setInterpolator(com.bumptech.glide.A5SV6n.D6DOie(getContext(), 2130969633, NdEzCJ.A2egSU.f6037A4TApA));
            this.f11977EsrwYR.setDuration(com.bumptech.glide.A5SV6n.D07BeM(getContext(), 2130969623, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION));
            this.f11977EsrwYR.addUpdateListener(new O1Vn2F.A2egSU(3, this));
        }
        this.f11977EsrwYR.setFloatValues(a5SV6n.f6458A4TApA, f);
        this.f11977EsrwYR.start();
    }

    public final void A5SV6n() {
        int i;
        int i2;
        AaHO0E aaHO0E = this.f11938CkXcdM;
        if (aaHO0E == null) {
            return;
        }
        B2KMhB b2KMhB = aaHO0E.f7042AlLFFp.f7021A2egSU;
        B2KMhB b2KMhB2 = this.f11944D07BeM;
        if (b2KMhB != b2KMhB2) {
            aaHO0E.setShapeAppearanceModel(b2KMhB2);
        }
        if (this.f11947D8MqeW == 2 && (i = this.f11949D9tr6l) > -1 && (i2 = this.f11952DRlcZ9) != 0) {
            AaHO0E aaHO0E2 = this.f11938CkXcdM;
            aaHO0E2.BJ7GGh(i);
            aaHO0E2.BIYEnU(ColorStateList.valueOf(i2));
        }
        int i3 = this.f11953DUi7mC;
        if (this.f11947D8MqeW == 1) {
            i3 = BV3sI0.A2egSU.A5SV6n(this.f11953DUi7mC, AYUAbz.AYUAbz(getContext(), 2130968895, 0));
        }
        this.f11953DUi7mC = i3;
        this.f11938CkXcdM.B3GDIM(ColorStateList.valueOf(i3));
        AaHO0E aaHO0E3 = this.f11942CtFAbx;
        if (aaHO0E3 != null && this.f11943CtxOCS != null) {
            if (this.f11949D9tr6l > -1 && this.f11952DRlcZ9 != 0) {
                aaHO0E3.B3GDIM(this.f11911B25kr6.isFocused() ? ColorStateList.valueOf(this.f11964DyaChj) : ColorStateList.valueOf(this.f11952DRlcZ9));
                this.f11943CtxOCS.B3GDIM(ColorStateList.valueOf(this.f11952DRlcZ9));
            }
            invalidate();
        }
        B9tovu();
    }

    public final Rect ADYaiT(Rect rect) {
        if (this.f11911B25kr6 == null) {
            throw new IllegalStateException();
        }
        boolean z = getLayoutDirection() == 1;
        int i = rect.bottom;
        Rect rect2 = this.f11955DXnQ0V;
        rect2.bottom = i;
        int i2 = this.f11947D8MqeW;
        if (i2 == 1) {
            rect2.left = AZOQYO(rect.left, z);
            rect2.top = rect.top + this.f11948D8cQ8b;
            rect2.right = AZkASS(rect.right, z);
            return rect2;
        }
        if (i2 != 2) {
            rect2.left = AZOQYO(rect.left, z);
            rect2.top = getPaddingTop();
            rect2.right = AZkASS(rect.right, z);
            return rect2;
        }
        rect2.left = this.f11911B25kr6.getPaddingLeft() + rect.left;
        rect2.top = rect.top - AMqCpz();
        rect2.right = rect.right - this.f11911B25kr6.getPaddingRight();
        return rect2;
    }

    public final int AMqCpz() {
        if (this.f11935CcAIMM) {
            int i = this.f11947D8MqeW;
            A5SV6n a5SV6n = this.f11974EicXu4;
            if (i == 0) {
                return (int) a5SV6n.ARc23Z();
            }
            if (i == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (a5SV6n.ARc23Z() / 2.0f);
                }
                float ARc23Z2 = a5SV6n.ARc23Z();
                TextPaint textPaint = a5SV6n.f6496Cd8JRx;
                textPaint.setTextSize(a5SV6n.f6464AZOQYO);
                textPaint.setTypeface(a5SV6n.f6474B4ZgIw);
                textPaint.setLetterSpacing(a5SV6n.f6503CtxOCS);
                return Math.max(0, (int) (ARc23Z2 - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final ASJ6gh ARc23Z() {
        ASJ6gh aSJ6gh = new ASJ6gh();
        aSJ6gh.f2240AmA8tU = com.bumptech.glide.A5SV6n.D07BeM(getContext(), 2130969625, 87);
        aSJ6gh.f2241AzWtSf = com.bumptech.glide.A5SV6n.D6DOie(getContext(), 2130969635, NdEzCJ.A2egSU.f6036A2egSU);
        return aSJ6gh;
    }

    public final boolean ASJ6gh() {
        return this.f11935CcAIMM && !TextUtils.isEmpty(this.f11936Cd8JRx) && (this.f11938CkXcdM instanceof PWr3nF.ASJ6gh);
    }

    public final AaHO0E AYUAbz(boolean z) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(2131166494);
        float f = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f11911B25kr6;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : getResources().getDimensionPixelOffset(2131165904);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(2131166431);
        B2KMhB.A2egSU a2egSU = new B2KMhB.A2egSU();
        a2egSU.ARc23Z(f);
        a2egSU.ASJ6gh(f);
        a2egSU.ADYaiT(dimensionPixelOffset);
        a2egSU.AMqCpz(dimensionPixelOffset);
        B2KMhB A2egSU2 = a2egSU.A2egSU();
        EditText editText2 = this.f11911B25kr6;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = AaHO0E.f7039CikNvS;
            dropDownBackgroundTintList = ColorStateList.valueOf(AYUAbz.AZOQYO(context, 2130968895, AaHO0E.class.getSimpleName()));
        }
        AaHO0E aaHO0E = new AaHO0E();
        aaHO0E.AmA8tU(context);
        aaHO0E.B3GDIM(dropDownBackgroundTintList);
        aaHO0E.B2KMhB(popupElevation);
        aaHO0E.setShapeAppearanceModel(A2egSU2);
        PCV8se.AZOQYO azoqyo = aaHO0E.f7042AlLFFp;
        if (azoqyo.f7027AYUAbz == null) {
            azoqyo.f7027AYUAbz = new Rect();
        }
        aaHO0E.f7042AlLFFp.f7027AYUAbz.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        aaHO0E.invalidateSelf();
        return aaHO0E;
    }

    public final int AZOQYO(int i, boolean z) {
        return ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.f11911B25kr6.getCompoundPaddingLeft() : this.f11909AmA8tU.A5SV6n() : this.f11908AlLFFp.A2egSU()) + i;
    }

    public final int AZkASS(int i, boolean z) {
        return i - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.f11911B25kr6.getCompoundPaddingRight() : this.f11908AlLFFp.A2egSU() : this.f11909AmA8tU.A5SV6n());
    }

    public final void AaHO0E() {
        int i = this.f11947D8MqeW;
        if (i == 0) {
            this.f11938CkXcdM = null;
            this.f11942CtFAbx = null;
            this.f11943CtxOCS = null;
        } else if (i == 1) {
            this.f11938CkXcdM = new AaHO0E(this.f11944D07BeM);
            this.f11942CtFAbx = new AaHO0E();
            this.f11943CtxOCS = new AaHO0E();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(CtFAbx.AZkASS(" is illegal; only @BoxBackgroundMode constants are supported.", this.f11947D8MqeW, new StringBuilder()));
            }
            if (!this.f11935CcAIMM || (this.f11938CkXcdM instanceof PWr3nF.ASJ6gh)) {
                this.f11938CkXcdM = new AaHO0E(this.f11944D07BeM);
            } else {
                B2KMhB b2KMhB = this.f11944D07BeM;
                int i2 = PWr3nF.ASJ6gh.f7305CqNSpT;
                if (b2KMhB == null) {
                    b2KMhB = new B2KMhB();
                }
                ARc23Z aRc23Z = new ARc23Z(b2KMhB, new RectF());
                PWr3nF.ASJ6gh aSJ6gh = new PWr3nF.ASJ6gh(aRc23Z);
                aSJ6gh.f7306CmUvjW = aRc23Z;
                this.f11938CkXcdM = aSJ6gh;
            }
            this.f11942CtFAbx = null;
            this.f11943CtxOCS = null;
        }
        B9tovu();
        BNL6CD();
        if (this.f11947D8MqeW == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.f11948D8cQ8b = getResources().getDimensionPixelSize(2131166319);
            } else if (AMqCpz.CNPG0E(getContext())) {
                this.f11948D8cQ8b = getResources().getDimensionPixelSize(2131166318);
            }
        }
        A2egSU();
        if (this.f11947D8MqeW != 0) {
            BChYOn();
        }
        EditText editText = this.f11911B25kr6;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i3 = this.f11947D8MqeW;
                if (i3 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i3 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AcNBzu() {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.AcNBzu():void");
    }

    public final void AmA8tU(AppCompatTextView appCompatTextView, int i) {
        try {
            A4TApA.DRlcZ9(appCompatTextView, i);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
            A4TApA.DRlcZ9(appCompatTextView, 2131952142);
            appCompatTextView.setTextColor(BPw6Q8.ASJ6gh.A4TApA(getContext(), 2131099738));
        }
    }

    public final boolean AzWtSf() {
        B3GDIM b3gdim = this.f11917BChYOn;
        return (b3gdim.f7371AzWtSf != 1 || b3gdim.f7374B3GDIM == null || TextUtils.isEmpty(b3gdim.f7372B25kr6)) ? false : true;
    }

    public final void B25kr6(Editable editable) {
        ((AZOQYO) this.f11921BNL6CD).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z = this.f11920BJ7GGh;
        int i = this.f11919BIYEnU;
        String str = null;
        if (i == -1) {
            this.f11922BPw6Q8.setText(String.valueOf(length));
            this.f11922BPw6Q8.setContentDescription(null);
            this.f11920BJ7GGh = false;
        } else {
            this.f11920BJ7GGh = length > i;
            Context context = getContext();
            this.f11922BPw6Q8.setContentDescription(context.getString(this.f11920BJ7GGh ? 2131886170 : 2131886169, Integer.valueOf(length), Integer.valueOf(this.f11919BIYEnU)));
            if (z != this.f11920BJ7GGh) {
                B2KMhB();
            }
            CASmeH.A5SV6n A5SV6n2 = CASmeH.A5SV6n.A5SV6n();
            AppCompatTextView appCompatTextView = this.f11922BPw6Q8;
            String string = getContext().getString(2131886171, Integer.valueOf(length), Integer.valueOf(this.f11919BIYEnU));
            if (string == null) {
                A5SV6n2.getClass();
            } else {
                str = A5SV6n2.ADYaiT(string, A5SV6n2.f1599A5SV6n).toString();
            }
            appCompatTextView.setText(str);
        }
        if (this.f11911B25kr6 == null || z == this.f11920BJ7GGh) {
            return;
        }
        BI9f7h(false, false);
        BNL6CD();
        B7CMnp();
    }

    public final void B2KMhB() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.f11922BPw6Q8;
        if (appCompatTextView != null) {
            AmA8tU(appCompatTextView, this.f11920BJ7GGh ? this.f11923BTvldC : this.f11924BV3sI0);
            if (!this.f11920BJ7GGh && (colorStateList2 = this.f11931COJEAR) != null) {
                this.f11922BPw6Q8.setTextColor(colorStateList2);
            }
            if (!this.f11920BJ7GGh || (colorStateList = this.f11932CQhlFr) == null) {
                return;
            }
            this.f11922BPw6Q8.setTextColor(colorStateList);
        }
    }

    public final void B3GDIM() {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f11933CSDoyG;
        if (colorStateList2 == null) {
            Context context = getContext();
            TypedValue A2egSU2 = P3rngT.A4TApA.A2egSU(context, 2130968852);
            if (A2egSU2 != null) {
                int i = A2egSU2.resourceId;
                if (i != 0) {
                    colorStateList2 = BPw6Q8.ASJ6gh.A5SV6n(context, i);
                } else {
                    int i2 = A2egSU2.data;
                    if (i2 != 0) {
                        colorStateList2 = ColorStateList.valueOf(i2);
                    }
                }
            }
            colorStateList2 = null;
        }
        EditText editText = this.f11911B25kr6;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable == null) {
                return;
            }
            textCursorDrawable2 = this.f11911B25kr6.getTextCursorDrawable();
            Drawable mutate = com.bumptech.glide.A5SV6n.DvK7DB(textCursorDrawable2).mutate();
            if ((AzWtSf() || (this.f11922BPw6Q8 != null && this.f11920BJ7GGh)) && (colorStateList = this.f11934CTkVKb) != null) {
                colorStateList2 = colorStateList;
            }
            mutate.setTintList(colorStateList2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B4ZgIw() {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.B4ZgIw():boolean");
    }

    public final void B7CMnp() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.f11911B25kr6;
        if (editText == null || this.f11947D8MqeW != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = EGM26s.f762A2egSU;
        Drawable mutate = background.mutate();
        if (AzWtSf()) {
            mutate.setColorFilter(BNL6CD.A5SV6n(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f11920BJ7GGh && (appCompatTextView = this.f11922BPw6Q8) != null) {
            mutate.setColorFilter(BNL6CD.A5SV6n(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            com.bumptech.glide.A5SV6n.B7CMnp(mutate);
            this.f11911B25kr6.refreshDrawableState();
        }
    }

    public final void B9tovu() {
        EditText editText = this.f11911B25kr6;
        if (editText == null || this.f11938CkXcdM == null) {
            return;
        }
        if ((this.f11941CrfGsy || editText.getBackground() == null) && this.f11947D8MqeW != 0) {
            this.f11911B25kr6.setBackground(getEditTextBoxBackground());
            this.f11941CrfGsy = true;
        }
    }

    public final void BChYOn() {
        if (this.f11947D8MqeW != 1) {
            FrameLayout frameLayout = this.f11907AcNBzu;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int AMqCpz = AMqCpz();
            if (AMqCpz != layoutParams.topMargin) {
                layoutParams.topMargin = AMqCpz;
                frameLayout.requestLayout();
            }
        }
    }

    public final void BI9f7h(boolean z, boolean z2) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f11911B25kr6;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f11911B25kr6;
        boolean z4 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f11962DuwtYk;
        A5SV6n a5SV6n = this.f11974EicXu4;
        if (colorStateList2 != null) {
            a5SV6n.AaHO0E(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f11962DuwtYk;
            a5SV6n.AaHO0E(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.EdQ5bb) : this.EdQ5bb));
        } else if (AzWtSf()) {
            AppCompatTextView appCompatTextView2 = this.f11917BChYOn.f7374B3GDIM;
            a5SV6n.AaHO0E(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.f11920BJ7GGh && (appCompatTextView = this.f11922BPw6Q8) != null) {
            a5SV6n.AaHO0E(appCompatTextView.getTextColors());
        } else if (z4 && (colorStateList = this.f11963DvK7DB) != null && a5SV6n.f6466AaHO0E != colorStateList) {
            a5SV6n.f6466AaHO0E = colorStateList;
            a5SV6n.AZkASS(false);
        }
        AmA8tU amA8tU = this.f11909AmA8tU;
        B9tovu b9tovu = this.f11908AlLFFp;
        if (z3 || !this.f11975EmJGcg || (isEnabled() && z4)) {
            if (z2 || this.f11973EiK8oA) {
                ValueAnimator valueAnimator = this.f11977EsrwYR;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f11977EsrwYR.cancel();
                }
                if (z && this.f11976ErKPGd) {
                    A4TApA(1.0f);
                } else {
                    a5SV6n.AlLFFp(1.0f);
                }
                this.f11973EiK8oA = false;
                if (ASJ6gh()) {
                    AcNBzu();
                }
                EditText editText3 = this.f11911B25kr6;
                BIYEnU(editText3 != null ? editText3.getText() : null);
                b9tovu.f7399B9tovu = false;
                b9tovu.AMqCpz();
                amA8tU.f7345BV3sI0 = false;
                amA8tU.AmA8tU();
                return;
            }
            return;
        }
        if (z2 || !this.f11973EiK8oA) {
            ValueAnimator valueAnimator2 = this.f11977EsrwYR;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f11977EsrwYR.cancel();
            }
            if (z && this.f11976ErKPGd) {
                A4TApA(0.0f);
            } else {
                a5SV6n.AlLFFp(0.0f);
            }
            if (ASJ6gh() && !((PWr3nF.ASJ6gh) this.f11938CkXcdM).f7306CmUvjW.f7304B4ZgIw.isEmpty() && ASJ6gh()) {
                ((PWr3nF.ASJ6gh) this.f11938CkXcdM).BmvVmW(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f11973EiK8oA = true;
            AppCompatTextView appCompatTextView3 = this.BpkvW3;
            if (appCompatTextView3 != null && this.f11926BniPrB) {
                appCompatTextView3.setText((CharSequence) null);
                BJ7GGh.A2egSU(this.f11907AcNBzu, this.f11930CNPG0E);
                this.BpkvW3.setVisibility(4);
            }
            b9tovu.f7399B9tovu = true;
            b9tovu.AMqCpz();
            amA8tU.f7345BV3sI0 = true;
            amA8tU.AmA8tU();
        }
    }

    public final void BIYEnU(Editable editable) {
        ((AZOQYO) this.f11921BNL6CD).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f11907AcNBzu;
        if (length != 0 || this.f11973EiK8oA) {
            AppCompatTextView appCompatTextView = this.BpkvW3;
            if (appCompatTextView == null || !this.f11926BniPrB) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            BJ7GGh.A2egSU(frameLayout, this.f11930CNPG0E);
            this.BpkvW3.setVisibility(4);
            return;
        }
        if (this.BpkvW3 == null || !this.f11926BniPrB || TextUtils.isEmpty(this.f11925BmvVmW)) {
            return;
        }
        this.BpkvW3.setText(this.f11925BmvVmW);
        BJ7GGh.A2egSU(frameLayout, this.f11929CASmeH);
        this.BpkvW3.setVisibility(0);
        this.BpkvW3.bringToFront();
    }

    public final void BJ7GGh(boolean z, boolean z2) {
        int defaultColor = this.f11967EH1KK8.getDefaultColor();
        int colorForState = this.f11967EH1KK8.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f11967EH1KK8.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.f11952DRlcZ9 = colorForState2;
        } else if (z2) {
            this.f11952DRlcZ9 = colorForState;
        } else {
            this.f11952DRlcZ9 = defaultColor;
        }
    }

    public final void BNL6CD() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.f11938CkXcdM == null || this.f11947D8MqeW == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.f11911B25kr6) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f11911B25kr6) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.f11952DRlcZ9 = this.EdQ5bb;
        } else if (AzWtSf()) {
            if (this.f11967EH1KK8 != null) {
                BJ7GGh(z2, z);
            } else {
                this.f11952DRlcZ9 = getErrorCurrentTextColors();
            }
        } else if (!this.f11920BJ7GGh || (appCompatTextView = this.f11922BPw6Q8) == null) {
            if (z2) {
                this.f11952DRlcZ9 = this.f11966EGM26s;
            } else if (z) {
                this.f11952DRlcZ9 = this.f11965ECyGFg;
            } else {
                this.f11952DRlcZ9 = this.f11964DyaChj;
            }
        } else if (this.f11967EH1KK8 != null) {
            BJ7GGh(z2, z);
        } else {
            this.f11952DRlcZ9 = appCompatTextView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            B3GDIM();
        }
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.AcNBzu();
        CheckableImageButton checkableImageButton = amA8tU.f7330AmA8tU;
        ColorStateList colorStateList = amA8tU.f7331AzWtSf;
        TextInputLayout textInputLayout = amA8tU.f7328AcNBzu;
        A4TApA.CrfGsy(textInputLayout, checkableImageButton, colorStateList);
        ColorStateList colorStateList2 = amA8tU.f7338BChYOn;
        CheckableImageButton checkableImageButton2 = amA8tU.f7334B3GDIM;
        A4TApA.CrfGsy(textInputLayout, checkableImageButton2, colorStateList2);
        if (amA8tU.A4TApA() instanceof AZkASS) {
            if (!textInputLayout.AzWtSf() || checkableImageButton2.getDrawable() == null) {
                A4TApA.AZOQYO(textInputLayout, checkableImageButton2, amA8tU.f7338BChYOn, amA8tU.f7339BI9f7h);
            } else {
                Drawable mutate = com.bumptech.glide.A5SV6n.DvK7DB(checkableImageButton2.getDrawable()).mutate();
                mutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton2.setImageDrawable(mutate);
            }
        }
        B9tovu b9tovu = this.f11908AlLFFp;
        A4TApA.CrfGsy(b9tovu.f7390AcNBzu, b9tovu.f7393AzWtSf, b9tovu.f7394B25kr6);
        if (this.f11947D8MqeW == 2) {
            int i = this.f11949D9tr6l;
            if (z2 && isEnabled()) {
                this.f11949D9tr6l = this.f11951DG07BK;
            } else {
                this.f11949D9tr6l = this.f11950DAk1zC;
            }
            if (this.f11949D9tr6l != i && ASJ6gh() && !this.f11973EiK8oA) {
                if (ASJ6gh()) {
                    ((PWr3nF.ASJ6gh) this.f11938CkXcdM).BmvVmW(0.0f, 0.0f, 0.0f, 0.0f);
                }
                AcNBzu();
            }
        }
        if (this.f11947D8MqeW == 1) {
            if (!isEnabled()) {
                this.f11953DUi7mC = this.f11969EQurEW;
            } else if (z && !z2) {
                this.f11953DUi7mC = this.f11971EY4UKY;
            } else if (z2) {
                this.f11953DUi7mC = this.f11970EUIRHA;
            } else {
                this.f11953DUi7mC = this.f11968EPdU4G;
            }
        }
        A5SV6n();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f11907AcNBzu;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        BChYOn();
        setEditText((EditText) view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.f11911B25kr6;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f11912B2KMhB != null) {
            boolean z = this.f11937CikNvS;
            this.f11937CikNvS = false;
            CharSequence hint = editText.getHint();
            this.f11911B25kr6.setHint(this.f11912B2KMhB);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f11911B25kr6.setHint(hint);
                this.f11937CikNvS = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.f11907AcNBzu;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            View childAt = frameLayout.getChildAt(i2);
            ViewStructure newChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(newChild, i);
            if (childAt == this.f11911B25kr6) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f11979ExjC7D = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f11979ExjC7D = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        AaHO0E aaHO0E;
        super.draw(canvas);
        boolean z = this.f11935CcAIMM;
        A5SV6n a5SV6n = this.f11974EicXu4;
        if (z) {
            a5SV6n.getClass();
            int save = canvas.save();
            if (a5SV6n.f6484BV3sI0 != null) {
                RectF rectF = a5SV6n.AMqCpz;
                if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                    TextPaint textPaint = a5SV6n.f6495CcAIMM;
                    textPaint.setTextSize(a5SV6n.f6487C2rE4F);
                    float f = a5SV6n.f6472B2KMhB;
                    float f2 = a5SV6n.f6473B3GDIM;
                    float f3 = a5SV6n.BpkvW3;
                    if (f3 != 1.0f) {
                        canvas.scale(f3, f3, f, f2);
                    }
                    if ((a5SV6n.f6511DG07BK > 1 || a5SV6n.f6512DRlcZ9 > 1) && !a5SV6n.f6485BmvVmW && a5SV6n.AzWtSf()) {
                        float lineStart = a5SV6n.f6472B2KMhB - a5SV6n.f6506D6yqiO.getLineStart(0);
                        int alpha = textPaint.getAlpha();
                        canvas.translate(lineStart, f2);
                        float f4 = alpha;
                        textPaint.setAlpha((int) (a5SV6n.f6509D9tr6l * f4));
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 31) {
                            textPaint.setShadowLayer(a5SV6n.f6488C4FrIb, a5SV6n.f6489CASmeH, a5SV6n.f6490CNPG0E, AYUAbz.ADYaiT(a5SV6n.f6491COJEAR, textPaint.getAlpha()));
                        }
                        a5SV6n.f6506D6yqiO.draw(canvas);
                        textPaint.setAlpha((int) (a5SV6n.f6508D8cQ8b * f4));
                        if (i >= 31) {
                            textPaint.setShadowLayer(a5SV6n.f6488C4FrIb, a5SV6n.f6489CASmeH, a5SV6n.f6490CNPG0E, AYUAbz.ADYaiT(a5SV6n.f6491COJEAR, textPaint.getAlpha()));
                        }
                        int lineBaseline = a5SV6n.f6506D6yqiO.getLineBaseline(0);
                        CharSequence charSequence = a5SV6n.f6510DAk1zC;
                        float f5 = lineBaseline;
                        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, textPaint);
                        if (i >= 31) {
                            textPaint.setShadowLayer(a5SV6n.f6488C4FrIb, a5SV6n.f6489CASmeH, a5SV6n.f6490CNPG0E, a5SV6n.f6491COJEAR);
                        }
                        String trim = a5SV6n.f6510DAk1zC.toString().trim();
                        if (trim.endsWith("…")) {
                            trim = CtFAbx.AMqCpz(1, 0, trim);
                        }
                        String str = trim;
                        textPaint.setAlpha(alpha);
                        canvas.drawText(str, 0, Math.min(a5SV6n.f6506D6yqiO.getLineEnd(0), str.length()), 0.0f, f5, (Paint) textPaint);
                        canvas = canvas;
                    } else {
                        canvas.translate(f, f2);
                        a5SV6n.f6506D6yqiO.draw(canvas);
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
        if (this.f11943CtxOCS == null || (aaHO0E = this.f11942CtFAbx) == null) {
            return;
        }
        aaHO0E.draw(canvas);
        if (this.f11911B25kr6.isFocused()) {
            Rect bounds = this.f11943CtxOCS.getBounds();
            Rect bounds2 = this.f11942CtFAbx.getBounds();
            float f6 = a5SV6n.f6458A4TApA;
            int centerX = bounds2.centerX();
            bounds.left = NdEzCJ.A2egSU.A5SV6n(f6, centerX, bounds2.left);
            bounds.right = NdEzCJ.A2egSU.A5SV6n(f6, centerX, bounds2.right);
            this.f11943CtxOCS.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.f11978EwN40Z
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.f11978EwN40Z = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            Oay4Bh.A5SV6n r3 = r4.f11974EicXu4
            if (r3 == 0) goto L2f
            r3.f6493CSDoyG = r1
            android.content.res.ColorStateList r1 = r3.f6466AaHO0E
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f6465AZkASS
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.AZkASS(r2)
            r1 = 1
            goto L30
        L2f:
            r1 = 0
        L30:
            android.widget.EditText r3 = r4.f11911B25kr6
            if (r3 == 0) goto L45
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L41
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L41
            goto L42
        L41:
            r0 = 0
        L42:
            r4.BI9f7h(r0, r2)
        L45:
            r4.B7CMnp()
            r4.BNL6CD()
            if (r1 == 0) goto L50
            r4.invalidate()
        L50:
            r4.f11978EwN40Z = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f11911B25kr6;
        if (editText == null) {
            return super.getBaseline();
        }
        return AMqCpz() + getPaddingTop() + editText.getBaseline();
    }

    public AaHO0E getBoxBackground() {
        int i = this.f11947D8MqeW;
        if (i == 1 || i == 2) {
            return this.f11938CkXcdM;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f11953DUi7mC;
    }

    public int getBoxBackgroundMode() {
        return this.f11947D8MqeW;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f11948D8cQ8b;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.DXuj49;
        return layoutDirection == 1 ? this.f11944D07BeM.f7089AYUAbz.A2egSU(rectF) : this.f11944D07BeM.f7088ASJ6gh.A2egSU(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.DXuj49;
        return layoutDirection == 1 ? this.f11944D07BeM.f7088ASJ6gh.A2egSU(rectF) : this.f11944D07BeM.f7089AYUAbz.A2egSU(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.DXuj49;
        return layoutDirection == 1 ? this.f11944D07BeM.AMqCpz.A2egSU(rectF) : this.f11944D07BeM.f7087ARc23Z.A2egSU(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.DXuj49;
        return layoutDirection == 1 ? this.f11944D07BeM.f7087ARc23Z.A2egSU(rectF) : this.f11944D07BeM.AMqCpz.A2egSU(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f11966EGM26s;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f11967EH1KK8;
    }

    public int getBoxStrokeWidth() {
        return this.f11950DAk1zC;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f11951DG07BK;
    }

    public int getCounterMaxLength() {
        return this.f11919BIYEnU;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.f11918BI9f7h && this.f11920BJ7GGh && (appCompatTextView = this.f11922BPw6Q8) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f11932CQhlFr;
    }

    public ColorStateList getCounterTextColor() {
        return this.f11931COJEAR;
    }

    public ColorStateList getCursorColor() {
        return this.f11933CSDoyG;
    }

    public ColorStateList getCursorErrorColor() {
        return this.f11934CTkVKb;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f11962DuwtYk;
    }

    public EditText getEditText() {
        return this.f11911B25kr6;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f11909AmA8tU.f7334B3GDIM.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f11909AmA8tU.f7334B3GDIM.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f11909AmA8tU.f7340BIYEnU;
    }

    public int getEndIconMode() {
        return this.f11909AmA8tU.f7336B7CMnp;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f11909AmA8tU.f7341BJ7GGh;
    }

    public CheckableImageButton getEndIconView() {
        return this.f11909AmA8tU.f7334B3GDIM;
    }

    public CharSequence getError() {
        B3GDIM b3gdim = this.f11917BChYOn;
        if (b3gdim.f7373B2KMhB) {
            return b3gdim.f7372B25kr6;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f11917BChYOn.f7376B7CMnp;
    }

    public CharSequence getErrorContentDescription() {
        return this.f11917BChYOn.f7375B4ZgIw;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.f11917BChYOn.f7374B3GDIM;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f11909AmA8tU.f7330AmA8tU.getDrawable();
    }

    public CharSequence getHelperText() {
        B3GDIM b3gdim = this.f11917BChYOn;
        if (b3gdim.f7380BIYEnU) {
            return b3gdim.f7379BI9f7h;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.f11917BChYOn.f7381BJ7GGh;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.f11935CcAIMM) {
            return this.f11936Cd8JRx;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f11974EicXu4.ARc23Z();
    }

    public final int getHintCurrentCollapsedTextColor() {
        A5SV6n a5SV6n = this.f11974EicXu4;
        return a5SV6n.ASJ6gh(a5SV6n.f6466AaHO0E);
    }

    public int getHintMaxLines() {
        return this.f11974EicXu4.f6511DG07BK;
    }

    public ColorStateList getHintTextColor() {
        return this.f11963DvK7DB;
    }

    public BIYEnU getLengthCounter() {
        return this.f11921BNL6CD;
    }

    public int getMaxEms() {
        return this.f11914B4ZgIw;
    }

    public int getMaxWidth() {
        return this.f11916B9tovu;
    }

    public int getMinEms() {
        return this.f11913B3GDIM;
    }

    public int getMinWidth() {
        return this.f11915B7CMnp;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f11909AmA8tU.f7334B3GDIM.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f11909AmA8tU.f7334B3GDIM.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f11926BniPrB) {
            return this.f11925BmvVmW;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f11928C4FrIb;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f11927C2rE4F;
    }

    public CharSequence getPrefixText() {
        return this.f11908AlLFFp.f7392AmA8tU;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f11908AlLFFp.f7391AlLFFp.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f11908AlLFFp.f7391AlLFFp;
    }

    public B2KMhB getShapeAppearanceModel() {
        return this.f11944D07BeM;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f11908AlLFFp.f7393AzWtSf.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f11908AlLFFp.f7393AzWtSf.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f11908AlLFFp.f7396B3GDIM;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f11908AlLFFp.f7397B4ZgIw;
    }

    public CharSequence getSuffixText() {
        return this.f11909AmA8tU.f7343BPw6Q8;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f11909AmA8tU.f7344BTvldC.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f11909AmA8tU.f7344BTvldC;
    }

    public Typeface getTypeface() {
        return this.f11956DaOi9o;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f11974EicXu4.AZOQYO(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int max;
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.f11980F1loUV = false;
        if (this.f11911B25kr6 != null && this.f11911B25kr6.getMeasuredHeight() < (max = Math.max(amA8tU.getMeasuredHeight(), this.f11908AlLFFp.getMeasuredHeight()))) {
            this.f11911B25kr6.setMinimumHeight(max);
            z = true;
        }
        boolean B4ZgIw2 = B4ZgIw();
        if (z || B4ZgIw2) {
            this.f11911B25kr6.post(new CtFAbx.A2egSU(12, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float descent;
        int i5;
        int compoundPaddingTop;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.f11911B25kr6;
        if (editText != null) {
            ThreadLocal threadLocal = Oay4Bh.AMqCpz.f6517A2egSU;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.f11954DV2E8K;
            rect.set(0, 0, width, height);
            Oay4Bh.AMqCpz.A4TApA(this, editText, rect);
            AaHO0E aaHO0E = this.f11942CtFAbx;
            if (aaHO0E != null) {
                int i6 = rect.bottom;
                aaHO0E.setBounds(rect.left, i6 - this.f11950DAk1zC, rect.right, i6);
            }
            AaHO0E aaHO0E2 = this.f11943CtxOCS;
            if (aaHO0E2 != null) {
                int i7 = rect.bottom;
                aaHO0E2.setBounds(rect.left, i7 - this.f11951DG07BK, rect.right, i7);
            }
            if (this.f11935CcAIMM) {
                float textSize = this.f11911B25kr6.getTextSize();
                A5SV6n a5SV6n = this.f11974EicXu4;
                if (a5SV6n.f6463AYUAbz != textSize) {
                    a5SV6n.f6463AYUAbz = textSize;
                    a5SV6n.AZkASS(false);
                }
                int gravity = this.f11911B25kr6.getGravity();
                int i8 = (gravity & (-113)) | 48;
                if (a5SV6n.f6462ASJ6gh != i8) {
                    a5SV6n.f6462ASJ6gh = i8;
                    a5SV6n.AZkASS(false);
                }
                if (a5SV6n.f6461ARc23Z != gravity) {
                    a5SV6n.f6461ARc23Z = gravity;
                    a5SV6n.AZkASS(false);
                }
                Rect ADYaiT2 = ADYaiT(rect);
                int i9 = ADYaiT2.left;
                int i10 = ADYaiT2.top;
                int i11 = ADYaiT2.right;
                int i12 = ADYaiT2.bottom;
                Rect rect2 = a5SV6n.f6460ADYaiT;
                if (rect2.left != i9 || rect2.top != i10 || rect2.right != i11 || rect2.bottom != i12) {
                    rect2.set(i9, i10, i11, i12);
                    a5SV6n.f6494CTkVKb = true;
                }
                if (this.f11911B25kr6 == null) {
                    throw new IllegalStateException();
                }
                int hintMaxLines = getHintMaxLines();
                TextPaint textPaint = a5SV6n.f6496Cd8JRx;
                if (hintMaxLines == 1) {
                    textPaint.setTextSize(a5SV6n.f6463AYUAbz);
                    textPaint.setTypeface(a5SV6n.f6477BChYOn);
                    textPaint.setLetterSpacing(a5SV6n.f6504D07BeM);
                    descent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(a5SV6n.f6463AYUAbz);
                    textPaint.setTypeface(a5SV6n.f6477BChYOn);
                    textPaint.setLetterSpacing(a5SV6n.f6504D07BeM);
                    descent = a5SV6n.f6467AcNBzu * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.f11911B25kr6.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.f11955DXnQ0V;
                rect3.left = compoundPaddingLeft;
                if (this.f11947D8MqeW == 1 && this.f11911B25kr6.getMinLines() <= 1) {
                    compoundPaddingTop = (int) (rect.centerY() - (descent / 2.0f));
                } else {
                    if (this.f11947D8MqeW != 0 || getHintMaxLines() == 1) {
                        i5 = 0;
                    } else {
                        textPaint.setTextSize(a5SV6n.f6463AYUAbz);
                        textPaint.setTypeface(a5SV6n.f6477BChYOn);
                        textPaint.setLetterSpacing(a5SV6n.f6504D07BeM);
                        i5 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.f11911B25kr6.getCompoundPaddingTop() + rect.top) - i5;
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.f11911B25kr6.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.f11947D8MqeW != 1 || this.f11911B25kr6.getMinLines() > 1) ? rect.bottom - this.f11911B25kr6.getCompoundPaddingBottom() : (int) (rect3.top + descent);
                rect3.bottom = compoundPaddingBottom;
                int i13 = rect3.left;
                int i14 = rect3.top;
                int i15 = rect3.right;
                Rect rect4 = a5SV6n.f6459A5SV6n;
                if (!(rect4.left == i13 && rect4.top == i14 && rect4.right == i15 && rect4.bottom == compoundPaddingBottom) || true != a5SV6n.f6516DaOi9o) {
                    rect4.set(i13, i14, i15, compoundPaddingBottom);
                    a5SV6n.f6494CTkVKb = true;
                    a5SV6n.f6516DaOi9o = true;
                }
                a5SV6n.AZkASS(false);
                if (!ASJ6gh() || this.f11973EiK8oA) {
                    return;
                }
                AcNBzu();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        float f;
        EditText editText;
        super.onMeasure(i, i2);
        boolean z = this.f11980F1loUV;
        AmA8tU amA8tU = this.f11909AmA8tU;
        if (!z) {
            amA8tU.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f11980F1loUV = true;
        }
        if (this.BpkvW3 != null && (editText = this.f11911B25kr6) != null) {
            this.BpkvW3.setGravity(editText.getGravity());
            this.BpkvW3.setPadding(this.f11911B25kr6.getCompoundPaddingLeft(), this.f11911B25kr6.getCompoundPaddingTop(), this.f11911B25kr6.getCompoundPaddingRight(), this.f11911B25kr6.getCompoundPaddingBottom());
        }
        amA8tU.AlLFFp();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.f11911B25kr6.getMeasuredWidth() - this.f11911B25kr6.getCompoundPaddingLeft()) - this.f11911B25kr6.getCompoundPaddingRight();
        A5SV6n a5SV6n = this.f11974EicXu4;
        TextPaint textPaint = a5SV6n.f6496Cd8JRx;
        textPaint.setTextSize(a5SV6n.f6464AZOQYO);
        textPaint.setTypeface(a5SV6n.f6474B4ZgIw);
        textPaint.setLetterSpacing(a5SV6n.f6503CtxOCS);
        float f2 = measuredWidth;
        a5SV6n.f6515DXnQ0V = a5SV6n.AMqCpz(a5SV6n.f6512DRlcZ9, textPaint, a5SV6n.f6483BTvldC, (a5SV6n.f6464AZOQYO / a5SV6n.f6463AYUAbz) * f2, a5SV6n.f6485BmvVmW).getHeight();
        textPaint.setTextSize(a5SV6n.f6463AYUAbz);
        textPaint.setTypeface(a5SV6n.f6477BChYOn);
        textPaint.setLetterSpacing(a5SV6n.f6504D07BeM);
        a5SV6n.DXuj49 = a5SV6n.AMqCpz(a5SV6n.f6511DG07BK, textPaint, a5SV6n.f6483BTvldC, f2, a5SV6n.f6485BmvVmW).getHeight();
        EditText editText2 = this.f11911B25kr6;
        ThreadLocal threadLocal = Oay4Bh.AMqCpz.f6517A2egSU;
        int width = editText2.getWidth();
        int height = editText2.getHeight();
        Rect rect = this.f11954DV2E8K;
        rect.set(0, 0, width, height);
        Oay4Bh.AMqCpz.A4TApA(this, editText2, rect);
        Rect ADYaiT2 = ADYaiT(rect);
        int i3 = ADYaiT2.left;
        int i4 = ADYaiT2.top;
        int i5 = ADYaiT2.right;
        int i6 = ADYaiT2.bottom;
        Rect rect2 = a5SV6n.f6460ADYaiT;
        if (rect2.left != i3 || rect2.top != i4 || rect2.right != i5 || rect2.bottom != i6) {
            rect2.set(i3, i4, i5, i6);
            a5SV6n.f6494CTkVKb = true;
        }
        BChYOn();
        A2egSU();
        if (this.f11911B25kr6 == null) {
            return;
        }
        int i7 = a5SV6n.DXuj49;
        if (i7 != -1) {
            f = i7;
        } else {
            TextPaint textPaint2 = a5SV6n.f6496Cd8JRx;
            textPaint2.setTextSize(a5SV6n.f6463AYUAbz);
            textPaint2.setTypeface(a5SV6n.f6477BChYOn);
            textPaint2.setLetterSpacing(a5SV6n.f6504D07BeM);
            f = -textPaint2.ascent();
        }
        float f3 = 0.0f;
        if (this.f11925BmvVmW != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.BpkvW3.getPaint());
            textPaint3.setTextSize(this.BpkvW3.getTextSize());
            textPaint3.setTypeface(this.BpkvW3.getTypeface());
            textPaint3.setLetterSpacing(this.BpkvW3.getLetterSpacing());
            try {
                BV3sI0 bV3sI0 = new BV3sI0(this.f11925BmvVmW, textPaint3, measuredWidth);
                bV3sI0.f6596AaHO0E = getLayoutDirection() == 1;
                bV3sI0.f6595AZkASS = true;
                float lineSpacingExtra = this.BpkvW3.getLineSpacingExtra();
                float lineSpacingMultiplier = this.BpkvW3.getLineSpacingMultiplier();
                bV3sI0.f6592ASJ6gh = lineSpacingExtra;
                bV3sI0.f6593AYUAbz = lineSpacingMultiplier;
                bV3sI0.f6598AlLFFp = new ADYaiT(9, this);
                f3 = bV3sI0.A2egSU().getHeight() + (this.f11947D8MqeW == 1 ? a5SV6n.ARc23Z() + this.f11948D8cQ8b + this.f11910AzWtSf : 0.0f);
            } catch (BTvldC e) {
                e.getCause().getMessage();
            }
        }
        float max = Math.max(f, f3);
        if (this.f11911B25kr6.getMeasuredHeight() < max) {
            this.f11911B25kr6.setMinimumHeight(Math.round(max));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof PWr3nF.BJ7GGh)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        PWr3nF.BJ7GGh bJ7GGh = (PWr3nF.BJ7GGh) parcelable;
        super.onRestoreInstanceState(bJ7GGh.getSuperState());
        setError(bJ7GGh.f7404AcNBzu);
        if (bJ7GGh.f7405AlLFFp) {
            post(new LLYwnm.AMqCpz(21, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 1;
        if (z != this.f11945D6DOie) {
            PCV8se.ADYaiT aDYaiT = this.f11944D07BeM.AMqCpz;
            RectF rectF = this.DXuj49;
            float A2egSU2 = aDYaiT.A2egSU(rectF);
            float A2egSU3 = this.f11944D07BeM.f7087ARc23Z.A2egSU(rectF);
            float A2egSU4 = this.f11944D07BeM.f7089AYUAbz.A2egSU(rectF);
            float A2egSU5 = this.f11944D07BeM.f7088ASJ6gh.A2egSU(rectF);
            B2KMhB b2KMhB = this.f11944D07BeM;
            PCV8se.AMqCpz aMqCpz = b2KMhB.f7083A2egSU;
            PCV8se.AMqCpz aMqCpz2 = b2KMhB.f7084A4TApA;
            PCV8se.AMqCpz aMqCpz3 = b2KMhB.f7086ADYaiT;
            PCV8se.AMqCpz aMqCpz4 = b2KMhB.f7085A5SV6n;
            B2KMhB.A2egSU a2egSU = new B2KMhB.A2egSU();
            a2egSU.f7094A2egSU = aMqCpz2;
            float A4TApA2 = B2KMhB.A2egSU.A4TApA(aMqCpz2);
            if (A4TApA2 != -1.0f) {
                a2egSU.ARc23Z(A4TApA2);
            }
            a2egSU.f7095A4TApA = aMqCpz;
            float A4TApA3 = B2KMhB.A2egSU.A4TApA(aMqCpz);
            if (A4TApA3 != -1.0f) {
                a2egSU.ASJ6gh(A4TApA3);
            }
            a2egSU.f7097ADYaiT = aMqCpz4;
            float A4TApA4 = B2KMhB.A2egSU.A4TApA(aMqCpz4);
            if (A4TApA4 != -1.0f) {
                a2egSU.ADYaiT(A4TApA4);
            }
            a2egSU.f7096A5SV6n = aMqCpz3;
            float A4TApA5 = B2KMhB.A2egSU.A4TApA(aMqCpz3);
            if (A4TApA5 != -1.0f) {
                a2egSU.AMqCpz(A4TApA5);
            }
            a2egSU.ARc23Z(A2egSU3);
            a2egSU.ASJ6gh(A2egSU2);
            a2egSU.ADYaiT(A2egSU5);
            a2egSU.AMqCpz(A2egSU4);
            B2KMhB A2egSU6 = a2egSU.A2egSU();
            this.f11945D6DOie = z;
            setShapeAppearanceModel(A2egSU6);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        PWr3nF.BJ7GGh bJ7GGh = new PWr3nF.BJ7GGh(super.onSaveInstanceState());
        if (AzWtSf()) {
            bJ7GGh.f7404AcNBzu = getError();
        }
        AmA8tU amA8tU = this.f11909AmA8tU;
        bJ7GGh.f7405AlLFFp = amA8tU.f7336B7CMnp != 0 && amA8tU.f7334B3GDIM.f11688AzWtSf;
        return bJ7GGh;
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f11953DUi7mC != i) {
            this.f11953DUi7mC = i;
            this.f11968EPdU4G = i;
            this.f11970EUIRHA = i;
            this.f11971EY4UKY = i;
            A5SV6n();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(BPw6Q8.ASJ6gh.A4TApA(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f11968EPdU4G = defaultColor;
        this.f11953DUi7mC = defaultColor;
        this.f11969EQurEW = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f11970EUIRHA = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f11971EY4UKY = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        A5SV6n();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f11947D8MqeW) {
            return;
        }
        this.f11947D8MqeW = i;
        if (this.f11911B25kr6 != null) {
            AaHO0E();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.f11948D8cQ8b = i;
    }

    public void setBoxCornerFamily(int i) {
        B2KMhB.A2egSU ASJ6gh2 = this.f11944D07BeM.ASJ6gh();
        PCV8se.ADYaiT aDYaiT = this.f11944D07BeM.AMqCpz;
        PCV8se.AMqCpz BV3sI02 = AlLFFp.BV3sI0(i);
        ASJ6gh2.f7094A2egSU = BV3sI02;
        float A4TApA2 = B2KMhB.A2egSU.A4TApA(BV3sI02);
        if (A4TApA2 != -1.0f) {
            ASJ6gh2.ARc23Z(A4TApA2);
        }
        ASJ6gh2.AMqCpz = aDYaiT;
        PCV8se.ADYaiT aDYaiT2 = this.f11944D07BeM.f7087ARc23Z;
        PCV8se.AMqCpz BV3sI03 = AlLFFp.BV3sI0(i);
        ASJ6gh2.f7095A4TApA = BV3sI03;
        float A4TApA3 = B2KMhB.A2egSU.A4TApA(BV3sI03);
        if (A4TApA3 != -1.0f) {
            ASJ6gh2.ASJ6gh(A4TApA3);
        }
        ASJ6gh2.f7098ARc23Z = aDYaiT2;
        PCV8se.ADYaiT aDYaiT3 = this.f11944D07BeM.f7089AYUAbz;
        PCV8se.AMqCpz BV3sI04 = AlLFFp.BV3sI0(i);
        ASJ6gh2.f7097ADYaiT = BV3sI04;
        float A4TApA4 = B2KMhB.A2egSU.A4TApA(BV3sI04);
        if (A4TApA4 != -1.0f) {
            ASJ6gh2.ADYaiT(A4TApA4);
        }
        ASJ6gh2.f7100AYUAbz = aDYaiT3;
        PCV8se.ADYaiT aDYaiT4 = this.f11944D07BeM.f7088ASJ6gh;
        PCV8se.AMqCpz BV3sI05 = AlLFFp.BV3sI0(i);
        ASJ6gh2.f7096A5SV6n = BV3sI05;
        float A4TApA5 = B2KMhB.A2egSU.A4TApA(BV3sI05);
        if (A4TApA5 != -1.0f) {
            ASJ6gh2.AMqCpz(A4TApA5);
        }
        ASJ6gh2.f7099ASJ6gh = aDYaiT4;
        this.f11944D07BeM = ASJ6gh2.A2egSU();
        A5SV6n();
    }

    public void setBoxStrokeColor(int i) {
        if (this.f11966EGM26s != i) {
            this.f11966EGM26s = i;
            BNL6CD();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f11964DyaChj = colorStateList.getDefaultColor();
            this.EdQ5bb = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f11965ECyGFg = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f11966EGM26s = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f11966EGM26s != colorStateList.getDefaultColor()) {
            this.f11966EGM26s = colorStateList.getDefaultColor();
        }
        BNL6CD();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f11967EH1KK8 != colorStateList) {
            this.f11967EH1KK8 = colorStateList;
            BNL6CD();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.f11950DAk1zC = i;
        BNL6CD();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.f11951DG07BK = i;
        BNL6CD();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f11918BI9f7h != z) {
            B3GDIM b3gdim = this.f11917BChYOn;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
                this.f11922BPw6Q8 = appCompatTextView;
                appCompatTextView.setId(2131298093);
                Typeface typeface = this.f11956DaOi9o;
                if (typeface != null) {
                    this.f11922BPw6Q8.setTypeface(typeface);
                }
                this.f11922BPw6Q8.setMaxLines(1);
                b3gdim.A2egSU(this.f11922BPw6Q8, 2);
                ((ViewGroup.MarginLayoutParams) this.f11922BPw6Q8.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(2131166523));
                B2KMhB();
                if (this.f11922BPw6Q8 != null) {
                    EditText editText = this.f11911B25kr6;
                    B25kr6(editText != null ? editText.getText() : null);
                }
            } else {
                b3gdim.ASJ6gh(this.f11922BPw6Q8, 2);
                this.f11922BPw6Q8 = null;
            }
            this.f11918BI9f7h = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f11919BIYEnU != i) {
            if (i > 0) {
                this.f11919BIYEnU = i;
            } else {
                this.f11919BIYEnU = -1;
            }
            if (!this.f11918BI9f7h || this.f11922BPw6Q8 == null) {
                return;
            }
            EditText editText = this.f11911B25kr6;
            B25kr6(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.f11923BTvldC != i) {
            this.f11923BTvldC = i;
            B2KMhB();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f11932CQhlFr != colorStateList) {
            this.f11932CQhlFr = colorStateList;
            B2KMhB();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.f11924BV3sI0 != i) {
            this.f11924BV3sI0 = i;
            B2KMhB();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f11931COJEAR != colorStateList) {
            this.f11931COJEAR = colorStateList;
            B2KMhB();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.f11933CSDoyG != colorStateList) {
            this.f11933CSDoyG = colorStateList;
            B3GDIM();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.f11934CTkVKb != colorStateList) {
            this.f11934CTkVKb = colorStateList;
            if (AzWtSf() || (this.f11922BPw6Q8 != null && this.f11920BJ7GGh)) {
                B3GDIM();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f11962DuwtYk = colorStateList;
        this.f11963DvK7DB = colorStateList;
        if (this.f11911B25kr6 != null) {
            BI9f7h(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        AlLFFp(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.f11909AmA8tU.f7334B3GDIM.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.f11909AmA8tU.f7334B3GDIM.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        CharSequence text = i != 0 ? amA8tU.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = amA8tU.f7334B3GDIM;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        Drawable CQhlFr2 = i != 0 ? AlLFFp.CQhlFr(amA8tU.getContext(), i) : null;
        CheckableImageButton checkableImageButton = amA8tU.f7334B3GDIM;
        checkableImageButton.setImageDrawable(CQhlFr2);
        if (CQhlFr2 != null) {
            ColorStateList colorStateList = amA8tU.f7338BChYOn;
            PorterDuff.Mode mode = amA8tU.f7339BI9f7h;
            TextInputLayout textInputLayout = amA8tU.f7328AcNBzu;
            A4TApA.AZOQYO(textInputLayout, checkableImageButton, colorStateList, mode);
            A4TApA.CrfGsy(textInputLayout, checkableImageButton, amA8tU.f7338BChYOn);
        }
    }

    public void setEndIconMinSize(int i) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        if (i < 0) {
            amA8tU.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != amA8tU.f7340BIYEnU) {
            amA8tU.f7340BIYEnU = i;
            CheckableImageButton checkableImageButton = amA8tU.f7334B3GDIM;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = amA8tU.f7330AmA8tU;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.f11909AmA8tU.ASJ6gh(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        View.OnLongClickListener onLongClickListener = amA8tU.f7342BNL6CD;
        CheckableImageButton checkableImageButton = amA8tU.f7334B3GDIM;
        checkableImageButton.setOnClickListener(onClickListener);
        A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.f7342BNL6CD = onLongClickListener;
        CheckableImageButton checkableImageButton = amA8tU.f7334B3GDIM;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.f7341BJ7GGh = scaleType;
        amA8tU.f7334B3GDIM.setScaleType(scaleType);
        amA8tU.f7330AmA8tU.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        if (amA8tU.f7338BChYOn != colorStateList) {
            amA8tU.f7338BChYOn = colorStateList;
            A4TApA.AZOQYO(amA8tU.f7328AcNBzu, amA8tU.f7334B3GDIM, colorStateList, amA8tU.f7339BI9f7h);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        if (amA8tU.f7339BI9f7h != mode) {
            amA8tU.f7339BI9f7h = mode;
            A4TApA.AZOQYO(amA8tU.f7328AcNBzu, amA8tU.f7334B3GDIM, amA8tU.f7338BChYOn, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.f11909AmA8tU.AYUAbz(z);
    }

    public void setError(CharSequence charSequence) {
        B3GDIM b3gdim = this.f11917BChYOn;
        if (!b3gdim.f7373B2KMhB) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            b3gdim.ARc23Z();
            return;
        }
        b3gdim.A5SV6n();
        b3gdim.f7372B25kr6 = charSequence;
        b3gdim.f7374B3GDIM.setText(charSequence);
        int i = b3gdim.f7370AmA8tU;
        if (i != 1) {
            b3gdim.f7371AzWtSf = 1;
        }
        b3gdim.AZOQYO(i, b3gdim.f7371AzWtSf, b3gdim.AYUAbz(b3gdim.f7374B3GDIM, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        B3GDIM b3gdim = this.f11917BChYOn;
        b3gdim.f7376B7CMnp = i;
        AppCompatTextView appCompatTextView = b3gdim.f7374B3GDIM;
        if (appCompatTextView != null) {
            appCompatTextView.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        B3GDIM b3gdim = this.f11917BChYOn;
        b3gdim.f7375B4ZgIw = charSequence;
        AppCompatTextView appCompatTextView = b3gdim.f7374B3GDIM;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        B3GDIM b3gdim = this.f11917BChYOn;
        if (b3gdim.f7373B2KMhB == z) {
            return;
        }
        b3gdim.A5SV6n();
        TextInputLayout textInputLayout = b3gdim.f7364AYUAbz;
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(b3gdim.f7363ASJ6gh, null);
            b3gdim.f7374B3GDIM = appCompatTextView;
            appCompatTextView.setId(2131298094);
            b3gdim.f7374B3GDIM.setTextAlignment(5);
            Typeface typeface = b3gdim.f7384BTvldC;
            if (typeface != null) {
                b3gdim.f7374B3GDIM.setTypeface(typeface);
            }
            int i = b3gdim.f7377B9tovu;
            b3gdim.f7377B9tovu = i;
            AppCompatTextView appCompatTextView2 = b3gdim.f7374B3GDIM;
            if (appCompatTextView2 != null) {
                textInputLayout.AmA8tU(appCompatTextView2, i);
            }
            ColorStateList colorStateList = b3gdim.f7378BChYOn;
            b3gdim.f7378BChYOn = colorStateList;
            AppCompatTextView appCompatTextView3 = b3gdim.f7374B3GDIM;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = b3gdim.f7375B4ZgIw;
            b3gdim.f7375B4ZgIw = charSequence;
            AppCompatTextView appCompatTextView4 = b3gdim.f7374B3GDIM;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i2 = b3gdim.f7376B7CMnp;
            b3gdim.f7376B7CMnp = i2;
            AppCompatTextView appCompatTextView5 = b3gdim.f7374B3GDIM;
            if (appCompatTextView5 != null) {
                appCompatTextView5.setAccessibilityLiveRegion(i2);
            }
            b3gdim.f7374B3GDIM.setVisibility(4);
            b3gdim.A2egSU(b3gdim.f7374B3GDIM, 0);
        } else {
            b3gdim.ARc23Z();
            b3gdim.ASJ6gh(b3gdim.f7374B3GDIM, 0);
            b3gdim.f7374B3GDIM = null;
            textInputLayout.B7CMnp();
            textInputLayout.BNL6CD();
        }
        b3gdim.f7373B2KMhB = z;
    }

    public void setErrorIconDrawable(int i) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.AZOQYO(i != 0 ? AlLFFp.CQhlFr(amA8tU.getContext(), i) : null);
        A4TApA.CrfGsy(amA8tU.f7328AcNBzu, amA8tU.f7330AmA8tU, amA8tU.f7331AzWtSf);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        CheckableImageButton checkableImageButton = amA8tU.f7330AmA8tU;
        View.OnLongClickListener onLongClickListener = amA8tU.f7333B2KMhB;
        checkableImageButton.setOnClickListener(onClickListener);
        A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.f7333B2KMhB = onLongClickListener;
        CheckableImageButton checkableImageButton = amA8tU.f7330AmA8tU;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        if (amA8tU.f7331AzWtSf != colorStateList) {
            amA8tU.f7331AzWtSf = colorStateList;
            A4TApA.AZOQYO(amA8tU.f7328AcNBzu, amA8tU.f7330AmA8tU, colorStateList, amA8tU.f7332B25kr6);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        if (amA8tU.f7332B25kr6 != mode) {
            amA8tU.f7332B25kr6 = mode;
            A4TApA.AZOQYO(amA8tU.f7328AcNBzu, amA8tU.f7330AmA8tU, amA8tU.f7331AzWtSf, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        B3GDIM b3gdim = this.f11917BChYOn;
        b3gdim.f7377B9tovu = i;
        AppCompatTextView appCompatTextView = b3gdim.f7374B3GDIM;
        if (appCompatTextView != null) {
            b3gdim.f7364AYUAbz.AmA8tU(appCompatTextView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        B3GDIM b3gdim = this.f11917BChYOn;
        b3gdim.f7378BChYOn = colorStateList;
        AppCompatTextView appCompatTextView = b3gdim.f7374B3GDIM;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.f11975EmJGcg != z) {
            this.f11975EmJGcg = z;
            BI9f7h(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        B3GDIM b3gdim = this.f11917BChYOn;
        if (isEmpty) {
            if (b3gdim.f7380BIYEnU) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!b3gdim.f7380BIYEnU) {
            setHelperTextEnabled(true);
        }
        b3gdim.A5SV6n();
        b3gdim.f7379BI9f7h = charSequence;
        b3gdim.f7381BJ7GGh.setText(charSequence);
        int i = b3gdim.f7370AmA8tU;
        if (i != 2) {
            b3gdim.f7371AzWtSf = 2;
        }
        b3gdim.AZOQYO(i, b3gdim.f7371AzWtSf, b3gdim.AYUAbz(b3gdim.f7381BJ7GGh, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        B3GDIM b3gdim = this.f11917BChYOn;
        b3gdim.f7383BPw6Q8 = colorStateList;
        AppCompatTextView appCompatTextView = b3gdim.f7381BJ7GGh;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        B3GDIM b3gdim = this.f11917BChYOn;
        if (b3gdim.f7380BIYEnU == z) {
            return;
        }
        b3gdim.A5SV6n();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(b3gdim.f7363ASJ6gh, null);
            b3gdim.f7381BJ7GGh = appCompatTextView;
            appCompatTextView.setId(2131298095);
            b3gdim.f7381BJ7GGh.setTextAlignment(5);
            Typeface typeface = b3gdim.f7384BTvldC;
            if (typeface != null) {
                b3gdim.f7381BJ7GGh.setTypeface(typeface);
            }
            b3gdim.f7381BJ7GGh.setVisibility(4);
            b3gdim.f7381BJ7GGh.setAccessibilityLiveRegion(1);
            int i = b3gdim.f7382BNL6CD;
            b3gdim.f7382BNL6CD = i;
            AppCompatTextView appCompatTextView2 = b3gdim.f7381BJ7GGh;
            if (appCompatTextView2 != null) {
                A4TApA.DRlcZ9(appCompatTextView2, i);
            }
            ColorStateList colorStateList = b3gdim.f7383BPw6Q8;
            b3gdim.f7383BPw6Q8 = colorStateList;
            AppCompatTextView appCompatTextView3 = b3gdim.f7381BJ7GGh;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            b3gdim.A2egSU(b3gdim.f7381BJ7GGh, 1);
            b3gdim.f7381BJ7GGh.setAccessibilityDelegate(new PWr3nF.B2KMhB(b3gdim));
        } else {
            b3gdim.A5SV6n();
            int i2 = b3gdim.f7370AmA8tU;
            if (i2 == 2) {
                b3gdim.f7371AzWtSf = 0;
            }
            b3gdim.AZOQYO(i2, b3gdim.f7371AzWtSf, b3gdim.AYUAbz(b3gdim.f7381BJ7GGh, ""));
            b3gdim.ASJ6gh(b3gdim.f7381BJ7GGh, 1);
            b3gdim.f7381BJ7GGh = null;
            TextInputLayout textInputLayout = b3gdim.f7364AYUAbz;
            textInputLayout.B7CMnp();
            textInputLayout.BNL6CD();
        }
        b3gdim.f7380BIYEnU = z;
    }

    public void setHelperTextTextAppearance(int i) {
        B3GDIM b3gdim = this.f11917BChYOn;
        b3gdim.f7382BNL6CD = i;
        AppCompatTextView appCompatTextView = b3gdim.f7381BJ7GGh;
        if (appCompatTextView != null) {
            A4TApA.DRlcZ9(appCompatTextView, i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f11935CcAIMM) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f11976ErKPGd = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f11935CcAIMM) {
            this.f11935CcAIMM = z;
            if (z) {
                CharSequence hint = this.f11911B25kr6.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f11936Cd8JRx)) {
                        setHint(hint);
                    }
                    this.f11911B25kr6.setHint((CharSequence) null);
                }
                this.f11937CikNvS = true;
            } else {
                this.f11937CikNvS = false;
                if (!TextUtils.isEmpty(this.f11936Cd8JRx) && TextUtils.isEmpty(this.f11911B25kr6.getHint())) {
                    this.f11911B25kr6.setHint(this.f11936Cd8JRx);
                }
                setHintInternal(null);
            }
            if (this.f11911B25kr6 != null) {
                BChYOn();
            }
        }
    }

    public void setHintMaxLines(int i) {
        A5SV6n a5SV6n = this.f11974EicXu4;
        if (i != a5SV6n.f6512DRlcZ9) {
            a5SV6n.f6512DRlcZ9 = i;
            a5SV6n.AZkASS(false);
        }
        if (i != a5SV6n.f6511DG07BK) {
            a5SV6n.f6511DG07BK = i;
            a5SV6n.AZkASS(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(int i) {
        A5SV6n a5SV6n = this.f11974EicXu4;
        TextInputLayout textInputLayout = a5SV6n.f6457A2egSU;
        P3rngT.AMqCpz aMqCpz = new P3rngT.AMqCpz(textInputLayout.getContext(), i);
        ColorStateList colorStateList = aMqCpz.f6951AaHO0E;
        if (colorStateList != null) {
            a5SV6n.f6466AaHO0E = colorStateList;
        }
        float f = aMqCpz.f6952AcNBzu;
        if (f != 0.0f) {
            a5SV6n.f6464AZOQYO = f;
        }
        ColorStateList colorStateList2 = aMqCpz.f6942A2egSU;
        if (colorStateList2 != null) {
            a5SV6n.f6502CtFAbx = colorStateList2;
        }
        a5SV6n.f6500CqNSpT = aMqCpz.f6946ARc23Z;
        a5SV6n.f6501CrfGsy = aMqCpz.f6947ASJ6gh;
        a5SV6n.f6499CmUvjW = aMqCpz.f6948AYUAbz;
        a5SV6n.f6503CtxOCS = aMqCpz.f6950AZkASS;
        P3rngT.A2egSU a2egSU = a5SV6n.f6481BNL6CD;
        if (a2egSU != null) {
            a2egSU.f6935A5SV6n = true;
        }
        IQ76hF.AmA8tU amA8tU = new IQ76hF.AmA8tU(23, a5SV6n);
        aMqCpz.A2egSU();
        a5SV6n.f6481BNL6CD = new P3rngT.A2egSU(amA8tU, aMqCpz.f6956B25kr6);
        aMqCpz.A4TApA(textInputLayout.getContext(), a5SV6n.f6481BNL6CD);
        a5SV6n.AZkASS(false);
        this.f11963DvK7DB = a5SV6n.f6466AaHO0E;
        if (this.f11911B25kr6 != null) {
            BI9f7h(false, false);
            BChYOn();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f11963DvK7DB != colorStateList) {
            if (this.f11962DuwtYk == null) {
                A5SV6n a5SV6n = this.f11974EicXu4;
                if (a5SV6n.f6466AaHO0E != colorStateList) {
                    a5SV6n.f6466AaHO0E = colorStateList;
                    a5SV6n.AZkASS(false);
                }
            }
            this.f11963DvK7DB = colorStateList;
            if (this.f11911B25kr6 != null) {
                BI9f7h(false, false);
            }
        }
    }

    public void setLengthCounter(BIYEnU bIYEnU) {
        this.f11921BNL6CD = bIYEnU;
    }

    public void setMaxEms(int i) {
        this.f11914B4ZgIw = i;
        EditText editText = this.f11911B25kr6;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.f11916B9tovu = i;
        EditText editText = this.f11911B25kr6;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.f11913B3GDIM = i;
        EditText editText = this.f11911B25kr6;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.f11915B7CMnp = i;
        EditText editText = this.f11911B25kr6;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.f7334B3GDIM.setContentDescription(i != 0 ? amA8tU.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.f7334B3GDIM.setImageDrawable(i != 0 ? AlLFFp.CQhlFr(amA8tU.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        if (z && amA8tU.f7336B7CMnp != 1) {
            amA8tU.ASJ6gh(1);
        } else if (z) {
            amA8tU.getClass();
        } else {
            amA8tU.ASJ6gh(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.f7338BChYOn = colorStateList;
        A4TApA.AZOQYO(amA8tU.f7328AcNBzu, amA8tU.f7334B3GDIM, colorStateList, amA8tU.f7339BI9f7h);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.f7339BI9f7h = mode;
        A4TApA.AZOQYO(amA8tU.f7328AcNBzu, amA8tU.f7334B3GDIM, amA8tU.f7338BChYOn, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.BpkvW3 == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
            this.BpkvW3 = appCompatTextView;
            appCompatTextView.setId(2131298096);
            this.BpkvW3.setImportantForAccessibility(1);
            this.BpkvW3.setAccessibilityLiveRegion(1);
            ASJ6gh ARc23Z2 = ARc23Z();
            this.f11929CASmeH = ARc23Z2;
            ARc23Z2.f2239AlLFFp = 67L;
            this.f11930CNPG0E = ARc23Z();
            setPlaceholderTextAppearance(this.f11928C4FrIb);
            setPlaceholderTextColor(this.f11927C2rE4F);
            DG07BK.B4ZgIw(this.BpkvW3, new CikNvS.AYUAbz(2));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f11926BniPrB) {
                setPlaceholderTextEnabled(true);
            }
            this.f11925BmvVmW = charSequence;
        }
        EditText editText = this.f11911B25kr6;
        BIYEnU(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.f11928C4FrIb = i;
        AppCompatTextView appCompatTextView = this.BpkvW3;
        if (appCompatTextView != null) {
            A4TApA.DRlcZ9(appCompatTextView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f11927C2rE4F != colorStateList) {
            this.f11927C2rE4F = colorStateList;
            AppCompatTextView appCompatTextView = this.BpkvW3;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        B9tovu b9tovu = this.f11908AlLFFp;
        b9tovu.getClass();
        b9tovu.f7392AmA8tU = TextUtils.isEmpty(charSequence) ? null : charSequence;
        b9tovu.f7391AlLFFp.setText(charSequence);
        b9tovu.AMqCpz();
    }

    public void setPrefixTextAppearance(int i) {
        A4TApA.DRlcZ9(this.f11908AlLFFp.f7391AlLFFp, i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f11908AlLFFp.f7391AlLFFp.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(B2KMhB b2KMhB) {
        AaHO0E aaHO0E = this.f11938CkXcdM;
        if (aaHO0E == null || aaHO0E.f7042AlLFFp.f7021A2egSU == b2KMhB) {
            return;
        }
        this.f11944D07BeM = b2KMhB;
        A5SV6n();
    }

    public void setStartIconCheckable(boolean z) {
        this.f11908AlLFFp.f7393AzWtSf.setCheckable(z);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f11908AlLFFp.f7393AzWtSf;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? AlLFFp.CQhlFr(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        B9tovu b9tovu = this.f11908AlLFFp;
        if (i < 0) {
            b9tovu.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != b9tovu.f7396B3GDIM) {
            b9tovu.f7396B3GDIM = i;
            CheckableImageButton checkableImageButton = b9tovu.f7393AzWtSf;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        B9tovu b9tovu = this.f11908AlLFFp;
        View.OnLongClickListener onLongClickListener = b9tovu.f7398B7CMnp;
        CheckableImageButton checkableImageButton = b9tovu.f7393AzWtSf;
        checkableImageButton.setOnClickListener(onClickListener);
        A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        B9tovu b9tovu = this.f11908AlLFFp;
        b9tovu.f7398B7CMnp = onLongClickListener;
        CheckableImageButton checkableImageButton = b9tovu.f7393AzWtSf;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        B9tovu b9tovu = this.f11908AlLFFp;
        b9tovu.f7397B4ZgIw = scaleType;
        b9tovu.f7393AzWtSf.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        B9tovu b9tovu = this.f11908AlLFFp;
        if (b9tovu.f7394B25kr6 != colorStateList) {
            b9tovu.f7394B25kr6 = colorStateList;
            A4TApA.AZOQYO(b9tovu.f7390AcNBzu, b9tovu.f7393AzWtSf, colorStateList, b9tovu.f7395B2KMhB);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        B9tovu b9tovu = this.f11908AlLFFp;
        if (b9tovu.f7395B2KMhB != mode) {
            b9tovu.f7395B2KMhB = mode;
            A4TApA.AZOQYO(b9tovu.f7390AcNBzu, b9tovu.f7393AzWtSf, b9tovu.f7394B25kr6, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.f11908AlLFFp.A5SV6n(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        amA8tU.getClass();
        amA8tU.f7343BPw6Q8 = TextUtils.isEmpty(charSequence) ? null : charSequence;
        amA8tU.f7344BTvldC.setText(charSequence);
        amA8tU.AmA8tU();
    }

    public void setSuffixTextAppearance(int i) {
        A4TApA.DRlcZ9(this.f11909AmA8tU.f7344BTvldC, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f11909AmA8tU.f7344BTvldC.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(BI9f7h bI9f7h) {
        EditText editText = this.f11911B25kr6;
        if (editText != null) {
            DG07BK.B4ZgIw(editText, bI9f7h);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f11956DaOi9o) {
            this.f11956DaOi9o = typeface;
            this.f11974EicXu4.AmA8tU(typeface);
            B3GDIM b3gdim = this.f11917BChYOn;
            if (typeface != b3gdim.f7384BTvldC) {
                b3gdim.f7384BTvldC = typeface;
                AppCompatTextView appCompatTextView = b3gdim.f7374B3GDIM;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = b3gdim.f7381BJ7GGh;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.f11922BPw6Q8;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f11908AlLFFp.A4TApA(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f11909AmA8tU.f7334B3GDIM.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f11909AmA8tU.f7334B3GDIM.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f11909AmA8tU.AZOQYO(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f11909AmA8tU.f7334B3GDIM;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        AmA8tU amA8tU = this.f11909AmA8tU;
        CheckableImageButton checkableImageButton = amA8tU.f7334B3GDIM;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = amA8tU.f7338BChYOn;
            PorterDuff.Mode mode = amA8tU.f7339BI9f7h;
            TextInputLayout textInputLayout = amA8tU.f7328AcNBzu;
            A4TApA.AZOQYO(textInputLayout, checkableImageButton, colorStateList, mode);
            A4TApA.CrfGsy(textInputLayout, checkableImageButton, amA8tU.f7338BChYOn);
        }
    }
}
