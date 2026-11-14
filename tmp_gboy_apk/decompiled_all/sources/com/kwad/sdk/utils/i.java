package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.pangle.wrapper.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class i {
    private AudioManager aPn;
    private AudioManager.OnAudioFocusChangeListener bdF = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.i.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (i.this.ke == null) {
                return;
            }
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.i.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        i.this.ke.onAudioBeOccupied();
                    } else {
                        i.this.ke.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a ke;

    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public i(Context context) {
        this.aPn = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
    }

    @TargetApi(26)
    private AudioFocusRequest Rv() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        audioAttributes = A2egSU.ADYaiT().setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build());
        acceptsDelayedFocusGain = audioAttributes.setAcceptsDelayedFocusGain(false);
        onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.bdF);
        build = onAudioFocusChangeListener.build();
        return build;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if (1 == r1.requestAudioFocus(r0, 3, 2)) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Ru() {
        /*
            r5 = this;
            android.media.AudioManager$OnAudioFocusChangeListener r0 = r5.bdF     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L24
            android.media.AudioManager r1 = r5.aPn     // Catch: java.lang.Throwable -> L24
            if (r1 != 0) goto L9
            goto L24
        L9:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L24
            r3 = 26
            r4 = 1
            if (r2 < r3) goto L1b
            android.media.AudioFocusRequest r0 = r5.Rv()     // Catch: java.lang.Throwable -> L24
            int r0 = com.bytedance.pangle.wrapper.A2egSU.A2egSU(r1, r0)     // Catch: java.lang.Throwable -> L24
            if (r4 != r0) goto L24
            goto L23
        L1b:
            r2 = 3
            r3 = 2
            int r0 = r1.requestAudioFocus(r0, r2, r3)     // Catch: java.lang.Throwable -> L24
            if (r4 != r0) goto L24
        L23:
            return r4
        L24:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.i.Ru():boolean");
    }

    public final void c(a aVar) {
        this.ke = aVar;
    }
}
