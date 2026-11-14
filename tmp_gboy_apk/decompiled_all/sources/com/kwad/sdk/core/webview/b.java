package com.kwad.sdk.core.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.widget.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {
    public WebView UA;
    public ViewGroup Vs;
    public g aRL;
    public an aRM;
    public boolean aRN = true;
    public boolean aRO = true;
    private List<AdTemplate> aRP = null;
    private AdResultData mAdResultData;
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final List<AdTemplate> MC() {
        List<AdTemplate> list = this.aRP;
        if (list != null && list.size() > 0) {
            return this.aRP;
        }
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.getAdTemplateList();
        }
        return null;
    }

    public final boolean MD() {
        return MC() == null || MC().size() == 0;
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
    }

    public final AdTemplate dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return getAdTemplate();
        }
        List<AdTemplate> MC = MC();
        if (MC == null) {
            return null;
        }
        for (AdTemplate adTemplate : MC) {
            if (bp.isEquals(str, String.valueOf(com.kwad.sdk.core.response.b.e.eB(adTemplate)))) {
                return adTemplate;
            }
        }
        return null;
    }

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aRP;
        return (list == null || list.size() <= 0) ? com.kwad.sdk.core.response.b.c.r(this.mAdResultData) : this.aRP.get(0);
    }

    public final Context getContext() {
        WebView webView = this.UA;
        if (webView == null) {
            return null;
        }
        return webView.getContext();
    }

    public final AdResultData iv() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData;
        }
        if (this.aRP == null) {
            return null;
        }
        AdResultData adResultData2 = new AdResultData();
        adResultData2.setAdTemplateList(this.aRP);
        return adResultData2;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.aRP = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.aRP = arrayList;
    }
}
