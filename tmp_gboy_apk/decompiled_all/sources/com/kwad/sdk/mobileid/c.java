package com.kwad.sdk.mobileid;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private static String traceId;

    private static void A(final com.kwad.sdk.commercial.c.a aVar) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.sdk.mobileid.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (com.kwad.sdk.commercial.c.a.this != null) {
                    com.kwad.sdk.core.d.c.d("UAIDMonitor", "asyncReport json: " + com.kwad.sdk.commercial.c.a.this.toJson().toString());
                }
                com.kwad.sdk.commercial.c.y(com.kwad.sdk.commercial.c.a.this);
            }
        });
    }

    public static void a(Context context, d dVar) {
        traceId = UUID.randomUUID().toString();
        A(a(context, 1, dVar));
    }

    public static void b(Context context, d dVar) {
        A(a(context, 2, dVar));
    }

    public static void c(Context context, d dVar) {
        A(a(context, 4, dVar));
    }

    public static void b(Context context, int i, String str) {
        UaidInfo a2 = a(context, 3, new d(false, "uaidTokenCanRequest"));
        a2.token = null;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        a2.errorCode = sb.toString();
        a2.errorMsg = str;
        a2.result = 0;
        A(a2);
    }

    public static void c(Context context, int i, String str) {
        UaidInfo a2 = a(context, 5, new d(false, "uaidTokenCanRequest"));
        a2.uaid = null;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        a2.errorCode = sb.toString();
        a2.errorMsg = str;
        a2.result = 0;
        A(a2);
    }

    public static void a(Context context, CMTokenResponse cMTokenResponse) {
        UaidInfo a2 = a(context, 3, new d(true, "uaidTokenCanRequest"));
        a2.token = cMTokenResponse.getResultToken();
        a2.errorCode = cMTokenResponse.getResultCode();
        a2.errorMsg = cMTokenResponse.getResultMsg();
        a2.result = !TextUtils.isEmpty(a2.token) ? 1 : 0;
        A(a2);
    }

    public static void a(Context context, UaidTokenResponse uaidTokenResponse) {
        UaidInfo a2 = a(context, 5, new d(true, "uaidTokenCanRequest"));
        a2.uaid = uaidTokenResponse.uaid;
        StringBuilder sb = new StringBuilder();
        sb.append(uaidTokenResponse.result);
        a2.errorCode = sb.toString();
        a2.errorMsg = uaidTokenResponse.errorMsg;
        a2.result = !TextUtils.isEmpty(a2.token) ? 1 : 0;
        A(a2);
    }

    private static UaidInfo a(Context context, int i, d dVar) {
        boolean useNetworkStateDisable = bc.useNetworkStateDisable();
        boolean usePhoneStateDisable = bc.usePhoneStateDisable();
        String dF = bd.dF(context);
        return UaidInfo.newBuilder().et(i).gF(traceId).gE(dVar.Po()).gG(dVar.Pp()).eu(ao.e(context, dF, useNetworkStateDisable)).ev(ao.dp(context)).bS((dF == null || TextUtils.isEmpty(dF.trim())) ? false : true).bQ(!useNetworkStateDisable).bR(!usePhoneStateDisable).Pq();
    }
}
