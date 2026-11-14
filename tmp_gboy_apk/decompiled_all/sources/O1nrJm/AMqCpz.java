package O1nrJm;

import IQ76hF.AmA8tU;
import Oay4Bh.C4FrIb;
import PCV8se.B2KMhB;
import PCV8se.BpkvW3;
import PCV8se.C2rE4F;
import PCV8se.CASmeH;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AMqCpz extends LinearLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f6162AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f6163AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AmA8tU f6164AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ADYaiT f6165AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Integer[] f6166B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public BpkvW3 f6167B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public C2rE4F f6168B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f6169B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public CASmeH f6170B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f6171B9tovu;

    /* JADX WARN: Type inference failed for: r12v5, types: [O1nrJm.ADYaiT] */
    public AMqCpz(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130969537, 2131952722), attributeSet, 2130969537);
        BpkvW3 A4TApA2;
        XmlResourceParser xml;
        int next;
        CASmeH cASmeH;
        int next2;
        this.f6162AcNBzu = new ArrayList();
        this.f6163AlLFFp = new ArrayList();
        final MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.f6164AmA8tU = new AmA8tU(21, materialButtonToggleGroup);
        this.f6165AzWtSf = new Comparator() { // from class: O1nrJm.ADYaiT
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                MaterialButtonToggleGroup materialButtonToggleGroup2 = MaterialButtonToggleGroup.this;
                int compareTo = Boolean.valueOf(materialButton.f11471BNL6CD).compareTo(Boolean.valueOf(materialButton2.f11471BNL6CD));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return compareTo2 != 0 ? compareTo2 : Integer.compare(materialButtonToggleGroup2.indexOfChild(materialButton), materialButtonToggleGroup2.indexOfChild(materialButton2));
            }
        };
        this.f6171B9tovu = true;
        Context context2 = getContext();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11233BI9f7h, 2130969537, 2131952722, new int[0]);
        if (AmA8tU2.hasValue(2)) {
            int resourceId = AmA8tU2.getResourceId(2, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                }
                try {
                    cASmeH = new CASmeH();
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next2 = xml.next();
                        if (next2 == 2) {
                            break;
                        }
                    } while (next2 != 1);
                    if (next2 != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (xml.getName().equals("selector")) {
                        cASmeH.A2egSU(context2, xml, asAttributeSet, context2.getTheme());
                    }
                    xml.close();
                    this.f6170B7CMnp = cASmeH;
                } finally {
                }
            }
            cASmeH = null;
            this.f6170B7CMnp = cASmeH;
        }
        if (AmA8tU2.hasValue(4)) {
            C2rE4F A4TApA3 = C2rE4F.A4TApA(context2, AmA8tU2, 4);
            this.f6168B3GDIM = A4TApA3;
            if (A4TApA3 == null) {
                HFjH17.ARc23Z aRc23Z = new HFjH17.ARc23Z(B2KMhB.A2egSU(context2, AmA8tU2.getResourceId(4, 0), AmA8tU2.getResourceId(5, 0)).A2egSU());
                this.f6168B3GDIM = aRc23Z.f3319A2egSU != 0 ? new C2rE4F(aRc23Z) : null;
            }
        }
        if (AmA8tU2.hasValue(3)) {
            PCV8se.A2egSU a2egSU = new PCV8se.A2egSU(0.0f);
            int resourceId2 = AmA8tU2.getResourceId(3, 0);
            if (resourceId2 == 0) {
                A4TApA2 = BpkvW3.A4TApA(B2KMhB.ADYaiT(AmA8tU2, 3, a2egSU));
            } else if (context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        A4TApA2 = new BpkvW3();
                        AttributeSet asAttributeSet2 = Xml.asAttributeSet(xml);
                        do {
                            next = xml.next();
                            if (next == 2) {
                                break;
                            }
                        } while (next != 1);
                        if (next != 2) {
                            throw new XmlPullParserException("No start tag found");
                        }
                        if (xml.getName().equals("selector")) {
                            A4TApA2.ADYaiT(context2, xml, asAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    A4TApA2 = BpkvW3.A4TApA(a2egSU);
                }
            } else {
                A4TApA2 = BpkvW3.A4TApA(B2KMhB.ADYaiT(AmA8tU2, 3, a2egSU));
            }
            this.f6167B2KMhB = A4TApA2;
        }
        this.f6169B4ZgIw = AmA8tU2.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(AmA8tU2.getBoolean(0, true));
        AmA8tU2.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (A5SV6n(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (A5SV6n(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    public final void A2egSU() {
        int i;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i2);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i2 - 1);
            if (this.f6169B4ZgIw <= 0) {
                i = Math.min(materialButton.getStrokeWidth(), materialButton2.getStrokeWidth());
                materialButton.setShouldDrawSurfaceColorStroke(true);
                materialButton2.setShouldDrawSurfaceColorStroke(true);
            } else {
                materialButton.setShouldDrawSurfaceColorStroke(false);
                materialButton2.setShouldDrawSurfaceColorStroke(false);
                i = 0;
            }
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(this.f6169B4ZgIw - i);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.f6169B4ZgIw - i;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    public final void A4TApA() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float max;
        if (this.f6170B7CMnp == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int i = Integer.MAX_VALUE;
        for (int i2 = firstVisibleChildIndex; i2 <= lastVisibleChildIndex; i2++) {
            if (A5SV6n(i2)) {
                if (A5SV6n(i2) && this.f6170B7CMnp != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i2);
                    CASmeH cASmeH = this.f6170B7CMnp;
                    int width = materialButton3.getWidth();
                    int i3 = -width;
                    for (int i4 = 0; i4 < cASmeH.f7159A2egSU; i4++) {
                        PCV8se.C4FrIb c4FrIb = (PCV8se.C4FrIb) cASmeH.f7162ADYaiT[i4].f5658AlLFFp;
                        int i5 = c4FrIb.f7157A2egSU;
                        float f = c4FrIb.f7158A4TApA;
                        if (i5 == 2) {
                            max = Math.max(i3, f);
                        } else if (i5 == 1) {
                            max = Math.max(i3, width * f);
                        }
                        i3 = (int) max;
                    }
                    int max2 = Math.max(0, i3);
                    int i6 = i2 - 1;
                    while (true) {
                        materialButton = null;
                        if (i6 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (A5SV6n(i6)) {
                                materialButton2 = (MaterialButton) getChildAt(i6);
                                break;
                            }
                            i6--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i7 = i2 + 1;
                    while (true) {
                        if (i7 >= childCount) {
                            break;
                        }
                        if (A5SV6n(i7)) {
                            materialButton = (MaterialButton) getChildAt(i7);
                            break;
                        }
                        i7++;
                    }
                    r5 = Math.min(max2, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i2 != firstVisibleChildIndex && i2 != lastVisibleChildIndex) {
                    r5 /= 2;
                }
                i = Math.min(i, r5);
            }
        }
        int i8 = firstVisibleChildIndex;
        while (i8 <= lastVisibleChildIndex) {
            if (A5SV6n(i8)) {
                ((MaterialButton) getChildAt(i8)).setSizeChange(this.f6170B7CMnp);
                ((MaterialButton) getChildAt(i8)).setWidthChangeMax((i8 == firstVisibleChildIndex || i8 == lastVisibleChildIndex) ? i : i * 2);
            }
            i8++;
        }
    }

    public final boolean A5SV6n(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public final void ADYaiT() {
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            LinearLayout.LayoutParams layoutParams = materialButton.f11477C2rE4F;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.f11477C2rE4F = null;
                materialButton.f11475BmvVmW = -1.0f;
            }
        }
    }

    public final void AMqCpz() {
        HFjH17.ARc23Z aRc23Z;
        int i;
        if (!(this.f6167B2KMhB == null && this.f6168B3GDIM == null) && this.f6171B9tovu) {
            this.f6171B9tovu = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i2 = 0;
            while (i2 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i2);
                if (materialButton.getVisibility() != 8) {
                    boolean z = i2 == firstVisibleChildIndex;
                    boolean z2 = i2 == lastVisibleChildIndex;
                    C2rE4F c2rE4F = this.f6168B3GDIM;
                    if (c2rE4F == null || (!z && !z2)) {
                        c2rE4F = (C2rE4F) this.f6163AlLFFp.get(i2);
                    }
                    if (c2rE4F == null) {
                        aRc23Z = new HFjH17.ARc23Z((B2KMhB) this.f6162AcNBzu.get(i2));
                    } else {
                        HFjH17.ARc23Z aRc23Z2 = new HFjH17.ARc23Z();
                        int i3 = c2rE4F.f7150A2egSU;
                        aRc23Z2.f3319A2egSU = i3;
                        aRc23Z2.f3320A4TApA = c2rE4F.f7151A4TApA;
                        int[][] iArr = c2rE4F.f7152A5SV6n;
                        int[][] iArr2 = new int[iArr.length][];
                        aRc23Z2.f3321A5SV6n = iArr2;
                        B2KMhB[] b2KMhBArr = c2rE4F.f7153ADYaiT;
                        aRc23Z2.f3322ADYaiT = new B2KMhB[b2KMhBArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, i3);
                        System.arraycopy(b2KMhBArr, 0, (B2KMhB[]) aRc23Z2.f3322ADYaiT, 0, aRc23Z2.f3319A2egSU);
                        aRc23Z2.AMqCpz = c2rE4F.AMqCpz;
                        aRc23Z2.f3323ARc23Z = c2rE4F.f7154ARc23Z;
                        aRc23Z2.f3324ASJ6gh = c2rE4F.f7155ASJ6gh;
                        aRc23Z2.f3325AYUAbz = c2rE4F.f7156AYUAbz;
                        aRc23Z = aRc23Z2;
                    }
                    boolean z3 = getOrientation() == 0;
                    boolean z4 = getLayoutDirection() == 1;
                    if (z3) {
                        i = z ? 5 : 0;
                        if (z2) {
                            i |= 10;
                        }
                        if (z4) {
                            i = ((i & 10) >> 1) | ((i & 5) << 1);
                        }
                    } else {
                        i = z ? 3 : 0;
                        if (z2) {
                            i |= 12;
                        }
                    }
                    int i4 = ~i;
                    BpkvW3 bpkvW3 = this.f6167B2KMhB;
                    if ((i4 | 1) == i4) {
                        aRc23Z.AMqCpz = bpkvW3;
                    }
                    if ((i4 | 2) == i4) {
                        aRc23Z.f3323ARc23Z = bpkvW3;
                    }
                    if ((i4 | 4) == i4) {
                        aRc23Z.f3324ASJ6gh = bpkvW3;
                    }
                    if ((i4 | 8) == i4) {
                        aRc23Z.f3325AYUAbz = bpkvW3;
                    }
                    C2rE4F c2rE4F2 = aRc23Z.f3319A2egSU == 0 ? null : new C2rE4F(aRc23Z);
                    if (c2rE4F2.ADYaiT()) {
                        materialButton.setStateListShapeAppearanceModel(c2rE4F2);
                    } else {
                        materialButton.setShapeAppearanceModel(c2rE4F2.A5SV6n());
                    }
                }
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            ADYaiT();
            this.f6171B9tovu = true;
            super.addView(view, i, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            materialButton.setOnPressedChangeListenerInternal(this.f6164AmA8tU);
            this.f6162AcNBzu.add(materialButton.getShapeAppearanceModel());
            this.f6163AlLFFp.add(materialButton.getStateListShapeAppearanceModel());
            materialButton.setEnabled(isEnabled());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f6165AzWtSf);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.f6166B25kr6 = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public CASmeH getButtonSizeChange() {
        return this.f6170B7CMnp;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.f6166B25kr6;
        return (numArr == null || i2 >= numArr.length) ? i2 : numArr[i2].intValue();
    }

    public PCV8se.ADYaiT getInnerCornerSize() {
        return this.f6167B2KMhB.f7147A4TApA;
    }

    public BpkvW3 getInnerCornerSizeStateList() {
        return this.f6167B2KMhB;
    }

    public B2KMhB getShapeAppearance() {
        C2rE4F c2rE4F = this.f6168B3GDIM;
        if (c2rE4F == null) {
            return null;
        }
        return c2rE4F.A5SV6n();
    }

    public int getSpacing() {
        return this.f6169B4ZgIw;
    }

    public C2rE4F getStateListShapeAppearance() {
        return this.f6168B3GDIM;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            ADYaiT();
            A4TApA();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        AMqCpz();
        A2egSU();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f6162AcNBzu.remove(indexOfChild);
            this.f6163AlLFFp.remove(indexOfChild);
        }
        this.f6171B9tovu = true;
        AMqCpz();
        ADYaiT();
        A2egSU();
    }

    public void setButtonSizeChange(CASmeH cASmeH) {
        if (this.f6170B7CMnp != cASmeH) {
            this.f6170B7CMnp = cASmeH;
            A4TApA();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setEnabled(z);
        }
    }

    public void setInnerCornerSize(PCV8se.ADYaiT aDYaiT) {
        this.f6167B2KMhB = BpkvW3.A4TApA(aDYaiT);
        this.f6171B9tovu = true;
        AMqCpz();
        invalidate();
    }

    public void setInnerCornerSizeStateList(BpkvW3 bpkvW3) {
        this.f6167B2KMhB = bpkvW3;
        this.f6171B9tovu = true;
        AMqCpz();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (getOrientation() != i) {
            this.f6171B9tovu = true;
        }
        super.setOrientation(i);
    }

    public void setShapeAppearance(B2KMhB b2KMhB) {
        HFjH17.ARc23Z aRc23Z = new HFjH17.ARc23Z(b2KMhB);
        this.f6168B3GDIM = aRc23Z.f3319A2egSU == 0 ? null : new C2rE4F(aRc23Z);
        this.f6171B9tovu = true;
        AMqCpz();
        invalidate();
    }

    public void setSpacing(int i) {
        this.f6169B4ZgIw = i;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(C2rE4F c2rE4F) {
        this.f6168B3GDIM = c2rE4F;
        this.f6171B9tovu = true;
        AMqCpz();
        invalidate();
    }
}
