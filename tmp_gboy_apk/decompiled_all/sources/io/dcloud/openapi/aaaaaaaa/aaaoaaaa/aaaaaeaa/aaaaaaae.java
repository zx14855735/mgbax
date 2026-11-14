package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaae implements aaaoaaaa {
    private final aaaoaaaa aaaaaaaa;

    public aaaaaaae(aaaoaaaa aaaoaaaaVar) {
        if (aaaoaaaaVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.aaaaaaaa = aaaoaaaaVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
    public void aaaaaaa0(aaaaaaao aaaaaaaoVar, long j) {
        this.aaaaaaaa.aaaaaaa0(aaaaaaaoVar, j);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.aaaaaaaa.close();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Flushable
    public void flush() {
        this.aaaaaaaa.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.aaaaaaaa.toString() + ")";
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
    public aaaaaoaa aaaaaaa0() {
        return this.aaaaaaaa.aaaaaaa0();
    }
}
