package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    public static String HTTP_CODE_ERROR_MSG = "网络错误";
    private static final String TAG = "Networking";
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.JO();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.dQ(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.Jr() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !ao.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.Oy();
    }

    private String getHostTypeByUrl(String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(R r, c cVar, String str) {
        String url = r.getUrl();
        DomainException domainException = new DomainException(cVar.aIU, cVar.aIV);
        com.kwad.sdk.core.network.idc.a.Jz().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((l<R, T>) r, cVar.code, str);
    }

    private void notifyOnStartRequest(R r) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r);
    }

    private void notifyOnSuccess(R r, T t) {
        if (com.kwad.sdk.core.network.idc.a.Jz().JB()) {
            String hostTypeByUrl = getHostTypeByUrl(r.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.Jz().ep(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r, t);
        this.mMonitorRecorder.JN();
    }

    private void onRequest(g<R, T> gVar) {
        this.mMonitorRecorder.JH();
        this.mListener = gVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.Jv().V(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void setMonitorRequestId(f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.ez(str);
        }
    }

    public void afterParseData(T t) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public boolean enableCrashReport() {
        return true;
    }

    public boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        R r;
        Throwable th;
        c cVar = null;
        try {
            try {
                this.mMonitorRecorder.JL();
                r = createRequest();
                try {
                    notifyOnStartRequest(r);
                    this.mMonitorRecorder.ev(r.getUrl()).ew(r.getUrl());
                    setMonitorRequestId(r);
                    if (ao.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                        try {
                            String url = r.getUrl();
                            AdHttpProxy Cm = com.kwad.sdk.g.Cm();
                            if (Cm instanceof com.kwad.sdk.core.network.c.b) {
                                this.mMonitorRecorder.ey("ok_http").JK();
                            } else {
                                this.mMonitorRecorder.ey(Constants.HTTP).JK();
                            }
                            cVar = isPostByJson() ? Cm.doPost(url, r.getHeader(), r.getBody()) : Cm.doPost(url, r.getHeader(), r.getBodyMap());
                            com.kwad.sdk.core.d.c.i(TAG, "url: " + url + ", response: " + cVar);
                        } catch (Exception e) {
                            notifyOnErrorListener((l<R, T>) r, e.aJh.errorCode, bw.r(e));
                            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            this.mMonitorRecorder.ex("requestError:" + e.getMessage());
                        }
                        this.mMonitorRecorder.JI().JJ().dS(com.kwad.sdk.ip.direct.a.getType());
                        try {
                            onResponse(r, cVar);
                        } catch (Exception e2) {
                            notifyOnErrorListener((l<R, T>) r, e.aJh.errorCode, bw.r(e2));
                            this.mMonitorRecorder.ex("onResponseError:" + e2.getMessage());
                            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                        }
                    } else {
                        e eVar = e.aJa;
                        notifyOnErrorListener((l<R, T>) r, eVar.errorCode, eVar.msg);
                        this.mMonitorRecorder.dP(e.aJa.errorCode).ex(e.aJa.msg);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        try {
                            this.mMonitorRecorder.ex("requestError:" + th.getMessage());
                        } catch (Exception unused) {
                        }
                        notifyOnErrorListener((l<R, T>) r, e.aJh.errorCode, bw.r(th));
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        if (!enableMonitorReport()) {
                        }
                    } finally {
                        try {
                            if (enableMonitorReport()) {
                                this.mMonitorRecorder.report();
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            } catch (Exception unused3) {
            }
        } catch (Throwable th3) {
            r = null;
            th = th3;
        }
    }

    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        if (cVar == null) {
            e eVar = e.aJa;
            notifyOnErrorListener((l<R, T>) r, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.ex("responseBase is null");
            com.kwad.sdk.core.d.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.dP(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.aIW) || !cVar.Jr()) {
            notifyOnErrorListener((l<R, T>) r, cVar, HTTP_CODE_ERROR_MSG);
            this.mMonitorRecorder.ex("httpCodeError:" + cVar.code + ":" + cVar.aIW);
            StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
            sb.append(cVar.code);
            com.kwad.sdk.core.d.c.w(TAG, sb.toString());
            return;
        }
        try {
            parseCommonData(r.getUrl(), cVar.aIW);
            T parseData = parseData(cVar.aIW);
            afterParseData(parseData);
            if (cVar.aIW != null) {
                this.mMonitorRecorder.az(r7.length()).JM().dR(parseData.result);
            }
            if (!parseData.isResultOk()) {
                this.mMonitorRecorder.ex("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
                if (parseData.notifyFailOnResultError()) {
                    notifyOnErrorListener((l<R, T>) r, parseData.result, parseData.errorMsg);
                    return;
                }
            }
            if (parseData.isDataEmpty()) {
                notifyOnErrorListener((l<R, T>) r, e.aJc.errorCode, !TextUtils.isEmpty(parseData.testErrorMsg) ? parseData.testErrorMsg : e.aJc.msg);
            } else {
                checkAndSetHasData(parseData);
                notifyOnSuccess(r, parseData);
            }
        } catch (Exception e) {
            e eVar2 = e.aJb;
            notifyOnErrorListener((l<R, T>) r, eVar2.errorCode, eVar2.msg);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            this.mMonitorRecorder.ex("parseDataError:" + e.getMessage());
        }
    }

    public abstract T parseData(String str);

    public void request(g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((l<R, T>) null, e.aJh.errorCode, bw.r(th));
            reportSdkCaughtException(th);
        }
    }

    private void notifyOnErrorListener(R r, int i, String str) {
        try {
            h.Js().b(r, i);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r, i, str);
        this.mMonitorRecorder.JN();
    }
}
