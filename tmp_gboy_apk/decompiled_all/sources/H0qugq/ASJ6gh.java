package H0qugq;

import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.utils.jni_interface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements jni_interface.Callback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ SAAllianceAdData f3173A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f3174A4TApA;

    public ASJ6gh(AZOQYO azoqyo, SAAllianceAdData sAAllianceAdData) {
        this.f3174A4TApA = azoqyo;
        this.f3173A2egSU = sAAllianceAdData;
    }

    @Override // com.alliance.ssp.ad.utils.jni_interface.Callback
    public final void onEvent(String str) {
        this.f3174A4TApA.f3247DvK7DB = str;
        SAAllianceAdData sAAllianceAdData = this.f3173A2egSU;
        if (sAAllianceAdData != null) {
            sAAllianceAdData.setDpres(str);
        }
    }
}
