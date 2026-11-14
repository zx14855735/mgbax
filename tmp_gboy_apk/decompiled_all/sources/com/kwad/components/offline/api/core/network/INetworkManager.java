package com.kwad.components.offline.api.core.network;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface INetworkManager {
    void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);

    int getNetworkType(Context context);

    void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);
}
