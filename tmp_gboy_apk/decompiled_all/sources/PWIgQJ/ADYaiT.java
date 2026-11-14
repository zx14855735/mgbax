package PWIgQJ;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements View.OnLayoutChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ View f7287AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ com.google.android.material.tabs.ADYaiT f7288AlLFFp;

    public ADYaiT(com.google.android.material.tabs.ADYaiT aDYaiT, View view) {
        this.f7288AlLFFp = aDYaiT;
        this.f7287AcNBzu = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        View view2 = this.f7287AcNBzu;
        if (view2.getVisibility() == 0) {
            this.f7288AlLFFp.A5SV6n(view2);
        }
    }
}
