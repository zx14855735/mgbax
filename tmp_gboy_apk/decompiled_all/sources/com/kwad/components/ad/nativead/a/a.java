package com.kwad.components.ad.nativead.a;

import ADYaiT.CtFAbx;
import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class a extends Presenter {
    public l mVideoPlayStateListener;
    public b pp;

    public static void a(View view, String str) {
        if (view == null) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException(CtFAbx.BChYOn(" findViewById failed ", str)));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        this.pp = (b) PC();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.pp.pq.a(this.mVideoPlayStateListener);
    }
}
