package com.kwad.components.core.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.core.request.k;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private static int Sq = 12;
    private static int Sr = 4;
    private static int Ss = 1;

    /* renamed from: com.kwad.components.core.j.a$a, reason: collision with other inner class name */
    public interface InterfaceC0298a {
        void e(List<c> list);

        void onError(int i, String str);

        void onRequestResult(int i);
    }

    public static void a(SceneImpl sceneImpl, InterfaceC0298a interfaceC0298a) {
        a(15, Sr, sceneImpl, e.AGGREGATION, interfaceC0298a);
    }

    private static void a(int i, int i2, SceneImpl sceneImpl, final int i3, final InterfaceC0298a interfaceC0298a) {
        SceneImpl m17clone = sceneImpl.m17clone();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        m17clone.setAdStyle(i);
        m17clone.setAdNum(i2);
        a(new ImpInfo(m17clone), null, false, true, new k() { // from class: com.kwad.components.core.j.a.1
            @Override // com.kwad.components.core.request.l
            public final void b(final AdResultData adResultData) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            InterfaceC0298a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.3
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        InterfaceC0298a.this.e(a.b(adResultData.getAdTemplateList(), i3));
                        a.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.request.l
            public final void onError(final int i4, final String str) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        InterfaceC0298a.this.onError(i4, str);
                    }
                });
            }
        }, false);
    }

    public static void b(SceneImpl sceneImpl, InterfaceC0298a interfaceC0298a) {
        a(17, Ss, sceneImpl, e.SD, interfaceC0298a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> b(List<AdTemplate> list, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new c(it.next(), i));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.o.a.tz().h(adTemplate, elapsedRealtime - j);
    }

    private static void a(final ImpInfo impInfo, List<String> list, boolean z, boolean z2, final k kVar, boolean z3) {
        final boolean z4 = false;
        final boolean z5 = true;
        final List list2 = null;
        final boolean z6 = false;
        new com.kwad.components.core.n.a(impInfo) { // from class: com.kwad.components.core.j.a.2
            @Override // com.kwad.components.core.n.a, com.kwad.sdk.core.network.a
            /* renamed from: oJ, reason: merged with bridge method [inline-methods] */
            public final com.kwad.components.core.request.a createRequest() {
                com.kwad.components.core.request.a aVar = new com.kwad.components.core.request.a(impInfo, list2, z4, null);
                aVar.bm(z5 ? 1 : 0);
                return aVar;
            }
        }.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.j.a.3
            private void n(AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty() || z6) {
                    kVar.b(adResultData);
                } else {
                    kVar.onError(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                n(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                n((AdResultData) baseResultData);
            }

            private void n(int i, String str) {
                kVar.onError(i, str);
            }
        });
    }
}
