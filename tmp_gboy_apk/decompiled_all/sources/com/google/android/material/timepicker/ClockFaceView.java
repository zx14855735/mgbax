package com.google.android.material.timepicker;

import COJEAR.DG07BK;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.constraintlayout.widget.A5SV6n;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class ClockFaceView extends AYUAbz implements ARc23Z {

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final ClockHandView f11993C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final Rect f11994C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final RectF f11995CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final Rect f11996CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final SparseArray f11997COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final A5SV6n f11998CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final int[] f11999CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public final float[] f12000CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public final int f12001CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public final int f12002Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public final int f12003CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public final int f12004CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public final String[] f12005CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public float f12006CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public final ColorStateList f12007CrfGsy;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11994C4FrIb = new Rect();
        this.f11995CASmeH = new RectF();
        this.f11996CNPG0E = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.f11997COJEAR = sparseArray;
        this.f12000CTkVKb = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11221AaHO0E, 2130969559, 2131952922);
        Resources resources = getResources();
        ColorStateList BPw6Q82 = com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 1);
        this.f12007CrfGsy = BPw6Q82;
        LayoutInflater.from(context).inflate(2131493215, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(2131297557);
        this.f11993C2rE4F = clockHandView;
        this.f12001CcAIMM = resources.getDimensionPixelSize(2131166236);
        int colorForState = BPw6Q82.getColorForState(new int[]{R.attr.state_selected}, BPw6Q82.getDefaultColor());
        this.f11999CSDoyG = new int[]{colorForState, colorForState, BPw6Q82.getDefaultColor()};
        clockHandView.f12011AmA8tU.add(this);
        int defaultColor = BPw6Q8.ASJ6gh.A5SV6n(context, 2131100563).getDefaultColor();
        ColorStateList BPw6Q83 = com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 0);
        setBackgroundColor(BPw6Q83 != null ? BPw6Q83.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new A4TApA(this));
        setFocusable(false);
        obtainStyledAttributes.recycle();
        this.f11998CQhlFr = new A5SV6n(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.f12005CmUvjW = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z = false;
        for (int i = 0; i < Math.max(this.f12005CmUvjW.length, size); i++) {
            TextView textView = (TextView) sparseArray.get(i);
            if (i >= this.f12005CmUvjW.length) {
                removeView(textView);
                sparseArray.remove(i);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(2131493214, (ViewGroup) this, false);
                    sparseArray.put(i, textView);
                    addView(textView);
                }
                textView.setText(this.f12005CmUvjW[i]);
                textView.setTag(2131297579, Integer.valueOf(i));
                int i2 = (i / 12) + 1;
                textView.setTag(2131297558, Integer.valueOf(i2));
                z = i2 > 1 ? true : z;
                DG07BK.B4ZgIw(textView, this.f11998CQhlFr);
                textView.setTextColor(this.f12007CrfGsy);
            }
        }
        ClockHandView clockHandView2 = this.f11993C2rE4F;
        if (clockHandView2.f12010AlLFFp && !z) {
            clockHandView2.f12021BIYEnU = 1;
        }
        clockHandView2.f12010AlLFFp = z;
        clockHandView2.invalidate();
        this.f12002Cd8JRx = resources.getDimensionPixelSize(2131166335);
        this.f12003CikNvS = resources.getDimensionPixelSize(2131166336);
        this.f12004CkXcdM = resources.getDimensionPixelSize(2131166243);
    }

    @Override // com.google.android.material.timepicker.AYUAbz
    public final void ASJ6gh() {
        androidx.constraintlayout.widget.A5SV6n a5SV6n = new androidx.constraintlayout.widget.A5SV6n();
        a5SV6n.A4TApA(this);
        HashMap hashMap = new HashMap();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != 2131296505 && !"skip".equals(childAt.getTag())) {
                int i2 = (Integer) childAt.getTag(2131297558);
                if (i2 == null) {
                    i2 = 1;
                }
                if (!hashMap.containsKey(i2)) {
                    hashMap.put(i2, new ArrayList());
                }
                ((List) hashMap.get(i2)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List list = (List) entry.getValue();
            int round = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.f11987BniPrB * 0.66f) : this.f11987BniPrB;
            Iterator it = list.iterator();
            float f = 0.0f;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                HashMap hashMap2 = a5SV6n.f8299A5SV6n;
                if (!hashMap2.containsKey(Integer.valueOf(id))) {
                    hashMap2.put(Integer.valueOf(id), new A5SV6n.A2egSU());
                }
                A5SV6n.A4TApA a4TApA = ((A5SV6n.A2egSU) hashMap2.get(Integer.valueOf(id))).f8303ADYaiT;
                a4TApA.f8330BNL6CD = 2131296505;
                a4TApA.f8331BPw6Q8 = round;
                a4TApA.f8332BTvldC = f;
                f += 360.0f / list.size();
            }
        }
        a5SV6n.A2egSU(this);
        setConstraintSet(null);
        requestLayout();
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.f11997COJEAR;
            if (i3 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i3)).setVisibility(0);
            i3++;
        }
    }

    public final void AYUAbz() {
        SparseArray sparseArray;
        RectF rectF;
        Rect rect;
        RectF rectF2 = this.f11993C2rE4F.f12015B3GDIM;
        float f = Float.MAX_VALUE;
        TextView textView = null;
        int i = 0;
        while (true) {
            sparseArray = this.f11997COJEAR;
            int size = sparseArray.size();
            rectF = this.f11995CASmeH;
            rect = this.f11994C4FrIb;
            if (i >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float height = rectF.height() * rectF.width();
                if (height < f) {
                    textView = textView2;
                    f = height;
                }
            }
            i++;
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            TextView textView3 = (TextView) sparseArray.get(i2);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.f11996CNPG0E);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.f11999CSDoyG, this.f12000CTkVKb, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) AZkASS.ARc23Z.BJ7GGh(1, this.f12005CmUvjW.length, 1, false).f451AlLFFp);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        AYUAbz();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.f12004CkXcdM / Math.max(Math.max(this.f12002Cd8JRx / displayMetrics.heightPixels, this.f12003CikNvS / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
