package ADYaiT;

import android.view.View;
import android.widget.AbsListView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements AbsListView.OnScrollListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ View f14A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ View f15A4TApA;

    public AMqCpz(View view, View view2) {
        this.f14A2egSU = view;
        this.f15A4TApA = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AcNBzu.A4TApA(absListView, this.f14A2egSU, this.f15A4TApA);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
