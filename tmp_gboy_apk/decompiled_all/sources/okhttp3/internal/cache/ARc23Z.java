package okhttp3.internal.cache;

import okio.Sink;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ARc23Z extends AZOQYO {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final /* synthetic */ AMqCpz this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ARc23Z(AMqCpz aMqCpz, Sink sink) {
        super(sink);
        this.this$0 = aMqCpz;
    }

    @Override // okhttp3.internal.cache.AZOQYO
    public final void A2egSU() {
        this.this$0.hasJournalErrors = true;
    }
}
