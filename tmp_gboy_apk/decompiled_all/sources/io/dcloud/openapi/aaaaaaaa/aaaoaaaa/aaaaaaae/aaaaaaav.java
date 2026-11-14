package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import com.sigmob.sdk.downloader.f;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class aaaaaaav implements Closeable {
    static final Logger aaaaaaau = Logger.getLogger(aaaaaaau.class.getName());
    private final aaaaaaaa aaaaaaa0;
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaaa;
    final aaaaaaac.aaaaaaaa aaaaaaac;
    private final boolean aaaaaaao;

    public interface aaaaaaa0 {
        void aaaaaaaa();

        void aaaaaaaa(int i, int i2, int i3, boolean z);

        void aaaaaaaa(int i, int i2, List list);

        void aaaaaaaa(int i, long j);

        void aaaaaaaa(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var);

        void aaaaaaaa(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar);

        void aaaaaaaa(boolean z, int i, int i2);

        void aaaaaaaa(boolean z, int i, int i2, List list);

        void aaaaaaaa(boolean z, int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, int i2);

        void aaaaaaaa(boolean z, aaaaaaea aaaaaaeaVar);
    }

    public static final class aaaaaaaa implements aaaaoaaa {
        int aaaaaaa0;
        private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaaa;
        int aaaaaaac;
        short aaaaaaan;
        byte aaaaaaao;
        int aaaaaaau;

        public aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar) {
            this.aaaaaaaa = aaaaaaauVar;
        }

        private void aaaaaaeo() {
            int i = this.aaaaaaac;
            int aaaaaaaa = aaaaaaav.aaaaaaaa(this.aaaaaaaa);
            this.aaaaaaau = aaaaaaaa;
            this.aaaaaaa0 = aaaaaaaa;
            byte readByte = (byte) (this.aaaaaaaa.readByte() & 255);
            this.aaaaaaao = (byte) (this.aaaaaaaa.readByte() & 255);
            Logger logger = aaaaaaav.aaaaaaau;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(aaaaaaau.aaaaaaaa(true, this.aaaaaaac, this.aaaaaaa0, readByte, this.aaaaaaao));
            }
            int readInt = this.aaaaaaaa.readInt() & Integer.MAX_VALUE;
            this.aaaaaaac = readInt;
            if (readByte != 9) {
                throw aaaaaaau.aaaaaaa0("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i) {
                throw aaaaaaau.aaaaaaa0("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public aaaaaoaa aaaaaaa0() {
            return this.aaaaaaaa.aaaaaaa0();
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            while (true) {
                int i = this.aaaaaaau;
                if (i != 0) {
                    long aaaaaaaa = this.aaaaaaaa.aaaaaaaa(aaaaaaaoVar, Math.min(j, i));
                    if (aaaaaaaa == -1) {
                        return -1L;
                    }
                    this.aaaaaaau = (int) (this.aaaaaaau - aaaaaaaa);
                    return aaaaaaaa;
                }
                this.aaaaaaaa.skip(this.aaaaaaan);
                this.aaaaaaan = (short) 0;
                if ((this.aaaaaaao & 4) != 0) {
                    return -1L;
                }
                aaaaaaeo();
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    static {
        LoqqO();
    }

    public aaaaaaav(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, boolean z) {
        this.aaaaaaaa = aaaaaaauVar;
        this.aaaaaaao = z;
        aaaaaaaa aaaaaaaaVar = new aaaaaaaa(aaaaaaauVar);
        this.aaaaaaa0 = aaaaaaaaVar;
        this.aaaaaaac = new aaaaaaac.aaaaaaaa(f.a.c, aaaaaaaaVar);
    }

    private static /* synthetic */ void LoqqO() {
        char[] charArray = "=13p9?3;p<1'p-6;22p\u001407\u001c,7:9;".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '^');
        }
        String str = new String(charArray);
        char[] charArray2 = "=2707*".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '^');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void aaaaaaa0(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i < 8) {
            throw aaaaaaau.aaaaaaa0("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw aaaaaaau.aaaaaaa0("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int readInt = this.aaaaaaaa.readInt();
        int readInt2 = this.aaaaaaaa.readInt();
        int i3 = i - 8;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.aaaaaaaa(readInt2);
        if (aaaaaaaa2 == null) {
            throw aaaaaaau.aaaaaaa0("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaau;
        if (i3 > 0) {
            aaaaaaanVar = this.aaaaaaaa.aaaaaaa0(i3);
        }
        aaaaaaa0Var.aaaaaaaa(readInt, aaaaaaaa2, aaaaaaanVar);
    }

    private void aaaaaaac(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i != 8) {
            throw aaaaaaau.aaaaaaa0("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw aaaaaaau.aaaaaaa0("TYPE_PING streamId != 0", new Object[0]);
        }
        aaaaaaa0Var.aaaaaaaa((b & 1) != 0, this.aaaaaaaa.readInt(), this.aaaaaaaa.readInt());
    }

    private void aaaaaaae(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i != 4) {
            throw aaaaaaau.aaaaaaa0("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw aaaaaaau.aaaaaaa0("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int readInt = this.aaaaaaaa.readInt();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.aaaaaaaa(readInt);
        if (aaaaaaaa2 == null) {
            throw aaaaaaau.aaaaaaa0("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        }
        aaaaaaa0Var.aaaaaaaa(i2, aaaaaaaa2);
    }

    private void aaaaaaan(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i2 == 0) {
            throw aaaaaaau.aaaaaaa0("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short readByte = (b & 8) != 0 ? (short) (this.aaaaaaaa.readByte() & 255) : (short) 0;
        aaaaaaa0Var.aaaaaaaa(i2, this.aaaaaaaa.readInt() & Integer.MAX_VALUE, aaaaaaaa(aaaaaaaa(i - 4, b, readByte), readByte, b, i2));
    }

    private void aaaaaaao(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i2 == 0) {
            throw aaaaaaau.aaaaaaa0("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short readByte = (b & 8) != 0 ? (short) (this.aaaaaaaa.readByte() & 255) : (short) 0;
        if ((b & 32) != 0) {
            aaaaaaaa(aaaaaaa0Var, i2);
            i -= 5;
        }
        aaaaaaa0Var.aaaaaaaa(z, i2, -1, aaaaaaaa(aaaaaaaa(i, b, readByte), readByte, b, i2));
    }

    private void aaaaaaau(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i != 5) {
            throw aaaaaaau.aaaaaaa0("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw aaaaaaau.aaaaaaa0("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        aaaaaaaa(aaaaaaa0Var, i2);
    }

    private void aaaaaaav(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i2 != 0) {
            throw aaaaaaau.aaaaaaa0("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw aaaaaaau.aaaaaaa0("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            aaaaaaa0Var.aaaaaaaa();
            return;
        }
        if (i % 6 != 0) {
            throw aaaaaaau.aaaaaaa0("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        aaaaaaea aaaaaaeaVar = new aaaaaaea();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int readShort = this.aaaaaaaa.readShort() & 65535;
            int readInt = this.aaaaaaaa.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    if (readInt < 0) {
                        throw aaaaaaau.aaaaaaa0("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    readShort = 7;
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    throw aaaaaaau.aaaaaaa0("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                }
            } else if (readInt != 0 && readInt != 1) {
                throw aaaaaaau.aaaaaaa0("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
            aaaaaaeaVar.aaaaaaaa(readShort, readInt);
        }
        aaaaaaa0Var.aaaaaaaa(false, aaaaaaeaVar);
    }

    private void aaaaaaeo(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i != 4) {
            throw aaaaaaau.aaaaaaa0("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long readInt = this.aaaaaaaa.readInt() & 2147483647L;
        if (readInt == 0) {
            throw aaaaaaau.aaaaaaa0("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        aaaaaaa0Var.aaaaaaaa(i2, readInt);
    }

    public void aaaaaaaa(aaaaaaa0 aaaaaaa0Var) {
        if (this.aaaaaaao) {
            if (!aaaaaaaa(true, aaaaaaa0Var)) {
                throw aaaaaaau.aaaaaaa0("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar = this.aaaaaaaa;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar = aaaaaaau.aaaaaaaa;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaa02 = aaaaaaauVar.aaaaaaa0(aaaaaaanVar.aaaaaaac());
        Logger logger = aaaaaaau;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("<< CONNECTION %s", aaaaaaa02.aaaaaaa0()));
        }
        if (!aaaaaaanVar.equals(aaaaaaa02)) {
            throw aaaaaaau.aaaaaaa0("Expected a connection header but was %s", aaaaaaa02.aaaaaaae());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.aaaaaaaa.close();
    }

    public boolean aaaaaaaa(boolean z, aaaaaaa0 aaaaaaa0Var) {
        try {
            this.aaaaaaaa.aaaaaaau(9L);
            int aaaaaaaa2 = aaaaaaaa(this.aaaaaaaa);
            if (aaaaaaaa2 < 0 || aaaaaaaa2 > 16384) {
                throw aaaaaaau.aaaaaaa0("FRAME_SIZE_ERROR: %s", Integer.valueOf(aaaaaaaa2));
            }
            byte readByte = (byte) (this.aaaaaaaa.readByte() & 255);
            if (z && readByte != 4) {
                throw aaaaaaau.aaaaaaa0("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            }
            byte readByte2 = (byte) (this.aaaaaaaa.readByte() & 255);
            int readInt = this.aaaaaaaa.readInt() & Integer.MAX_VALUE;
            Logger logger = aaaaaaau;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(aaaaaaau.aaaaaaaa(true, readInt, aaaaaaaa2, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    aaaaaaaa(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                case 1:
                    aaaaaaao(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                case 2:
                    aaaaaaau(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                case 3:
                    aaaaaaae(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                case 4:
                    aaaaaaav(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                case 5:
                    aaaaaaan(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                case 6:
                    aaaaaaac(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                case 7:
                    aaaaaaa0(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                case 8:
                    aaaaaaeo(aaaaaaa0Var, aaaaaaaa2, readByte2, readInt);
                    return true;
                default:
                    this.aaaaaaaa.skip(aaaaaaaa2);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private List aaaaaaaa(int i, short s, byte b, int i2) {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        aaaaaaaaVar.aaaaaaau = i;
        aaaaaaaaVar.aaaaaaa0 = i;
        aaaaaaaaVar.aaaaaaan = s;
        aaaaaaaaVar.aaaaaaao = b;
        aaaaaaaaVar.aaaaaaac = i2;
        this.aaaaaaac.aaaaaaan();
        return this.aaaaaaac.aaaaaaao();
    }

    private void aaaaaaaa(aaaaaaa0 aaaaaaa0Var, int i, byte b, int i2) {
        if (i2 == 0) {
            throw aaaaaaau.aaaaaaa0("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) == 0) {
            short readByte = (b & 8) != 0 ? (short) (this.aaaaaaaa.readByte() & 255) : (short) 0;
            aaaaaaa0Var.aaaaaaaa(z, i2, this.aaaaaaaa, aaaaaaaa(i, b, readByte));
            this.aaaaaaaa.skip(readByte);
            return;
        }
        throw aaaaaaau.aaaaaaa0("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }

    private void aaaaaaaa(aaaaaaa0 aaaaaaa0Var, int i) {
        int readInt = this.aaaaaaaa.readInt();
        aaaaaaa0Var.aaaaaaaa(i, readInt & Integer.MAX_VALUE, (this.aaaaaaaa.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    public static int aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar) {
        return (aaaaaaauVar.readByte() & 255) | ((aaaaaaauVar.readByte() & 255) << 16) | ((aaaaaaauVar.readByte() & 255) << 8);
    }

    public static int aaaaaaaa(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw aaaaaaau.aaaaaaa0("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
