package LHpdLt;

import com.game.boy.MyApp;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu extends LLYwnm.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4511A2egSU;

    private final void AMqCpz(Map map) {
    }

    @Override // LLYwnm.B25kr6
    public final void A2egSU(String str) {
        switch (this.f4511A2egSU) {
            case 0:
                MyApp.A2egSU("修改失败：" + str);
                break;
            default:
                MyApp.A2egSU("拒绝失败：" + str);
                break;
        }
    }

    @Override // LLYwnm.B25kr6
    public final void A4TApA(Map map) {
        switch (this.f4511A2egSU) {
            case 0:
                break;
            default:
                MyApp.A2egSU("已拒绝");
                break;
        }
    }
}
