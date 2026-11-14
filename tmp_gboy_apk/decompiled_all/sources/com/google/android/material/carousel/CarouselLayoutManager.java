package com.google.android.material.carousel;

import ADYaiT.CtFAbx;
import NdEzCJ.A2egSU;
import OCUYV2.A4TApA;
import OCUYV2.A5SV6n;
import OCUYV2.ADYaiT;
import OCUYV2.AMqCpz;
import OCUYV2.ARc23Z;
import OCUYV2.AZOQYO;
import OCUYV2.AcNBzu;
import OCUYV2.AlLFFp;
import OCUYV2.AmA8tU;
import OCUYV2.AzWtSf;
import OCUYV2.B25kr6;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.DG07BK;
import androidx.recyclerview.widget.DXnQ0V;
import androidx.recyclerview.widget.Ddcejp;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$styleable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CarouselLayoutManager extends RecyclerView.ARc23Z implements A4TApA, Ddcejp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f11501A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f11502A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f11503A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final AMqCpz f11504ADYaiT;
    public final AZOQYO AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AmA8tU f11505ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public AlLFFp f11506ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f11507AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public HashMap f11508AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public ARc23Z f11509AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final View.OnLayoutChangeListener f11510AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f11511AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f11512AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f11513AmA8tU;

    public CarouselLayoutManager() {
        this(new B25kr6());
    }

    public static I3HV03.A4TApA B25kr6(List list, float f, boolean z) {
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MAX_VALUE;
        float f4 = Float.MAX_VALUE;
        float f5 = -3.4028235E38f;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < list.size(); i5++) {
            AcNBzu acNBzu = (AcNBzu) list.get(i5);
            float f6 = z ? acNBzu.f6251A4TApA : acNBzu.f6250A2egSU;
            float abs = Math.abs(f6 - f);
            if (f6 <= f && abs <= f2) {
                i = i5;
                f2 = abs;
            }
            if (f6 > f && abs <= f3) {
                i3 = i5;
                f3 = abs;
            }
            if (f6 <= f4) {
                i2 = i5;
                f4 = f6;
            }
            if (f6 > f5) {
                i4 = i5;
                f5 = f6;
            }
        }
        if (i == -1) {
            i = i2;
        }
        if (i3 == -1) {
            i3 = i4;
        }
        return new I3HV03.A4TApA((AcNBzu) list.get(i), (AcNBzu) list.get(i3));
    }

    public final float ADYaiT(float f, float f2) {
        return B3GDIM() ? f - f2 : f + f2;
    }

    public final void AMqCpz(DXnQ0V dXnQ0V, int i, int i2) {
        if (i < 0 || i >= getItemCount()) {
            return;
        }
        float AZOQYO2 = AZOQYO(i);
        View ADYaiT2 = dXnQ0V.ADYaiT(i);
        measureChildWithMargins(ADYaiT2, 0, 0);
        float ADYaiT3 = ADYaiT(AZOQYO2, this.f11506ASJ6gh.f6257A2egSU / 2.0f);
        I3HV03.A4TApA B25kr62 = B25kr6(this.f11506ASJ6gh.f6259A5SV6n, ADYaiT3, false);
        float AYUAbz2 = AYUAbz(ADYaiT3, B25kr62);
        float f = this.f11506ASJ6gh.f6257A2egSU / 2.0f;
        addView(ADYaiT2, i2);
        measureChildWithMargins(ADYaiT2, 0, 0);
        this.f11509AZkASS.ARc23Z(ADYaiT2, (int) (AYUAbz2 - f), (int) (AYUAbz2 + f));
        BIYEnU(ADYaiT2, ADYaiT3, B25kr62);
    }

    public final void ARc23Z(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        float AZOQYO2 = AZOQYO(i);
        while (i < aaHO0E.A4TApA()) {
            float ADYaiT2 = ADYaiT(AZOQYO2, this.f11506ASJ6gh.f6257A2egSU / 2.0f);
            I3HV03.A4TApA B25kr62 = B25kr6(this.f11506ASJ6gh.f6259A5SV6n, ADYaiT2, false);
            float AYUAbz2 = AYUAbz(ADYaiT2, B25kr62);
            if (B4ZgIw(AYUAbz2, B25kr62)) {
                return;
            }
            AZOQYO2 = ADYaiT(AZOQYO2, this.f11506ASJ6gh.f6257A2egSU);
            if (!B7CMnp(AYUAbz2, B25kr62)) {
                View ADYaiT3 = dXnQ0V.ADYaiT(i);
                float f = this.f11506ASJ6gh.f6257A2egSU / 2.0f;
                addView(ADYaiT3, -1);
                measureChildWithMargins(ADYaiT3, 0, 0);
                this.f11509AZkASS.ARc23Z(ADYaiT3, (int) (AYUAbz2 - f), (int) (AYUAbz2 + f));
                BIYEnU(ADYaiT3, ADYaiT2, B25kr62);
            }
            i++;
        }
    }

    public final void ASJ6gh(int i, DXnQ0V dXnQ0V) {
        float AZOQYO2 = AZOQYO(i);
        while (i >= 0) {
            float ADYaiT2 = ADYaiT(AZOQYO2, this.f11506ASJ6gh.f6257A2egSU / 2.0f);
            I3HV03.A4TApA B25kr62 = B25kr6(this.f11506ASJ6gh.f6259A5SV6n, ADYaiT2, false);
            float AYUAbz2 = AYUAbz(ADYaiT2, B25kr62);
            if (B7CMnp(AYUAbz2, B25kr62)) {
                return;
            }
            float f = this.f11506ASJ6gh.f6257A2egSU;
            AZOQYO2 = B3GDIM() ? AZOQYO2 + f : AZOQYO2 - f;
            if (!B4ZgIw(AYUAbz2, B25kr62)) {
                View ADYaiT3 = dXnQ0V.ADYaiT(i);
                float f2 = this.f11506ASJ6gh.f6257A2egSU / 2.0f;
                addView(ADYaiT3, 0);
                measureChildWithMargins(ADYaiT3, 0, 0);
                this.f11509AZkASS.ARc23Z(ADYaiT3, (int) (AYUAbz2 - f2), (int) (AYUAbz2 + f2));
                BIYEnU(ADYaiT3, ADYaiT2, B25kr62);
            }
            i--;
        }
    }

    public final float AYUAbz(float f, I3HV03.A4TApA a4TApA) {
        AcNBzu acNBzu = (AcNBzu) a4TApA.f3808AlLFFp;
        float f2 = acNBzu.f6251A4TApA;
        AcNBzu acNBzu2 = (AcNBzu) a4TApA.f3809AmA8tU;
        float f3 = acNBzu2.f6251A4TApA;
        float f4 = acNBzu.f6250A2egSU;
        float f5 = acNBzu2.f6250A2egSU;
        float A4TApA2 = A2egSU.A4TApA(f2, f3, f4, f5, f);
        if (acNBzu2 != this.f11506ASJ6gh.A4TApA() && acNBzu != this.f11506ASJ6gh.ADYaiT()) {
            return A4TApA2;
        }
        return CtFAbx.A4TApA(1.0f, acNBzu2.f6252A5SV6n, f - f5, A4TApA2);
    }

    public final float AZOQYO(int i) {
        return ADYaiT(this.f11509AZkASS.ADYaiT() - this.f11501A2egSU, this.f11506ASJ6gh.f6257A2egSU * i);
    }

    public final void AZkASS(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Rect rect = new Rect();
            super.getDecoratedBoundsWithMargins(childAt, rect);
            float centerX = B2KMhB() ? rect.centerX() : rect.centerY();
            if (!B7CMnp(centerX, B25kr6(this.f11506ASJ6gh.f6259A5SV6n, centerX, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, dXnQ0V);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            Rect rect2 = new Rect();
            super.getDecoratedBoundsWithMargins(childAt2, rect2);
            float centerX2 = B2KMhB() ? rect2.centerX() : rect2.centerY();
            if (!B4ZgIw(centerX2, B25kr6(this.f11506ASJ6gh.f6259A5SV6n, centerX2, true))) {
                break;
            } else {
                removeAndRecycleView(childAt2, dXnQ0V);
            }
        }
        if (getChildCount() == 0) {
            ASJ6gh(this.f11507AYUAbz - 1, dXnQ0V);
            ARc23Z(this.f11507AYUAbz, dXnQ0V, aaHO0E);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            ASJ6gh(position - 1, dXnQ0V);
            ARc23Z(position2 + 1, dXnQ0V, aaHO0E);
        }
    }

    public final int AaHO0E() {
        return B2KMhB() ? getWidth() : getHeight();
    }

    public final AlLFFp AcNBzu(int i) {
        AlLFFp alLFFp;
        HashMap hashMap = this.f11508AZOQYO;
        return (hashMap == null || (alLFFp = (AlLFFp) hashMap.get(Integer.valueOf(com.bumptech.glide.AMqCpz.B3GDIM(i, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.f11505ARc23Z.f6262A2egSU : alLFFp;
    }

    public final int AlLFFp(int i, boolean z) {
        int AmA8tU2 = AmA8tU(i, this.f11505ARc23Z.A4TApA(this.f11501A2egSU, this.f11502A4TApA, this.f11503A5SV6n, true)) - this.f11501A2egSU;
        int AmA8tU3 = this.f11508AZOQYO != null ? AmA8tU(i, AcNBzu(i)) - this.f11501A2egSU : AmA8tU2;
        return (!z || Math.abs(AmA8tU3) >= Math.abs(AmA8tU2)) ? AmA8tU2 : AmA8tU3;
    }

    public final int AmA8tU(int i, AlLFFp alLFFp) {
        if (!B3GDIM()) {
            return (int) ((alLFFp.f6257A2egSU / 2.0f) + ((i * alLFFp.f6257A2egSU) - alLFFp.A2egSU().f6250A2egSU));
        }
        float AaHO0E2 = AaHO0E() - alLFFp.A5SV6n().f6250A2egSU;
        float f = alLFFp.f6257A2egSU;
        return (int) ((AaHO0E2 - (i * f)) - (f / 2.0f));
    }

    public final int AzWtSf(int i, AlLFFp alLFFp) {
        int i2 = Integer.MAX_VALUE;
        for (AcNBzu acNBzu : alLFFp.f6259A5SV6n.subList(alLFFp.f6260ADYaiT, alLFFp.AMqCpz + 1)) {
            float f = alLFFp.f6257A2egSU;
            float f2 = (f / 2.0f) + (i * f);
            int AaHO0E2 = (B3GDIM() ? (int) ((AaHO0E() - acNBzu.f6250A2egSU) - f2) : (int) (f2 - acNBzu.f6250A2egSU)) - this.f11501A2egSU;
            if (Math.abs(i2) > Math.abs(AaHO0E2)) {
                i2 = AaHO0E2;
            }
        }
        return i2;
    }

    public final boolean B2KMhB() {
        return this.f11509AZkASS.f6231A2egSU == 0;
    }

    public final boolean B3GDIM() {
        return B2KMhB() && getLayoutDirection() == 1;
    }

    public final boolean B4ZgIw(float f, I3HV03.A4TApA a4TApA) {
        AcNBzu acNBzu = (AcNBzu) a4TApA.f3808AlLFFp;
        float f2 = acNBzu.f6253ADYaiT;
        AcNBzu acNBzu2 = (AcNBzu) a4TApA.f3809AmA8tU;
        float A4TApA2 = A2egSU.A4TApA(f2, acNBzu2.f6253ADYaiT, acNBzu.f6251A4TApA, acNBzu2.f6251A4TApA, f) / 2.0f;
        float f3 = B3GDIM() ? f + A4TApA2 : f - A4TApA2;
        return B3GDIM() ? f3 < 0.0f : f3 > ((float) AaHO0E());
    }

    public final boolean B7CMnp(float f, I3HV03.A4TApA a4TApA) {
        AcNBzu acNBzu = (AcNBzu) a4TApA.f3808AlLFFp;
        float f2 = acNBzu.f6253ADYaiT;
        AcNBzu acNBzu2 = (AcNBzu) a4TApA.f3809AmA8tU;
        float ADYaiT2 = ADYaiT(f, A2egSU.A4TApA(f2, acNBzu2.f6253ADYaiT, acNBzu.f6251A4TApA, acNBzu2.f6251A4TApA, f) / 2.0f);
        return B3GDIM() ? ADYaiT2 > ((float) AaHO0E()) : ADYaiT2 < 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x028c, code lost:
    
        if (r3 == r5) goto L122;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x023a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B9tovu(androidx.recyclerview.widget.DXnQ0V r30) {
        /*
            Method dump skipped, instructions count: 867
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.B9tovu(androidx.recyclerview.widget.DXnQ0V):void");
    }

    public final void BChYOn() {
        this.f11505ARc23Z = null;
        requestLayout();
    }

    public final int BI9f7h(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() != 0 && i != 0) {
            if (this.f11505ARc23Z == null) {
                B9tovu(dXnQ0V);
            }
            int itemCount = getItemCount();
            AmA8tU amA8tU = this.f11505ARc23Z;
            if (itemCount > (B3GDIM() ? amA8tU.A2egSU() : amA8tU.A5SV6n()).f6258A4TApA) {
                int i2 = this.f11501A2egSU;
                int i3 = this.f11502A4TApA;
                int i4 = this.f11503A5SV6n;
                int i5 = i2 + i;
                if (i5 < i3) {
                    i = i3 - i2;
                } else if (i5 > i4) {
                    i = i4 - i2;
                }
                this.f11501A2egSU = i2 + i;
                BJ7GGh(this.f11505ARc23Z);
                float f = this.f11506ASJ6gh.f6257A2egSU / 2.0f;
                float AZOQYO2 = AZOQYO(getPosition(getChildAt(0)));
                Rect rect = new Rect();
                float f2 = B3GDIM() ? this.f11506ASJ6gh.A5SV6n().f6251A4TApA : this.f11506ASJ6gh.A2egSU().f6251A4TApA;
                float f3 = Float.MAX_VALUE;
                for (int i6 = 0; i6 < getChildCount(); i6++) {
                    View childAt = getChildAt(i6);
                    float ADYaiT2 = ADYaiT(AZOQYO2, f);
                    I3HV03.A4TApA B25kr62 = B25kr6(this.f11506ASJ6gh.f6259A5SV6n, ADYaiT2, false);
                    float AYUAbz2 = AYUAbz(ADYaiT2, B25kr62);
                    super.getDecoratedBoundsWithMargins(childAt, rect);
                    BIYEnU(childAt, ADYaiT2, B25kr62);
                    switch (this.f11509AZkASS.f6232A4TApA) {
                        case 0:
                            childAt.offsetTopAndBottom((int) (AYUAbz2 - (rect.top + f)));
                            break;
                        default:
                            childAt.offsetLeftAndRight((int) (AYUAbz2 - (rect.left + f)));
                            break;
                    }
                    float abs = Math.abs(f2 - AYUAbz2);
                    if (abs < f3) {
                        this.f11512AlLFFp = getPosition(childAt);
                        f3 = abs;
                    }
                    AZOQYO2 = ADYaiT(AZOQYO2, this.f11506ASJ6gh.f6257A2egSU);
                }
                AZkASS(dXnQ0V, aaHO0E);
                return i;
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void BIYEnU(View view, float f, I3HV03.A4TApA a4TApA) {
        RectF rectF;
        if (view instanceof AzWtSf) {
            AcNBzu acNBzu = (AcNBzu) a4TApA.f3808AlLFFp;
            float f2 = acNBzu.f6252A5SV6n;
            AcNBzu acNBzu2 = (AcNBzu) a4TApA.f3809AmA8tU;
            float A4TApA2 = A2egSU.A4TApA(f2, acNBzu2.f6252A5SV6n, acNBzu.f6250A2egSU, acNBzu2.f6250A2egSU, f);
            float height = view.getHeight();
            float width = view.getWidth();
            float A4TApA3 = A2egSU.A4TApA(0.0f, width / 2.0f, 0.0f, 1.0f, A4TApA2);
            float A4TApA4 = A2egSU.A4TApA(0.0f, height / 2.0f, 0.0f, 1.0f, A4TApA2);
            switch (this.f11509AZkASS.f6232A4TApA) {
                case 0:
                    rectF = new RectF(0.0f, A4TApA4, width, height - A4TApA4);
                    break;
                default:
                    rectF = new RectF(A4TApA3, 0.0f, width - A4TApA3, height);
                    break;
            }
            float AYUAbz2 = AYUAbz(f, a4TApA);
            RectF rectF2 = new RectF(AYUAbz2 - (rectF.width() / 2.0f), AYUAbz2 - (rectF.height() / 2.0f), (rectF.width() / 2.0f) + AYUAbz2, (rectF.height() / 2.0f) + AYUAbz2);
            RectF rectF3 = new RectF(this.f11509AZkASS.A4TApA(), this.f11509AZkASS.AMqCpz(), this.f11509AZkASS.A5SV6n(), this.f11509AZkASS.A2egSU());
            this.AMqCpz.getClass();
            switch (this.f11509AZkASS.f6232A4TApA) {
                case 0:
                    float f3 = rectF2.top;
                    float f4 = rectF3.top;
                    if (f3 < f4 && rectF2.bottom > f4) {
                        float f5 = f4 - f3;
                        rectF.top += f5;
                        rectF3.top += f5;
                    }
                    float f6 = rectF2.bottom;
                    float f7 = rectF3.bottom;
                    if (f6 > f7 && rectF2.top < f7) {
                        float f8 = f6 - f7;
                        rectF.bottom = Math.max(rectF.bottom - f8, rectF.top);
                        rectF2.bottom = Math.max(rectF2.bottom - f8, rectF2.top);
                        break;
                    }
                    break;
                default:
                    float f9 = rectF2.left;
                    float f10 = rectF3.left;
                    if (f9 < f10 && rectF2.right > f10) {
                        float f11 = f10 - f9;
                        rectF.left += f11;
                        rectF2.left += f11;
                    }
                    float f12 = rectF2.right;
                    float f13 = rectF3.right;
                    if (f12 > f13 && rectF2.left < f13) {
                        float f14 = f12 - f13;
                        rectF.right = Math.max(rectF.right - f14, rectF.left);
                        rectF2.right = Math.max(rectF2.right - f14, rectF2.left);
                        break;
                    }
                    break;
            }
            switch (this.f11509AZkASS.f6232A4TApA) {
                case 0:
                    if (rectF2.bottom <= rectF3.top) {
                        float floor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                        rectF.bottom = floor;
                        rectF.top = Math.min(rectF.top, floor);
                    }
                    if (rectF2.top >= rectF3.bottom) {
                        float ceil = ((float) Math.ceil(rectF.top)) + 1.0f;
                        rectF.top = ceil;
                        rectF.bottom = Math.max(ceil, rectF.bottom);
                        break;
                    }
                    break;
                default:
                    if (rectF2.right <= rectF3.left) {
                        float floor2 = ((float) Math.floor(rectF.right)) - 1.0f;
                        rectF.right = floor2;
                        rectF.left = Math.min(rectF.left, floor2);
                    }
                    if (rectF2.left >= rectF3.right) {
                        float ceil2 = ((float) Math.ceil(rectF.left)) + 1.0f;
                        rectF.left = ceil2;
                        rectF.right = Math.max(ceil2, rectF.right);
                        break;
                    }
                    break;
            }
            ((AzWtSf) view).setMaskRectF(rectF);
        }
    }

    public final void BJ7GGh(AmA8tU amA8tU) {
        int i = this.f11503A5SV6n;
        int i2 = this.f11502A4TApA;
        if (i <= i2) {
            this.f11506ASJ6gh = B3GDIM() ? amA8tU.A2egSU() : amA8tU.A5SV6n();
        } else {
            this.f11506ASJ6gh = amA8tU.A4TApA(this.f11501A2egSU, i2, i, false);
        }
        List list = this.f11506ASJ6gh.f6259A5SV6n;
        AMqCpz aMqCpz = this.f11504ADYaiT;
        aMqCpz.getClass();
        aMqCpz.f6230A4TApA = Collections.unmodifiableList(list);
    }

    public final void BNL6CD() {
        int itemCount = getItemCount();
        int i = this.f11511AcNBzu;
        if (itemCount == i || this.f11505ARc23Z == null) {
            return;
        }
        if (this.AMqCpz.ADYaiT(this, i)) {
            BChYOn();
        }
        this.f11511AcNBzu = itemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean canScrollHorizontally() {
        return B2KMhB();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean canScrollVertically() {
        return !B2KMhB();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeHorizontalScrollExtent(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0 || this.f11505ARc23Z == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.f11505ARc23Z.f6262A2egSU.f6257A2egSU / computeHorizontalScrollRange(aaHO0E)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeHorizontalScrollOffset(RecyclerView.AaHO0E aaHO0E) {
        return this.f11501A2egSU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeHorizontalScrollRange(RecyclerView.AaHO0E aaHO0E) {
        return this.f11503A5SV6n - this.f11502A4TApA;
    }

    @Override // androidx.recyclerview.widget.Ddcejp
    public final PointF computeScrollVectorForPosition(int i) {
        if (this.f11505ARc23Z == null) {
            return null;
        }
        int AmA8tU2 = AmA8tU(i, AcNBzu(i)) - this.f11501A2egSU;
        return B2KMhB() ? new PointF(AmA8tU2, 0.0f) : new PointF(0.0f, AmA8tU2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeVerticalScrollExtent(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0 || this.f11505ARc23Z == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.f11505ARc23Z.f6262A2egSU.f6257A2egSU / computeVerticalScrollRange(aaHO0E)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeVerticalScrollOffset(RecyclerView.AaHO0E aaHO0E) {
        return this.f11501A2egSU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeVerticalScrollRange(RecyclerView.AaHO0E aaHO0E) {
        return this.f11503A5SV6n - this.f11502A4TApA;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final DG07BK generateDefaultLayoutParams() {
        return new DG07BK(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float centerY = rect.centerY();
        if (B2KMhB()) {
            centerY = rect.centerX();
        }
        I3HV03.A4TApA B25kr62 = B25kr6(this.f11506ASJ6gh.f6259A5SV6n, centerY, true);
        AcNBzu acNBzu = (AcNBzu) B25kr62.f3808AlLFFp;
        float f = acNBzu.f6253ADYaiT;
        AcNBzu acNBzu2 = (AcNBzu) B25kr62.f3809AmA8tU;
        float A4TApA2 = A2egSU.A4TApA(f, acNBzu2.f6253ADYaiT, acNBzu.f6251A4TApA, acNBzu2.f6251A4TApA, centerY);
        float width = B2KMhB() ? (rect.width() - A4TApA2) / 2.0f : 0.0f;
        float height = B2KMhB() ? 0.0f : (rect.height() - A4TApA2) / 2.0f;
        rect.set((int) (rect.left + width), (int) (rect.top + height), (int) (rect.right - width), (int) (rect.bottom - height));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void measureChildWithMargins(View view, int i, int i2) {
        if (!(view instanceof AzWtSf)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i3 = rect.left + rect.right + i;
        int i4 = rect.top + rect.bottom + i2;
        AmA8tU amA8tU = this.f11505ARc23Z;
        view.measure(RecyclerView.ARc23Z.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin + ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin + i3, (int) ((amA8tU == null || this.f11509AZkASS.f6231A2egSU != 0) ? ((ViewGroup.MarginLayoutParams) dg07bk).width : amA8tU.f6262A2egSU.f6257A2egSU), B2KMhB()), RecyclerView.ARc23Z.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) dg07bk).topMargin + ((ViewGroup.MarginLayoutParams) dg07bk).bottomMargin + i4, (int) ((amA8tU == null || this.f11509AZkASS.f6231A2egSU != 1) ? ((ViewGroup.MarginLayoutParams) dg07bk).height : amA8tU.f6262A2egSU.f6257A2egSU), canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        AZOQYO azoqyo = this.AMqCpz;
        Context context = recyclerView.getContext();
        float f = azoqyo.f6238A2egSU;
        if (f <= 0.0f) {
            f = context.getResources().getDimension(2131165698);
        }
        azoqyo.f6238A2egSU = f;
        float f2 = azoqyo.f6239A4TApA;
        if (f2 <= 0.0f) {
            f2 = context.getResources().getDimension(2131165697);
        }
        azoqyo.f6239A4TApA = f2;
        BChYOn();
        recyclerView.addOnLayoutChangeListener(this.f11510AaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onDetachedFromWindow(RecyclerView recyclerView, DXnQ0V dXnQ0V) {
        onDetachedFromWindow(recyclerView);
        recyclerView.removeOnLayoutChangeListener(this.f11510AaHO0E);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0028, code lost:
    
        if (r8 != 1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0032, code lost:
    
        if (B3GDIM() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0036, code lost:
    
        if (r8 == 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003f, code lost:
    
        if (B3GDIM() != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r5, int r6, androidx.recyclerview.widget.DXnQ0V r7, androidx.recyclerview.widget.RecyclerView.AaHO0E r8) {
        /*
            r4 = this;
            int r8 = r4.getChildCount()
            if (r8 != 0) goto L8
            goto L77
        L8:
            OCUYV2.ARc23Z r8 = r4.f11509AZkASS
            int r8 = r8.f6231A2egSU
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -1
            r2 = 1
            if (r6 == r2) goto L34
            r3 = 2
            if (r6 == r3) goto L2a
            r3 = 17
            if (r6 == r3) goto L39
            r3 = 33
            if (r6 == r3) goto L36
            r3 = 66
            if (r6 == r3) goto L2c
            r3 = 130(0x82, float:1.82E-43)
            if (r6 == r3) goto L28
        L25:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L42
        L28:
            if (r8 != r2) goto L25
        L2a:
            r6 = 1
            goto L42
        L2c:
            if (r8 != 0) goto L25
            boolean r6 = r4.B3GDIM()
            if (r6 == 0) goto L2a
        L34:
            r6 = -1
            goto L42
        L36:
            if (r8 != r2) goto L25
            goto L34
        L39:
            if (r8 != 0) goto L25
            boolean r6 = r4.B3GDIM()
            if (r6 == 0) goto L34
            goto L2a
        L42:
            if (r6 != r0) goto L45
            goto L77
        L45:
            r8 = 0
            if (r6 != r1) goto L6c
            int r5 = r4.getPosition(r5)
            if (r5 != 0) goto L4f
            goto L77
        L4f:
            android.view.View r5 = r4.getChildAt(r8)
            int r5 = r4.getPosition(r5)
            int r5 = r5 - r2
            r4.AMqCpz(r7, r5, r8)
            boolean r5 = r4.B3GDIM()
            if (r5 == 0) goto L67
            int r5 = r4.getChildCount()
            int r8 = r5 + (-1)
        L67:
            android.view.View r5 = r4.getChildAt(r8)
            return r5
        L6c:
            int r5 = r4.getPosition(r5)
            int r6 = r4.getItemCount()
            int r6 = r6 - r2
            if (r5 != r6) goto L79
        L77:
            r5 = 0
            return r5
        L79:
            int r5 = r4.getChildCount()
            int r5 = r5 - r2
            android.view.View r5 = r4.getChildAt(r5)
            int r5 = r4.getPosition(r5)
            int r5 = r5 + r2
            r4.AMqCpz(r7, r5, r1)
            boolean r5 = r4.B3GDIM()
            if (r5 == 0) goto L91
            goto L97
        L91:
            int r5 = r4.getChildCount()
            int r8 = r5 + (-1)
        L97:
            android.view.View r5 = r4.getChildAt(r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.DXnQ0V, androidx.recyclerview.widget.RecyclerView$AaHO0E):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        BNL6CD();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        BNL6CD();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        BNL6CD();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        if (r3.f6262A2egSU.f6261ARc23Z != AaHO0E()) goto L14;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayoutChildren(androidx.recyclerview.widget.DXnQ0V r18, androidx.recyclerview.widget.RecyclerView.AaHO0E r19) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.onLayoutChildren(androidx.recyclerview.widget.DXnQ0V, androidx.recyclerview.widget.RecyclerView$AaHO0E):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onLayoutCompleted(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0) {
            this.f11507AYUAbz = 0;
        } else {
            this.f11507AYUAbz = getPosition(getChildAt(0));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        int AzWtSf2;
        if (this.f11505ARc23Z == null || (AzWtSf2 = AzWtSf(getPosition(view), AcNBzu(getPosition(view)))) == 0) {
            return false;
        }
        int i = this.f11501A2egSU;
        int i2 = this.f11502A4TApA;
        int i3 = this.f11503A5SV6n;
        int i4 = i + AzWtSf2;
        if (i4 < i2) {
            AzWtSf2 = i2 - i;
        } else if (i4 > i3) {
            AzWtSf2 = i3 - i;
        }
        int AzWtSf3 = AzWtSf(getPosition(view), this.f11505ARc23Z.A4TApA(i + AzWtSf2, i2, i3, false));
        if (B2KMhB()) {
            recyclerView.scrollBy(AzWtSf3, 0);
            return true;
        }
        recyclerView.scrollBy(0, AzWtSf3);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int scrollHorizontallyBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (B2KMhB()) {
            return BI9f7h(i, dXnQ0V, aaHO0E);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void scrollToPosition(int i) {
        this.f11512AlLFFp = i;
        if (this.f11505ARc23Z == null) {
            return;
        }
        this.f11501A2egSU = AmA8tU(i, AcNBzu(i));
        this.f11507AYUAbz = com.bumptech.glide.AMqCpz.B3GDIM(i, 0, Math.max(0, getItemCount() - 1));
        BJ7GGh(this.f11505ARc23Z);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int scrollVerticallyBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (canScrollVertically()) {
            return BI9f7h(i, dXnQ0V, aaHO0E);
        }
        return 0;
    }

    public final void setOrientation(int i) {
        ARc23Z aRc23Z;
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "invalid orientation:"));
        }
        assertNotInLayoutOrScroll(null);
        ARc23Z aRc23Z2 = this.f11509AZkASS;
        if (aRc23Z2 == null || i != aRc23Z2.f6231A2egSU) {
            if (i == 0) {
                aRc23Z = new ARc23Z(this, 1);
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                aRc23Z = new ARc23Z(this, 0);
            }
            this.f11509AZkASS = aRc23Z;
            BChYOn();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E, int i) {
        ADYaiT aDYaiT = new ADYaiT(this, recyclerView.getContext());
        aDYaiT.setTargetPosition(i);
        startSmoothScroll(aDYaiT);
    }

    public CarouselLayoutManager(AZOQYO azoqyo) {
        this.f11504ADYaiT = new AMqCpz();
        this.f11507AYUAbz = 0;
        this.f11510AaHO0E = new A5SV6n(1, this);
        this.f11512AlLFFp = -1;
        this.f11513AmA8tU = 0;
        this.AMqCpz = azoqyo;
        BChYOn();
        setOrientation(0);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f11504ADYaiT = new AMqCpz();
        this.f11507AYUAbz = 0;
        this.f11510AaHO0E = new A5SV6n(0, this);
        this.f11512AlLFFp = -1;
        this.f11513AmA8tU = 0;
        this.AMqCpz = new B25kr6();
        BChYOn();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11218AYUAbz);
            this.f11513AmA8tU = obtainStyledAttributes.getInt(0, 0);
            BChYOn();
            setOrientation(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
        }
    }
}
