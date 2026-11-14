package LHpdLt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4451AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f4452AlLFFp;

    public /* synthetic */ A2egSU(AZOQYO azoqyo, int i) {
        this.f4451AcNBzu = i;
        this.f4452AlLFFp = azoqyo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4451AcNBzu) {
            case 0:
                AZOQYO azoqyo = this.f4452AlLFFp;
                AZOQYO.A2egSU(azoqyo);
                AZOQYO.ADYaiT(azoqyo);
                azoqyo.AZOQYO();
                break;
            default:
                AZOQYO azoqyo2 = this.f4452AlLFFp;
                azoqyo2.AzWtSf();
                azoqyo2.f4481AcNBzu = azoqyo2.AMqCpz.getWidth();
                azoqyo2.f4482AlLFFp = azoqyo2.AMqCpz.getHeight();
                AZOQYO.ADYaiT(azoqyo2);
                break;
        }
    }
}
