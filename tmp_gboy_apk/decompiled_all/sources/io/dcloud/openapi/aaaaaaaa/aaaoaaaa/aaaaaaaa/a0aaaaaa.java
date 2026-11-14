package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import ADYaiT.CtFAbx;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class a0aaaaaa implements Closeable {

    public class aaaaaaaa extends a0aaaaaa {
        final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaa0;
        final /* synthetic */ long aaaaaaaa;

        public aaaaaaaa(aaaaaaoa aaaaaaoaVar, long j, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar) {
            this.aaaaaaaa = j;
            this.aaaaaaa0 = aaaaaaauVar;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.a0aaaaaa
        public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaeaaa() {
            return this.aaaaaaa0;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.a0aaaaaa
        public long aaaeaaaa() {
            return this.aaaaaaaa;
        }
    }

    public static a0aaaaaa aaaaaaaa(aaaaaaoa aaaaaaoaVar, byte[] bArr) {
        return aaaaaaaa(aaaaaaoaVar, bArr.length, new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao().write(bArr));
    }

    public final byte[] aaaaaaeo() {
        long aaaeaaaa = aaaeaaaa();
        if (aaaeaaaa > 2147483647L) {
            throw new IOException(CtFAbx.AaHO0E("Cannot buffer entire body for content length: ", aaaeaaaa));
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaeaaa = aaaaeaaa();
        try {
            byte[] aaaaaaac = aaaaeaaa.aaaaaaac();
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaeaaa);
            if (aaaeaaaa == -1 || aaaeaaaa == aaaaaaac.length) {
                return aaaaaaac;
            }
            throw new IOException(CtFAbx.AZkASS(") disagree", aaaaaaac.length, CtFAbx.B2KMhB("Content-Length (", aaaeaaaa, ") and stream length (")));
        } catch (Throwable th) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaeaaa);
            throw th;
        }
    }

    public abstract io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaeaaa();

    public abstract long aaaeaaaa();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaeaaa());
    }

    public static a0aaaaaa aaaaaaaa(aaaaaaoa aaaaaaoaVar, long j, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar) {
        if (aaaaaaauVar != null) {
            return new aaaaaaaa(aaaaaaoaVar, j, aaaaaaauVar);
        }
        throw new NullPointerException("source == null");
    }
}
