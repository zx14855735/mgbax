package com.google.android.material.checkbox;

import ADYaiT.CtFAbx;
import AaHO0E.BChYOn;
import AaHO0E.GYpKKt;
import BTvldC.AcNBzu;
import BTvldC.B4ZgIw;
import DcUJf1.ADYaiT;
import DcUJf1.AMqCpz;
import DcUJf1.ARc23Z;
import NOd7IU.AlLFFp;
import OLy1FW.AYUAbz;
import Oay4Bh.C4FrIb;
import OvgpEe.A5SV6n;
import P3rngT.A4TApA;
import PXXBzr.A2egSU;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import com.google.android.material.R$styleable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialCheckBox extends BChYOn {

    /* renamed from: CNPG0E, reason: collision with root package name */
    public static final int[] f11523CNPG0E = {2130969921};

    /* renamed from: COJEAR, reason: collision with root package name */
    public static final int[] f11524COJEAR = {2130969920};

    /* renamed from: CQhlFr, reason: collision with root package name */
    public static final int[][] f11525CQhlFr = {new int[]{R.attr.state_enabled, 2130969920}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: CSDoyG, reason: collision with root package name */
    public static final int f11526CSDoyG = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    /* renamed from: B25kr6, reason: collision with root package name */
    public final LinkedHashSet f11527B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final LinkedHashSet f11528B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ColorStateList f11529B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f11530B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f11531B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f11532B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public CharSequence f11533BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public Drawable f11534BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public Drawable f11535BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f11536BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public ColorStateList f11537BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public ColorStateList f11538BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public PorterDuff.Mode f11539BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f11540BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int[] f11541BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f11542BniPrB;
    public CharSequence BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f11543C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final ARc23Z f11544C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final A5SV6n f11545CASmeH;

    static {
        KbBGjM();
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130968775, 2131952854), attributeSet, 2130968775);
        ARc23Z aRc23Z;
        int next;
        this.f11527B25kr6 = new LinkedHashSet();
        this.f11528B2KMhB = new LinkedHashSet();
        Context context2 = getContext();
        if (Build.VERSION.SDK_INT >= 24) {
            aRc23Z = new ARc23Z(context2);
            Resources resources = context2.getResources();
            Resources.Theme theme = context2.getTheme();
            ThreadLocal threadLocal = B4ZgIw.f1468A2egSU;
            Drawable A2egSU2 = AcNBzu.A2egSU(resources, 2131231361, theme);
            aRc23Z.f2331AcNBzu = A2egSU2;
            A2egSU2.setCallback(aRc23Z.f2327B2KMhB);
            new AMqCpz(0, aRc23Z.f2331AcNBzu.getConstantState());
        } else {
            int i = ARc23Z.f2322B3GDIM;
            try {
                XmlResourceParser xml = context2.getResources().getXml(2131231361);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                Resources resources2 = context2.getResources();
                Resources.Theme theme2 = context2.getTheme();
                ARc23Z aRc23Z2 = new ARc23Z(context2);
                aRc23Z2.inflate(resources2, xml, asAttributeSet, theme2);
                aRc23Z = aRc23Z2;
            } catch (IOException | XmlPullParserException unused) {
                aRc23Z = null;
            }
        }
        this.f11544C4FrIb = aRc23Z;
        this.f11545CASmeH = new A5SV6n(this, 2);
        Context context3 = getContext();
        this.f11534BI9f7h = AlLFFp.CNPG0E(this);
        this.f11537BNL6CD = getSuperButtonTintList();
        setSupportButtonTintList(null);
        GYpKKt AzWtSf2 = C4FrIb.AzWtSf(context3, attributeSet, R$styleable.f11238BTvldC, 2130968775, 2131952854, new int[0]);
        this.f11535BIYEnU = AzWtSf2.A4TApA(2);
        Drawable drawable = this.f11534BI9f7h;
        TypedArray typedArray = AzWtSf2.f884A4TApA;
        if (drawable != null && A4TApA.A4TApA(context3, 2130969267, false)) {
            int resourceId = typedArray.getResourceId(0, 0);
            int resourceId2 = typedArray.getResourceId(1, 0);
            if (resourceId == f11526CSDoyG && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f11534BI9f7h = AlLFFp.CQhlFr(context3, 2131231360);
                this.f11536BJ7GGh = true;
                if (this.f11535BIYEnU == null) {
                    this.f11535BIYEnU = AlLFFp.CQhlFr(context3, 2131231362);
                }
            }
        }
        this.f11538BPw6Q8 = com.bumptech.glide.AMqCpz.BNL6CD(context3, AzWtSf2, 3);
        this.f11539BTvldC = C4FrIb.B25kr6(typedArray.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.f11530B4ZgIw = typedArray.getBoolean(10, false);
        this.f11531B7CMnp = typedArray.getBoolean(6, true);
        this.f11532B9tovu = typedArray.getBoolean(9, false);
        this.f11533BChYOn = typedArray.getText(8);
        if (typedArray.hasValue(7)) {
            setCheckedState(typedArray.getInt(7, 0));
        }
        AzWtSf2.ASJ6gh();
        A2egSU();
    }

    private static /* synthetic */ void KbBGjM() {
        char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 250);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 250);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private String getButtonStateDescription() {
        int i = this.f11540BV3sI0;
        return i == 1 ? getResources().getString(2131886560) : i == 0 ? getResources().getString(2131886562) : getResources().getString(2131886561);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f11529B3GDIM == null) {
            int ASJ6gh2 = AYUAbz.ASJ6gh(2130968852, this);
            int ASJ6gh3 = AYUAbz.ASJ6gh(2130968855, this);
            int ASJ6gh4 = AYUAbz.ASJ6gh(2130968895, this);
            int ASJ6gh5 = AYUAbz.ASJ6gh(2130968872, this);
            this.f11529B3GDIM = new ColorStateList(f11525CQhlFr, new int[]{AYUAbz.AaHO0E(1.0f, ASJ6gh4, ASJ6gh3), AYUAbz.AaHO0E(1.0f, ASJ6gh4, ASJ6gh2), AYUAbz.AaHO0E(0.54f, ASJ6gh4, ASJ6gh5), AYUAbz.AaHO0E(0.38f, ASJ6gh4, ASJ6gh5), AYUAbz.AaHO0E(0.38f, ASJ6gh4, ASJ6gh5)});
        }
        return this.f11529B3GDIM;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f11537BNL6CD;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void A2egSU() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AaHO0E.A5SV6n a5SV6n;
        Drawable drawable = this.f11534BI9f7h;
        ColorStateList colorStateList3 = this.f11537BNL6CD;
        PorterDuff.Mode A4TApA2 = CikNvS.A4TApA.A4TApA(this);
        int i = Build.VERSION.SDK_INT;
        this.f11534BI9f7h = JrXYwF.A4TApA.BPw6Q8(drawable, colorStateList3, A4TApA2, i < 23);
        this.f11535BIYEnU = JrXYwF.A4TApA.BPw6Q8(this.f11535BIYEnU, this.f11538BPw6Q8, this.f11539BTvldC, i < 23);
        if (this.f11536BJ7GGh) {
            ARc23Z aRc23Z = this.f11544C4FrIb;
            if (aRc23Z != null) {
                Drawable drawable2 = aRc23Z.f2331AcNBzu;
                A5SV6n a5SV6n2 = this.f11545CASmeH;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable2;
                    if (a5SV6n2.f2315A2egSU == null) {
                        a5SV6n2.f2315A2egSU = new DcUJf1.A4TApA(a5SV6n2);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(a5SV6n2.f2315A2egSU);
                }
                ArrayList arrayList = aRc23Z.f2326B25kr6;
                ADYaiT aDYaiT = aRc23Z.f2323AlLFFp;
                if (arrayList != null && a5SV6n2 != null) {
                    arrayList.remove(a5SV6n2);
                    if (aRc23Z.f2326B25kr6.size() == 0 && (a5SV6n = aRc23Z.f2325AzWtSf) != null) {
                        aDYaiT.f2317A4TApA.removeListener(a5SV6n);
                        aRc23Z.f2325AzWtSf = null;
                    }
                }
                Drawable drawable3 = aRc23Z.f2331AcNBzu;
                if (drawable3 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable3;
                    if (a5SV6n2.f2315A2egSU == null) {
                        a5SV6n2.f2315A2egSU = new DcUJf1.A4TApA(a5SV6n2);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(a5SV6n2.f2315A2egSU);
                } else if (a5SV6n2 != null) {
                    if (aRc23Z.f2326B25kr6 == null) {
                        aRc23Z.f2326B25kr6 = new ArrayList();
                    }
                    if (!aRc23Z.f2326B25kr6.contains(a5SV6n2)) {
                        aRc23Z.f2326B25kr6.add(a5SV6n2);
                        if (aRc23Z.f2325AzWtSf == null) {
                            aRc23Z.f2325AzWtSf = new AaHO0E.A5SV6n(3, aRc23Z);
                        }
                        aDYaiT.f2317A4TApA.addListener(aRc23Z.f2325AzWtSf);
                    }
                }
            }
            if (i >= 24) {
                Drawable drawable4 = this.f11534BI9f7h;
                if ((drawable4 instanceof AnimatedStateListDrawable) && aRc23Z != null) {
                    ((AnimatedStateListDrawable) drawable4).addTransition(2131296494, 2131298272, aRc23Z, false);
                    ((AnimatedStateListDrawable) this.f11534BI9f7h).addTransition(2131296738, 2131298272, aRc23Z, false);
                }
            }
        }
        Drawable drawable5 = this.f11534BI9f7h;
        if (drawable5 != null && (colorStateList2 = this.f11537BNL6CD) != null) {
            drawable5.setTintList(colorStateList2);
        }
        Drawable drawable6 = this.f11535BIYEnU;
        if (drawable6 != null && (colorStateList = this.f11538BPw6Q8) != null) {
            drawable6.setTintList(colorStateList);
        }
        super.setButtonDrawable(JrXYwF.A4TApA.B9tovu(this.f11534BI9f7h, this.f11535BIYEnU, -1, -1));
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f11534BI9f7h;
    }

    public Drawable getButtonIconDrawable() {
        return this.f11535BIYEnU;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f11538BPw6Q8;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f11539BTvldC;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f11537BNL6CD;
    }

    public int getCheckedState() {
        return this.f11540BV3sI0;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f11533BChYOn;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f11540BV3sI0 == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f11530B4ZgIw && this.f11537BNL6CD == null && this.f11538BPw6Q8 == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f11523CNPG0E);
        }
        if (this.f11532B9tovu) {
            View.mergeDrawableStates(onCreateDrawableState, f11524COJEAR);
        }
        this.f11541BmvVmW = JrXYwF.A4TApA.BpkvW3(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable CNPG0E2;
        if (!this.f11531B7CMnp || !TextUtils.isEmpty(getText()) || (CNPG0E2 = AlLFFp.CNPG0E(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - CNPG0E2.getIntrinsicWidth()) / 2) * (getLayoutDirection() == 1 ? -1 : 1);
        int save = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = CNPG0E2.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f11532B9tovu) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f11533BChYOn));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof OIlOLF.A2egSU)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        OIlOLF.A2egSU a2egSU = (OIlOLF.A2egSU) parcelable;
        super.onRestoreInstanceState(a2egSU.getSuperState());
        setCheckedState(a2egSU.f6270AcNBzu);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        OIlOLF.A2egSU a2egSU = new OIlOLF.A2egSU(super.onSaveInstanceState());
        a2egSU.f6270AcNBzu = getCheckedState();
        return a2egSU;
    }

    @Override // AaHO0E.BChYOn, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f11535BIYEnU = drawable;
        A2egSU();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f11538BPw6Q8 == colorStateList) {
            return;
        }
        this.f11538BPw6Q8 = colorStateList;
        A2egSU();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f11539BTvldC == mode) {
            return;
        }
        this.f11539BTvldC = mode;
        A2egSU();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f11537BNL6CD == colorStateList) {
            return;
        }
        this.f11537BNL6CD = colorStateList;
        A2egSU();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        A2egSU();
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.f11531B7CMnp = z;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedState(z ? 1 : 0);
    }

    public void setCheckedState(int i) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f11540BV3sI0 != i) {
            this.f11540BV3sI0 = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && this.BpkvW3 == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f11542BniPrB) {
                return;
            }
            this.f11542BniPrB = true;
            LinkedHashSet linkedHashSet = this.f11528B2KMhB;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw CtFAbx.A5SV6n(it);
                }
            }
            if (this.f11540BV3sI0 != 2 && (onCheckedChangeListener = this.f11543C2rE4F) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i2 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f11542BniPrB = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f11533BChYOn = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z) {
        if (this.f11532B9tovu == z) {
            return;
        }
        this.f11532B9tovu = z;
        refreshDrawableState();
        Iterator it = this.f11527B25kr6.iterator();
        if (it.hasNext()) {
            throw CtFAbx.A5SV6n(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f11543C2rE4F = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.BpkvW3 = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f11530B4ZgIw = z;
        if (z) {
            CikNvS.A4TApA.A5SV6n(this, getMaterialThemeColorsTintList());
        } else {
            CikNvS.A4TApA.A5SV6n(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // AaHO0E.BChYOn, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f11534BI9f7h = drawable;
        this.f11536BJ7GGh = false;
        A2egSU();
    }
}
