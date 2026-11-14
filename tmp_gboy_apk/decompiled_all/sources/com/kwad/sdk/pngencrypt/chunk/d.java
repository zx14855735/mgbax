package com.kwad.sdk.pngencrypt.chunk;

import ADYaiT.CtFAbx;
import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    public final String asJ;
    public final byte[] baL;
    private CRC32 baO;
    public final int len;
    public byte[] data = null;
    private long baM = 0;
    public byte[] baN = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.asJ = str;
        this.baL = b.gO(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = this.baL[i2];
            if (b < 65 || b > 122 || (b > 90 && b < 97)) {
                new PngjException(CtFAbx.BChYOn("Bad id chunk: must be ascii letters ", str));
            }
        }
        if (z) {
            Qp();
        }
    }

    private void Qp() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final ByteArrayInputStream Qq() {
        return new ByteArrayInputStream(this.data);
    }

    public final long Qr() {
        return this.baM;
    }

    public final void aU(long j) {
        this.baM = j;
    }

    public final void bW(boolean z) {
        int value = (int) this.baO.getValue();
        int g = com.kwad.sdk.pngencrypt.n.g(this.baN, 0);
        if (value != g) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.asJ, Long.valueOf(this.baM), Integer.valueOf(g), Integer.valueOf(value));
            if (z) {
                new PngjException(format);
            }
        }
    }

    public final void e(byte[] bArr, int i, int i2) {
        if (this.baO == null) {
            this.baO = new CRC32();
        }
        this.baO.update(bArr, i, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.asJ;
        if (str == null) {
            if (dVar.asJ != null) {
                return false;
            }
        } else if (!str.equals(dVar.asJ)) {
            return false;
        }
        return this.baM == dVar.baM;
    }

    public final int hashCode() {
        String str = this.asJ;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.baM;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.h(this.baL) + " len=" + this.len;
    }
}
