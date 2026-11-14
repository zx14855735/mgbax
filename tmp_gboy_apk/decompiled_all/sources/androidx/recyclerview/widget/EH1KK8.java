package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EH1KK8 extends CASmeH {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ EPdU4G f9378A2egSU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EH1KK8(EPdU4G ePdU4G, Context context) {
        super(context);
        this.f9378A2egSU = ePdU4G;
    }

    @Override // androidx.recyclerview.widget.CASmeH
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.CASmeH, androidx.recyclerview.widget.RecyclerView.AZkASS
    public final void onTargetFound(View view, RecyclerView.AaHO0E aaHO0E, DdagTj ddagTj) {
        EPdU4G ePdU4G = this.f9378A2egSU;
        RecyclerView recyclerView = ePdU4G.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = ePdU4G.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
        int i = calculateDistanceToFinalSnap[0];
        int i2 = calculateDistanceToFinalSnap[1];
        int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (calculateTimeForDeceleration > 0) {
            ddagTj.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
