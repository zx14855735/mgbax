package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.ARc23Z;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.common.al;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends SigmobRequest<NetworkResponse> {

    /* renamed from: a, reason: collision with root package name */
    private final a f13196a;

    public interface a extends Response.ErrorListener {
        void a(NetworkResponse networkResponse);
    }

    public b(String str, int i, a aVar) {
        super(str, 0, aVar);
        this.f13196a = aVar;
        setShouldRetryServerErrors(true);
        setRetryPolicy(new DefaultRetryPolicy(i, 5000, 0, 0.0f));
        setShouldCache(false);
    }

    @Override // com.czhj.volley.Request
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(NetworkResponse networkResponse) {
        a aVar;
        synchronized (this.mLock) {
            aVar = this.f13196a;
        }
        SigmobLog.i("send tracking: " + getUrl() + " success");
        if (aVar == null) {
            return;
        }
        aVar.a(networkResponse);
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        SigmobLog.e("send tracking: " + getUrl() + " fail");
        super.deliverError(volleyError);
    }

    @Override // com.czhj.volley.Request
    public int getMaxLength() {
        return 100;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Response<NetworkResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(networkResponse, null);
    }

    public b(String str, a aVar) {
        this(str, 5000, aVar);
    }

    public static void a(String str, String str2, WindAdRequest windAdRequest, NetworkResponse networkResponse, String str3) {
        al.a(PointCategory.HB_TRACKING).a(windAdRequest).a(new ARc23Z(str, str2, str3, networkResponse, 2)).a();
    }

    public static void a(final String str, final String str2, final WindAdRequest windAdRequest, final String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b(str, new a() { // from class: com.sigmob.sdk.base.network.b.1
            @Override // com.sigmob.sdk.base.network.b.a
            public void a(NetworkResponse networkResponse) {
                b.a(str, str2, windAdRequest, networkResponse, str3);
            }

            @Override // com.czhj.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                b.a(str, str2, windAdRequest, volleyError != null ? volleyError.networkResponse : null, str3);
            }
        });
        if (Networking.getSigRequestQueue() != null) {
            Networking.getSigRequestQueue().add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, String str3, NetworkResponse networkResponse, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setUrl(str);
            pointEntitySigmob.setTracking_type(str2);
            pointEntitySigmob.setRequest_id(str3);
            if (networkResponse == null) {
                return;
            }
            byte[] bArr = networkResponse.data;
            pointEntitySigmob.setResponse(bArr == null ? null : Base64.encodeToString(bArr, 2));
            pointEntitySigmob.setHttp_code(String.valueOf(networkResponse.statusCode));
            pointEntitySigmob.setTime_spend(String.valueOf(networkResponse.networkTimeMs));
            pointEntitySigmob.setContent_type(networkResponse.headers.get("Content-Type"));
            pointEntitySigmob.setContent_length(networkResponse.headers.get(com.sigmob.sdk.downloader.core.c.e));
        }
    }
}
