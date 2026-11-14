package com.kwad.components.core.widget;

import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class KsConvertButton extends KSCornerButton implements KsAppDownloadListener {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public KsConvertButton(Context context) {
        super(context);
    }

    private void bv(String str) {
        if (str != null) {
            setText(str);
        }
    }

    private String getAdActionDesc() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            return com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.er(adTemplate));
        }
        return null;
    }

    public final void a(com.kwad.components.core.e.d.d dVar, AdTemplate adTemplate) {
        this.mApkDownloadHelper = dVar;
        this.mAdTemplate = adTemplate;
        if (dVar != null) {
            dVar.b(this);
        }
        bv(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        bv(adTemplate != null ? com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.er(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        bv(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        bv(adTemplate != null ? com.kwad.sdk.core.response.b.a.ad(com.kwad.sdk.core.response.b.e.er(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        bv(CtFAbx.ASJ6gh(i, "下载中...", "%"));
    }

    public KsConvertButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
