package com.kwad.components.ad.reward;

import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class m {
    public static void a(final int i, final g gVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.f, RewardCallBackRespInfo> lVar = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.1
            private static RewardCallBackRespInfo J(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: hw, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.f createRequest() {
                return new com.kwad.components.core.request.f(i, gVar.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return J(str);
            }
        };
        if (i == 1) {
            lVar.request(k(gVar));
        } else if (i == 2) {
            lVar.request(l(gVar));
        }
    }

    public static void b(g gVar, long j, long j2, long j3) {
        boolean m = m(gVar);
        long df = m ? com.kwad.sdk.core.response.b.a.df(com.kwad.sdk.core.response.b.e.er(gVar.mAdTemplate)) : 0L;
        if (gVar.sh || !m || !gVar.mCheckExposureResult || j <= ((j2 - 800) - j3) - df || df <= 0) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.dg(com.kwad.sdk.core.response.b.e.er(gVar.mAdTemplate))) {
            gVar.sg = 1;
            a(2, gVar);
        } else {
            gVar.rG.onRewardVerify();
        }
        gVar.sh = true;
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo> k(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.core.request.f fVar) {
                fVar.requestStartTime = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.request.f fVar, final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - fVar.requestStartTime, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.core.request.f fVar, int i, String str) {
                super.onError(fVar, i, str);
                bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = false;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - fVar.requestStartTime, i, str);
            }
        };
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo> l(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.core.request.f fVar) {
                fVar.requestStartTime = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.request.f fVar, final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.m.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (rewardCallBackRespInfo.result == 1) {
                            g.this.sg = 1;
                        } else {
                            g.this.sg = 2;
                        }
                        g.this.rG.onRewardVerify();
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - fVar.requestStartTime, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.core.request.f fVar, int i, String str) {
                super.onError(fVar, i, str);
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.m.3.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        g.this.sg = 2;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - fVar.requestStartTime, i, str);
            }
        };
    }

    private static boolean m(g gVar) {
        return !gVar.sh && com.kwad.sdk.core.response.b.a.dh(com.kwad.sdk.core.response.b.e.er(gVar.mAdTemplate));
    }
}
