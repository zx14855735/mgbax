package androidx.fragment.app;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BChYOn implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f8766AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Fragment f8767AlLFFp;

    public /* synthetic */ BChYOn(Fragment fragment, int i) {
        this.f8766AcNBzu = i;
        this.f8767AlLFFp = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8766AcNBzu) {
            case 0:
                this.f8767AlLFFp.startPostponedEnterTransition();
                break;
            default:
                this.f8767AlLFFp.callStartTransitionListener(false);
                break;
        }
    }
}
