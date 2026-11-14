package DRlcZ9;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM extends RecyclerView.AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Drawable f2100A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f2101A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f2102A5SV6n = true;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ B4ZgIw f2103ADYaiT;

    public B3GDIM(B4ZgIw b4ZgIw) {
        this.f2103ADYaiT = b4ZgIw;
    }

    public final boolean A2egSU(RecyclerView recyclerView, View view) {
        Dphsd2 childViewHolder = recyclerView.getChildViewHolder(view);
        if (!(childViewHolder instanceof BV3sI0) || !((BV3sI0) childViewHolder).f2144B25kr6) {
            return false;
        }
        boolean z = this.f2102A5SV6n;
        int indexOfChild = recyclerView.indexOfChild(view);
        if (indexOfChild >= recyclerView.getChildCount() - 1) {
            return z;
        }
        Dphsd2 childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
        return (childViewHolder2 instanceof BV3sI0) && ((BV3sI0) childViewHolder2).f2143AzWtSf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AMqCpz
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E) {
        if (A2egSU(recyclerView, view)) {
            rect.bottom = this.f2101A4TApA;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AMqCpz
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E) {
        if (this.f2100A2egSU == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        int width = recyclerView.getWidth();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (A2egSU(recyclerView, childAt)) {
                int height = childAt.getHeight() + ((int) childAt.getY());
                this.f2100A2egSU.setBounds(0, height, width, this.f2101A4TApA + height);
                this.f2100A2egSU.draw(canvas);
            }
        }
    }
}
