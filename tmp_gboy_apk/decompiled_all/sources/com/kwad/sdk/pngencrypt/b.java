package com.kwad.sdk.pngencrypt;

import ADYaiT.CtFAbx;
import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] aYJ;
    private final int aYK;
    private byte[] aYL;
    private int aYM;
    protected boolean aYN;
    protected boolean aYO;
    private int aYP;
    private long aYQ;
    private DeflatedChunksSet aYR;
    private ChunkReader aYS;
    private long aYT;
    private ErrorBehaviour aYU;
    protected boolean closed;

    public b() {
        this(n.Qi());
    }

    private static String PJ() {
        return "IHDR";
    }

    private static String PK() {
        return "IEND";
    }

    private static void g(byte[] bArr) {
        if (Arrays.equals(bArr, n.Qi())) {
            return;
        }
        new PngjException("Bad signature:" + Arrays.toString(bArr));
    }

    public boolean B(int i, String str) {
        return false;
    }

    public boolean PG() {
        return true;
    }

    public final long PH() {
        return this.aYQ;
    }

    public final DeflatedChunksSet PI() {
        return this.aYR;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException(CtFAbx.ARc23Z(i2, "This should not happen. Bad length: "));
        }
        if (!this.aYN) {
            int i3 = this.aYK;
            int i4 = this.aYM;
            int i5 = i3 - i4;
            if (i5 <= i2) {
                i2 = i5;
            }
            System.arraycopy(bArr, i, this.aYL, i4, i2);
            int i6 = this.aYM + i2;
            this.aYM = i6;
            if (i6 == this.aYK) {
                g(this.aYL);
                this.aYM = 0;
                this.aYN = true;
            }
            this.aYQ += i2;
            return i2;
        }
        ChunkReader chunkReader = this.aYS;
        if (chunkReader != null && !chunkReader.isDone()) {
            int a2 = this.aYS.a(bArr, i, i2);
            if (a2 < 0) {
                return -1;
            }
            this.aYQ += a2;
            return a2;
        }
        int i7 = this.aYM;
        int i8 = 8 - i7;
        if (i8 <= i2) {
            i2 = i8;
        }
        System.arraycopy(bArr, i, this.aYL, i7, i2);
        int i9 = this.aYM + i2;
        this.aYM = i9;
        this.aYQ += i2;
        if (i9 == 8) {
            this.aYP++;
            c(n.g(this.aYL, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aYL, 4), this.aYQ - 8);
            this.aYM = 0;
        }
        return i2;
    }

    public void c(int i, String str, long j) {
        b bVar;
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.baK.matcher(str).matches()) {
            new PngjException("Bad chunk id: ".concat(str));
        }
        if (i < 0) {
            new PngjException(CtFAbx.ARc23Z(i, "Bad chunk len: "));
        }
        if (str.equals("IDAT")) {
            this.aYT += i;
        }
        boolean PG = PG();
        boolean B = B(i, str);
        boolean gK = gK(str);
        DeflatedChunksSet deflatedChunksSet = this.aYR;
        boolean gN = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.aYR.gN(str);
        if (!gK || B) {
            bVar = this;
            bVar.aYS = bVar.a(str, i, j, B);
        } else {
            if (!gN) {
                DeflatedChunksSet deflatedChunksSet2 = this.aYR;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    new PngjException("new IDAT-like chunk when previous was not done");
                }
                this.aYR = gJ(str);
            }
            bVar = this;
            bVar.aYS = new d(i, str, PG, j, this.aYR) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void PF() {
                    super.PF();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = bVar.aYS;
        if (chunkReader == null || PG) {
            return;
        }
        chunkReader.bU(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aYR;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    public abstract DeflatedChunksSet gJ(String str);

    public boolean gK(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aYO;
    }

    private b(byte[] bArr) {
        this.aYL = new byte[8];
        this.aYM = 0;
        this.aYN = false;
        this.aYO = false;
        this.closed = false;
        this.aYP = 0;
        this.aYQ = 0L;
        this.aYU = ErrorBehaviour.STRICT;
        this.aYJ = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.aYK = length;
        this.aYN = length <= 0;
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void PF() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void a(int i2, byte[] bArr, int i3, int i4) {
                new PngjException("should never happen");
            }
        };
    }

    public void a(ChunkReader chunkReader) {
        if (this.aYP == 1 && !PJ().equals(chunkReader.PE().asJ)) {
            String str = "Bad first chunk: " + chunkReader.PE().asJ + " expected: " + PJ();
            if (this.aYU.c < ErrorBehaviour.SUPER_LENIENT.c) {
                new PngjException(str);
            }
        }
        PK();
        if (chunkReader.PE().asJ.equals(PK())) {
            this.aYO = true;
            close();
        }
    }
}
