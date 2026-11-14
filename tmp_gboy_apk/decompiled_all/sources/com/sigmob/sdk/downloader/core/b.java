package com.sigmob.sdk.downloader.core;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected final String f13344a;

    public b(String str) {
        this.f13344a = str;
    }

    public abstract void a();

    public abstract void a(InterruptedException interruptedException);

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f13344a);
        try {
            a();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            a(e);
        } finally {
            Thread.currentThread().setName(name);
            b();
        }
    }
}
