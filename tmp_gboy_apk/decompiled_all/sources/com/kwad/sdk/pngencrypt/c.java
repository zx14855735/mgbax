package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c extends b {
    protected k aYW;
    protected k aYX;
    protected e aYY;
    protected int aYZ = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e aZa = null;
    private long aZc = 0;
    private boolean aZd = true;
    private boolean aZe = false;
    private Set<String> aZf = new HashSet();
    private long aZg = 0;
    private long aZh = 0;
    private long aZi = 0;
    private ChunkLoadBehaviour aZk = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean aZb = false;
    private g aZj = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aZl;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aZl = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aZl[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
    }

    private int PL() {
        return this.aYZ;
    }

    private k PQ() {
        return this.aYX;
    }

    private void gL(String str) {
        if (str.equals("IHDR")) {
            if (this.aYZ < 0) {
                this.aYZ = 0;
                return;
            } else {
                new PngjException("unexpected chunk ".concat(str));
                return;
            }
        }
        if (str.equals("PLTE")) {
            int i = this.aYZ;
            if (i == 0 || i == 1) {
                this.aYZ = 2;
                return;
            } else {
                new PngjException("unexpected chunk here ".concat(str));
                return;
            }
        }
        if (str.equals("IDAT")) {
            int i2 = this.aYZ;
            if (i2 < 0 || i2 > 4) {
                new PngjException("unexpected chunk ".concat(str));
                return;
            } else {
                this.aYZ = 4;
                return;
            }
        }
        if (str.equals("IEND")) {
            if (this.aYZ >= 4) {
                this.aYZ = 6;
                return;
            } else {
                new PngjException("unexpected chunk ".concat(str));
                return;
            }
        }
        int i3 = this.aYZ;
        if (i3 <= 1) {
            this.aYZ = 1;
        } else if (i3 <= 3) {
            this.aYZ = 3;
        } else {
            this.aYZ = 5;
        }
    }

    private static boolean gM(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.gP(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean B(int i, String str) {
        if (super.B(i, str)) {
            return true;
        }
        if (this.aZg > 0) {
            if (PH() + i > this.aZg) {
                new PngjException("Maximum total bytes to read exceeeded: " + this.aZg + " offset:" + PH() + " len=" + i);
            }
        }
        if (this.aZf.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.gP(str)) {
            return false;
        }
        long j = this.aZh;
        if (j > 0 && i > j) {
            return true;
        }
        long j2 = this.aZi;
        if (j2 > 0 && i > j2 - this.aZc) {
            return true;
        }
        int i2 = AnonymousClass1.aZl[this.aZk.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.gR(str)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean PG() {
        return this.aZd;
    }

    public final boolean PM() {
        return PL() < 4;
    }

    public final j PN() {
        DeflatedChunksSet PI = PI();
        if (PI instanceof j) {
            return (j) PI;
        }
        return null;
    }

    public final k PO() {
        return this.aYW;
    }

    public final e PP() {
        return this.aYY;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.PE().asJ.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.PE());
            k Qz = iVar.Qz();
            this.aYW = Qz;
            this.aYX = Qz;
            if (iVar.Qx()) {
                this.aYY = new e(this.aYX);
            }
            this.aZa = new com.kwad.sdk.pngencrypt.chunk.e(this.aYW);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.aYD;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && gM(chunkReader.PE().asJ)) {
            this.aZc += chunkReader.PE().len;
        }
        if (chunkReader.aYD == chunkReaderMode2 || this.aZe) {
            this.aZa.a(this.aZj.a(chunkReader.PE(), PO()), this.aYZ);
        }
    }

    public final void aR(long j) {
        this.aZg = j;
    }

    public final void aS(long j) {
        this.aZh = j;
    }

    public final void aT(long j) {
        this.aZi = j;
    }

    public final void bV(boolean z) {
        this.aZd = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void c(int i, String str, long j) {
        gL(str);
        super.c(i, str, j);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aYZ != 6) {
            this.aYZ = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final DeflatedChunksSet gJ(String str) {
        return new j(str, this.aZb, PQ(), this.aYY);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean gK(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        return super.a(bArr, i, i2);
    }
}
