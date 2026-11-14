package FZu94u;

import EY4UKY.ADYaiT;
import android.content.Context;
import com.alliance.ssp.ad.bean.RewardInfo;
import com.sigmob.sdk.nativead.y;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa.aaaaaaa0;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaao;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2757AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f2758AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f2759AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f2760AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ Object f2761B25kr6;

    public /* synthetic */ A2egSU(aaaaaaa0 aaaaaaa0Var, Context context, int i, aaaaaaao.aaaaaaaa[] aaaaaaaaVarArr) {
        this.f2757AcNBzu = 2;
        this.f2759AmA8tU = aaaaaaa0Var;
        this.f2760AzWtSf = context;
        this.f2758AlLFFp = i;
        this.f2761B25kr6 = aaaaaaaaVarArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECyGFg.A4TApA a4TApA;
        switch (this.f2757AcNBzu) {
            case 0:
                A4TApA a4TApA2 = (A4TApA) this.f2759AmA8tU;
                int i = this.f2758AlLFFp;
                RewardInfo rewardInfo = (RewardInfo) this.f2760AzWtSf;
                Runnable runnable = (Runnable) this.f2761B25kr6;
                a4TApA2.getClass();
                synchronized (HHLj6Q.A4TApA.f3357A5SV6n) {
                    try {
                        try {
                            HHLj6Q.A4TApA a4TApA3 = a4TApA2.f2768EwN40Z;
                            if (a4TApA3 != null && (a4TApA = a4TApA3.f3358A4TApA) != null) {
                                if (i == 0) {
                                    a4TApA.onAdShow();
                                } else if (i == 1) {
                                    a4TApA.onAdClose();
                                } else if (i == 2) {
                                    a4TApA.onVideoComplete();
                                } else if (i == 3) {
                                    a4TApA.onVideoError();
                                } else if (i != 4) {
                                    if (i == 5) {
                                        a4TApA2.f2789GJee0v = false;
                                        a4TApA.onRewardVerify(rewardInfo);
                                        a4TApA2.f3187AYUAbz.setRewardValid(a4TApA2.f2788GIl1rw);
                                        new ADYaiT().B3GDIM(3, 0, a4TApA2.f3187AYUAbz, a4TApA2.f3200B9tovu, "");
                                    }
                                } else if (a4TApA2.f2785GEYgCP != 1) {
                                    a4TApA.onAdClick();
                                    a4TApA2.DXnQ0V();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (Exception unused) {
                    }
                }
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 1:
                ((y) this.f2759AmA8tU).a(this.f2758AlLFFp, (List) this.f2760AzWtSf, (String) this.f2761B25kr6);
                return;
            case 2:
                ((aaaaaaa0) this.f2759AmA8tU).aaaaaaa0((Context) this.f2760AzWtSf, this.f2758AlLFFp, (aaaaaaao.aaaaaaaa[]) this.f2761B25kr6);
                return;
            case 3:
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaa0) this.f2759AmA8tU).aaaaaaao(this.f2758AlLFFp, (String) this.f2760AzWtSf, (JSONArray) this.f2761B25kr6);
                return;
            default:
                ((aaaaaaaa) this.f2759AmA8tU).aaaaaaao(this.f2758AlLFFp, (String) this.f2760AzWtSf, (JSONArray) this.f2761B25kr6);
                return;
        }
    }

    public /* synthetic */ A2egSU(Object obj, int i, Object obj2, Object obj3, int i2) {
        this.f2757AcNBzu = i2;
        this.f2759AmA8tU = obj;
        this.f2758AlLFFp = i;
        this.f2760AzWtSf = obj2;
        this.f2761B25kr6 = obj3;
    }
}
