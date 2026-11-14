package QFcQI0;

import com.sigmob.windad.Splash.WindSplashAD;
import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7458AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ WindSplashAD f7459AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ WindAdError f7460AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ String f7461AzWtSf;

    public /* synthetic */ A2egSU(WindSplashAD windSplashAD, WindAdError windAdError, String str, int i) {
        this.f7458AcNBzu = i;
        this.f7459AlLFFp = windSplashAD;
        this.f7460AmA8tU = windAdError;
        this.f7461AzWtSf = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7458AcNBzu) {
            case 0:
                this.f7459AlLFFp.b(this.f7460AmA8tU, this.f7461AzWtSf);
                break;
            case 1:
                this.f7459AlLFFp.c(this.f7460AmA8tU, this.f7461AzWtSf);
                break;
            default:
                this.f7459AlLFFp.d(this.f7460AmA8tU, this.f7461AzWtSf);
                break;
        }
    }
}
