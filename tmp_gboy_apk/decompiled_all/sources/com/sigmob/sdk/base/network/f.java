package com.sigmob.sdk.base.network;

import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.ModelBuilderCreator;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.toolbox.HttpHeaderParser;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigRequest;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigResponse;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends SigmobRequest<SigmobSdkConfigResponse> {

    /* renamed from: a, reason: collision with root package name */
    private final a f13200a;
    private final SigmobSdkConfigRequest.Builder b;
    private byte[] c;

    public interface a extends Response.ErrorListener {
        void a(SigmobSdkConfigResponse sigmobSdkConfigResponse);
    }

    public f(String str, a aVar) {
        super(str, 1, aVar);
        this.f13200a = aVar;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
        this.b = a();
    }

    public static SigmobSdkConfigRequest.Builder a() {
        SigmobSdkConfigRequest.Builder builder = new SigmobSdkConfigRequest.Builder();
        ClientMetadata clientMetadata = ClientMetadata.getInstance();
        if (clientMetadata != null && clientMetadata.getDeviceLocale() != null) {
            builder.app(com.sigmob.sdk.base.network.a.b().build());
            builder.user(com.sigmob.sdk.base.network.a.c().build());
            builder.privacy(com.sigmob.sdk.base.network.a.d().build());
            DeviceContext b = com.sigmob.sdk.b.b();
            builder.network(ModelBuilderCreator.createNetwork(b).build());
            builder.device(ModelBuilderCreator.createDevice(b).did(ModelBuilderCreator.createDeviceId(b).build()).build());
        }
        return builder;
    }

    public a b() {
        return this.f13200a;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public byte[] getBody() {
        return this.c;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public String getBodyContentType() {
        return "application/octet-stream";
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        } catch (NoSuchMethodError unused) {
            headers.put("e", "1");
        }
        SigmobSdkConfigRequest build = this.b.build();
        try {
            byte[] encode = build.encode();
            this.c = encode;
            this.c = c.b(encode);
            headers.put("cp", "1");
        } catch (Throwable unused2) {
            headers.remove("cp");
            this.c = build.encode();
        }
        try {
            this.c = AESUtil.Encrypt(this.c, "KGpfzbYsn4T9Jyuq");
        } catch (Exception e) {
            e.printStackTrace();
            headers.remove("e");
            headers.remove("agn");
        }
        return headers;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Response<SigmobSdkConfigResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            if (networkResponse.data == null) {
                return Response.error(new ParseError(networkResponse));
            }
            return Response.success(SigmobSdkConfigResponse.ADAPTER.decode((networkResponse.headers.containsKey("cp") && "1".equals(networkResponse.headers.get("cp"))) ? c.a(networkResponse.data) : networkResponse.data), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return Response.error(new ParseError(th));
        }
    }

    @Override // com.czhj.volley.Request
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
        this.f13200a.a(sigmobSdkConfigResponse);
    }
}
