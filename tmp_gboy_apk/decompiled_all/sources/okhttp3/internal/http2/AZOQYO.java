package okhttp3.internal.http2;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AZOQYO extends okhttp3.internal.A4TApA {
    final /* synthetic */ AmA8tU this$0;
    final /* synthetic */ int val$streamId;
    final /* synthetic */ long val$unacknowledgedBytesRead;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AZOQYO(AmA8tU amA8tU, String str, Object[] objArr, int i, long j) {
        super(str, objArr);
        this.this$0 = amA8tU;
        this.val$streamId = i;
        this.val$unacknowledgedBytesRead = j;
    }

    @Override // okhttp3.internal.A4TApA
    public final void execute() {
        try {
            this.this$0.writer.AcNBzu(this.val$streamId, this.val$unacknowledgedBytesRead);
        } catch (IOException unused) {
            AmA8tU amA8tU = this.this$0;
            int i = AmA8tU.OKHTTP_CLIENT_WINDOW_SIZE;
            amA8tU.AMqCpz();
        }
    }
}
