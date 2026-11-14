package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaacaa {

    public class aaaaaaaa extends aaaaacaa {
        final /* synthetic */ byte[] aaaaaaa0;
        final /* synthetic */ int aaaaaaaa;
        final /* synthetic */ int aaaaaaao;

        public aaaaaaaa(aaaaaaoa aaaaaaoaVar, int i, byte[] bArr, int i2) {
            this.aaaaaaaa = i;
            this.aaaaaaa0 = bArr;
            this.aaaaaaao = i2;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaacaa
        public aaaaaaoa aaaaaaa0() {
            return null;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaacaa
        public long aaaaaaaa() {
            return this.aaaaaaaa;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaacaa
        public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaacVar) {
            aaaaaaacVar.write(this.aaaaaaa0, this.aaaaaaao, this.aaaaaaaa);
        }
    }

    public static aaaaacaa aaaaaaaa(aaaaaaoa aaaaaaoaVar, byte[] bArr) {
        return aaaaaaaa(aaaaaaoaVar, bArr, 0, bArr.length);
    }

    public abstract aaaaaaoa aaaaaaa0();

    public abstract long aaaaaaaa();

    public abstract void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaacVar);

    public static aaaaacaa aaaaaaaa(aaaaaaoa aaaaaaoaVar, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(bArr.length, i, i2);
        return new aaaaaaaa(aaaaaaoaVar, i2, bArr, i);
    }
}
