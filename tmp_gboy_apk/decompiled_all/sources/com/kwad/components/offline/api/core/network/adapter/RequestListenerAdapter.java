package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RequestListenerAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> implements g<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    @Override // com.kwad.sdk.core.network.g
    public void onError(RequestAdapter<R> requestAdapter, int i, String str) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i, str);
        }
    }

    @Override // com.kwad.sdk.core.network.g
    public void onStartRequest(RequestAdapter<R> requestAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onStartRequest(requestAdapter.getOfflineCompoRequest());
        }
    }

    @Override // com.kwad.sdk.core.network.g
    public void onSuccess(RequestAdapter<R> requestAdapter, ResultDataAdapter<T> resultDataAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onSuccess(requestAdapter.getOfflineCompoRequest(), resultDataAdapter.getOfflineCompoResultData());
        }
    }
}
