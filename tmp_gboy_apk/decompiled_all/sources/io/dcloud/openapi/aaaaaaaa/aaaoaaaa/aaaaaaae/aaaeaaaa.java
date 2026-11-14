package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import com.sigmob.sdk.downloader.f;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaac;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class aaaeaaaa implements Closeable {
    private static final Logger aaaaaaae = Logger.getLogger(aaaaaaau.class.getName());
    private final boolean aaaaaaa0;
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaaa;
    private int aaaaaaac;
    final aaaaaaac.aaaaaaa0 aaaaaaan;
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaao;
    private boolean aaaaaaau;

    static {
        TcqG();
    }

    public aaaeaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaacVar, boolean z) {
        this.aaaaaaaa = aaaaaaacVar;
        this.aaaaaaa0 = z;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
        this.aaaaaaao = aaaaaaaoVar;
        this.aaaaaaan = new aaaaaaac.aaaaaaa0(aaaaaaaoVar);
        this.aaaaaaac = f.a.d;
    }

    private static /* synthetic */ void TcqG() {
        char[] charArray = "EIK\bAGKC\bDI_\bUNCJJ\blHOdTOBAC".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '&');
        }
        String str = new String(charArray);
        char[] charArray2 = "EJOHOR".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '&');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public synchronized void aaaaaaa0(aaaaaaea aaaaaaeaVar) {
        try {
            if (this.aaaaaaau) {
                throw new IOException("closed");
            }
            int i = 0;
            aaaaaaaa(0, aaaaaaeaVar.aaaaaaac() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (aaaaaaeaVar.aaaaaaac(i)) {
                    this.aaaaaaaa.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.aaaaaaaa.writeInt(aaaaaaeaVar.aaaaaaaa(i));
                }
                i++;
            }
            this.aaaaaaaa.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void aaaaaaaa(aaaaaaea aaaaaaeaVar) {
        try {
            if (this.aaaaaaau) {
                throw new IOException("closed");
            }
            this.aaaaaaac = aaaaaaeaVar.aaaaaaao(this.aaaaaaac);
            if (aaaaaaeaVar.aaaaaaa0() != -1) {
                this.aaaaaaan.aaaaaaa0(aaaaaaeaVar.aaaaaaa0());
            }
            aaaaaaaa(0, 0, (byte) 4, (byte) 1);
            this.aaaaaaaa.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void aaaaaaeo() {
        try {
            if (this.aaaaaaau) {
                throw new IOException("closed");
            }
            if (this.aaaaaaa0) {
                Logger logger = aaaaaaae;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(">> CONNECTION %s", aaaaaaau.aaaaaaaa.aaaaaaa0()));
                }
                this.aaaaaaaa.write(aaaaaaau.aaaaaaaa.aaaaaaan());
                this.aaaaaaaa.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int aaaeaaaa() {
        return this.aaaaaaac;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.aaaaaaau = true;
        this.aaaaaaaa.close();
    }

    public synchronized void flush() {
        if (this.aaaaaaau) {
            throw new IOException("closed");
        }
        this.aaaaaaaa.flush();
    }

    public synchronized void aaaaaaaa(int i, int i2, List list) {
        if (!this.aaaaaaau) {
            this.aaaaaaan.aaaaaaaa(list);
            long size = this.aaaaaaao.size();
            int min = (int) Math.min(this.aaaaaaac - 4, size);
            long j = min;
            aaaaaaaa(i, min + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
            this.aaaaaaaa.writeInt(i2 & Integer.MAX_VALUE);
            this.aaaaaaaa.aaaaaaa0(this.aaaaaaao, j);
            if (size > j) {
                aaaaaaa0(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    private void aaaaaaa0(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min(this.aaaaaaac, j);
            long j2 = min;
            j -= j2;
            aaaaaaaa(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.aaaaaaaa.aaaaaaa0(this.aaaaaaao, j2);
        }
    }

    public synchronized void aaaaaaaa(boolean z, int i, int i2, List list) {
        if (!this.aaaaaaau) {
            aaaaaaaa(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void aaaaaaaa(int i, aaaaaaa0 aaaaaaa0Var) {
        if (!this.aaaaaaau) {
            if (aaaaaaa0Var.aaaaaaaa != -1) {
                aaaaaaaa(i, 4, (byte) 3, (byte) 0);
                this.aaaaaaaa.writeInt(aaaaaaa0Var.aaaaaaaa);
                this.aaaaaaaa.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void aaaaaaaa(boolean z, int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, int i2) {
        if (!this.aaaaaaau) {
            aaaaaaaa(i, z ? (byte) 1 : (byte) 0, aaaaaaaoVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    public void aaaaaaaa(int i, byte b, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, int i2) {
        aaaaaaaa(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.aaaaaaaa.aaaaaaa0(aaaaaaaoVar, i2);
        }
    }

    public synchronized void aaaaaaaa(boolean z, int i, int i2) {
        if (!this.aaaaaaau) {
            aaaaaaaa(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.aaaaaaaa.writeInt(i);
            this.aaaaaaaa.writeInt(i2);
            this.aaaaaaaa.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void aaaaaaaa(int i, aaaaaaa0 aaaaaaa0Var, byte[] bArr) {
        try {
            if (!this.aaaaaaau) {
                if (aaaaaaa0Var.aaaaaaaa != -1) {
                    aaaaaaaa(0, bArr.length + 8, (byte) 7, (byte) 0);
                    this.aaaaaaaa.writeInt(i);
                    this.aaaaaaaa.writeInt(aaaaaaa0Var.aaaaaaaa);
                    if (bArr.length > 0) {
                        this.aaaaaaaa.write(bArr);
                    }
                    this.aaaaaaaa.flush();
                } else {
                    throw aaaaaaau.aaaaaaaa("errorCode.httpCode == -1", new Object[0]);
                }
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void aaaaaaaa(int i, long j) {
        if (this.aaaaaaau) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            aaaaaaaa(i, 4, (byte) 8, (byte) 0);
            this.aaaaaaaa.writeInt((int) j);
            this.aaaaaaaa.flush();
        } else {
            throw aaaaaaau.aaaaaaaa("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
    }

    public void aaaaaaaa(int i, int i2, byte b, byte b2) {
        Logger logger = aaaaaaae;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(aaaaaaau.aaaaaaaa(false, i, i2, b, b2));
        }
        int i3 = this.aaaaaaac;
        if (i2 > i3) {
            throw aaaaaaau.aaaaaaaa("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw aaaaaaau.aaaaaaaa("reserved bit set: %s", Integer.valueOf(i));
        }
        aaaaaaaa(this.aaaaaaaa, i2);
        this.aaaaaaaa.writeByte(b & 255);
        this.aaaaaaaa.writeByte(b2 & 255);
        this.aaaaaaaa.writeInt(i & Integer.MAX_VALUE);
    }

    private static void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaacVar, int i) {
        aaaaaaacVar.writeByte((i >>> 16) & 255);
        aaaaaaacVar.writeByte((i >>> 8) & 255);
        aaaaaaacVar.writeByte(i & 255);
    }

    public void aaaaaaaa(boolean z, int i, List list) {
        if (!this.aaaaaaau) {
            this.aaaaaaan.aaaaaaaa(list);
            long size = this.aaaaaaao.size();
            int min = (int) Math.min(this.aaaaaaac, size);
            long j = min;
            byte b = size == j ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            aaaaaaaa(i, min, (byte) 1, b);
            this.aaaaaaaa.aaaaaaa0(this.aaaaaaao, j);
            if (size > j) {
                aaaaaaa0(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
