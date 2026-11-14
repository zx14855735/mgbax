package com.czhj.sdk.common.network;

import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.Request;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.HttpHeaderParser;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class SigmobRequest<T> extends Request<T> {
    protected static final String AESKEY = "KGpfzbYsn4T9Jyuq";

    /* renamed from: a, reason: collision with root package name */
    private final String f10578a;

    public SigmobRequest(String str, int i, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.f10578a = str;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
    }

    @Override // com.czhj.volley.Request
    public byte[] getBody() {
        String generateBodyFromParams = SigmobRequestUtil.generateBodyFromParams(getParams(), getUrl());
        if (generateBodyFromParams == null) {
            return null;
        }
        return generateBodyFromParams.getBytes();
    }

    @Override // com.czhj.volley.Request
    public String getBodyContentType() {
        return super.getBodyContentType();
    }

    @Override // com.czhj.volley.Request
    public Map<String, String> getHeaders() {
        TreeMap treeMap = new TreeMap();
        if (SigmobRequestUtil.a(this.f10578a)) {
            String language = Locale.getDefault().getLanguage();
            if (ClientMetadata.getInstance() != null) {
                Locale deviceLocale = ClientMetadata.getInstance().getDeviceLocale();
                if (!deviceLocale.getLanguage().trim().isEmpty()) {
                    language = deviceLocale.getLanguage().trim();
                }
            }
            if (!TextUtils.isEmpty(language)) {
                treeMap.put(ResponseHeader.ACCEPT_LANGUAGE.getKey(), language);
            }
        }
        return treeMap;
    }

    public String getOriginalUrl() {
        return this.f10578a;
    }

    @Override // com.czhj.volley.Request
    public String getUrl() {
        return super.getUrl();
    }

    @Override // com.czhj.volley.Request
    public VolleyError parseNetworkError(VolleyError volleyError) {
        return super.parseNetworkError(volleyError);
    }

    @Override // com.czhj.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(networkResponse, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
