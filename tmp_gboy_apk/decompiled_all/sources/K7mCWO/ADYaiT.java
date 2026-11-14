package K7mCWO;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Printer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements Printer {
    @Override // android.util.Printer
    public final void println(String str) {
        if (str == null) {
            return;
        }
        if (str.startsWith(">>>>> Dispatching")) {
            AMqCpz A2egSU2 = AMqCpz.A2egSU();
            if (!A2egSU2.f4192B4ZgIw) {
                AZOQYO.A2egSU(32L);
                A2egSU2.f4192B4ZgIw = true;
            }
            A2egSU2.f4187AmA8tU = SystemClock.uptimeMillis();
            try {
                A2egSU2.A5SV6n(str, A2egSU2.f4189B25kr6);
                A2egSU2.f4185AcNBzu.sendEmptyMessage(0);
            } catch (Exception unused) {
                JrXYwF.A5SV6n.f4152ADYaiT.getClass();
            }
        } else if (str.startsWith("<<<<< Finished")) {
            AMqCpz A2egSU3 = AMqCpz.A2egSU();
            A2egSU3.getClass();
            SystemClock.uptimeMillis();
            Handler handler = A2egSU3.f4185AcNBzu;
            try {
                handler.removeMessages(2);
                A2egSU3.A5SV6n(str, A2egSU3.f4190B2KMhB);
                handler.sendEmptyMessage(1);
            } catch (Exception unused2) {
                com.bumptech.glide.AMqCpz.C2rE4F();
            }
        }
        Printer printer = AMqCpz.f4182B7CMnp;
        if (printer == null || printer == AMqCpz.f4184BChYOn) {
            return;
        }
        printer.println(str);
    }
}
