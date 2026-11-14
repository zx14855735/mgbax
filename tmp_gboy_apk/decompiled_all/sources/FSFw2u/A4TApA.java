package FSFw2u;

import android.widget.FrameLayout;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2673AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2674AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ double f2675AmA8tU;

    public /* synthetic */ A4TApA(Object obj, double d, int i) {
        this.f2673AcNBzu = i;
        this.f2674AlLFFp = obj;
        this.f2675AmA8tU = d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        double d = this.f2675AmA8tU;
        Object obj = this.f2674AlLFFp;
        switch (this.f2673AcNBzu) {
            case 0:
                AZkASS aZkASS = (AZkASS) obj;
                if (d < 3.0d) {
                    aZkASS.getClass();
                    break;
                } else {
                    FrameLayout frameLayout = aZkASS.f2695ErKPGd;
                    if (frameLayout != null && aZkASS.f2705FSFw2u != null && aZkASS.f2727H1wUHe == 1 && aZkASS.f2730HH6JFw) {
                        frameLayout.setVisibility(8);
                        aZkASS.f2705FSFw2u.setVisibility(0);
                        break;
                    }
                }
                break;
            case 1:
                AZkASS aZkASS2 = (AZkASS) obj;
                if (d < 3.0d) {
                    aZkASS2.getClass();
                    break;
                } else {
                    FrameLayout frameLayout2 = aZkASS2.f2695ErKPGd;
                    if (frameLayout2 != null && aZkASS2.f2705FSFw2u != null && aZkASS2.f2727H1wUHe == 1 && aZkASS2.f2730HH6JFw) {
                        frameLayout2.setVisibility(8);
                        aZkASS2.f2705FSFw2u.setVisibility(0);
                        break;
                    }
                }
                break;
            case 2:
                ((AZkASS) obj).f2703FM663C.setText((((int) d) + 1) + " | 关闭");
                break;
            default:
                NMRewardVideoActivity nMRewardVideoActivity = (NMRewardVideoActivity) obj;
                if (d < 3.0d) {
                    FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                    break;
                } else {
                    FrameLayout frameLayout3 = nMRewardVideoActivity.f9632BmvVmW;
                    if (frameLayout3 != null && nMRewardVideoActivity.f9624BChYOn != null && nMRewardVideoActivity.Ddcejp && !nMRewardVideoActivity.f9665DdagTj) {
                        frameLayout3.setVisibility(8);
                        nMRewardVideoActivity.f9624BChYOn.setVisibility(0);
                        break;
                    }
                }
                break;
        }
    }
}
