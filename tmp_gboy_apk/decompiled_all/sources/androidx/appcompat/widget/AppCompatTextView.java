package androidx.appcompat.widget;

import AZkASS.ARc23Z;
import AaHO0E.B7CMnp;
import AaHO0E.BTvldC;
import AaHO0E.C4FrIb;
import AaHO0E.D6DOie;
import AaHO0E.DRlcZ9;
import AaHO0E.DUi7mC;
import AaHO0E.DV2E8K;
import AaHO0E.DXnQ0V;
import AaHO0E.De4eam;
import AaHO0E.GIi2tl;
import AaHO0E.GIl1rw;
import AaHO0E.HSHyT0;
import CASmeH.AYUAbz;
import CASmeH.AZOQYO;
import CikNvS.AmA8tU;
import CikNvS.B2KMhB;
import CikNvS.B9tovu;
import JrXYwF.A4TApA;
import NOd7IU.AlLFFp;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import com.bumptech.glide.AMqCpz;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AppCompatTextView extends TextView implements B9tovu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f8154AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DRlcZ9 f8155AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final C4FrIb f8156AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public BTvldC f8157AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f8158B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ARc23Z f8159B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Future f8160B3GDIM;

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private BTvldC getEmojiTextViewHelper() {
        if (this.f8157AzWtSf == null) {
            this.f8157AzWtSf = new BTvldC(this);
        }
        return this.f8157AzWtSf;
    }

    public final void ASJ6gh() {
        Future future = this.f8160B3GDIM;
        if (future == null) {
            return;
        }
        try {
            this.f8160B3GDIM = null;
            if (future.get() != null) {
                throw new ClassCastException();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            A4TApA.CNPG0E(this);
            throw null;
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.f8154AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeMaxTextSize();
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            return Math.round(dRlcZ9.f735AZOQYO.AMqCpz);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeMinTextSize();
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            return Math.round(dRlcZ9.f735AZOQYO.f747ADYaiT);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeStepGranularity();
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            return Math.round(dRlcZ9.f735AZOQYO.f746A5SV6n);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeTextAvailableSizes();
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        return dRlcZ9 != null ? dRlcZ9.f735AZOQYO.f748ARc23Z : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (HSHyT0.f935A5SV6n) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            return dRlcZ9.f735AZOQYO.f744A2egSU;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return A4TApA.DcUJf1(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public DUi7mC getSuperCaller() {
        if (this.f8159B2KMhB == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.f8159B2KMhB = new DXnQ0V(this);
            } else if (i >= 28) {
                this.f8159B2KMhB = new DV2E8K(this);
            } else if (i >= 26) {
                this.f8159B2KMhB = new ARc23Z(2, this);
            }
        }
        return this.f8159B2KMhB;
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f8154AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f8154AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8155AlLFFp.ADYaiT();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8155AlLFFp.AMqCpz();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        ASJ6gh();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C4FrIb c4FrIb;
        if (Build.VERSION.SDK_INT >= 28 || (c4FrIb = this.f8156AmA8tU) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) c4FrIb.f681A5SV6n;
        return textClassifier == null ? D6DOie.A2egSU((TextView) c4FrIb.f680A4TApA) : textClassifier;
    }

    public AYUAbz getTextMetricsParamsCompat() {
        return A4TApA.CNPG0E(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f8155AlLFFp.getClass();
        DRlcZ9.AYUAbz(editorInfo, onCreateInputConnection, this);
        AMqCpz.CSDoyG(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 == null || HSHyT0.f935A5SV6n) {
            return;
        }
        dRlcZ9.f735AZOQYO.A2egSU();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        ASJ6gh();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 == null || HSHyT0.f935A5SV6n) {
            return;
        }
        De4eam de4eam = dRlcZ9.f735AZOQYO;
        if (de4eam.ARc23Z()) {
            de4eam.A2egSU();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().A5SV6n(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (HSHyT0.f935A5SV6n) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.AZOQYO(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (HSHyT0.f935A5SV6n) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.AZkASS(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (HSHyT0.f935A5SV6n) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.AaHO0E(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f8154AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f8154AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(A4TApA.Ddcejp(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().ADYaiT(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().A2egSU(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().B4ZgIw(i);
        } else {
            A4TApA.D8cQ8b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().AZkASS(i);
        } else {
            A4TApA.DAk1zC(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        A4TApA.DG07BK(this, i);
    }

    public void setPrecomputedText(AZOQYO azoqyo) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        A4TApA.CNPG0E(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.f8154AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f8154AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        dRlcZ9.AcNBzu(colorStateList);
        dRlcZ9.A4TApA();
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        dRlcZ9.AlLFFp(mode);
        dRlcZ9.A4TApA();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.ASJ6gh(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C4FrIb c4FrIb;
        if (Build.VERSION.SDK_INT >= 28 || (c4FrIb = this.f8156AmA8tU) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c4FrIb.f681A5SV6n = textClassifier;
        }
    }

    public void setTextFuture(Future<AZOQYO> future) {
        this.f8160B3GDIM = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(AYUAbz aYUAbz) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = aYUAbz.f1602A4TApA;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i = 7;
            }
        }
        setTextDirection(i);
        int i2 = Build.VERSION.SDK_INT;
        TextPaint textPaint = aYUAbz.f1601A2egSU;
        if (i2 >= 23) {
            getPaint().set(textPaint);
            AmA8tU.AMqCpz(this, aYUAbz.f1603A5SV6n);
            AmA8tU.AYUAbz(this, aYUAbz.f1604ADYaiT);
        } else {
            float textScaleX = textPaint.getTextScaleX();
            getPaint().set(textPaint);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z = HSHyT0.f935A5SV6n;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 == null || z) {
            return;
        }
        De4eam de4eam = dRlcZ9.f735AZOQYO;
        if (de4eam.ARc23Z()) {
            return;
        }
        de4eam.ASJ6gh(f, i);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typeface2;
        if (this.f8158B25kr6) {
            return;
        }
        if (typeface == null || i <= 0) {
            typeface2 = null;
        } else {
            Context context = getContext();
            A4TApA a4TApA = BV3sI0.AYUAbz.f1490A2egSU;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typeface2 = Typeface.create(typeface, i);
        }
        this.f8158B25kr6 = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f8158B25kr6 = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GIl1rw.A2egSU(context);
        this.f8158B25kr6 = false;
        this.f8159B2KMhB = null;
        GIi2tl.A2egSU(getContext(), this);
        B7CMnp b7CMnp = new B7CMnp(this);
        this.f8154AcNBzu = b7CMnp;
        b7CMnp.ADYaiT(attributeSet, i);
        DRlcZ9 dRlcZ9 = new DRlcZ9(this);
        this.f8155AlLFFp = dRlcZ9;
        dRlcZ9.ARc23Z(attributeSet, i);
        dRlcZ9.A4TApA();
        C4FrIb c4FrIb = new C4FrIb();
        c4FrIb.f680A4TApA = this;
        this.f8156AmA8tU = c4FrIb;
        getEmojiTextViewHelper().A4TApA(attributeSet, i);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i, float f) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            getSuperCaller().B7CMnp(i, f);
        } else if (i2 >= 34) {
            B2KMhB.A2egSU(this, i, f);
        } else {
            A4TApA.DG07BK(this, Math.round(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics())));
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? AlLFFp.CQhlFr(context, i) : null, i2 != 0 ? AlLFFp.CQhlFr(context, i2) : null, i3 != 0 ? AlLFFp.CQhlFr(context, i3) : null, i4 != 0 ? AlLFFp.CQhlFr(context, i4) : null);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? AlLFFp.CQhlFr(context, i) : null, i2 != 0 ? AlLFFp.CQhlFr(context, i2) : null, i3 != 0 ? AlLFFp.CQhlFr(context, i3) : null, i4 != 0 ? AlLFFp.CQhlFr(context, i4) : null);
        DRlcZ9 dRlcZ9 = this.f8155AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }
}
