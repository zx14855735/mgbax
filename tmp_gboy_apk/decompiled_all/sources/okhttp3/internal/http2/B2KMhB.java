package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.AmA8tU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class B2KMhB extends okhttp3.internal.A4TApA {
    final /* synthetic */ AmA8tU.ADYaiT this$1;
    final /* synthetic */ BIYEnU val$peerSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B2KMhB(AmA8tU.ADYaiT aDYaiT, String str, Object[] objArr, BIYEnU bIYEnU) {
        super(str, objArr);
        this.this$1 = aDYaiT;
        this.val$peerSettings = bIYEnU;
    }

    @Override // okhttp3.internal.A4TApA
    public final void execute() {
        try {
            AmA8tU.this.writer.A2egSU(this.val$peerSettings);
        } catch (IOException unused) {
            AmA8tU amA8tU = AmA8tU.this;
            int i = AmA8tU.OKHTTP_CLIENT_WINDOW_SIZE;
            amA8tU.AMqCpz();
        }
    }
}
