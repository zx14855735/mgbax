package com.kwad.sdk.core.adlog.a;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private final c aBY;
    private final List<com.kwad.sdk.core.adlog.a.a> aBZ;

    public static final class a {
        private static final b aCb = new b(0);

        static {
            ktJYTq();
        }

        private static /* synthetic */ void ktJYTq() {
            char[] charArray = "ÌÀÂ\u0081ÈÎÂÊ\u0081ÍÀÖ\u0081ÜÇÊÃÃ\u0081åÁÆíÝÆËÈÊ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 175);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÌÃÆÁÆÛ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 175);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b Gp() {
        return a.aCb;
    }

    private synchronized com.kwad.sdk.core.adlog.a.a Gr() {
        if (ap.L(this.aBZ)) {
            return null;
        }
        return this.aBZ.remove(0);
    }

    private boolean Gt() {
        c cVar = this.aBY;
        return cVar == null || !cVar.aCc;
    }

    private boolean Gu() {
        c cVar = this.aBY;
        return cVar != null && cVar.aCg;
    }

    private static boolean d(com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        int i = aVar.aAV;
        return i == 1 || i == 2;
    }

    public final void Gq() {
        try {
            if (Gt() || ap.L(this.aBZ)) {
                return;
            }
            bw.runOnUiThread(new bg() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.Gm();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final com.kwad.sdk.core.adlog.a.a Gs() {
        com.kwad.sdk.core.adlog.a.a Gr = Gr();
        if (Gr == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(Gr, this.aBY, this.aBZ.size());
        long currentTimeMillis = System.currentTimeMillis() - Gr.aBV;
        c cVar = this.aBY;
        if (currentTimeMillis <= cVar.aCe * 1000) {
            Gr.retryCount++;
            com.kwad.sdk.core.adlog.b.a.a(Gr, cVar, this.aBZ.size(), currentTimeMillis);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache success：" + Gr);
            return Gr;
        }
        com.kwad.sdk.core.adlog.b.a.b(Gr, cVar, this.aBZ.size(), currentTimeMillis);
        com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + currentTimeMillis + ", adLogCache：" + Gr);
        return null;
    }

    public final void a(com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i, String str2) {
        try {
            if (Gt()) {
                return;
            }
            if (!Gu() || d(aVar2)) {
                if (aVar == null) {
                    if (aVar2 != null) {
                        a.C0353a c0353a = aVar2.GA() == null ? new a.C0353a() : aVar2.GA();
                        c0353a.aBs = 1;
                        aVar2.a(c0353a);
                        aa.putValue(jSONObject, "clientExtData", aVar2.PJ.toJson().toString());
                    }
                    aVar = com.kwad.sdk.core.adlog.a.a.Go().dz(str).j(jSONObject).c(aVar2).as(System.currentTimeMillis());
                }
                aVar.dc(i).dA(str2);
                com.kwad.sdk.core.adlog.b.a.a(aVar, this.aBY, this.aBZ.size());
                int i2 = aVar.retryCount;
                c cVar = this.aBY;
                if (i2 >= cVar.aCd) {
                    com.kwad.sdk.core.adlog.b.a.c(aVar, cVar, this.aBZ.size());
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                    return;
                }
                if (this.aBZ.size() >= this.aBY.aCf) {
                    com.kwad.sdk.core.adlog.a.a Gr = Gr();
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache limit size: " + this.aBZ.size() + ", remove log：" + Gr);
                    com.kwad.sdk.core.adlog.b.a.e(Gr, this.aBY, this.aBZ.size());
                }
                a(aVar);
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache success size: " + this.aBZ.size() + ", log: " + aVar);
                com.kwad.sdk.core.adlog.b.a.b(aVar, this.aBY, this.aBZ.size());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private b() {
        this.aBZ = new CopyOnWriteArrayList();
        this.aBY = (c) aa.b(((h) ServiceProvider.get(h.class)).DG(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            private static c Gv() {
                return new c();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ c FU() {
                return Gv();
            }
        });
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.aBZ.add(aVar);
    }
}
