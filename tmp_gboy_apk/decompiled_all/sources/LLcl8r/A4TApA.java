package LLcl8r;

import ADYaiT.AmA8tU;
import com.game.boy.viewUi.GameSurfaceView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4649AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ADYaiT f4650AlLFFp;

    public /* synthetic */ A4TApA(ADYaiT aDYaiT, int i) {
        this.f4649AcNBzu = i;
        this.f4650AlLFFp = aDYaiT;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4649AcNBzu) {
            case 0:
                this.f4650AlLFFp.onPreExecute();
                break;
            default:
                GameSurfaceView gameSurfaceView = this.f4650AlLFFp.f4653A2egSU.f10995B3GDIM;
                AmA8tU amA8tU = gameSurfaceView.f11164BIYEnU;
                if (amA8tU != null && amA8tU.isShowing()) {
                    gameSurfaceView.f11164BIYEnU.dismiss();
                    break;
                }
                break;
        }
    }
}
