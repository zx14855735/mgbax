package com.kwad.components.core.liveEnd;

import com.czhj.sdk.common.Constants;
import com.kwad.sdk.core.response.model.BaseResultData;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AdLiveEndCommonResultData extends BaseResultData {
    private static final long serialVersionUID = 1126369604146892297L;
    public int likeUserCount;
    public long liveDuration;
    public long totalWatchingDuration;
    public int watchingUserCount;
    public String displayWatchingUserCount = Constants.FAIL;
    public String displayLikeUserCount = Constants.FAIL;
}
