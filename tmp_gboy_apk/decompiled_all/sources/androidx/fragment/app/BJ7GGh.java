package androidx.fragment.app;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BJ7GGh implements AmA8tU.A2egSU, androidx.lifecycle.BV3sI0 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f8770AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f8771AlLFFp;

    public /* synthetic */ BJ7GGh(int i, Object obj) {
        this.f8770AcNBzu = i;
        this.f8771AlLFFp = obj;
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        switch (this.f8770AcNBzu) {
            case 0:
                Fragment fragment = (Fragment) this.f8771AlLFFp;
                Object obj2 = fragment.mHost;
                return obj2 instanceof androidx.activity.result.AYUAbz ? ((androidx.activity.result.AYUAbz) obj2).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
            default:
                return (androidx.activity.result.ASJ6gh) this.f8771AlLFFp;
        }
    }
}
