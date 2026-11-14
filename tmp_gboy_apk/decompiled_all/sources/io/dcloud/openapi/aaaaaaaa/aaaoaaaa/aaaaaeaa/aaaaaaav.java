package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaav implements aaaaoaaa {
    private final aaaaoaaa aaaaaaaa;

    public aaaaaaav(aaaaoaaa aaaaoaaaVar) {
        if (aaaaoaaaVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.aaaaaaaa = aaaaoaaaVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public aaaaaoaa aaaaaaa0() {
        return this.aaaaaaaa.aaaaaaa0();
    }

    public final aaaaoaaa aaaaaaeo() {
        return this.aaaaaaaa;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.aaaaaaaa.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.aaaaaaaa.toString() + ")";
    }
}
