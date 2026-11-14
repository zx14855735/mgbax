package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DvK7DB extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final RecyclerView f9374ADYaiT;
    public final DuwtYk AMqCpz;

    public DvK7DB(RecyclerView recyclerView) {
        this.f9374ADYaiT = recyclerView;
        COJEAR.A4TApA AZkASS2 = AZkASS();
        if (AZkASS2 == null || !(AZkASS2 instanceof DuwtYk)) {
            this.AMqCpz = new DuwtYk(this);
        } else {
            this.AMqCpz = (DuwtYk) AZkASS2;
        }
    }

    @Override // COJEAR.A4TApA
    public final void A5SV6n(View view, AccessibilityEvent accessibilityEvent) {
        super.A5SV6n(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f9374ADYaiT.hasPendingAdapterUpdates()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // COJEAR.A4TApA
    public void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        this.f1615A2egSU.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
        RecyclerView recyclerView = this.f9374ADYaiT;
        if (recyclerView.hasPendingAdapterUpdates() || recyclerView.getLayoutManager() == null) {
            return;
        }
        recyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(aYUAbz);
    }

    @Override // COJEAR.A4TApA
    public final boolean ASJ6gh(View view, int i, Bundle bundle) {
        if (super.ASJ6gh(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f9374ADYaiT;
        if (recyclerView.hasPendingAdapterUpdates() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        return recyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public COJEAR.A4TApA AZkASS() {
        return this.AMqCpz;
    }
}
