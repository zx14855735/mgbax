package com.kwad.sdk.core.network;

import com.baidu.mobads.sdk.internal.an;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class m<R extends n, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";
    private g<R, T> mListener = null;

    private void onRequest(g<R, T> gVar) {
        this.mListener = gVar;
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public abstract T createResponseData();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        c cVar;
        n nVar = (n) createRequest();
        try {
            String url = nVar.getUrl();
            cVar = nVar.getMethod().equals(an.b) ? com.kwad.sdk.g.Cm().doPost(url, nVar.getHeader(), nVar.getBody()) : com.kwad.sdk.g.Cm().doGet(url, nVar.getHeader());
            if (cVar == null || cVar.code != 200) {
                com.kwad.sdk.core.d.c.d(TAG, "normal request failed");
            } else {
                com.kwad.sdk.core.d.c.d(TAG, "normal request success:" + cVar.code);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar = 0 == 0 ? new c() : null;
            cVar.code = -1;
            cVar.aIV = e;
        }
        onResponse((m<R, T>) nVar, cVar);
    }

    public void parseResponse(T t, c cVar) {
        t.parseResponse(cVar);
    }

    public void request(g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            gVar.onError(null, e.aJh.errorCode, bw.r(th));
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.Jr()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, cVar);
            this.mListener.onSuccess(r, createResponseData);
        } else {
            g<R, T> gVar = this.mListener;
            int i = cVar.code;
            Exception exc = cVar.aIV;
            gVar.onError(r, i, exc != null ? exc.getMessage() : "");
        }
    }
}
