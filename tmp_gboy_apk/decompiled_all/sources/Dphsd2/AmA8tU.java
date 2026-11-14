package Dphsd2;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU implements GnQT2j.AaHO0E {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2462AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ImageView f2463AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ NMRewardVideoActivity f2464AmA8tU;

    public /* synthetic */ AmA8tU(NMRewardVideoActivity nMRewardVideoActivity, ImageView imageView, int i) {
        this.f2462AcNBzu = i;
        this.f2464AmA8tU = nMRewardVideoActivity;
        this.f2463AlLFFp = imageView;
    }

    private final void A2egSU(Exception exc) {
    }

    private final void A4TApA(Exception exc) {
    }

    @Override // GnQT2j.AaHO0E
    public final void a(Exception exc) {
        int i = this.f2462AcNBzu;
    }

    @Override // GnQT2j.AaHO0E
    public final void a(Bitmap bitmap) {
        switch (this.f2462AcNBzu) {
            case 0:
                this.f2464AmA8tU.runOnUiThread(new AlLFFp(0, this, this.f2463AlLFFp, bitmap));
                break;
            default:
                this.f2464AmA8tU.runOnUiThread(new AlLFFp(1, this, this.f2463AlLFFp, bitmap));
                break;
        }
    }
}
