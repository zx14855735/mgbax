package okhttp3.internal.http2;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AYUAbz extends okhttp3.internal.A4TApA {
    final /* synthetic */ AmA8tU this$0;
    final /* synthetic */ A4TApA val$errorCode;
    final /* synthetic */ int val$streamId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AYUAbz(AmA8tU amA8tU, String str, Object[] objArr, int i, A4TApA a4TApA) {
        super(str, objArr);
        this.this$0 = amA8tU;
        this.val$streamId = i;
        this.val$errorCode = a4TApA;
    }

    @Override // okhttp3.internal.A4TApA
    public final void execute() {
        try {
            AmA8tU amA8tU = this.this$0;
            amA8tU.writer.AZOQYO(this.val$streamId, this.val$errorCode);
        } catch (IOException unused) {
            AmA8tU amA8tU2 = this.this$0;
            int i = AmA8tU.OKHTTP_CLIENT_WINDOW_SIZE;
            amA8tU2.AMqCpz();
        }
    }
}
