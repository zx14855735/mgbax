package com.kwad.components.core.o;

import android.content.Context;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private static boolean aaE;

    /* renamed from: com.kwad.components.core.o.a$a, reason: collision with other inner class name */
    public static final class C0300a {
        private static final a aaG = new a();

        static {
            cREZ();
        }

        private static /* synthetic */ void cREZ() {
            char[] charArray = "ùõ÷´ýû÷ÿ´øõã´éòÿöö´ÐôóØèóþýÿ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 154);
            }
            String str = new String(charArray);
            char[] charArray2 = "ùöóôóî".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 154);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static n M(long j) {
        return new n(j);
    }

    private static n a(long j, AdTemplate adTemplate, String str) {
        return new n(j, adTemplate, str);
    }

    private static n b(long j, AdTemplate adTemplate) {
        return new n(j, adTemplate);
    }

    public static a tz() {
        return C0300a.aaG;
    }

    public final void aD(Context context) {
        n M = M(11L);
        p pVar = (p) d.f(p.class);
        if (pVar != null) {
            JSONArray[] b = pVar.b(context, e.Dk());
            M.aLC = b[0];
            M.aLD = b[1];
            g.a2(M);
        }
    }

    public final void aL(AdTemplate adTemplate) {
        g.a2(b(10007L, adTemplate));
    }

    public final void aM(AdTemplate adTemplate) {
        g.a2(b(10208L, adTemplate));
    }

    public final void aN(AdTemplate adTemplate) {
        g.a2(b(10209L, adTemplate));
    }

    public final void bk(int i) {
        n M = M(10104L);
        M.aLK = i;
        g.a2(M);
    }

    public final void bl(int i) {
        n M = M(10107L);
        M.aLL = i;
        g.a2(M);
    }

    public final void c(JSONArray jSONArray) {
        n M = M(10200L);
        M.aLO = jSONArray;
        g.a2(M);
    }

    public final void e(JSONObject jSONObject, int i) {
        n M = M(10201L);
        aa.putValue(jSONObject, "appChangeType", i);
        M.aLN = jSONObject;
        g.a2(M);
    }

    public final void f(AdTemplate adTemplate, int i, int i2) {
        n b = b(12006L, adTemplate);
        b.ahA = i;
        b.aCH = i2;
        g.a2(b);
    }

    public final void g(AdTemplate adTemplate, int i, int i2) {
        n b = b(10002L, adTemplate);
        b.Ko();
        if (com.kwad.sdk.core.response.b.e.ej(adTemplate)) {
            b.aLJ = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.er(adTemplate));
        } else {
            b.aLJ = com.kwad.sdk.core.response.b.e.et(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, i2);
            b.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
        g.a2(b);
    }

    public final void h(AdTemplate adTemplate, long j) {
        n b = b(10202L, adTemplate);
        b.aLS = j;
        g.a2(b);
    }

    public final void i(AdTemplate adTemplate, long j) {
        n b = b(10206L, adTemplate);
        b.aMi = j;
        g.a2(b);
    }

    public final void j(AdTemplate adTemplate, long j) {
        n b = b(10207L, adTemplate);
        b.aMj = j;
        g.a2(b);
    }

    public final n m(String str, String str2) {
        n M = M(12200L);
        M.aMr = str;
        M.aMs = str2;
        return M;
    }

    public final void tA() {
        if (aaE) {
            return;
        }
        aaE = true;
        h.execute(new bg() { // from class: com.kwad.components.core.o.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                n M = a.M(8L);
                M.aMk = f.Fu();
                g.a2(M);
            }
        });
    }

    public final void tB() {
        g.a2(M(10101L));
    }

    public final void tC() {
        g.a2(M(10106L));
    }

    public final void a(AdTemplate adTemplate, String str, String str2) {
        n b = b(10003L, adTemplate);
        b.aLJ = str;
        b.errorMsg = str2;
        g.a2(b);
    }

    public final void b(AdTemplate adTemplate, String str, String str2) {
        n b = b(10005L, adTemplate);
        if (com.kwad.sdk.core.response.b.e.ej(adTemplate)) {
            b.aLJ = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.er(adTemplate));
        } else {
            b.aLJ = com.kwad.sdk.core.response.b.e.et(adTemplate);
        }
        b.aLJ = str;
        b.errorMsg = str2;
        g.a2(b);
    }

    public final void c(long j, int i) {
        if (e.HJ()) {
            n M = M(20000L);
            M.timestamp = System.currentTimeMillis();
            M.aMt = i;
            M.posId = j;
            M.aMu = BuildConfig.VERSION_CODE;
            g.a2(M);
        }
    }

    public final void e(AdTemplate adTemplate, int i) {
        n b = b(10108L, adTemplate);
        b.aLL = i;
        g.a2(b);
    }

    public final void f(AdTemplate adTemplate, int i, String str) {
        n b = b(10109L, adTemplate);
        b.aLL = 1;
        b.aLM = str;
        g.a2(b);
    }

    public final void a(int i, AdTemplate adTemplate, String str) {
        g.a2(a(i, adTemplate, str));
    }

    public final void a(AdTemplate adTemplate, long j, long j2, int i) {
        n b = b(10203L, adTemplate);
        b.age = j;
        b.blockDuration = j2;
        b.aLz = i;
        g.a2(b);
    }

    public final void e(String str, String str2, boolean z) {
        g.a(m(str, str2), z);
    }

    public final void f(AdTemplate adTemplate, int i) {
        if (e.HJ()) {
            AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
            n M = M(20000L);
            M.timestamp = System.currentTimeMillis();
            M.aMt = i;
            M.trace = er.trace;
            M.aMu = BuildConfig.VERSION_CODE;
            M.posId = com.kwad.sdk.core.response.b.e.ek(adTemplate);
            g.a2(M);
        }
    }

    public final void a(boolean z, List<Integer> list) {
        n M = M(10204L);
        M.aLU = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            M.aLT = jSONArray;
        }
        g.a2(M);
    }

    public final void g(AdTemplate adTemplate, int i, String str) {
        n b = b(107L, adTemplate);
        b.errorCode = i;
        b.errorMsg = str;
        g.a2(b);
    }

    public final void a(SceneImpl sceneImpl, boolean z, String str) {
        n M = M(10216L);
        M.aLU = z;
        M.aLV = str;
        M.adScene = sceneImpl;
        g.a2(M);
    }

    public final void a(AdTemplate adTemplate, long j, int i) {
        n b = b(104L, adTemplate);
        b.clickTime = com.kwad.sdk.utils.n.eT(adTemplate);
        b.aLY = j;
        b.aLZ = i;
        g.a2(b);
    }

    public final void a(b bVar) {
        n M = M(10215L);
        M.aau = bVar.aau;
        M.aaB = bVar.aaB;
        M.aaC = bVar.aaC;
        M.aaD = bVar.aaD;
        g.a2(M);
    }
}
