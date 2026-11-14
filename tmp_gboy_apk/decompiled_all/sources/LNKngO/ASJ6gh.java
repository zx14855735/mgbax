package LNKngO;

import KpHwm4.AZOQYO;
import KpHwm4.AaHO0E;
import com.game.boy.emu.gba.Console;
import com.kwad.components.offline.api.IOfflineCompo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh implements A2egSU, AZOQYO {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AaHO0E f4818AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Console f4819AlLFFp;

    public ASJ6gh(AaHO0E aaHO0E) {
        this.f4818AcNBzu = aaHO0E;
        aaHO0E.f4296A5SV6n = this;
        this.f4819AlLFFp = aaHO0E.f4307AzWtSf.f11100A2egSU;
    }

    @Override // KpHwm4.AZOQYO
    public final void a(int i, int i2) {
        int i3 = 50;
        if (((i2 ^ i) & 50) != 0) {
            boolean z = (i & 2) != 0;
            if ((i & 16) == 0) {
                i3 = (i & 32) != 0 ? z ? IOfflineCompo.Priority.HIGHEST : -50 : 0;
            } else if (z) {
                i3 = 200;
            }
            this.f4819AlLFFp.setGyroValue(i3);
        }
    }

    @Override // LNKngO.A2egSU
    public final void c() {
        this.f4818AcNBzu.f4296A5SV6n = null;
    }
}
