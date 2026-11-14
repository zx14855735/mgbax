package LNKngO;

import KpHwm4.AaHO0E;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.game.boy.emu.gba.Console;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AaHO0E f4798AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Console f4799AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Vibrator f4800AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final long[] f4801AzWtSf = new long[32];

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f4802B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final boolean f4803B2KMhB;

    public ADYaiT(Vibrator vibrator, AaHO0E aaHO0E, int i) {
        this.f4802B25kr6 = 7;
        this.f4803B2KMhB = false;
        this.f4800AmA8tU = vibrator;
        this.f4798AcNBzu = aaHO0E;
        this.f4802B25kr6 = Math.max(0, Math.min(10, i));
        aaHO0E.f4297ADYaiT = this;
        Console console = aaHO0E.f4307AzWtSf.f11100A2egSU;
        this.f4799AlLFFp = console;
        console.enableRumble(true);
        this.f4803B2KMhB = Build.VERSION.SDK_INT >= 26;
    }

    public final void A2egSU() {
        int i;
        VibrationEffect createWaveform;
        if (this.f4802B25kr6 == 0) {
            return;
        }
        long[] jArr = this.f4801AzWtSf;
        if (this.f4799AlLFFp.getRumblePattern(jArr)) {
            boolean z = this.f4803B2KMhB;
            Vibrator vibrator = this.f4800AmA8tU;
            if (!z || (i = Build.VERSION.SDK_INT) < 26) {
                vibrator.vibrate(jArr, -1);
            } else if (i >= 26) {
                try {
                    createWaveform = VibrationEffect.createWaveform(jArr, ((this.f4802B25kr6 - 1) * 23) + 25);
                    vibrator.vibrate(createWaveform);
                } catch (Exception unused) {
                    vibrator.vibrate(jArr, -1);
                }
            }
        }
    }

    @Override // LNKngO.A2egSU
    public final void c() {
        this.f4798AcNBzu.f4297ADYaiT = null;
        this.f4799AlLFFp.enableRumble(false);
    }
}
