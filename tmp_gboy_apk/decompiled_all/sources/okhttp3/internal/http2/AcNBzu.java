package okhttp3.internal.http2;

import java.io.IOException;
import okio.Buffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AcNBzu extends okhttp3.internal.A4TApA {
    final /* synthetic */ AmA8tU this$0;
    final /* synthetic */ Buffer val$buffer;
    final /* synthetic */ int val$byteCount;
    final /* synthetic */ boolean val$inFinished;
    final /* synthetic */ int val$streamId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcNBzu(AmA8tU amA8tU, String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
        super(str, objArr);
        this.this$0 = amA8tU;
        this.val$streamId = i;
        this.val$buffer = buffer;
        this.val$byteCount = i2;
        this.val$inFinished = z;
    }

    @Override // okhttp3.internal.A4TApA
    public final void execute() {
        try {
            BI9f7h bI9f7h = this.this$0.pushObserver;
            Buffer buffer = this.val$buffer;
            int i = this.val$byteCount;
            ((BChYOn) bI9f7h).getClass();
            buffer.skip(i);
            this.this$0.writer.AZOQYO(this.val$streamId, A4TApA.CANCEL);
            synchronized (this.this$0) {
                this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
            }
        } catch (IOException unused) {
        }
    }
}
