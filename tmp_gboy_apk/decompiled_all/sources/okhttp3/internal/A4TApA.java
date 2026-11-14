package okhttp3.internal;

import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class A4TApA implements Runnable {
    protected final String name;

    public A4TApA(String str, Object... objArr) {
        byte[] bArr = A5SV6n.EMPTY_BYTE_ARRAY;
        this.name = String.format(Locale.US, str, objArr);
    }

    public abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
