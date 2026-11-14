package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class n extends k {
    private String bbn;
    private int bbo;
    private int[] bbp;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String QB() {
        return this.bbn;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int f;
        int f2;
        int f3;
        int f4;
        int i;
        int i2 = 0;
        while (true) {
            bArr = dVar.data;
            if (i2 >= bArr.length) {
                i2 = -1;
                break;
            } else if (bArr[i2] == 0) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 <= 0 || i2 > bArr.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.bbn = b.c(bArr, 0, i2);
        int e = com.kwad.sdk.pngencrypt.n.e(dVar.data, i2 + 1);
        this.bbo = e;
        int i3 = i2 + 2;
        int length = (dVar.data.length - i3) / (e == 8 ? 6 : 10);
        this.bbp = new int[length * 5];
        int i4 = i3;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (this.bbo == 8) {
                f = com.kwad.sdk.pngencrypt.n.e(dVar.data, i4);
                f2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i4 + 1);
                int i7 = i4 + 3;
                f3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i4 + 2);
                i = i4 + 4;
                f4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i7);
            } else {
                f = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4);
                f2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4 + 2);
                f3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4 + 4);
                f4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4 + 6);
                i = i4 + 8;
            }
            int f5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i);
            i4 = i + 2;
            int[] iArr = this.bbp;
            iArr[i5] = f;
            iArr[i5 + 1] = f2;
            iArr[i5 + 2] = f3;
            int i8 = i5 + 4;
            iArr[i5 + 3] = f4;
            i5 += 5;
            iArr[i8] = f5;
        }
    }
}
