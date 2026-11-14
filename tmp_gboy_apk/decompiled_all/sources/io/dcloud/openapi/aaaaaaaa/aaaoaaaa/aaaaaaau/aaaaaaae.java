package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aoaaaaaa;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaae implements aaaaaoaa.aaaaaaaa {
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaa0;
    private final List aaaaaaaa;
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaac;
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaae;
    private final aaaacaaa aaaaaaan;
    private final aaaaaaao aaaaaaao;
    private final int aaaaaaau;
    private final aoaaaaaa aaaaaaav;
    private final int aaaaaaeo;
    private int aaaaaeaa;
    private final int aaaaeaaa;
    private final int aaaeaaaa;

    public aaaaaaae(List list, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar, aaaaaaao aaaaaaaoVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar2, int i, aaaacaaa aaaacaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaacVar, aoaaaaaa aoaaaaaaVar, int i2, int i3, int i4) {
        this.aaaaaaaa = list;
        this.aaaaaaac = aaaaaaaoVar2;
        this.aaaaaaa0 = aaaaaaaeVar;
        this.aaaaaaao = aaaaaaaoVar;
        this.aaaaaaau = i;
        this.aaaaaaan = aaaacaaaVar;
        this.aaaaaaae = aaaaaaacVar;
        this.aaaaaaav = aoaaaaaaVar;
        this.aaaaaaeo = i2;
        this.aaaeaaaa = i3;
        this.aaaaeaaa = i4;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa.aaaaaaaa
    public int aaaaaaa0() {
        return this.aaaeaaaa;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa.aaaaaaaa
    public int aaaaaaaa() {
        return this.aaaaaaeo;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa.aaaaaaaa
    public aaaacaaa aaaaaaac() {
        return this.aaaaaaan;
    }

    public aoaaaaaa aaaaaaae() {
        return this.aaaaaaav;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaeo aaaaaaan() {
        return this.aaaaaaac;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa.aaaaaaaa
    public int aaaaaaao() {
        return this.aaaaeaaa;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaau() {
        return this.aaaaaaae;
    }

    public aaaaaaao aaaaaaav() {
        return this.aaaaaaao;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaeo() {
        return this.aaaaaaa0;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa.aaaaaaaa
    public aaaaaaca aaaaaaaa(aaaacaaa aaaacaaaVar) {
        return aaaaaaaa(aaaacaaaVar, this.aaaaaaa0, this.aaaaaaao, this.aaaaaaac);
    }

    public aaaaaaca aaaaaaaa(aaaacaaa aaaacaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar, aaaaaaao aaaaaaaoVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar2) {
        if (this.aaaaaaau < this.aaaaaaaa.size()) {
            this.aaaaaeaa++;
            if (this.aaaaaaao != null && !this.aaaaaaac.aaaaaaaa(aaaacaaaVar.aaaaaaae())) {
                throw new IllegalStateException("network interceptor " + this.aaaaaaaa.get(this.aaaaaaau - 1) + " must retain the same host and port");
            }
            if (this.aaaaaaao != null && this.aaaaaeaa > 1) {
                throw new IllegalStateException("network interceptor " + this.aaaaaaaa.get(this.aaaaaaau - 1) + " must call proceed() exactly once");
            }
            aaaaaaae aaaaaaaeVar2 = new aaaaaaae(this.aaaaaaaa, aaaaaaaeVar, aaaaaaaoVar, aaaaaaaoVar2, this.aaaaaaau + 1, aaaacaaaVar, this.aaaaaaae, this.aaaaaaav, this.aaaaaaeo, this.aaaeaaaa, this.aaaaeaaa);
            aaaaaoaa aaaaaoaaVar = (aaaaaoaa) this.aaaaaaaa.get(this.aaaaaaau);
            aaaaaaca aaaaaaaa = aaaaaoaaVar.aaaaaaaa(aaaaaaaeVar2);
            if (aaaaaaaoVar != null && this.aaaaaaau + 1 < this.aaaaaaaa.size() && aaaaaaaeVar2.aaaaaeaa != 1) {
                throw new IllegalStateException("network interceptor " + aaaaaoaaVar + " must call proceed() exactly once");
            }
            if (aaaaaaaa != null) {
                if (aaaaaaaa.aaaaaaeo() != null) {
                    return aaaaaaaa;
                }
                throw new IllegalStateException("interceptor " + aaaaaoaaVar + " returned a response with no body");
            }
            throw new NullPointerException("interceptor " + aaaaaoaaVar + " returned null");
        }
        throw new AssertionError();
    }
}
