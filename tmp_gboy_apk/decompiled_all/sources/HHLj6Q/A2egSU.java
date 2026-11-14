package HHLj6Q;

import GJee0v.AZOQYO;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends Handler {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3355A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ FZu94u.A4TApA f3356A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A2egSU(FZu94u.A4TApA a4TApA, Looper looper, int i) {
        super(looper);
        this.f3355A2egSU = i;
        this.f3356A4TApA = a4TApA;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        FZu94u.A4TApA a4TApA = this.f3356A4TApA;
        switch (this.f3355A2egSU) {
            case 0:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                int i = AZOQYO.f3039AcNBzu;
                FZu94u.A4TApA.Dphsd2(a4TApA, a4TApA.f2781FmyuN2, null);
                break;
            default:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                if (!a4TApA.f3189AZkASS) {
                    int i2 = a4TApA.f2774FM663C + 100;
                    a4TApA.f2774FM663C = i2;
                    if (i2 < 4300) {
                        a4TApA.f2772F508T2.sendEmptyMessageDelayed(0, 100L);
                        break;
                    } else {
                        a4TApA.D07BeM(a4TApA.f3187AYUAbz);
                        a4TApA.DRlcZ9();
                        a4TApA.B4ZgIw("素材加载超时", "1", "加载超时导致素材不可用");
                        int i3 = AZOQYO.f3039AcNBzu;
                        break;
                    }
                } else {
                    NMRewardVideoActivity.f9613F1loUV = a4TApA;
                    Intent intent = new Intent(a4TApA.f2769ExjC7D, (Class<?>) NMRewardVideoActivity.class);
                    intent.putExtra("extra_name_land_page_ad_data", a4TApA.f3187AYUAbz.copy());
                    a4TApA.f2769ExjC7D.startActivity(intent);
                    int i4 = AZOQYO.f3039AcNBzu;
                    break;
                }
        }
    }
}
