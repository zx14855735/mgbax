package H0qugq;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3154AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f3155AlLFFp;

    public /* synthetic */ A2egSU(AZOQYO azoqyo, int i) {
        this.f3154AcNBzu = i;
        this.f3155AlLFFp = azoqyo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3154AcNBzu) {
            case 0:
                AZOQYO azoqyo = this.f3155AlLFFp;
                ((EGM26s.A5SV6n) azoqyo.f3188AZOQYO).onSplashAdLoad((EGM26s.A2egSU) azoqyo.AMqCpz.get(0));
                break;
            case 1:
                AZOQYO azoqyo2 = this.f3155AlLFFp;
                ((DvK7DB.A5SV6n) azoqyo2.f3188AZOQYO).onExpressFeedAdLoad(azoqyo2.AMqCpz);
                break;
            case 2:
                AZOQYO azoqyo3 = this.f3155AlLFFp;
                ((ECyGFg.A5SV6n) azoqyo3.f3188AZOQYO).onRewardVideoAdLoad((ECyGFg.A2egSU) azoqyo3.AMqCpz.get(0));
                break;
            case 3:
                AZOQYO azoqyo4 = this.f3155AlLFFp;
                ((DyaChj.A5SV6n) azoqyo4.f3188AZOQYO).onInterstitialAdLoad((DyaChj.A2egSU) azoqyo4.AMqCpz.get(0));
                break;
            case 4:
                this.f3155AlLFFp.f3188AZOQYO.onError(100006, "广告加载数据为空");
                break;
            default:
                this.f3155AlLFFp.f3188AZOQYO.onResourceLoad();
                break;
        }
    }
}
