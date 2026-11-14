package LLiCI0;

import androidx.viewpager2.widget.ViewPager2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends ViewPager2.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f4677A2egSU;

    public ADYaiT(AMqCpz aMqCpz) {
        this.f4677A2egSU = aMqCpz;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A2egSU(int i) {
        AMqCpz aMqCpz = this.f4677A2egSU;
        if (i == 1) {
            A4TApA a4TApA = aMqCpz.f4680AmA8tU;
            a4TApA.f4675ADYaiT = false;
            a4TApA.f4673A4TApA.removeCallbacks(a4TApA.f4676ARc23Z);
        } else if (i == 0) {
            aMqCpz.f4680AmA8tU.A2egSU();
        }
    }
}
