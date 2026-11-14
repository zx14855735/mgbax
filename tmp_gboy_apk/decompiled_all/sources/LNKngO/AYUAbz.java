package LNKngO;

import KpHwm4.AZOQYO;
import KpHwm4.AaHO0E;
import com.game.boy.emu.gba.Console;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz implements A2egSU, AZOQYO {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AaHO0E f4820AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Console f4821AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f4822AmA8tU;

    public AYUAbz(AaHO0E aaHO0E) {
        this.f4820AcNBzu = aaHO0E;
        aaHO0E.f4296A5SV6n = this;
        this.f4821AlLFFp = aaHO0E.f4307AzWtSf.f11100A2egSU;
    }

    @Override // KpHwm4.AZOQYO
    public final void a(int i, int i2) {
        int i3 = (i2 ^ i) & i;
        if ((i3 & 48) == 0 || (i & 512) == 0) {
            return;
        }
        int i4 = this.f4822AmA8tU;
        int i5 = (i3 & 32) != 0 ? i4 + 1 : (i3 & 16) != 0 ? i4 - 1 : i4;
        if (i5 < 0) {
            i5 = 0;
        }
        if (i5 > 10) {
            i5 = 10;
        }
        if (i4 != i5) {
            this.f4822AmA8tU = i5;
            this.f4821AlLFFp.setSolarValue(AMqCpz.f4804B25kr6[i5]);
        }
    }

    @Override // LNKngO.A2egSU
    public final void c() {
        this.f4820AcNBzu.f4296A5SV6n = null;
    }
}
