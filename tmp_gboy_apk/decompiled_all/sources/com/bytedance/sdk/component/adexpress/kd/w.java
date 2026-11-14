package com.bytedance.sdk.component.adexpress.kd;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private WeakReference<hf> xj;

    public w(hf hfVar) {
        this.xj = new WeakReference<>(hfVar);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<hf> weakReference = this.xj;
        return (weakReference == null || weakReference.get() == null) ? "" : this.xj.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<hf> weakReference = this.xj;
        return (weakReference == null || weakReference.get() == null) ? "" : this.xj.get().appInfo();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<hf> weakReference = this.xj;
        return (weakReference == null || weakReference.get() == null) ? "" : this.xj.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<hf> weakReference = this.xj;
        return (weakReference == null || weakReference.get() == null) ? "" : this.xj.get().getData(str);
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<hf> weakReference = this.xj;
        return (weakReference == null || weakReference.get() == null) ? "" : this.xj.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().initRenderFinish();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<hf> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().skipVideo();
    }

    public void xj(hf hfVar) {
        if (hfVar == null) {
            this.xj = null;
        } else {
            this.xj = new WeakReference<>(hfVar);
        }
    }
}
