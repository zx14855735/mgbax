package De4eam;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.DXnQ0V;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO extends LinearLayoutManager {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f2409A2egSU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AZOQYO(ViewPager2 viewPager2) {
        super(1);
        this.f2409A2egSU = viewPager2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.AaHO0E aaHO0E, int[] iArr) {
        ViewPager2 viewPager2 = this.f2409A2egSU;
        int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.calculateExtraLayoutSpace(aaHO0E, iArr);
            return;
        }
        int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onInitializeAccessibilityNodeInfo(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, CQhlFr.AYUAbz aYUAbz) {
        super.onInitializeAccessibilityNodeInfo(dXnQ0V, aaHO0E, aYUAbz);
        this.f2409A2egSU.f9604BniPrB.getClass();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onInitializeAccessibilityNodeInfoForItem(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, View view, CQhlFr.AYUAbz aYUAbz) {
        ViewPager2 viewPager2 = this.f2409A2egSU.f9604BniPrB.f2413ADYaiT;
        aYUAbz.AaHO0E(CQhlFr.ASJ6gh.A2egSU(viewPager2.getOrientation() == 1 ? viewPager2.f9591B3GDIM.getPosition(view) : 0, 1, viewPager2.getOrientation() == 0 ? viewPager2.f9591B3GDIM.getPosition(view) : 0, 1, false, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean performAccessibilityAction(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, int i, Bundle bundle) {
        this.f2409A2egSU.f9604BniPrB.getClass();
        return super.performAccessibilityAction(dXnQ0V, aaHO0E, i, bundle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }
}
