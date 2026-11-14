package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D9tr6l implements ErKPGd {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ARc23Z f9342A2egSU;

    public D9tr6l(RecyclerView.ARc23Z aRc23Z) {
        this.f9342A2egSU = aRc23Z;
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final int A2egSU(View view) {
        return this.f9342A2egSU.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((DG07BK) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final int A4TApA() {
        return this.f9342A2egSU.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final int A5SV6n() {
        RecyclerView.ARc23Z aRc23Z = this.f9342A2egSU;
        return aRc23Z.getHeight() - aRc23Z.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final View ADYaiT(int i) {
        return this.f9342A2egSU.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final int AMqCpz(View view) {
        return this.f9342A2egSU.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((DG07BK) view.getLayoutParams())).bottomMargin;
    }
}
