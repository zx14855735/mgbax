package NGepWW;

import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Dphsd2 implements NSK3xo.AZkASS, NSK3xo.AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DuwtYk f5752A2egSU;

    public Dphsd2(DuwtYk duwtYk) {
        this.f5752A2egSU = duwtYk;
    }

    @Override // NSK3xo.AZkASS
    public final void A2egSU(Bundle bundle) {
        DuwtYk duwtYk = this.f5752A2egSU;
        duwtYk.f5763BChYOn.AlLFFp(new DjONCG(duwtYk));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        r0.AaHO0E();
        r0.AZOQYO();
     */
    @Override // NSK3xo.AaHO0E
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A4TApA(NOd7IU.A2egSU r6) {
        /*
            r5 = this;
            NGepWW.DuwtYk r0 = r5.f5752A2egSU
            java.util.concurrent.locks.ReentrantLock r1 = r0.f5754AlLFFp
            java.util.concurrent.locks.ReentrantLock r2 = r0.f5754AlLFFp
            r1.lock()
            int r1 = r0.f5764BI9f7h     // Catch: java.lang.Throwable -> L18
            r3 = 2
            r4 = 1
            if (r1 == r3) goto L1b
            if (r1 != r4) goto L1a
            boolean r1 = r6.A4TApA()     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1a
            goto L1b
        L18:
            r6 = move-exception
            goto L2b
        L1a:
            r4 = 0
        L1b:
            if (r4 == 0) goto L24
            r0.AaHO0E()     // Catch: java.lang.Throwable -> L18
            r0.AZOQYO()     // Catch: java.lang.Throwable -> L18
            goto L27
        L24:
            r0.ASJ6gh(r6)     // Catch: java.lang.Throwable -> L18
        L27:
            r2.unlock()
            return
        L2b:
            r2.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: NGepWW.Dphsd2.A4TApA(NOd7IU.A2egSU):void");
    }

    @Override // NSK3xo.AZkASS
    public final void a(int i) {
    }
}
