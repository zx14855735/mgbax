package AcNBzu;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements ThreadFactory {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f938A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AtomicInteger f939A4TApA;

    public A4TApA(int i) {
        this.f938A2egSU = i;
        switch (i) {
            case 1:
                this.f939A4TApA = new AtomicInteger(1);
                break;
            case 2:
                this.f939A4TApA = new AtomicInteger(1);
                break;
            default:
                this.f939A4TApA = new AtomicInteger(0);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f938A2egSU) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + this.f939A4TApA.getAndIncrement());
                return thread;
            case 1:
                Thread thread2 = new Thread(runnable, "DownloadThread-" + this.f939A4TApA.getAndIncrement());
                thread2.setPriority(1);
                return thread2;
            default:
                return new Thread(runnable, "ModernAsyncTask #" + this.f939A4TApA.getAndIncrement());
        }
    }
}
