package NGepWW;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DG07BK extends Handler {
    public DG07BK() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            Pair pair = (Pair) message.obj;
            try {
                ((ECyGFg) pair.first).A2egSU((NSK3xo.AmA8tU) pair.second);
                return;
            } catch (RuntimeException e) {
                DAk1zC dAk1zC = DRlcZ9.f5722AlLFFp;
                throw e;
            }
        }
        if (i == 2) {
            ((DRlcZ9) message.obj).AMqCpz(NSK3xo.A4TApA.f5923B3GDIM);
            return;
        }
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i);
        Log.wtf("BasePendingResult", sb.toString(), new Exception());
    }
}
