package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e {
    private static boolean Qe;
    private static final b Qf = new b() { // from class: com.kwad.components.core.e.d.e.4
        long Ql;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Ql = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Ql != 0) {
                com.kwad.sdk.core.adlog.c.n(getAdTemplate(), System.currentTimeMillis() - this.Ql);
            }
            com.kwad.sdk.core.c.b.Ji();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) e.Qf);
            setAdTemplate(null);
            this.Ql = 0L;
        }
    };

    static {
        iJzGVva();
    }

    public static int F(a.C0291a c0291a) {
        Context context = c0291a.getContext();
        final AdTemplate adTemplate = c0291a.getAdTemplate();
        String b = b(c0291a, adTemplate);
        if (TextUtils.isEmpty(b)) {
            return 0;
        }
        final AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        final String a2 = a(b, c0291a, er);
        return com.kwad.sdk.core.download.a.b.a(context, a2, new b.a() { // from class: com.kwad.components.core.e.d.e.2
            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                com.kwad.sdk.commercial.f.a.d(AdTemplate.this, a2, bw.r(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onPreStart() {
                com.kwad.sdk.commercial.f.a.f(AdTemplate.this, a2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                com.kwad.sdk.commercial.f.a.h(AdTemplate.this, a2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                com.kwad.sdk.commercial.f.a.i(AdTemplate.this, a2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void qk() {
                com.kwad.sdk.commercial.f.a.g(AdTemplate.this, a2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final boolean ql() {
                return com.kwad.sdk.core.response.b.a.cl(er);
            }
        });
    }

    public static int a(final a.C0291a c0291a, int i) {
        Context context = c0291a.getContext();
        final AdTemplate adTemplate = c0291a.getAdTemplate();
        String b = b(c0291a, adTemplate);
        if (TextUtils.isEmpty(b)) {
            return 0;
        }
        final AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.U(er) || c0291a.pu()) {
            final String a2 = a(b, c0291a, er);
            final int i2 = 1;
            return com.kwad.sdk.core.download.a.b.a(context, a2, new b.a() { // from class: com.kwad.components.core.e.d.e.1
                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                    com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                    if (ql()) {
                        a.C0353a c0353a = new a.C0353a();
                        aVar.PJ = c0353a;
                        c0353a.aBC = true;
                    }
                    com.kwad.sdk.core.adlog.c.b(AdTemplate.this, "", i2, aVar);
                    com.kwad.sdk.commercial.f.a.d(AdTemplate.this, a2, bw.r(th));
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onPreStart() {
                    com.kwad.sdk.commercial.f.a.f(AdTemplate.this, a2);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    com.kwad.components.core.proxy.launchdialog.e.tx().aI(AdTemplate.this);
                    e.Qf.setAdTemplate(AdTemplate.this);
                    com.kwad.sdk.core.c.b.Ji();
                    com.kwad.sdk.core.c.b.a(e.Qf);
                    com.kwad.sdk.core.adlog.c.aBQ = e.aq(a2);
                    com.kwad.sdk.commercial.f.a.h(AdTemplate.this, a2);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    com.kwad.sdk.core.adlog.c.a pF = c0291a.pF();
                    if (ql()) {
                        if (pF.PJ == null) {
                            pF.PJ = new a.C0353a();
                        }
                        pF.PJ.aBC = true;
                    }
                    com.kwad.sdk.commercial.f.a.i(AdTemplate.this, a2);
                    com.kwad.sdk.core.adlog.c.a(AdTemplate.this, "", i2, pF);
                    e.a(AdTemplate.this, a2, i2);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void qk() {
                    com.kwad.sdk.commercial.f.a.g(AdTemplate.this, a2);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final boolean ql() {
                    return com.kwad.sdk.core.response.b.a.cl(er);
                }
            });
        }
        c0291a.aA(1);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0291a);
        return 2;
    }

    public static void aC(boolean z) {
        com.kwad.sdk.core.adlog.c.aBR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aD(boolean z) {
        Qe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject aq(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static /* synthetic */ void iJzGVva() {
        char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 135);
        }
        String str = new String(charArray);
        char[] charArray2 = "äëîéîó".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 135);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String l(String str, String str2) {
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = Constants.FAIL;
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    private static boolean qi() {
        return Qe;
    }

    private static String b(a.C0291a c0291a, AdTemplate adTemplate) {
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : er.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0291a.ea()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0291a.py()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + er.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.b.a.cU(er);
    }

    private static String a(String str, a.C0291a c0291a, AdInfo adInfo) {
        AdTemplate adTemplate = c0291a.getAdTemplate();
        if (com.kwad.sdk.core.response.b.a.bn(adInfo)) {
            str = b(c0291a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.b.a.cS(adInfo)) {
            str = a(c0291a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.b.a.cK(adInfo) || com.kwad.sdk.core.response.b.a.cQ(adInfo)) && adTemplate.mAdScene != null) ? a(str, c0291a.getContext(), adTemplate.mAdScene) : str;
    }

    private static String b(a.C0291a c0291a, AdInfo adInfo, String str) {
        long j = c0291a.getAdTemplate().getmCurPlayTime();
        if (j > 0) {
            j = Math.max(j - com.kwad.sdk.core.response.b.a.bo(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final String str, final int i) {
        if (qi()) {
            return;
        }
        aD(true);
        int Hd = com.kwad.sdk.core.config.e.Hd();
        com.kwad.sdk.core.config.e.He();
        int abs = Math.abs(Hd);
        if (abs > 0) {
            bw.a(new Runnable() { // from class: com.kwad.components.core.e.d.e.3
                @Override // java.lang.Runnable
                public final void run() {
                    e.aD(false);
                    com.kwad.sdk.core.c.b.Ji();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "", i);
                    com.kwad.sdk.commercial.f.a.j(AdTemplate.this, str);
                }
            }, null, abs * 1000);
        } else {
            aD(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(com.kwad.components.core.e.d.a.C0291a r3, com.kwad.sdk.core.response.model.AdInfo r4, java.lang.String r5) {
        /*
            boolean r0 = com.kwad.sdk.core.response.b.a.bk(r4)
            if (r0 != 0) goto L7
            return r5
        L7:
            java.util.concurrent.Callable r0 = r3.pt()
            if (r0 == 0) goto L14
            java.lang.Object r0 = r0.call()     // Catch: java.lang.Exception -> L14
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L14
            goto L15
        L14:
            r0 = 0
        L15:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L1f
            java.lang.String r0 = r3.ps()
        L1f:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "__simpleItemId__"
            java.lang.String r2 = "__itemId__"
            if (r3 == 0) goto L3c
            boolean r3 = r5.contains(r2)
            if (r3 != 0) goto L37
            boolean r3 = r5.contains(r1)
            if (r3 == 0) goto L36
            goto L37
        L36:
            return r5
        L37:
            java.lang.String r3 = com.kwad.sdk.core.response.b.a.cU(r4)
            return r3
        L3c:
            long r3 = com.kwad.components.core.e.b.a.al(r0)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L45
            goto L46
        L45:
            r3 = r0
        L46:
            java.lang.String r4 = r5.replaceAll(r2, r0)
            java.lang.String r3 = r4.replaceAll(r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.e.d.e.a(com.kwad.components.core.e.d.a$a, com.kwad.sdk.core.response.model.AdInfo, java.lang.String):java.lang.String");
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i = 0;
        if (!as.as(context, "com.smile.gifmaker") && as.as(context, "com.kuaishou.nebula")) {
            i = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        return a(str, i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
    }

    private static String a(String str, int i, String str2) {
        return (!TextUtils.isEmpty(str2) && (i == 0 || i == 3)) ? l(str, str2) : str;
    }
}
