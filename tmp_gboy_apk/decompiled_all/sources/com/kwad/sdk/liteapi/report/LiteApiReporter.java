package com.kwad.sdk.liteapi.report;

import A5SV6n.A2egSU;
import android.content.Context;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.report.LiteReportHttp;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class LiteApiReporter {
    private static final String REPORT_URL = "https://open.e.kuaishou.com/rest/e/v3/open/logDex";
    private static final String TAG = "LiteApiReporter";

    public static void reportDexError(Context context, String str, int i) {
        LiteApiLogger.w(TAG, "reportDexError dexErrorCode: " + i);
        try {
            LiteApiReportRequest newInstance = LiteApiReportRequest.newInstance(context, str, i);
            LiteReportHttp liteReportHttp = new LiteReportHttp(REPORT_URL);
            LiteApiLogger.w(TAG, "reportDexError before  reportHttp.request ");
            liteReportHttp.request(context, newInstance, new LiteReportHttp.a() { // from class: com.kwad.sdk.liteapi.report.LiteApiReporter.1
                @Override // com.kwad.sdk.liteapi.report.LiteReportHttp.a
                public final void a(LiteApiReportResponse liteApiReportResponse) {
                    LiteApiLogger.w(LiteApiReporter.TAG, "reportDexError request onSuccess: " + liteApiReportResponse);
                }

                @Override // com.kwad.sdk.liteapi.report.LiteReportHttp.a
                public final void b(Exception exc) {
                    LiteApiLogger.w(LiteApiReporter.TAG, "reportDexError request onError: " + exc.getMessage());
                    exc.printStackTrace();
                }
            });
        } catch (Throwable th) {
            LiteApiLogger.w(TAG, "reportDexError  error: " + th.getMessage());
            th.printStackTrace();
        }
    }
}
