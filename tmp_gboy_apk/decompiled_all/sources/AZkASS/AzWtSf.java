package AZkASS;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, BJ7GGh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public BpkvW3 f517AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ADYaiT.AmA8tU f518AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public AZkASS f519AmA8tU;

    @Override // AZkASS.BJ7GGh
    public final void A2egSU(AmA8tU amA8tU, boolean z) {
        ADYaiT.AmA8tU amA8tU2;
        if ((z || amA8tU == this.f517AcNBzu) && (amA8tU2 = this.f518AlLFFp) != null) {
            amA8tU2.dismiss();
        }
    }

    @Override // AZkASS.BJ7GGh
    public final boolean AMqCpz(AmA8tU amA8tU) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AZkASS aZkASS = this.f519AmA8tU;
        if (aZkASS.f486B2KMhB == null) {
            aZkASS.f486B2KMhB = new AZOQYO(aZkASS);
        }
        this.f517AcNBzu.B2KMhB(aZkASS.f486B2KMhB.getItem(i), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f519AmA8tU.A2egSU(this.f517AcNBzu, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        BpkvW3 bpkvW3 = this.f517AcNBzu;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f518AlLFFp.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f518AlLFFp.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                bpkvW3.A5SV6n(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return bpkvW3.performShortcut(i, keyEvent, 0);
    }
}
