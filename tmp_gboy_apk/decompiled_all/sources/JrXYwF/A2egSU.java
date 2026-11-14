package JrXYwF;

import C2rE4F.AcNBzu;
import JtTqUo.A2egSU;
import LCJm5h.AYUAbz;
import LLYwnm.B25kr6;
import android.content.Context;
import android.os.Trace;
import androidx.emoji2.text.AmA8tU;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4140AcNBzu;

    public /* synthetic */ A2egSU(int i) {
        this.f4140AcNBzu = i;
    }

    private final void A2egSU() {
    }

    private final void A4TApA() {
    }

    private final void A5SV6n() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4140AcNBzu) {
            case 0:
                Map BNL6CD2 = A5SV6n.f4151A5SV6n.BNL6CD();
                try {
                    byte[] bytes = KT3FfN.A2egSU.A2egSU(BNL6CD2).toString().getBytes("UTF-8");
                    A5SV6n.f4152ADYaiT.getClass();
                    A2egSU.C0003A2egSU c0003A2egSU = new A2egSU.C0003A2egSU();
                    c0003A2egSU.f4163A2egSU = "https://apmplus.volces.com/monitor/collect/c/session?device_platform=android&version_code=137&iid=iid&aid=" + BNL6CD2.get("aid");
                    c0003A2egSU.f4164A4TApA = true;
                    c0003A2egSU.f4165A5SV6n = bytes;
                    new JtTqUo.A2egSU();
                    try {
                        com.bumptech.glide.AMqCpz.D6yqiO(c0003A2egSU.f4163A2egSU, c0003A2egSU.f4165A5SV6n, c0003A2egSU.f4164A4TApA);
                    } catch (Throwable th) {
                        com.bumptech.glide.AMqCpz.C2rE4F();
                        th.getMessage();
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 1:
                AYUAbz.A5SV6n();
                return;
            case 2:
                try {
                    AYUAbz.A2egSU();
                    AYUAbz.f4442ASJ6gh = null;
                    AYUAbz.f4441ARc23Z.set(false);
                    return;
                } catch (Throwable th2) {
                    AYUAbz.f4442ASJ6gh = null;
                    Context context = AYUAbz.f4437A2egSU;
                    AYUAbz.f4441ARc23Z.set(false);
                    throw th2;
                }
            case 3:
            case 4:
            case 5:
                return;
            default:
                try {
                    int i = AcNBzu.f1543A2egSU;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (AmA8tU.f8658AaHO0E != null) {
                        AmA8tU.A2egSU().A5SV6n();
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th3) {
                    int i2 = AcNBzu.f1543A2egSU;
                    Trace.endSection();
                    throw th3;
                }
        }
    }

    public /* synthetic */ A2egSU(B25kr6 b25kr6, int i) {
        this.f4140AcNBzu = i;
    }
}
