package com.kwad.components.offline.api.core.adlive;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IAdLiveEndRequest {
    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getUrl();

    Map<String, String> getUrlParam();
}
