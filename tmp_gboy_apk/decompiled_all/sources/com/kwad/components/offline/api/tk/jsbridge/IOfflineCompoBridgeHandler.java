package com.kwad.components.offline.api.tk.jsbridge;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IOfflineCompoBridgeHandler {
    String getKey();

    void handleJsCall(String str, IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}
