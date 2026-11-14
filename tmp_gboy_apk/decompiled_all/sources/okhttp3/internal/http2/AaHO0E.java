package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AaHO0E extends okhttp3.internal.A4TApA {
    final /* synthetic */ AmA8tU this$0;
    final /* synthetic */ boolean val$inFinished;
    final /* synthetic */ List val$requestHeaders;
    final /* synthetic */ int val$streamId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AaHO0E(AmA8tU amA8tU, String str, Object[] objArr, int i, List list, boolean z) {
        super(str, objArr);
        this.this$0 = amA8tU;
        this.val$streamId = i;
        this.val$requestHeaders = list;
        this.val$inFinished = z;
    }

    @Override // okhttp3.internal.A4TApA
    public final void execute() {
        this.this$0.pushObserver.getClass();
        try {
            this.this$0.writer.AZOQYO(this.val$streamId, A4TApA.CANCEL);
            synchronized (this.this$0) {
                this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
            }
        } catch (IOException unused) {
        }
    }
}
