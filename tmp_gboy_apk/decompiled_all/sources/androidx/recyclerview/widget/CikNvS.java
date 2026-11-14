package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CikNvS extends CASmeH {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ CkXcdM f9328A2egSU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CikNvS(CkXcdM ckXcdM, Context context) {
        super(context);
        this.f9328A2egSU = ckXcdM;
    }

    @Override // androidx.recyclerview.widget.CASmeH
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.CASmeH
    public final int calculateTimeForScrolling(int i) {
        return Math.min(100, super.calculateTimeForScrolling(i));
    }

    @Override // androidx.recyclerview.widget.CASmeH, androidx.recyclerview.widget.RecyclerView.AZkASS
    public final void onTargetFound(View view, RecyclerView.AaHO0E aaHO0E, DdagTj ddagTj) {
        CkXcdM ckXcdM = this.f9328A2egSU;
        int[] calculateDistanceToFinalSnap = ckXcdM.calculateDistanceToFinalSnap(ckXcdM.mRecyclerView.getLayoutManager(), view);
        int i = calculateDistanceToFinalSnap[0];
        int i2 = calculateDistanceToFinalSnap[1];
        int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (calculateTimeForDeceleration > 0) {
            ddagTj.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
