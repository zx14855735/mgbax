package okhttp3.internal.cache;

import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface AZkASS {
    Response get(Request request);

    A5SV6n put(Response response);

    void remove(Request request);

    void trackConditionalCacheHit();

    void trackResponse(ADYaiT aDYaiT);

    void update(Response response, Response response2);
}
