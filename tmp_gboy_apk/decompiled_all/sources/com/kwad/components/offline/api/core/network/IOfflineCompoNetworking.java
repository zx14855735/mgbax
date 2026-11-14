package com.kwad.components.offline.api.core.network;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IOfflineCompoNetworking<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    void cancel();

    R createRequest();

    boolean enableMonitorReport();

    boolean isPostByJson();

    void onResponse(R r, c cVar);

    void request(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener);
}
