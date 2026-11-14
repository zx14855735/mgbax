package androidx.fragment.app;

import android.view.View;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DRlcZ9 implements View.OnAttachStateChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ View f8900AcNBzu;

    public DRlcZ9(View view) {
        this.f8900AcNBzu = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        View view2 = this.f8900AcNBzu;
        view2.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        COJEAR.CikNvS.A5SV6n(view2);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
