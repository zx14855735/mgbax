package com.kwai.adclient.kscommerciallogger;

import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a bjh;
    private com.kwai.adclient.kscommerciallogger.a.b bji;
    private JSONObject bjj;
    private boolean bjk;
    private boolean isDebug;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a, reason: collision with other inner class name */
    public static final class C0392a {
        private static a bjl;

        public static a UW() {
            if (bjl == null) {
                bjl = new a((byte) 0);
            }
            return bjl;
        }
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a UW() {
        return C0392a.UW();
    }

    private void b(c cVar) {
        if (this.bjh != null) {
            if (cVar.Va() != null) {
                String str = cVar.Va().value;
            }
            if (cVar.Vb() != null) {
                cVar.Vb().getValue();
            }
            cVar.Ve();
            b.A(cVar.Vc());
            b.A(cVar.Vd());
        }
    }

    public final JSONObject UX() {
        return this.bjj;
    }

    public final boolean UY() {
        return this.bjk;
    }

    public final void a(com.kwai.adclient.kscommerciallogger.a.a aVar, com.kwai.adclient.kscommerciallogger.a.b bVar, JSONObject jSONObject, boolean z, boolean z2) {
        this.bjh = aVar;
        this.bji = bVar;
        this.bjj = jSONObject;
        this.isDebug = z;
        this.bjk = z2;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    private a() {
        this.isDebug = false;
        this.bjk = false;
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.bji;
        if (bVar != null) {
            bVar.M(cVar.UZ(), cVar.toString());
        }
    }
}
