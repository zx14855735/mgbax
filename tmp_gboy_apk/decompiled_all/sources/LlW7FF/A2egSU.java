package LlW7FF;

import L2suez.AcNBzu;
import L2suez.AlLFFp;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final OkHttpClient f4864A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Gson f4865A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Handler f4866A5SV6n = new Handler(Looper.getMainLooper());

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final String[] f4867ADYaiT = {"Mozilla/5.0 (Linux; Android 13; SM-S918B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; 2210132G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; Pixel 7 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; CPH2447) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; LNA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (iPhone14,6; U; CPU iPhone OS 15_4 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) Version/15.4 Mobile/10A403 Safari/602.1.50", "Mozilla/5.0 (iPhone; CPU iPhone OS 16_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1"};

    static {
        TrustManager[] trustManagerArr = {new AcNBzu(1)};
        AlLFFp alLFFp = new AlLFFp(1);
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().sslSocketFactory(sSLContext.getSocketFactory(), (X509TrustManager) trustManagerArr[0]).hostnameVerifier(alLFFp);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            f4864A2egSU = hostnameVerifier.connectTimeout(10L, timeUnit).readTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).build();
            f4865A4TApA = new GsonBuilder().create();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to initialize SSL context", e);
        }
    }
}
