package com.baidu.mobads.sdk.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.EicXu4;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RLRecyclerView extends SwipeRefreshLayout {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f9856a;
    private int[] b;
    private int[] c;
    private int[] d;

    public static class NormalItemDecoration extends RecyclerView.AMqCpz {

        /* renamed from: a, reason: collision with root package name */
        private final int f9857a;
        private final int b;
        private final int c;
        private final int d;

        public NormalItemDecoration(int i, int i2, int i3, int i4) {
            this.f9857a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AMqCpz
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E) {
            rect.left = this.f9857a;
            rect.top = this.b;
            rect.right = this.c;
            rect.bottom = this.d;
        }
    }

    public RLRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new int[2];
        this.d = new int[2];
        a(context);
    }

    private void a(Context context) {
        this.f9856a = new RecyclerView(context, null);
        addView(this.f9856a, new ViewGroup.LayoutParams(-1, -1));
    }

    private int b(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public void addOnScrollListener(RecyclerView.AYUAbz aYUAbz) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(aYUAbz);
        }
    }

    public int[] findVisibleItemPositions() {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView == null) {
            return null;
        }
        RecyclerView.ARc23Z layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.d[0] = gridLayoutManager.findFirstVisibleItemPosition();
            this.d[1] = gridLayoutManager.findLastVisibleItemPosition();
            return this.d;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.d[0] = linearLayoutManager.findFirstVisibleItemPosition();
            this.d[1] = linearLayoutManager.findLastVisibleItemPosition();
            return this.d;
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return null;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        if (this.b == null) {
            this.b = new int[staggeredGridLayoutManager.f9453A2egSU];
        }
        int[] iArr = this.b;
        if (iArr == null) {
            iArr = new int[staggeredGridLayoutManager.f9453A2egSU];
        } else {
            staggeredGridLayoutManager.getClass();
            if (iArr.length < staggeredGridLayoutManager.f9453A2egSU) {
                throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + staggeredGridLayoutManager.f9453A2egSU + ", array size:" + iArr.length);
            }
        }
        for (int i = 0; i < staggeredGridLayoutManager.f9453A2egSU; i++) {
            EicXu4 eicXu4 = staggeredGridLayoutManager.f9454A4TApA[i];
            boolean z = eicXu4.f9395ARc23Z.f9459AYUAbz;
            ArrayList arrayList = eicXu4.f9391A2egSU;
            iArr[i] = z ? eicXu4.AMqCpz(arrayList.size() - 1, -1, true, false) : eicXu4.AMqCpz(0, arrayList.size(), true, false);
        }
        this.d[0] = a(this.b);
        int[] iArr2 = this.b;
        if (iArr2 == null) {
            iArr2 = new int[staggeredGridLayoutManager.f9453A2egSU];
        } else if (iArr2.length < staggeredGridLayoutManager.f9453A2egSU) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + staggeredGridLayoutManager.f9453A2egSU + ", array size:" + iArr2.length);
        }
        for (int i2 = 0; i2 < staggeredGridLayoutManager.f9453A2egSU; i2++) {
            EicXu4 eicXu42 = staggeredGridLayoutManager.f9454A4TApA[i2];
            boolean z2 = eicXu42.f9395ARc23Z.f9459AYUAbz;
            ArrayList arrayList2 = eicXu42.f9391A2egSU;
            iArr2[i2] = z2 ? eicXu42.AMqCpz(0, arrayList2.size(), true, false) : eicXu42.AMqCpz(arrayList2.size() - 1, -1, true, false);
        }
        this.d[1] = b(this.b);
        return this.d;
    }

    public int getChildAdapterPosition(View view) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            return recyclerView.getChildAdapterPosition(view);
        }
        return -1;
    }

    public int[] getLayoutManagerCounts() {
        RecyclerView.ARc23Z layoutManager;
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        this.c[0] = layoutManager.getItemCount();
        this.c[1] = layoutManager.getChildCount();
        return this.c;
    }

    public View getRvChildAt(int i) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            return recyclerView.getChildAt(i);
        }
        return null;
    }

    public int getRvChildCount() {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            return recyclerView.getChildCount();
        }
        return 0;
    }

    public int indexOfRvChild(View view) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            return recyclerView.indexOfChild(view);
        }
        return -1;
    }

    public void scrollToPosition(int i) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i);
        }
    }

    public void setAdapter(RecyclerView.A2egSU a2egSU) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            recyclerView.setAdapter(a2egSU);
        }
    }

    public void setItemDecoration(int i, int i2, int i3, int i4) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new NormalItemDecoration(i, i2, i3, i4));
        }
    }

    public void setLayoutManager(int i, int i2, int i3) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            if (1 == i) {
                getContext();
                recyclerView.setLayoutManager(new LinearLayoutManager(1));
            } else if (2 == i) {
                getContext();
                recyclerView.setLayoutManager(new GridLayoutManager(i2));
            } else if (3 == i) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(i2, i3));
            }
        }
    }

    public void setRecyclerViewPadding(int i, int i2, int i3, int i4) {
        RecyclerView recyclerView = this.f9856a;
        if (recyclerView != null) {
            recyclerView.setPadding(i, i2, i3, i4);
        }
    }

    public RLRecyclerView(Context context) {
        super(context, null);
        this.c = new int[2];
        this.d = new int[2];
        a(context);
    }

    private int a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 < i) {
                i = i2;
            }
        }
        return i;
    }
}
