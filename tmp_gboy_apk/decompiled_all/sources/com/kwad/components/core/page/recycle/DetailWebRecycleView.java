package com.kwad.components.core.page.recycle;

import COJEAR.DG07BK;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.s.y;
import com.kwad.sdk.utils.z;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DetailWebRecycleView extends b {
    a WA;
    private Runnable WB;
    private y WC;
    private int Wu;
    private boolean Wv;
    private boolean Ww;
    private int Wx;
    private int Wy;
    private boolean Wz;
    private int oB;

    public interface a {
        boolean sF();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.WC, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.WC);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.WA;
        if (aVar != null && aVar.sF()) {
            return true;
        }
        this.Wy = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.Wx - this.Wy) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.Wy = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.Wx) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.Wy = computeVerticalScrollOffset;
        if (i2 > 0 && computeVerticalScrollOffset < this.Wx && !this.Wz && computeVerticalScrollOffset < this.oB) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 >= 0 || this.Wy <= 0) {
            return;
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (view.canScrollVertically(-1)) {
            return;
        }
        scrollBy(0, i2);
        iArr[1] = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.Wz = true;
                    return;
                }
            }
            this.Wz = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.Ww) {
            this.Ww = false;
        } else {
            if (this.Wv) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.Wv = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.Ww = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.WA = aVar;
    }

    public void setTopViewHeight(int i) {
        this.Wx = i;
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wu = 1000;
        this.Wv = false;
        this.Ww = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = z.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        z.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Wu));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
        };
        this.WB = runnable;
        this.WC = new y(runnable);
        if (context instanceof Activity) {
            this.oB = com.kwad.sdk.c.a.a.k((Activity) context);
        } else {
            this.oB = com.kwad.sdk.c.a.a.getScreenHeight(context);
        }
    }
}
