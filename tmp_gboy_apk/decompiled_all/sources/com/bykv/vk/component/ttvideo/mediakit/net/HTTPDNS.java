package com.bykv.vk.component.ttvideo.mediakit.net;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGoogleDNSServer = "/resolve?name=";
    private static String mTTDNSServer = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    public HTTPDNS(String str, AVMDLNetClient aVMDLNetClient, int i, Handler handler) {
        super(str, aVMDLNetClient, handler);
        this.mHttpDNSType = i;
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        int i = this.mHttpDNSType;
        if (i == 2 || i == 1) {
            sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        } else if (i == 3) {
            sb.append("https://" + AVMDLDNSParser.mGlobalGoogleDNSParseHost + mGoogleDNSServer);
        }
        sb.append(this.mHostname);
        int i2 = this.mHttpDNSType;
        if (i2 == 2 || i2 == 1) {
            sb.append("&source=vod");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLDNSInfo aVMDLDNSInfo;
        String.format("****http dns id:%s type:%d host:%s", this.mId, Integer.valueOf(this.mHttpDNSType), this.mHostname);
        AVMDLDNSInfo aVMDLDNSInfo2 = new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, (String) null, 0L, this.mId);
        if (error != null) {
            aVMDLDNSInfo2.mErrorStr = error.errStr;
        } else if (jSONObject == null || jSONObject.length() == 0) {
            int i = this.mHttpDNSType;
            new Error(i, this.mHostname, this.mId, String.format("HTTP dns empty, type:%d", Integer.valueOf(i)));
        } else {
            try {
                aVMDLDNSInfo = parserResult(jSONObject);
            } catch (Throwable th) {
                th.toString();
                aVMDLDNSInfo = null;
            }
            if (aVMDLDNSInfo != null) {
                IPCache.getInstance().put(this.mHostname, aVMDLDNSInfo);
                notifySuccess(aVMDLDNSInfo);
                return;
            }
        }
        notifyError(aVMDLDNSInfo2);
    }

    private AVMDLDNSInfo parserResult(JSONObject jSONObject) {
        AVMDLDNSInfo aVMDLDNSInfo;
        long currentTimeMillis;
        String str;
        char c;
        int i = this.mHttpDNSType;
        String str2 = "";
        if (i == 2 || i == 1) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            r13 = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
            String.format("receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(r13), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
            int i2 = AVMDLDNSParser.mGlobalForceExpiredTime;
            if (i2 > 0) {
                r13 = i2;
            }
            int i3 = r13;
            aVMDLDNSInfo = null;
            currentTimeMillis = System.currentTimeMillis() + (r13 * 1000);
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return null;
            }
            str = null;
            c = 0;
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                try {
                    str = optJSONArray.getString(i4);
                } catch (Exception e) {
                    pl.xj(e);
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = TextUtils.isEmpty(str2) ? CtFAbx.AcNBzu(str2, str) : CtFAbx.AlLFFp(str2, ",", str);
                }
            }
            r13 = i3;
        } else {
            currentTimeMillis = 0;
            str = null;
            aVMDLDNSInfo = null;
            c = 0;
        }
        if (this.mHttpDNSType == 3) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Answer");
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                    if (jSONObject2.has(PointParamKey.TYPE) && jSONObject2.getInt(PointParamKey.TYPE) == 1) {
                        if (jSONObject2.has("TTL")) {
                            r13 = jSONObject2.optInt("TTL");
                        }
                        if (jSONObject2.has(PointParamKey.DATA)) {
                            str = jSONObject2.optString(PointParamKey.DATA);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str2 = TextUtils.isEmpty(str2) ? str2 + str : str2 + "," + str;
                        }
                    }
                }
                Integer valueOf = Integer.valueOf(r13);
                Integer valueOf2 = Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime);
                Object[] objArr = new Object[2];
                objArr[c] = valueOf;
                objArr[1] = valueOf2;
                String.format("receive expiredtime:%d force expiredtime:%d ", objArr);
                int i6 = AVMDLDNSParser.mGlobalForceExpiredTime;
                if (i6 > 0) {
                    r13 = i6;
                }
                currentTimeMillis = System.currentTimeMillis() + (r13 * 1000);
            } catch (Exception e2) {
                pl.xj(e2);
                return aVMDLDNSInfo;
            }
        }
        return new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, str2, currentTimeMillis, this.mId);
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void start() {
        String _getURL = _getURL();
        for (Method method : this.mNetClient.getClass().getDeclaredMethods()) {
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                this.mNetClient.startTask(_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.1
                    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                    public void onCompletion(JSONObject jSONObject, Error error) {
                        HTTPDNS.this._handleResponse(jSONObject, error);
                    }
                });
                return;
            }
        }
        this.mNetClient.startTask(_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.2
            @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
            public void onCompletion(JSONObject jSONObject, Error error) {
                HTTPDNS.this._handleResponse(jSONObject, error);
            }
        });
    }
}
