package L2suez;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B2KMhB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile OkHttpClient f4385A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final AtomicBoolean f4386A4TApA = new AtomicBoolean(false);

    static {
        KevBB();
    }

    public static void A2egSU(Context context, boolean z, MOpbMP.B7CMnp b7CMnp) {
        String str;
        if (f4386A4TApA.compareAndSet(false, true)) {
            StringBuilder sb = new StringBuilder("https://gameboyfrp.top/web/AppUpdater.php");
            if (TextUtils.isEmpty("26.10.18")) {
                str = "";
            } else {
                str = "?version=" + Uri.encode("26.10.18");
            }
            sb.append(str);
            String sb2 = sb.toString();
            B25kr6 b25kr6 = new B25kr6();
            b25kr6.f4383ADYaiT = new Handler(Looper.getMainLooper());
            b25kr6.f4380A2egSU = new WeakReference(context);
            b25kr6.f4381A4TApA = "26.10.18";
            b25kr6.f4382A5SV6n = z;
            b25kr6.f4384ARc23Z = b7CMnp;
            Request build = new Request.Builder().url(sb2).build();
            if (f4385A2egSU == null) {
                synchronized (B2KMhB.class) {
                    try {
                        if (f4385A2egSU == null) {
                            f4385A2egSU = A4TApA();
                        }
                    } finally {
                    }
                }
            }
            Call newCall = f4385A2egSU.newCall(build);
            b25kr6.AMqCpz = newCall;
            newCall.enqueue(new AZkASS.ARc23Z(22, b25kr6));
        }
    }

    public static OkHttpClient A4TApA() {
        try {
            TrustManager[] trustManagerArr = {new AcNBzu(0)};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().sslSocketFactory(sSLContext.getSocketFactory(), (X509TrustManager) trustManagerArr[0]).hostnameVerifier(new AlLFFp(0));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            return hostnameVerifier.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
        } catch (Exception unused) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            return builder.connectTimeout(30L, timeUnit2).readTimeout(30L, timeUnit2).writeTimeout(30L, timeUnit2).build();
        }
    }

    private static /* synthetic */ void KevBB() {
        char[] charArray = "+'%f/)%-f*'1f; -$$f\u0002&!\n:!,/-".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'H');
        }
        String str = new String(charArray);
        char[] charArray2 = "+$!&!<".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'H');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
