package com.kwad.components.ad.reward;

import com.baidu.mobads.sdk.internal.cb;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bp;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class p {

    public static class a {
        private String errorMsg;
        private boolean tu;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.tu = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.tu = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.tu;
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String bS = com.kwad.sdk.core.response.b.a.bS(adInfo);
        com.kwad.sdk.core.d.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bS);
        if (bp.isNullString(bS)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.components.ad.reward.p.1
            private void K(String str) {
                com.kwad.components.core.o.a.tz().g(adTemplate, 1, str);
            }

            private void hz() {
                com.kwad.components.core.o.a.tz().g(adTemplate, 0, cb.o);
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.core.network.c doGet = com.kwad.sdk.g.Cm().doGet(bS, null);
                    if (doGet == null) {
                        K("Network Error: url invalid");
                        return;
                    }
                    if (doGet.code != 200) {
                        K("Network Error: " + doGet.aIW);
                    } else {
                        a aVar = new a(doGet.aIW);
                        if (aVar.isValid()) {
                            hz();
                        } else {
                            K(aVar.errorMsg);
                        }
                    }
                } catch (Throwable th) {
                    K(J3FDQU.A2egSU.B4ZgIw(th, new StringBuilder("Request Error: ")));
                }
            }
        });
    }
}
