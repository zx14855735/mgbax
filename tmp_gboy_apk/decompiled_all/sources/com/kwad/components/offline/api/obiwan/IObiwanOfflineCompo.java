package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IObiwanOfflineCompo extends IOfflineCompo<IObiwanOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.core.log.ObiwanOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.obiwan";

    IObiwanLogcat getLog();

    void updateConfigs();
}
