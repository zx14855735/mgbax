package com.kwad.components.offline.api.core.video.mdoel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class KsPlayerLogParams {
    public long adStyle;
    public long clickTime = -1;
    public int contentType;
    public long photoId;

    public KsPlayerLogParams setAdStyle(long j) {
        this.adStyle = j;
        return this;
    }

    public KsPlayerLogParams setClickTime(long j) {
        this.clickTime = j;
        return this;
    }

    public KsPlayerLogParams setContentType(int i) {
        this.contentType = i;
        return this;
    }

    public KsPlayerLogParams setPhotoId(long j) {
        this.photoId = j;
        return this;
    }
}
