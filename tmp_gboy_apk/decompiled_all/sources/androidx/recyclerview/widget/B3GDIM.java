package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f9228A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int[] f9229A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int[] f9230A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final B25kr6 f9231ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f9232ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final boolean f9233ASJ6gh;

    public B3GDIM(B25kr6 b25kr6, ArrayList arrayList, int[] iArr, int[] iArr2) {
        int[] iArr3;
        int[] iArr4;
        B25kr6 b25kr62;
        int i;
        B2KMhB b2KMhB;
        int i2;
        this.f9228A2egSU = arrayList;
        this.f9229A4TApA = iArr;
        this.f9230A5SV6n = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.f9231ADYaiT = b25kr6;
        int AMqCpz = b25kr6.AMqCpz();
        this.AMqCpz = AMqCpz;
        int ADYaiT2 = b25kr6.ADYaiT();
        this.f9232ARc23Z = ADYaiT2;
        this.f9233ASJ6gh = true;
        B2KMhB b2KMhB2 = arrayList.isEmpty() ? null : (B2KMhB) arrayList.get(0);
        if (b2KMhB2 == null || b2KMhB2.f9225A2egSU != 0 || b2KMhB2.f9226A4TApA != 0) {
            arrayList.add(0, new B2KMhB(0, 0, 0));
        }
        arrayList.add(new B2KMhB(AMqCpz, ADYaiT2, 0));
        Iterator it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            iArr3 = this.f9230A5SV6n;
            iArr4 = this.f9229A4TApA;
            b25kr62 = this.f9231ADYaiT;
            if (!hasNext) {
                break;
            }
            B2KMhB b2KMhB3 = (B2KMhB) it.next();
            for (int i3 = 0; i3 < b2KMhB3.f9227A5SV6n; i3++) {
                int i4 = b2KMhB3.f9225A2egSU + i3;
                int i5 = b2KMhB3.f9226A4TApA + i3;
                int i6 = b25kr62.A2egSU(i4, i5) ? 1 : 2;
                iArr4[i4] = (i5 << 4) | i6;
                iArr3[i5] = (i4 << 4) | i6;
            }
        }
        if (this.f9233ASJ6gh) {
            Iterator it2 = arrayList.iterator();
            int i7 = 0;
            while (it2.hasNext()) {
                B2KMhB b2KMhB4 = (B2KMhB) it2.next();
                while (true) {
                    i = b2KMhB4.f9225A2egSU;
                    if (i7 < i) {
                        if (iArr4[i7] == 0) {
                            int size = arrayList.size();
                            int i8 = 0;
                            int i9 = 0;
                            while (true) {
                                if (i8 < size) {
                                    b2KMhB = (B2KMhB) arrayList.get(i8);
                                    while (true) {
                                        i2 = b2KMhB.f9226A4TApA;
                                        if (i9 < i2) {
                                            if (iArr3[i9] == 0 && b25kr62.A4TApA(i7, i9)) {
                                                int i10 = b25kr62.A2egSU(i7, i9) ? 8 : 4;
                                                iArr4[i7] = (i9 << 4) | i10;
                                                iArr3[i9] = i10 | (i7 << 4);
                                            } else {
                                                i9++;
                                            }
                                        }
                                    }
                                }
                                i9 = b2KMhB.f9227A5SV6n + i2;
                                i8++;
                            }
                        }
                        i7++;
                    }
                }
                i7 = b2KMhB4.f9227A5SV6n + i;
            }
        }
    }

    public static B4ZgIw A4TApA(ArrayDeque arrayDeque, int i, boolean z) {
        B4ZgIw b4ZgIw;
        Iterator it = arrayDeque.iterator();
        while (true) {
            if (!it.hasNext()) {
                b4ZgIw = null;
                break;
            }
            b4ZgIw = (B4ZgIw) it.next();
            if (b4ZgIw.f9234A2egSU == i && b4ZgIw.f9236A5SV6n == z) {
                it.remove();
                break;
            }
        }
        while (it.hasNext()) {
            B4ZgIw b4ZgIw2 = (B4ZgIw) it.next();
            if (z) {
                b4ZgIw2.f9235A4TApA--;
            } else {
                b4ZgIw2.f9235A4TApA++;
            }
        }
        return b4ZgIw;
    }

    public final void A2egSU(RecyclerView.A2egSU a2egSU) {
        int[] iArr;
        B25kr6 b25kr6;
        int i;
        ArrayList arrayList;
        int i2;
        B3GDIM b3gdim = this;
        ADYaiT aDYaiT = new ADYaiT(new A5SV6n(a2egSU));
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList2 = b3gdim.f9228A2egSU;
        int size = arrayList2.size() - 1;
        int i3 = b3gdim.AMqCpz;
        int i4 = b3gdim.f9232ARc23Z;
        int i5 = i3;
        while (size >= 0) {
            B2KMhB b2KMhB = (B2KMhB) arrayList2.get(size);
            int i6 = b2KMhB.f9225A2egSU;
            int i7 = b2KMhB.f9227A5SV6n;
            int i8 = i6 + i7;
            int i9 = b2KMhB.f9226A4TApA;
            int i10 = i9 + i7;
            while (true) {
                iArr = b3gdim.f9229A4TApA;
                b25kr6 = b3gdim.f9231ADYaiT;
                if (i5 <= i8) {
                    break;
                }
                i5--;
                int i11 = iArr[i5];
                if ((i11 & 12) != 0) {
                    arrayList = arrayList2;
                    int i12 = i11 >> 4;
                    B4ZgIw A4TApA2 = A4TApA(arrayDeque, i12, false);
                    if (A4TApA2 != null) {
                        int i13 = (i3 - A4TApA2.f9235A4TApA) - 1;
                        aDYaiT.A5SV6n(i5, i13);
                        if ((i11 & 4) != 0) {
                            aDYaiT.A4TApA(i13, 1, b25kr6.A5SV6n(i5, i12));
                        }
                    } else {
                        arrayDeque.add(new B4ZgIw(i5, (i3 - i5) - 1, true));
                    }
                } else {
                    arrayList = arrayList2;
                    if (aDYaiT.f9171A4TApA != 2 || (i2 = aDYaiT.f9172A5SV6n) < i5 || i2 > i5 + 1) {
                        aDYaiT.A2egSU();
                        aDYaiT.f9172A5SV6n = i5;
                        aDYaiT.f9173ADYaiT = 1;
                        aDYaiT.f9171A4TApA = 2;
                    } else {
                        aDYaiT.f9173ADYaiT++;
                        aDYaiT.f9172A5SV6n = i5;
                    }
                    i3--;
                }
                arrayList2 = arrayList;
            }
            ArrayList arrayList3 = arrayList2;
            while (i4 > i10) {
                i4--;
                int i14 = b3gdim.f9230A5SV6n[i4];
                if ((i14 & 12) != 0) {
                    int i15 = i14 >> 4;
                    B4ZgIw A4TApA3 = A4TApA(arrayDeque, i15, true);
                    if (A4TApA3 == null) {
                        arrayDeque.add(new B4ZgIw(i4, i3 - i5, false));
                    } else {
                        aDYaiT.A5SV6n((i3 - A4TApA3.f9235A4TApA) - 1, i5);
                        if ((i14 & 4) != 0) {
                            aDYaiT.A4TApA(i5, 1, b25kr6.A5SV6n(i15, i4));
                        }
                    }
                } else {
                    if (aDYaiT.f9171A4TApA == 1 && i5 >= (i = aDYaiT.f9172A5SV6n)) {
                        int i16 = aDYaiT.f9173ADYaiT;
                        if (i5 <= i + i16) {
                            aDYaiT.f9173ADYaiT = i16 + 1;
                            aDYaiT.f9172A5SV6n = Math.min(i5, i);
                            i3++;
                        }
                    }
                    aDYaiT.A2egSU();
                    aDYaiT.f9172A5SV6n = i5;
                    aDYaiT.f9173ADYaiT = 1;
                    aDYaiT.f9171A4TApA = 1;
                    i3++;
                }
                b3gdim = this;
            }
            i5 = b2KMhB.f9225A2egSU;
            int i17 = i5;
            int i18 = i9;
            for (int i19 = 0; i19 < i7; i19++) {
                if ((iArr[i17] & 15) == 2) {
                    aDYaiT.A4TApA(i17, 1, b25kr6.A5SV6n(i17, i18));
                }
                i17++;
                i18++;
            }
            size--;
            b3gdim = this;
            i4 = i9;
            arrayList2 = arrayList3;
        }
        aDYaiT.A2egSU();
    }
}
