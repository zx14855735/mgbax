package LlW7FF;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ String f4868AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f4869AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ boolean f4870AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh f4871AzWtSf;

    public A5SV6n(ASJ6gh aSJ6gh, String str, AMqCpz aMqCpz, boolean z) {
        this.f4871AzWtSf = aSJ6gh;
        this.f4868AcNBzu = str;
        this.f4869AlLFFp = aMqCpz;
        this.f4870AmA8tU = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ARc23Z aRc23Z = (ARc23Z) this.f4871AzWtSf.f4886ADYaiT.remove(this.f4868AcNBzu);
        if (aRc23Z == null || aRc23Z.f4880ADYaiT) {
            return;
        }
        aRc23Z.f4877A2egSU.cancel();
        aRc23Z.f4880ADYaiT = true;
        this.f4871AzWtSf.AZOQYO(this.f4869AlLFFp, "请求超时", this.f4870AmA8tU);
    }
}
