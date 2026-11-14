package com.kwad.components.core.innerEc.followuser;

import ADYaiT.CtFAbx;
import com.baidu.mobads.sdk.internal.cb;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.Callback;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d {
    public static void a(String str, final Callback callback) {
        final Map<String, String> qK = f.qK();
        if (qK == null) {
            a(callback, "-100", "user not login");
            return;
        }
        b ay = ay(str);
        if (ay == null) {
            a(callback, "-101", CtFAbx.BChYOn("params from h5 not legal: ", str));
        } else {
            final a ax = a.ax(ay.Sb);
            new l<c, FollowUserResultData>() { // from class: com.kwad.components.core.innerEc.followuser.d.1
                private static FollowUserResultData az(String str2) {
                    FollowUserResultData followUserResultData = new FollowUserResultData();
                    followUserResultData.parseJson(new JSONObject(str2));
                    return followUserResultData;
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                /* renamed from: rd, reason: merged with bridge method [inline-methods] */
                public c createRequest() {
                    return new c(qK, ax);
                }

                @Override // com.kwad.sdk.core.network.l
                public final /* synthetic */ FollowUserResultData parseData(String str2) {
                    return az(str2);
                }
            }.request(new g<c, FollowUserResultData>() { // from class: com.kwad.components.core.innerEc.followuser.d.2
                private static void a(c cVar) {
                    com.kwad.sdk.core.d.c.w("FollowUserRequestHelper", "onStartRequest: " + cVar.getUrl());
                }

                private void l(int i, String str2) {
                    Callback callback2 = Callback.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    d.a(callback2, sb.toString(), str2);
                }

                private void re() {
                    d.a(Callback.this, cb.o);
                }

                @Override // com.kwad.sdk.core.network.g
                public final /* synthetic */ void onError(c cVar, int i, String str2) {
                    l(i, str2);
                }

                @Override // com.kwad.sdk.core.network.g
                public final /* synthetic */ void onStartRequest(c cVar) {
                    a(cVar);
                }

                @Override // com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(c cVar, FollowUserResultData followUserResultData) {
                    re();
                }
            });
        }
    }

    private static b ay(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Callback callback, final String str, final String str2) {
        com.kwad.sdk.core.d.c.w("FollowUserRequestHelper", "notifyError errorCode: " + str + ", errorMsg: " + str2);
        if (callback != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.followuser.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    Callback.this.onFail(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Callback callback, final String str) {
        com.kwad.sdk.core.d.c.w("FollowUserRequestHelper", "notifySuccess: ");
        if (callback != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.followuser.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    Callback.this.onSuccess(str);
                }
            });
        }
    }
}
