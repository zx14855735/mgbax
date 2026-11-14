package Dphsd2;

import android.widget.ImageView;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AZOQYO implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2449AcNBzu = 1;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ NMRewardVideoActivity f2450AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ ImageView f2451AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ String f2452AzWtSf;

    public /* synthetic */ AZOQYO(NMRewardVideoActivity nMRewardVideoActivity, ImageView imageView, String str) {
        this.f2450AlLFFp = nMRewardVideoActivity;
        this.f2451AmA8tU = imageView;
        this.f2452AzWtSf = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView = this.f2451AmA8tU;
        String str = this.f2452AzWtSf;
        NMRewardVideoActivity nMRewardVideoActivity = this.f2450AlLFFp;
        switch (this.f2449AcNBzu) {
            case 0:
                FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                if (!str.endsWith(".gif")) {
                    GnQT2j.AcNBzu.A2egSU().A4TApA(str, new AmA8tU(nMRewardVideoActivity, imageView, 1));
                    break;
                } else {
                    nMRewardVideoActivity.runOnUiThread(new AZOQYO(nMRewardVideoActivity, imageView, str));
                    break;
                }
            default:
                FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                nMRewardVideoActivity.A5SV6n(imageView, str);
                break;
        }
    }

    public /* synthetic */ AZOQYO(NMRewardVideoActivity nMRewardVideoActivity, String str, ImageView imageView) {
        this.f2450AlLFFp = nMRewardVideoActivity;
        this.f2452AzWtSf = str;
        this.f2451AmA8tU = imageView;
    }
}
