package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.s;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {

    public interface a {
        void b(AppStatusRules appStatusRules);

        void v(int i, String str);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.d.a
            public final void cN(String str) {
                com.kwad.sdk.core.d.c.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(context, aVar);
            }
        });
    }

    public static void b(final Context context, final a aVar) {
        new l<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Fs, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.collector.a.a createRequest() {
                return !s.RL() ? new com.kwad.sdk.collector.a.a(null) : new com.kwad.sdk.collector.a.a(br.eo(context));
            }

            private static AppStatusRules cO(String str) {
                return AppStatusRules.createFromJson(str);
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ AppStatusRules parseData(String str) {
                return cO(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.sdk.collector.a.a aVar2) {
                super.onStartRequest(aVar2);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }

            private void a(AppStatusRules appStatusRules) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.sdk.collector.a.a aVar2, int i, String str) {
                super.onError(aVar2, i, str);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.v(i, str);
                }
            }
        });
    }
}
