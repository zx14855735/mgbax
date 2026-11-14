package com.kwad.sdk.pngencrypt;

import J3FDQU.A2egSU;
import com.kwad.sdk.pngencrypt.ChunkReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet aZm;
    protected boolean aZn;
    protected boolean aZo;
    protected byte[] aZp;
    protected int aZq;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.aZn = false;
        this.aZo = false;
        this.aZq = -1;
        this.aZm = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void PF() {
        int g;
        if (!this.aZo || this.aZq < 0 || (g = n.g(this.aZp, 0)) == this.aZq) {
            return;
        }
        StringBuilder B9tovu2 = A2egSU.B9tovu(g, "bad chunk sequence for fDAT chunk ", " expected ");
        B9tovu2.append(this.aZq);
        new PngjException(B9tovu2.toString());
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i, byte[] bArr, int i2, int i3) {
        if (this.aZo && i < 4) {
            while (i < 4 && i3 > 0) {
                this.aZp[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.aZm.b(bArr, i2, i3);
            if (this.aZn) {
                System.arraycopy(bArr, i2, PE().data, this.aYF, i3);
            }
        }
    }

    public final void ew(int i) {
        this.aZq = i;
    }
}
