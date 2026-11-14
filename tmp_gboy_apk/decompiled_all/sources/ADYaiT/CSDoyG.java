package ADYaiT;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CSDoyG extends CcAIMM {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f130AmA8tU = 1;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ CkXcdM f131AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Object f132B25kr6;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSDoyG(CkXcdM ckXcdM, DUi7mC dUi7mC) {
        super(ckXcdM);
        this.f131AzWtSf = ckXcdM;
        this.f132B25kr6 = dUi7mC;
    }

    @Override // ADYaiT.CcAIMM
    public final IntentFilter AMqCpz() {
        switch (this.f130AmA8tU) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    @Override // ADYaiT.CcAIMM
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int ARc23Z() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CSDoyG.ARc23Z():int");
    }

    @Override // ADYaiT.CcAIMM
    public final void AZkASS() {
        switch (this.f130AmA8tU) {
            case 0:
                this.f131AzWtSf.AzWtSf(true, true);
                break;
            default:
                this.f131AzWtSf.AzWtSf(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSDoyG(CkXcdM ckXcdM, Context context) {
        super(ckXcdM);
        this.f131AzWtSf = ckXcdM;
        this.f132B25kr6 = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
