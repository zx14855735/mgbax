package androidx.appcompat.widget;

import AYUAbz.A2egSU;
import AaHO0E.BTvldC;
import AaHO0E.DRlcZ9;
import AaHO0E.EGM26s;
import AaHO0E.GEYgCP;
import AaHO0E.GGG1xW;
import AaHO0E.GIi2tl;
import AaHO0E.GYpKKt;
import AaHO0E.HSHyT0;
import BPw6Q8.ASJ6gh;
import COJEAR.CcAIMM;
import COJEAR.DG07BK;
import JrXYwF.A4TApA;
import NOd7IU.AlLFFp;
import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import androidx.emoji2.text.AmA8tU;
import com.bumptech.glide.A5SV6n;
import com.qq.e.comm.adevent.AdEventType;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: D9tr6l, reason: collision with root package name */
    public static final GEYgCP f8175D9tr6l = new GEYgCP(Float.class, "thumbPos", 0);

    /* renamed from: DAk1zC, reason: collision with root package name */
    public static final int[] f8176DAk1zC = {R.attr.state_checked};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Drawable f8177AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ColorStateList f8178AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public PorterDuff.Mode f8179AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f8180AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f8181B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Drawable f8182B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ColorStateList f8183B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public PorterDuff.Mode f8184B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f8185B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f8186B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f8187BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f8188BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f8189BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f8190BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public CharSequence f8191BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public CharSequence f8192BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public CharSequence f8193BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public CharSequence f8194BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f8195BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f8196BniPrB;
    public final int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public float f8197C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public float f8198C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final VelocityTracker f8199CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final int f8200CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public float f8201COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public int f8202CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int f8203CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f8204CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f8205CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public int f8206Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public int f8207CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public int f8208CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public boolean f8209CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public final TextPaint f8210CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public final ColorStateList f8211CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public StaticLayout f8212CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public StaticLayout f8213CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public final A2egSU f8214D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public ObjectAnimator f8215D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public BTvldC f8216D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public GGG1xW f8217D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public final Rect f8218D8cQ8b;

    static {
        izeENm();
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130969958);
    }

    private BTvldC getEmojiTextViewHelper() {
        if (this.f8216D6yqiO == null) {
            this.f8216D6yqiO = new BTvldC(this);
        }
        return this.f8216D6yqiO;
    }

    private boolean getTargetCheckedState() {
        return this.f8201COJEAR > 0.5f;
    }

    private int getThumbOffset() {
        boolean z = HSHyT0.f933A2egSU;
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.f8201COJEAR : this.f8201COJEAR) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f8182B2KMhB;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f8218D8cQ8b;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f8177AcNBzu;
        Rect A4TApA2 = drawable2 != null ? EGM26s.A4TApA(drawable2) : EGM26s.f764A5SV6n;
        return ((((this.f8202CQhlFr - this.f8204CTkVKb) - rect.left) - rect.right) - A4TApA2.left) - A4TApA2.right;
    }

    private static /* synthetic */ void izeENm() {
        char[] charArray = "\u008f\u0083\u0081Â\u008b\u008d\u0081\u0089Â\u008e\u0083\u0095Â\u009f\u0084\u0089\u0080\u0080Â¦\u0082\u0085®\u009e\u0085\u0088\u008b\u0089".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 236);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008f\u0080\u0085\u0082\u0085\u0098".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 236);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f8193BTvldC = charSequence;
        BTvldC emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod De4eam2 = ((A4TApA) emojiTextViewHelper.f666A4TApA.f451AlLFFp).De4eam(this.f8214D07BeM);
        if (De4eam2 != null) {
            charSequence = De4eam2.getTransformation(charSequence, this);
        }
        this.f8194BV3sI0 = charSequence;
        this.f8213CtxOCS = null;
        if (this.f8195BmvVmW) {
            ADYaiT();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f8191BNL6CD = charSequence;
        BTvldC emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod De4eam2 = ((A4TApA) emojiTextViewHelper.f666A4TApA.f451AlLFFp).De4eam(this.f8214D07BeM);
        if (De4eam2 != null) {
            charSequence = De4eam2.getTransformation(charSequence, this);
        }
        this.f8192BPw6Q8 = charSequence;
        this.f8212CtFAbx = null;
        if (this.f8195BmvVmW) {
            ADYaiT();
        }
    }

    public final void A2egSU() {
        Drawable drawable = this.f8177AcNBzu;
        if (drawable != null) {
            if (this.f8180AzWtSf || this.f8181B25kr6) {
                Drawable mutate = A5SV6n.DvK7DB(drawable).mutate();
                this.f8177AcNBzu = mutate;
                if (this.f8180AzWtSf) {
                    BmvVmW.A2egSU.AYUAbz(mutate, this.f8178AlLFFp);
                }
                if (this.f8181B25kr6) {
                    BmvVmW.A2egSU.AZOQYO(this.f8177AcNBzu, this.f8179AmA8tU);
                }
                if (this.f8177AcNBzu.isStateful()) {
                    this.f8177AcNBzu.setState(getDrawableState());
                }
            }
        }
    }

    public final void A4TApA() {
        Drawable drawable = this.f8182B2KMhB;
        if (drawable != null) {
            if (this.f8185B7CMnp || this.f8186B9tovu) {
                Drawable mutate = A5SV6n.DvK7DB(drawable).mutate();
                this.f8182B2KMhB = mutate;
                if (this.f8185B7CMnp) {
                    BmvVmW.A2egSU.AYUAbz(mutate, this.f8183B3GDIM);
                }
                if (this.f8186B9tovu) {
                    BmvVmW.A2egSU.AZOQYO(this.f8182B2KMhB, this.f8184B4ZgIw);
                }
                if (this.f8182B2KMhB.isStateful()) {
                    this.f8182B2KMhB.setState(getDrawableState());
                }
            }
        }
    }

    public final void A5SV6n() {
        setTextOnInternal(this.f8191BNL6CD);
        setTextOffInternal(this.f8193BTvldC);
        requestLayout();
    }

    public final void ADYaiT() {
        if (this.f8217D8MqeW == null && ((A4TApA) this.f8216D6yqiO.f666A4TApA.f451AlLFFp).Cd8JRx() && AmA8tU.f8658AaHO0E != null) {
            AmA8tU A2egSU2 = AmA8tU.A2egSU();
            int A4TApA2 = A2egSU2.A4TApA();
            if (A4TApA2 == 3 || A4TApA2 == 0) {
                GGG1xW gGG1xW = new GGG1xW(this);
                this.f8217D8MqeW = gGG1xW;
                A2egSU2.ARc23Z(gGG1xW);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.f8205CcAIMM;
        int i4 = this.f8206Cd8JRx;
        int i5 = this.f8207CikNvS;
        int i6 = this.f8208CkXcdM;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.f8177AcNBzu;
        Rect A4TApA2 = drawable != null ? EGM26s.A4TApA(drawable) : EGM26s.f764A5SV6n;
        Drawable drawable2 = this.f8182B2KMhB;
        Rect rect = this.f8218D8cQ8b;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i7 = rect.left;
            thumbOffset += i7;
            if (A4TApA2 != null) {
                int i8 = A4TApA2.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = A4TApA2.top;
                int i10 = rect.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = A4TApA2.right;
                int i12 = rect.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = A4TApA2.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                    this.f8182B2KMhB.setBounds(i3, i, i5, i2);
                }
            } else {
                i = i4;
            }
            i2 = i6;
            this.f8182B2KMhB.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.f8177AcNBzu;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i15 = thumbOffset - rect.left;
            int i16 = thumbOffset + this.f8204CTkVKb + rect.right;
            this.f8177AcNBzu.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                BmvVmW.A2egSU.ARc23Z(background, i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f8177AcNBzu;
        if (drawable != null) {
            BmvVmW.A2egSU.AMqCpz(drawable, f, f2);
        }
        Drawable drawable2 = this.f8182B2KMhB;
        if (drawable2 != null) {
            BmvVmW.A2egSU.AMqCpz(drawable2, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f8177AcNBzu;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f8182B2KMhB;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        boolean z = HSHyT0.f933A2egSU;
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f8202CQhlFr;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f8189BIYEnU : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        boolean z = HSHyT0.f933A2egSU;
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f8202CQhlFr;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f8189BIYEnU : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return A4TApA.DcUJf1(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f8195BmvVmW;
    }

    public boolean getSplitTrack() {
        return this.f8190BJ7GGh;
    }

    public int getSwitchMinWidth() {
        return this.f8188BI9f7h;
    }

    public int getSwitchPadding() {
        return this.f8189BIYEnU;
    }

    public CharSequence getTextOff() {
        return this.f8193BTvldC;
    }

    public CharSequence getTextOn() {
        return this.f8191BNL6CD;
    }

    public Drawable getThumbDrawable() {
        return this.f8177AcNBzu;
    }

    public final float getThumbPosition() {
        return this.f8201COJEAR;
    }

    public int getThumbTextPadding() {
        return this.f8187BChYOn;
    }

    public ColorStateList getThumbTintList() {
        return this.f8178AlLFFp;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f8179AmA8tU;
    }

    public Drawable getTrackDrawable() {
        return this.f8182B2KMhB;
    }

    public ColorStateList getTrackTintList() {
        return this.f8183B3GDIM;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f8184B4ZgIw;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8177AcNBzu;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f8182B2KMhB;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f8215D6DOie;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f8215D6DOie.end();
        this.f8215D6DOie = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f8176DAk1zC);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f8182B2KMhB;
        Rect rect = this.f8218D8cQ8b;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f8206Cd8JRx;
        int i2 = this.f8208CkXcdM;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f8177AcNBzu;
        if (drawable != null) {
            if (!this.f8190BJ7GGh || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect A4TApA2 = EGM26s.A4TApA(drawable2);
                drawable2.copyBounds(rect);
                rect.left += A4TApA2.left;
                rect.right -= A4TApA2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.f8212CtFAbx : this.f8213CtxOCS;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f8211CrfGsy;
            TextPaint textPaint = this.f8210CqNSpT;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i3 + i4) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f8191BNL6CD : this.f8193BTvldC;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int i7;
        int i8;
        super.onLayout(z, i, i2, i3, i4);
        int i9 = 0;
        if (this.f8177AcNBzu != null) {
            Drawable drawable = this.f8182B2KMhB;
            Rect rect = this.f8218D8cQ8b;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect A4TApA2 = EGM26s.A4TApA(this.f8177AcNBzu);
            i5 = Math.max(0, A4TApA2.left - rect.left);
            i9 = Math.max(0, A4TApA2.right - rect.right);
        } else {
            i5 = 0;
        }
        boolean z2 = HSHyT0.f933A2egSU;
        if (getLayoutDirection() == 1) {
            i6 = getPaddingLeft() + i5;
            width = ((this.f8202CQhlFr + i6) - i5) - i9;
        } else {
            width = (getWidth() - getPaddingRight()) - i9;
            i6 = (width - this.f8202CQhlFr) + i5 + i9;
        }
        int gravity = getGravity() & AdEventType.AD_TICK;
        if (gravity == 16) {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i10 = this.f8203CSDoyG;
            int i11 = height - (i10 / 2);
            i7 = i10 + i11;
            i8 = i11;
        } else if (gravity != 80) {
            i8 = getPaddingTop();
            i7 = this.f8203CSDoyG + i8;
        } else {
            i7 = getHeight() - getPaddingBottom();
            i8 = i7 - this.f8203CSDoyG;
        }
        this.f8205CcAIMM = i6;
        this.f8206Cd8JRx = i8;
        this.f8208CkXcdM = i7;
        this.f8207CikNvS = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (this.f8195BmvVmW) {
            StaticLayout staticLayout = this.f8212CtFAbx;
            TextPaint textPaint = this.f8210CqNSpT;
            if (staticLayout == null) {
                CharSequence charSequence = this.f8192BPw6Q8;
                this.f8212CtFAbx = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.f8213CtxOCS == null) {
                CharSequence charSequence2 = this.f8194BV3sI0;
                this.f8213CtxOCS = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f8177AcNBzu;
        Rect rect = this.f8218D8cQ8b;
        if (drawable != null) {
            drawable.getPadding(rect);
            i3 = (this.f8177AcNBzu.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f8177AcNBzu.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.f8204CTkVKb = Math.max(this.f8195BmvVmW ? (this.f8187BChYOn * 2) + Math.max(this.f8212CtFAbx.getWidth(), this.f8213CtxOCS.getWidth()) : 0, i3);
        Drawable drawable2 = this.f8182B2KMhB;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i5 = this.f8182B2KMhB.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        Drawable drawable3 = this.f8177AcNBzu;
        if (drawable3 != null) {
            Rect A4TApA2 = EGM26s.A4TApA(drawable3);
            i6 = Math.max(i6, A4TApA2.left);
            i7 = Math.max(i7, A4TApA2.right);
        }
        int max = this.f8209CmUvjW ? Math.max(this.f8188BI9f7h, (this.f8204CTkVKb * 2) + i6 + i7) : this.f8188BI9f7h;
        int max2 = Math.max(i5, i4);
        this.f8202CQhlFr = max;
        this.f8203CSDoyG = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f8191BNL6CD : this.f8193BTvldC;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r1 != 3) goto L82;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().A5SV6n(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.f8191BNL6CD;
                if (obj == null) {
                    obj = getResources().getString(2131886089);
                }
                Object obj2 = obj;
                WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                new CcAIMM(2131298064, CharSequence.class, 64, 30, 2).A2egSU(this, obj2);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj3 = this.f8193BTvldC;
            if (obj3 == null) {
                obj3 = getResources().getString(2131886088);
            }
            Object obj4 = obj3;
            WeakHashMap weakHashMap2 = DG07BK.f1680A2egSU;
            new CcAIMM(2131298064, CharSequence.class, 64, 30, 2).A2egSU(this, obj4);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.f8215D6DOie;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f8175D9tr6l, isChecked ? 1.0f : 0.0f);
        this.f8215D6DOie = ofFloat;
        ofFloat.setDuration(250L);
        this.f8215D6DOie.setAutoCancel(true);
        this.f8215D6DOie.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(A4TApA.Ddcejp(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().ADYaiT(z);
        setTextOnInternal(this.f8191BNL6CD);
        setTextOffInternal(this.f8193BTvldC);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.f8209CmUvjW = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().A2egSU(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.f8195BmvVmW != z) {
            this.f8195BmvVmW = z;
            requestLayout();
            if (z) {
                ADYaiT();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f8190BJ7GGh = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f8188BI9f7h = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f8189BIYEnU = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f8210CqNSpT;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.f8193BTvldC;
        if (obj == null) {
            obj = getResources().getString(2131886088);
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        new CcAIMM(2131298064, CharSequence.class, 64, 30, 2).A2egSU(this, obj);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.f8191BNL6CD;
        if (obj == null) {
            obj = getResources().getString(2131886089);
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        new CcAIMM(2131298064, CharSequence.class, 64, 30, 2).A2egSU(this, obj);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f8177AcNBzu;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f8177AcNBzu = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.f8201COJEAR = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f8187BChYOn = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f8178AlLFFp = colorStateList;
        this.f8180AzWtSf = true;
        A2egSU();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f8179AmA8tU = mode;
        this.f8181B25kr6 = true;
        A2egSU();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f8182B2KMhB;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f8182B2KMhB = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f8183B3GDIM = colorStateList;
        this.f8185B7CMnp = true;
        A4TApA();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f8184B4ZgIw = mode;
        this.f8186B9tovu = true;
        A4TApA();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8177AcNBzu || drawable == this.f8182B2KMhB;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int resourceId;
        this.f8178AlLFFp = null;
        this.f8179AmA8tU = null;
        this.f8180AzWtSf = false;
        this.f8181B25kr6 = false;
        this.f8183B3GDIM = null;
        this.f8184B4ZgIw = null;
        this.f8185B7CMnp = false;
        this.f8186B9tovu = false;
        this.f8199CASmeH = VelocityTracker.obtain();
        this.f8209CmUvjW = true;
        this.f8218D8cQ8b = new Rect();
        GIi2tl.A2egSU(getContext(), this);
        TextPaint textPaint = new TextPaint(1);
        this.f8210CqNSpT = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R$styleable.f8035BI9f7h;
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(context, attributeSet, iArr, i);
        DG07BK.B3GDIM(this, context, iArr, attributeSet, ARc23Z2.f884A4TApA, i);
        Drawable A4TApA2 = ARc23Z2.A4TApA(2);
        this.f8177AcNBzu = A4TApA2;
        if (A4TApA2 != null) {
            A4TApA2.setCallback(this);
        }
        Drawable A4TApA3 = ARc23Z2.A4TApA(11);
        this.f8182B2KMhB = A4TApA3;
        if (A4TApA3 != null) {
            A4TApA3.setCallback(this);
        }
        TypedArray typedArray = ARc23Z2.f884A4TApA;
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.f8195BmvVmW = typedArray.getBoolean(3, true);
        this.f8187BChYOn = typedArray.getDimensionPixelSize(8, 0);
        this.f8188BI9f7h = typedArray.getDimensionPixelSize(5, 0);
        this.f8189BIYEnU = typedArray.getDimensionPixelSize(6, 0);
        this.f8190BJ7GGh = typedArray.getBoolean(4, false);
        ColorStateList A2egSU2 = ARc23Z2.A2egSU(9);
        if (A2egSU2 != null) {
            this.f8178AlLFFp = A2egSU2;
            this.f8180AzWtSf = true;
        }
        PorterDuff.Mode A5SV6n2 = EGM26s.A5SV6n(typedArray.getInt(10, -1), null);
        if (this.f8179AmA8tU != A5SV6n2) {
            this.f8179AmA8tU = A5SV6n2;
            this.f8181B25kr6 = true;
        }
        if (this.f8180AzWtSf || this.f8181B25kr6) {
            A2egSU();
        }
        ColorStateList A2egSU3 = ARc23Z2.A2egSU(12);
        if (A2egSU3 != null) {
            this.f8183B3GDIM = A2egSU3;
            this.f8185B7CMnp = true;
        }
        PorterDuff.Mode A5SV6n3 = EGM26s.A5SV6n(typedArray.getInt(13, -1), null);
        if (this.f8184B4ZgIw != A5SV6n3) {
            this.f8184B4ZgIw = A5SV6n3;
            this.f8186B9tovu = true;
        }
        if (this.f8185B7CMnp || this.f8186B9tovu) {
            A4TApA();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId2, R$styleable.f8036BIYEnU);
            ColorStateList colorStateList = (!obtainStyledAttributes.hasValue(3) || (resourceId = obtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = ASJ6gh.A5SV6n(context, resourceId)) == null) ? obtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.f8211CrfGsy = colorStateList;
            } else {
                this.f8211CrfGsy = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int i2 = obtainStyledAttributes.getInt(1, -1);
            int i3 = obtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i3 > 0) {
                Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
                setSwitchTypeface(defaultFromStyle);
                int i4 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i3;
                textPaint.setFakeBoldText((i4 & 1) != 0);
                textPaint.setTextSkewX((2 & i4) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                A2egSU a2egSU = new A2egSU();
                a2egSU.f350A2egSU = context2.getResources().getConfiguration().locale;
                this.f8214D07BeM = a2egSU;
            } else {
                this.f8214D07BeM = null;
            }
            setTextOnInternal(this.f8191BNL6CD);
            setTextOffInternal(this.f8193BTvldC);
            obtainStyledAttributes.recycle();
        }
        new DRlcZ9(this).ARc23Z(attributeSet, i);
        ARc23Z2.ASJ6gh();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.BpkvW3 = viewConfiguration.getScaledTouchSlop();
        this.f8200CNPG0E = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().A4TApA(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
