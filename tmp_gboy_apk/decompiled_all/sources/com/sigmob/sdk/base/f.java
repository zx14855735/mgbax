package com.sigmob.sdk.base;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f extends e {
    private OkHttpClient.Builder b;
    private OkHttpClient c;

    public f() {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            this.b = builder;
            builder.connectionPool(new ConnectionPool());
            OkHttpClient.Builder builder2 = this.b;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder2.connectTimeout(PushUIConfig.dismissTime, timeUnit);
            this.b.readTimeout(PushUIConfig.dismissTime, timeUnit);
            this.b.writeTimeout(PushUIConfig.dismissTime, timeUnit);
            this.c = this.b.build();
        } catch (Throwable unused) {
        }
    }

    @Override // com.sigmob.sdk.base.e
    public WebResourceResponse a(String str, String str2, Map<String, String> map) {
        if ((!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) || str2.equals(an.b)) {
            return null;
        }
        try {
            String host = Uri.parse(str).getHost();
            if (host != null && !host.equals("127.0.0.1") && !host.equals("localhost")) {
                Request.Builder url = new Request.Builder().url(str);
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        url.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                String cookie = CookieManager.getInstance().getCookie(str);
                if (!TextUtils.isEmpty(cookie)) {
                    for (String str3 : cookie.split(";")) {
                        url.addHeader(e.f13172a.toLowerCase(), str3.replace(" ", ""));
                    }
                }
                Response execute = this.c.newCall(url.build()).execute();
                return new WebResourceResponse(execute.body().contentType().type() + "/" + execute.body().contentType().subtype(), execute.header("content-encoding", "utf-8"), execute.body().byteStream());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return super.a(str, str2, map);
        }
    }
}
