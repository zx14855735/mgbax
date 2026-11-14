package com.bytedance.sdk.component.w.hf;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class et implements kd {
    final com.bytedance.sdk.component.w.hf.xj.w.tf hf;
    private zg kd;
    final boolean u;
    final io w;
    final ra xj;
    private boolean y;

    public final class xj extends com.bytedance.sdk.component.w.hf.xj.hf {
        private final y w;

        public xj(y yVar) {
            super("OkHttp %s", et.this.f());
            this.w = yVar;
        }

        public void hf() {
            ai aiVar;
            io ioVar = et.this.w;
            if (ioVar == null || (aiVar = ioVar.y) == null) {
                return;
            }
            aiVar.p();
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.hf
        public void w() {
            ai aiVar;
            boolean z = false;
            try {
                try {
                    try {
                        io ioVar = et.this.w;
                        if (ioVar != null && (aiVar = ioVar.y) != null) {
                            aiVar.xj();
                        }
                        q d = et.this.d();
                        try {
                            if (et.this.hf.hf()) {
                                this.w.xj(et.this, new IOException("Canceled"));
                            } else {
                                this.w.xj(et.this, d);
                            }
                            if (d.w == 0) {
                                throw new IOException(d.u);
                            }
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (z) {
                                com.bytedance.sdk.component.w.hf.xj.c.kd.hf().xj(4, "Callback failure for " + et.this.c(), e);
                            } else {
                                et.this.kd.xj(et.this, e);
                                this.w.xj(et.this, e);
                            }
                            et.this.xj.v().hf(this);
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    et.this.kd.xj(et.this, new IOException(e3));
                    this.w.xj(et.this, new IOException(e3));
                }
                et.this.xj.v().hf(this);
            } catch (Throwable th) {
                et.this.xj.v().hf(this);
                throw th;
            }
        }

        public String xj() {
            return et.this.w.xj().c();
        }
    }

    private et(ra raVar, io ioVar, boolean z) {
        this.xj = raVar;
        this.w = ioVar;
        this.u = z;
        this.hf = new com.bytedance.sdk.component.w.hf.xj.w.tf(raVar, z);
    }

    private void tf() {
        this.hf.xj(com.bytedance.sdk.component.w.hf.xj.c.kd.hf().xj("response.body().close()"));
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(u() ? "canceled " : "");
        sb.append(this.u ? "web socket" : "call");
        sb.append(" to ");
        sb.append(f());
        return sb.toString();
    }

    public q d() {
        ArrayList arrayList = new ArrayList(this.xj.ht());
        arrayList.add(this.hf);
        arrayList.add(new com.bytedance.sdk.component.w.hf.xj.w.xj(this.xj.y()));
        arrayList.add(new com.bytedance.sdk.component.w.hf.xj.xj.xj(this.xj.c()));
        arrayList.add(new com.bytedance.sdk.component.w.hf.xj.hf.xj(this.xj));
        if (!this.u) {
            arrayList.addAll(this.xj.ra());
        }
        arrayList.add(new com.bytedance.sdk.component.w.hf.xj.w.hf(this.u));
        return new com.bytedance.sdk.component.w.hf.xj.w.c(arrayList, null, null, null, 0, this.w, this, this.kd, this.xj.xj(), this.xj.hf(), this.xj.w()).xj(this.w);
    }

    public String f() {
        return this.w.xj().g();
    }

    @Override // com.bytedance.sdk.component.w.hf.kd
    public q hf() {
        synchronized (this) {
            if (this.y) {
                throw new IllegalStateException("Already Executed");
            }
            this.y = true;
        }
        tf();
        try {
            try {
                ai aiVar = this.w.y;
                if (aiVar != null) {
                    aiVar.xj();
                }
                this.xj.v().xj(this);
                q d = d();
                if (d == null) {
                    throw new IOException("Canceled");
                }
                if (d.w == 0) {
                    throw new IOException(d.u);
                }
                this.xj.v().hf(this);
                return d;
            } catch (IOException e) {
                this.kd.xj(this, e);
                this.xj.v().hf(this);
                return null;
            } catch (Exception e2) {
                this.kd.xj(this, new IOException(e2));
                this.xj.v().hf(this);
                return null;
            }
        } catch (Throwable th) {
            this.xj.v().hf(this);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.kd
    public boolean u() {
        return this.hf.hf();
    }

    @Override // com.bytedance.sdk.component.w.hf.kd
    public void w() {
        this.hf.xj();
    }

    @Override // com.bytedance.sdk.component.w.hf.kd
    /* renamed from: y, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public et kd() {
        return xj(this.xj, this.w, this.u);
    }

    public static et xj(ra raVar, io ioVar, boolean z) {
        et etVar = new et(raVar, ioVar, z);
        etVar.kd = raVar.dk().xj(etVar);
        return etVar;
    }

    @Override // com.bytedance.sdk.component.w.hf.kd
    public io xj() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.w.hf.kd
    public void xj(y yVar) {
        try {
            synchronized (this) {
                if (!this.y) {
                    this.y = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            tf();
            this.xj.v().xj(new xj(yVar));
        } catch (Throwable th) {
            if (yVar != null) {
                yVar.xj(this, new IOException(th.getMessage()));
            }
        }
    }
}
