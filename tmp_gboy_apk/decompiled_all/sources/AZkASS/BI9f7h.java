package AZkASS;

import ADYaiT.DUi7mC;
import android.widget.PopupWindow;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h implements PopupWindow.OnDismissListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f559AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f560AlLFFp;

    public /* synthetic */ BI9f7h(int i, Object obj) {
        this.f559AcNBzu = i;
        this.f560AlLFFp = obj;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        switch (this.f559AcNBzu) {
            case 0:
                ((BIYEnU) this.f560AlLFFp).A5SV6n();
                break;
            default:
                ((DUi7mC) this.f560AlLFFp).getClass();
                break;
        }
    }
}
