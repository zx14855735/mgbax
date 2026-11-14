package androidx.recyclerview.widget;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BTvldC implements Runnable {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final ThreadLocal f9285B25kr6 = new ThreadLocal();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final B4ZgIw.ARc23Z f9286B2KMhB = new B4ZgIw.ARc23Z(14);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ArrayList f9287AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public long f9288AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public long f9289AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ArrayList f9290AzWtSf;

    static {
        qJivedG();
    }

    public static Dphsd2 A5SV6n(RecyclerView recyclerView, int i, long j) {
        int AYUAbz2 = recyclerView.mChildHelper.AYUAbz();
        for (int i2 = 0; i2 < AYUAbz2; i2++) {
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.ASJ6gh(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return null;
            }
        }
        DXnQ0V dXnQ0V = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            Dphsd2 AlLFFp2 = dXnQ0V.AlLFFp(i, j);
            if (AlLFFp2 != null) {
                if (!AlLFFp2.isBound() || AlLFFp2.isInvalid()) {
                    dXnQ0V.A2egSU(AlLFFp2, false);
                } else {
                    dXnQ0V.AZkASS(AlLFFp2.itemView);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return AlLFFp2;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th;
        }
    }

    private static /* synthetic */ void qJivedG() {
        char[] charArray = "ÐÜÞ\u009dÔÒÞÖ\u009dÑÜÊ\u009dÀÛÖßß\u009dùÝÚñÁÚ×ÔÖ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 179);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÐßÚÝÚÇ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 179);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.sDebugAssertionsEnabled && !this.f9287AcNBzu.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f9288AlLFFp == 0) {
                this.f9288AlLFFp = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        BNL6CD bnl6cd = recyclerView.mPrefetchRegistry;
        bnl6cd.f9277A2egSU = i;
        bnl6cd.f9278A4TApA = i2;
    }

    public final void A4TApA(long j) {
        BPw6Q8 bPw6Q8;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        BPw6Q8 bPw6Q82;
        ArrayList arrayList = this.f9287AcNBzu;
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i2);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.mPrefetchRegistry.A4TApA(recyclerView3, false);
                i += recyclerView3.mPrefetchRegistry.f9280ADYaiT;
            }
        }
        ArrayList arrayList2 = this.f9290AzWtSf;
        arrayList2.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i4);
            if (recyclerView4.getWindowVisibility() == 0) {
                BNL6CD bnl6cd = recyclerView4.mPrefetchRegistry;
                int abs = Math.abs(bnl6cd.f9278A4TApA) + Math.abs(bnl6cd.f9277A2egSU);
                for (int i5 = 0; i5 < bnl6cd.f9280ADYaiT * 2; i5 += 2) {
                    if (i3 >= arrayList2.size()) {
                        bPw6Q82 = new BPw6Q8();
                        arrayList2.add(bPw6Q82);
                    } else {
                        bPw6Q82 = (BPw6Q8) arrayList2.get(i3);
                    }
                    int[] iArr = bnl6cd.f9279A5SV6n;
                    int i6 = iArr[i5 + 1];
                    bPw6Q82.f9281A2egSU = i6 <= abs;
                    bPw6Q82.f9282A4TApA = abs;
                    bPw6Q82.f9283A5SV6n = i6;
                    bPw6Q82.f9284ADYaiT = recyclerView4;
                    bPw6Q82.AMqCpz = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(arrayList2, f9286B2KMhB);
        for (int i7 = 0; i7 < arrayList2.size() && (recyclerView = (bPw6Q8 = (BPw6Q8) arrayList2.get(i7)).f9284ADYaiT) != null; i7++) {
            Dphsd2 A5SV6n2 = A5SV6n(recyclerView, bPw6Q8.AMqCpz, bPw6Q8.f9281A2egSU ? Long.MAX_VALUE : j);
            if (A5SV6n2 != null && A5SV6n2.mNestedRecyclerView != null && A5SV6n2.isBound() && !A5SV6n2.isInvalid() && (recyclerView2 = A5SV6n2.mNestedRecyclerView.get()) != null) {
                if (recyclerView2.mDataSetHasChangedAfterLayout && recyclerView2.mChildHelper.AYUAbz() != 0) {
                    recyclerView2.removeAndRecycleViews();
                }
                BNL6CD bnl6cd2 = recyclerView2.mPrefetchRegistry;
                bnl6cd2.A4TApA(recyclerView2, true);
                if (bnl6cd2.f9280ADYaiT != 0) {
                    try {
                        int i8 = C2rE4F.AcNBzu.f1543A2egSU;
                        Trace.beginSection("RV Nested Prefetch");
                        RecyclerView.AaHO0E aaHO0E = recyclerView2.mState;
                        RecyclerView.A2egSU a2egSU = recyclerView2.mAdapter;
                        aaHO0E.f9443ADYaiT = 1;
                        aaHO0E.AMqCpz = a2egSU.getItemCount();
                        aaHO0E.f9445ASJ6gh = false;
                        aaHO0E.f9446AYUAbz = false;
                        aaHO0E.f9447AZOQYO = false;
                        for (int i9 = 0; i9 < bnl6cd2.f9280ADYaiT * 2; i9 += 2) {
                            A5SV6n(recyclerView2, bnl6cd2.f9279A5SV6n[i9], j);
                        }
                        Trace.endSection();
                        bPw6Q8.f9281A2egSU = false;
                        bPw6Q8.f9282A4TApA = 0;
                        bPw6Q8.f9283A5SV6n = 0;
                        bPw6Q8.f9284ADYaiT = null;
                        bPw6Q8.AMqCpz = 0;
                    } catch (Throwable th) {
                        int i10 = C2rE4F.AcNBzu.f1543A2egSU;
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            bPw6Q8.f9281A2egSU = false;
            bPw6Q8.f9282A4TApA = 0;
            bPw6Q8.f9283A5SV6n = 0;
            bPw6Q8.f9284ADYaiT = null;
            bPw6Q8.AMqCpz = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i = C2rE4F.AcNBzu.f1543A2egSU;
            Trace.beginSection("RV Prefetch");
            ArrayList arrayList = this.f9287AcNBzu;
            if (arrayList.isEmpty()) {
                this.f9288AlLFFp = 0L;
                Trace.endSection();
                return;
            }
            int size = arrayList.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i2);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.f9288AlLFFp = 0L;
                Trace.endSection();
            } else {
                A4TApA(TimeUnit.MILLISECONDS.toNanos(j) + this.f9289AmA8tU);
                this.f9288AlLFFp = 0L;
                Trace.endSection();
            }
        } catch (Throwable th) {
            this.f9288AlLFFp = 0L;
            int i3 = C2rE4F.AcNBzu.f1543A2egSU;
            Trace.endSection();
            throw th;
        }
    }
}
