package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaeo extends aaaaaoaa {
    private aaaaaoaa aaaaaaau;

    public aaaaaaeo(aaaaaoaa aaaaaoaaVar) {
        if (aaaaaoaaVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.aaaaaaau = aaaaaoaaVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
    public aaaaaoaa aaaaaaa0() {
        return this.aaaaaaau.aaaaaaa0();
    }

    public final aaaaaaeo aaaaaaaa(aaaaaoaa aaaaaoaaVar) {
        if (aaaaaoaaVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.aaaaaaau = aaaaaoaaVar;
        return this;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
    public boolean aaaaaaac() {
        return this.aaaaaaau.aaaaaaac();
    }

    public final aaaaaoaa aaaaaaae() {
        return this.aaaaaaau;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
    public long aaaaaaao() {
        return this.aaaaaaau.aaaaaaao();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
    public void aaaaaaau() {
        this.aaaaaaau.aaaaaaau();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
    public aaaaaoaa aaaaaaaa(long j, TimeUnit timeUnit) {
        return this.aaaaaaau.aaaaaaaa(j, timeUnit);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
    public aaaaaoaa aaaaaaaa(long j) {
        return this.aaaaaaau.aaaaaaaa(j);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
    public aaaaaoaa aaaaaaaa() {
        return this.aaaaaaau.aaaaaaaa();
    }
}
