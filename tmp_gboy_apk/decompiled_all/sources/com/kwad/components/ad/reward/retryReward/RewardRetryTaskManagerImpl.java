package com.kwad.components.ad.reward.retryReward;

import A5SV6n.A2egSU;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.manager.RewardRetryTaskManager;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.api.model.KSAdRewardRetryTaskResult;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bg;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardRetryTaskManagerImpl implements RewardRetryTaskManager {
    private static final String TAG = "RewardRetryTaskCacheManager";

    public enum RewardRetryErrorCode {
        REWARD_RETRY_TASK_EMPTY(1001, "激励二次深度转化任务参数为空"),
        REWARD_RETRY_TASK_LLSID_NULL(1002, "激励二次深度转化LLSID为空"),
        REWARD_RETRY_TASK_TIME_OUT(1003, "激励二次深度转化任务过期"),
        REWARD_RETRY_CONVERT_ERROR(PluginConstants.ERROR_PLUGIN_DOWNLOAD, "激励二次深度转化失败");

        public int code;
        public String msg;

        static {
            WZezoyx();
        }

        RewardRetryErrorCode(int i, String str) {
            this.code = i;
            this.msg = str;
        }

        private static /* synthetic */ void WZezoyx() {
            char[] charArray = "P\\^\u001dTR^V\u001dQ\\J\u001d@[V__\u001dy]ZqAZWTV".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '3');
            }
            String str = new String(charArray);
            char[] charArray2 = "P_Z]ZG".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '3');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private static Context getContext() {
        return ServiceProvider.Re();
    }

    private void performConvert(final Context context, final AdTemplate adTemplate, com.kwad.components.core.e.d.d dVar, final RewardRetryTaskManager.RetryRewardConvertResultListener retryRewardConvertResultListener) {
        a.C0291a a2 = new a.C0291a(m.wrapContextIfNeed(context)).aE(adTemplate).b(dVar).a(new a.b() { // from class: com.kwad.components.ad.reward.retryReward.RewardRetryTaskManagerImpl.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                final com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                aVar.aAV = 2;
                aVar.adTemplate = adTemplate;
                aj.a aVar2 = new aj.a();
                aVar2.C(com.kwad.sdk.utils.m.getScreenWidth(context), com.kwad.sdk.utils.m.getScreenHeight(context));
                aVar2.f((int) (Math.random() * 100.0d), (int) (Math.random() * 100.0d));
                aVar.e(aVar2);
                b.Y(adTemplate);
                retryRewardConvertResultListener.onSuccess();
                com.kwad.sdk.core.d.c.d(RewardRetryTaskManagerImpl.TAG, "开始上报track");
                GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.retryReward.RewardRetryTaskManagerImpl.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.adlog.b.b(aVar);
                    }
                });
            }
        });
        b.Z(adTemplate);
        com.kwad.sdk.core.d.c.d(TAG, "开始转化");
        com.kwad.components.core.e.d.c.q(a2);
    }

    @Override // com.kwad.sdk.api.manager.RewardRetryTaskManager
    public void rewardAdRetryTaskUpdate(KSAdInfoData kSAdInfoData, RewardRetryTaskManager.RetryRewardConvertResultListener retryRewardConvertResultListener) {
        com.kwad.sdk.core.d.c.d(TAG, "rewardAdRetryTaskUpdate 接口调用");
        if (kSAdInfoData == null) {
            RewardRetryErrorCode rewardRetryErrorCode = RewardRetryErrorCode.REWARD_RETRY_TASK_EMPTY;
            retryRewardConvertResultListener.onError(rewardRetryErrorCode.code, rewardRetryErrorCode.msg);
            return;
        }
        f Y = d.ku().Y(kSAdInfoData.getLlsid());
        if (Y == null || Y.mAdTemplate == null) {
            RewardRetryErrorCode rewardRetryErrorCode2 = RewardRetryErrorCode.REWARD_RETRY_TASK_TIME_OUT;
            retryRewardConvertResultListener.onError(rewardRetryErrorCode2.code, rewardRetryErrorCode2.msg);
        } else {
            b.b(Y);
            performConvert(getContext(), Y.mAdTemplate, new com.kwad.components.core.e.d.d(Y.mAdTemplate), retryRewardConvertResultListener);
        }
    }

    @Override // com.kwad.sdk.api.manager.RewardRetryTaskManager
    public void setRetryRewardResultListener(List<KSAdInfoData> list, final RewardRetryTaskManager.RetryRewardResultListener retryRewardResultListener) {
        com.kwad.sdk.core.d.c.d(TAG, "setRetryRewardResultListener 接口调用  count " + list.size());
        if (list.isEmpty()) {
            RewardRetryErrorCode rewardRetryErrorCode = RewardRetryErrorCode.REWARD_RETRY_TASK_EMPTY;
            retryRewardResultListener.onError(rewardRetryErrorCode.code, rewardRetryErrorCode.msg);
            return;
        }
        b.kr();
        ArrayList arrayList = new ArrayList();
        Iterator<KSAdInfoData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new KSAdRewardRetryTaskResult(it.next()));
        }
        g.a(arrayList, new RewardRetryTaskManager.RetryRewardResultListener() { // from class: com.kwad.components.ad.reward.retryReward.RewardRetryTaskManagerImpl.2
            @Override // com.kwad.sdk.api.manager.RewardRetryTaskManager.RetryRewardResultListener
            public final void onError(int i, String str) {
                RewardRetryTaskManager.RetryRewardResultListener retryRewardResultListener2 = retryRewardResultListener;
                if (retryRewardResultListener2 != null) {
                    retryRewardResultListener2.onError(i, str);
                    b.i(i, str);
                }
            }

            @Override // com.kwad.sdk.api.manager.RewardRetryTaskManager.RetryRewardResultListener
            public final void onSuccess(List<KSAdRewardRetryTaskResult> list2) {
                RewardRetryTaskManager.RetryRewardResultListener retryRewardResultListener2 = retryRewardResultListener;
                if (retryRewardResultListener2 != null) {
                    retryRewardResultListener2.onSuccess(list2);
                    b.ks();
                }
            }
        });
    }
}
