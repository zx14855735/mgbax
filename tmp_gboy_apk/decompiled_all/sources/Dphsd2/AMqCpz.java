package Dphsd2;

import ADYaiT.CtFAbx;
import android.webkit.WebView;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;
import com.sigmob.sdk.videoAd.l;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import com.sigmob.windad.rewardVideo.WindRewardVideoAd;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2435AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f2436AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f2437AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f2438AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ Object f2439B25kr6;

    public /* synthetic */ AMqCpz(AppInfoViewActivity appInfoViewActivity, String str, WebView webView, String str2) {
        this.f2437AmA8tU = appInfoViewActivity;
        this.f2436AlLFFp = str;
        this.f2439B25kr6 = webView;
        this.f2438AzWtSf = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f2436AlLFFp;
        Object obj = this.f2439B25kr6;
        Object obj2 = this.f2438AzWtSf;
        Object obj3 = this.f2437AmA8tU;
        switch (this.f2435AcNBzu) {
            case 0:
                H0qugq.AZOQYO azoqyo = AppInfoViewActivity.f9605B2KMhB;
                AppInfoViewActivity appInfoViewActivity = (AppInfoViewActivity) obj3;
                appInfoViewActivity.getClass();
                WebView webView = (WebView) obj;
                String str2 = (String) obj2;
                if (str == null || str.isEmpty() || appInfoViewActivity.f9608AlLFFp != 0) {
                    webView.loadUrl(str2);
                    break;
                } else {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("X-Requested-With", URLEncoder.encode(str, "UTF-8"));
                        webView.loadUrl(str2, hashMap);
                        break;
                    } catch (Exception e) {
                        CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("AppInfoViewActivity 001: "), new EY4UKY.ADYaiT(), "004", e);
                        return;
                    }
                }
                break;
            default:
                ((WindRewardVideoAd) obj3).a((WindRewardInfo) obj2, (l) obj, str);
                break;
        }
    }

    public /* synthetic */ AMqCpz(l lVar, WindRewardInfo windRewardInfo, WindRewardVideoAd windRewardVideoAd, String str) {
        this.f2437AmA8tU = windRewardVideoAd;
        this.f2438AzWtSf = windRewardInfo;
        this.f2439B25kr6 = lVar;
        this.f2436AlLFFp = str;
    }
}
