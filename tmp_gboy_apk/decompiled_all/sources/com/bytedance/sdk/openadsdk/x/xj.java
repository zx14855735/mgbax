package com.bytedance.sdk.openadsdk.x;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.pangle.wrapper.A2egSU;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private AudioFocusRequest hf;
    private boolean kd;
    private AudioManager.OnAudioFocusChangeListener u;
    private AudioManager w;
    private AudioAttributes xj;

    public xj() {
        this.kd = false;
        boolean ai = pz.hf().ai();
        this.kd = ai;
        if (ai) {
            this.u = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.x.xj.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i) {
                }
            };
            this.w = (AudioManager) pz.getContext().getSystemService(MediaFormat.KEY_AUDIO);
        }
    }

    public void hf() {
        if (this.kd) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioManager audioManager = this.w;
                if (audioManager != null) {
                    audioManager.abandonAudioFocusRequest(this.hf);
                    return;
                }
                return;
            }
            AudioManager audioManager2 = this.w;
            if (audioManager2 != null) {
                audioManager2.abandonAudioFocus(this.u);
            }
        }
    }

    public int xj() {
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest build;
        int requestAudioFocus;
        if (!this.kd) {
            return -1;
        }
        int i = Build.VERSION.SDK_INT;
        this.xj = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        if (i < 26) {
            AudioManager audioManager = this.w;
            if (audioManager != null) {
                return audioManager.requestAudioFocus(this.u, 3, 2);
            }
            return -1;
        }
        willPauseWhenDucked = A2egSU.ADYaiT().setWillPauseWhenDucked(true);
        acceptsDelayedFocusGain = willPauseWhenDucked.setAcceptsDelayedFocusGain(true);
        onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.u);
        audioAttributes = onAudioFocusChangeListener.setAudioAttributes(this.xj);
        build = audioAttributes.build();
        this.hf = build;
        AudioManager audioManager2 = this.w;
        if (audioManager2 == null) {
            return -1;
        }
        requestAudioFocus = audioManager2.requestAudioFocus(build);
        return requestAudioFocus;
    }
}
