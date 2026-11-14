package com.bytedance.sdk.openadsdk.core.ra;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class lw {
    private int hf;
    private int w;
    private int xj;

    private int u() {
        return com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), com.bytedance.sdk.openadsdk.core.a.r.kd(com.bytedance.sdk.openadsdk.core.pz.getContext()));
    }

    public int hf() {
        return this.hf;
    }

    public int w() {
        return this.w;
    }

    public int xj() {
        return this.xj;
    }

    public void hf(int i) {
        if (i > 0 && i < u()) {
            this.hf = i;
            return;
        }
        int i2 = this.xj;
        if (i2 == 1) {
            this.hf = 90;
        } else if (i2 == 2) {
            this.hf = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
        }
    }

    public void w(int i) {
        if (i > 0 && i < u()) {
            this.w = i;
            return;
        }
        int i2 = this.xj;
        if (i2 == 1) {
            this.w = 90;
        } else if (i2 == 2) {
            this.w = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
        }
    }

    public void xj(int i) {
        if (i != 1 && i != 2) {
            i = 0;
        }
        this.xj = i;
    }
}
