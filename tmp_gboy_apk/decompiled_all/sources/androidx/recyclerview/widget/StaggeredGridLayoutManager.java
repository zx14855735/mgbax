package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.ARc23Z implements Ddcejp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f9453A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public EicXu4[] f9454A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Cd8JRx f9455A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Cd8JRx f9456ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f9457ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final BmvVmW f9458ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f9459AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f9460AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public BitSet f9461AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f9462AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f9463AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final I3HV03.A4TApA f9464AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f9465AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f9466AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f9467B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public A2egSU f9468B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Rect f9469B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final EUIRHA f9470B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final boolean f9471B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int[] f9472B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final CmUvjW f9473BChYOn;

    public static class A2egSU implements Parcelable {
        public static final Parcelable.Creator<A2egSU> CREATOR = new EiK8oA();

        /* renamed from: AcNBzu, reason: collision with root package name */
        public int f9474AcNBzu;

        /* renamed from: AlLFFp, reason: collision with root package name */
        public int f9475AlLFFp;

        /* renamed from: AmA8tU, reason: collision with root package name */
        public int f9476AmA8tU;

        /* renamed from: AzWtSf, reason: collision with root package name */
        public int[] f9477AzWtSf;

        /* renamed from: B25kr6, reason: collision with root package name */
        public int f9478B25kr6;

        /* renamed from: B2KMhB, reason: collision with root package name */
        public int[] f9479B2KMhB;

        /* renamed from: B3GDIM, reason: collision with root package name */
        public ArrayList f9480B3GDIM;

        /* renamed from: B4ZgIw, reason: collision with root package name */
        public boolean f9481B4ZgIw;

        /* renamed from: B7CMnp, reason: collision with root package name */
        public boolean f9482B7CMnp;

        /* renamed from: B9tovu, reason: collision with root package name */
        public boolean f9483B9tovu;

        static {
            xOofmDL();
        }

        private static /* synthetic */ void xOofmDL() {
            char[] charArray = "¶º¸û²´¸°û·º¬û¦½°¹¹û\u009f»¼\u0097§¼±²°".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 213);
            }
            String str = new String(charArray);
            char[] charArray2 = "¶¹¼»¼¡".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 213);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f9474AcNBzu);
            parcel.writeInt(this.f9475AlLFFp);
            parcel.writeInt(this.f9476AmA8tU);
            if (this.f9476AmA8tU > 0) {
                parcel.writeIntArray(this.f9477AzWtSf);
            }
            parcel.writeInt(this.f9478B25kr6);
            if (this.f9478B25kr6 > 0) {
                parcel.writeIntArray(this.f9479B2KMhB);
            }
            parcel.writeInt(this.f9481B4ZgIw ? 1 : 0);
            parcel.writeInt(this.f9482B7CMnp ? 1 : 0);
            parcel.writeInt(this.f9483B9tovu ? 1 : 0);
            parcel.writeList(this.f9480B3GDIM);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f9453A2egSU = -1;
        this.f9459AYUAbz = false;
        this.f9460AZOQYO = false;
        this.f9462AaHO0E = -1;
        this.f9463AcNBzu = Integer.MIN_VALUE;
        this.f9464AlLFFp = new I3HV03.A4TApA(17);
        this.f9465AmA8tU = 2;
        this.f9469B3GDIM = new Rect();
        this.f9470B4ZgIw = new EUIRHA(this);
        this.f9471B7CMnp = true;
        this.f9473BChYOn = new CmUvjW(2, this);
        RecyclerView.ARc23Z.A2egSU properties = RecyclerView.ARc23Z.getProperties(context, attributeSet, i, i2);
        int i3 = properties.f9433A2egSU;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i3 != this.AMqCpz) {
            this.AMqCpz = i3;
            Cd8JRx cd8JRx = this.f9455A5SV6n;
            this.f9455A5SV6n = this.f9456ADYaiT;
            this.f9456ADYaiT = cd8JRx;
            requestLayout();
        }
        BTvldC(properties.f9434A4TApA);
        boolean z = properties.f9435A5SV6n;
        assertNotInLayoutOrScroll(null);
        A2egSU a2egSU = this.f9468B2KMhB;
        if (a2egSU != null && a2egSU.f9481B4ZgIw != z) {
            a2egSU.f9481B4ZgIw = z;
        }
        this.f9459AYUAbz = z;
        requestLayout();
        this.f9458ASJ6gh = new BmvVmW();
        this.f9455A5SV6n = Cd8JRx.A2egSU(this, this.AMqCpz);
        this.f9456ADYaiT = Cd8JRx.A2egSU(this, 1 - this.AMqCpz);
    }

    public static int BniPrB(int i, int i2, int i3) {
        int mode;
        return (!(i2 == 0 && i3 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    public final boolean ADYaiT() {
        int AlLFFp2;
        if (getChildCount() != 0 && this.f9465AmA8tU != 0 && isAttachedToWindow()) {
            if (this.f9460AZOQYO) {
                AlLFFp2 = AmA8tU();
                AlLFFp();
            } else {
                AlLFFp2 = AlLFFp();
                AmA8tU();
            }
            I3HV03.A4TApA a4TApA = this.f9464AlLFFp;
            if (AlLFFp2 == 0 && B3GDIM() != null) {
                a4TApA.AcNBzu();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            }
        }
        return false;
    }

    public final int AMqCpz(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0) {
            return 0;
        }
        Cd8JRx cd8JRx = this.f9455A5SV6n;
        boolean z = !this.f9471B7CMnp;
        return DyaChj.A2egSU(aaHO0E, cd8JRx, AZkASS(z), AZOQYO(z), this, this.f9471B7CMnp);
    }

    public final int ARc23Z(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0) {
            return 0;
        }
        Cd8JRx cd8JRx = this.f9455A5SV6n;
        boolean z = !this.f9471B7CMnp;
        return DyaChj.A4TApA(aaHO0E, cd8JRx, AZkASS(z), AZOQYO(z), this, this.f9471B7CMnp, this.f9460AZOQYO);
    }

    public final int ASJ6gh(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0) {
            return 0;
        }
        Cd8JRx cd8JRx = this.f9455A5SV6n;
        boolean z = !this.f9471B7CMnp;
        return DyaChj.A5SV6n(aaHO0E, cd8JRx, AZkASS(z), AZOQYO(z), this, this.f9471B7CMnp);
    }

    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [boolean, int] */
    public final int AYUAbz(DXnQ0V dXnQ0V, BmvVmW bmvVmW, RecyclerView.AaHO0E aaHO0E) {
        EicXu4 eicXu4;
        ?? r3;
        int AYUAbz2;
        int A5SV6n2;
        int AaHO0E2;
        int A5SV6n3;
        int i;
        int i2;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this;
        int i3 = 1;
        staggeredGridLayoutManager.f9461AZkASS.set(0, staggeredGridLayoutManager.f9453A2egSU, true);
        BmvVmW bmvVmW2 = staggeredGridLayoutManager.f9458ASJ6gh;
        int i4 = bmvVmW2.f9299AZOQYO ? bmvVmW.AMqCpz == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : bmvVmW.AMqCpz == 1 ? bmvVmW.f9297ASJ6gh + bmvVmW.f9293A4TApA : bmvVmW.f9296ARc23Z - bmvVmW.f9293A4TApA;
        int i5 = bmvVmW.AMqCpz;
        for (int i6 = 0; i6 < staggeredGridLayoutManager.f9453A2egSU; i6++) {
            if (!staggeredGridLayoutManager.f9454A4TApA[i6].f9391A2egSU.isEmpty()) {
                staggeredGridLayoutManager.BmvVmW(staggeredGridLayoutManager.f9454A4TApA[i6], i5, i4);
            }
        }
        int ASJ6gh2 = staggeredGridLayoutManager.f9460AZOQYO ? staggeredGridLayoutManager.f9455A5SV6n.ASJ6gh() : staggeredGridLayoutManager.f9455A5SV6n.AaHO0E();
        boolean z = false;
        while (true) {
            int i7 = bmvVmW.f9294A5SV6n;
            int i8 = -1;
            if (!(i7 >= 0 && i7 < aaHO0E.A4TApA()) || (!bmvVmW2.f9299AZOQYO && staggeredGridLayoutManager.f9461AZkASS.isEmpty())) {
                break;
            }
            View ADYaiT2 = dXnQ0V.ADYaiT(bmvVmW.f9294A5SV6n);
            bmvVmW.f9294A5SV6n += bmvVmW.f9295ADYaiT;
            EY4UKY ey4uky = (EY4UKY) ADYaiT2.getLayoutParams();
            int layoutPosition = ey4uky.f9343A2egSU.getLayoutPosition();
            I3HV03.A4TApA a4TApA = staggeredGridLayoutManager.f9464AlLFFp;
            int[] iArr = (int[]) a4TApA.f3808AlLFFp;
            int i9 = (iArr == null || layoutPosition >= iArr.length) ? -1 : iArr[layoutPosition];
            if (i9 == -1) {
                if (staggeredGridLayoutManager.B9tovu(bmvVmW.AMqCpz)) {
                    i2 = staggeredGridLayoutManager.f9453A2egSU - i3;
                    i = -1;
                } else {
                    i8 = staggeredGridLayoutManager.f9453A2egSU;
                    i = 1;
                    i2 = 0;
                }
                EicXu4 eicXu42 = null;
                if (bmvVmW.AMqCpz == i3) {
                    int AaHO0E3 = staggeredGridLayoutManager.f9455A5SV6n.AaHO0E();
                    int i10 = Integer.MAX_VALUE;
                    while (i2 != i8) {
                        EicXu4 eicXu43 = staggeredGridLayoutManager.f9454A4TApA[i2];
                        int i11 = i;
                        int ARc23Z2 = eicXu43.ARc23Z(AaHO0E3);
                        if (ARc23Z2 < i10) {
                            eicXu42 = eicXu43;
                            i10 = ARc23Z2;
                        }
                        i2 += i11;
                        i = i11;
                    }
                } else {
                    int i12 = i;
                    int ASJ6gh3 = staggeredGridLayoutManager.f9455A5SV6n.ASJ6gh();
                    int i13 = Integer.MIN_VALUE;
                    while (i2 != i8) {
                        EicXu4 eicXu44 = staggeredGridLayoutManager.f9454A4TApA[i2];
                        int AYUAbz3 = eicXu44.AYUAbz(ASJ6gh3);
                        if (AYUAbz3 > i13) {
                            eicXu42 = eicXu44;
                            i13 = AYUAbz3;
                        }
                        i2 += i12;
                    }
                }
                eicXu4 = eicXu42;
                a4TApA.AlLFFp(layoutPosition);
                ((int[]) a4TApA.f3808AlLFFp)[layoutPosition] = eicXu4.AMqCpz;
            } else {
                eicXu4 = staggeredGridLayoutManager.f9454A4TApA[i9];
            }
            EicXu4 eicXu45 = eicXu4;
            ey4uky.AMqCpz = eicXu45;
            if (bmvVmW.AMqCpz == 1) {
                staggeredGridLayoutManager.addView(ADYaiT2);
                r3 = 0;
            } else {
                r3 = 0;
                staggeredGridLayoutManager.addView(ADYaiT2, 0);
            }
            if (staggeredGridLayoutManager.AMqCpz == 1) {
                staggeredGridLayoutManager.B4ZgIw(ADYaiT2, RecyclerView.ARc23Z.getChildMeasureSpec(staggeredGridLayoutManager.f9457ARc23Z, staggeredGridLayoutManager.getWidthMode(), r3, ((ViewGroup.MarginLayoutParams) ey4uky).width, r3), RecyclerView.ARc23Z.getChildMeasureSpec(staggeredGridLayoutManager.getHeight(), staggeredGridLayoutManager.getHeightMode(), staggeredGridLayoutManager.getPaddingBottom() + staggeredGridLayoutManager.getPaddingTop(), ((ViewGroup.MarginLayoutParams) ey4uky).height, true));
            } else {
                staggeredGridLayoutManager.B4ZgIw(ADYaiT2, RecyclerView.ARc23Z.getChildMeasureSpec(staggeredGridLayoutManager.getWidth(), staggeredGridLayoutManager.getWidthMode(), staggeredGridLayoutManager.getPaddingRight() + staggeredGridLayoutManager.getPaddingLeft(), ((ViewGroup.MarginLayoutParams) ey4uky).width, true), RecyclerView.ARc23Z.getChildMeasureSpec(staggeredGridLayoutManager.f9457ARc23Z, staggeredGridLayoutManager.getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) ey4uky).height, false));
            }
            if (bmvVmW.AMqCpz == 1) {
                A5SV6n2 = eicXu45.ARc23Z(ASJ6gh2);
                AYUAbz2 = staggeredGridLayoutManager.f9455A5SV6n.A5SV6n(ADYaiT2) + A5SV6n2;
            } else {
                AYUAbz2 = eicXu45.AYUAbz(ASJ6gh2);
                A5SV6n2 = AYUAbz2 - staggeredGridLayoutManager.f9455A5SV6n.A5SV6n(ADYaiT2);
            }
            if (bmvVmW.AMqCpz == 1) {
                EicXu4 eicXu46 = ey4uky.AMqCpz;
                eicXu46.getClass();
                EY4UKY ey4uky2 = (EY4UKY) ADYaiT2.getLayoutParams();
                ey4uky2.AMqCpz = eicXu46;
                ArrayList arrayList = eicXu46.f9391A2egSU;
                arrayList.add(ADYaiT2);
                eicXu46.f9393A5SV6n = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    eicXu46.f9392A4TApA = Integer.MIN_VALUE;
                }
                if (ey4uky2.f9343A2egSU.isRemoved() || ey4uky2.f9343A2egSU.isUpdated()) {
                    eicXu46.f9394ADYaiT = eicXu46.f9395ARc23Z.f9455A5SV6n.A5SV6n(ADYaiT2) + eicXu46.f9394ADYaiT;
                }
            } else {
                EicXu4 eicXu47 = ey4uky.AMqCpz;
                eicXu47.getClass();
                EY4UKY ey4uky3 = (EY4UKY) ADYaiT2.getLayoutParams();
                ey4uky3.AMqCpz = eicXu47;
                ArrayList arrayList2 = eicXu47.f9391A2egSU;
                arrayList2.add(0, ADYaiT2);
                eicXu47.f9392A4TApA = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    eicXu47.f9393A5SV6n = Integer.MIN_VALUE;
                }
                if (ey4uky3.f9343A2egSU.isRemoved() || ey4uky3.f9343A2egSU.isUpdated()) {
                    eicXu47.f9394ADYaiT = eicXu47.f9395ARc23Z.f9455A5SV6n.A5SV6n(ADYaiT2) + eicXu47.f9394ADYaiT;
                }
            }
            if (staggeredGridLayoutManager.isLayoutRTL() && staggeredGridLayoutManager.AMqCpz == 1) {
                A5SV6n3 = staggeredGridLayoutManager.f9456ADYaiT.ASJ6gh() - (((staggeredGridLayoutManager.f9453A2egSU - 1) - eicXu45.AMqCpz) * staggeredGridLayoutManager.f9457ARc23Z);
                AaHO0E2 = A5SV6n3 - staggeredGridLayoutManager.f9456ADYaiT.A5SV6n(ADYaiT2);
            } else {
                AaHO0E2 = staggeredGridLayoutManager.f9456ADYaiT.AaHO0E() + (eicXu45.AMqCpz * staggeredGridLayoutManager.f9457ARc23Z);
                A5SV6n3 = staggeredGridLayoutManager.f9456ADYaiT.A5SV6n(ADYaiT2) + AaHO0E2;
            }
            int i14 = AaHO0E2;
            int i15 = A5SV6n3;
            if (staggeredGridLayoutManager.AMqCpz == 1) {
                staggeredGridLayoutManager.layoutDecoratedWithMargins(ADYaiT2, i14, A5SV6n2, i15, AYUAbz2);
                staggeredGridLayoutManager = this;
            } else {
                staggeredGridLayoutManager.layoutDecoratedWithMargins(ADYaiT2, A5SV6n2, i14, AYUAbz2, i15);
            }
            staggeredGridLayoutManager.BmvVmW(eicXu45, bmvVmW2.AMqCpz, i4);
            staggeredGridLayoutManager.BI9f7h(dXnQ0V, bmvVmW2);
            if (bmvVmW2.f9298AYUAbz && ADYaiT2.hasFocusable()) {
                staggeredGridLayoutManager.f9461AZkASS.set(eicXu45.AMqCpz, false);
            }
            z = true;
            i3 = 1;
        }
        if (!z) {
            staggeredGridLayoutManager.BI9f7h(dXnQ0V, bmvVmW2);
        }
        int AaHO0E4 = bmvVmW2.AMqCpz == -1 ? staggeredGridLayoutManager.f9455A5SV6n.AaHO0E() - staggeredGridLayoutManager.B25kr6(staggeredGridLayoutManager.f9455A5SV6n.AaHO0E()) : staggeredGridLayoutManager.AzWtSf(staggeredGridLayoutManager.f9455A5SV6n.ASJ6gh()) - staggeredGridLayoutManager.f9455A5SV6n.ASJ6gh();
        if (AaHO0E4 > 0) {
            return Math.min(bmvVmW.f9293A4TApA, AaHO0E4);
        }
        return 0;
    }

    public final View AZOQYO(boolean z) {
        int AaHO0E2 = this.f9455A5SV6n.AaHO0E();
        int ASJ6gh2 = this.f9455A5SV6n.ASJ6gh();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int AMqCpz = this.f9455A5SV6n.AMqCpz(childAt);
            int A4TApA2 = this.f9455A5SV6n.A4TApA(childAt);
            if (A4TApA2 > AaHO0E2 && AMqCpz < ASJ6gh2) {
                if (A4TApA2 <= ASJ6gh2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View AZkASS(boolean z) {
        int AaHO0E2 = this.f9455A5SV6n.AaHO0E();
        int ASJ6gh2 = this.f9455A5SV6n.ASJ6gh();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int AMqCpz = this.f9455A5SV6n.AMqCpz(childAt);
            if (this.f9455A5SV6n.A4TApA(childAt) > AaHO0E2 && AMqCpz < ASJ6gh2) {
                if (AMqCpz >= AaHO0E2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void AaHO0E(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, boolean z) {
        int ASJ6gh2;
        int AzWtSf2 = AzWtSf(Integer.MIN_VALUE);
        if (AzWtSf2 != Integer.MIN_VALUE && (ASJ6gh2 = this.f9455A5SV6n.ASJ6gh() - AzWtSf2) > 0) {
            int i = ASJ6gh2 - (-scrollBy(-ASJ6gh2, dXnQ0V, aaHO0E));
            if (!z || i <= 0) {
                return;
            }
            this.f9455A5SV6n.AzWtSf(i);
        }
    }

    public final void AcNBzu(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, boolean z) {
        int AaHO0E2;
        int B25kr62 = B25kr6(Integer.MAX_VALUE);
        if (B25kr62 != Integer.MAX_VALUE && (AaHO0E2 = B25kr62 - this.f9455A5SV6n.AaHO0E()) > 0) {
            int scrollBy = AaHO0E2 - scrollBy(AaHO0E2, dXnQ0V, aaHO0E);
            if (!z || scrollBy <= 0) {
                return;
            }
            this.f9455A5SV6n.AzWtSf(-scrollBy);
        }
    }

    public final int AlLFFp() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public final int AmA8tU() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int AzWtSf(int i) {
        int ARc23Z2 = this.f9454A4TApA[0].ARc23Z(i);
        for (int i2 = 1; i2 < this.f9453A2egSU; i2++) {
            int ARc23Z3 = this.f9454A4TApA[i2].ARc23Z(i);
            if (ARc23Z3 > ARc23Z2) {
                ARc23Z2 = ARc23Z3;
            }
        }
        return ARc23Z2;
    }

    public final int B25kr6(int i) {
        int AYUAbz2 = this.f9454A4TApA[0].AYUAbz(i);
        for (int i2 = 1; i2 < this.f9453A2egSU; i2++) {
            int AYUAbz3 = this.f9454A4TApA[i2].AYUAbz(i);
            if (AYUAbz3 < AYUAbz2) {
                AYUAbz2 = AYUAbz3;
            }
        }
        return AYUAbz2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B2KMhB(int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B2KMhB(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View B3GDIM() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B3GDIM():android.view.View");
    }

    public final void B4ZgIw(View view, int i, int i2) {
        Rect rect = this.f9469B3GDIM;
        calculateItemDecorationsForChild(view, rect);
        EY4UKY ey4uky = (EY4UKY) view.getLayoutParams();
        int BniPrB2 = BniPrB(i, ((ViewGroup.MarginLayoutParams) ey4uky).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) ey4uky).rightMargin + rect.right);
        int BniPrB3 = BniPrB(i2, ((ViewGroup.MarginLayoutParams) ey4uky).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) ey4uky).bottomMargin + rect.bottom);
        if (shouldMeasureChild(view, BniPrB2, BniPrB3, ey4uky)) {
            view.measure(BniPrB2, BniPrB3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01aa, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a6, code lost:
    
        if ((r11 < AlLFFp()) != r16.f9460AZOQYO) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0415, code lost:
    
        if (ADYaiT() != false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0198, code lost:
    
        if (r16.f9460AZOQYO != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a8, code lost:
    
        r11 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B7CMnp(androidx.recyclerview.widget.DXnQ0V r17, androidx.recyclerview.widget.RecyclerView.AaHO0E r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1075
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B7CMnp(androidx.recyclerview.widget.DXnQ0V, androidx.recyclerview.widget.RecyclerView$AaHO0E, boolean):void");
    }

    public final boolean B9tovu(int i) {
        if (this.AMqCpz == 0) {
            return (i == -1) != this.f9460AZOQYO;
        }
        return ((i == -1) == this.f9460AZOQYO) == isLayoutRTL();
    }

    public final void BChYOn(int i, RecyclerView.AaHO0E aaHO0E) {
        int AlLFFp2;
        int i2;
        if (i > 0) {
            AlLFFp2 = AmA8tU();
            i2 = 1;
        } else {
            AlLFFp2 = AlLFFp();
            i2 = -1;
        }
        BmvVmW bmvVmW = this.f9458ASJ6gh;
        bmvVmW.f9292A2egSU = true;
        BV3sI0(AlLFFp2, aaHO0E);
        BPw6Q8(i2);
        bmvVmW.f9294A5SV6n = AlLFFp2 + bmvVmW.f9295ADYaiT;
        bmvVmW.f9293A4TApA = Math.abs(i);
    }

    public final void BI9f7h(DXnQ0V dXnQ0V, BmvVmW bmvVmW) {
        if (!bmvVmW.f9292A2egSU || bmvVmW.f9299AZOQYO) {
            return;
        }
        if (bmvVmW.f9293A4TApA == 0) {
            if (bmvVmW.AMqCpz == -1) {
                BIYEnU(bmvVmW.f9297ASJ6gh, dXnQ0V);
                return;
            } else {
                BJ7GGh(bmvVmW.f9296ARc23Z, dXnQ0V);
                return;
            }
        }
        int i = 1;
        if (bmvVmW.AMqCpz == -1) {
            int i2 = bmvVmW.f9296ARc23Z;
            int AYUAbz2 = this.f9454A4TApA[0].AYUAbz(i2);
            while (i < this.f9453A2egSU) {
                int AYUAbz3 = this.f9454A4TApA[i].AYUAbz(i2);
                if (AYUAbz3 > AYUAbz2) {
                    AYUAbz2 = AYUAbz3;
                }
                i++;
            }
            int i3 = i2 - AYUAbz2;
            BIYEnU(i3 < 0 ? bmvVmW.f9297ASJ6gh : bmvVmW.f9297ASJ6gh - Math.min(i3, bmvVmW.f9293A4TApA), dXnQ0V);
            return;
        }
        int i4 = bmvVmW.f9297ASJ6gh;
        int ARc23Z2 = this.f9454A4TApA[0].ARc23Z(i4);
        while (i < this.f9453A2egSU) {
            int ARc23Z3 = this.f9454A4TApA[i].ARc23Z(i4);
            if (ARc23Z3 < ARc23Z2) {
                ARc23Z2 = ARc23Z3;
            }
            i++;
        }
        int i5 = ARc23Z2 - bmvVmW.f9297ASJ6gh;
        BJ7GGh(i5 < 0 ? bmvVmW.f9296ARc23Z : Math.min(i5, bmvVmW.f9293A4TApA) + bmvVmW.f9296ARc23Z, dXnQ0V);
    }

    public final void BIYEnU(int i, DXnQ0V dXnQ0V) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f9455A5SV6n.AMqCpz(childAt) < i || this.f9455A5SV6n.AmA8tU(childAt) < i) {
                return;
            }
            EY4UKY ey4uky = (EY4UKY) childAt.getLayoutParams();
            ey4uky.getClass();
            if (ey4uky.AMqCpz.f9391A2egSU.size() == 1) {
                return;
            }
            EicXu4 eicXu4 = ey4uky.AMqCpz;
            ArrayList arrayList = eicXu4.f9391A2egSU;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            EY4UKY ey4uky2 = (EY4UKY) view.getLayoutParams();
            ey4uky2.AMqCpz = null;
            if (ey4uky2.f9343A2egSU.isRemoved() || ey4uky2.f9343A2egSU.isUpdated()) {
                eicXu4.f9394ADYaiT -= eicXu4.f9395ARc23Z.f9455A5SV6n.A5SV6n(view);
            }
            if (size == 1) {
                eicXu4.f9392A4TApA = Integer.MIN_VALUE;
            }
            eicXu4.f9393A5SV6n = Integer.MIN_VALUE;
            removeAndRecycleView(childAt, dXnQ0V);
        }
    }

    public final void BJ7GGh(int i, DXnQ0V dXnQ0V) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f9455A5SV6n.A4TApA(childAt) > i || this.f9455A5SV6n.AlLFFp(childAt) > i) {
                return;
            }
            EY4UKY ey4uky = (EY4UKY) childAt.getLayoutParams();
            ey4uky.getClass();
            if (ey4uky.AMqCpz.f9391A2egSU.size() == 1) {
                return;
            }
            EicXu4 eicXu4 = ey4uky.AMqCpz;
            ArrayList arrayList = eicXu4.f9391A2egSU;
            View view = (View) arrayList.remove(0);
            EY4UKY ey4uky2 = (EY4UKY) view.getLayoutParams();
            ey4uky2.AMqCpz = null;
            if (arrayList.size() == 0) {
                eicXu4.f9393A5SV6n = Integer.MIN_VALUE;
            }
            if (ey4uky2.f9343A2egSU.isRemoved() || ey4uky2.f9343A2egSU.isUpdated()) {
                eicXu4.f9394ADYaiT -= eicXu4.f9395ARc23Z.f9455A5SV6n.A5SV6n(view);
            }
            eicXu4.f9392A4TApA = Integer.MIN_VALUE;
            removeAndRecycleView(childAt, dXnQ0V);
        }
    }

    public final void BNL6CD() {
        if (this.AMqCpz == 1 || !isLayoutRTL()) {
            this.f9460AZOQYO = this.f9459AYUAbz;
        } else {
            this.f9460AZOQYO = !this.f9459AYUAbz;
        }
    }

    public final void BPw6Q8(int i) {
        BmvVmW bmvVmW = this.f9458ASJ6gh;
        bmvVmW.AMqCpz = i;
        bmvVmW.f9295ADYaiT = this.f9460AZOQYO != (i == -1) ? -1 : 1;
    }

    public final void BTvldC(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.f9453A2egSU) {
            this.f9464AlLFFp.AcNBzu();
            requestLayout();
            this.f9453A2egSU = i;
            this.f9461AZkASS = new BitSet(this.f9453A2egSU);
            this.f9454A4TApA = new EicXu4[this.f9453A2egSU];
            for (int i2 = 0; i2 < this.f9453A2egSU; i2++) {
                this.f9454A4TApA[i2] = new EicXu4(this, i2);
            }
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void BV3sI0(int r5, androidx.recyclerview.widget.RecyclerView.AaHO0E r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.BmvVmW r0 = r4.f9458ASJ6gh
            r1 = 0
            r0.f9293A4TApA = r1
            r0.f9294A5SV6n = r5
            boolean r2 = r4.isSmoothScrolling()
            r3 = 1
            if (r2 == 0) goto L2d
            int r6 = r6.f9440A2egSU
            r2 = -1
            if (r6 == r2) goto L2d
            boolean r2 = r4.f9460AZOQYO
            if (r6 >= r5) goto L19
            r5 = 1
            goto L1a
        L19:
            r5 = 0
        L1a:
            if (r2 != r5) goto L24
            androidx.recyclerview.widget.Cd8JRx r5 = r4.f9455A5SV6n
            int r5 = r5.AcNBzu()
        L22:
            r6 = 0
            goto L2f
        L24:
            androidx.recyclerview.widget.Cd8JRx r5 = r4.f9455A5SV6n
            int r5 = r5.AcNBzu()
            r6 = r5
            r5 = 0
            goto L2f
        L2d:
            r5 = 0
            goto L22
        L2f:
            boolean r2 = r4.getClipToPadding()
            if (r2 == 0) goto L48
            androidx.recyclerview.widget.Cd8JRx r2 = r4.f9455A5SV6n
            int r2 = r2.AaHO0E()
            int r2 = r2 - r6
            r0.f9296ARc23Z = r2
            androidx.recyclerview.widget.Cd8JRx r6 = r4.f9455A5SV6n
            int r6 = r6.ASJ6gh()
            int r6 = r6 + r5
            r0.f9297ASJ6gh = r6
            goto L54
        L48:
            androidx.recyclerview.widget.Cd8JRx r2 = r4.f9455A5SV6n
            int r2 = r2.ARc23Z()
            int r2 = r2 + r5
            r0.f9297ASJ6gh = r2
            int r5 = -r6
            r0.f9296ARc23Z = r5
        L54:
            r0.f9298AYUAbz = r1
            r0.f9292A2egSU = r3
            androidx.recyclerview.widget.Cd8JRx r5 = r4.f9455A5SV6n
            int r5 = r5.AZOQYO()
            if (r5 != 0) goto L69
            androidx.recyclerview.widget.Cd8JRx r5 = r4.f9455A5SV6n
            int r5 = r5.ARc23Z()
            if (r5 != 0) goto L69
            r1 = 1
        L69:
            r0.f9299AZOQYO = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.BV3sI0(int, androidx.recyclerview.widget.RecyclerView$AaHO0E):void");
    }

    public final void BmvVmW(EicXu4 eicXu4, int i, int i2) {
        int i3 = eicXu4.f9394ADYaiT;
        int i4 = eicXu4.AMqCpz;
        if (i != -1) {
            int i5 = eicXu4.f9393A5SV6n;
            if (i5 == Integer.MIN_VALUE) {
                eicXu4.A2egSU();
                i5 = eicXu4.f9393A5SV6n;
            }
            if (i5 - i3 >= i2) {
                this.f9461AZkASS.set(i4, false);
                return;
            }
            return;
        }
        int i6 = eicXu4.f9392A4TApA;
        if (i6 == Integer.MIN_VALUE) {
            View view = (View) eicXu4.f9391A2egSU.get(0);
            EY4UKY ey4uky = (EY4UKY) view.getLayoutParams();
            eicXu4.f9392A4TApA = eicXu4.f9395ARc23Z.f9455A5SV6n.AMqCpz(view);
            ey4uky.getClass();
            i6 = eicXu4.f9392A4TApA;
        }
        if (i6 + i3 <= i2) {
            this.f9461AZkASS.set(i4, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void assertNotInLayoutOrScroll(String str) {
        if (this.f9468B2KMhB == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean canScrollHorizontally() {
        return this.AMqCpz == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean canScrollVertically() {
        return this.AMqCpz == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean checkLayoutParams(DG07BK dg07bk) {
        return dg07bk instanceof EY4UKY;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.AaHO0E aaHO0E, DAk1zC dAk1zC) {
        BmvVmW bmvVmW;
        int ARc23Z2;
        int i3;
        if (this.AMqCpz != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        BChYOn(i, aaHO0E);
        int[] iArr = this.f9472B9tovu;
        if (iArr == null || iArr.length < this.f9453A2egSU) {
            this.f9472B9tovu = new int[this.f9453A2egSU];
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.f9453A2egSU;
            bmvVmW = this.f9458ASJ6gh;
            if (i4 >= i6) {
                break;
            }
            if (bmvVmW.f9295ADYaiT == -1) {
                ARc23Z2 = bmvVmW.f9296ARc23Z;
                i3 = this.f9454A4TApA[i4].AYUAbz(ARc23Z2);
            } else {
                ARc23Z2 = this.f9454A4TApA[i4].ARc23Z(bmvVmW.f9297ASJ6gh);
                i3 = bmvVmW.f9297ASJ6gh;
            }
            int i7 = ARc23Z2 - i3;
            if (i7 >= 0) {
                this.f9472B9tovu[i5] = i7;
                i5++;
            }
            i4++;
        }
        Arrays.sort(this.f9472B9tovu, 0, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = bmvVmW.f9294A5SV6n;
            if (i9 < 0 || i9 >= aaHO0E.A4TApA()) {
                return;
            }
            ((BNL6CD) dAk1zC).A2egSU(bmvVmW.f9294A5SV6n, this.f9472B9tovu[i8]);
            bmvVmW.f9294A5SV6n += bmvVmW.f9295ADYaiT;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeHorizontalScrollExtent(RecyclerView.AaHO0E aaHO0E) {
        return AMqCpz(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeHorizontalScrollOffset(RecyclerView.AaHO0E aaHO0E) {
        return ARc23Z(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeHorizontalScrollRange(RecyclerView.AaHO0E aaHO0E) {
        return ASJ6gh(aaHO0E);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0019, code lost:
    
        if ((r4 < AlLFFp()) != r3.f9460AZOQYO) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r3.f9460AZOQYO != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r1 = 1;
     */
    @Override // androidx.recyclerview.widget.Ddcejp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF computeScrollVectorForPosition(int r4) {
        /*
            r3 = this;
            int r0 = r3.getChildCount()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.f9460AZOQYO
            if (r4 == 0) goto L1b
        Lc:
            r1 = 1
            goto L1b
        Le:
            int r0 = r3.AlLFFp()
            if (r4 >= r0) goto L16
            r4 = 1
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.f9460AZOQYO
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r4 = 0
            return r4
        L24:
            int r0 = r3.AMqCpz
            r2 = 0
            if (r0 != 0) goto L2f
            float r0 = (float) r1
            r4.x = r0
            r4.y = r2
            return r4
        L2f:
            r4.x = r2
            float r0 = (float) r1
            r4.y = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.computeScrollVectorForPosition(int):android.graphics.PointF");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeVerticalScrollExtent(RecyclerView.AaHO0E aaHO0E) {
        return AMqCpz(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeVerticalScrollOffset(RecyclerView.AaHO0E aaHO0E) {
        return ARc23Z(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int computeVerticalScrollRange(RecyclerView.AaHO0E aaHO0E) {
        return ASJ6gh(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final DG07BK generateDefaultLayoutParams() {
        return this.AMqCpz == 0 ? new EY4UKY(-2, -1) : new EY4UKY(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final DG07BK generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new EY4UKY(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean isAutoMeasureEnabled() {
        return this.f9465AmA8tU != 0;
    }

    public final boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f9453A2egSU; i2++) {
            EicXu4 eicXu4 = this.f9454A4TApA[i2];
            int i3 = eicXu4.f9392A4TApA;
            if (i3 != Integer.MIN_VALUE) {
                eicXu4.f9392A4TApA = i3 + i;
            }
            int i4 = eicXu4.f9393A5SV6n;
            if (i4 != Integer.MIN_VALUE) {
                eicXu4.f9393A5SV6n = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f9453A2egSU; i2++) {
            EicXu4 eicXu4 = this.f9454A4TApA[i2];
            int i3 = eicXu4.f9392A4TApA;
            if (i3 != Integer.MIN_VALUE) {
                eicXu4.f9392A4TApA = i3 + i;
            }
            int i4 = eicXu4.f9393A5SV6n;
            if (i4 != Integer.MIN_VALUE) {
                eicXu4.f9393A5SV6n = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onAdapterChanged(RecyclerView.A2egSU a2egSU, RecyclerView.A2egSU a2egSU2) {
        this.f9464AlLFFp.AcNBzu();
        for (int i = 0; i < this.f9453A2egSU; i++) {
            this.f9454A4TApA[i].A4TApA();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onDetachedFromWindow(RecyclerView recyclerView, DXnQ0V dXnQ0V) {
        onDetachedFromWindow(recyclerView);
        removeCallbacks(this.f9473BChYOn);
        for (int i = 0; i < this.f9453A2egSU; i++) {
            this.f9454A4TApA[i].A4TApA();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x003b, code lost:
    
        if (r8.AMqCpz == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0041, code lost:
    
        if (r8.AMqCpz == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x004d, code lost:
    
        if (isLayoutRTL() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0059, code lost:
    
        if (isLayoutRTL() == false) goto L29;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r9, int r10, androidx.recyclerview.widget.DXnQ0V r11, androidx.recyclerview.widget.RecyclerView.AaHO0E r12) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.DXnQ0V, androidx.recyclerview.widget.RecyclerView$AaHO0E):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View AZkASS2 = AZkASS(false);
            View AZOQYO2 = AZOQYO(false);
            if (AZkASS2 == null || AZOQYO2 == null) {
                return;
            }
            int position = getPosition(AZkASS2);
            int position2 = getPosition(AZOQYO2);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        B2KMhB(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsChanged(RecyclerView recyclerView) {
        this.f9464AlLFFp.AcNBzu();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        B2KMhB(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        B2KMhB(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        B2KMhB(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onLayoutChildren(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        B7CMnp(dXnQ0V, aaHO0E, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onLayoutCompleted(RecyclerView.AaHO0E aaHO0E) {
        this.f9462AaHO0E = -1;
        this.f9463AcNBzu = Integer.MIN_VALUE;
        this.f9468B2KMhB = null;
        this.f9470B4ZgIw.A2egSU();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof A2egSU) {
            A2egSU a2egSU = (A2egSU) parcelable;
            this.f9468B2KMhB = a2egSU;
            if (this.f9462AaHO0E != -1) {
                a2egSU.f9477AzWtSf = null;
                a2egSU.f9476AmA8tU = 0;
                a2egSU.f9474AcNBzu = -1;
                a2egSU.f9475AlLFFp = -1;
                a2egSU.f9477AzWtSf = null;
                a2egSU.f9476AmA8tU = 0;
                a2egSU.f9478B25kr6 = 0;
                a2egSU.f9479B2KMhB = null;
                a2egSU.f9480B3GDIM = null;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final Parcelable onSaveInstanceState() {
        int AYUAbz2;
        int AaHO0E2;
        int[] iArr;
        A2egSU a2egSU = this.f9468B2KMhB;
        if (a2egSU != null) {
            A2egSU a2egSU2 = new A2egSU();
            a2egSU2.f9476AmA8tU = a2egSU.f9476AmA8tU;
            a2egSU2.f9474AcNBzu = a2egSU.f9474AcNBzu;
            a2egSU2.f9475AlLFFp = a2egSU.f9475AlLFFp;
            a2egSU2.f9477AzWtSf = a2egSU.f9477AzWtSf;
            a2egSU2.f9478B25kr6 = a2egSU.f9478B25kr6;
            a2egSU2.f9479B2KMhB = a2egSU.f9479B2KMhB;
            a2egSU2.f9481B4ZgIw = a2egSU.f9481B4ZgIw;
            a2egSU2.f9482B7CMnp = a2egSU.f9482B7CMnp;
            a2egSU2.f9483B9tovu = a2egSU.f9483B9tovu;
            a2egSU2.f9480B3GDIM = a2egSU.f9480B3GDIM;
            return a2egSU2;
        }
        A2egSU a2egSU3 = new A2egSU();
        a2egSU3.f9481B4ZgIw = this.f9459AYUAbz;
        a2egSU3.f9482B7CMnp = this.f9466AzWtSf;
        a2egSU3.f9483B9tovu = this.f9467B25kr6;
        I3HV03.A4TApA a4TApA = this.f9464AlLFFp;
        if (a4TApA == null || (iArr = (int[]) a4TApA.f3808AlLFFp) == null) {
            a2egSU3.f9478B25kr6 = 0;
        } else {
            a2egSU3.f9479B2KMhB = iArr;
            a2egSU3.f9478B25kr6 = iArr.length;
            a2egSU3.f9480B3GDIM = (ArrayList) a4TApA.f3809AmA8tU;
        }
        if (getChildCount() <= 0) {
            a2egSU3.f9474AcNBzu = -1;
            a2egSU3.f9475AlLFFp = -1;
            a2egSU3.f9476AmA8tU = 0;
            return a2egSU3;
        }
        a2egSU3.f9474AcNBzu = this.f9466AzWtSf ? AmA8tU() : AlLFFp();
        View AZOQYO2 = this.f9460AZOQYO ? AZOQYO(true) : AZkASS(true);
        a2egSU3.f9475AlLFFp = AZOQYO2 != null ? getPosition(AZOQYO2) : -1;
        int i = this.f9453A2egSU;
        a2egSU3.f9476AmA8tU = i;
        a2egSU3.f9477AzWtSf = new int[i];
        for (int i2 = 0; i2 < this.f9453A2egSU; i2++) {
            if (this.f9466AzWtSf) {
                AYUAbz2 = this.f9454A4TApA[i2].ARc23Z(Integer.MIN_VALUE);
                if (AYUAbz2 != Integer.MIN_VALUE) {
                    AaHO0E2 = this.f9455A5SV6n.ASJ6gh();
                    AYUAbz2 -= AaHO0E2;
                    a2egSU3.f9477AzWtSf[i2] = AYUAbz2;
                } else {
                    a2egSU3.f9477AzWtSf[i2] = AYUAbz2;
                }
            } else {
                AYUAbz2 = this.f9454A4TApA[i2].AYUAbz(Integer.MIN_VALUE);
                if (AYUAbz2 != Integer.MIN_VALUE) {
                    AaHO0E2 = this.f9455A5SV6n.AaHO0E();
                    AYUAbz2 -= AaHO0E2;
                    a2egSU3.f9477AzWtSf[i2] = AYUAbz2;
                } else {
                    a2egSU3.f9477AzWtSf[i2] = AYUAbz2;
                }
            }
        }
        return a2egSU3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onScrollStateChanged(int i) {
        if (i == 0) {
            ADYaiT();
        }
    }

    public final int scrollBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        BChYOn(i, aaHO0E);
        BmvVmW bmvVmW = this.f9458ASJ6gh;
        int AYUAbz2 = AYUAbz(dXnQ0V, bmvVmW, aaHO0E);
        if (bmvVmW.f9293A4TApA >= AYUAbz2) {
            i = i < 0 ? -AYUAbz2 : AYUAbz2;
        }
        this.f9455A5SV6n.AzWtSf(-i);
        this.f9466AzWtSf = this.f9460AZOQYO;
        bmvVmW.f9293A4TApA = 0;
        BI9f7h(dXnQ0V, bmvVmW);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int scrollHorizontallyBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        return scrollBy(i, dXnQ0V, aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void scrollToPosition(int i) {
        A2egSU a2egSU = this.f9468B2KMhB;
        if (a2egSU != null && a2egSU.f9474AcNBzu != i) {
            a2egSU.f9477AzWtSf = null;
            a2egSU.f9476AmA8tU = 0;
            a2egSU.f9474AcNBzu = -1;
            a2egSU.f9475AlLFFp = -1;
        }
        this.f9462AaHO0E = i;
        this.f9463AcNBzu = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int scrollVerticallyBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        return scrollBy(i, dXnQ0V, aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.AMqCpz == 1) {
            chooseSize2 = RecyclerView.ARc23Z.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            chooseSize = RecyclerView.ARc23Z.chooseSize(i, (this.f9457ARc23Z * this.f9453A2egSU) + paddingRight, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.ARc23Z.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            chooseSize2 = RecyclerView.ARc23Z.chooseSize(i2, (this.f9457ARc23Z * this.f9453A2egSU) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E, int i) {
        CASmeH cASmeH = new CASmeH(recyclerView.getContext());
        cASmeH.setTargetPosition(i);
        startSmoothScroll(cASmeH);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean supportsPredictiveItemAnimations() {
        return this.f9468B2KMhB == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final DG07BK generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new EY4UKY((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new EY4UKY(layoutParams);
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.f9453A2egSU = -1;
        this.f9459AYUAbz = false;
        this.f9460AZOQYO = false;
        this.f9462AaHO0E = -1;
        this.f9463AcNBzu = Integer.MIN_VALUE;
        this.f9464AlLFFp = new I3HV03.A4TApA(17);
        this.f9465AmA8tU = 2;
        this.f9469B3GDIM = new Rect();
        this.f9470B4ZgIw = new EUIRHA(this);
        this.f9471B7CMnp = true;
        this.f9473BChYOn = new CmUvjW(2, this);
        this.AMqCpz = i2;
        BTvldC(i);
        this.f9458ASJ6gh = new BmvVmW();
        this.f9455A5SV6n = Cd8JRx.A2egSU(this, this.AMqCpz);
        this.f9456ADYaiT = Cd8JRx.A2egSU(this, 1 - this.AMqCpz);
    }
}
