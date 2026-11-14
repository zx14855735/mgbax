package MOpbMP;

import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements DialogInterface.OnShowListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5024AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f5025AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f5026AmA8tU;

    public /* synthetic */ AaHO0E(Object obj, int i, Object obj2) {
        this.f5024AcNBzu = i;
        this.f5026AmA8tU = obj;
        this.f5025AlLFFp = obj2;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        switch (this.f5024AcNBzu) {
            case 0:
                Window window = ((ADYaiT.AmA8tU) this.f5025AlLFFp).getWindow();
                if (window != null) {
                    window.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    View decorView = window.getDecorView();
                    decorView.setFocusable(true);
                    decorView.setFocusableInTouchMode(true);
                    decorView.requestFocus();
                    Window.Callback callback = window.getCallback();
                    if (callback != null) {
                        window.setCallback(new AcNBzu(callback, new AZkASS.ARc23Z(25, this)));
                        break;
                    }
                }
                break;
            default:
                ADYaiT.AmA8tU amA8tU = (ADYaiT.AmA8tU) dialogInterface;
                amA8tU.ARc23Z(-2).setOnClickListener(new ADYaiT.A5SV6n(20, this));
                com.game.boy.activity.BTvldC bTvldC = (com.game.boy.activity.BTvldC) this.f5025AlLFFp;
                if (bTvldC != null) {
                    bTvldC.A2egSU(amA8tU);
                    break;
                }
                break;
        }
    }
}
