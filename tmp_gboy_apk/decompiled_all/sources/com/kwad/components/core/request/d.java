package com.kwad.components.core.request;

import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends c {
    @Override // com.kwad.components.core.request.c
    public void a(AdResultData adResultData, boolean z) {
        b(adResultData);
    }

    @Override // com.kwad.components.core.request.l
    public void b(AdResultData adResultData) {
    }

    @Override // com.kwad.components.core.request.l
    public void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.request.c
    public void a(int i, String str, boolean z) {
        onError(i, str);
    }
}
