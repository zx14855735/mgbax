package LHpdLt;

import android.os.CountDownTimer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BChYOn extends CountDownTimer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ BI9f7h f4538A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ BIYEnU f4539A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BChYOn(BIYEnU bIYEnU, long j, BI9f7h bI9f7h) {
        super(j, 1000L);
        this.f4539A4TApA = bIYEnU;
        this.f4538A2egSU = bI9f7h;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        this.f4539A4TApA.getClass();
        BI9f7h bI9f7h = this.f4538A2egSU;
        bI9f7h.f4542AmA8tU.setEnabled(true);
        bI9f7h.f4542AmA8tU.setText("邀请");
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        this.f4538A2egSU.f4542AmA8tU.setText(Math.max(1L, j / 1000) + "s");
    }
}
