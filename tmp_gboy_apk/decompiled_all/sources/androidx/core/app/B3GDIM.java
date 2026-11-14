package androidx.core.app;

import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM implements B4ZgIw {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Intent f8490A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f8491A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ BIYEnU f8492A5SV6n;

    public B3GDIM(BIYEnU bIYEnU, Intent intent, int i) {
        this.f8492A5SV6n = bIYEnU;
        this.f8490A2egSU = intent;
        this.f8491A4TApA = i;
    }

    @Override // androidx.core.app.B4ZgIw
    public final void complete() {
        this.f8492A5SV6n.stopSelf(this.f8491A4TApA);
    }

    @Override // androidx.core.app.B4ZgIw
    public final Intent getIntent() {
        return this.f8490A2egSU;
    }
}
