package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.AmA8tU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AzWtSf extends okhttp3.internal.A4TApA {
    final /* synthetic */ AmA8tU.ADYaiT this$1;
    final /* synthetic */ B4ZgIw val$newStream;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AzWtSf(AmA8tU.ADYaiT aDYaiT, String str, Object[] objArr, B4ZgIw b4ZgIw) {
        super(str, objArr);
        this.this$1 = aDYaiT;
        this.val$newStream = b4ZgIw;
    }

    @Override // okhttp3.internal.A4TApA
    public final void execute() {
        try {
            AmA8tU.this.listener.A4TApA(this.val$newStream);
        } catch (IOException e) {
            okhttp3.internal.platform.ARc23Z.AZOQYO().AmA8tU(4, "Http2Connection.Listener failure for " + AmA8tU.this.hostname, e);
            try {
                this.val$newStream.ADYaiT(A4TApA.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}
