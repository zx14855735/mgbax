package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 extends AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f8667A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f8668A4TApA;

    public B25kr6(AlLFFp alLFFp, ThreadPoolExecutor threadPoolExecutor) {
        this.f8667A2egSU = alLFFp;
        this.f8668A4TApA = threadPoolExecutor;
    }

    @Override // androidx.emoji2.text.AlLFFp
    public final void A2egSU(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f8668A4TApA;
        try {
            this.f8667A2egSU.A2egSU(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // androidx.emoji2.text.AlLFFp
    public final void A4TApA(AZOQYO.ARc23Z aRc23Z) {
        ThreadPoolExecutor threadPoolExecutor = this.f8668A4TApA;
        try {
            this.f8667A2egSU.A4TApA(aRc23Z);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
