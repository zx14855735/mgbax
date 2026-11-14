package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    private final String hf;
    private final Object xj;

    public xj(Object obj, String str) {
        this.xj = obj;
        this.hf = str;
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        xj("adAnalysisData", str);
    }

    @JavascriptInterface
    public String adInfo() {
        Object xj = xj("adInfo", new Object[0]);
        return xj != null ? xj.toString() : "";
    }

    @JavascriptInterface
    public String appInfo() {
        Object xj = xj("appInfo", new Object[0]);
        return xj != null ? xj.toString() : "";
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        xj("changeVideoState", str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        xj("clickEvent", str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        xj("dynamicTrack", str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        Object xj = xj("getCurrentVideoState", new Object[0]);
        return xj != null ? xj.toString() : "";
    }

    @JavascriptInterface
    public String getData(String str) {
        Object xj = xj("getData", str);
        return xj != null ? xj.toString() : "";
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        Object xj = xj("getNetOperatorType", new Object[0]);
        if (xj instanceof Integer) {
            return ((Integer) xj).intValue();
        }
        return -3;
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        Object xj = xj("getTemplateInfo", new Object[0]);
        return xj != null ? xj.toString() : "";
    }

    @JavascriptInterface
    public void getUrl(String str) {
        xj("getUrl", str);
    }

    public String hf() {
        return this.hf;
    }

    @JavascriptInterface
    public void initRenderFinish() {
        xj("initRenderFinish", new Object[0]);
    }

    @JavascriptInterface
    public Object invokeMethod(String str) {
        return xj("invokeMethod", str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        xj("muteVideo", str);
    }

    @JavascriptInterface
    public void readHtml(String str, String str2) {
        xj("readHtml", str, str2);
    }

    @JavascriptInterface
    public void readPercent(String str) {
        xj("readPercent", str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        xj("renderDidFinish", str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        xj("requestPauseVideo", str);
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        Object xj = xj("sendNetworkSwitch", str);
        return xj != null ? xj.toString() : "";
    }

    @JavascriptInterface
    public void skipVideo() {
        xj("skipVideo", new Object[0]);
    }

    public Object xj() {
        return this.xj;
    }

    private Object xj(String str, Object... objArr) {
        Method declaredMethod;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Class<?>[] clsArr = new Class[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                    declaredMethod = this.xj.getClass().getDeclaredMethod(str, clsArr);
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(this.xj, objArr);
                }
            } catch (Exception e) {
                pl.hf("JavascriptInterfaceProxy", "invokeMethod name= ".concat(String.valueOf(str)), e);
                return null;
            }
        }
        declaredMethod = this.xj.getClass().getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(this.xj, objArr);
    }
}
