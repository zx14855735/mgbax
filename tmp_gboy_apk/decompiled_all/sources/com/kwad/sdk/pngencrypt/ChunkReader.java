package com.kwad.sdk.pngencrypt;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode aYD;
    private final com.kwad.sdk.pngencrypt.chunk.d aYE;
    private boolean aYH;
    protected int aYF = 0;
    private int aYG = 0;
    protected ErrorBehaviour aYI = ErrorBehaviour.STRICT;

    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP;

        static {
            rUkM();
        }

        private static /* synthetic */ void rUkM() {
            char[] charArray = "amo,ecog,`m{,qjgnn,Hlk@pkfeg".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 2);
            }
            String str = new String(charArray);
            char[] charArray2 = "anklkv".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 2);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            new PngjException("Bad chunk paramenters: " + chunkReaderMode);
        }
        this.aYD = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.aYE = dVar;
        dVar.aU(j);
        this.aYH = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d PE() {
        return this.aYE;
    }

    public abstract void PF();

    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("negative length??");
        }
        if (this.aYF == 0 && this.aYG == 0 && this.aYH) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aYE;
            dVar.e(dVar.baL, 0, 4);
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.aYE;
        int i4 = dVar2.len - this.aYF;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.aYG == 0) {
            if (this.aYH && this.aYD != ChunkReaderMode.BUFFER && i4 > 0) {
                dVar2.e(bArr, i, i4);
            }
            ChunkReaderMode chunkReaderMode = this.aYD;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.aYE.data;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, bArr2, this.aYF, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.aYF, bArr, i, i4);
            }
            this.aYF += i4;
            i += i4;
            i2 -= i4;
        }
        int i5 = this.aYF;
        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.aYE;
        if (i5 == dVar3.len) {
            int i6 = this.aYG;
            int i7 = 4 - i6;
            if (i7 <= i2) {
                i2 = i7;
            }
            if (i2 > 0) {
                byte[] bArr3 = dVar3.baN;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i, bArr3, i6, i2);
                }
                int i8 = this.aYG + i2;
                this.aYG = i8;
                if (i8 == 4) {
                    if (this.aYH) {
                        if (this.aYD == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar4 = this.aYE;
                            dVar4.e(dVar4.data, 0, dVar4.len);
                        }
                        this.aYE.bW(this.aYI == ErrorBehaviour.STRICT);
                    }
                    PF();
                }
            }
            i3 = i2;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    public abstract void a(int i, byte[] bArr, int i2, int i3);

    public final void bU(boolean z) {
        this.aYH = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aYE;
        if (dVar == null) {
            if (chunkReader.aYE != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.aYE)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aYE;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aYG == 4;
    }

    public String toString() {
        return this.aYE.toString();
    }
}
