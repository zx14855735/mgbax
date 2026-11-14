package com.bykv.vk.component.ttvideo.mediakit.net;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class HTTPDNSHosts {
    private static final String TAG = "BatchParseHTTPDNSHosts";
    private static String mTTDNSServer = "/q?host=";
    protected boolean mCancelled = false;
    protected Handler mHandler;
    public String[] mHostnames;
    private int mHttpDNSType;
    public String mId;
    protected AVMDLNetClient mNetClient;

    public HTTPDNSHosts(String[] strArr, AVMDLNetClient aVMDLNetClient, int i, Handler handler) {
        this.mHttpDNSType = 2;
        this.mNetClient = null;
        if (i != 2) {
            throw new Exception("type is not own");
        }
        if (strArr == null || strArr.length == 0) {
            throw new Exception("host array is valid");
        }
        this.mHttpDNSType = i;
        this.mHostnames = strArr;
        this.mNetClient = aVMDLNetClient;
        if (aVMDLNetClient == null) {
            this.mNetClient = new AVMDLHTTPNetwork();
        }
        this.mHttpDNSType = i;
        this.mHandler = handler;
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.mHostnames;
            if (i >= strArr.length) {
                return sb.toString();
            }
            if (!TextUtils.isEmpty(strArr[i])) {
                if (i2 == 0) {
                    sb.append(this.mHostnames[i]);
                } else {
                    sb.append("," + this.mHostnames[i]);
                }
                i2++;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        String.format("****http dns id:%s type:%d", this.mId, Integer.valueOf(this.mHttpDNSType));
        if (error != null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            parseResult(jSONObject);
        } catch (Throwable th) {
            th.toString();
        }
    }

    private void parseResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dns");
            for (int i = 0; i < jSONArray.length(); i++) {
                AVMDLDNSInfo parserResultForSingleHost = parserResultForSingleHost(jSONArray.getJSONObject(i));
                if (parserResultForSingleHost != null) {
                    IPCache.getInstance().put(parserResultForSingleHost.mHost, parserResultForSingleHost);
                }
            }
        } catch (Exception unused) {
        }
    }

    private AVMDLDNSInfo parserResultForSingleHost(JSONObject jSONObject) {
        String str;
        long j;
        String str2;
        int i = this.mHttpDNSType;
        String str3 = "";
        if (i == 2 || i == 1) {
            if (jSONObject != null && jSONObject.length() != 0) {
                int optInt = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
                String optString = jSONObject.has("host") ? jSONObject.optString("host") : null;
                long currentTimeMillis = System.currentTimeMillis() + (optInt * 1000);
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        try {
                            str2 = optJSONArray.getString(i2);
                        } catch (Exception e) {
                            pl.xj(e);
                            str2 = null;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            str3 = TextUtils.isEmpty(str3) ? CtFAbx.AcNBzu(str3, str2) : CtFAbx.AlLFFp(str3, ",", str2);
                        }
                    }
                    str = optString;
                    j = currentTimeMillis;
                }
            }
            return null;
        }
        str = null;
        j = 0;
        String str4 = str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str4)) {
            String.format("parse result host:%s ips:%s expiredT:%d", str, str4, Long.valueOf(j));
            return new AVMDLDNSInfo(this.mHttpDNSType, str, str4, j, this.mId);
        }
        return null;
    }

    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    public void start() {
        String _getURL = _getURL();
        for (Method method : this.mNetClient.getClass().getDeclaredMethods()) {
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                this.mNetClient.startTask(_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNSHosts.1
                    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                    public void onCompletion(JSONObject jSONObject, Error error) {
                        HTTPDNSHosts.this._handleResponse(jSONObject, error);
                    }
                });
                return;
            }
        }
        this.mNetClient.startTask(_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNSHosts.2
            @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
            public void onCompletion(JSONObject jSONObject, Error error) {
                HTTPDNSHosts.this._handleResponse(jSONObject, error);
            }
        });
    }
}
