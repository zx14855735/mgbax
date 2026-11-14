package com.google.android.material.chip;

import AaHO0E.BChYOn;
import COJEAR.DG07BK;
import CQhlFr.ASJ6gh;
import NOd7IU.AlLFFp;
import NdEzCJ.A5SV6n;
import OLvDpK.A4TApA;
import OLvDpK.ADYaiT;
import OLvDpK.AMqCpz;
import OLvDpK.ARc23Z;
import Oay4Bh.AZOQYO;
import Oay4Bh.AZkASS;
import Oay4Bh.BniPrB;
import Oay4Bh.C4FrIb;
import PCV8se.B2KMhB;
import PCV8se.BPw6Q8;
import PXXBzr.A2egSU;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.R$styleable;
import com.google.android.material.chip.Chip;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Chip extends BChYOn implements AMqCpz, BPw6Q8, AZkASS {

    /* renamed from: CASmeH, reason: collision with root package name */
    public static final Rect f11546CASmeH = new Rect();

    /* renamed from: CNPG0E, reason: collision with root package name */
    public static final int[] f11547CNPG0E = {R.attr.state_selected};

    /* renamed from: COJEAR, reason: collision with root package name */
    public static final int[] f11548COJEAR = {R.attr.state_checkable};

    /* renamed from: B25kr6, reason: collision with root package name */
    public ARc23Z f11549B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public InsetDrawable f11550B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public RippleDrawable f11551B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public View.OnClickListener f11552B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f11553B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public AZOQYO f11554B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f11555BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f11556BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f11557BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f11558BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f11559BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f11560BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f11561BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public CharSequence f11562BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final ADYaiT f11563BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f11564BniPrB;
    public final Rect BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final RectF f11565C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final A4TApA f11566C4FrIb;

    static {
        QLGaC();
    }

    public Chip(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130968805, 2131952844), attributeSet, 2130968805);
        int resourceId;
        int resourceId2;
        int resourceId3;
        this.BpkvW3 = new Rect();
        this.f11565C2rE4F = new RectF();
        this.f11566C4FrIb = new A4TApA(0, this);
        Context context2 = getContext();
        if (attributeSet != null) {
            attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background");
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
        }
        ARc23Z aRc23Z = new ARc23Z(context2, attributeSet);
        int[] iArr = R$styleable.f11219AZOQYO;
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(aRc23Z.f6310EUIRHA, attributeSet, iArr, 2130968805, 2131952844, new int[0]);
        aRc23Z.G2rdQT = AmA8tU2.hasValue(37);
        Context context3 = aRc23Z.f6310EUIRHA;
        ColorStateList BPw6Q82 = com.bumptech.glide.AMqCpz.BPw6Q8(context3, AmA8tU2, 24);
        if (aRc23Z.f6279CmUvjW != BPw6Q82) {
            aRc23Z.f6279CmUvjW = BPw6Q82;
            aRc23Z.onStateChange(aRc23Z.getState());
        }
        ColorStateList BPw6Q83 = com.bumptech.glide.AMqCpz.BPw6Q8(context3, AmA8tU2, 11);
        if (aRc23Z.f6280CqNSpT != BPw6Q83) {
            aRc23Z.f6280CqNSpT = BPw6Q83;
            aRc23Z.onStateChange(aRc23Z.getState());
        }
        float dimension = AmA8tU2.getDimension(19, 0.0f);
        if (aRc23Z.f6281CrfGsy != dimension) {
            aRc23Z.f6281CrfGsy = dimension;
            aRc23Z.invalidateSelf();
            aRc23Z.COJEAR();
        }
        if (AmA8tU2.hasValue(12)) {
            aRc23Z.CikNvS(AmA8tU2.getDimension(12, 0.0f));
        }
        aRc23Z.CtFAbx(com.bumptech.glide.AMqCpz.BPw6Q8(context3, AmA8tU2, 22));
        aRc23Z.CtxOCS(AmA8tU2.getDimension(23, 0.0f));
        aRc23Z.DUi7mC(com.bumptech.glide.AMqCpz.BPw6Q8(context3, AmA8tU2, 36));
        String text = AmA8tU2.getText(5);
        text = text == null ? "" : text;
        boolean equals = TextUtils.equals(aRc23Z.f6286D6yqiO, text);
        BniPrB bniPrB = aRc23Z.f6315EmJGcg;
        if (!equals) {
            aRc23Z.f6286D6yqiO = text;
            bniPrB.AMqCpz = true;
            aRc23Z.invalidateSelf();
            aRc23Z.COJEAR();
        }
        P3rngT.AMqCpz aMqCpz = (!AmA8tU2.hasValue(0) || (resourceId3 = AmA8tU2.getResourceId(0, 0)) == 0) ? null : new P3rngT.AMqCpz(context3, resourceId3);
        aMqCpz.f6952AcNBzu = AmA8tU2.getDimension(1, aMqCpz.f6952AcNBzu);
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            aMqCpz.f6951AaHO0E = com.bumptech.glide.AMqCpz.BPw6Q8(context3, AmA8tU2, 2);
        }
        bniPrB.A5SV6n(aMqCpz, context3);
        int i2 = AmA8tU2.getInt(3, 0);
        if (i2 == 1) {
            aRc23Z.f6332FpcJKS = TextUtils.TruncateAt.START;
        } else if (i2 == 2) {
            aRc23Z.f6332FpcJKS = TextUtils.TruncateAt.MIDDLE;
        } else if (i2 == 3) {
            aRc23Z.f6332FpcJKS = TextUtils.TruncateAt.END;
        }
        aRc23Z.CrfGsy(AmA8tU2.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            aRc23Z.CrfGsy(AmA8tU2.getBoolean(15, false));
        }
        aRc23Z.CkXcdM(com.bumptech.glide.AMqCpz.BV3sI0(context3, AmA8tU2, 14));
        if (AmA8tU2.hasValue(17)) {
            aRc23Z.CqNSpT(com.bumptech.glide.AMqCpz.BPw6Q8(context3, AmA8tU2, 17));
        }
        aRc23Z.CmUvjW(AmA8tU2.getDimension(16, -1.0f));
        aRc23Z.DAk1zC(AmA8tU2.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            aRc23Z.DAk1zC(AmA8tU2.getBoolean(26, false));
        }
        aRc23Z.D07BeM(com.bumptech.glide.AMqCpz.BV3sI0(context3, AmA8tU2, 25));
        aRc23Z.D9tr6l(com.bumptech.glide.AMqCpz.BPw6Q8(context3, AmA8tU2, 30));
        aRc23Z.D6yqiO(AmA8tU2.getDimension(28, 0.0f));
        aRc23Z.CSDoyG(AmA8tU2.getBoolean(6, false));
        aRc23Z.Cd8JRx(AmA8tU2.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            aRc23Z.Cd8JRx(AmA8tU2.getBoolean(8, false));
        }
        aRc23Z.CTkVKb(com.bumptech.glide.AMqCpz.BV3sI0(context3, AmA8tU2, 7));
        if (AmA8tU2.hasValue(9)) {
            aRc23Z.CcAIMM(com.bumptech.glide.AMqCpz.BPw6Q8(context3, AmA8tU2, 9));
        }
        aRc23Z.f6300DjONCG = (!AmA8tU2.hasValue(39) || (resourceId2 = AmA8tU2.getResourceId(39, 0)) == 0) ? null : A5SV6n.A2egSU(context3, resourceId2);
        aRc23Z.f6301Dphsd2 = (!AmA8tU2.hasValue(33) || (resourceId = AmA8tU2.getResourceId(33, 0)) == 0) ? null : A5SV6n.A2egSU(context3, resourceId);
        float dimension2 = AmA8tU2.getDimension(21, 0.0f);
        if (aRc23Z.f6302DuwtYk != dimension2) {
            aRc23Z.f6302DuwtYk = dimension2;
            aRc23Z.invalidateSelf();
            aRc23Z.COJEAR();
        }
        aRc23Z.DRlcZ9(AmA8tU2.getDimension(35, 0.0f));
        aRc23Z.DG07BK(AmA8tU2.getDimension(34, 0.0f));
        float dimension3 = AmA8tU2.getDimension(41, 0.0f);
        if (aRc23Z.f6305ECyGFg != dimension3) {
            aRc23Z.f6305ECyGFg = dimension3;
            aRc23Z.invalidateSelf();
            aRc23Z.COJEAR();
        }
        float dimension4 = AmA8tU2.getDimension(40, 0.0f);
        if (aRc23Z.f6306EGM26s != dimension4) {
            aRc23Z.f6306EGM26s = dimension4;
            aRc23Z.invalidateSelf();
            aRc23Z.COJEAR();
        }
        aRc23Z.D8MqeW(AmA8tU2.getDimension(29, 0.0f));
        aRc23Z.D6DOie(AmA8tU2.getDimension(27, 0.0f));
        float dimension5 = AmA8tU2.getDimension(13, 0.0f);
        if (aRc23Z.f6309EQurEW != dimension5) {
            aRc23Z.f6309EQurEW = dimension5;
            aRc23Z.invalidateSelf();
            aRc23Z.COJEAR();
        }
        aRc23Z.G16Pvp = AmA8tU2.getDimensionPixelSize(4, Integer.MAX_VALUE);
        AmA8tU2.recycle();
        C4FrIb.ADYaiT(context2, attributeSet, 2130968805, 2131952844);
        C4FrIb.AMqCpz(context2, attributeSet, iArr, 2130968805, 2131952844, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, 2130968805, 2131952844);
        this.f11559BNL6CD = obtainStyledAttributes.getBoolean(32, false);
        this.f11561BTvldC = (int) Math.ceil(obtainStyledAttributes.getDimension(20, P3rngT.A4TApA.A5SV6n(context2)));
        obtainStyledAttributes.recycle();
        setChipDrawable(aRc23Z);
        aRc23Z.B2KMhB(getElevation());
        C4FrIb.ADYaiT(context2, attributeSet, 2130968805, 2131952844);
        C4FrIb.AMqCpz(context2, attributeSet, iArr, 2130968805, 2131952844, new int[0]);
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, 2130968805, 2131952844);
        if (i < 23) {
            setTextColor(com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes2, 2));
        }
        boolean hasValue = obtainStyledAttributes2.hasValue(37);
        obtainStyledAttributes2.recycle();
        this.f11563BmvVmW = new ADYaiT(this, this);
        AMqCpz();
        if (!hasValue) {
            setOutlineProvider(new OLvDpK.A5SV6n(0, this));
        }
        setChecked(this.f11555BChYOn);
        setText(aRc23Z.f6286D6yqiO);
        setEllipsize(aRc23Z.f6332FpcJKS);
        AYUAbz();
        if (!this.f11549B25kr6.f6333Fyurov) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        ASJ6gh();
        if (this.f11559BNL6CD) {
            setMinHeight(this.f11561BTvldC);
        }
        this.f11560BPw6Q8 = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: OLvDpK.A2egSU
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Chip chip = Chip.this;
                Oay4Bh.AZOQYO azoqyo = chip.f11554B9tovu;
                if (azoqyo != null) {
                    Oay4Bh.A2egSU a2egSU = (Oay4Bh.A2egSU) ((NGepWW.A2egSU) azoqyo).f5658AlLFFp;
                    if (!z ? a2egSU.AMqCpz(chip, a2egSU.AMqCpz) : a2egSU.A2egSU(chip)) {
                        a2egSU.ADYaiT();
                    }
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.f11553B7CMnp;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                }
            }
        });
    }

    private static /* synthetic */ void QLGaC() {
        char[] charArray = "ÒÞÜ\u009fÖÐÜÔ\u009fÓÞÈ\u009fÂÙÔÝÝ\u009fûßØóÃØÕÖÔ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 177);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÒÝØßØÅ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 177);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.f11565C2rE4F;
        rectF.setEmpty();
        if (ADYaiT() && this.f11552B4ZgIw != null) {
            ARc23Z aRc23Z = this.f11549B25kr6;
            Rect bounds = aRc23Z.getBounds();
            rectF.setEmpty();
            if (aRc23Z.DXuj49()) {
                float f = aRc23Z.f6309EQurEW + aRc23Z.f6308EPdU4G + aRc23Z.DXuj49 + aRc23Z.f6307EH1KK8 + aRc23Z.f6306EGM26s;
                if (com.bumptech.glide.A5SV6n.BPw6Q8(aRc23Z) == 0) {
                    float f2 = bounds.right;
                    rectF.right = f2;
                    rectF.left = f2 - f;
                } else {
                    float f3 = bounds.left;
                    rectF.left = f3;
                    rectF.right = f3 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i = (int) closeIconTouchBounds.left;
        int i2 = (int) closeIconTouchBounds.top;
        int i3 = (int) closeIconTouchBounds.right;
        int i4 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.BpkvW3;
        rect.set(i, i2, i3, i4);
        return rect;
    }

    private P3rngT.AMqCpz getTextAppearance() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6315EmJGcg.f6604ASJ6gh;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.f11557BIYEnU != z) {
            this.f11557BIYEnU = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.f11556BI9f7h != z) {
            this.f11556BI9f7h = z;
            refreshDrawableState();
        }
    }

    public final void A5SV6n(int i) {
        this.f11561BTvldC = i;
        if (!this.f11559BNL6CD) {
            InsetDrawable insetDrawable = this.f11550B2KMhB;
            if (insetDrawable == null) {
                ARc23Z();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f11550B2KMhB = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    ARc23Z();
                    return;
                }
                return;
            }
        }
        int max = Math.max(0, i - ((int) this.f11549B25kr6.f6281CrfGsy));
        int max2 = Math.max(0, i - this.f11549B25kr6.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            InsetDrawable insetDrawable2 = this.f11550B2KMhB;
            if (insetDrawable2 == null) {
                ARc23Z();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f11550B2KMhB = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    ARc23Z();
                    return;
                }
                return;
            }
        }
        int i2 = max2 > 0 ? max2 / 2 : 0;
        int i3 = max > 0 ? max / 2 : 0;
        if (this.f11550B2KMhB != null) {
            Rect rect = new Rect();
            this.f11550B2KMhB.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                ARc23Z();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.f11550B2KMhB = new InsetDrawable((Drawable) this.f11549B25kr6, i2, i3, i2, i3);
        ARc23Z();
    }

    public final boolean ADYaiT() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null) {
            return false;
        }
        Drawable drawable = aRc23Z.f6293DUi7mC;
        return (drawable != null ? com.bumptech.glide.A5SV6n.DdagTj(drawable) : null) != null;
    }

    public final void AMqCpz() {
        ARc23Z aRc23Z;
        if (!ADYaiT() || (aRc23Z = this.f11549B25kr6) == null || !aRc23Z.f6292DRlcZ9 || this.f11552B4ZgIw == null) {
            DG07BK.B4ZgIw(this, null);
            this.f11564BniPrB = false;
        } else {
            DG07BK.B4ZgIw(this, this.f11563BmvVmW);
            this.f11564BniPrB = true;
        }
    }

    public final void ARc23Z() {
        this.f11551B3GDIM = new RippleDrawable(P5yM7D.A4TApA.A5SV6n(this.f11549B25kr6.f6285D6DOie), getBackgroundDrawable(), null);
        this.f11549B25kr6.getClass();
        setBackground(this.f11551B3GDIM);
        ASJ6gh();
    }

    public final void ASJ6gh() {
        ARc23Z aRc23Z;
        if (TextUtils.isEmpty(getText()) || (aRc23Z = this.f11549B25kr6) == null) {
            return;
        }
        int C2rE4F2 = (int) (aRc23Z.C2rE4F() + aRc23Z.f6309EQurEW + aRc23Z.f6306EGM26s);
        ARc23Z aRc23Z2 = this.f11549B25kr6;
        int BpkvW3 = (int) (aRc23Z2.BpkvW3() + aRc23Z2.f6302DuwtYk + aRc23Z2.f6305ECyGFg);
        if (this.f11550B2KMhB != null) {
            Rect rect = new Rect();
            this.f11550B2KMhB.getPadding(rect);
            BpkvW3 += rect.left;
            C2rE4F2 += rect.right;
        }
        setPaddingRelative(BpkvW3, getPaddingTop(), C2rE4F2, getPaddingBottom());
    }

    public final void AYUAbz() {
        TextPaint paint = getPaint();
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            paint.drawableState = aRc23Z.getState();
        }
        P3rngT.AMqCpz textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.ADYaiT(getContext(), paint, this.f11566C4FrIb);
        }
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f11564BniPrB ? super.dispatchHoverEvent(motionEvent) : this.f11563BmvVmW.AlLFFp(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f11564BniPrB) {
            return super.dispatchKeyEvent(keyEvent);
        }
        ADYaiT aDYaiT = this.f11563BmvVmW;
        aDYaiT.getClass();
        boolean z = false;
        int i = 0;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i2 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i2 = 33;
                                } else if (keyCode == 21) {
                                    i2 = 17;
                                } else if (keyCode != 22) {
                                    i2 = MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z2 = false;
                                while (i < repeatCount && aDYaiT.B2KMhB(i2, null)) {
                                    i++;
                                    z2 = true;
                                }
                                z = z2;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i3 = aDYaiT.f1829AcNBzu;
                    if (i3 != Integer.MIN_VALUE) {
                        aDYaiT.B4ZgIw(i3, 16, null);
                    }
                    z = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z = aDYaiT.B2KMhB(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z = aDYaiT.B2KMhB(1, null);
            }
        }
        if (!z || aDYaiT.f1829AcNBzu == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // AaHO0E.BChYOn, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ARc23Z aRc23Z = this.f11549B25kr6;
        boolean z = false;
        int i = 0;
        z = false;
        if (aRc23Z != null && ARc23Z.CNPG0E(aRc23Z.f6293DUi7mC)) {
            ARc23Z aRc23Z2 = this.f11549B25kr6;
            ?? isEnabled = isEnabled();
            int i2 = isEnabled;
            if (this.f11558BJ7GGh) {
                i2 = isEnabled + 1;
            }
            int i3 = i2;
            if (this.f11557BIYEnU) {
                i3 = i2 + 1;
            }
            int i4 = i3;
            if (this.f11556BI9f7h) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.f11558BJ7GGh) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.f11557BIYEnU) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.f11556BI9f7h) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            z = aRc23Z2.D8cQ8b(iArr);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f11562BV3sI0)) {
            return this.f11562BV3sI0;
        }
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (!(aRc23Z != null && aRc23Z.f6297DcUJf1)) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).f11570B4ZgIw.f6455ADYaiT) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f11550B2KMhB;
        return insetDrawable == null ? this.f11549B25kr6 : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.Ddcejp;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6299De4eam;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6280CqNSpT;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return Math.max(0.0f, aRc23Z.C4FrIb());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f11549B25kr6;
    }

    public float getChipEndPadding() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6309EQurEW;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || (drawable = aRc23Z.f6288D8cQ8b) == null) {
            return null;
        }
        return com.bumptech.glide.A5SV6n.DdagTj(drawable);
    }

    public float getChipIconSize() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6290DAk1zC;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6289D9tr6l;
        }
        return null;
    }

    public float getChipMinHeight() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6281CrfGsy;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6302DuwtYk;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6283CtxOCS;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6284D07BeM;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || (drawable = aRc23Z.f6293DUi7mC) == null) {
            return null;
        }
        return com.bumptech.glide.A5SV6n.DdagTj(drawable);
    }

    public CharSequence getCloseIconContentDescription() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6296DaOi9o;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6308EPdU4G;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.DXuj49;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6307EH1KK8;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6295DXnQ0V;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6332FpcJKS;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f11564BniPrB) {
            ADYaiT aDYaiT = this.f11563BmvVmW;
            if (aDYaiT.f1829AcNBzu == 1 || aDYaiT.f1828AaHO0E == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public A5SV6n getHideMotionSpec() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6301Dphsd2;
        }
        return null;
    }

    public float getIconEndPadding() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6304DyaChj;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6303DvK7DB;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6285D6DOie;
        }
        return null;
    }

    public B2KMhB getShapeAppearanceModel() {
        return this.f11549B25kr6.f7042AlLFFp.f7021A2egSU;
    }

    public A5SV6n getShowMotionSpec() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6300DjONCG;
        }
        return null;
    }

    public float getTextEndPadding() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6306EGM26s;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            return aRc23Z.f6305ECyGFg;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AlLFFp.CtxOCS(this, this.f11549B25kr6);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f11547CNPG0E);
        }
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null && aRc23Z.f6297DcUJf1) {
            View.mergeDrawableStates(onCreateDrawableState, f11548COJEAR);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.f11564BniPrB) {
            ADYaiT aDYaiT = this.f11563BmvVmW;
            int i2 = aDYaiT.f1829AcNBzu;
            if (i2 != Integer.MIN_VALUE) {
                aDYaiT.AZkASS(i2);
            }
            if (z) {
                aDYaiT.B2KMhB(i, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        ARc23Z aRc23Z = this.f11549B25kr6;
        int i2 = 0;
        accessibilityNodeInfo.setCheckable(aRc23Z != null && aRc23Z.f6297DcUJf1);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.f6525AmA8tU) {
                int i3 = 0;
                while (true) {
                    if (i2 >= chipGroup.getChildCount()) {
                        i3 = -1;
                        break;
                    }
                    View childAt = chipGroup.getChildAt(i2);
                    if ((childAt instanceof Chip) && chipGroup.getChildAt(i2).getVisibility() == 0) {
                        if (((Chip) childAt) == this) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    i2++;
                }
                i = i3;
            } else {
                i = -1;
            }
            Object tag = getTag(2131297842);
            accessibilityNodeInfo.setCollectionItemInfo(ASJ6gh.A2egSU(!(tag instanceof Integer) ? -1 : ((Integer) tag).intValue(), 1, i, 1, false, isChecked()).f1771A2egSU);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.f11560BPw6Q8 != i) {
            this.f11560BPw6Q8 = i;
            ASJ6gh();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L4a
            if (r0 == r3) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.f11556BI9f7h
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r2)
        L2a:
            r0 = 1
            goto L51
        L2c:
            boolean r0 = r5.f11556BI9f7h
            if (r0 == 0) goto L45
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.f11552B4ZgIw
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.f11564BniPrB
            if (r0 == 0) goto L43
            OLvDpK.ADYaiT r0 = r5.f11563BmvVmW
            r0.BIYEnU(r3, r3)
        L43:
            r0 = 1
            goto L46
        L45:
            r0 = 0
        L46:
            r5.setCloseIconPressed(r2)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r3)
            goto L2a
        L50:
            r0 = 0
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            return r2
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f11562BV3sI0 = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f11551B3GDIM) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // AaHO0E.BChYOn, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f11551B3GDIM) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // AaHO0E.BChYOn, android.view.View
    public void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CSDoyG(z);
        }
    }

    public void setCheckableResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CSDoyG(aRc23Z.f6310EUIRHA.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null) {
            this.f11555BChYOn = z;
        } else if (aRc23Z.f6297DcUJf1) {
            super.setChecked(z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CTkVKb(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CTkVKb(AlLFFp.CQhlFr(aRc23Z.f6310EUIRHA, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CcAIMM(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CcAIMM(BPw6Q8.ASJ6gh.A5SV6n(aRc23Z.f6310EUIRHA, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.Cd8JRx(aRc23Z.f6310EUIRHA.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || aRc23Z.f6280CqNSpT == colorStateList) {
            return;
        }
        aRc23Z.f6280CqNSpT = colorStateList;
        aRc23Z.onStateChange(aRc23Z.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        ColorStateList A5SV6n2;
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || aRc23Z.f6280CqNSpT == (A5SV6n2 = BPw6Q8.ASJ6gh.A5SV6n(aRc23Z.f6310EUIRHA, i))) {
            return;
        }
        aRc23Z.f6280CqNSpT = A5SV6n2;
        aRc23Z.onStateChange(aRc23Z.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CikNvS(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CikNvS(aRc23Z.f6310EUIRHA.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(ARc23Z aRc23Z) {
        ARc23Z aRc23Z2 = this.f11549B25kr6;
        if (aRc23Z2 != aRc23Z) {
            if (aRc23Z2 != null) {
                aRc23Z2.f6331FmyuN2 = new WeakReference(null);
            }
            this.f11549B25kr6 = aRc23Z;
            aRc23Z.f6333Fyurov = false;
            aRc23Z.f6331FmyuN2 = new WeakReference(this);
            A5SV6n(this.f11561BTvldC);
        }
    }

    public void setChipEndPadding(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || aRc23Z.f6309EQurEW == f) {
            return;
        }
        aRc23Z.f6309EQurEW = f;
        aRc23Z.invalidateSelf();
        aRc23Z.COJEAR();
    }

    public void setChipEndPaddingResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            float dimension = aRc23Z.f6310EUIRHA.getResources().getDimension(i);
            if (aRc23Z.f6309EQurEW != dimension) {
                aRc23Z.f6309EQurEW = dimension;
                aRc23Z.invalidateSelf();
                aRc23Z.COJEAR();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CkXcdM(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CkXcdM(AlLFFp.CQhlFr(aRc23Z.f6310EUIRHA, i));
        }
    }

    public void setChipIconSize(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CmUvjW(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CmUvjW(aRc23Z.f6310EUIRHA.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CqNSpT(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CqNSpT(BPw6Q8.ASJ6gh.A5SV6n(aRc23Z.f6310EUIRHA, i));
        }
    }

    public void setChipIconVisible(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CrfGsy(aRc23Z.f6310EUIRHA.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || aRc23Z.f6281CrfGsy == f) {
            return;
        }
        aRc23Z.f6281CrfGsy = f;
        aRc23Z.invalidateSelf();
        aRc23Z.COJEAR();
    }

    public void setChipMinHeightResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            float dimension = aRc23Z.f6310EUIRHA.getResources().getDimension(i);
            if (aRc23Z.f6281CrfGsy != dimension) {
                aRc23Z.f6281CrfGsy = dimension;
                aRc23Z.invalidateSelf();
                aRc23Z.COJEAR();
            }
        }
    }

    public void setChipStartPadding(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || aRc23Z.f6302DuwtYk == f) {
            return;
        }
        aRc23Z.f6302DuwtYk = f;
        aRc23Z.invalidateSelf();
        aRc23Z.COJEAR();
    }

    public void setChipStartPaddingResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            float dimension = aRc23Z.f6310EUIRHA.getResources().getDimension(i);
            if (aRc23Z.f6302DuwtYk != dimension) {
                aRc23Z.f6302DuwtYk = dimension;
                aRc23Z.invalidateSelf();
                aRc23Z.COJEAR();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CtFAbx(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CtFAbx(BPw6Q8.ASJ6gh.A5SV6n(aRc23Z.f6310EUIRHA, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CtxOCS(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CtxOCS(aRc23Z.f6310EUIRHA.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D07BeM(drawable);
        }
        AMqCpz();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || aRc23Z.f6296DaOi9o == charSequence) {
            return;
        }
        CASmeH.A5SV6n A5SV6n2 = CASmeH.A5SV6n.A5SV6n();
        aRc23Z.f6296DaOi9o = A5SV6n2.ADYaiT(charSequence, A5SV6n2.f1599A5SV6n);
        aRc23Z.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D6DOie(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D6DOie(aRc23Z.f6310EUIRHA.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D07BeM(AlLFFp.CQhlFr(aRc23Z.f6310EUIRHA, i));
        }
        AMqCpz();
    }

    public void setCloseIconSize(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D6yqiO(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D6yqiO(aRc23Z.f6310EUIRHA.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D8MqeW(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D8MqeW(aRc23Z.f6310EUIRHA.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D9tr6l(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.D9tr6l(BPw6Q8.ASJ6gh.A5SV6n(aRc23Z.f6310EUIRHA, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // AaHO0E.BChYOn, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // AaHO0E.BChYOn, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.B2KMhB(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f11549B25kr6 == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.f6332FpcJKS = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.f11559BNL6CD = z;
        A5SV6n(this.f11561BTvldC);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            return;
        }
        super.setGravity(i);
    }

    public void setHideMotionSpec(A5SV6n a5SV6n) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.f6301Dphsd2 = a5SV6n;
        }
    }

    public void setHideMotionSpecResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.f6301Dphsd2 = A5SV6n.A2egSU(aRc23Z.f6310EUIRHA, i);
        }
    }

    public void setIconEndPadding(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.DG07BK(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.DG07BK(aRc23Z.f6310EUIRHA.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.DRlcZ9(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.DRlcZ9(aRc23Z.f6310EUIRHA.getResources().getDimension(i));
        }
    }

    @Override // Oay4Bh.AZkASS
    public void setInternalOnCheckedChangeListener(AZOQYO azoqyo) {
        this.f11554B9tovu = azoqyo;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f11549B25kr6 == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.G16Pvp = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f11553B7CMnp = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f11552B4ZgIw = onClickListener;
        AMqCpz();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.DUi7mC(colorStateList);
        }
        this.f11549B25kr6.getClass();
        ARc23Z();
    }

    public void setRippleColorResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.DUi7mC(BPw6Q8.ASJ6gh.A5SV6n(aRc23Z.f6310EUIRHA, i));
            this.f11549B25kr6.getClass();
            ARc23Z();
        }
    }

    @Override // PCV8se.BPw6Q8
    public void setShapeAppearanceModel(B2KMhB b2KMhB) {
        this.f11549B25kr6.setShapeAppearanceModel(b2KMhB);
    }

    public void setShowMotionSpec(A5SV6n a5SV6n) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.f6300DjONCG = a5SV6n;
        }
    }

    public void setShowMotionSpecResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.f6300DjONCG = A5SV6n.A2egSU(aRc23Z.f6310EUIRHA, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aRc23Z.f6333Fyurov ? null : charSequence, bufferType);
        ARc23Z aRc23Z2 = this.f11549B25kr6;
        if (aRc23Z2 == null || TextUtils.equals(aRc23Z2.f6286D6yqiO, charSequence)) {
            return;
        }
        aRc23Z2.f6286D6yqiO = charSequence;
        aRc23Z2.f6315EmJGcg.AMqCpz = true;
        aRc23Z2.invalidateSelf();
        aRc23Z2.COJEAR();
    }

    public void setTextAppearance(P3rngT.AMqCpz aMqCpz) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.f6315EmJGcg.A5SV6n(aMqCpz, aRc23Z.f6310EUIRHA);
        }
        AYUAbz();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || aRc23Z.f6306EGM26s == f) {
            return;
        }
        aRc23Z.f6306EGM26s = f;
        aRc23Z.invalidateSelf();
        aRc23Z.COJEAR();
    }

    public void setTextEndPaddingResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            float dimension = aRc23Z.f6310EUIRHA.getResources().getDimension(i);
            if (aRc23Z.f6306EGM26s != dimension) {
                aRc23Z.f6306EGM26s = dimension;
                aRc23Z.invalidateSelf();
                aRc23Z.COJEAR();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            float applyDimension = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
            BniPrB bniPrB = aRc23Z.f6315EmJGcg;
            P3rngT.AMqCpz aMqCpz = bniPrB.f6604ASJ6gh;
            if (aMqCpz != null) {
                aMqCpz.f6952AcNBzu = applyDimension;
                bniPrB.f6599A2egSU.setTextSize(applyDimension);
                aRc23Z.A2egSU();
            }
        }
        AYUAbz();
    }

    public void setTextStartPadding(float f) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z == null || aRc23Z.f6305ECyGFg == f) {
            return;
        }
        aRc23Z.f6305ECyGFg = f;
        aRc23Z.invalidateSelf();
        aRc23Z.COJEAR();
    }

    public void setTextStartPaddingResource(int i) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            float dimension = aRc23Z.f6310EUIRHA.getResources().getDimension(i);
            if (aRc23Z.f6305ECyGFg != dimension) {
                aRc23Z.f6305ECyGFg = dimension;
                aRc23Z.invalidateSelf();
                aRc23Z.COJEAR();
            }
        }
    }

    public void setCloseIconVisible(boolean z) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.DAk1zC(z);
        }
        AMqCpz();
    }

    public void setCheckedIconVisible(boolean z) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.Cd8JRx(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            aRc23Z.CrfGsy(z);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            Context context2 = aRc23Z.f6310EUIRHA;
            aRc23Z.f6315EmJGcg.A5SV6n(new P3rngT.AMqCpz(context2, i), context2);
        }
        AYUAbz();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        ARc23Z aRc23Z = this.f11549B25kr6;
        if (aRc23Z != null) {
            Context context = aRc23Z.f6310EUIRHA;
            aRc23Z.f6315EmJGcg.A5SV6n(new P3rngT.AMqCpz(context, i), context);
        }
        AYUAbz();
    }
}
