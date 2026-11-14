package okhttp3.internal.http2;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class BJ7GGh extends IOException {
    public final A4TApA errorCode;

    public BJ7GGh(A4TApA a4TApA) {
        super("stream was reset: " + a4TApA);
        this.errorCode = a4TApA;
    }
}
