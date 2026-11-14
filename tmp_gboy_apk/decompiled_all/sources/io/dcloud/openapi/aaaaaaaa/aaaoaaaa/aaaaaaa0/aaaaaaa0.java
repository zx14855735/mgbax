package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaa0 implements Runnable {
    protected final String aaaaaaaa;

    public aaaaaaa0(String str, Object... objArr) {
        this.aaaaaaaa = aaaaaaao.aaaaaaaa(str, objArr);
    }

    public abstract void aaaaaaa0();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.aaaaaaaa);
        try {
            aaaaaaa0();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
