package C4FrIb;

import AaHO0E.D8MqeW;
import CQhlFr.B7CMnp;
import android.view.View;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.emu.gba.Console;
import com.game.boy.emu.gba.Link;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU implements B7CMnp {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1574AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f1575AlLFFp;

    public /* synthetic */ AmA8tU(int i, Object obj) {
        this.f1575AlLFFp = obj;
        this.f1574AcNBzu = i;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [KpHwm4.AZOQYO, java.lang.Object] */
    public void A2egSU() {
        Iterator it = ((EmulatorActivity) this.f1575AlLFFp).f11028D6yqiO.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i2 |= ((LQ734U.A2egSU) it.next()).f4823AcNBzu;
        }
        int i3 = this.f1574AcNBzu ^ i2;
        this.f1574AcNBzu = i2;
        if (((-65536) & i3) != 0) {
            EmulatorActivity emulatorActivity = (EmulatorActivity) this.f1575AlLFFp;
            int i4 = i2 & i3;
            Link link = emulatorActivity.f11004BPw6Q8;
            Console console = link.f11100A2egSU;
            if (console != null) {
                if ((131072 & i4) != 0) {
                    emulatorActivity.CcAIMM(new D8MqeW(emulatorActivity, console, i, 8, false));
                    MyApp.A2egSU("快速保存成功");
                }
                if ((65536 & i4) != 0) {
                    emulatorActivity.AmA8tU(link.f11100A2egSU, 0);
                }
                if ((524288 & i4) != 0) {
                    emulatorActivity.D6DOie();
                }
                if ((1048576 & i4) != 0) {
                    emulatorActivity.openOptionsMenu();
                }
            }
            if (!emulatorActivity.f11027D6DOie) {
                i3 = i4;
            }
            if ((i3 & 262144) != 0 && emulatorActivity.f11015CSDoyG == null) {
                emulatorActivity.CASmeH(null, !emulatorActivity.BpkvW3());
            }
        }
        KpHwm4.AaHO0E aaHO0E = ((EmulatorActivity) this.f1575AlLFFp).f11011CASmeH;
        int i5 = 65535 & i2;
        ?? r2 = aaHO0E.f4296A5SV6n;
        if (r2 != 0) {
            r2.a(i5, aaHO0E.f4299ASJ6gh);
        }
        aaHO0E.f4299ASJ6gh = i5;
    }

    @Override // CQhlFr.B7CMnp
    public boolean ADYaiT(View view) {
        ((BottomSheetBehavior) this.f1575AlLFFp).setState(this.f1574AcNBzu);
        return true;
    }

    public AmA8tU(EmulatorActivity emulatorActivity) {
        this.f1575AlLFFp = emulatorActivity;
    }

    public AmA8tU(int i, AzWtSf[] azWtSfArr) {
        this.f1574AcNBzu = i;
        this.f1575AlLFFp = azWtSfArr;
    }
}
