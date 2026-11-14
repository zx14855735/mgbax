package DjONCG;

import GnQT2j.ARc23Z;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.bean.SAAllianceAdData;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements DownloadListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public SAAllianceWebViewActivity f2422A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public SAAllianceAdData f2423A4TApA;

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(15, this);
        int i = ARc23Z.f3096A2egSU;
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        new GnQT2j.ADYaiT(str, this.f2422A2egSU, a5SV6n).start();
    }
}
