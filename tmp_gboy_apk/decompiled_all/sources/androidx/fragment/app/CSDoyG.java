package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CSDoyG implements View.OnAttachStateChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ DUi7mC f8815AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ CTkVKb f8816AlLFFp;

    public CSDoyG(CTkVKb cTkVKb, DUi7mC dUi7mC) {
        this.f8816AlLFFp = cTkVKb;
        this.f8815AcNBzu = dUi7mC;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        DUi7mC dUi7mC = this.f8815AcNBzu;
        dUi7mC.AZOQYO();
        AmA8tU.AYUAbz((ViewGroup) dUi7mC.f8903A5SV6n.mView.getParent(), this.f8816AlLFFp.f8817AcNBzu).ASJ6gh();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
