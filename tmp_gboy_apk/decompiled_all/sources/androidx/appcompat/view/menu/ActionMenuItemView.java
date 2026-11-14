package androidx.appcompat.view.menu;

import AZkASS.AlLFFp;
import AZkASS.AmA8tU;
import AZkASS.BChYOn;
import AZkASS.BPw6Q8;
import AaHO0E.B25kr6;
import JrXYwF.A4TApA;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements BPw6Q8, View.OnClickListener, B25kr6 {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public AZkASS.B25kr6 f8047B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public CharSequence f8048B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public Drawable f8049B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public AlLFFp f8050BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public androidx.appcompat.view.menu.A2egSU f8051BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public A2egSU f8052BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f8053BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f8054BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final int f8055BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f8056BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final int f8057BV3sI0;

    public static abstract class A2egSU {
        public abstract BChYOn A2egSU();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f8053BJ7GGh = AYUAbz();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8016A5SV6n, 0, 0);
        this.f8055BPw6Q8 = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f8057BV3sI0 = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f8056BTvldC = -1;
        setSaveEnabled(false);
    }

    @Override // AZkASS.BPw6Q8
    public final void A2egSU(AZkASS.B25kr6 b25kr6) {
        this.f8047B4ZgIw = b25kr6;
        setIcon(b25kr6.getIcon());
        setTitle(b25kr6.getTitleCondensed());
        setId(b25kr6.f520AcNBzu);
        setVisibility(b25kr6.isVisible() ? 0 : 8);
        setEnabled(b25kr6.isEnabled());
        if (b25kr6.hasSubMenu() && this.f8051BI9f7h == null) {
            this.f8051BI9f7h = new androidx.appcompat.view.menu.A2egSU(this);
        }
    }

    @Override // AaHO0E.B25kr6
    public final boolean A4TApA() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // AaHO0E.B25kr6
    public final boolean A5SV6n() {
        return !TextUtils.isEmpty(getText()) && this.f8047B4ZgIw.getIcon() == null;
    }

    public final boolean AYUAbz() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    public final void AZOQYO() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f8048B7CMnp);
        if (this.f8049B9tovu != null && ((this.f8047B4ZgIw.f543CNPG0E & 4) != 4 || (!this.f8053BJ7GGh && !this.f8054BNL6CD))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f8048B7CMnp : null);
        CharSequence charSequence = this.f8047B4ZgIw.f536BTvldC;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z3 ? null : this.f8047B4ZgIw.f524B25kr6);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f8047B4ZgIw.f537BV3sI0;
        if (TextUtils.isEmpty(charSequence2)) {
            A4TApA.DV2E8K(this, z3 ? null : this.f8047B4ZgIw.f524B25kr6);
        } else {
            A4TApA.DV2E8K(this, charSequence2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // AZkASS.BPw6Q8
    public AZkASS.B25kr6 getItemData() {
        return this.f8047B4ZgIw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AlLFFp alLFFp = this.f8050BChYOn;
        if (alLFFp != null) {
            alLFFp.A4TApA(this.f8047B4ZgIw);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f8053BJ7GGh = AYUAbz();
        AZOQYO();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean isEmpty = TextUtils.isEmpty(getText());
        if (!isEmpty && (i3 = this.f8056BTvldC) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.f8055BPw6Q8;
        int min = mode == Integer.MIN_VALUE ? Math.min(size, i4) : i4;
        if (mode != 1073741824 && i4 > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!isEmpty || this.f8049B9tovu == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f8049B9tovu.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.appcompat.view.menu.A2egSU a2egSU;
        if (this.f8047B4ZgIw.hasSubMenu() && (a2egSU = this.f8051BI9f7h) != null && a2egSU.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f8054BNL6CD != z) {
            this.f8054BNL6CD = z;
            AZkASS.B25kr6 b25kr6 = this.f8047B4ZgIw;
            if (b25kr6 != null) {
                AmA8tU amA8tU = b25kr6.f533BJ7GGh;
                amA8tU.f503BChYOn = true;
                amA8tU.B25kr6(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f8049B9tovu = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f8057BV3sI0;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        AZOQYO();
    }

    public void setItemInvoker(AlLFFp alLFFp) {
        this.f8050BChYOn = alLFFp;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.f8056BTvldC = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(A2egSU a2egSU) {
        this.f8052BIYEnU = a2egSU;
    }

    public void setTitle(CharSequence charSequence) {
        this.f8048B7CMnp = charSequence;
        AZOQYO();
    }
}
