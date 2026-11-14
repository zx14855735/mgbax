package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaan;

import ADYaiT.CtFAbx;
import com.sigmob.sdk.downloader.core.c;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.a0aaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.acaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaav;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaeaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaeo;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaeaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaaa implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao {
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaa0;
    final acaaaaaa aaaaaaaa;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaac;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaao;
    int aaaaaaau = 0;
    private long aaaaaaan = 262144;

    public class aaaaaaac extends aaaaaaa0 {
        private boolean aaaaaaae;
        private long aaaaaaan;
        private final aaaaoaaa aaaaaaau;

        public aaaaaaac(aaaaoaaa aaaaoaaaVar) {
            super();
            this.aaaaaaan = -1L;
            this.aaaaaaae = true;
            this.aaaaaaau = aaaaoaaaVar;
        }

        private void aaaaaaeo() {
            if (this.aaaaaaan != -1) {
                aaaaaaaa.this.aaaaaaao.aaaaaaao();
            }
            try {
                this.aaaaaaan = aaaaaaaa.this.aaaaaaao.aaaaaaav();
                String trim = aaaaaaaa.this.aaaaaaao.aaaaaaao().trim();
                if (this.aaaaaaan < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.aaaaaaan + trim + "\"");
                }
                if (this.aaaaaaan == 0) {
                    this.aaaaaaae = false;
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaau.aaaaaaaa(aaaaaaaa.this.aaaaaaaa.aaaaaaae(), this.aaaaaaau, aaaaaaaa.this.aaaaaaan());
                    aaaaaaaa(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaan.aaaaaaaa.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
            }
            if (this.aaaaaaa0) {
                throw new IllegalStateException("closed");
            }
            if (!this.aaaaaaae) {
                return -1L;
            }
            long j2 = this.aaaaaaan;
            if (j2 == 0 || j2 == -1) {
                aaaaaaeo();
                if (!this.aaaaaaae) {
                    return -1L;
                }
            }
            long aaaaaaaa = super.aaaaaaaa(aaaaaaaoVar, Math.min(j, this.aaaaaaan));
            if (aaaaaaaa != -1) {
                this.aaaaaaan -= aaaaaaaa;
                return aaaaaaaa;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            aaaaaaaa(false, (IOException) protocolException);
            throw protocolException;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.aaaaaaa0) {
                return;
            }
            if (this.aaaaaaae && !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this, 100, TimeUnit.MILLISECONDS)) {
                aaaaaaaa(false, (IOException) null);
            }
            this.aaaaaaa0 = true;
        }
    }

    public class aaaaaaae extends aaaaaaa0 {
        private boolean aaaaaaau;

        public aaaaaaae() {
            super();
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaan.aaaaaaaa.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
            }
            if (this.aaaaaaa0) {
                throw new IllegalStateException("closed");
            }
            if (this.aaaaaaau) {
                return -1L;
            }
            long aaaaaaaa = super.aaaaaaaa(aaaaaaaoVar, j);
            if (aaaaaaaa != -1) {
                return aaaaaaaa;
            }
            this.aaaaaaau = true;
            aaaaaaaa(true, (IOException) null);
            return -1L;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.aaaaaaa0) {
                return;
            }
            if (!this.aaaaaaau) {
                aaaaaaaa(false, (IOException) null);
            }
            this.aaaaaaa0 = true;
        }
    }

    public class aaaaaaan extends aaaaaaa0 {
        private long aaaaaaau;

        public aaaaaaan(long j) {
            super();
            this.aaaaaaau = j;
            if (j == 0) {
                aaaaaaaa(true, (IOException) null);
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaan.aaaaaaaa.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
            }
            if (this.aaaaaaa0) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.aaaaaaau;
            if (j2 == 0) {
                return -1L;
            }
            long aaaaaaaa = super.aaaaaaaa(aaaaaaaoVar, Math.min(j2, j));
            if (aaaaaaaa == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                aaaaaaaa(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.aaaaaaau - aaaaaaaa;
            this.aaaaaaau = j3;
            if (j3 == 0) {
                aaaaaaaa(true, (IOException) null);
            }
            return aaaaaaaa;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.aaaaaaa0) {
                return;
            }
            if (this.aaaaaaau != 0 && !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this, 100, TimeUnit.MILLISECONDS)) {
                aaaaaaaa(false, (IOException) null);
            }
            this.aaaaaaa0 = true;
        }
    }

    public final class aaaaaaao implements aaaoaaaa {
        private boolean aaaaaaa0;
        private final aaaaaaeo aaaaaaaa;

        public aaaaaaao() {
            this.aaaaaaaa = new aaaaaaeo(aaaaaaaa.this.aaaaaaac.aaaaaaa0());
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public aaaaaoaa aaaaaaa0() {
            return this.aaaaaaaa;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.aaaaaaa0) {
                return;
            }
            this.aaaaaaa0 = true;
            aaaaaaaa.this.aaaaaaac.aaaaaaaa("0\r\n\r\n");
            aaaaaaaa.this.aaaaaaaa(this.aaaaaaaa);
            aaaaaaaa.this.aaaaaaau = 3;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Flushable
        public synchronized void flush() {
            if (this.aaaaaaa0) {
                return;
            }
            aaaaaaaa.this.aaaaaaac.flush();
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            if (this.aaaaaaa0) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            aaaaaaaa.this.aaaaaaac.aaaaaaaa(j);
            aaaaaaaa.this.aaaaaaac.aaaaaaaa("\r\n");
            aaaaaaaa.this.aaaaaaac.aaaaaaa0(aaaaaaaoVar, j);
            aaaaaaaa.this.aaaaaaac.aaaaaaaa("\r\n");
        }
    }

    public final class aaaaaaau implements aaaoaaaa {
        private boolean aaaaaaa0;
        private final aaaaaaeo aaaaaaaa;
        private long aaaaaaao;

        public aaaaaaau(long j) {
            this.aaaaaaaa = new aaaaaaeo(aaaaaaaa.this.aaaaaaac.aaaaaaa0());
            this.aaaaaaao = j;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public aaaaaoaa aaaaaaa0() {
            return this.aaaaaaaa;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.aaaaaaa0) {
                return;
            }
            this.aaaaaaa0 = true;
            if (this.aaaaaaao > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            aaaaaaaa.this.aaaaaaaa(this.aaaaaaaa);
            aaaaaaaa.this.aaaaaaau = 3;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Flushable
        public void flush() {
            if (this.aaaaaaa0) {
                return;
            }
            aaaaaaaa.this.aaaaaaac.flush();
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            if (this.aaaaaaa0) {
                throw new IllegalStateException("closed");
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaoVar.size(), 0L, j);
            if (j <= this.aaaaaaao) {
                aaaaaaaa.this.aaaaaaac.aaaaaaa0(aaaaaaaoVar, j);
                this.aaaaaaao -= j;
            } else {
                throw new ProtocolException("expected " + this.aaaaaaao + " bytes but received " + j);
            }
        }
    }

    public aaaaaaaa(acaaaaaa acaaaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaacVar) {
        this.aaaaaaaa = acaaaaaaVar;
        this.aaaaaaa0 = aaaaaaaeVar;
        this.aaaaaaao = aaaaaaauVar;
        this.aaaaaaac = aaaaaaacVar;
    }

    private String aaaaaaau() {
        String aaaaaaac2 = this.aaaaaaao.aaaaaaac(this.aaaaaaan);
        this.aaaaaaan -= aaaaaaac2.length();
        return aaaaaaac2;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public void aaaaaaa0() {
        this.aaaaaaac.flush();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public aaaoaaaa aaaaaaaa(aaaacaaa aaaacaaaVar, long j) {
        if ("chunked".equalsIgnoreCase(aaaacaaaVar.aaaaaaaa(c.h))) {
            return aaaaaaao();
        }
        if (j != -1) {
            return aaaaaaaa(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa aaaaaaac() {
        if (this.aaaaaaau != 4) {
            throw new IllegalStateException("state: " + this.aaaaaaau);
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar = this.aaaaaaa0;
        if (aaaaaaaeVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.aaaaaaau = 5;
        aaaaaaaeVar.aaaaaaau();
        return new aaaaaaae();
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa aaaaaaan() {
        aaaoaaaa.aaaaaaaa aaaaaaaaVar = new aaaoaaaa.aaaaaaaa();
        while (true) {
            String aaaaaaau2 = aaaaaaau();
            if (aaaaaaau2.length() == 0) {
                return aaaaaaaaVar.aaaaaaaa();
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(aaaaaaaaVar, aaaaaaau2);
        }
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa aaaaaaao() {
        if (this.aaaaaaau == 1) {
            this.aaaaaaau = 2;
            return new aaaaaaao();
        }
        throw new IllegalStateException("state: " + this.aaaaaaau);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public void cancel() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaao2 = this.aaaaaaa0.aaaaaaao();
        if (aaaaaaao2 != null) {
            aaaaaaao2.aaaaaaaa();
        }
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa aaaaaaa0(long j) {
        if (this.aaaaaaau == 4) {
            this.aaaaaaau = 5;
            return new aaaaaaan(j);
        }
        throw new IllegalStateException("state: " + this.aaaaaaau);
    }

    public abstract class aaaaaaa0 implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa {
        protected boolean aaaaaaa0;
        protected final aaaaaaeo aaaaaaaa;
        protected long aaaaaaao;

        private aaaaaaa0() {
            this.aaaaaaaa = new aaaaaaeo(aaaaaaaa.this.aaaaaaao.aaaaaaa0());
            this.aaaaaaao = 0L;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public aaaaaoaa aaaaaaa0() {
            return this.aaaaaaaa;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            try {
                long aaaaaaaa = aaaaaaaa.this.aaaaaaao.aaaaaaaa(aaaaaaaoVar, j);
                if (aaaaaaaa <= 0) {
                    return aaaaaaaa;
                }
                this.aaaaaaao += aaaaaaaa;
                return aaaaaaaa;
            } catch (IOException e) {
                aaaaaaaa(false, e);
                throw e;
            }
        }

        public final void aaaaaaaa(boolean z, IOException iOException) {
            aaaaaaaa aaaaaaaaVar = aaaaaaaa.this;
            int i = aaaaaaaaVar.aaaaaaau;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                aaaaaaaaVar.aaaaaaaa(this.aaaaaaaa);
                aaaaaaaa aaaaaaaaVar2 = aaaaaaaa.this;
                aaaaaaaaVar2.aaaaaaau = 6;
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar = aaaaaaaaVar2.aaaaaaa0;
                if (aaaaaaaeVar != null) {
                    aaaaaaaeVar.aaaaaaaa(!z, aaaaaaaaVar2, this.aaaaaaao, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + aaaaaaaa.this.aaaaaaau);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public void aaaaaaaa(aaaacaaa aaaacaaaVar) {
        aaaaaaaa(aaaacaaaVar.aaaaaaao(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaeo.aaaaaaaa(aaaacaaaVar, this.aaaaaaa0.aaaaaaao().aaaaaaau().aaaaaaa0().type()));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public a0aaaaaa aaaaaaaa(aaaaaaca aaaaaacaVar) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar = this.aaaaaaa0;
        aaaaaaaeVar.aaaaaaan.aaaaaaau(aaaaaaaeVar.aaaaaaau);
        String aaaaaaa02 = aaaaaacaVar.aaaaaaa0("Content-Type");
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaau.aaaaaaa0(aaaaaacaVar)) {
            return new aaaaaaav(aaaaaaa02, 0L, aaaaaeaa.aaaaaaaa(aaaaaaa0(0L)));
        }
        if ("chunked".equalsIgnoreCase(aaaaaacaVar.aaaaaaa0(c.h))) {
            return new aaaaaaav(aaaaaaa02, -1L, aaaaaeaa.aaaaaaaa(aaaaaaaa(aaaaaacaVar.aaoaaaaa().aaaaaaae())));
        }
        long aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaau.aaaaaaaa(aaaaaacaVar);
        if (aaaaaaaa != -1) {
            return new aaaaaaav(aaaaaaa02, aaaaaaaa, aaaaaeaa.aaaaaaaa(aaaaaaa0(aaaaaaaa)));
        }
        return new aaaaaaav(aaaaaaa02, -1L, aaaaaeaa.aaaaaaaa(aaaaaaac()));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public void aaaaaaaa() {
        this.aaaaaaac.flush();
    }

    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa aaaoaaaaVar, String str) {
        if (this.aaaaaaau == 0) {
            this.aaaaaaac.aaaaaaaa(str).aaaaaaaa("\r\n");
            int aaaaaaa02 = aaaoaaaaVar.aaaaaaa0();
            for (int i = 0; i < aaaaaaa02; i++) {
                this.aaaaaaac.aaaaaaaa(aaaoaaaaVar.aaaaaaaa(i)).aaaaaaaa(": ").aaaaaaaa(aaaoaaaaVar.aaaaaaa0(i)).aaaaaaaa("\r\n");
            }
            this.aaaaaaac.aaaaaaaa("\r\n");
            this.aaaaaaau = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.aaaaaaau);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public aaaaaaca.aaaaaaaa aaaaaaaa(boolean z) {
        int i = this.aaaaaaau;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.aaaaaaau);
        }
        try {
            aaaaeaaa aaaaaaaa = aaaaeaaa.aaaaaaaa(aaaaaaau());
            aaaaaaca.aaaaaaaa aaaaaaaa2 = new aaaaaaca.aaaaaaaa().aaaaaaaa(aaaaaaaa.aaaaaaaa).aaaaaaaa(aaaaaaaa.aaaaaaa0).aaaaaaaa(aaaaaaaa.aaaaaaao).aaaaaaaa(aaaaaaan());
            if (z && aaaaaaaa.aaaaaaa0 == 100) {
                return null;
            }
            if (aaaaaaaa.aaaaaaa0 == 100) {
                this.aaaaaaau = 3;
                return aaaaaaaa2;
            }
            this.aaaaaaau = 4;
            return aaaaaaaa2;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.aaaaaaa0);
            iOException.initCause(e);
            throw iOException;
        }
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa aaaaaaaa(long j) {
        if (this.aaaaaaau == 1) {
            this.aaaaaaau = 2;
            return new aaaaaaau(j);
        }
        throw new IllegalStateException("state: " + this.aaaaaaau);
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
        if (this.aaaaaaau == 4) {
            this.aaaaaaau = 5;
            return new aaaaaaac(aaaaoaaaVar);
        }
        throw new IllegalStateException("state: " + this.aaaaaaau);
    }

    public void aaaaaaaa(aaaaaaeo aaaaaaeoVar) {
        aaaaaoaa aaaaaaae2 = aaaaaaeoVar.aaaaaaae();
        aaaaaaeoVar.aaaaaaaa(aaaaaoaa.aaaaaaac);
        aaaaaaae2.aaaaaaaa();
        aaaaaaae2.aaaaaaa0();
    }
}
