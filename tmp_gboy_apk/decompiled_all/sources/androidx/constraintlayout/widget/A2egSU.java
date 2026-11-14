package androidx.constraintlayout.widget;

import BChYOn.ARc23Z;
import BChYOn.AaHO0E;
import BJ7GGh.ADYaiT;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU extends View {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int[] f8277AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f8278AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Context f8279AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AaHO0E f8280AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public String f8281B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public String f8282B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public HashMap f8283B3GDIM;

    public A2egSU(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8277AcNBzu = new int[32];
        this.f8283B3GDIM = new HashMap();
        this.f8279AmA8tU = context;
        ASJ6gh(attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A2egSU(java.lang.String r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L93
            int r0 = r6.length()
            if (r0 != 0) goto La
            goto L93
        La:
            android.content.Context r0 = r5.f8279AmA8tU
            if (r0 != 0) goto L10
            goto L93
        L10:
            java.lang.String r6 = r6.trim()
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            if (r1 == 0) goto L22
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
        L22:
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r2 = 0
            if (r1 == 0) goto L32
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L33
        L32:
            r1 = r2
        L33:
            boolean r3 = r5.isInEditMode()
            if (r3 == 0) goto L5e
            if (r1 == 0) goto L5e
            boolean r3 = ADYaiT.CtFAbx.B9tovu(r6)
            if (r3 == 0) goto L52
            java.util.HashMap r3 = r1.f8411BIYEnU
            if (r3 == 0) goto L52
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L52
            java.util.HashMap r3 = r1.f8411BIYEnU
            java.lang.Object r3 = r3.get(r6)
            goto L53
        L52:
            r3 = r2
        L53:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L5e
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L5f
        L5e:
            r3 = 0
        L5f:
            if (r3 != 0) goto L67
            if (r1 == 0) goto L67
            int r3 = r5.ARc23Z(r1, r6)
        L67:
            if (r3 != 0) goto L75
            java.lang.Class<androidx.constraintlayout.widget.R$id> r1 = androidx.constraintlayout.widget.R$id.class
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch: java.lang.Exception -> L74
            int r3 = r1.getInt(r2)     // Catch: java.lang.Exception -> L74
            goto L75
        L74:
        L75:
            if (r3 != 0) goto L85
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r3 = r1.getIdentifier(r6, r2, r0)
        L85:
            if (r3 == 0) goto L93
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.util.HashMap r1 = r5.f8283B3GDIM
            r1.put(r0, r6)
            r5.A4TApA(r3)
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.A2egSU.A2egSU(java.lang.String):void");
    }

    public final void A4TApA(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.f8278AlLFFp + 1;
        int[] iArr = this.f8277AcNBzu;
        if (i2 > iArr.length) {
            this.f8277AcNBzu = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f8277AcNBzu;
        int i3 = this.f8278AlLFFp;
        iArr2[i3] = i;
        this.f8278AlLFFp = i3 + 1;
    }

    public final void A5SV6n(String str) {
        if (str == null || str.length() == 0 || this.f8279AmA8tU == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ADYaiT) && trim.equals(((ADYaiT) layoutParams).f1391D6DOie) && childAt.getId() != -1) {
                A4TApA(childAt.getId());
            }
        }
    }

    public final void ADYaiT(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.f8278AlLFFp; i++) {
            View view = (View) constraintLayout.f8399AcNBzu.get(this.f8277AcNBzu[i]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void AMqCpz(ConstraintLayout constraintLayout) {
    }

    public final int ARc23Z(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str != null && (resources = this.f8279AmA8tU.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                if (childAt.getId() != -1) {
                    try {
                        str2 = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        str2 = null;
                    }
                    if (str.equals(str2)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    public void ASJ6gh(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f8417A4TApA);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 35) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f8281B25kr6 = string;
                    setIds(string);
                } else if (index == 36) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f8282B2KMhB = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public abstract void AYUAbz(ARc23Z aRc23Z, boolean z);

    public final void AZOQYO() {
        if (this.f8280AzWtSf == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ADYaiT) {
            ((ADYaiT) layoutParams).f1406DjONCG = this.f8280AzWtSf;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f8277AcNBzu, this.f8278AlLFFp);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f8281B25kr6;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f8282B2KMhB;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f8281B25kr6 = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f8278AlLFFp = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                A2egSU(str.substring(i));
                return;
            } else {
                A2egSU(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f8282B2KMhB = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f8278AlLFFp = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                A5SV6n(str.substring(i));
                return;
            } else {
                A5SV6n(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f8281B25kr6 = null;
        this.f8278AlLFFp = 0;
        for (int i : iArr) {
            A4TApA(i);
        }
    }

    @Override // android.view.View
    public final void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.f8281B25kr6 == null) {
            A4TApA(i);
        }
    }
}
