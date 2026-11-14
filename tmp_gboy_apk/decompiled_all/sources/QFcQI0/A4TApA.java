package QFcQI0;

import com.sigmob.windad.Splash.WindSplashAD;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7462AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ WindSplashAD f7463AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f7464AmA8tU;

    public /* synthetic */ A4TApA(WindSplashAD windSplashAD, String str, int i) {
        this.f7462AcNBzu = i;
        this.f7463AlLFFp = windSplashAD;
        this.f7464AmA8tU = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7462AcNBzu) {
            case 0:
                this.f7463AlLFFp.b(this.f7464AmA8tU);
                break;
            case 1:
                this.f7463AlLFFp.c(this.f7464AmA8tU);
                break;
            default:
                this.f7463AlLFFp.a(this.f7464AmA8tU);
                break;
        }
    }
}
