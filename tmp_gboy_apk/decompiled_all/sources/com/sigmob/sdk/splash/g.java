package com.sigmob.sdk.splash;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class g extends b {
    private final com.sigmob.sdk.base.views.c b;
    private final BaseAdUnit c;

    public g(Context context, BaseAdUnit baseAdUnit) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.sigmob.sdk.base.views.c cVar = new com.sigmob.sdk.base.views.c(context);
        this.b = cVar;
        setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.c = baseAdUnit;
        addView(cVar, layoutParams);
    }

    @Override // com.sigmob.sdk.splash.b
    public void a() {
        super.setVisibility(0);
        SigmobLog.i("video showAd");
        this.b.setVisibility(0);
        this.b.d();
    }

    @Override // com.sigmob.sdk.splash.b
    public void b() {
        this.b.a();
    }

    @Override // com.sigmob.sdk.splash.b
    public void c() {
        this.b.b();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            try {
                if (this.b != null) {
                    SigmobLog.i("video GONE");
                    this.b.c();
                    removeAllViews();
                }
            } catch (Throwable th) {
                com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("set splash ad video content error: "));
            }
        }
        super.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MediaPlayer mediaPlayer) {
        this.f13669a = mediaPlayer.getDuration() / 1000;
        mediaPlayer.setVolume(0.0f, 0.0f);
        mediaPlayer.start();
        BaseBroadcastReceiver.a(getContext(), this.c.getUuid(), IntentActions.ACTION_INTERSTITIAL_SHOW);
        SigmobLog.i("video onPrepared");
    }

    @Override // com.sigmob.sdk.splash.b
    public boolean a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || baseAdUnit.getSplashFilePath() == null) {
            SigmobLog.e("adUnit or splashFilePath is null");
            return false;
        }
        this.b.a(0, 0);
        this.b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.sigmob.sdk.splash.ADYaiT
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                g.this.a(mediaPlayer);
            }
        });
        this.b.setVideoPath(baseAdUnit.getSplashFilePath());
        return true;
    }
}
