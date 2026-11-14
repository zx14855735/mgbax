package okhttp3.internal.http;

import okhttp3.Request;
import okhttp3.Response;
import okio.Sink;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface A5SV6n {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void A2egSU();

    void A4TApA(Request request);

    AYUAbz A5SV6n(Response response);

    Response.Builder ADYaiT(boolean z);

    void AMqCpz();

    Sink ARc23Z(Request request, long j);

    void cancel();
}
