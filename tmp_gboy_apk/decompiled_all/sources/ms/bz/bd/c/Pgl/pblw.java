package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class pblw extends pbly.pgla {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static pblw f14064A2egSU;

    public static class pgla {

        /* renamed from: A2egSU, reason: collision with root package name */
        public long f14065A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public String f14066A4TApA;

        public final void A2egSU(String str, int i) {
            pblw pblwVar;
            synchronized (pblw.class) {
                pblwVar = pblw.f14064A2egSU;
            }
            if (pblwVar == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f14065A2egSU;
            pblwVar.A5SV6n(currentTimeMillis - j, j, this.f14066A4TApA, str, i);
        }

        public final void A4TApA(String str, int i) {
            pblw pblwVar;
            synchronized (pblw.class) {
                pblwVar = pblw.f14064A2egSU;
            }
            if (pblwVar == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f14065A2egSU;
            pblwVar.ADYaiT(currentTimeMillis - j, j, this.f14066A4TApA, str, i);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A2egSU(int i, long j, String str, Object obj) {
        if (i == 131073) {
            if (str != null && ARc23Z(str)) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f654b8", new byte[]{com.sigmob.sdk.archives.tar.e.S, 31});
            }
        } else if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                AMqCpz(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void A5SV6n(long j, long j2, String str, String str2, int i);

    public abstract void ADYaiT(long j, long j2, String str, String str2, int i);

    public abstract void AMqCpz(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean ARc23Z(String str);
}
