package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e {

    public static class a {
        private static e rD = new e(0);

        static {
            GmdFZi();
        }

        private static /* synthetic */ void GmdFZi() {
            char[] charArray = "²¾¼ÿ¶°¼´ÿ³¾¨ÿ¢¹´½½ÿ\u009b¿¸\u0093£¸µ¶´".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 209);
            }
            String str = new String(charArray);
            char[] charArray2 = "²½¸¿¸¥".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 209);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class b extends com.kwad.sdk.core.network.l<f, BaseResultData> {
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.o<f, BaseResultData> rE = new com.kwad.sdk.core.network.o<f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(f fVar, BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.o.a.tz().g(b.this.adTemplate, 0, cb.o);
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(f fVar, int i, String str) {
                super.onError(fVar, i, str);
                com.kwad.components.core.o.a.tz().g(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        public b(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        /* renamed from: gC, reason: merged with bridge method [inline-methods] */
        public f createRequest() {
            return new f(this.adTemplate);
        }

        public final void gB() {
            request(this.rE);
        }

        @Override // com.kwad.sdk.core.network.l
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                    return baseResultData;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
            return baseResultData;
        }
    }

    private e() {
    }

    private static void M(AdTemplate adTemplate) {
        new b(adTemplate).gB();
    }

    public static e gz() {
        return a.rD;
    }

    public final void L(AdTemplate adTemplate) {
        com.kwad.sdk.core.d.c.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.bT(er))) {
            p.b(adTemplate, er);
        } else {
            M(adTemplate);
        }
    }

    public /* synthetic */ e(byte b2) {
        this();
    }
}
