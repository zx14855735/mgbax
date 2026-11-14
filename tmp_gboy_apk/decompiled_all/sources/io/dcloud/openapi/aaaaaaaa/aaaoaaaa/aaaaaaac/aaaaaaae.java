package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aa0aaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaeaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.acaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aoaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaan;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.eaaaaaaa;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaae {
    static final /* synthetic */ boolean aeaaaaaa = true;
    private aaaaaaan.aaaaaaaa aaaaaaa0;
    public final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaa;
    private final aaaeaaaa aaaaaaac;
    private final Object aaaaaaae;
    public final aoaaaaaa aaaaaaan;
    private aa0aaaaa aaaaaaao;
    public final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaau;
    private final aaaaaaan aaaaaaav;
    private boolean aaaaaaea;
    private int aaaaaaeo;
    private boolean aaaaaeaa;
    private boolean aaaaeaaa;
    private aaaaaaao aaaeaaaa;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao eaaaaaaa;

    public static final class aaaaaaaa extends WeakReference {
        public final Object aaaaaaaa;

        public aaaaaaaa(aaaaaaae aaaaaaaeVar, Object obj) {
            super(aaaaaaaeVar);
            this.aaaaaaaa = obj;
        }
    }

    public aaaaaaae(aaaeaaaa aaaeaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaacVar, aoaaaaaa aoaaaaaaVar, Object obj) {
        this.aaaaaaac = aaaeaaaaVar;
        this.aaaaaaaa = aaaaaaaaVar;
        this.aaaaaaau = aaaaaaacVar;
        this.aaaaaaan = aoaaaaaaVar;
        this.aaaaaaav = new aaaaaaan(aaaaaaaaVar, aaaaaaeo(), aaaaaaacVar, aoaaaaaaVar);
        this.aaaaaaae = obj;
    }

    private Socket aaaaaaae() {
        if (!aeaaaaaa && !Thread.holdsLock(this.aaaaaaac)) {
            throw new AssertionError();
        }
        aaaaaaao aaaaaaaoVar = this.aaaeaaaa;
        if (aaaaaaaoVar == null || !aaaaaaaoVar.aaaaeaaa) {
            return null;
        }
        return aaaaaaaa(false, false, true);
    }

    private aaaaaaac aaaaaaeo() {
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaac);
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao aaaaaaa0() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao aaaaaaaoVar;
        synchronized (this.aaaaaaac) {
            aaaaaaaoVar = this.eaaaaaaa;
        }
        return aaaaaaaoVar;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao aaaaaaaa(acaaaaaa acaaaaaaVar, aaaaaoaa.aaaaaaaa aaaaaaaaVar, boolean z) {
        try {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao aaaaaaaa2 = aaaaaaaa(aaaaaaaaVar.aaaaaaaa(), aaaaaaaaVar.aaaaaaa0(), aaaaaaaaVar.aaaaaaao(), acaaaaaaVar.aaoaaaaa(), acaaaaaaVar.aacaaaaa(), z).aaaaaaaa(acaaaaaaVar, aaaaaaaaVar, this);
            synchronized (this.aaaaaaac) {
                this.eaaaaaaa = aaaaaaaa2;
            }
            return aaaaaaaa2;
        } catch (IOException e) {
            throw new aaaaaaau(e);
        }
    }

    public boolean aaaaaaac() {
        if (this.aaaaaaao != null) {
            return true;
        }
        aaaaaaan.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        return (aaaaaaaaVar != null && aaaaaaaaVar.aaaaaaa0()) || this.aaaaaaav.aaaaaaaa();
    }

    public void aaaaaaan() {
        aaaaaaao aaaaaaaoVar;
        Socket aaaaaaaa2;
        synchronized (this.aaaaaaac) {
            aaaaaaaoVar = this.aaaeaaaa;
            aaaaaaaa2 = aaaaaaaa(false, true, false);
            if (this.aaaeaaaa != null) {
                aaaaaaaoVar = null;
            }
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaa2);
        if (aaaaaaaoVar != null) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaau, (IOException) null);
            this.aaaaaaan.aaaaaaa0(this.aaaaaaau, aaaaaaaoVar);
            this.aaaaaaan.aaaaaaaa(this.aaaaaaau);
        }
    }

    public synchronized aaaaaaao aaaaaaao() {
        return this.aaaeaaaa;
    }

    public void aaaaaaau() {
        aaaaaaao aaaaaaaoVar;
        Socket aaaaaaaa2;
        synchronized (this.aaaaaaac) {
            aaaaaaaoVar = this.aaaeaaaa;
            aaaaaaaa2 = aaaaaaaa(true, false, false);
            if (this.aaaeaaaa != null) {
                aaaaaaaoVar = null;
            }
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaa2);
        if (aaaaaaaoVar != null) {
            this.aaaaaaan.aaaaaaa0(this.aaaaaaau, aaaaaaaoVar);
        }
    }

    public aa0aaaaa aaaaaaav() {
        return this.aaaaaaao;
    }

    public String toString() {
        aaaaaaao aaaaaaao = aaaaaaao();
        return aaaaaaao != null ? aaaaaaao.toString() : this.aaaaaaaa.toString();
    }

    public Socket aaaaaaa0(aaaaaaao aaaaaaaoVar) {
        if (!aeaaaaaa && !Thread.holdsLock(this.aaaaaaac)) {
            throw new AssertionError();
        }
        if (this.eaaaaaaa == null && this.aaaeaaaa.eaaaaaaa.size() == 1) {
            Reference reference = (Reference) this.aaaeaaaa.eaaaaaaa.get(0);
            Socket aaaaaaaa2 = aaaaaaaa(true, false, false);
            this.aaaeaaaa = aaaaaaaoVar;
            aaaaaaaoVar.eaaaaaaa.add(reference);
            return aaaaaaaa2;
        }
        throw new IllegalStateException();
    }

    private aaaaaaao aaaaaaaa(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        while (true) {
            aaaaaaao aaaaaaaa2 = aaaaaaaa(i, i2, i3, i4, z);
            boolean z3 = z;
            int i5 = i4;
            int i6 = i3;
            int i7 = i2;
            int i8 = i;
            synchronized (this.aaaaaaac) {
                try {
                    if (aaaaaaaa2.aaaaaeaa == 0 && !aaaaaaaa2.aaaaaaac()) {
                        return aaaaaaaa2;
                    }
                    if (aaaaaaaa2.aaaaaaaa(z2)) {
                        return aaaaaaaa2;
                    }
                    aaaaaaau();
                    i = i8;
                    i2 = i7;
                    i3 = i6;
                    i4 = i5;
                    z = z3;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private aaaaaaao aaaaaaaa(int i, int i2, int i3, int i4, boolean z) {
        aaaaaaao aaaaaaaoVar;
        Socket aaaaaaae;
        aaaaaaao aaaaaaaoVar2;
        Socket socket;
        aa0aaaaa aa0aaaaaVar;
        boolean z2;
        boolean z3;
        aaaaaaao aaaaaaaoVar3;
        aaaaaaan.aaaaaaaa aaaaaaaaVar;
        synchronized (this.aaaaaaac) {
            try {
                if (!this.aaaaaeaa) {
                    if (this.eaaaaaaa == null) {
                        if (!this.aaaaaaea) {
                            aaaaaaaoVar = this.aaaeaaaa;
                            aaaaaaae = aaaaaaae();
                            aaaaaaaoVar2 = this.aaaeaaaa;
                            socket = null;
                            if (aaaaaaaoVar2 != null) {
                                aaaaaaaoVar = null;
                            } else {
                                aaaaaaaoVar2 = null;
                            }
                            if (!this.aaaaeaaa) {
                                aaaaaaaoVar = null;
                            }
                            if (aaaaaaaoVar2 == null) {
                                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaac, this.aaaaaaaa, this, null);
                                aaaaaaao aaaaaaaoVar4 = this.aaaeaaaa;
                                if (aaaaaaaoVar4 != null) {
                                    aaaaaaaoVar2 = aaaaaaaoVar4;
                                    z2 = true;
                                    aa0aaaaaVar = null;
                                } else {
                                    aa0aaaaaVar = this.aaaaaaao;
                                }
                            } else {
                                aa0aaaaaVar = null;
                            }
                            z2 = false;
                        } else {
                            throw new IOException("Canceled");
                        }
                    } else {
                        throw new IllegalStateException("codec != null");
                    }
                } else {
                    throw new IllegalStateException("released");
                }
            } finally {
            }
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaae);
        if (aaaaaaaoVar != null) {
            this.aaaaaaan.aaaaaaa0(this.aaaaaaau, aaaaaaaoVar);
        }
        if (z2) {
            this.aaaaaaan.aaaaaaaa(this.aaaaaaau, aaaaaaaoVar2);
        }
        if (aaaaaaaoVar2 != null) {
            this.aaaaaaao = this.aaaeaaaa.aaaaaaau();
            return aaaaaaaoVar2;
        }
        if (aa0aaaaaVar != null || ((aaaaaaaaVar = this.aaaaaaa0) != null && aaaaaaaaVar.aaaaaaa0())) {
            z3 = false;
        } else {
            this.aaaaaaa0 = this.aaaaaaav.aaaaaaao();
            z3 = true;
        }
        synchronized (this.aaaaaaac) {
            try {
                if (this.aaaaaaea) {
                    throw new IOException("Canceled");
                }
                if (z3) {
                    List aaaaaaaa2 = this.aaaaaaa0.aaaaaaaa();
                    int size = aaaaaaaa2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        aa0aaaaa aa0aaaaaVar2 = (aa0aaaaa) aaaaaaaa2.get(i5);
                        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaac, this.aaaaaaaa, this, aa0aaaaaVar2);
                        aaaaaaao aaaaaaaoVar5 = this.aaaeaaaa;
                        if (aaaaaaaoVar5 != null) {
                            this.aaaaaaao = aa0aaaaaVar2;
                            aaaaaaaoVar2 = aaaaaaaoVar5;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (aa0aaaaaVar == null) {
                        aa0aaaaaVar = this.aaaaaaa0.aaaaaaao();
                    }
                    this.aaaaaaao = aa0aaaaaVar;
                    this.aaaaaaeo = 0;
                    aaaaaaaoVar2 = new aaaaaaao(this.aaaaaaac, aa0aaaaaVar);
                    aaaaaaaa(aaaaaaaoVar2, false);
                }
                aaaaaaaoVar3 = aaaaaaaoVar2;
            } finally {
            }
        }
        if (z2) {
            this.aaaaaaan.aaaaaaaa(this.aaaaaaau, aaaaaaaoVar3);
            return aaaaaaaoVar3;
        }
        aaaaaaaoVar3.aaaaaaaa(i, i2, i3, i4, z, this.aaaaaaau, this.aaaaaaan);
        aaaaaaeo().aaaaaaaa(aaaaaaaoVar3.aaaaaaau());
        synchronized (this.aaaaaaac) {
            try {
                this.aaaaeaaa = true;
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaa0(this.aaaaaaac, aaaaaaaoVar3);
                if (aaaaaaaoVar3.aaaaaaac()) {
                    socket = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaac, this.aaaaaaaa, this);
                    aaaaaaaoVar3 = this.aaaeaaaa;
                }
            } finally {
            }
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(socket);
        this.aaaaaaan.aaaaaaaa(this.aaaaaaau, aaaaaaaoVar3);
        return aaaaaaaoVar3;
    }

    public void aaaaaaaa(boolean z, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao aaaaaaaoVar, long j, IOException iOException) {
        aaaaaaao aaaaaaaoVar2;
        Socket aaaaaaaa2;
        boolean z2;
        this.aaaaaaan.aaaaaaa0(this.aaaaaaau, j);
        synchronized (this.aaaaaaac) {
            if (aaaaaaaoVar != null) {
                try {
                    if (aaaaaaaoVar == this.eaaaaaaa) {
                        if (!z) {
                            this.aaaeaaaa.aaaaaeaa++;
                        }
                        aaaaaaaoVar2 = this.aaaeaaaa;
                        aaaaaaaa2 = aaaaaaaa(z, false, true);
                        if (this.aaaeaaaa != null) {
                            aaaaaaaoVar2 = null;
                        }
                        z2 = this.aaaaaeaa;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.eaaaaaaa + " but was " + aaaaaaaoVar);
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaa2);
        if (aaaaaaaoVar2 != null) {
            this.aaaaaaan.aaaaaaa0(this.aaaaaaau, aaaaaaaoVar2);
        }
        if (iOException != null) {
            this.aaaaaaan.aaaaaaaa(this.aaaaaaau, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaau, iOException));
        } else if (z2) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaau, (IOException) null);
            this.aaaaaaan.aaaaaaaa(this.aaaaaaau);
        }
    }

    private Socket aaaaaaaa(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (!aeaaaaaa && !Thread.holdsLock(this.aaaaaaac)) {
            throw new AssertionError();
        }
        if (z3) {
            this.eaaaaaaa = null;
        }
        if (z2) {
            this.aaaaaeaa = true;
        }
        aaaaaaao aaaaaaaoVar = this.aaaeaaaa;
        if (aaaaaaaoVar != null) {
            if (z) {
                aaaaaaaoVar.aaaaeaaa = true;
            }
            if (this.eaaaaaaa == null && (this.aaaaaeaa || aaaaaaaoVar.aaaaeaaa)) {
                aaaaaaaa(aaaaaaaoVar);
                if (this.aaaeaaaa.eaaaaaaa.isEmpty()) {
                    this.aaaeaaaa.aeaaaaaa = System.nanoTime();
                    if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaac, this.aaaeaaaa)) {
                        socket = this.aaaeaaaa.aaaaaaan();
                        this.aaaeaaaa = null;
                        return socket;
                    }
                }
                socket = null;
                this.aaaeaaaa = null;
                return socket;
            }
        }
        return null;
    }

    public void aaaaaaaa() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao aaaaaaaoVar;
        aaaaaaao aaaaaaaoVar2;
        synchronized (this.aaaaaaac) {
            this.aaaaaaea = true;
            aaaaaaaoVar = this.eaaaaaaa;
            aaaaaaaoVar2 = this.aaaeaaaa;
        }
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.cancel();
        } else if (aaaaaaaoVar2 != null) {
            aaaaaaaoVar2.aaaaaaaa();
        }
    }

    public void aaaaaaaa(IOException iOException) {
        aaaaaaao aaaaaaaoVar;
        boolean z;
        Socket aaaaaaaa2;
        synchronized (this.aaaaaaac) {
            try {
                aaaaaaaoVar = null;
                if (iOException instanceof eaaaaaaa) {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var = ((eaaaaaaa) iOException).aaaaaaaa;
                    if (aaaaaaa0Var == io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.REFUSED_STREAM) {
                        int i = this.aaaaaaeo + 1;
                        this.aaaaaaeo = i;
                        if (i > 1) {
                            this.aaaaaaao = null;
                            z = true;
                        }
                        z = false;
                    } else {
                        if (aaaaaaa0Var != io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.CANCEL) {
                            this.aaaaaaao = null;
                            z = true;
                        }
                        z = false;
                    }
                } else {
                    aaaaaaao aaaaaaaoVar2 = this.aaaeaaaa;
                    if (aaaaaaaoVar2 != null && (!aaaaaaaoVar2.aaaaaaac() || (iOException instanceof io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaaa))) {
                        if (this.aaaeaaaa.aaaaaeaa == 0) {
                            aa0aaaaa aa0aaaaaVar = this.aaaaaaao;
                            if (aa0aaaaaVar != null && iOException != null) {
                                this.aaaaaaav.aaaaaaaa(aa0aaaaaVar, iOException);
                            }
                            this.aaaaaaao = null;
                        }
                        z = true;
                    }
                    z = false;
                }
                aaaaaaao aaaaaaaoVar3 = this.aaaeaaaa;
                aaaaaaaa2 = aaaaaaaa(z, false, true);
                if (this.aaaeaaaa == null && this.aaaaeaaa) {
                    aaaaaaaoVar = aaaaaaaoVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaa2);
        if (aaaaaaaoVar != null) {
            this.aaaaaaan.aaaaaaa0(this.aaaaaaau, aaaaaaaoVar);
        }
    }

    public void aaaaaaaa(aaaaaaao aaaaaaaoVar, boolean z) {
        if (!aeaaaaaa && !Thread.holdsLock(this.aaaaaaac)) {
            throw new AssertionError();
        }
        if (this.aaaeaaaa == null) {
            this.aaaeaaaa = aaaaaaaoVar;
            this.aaaaeaaa = z;
            aaaaaaaoVar.eaaaaaaa.add(new aaaaaaaa(this, this.aaaaaaae));
            return;
        }
        throw new IllegalStateException();
    }

    private void aaaaaaaa(aaaaaaao aaaaaaaoVar) {
        int size = aaaaaaaoVar.eaaaaaaa.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) aaaaaaaoVar.eaaaaaaa.get(i)).get() == this) {
                aaaaaaaoVar.eaaaaaaa.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
