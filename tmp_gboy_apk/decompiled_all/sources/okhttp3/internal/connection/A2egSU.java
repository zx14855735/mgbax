package okhttp3.internal.connection;

import com.baidu.mobads.sdk.internal.an;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU implements Interceptor {
    public final OkHttpClient client;

    public A2egSU(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        okhttp3.internal.http.ASJ6gh aSJ6gh = (okhttp3.internal.http.ASJ6gh) chain;
        Request request = aSJ6gh.request();
        AYUAbz ADYaiT2 = aSJ6gh.ADYaiT();
        return aSJ6gh.A5SV6n(request, ADYaiT2, ADYaiT2.AZOQYO(this.client, chain, !request.method().equals(an.c)), ADYaiT2.ADYaiT());
    }
}
