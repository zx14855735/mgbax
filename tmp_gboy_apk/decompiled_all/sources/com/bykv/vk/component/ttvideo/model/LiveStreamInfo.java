package com.bykv.vk.component.ttvideo.model;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.component.utils.pl;
import com.czhj.sdk.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LiveStreamInfo {
    public static final int LIVE_STREAM_INFO_CMAF_INVALID = 1;
    public static final int LIVE_STREAM_INFO_LLS_INVALID = 2;
    public static final String MPD_VERSION = "1.0";
    private JSONObject mCommonInfo;
    private String mDefaultResolution;
    private int mFlag;
    private String mHost;
    private String mIp;
    private boolean mIsABRListMatch;
    private String mRequestParams;
    private JSONObject mStreamInfo;
    private boolean mEnableOriginResolution = false;
    private long mAdjustedOriginBitRate = -1;
    private int mIsCodecSame = -1;
    private String mTransportProtocol = "";
    private String mPortNum = "";
    private int mRtcFallback = 0;
    private final String TAG = "LiveStreamInfo";
    public int mSRShorterSideUpperBound = 0;
    public int mSRLongerSideUpperBound = 0;
    private int mSRFrameRateUpperBound = 0;
    public int mSharpenLongerSideUpperBound = 0;
    public int mSharpenLongerSideLowerBound = 0;
    public int mSharpenShorterSideUpperBound = 0;
    public int mSharpenShorterSideLowerBound = 0;

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
    
        r6.mIsABRListMatch = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public LiveStreamInfo(org.json.JSONObject r7) {
        /*
            r6 = this;
            java.lang.String r0 = "list"
            java.lang.String r1 = "default"
            java.lang.String r2 = "common"
            r6.<init>()
            r3 = 0
            r6.mEnableOriginResolution = r3
            r4 = -1
            r6.mAdjustedOriginBitRate = r4
            r4 = -1
            r6.mIsCodecSame = r4
            java.lang.String r4 = ""
            r6.mTransportProtocol = r4
            r6.mPortNum = r4
            r6.mRtcFallback = r3
            java.lang.String r4 = "LiveStreamInfo"
            r6.TAG = r4
            r6.mSRShorterSideUpperBound = r3
            r6.mSRLongerSideUpperBound = r3
            r6.mSRFrameRateUpperBound = r3
            r6.mIsABRListMatch = r3
            r6.mSharpenLongerSideUpperBound = r3
            r6.mSharpenLongerSideLowerBound = r3
            r6.mSharpenShorterSideUpperBound = r3
            r6.mSharpenShorterSideLowerBound = r3
            if (r7 != 0) goto L32
            return
        L32:
            java.lang.String r5 = "data"
            org.json.JSONObject r5 = r7.getJSONObject(r5)     // Catch: org.json.JSONException -> L47
            r6.mStreamInfo = r5     // Catch: org.json.JSONException -> L47
            boolean r5 = r7.has(r2)     // Catch: org.json.JSONException -> L47
            if (r5 == 0) goto L49
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch: org.json.JSONException -> L47
            r6.mCommonInfo = r7     // Catch: org.json.JSONException -> L47
            goto L49
        L47:
            r7 = move-exception
            goto La2
        L49:
            org.json.JSONObject r7 = r6.mCommonInfo     // Catch: org.json.JSONException -> L47
            if (r7 == 0) goto La5
            java.lang.String r2 = "auto"
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch: org.json.JSONException -> L47
            if (r7 == 0) goto L74
            boolean r2 = r7.has(r1)     // Catch: org.json.JSONException -> L47
            if (r2 == 0) goto L74
            java.lang.String r1 = r7.getString(r1)     // Catch: org.json.JSONException -> L47
            r6.mDefaultResolution = r1     // Catch: org.json.JSONException -> L47
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L47
            java.lang.String r2 = "mDefaultResolution: "
            r1.<init>(r2)     // Catch: org.json.JSONException -> L47
            java.lang.String r2 = r6.mDefaultResolution     // Catch: org.json.JSONException -> L47
            r1.append(r2)     // Catch: org.json.JSONException -> L47
            java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> L47
            com.bykv.vk.component.ttvideo.log.MyLog.i(r4, r1)     // Catch: org.json.JSONException -> L47
        L74:
            r1 = 1
            r6.mIsABRListMatch = r1     // Catch: org.json.JSONException -> L47
            if (r7 == 0) goto La5
            boolean r1 = r7.has(r0)     // Catch: org.json.JSONException -> L47
            if (r1 == 0) goto La5
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: org.json.JSONException -> L47
            if (r7 == 0) goto La5
            int r0 = r7.length()     // Catch: org.json.JSONException -> L47
            if (r0 <= 0) goto La5
            r0 = 0
        L8c:
            int r1 = r7.length()     // Catch: org.json.JSONException -> L47
            if (r0 >= r1) goto La5
            java.lang.String r1 = r7.getString(r0)     // Catch: org.json.JSONException -> L47
            boolean r1 = r6.isSupport(r1)     // Catch: org.json.JSONException -> L47
            if (r1 != 0) goto L9f
            r6.mIsABRListMatch = r3     // Catch: org.json.JSONException -> L47
            goto La5
        L9f:
            int r0 = r0 + 1
            goto L8c
        La2:
            com.bytedance.sdk.component.utils.pl.xj(r7)
        La5:
            r6.mFlag = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.<init>(org.json.JSONObject):void");
    }

    private boolean isNeedUseDefaultResolution(String str) {
        return (TextUtils.isEmpty(str) || !str.equals(LiveConfigKey.AUTO) || TextUtils.isEmpty(this.mDefaultResolution)) ? false : true;
    }

    private String set_url_port_scheme(String str) {
        int indexOf;
        int indexOf2 = str.indexOf(".com");
        int indexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.mPortNum)) {
            if (indexOf3 != -1) {
                int i = indexOf3 + 5;
                int i2 = indexOf3 + 6;
                while (i2 < sb.length() && sb.charAt(i2) - '0' >= 0 && sb.charAt(i2) - '0' <= 9) {
                    i2++;
                }
                sb.replace(i, i2, this.mPortNum);
            } else if (indexOf2 != -1 && ((indexOf = str.indexOf("vhost")) == -1 || indexOf > indexOf2)) {
                sb.insert(indexOf2 + 4, ":" + this.mPortNum);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int indexOf4 = sb2.indexOf("://");
        if (!TextUtils.isEmpty(this.mTransportProtocol)) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "https");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && indexOf4 != -1) {
                sb2.replace(0, indexOf4, Constants.HTTP);
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean adjustOriginBitRate(String str, String str2, long j) {
        if (this.mAdjustedOriginBitRate > 0) {
            return true;
        }
        long j2 = -1;
        String str3 = LiveConfigKey.LOW;
        while (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(getStreamUrlForResolution(str3, str, str2))) {
                long bitrate = getBitrate(str3, str2);
                if (str3.equals(LiveConfigKey.ORIGIN) && bitrate <= j2 && j > 0) {
                    this.mAdjustedOriginBitRate = j;
                    bitrate = j;
                }
                j2 = bitrate;
            }
            str3.getClass();
            char c = 65535;
            switch (str3.hashCode()) {
                case -1008619738:
                    if (str3.equals(LiveConfigKey.ORIGIN)) {
                        c = 0;
                        break;
                    }
                    break;
                case 3324:
                    if (str3.equals(LiveConfigKey.HIGH)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3448:
                    if (str3.equals(LiveConfigKey.LOW)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3665:
                    if (str3.equals(LiveConfigKey.STANDARD)) {
                        c = 3;
                        break;
                    }
                    break;
                case 115761:
                    if (str3.equals(LiveConfigKey.UHD)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                default:
                    str3 = null;
                    break;
                case 1:
                    str3 = LiveConfigKey.UHD;
                    break;
                case 2:
                    str3 = LiveConfigKey.STANDARD;
                    break;
                case 3:
                    str3 = LiveConfigKey.HIGH;
                    break;
                case 4:
                    str3 = LiveConfigKey.ORIGIN;
                    break;
            }
        }
        return this.mAdjustedOriginBitRate > 0;
    }

    public JSONObject getAbrInfo() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(LiveConfigKey.AUTO);
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    public String getAvLinesParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams != null) {
                return new JSONObject(sDKParams).optString("AvLines");
            }
            return null;
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    public long getBitrate(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return 0L;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("vbitrate");
        } catch (JSONException e) {
            pl.xj(e);
            return 0L;
        }
    }

    public int getCheckSilenceInterval(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return -1;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams != null) {
                return new JSONObject(sDKParams).optInt("CheckSilenceInterval");
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        return -1;
    }

    public String getDefaultResolution() {
        return this.mDefaultResolution;
    }

    public long getGopDuration(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return 0L;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("gop");
        } catch (JSONException e) {
            pl.xj(e);
            return 0L;
        }
    }

    public Map<String, String> getHTTPHeaders() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("header")) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("header");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.getString(next));
                }
                return hashMap;
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return null;
    }

    public String getLabelfromBitrate(long j, String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        Iterator<String> keys = this.mStreamInfo.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (isEnableAdaptive(next) && j == getBitrate(next, str) / 1000) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae A[Catch: JSONException -> 0x0083, TryCatch #0 {JSONException -> 0x0083, blocks: (B:27:0x0052, B:31:0x0079, B:33:0x007f, B:34:0x0090, B:36:0x00ae, B:38:0x00b5, B:39:0x00ca, B:41:0x00d2, B:45:0x00ee, B:47:0x00f8, B:48:0x0107, B:50:0x010e, B:51:0x0115, B:54:0x0104, B:55:0x0089, B:71:0x013d), top: B:26:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010e A[Catch: JSONException -> 0x0083, TryCatch #0 {JSONException -> 0x0083, blocks: (B:27:0x0052, B:31:0x0079, B:33:0x007f, B:34:0x0090, B:36:0x00ae, B:38:0x00b5, B:39:0x00ca, B:41:0x00d2, B:45:0x00ee, B:47:0x00f8, B:48:0x0107, B:50:0x010e, B:51:0x0115, B:54:0x0104, B:55:0x0089, B:71:0x013d), top: B:26:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0113  */
    /* JADX WARN: Type inference failed for: r6v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getMPDForFormat(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.getMPDForFormat(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public String getPortNum(String str, String str2, String str3) {
        String str4;
        if (this.mCommonInfo == null) {
            return null;
        }
        try {
            str4 = new JSONObject(this.mCommonInfo.getJSONObject(str.equals(LiveConfigKey.RTMP) ? "rtmp_ports" : "http_ports").optString(str2)).optString(str3);
        } catch (JSONException e) {
            pl.xj(e);
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        return str4;
    }

    public String getQueryItems() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("query")) {
            StringBuilder sb = new StringBuilder();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("query");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject2.getString(next);
                    String encode = URLEncoder.encode(next, "UTF-8");
                    String encode2 = URLEncoder.encode(string, "UTF-8");
                    sb.append("&");
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e) {
                e = e;
                pl.xj(e);
                return null;
            } catch (JSONException e2) {
                e = e2;
                pl.xj(e);
                return null;
            }
        }
        return null;
    }

    public String getRuleIds() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("rule_ids")) {
            return null;
        }
        return this.mCommonInfo.optString("rule_ids");
    }

    public String getSDKParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            return this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params");
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    public boolean getSREnabled(String str, String str2, int i) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params"));
            long optLong = jSONObject.optLong("vbitrate");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NNSR"));
            int optInt = i == 1 ? jSONObject2.optInt("Enabled") : 0;
            long optLong2 = jSONObject2.optLong("VBitrateLowerBoundInKbps");
            this.mSRShorterSideUpperBound = jSONObject2.optInt("ShorterSideUpperBound");
            this.mSRLongerSideUpperBound = jSONObject2.optInt("LongerSideUpperBound");
            int optInt2 = jSONObject2.optInt("FrameRateUpperBound");
            this.mSRFrameRateUpperBound = optInt2;
            return optInt == 1 && optLong >= optLong2 * 1000 && this.mSRShorterSideUpperBound > 0 && this.mSRLongerSideUpperBound > 0 && optInt2 > 0;
        } catch (JSONException e) {
            pl.xj(e);
            return false;
        }
    }

    public int getSRLongerSideUpperBound() {
        return this.mSRLongerSideUpperBound;
    }

    public int getSRShorterSideUpperBound() {
        return this.mSRShorterSideUpperBound;
    }

    public String getSessionID() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("session_id")) {
            return null;
        }
        return this.mCommonInfo.optString("session_id");
    }

    public JSONObject getSharpenParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("ASF"));
            this.mSharpenLongerSideUpperBound = jSONObject.optInt("LongerSideUpperBound");
            this.mSharpenLongerSideLowerBound = jSONObject.optInt("LongerSideLowerBound");
            this.mSharpenShorterSideUpperBound = jSONObject.optInt("ShorterSideUpperBound");
            this.mSharpenShorterSideLowerBound = jSONObject.optInt("ShorterSideLowerBound");
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getStreamUrlForResolution(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = "SuggestFormat"
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            r2 = 0
            if (r1 != 0) goto L23
            java.lang.String r1 = "auto"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L23
            java.lang.String r7 = r6.mDefaultResolution
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L1a
            return r2
        L1a:
            java.lang.String r7 = r6.mIp
            java.lang.String r0 = r6.mHost
            java.lang.String r7 = r6.getMPDForFormat(r8, r9, r7, r0)
            return r7
        L23:
            boolean r1 = r6.isSupport(r7)
            if (r1 != 0) goto L2a
            return r2
        L2a:
            org.json.JSONObject r1 = r6.mStreamInfo     // Catch: org.json.JSONException -> L5c
            java.lang.String r7 = r1.optString(r7)     // Catch: org.json.JSONException -> L5c
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5c
            r1.<init>(r7)     // Catch: org.json.JSONException -> L5c
            boolean r7 = r1.has(r9)     // Catch: org.json.JSONException -> L5c
            if (r7 == 0) goto L5f
            java.lang.String r7 = r1.optString(r9)     // Catch: org.json.JSONException -> L5c
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5c
            r9.<init>(r7)     // Catch: org.json.JSONException -> L5c
            java.lang.String r7 = "sdk_params"
            java.lang.String r7 = r9.optString(r7)     // Catch: org.json.JSONException -> L5a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5a
            r1.<init>(r7)     // Catch: org.json.JSONException -> L5a
            boolean r7 = r1.has(r0)     // Catch: org.json.JSONException -> L5a
            if (r7 == 0) goto L65
            java.lang.String r7 = r1.optString(r0)     // Catch: org.json.JSONException -> L5a
            goto L66
        L5a:
            r7 = move-exception
            goto L62
        L5c:
            r7 = move-exception
            r9 = r2
            goto L62
        L5f:
            r7 = r2
            r9 = r7
            goto L66
        L62:
            com.bytedance.sdk.component.utils.pl.xj(r7)
        L65:
            r7 = r2
        L66:
            java.lang.String r0 = "avph"
            boolean r1 = r0.equals(r8)
            java.lang.String r3 = "flv"
            if (r1 == 0) goto L71
            r8 = r3
        L71:
            java.lang.String r1 = ""
            if (r7 == 0) goto L81
            boolean r4 = r7.equals(r1)
            if (r4 != 0) goto L81
            boolean r4 = r7.equals(r0)
            if (r4 == 0) goto L82
        L81:
            r7 = r8
        L82:
            int r4 = r6.mFlag
            r5 = 1
            r4 = r4 & r5
            if (r4 <= 0) goto L91
            java.lang.String r4 = "cmaf"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L91
            goto L92
        L91:
            r8 = r7
        L92:
            int r7 = r6.mRtcFallback
            if (r7 == r5) goto L9c
            int r7 = r6.mFlag
            r7 = r7 & 2
            if (r7 <= 0) goto L9d
        L9c:
            r8 = r3
        L9d:
            if (r9 == 0) goto Lad
            if (r8 == 0) goto La8
            boolean r7 = r8.equals(r0)
            if (r7 == 0) goto La8
            goto La9
        La8:
            r3 = r8
        La9:
            java.lang.String r2 = r9.optString(r3)
        Lad:
            if (r2 == 0) goto Le4
            java.lang.String r7 = r6.getQueryItems()
            if (r7 == 0) goto Le4
            boolean r8 = r7.equals(r1)
            if (r8 != 0) goto Le4
            java.lang.String r8 = "?"
            int r9 = r2.indexOf(r8)
            r0 = -1
            if (r9 != r0) goto Ld5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.String r7 = r7.substring(r5)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            goto Le0
        Ld5:
            int r8 = r2.length()
            int r8 = r8 - r5
            if (r9 != r8) goto Le0
            java.lang.String r7 = r7.substring(r5)
        Le0:
            java.lang.String r2 = ADYaiT.CtFAbx.AcNBzu(r2, r7)
        Le4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.getStreamUrlForResolution(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public String getSuggestFormat(String str, String str2) {
        String str3;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            str3 = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestFormat");
        } catch (JSONException e) {
            pl.xj(e);
            str3 = null;
        }
        if (str3 == null || str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public String getSuggestProtocol(String str, String str2) {
        String str3;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestProtocol");
            str3 = LiveConfigKey.TCP;
        } catch (JSONException e) {
            pl.xj(e);
            str3 = null;
        }
        if (str3 == null || str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public String getVCodec(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("VCodec");
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    public boolean isABRListMatch() {
        return this.mIsABRListMatch;
    }

    public boolean isCodecSame(String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        int i = this.mIsCodecSame;
        if (i >= 0) {
            return i == 1;
        }
        this.mIsCodecSame = 1;
        Iterator<String> keys = this.mStreamInfo.keys();
        String str2 = null;
        String str3 = null;
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            str3 = getVCodec(keys.next(), str);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.mIsCodecSame = 0;
                break;
            }
            if (!TextUtils.isEmpty(str3)) {
                str2 = str3;
            }
        }
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            this.mIsCodecSame = 0;
        }
        return this.mIsCodecSame == 1;
    }

    public boolean isEnableAdaptive(String str) {
        JSONArray optJSONArray;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return false;
        }
        try {
            JSONObject abrInfo = getAbrInfo();
            if (abrInfo != null && abrInfo.has("list") && (optJSONArray = abrInfo.optJSONArray("list")) != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String string = optJSONArray.getString(i);
                    if (string != null && string.equals(str) && (!string.equals(LiveConfigKey.ORIGIN) || this.mEnableOriginResolution)) {
                        return true;
                    }
                }
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        return false;
    }

    public boolean isSupport(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.mStreamInfo;
        if (jSONObject2 == null) {
            return false;
        }
        try {
            jSONObject = jSONObject2.getJSONObject(str);
        } catch (JSONException e) {
            pl.xj(e);
            jSONObject = null;
        }
        return jSONObject != null;
    }

    public boolean isSupportSR(int i, int i2, float f) {
        return Math.max(i, i2) <= this.mSRLongerSideUpperBound && Math.min(i, i2) <= this.mSRShorterSideUpperBound && f <= ((float) this.mSRFrameRateUpperBound) && i < i2;
    }

    public boolean isSupportSharpen(int i, int i2) {
        int max = Math.max(i, i2);
        int min = Math.min(i, i2);
        return max >= this.mSharpenLongerSideLowerBound && max <= this.mSharpenLongerSideUpperBound && min >= this.mSharpenShorterSideLowerBound && min <= this.mSharpenShorterSideUpperBound;
    }

    public void setDefaultResolution(String str) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            this.mDefaultResolution = str;
        }
    }

    public void setEnableOriginResolution(boolean z) {
        this.mEnableOriginResolution = z;
    }

    public boolean setFlag(int i) {
        this.mFlag = i | this.mFlag;
        return true;
    }

    public void setRequestParams(String str) {
        this.mRequestParams = str;
    }

    public void setRequestParamsWithDNSIp(String str, String str2, String str3) {
        this.mRequestParams = str;
        this.mIp = str2;
        this.mHost = str3;
    }

    public void setRtcFallback(int i) {
        this.mRtcFallback = i;
    }

    public void setTransportProtocol(String str, String str2) {
        this.mTransportProtocol = str;
        this.mPortNum = str2;
    }
}
