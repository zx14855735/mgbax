package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.common.util.CommConstant;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class h {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ab ayr;
    private int currentNum;
    private String mCurrentUrl;
    private final String mUrl;

    public interface a {
        void a(a.b bVar);
    }

    public h(ab abVar) {
        this.ayr = abVar;
        String Fg = abVar.Fg();
        this.mUrl = Fg;
        this.mCurrentUrl = Fg;
    }

    private static Map<String, String> buildHeader() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", "zh-CN");
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("User-Agent", RequestParamsUtils.getUserAgent());
        return hashMap;
    }

    private static HttpURLConnection createUrlConnection(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod(an.b);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    private String g(Map<String, String> map) {
        String bg = i.bg(this.ayr.getContext());
        if (TextUtils.isEmpty(bg)) {
            bg = this.ayr.Fh().getSDKVersion();
        }
        int sDKVersionCode = this.ayr.Fh().getSDKVersionCode();
        JSONObject appInfo = this.ayr.Fh().getAppInfo();
        JSONObject deviceInfo = this.ayr.Fh().getDeviceInfo();
        JSONObject networkInfo = this.ayr.Fh().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        n.putValue(jSONObject, "sdkApiVersion", BuildConfig.VERSION_NAME);
        n.putValue(jSONObject, "sdkApiVersionCode", BuildConfig.VERSION_CODE);
        n.putValue(jSONObject, CommConstant.SdkVersion.SDK_VERSION_KEY, bg);
        n.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        n.putValue(jSONObject, "sdkType", 1);
        n.putValue(jSONObject, "appInfo", appInfo);
        n.putValue(jSONObject, "deviceInfo", deviceInfo);
        n.putValue(jSONObject, "networkInfo", networkInfo);
        n.putValue(jSONObject, "sdkAbi", ac.Cd());
        String jSONObject2 = jSONObject.toString();
        this.ayr.Fh().addHp(map);
        JSONObject jSONObject3 = new JSONObject();
        n.putValue(jSONObject3, "version", BuildConfig.VERSION_NAME);
        n.putValue(jSONObject3, MedProConst.AD_APPID, appInfo.optString(MedProConst.AD_APPID));
        n.putValue(jSONObject3, "message", this.ayr.Fh().getRM(jSONObject2));
        this.ayr.Fh().sR(this.mUrl, map, jSONObject3.toString());
        return jSONObject3.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String inputStream2String(java.io.InputStream r5) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
        La:
            int r3 = r5.read(r0)     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            r4 = -1
            if (r3 == r4) goto L1b
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            goto La
        L16:
            r0 = move-exception
            r1 = r2
            goto L4c
        L19:
            r0 = move-exception
            goto L34
        L1b:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            r5.close()     // Catch: java.io.IOException -> L23
            goto L27
        L23:
            r5 = move-exception
            r5.printStackTrace()
        L27:
            r2.close()     // Catch: java.io.IOException -> L2b
            goto L2f
        L2b:
            r5 = move-exception
            r5.printStackTrace()
        L2f:
            return r0
        L30:
            r0 = move-exception
            goto L4c
        L32:
            r0 = move-exception
            r2 = r1
        L34:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L16
            if (r5 == 0) goto L41
            r5.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r5 = move-exception
            r5.printStackTrace()
        L41:
            if (r2 == 0) goto L4b
            r2.close()     // Catch: java.io.IOException -> L47
            goto L4b
        L47:
            r5 = move-exception
            r5.printStackTrace()
        L4b:
            return r1
        L4c:
            if (r5 == 0) goto L56
            r5.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r5 = move-exception
            r5.printStackTrace()
        L56:
            if (r1 == 0) goto L60
            r1.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r5 = move-exception
            r5.printStackTrace()
        L60:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.h.inputStream2String(java.io.InputStream):java.lang.String");
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                Map<String, String> buildHeader = buildHeader();
                String g = g(buildHeader);
                HttpURLConnection createUrlConnection = createUrlConnection(this.mCurrentUrl);
                setConnectionHeader(createUrlConnection, buildHeader);
                createUrlConnection.connect();
                new DataOutputStream(createUrlConnection.getOutputStream()).write(g.getBytes());
                int responseCode = createUrlConnection.getResponseCode();
                if (responseCode == 200) {
                    String inputStream2String = inputStream2String(createUrlConnection.getInputStream());
                    a.b bVar = new a.b();
                    JSONObject jSONObject = new JSONObject(inputStream2String);
                    String optString = jSONObject.optString(PointParamKey.DATA);
                    if (!TextUtils.isEmpty(optString) && !"null".equals(optString)) {
                        jSONObject.put(PointParamKey.DATA, new JSONObject(this.ayr.Fh().getRD(optString)));
                    }
                    bVar.parseJson(jSONObject);
                    aVar.a(bVar);
                } else {
                    if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    }
                    if (this.currentNum < 21) {
                        this.mCurrentUrl = createUrlConnection.getHeaderField("Location");
                        this.currentNum++;
                        a(aVar);
                    }
                }
                createUrlConnection.disconnect();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }
}
