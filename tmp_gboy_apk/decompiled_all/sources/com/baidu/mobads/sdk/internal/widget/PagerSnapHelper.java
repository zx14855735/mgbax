package com.baidu.mobads.sdk.internal.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.CASmeH;
import androidx.recyclerview.widget.CTkVKb;
import androidx.recyclerview.widget.CcAIMM;
import androidx.recyclerview.widget.Cd8JRx;
import androidx.recyclerview.widget.DdagTj;
import androidx.recyclerview.widget.Ddcejp;
import androidx.recyclerview.widget.EPdU4G;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.av;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class PagerSnapHelper extends EPdU4G {

    /* renamed from: a, reason: collision with root package name */
    private static final int f9854a = 100;
    private static final float b = 100.0f;
    private static final boolean g = av.a((Class<?>) Cd8JRx.class, "getLayoutManager", (Class<?>[]) new Class[0]);
    private Cd8JRx c;
    private RecyclerView.ARc23Z d;
    private Cd8JRx e;
    private RecyclerView.ARc23Z f;
    private RecyclerView h;

    static {
        UVsZa();
    }

    private static /* synthetic */ void UVsZa() {
        char[] charArray = "\u0085\u0089\u008bÈ\u0081\u0087\u008b\u0083È\u0084\u0089\u009fÈ\u0095\u008e\u0083\u008a\u008aÈ¬\u0088\u008f¤\u0094\u008f\u0082\u0081\u0083".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 230);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0085\u008a\u008f\u0088\u008f\u0092".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 230);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Cd8JRx b(RecyclerView.ARc23Z aRc23Z) {
        if (aRc23Z.canScrollVertically()) {
            return c(aRc23Z);
        }
        if (aRc23Z.canScrollHorizontally()) {
            return d(aRc23Z);
        }
        return null;
    }

    private Cd8JRx c(RecyclerView.ARc23Z aRc23Z) {
        if (this.c == null || this.d != aRc23Z) {
            this.d = aRc23Z;
            this.c = new CcAIMM(aRc23Z);
        }
        return this.c;
    }

    private Cd8JRx d(RecyclerView.ARc23Z aRc23Z) {
        if (this.e == null || this.f != aRc23Z) {
            this.f = aRc23Z;
            this.e = new CTkVKb(aRc23Z);
        }
        return this.e;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public void attachToRecyclerView(RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (this.h == recyclerView) {
            return;
        }
        this.h = recyclerView;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public int[] calculateDistanceToFinalSnap(RecyclerView.ARc23Z aRc23Z, View view) {
        int[] iArr = new int[2];
        if (aRc23Z.canScrollHorizontally()) {
            iArr[0] = a(aRc23Z, view, d(aRc23Z));
        } else {
            iArr[0] = 0;
        }
        if (aRc23Z.canScrollVertically()) {
            iArr[1] = a(aRc23Z, view, c(aRc23Z));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public CASmeH createSnapScroller(RecyclerView.ARc23Z aRc23Z) {
        RecyclerView recyclerView;
        if (!(aRc23Z instanceof Ddcejp) || (recyclerView = this.h) == null) {
            return null;
        }
        return new CASmeH(recyclerView.getContext()) { // from class: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.1
            @Override // androidx.recyclerview.widget.CASmeH
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.CASmeH
            public int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }

            @Override // androidx.recyclerview.widget.CASmeH, androidx.recyclerview.widget.RecyclerView.AZkASS
            public void onStop() {
                RecyclerView.ARc23Z layoutManager;
                super.onStop();
                if (!PagerSnapHelper.g || PagerSnapHelper.this.h == null || PagerSnapHelper.this.h.getScrollState() == 0 || (layoutManager = PagerSnapHelper.this.h.getLayoutManager()) == null || layoutManager.getChildCount() > 1) {
                    return;
                }
                PagerSnapHelper.this.h.stopScroll();
            }

            @Override // androidx.recyclerview.widget.CASmeH, androidx.recyclerview.widget.RecyclerView.AZkASS
            public void onTargetFound(View view, RecyclerView.AaHO0E aaHO0E, DdagTj ddagTj) {
                if (PagerSnapHelper.this.h == null || PagerSnapHelper.this.h.getLayoutManager() == null) {
                    return;
                }
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.h.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    ddagTj.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public View findSnapView(RecyclerView.ARc23Z aRc23Z) {
        if (aRc23Z.canScrollVertically()) {
            return a(aRc23Z, c(aRc23Z));
        }
        if (aRc23Z.canScrollHorizontally()) {
            return a(aRc23Z, d(aRc23Z));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public int findTargetSnapPosition(RecyclerView.ARc23Z aRc23Z, int i, int i2) {
        Cd8JRx b2;
        int itemCount = aRc23Z.getItemCount();
        if (itemCount == 0 || (b2 = b(aRc23Z)) == null) {
            return -1;
        }
        int childCount = aRc23Z.getChildCount();
        View view = null;
        View view2 = null;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = aRc23Z.getChildAt(i5);
            if (childAt != null) {
                int a2 = a(aRc23Z, childAt, b2);
                if (a2 <= 0 && a2 > i3) {
                    view2 = childAt;
                    i3 = a2;
                }
                if (a2 >= 0 && a2 < i4) {
                    view = childAt;
                    i4 = a2;
                }
            }
        }
        boolean a3 = a(aRc23Z, i, i2);
        if (a3 && view != null) {
            return aRc23Z.getPosition(view);
        }
        if (!a3 && view2 != null) {
            return aRc23Z.getPosition(view2);
        }
        if (a3) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = aRc23Z.getPosition(view) + (a(aRc23Z) == a3 ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    private boolean a(RecyclerView.ARc23Z aRc23Z, int i, int i2) {
        return aRc23Z.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(RecyclerView.ARc23Z aRc23Z) {
        PointF computeScrollVectorForPosition;
        int itemCount = aRc23Z.getItemCount();
        if (!(aRc23Z instanceof Ddcejp) || (computeScrollVectorForPosition = ((Ddcejp) aRc23Z).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    private int a(RecyclerView.ARc23Z aRc23Z, View view, Cd8JRx cd8JRx) {
        return ((cd8JRx.A5SV6n(view) / 2) + cd8JRx.AMqCpz(view)) - ((cd8JRx.AcNBzu() / 2) + cd8JRx.AaHO0E());
    }

    private View a(RecyclerView.ARc23Z aRc23Z, Cd8JRx cd8JRx) {
        int childCount = aRc23Z.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int AcNBzu2 = (cd8JRx.AcNBzu() / 2) + cd8JRx.AaHO0E();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = aRc23Z.getChildAt(i2);
            int abs = Math.abs(((cd8JRx.A5SV6n(childAt) / 2) + cd8JRx.AMqCpz(childAt)) - AcNBzu2);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }
}
