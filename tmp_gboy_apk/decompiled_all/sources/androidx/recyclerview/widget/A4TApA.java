package androidx.recyclerview.widget;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final CtFAbx f9167ADYaiT;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B4ZgIw.AMqCpz f9164A2egSU = new B4ZgIw.AMqCpz(30);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f9165A4TApA = new ArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f9166A5SV6n = new ArrayList();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f9168ARc23Z = 0;
    public final CSDoyG AMqCpz = new CSDoyG(this);

    public A4TApA(CtFAbx ctFAbx) {
        this.f9167ADYaiT = ctFAbx;
    }

    public final boolean A2egSU(int i) {
        ArrayList arrayList = this.f9166A5SV6n;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            A2egSU a2egSU = (A2egSU) arrayList.get(i2);
            int i3 = a2egSU.f9160A2egSU;
            if (i3 != 8) {
                if (i3 == 1) {
                    int i4 = a2egSU.f9161A4TApA;
                    int i5 = a2egSU.f9163ADYaiT + i4;
                    while (i4 < i5) {
                        if (ARc23Z(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                } else {
                    continue;
                }
            } else {
                if (ARc23Z(a2egSU.f9163ADYaiT, i2 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void A4TApA() {
        ArrayList arrayList = this.f9166A5SV6n;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.f9167ADYaiT.A2egSU((A2egSU) arrayList.get(i));
        }
        AaHO0E(arrayList);
        this.f9168ARc23Z = 0;
    }

    public final void A5SV6n() {
        A4TApA();
        ArrayList arrayList = this.f9165A4TApA;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            A2egSU a2egSU = (A2egSU) arrayList.get(i);
            int i2 = a2egSU.f9160A2egSU;
            CtFAbx ctFAbx = this.f9167ADYaiT;
            if (i2 == 1) {
                ctFAbx.A2egSU(a2egSU);
                int i3 = a2egSU.f9161A4TApA;
                int i4 = a2egSU.f9163ADYaiT;
                RecyclerView recyclerView = ctFAbx.f9335A2egSU;
                recyclerView.offsetPositionRecordsForInsert(i3, i4);
                recyclerView.mItemsAddedOrRemoved = true;
            } else if (i2 == 2) {
                ctFAbx.A2egSU(a2egSU);
                int i5 = a2egSU.f9161A4TApA;
                int i6 = a2egSU.f9163ADYaiT;
                RecyclerView recyclerView2 = ctFAbx.f9335A2egSU;
                recyclerView2.offsetPositionRecordsForRemove(i5, i6, true);
                recyclerView2.mItemsAddedOrRemoved = true;
                recyclerView2.mState.f9442A5SV6n += i6;
            } else if (i2 == 4) {
                ctFAbx.A2egSU(a2egSU);
                int i7 = a2egSU.f9161A4TApA;
                int i8 = a2egSU.f9163ADYaiT;
                Object obj = a2egSU.f9162A5SV6n;
                RecyclerView recyclerView3 = ctFAbx.f9335A2egSU;
                recyclerView3.viewRangeUpdate(i7, i8, obj);
                recyclerView3.mItemsChanged = true;
            } else if (i2 == 8) {
                ctFAbx.A2egSU(a2egSU);
                int i9 = a2egSU.f9161A4TApA;
                int i10 = a2egSU.f9163ADYaiT;
                RecyclerView recyclerView4 = ctFAbx.f9335A2egSU;
                recyclerView4.offsetPositionRecordsForMove(i9, i10);
                recyclerView4.mItemsAddedOrRemoved = true;
            }
        }
        AaHO0E(arrayList);
        this.f9168ARc23Z = 0;
    }

    public final void ADYaiT(A2egSU a2egSU) {
        int i;
        int i2 = a2egSU.f9160A2egSU;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int AcNBzu2 = AcNBzu(a2egSU.f9161A4TApA, i2);
        int i3 = a2egSU.f9161A4TApA;
        int i4 = a2egSU.f9160A2egSU;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + a2egSU);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < a2egSU.f9163ADYaiT; i6++) {
            int AcNBzu3 = AcNBzu((i * i6) + a2egSU.f9161A4TApA, a2egSU.f9160A2egSU);
            int i7 = a2egSU.f9160A2egSU;
            if (i7 == 2 ? AcNBzu3 != AcNBzu2 : !(i7 == 4 && AcNBzu3 == AcNBzu2 + 1)) {
                A2egSU AYUAbz2 = AYUAbz(i7, AcNBzu2, i5, a2egSU.f9162A5SV6n);
                AMqCpz(AYUAbz2, i3);
                AYUAbz2.f9162A5SV6n = null;
                this.f9164A2egSU.A5SV6n(AYUAbz2);
                if (a2egSU.f9160A2egSU == 4) {
                    i3 += i5;
                }
                AcNBzu2 = AcNBzu3;
                i5 = 1;
            } else {
                i5++;
            }
        }
        Object obj = a2egSU.f9162A5SV6n;
        a2egSU.f9162A5SV6n = null;
        this.f9164A2egSU.A5SV6n(a2egSU);
        if (i5 > 0) {
            A2egSU AYUAbz3 = AYUAbz(a2egSU.f9160A2egSU, AcNBzu2, i5, obj);
            AMqCpz(AYUAbz3, i3);
            AYUAbz3.f9162A5SV6n = null;
            this.f9164A2egSU.A5SV6n(AYUAbz3);
        }
    }

    public final void AMqCpz(A2egSU a2egSU, int i) {
        CtFAbx ctFAbx = this.f9167ADYaiT;
        ctFAbx.A2egSU(a2egSU);
        int i2 = a2egSU.f9160A2egSU;
        if (i2 == 2) {
            int i3 = a2egSU.f9163ADYaiT;
            RecyclerView recyclerView = ctFAbx.f9335A2egSU;
            recyclerView.offsetPositionRecordsForRemove(i, i3, true);
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f9442A5SV6n += i3;
            return;
        }
        if (i2 != 4) {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        int i4 = a2egSU.f9163ADYaiT;
        Object obj = a2egSU.f9162A5SV6n;
        RecyclerView recyclerView2 = ctFAbx.f9335A2egSU;
        recyclerView2.viewRangeUpdate(i, i4, obj);
        recyclerView2.mItemsChanged = true;
    }

    public final int ARc23Z(int i, int i2) {
        ArrayList arrayList = this.f9166A5SV6n;
        int size = arrayList.size();
        while (i2 < size) {
            A2egSU a2egSU = (A2egSU) arrayList.get(i2);
            int i3 = a2egSU.f9160A2egSU;
            if (i3 == 8) {
                int i4 = a2egSU.f9161A4TApA;
                if (i4 == i) {
                    i = a2egSU.f9163ADYaiT;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (a2egSU.f9163ADYaiT <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = a2egSU.f9161A4TApA;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = a2egSU.f9163ADYaiT;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += a2egSU.f9163ADYaiT;
                }
            }
            i2++;
        }
        return i;
    }

    public final boolean ASJ6gh() {
        return this.f9165A4TApA.size() > 0;
    }

    public final A2egSU AYUAbz(int i, int i2, int i3, Object obj) {
        A2egSU a2egSU = (A2egSU) this.f9164A2egSU.A2egSU();
        if (a2egSU != null) {
            a2egSU.f9160A2egSU = i;
            a2egSU.f9161A4TApA = i2;
            a2egSU.f9163ADYaiT = i3;
            a2egSU.f9162A5SV6n = obj;
            return a2egSU;
        }
        A2egSU a2egSU2 = new A2egSU();
        a2egSU2.f9160A2egSU = i;
        a2egSU2.f9161A4TApA = i2;
        a2egSU2.f9163ADYaiT = i3;
        a2egSU2.f9162A5SV6n = obj;
        return a2egSU2;
    }

    public final void AZOQYO(A2egSU a2egSU) {
        this.f9166A5SV6n.add(a2egSU);
        int i = a2egSU.f9160A2egSU;
        CtFAbx ctFAbx = this.f9167ADYaiT;
        if (i == 1) {
            int i2 = a2egSU.f9161A4TApA;
            int i3 = a2egSU.f9163ADYaiT;
            RecyclerView recyclerView = ctFAbx.f9335A2egSU;
            recyclerView.offsetPositionRecordsForInsert(i2, i3);
            recyclerView.mItemsAddedOrRemoved = true;
            return;
        }
        if (i == 2) {
            int i4 = a2egSU.f9161A4TApA;
            int i5 = a2egSU.f9163ADYaiT;
            RecyclerView recyclerView2 = ctFAbx.f9335A2egSU;
            recyclerView2.offsetPositionRecordsForRemove(i4, i5, false);
            recyclerView2.mItemsAddedOrRemoved = true;
            return;
        }
        if (i == 4) {
            int i6 = a2egSU.f9161A4TApA;
            int i7 = a2egSU.f9163ADYaiT;
            Object obj = a2egSU.f9162A5SV6n;
            RecyclerView recyclerView3 = ctFAbx.f9335A2egSU;
            recyclerView3.viewRangeUpdate(i6, i7, obj);
            recyclerView3.mItemsChanged = true;
            return;
        }
        if (i != 8) {
            throw new IllegalArgumentException("Unknown update op type for " + a2egSU);
        }
        int i8 = a2egSU.f9161A4TApA;
        int i9 = a2egSU.f9163ADYaiT;
        RecyclerView recyclerView4 = ctFAbx.f9335A2egSU;
        recyclerView4.offsetPositionRecordsForMove(i8, i9);
        recyclerView4.mItemsAddedOrRemoved = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZkASS() {
        /*
            Method dump skipped, instructions count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.A4TApA.AZkASS():void");
    }

    public final void AaHO0E(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            A2egSU a2egSU = (A2egSU) arrayList.get(i);
            a2egSU.f9162A5SV6n = null;
            this.f9164A2egSU.A5SV6n(a2egSU);
        }
        arrayList.clear();
    }

    public final int AcNBzu(int i, int i2) {
        int i3;
        int i4;
        ArrayList arrayList = this.f9166A5SV6n;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            A2egSU a2egSU = (A2egSU) arrayList.get(size);
            int i5 = a2egSU.f9160A2egSU;
            if (i5 == 8) {
                int i6 = a2egSU.f9161A4TApA;
                int i7 = a2egSU.f9163ADYaiT;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            a2egSU.f9161A4TApA = i6 + 1;
                            a2egSU.f9163ADYaiT = i7 + 1;
                        } else if (i2 == 2) {
                            a2egSU.f9161A4TApA = i6 - 1;
                            a2egSU.f9163ADYaiT = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        a2egSU.f9163ADYaiT = i7 + 1;
                    } else if (i2 == 2) {
                        a2egSU.f9163ADYaiT = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        a2egSU.f9161A4TApA = i6 + 1;
                    } else if (i2 == 2) {
                        a2egSU.f9161A4TApA = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = a2egSU.f9161A4TApA;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= a2egSU.f9163ADYaiT;
                    } else if (i5 == 2) {
                        i += a2egSU.f9163ADYaiT;
                    }
                } else if (i2 == 1) {
                    a2egSU.f9161A4TApA = i8 + 1;
                } else if (i2 == 2) {
                    a2egSU.f9161A4TApA = i8 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            A2egSU a2egSU2 = (A2egSU) arrayList.get(size2);
            if (a2egSU2.f9160A2egSU == 8) {
                int i9 = a2egSU2.f9163ADYaiT;
                if (i9 == a2egSU2.f9161A4TApA || i9 < 0) {
                    arrayList.remove(size2);
                    a2egSU2.f9162A5SV6n = null;
                    this.f9164A2egSU.A5SV6n(a2egSU2);
                }
            } else if (a2egSU2.f9163ADYaiT <= 0) {
                arrayList.remove(size2);
                a2egSU2.f9162A5SV6n = null;
                this.f9164A2egSU.A5SV6n(a2egSU2);
            }
        }
        return i;
    }
}
