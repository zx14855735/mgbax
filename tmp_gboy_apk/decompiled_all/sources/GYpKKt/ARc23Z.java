package GYpKKt;

import android.content.Context;
import android.webkit.WebSettings;
import com.baidu.mobads.sdk.internal.an;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final MediaType f3062A2egSU = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final OkHttpClient f3063A4TApA;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder readTimeout = builder.connectTimeout(3000L, timeUnit).readTimeout(3000L, timeUnit);
        try {
            TrustManager[] trustManagerArr = {new AMqCpz()};
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            readTimeout.sslSocketFactory(sSLContext.getSocketFactory(), (X509TrustManager) trustManagerArr[0]).hostnameVerifier(new ADYaiT());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.getMessage();
            int i = GJee0v.AZOQYO.f3039AcNBzu;
        }
        f3063A4TApA = readTimeout.build();
    }

    public static Request A2egSU(BTvldC.ADYaiT aDYaiT) {
        Request.Builder addHeader = new Request.Builder().url((String) aDYaiT.f1448AlLFFp).addHeader("Connection", "Keep-Alive").addHeader("Charset", "UTF-8");
        Context context = EY4UKY.A2egSU.A5SV6n().f2499A2egSU;
        if (context == null) {
            context = null;
        }
        addHeader.addHeader("User-Agent", WebSettings.getDefaultUserAgent(context));
        if (aDYaiT.f1447AcNBzu == 1) {
            JSONObject jSONObject = new JSONObject();
            String[] strArr = (String[]) aDYaiT.f1449AmA8tU;
            jSONObject.put("cipher", strArr[0]);
            jSONObject.put("encryptParams", strArr[1]);
            addHeader.post(RequestBody.create(f3062A2egSU, jSONObject.toString())).addHeader("Content-Type", an.d);
        }
        return addHeader.build();
    }

    public static Request A4TApA(BTvldC.ADYaiT aDYaiT) {
        Request.Builder addHeader = new Request.Builder().url((String) aDYaiT.f1448AlLFFp).addHeader("Connection", "Keep-Alive").addHeader("Charset", "UTF-8");
        Context context = EY4UKY.A2egSU.A5SV6n().f2499A2egSU;
        if (context == null) {
            context = null;
        }
        addHeader.addHeader("User-Agent", WebSettings.getDefaultUserAgent(context));
        if (aDYaiT.f1447AcNBzu == 1) {
            JSONObject jSONObject = new JSONObject();
            String[] strArr = (String[]) aDYaiT.f1449AmA8tU;
            jSONObject.put("cipher", strArr[0]);
            jSONObject.put("encryptParams", strArr[1]);
            addHeader.post(RequestBody.create(f3062A2egSU, jSONObject.toString())).addHeader("Content-Type", an.d);
        }
        return addHeader.build();
    }
}
