package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class b extends Presenter {
    protected c Qu;
    protected AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        c cVar = (c) PC();
        this.Qu = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.er(cVar.Qt.getAdTemplate());
    }
}
