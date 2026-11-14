package HieBYM;

import java.util.concurrent.ThreadFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements ThreadFactory {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f3705A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final boolean f3706A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f3707A5SV6n;

    public A4TApA(String str, boolean z) {
        this.f3705A2egSU = str;
        this.f3706A4TApA = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final synchronized Thread newThread(Runnable runnable) {
        A2egSU a2egSU;
        a2egSU = new A2egSU(this, runnable, "glide-" + this.f3705A2egSU + "-thread-" + this.f3707A5SV6n);
        this.f3707A5SV6n = this.f3707A5SV6n + 1;
        return a2egSU;
    }
}
