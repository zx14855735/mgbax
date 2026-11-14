package OCUYV2;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.CASmeH;
import androidx.recyclerview.widget.DdagTj;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends CASmeH {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ARc23Z f6234A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f6235A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ASJ6gh(AYUAbz aYUAbz, Context context, RecyclerView.ARc23Z aRc23Z) {
        super(context);
        this.f6235A4TApA = aYUAbz;
        this.f6234A2egSU = aRc23Z;
    }

    @Override // androidx.recyclerview.widget.CASmeH
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        float f;
        float f2;
        if (this.f6234A2egSU.canScrollVertically()) {
            f = displayMetrics.densityDpi;
            f2 = 50.0f;
        } else {
            f = displayMetrics.densityDpi;
            f2 = 100.0f;
        }
        return f2 / f;
    }

    @Override // androidx.recyclerview.widget.CASmeH, androidx.recyclerview.widget.RecyclerView.AZkASS
    public final void onTargetFound(View view, RecyclerView.AaHO0E aaHO0E, DdagTj ddagTj) {
        RecyclerView recyclerView = this.f6235A4TApA.f6237A4TApA;
        if (recyclerView != null) {
            int[] A2egSU2 = AYUAbz.A2egSU(recyclerView.getLayoutManager(), view, true);
            int i = A2egSU2[0];
            int i2 = A2egSU2[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
            if (calculateTimeForDeceleration > 0) {
                ddagTj.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }
}
