package androidx.viewpager.widget;

import android.database.DataSetObserver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO extends DataSetObserver {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f9538A2egSU;

    public AZOQYO(AlLFFp alLFFp) {
        this.f9538A2egSU = alLFFp;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.f9538A2egSU.dataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.f9538A2egSU.dataSetChanged();
    }
}
