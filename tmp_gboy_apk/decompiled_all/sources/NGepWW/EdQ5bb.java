package NGepWW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class EdQ5bb implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5819AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final EdhSi6 f5820AlLFFp;

    public /* synthetic */ EdQ5bb(EdhSi6 edhSi6, int i) {
        this.f5819AcNBzu = i;
        this.f5820AlLFFp = edhSi6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5819AcNBzu) {
            case 0:
                this.f5820AlLFFp.ASJ6gh();
                break;
            default:
                this.f5820AlLFFp.AYUAbz();
                break;
        }
    }
}
