package com.google.android.material.button;

import ADYaiT.CtFAbx;
import AaHO0E.B9tovu;
import Cd8JRx.ADYaiT;
import CtFAbx.ASJ6gh;
import CtFAbx.AYUAbz;
import IQ76hF.AmA8tU;
import NOd7IU.AlLFFp;
import O1nrJm.A2egSU;
import O1nrJm.A4TApA;
import O1nrJm.ARc23Z;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import PCV8se.BPw6Q8;
import PCV8se.C2rE4F;
import PCV8se.CASmeH;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.bumptech.glide.A5SV6n;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialButton extends B9tovu implements Checkable, BPw6Q8 {

    /* renamed from: CikNvS, reason: collision with root package name */
    public static final int[] f11457CikNvS = {R.attr.state_checkable};

    /* renamed from: CkXcdM, reason: collision with root package name */
    public static final int[] f11458CkXcdM = {R.attr.state_checked};

    /* renamed from: CmUvjW, reason: collision with root package name */
    public static final A2egSU f11459CmUvjW = new A2egSU(0);

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ARc23Z f11460AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final LinkedHashSet f11461B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public A4TApA f11462B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public PorterDuff.Mode f11463B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ColorStateList f11464B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Drawable f11465B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public String f11466B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f11467BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f11468BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f11469BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f11470BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f11471BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f11472BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f11473BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f11474BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public float f11475BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f11476BniPrB;
    public int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public LinearLayout.LayoutParams f11477C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f11478C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public int f11479CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f11480CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public int f11481COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public CASmeH f11482CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int f11483CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public float f11484CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public float f11485CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public ASJ6gh f11486Cd8JRx;

    static {
        XTdP();
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A4TApA(context, attributeSet, 2130969536, 2131952830, new int[]{2130969572}), attributeSet, 2130969536);
        this.f11461B25kr6 = new LinkedHashSet();
        this.f11471BNL6CD = false;
        this.f11472BPw6Q8 = false;
        this.f11474BV3sI0 = -1;
        this.f11475BmvVmW = -1.0f;
        this.f11476BniPrB = -1;
        this.BpkvW3 = -1;
        this.f11481COJEAR = -1;
        Context context2 = getContext();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11232BChYOn, 2130969536, 2131952830, new int[0]);
        this.f11470BJ7GGh = AmA8tU2.getDimensionPixelSize(13, 0);
        int i = AmA8tU2.getInt(16, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f11463B3GDIM = C4FrIb.B25kr6(i, mode);
        this.f11464B4ZgIw = AMqCpz.BPw6Q8(getContext(), AmA8tU2, 15);
        this.f11465B7CMnp = AMqCpz.BV3sI0(getContext(), AmA8tU2, 11);
        this.f11473BTvldC = AmA8tU2.getInteger(12, 1);
        this.f11467BChYOn = AmA8tU2.getDimensionPixelSize(14, 0);
        C2rE4F A4TApA2 = C2rE4F.A4TApA(context2, AmA8tU2, 19);
        B2KMhB A5SV6n2 = A4TApA2 != null ? A4TApA2.A5SV6n() : B2KMhB.A5SV6n(context2, attributeSet, 2130969536, 2131952830).A2egSU();
        boolean z = AmA8tU2.getBoolean(17, false);
        ARc23Z aRc23Z = new ARc23Z(this, A5SV6n2);
        this.f11460AzWtSf = aRc23Z;
        aRc23Z.f6176ARc23Z = AmA8tU2.getDimensionPixelOffset(2, 0);
        aRc23Z.f6177ASJ6gh = AmA8tU2.getDimensionPixelOffset(3, 0);
        aRc23Z.f6178AYUAbz = AmA8tU2.getDimensionPixelOffset(4, 0);
        aRc23Z.f6179AZOQYO = AmA8tU2.getDimensionPixelOffset(5, 0);
        if (AmA8tU2.hasValue(9)) {
            int dimensionPixelSize = AmA8tU2.getDimensionPixelSize(9, -1);
            aRc23Z.f6180AZkASS = dimensionPixelSize;
            B2KMhB.A2egSU ASJ6gh2 = aRc23Z.f6173A4TApA.ASJ6gh();
            ASJ6gh2.A5SV6n(dimensionPixelSize);
            aRc23Z.f6173A4TApA = ASJ6gh2.A2egSU();
            aRc23Z.f6174A5SV6n = null;
            aRc23Z.ADYaiT();
            aRc23Z.f6189B4ZgIw = true;
        }
        aRc23Z.f6181AaHO0E = AmA8tU2.getDimensionPixelSize(22, 0);
        aRc23Z.f6182AcNBzu = C4FrIb.B25kr6(AmA8tU2.getInt(8, -1), mode);
        aRc23Z.f6183AlLFFp = AMqCpz.BPw6Q8(getContext(), AmA8tU2, 7);
        aRc23Z.f6184AmA8tU = AMqCpz.BPw6Q8(getContext(), AmA8tU2, 21);
        aRc23Z.f6185AzWtSf = AMqCpz.BPw6Q8(getContext(), AmA8tU2, 18);
        aRc23Z.f6190B7CMnp = AmA8tU2.getBoolean(6, false);
        aRc23Z.f6193BI9f7h = AmA8tU2.getDimensionPixelSize(10, 0);
        aRc23Z.f6191B9tovu = AmA8tU2.getBoolean(23, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (AmA8tU2.hasValue(0)) {
            aRc23Z.f6188B3GDIM = true;
            setSupportBackgroundTintList(aRc23Z.f6183AlLFFp);
            setSupportBackgroundTintMode(aRc23Z.f6182AcNBzu);
        } else {
            aRc23Z.A5SV6n();
        }
        setPaddingRelative(paddingStart + aRc23Z.f6176ARc23Z, paddingTop + aRc23Z.f6178AYUAbz, paddingEnd + aRc23Z.f6177ASJ6gh, paddingBottom + aRc23Z.f6179AZOQYO);
        setCheckedInternal(AmA8tU2.getBoolean(1, false));
        if (A4TApA2 != null) {
            aRc23Z.f6175ADYaiT = ADYaiT();
            if (aRc23Z.f6174A5SV6n != null) {
                aRc23Z.ADYaiT();
            }
            aRc23Z.f6174A5SV6n = A4TApA2;
            aRc23Z.ADYaiT();
        }
        setOpticalCenterEnabled(z);
        AmA8tU2.recycle();
        setCompoundDrawablePadding(this.f11470BJ7GGh);
        AYUAbz(this.f11465B7CMnp != null);
    }

    public static /* synthetic */ void A2egSU(MaterialButton materialButton) {
        materialButton.f11479CASmeH = materialButton.getOpticalCenterShift();
        materialButton.AZkASS();
        materialButton.invalidate();
    }

    private static /* synthetic */ void XTdP() {
        char[] charArray = "#/-n'!-%n\"/9n3(%,,n\n.)\u00022)$'%".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '@');
        }
        String str = new String(charArray);
        char[] charArray2 = "#,).)4".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '@');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.f11484CTkVKb;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        AaHO0E A2egSU2;
        if (this.f11478C4FrIb && this.f11480CNPG0E && (A2egSU2 = this.f11460AzWtSf.A2egSU(false)) != null) {
            return (int) (A2egSU2.AZOQYO() * 0.11f);
        }
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            f = Math.max(f, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(f);
    }

    private void setCheckedInternal(boolean z) {
        ARc23Z aRc23Z = this.f11460AzWtSf;
        if (aRc23Z == null || !aRc23Z.f6190B7CMnp || this.f11471BNL6CD == z) {
            return;
        }
        this.f11471BNL6CD = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z2 = this.f11471BNL6CD;
            if (!materialButtonToggleGroup.f11489BI9f7h) {
                materialButtonToggleGroup.ARc23Z(getId(), z2);
            }
        }
        if (this.f11472BPw6Q8) {
            return;
        }
        this.f11472BPw6Q8 = true;
        Iterator it = this.f11461B25kr6.iterator();
        if (it.hasNext()) {
            throw CtFAbx.A5SV6n(it);
        }
        this.f11472BPw6Q8 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        if (this.f11484CTkVKb != f) {
            this.f11484CTkVKb = f;
            AZkASS();
            invalidate();
            if (getParent() instanceof O1nrJm.AMqCpz) {
                O1nrJm.AMqCpz aMqCpz = (O1nrJm.AMqCpz) getParent();
                int i = (int) this.f11484CTkVKb;
                int indexOfChild = aMqCpz.indexOfChild(this);
                if (indexOfChild < 0) {
                    return;
                }
                int i2 = indexOfChild - 1;
                while (true) {
                    materialButton = null;
                    if (i2 < 0) {
                        materialButton2 = null;
                        break;
                    } else {
                        if (aMqCpz.A5SV6n(i2)) {
                            materialButton2 = (MaterialButton) aMqCpz.getChildAt(i2);
                            break;
                        }
                        i2--;
                    }
                }
                int childCount = aMqCpz.getChildCount();
                while (true) {
                    indexOfChild++;
                    if (indexOfChild >= childCount) {
                        break;
                    } else if (aMqCpz.A5SV6n(indexOfChild)) {
                        materialButton = (MaterialButton) aMqCpz.getChildAt(indexOfChild);
                        break;
                    }
                }
                if (materialButton2 == null && materialButton == null) {
                    return;
                }
                if (materialButton2 == null) {
                    materialButton.setDisplayedWidthDecrease(i);
                }
                if (materialButton == null) {
                    materialButton2.setDisplayedWidthDecrease(i);
                }
                if (materialButton2 == null || materialButton == null) {
                    return;
                }
                materialButton2.setDisplayedWidthDecrease(i / 2);
                materialButton.setDisplayedWidthDecrease((i + 1) / 2);
            }
        }
    }

    public final AYUAbz ADYaiT() {
        Context context = getContext();
        TypedValue A2egSU2 = P3rngT.A4TApA.A2egSU(context, 2130969655);
        int[] iArr = R$styleable.BpkvW3;
        TypedArray obtainStyledAttributes = A2egSU2 == null ? context.obtainStyledAttributes(null, iArr, 0, 2131951962) : context.obtainStyledAttributes(A2egSU2.resourceId, iArr);
        AYUAbz aYUAbz = new AYUAbz();
        try {
            float f = obtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f2 = obtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f2 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            aYUAbz.A4TApA(f);
            aYUAbz.A2egSU(f2);
            return aYUAbz;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final boolean AMqCpz() {
        ARc23Z aRc23Z = this.f11460AzWtSf;
        return (aRc23Z == null || aRc23Z.f6188B3GDIM) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (r1 == 2) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ARc23Z(boolean r9) {
        /*
            r8 = this;
            PCV8se.CASmeH r0 = r8.f11482CQhlFr
            if (r0 != 0) goto L6
            goto L86
        L6:
            CtFAbx.ASJ6gh r0 = r8.f11486Cd8JRx
            if (r0 != 0) goto L19
            CtFAbx.ASJ6gh r0 = new CtFAbx.ASJ6gh
            O1nrJm.A2egSU r1 = com.google.android.material.button.MaterialButton.f11459CmUvjW
            r0.<init>(r8, r1)
            r8.f11486Cd8JRx = r0
            CtFAbx.AYUAbz r1 = r8.ADYaiT()
            r0.f1905AaHO0E = r1
        L19:
            boolean r0 = r8.f11480CNPG0E
            if (r0 == 0) goto L86
            int r0 = r8.f11483CSDoyG
            PCV8se.CASmeH r1 = r8.f11482CQhlFr
            int[] r2 = r8.getDrawableState()
            int[][] r3 = r1.f7161A5SV6n
            r4 = 0
            r5 = 0
        L29:
            int r6 = r1.f7159A2egSU
            r7 = -1
            if (r5 >= r6) goto L3a
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L37
            goto L3b
        L37:
            int r5 = r5 + 1
            goto L29
        L3a:
            r5 = -1
        L3b:
            if (r5 >= 0) goto L54
            int[] r2 = android.util.StateSet.WILD_CARD
            int[][] r3 = r1.f7161A5SV6n
            r5 = 0
        L42:
            int r6 = r1.f7159A2egSU
            if (r5 >= r6) goto L53
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L50
            r7 = r5
            goto L53
        L50:
            int r5 = r5 + 1
            goto L42
        L53:
            r5 = r7
        L54:
            if (r5 >= 0) goto L59
            NGepWW.A2egSU r1 = r1.f7160A4TApA
            goto L5d
        L59:
            NGepWW.A2egSU[] r1 = r1.f7162ADYaiT
            r1 = r1[r5]
        L5d:
            java.lang.Object r1 = r1.f5658AlLFFp
            PCV8se.C4FrIb r1 = (PCV8se.C4FrIb) r1
            int r2 = r8.getWidth()
            float r3 = r1.f7158A4TApA
            int r1 = r1.f7157A2egSU
            r5 = 1
            if (r1 != r5) goto L71
            float r1 = (float) r2
            float r3 = r3 * r1
        L6f:
            int r4 = (int) r3
            goto L75
        L71:
            r2 = 2
            if (r1 != r2) goto L75
            goto L6f
        L75:
            int r0 = java.lang.Math.min(r0, r4)
            CtFAbx.ASJ6gh r1 = r8.f11486Cd8JRx
            float r0 = (float) r0
            r1.A2egSU(r0)
            if (r9 == 0) goto L86
            CtFAbx.ASJ6gh r9 = r8.f11486Cd8JRx
            r9.ADYaiT()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.ARc23Z(boolean):void");
    }

    public final void ASJ6gh() {
        int i = this.f11473BTvldC;
        boolean z = true;
        if (i != 1 && i != 2) {
            z = false;
        }
        if (z) {
            setCompoundDrawablesRelative(this.f11465B7CMnp, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.f11465B7CMnp, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.f11465B7CMnp, null, null);
        }
    }

    public final void AYUAbz(boolean z) {
        Drawable drawable = this.f11465B7CMnp;
        if (drawable != null) {
            Drawable mutate = A5SV6n.DvK7DB(drawable).mutate();
            this.f11465B7CMnp = mutate;
            mutate.setTintList(this.f11464B4ZgIw);
            PorterDuff.Mode mode = this.f11463B3GDIM;
            if (mode != null) {
                this.f11465B7CMnp.setTintMode(mode);
            }
            int i = this.f11467BChYOn;
            if (i == 0) {
                i = this.f11465B7CMnp.getIntrinsicWidth();
            }
            int i2 = this.f11467BChYOn;
            if (i2 == 0) {
                i2 = this.f11465B7CMnp.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f11465B7CMnp;
            int i3 = this.f11468BI9f7h;
            int i4 = this.f11469BIYEnU;
            drawable2.setBounds(i3, i4, i + i3, i2 + i4);
            this.f11465B7CMnp.setVisible(true, z);
        }
        if (z) {
            ASJ6gh();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i5 = this.f11473BTvldC;
        if (((i5 == 1 || i5 == 2) && drawable3 != this.f11465B7CMnp) || (((i5 == 3 || i5 == 4) && drawable5 != this.f11465B7CMnp) || ((i5 == 16 || i5 == 32) && drawable4 != this.f11465B7CMnp))) {
            ASJ6gh();
        }
    }

    public final void AZOQYO(int i, int i2) {
        if (this.f11465B7CMnp == null || getLayout() == null) {
            return;
        }
        int i3 = this.f11473BTvldC;
        if (!(i3 == 1 || i3 == 2) && i3 != 3 && i3 != 4) {
            if (i3 == 16 || i3 == 32) {
                this.f11468BI9f7h = 0;
                if (i3 == 16) {
                    this.f11469BIYEnU = 0;
                    AYUAbz(false);
                    return;
                }
                int i4 = this.f11467BChYOn;
                if (i4 == 0) {
                    i4 = this.f11465B7CMnp.getIntrinsicHeight();
                }
                int max = Math.max(0, (((((i2 - getTextHeight()) - getPaddingTop()) - i4) - this.f11470BJ7GGh) - getPaddingBottom()) / 2);
                if (this.f11469BIYEnU != max) {
                    this.f11469BIYEnU = max;
                    AYUAbz(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f11469BIYEnU = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i5 = this.f11473BTvldC;
        if (i5 == 1 || i5 == 3 || ((i5 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i5 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f11468BI9f7h = 0;
            AYUAbz(false);
            return;
        }
        int i6 = this.f11467BChYOn;
        if (i6 == 0) {
            i6 = this.f11465B7CMnp.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i - getTextLayoutWidth()) - getPaddingEnd()) - i6) - this.f11470BJ7GGh) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.f11473BTvldC == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f11468BI9f7h != textLayoutWidth) {
            this.f11468BI9f7h = textLayoutWidth;
            AYUAbz(false);
        }
    }

    public final void AZkASS() {
        int i = (int) (this.f11484CTkVKb - this.f11485CcAIMM);
        int i2 = (i / 2) + this.f11479CASmeH;
        getLayoutParams().width = (int) (this.f11475BmvVmW + i);
        setPaddingRelative(this.f11476BniPrB + i2, getPaddingTop(), (this.BpkvW3 + i) - i2, getPaddingBottom());
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f11466B9tovu)) {
            return this.f11466B9tovu;
        }
        ARc23Z aRc23Z = this.f11460AzWtSf;
        return ((aRc23Z == null || !aRc23Z.f6190B7CMnp) ? Button.class : CompoundButton.class).getName();
    }

    public int getAllowedWidthDecrease() {
        return this.f11481COJEAR;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (AMqCpz()) {
            return this.f11460AzWtSf.f6180AZkASS;
        }
        return 0;
    }

    public AYUAbz getCornerSpringForce() {
        return this.f11460AzWtSf.f6175ADYaiT;
    }

    public Drawable getIcon() {
        return this.f11465B7CMnp;
    }

    public int getIconGravity() {
        return this.f11473BTvldC;
    }

    public int getIconPadding() {
        return this.f11470BJ7GGh;
    }

    public int getIconSize() {
        return this.f11467BChYOn;
    }

    public ColorStateList getIconTint() {
        return this.f11464B4ZgIw;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f11463B3GDIM;
    }

    public int getInsetBottom() {
        return this.f11460AzWtSf.f6179AZOQYO;
    }

    public int getInsetTop() {
        return this.f11460AzWtSf.f6178AYUAbz;
    }

    public ColorStateList getRippleColor() {
        if (AMqCpz()) {
            return this.f11460AzWtSf.f6185AzWtSf;
        }
        return null;
    }

    public B2KMhB getShapeAppearanceModel() {
        if (AMqCpz()) {
            return this.f11460AzWtSf.f6173A4TApA;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public C2rE4F getStateListShapeAppearanceModel() {
        if (AMqCpz()) {
            return this.f11460AzWtSf.f6174A5SV6n;
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (AMqCpz()) {
            return this.f11460AzWtSf.f6184AmA8tU;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (AMqCpz()) {
            return this.f11460AzWtSf.f6181AaHO0E;
        }
        return 0;
    }

    @Override // AaHO0E.B9tovu
    public ColorStateList getSupportBackgroundTintList() {
        return AMqCpz() ? this.f11460AzWtSf.f6183AlLFFp : super.getSupportBackgroundTintList();
    }

    @Override // AaHO0E.B9tovu
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return AMqCpz() ? this.f11460AzWtSf.f6182AcNBzu : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f11471BNL6CD;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (AMqCpz()) {
            AlLFFp.CtxOCS(this, this.f11460AzWtSf.A2egSU(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        ARc23Z aRc23Z = this.f11460AzWtSf;
        if (aRc23Z != null && aRc23Z.f6190B7CMnp) {
            View.mergeDrawableStates(onCreateDrawableState, f11457CikNvS);
        }
        if (this.f11471BNL6CD) {
            View.mergeDrawableStates(onCreateDrawableState, f11458CkXcdM);
        }
        return onCreateDrawableState;
    }

    @Override // AaHO0E.B9tovu, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f11471BNL6CD);
    }

    @Override // AaHO0E.B9tovu, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        ARc23Z aRc23Z = this.f11460AzWtSf;
        accessibilityNodeInfo.setCheckable(aRc23Z != null && aRc23Z.f6190B7CMnp);
        accessibilityNodeInfo.setChecked(this.f11471BNL6CD);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // AaHO0E.B9tovu, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        ARc23Z aRc23Z;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT == 21 && (aRc23Z = this.f11460AzWtSf) != null) {
            int i6 = i4 - i2;
            int i7 = i3 - i;
            AaHO0E aaHO0E = aRc23Z.f6186B25kr6;
            if (aaHO0E != null) {
                aaHO0E.setBounds(aRc23Z.f6176ARc23Z, aRc23Z.f6178AYUAbz, i7 - aRc23Z.f6177ASJ6gh, i6 - aRc23Z.f6179AZOQYO);
            }
        }
        AZOQYO(getMeasuredWidth(), getMeasuredHeight());
        int i8 = getResources().getConfiguration().orientation;
        if (this.f11474BV3sI0 != i8) {
            this.f11474BV3sI0 = i8;
            this.f11475BmvVmW = -1.0f;
        }
        if (this.f11475BmvVmW == -1.0f) {
            this.f11475BmvVmW = getMeasuredWidth();
            if (this.f11477C2rE4F == null && (getParent() instanceof O1nrJm.AMqCpz) && ((O1nrJm.AMqCpz) getParent()).getButtonSizeChange() != null) {
                this.f11477C2rE4F = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f11477C2rE4F);
                layoutParams.width = (int) this.f11475BmvVmW;
                setLayoutParams(layoutParams);
            }
        }
        boolean z2 = false;
        if (this.f11481COJEAR == -1) {
            if (this.f11465B7CMnp == null) {
                i5 = 0;
            } else {
                int iconPadding = getIconPadding();
                int i9 = this.f11467BChYOn;
                if (i9 == 0) {
                    i9 = this.f11465B7CMnp.getIntrinsicWidth();
                }
                i5 = iconPadding + i9;
            }
            this.f11481COJEAR = (getMeasuredWidth() - getTextLayoutWidth()) - i5;
        }
        if (this.f11476BniPrB == -1) {
            this.f11476BniPrB = getPaddingStart();
        }
        if (this.BpkvW3 == -1) {
            this.BpkvW3 = getPaddingEnd();
        }
        if ((getParent() instanceof O1nrJm.AMqCpz) && ((O1nrJm.AMqCpz) getParent()).getOrientation() == 0) {
            z2 = true;
        }
        this.f11480CNPG0E = z2;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof O1nrJm.A5SV6n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        O1nrJm.A5SV6n a5SV6n = (O1nrJm.A5SV6n) parcelable;
        super.onRestoreInstanceState(a5SV6n.getSuperState());
        setChecked(a5SV6n.f6160AcNBzu);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        O1nrJm.A5SV6n a5SV6n = new O1nrJm.A5SV6n(super.onSaveInstanceState());
        a5SV6n.f6160AcNBzu = this.f11471BNL6CD;
        return a5SV6n;
    }

    @Override // AaHO0E.B9tovu, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        AZOQYO(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.f11460AzWtSf.f6191B9tovu) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f11465B7CMnp != null) {
            if (this.f11465B7CMnp.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f11466B9tovu = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!AMqCpz()) {
            super.setBackgroundColor(i);
            return;
        }
        ARc23Z aRc23Z = this.f11460AzWtSf;
        if (aRc23Z.A2egSU(false) != null) {
            aRc23Z.A2egSU(false).setTint(i);
        }
    }

    @Override // AaHO0E.B9tovu, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!AMqCpz()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        ARc23Z aRc23Z = this.f11460AzWtSf;
        aRc23Z.f6188B3GDIM = true;
        ColorStateList colorStateList = aRc23Z.f6183AlLFFp;
        MaterialButton materialButton = aRc23Z.f6172A2egSU;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(aRc23Z.f6182AcNBzu);
        super.setBackgroundDrawable(drawable);
    }

    @Override // AaHO0E.B9tovu, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? AlLFFp.CQhlFr(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (AMqCpz()) {
            this.f11460AzWtSf.f6190B7CMnp = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedInternal(z);
    }

    public void setCornerRadius(int i) {
        if (AMqCpz()) {
            ARc23Z aRc23Z = this.f11460AzWtSf;
            if (aRc23Z.f6189B4ZgIw && aRc23Z.f6180AZkASS == i) {
                return;
            }
            aRc23Z.f6180AZkASS = i;
            aRc23Z.f6189B4ZgIw = true;
            B2KMhB.A2egSU ASJ6gh2 = aRc23Z.f6173A4TApA.ASJ6gh();
            ASJ6gh2.A5SV6n(i);
            aRc23Z.f6173A4TApA = ASJ6gh2.A2egSU();
            aRc23Z.f6174A5SV6n = null;
            aRc23Z.ADYaiT();
        }
    }

    public void setCornerRadiusResource(int i) {
        if (AMqCpz()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCornerSpringForce(AYUAbz aYUAbz) {
        ARc23Z aRc23Z = this.f11460AzWtSf;
        aRc23Z.f6175ADYaiT = aYUAbz;
        if (aRc23Z.f6174A5SV6n != null) {
            aRc23Z.ADYaiT();
        }
    }

    public void setDisplayedWidthDecrease(int i) {
        this.f11485CcAIMM = Math.min(i, this.f11481COJEAR);
        AZkASS();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (AMqCpz()) {
            this.f11460AzWtSf.A2egSU(false).B2KMhB(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f11465B7CMnp != drawable) {
            this.f11465B7CMnp = drawable;
            AYUAbz(true);
            AZOQYO(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.f11473BTvldC != i) {
            this.f11473BTvldC = i;
            AZOQYO(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.f11470BJ7GGh != i) {
            this.f11470BJ7GGh = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? AlLFFp.CQhlFr(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f11467BChYOn != i) {
            this.f11467BChYOn = i;
            AYUAbz(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f11464B4ZgIw != colorStateList) {
            this.f11464B4ZgIw = colorStateList;
            AYUAbz(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f11463B3GDIM != mode) {
            this.f11463B3GDIM = mode;
            AYUAbz(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(BPw6Q8.ASJ6gh.A5SV6n(getContext(), i));
    }

    public void setInsetBottom(int i) {
        ARc23Z aRc23Z = this.f11460AzWtSf;
        aRc23Z.A4TApA(aRc23Z.f6178AYUAbz, i);
    }

    public void setInsetTop(int i) {
        ARc23Z aRc23Z = this.f11460AzWtSf;
        aRc23Z.A4TApA(i, aRc23Z.f6179AZOQYO);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(A4TApA a4TApA) {
        this.f11462B2KMhB = a4TApA;
    }

    public void setOpticalCenterEnabled(boolean z) {
        if (this.f11478C4FrIb != z) {
            this.f11478C4FrIb = z;
            ARc23Z aRc23Z = this.f11460AzWtSf;
            if (z) {
                ADYaiT aDYaiT = new ADYaiT(8, this);
                aRc23Z.AMqCpz = aDYaiT;
                AaHO0E A2egSU2 = aRc23Z.A2egSU(false);
                if (A2egSU2 != null) {
                    A2egSU2.f7070Cd8JRx = aDYaiT;
                }
            } else {
                aRc23Z.AMqCpz = null;
                AaHO0E A2egSU3 = aRc23Z.A2egSU(false);
                if (A2egSU3 != null) {
                    A2egSU3.f7070Cd8JRx = null;
                }
            }
            post(new CtFAbx.A2egSU(5, this));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        A4TApA a4TApA = this.f11462B2KMhB;
        if (a4TApA != null) {
            ((MaterialButtonToggleGroup) ((AmA8tU) a4TApA).f3956AlLFFp).invalidate();
        }
        super.setPressed(z);
        ARc23Z(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (AMqCpz()) {
            ARc23Z aRc23Z = this.f11460AzWtSf;
            if (aRc23Z.f6185AzWtSf != colorStateList) {
                aRc23Z.f6185AzWtSf = colorStateList;
                MaterialButton materialButton = aRc23Z.f6172A2egSU;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(P5yM7D.A4TApA.A5SV6n(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (AMqCpz()) {
            setRippleColor(BPw6Q8.ASJ6gh.A5SV6n(getContext(), i));
        }
    }

    @Override // PCV8se.BPw6Q8
    public void setShapeAppearanceModel(B2KMhB b2KMhB) {
        if (!AMqCpz()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        ARc23Z aRc23Z = this.f11460AzWtSf;
        aRc23Z.f6173A4TApA = b2KMhB;
        aRc23Z.f6174A5SV6n = null;
        aRc23Z.ADYaiT();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (AMqCpz()) {
            ARc23Z aRc23Z = this.f11460AzWtSf;
            aRc23Z.f6187B2KMhB = z;
            aRc23Z.AMqCpz();
        }
    }

    public void setSizeChange(CASmeH cASmeH) {
        if (this.f11482CQhlFr != cASmeH) {
            this.f11482CQhlFr = cASmeH;
            ARc23Z(true);
        }
    }

    public void setStateListShapeAppearanceModel(C2rE4F c2rE4F) {
        if (!AMqCpz()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        ARc23Z aRc23Z = this.f11460AzWtSf;
        if (aRc23Z.f6175ADYaiT == null && c2rE4F.ADYaiT()) {
            aRc23Z.f6175ADYaiT = ADYaiT();
            if (aRc23Z.f6174A5SV6n != null) {
                aRc23Z.ADYaiT();
            }
        }
        aRc23Z.f6174A5SV6n = c2rE4F;
        aRc23Z.ADYaiT();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (AMqCpz()) {
            ARc23Z aRc23Z = this.f11460AzWtSf;
            if (aRc23Z.f6184AmA8tU != colorStateList) {
                aRc23Z.f6184AmA8tU = colorStateList;
                aRc23Z.AMqCpz();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (AMqCpz()) {
            setStrokeColor(BPw6Q8.ASJ6gh.A5SV6n(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (AMqCpz()) {
            ARc23Z aRc23Z = this.f11460AzWtSf;
            if (aRc23Z.f6181AaHO0E != i) {
                aRc23Z.f6181AaHO0E = i;
                aRc23Z.AMqCpz();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (AMqCpz()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // AaHO0E.B9tovu
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!AMqCpz()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        ARc23Z aRc23Z = this.f11460AzWtSf;
        if (aRc23Z.f6183AlLFFp != colorStateList) {
            aRc23Z.f6183AlLFFp = colorStateList;
            if (aRc23Z.A2egSU(false) != null) {
                aRc23Z.A2egSU(false).setTintList(aRc23Z.f6183AlLFFp);
            }
        }
    }

    @Override // AaHO0E.B9tovu
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!AMqCpz()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        ARc23Z aRc23Z = this.f11460AzWtSf;
        if (aRc23Z.f6182AcNBzu != mode) {
            aRc23Z.f6182AcNBzu = mode;
            if (aRc23Z.A2egSU(false) == null || aRc23Z.f6182AcNBzu == null) {
                return;
            }
            aRc23Z.A2egSU(false).setTintMode(aRc23Z.f6182AcNBzu);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        AZOQYO(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.f11460AzWtSf.f6191B9tovu = z;
    }

    @Override // android.widget.TextView
    public void setWidth(int i) {
        this.f11475BmvVmW = -1.0f;
        super.setWidth(i);
    }

    public void setWidthChangeMax(int i) {
        if (this.f11483CSDoyG != i) {
            this.f11483CSDoyG = i;
            ARc23Z(true);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f11471BNL6CD);
    }
}
