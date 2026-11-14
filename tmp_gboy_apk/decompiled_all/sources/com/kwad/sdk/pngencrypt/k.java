package com.kwad.sdk.pngencrypt;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class k {
    public final int aZF;
    public final int aZG;
    public final int aZY;
    public final int aZZ;
    public final boolean baa;
    public final boolean bab;
    public final boolean bac;
    public final boolean bad;
    public final int bae;
    public final int baf;
    public final int bag;
    public final int bah;
    public final int bai;
    private long baj = -1;
    private long bak = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.aZG = i;
        this.aZF = i2;
        this.baa = z;
        this.bac = z3;
        this.bab = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i4 = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.aZZ = i4;
        this.aZY = i3;
        boolean z4 = i3 < 8;
        this.bad = z4;
        int i5 = i4 * i3;
        this.bae = i5;
        this.baf = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.bag = i6;
        int i7 = i4 * i;
        this.bah = i7;
        this.bai = z4 ? i6 : i7;
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            if (!z3 && !z2) {
                throw new PngjException(CtFAbx.ARc23Z(i3, "only indexed or grayscale can have bitdepth="));
            }
        } else if (i3 != 8) {
            if (i3 != 16) {
                throw new PngjException(CtFAbx.ARc23Z(i3, "invalid bitdepth="));
            }
            if (z3) {
                throw new PngjException(CtFAbx.ARc23Z(i3, "indexed can't have bitdepth="));
            }
        }
        if (i <= 0 || i > 16777216) {
            throw new PngjException(CtFAbx.ASJ6gh(i, "invalid cols=", " ???"));
        }
        if (i2 <= 0 || i2 > 16777216) {
            throw new PngjException(CtFAbx.ASJ6gh(i2, "invalid rows=", " ???"));
        }
        if (i7 <= 0) {
            throw new PngjException("invalid image parameters (overflow?)");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.baa == kVar.baa && this.aZY == kVar.aZY && this.aZG == kVar.aZG && this.bab == kVar.bab && this.bac == kVar.bac && this.aZF == kVar.aZF;
    }

    public final int hashCode() {
        return (((((((((((this.baa ? 1231 : 1237) + 31) * 31) + this.aZY) * 31) + this.aZG) * 31) + (this.bab ? 1231 : 1237)) * 31) + (this.bac ? 1231 : 1237)) * 31) + this.aZF;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.aZG + ", rows=" + this.aZF + ", bitDepth=" + this.aZY + ", channels=" + this.aZZ + ", alpha=" + this.baa + ", greyscale=" + this.bab + ", indexed=" + this.bac + "]";
    }
}
