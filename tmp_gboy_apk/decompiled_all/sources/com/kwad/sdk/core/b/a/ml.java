package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ml implements com.kwad.sdk.core.d<VideoPlayerStatus> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        a2(videoPlayerStatus, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        return b2(videoPlayerStatus, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = jSONObject.optInt("mVideoPlayerType");
        videoPlayerStatus.mVideoPlayerBehavior = A2egSU.A5SV6n("1", "mVideoPlayerBehavior", jSONObject);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = videoPlayerStatus.mVideoPlayerType;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mVideoPlayerType", i);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mVideoPlayerBehavior", videoPlayerStatus.mVideoPlayerBehavior);
        return jSONObject;
    }
}
