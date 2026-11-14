package androidx.activity;

import ADYaiT.CtFAbx;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class B7CMnp extends RXb0Sz.A4TApA implements Function0, RXb0Sz.AMqCpz, RiEDdo.A5SV6n {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f7968B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final /* synthetic */ int f7969B4ZgIw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B7CMnp(int i, Object obj) {
        super(obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", false);
        this.f7969B4ZgIw = i;
        this.f7968B3GDIM = 0;
    }

    @Override // RXb0Sz.A4TApA
    public final RiEDdo.A2egSU A4TApA() {
        RXb0Sz.AZOQYO.f7892A2egSU.getClass();
        return this;
    }

    @Override // RXb0Sz.A4TApA
    public final RiEDdo.A2egSU ADYaiT() {
        return (RiEDdo.A5SV6n) super.ADYaiT();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof B7CMnp) {
            B7CMnp b7CMnp = (B7CMnp) obj;
            return this.f7884AzWtSf.equals(b7CMnp.f7884AzWtSf) && this.f7885B25kr6.equals(b7CMnp.f7885B25kr6) && this.f7968B3GDIM == b7CMnp.f7968B3GDIM && RXb0Sz.ARc23Z.A2egSU(this.f7882AlLFFp, b7CMnp.f7882AlLFFp) && RXb0Sz.ARc23Z.A2egSU(A5SV6n(), b7CMnp.A5SV6n());
        }
        if (obj instanceof RiEDdo.A5SV6n) {
            return obj.equals(A2egSU());
        }
        return false;
    }

    @Override // RXb0Sz.AMqCpz
    public final int getArity() {
        return 0;
    }

    public final int hashCode() {
        return this.f7885B25kr6.hashCode() + com.bykv.vk.component.ttvideo.player.A2egSU.A2egSU(A5SV6n() == null ? 0 : A5SV6n().hashCode() * 31, 31, this.f7884AzWtSf);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f7969B4ZgIw) {
            case 0:
                ((OnBackPressedDispatcher) this.f7882AlLFFp).ADYaiT();
                break;
            default:
                ((OnBackPressedDispatcher) this.f7882AlLFFp).ADYaiT();
                break;
        }
        return R8Rbcg.AMqCpz.f7833A5SV6n;
    }

    public final String toString() {
        RiEDdo.A2egSU A2egSU2 = A2egSU();
        if (A2egSU2 != this) {
            return A2egSU2.toString();
        }
        String str = this.f7884AzWtSf;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : CtFAbx.BI9f7h("function ", str, " (Kotlin reflection is not available)");
    }
}
