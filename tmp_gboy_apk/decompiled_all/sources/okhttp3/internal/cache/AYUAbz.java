package okhttp3.internal.cache;

import okhttp3.internal.cache.AMqCpz;
import okio.Sink;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AYUAbz extends AZOQYO {
    final /* synthetic */ AMqCpz.A4TApA this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AYUAbz(AMqCpz.A4TApA a4TApA, Sink sink) {
        super(sink);
        this.this$1 = a4TApA;
    }

    @Override // okhttp3.internal.cache.AZOQYO
    public final void A2egSU() {
        synchronized (AMqCpz.this) {
            this.this$1.A5SV6n();
        }
    }
}
