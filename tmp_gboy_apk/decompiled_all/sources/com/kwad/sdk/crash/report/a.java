package com.kwad.sdk.crash.report;

import com.kwad.sdk.core.report.n;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static void b(ExceptionMessage exceptionMessage) {
        n nVar = new n(10211L);
        nVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.g.a2(nVar);
    }
}
