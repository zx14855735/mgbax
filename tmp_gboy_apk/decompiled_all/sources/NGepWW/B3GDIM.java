package NGepWW;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM implements ThreadFactory {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AtomicInteger f5691A4TApA = new AtomicInteger();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ThreadFactory f5692A5SV6n = Executors.defaultThreadFactory();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f5690A2egSU = "GAC_Executor";

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f5692A5SV6n.newThread(new HXc4pW.A2egSU(1, runnable));
        int andIncrement = this.f5691A4TApA.getAndIncrement();
        String str = this.f5690A2egSU;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
