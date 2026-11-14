package com.google.android.material.button;

import AZkASS.ARc23Z;
import COJEAR.DG07BK;
import O1Vn2F.ADYaiT;
import O1nrJm.AMqCpz;
import Oay4Bh.C4FrIb;
import PCV8se.BpkvW3;
import PXXBzr.A2egSU;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.AZOQYO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialButtonToggleGroup extends AMqCpz {

    /* renamed from: BTvldC, reason: collision with root package name */
    public static final /* synthetic */ int f11487BTvldC = 0;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final LinkedHashSet f11488BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f11489BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f11490BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f11491BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final int f11492BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public HashSet f11493BPw6Q8;

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130969537, 2131952862), attributeSet);
        this.f11488BChYOn = new LinkedHashSet();
        this.f11489BI9f7h = false;
        this.f11493BPw6Q8 = new HashSet();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(getContext(), attributeSet, R$styleable.f11234BIYEnU, 2130969537, 2131952862, new int[0]);
        setSingleSelection(AmA8tU2.getBoolean(7, false));
        this.f11492BNL6CD = AmA8tU2.getResourceId(2, -1);
        this.f11491BJ7GGh = AmA8tU2.getBoolean(4, false);
        if (this.f6167B2KMhB == null) {
            this.f6167B2KMhB = BpkvW3.A4TApA(new PCV8se.A2egSU(0.0f));
        }
        setEnabled(AmA8tU2.getBoolean(0, true));
        AmA8tU2.recycle();
        setImportantForAccessibility(1);
    }

    private String getChildrenA11yClassName() {
        return (this.f11490BIYEnU ? RadioButton.class : ToggleButton.class).getName();
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && getChildAt(i2).getVisibility() != 8) {
                i++;
            }
        }
        return i;
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setA11yClassName(getChildrenA11yClassName());
    }

    public final void ARc23Z(int i, boolean z) {
        if (i == -1) {
            return;
        }
        HashSet hashSet = new HashSet(this.f11493BPw6Q8);
        if (z && !hashSet.contains(Integer.valueOf(i))) {
            if (this.f11490BIYEnU && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.f11491BJ7GGh || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        ASJ6gh(hashSet);
    }

    public final void ASJ6gh(Set set) {
        HashSet hashSet = this.f11493BPw6Q8;
        this.f11493BPw6Q8 = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            boolean contains = set.contains(Integer.valueOf(id));
            View findViewById = findViewById(id);
            if (findViewById instanceof MaterialButton) {
                this.f11489BI9f7h = true;
                ((MaterialButton) findViewById).setChecked(contains);
                this.f11489BI9f7h = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f11488BChYOn.iterator();
                while (it.hasNext()) {
                    ((AZOQYO) it.next()).A2egSU();
                }
            }
        }
        invalidate();
    }

    @Override // O1nrJm.AMqCpz, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setupButtonChild(materialButton);
            ARc23Z(materialButton.getId(), materialButton.f11471BNL6CD);
            DG07BK.B4ZgIw(materialButton, new ADYaiT(2, this));
        }
    }

    public int getCheckedButtonId() {
        if (!this.f11490BIYEnU || this.f11493BPw6Q8.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f11493BPw6Q8.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            if (this.f11493BPw6Q8.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f11492BNL6CD;
        if (i != -1) {
            ASJ6gh(Collections.singleton(Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) ARc23Z.BJ7GGh(1, getVisibleButtonCount(), this.f11490BIYEnU ? 1 : 2, false).f451AlLFFp);
    }

    public void setSelectionRequired(boolean z) {
        this.f11491BJ7GGh = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f11490BIYEnU != z) {
            this.f11490BIYEnU = z;
            ASJ6gh(new HashSet());
        }
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setA11yClassName(childrenA11yClassName);
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
