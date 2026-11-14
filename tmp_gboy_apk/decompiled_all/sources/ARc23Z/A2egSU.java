package ARc23Z;

import android.graphics.drawable.Animatable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends com.bumptech.glide.A5SV6n {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final /* synthetic */ int f274B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Animatable f275B7CMnp;

    public /* synthetic */ A2egSU(Animatable animatable, int i) {
        this.f274B4ZgIw = i;
        this.f275B7CMnp = animatable;
    }

    @Override // com.bumptech.glide.A5SV6n
    public final void DV2E8K() {
        switch (this.f274B4ZgIw) {
            case 0:
                this.f275B7CMnp.start();
                break;
            default:
                ((DcUJf1.ARc23Z) this.f275B7CMnp).start();
                break;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final void DXnQ0V() {
        switch (this.f274B4ZgIw) {
            case 0:
                this.f275B7CMnp.stop();
                break;
            default:
                ((DcUJf1.ARc23Z) this.f275B7CMnp).stop();
                break;
        }
    }
}
