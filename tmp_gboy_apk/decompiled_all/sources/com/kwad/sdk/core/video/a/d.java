package com.kwad.sdk.core.video.a;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean aPe;
    private static final Queue<d> aPf = new ConcurrentLinkedQueue();
    private final String TAG;
    private MediaDataSource aPa;
    private final KSVodPlayerWrapper aPb;
    private final a aPc;
    private boolean aPd;
    private boolean aPg;
    private com.kwad.sdk.contentalliance.a.a.b adK;
    private final Object aeG;
    private String aeH;
    private boolean aeM;
    private boolean aeN;
    private int mSarDen;
    private int mSarNum;

    public static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<d> mWeakMediaPlayer;

        public a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        private d LR() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i) {
            d LR = LR();
            if (LR != null) {
                LR.notifyOnBufferingUpdate(i);
            }
        }

        public final void onError(int i, int i2) {
            d LR = LR();
            if (LR != null) {
                d.a(LR, false);
                LR.notifyOnError(i, i2);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i, int i2) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onEvent, what: " + i);
            try {
                d LR = LR();
                if (LR != null) {
                    if (i == 10100) {
                        LR.notifyOnSeekComplete();
                    } else {
                        if (i == 10101) {
                            LR.notifyOnCompletion();
                            return;
                        }
                        if (i == 10209) {
                            LR.LQ();
                        }
                        LR.notifyOnInfo(i, i2);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPrepared");
            d LR = LR();
            if (LR != null) {
                LR.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            String str = this.TAG;
            StringBuilder B7CMnp2 = A2egSU.B7CMnp(i, i2, "onVideoSizeChanged width: ", ", height: ", ", sarNum:");
            B7CMnp2.append(i3);
            B7CMnp2.append(", sarDen:");
            B7CMnp2.append(i4);
            com.kwad.sdk.core.d.c.i(str, B7CMnp2.toString());
            d LR = LR();
            if (LR != null) {
                LR.y(i, i2);
                LR.mSarNum = i3;
                LR.mSarDen = i4;
            }
        }
    }

    static {
        acxCaLO();
    }

    public d(int i) {
        Object obj = new Object();
        this.aeG = obj;
        this.aeN = false;
        this.aPg = true;
        synchronized (obj) {
            this.aPb = new KSVodPlayerWrapper(m.US());
        }
        String ASJ6gh2 = CtFAbx.ASJ6gh(i, "KSMediaPlayer[", "]");
        this.TAG = ASJ6gh2;
        this.aPc = new a(this, ASJ6gh2);
        vy();
        setLooping(false);
        com.kwad.sdk.core.d.c.i(ASJ6gh2, "create KwaiMediaPlayer");
    }

    private void LO() {
        MediaDataSource mediaDataSource = this.aPa;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aPa = null;
        }
    }

    private void LP() {
        com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare hasCallPrepare: " + this.aeN);
        if (this.aeN) {
            return;
        }
        try {
            this.aeN = true;
            int prepareAsync = this.aPb.prepareAsync();
            LN();
            com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare result: " + prepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.d.c.e(this.TAG, "realPrepare failed ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LQ() {
        Iterator<d> it = aPf.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i++;
            }
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "preloadNextPlayer next player index: " + i);
        int i2 = i + 1;
        if (i2 < aPf.size()) {
            com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i3 = 0; i3 < i2; i3++) {
                aPf.poll();
            }
            Queue<d> queue = aPf;
            d poll = queue.poll();
            queue.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    private static /* synthetic */ void acxCaLO() {
        char[] charArray = "ôøú¹ðöúò¹õøî¹äÿòûû¹ÝùþÕåþóðò".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 151);
        }
        String str = new String(charArray);
        char[] charArray2 = "ôûþùþã".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 151);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void vy() {
        this.aPb.setOnPreparedListener(this.aPc);
        this.aPb.setBufferingUpdateListener(this.aPc);
        this.aPb.setOnEventListener(this.aPc);
        this.aPb.setVideoSizeChangedListener(this.aPc);
        this.aPb.setOnErrorListener(this.aPc);
    }

    private void vz() {
        this.aPb.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aPb.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aPb.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aPb.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aPb.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    public final void by(boolean z) {
        this.aPg = z;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aPb.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aPb;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aPb.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aeH;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aPb.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aPb.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aPb.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aPd;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aPb.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aPb.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (!this.aPg) {
            LP();
            return true;
        }
        Queue<d> queue = aPf;
        if (!queue.contains(this)) {
            queue.offer(this);
        }
        int size = queue.size();
        if (size == 1) {
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync first");
            LP();
            return true;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync pending size: " + size);
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = aPf;
        boolean remove = queue.remove(this);
        com.kwad.sdk.core.d.c.i(this.TAG, "release remote player ret: " + remove + ", player list size: " + queue.size());
        this.aeM = true;
        this.aPb.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            LO();
            resetListeners();
            vz();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aeN = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aPb.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        LO();
        resetListeners();
        vy();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        this.aPb.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aeG) {
            try {
                if (!this.aeM) {
                    this.aPb.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.aPd = z;
        this.aPb.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        this.aPb.setSpeed(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aPb.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.aPb.setVolume(f, f2);
        com.kwad.sdk.core.video.a.a.l(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.d.c.i(this.TAG, "start");
        this.aPb.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aPb.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean vx() {
        com.kwad.sdk.core.d.c.i(this.TAG, "forcePrepareAsync");
        LP();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aeN = false;
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.adK = bVar;
        a(bVar.aAX);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.xO()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aPb == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.FZ();
        this.aPb.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aeH = str;
        this.aPb.setDataSource(str, (Map) null);
    }
}
