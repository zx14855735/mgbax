package Dphsd2;

import android.view.View;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2465AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ SAAllianceWebViewActivity f2466AlLFFp;

    public /* synthetic */ B2KMhB(SAAllianceWebViewActivity sAAllianceWebViewActivity, int i) {
        this.f2465AcNBzu = i;
        this.f2466AlLFFp = sAAllianceWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2465AcNBzu) {
            case 0:
                SAAllianceWebViewActivity sAAllianceWebViewActivity = this.f2466AlLFFp;
                if (!sAAllianceWebViewActivity.f9691AzWtSf.canGoBack()) {
                    sAAllianceWebViewActivity.finish();
                    break;
                } else {
                    sAAllianceWebViewActivity.f9691AzWtSf.goBack();
                    break;
                }
            default:
                this.f2466AlLFFp.finish();
                break;
        }
    }
}
