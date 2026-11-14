package DaOi9o;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.base.adapter.AdViewMixNativeAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.manager.loader.BaseLoader;
import com.fl.saas.base.widget.YdCommonDialog;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.common.widget.h5.SignUrlWebView;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.manager.b;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.c;
import com.sigmob.sdk.mraid.f;
import com.sigmob.sdk.mraid.k;
import com.sigmob.sdk.mraid.m;
import com.sigmob.sdk.videoAd.l;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import com.sigmob.windad.rewardVideo.WindRewardVideoAd;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AYUAbz implements C2rE4F.ADYaiT, Fyurov.B3GDIM, Supplier, AmA8tU.A2egSU, YdCommonDialog.OnSubmitListener, ae.a, m.a, l {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2219AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2220AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f2221AmA8tU;

    public /* synthetic */ AYUAbz(Object obj, int i, Object obj2) {
        this.f2219AcNBzu = i;
        this.f2220AlLFFp = obj;
        this.f2221AmA8tU = obj2;
    }

    @Override // Fyurov.B3GDIM
    public void A2egSU(final double d, final double d2) {
        Fyurov.ASJ6gh aSJ6gh;
        Fyurov.ASJ6gh aSJ6gh2;
        int i = 2;
        Object obj = this.f2220AlLFFp;
        Object obj2 = this.f2221AmA8tU;
        int i2 = 1;
        int i3 = 0;
        switch (this.f2219AcNBzu) {
            case 1:
                View view = (View) obj2;
                FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) obj;
                aZkASS.getClass();
                try {
                    if (aZkASS.f2720GTPRn3 > 0.0f && aZkASS.f2703FM663C != null) {
                        GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new FSFw2u.A4TApA(aZkASS, d2, i));
                    }
                    if (!aZkASS.f2753IhMMDv && d > 0.0d && (aSJ6gh = aZkASS.f2738HZUvgL) != null) {
                        aZkASS.f2753IhMMDv = true;
                        aSJ6gh.ADYaiT();
                    }
                    GJee0v.AZkASS aZkASS2 = GJee0v.AZkASS.f3040ADYaiT;
                    aZkASS2.f3043A5SV6n.post(new FSFw2u.A4TApA(aZkASS, d, i3));
                    float f = aZkASS.f2720GTPRn3;
                    Handler handler = aZkASS2.f3043A5SV6n;
                    if (f > 0.0f && d >= f) {
                        int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                        if (aZkASS.f2693EicXu4 != null) {
                            aZkASS.DuwtYk(2, null);
                            aZkASS.f3242DdagTj = true;
                            Context A4TApA2 = GJee0v.A2egSU.A4TApA(aZkASS.f3185ARc23Z);
                            if (A4TApA2 != null) {
                                if (A4TApA2 instanceof Activity) {
                                    ((Activity) A4TApA2).setRequestedOrientation(aZkASS.f2721GYpKKt);
                                } else {
                                    Activity A5SV6n2 = GJee0v.A2egSU.A5SV6n();
                                    if (A5SV6n2 != null) {
                                        A5SV6n2.setRequestedOrientation(aZkASS.f2721GYpKKt);
                                    }
                                }
                            }
                            handler.post(new FSFw2u.A5SV6n(aZkASS, 0));
                            handler.post(new FSFw2u.A4TApA(aZkASS, d, i2));
                            aZkASS.Dphsd2();
                            aZkASS.CtxOCS();
                            break;
                        }
                    } else {
                        float f2 = aZkASS.f3202BI9f7h;
                        if (f2 > 0.0f && ((float) d) == f2 && aZkASS.BniPrB()) {
                            handler.post(new ADYaiT.BChYOn(aZkASS, 5, view));
                            if (aZkASS.EH1KK8("unuser", 0, false)) {
                                aZkASS.f3203BIYEnU = true;
                                aZkASS.BV3sI0();
                                HFjH17.ADYaiT aDYaiT = aZkASS.f2745I3bnmY;
                                if (aDYaiT != null && !aZkASS.f2729HFjH17 && aZkASS.f2724GnQT2j != 1 && aDYaiT.AcNBzu()) {
                                    aZkASS.CTkVKb(aZkASS.f3187AYUAbz);
                                    break;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMInterstitialAdImpl 009: "), new EY4UKY.ADYaiT(), "004", e);
                    return;
                }
                break;
            default:
                View view2 = (View) obj2;
                final FdMWEC.AZkASS aZkASS3 = (FdMWEC.AZkASS) obj;
                aZkASS3.getClass();
                try {
                    GJee0v.AZkASS aZkASS4 = GJee0v.AZkASS.f3040ADYaiT;
                    aZkASS4.f3043A5SV6n.post(new Runnable() { // from class: FdMWEC.A5SV6n
                        @Override // java.lang.Runnable
                        public final void run() {
                            AZkASS aZkASS5 = AZkASS.this;
                            TextView textView = aZkASS5.f2819FOAO9d;
                            double d3 = d2;
                            if (textView != null) {
                                StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("跳过 ");
                                AMqCpz.append(((int) d3) + 1);
                                textView.setText(AMqCpz.toString());
                            }
                            if (d >= 5000.0d || d3 <= 0.0d) {
                                GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new ADYaiT(aZkASS5, 0));
                                if (!aZkASS5.f2855HieBYM && aZkASS5.HHoABE != 0) {
                                    int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                                    aZkASS5.Dphsd2(1, null);
                                    aZkASS5.DdagTj();
                                } else {
                                    if (aZkASS5.HHoABE != 0 || aZkASS5.f2838GhvxjZ) {
                                        aZkASS5.f2859I3HV03 = true;
                                        return;
                                    }
                                    if (aZkASS5.f2865IQ76hF == 5) {
                                        aZkASS5.Dphsd2(1, null);
                                        aZkASS5.DdagTj();
                                    }
                                    aZkASS5.f2838GhvxjZ = true;
                                }
                            }
                        }
                    });
                    if (d >= 0.2d && (aSJ6gh2 = aZkASS3.f2821FZu94u) != null && !aZkASS3.f2858HwAeAU) {
                        aZkASS3.f2858HwAeAU = true;
                        aSJ6gh2.ADYaiT();
                    }
                    float f3 = aZkASS3.f3202BI9f7h;
                    if (f3 >= 0.0f && ((float) d) == f3 && aZkASS3.BniPrB()) {
                        aZkASS4.f3043A5SV6n.post(new ADYaiT.BChYOn(aZkASS3, 6, view2));
                        if (aZkASS3.EH1KK8("unuser", 0)) {
                            aZkASS3.f3203BIYEnU = true;
                            aZkASS3.BV3sI0();
                            break;
                        }
                    }
                } catch (Exception e2) {
                    CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMSplashAdImpl 004: "), new EY4UKY.ADYaiT(), "004", e2);
                }
                break;
        }
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        AdapterAPI lambda$handleAdapterConfig$2;
        lambda$handleAdapterConfig$2 = ((BaseLoader) this.f2220AlLFFp).lambda$handleAdapterConfig$2((AdapterAPI) this.f2221AmA8tU, (Context) obj);
        return lambda$handleAdapterConfig$2;
    }

    @Override // com.fl.saas.common.util.feature.Supplier
    public Object get() {
        Integer lambda$onNativeAdLoaded$3;
        lambda$onNativeAdLoaded$3 = ((AdViewMixNativeAdapter) this.f2220AlLFFp).lambda$onNativeAdLoaded$3((NativeAd) this.f2221AmA8tU);
        return lambda$onNativeAdLoaded$3;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public void onAddExtra(Object obj) {
        switch (this.f2219AcNBzu) {
            case 6:
                b.a((String) this.f2220AlLFFp, (BaseAdUnit) this.f2221AmA8tU, obj);
                break;
            case 7:
                ((b) this.f2220AlLFFp).a((BaseAdUnit) this.f2221AmA8tU, obj);
                break;
            default:
                a.a((JSONObject) this.f2220AlLFFp, (BaseAdUnit) this.f2221AmA8tU, obj);
                break;
        }
    }

    @Override // C2rE4F.ADYaiT
    public void onCancel() {
        ((B4ZgIw) this.f2220AlLFFp).cancel();
        ((androidx.fragment.app.AYUAbz) this.f2221AmA8tU).run();
    }

    @Override // com.fl.saas.base.widget.YdCommonDialog.OnSubmitListener
    public void onClick() {
        ((SignUrlWebView) this.f2220AlLFFp).lambda$startThirdPartyApp$0((Uri) this.f2221AmA8tU);
    }

    @Override // com.sigmob.sdk.mraid.m.a
    public void onFailure(f fVar) {
        ((c) this.f2220AlLFFp).a((k) this.f2221AmA8tU, fVar);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onVideoAdRewarded(WindRewardInfo windRewardInfo, String str) {
        ((WindRewardVideoAd) this.f2220AlLFFp).a((l) this.f2221AmA8tU, windRewardInfo, str);
    }
}
