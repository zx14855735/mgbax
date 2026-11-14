package PWr3nF;

import ADYaiT.CtFAbx;
import AaHO0E.GYpKKt;
import Oay4Bh.C4FrIb;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU extends LinearLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final TextInputLayout f7328AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final FrameLayout f7329AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final CheckableImageButton f7330AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ColorStateList f7331AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public PorterDuff.Mode f7332B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public View.OnLongClickListener f7333B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final CheckableImageButton f7334B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final AlLFFp f7335B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f7336B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final LinkedHashSet f7337B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public ColorStateList f7338BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public PorterDuff.Mode f7339BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f7340BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public ImageView.ScaleType f7341BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public View.OnLongClickListener f7342BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public CharSequence f7343BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final AppCompatTextView f7344BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f7345BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public EditText f7346BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final AccessibilityManager f7347BniPrB;
    public AccessibilityManager.TouchExplorationStateChangeListener BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final AaHO0E f7348C2rE4F;

    public AmA8tU(TextInputLayout textInputLayout, GYpKKt gYpKKt) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.f7336B7CMnp = 0;
        this.f7337B9tovu = new LinkedHashSet();
        this.f7348C2rE4F = new AaHO0E(this);
        AcNBzu acNBzu = new AcNBzu(this);
        this.f7347BniPrB = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f7328AcNBzu = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f7329AlLFFp = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton A2egSU2 = A2egSU(this, from, 2131298083);
        this.f7330AmA8tU = A2egSU2;
        CheckableImageButton A2egSU3 = A2egSU(frameLayout, from, 2131298082);
        this.f7334B3GDIM = A2egSU3;
        this.f7335B4ZgIw = new AlLFFp(this, gYpKKt);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.f7344BTvldC = appCompatTextView;
        TypedArray typedArray = gYpKKt.f884A4TApA;
        if (typedArray.hasValue(38)) {
            this.f7331AzWtSf = com.bumptech.glide.AMqCpz.BNL6CD(getContext(), gYpKKt, 38);
        }
        if (typedArray.hasValue(39)) {
            this.f7332B25kr6 = C4FrIb.B25kr6(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            AZOQYO(gYpKKt.A4TApA(37));
        }
        A2egSU2.setContentDescription(getResources().getText(2131886297));
        A2egSU2.setImportantForAccessibility(2);
        A2egSU2.setClickable(false);
        A2egSU2.setPressable(false);
        A2egSU2.setCheckable(false);
        A2egSU2.setFocusable(false);
        if (!typedArray.hasValue(54)) {
            if (typedArray.hasValue(32)) {
                this.f7338BChYOn = com.bumptech.glide.AMqCpz.BNL6CD(getContext(), gYpKKt, 32);
            }
            if (typedArray.hasValue(33)) {
                this.f7339BI9f7h = C4FrIb.B25kr6(typedArray.getInt(33, -1), null);
            }
        }
        if (typedArray.hasValue(30)) {
            ASJ6gh(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && A2egSU3.getContentDescription() != (text = typedArray.getText(27))) {
                A2egSU3.setContentDescription(text);
            }
            A2egSU3.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(54)) {
            if (typedArray.hasValue(55)) {
                this.f7338BChYOn = com.bumptech.glide.AMqCpz.BNL6CD(getContext(), gYpKKt, 55);
            }
            if (typedArray.hasValue(56)) {
                this.f7339BI9f7h = C4FrIb.B25kr6(typedArray.getInt(56, -1), null);
            }
            ASJ6gh(typedArray.getBoolean(54, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(52);
            if (A2egSU3.getContentDescription() != text2) {
                A2egSU3.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(2131166460));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f7340BIYEnU) {
            this.f7340BIYEnU = dimensionPixelSize;
            A2egSU3.setMinimumWidth(dimensionPixelSize);
            A2egSU3.setMinimumHeight(dimensionPixelSize);
            A2egSU2.setMinimumWidth(dimensionPixelSize);
            A2egSU2.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType BChYOn2 = JrXYwF.A4TApA.BChYOn(typedArray.getInt(31, -1));
            this.f7341BJ7GGh = BChYOn2;
            A2egSU3.setScaleType(BChYOn2);
            A2egSU2.setScaleType(BChYOn2);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(2131298098);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView.setAccessibilityLiveRegion(1);
        JrXYwF.A4TApA.DRlcZ9(appCompatTextView, typedArray.getResourceId(73, 0));
        if (typedArray.hasValue(74)) {
            appCompatTextView.setTextColor(gYpKKt.A2egSU(74));
        }
        CharSequence text3 = typedArray.getText(72);
        this.f7343BPw6Q8 = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        AmA8tU();
        frameLayout.addView(A2egSU3);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(A2egSU2);
        textInputLayout.Ddcejp.add(acNBzu);
        if (textInputLayout.f11911B25kr6 != null) {
            acNBzu.A2egSU(textInputLayout);
        }
        addOnAttachStateChangeListener(new AZkASS.ADYaiT(7, this));
    }

    public final CheckableImageButton A2egSU(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        Drawable A4TApA2;
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(2131492946, viewGroup, false);
        checkableImageButton.setId(i);
        if (Build.VERSION.SDK_INT < 23) {
            A4TApA2 = P5yM7D.A2egSU.A4TApA(checkableImageButton.getContext(), (int) C4FrIb.AYUAbz(checkableImageButton.getContext(), 4));
            checkableImageButton.setBackground(A4TApA2);
        }
        if (com.bumptech.glide.AMqCpz.CNPG0E(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final AzWtSf A4TApA() {
        AzWtSf aMqCpz;
        int i = this.f7336B7CMnp;
        AlLFFp alLFFp = this.f7335B4ZgIw;
        SparseArray sparseArray = alLFFp.f7324A2egSU;
        AzWtSf azWtSf = (AzWtSf) sparseArray.get(i);
        if (azWtSf != null) {
            return azWtSf;
        }
        AmA8tU amA8tU = alLFFp.f7325A4TApA;
        if (i == -1) {
            aMqCpz = new AMqCpz(amA8tU, 0);
        } else if (i == 0) {
            aMqCpz = new AMqCpz(amA8tU, 1);
        } else if (i == 1) {
            aMqCpz = new B7CMnp(amA8tU, alLFFp.f7327ADYaiT);
        } else if (i == 2) {
            aMqCpz = new ADYaiT(amA8tU);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "Invalid end icon mode: "));
            }
            aMqCpz = new AZkASS(amA8tU);
        }
        sparseArray.append(i, aMqCpz);
        return aMqCpz;
    }

    public final int A5SV6n() {
        int marginStart;
        if (ADYaiT() || AMqCpz()) {
            CheckableImageButton checkableImageButton = this.f7334B3GDIM;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.f7344BTvldC.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean ADYaiT() {
        return this.f7329AlLFFp.getVisibility() == 0 && this.f7334B3GDIM.getVisibility() == 0;
    }

    public final boolean AMqCpz() {
        return this.f7330AmA8tU.getVisibility() == 0;
    }

    public final void ARc23Z(boolean z) {
        boolean z2;
        boolean isActivated;
        boolean z3;
        AzWtSf A4TApA2 = A4TApA();
        boolean AaHO0E2 = A4TApA2.AaHO0E();
        CheckableImageButton checkableImageButton = this.f7334B3GDIM;
        boolean z4 = true;
        if (!AaHO0E2 || (z3 = checkableImageButton.f11688AzWtSf) == A4TApA2.AcNBzu()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        }
        if (!(A4TApA2 instanceof AZkASS) || (isActivated = checkableImageButton.isActivated()) == A4TApA2.AZkASS()) {
            z4 = z2;
        } else {
            checkableImageButton.setActivated(!isActivated);
        }
        if (z || z4) {
            JrXYwF.A4TApA.CrfGsy(this.f7328AcNBzu, checkableImageButton, this.f7338BChYOn);
        }
    }

    public final void ASJ6gh(int i) {
        if (this.f7336B7CMnp == i) {
            return;
        }
        AzWtSf A4TApA2 = A4TApA();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.BpkvW3;
        AccessibilityManager accessibilityManager = this.f7347BniPrB;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.BpkvW3 = null;
        A4TApA2.B4ZgIw();
        this.f7336B7CMnp = i;
        Iterator it = this.f7337B9tovu.iterator();
        if (it.hasNext()) {
            throw CtFAbx.A5SV6n(it);
        }
        AYUAbz(i != 0);
        AzWtSf A4TApA3 = A4TApA();
        int i2 = this.f7335B4ZgIw.f7326A5SV6n;
        if (i2 == 0) {
            i2 = A4TApA3.ADYaiT();
        }
        Drawable CQhlFr2 = i2 != 0 ? NOd7IU.AlLFFp.CQhlFr(getContext(), i2) : null;
        CheckableImageButton checkableImageButton = this.f7334B3GDIM;
        checkableImageButton.setImageDrawable(CQhlFr2);
        TextInputLayout textInputLayout = this.f7328AcNBzu;
        if (CQhlFr2 != null) {
            JrXYwF.A4TApA.AZOQYO(textInputLayout, checkableImageButton, this.f7338BChYOn, this.f7339BI9f7h);
            JrXYwF.A4TApA.CrfGsy(textInputLayout, checkableImageButton, this.f7338BChYOn);
        }
        int A5SV6n2 = A4TApA3.A5SV6n();
        CharSequence text = A5SV6n2 != 0 ? getResources().getText(A5SV6n2) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(A4TApA3.AaHO0E());
        if (!A4TApA3.AZOQYO(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        A4TApA3.B3GDIM();
        AccessibilityManager.TouchExplorationStateChangeListener AYUAbz2 = A4TApA3.AYUAbz();
        this.BpkvW3 = AYUAbz2;
        if (AYUAbz2 != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.BpkvW3);
        }
        View.OnClickListener ARc23Z2 = A4TApA3.ARc23Z();
        View.OnLongClickListener onLongClickListener = this.f7342BNL6CD;
        checkableImageButton.setOnClickListener(ARc23Z2);
        JrXYwF.A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
        EditText editText = this.f7346BmvVmW;
        if (editText != null) {
            A4TApA3.AlLFFp(editText);
            AZkASS(A4TApA3);
        }
        JrXYwF.A4TApA.AZOQYO(textInputLayout, checkableImageButton, this.f7338BChYOn, this.f7339BI9f7h);
        ARc23Z(true);
    }

    public final void AYUAbz(boolean z) {
        if (ADYaiT() != z) {
            this.f7334B3GDIM.setVisibility(z ? 0 : 8);
            AaHO0E();
            AlLFFp();
            this.f7328AcNBzu.B4ZgIw();
        }
    }

    public final void AZOQYO(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f7330AmA8tU;
        checkableImageButton.setImageDrawable(drawable);
        AcNBzu();
        JrXYwF.A4TApA.AZOQYO(this.f7328AcNBzu, checkableImageButton, this.f7331AzWtSf, this.f7332B25kr6);
    }

    public final void AZkASS(AzWtSf azWtSf) {
        if (this.f7346BmvVmW == null) {
            return;
        }
        if (azWtSf.AMqCpz() != null) {
            this.f7346BmvVmW.setOnFocusChangeListener(azWtSf.AMqCpz());
        }
        if (azWtSf.ASJ6gh() != null) {
            this.f7334B3GDIM.setOnFocusChangeListener(azWtSf.ASJ6gh());
        }
    }

    public final void AaHO0E() {
        this.f7329AlLFFp.setVisibility((this.f7334B3GDIM.getVisibility() != 0 || AMqCpz()) ? 8 : 0);
        setVisibility((ADYaiT() || AMqCpz() || ((this.f7343BPw6Q8 == null || this.f7345BV3sI0) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void AcNBzu() {
        CheckableImageButton checkableImageButton = this.f7330AmA8tU;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f7328AcNBzu;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f11917BChYOn.f7373B2KMhB && textInputLayout.AzWtSf()) ? 0 : 8);
        AaHO0E();
        AlLFFp();
        if (this.f7336B7CMnp != 0) {
            return;
        }
        textInputLayout.B4ZgIw();
    }

    public final void AlLFFp() {
        TextInputLayout textInputLayout = this.f7328AcNBzu;
        if (textInputLayout.f11911B25kr6 == null) {
            return;
        }
        this.f7344BTvldC.setPaddingRelative(getContext().getResources().getDimensionPixelSize(2131166323), textInputLayout.f11911B25kr6.getPaddingTop(), (ADYaiT() || AMqCpz()) ? 0 : textInputLayout.f11911B25kr6.getPaddingEnd(), textInputLayout.f11911B25kr6.getPaddingBottom());
    }

    public final void AmA8tU() {
        AppCompatTextView appCompatTextView = this.f7344BTvldC;
        int visibility = appCompatTextView.getVisibility();
        int i = (this.f7343BPw6Q8 == null || this.f7345BV3sI0) ? 8 : 0;
        if (visibility != i) {
            A4TApA().B25kr6(i == 0);
        }
        AaHO0E();
        appCompatTextView.setVisibility(i);
        this.f7328AcNBzu.B4ZgIw();
    }
}
