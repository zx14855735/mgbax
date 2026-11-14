package PWr3nF;

import AaHO0E.GYpKKt;
import Oay4Bh.C4FrIb;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu extends LinearLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final TextInputLayout f7390AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AppCompatTextView f7391AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public CharSequence f7392AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final CheckableImageButton f7393AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public ColorStateList f7394B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public PorterDuff.Mode f7395B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f7396B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ImageView.ScaleType f7397B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public View.OnLongClickListener f7398B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f7399B9tovu;

    public B9tovu(TextInputLayout textInputLayout, GYpKKt gYpKKt) {
        super(textInputLayout.getContext());
        CharSequence text;
        Drawable A4TApA2;
        this.f7390AcNBzu = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(2131492947, (ViewGroup) this, false);
        this.f7393AzWtSf = checkableImageButton;
        if (Build.VERSION.SDK_INT < 23) {
            A4TApA2 = P5yM7D.A2egSU.A4TApA(checkableImageButton.getContext(), (int) C4FrIb.AYUAbz(checkableImageButton.getContext(), 4));
            checkableImageButton.setBackground(A4TApA2);
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.f7391AlLFFp = appCompatTextView;
        if (com.bumptech.glide.AMqCpz.CNPG0E(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.f7398B7CMnp;
        checkableImageButton.setOnClickListener(null);
        JrXYwF.A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
        this.f7398B7CMnp = null;
        checkableImageButton.setOnLongClickListener(null);
        JrXYwF.A4TApA.D9tr6l(checkableImageButton, null);
        TypedArray typedArray = gYpKKt.f884A4TApA;
        if (typedArray.hasValue(70)) {
            this.f7394B25kr6 = com.bumptech.glide.AMqCpz.BNL6CD(getContext(), gYpKKt, 70);
        }
        if (typedArray.hasValue(71)) {
            this.f7395B2KMhB = C4FrIb.B25kr6(typedArray.getInt(71, -1), null);
        }
        if (typedArray.hasValue(67)) {
            A4TApA(gYpKKt.A4TApA(67));
            if (typedArray.hasValue(66) && checkableImageButton.getContentDescription() != (text = typedArray.getText(66))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(2131166460));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f7396B3GDIM) {
            this.f7396B3GDIM = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(69)) {
            ImageView.ScaleType BChYOn2 = JrXYwF.A4TApA.BChYOn(typedArray.getInt(69, -1));
            this.f7397B4ZgIw = BChYOn2;
            checkableImageButton.setScaleType(BChYOn2);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(2131298097);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        appCompatTextView.setAccessibilityLiveRegion(1);
        JrXYwF.A4TApA.DRlcZ9(appCompatTextView, typedArray.getResourceId(61, 0));
        if (typedArray.hasValue(62)) {
            appCompatTextView.setTextColor(gYpKKt.A2egSU(62));
        }
        CharSequence text2 = typedArray.getText(60);
        this.f7392AmA8tU = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        AMqCpz();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final int A2egSU() {
        int i;
        CheckableImageButton checkableImageButton = this.f7393AzWtSf;
        if (checkableImageButton.getVisibility() == 0) {
            i = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            i = 0;
        }
        return this.f7391AlLFFp.getPaddingStart() + getPaddingStart() + i;
    }

    public final void A4TApA(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f7393AzWtSf;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f7394B25kr6;
            PorterDuff.Mode mode = this.f7395B2KMhB;
            TextInputLayout textInputLayout = this.f7390AcNBzu;
            JrXYwF.A4TApA.AZOQYO(textInputLayout, checkableImageButton, colorStateList, mode);
            A5SV6n(true);
            JrXYwF.A4TApA.CrfGsy(textInputLayout, checkableImageButton, this.f7394B25kr6);
            return;
        }
        A5SV6n(false);
        View.OnLongClickListener onLongClickListener = this.f7398B7CMnp;
        checkableImageButton.setOnClickListener(null);
        JrXYwF.A4TApA.D9tr6l(checkableImageButton, onLongClickListener);
        this.f7398B7CMnp = null;
        checkableImageButton.setOnLongClickListener(null);
        JrXYwF.A4TApA.D9tr6l(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void A5SV6n(boolean z) {
        CheckableImageButton checkableImageButton = this.f7393AzWtSf;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            ADYaiT();
            AMqCpz();
        }
    }

    public final void ADYaiT() {
        EditText editText = this.f7390AcNBzu.f11911B25kr6;
        if (editText == null) {
            return;
        }
        this.f7391AlLFFp.setPaddingRelative(this.f7393AzWtSf.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(2131166323), editText.getCompoundPaddingBottom());
    }

    public final void AMqCpz() {
        int i = (this.f7392AmA8tU == null || this.f7399B9tovu) ? 8 : 0;
        setVisibility((this.f7393AzWtSf.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.f7391AlLFFp.setVisibility(i);
        this.f7390AcNBzu.B4ZgIw();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ADYaiT();
    }
}
