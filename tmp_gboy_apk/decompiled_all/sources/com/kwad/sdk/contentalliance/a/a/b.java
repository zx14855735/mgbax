package com.kwad.sdk.contentalliance.a.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public com.kwad.sdk.contentalliance.a.a.a aAX;
    public AdTemplate adTemplate;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    public static class a {
        private com.kwad.sdk.contentalliance.a.a.a aAX;
        private AdTemplate adTemplate;
        private boolean isNoCache = false;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public final b Ga() {
            return new b(this, (byte) 0);
        }

        public final a bs(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public final a dt(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a du(String str) {
            this.manifest = str;
            return this;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a b(com.kwad.sdk.contentalliance.a.a.a aVar) {
            this.aAX = aVar;
            return this;
        }

        public a(String str) {
            this.videoUrl = str;
        }
    }

    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    private b(a aVar) {
        this.aAX = new com.kwad.sdk.contentalliance.a.a.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.aAX != null) {
            this.aAX.photoId = aVar.aAX.photoId;
            this.aAX.clickTime = aVar.aAX.clickTime;
            this.aAX.adStyle = aVar.aAX.adStyle;
            this.aAX.contentType = aVar.aAX.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }
}
