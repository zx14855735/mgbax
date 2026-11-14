package com.kwad.components.ad.reward;

import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class k {
    public static boolean a(g gVar, long j, long j2, long j3) {
        long dk = com.kwad.sdk.core.response.b.a.dk(com.kwad.sdk.core.response.b.e.er(gVar.mAdTemplate));
        if (j <= ((j2 - 800) - j3) - dk || dk <= 0 || !com.kwad.sdk.core.response.b.a.di(com.kwad.sdk.core.response.b.e.er(gVar.mAdTemplate))) {
            return false;
        }
        h(gVar);
        return true;
    }

    private static void h(final g gVar) {
        new com.kwad.sdk.core.network.l<com.kwad.components.core.request.m, RewardFraudVerifyRespInfo>() { // from class: com.kwad.components.ad.reward.k.1
            private static RewardFraudVerifyRespInfo I(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo = new RewardFraudVerifyRespInfo();
                rewardFraudVerifyRespInfo.parseJson(jSONObject);
                return rewardFraudVerifyRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: hv, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.m createRequest() {
                return new com.kwad.components.core.request.m(g.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ RewardFraudVerifyRespInfo parseData(String str) {
                return I(str);
            }
        }.request(i(gVar));
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.m, RewardFraudVerifyRespInfo> i(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.m, RewardFraudVerifyRespInfo>() { // from class: com.kwad.components.ad.reward.k.2
            private void a(final RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.k.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        g.this.se = rewardFraudVerifyRespInfo.isFraud() ? 3 : 2;
                        g.this.sf = rewardFraudVerifyRespInfo.getCode();
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(com.kwad.sdk.core.network.f fVar) {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((RewardFraudVerifyRespInfo) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.core.request.m mVar, int i, String str) {
                super.onError(mVar, i, str);
                A2egSU.A4TApA(i, "error: ", "RewardFraudVerifyUtil");
            }
        };
    }
}
