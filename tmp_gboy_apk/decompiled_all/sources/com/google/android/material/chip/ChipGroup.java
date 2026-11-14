package com.google.android.material.chip;

import AZkASS.ARc23Z;
import IQ76hF.AmA8tU;
import OLvDpK.AYUAbz;
import OLvDpK.AZOQYO;
import OLvDpK.AZkASS;
import Oay4Bh.A2egSU;
import Oay4Bh.ASJ6gh;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ChipGroup extends ASJ6gh {

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f11567B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f11568B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public AZOQYO f11569B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final A2egSU f11570B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final int f11571B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final AZkASS f11572B9tovu;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ChipGroup(android.content.Context r10, android.util.AttributeSet r11) {
        /*
            r9 = this;
            r3 = 2130968790(0x7f0400d6, float:1.7546244E38)
            r0 = 2131952848(0x7f1304d0, float:1.954215E38)
            android.content.Context r10 = PXXBzr.A2egSU.A2egSU(r10, r11, r3, r0)
            r9.<init>(r10, r11, r3)
            r6 = 0
            r9.f6525AmA8tU = r6
            android.content.res.Resources$Theme r10 = r10.getTheme()
            int[] r0 = com.google.android.material.R$styleable.f11225AzWtSf
            android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r11, r0, r6, r6)
            r7 = 1
            int r0 = r10.getDimensionPixelSize(r7, r6)
            r9.f6523AcNBzu = r0
            int r0 = r10.getDimensionPixelSize(r6, r6)
            r9.f6524AlLFFp = r0
            r10.recycle()
            Oay4Bh.A2egSU r10 = new Oay4Bh.A2egSU
            r10.<init>()
            r9.f11570B4ZgIw = r10
            OLvDpK.AZkASS r8 = new OLvDpK.AZkASS
            r8.<init>(r9)
            r9.f11572B9tovu = r8
            android.content.Context r0 = r9.getContext()
            int[] r2 = com.google.android.material.R$styleable.f11220AZkASS
            r4 = 2131952848(0x7f1304d0, float:1.954215E38)
            int[] r5 = new int[r6]
            r1 = r11
            android.content.res.TypedArray r11 = Oay4Bh.C4FrIb.AmA8tU(r0, r1, r2, r3, r4, r5)
            int r0 = r11.getDimensionPixelOffset(r7, r6)
            r1 = 2
            int r1 = r11.getDimensionPixelOffset(r1, r0)
            r9.setChipSpacingHorizontal(r1)
            r1 = 3
            int r0 = r11.getDimensionPixelOffset(r1, r0)
            r9.setChipSpacingVertical(r0)
            r0 = 5
            boolean r0 = r11.getBoolean(r0, r6)
            r9.setSingleLine(r0)
            r0 = 6
            boolean r0 = r11.getBoolean(r0, r6)
            r9.setSingleSelection(r0)
            r0 = 4
            boolean r0 = r11.getBoolean(r0, r6)
            r9.setSelectionRequired(r0)
            r0 = -1
            int r0 = r11.getResourceId(r6, r0)
            r9.f11571B7CMnp = r0
            r11.recycle()
            NGepWW.A2egSU r11 = new NGepWW.A2egSU
            r0 = 5
            r11.<init>(r0, r9)
            r10.f6454A5SV6n = r11
            super.setOnHierarchyChangeListener(r8)
            r9.setImportantForAccessibility(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private int getVisibleChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof Chip) && getChildAt(i2).getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof OLvDpK.ASJ6gh);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new OLvDpK.ASJ6gh(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new OLvDpK.ASJ6gh(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.f11570B4ZgIw.A5SV6n();
    }

    public List<Integer> getCheckedChipIds() {
        return this.f11570B4ZgIw.A4TApA(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f11567B25kr6;
    }

    public int getChipSpacingVertical() {
        return this.f11568B2KMhB;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f11571B7CMnp;
        if (i != -1) {
            A2egSU a2egSU = this.f11570B4ZgIw;
            Oay4Bh.AZkASS aZkASS = (Oay4Bh.AZkASS) a2egSU.f6452A2egSU.get(Integer.valueOf(i));
            if (aZkASS != null && a2egSU.A2egSU(aZkASS)) {
                a2egSU.ADYaiT();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) ARc23Z.BJ7GGh(getRowCount(), this.f6525AmA8tU ? getVisibleChipCount() : -1, this.f11570B4ZgIw.f6455ADYaiT ? 1 : 2, false).f451AlLFFp);
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.f11567B25kr6 != i) {
            this.f11567B25kr6 = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.f11568B2KMhB != i) {
            this.f11568B2KMhB = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(AYUAbz aYUAbz) {
        if (aYUAbz == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new AmA8tU(22, this));
        }
    }

    public void setOnCheckedStateChangeListener(AZOQYO azoqyo) {
        this.f11569B3GDIM = azoqyo;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f11572B9tovu.f6334AcNBzu = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.f11570B4ZgIw.AMqCpz = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // Oay4Bh.ASJ6gh
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        A2egSU a2egSU = this.f11570B4ZgIw;
        if (a2egSU.f6455ADYaiT != z) {
            a2egSU.f6455ADYaiT = z;
            boolean isEmpty = a2egSU.f6453A4TApA.isEmpty();
            Iterator it = a2egSU.f6452A2egSU.values().iterator();
            while (it.hasNext()) {
                a2egSU.AMqCpz((Oay4Bh.AZkASS) it.next(), false);
            }
            if (isEmpty) {
                return;
            }
            a2egSU.ADYaiT();
        }
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new OLvDpK.ASJ6gh(layoutParams);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
