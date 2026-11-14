package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import ADYaiT.CtFAbx;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import java.io.Closeable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaca implements Closeable {
    final aacaaaaa aaaaaaa0;
    final aaaacaaa aaaaaaaa;
    final String aaaaaaac;
    final a0aaaaaa aaaaaaae;
    final aaaoaaaa aaaaaaan;
    final int aaaaaaao;
    final aaoaaaaa aaaaaaau;
    final aaaaaaca aaaaaaav;
    private volatile aaaaaaao aaaaaaea;
    final aaaaaaca aaaaaaeo;
    final long aaaaaeaa;
    final long aaaaeaaa;
    final aaaaaaca aaaeaaaa;

    public static class aaaaaaaa {
        aacaaaaa aaaaaaa0;
        aaaacaaa aaaaaaaa;
        String aaaaaaac;
        a0aaaaaa aaaaaaae;
        aaaoaaaa.aaaaaaaa aaaaaaan;
        int aaaaaaao;
        aaoaaaaa aaaaaaau;
        aaaaaaca aaaaaaav;
        aaaaaaca aaaaaaeo;
        long aaaaaeaa;
        long aaaaeaaa;
        aaaaaaca aaaeaaaa;

        public aaaaaaaa() {
            this.aaaaaaao = -1;
            this.aaaaaaan = new aaaoaaaa.aaaaaaaa();
        }

        public aaaaaaaa aaaaaaa0(String str, String str2) {
            this.aaaaaaan.aaaaaaao(str, str2);
            return this;
        }

        public aaaaaaaa aaaaaaaa(aaaacaaa aaaacaaaVar) {
            this.aaaaaaaa = aaaacaaaVar;
            return this;
        }

        public aaaaaaaa aaaaaaac(aaaaaaca aaaaaacaVar) {
            if (aaaaaacaVar != null) {
                aaaaaaa0(aaaaaacaVar);
            }
            this.aaaeaaaa = aaaaaacaVar;
            return this;
        }

        public aaaaaaaa aaaaaaao(aaaaaaca aaaaaacaVar) {
            if (aaaaaacaVar != null) {
                aaaaaaaa("networkResponse", aaaaaacaVar);
            }
            this.aaaaaaav = aaaaaacaVar;
            return this;
        }

        private void aaaaaaa0(aaaaaaca aaaaaacaVar) {
            if (aaaaaacaVar.aaaaaaae != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public aaaaaaaa aaaaaaaa(aacaaaaa aacaaaaaVar) {
            this.aaaaaaa0 = aacaaaaaVar;
            return this;
        }

        public aaaaaaaa aaaaaaaa(int i) {
            this.aaaaaaao = i;
            return this;
        }

        public aaaaaaaa(aaaaaaca aaaaaacaVar) {
            this.aaaaaaao = -1;
            this.aaaaaaaa = aaaaaacaVar.aaaaaaaa;
            this.aaaaaaa0 = aaaaaacaVar.aaaaaaa0;
            this.aaaaaaao = aaaaaacaVar.aaaaaaao;
            this.aaaaaaac = aaaaaacaVar.aaaaaaac;
            this.aaaaaaau = aaaaaacaVar.aaaaaaau;
            this.aaaaaaan = aaaaaacaVar.aaaaaaan.aaaaaaaa();
            this.aaaaaaae = aaaaaacaVar.aaaaaaae;
            this.aaaaaaav = aaaaaacaVar.aaaaaaav;
            this.aaaaaaeo = aaaaaacaVar.aaaaaaeo;
            this.aaaeaaaa = aaaaaacaVar.aaaeaaaa;
            this.aaaaeaaa = aaaaaacaVar.aaaaeaaa;
            this.aaaaaeaa = aaaaaacaVar.aaaaaeaa;
        }

        public aaaaaaaa aaaaaaa0(long j) {
            this.aaaaeaaa = j;
            return this;
        }

        public aaaaaaaa aaaaaaaa(String str) {
            this.aaaaaaac = str;
            return this;
        }

        public aaaaaaaa aaaaaaaa(aaoaaaaa aaoaaaaaVar) {
            this.aaaaaaau = aaoaaaaaVar;
            return this;
        }

        public aaaaaaaa aaaaaaaa(String str, String str2) {
            this.aaaaaaan.aaaaaaaa(str, str2);
            return this;
        }

        public aaaaaaaa aaaaaaaa(aaaoaaaa aaaoaaaaVar) {
            this.aaaaaaan = aaaoaaaaVar.aaaaaaaa();
            return this;
        }

        public aaaaaaaa aaaaaaaa(a0aaaaaa a0aaaaaaVar) {
            this.aaaaaaae = a0aaaaaaVar;
            return this;
        }

        public aaaaaaaa aaaaaaaa(aaaaaaca aaaaaacaVar) {
            if (aaaaaacaVar != null) {
                aaaaaaaa("cacheResponse", aaaaaacaVar);
            }
            this.aaaaaaeo = aaaaaacaVar;
            return this;
        }

        private void aaaaaaaa(String str, aaaaaaca aaaaaacaVar) {
            if (aaaaaacaVar.aaaaaaae == null) {
                if (aaaaaacaVar.aaaaaaav == null) {
                    if (aaaaaacaVar.aaaaaaeo == null) {
                        if (aaaaaacaVar.aaaeaaaa != null) {
                            throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".priorResponse != null"));
                        }
                        return;
                    }
                    throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".cacheResponse != null"));
                }
                throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".networkResponse != null"));
            }
            throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".body != null"));
        }

        public aaaaaaaa aaaaaaaa(long j) {
            this.aaaaaeaa = j;
            return this;
        }

        public aaaaaaca aaaaaaaa() {
            if (this.aaaaaaaa != null) {
                if (this.aaaaaaa0 != null) {
                    if (this.aaaaaaao >= 0) {
                        if (this.aaaaaaac != null) {
                            return new aaaaaaca(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.aaaaaaao);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public aaaaaaca(aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaaa = aaaaaaaaVar.aaaaaaaa;
        this.aaaaaaa0 = aaaaaaaaVar.aaaaaaa0;
        this.aaaaaaao = aaaaaaaaVar.aaaaaaao;
        this.aaaaaaac = aaaaaaaaVar.aaaaaaac;
        this.aaaaaaau = aaaaaaaaVar.aaaaaaau;
        this.aaaaaaan = aaaaaaaaVar.aaaaaaan.aaaaaaaa();
        this.aaaaaaae = aaaaaaaaVar.aaaaaaae;
        this.aaaaaaav = aaaaaaaaVar.aaaaaaav;
        this.aaaaaaeo = aaaaaaaaVar.aaaaaaeo;
        this.aaaeaaaa = aaaaaaaaVar.aaaeaaaa;
        this.aaaaeaaa = aaaaaaaaVar.aaaaeaaa;
        this.aaaaaeaa = aaaaaaaaVar.aaaaaeaa;
    }

    public String aaaaaaa0(String str) {
        return aaaaaaaa(str, null);
    }

    public String aaaaaaaa(String str, String str2) {
        String aaaaaaa0 = this.aaaaaaan.aaaaaaa0(str);
        return aaaaaaa0 != null ? aaaaaaa0 : str2;
    }

    public aaaoaaaa aaaaaaea() {
        return this.aaaaaaan;
    }

    public a0aaaaaa aaaaaaeo() {
        return this.aaaaaaae;
    }

    public aaoaaaaa aaaaaeaa() {
        return this.aaaaaaau;
    }

    public int aaaaeaaa() {
        return this.aaaaaaao;
    }

    public aaaaaaao aaaeaaaa() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaea;
        if (aaaaaaaoVar != null) {
            return aaaaaaaoVar;
        }
        aaaaaaao aaaaaaaa2 = aaaaaaao.aaaaaaaa(this.aaaaaaan);
        this.aaaaaaea = aaaaaaaa2;
        return aaaaaaaa2;
    }

    public long aaaoaaaa() {
        return this.aaaaeaaa;
    }

    public aaaacaaa aaoaaaaa() {
        return this.aaaaaaaa;
    }

    public aaaaaaca aeaaaaaa() {
        return this.aaaeaaaa;
    }

    public long aoaaaaaa() {
        return this.aaaaaeaa;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a0aaaaaa a0aaaaaaVar = this.aaaaaaae;
        if (a0aaaaaaVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        a0aaaaaaVar.close();
    }

    public aaaaaaaa eaaaaaaa() {
        return new aaaaaaaa(this);
    }

    public String toString() {
        return "Response{protocol=" + this.aaaaaaa0 + ", code=" + this.aaaaaaao + ", message=" + this.aaaaaaac + ", url=" + this.aaaaaaaa.aaaaaaae() + '}';
    }
}
