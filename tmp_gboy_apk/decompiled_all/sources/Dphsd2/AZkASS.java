package Dphsd2;

import android.view.ViewTreeObserver;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.google.android.material.slider.Slider;
import com.sigmob.sdk.base.utils.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AZkASS implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2453AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2454AlLFFp;

    public /* synthetic */ AZkASS(int i, Object obj) {
        this.f2453AcNBzu = i;
        this.f2454AlLFFp = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f2453AcNBzu) {
            case 0:
                int[] iArr = new int[2];
                ((NMRewardVideoActivity) this.f2454AlLFFp).f9647CqNSpT.getLocationOnScreen(iArr);
                FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                if (a4TApA != null) {
                    int i = iArr[0];
                    int i2 = iArr[1];
                    a4TApA.f3234DAk1zC = NOd7IU.AlLFFp.ASJ6gh(i, "");
                    a4TApA.f3235DG07BK = NOd7IU.AlLFFp.ASJ6gh(i2, "");
                    StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
                    AMqCpz.append(NOd7IU.AlLFFp.AMqCpz(a4TApA.f2769ExjC7D, 52.0f));
                    a4TApA.f3236DRlcZ9 = AMqCpz.toString();
                    StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
                    AMqCpz2.append(NOd7IU.AlLFFp.AMqCpz(a4TApA.f2769ExjC7D, 28.0f));
                    a4TApA.f3237DUi7mC = AMqCpz2.toString();
                    break;
                }
                break;
            case 1:
                ((Slider) this.f2454AlLFFp).BV3sI0();
                break;
            default:
                ((a) this.f2454AlLFFp).a();
                break;
        }
    }
}
