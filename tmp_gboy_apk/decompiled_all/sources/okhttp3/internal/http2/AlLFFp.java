package okhttp3.internal.http2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AlLFFp extends okhttp3.internal.A4TApA {
    final /* synthetic */ AmA8tU this$0;
    final /* synthetic */ A4TApA val$errorCode;
    final /* synthetic */ int val$streamId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlLFFp(AmA8tU amA8tU, String str, Object[] objArr, int i, A4TApA a4TApA) {
        super(str, objArr);
        this.this$0 = amA8tU;
        this.val$streamId = i;
        this.val$errorCode = a4TApA;
    }

    @Override // okhttp3.internal.A4TApA
    public final void execute() {
        this.this$0.pushObserver.getClass();
        synchronized (this.this$0) {
            this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
        }
    }
}
