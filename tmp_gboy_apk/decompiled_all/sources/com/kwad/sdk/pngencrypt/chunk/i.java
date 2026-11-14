package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class i extends p {
    private int aZF;
    private int aZG;
    private int bba;
    private int bbb;
    private int bbc;
    private int bbd;
    private int bbe;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Qy();
        }
    }

    private void QA() {
        if (this.aZG <= 0 || this.aZF <= 0 || this.bbc != 0 || this.bbd != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i = this.bba;
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i2 = this.bbe;
        if (i2 < 0 || i2 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i3 = this.bbb;
        if (i3 != 0) {
            if (i3 != 6 && i3 != 2) {
                if (i3 == 3) {
                    if (i == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i3 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            if (i != 8 && i != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    private int Qa() {
        return this.aZF;
    }

    private int Qb() {
        return this.aZG;
    }

    private int Qu() {
        return this.bba;
    }

    private int Qv() {
        return this.bbb;
    }

    private int Qw() {
        return this.bbe;
    }

    private void Qy() {
        eI(this.aZU.aZG);
        eJ(this.aZU.aZF);
        eK(this.aZU.aZY);
        com.kwad.sdk.pngencrypt.k kVar = this.aZU;
        int i = kVar.baa ? 4 : 0;
        if (kVar.bac) {
            i++;
        }
        if (!kVar.bab) {
            i += 2;
        }
        eL(i);
        eM(0);
        eN(0);
        eO(0);
    }

    private void eI(int i) {
        this.aZG = i;
    }

    private void eJ(int i) {
        this.aZF = i;
    }

    private void eK(int i) {
        this.bba = i;
    }

    private void eL(int i) {
        this.bbb = i;
    }

    private void eM(int i) {
        this.bbc = 0;
    }

    private void eN(int i) {
        this.bbd = 0;
    }

    private void eO(int i) {
        this.bbe = 0;
    }

    public final boolean Qx() {
        return Qw() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k Qz() {
        QA();
        return new com.kwad.sdk.pngencrypt.k(Qb(), Qa(), Qu(), (Qv() & 4) != 0, Qv() == 0 || Qv() == 4, (Qv() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream Qq = dVar.Qq();
        this.aZG = com.kwad.sdk.pngencrypt.n.f(Qq);
        this.aZF = com.kwad.sdk.pngencrypt.n.f(Qq);
        this.bba = com.kwad.sdk.pngencrypt.n.e(Qq);
        this.bbb = com.kwad.sdk.pngencrypt.n.e(Qq);
        this.bbc = com.kwad.sdk.pngencrypt.n.e(Qq);
        this.bbd = com.kwad.sdk.pngencrypt.n.e(Qq);
        this.bbe = com.kwad.sdk.pngencrypt.n.e(Qq);
    }
}
