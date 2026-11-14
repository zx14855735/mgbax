package com.kwad.sdk.mobileid.a;

import android.annotation.SuppressLint;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.al;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b extends d {
    private static String aYk;

    private static String Pu() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String Pv() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    private static String Pw() {
        return "300012755841";
    }

    private static String Px() {
        return "CB607A51A7A639E532D288AB8C963DB6";
    }

    private static String am(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        A2egSU.BIYEnU(sb, Pw(), str, str2, "2.0");
        sb.append(Px());
        return al.md5(sb.toString());
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        try {
            aYk = Pu();
            String Pv = Pv();
            String am = am(Pv, aYk);
            putBody("timestamp", Pv);
            putBody("sign", am);
            putBody("traceId", aYk);
            putBody(MedProConst.AD_APPID, Pw());
            putBody("interfaceVersion", "2.0");
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.CK();
    }
}
