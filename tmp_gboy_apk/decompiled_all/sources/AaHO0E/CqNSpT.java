package AaHO0E;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CqNSpT implements PopupWindow.OnDismissListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AZkASS.A5SV6n f703AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ CrfGsy f704AlLFFp;

    public CqNSpT(CrfGsy crfGsy, AZkASS.A5SV6n a5SV6n) {
        this.f704AlLFFp = crfGsy;
        this.f703AcNBzu = a5SV6n;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f704AlLFFp.f709CmUvjW.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f703AcNBzu);
        }
    }
}
