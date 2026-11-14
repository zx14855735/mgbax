package H0qugq;

import android.app.Activity;
import android.os.Handler;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.HttpUtils;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3156AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f3157AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f3158AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f3159AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ Object f3160B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ Object f3161B2KMhB;

    public /* synthetic */ A4TApA(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.f3156AcNBzu = i;
        this.f3157AlLFFp = obj;
        this.f3158AmA8tU = obj2;
        this.f3159AzWtSf = obj3;
        this.f3160B25kr6 = obj4;
        this.f3161B2KMhB = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3156AcNBzu) {
            case 0:
                ((AZOQYO) this.f3157AlLFFp).B25kr6((Activity) this.f3158AmA8tU, (Material) this.f3159AzWtSf, (SAAllianceAdData) this.f3160B25kr6, (Handler) this.f3161B2KMhB);
                break;
            default:
                ((HttpUtils) this.f3157AlLFFp).lambda$doPost$3((String) this.f3158AmA8tU, (Map) this.f3159AzWtSf, (String) this.f3160B25kr6, (HttpCallbackStringListener) this.f3161B2KMhB);
                break;
        }
    }
}
