package com.kwad.components.offline.api.core.network;

import com.kwad.sdk.api.KsScene;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IOfflineCompoRequest {
    boolean encryptDisable();

    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getMethod();

    String getRequestHost();

    KsScene getScene();

    String getUrl();
}
