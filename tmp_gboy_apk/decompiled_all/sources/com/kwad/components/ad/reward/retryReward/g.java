package com.kwad.components.ad.reward.retryReward;

import com.kwad.components.ad.reward.retryReward.RewardRetryTaskParams;
import com.kwad.sdk.api.manager.RewardRetryTaskManager;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.api.model.KSAdRewardRetryTaskResult;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class g {
    public static synchronized void a(final List<KSAdRewardRetryTaskResult> list, final RewardRetryTaskManager.RetryRewardResultListener retryRewardResultListener) {
        synchronized (g.class) {
            h.execute(new bg() { // from class: com.kwad.components.ad.reward.retryReward.g.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    List list2 = list;
                    if (list2 == null || list2.isEmpty()) {
                        return;
                    }
                    com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "requestIndustryInfo start");
                    new l<RewardRetryTaskNetRequest, RewardRetryTaskParams>() { // from class: com.kwad.components.ad.reward.retryReward.g.1.1
                        private static RewardRetryTaskParams Z(String str) {
                            RewardRetryTaskParams rewardRetryTaskParams = new RewardRetryTaskParams();
                            try {
                                rewardRetryTaskParams.parseJson(new JSONObject(str));
                                return rewardRetryTaskParams;
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                                return rewardRetryTaskParams;
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.a
                        /* renamed from: kA, reason: merged with bridge method [inline-methods] */
                        public RewardRetryTaskNetRequest createRequest() {
                            return new RewardRetryTaskNetRequest(list);
                        }

                        @Override // com.kwad.sdk.core.network.l
                        public final /* synthetic */ RewardRetryTaskParams parseData(String str) {
                            return Z(str);
                        }
                    }.request(new o<RewardRetryTaskNetRequest, RewardRetryTaskParams>() { // from class: com.kwad.components.ad.reward.retryReward.g.1.2
                        private void a(RewardRetryTaskParams rewardRetryTaskParams) {
                            KSAdInfoData kSAdInfoData;
                            String llsid;
                            RewardRetryTaskParams.a aVar;
                            com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "rewardTask query successfully");
                            try {
                                Map<Long, RewardRetryTaskParams.a> taskResultMap = rewardRetryTaskParams.getTaskResultMap();
                                if (taskResultMap.keySet().isEmpty()) {
                                    return;
                                }
                                for (KSAdRewardRetryTaskResult kSAdRewardRetryTaskResult : list) {
                                    if (kSAdRewardRetryTaskResult != null && (kSAdInfoData = kSAdRewardRetryTaskResult.ksAdInfoData) != null && (llsid = kSAdInfoData.getLlsid()) != null && (aVar = taskResultMap.get(Long.valueOf(Long.parseLong(llsid)))) != null) {
                                        kSAdRewardRetryTaskResult.conversionStatus = aVar.conversionStatus;
                                    }
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                retryRewardResultListener.onSuccess(list);
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                        }

                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                            a((RewardRetryTaskParams) baseResultData);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onError(RewardRetryTaskNetRequest rewardRetryTaskNetRequest, int i, String str) {
                            super.onError(rewardRetryTaskNetRequest, i, str);
                            com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "onError errorCode=" + i + " errorMsg=" + str);
                            retryRewardResultListener.onError(i, str);
                        }
                    });
                }
            });
        }
    }
}
