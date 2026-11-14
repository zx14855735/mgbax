package GcSJYy;

import android.os.Handler;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends Handler {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        A5SV6n a5SV6n = (A5SV6n) message.obj;
        int i = message.what;
        if (i == 1) {
            AMqCpz aMqCpz = a5SV6n.f3068A4TApA;
            boolean A2egSU2 = aMqCpz.A2egSU();
            F32kj0.A2egSU a2egSU = aMqCpz.f3072A4TApA;
            if (A2egSU2) {
                a2egSU.ADYaiT(new F1loUV.A2egSU(801));
                return;
            } else {
                if (aMqCpz.A2egSU()) {
                    return;
                }
                a2egSU.AMqCpz(a5SV6n.f3067A2egSU);
                return;
            }
        }
        if (i == 2) {
            a5SV6n.f3068A4TApA.A2egSU();
            return;
        }
        if (i == 3) {
            a5SV6n.f3068A4TApA.f3072A4TApA.ADYaiT(new F1loUV.A2egSU(801));
            return;
        }
        if (i != 4) {
            return;
        }
        AMqCpz aMqCpz2 = a5SV6n.f3068A4TApA;
        if (aMqCpz2.A2egSU()) {
            return;
        }
        Exception exc = a5SV6n.f3069A5SV6n;
        aMqCpz2.f3072A4TApA.ADYaiT(exc instanceof F1loUV.A2egSU ? (F1loUV.A2egSU) exc : (exc.getCause() == null || !(exc.getCause() instanceof F1loUV.A2egSU)) ? new F1loUV.A2egSU(F1loUV.A2egSU.A2egSU(exc, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE), exc) : (F1loUV.A2egSU) exc.getCause());
    }
}
