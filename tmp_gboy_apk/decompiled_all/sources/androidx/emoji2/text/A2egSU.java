package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A2egSU implements ThreadFactory {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ String f8647A2egSU;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f8647A2egSU);
        thread.setPriority(10);
        return thread;
    }
}
