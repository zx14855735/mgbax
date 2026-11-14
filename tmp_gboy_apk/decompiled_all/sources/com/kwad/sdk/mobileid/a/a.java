package com.kwad.sdk.mobileid.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.mobileid.d;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends com.kwad.sdk.mobileid.b {
    private l<b, CMTokenResponse> agZ;
    private int retryCount = 0;
    private int aKV = 3;

    public static /* synthetic */ int c(a aVar) {
        int i = aVar.retryCount;
        aVar.retryCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(final Context context) {
        new l<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.3
            private static c Ps() {
                return new c();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: gI, reason: merged with bridge method [inline-methods] */
            public UaidTokenResponse parseData(String str) {
                UaidTokenResponse uaidTokenResponse = new UaidTokenResponse();
                uaidTokenResponse.parseJson(new JSONObject(str));
                if (!TextUtils.isEmpty(uaidTokenResponse.uaid)) {
                    ag.ab(ServiceProvider.Re(), uaidTokenResponse.uaid);
                    ag.e(ServiceProvider.Re(), System.currentTimeMillis());
                }
                ag.ac(ServiceProvider.Re(), "");
                com.kwad.sdk.mobileid.c.a(context, uaidTokenResponse);
                return uaidTokenResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ f createRequest() {
                return Ps();
            }
        }.request(new o<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.4
            private void A(int i, String str) {
                com.kwad.sdk.mobileid.a.Pi();
                com.kwad.sdk.mobileid.c.c(context, i, str);
            }

            private static void Pt() {
                com.kwad.sdk.mobileid.a.Pi();
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                A(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                Pt();
            }
        });
    }

    @Override // com.kwad.sdk.mobileid.b
    public final void cr(Context context) {
        b(context, false);
    }

    @SuppressLint({"CheckResult"})
    public final void b(final Context context, final boolean z) {
        com.kwad.sdk.mobileid.c.b(context, z ? new d(true, "uaidTokenCanRequestByWifi") : new d(true, "uaidTokenCanRequest"));
        l<b, CMTokenResponse> lVar = new l<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.1
            private static b Pr() {
                return new b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: gH, reason: merged with bridge method [inline-methods] */
            public CMTokenResponse parseData(String str) {
                CMTokenResponse cMTokenResponse = new CMTokenResponse();
                cMTokenResponse.parseJson(new JSONObject(str));
                ag.ac(context, cMTokenResponse.getResultToken());
                com.kwad.sdk.mobileid.a.Pi();
                com.kwad.sdk.mobileid.c.a(context, cMTokenResponse);
                return cMTokenResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ f createRequest() {
                return Pr();
            }
        };
        this.agZ = lVar;
        lVar.request(new o<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(b bVar, CMTokenResponse cMTokenResponse) {
                d dVar;
                super.onSuccess(bVar, cMTokenResponse);
                boolean isEmpty = TextUtils.isEmpty(ag.dc(context));
                boolean z2 = a.this.retryCount < a.this.aKV;
                if (isEmpty || !z2) {
                    dVar = isEmpty ? new d(false, "noRequestUaidTokenEmpty") : new d(false, "noRequestUaidRetry");
                } else {
                    a.c(a.this);
                    dVar = z ? new d(true, "uaidTokenCanRequestByWifi") : new d(true, "uaidTokenCanRequest");
                    a.this.cs(context);
                }
                com.kwad.sdk.mobileid.c.c(context, dVar);
            }

            private void z(int i, String str) {
                com.kwad.sdk.mobileid.c.b(context, i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                z(i, str);
            }
        });
    }
}
