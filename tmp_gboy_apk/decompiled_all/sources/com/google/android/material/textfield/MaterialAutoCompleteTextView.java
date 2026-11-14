package com.google.android.material.textfield;

import AaHO0E.B4ZgIw;
import AaHO0E.CmUvjW;
import AaHO0E.FM663C;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PXXBzr.A2egSU;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialAutoCompleteTextView extends B4ZgIw {

    /* renamed from: B25kr6, reason: collision with root package name */
    public final FM663C f11896B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final AccessibilityManager f11897B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Rect f11898B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f11899B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final float f11900B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public ColorStateList f11901B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f11902BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ColorStateList f11903BI9f7h;

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130968646, 0), attributeSet);
        this.f11898B3GDIM = new Rect();
        Context context2 = getContext();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11231B9tovu, 2130968646, 2131952529, new int[0]);
        if (AmA8tU2.hasValue(0) && AmA8tU2.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f11899B4ZgIw = AmA8tU2.getResourceId(3, 2131493235);
        this.f11900B7CMnp = AmA8tU2.getDimensionPixelOffset(1, 2131166429);
        if (AmA8tU2.hasValue(2)) {
            this.f11901B9tovu = ColorStateList.valueOf(AmA8tU2.getColor(2, 0));
        }
        this.f11902BChYOn = AmA8tU2.getColor(4, 0);
        this.f11903BI9f7h = AMqCpz.BPw6Q8(context2, AmA8tU2, 5);
        this.f11897B2KMhB = (AccessibilityManager) context2.getSystemService("accessibility");
        FM663C fm663c = new FM663C(context2, null, 2130969507);
        this.f11896B25kr6 = fm663c;
        fm663c.f844CNPG0E = true;
        fm663c.f845COJEAR.setFocusable(true);
        fm663c.f835BNL6CD = this;
        fm663c.f845COJEAR.setInputMethodMode(2);
        fm663c.AlLFFp(getAdapter());
        fm663c.f836BPw6Q8 = new CmUvjW(3, this);
        if (AmA8tU2.hasValue(6)) {
            setSimpleItems(AmA8tU2.getResourceId(6, 0));
        }
        AmA8tU2.recycle();
    }

    public final TextInputLayout A4TApA() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean A5SV6n() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f11897B2KMhB;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) == null) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
            if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if (A5SV6n()) {
            this.f11896B25kr6.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f11901B9tovu;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout A4TApA2 = A4TApA();
        return (A4TApA2 == null || !A4TApA2.f11937CikNvS) ? super.getHint() : A4TApA2.getHint();
    }

    public float getPopupElevation() {
        return this.f11900B7CMnp;
    }

    public int getSimpleItemSelectedColor() {
        return this.f11902BChYOn;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f11903BI9f7h;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout A4TApA2 = A4TApA();
        if (A4TApA2 != null && A4TApA2.f11937CikNvS && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11896B25kr6.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout A4TApA2 = A4TApA();
            int i3 = 0;
            if (adapter != null && A4TApA2 != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                FM663C fm663c = this.f11896B25kr6;
                int min = Math.min(adapter.getCount(), Math.max(0, !fm663c.f845COJEAR.isShowing() ? -1 : fm663c.f823AmA8tU.getSelectedItemPosition()) + 15);
                View view = null;
                int i4 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i3) {
                        view = null;
                        i3 = itemViewType;
                    }
                    view = adapter.getView(max, view, A4TApA2);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i4 = Math.max(i4, view.getMeasuredWidth());
                }
                Drawable background = fm663c.f845COJEAR.getBackground();
                if (background != null) {
                    Rect rect = this.f11898B3GDIM;
                    background.getPadding(rect);
                    i4 += rect.left + rect.right;
                }
                i3 = A4TApA2.getEndIconView().getMeasuredWidth() + i4;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i3), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        if (A5SV6n()) {
            return;
        }
        super.onWindowFocusChanged(z);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f11896B25kr6.AlLFFp(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        FM663C fm663c = this.f11896B25kr6;
        if (fm663c != null) {
            fm663c.ASJ6gh(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f11901B9tovu = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof AaHO0E) {
            ((AaHO0E) dropDownBackground).B3GDIM(this.f11901B9tovu);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f11896B25kr6.f837BTvldC = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i) {
        super.setRawInputType(i);
        TextInputLayout A4TApA2 = A4TApA();
        if (A4TApA2 != null) {
            A4TApA2.B9tovu();
        }
    }

    public void setSimpleItemSelectedColor(int i) {
        this.f11902BChYOn = i;
        if (getAdapter() instanceof PWr3nF.B4ZgIw) {
            ((PWr3nF.B4ZgIw) getAdapter()).A2egSU();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f11903BI9f7h = colorStateList;
        if (getAdapter() instanceof PWr3nF.B4ZgIw) {
            ((PWr3nF.B4ZgIw) getAdapter()).A2egSU();
        }
    }

    public void setSimpleItems(int i) {
        setSimpleItems(getResources().getStringArray(i));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (A5SV6n()) {
            this.f11896B25kr6.show();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new PWr3nF.B4ZgIw(this, getContext(), this.f11899B4ZgIw, strArr));
    }
}
