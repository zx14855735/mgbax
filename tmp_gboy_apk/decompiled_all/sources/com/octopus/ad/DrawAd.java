package com.octopus.ad;

import android.content.Context;
import com.octopus.ad.AdRequest;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class DrawAd implements AdLifeControl, IBidding {

    /* renamed from: a, reason: collision with root package name */
    private final com.octopus.ad.internal.nativead.a f12330a;

    public DrawAd(Context context, String str, DrawAdListener drawAdListener) {
        com.octopus.ad.internal.nativead.a aVar = new com.octopus.ad.internal.nativead.a(context == null ? q.a().j() : context, str, p.DRAW);
        this.f12330a = aVar;
        aVar.a(drawAdListener);
    }

    @Override // com.octopus.ad.AdLifeControl
    public void cancel() {
        com.octopus.ad.internal.nativead.a aVar = this.f12330a;
        if (aVar != null) {
            aVar.l();
            this.f12330a.f12446a.a();
        }
    }

    @Override // com.octopus.ad.AdLifeControl
    public void destroy() {
        cancel();
    }

    public String getAdSlotId() {
        return this.f12330a.c();
    }

    public int getPrice() {
        com.octopus.ad.internal.nativead.a aVar = this.f12330a;
        if (aVar == null) {
            return 0;
        }
        return aVar.d();
    }

    public String getRequestId() {
        return this.f12330a.h();
    }

    public String getTagId() {
        com.octopus.ad.internal.nativead.a aVar = this.f12330a;
        if (aVar == null) {
            return null;
        }
        return aVar.e();
    }

    public boolean isLoaded() {
        return this.f12330a.f();
    }

    public boolean isValid() {
        return isLoaded() && this.f12330a.g();
    }

    public void loadAd() {
        this.f12330a.a(new AdRequest.Builder().build().a());
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onDestroyLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onResumeLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onStopLifeCycle() {
    }

    public void openAdInNativeBrowser(boolean z) {
        this.f12330a.b(z);
    }

    @Override // com.octopus.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        com.octopus.ad.internal.nativead.a aVar = this.f12330a;
        if (aVar == null) {
            return;
        }
        aVar.sendLossNotice(i, str, str2);
    }

    @Override // com.octopus.ad.IBidding
    public void sendWinNotice(int i) {
        com.octopus.ad.internal.nativead.a aVar = this.f12330a;
        if (aVar == null) {
            return;
        }
        aVar.sendWinNotice(i);
    }

    public void setAdSlotId(String str) {
        this.f12330a.a(str);
    }

    public void setChannel(String str) {
        this.f12330a.c(str);
    }

    public void setRequestId(String str) {
        this.f12330a.d(str);
    }
}
