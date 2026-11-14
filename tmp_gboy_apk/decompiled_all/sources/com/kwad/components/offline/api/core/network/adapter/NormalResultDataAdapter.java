package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class NormalResultDataAdapter<T extends NormalOfflineCompoResultData> extends NormalResultData {
    private final T mOfflineCompoResultData;

    public NormalResultDataAdapter(T t) {
        this.mOfflineCompoResultData = t;
    }

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    @Override // com.kwad.sdk.core.network.NormalResultData
    public void parseResponse(c cVar) {
        super.parseResponse(cVar);
        this.mOfflineCompoResultData.parseResponse(cVar);
    }
}
