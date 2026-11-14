package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.an;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d extends SigmobRequest {

    /* renamed from: a, reason: collision with root package name */
    private final a f13198a;
    private byte[] b;

    public interface a extends Response.ErrorListener {
        void a(JSONObject jSONObject);
    }

    public d(String str, BidResponse bidResponse, a aVar) {
        super(str, 1, aVar);
        this.f13198a = aVar;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
        String a2 = a(bidResponse);
        if (a2 == null) {
            return;
        }
        try {
            this.b = AESUtil.Encrypt(a2.getBytes(), "KGpfzbYsn4T9Jyuq");
        } catch (Exception unused) {
            SigmobLog.e("feedback body bug");
        }
    }

    private String a(BidResponse bidResponse) {
        try {
            JSONObject jSONObject = new JSONObject(JSONSerializer.Serialize(bidResponse));
            JSONObject optJSONObject = jSONObject.optJSONObject("scene");
            if (optJSONObject != null) {
                a(optJSONObject, "context");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(com.sigmob.sdk.base.db.a.f13169a);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONArray jSONArray = optJSONArray.getJSONObject(i).getJSONArray("materials");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        a(jSONObject2, "html_snippet");
                        a(jSONObject2, "closecard_html_snippet");
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("main_template");
                        if (optJSONObject2 != null) {
                            a(optJSONObject2, "context");
                        }
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("sub_template");
                        if (optJSONObject3 != null) {
                            a(optJSONObject3, "context");
                        }
                    }
                }
            }
            SigmobLog.d("json " + jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            SigmobLog.e("Serialize error", th);
            return null;
        }
    }

    @Override // com.czhj.volley.Request, java.lang.Comparable
    public int compareTo(Object obj) {
        return 0;
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        super.deliverError(volleyError);
        a aVar = this.f13198a;
        if (aVar == null) {
            return;
        }
        aVar.onErrorResponse(volleyError);
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(Object obj) {
        a aVar = this.f13198a;
        if (aVar == null) {
            return;
        }
        aVar.a(null);
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public byte[] getBody() {
        return this.b;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public String getBodyContentType() {
        return an.d;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
            return headers;
        } catch (NoSuchMethodError unused) {
            headers.put("e", "1");
            return headers;
        }
    }

    private void a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            Object opt = optJSONObject.opt(keys.next());
            if (opt instanceof String) {
                String str2 = (String) opt;
                if (TextUtils.isEmpty(str2)) {
                    continue;
                } else {
                    String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
                    jSONObject.remove(str);
                    try {
                        jSONObject.put(str, encodeToString);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
