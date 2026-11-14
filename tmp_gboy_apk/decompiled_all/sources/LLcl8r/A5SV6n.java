package LLcl8r;

import MOpbMP.AZOQYO;
import android.content.DialogInterface;
import android.view.KeyEvent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements DialogInterface.OnKeyListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4651AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f4652AlLFFp;

    public /* synthetic */ A5SV6n(int i, Object obj) {
        this.f4651AcNBzu = i;
        this.f4652AlLFFp = obj;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        switch (this.f4651AcNBzu) {
            case 0:
                if (i != 4) {
                    return false;
                }
                ((ADYaiT) this.f4652AlLFFp).f4653A2egSU.finish();
                return true;
            default:
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                ((AZOQYO) this.f4652AlLFFp).getClass();
                if (!LEPB2s.A2egSU.A4TApA().A5SV6n()) {
                    return false;
                }
                LEPB2s.A2egSU.A4TApA().A2egSU();
                return true;
        }
    }
}
