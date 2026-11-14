package io.dcloud.ads.core.v2.feed;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface DCFeedAdLoadListener extends aaaaaaa0 {
    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
    /* synthetic */ void onError(int i, String str, JSONArray jSONArray);

    void onFeedAdLoad(List<DCFeedAd> list);
}
