package com.sigmob.windad.natives;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindNativeAdRequest extends WindAdRequest {
    @Deprecated
    public WindNativeAdRequest(String str, String str2, int i, Map<String, Object> map) {
        super(str, str2, map, 5);
        this.f13783a = i;
    }

    public static WindNativeAdRequest getWindVideoAdRequest(WindAdRequest windAdRequest) {
        if (windAdRequest == null) {
            return null;
        }
        return new WindNativeAdRequest(windAdRequest.getPlacementId(), windAdRequest.getUserId(), 1, windAdRequest.getOptions());
    }

    public WindNativeAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map, 5);
    }
}
