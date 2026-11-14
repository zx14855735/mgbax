package com.sigmob.sdk.base;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p extends WindAdRequest {
    public p(String str, String str2, Map<String, Object> map) {
        super(str, str2, map, 1);
    }

    @Deprecated
    public p(String str, String str2, boolean z, Map<String, Object> map) {
        super(str, str2, map, z ? 1 : 4);
    }
}
