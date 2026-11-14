package Fyurov;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AmA8tU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2951AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ B2KMhB f2952AlLFFp;

    public /* synthetic */ AmA8tU(B2KMhB b2KMhB, int i) {
        this.f2951AcNBzu = i;
        this.f2952AlLFFp = b2KMhB;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2951AcNBzu) {
            case 0:
                this.f2952AlLFFp.f2968AZkASS.resume();
                break;
            case 1:
                this.f2952AlLFFp.f2968AZkASS.cancel();
                break;
            default:
                this.f2952AlLFFp.f2968AZkASS.pause();
                break;
        }
    }
}
