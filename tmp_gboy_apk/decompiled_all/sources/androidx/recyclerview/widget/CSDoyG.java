package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CSDoyG {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f9324A2egSU;

    public void A2egSU(int i) {
        RecyclerView recyclerView = (RecyclerView) this.f9324A2egSU;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            recyclerView.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }
}
