package com.kwad.sdk.liteapi;

import A5SV6n.A2egSU;
import android.content.Context;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class KsSecSDKWrapper {
    private static final String TAG = "KsSecSDKWrapper";

    public static String doSign(Context context, String str) {
        return a.doSign(context, str);
    }

    public static void getEGidByCallback(Context context, boolean z, final ResponseDfpCallbackProxy responseDfpCallbackProxy) {
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.sdk.liteapi.KsSecSDKWrapper.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i, String str) {
                ResponseDfpCallbackProxy responseDfpCallbackProxy2 = ResponseDfpCallbackProxy.this;
                if (responseDfpCallbackProxy2 != null) {
                    responseDfpCallbackProxy2.onFailed(i, str);
                }
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                ResponseDfpCallbackProxy responseDfpCallbackProxy2 = ResponseDfpCallbackProxy.this;
                if (responseDfpCallbackProxy2 != null) {
                    responseDfpCallbackProxy2.onSuccess(str, str2);
                }
            }
        });
    }

    public static void handlePolicy(JSONObject jSONObject) {
        a.handlePolicy(jSONObject);
    }

    public static boolean setEgid(Context context, String str) {
        return KWEGIDDFP.instance().setEgid(context, str);
    }
}
