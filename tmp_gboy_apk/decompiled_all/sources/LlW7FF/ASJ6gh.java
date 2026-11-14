package LlW7FF;

import L2suez.AcNBzu;
import L2suez.AlLFFp;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.czhj.sdk.common.Constants;
import com.game.boy.MyApp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.Call;
import okhttp3.ConnectionSpec;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.TlsVersion;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static volatile OkHttpClient f4881ARc23Z;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final OkHttpClient f4883A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Gson f4884A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Handler f4885A5SV6n = new Handler(Looper.getMainLooper());

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ConcurrentHashMap f4886ADYaiT = new ConcurrentHashMap();
    public static final MediaType AMqCpz = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final A4TApA f4882ASJ6gh = new A4TApA(null, null, null);

    static {
        HUHt();
    }

    public ASJ6gh(Context context) {
        context.getApplicationContext();
        this.f4884A4TApA = new GsonBuilder().create();
        if (f4881ARc23Z == null) {
            synchronized (ASJ6gh.class) {
                try {
                    if (f4881ARc23Z == null) {
                        f4881ARc23Z = AMqCpz();
                    }
                } finally {
                }
            }
        }
        this.f4883A2egSU = f4881ARc23Z;
    }

    public static void A2egSU(ASJ6gh aSJ6gh, String str) {
        synchronized (aSJ6gh) {
            ARc23Z aRc23Z = (ARc23Z) aSJ6gh.f4886ADYaiT.remove(str);
            if (aRc23Z != null && aRc23Z != f4882ASJ6gh) {
                aRc23Z.A2egSU();
            }
        }
    }

    public static HashMap A4TApA(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("参数必须成对出现");
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < objArr.length; i += 2) {
            hashMap.put(objArr[i].toString(), objArr[i + 1]);
        }
        return hashMap;
    }

    public static OkHttpClient AMqCpz() {
        SecureRandom secureRandom;
        try {
            AcNBzu acNBzu = new AcNBzu(2);
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (Exception unused) {
                secureRandom = new SecureRandom();
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{acNBzu}, secureRandom);
            OkHttpClient.Builder connectionSpecs = new OkHttpClient.Builder().sslSocketFactory(sSLContext.getSocketFactory(), acNBzu).hostnameVerifier(new AlLFFp(2)).connectionSpecs(Arrays.asList(new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).allEnabledCipherSuites().build(), new ConnectionSpec.Builder(ConnectionSpec.CLEARTEXT).build()));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            return connectionSpecs.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).retryOnConnectionFailure(true).build();
        } catch (Exception unused2) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            return builder.connectTimeout(30L, timeUnit2).readTimeout(30L, timeUnit2).writeTimeout(30L, timeUnit2).build();
        }
    }

    public static String ASJ6gh(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder(str);
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append("|");
                sb.append(obj.toString());
            }
        }
        return sb.toString();
    }

    private static /* synthetic */ void HUHt() {
        char[] charArray = "=13p9?3;p<1'p-6;22p\u001407\u001c,7:9;".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '^');
        }
        String str = new String(charArray);
        char[] charArray2 = "=2707*".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '^');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized boolean A5SV6n(String str) {
        if (this.f4886ADYaiT.containsKey(str)) {
            return false;
        }
        this.f4886ADYaiT.put(str, f4882ASJ6gh);
        return true;
    }

    public final Request ADYaiT(HashMap hashMap) {
        return new Request.Builder().url("https://gboy.top/api/api.php").post(RequestBody.create(AMqCpz, this.f4884A4TApA.toJson(hashMap))).build();
    }

    public final void ARc23Z(Request request, Class cls, AMqCpz aMqCpz, String str, boolean z) {
        ARc23Z aRc23Z = (ARc23Z) this.f4886ADYaiT.get(str);
        if (aRc23Z != null && aRc23Z.f4880ADYaiT) {
            this.f4886ADYaiT.remove(str);
        }
        Call newCall = this.f4883A2egSU.newCall(request);
        A5SV6n a5SV6n = new A5SV6n(this, str, aMqCpz, z);
        this.f4885A5SV6n.postDelayed(a5SV6n, 30000L);
        this.f4886ADYaiT.put(str, new ARc23Z(newCall, a5SV6n, this.f4885A5SV6n));
        newCall.enqueue(new ADYaiT(this, str, aMqCpz, z, cls));
    }

    public final void AYUAbz(String str, String str2, String str3, AMqCpz aMqCpz) {
        String ASJ6gh2 = ASJ6gh(str, str2);
        if (A5SV6n(ASJ6gh2)) {
            ARc23Z(ADYaiT(A4TApA("action", str, Constants.TOKEN, str2, "download_id", str3)), MTKlkd.A2egSU.class, aMqCpz, ASJ6gh2, false);
        } else {
            AZOQYO(aMqCpz, "检查收藏请求正在进行中，请稍候", false);
        }
    }

    public final void AZOQYO(AMqCpz aMqCpz, String str, boolean z) {
        if (z) {
            MyApp.A2egSU(str);
        }
        this.f4885A5SV6n.post(new C4FrIb.A2egSU(aMqCpz, 27, str));
    }
}
