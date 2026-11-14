package com.kwad.components.ad.reward.retryReward;

import android.content.SharedPreferences;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.h;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class d {
    private final Map<String, f> AC = new HashMap();
    private final ArrayList<String> AE = new ArrayList<>();
    private final Object lock = new Object();

    public static class a {
        private static final d AI = new d();

        static {
            QATDH();
        }

        private static /* synthetic */ void QATDH() {
            char[] charArray = "\u0083\u008f\u008dÎ\u0087\u0081\u008d\u0085Î\u0082\u008f\u0099Î\u0093\u0088\u0085\u008c\u008cÎª\u008e\u0089¢\u0092\u0089\u0084\u0087\u0085".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 224);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0083\u008c\u0089\u008e\u0089\u0094".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 224);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static d ku() {
        return a.AI;
    }

    public final f Y(String str) {
        return this.AC.get(str);
    }

    public final void kv() {
        if (bx.aC(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion(), BuildConfig.VERSION_NAME)) {
            h.execute(new bg() { // from class: com.kwad.components.ad.reward.retryReward.d.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    SharedPreferences hF;
                    try {
                        synchronized (d.this.lock) {
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                Map<String, ?> ho = ag.ho("ksadsdk_reward_task_cache");
                                com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "initRewardTaskAsync map cost time: " + (System.currentTimeMillis() - currentTimeMillis));
                                boolean hn = af.hn("ksadsdk_reward_task_cache");
                                if (ho != null && !ho.isEmpty()) {
                                    for (Map.Entry<String, ?> entry : ho.entrySet()) {
                                        if (entry != null) {
                                            Object value = entry.getValue();
                                            if (value instanceof String) {
                                                String str = (String) value;
                                                if (com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) {
                                                    str = com.kwad.sdk.core.a.c.decodeKsSdk(str);
                                                }
                                                JSONObject jSONObject = new JSONObject(str);
                                                f fVar = new f();
                                                fVar.parseJson(jSONObject);
                                                com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "json parse " + entry.getKey() + com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.er(fVar.mAdTemplate)) + " cost time: " + (System.currentTimeMillis() - currentTimeMillis));
                                                if (fVar.AQ * 1000 <= currentTimeMillis - fVar.AR) {
                                                    if (hn) {
                                                        d.this.AE.add(entry.getKey());
                                                    } else {
                                                        ag.ax("ksadsdk_reward_task_cache", entry.getKey());
                                                    }
                                                    StringBuilder sb = new StringBuilder("remove task: ");
                                                    sb.append(entry.getKey());
                                                    sb.append(com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.er(fVar.mAdTemplate)));
                                                    sb.append(" out time: ");
                                                    long j = currentTimeMillis - fVar.AR;
                                                    long j2 = fVar.AQ;
                                                    Long.signum(j2);
                                                    sb.append(j - (j2 * 1000));
                                                    com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", sb.toString());
                                                } else {
                                                    d.this.AC.put(entry.getKey(), fVar);
                                                }
                                            }
                                        }
                                    }
                                    if (hn && (hF = bo.hF("ksadsdk_reward_task_cache")) != null) {
                                        SharedPreferences.Editor edit = hF.edit();
                                        Iterator it = d.this.AE.iterator();
                                        while (it.hasNext()) {
                                            edit.remove((String) it.next());
                                        }
                                        edit.apply();
                                    }
                                }
                                com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", " all items: " + d.this.AC.size() + " cost time: " + (System.currentTimeMillis() - currentTimeMillis));
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
    }

    public final void a(final String str, final f fVar) {
        if (!this.AC.containsKey(str)) {
            this.AC.put(str, fVar);
            h.execute(new bg() { // from class: com.kwad.components.ad.reward.retryReward.d.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    synchronized (d.this.lock) {
                        ag.aw(str, fVar.toJson().toString());
                        com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "addTask key: " + str + com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.er(fVar.mAdTemplate)) + " save success");
                    }
                }
            });
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "addTask key: " + str + com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.er(fVar.mAdTemplate)) + " already exist");
    }
}
