package com.kwad.components.core.offline.b;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    private long Jf;
    private String SU = "";

    private void ax(final Context context) {
        if (com.kwad.components.core.a.Ns.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
            return;
        }
        com.kwad.library.solder.lib.c.b rp = rp();
        c.d(getTag(), "load component start pluginInfo: " + rp);
        com.kwad.library.solder.a.a.a(context, rp, new b.a() { // from class: com.kwad.components.core.offline.b.a.1
            long SV;

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            public void b(com.kwad.library.solder.lib.b.a aVar) {
                super.b((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource start");
                com.kwad.components.core.offline.moitor.a.b(a.this.rs(), a.this.getDuration(), a.this.SU);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(com.kwad.library.solder.lib.b.a aVar) {
                super.a((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource success");
                com.kwad.components.core.offline.moitor.a.c(a.this.rs(), a.this.getDuration(), a.this.SU);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void e(com.kwad.library.solder.lib.b.a aVar) {
                super.e((AnonymousClass1) aVar);
                this.SV = SystemClock.elapsedRealtime();
                a.this.SU = aVar.BM() ? "ASSETS" : "NETWORK";
                c.d(a.this.getTag(), "update component resource start");
                com.kwad.components.core.offline.moitor.c.d(a.this.rs(), a.this.getDuration(), a.this.SU);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(com.kwad.library.solder.lib.b.a aVar) {
                super.c((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "load component resource start");
                a.this.SU = "LOCAL";
                com.kwad.components.core.offline.moitor.a.b(a.this.rs(), a.this.getDuration(), aVar.BD().Bq().BR());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                super.a((AnonymousClass1) aVar, (com.kwad.library.solder.lib.b.a) aVar2);
                c.d(a.this.getTag(), "load component resource success");
                com.kwad.components.core.offline.moitor.a.a(a.this.rs(), a.this.getDuration(), a.this.SU);
                a.this.a(context, !"LOCAL".equals(r4.SU), aVar2.Bm());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.a aVar) {
                super.d((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "update component resource success");
                com.kwad.components.core.offline.moitor.c.a(a.this.rs(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.SV, a.this.SU);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass1) aVar, pluginError);
                if (aVar.getState() == 1) {
                    com.kwad.components.core.offline.moitor.c.b(a.this.rs(), a.this.getDuration(), pluginError.getCode(), a.this.SU, pluginError.getMessage());
                }
                com.kwad.components.core.offline.moitor.a.a(a.this.rs(), a.this.getDuration(), pluginError.getCode(), "cmp_load_error " + pluginError.getMessage(), a.this.SU);
                c.d(a.this.getTag(), "load component resource failed error: " + pluginError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.Jf;
    }

    private com.kwad.library.solder.lib.c.b rp() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.avL = rt();
        bVar.enable = true;
        bVar.avP = false;
        bVar.avM = com.kwad.sdk.core.network.idc.a.Jz().es(rv());
        bVar.version = ru();
        bVar.avO = rw();
        if (com.kwad.components.core.a.Nv.booleanValue()) {
            bVar.avo = rx();
            bVar.avp = true;
        }
        if (!TextUtils.isEmpty(rw()) && !TextUtils.isEmpty(rt()) && !TextUtils.isEmpty(ru()) && !TextUtils.isEmpty(rv())) {
            return bVar;
        }
        com.kwad.components.core.offline.moitor.a.a(rs(), getDuration(), PluginError.ERROR_BUILD_REMOTE_PLUGIN_INFO, "buildRemotePlugInfo error", this.SU);
        return bVar;
    }

    private void rq() {
        c.d(getTag(), "init component start cost: " + getDuration());
        com.kwad.components.core.offline.moitor.a.d(rs(), getDuration());
    }

    public abstract void a(Context context, boolean z, T t);

    public final void aL(int i) {
        c.d(getTag(), "init component error time: " + getDuration());
        com.kwad.components.core.offline.moitor.a.a(rs(), getDuration(), 5001, CtFAbx.ARc23Z(i, "cmp_init_error, errorCode:"), this.SU);
    }

    public abstract String getTag();

    public final void init(Context context) {
        try {
            if (!isEnabled()) {
                try {
                    c.d(getTag(), "del start");
                    com.kwad.library.solder.a.a.n(context, rt());
                } catch (Throwable unused) {
                }
            } else {
                this.Jf = SystemClock.elapsedRealtime();
                com.kwad.components.core.offline.moitor.a.c(rs(), getDuration());
                c.d(getTag(), "init start");
                ax(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public abstract boolean isEnabled();

    public final void rr() {
        c.d(getTag(), "init component success cost: " + getDuration());
        com.kwad.components.core.offline.moitor.a.c(rs(), getDuration(), i.Bw().Bq().BR());
    }

    public abstract String rs();

    public abstract String rt();

    public abstract String ru();

    public abstract String rv();

    public abstract String rw();

    public abstract String rx();

    public abstract String ry();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, boolean z, ClassLoader classLoader) {
        rq();
        String ry = ry();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(ry).newInstance();
            c.d(getTag(), "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z + ", classLoader:" + classLoader);
            a(context, z, (boolean) iOfflineCompo);
        } catch (Throwable th) {
            com.kwad.components.core.offline.moitor.a.a(rs(), getDuration(), 4005, "loadClass error", this.SU);
            c.e(getTag(), "loadClass or instance failed: " + ry, th);
        }
    }
}
