package LLYwnm;

import ADYaiT.CtFAbx;
import C4FrIb.B4ZgIw;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okio.ByteString;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public WebSocket f4636A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AYUAbz f4638A5SV6n;
    public final OkHttpClient AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final ScheduledExecutorService f4640ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public ScheduledFuture f4641ASJ6gh;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ScheduledExecutorService f4643AZOQYO;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public volatile boolean f4639ADYaiT = false;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final AtomicLong f4642AYUAbz = new AtomicLong(0);

    /* renamed from: AZkASS, reason: collision with root package name */
    public volatile boolean f4644AZkASS = false;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public volatile boolean f4645AaHO0E = false;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AtomicLong f4646AcNBzu = new AtomicLong(0);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f4637A4TApA = "wss://gboy.top:23459";

    public AcNBzu(AYUAbz aYUAbz) {
        int i = 0;
        this.f4638A5SV6n = aYUAbz;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder pingInterval = builder.connectTimeout(10L, timeUnit).readTimeout(0L, timeUnit).writeTimeout(10L, timeUnit).pingInterval(20L, timeUnit);
        try {
            TrustManager[] trustManagerArr = {new AZOQYO()};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            pingInterval.sslSocketFactory(sSLContext.getSocketFactory(), (X509TrustManager) trustManagerArr[0]);
            pingInterval.hostnameVerifier(new AZkASS());
        } catch (Exception e) {
            String AZOQYO2 = CtFAbx.AZOQYO(e, new StringBuilder("SSL配置失败: "));
            AYUAbz aYUAbz2 = this.f4638A5SV6n;
            aYUAbz2.getClass();
            aYUAbz2.A5SV6n(new A2egSU(aYUAbz2, AZOQYO2, i));
        }
        this.AMqCpz = pingInterval.build();
        this.f4640ARc23Z = Executors.newSingleThreadScheduledExecutor();
        this.f4643AZOQYO = Executors.newSingleThreadScheduledExecutor();
    }

    public static void A2egSU(AcNBzu acNBzu, byte[] bArr, AZOQYO.ARc23Z aRc23Z) {
        WebSocket webSocket;
        String str = "msg_" + acNBzu.f4646AcNBzu.incrementAndGet() + "_" + System.currentTimeMillis();
        if (!acNBzu.f4639ADYaiT || (webSocket = acNBzu.f4636A2egSU) == null) {
            if (aRc23Z != null) {
                aRc23Z.AcNBzu(str, "WebSocket未连接");
                return;
            }
            return;
        }
        try {
            webSocket.send(ByteString.of(bArr));
            if (aRc23Z != null) {
                ((AYUAbz) aRc23Z.f366AzWtSf).A5SV6n(new AMqCpz(aRc23Z, str));
            }
        } catch (Exception e) {
            if (aRc23Z != null) {
                aRc23Z.AcNBzu(str, e.getMessage());
            }
            acNBzu.A5SV6n();
        }
    }

    public final synchronized void A4TApA() {
        if (!this.f4644AZkASS && !this.f4645AaHO0E) {
            this.f4645AaHO0E = true;
            try {
                this.f4636A2egSU = this.AMqCpz.newWebSocket(new Request.Builder().url(this.f4637A4TApA).build(), new AaHO0E(this));
            } catch (Exception e) {
                this.f4645AaHO0E = false;
                AYUAbz aYUAbz = this.f4638A5SV6n;
                String str = "连接异常: " + e.getMessage();
                aYUAbz.getClass();
                aYUAbz.A5SV6n(new A2egSU(aYUAbz, str, 0));
                AMqCpz();
            }
        }
    }

    public final synchronized void A5SV6n() {
        try {
            if (this.f4644AZkASS) {
                return;
            }
            WebSocket webSocket = this.f4636A2egSU;
            if (webSocket != null) {
                webSocket.cancel();
                this.f4636A2egSU = null;
            }
            this.f4639ADYaiT = false;
            this.f4645AaHO0E = false;
            this.f4642AYUAbz.set(0L);
            A4TApA();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean ADYaiT() {
        return (!this.f4639ADYaiT || this.f4644AZkASS || this.f4636A2egSU == null) ? false : true;
    }

    public final synchronized void AMqCpz() {
        try {
            if (!this.f4644AZkASS && !this.f4645AaHO0E) {
                ScheduledFuture scheduledFuture = this.f4641ASJ6gh;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.f4641ASJ6gh = this.f4640ARc23Z.schedule(new AMqCpz(3, this), Math.min(((long) Math.pow(2.0d, Math.min(this.f4642AYUAbz.getAndIncrement(), 10L))) * 1000, 30000L), TimeUnit.MILLISECONDS);
            }
        } finally {
        }
    }

    public final void ARc23Z(HashMap hashMap, AZOQYO.ARc23Z aRc23Z) {
        if (!this.f4644AZkASS) {
            this.f4643AZOQYO.execute(new B4ZgIw(8, this, hashMap, aRc23Z));
        } else if (aRc23Z != null) {
            aRc23Z.AcNBzu(null, "客户端已销毁");
        }
    }
}
