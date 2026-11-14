package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class o implements Closeable {
    protected ErrorBehaviour aYU = ErrorBehaviour.STRICT;
    public final k aZU;
    public final boolean baq;
    protected final c bar;
    protected final a bas;
    protected final w bat;
    protected int bau;
    private i<? extends Object> bav;

    public o(InputStream inputStream, boolean z) {
        this.bau = -1;
        a aVar = new a(inputStream);
        this.bas = aVar;
        boolean z2 = true;
        aVar.bT(true);
        c Qo = Qo();
        this.bar = Qo;
        try {
            if (aVar.b(Qo, 36) != 36) {
                new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)");
            }
            this.aZU = Qo.PO();
            if (Qo.PP() == null) {
                z2 = false;
            }
            this.baq = z2;
            aT(5024024L);
            aR(901001001L);
            aS(2024024L);
            this.bat = new w(Qo.aZa);
            a(m.Qh());
            this.bau = -1;
        } catch (RuntimeException e) {
            this.bas.close();
            this.bar.close();
            throw e;
        }
    }

    private void Qk() {
        while (true) {
            c cVar = this.bar;
            if (cVar.aYZ >= 4) {
                return;
            }
            if (this.bas.a(cVar) <= 0) {
                new PngjException("Premature ending reading first chunks");
            }
        }
    }

    private void Qn() {
        this.bar.bV(false);
    }

    private static c Qo() {
        return new c(false);
    }

    private void a(i<? extends Object> iVar) {
        this.bav = iVar;
    }

    private void aR(long j) {
        this.bar.aR(901001001L);
    }

    private void aS(long j) {
        this.bar.aS(2024024L);
    }

    private void aT(long j) {
        this.bar.aT(5024024L);
    }

    public final w Ql() {
        if (this.bar.PM()) {
            Qk();
        }
        return this.bat;
    }

    public final void Qm() {
        Qn();
        if (this.bar.PM()) {
            Qk();
        }
        end();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.bar);
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.bas);
    }

    public final void end() {
        try {
            if (this.bar.PM()) {
                Qk();
            }
            if (this.bar.PN() != null && !this.bar.PN().isDone()) {
                this.bar.PN().PU();
            }
            while (!this.bar.isDone() && this.bas.a(this.bar) > 0) {
            }
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    public final String toString() {
        return this.aZU.toString() + " interlaced=" + this.baq;
    }
}
