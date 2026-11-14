package FSFw2u;

import android.app.Activity;
import android.view.View;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialFullScreenView;
import com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.DownloadTipDialog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AMqCpz implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2679AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2680AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f2681AmA8tU;

    public /* synthetic */ AMqCpz(Object obj, int i, Object obj2) {
        this.f2679AcNBzu = i;
        this.f2681AmA8tU = obj;
        this.f2680AlLFFp = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj = this.f2680AlLFFp;
        Object obj2 = this.f2681AmA8tU;
        switch (this.f2679AcNBzu) {
            case 0:
                AZkASS aZkASS = (AZkASS) obj2;
                if (aZkASS.f3202BI9f7h <= 0.0f && aZkASS.BniPrB()) {
                    if (aZkASS.f2731HHLj6Q == 1) {
                        aZkASS.B2KMhB(aZkASS.f2704FOAO9d, null);
                    } else {
                        aZkASS.B2KMhB((View) obj, null);
                    }
                    if (aZkASS.EH1KK8("close_button", 0, false)) {
                        aZkASS.f3203BIYEnU = true;
                        aZkASS.BV3sI0();
                        if (aZkASS.f2724GnQT2j != 1) {
                            aZkASS.DaOi9o();
                            break;
                        }
                    }
                }
                aZkASS.DaOi9o();
                aZkASS.Dphsd2();
                Activity A5SV6n2 = GJee0v.A2egSU.A5SV6n();
                HH6JFw.A5SV6n a5SV6n = aZkASS.f2715GGG1xW;
                if (a5SV6n != null && a5SV6n.isShowing() && A5SV6n2 != null && !A5SV6n2.isFinishing()) {
                    aZkASS.f2715GGG1xW.dismiss();
                }
                if (A5SV6n2 != null) {
                    A5SV6n2.setRequestedOrientation(aZkASS.f2721GYpKKt);
                }
                aZkASS.DuwtYk(2, null);
                aZkASS.CtxOCS();
                break;
            case 1:
                FdMWEC.AZkASS aZkASS2 = (FdMWEC.AZkASS) obj2;
                aZkASS2.getClass();
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                if (aZkASS2.f3202BI9f7h <= 0.0f && aZkASS2.BniPrB()) {
                    if (aZkASS2.f2842H1wUHe == 1) {
                        aZkASS2.B2KMhB(aZkASS2.f2808EicXu4, "1");
                    } else {
                        aZkASS2.B2KMhB((View) obj, null);
                    }
                    if (aZkASS2.EH1KK8("close_button", 0)) {
                        aZkASS2.f3203BIYEnU = true;
                        aZkASS2.BV3sI0();
                        break;
                    }
                }
                aZkASS2.DdagTj();
                aZkASS2.Dphsd2(0, null);
                aZkASS2.DaOi9o();
                new EY4UKY.ADYaiT().B3GDIM(1, 1, aZkASS2.f3187AYUAbz, aZkASS2.f3200B9tovu, "");
                aZkASS2.Cd8JRx(aZkASS2.f3187AYUAbz);
                break;
            case 2:
                ((InterstitialFullScreenView) obj2).lambda$setMediaView$5((VideoSoundControlListener) obj, view);
                break;
            default:
                ((DownloadTipDialog) obj2).lambda$new$0((AdInfoPoJo) obj, view);
                break;
        }
    }
}
