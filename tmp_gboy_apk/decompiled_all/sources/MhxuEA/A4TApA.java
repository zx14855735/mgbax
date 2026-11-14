package MhxuEA;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements ThreadFactory {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f5348A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AtomicInteger f5349A4TApA = new AtomicInteger(1);

    public A4TApA(String str) {
        this.f5348A2egSU = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f5348A2egSU + "-" + this.f5349A4TApA.getAndIncrement());
        thread.setDaemon(true);
        return thread;
    }
}
