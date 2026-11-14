package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.g.w;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class hf extends xj {
    private final WebViewImpl hf;
    private final com.bytedance.sdk.component.g.xj xj;

    public hf(Object obj, String str, com.bytedance.sdk.component.g.xj xjVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.xj = xjVar;
        this.hf = webViewImpl;
    }

    private boolean hf(JSONObject jSONObject) {
        JSONObject hf = hf(jSONObject, "removeWebviewListener");
        if (hf == null) {
            return false;
        }
        String optString = hf.optString("event");
        if (optString == null || optString.length() <= 0) {
            return true;
        }
        this.xj.hf(this.hf, optString);
        return true;
    }

    private boolean kd(JSONObject jSONObject) {
        if (!xj(jSONObject, "popWebview")) {
            return false;
        }
        w xj = this.xj.xj();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(xj == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(xj != null));
        } catch (Exception unused) {
        }
        this.hf.xj(hf(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean u(JSONObject jSONObject) {
        JSONObject hf = hf(jSONObject, "pushWebview");
        if (hf == null) {
            return false;
        }
        int xj = this.xj.xj(hf.optString("url"));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(xj));
            jSONObject2.putOpt("result", Boolean.valueOf(xj == 0));
        } catch (Exception unused) {
        }
        this.hf.xj(hf(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean w(JSONObject jSONObject) {
        JSONObject hf = hf(jSONObject, "sendWebviewEvent");
        if (hf == null) {
            return false;
        }
        String optString = hf.optString("event");
        if (optString == null) {
            return true;
        }
        this.xj.xj(this.hf, hf(), optString, hf.opt("param"));
        return true;
    }

    private boolean xj(JSONObject jSONObject) {
        JSONObject hf = hf(jSONObject, "addWebviewListener");
        if (hf == null) {
            return false;
        }
        String optString = hf.optString("event");
        if (optString == null || optString.length() <= 0) {
            return true;
        }
        this.xj.xj(this.hf, optString);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.web.xj
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("popWebview")) {
            if (kd(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("pushWebview")) {
            if (u(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("addWebviewListener")) {
            if (xj(new JSONObject(str))) {
                return null;
            }
        } else {
            if (!str.contains("removeWebviewListener")) {
                if (str.contains("sendWebviewEvent")) {
                    if (w(new JSONObject(str))) {
                        return null;
                    }
                }
                return super.invokeMethod(str);
            }
            if (hf(new JSONObject(str))) {
                return null;
            }
        }
        return super.invokeMethod(str);
    }

    private JSONObject hf(JSONObject jSONObject, String str) {
        if (xj(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }

    private boolean xj(JSONObject jSONObject, String str) {
        return jSONObject.optString("func").equals(str);
    }
}
