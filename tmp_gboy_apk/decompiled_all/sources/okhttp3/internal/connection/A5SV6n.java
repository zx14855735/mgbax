package okhttp3.internal.connection;

import okhttp3.internal.ws.A2egSU;
import okio.BufferedSink;
import okio.BufferedSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class A5SV6n extends A2egSU.ARc23Z {
    final /* synthetic */ ADYaiT this$0;
    final /* synthetic */ AYUAbz val$streamAllocation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A5SV6n(ADYaiT aDYaiT, boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink, AYUAbz aYUAbz) {
        super(z, bufferedSource, bufferedSink);
        this.this$0 = aDYaiT;
        this.val$streamAllocation = aYUAbz;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AYUAbz aYUAbz = this.val$streamAllocation;
        aYUAbz.AzWtSf(true, aYUAbz.A5SV6n(), -1L, null);
    }
}
