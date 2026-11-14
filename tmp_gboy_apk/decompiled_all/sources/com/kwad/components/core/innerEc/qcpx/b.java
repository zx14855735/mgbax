package com.kwad.components.core.innerEc.qcpx;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.kwad.components.core.innerEc.f;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, final Context context, final int i, final String str, final String str2) {
        int i2 = 4;
        if (!l.HTTP_CODE_ERROR_MSG.equals(str) && i != e.aJa.errorCode) {
            int i3 = e.aJb.errorCode;
            i2 = 3;
        }
        c.q(adTemplate, i2);
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.qcpx.b.3
            @Override // java.lang.Runnable
            public final void run() {
                String str3 = str2;
                if (!TextUtils.isEmpty(str)) {
                    str3 = str;
                }
                com.kwad.sdk.core.d.c.w("ReceiveQcpxRequestHelper", "notifyError errorCode: " + i + ", errorMsg: " + str + ", defaultToast: " + str2 + ", targetToast: " + str3);
                ac.c(context, str3, 0);
            }
        });
    }

    public static void h(final Context context, final AdTemplate adTemplate) {
        final Map<String, String> qK = f.qK();
        if (qK == null) {
            com.kwad.sdk.core.d.c.d("ReceiveQcpxRequestHelper", "requestReceiveQcpx: map is null");
            return;
        }
        if (adTemplate == null) {
            com.kwad.sdk.core.d.c.d("ReceiveQcpxRequestHelper", "requestReceiveQcpx: adTemplate is null");
            return;
        }
        if (!com.kwad.sdk.core.response.b.a.dB(com.kwad.sdk.core.response.b.e.er(adTemplate))) {
            com.kwad.sdk.core.d.c.d("ReceiveQcpxRequestHelper", "requestReceiveQcpx: there is no qcpx");
            return;
        }
        final ReceiveQcpxBody newInstance = ReceiveQcpxBody.newInstance(adTemplate);
        final String str = newInstance.receiveToast;
        final String str2 = newInstance.receiveFailToast;
        new l<a, ReceiveQcpxResultData>() { // from class: com.kwad.components.core.innerEc.qcpx.b.1
            private static ReceiveQcpxResultData aA(String str3) {
                ReceiveQcpxResultData receiveQcpxResultData = new ReceiveQcpxResultData();
                receiveQcpxResultData.parseJson(new JSONObject(str3));
                return receiveQcpxResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: rf, reason: merged with bridge method [inline-methods] */
            public a createRequest() {
                return new a(qK, newInstance);
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ ReceiveQcpxResultData parseData(String str3) {
                return aA(str3);
            }
        }.request(new g<a, ReceiveQcpxResultData>() { // from class: com.kwad.components.core.innerEc.qcpx.b.2
            private static void a(a aVar) {
                com.kwad.sdk.core.d.c.w("ReceiveQcpxRequestHelper", "request onStartRequest: " + aVar.getUrl());
            }

            private void m(int i, String str3) {
                com.kwad.sdk.core.d.c.w("ReceiveQcpxRequestHelper", "request onError: errorCode: " + i + ", errorMsg: " + str3);
                b.a(AdTemplate.this, context, i, str3, str2);
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(a aVar, int i, String str3) {
                m(i, str3);
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* synthetic */ void onStartRequest(a aVar) {
                a(aVar);
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(a aVar, ReceiveQcpxResultData receiveQcpxResultData) {
                a(receiveQcpxResultData);
            }

            private void a(ReceiveQcpxResultData receiveQcpxResultData) {
                com.kwad.sdk.core.d.c.w("ReceiveQcpxRequestHelper", "request onSuccess: " + receiveQcpxResultData.errorMsg);
                b.a(AdTemplate.this, context, cb.o, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, final Context context, final String str, final String str2) {
        c.ch(adTemplate);
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.qcpx.b.4
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.w("ReceiveQcpxRequestHelper", "notifySuccess: " + str + ", toast: " + str2);
                ac.c(context, str2, 0);
            }
        });
    }
}
