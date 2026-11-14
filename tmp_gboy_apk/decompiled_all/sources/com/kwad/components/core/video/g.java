package com.kwad.components.core.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.sigmob.sdk.base.n;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class g extends com.kwad.sdk.core.video.a.a {
    private static AtomicBoolean aeL = new AtomicBoolean(false);
    private String aeH;
    private com.kwad.components.core.offline.a.b.a aeJ;
    private IAdWaynePlayerPlayModule aeK;
    private AdTemplate mAdTemplate;
    private final String TAG = "KwaiWaynePlayer";
    private final Object aeG = new Object();
    private boolean aeM = false;
    private boolean aeN = false;
    private boolean aeO = false;
    private final a aeI = new a(this, "KwaiWaynePlayer");

    public static class a implements IAdWaynePlayerPlayModule.OnBufferingUpdateListener, IAdWaynePlayerPlayModule.OnCompletionListener, IAdWaynePlayerPlayModule.OnErrorListener, IAdWaynePlayerPlayModule.OnInfoListener, IAdWaynePlayerPlayModule.OnPreparedListener, IAdWaynePlayerPlayModule.OnSeekCompleteListener, IAdWaynePlayerPlayModule.OnVideoSizeChangedListener, IAdWaynePlayerPlayModule.OnVseReportListener {
        final String TAG;
        final WeakReference<g> mWeakMediaPlayer;

        public a(g gVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(gVar);
            this.TAG = str;
        }

        private g vA() {
            return this.mWeakMediaPlayer.get();
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnBufferingUpdateListener
        public final void onBufferingUpdate(int i) {
            g vA = vA();
            if (vA != null) {
                vA.notifyOnBufferingUpdate(i);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnCompletionListener
        public final void onCompletion() {
            g vA = vA();
            if (vA != null) {
                vA.notifyOnCompletion();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnErrorListener
        public final boolean onError(int i, int i2) {
            g vA = vA();
            if (vA != null) {
                return vA.notifyOnError(i, i2);
            }
            return false;
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnInfoListener
        public final boolean onInfo(int i, int i2) {
            g vA = vA();
            if (vA == null) {
                return false;
            }
            if (i != 3) {
                return vA.notifyOnInfo(i, i2);
            }
            if (vA.aeO) {
                return false;
            }
            g.a(vA, true);
            return vA.notifyOnInfo(i, i2);
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnPreparedListener
        public final void onPrepared() {
            g vA = vA();
            if (vA != null) {
                vA.notifyOnPrepared();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnSeekCompleteListener
        public final void onSeekComplete() {
            g vA = vA();
            if (vA != null) {
                vA.notifyOnSeekComplete();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(int i, int i2) {
            g vA = vA();
            if (vA != null) {
                vA.y(i, i2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVseReportListener
        public final void onVseReport(String str, String str2) {
            g vA = vA();
            if (vA != null) {
                vA.n(str, str2);
            }
        }
    }

    static {
        vFWnQLY();
    }

    public g(com.kwad.sdk.contentalliance.a.a.b bVar, AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        com.kwad.components.core.offline.a.b.a aVar = (com.kwad.components.core.offline.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.b.a.class);
        this.aeJ = aVar;
        if (aVar == null || !aVar.rn()) {
            return;
        }
        if (TextUtils.isEmpty(bVar.manifest)) {
            String str = bVar.videoUrl;
            this.aeH = str;
            this.aeK = this.aeJ.getAdWaynePlayerPlayModule(str, false);
        } else {
            String str2 = bVar.manifest;
            this.aeH = str2;
            this.aeK = this.aeJ.getAdWaynePlayerPlayModule(str2, true);
        }
        if (this.aeK != null) {
            aeL.set(true);
            this.aeK.setLooping(false);
            vy();
        }
    }

    public static boolean isWaynePlayerReady() {
        return aeL.get();
    }

    private static /* synthetic */ void vFWnQLY() {
        char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'N');
        }
        String str = new String(charArray);
        char[] charArray2 = "-\"' ':".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'N');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void vy() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(this.aeI);
            this.aeK.setOnCompletionListener(this.aeI);
            this.aeK.setOnBufferingUpdateListener(this.aeI);
            this.aeK.setOnSeekCompleteListener(this.aeI);
            this.aeK.setOnVideoSizeChangedListener(this.aeI);
            this.aeK.setOnErrorListener(this.aeI);
            this.aeK.setOnInfoListener(this.aeI);
            this.aeK.setOnVseReportListener(this.aeI);
        }
    }

    private void vz() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(null);
            this.aeK.setOnCompletionListener(null);
            this.aeK.setOnBufferingUpdateListener(null);
            this.aeK.setOnSeekCompleteListener(null);
            this.aeK.setOnVideoSizeChangedListener(null);
            this.aeK.setOnErrorListener(null);
            this.aeK.setOnInfoListener(null);
            this.aeK.setOnVseReportListener(null);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getAudioSessionId();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        return iAdWaynePlayerPlayModule != null ? iAdWaynePlayerPlayModule.getCurrentPlayingUrl() : "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aeH;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getDuration();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 3;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoHeight();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoWidth();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isLooping();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isPlaying();
        }
        return false;
    }

    public final void n(String str, String str2) {
        final com.kwad.components.core.video.a.e eVar = new com.kwad.components.core.video.a.e();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            eVar.setAdTemplate(adTemplate);
        }
        eVar.aZ(str);
        eVar.ba(str2);
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.video.g.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.w(eVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        if (this.aeK != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", com.sigmob.sdk.base.common.a.j);
            this.aeK.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        if (!this.aeN && (iAdWaynePlayerPlayModule = this.aeK) != null) {
            try {
                this.aeN = true;
                boolean prepareAsync = iAdWaynePlayerPlayModule.prepareAsync();
                LN();
                com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "prepareAsync result: " + prepareAsync);
                return prepareAsync;
            } catch (IllegalStateException e) {
                com.kwad.sdk.core.d.c.e("KwaiWaynePlayer", "prepareAsync failed ", e);
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            this.aeM = true;
            iAdWaynePlayerPlayModule.release();
            try {
                resetListeners();
                vz();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aeN = false;
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.reset();
                resetListeners();
                vy();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.seekTo(j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setAudioStreamType(i);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        synchronized (this.aeG) {
            try {
                if (!this.aeM && (iAdWaynePlayerPlayModule = this.aeK) != null) {
                    iAdWaynePlayerPlayModule.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setLooping(z);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.setSpeed(f);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aeK;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setVolume(f, f2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        if (this.aeK != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "start");
            this.aeK.start();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        if (this.aeK != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "stop");
            this.aeK.stop();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean vx() {
        return prepareAsync();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (this.aeK != null) {
            if (!TextUtils.isEmpty(bVar.manifest)) {
                String str = bVar.manifest;
                this.aeH = str;
                this.aeK.setDataSource(str, true);
            } else {
                String str2 = bVar.videoUrl;
                this.aeH = str2;
                this.aeK.setDataSource(str2, false);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    public static /* synthetic */ boolean a(g gVar, boolean z) {
        gVar.aeO = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        if (this.aeK != null) {
            this.aeH = str;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(n.z)) {
                this.aeK.setDataSource(parse.getPath(), false);
            } else {
                this.aeK.setDataSource(str, false);
            }
        }
    }
}
