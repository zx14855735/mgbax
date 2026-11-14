package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D8cQ8b implements ErKPGd {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ARc23Z f9341A2egSU;

    public D8cQ8b(RecyclerView.ARc23Z aRc23Z) {
        this.f9341A2egSU = aRc23Z;
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final int A2egSU(View view) {
        return this.f9341A2egSU.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((DG07BK) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final int A4TApA() {
        return this.f9341A2egSU.getPaddingLeft();
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final int A5SV6n() {
        RecyclerView.ARc23Z aRc23Z = this.f9341A2egSU;
        return aRc23Z.getWidth() - aRc23Z.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final View ADYaiT(int i) {
        return this.f9341A2egSU.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.ErKPGd
    public final int AMqCpz(View view) {
        return this.f9341A2egSU.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((DG07BK) view.getLayoutParams())).rightMargin;
    }
}
