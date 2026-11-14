package com.google.android.material.internal;

import AZkASS.B25kr6;
import AZkASS.BPw6Q8;
import AaHO0E.EmJGcg;
import BTvldC.AcNBzu;
import BTvldC.B4ZgIw;
import COJEAR.DG07BK;
import JrXYwF.A4TApA;
import O1Vn2F.ADYaiT;
import Oay4Bh.AYUAbz;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bumptech.glide.A5SV6n;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NavigationMenuItemView extends AYUAbz implements BPw6Q8 {

    /* renamed from: CkXcdM, reason: collision with root package name */
    public static final int[] f11693CkXcdM = {R.attr.state_checked};

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f11694C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f11695C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public boolean f11696CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f11697CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final CheckedTextView f11698COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public FrameLayout f11699CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public B25kr6 f11700CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public ColorStateList f11701CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public boolean f11702CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public Drawable f11703Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public final ADYaiT f11704CikNvS;

    static {
        PTmLka();
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11697CNPG0E = true;
        ADYaiT aDYaiT = new ADYaiT(4, this);
        this.f11704CikNvS = aDYaiT;
        setOrientation(0);
        LayoutInflater.from(context).inflate(2131492945, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(2131165310));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(2131296579);
        this.f11698COJEAR = checkedTextView;
        DG07BK.B4ZgIw(checkedTextView, aDYaiT);
    }

    private static /* synthetic */ void PTmLka() {
        char[] charArray = "xtv5|zv~5ytb5hs~ww5QurYir\u007f|~".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 27);
        }
        String str = new String(charArray);
        char[] charArray2 = "xwruro".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 27);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f11699CQhlFr == null) {
                this.f11699CQhlFr = (FrameLayout) ((ViewStub) findViewById(2131296578)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f11699CQhlFr.removeAllViews();
            this.f11699CQhlFr.addView(view);
        }
    }

    @Override // AZkASS.BPw6Q8
    public final void A2egSU(B25kr6 b25kr6) {
        StateListDrawable stateListDrawable;
        this.f11700CSDoyG = b25kr6;
        int i = b25kr6.f520AcNBzu;
        if (i > 0) {
            setId(i);
        }
        setVisibility(b25kr6.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(2130968853, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f11693CkXcdM, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(b25kr6.isCheckable());
        setChecked(b25kr6.isChecked());
        setEnabled(b25kr6.isEnabled());
        setTitle(b25kr6.f524B25kr6);
        setIcon(b25kr6.getIcon());
        setActionView(b25kr6.getActionView());
        setContentDescription(b25kr6.f536BTvldC);
        A4TApA.DV2E8K(this, b25kr6.f537BV3sI0);
        B25kr6 b25kr62 = this.f11700CSDoyG;
        CharSequence charSequence = b25kr62.f524B25kr6;
        CheckedTextView checkedTextView = this.f11698COJEAR;
        if (charSequence == null && b25kr62.getIcon() == null && this.f11700CSDoyG.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.f11699CQhlFr;
            if (frameLayout != null) {
                EmJGcg emJGcg = (EmJGcg) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) emJGcg).width = -1;
                this.f11699CQhlFr.setLayoutParams(emJGcg);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.f11699CQhlFr;
        if (frameLayout2 != null) {
            EmJGcg emJGcg2 = (EmJGcg) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) emJGcg2).width = -2;
            this.f11699CQhlFr.setLayoutParams(emJGcg2);
        }
    }

    @Override // AZkASS.BPw6Q8
    public B25kr6 getItemData() {
        return this.f11700CSDoyG;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        B25kr6 b25kr6 = this.f11700CSDoyG;
        if (b25kr6 != null && b25kr6.isCheckable() && this.f11700CSDoyG.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f11693CkXcdM);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f11696CASmeH != z) {
            this.f11696CASmeH = z;
            this.f11704CikNvS.AYUAbz(this.f11698COJEAR, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.f11698COJEAR;
        checkedTextView.setChecked(z);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z && this.f11697CNPG0E) ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f11702CcAIMM) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = A5SV6n.DvK7DB(drawable).mutate();
                drawable.setTintList(this.f11701CTkVKb);
            }
            int i = this.f11694C2rE4F;
            drawable.setBounds(0, 0, i, i);
        } else if (this.f11695C4FrIb) {
            if (this.f11703Cd8JRx == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = B4ZgIw.f1468A2egSU;
                Drawable A2egSU2 = AcNBzu.A2egSU(resources, 2131231396, theme);
                this.f11703Cd8JRx = A2egSU2;
                if (A2egSU2 != null) {
                    int i2 = this.f11694C2rE4F;
                    A2egSU2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.f11703Cd8JRx;
        }
        this.f11698COJEAR.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.f11698COJEAR.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.f11694C2rE4F = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f11701CTkVKb = colorStateList;
        this.f11702CcAIMM = colorStateList != null;
        B25kr6 b25kr6 = this.f11700CSDoyG;
        if (b25kr6 != null) {
            setIcon(b25kr6.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.f11698COJEAR.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f11695C4FrIb = z;
    }

    public void setTextAppearance(int i) {
        A4TApA.DRlcZ9(this.f11698COJEAR, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f11698COJEAR.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f11698COJEAR.setText(charSequence);
    }
}
