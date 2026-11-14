package okhttp3.internal.connection;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ARc23Z extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    public ARc23Z(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public final void A2egSU(IOException iOException) {
        okhttp3.internal.A5SV6n.A2egSU(this.firstException, iOException);
        this.lastException = iOException;
    }

    public final IOException A4TApA() {
        return this.firstException;
    }

    public final IOException A5SV6n() {
        return this.lastException;
    }
}
