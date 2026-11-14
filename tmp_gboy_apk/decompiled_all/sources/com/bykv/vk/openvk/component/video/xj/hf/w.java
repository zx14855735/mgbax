package com.bykv.vk.openvk.component.video.xj.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private final long hf;
    private final long w;
    private final long xj;

    public long xj(int i) {
        if (i <= 0) {
            return this.xj;
        }
        return Math.min((this.hf * i) + this.xj, this.w);
    }
}
