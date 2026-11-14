package QigWB9;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class AMqCpz {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final ThreadPoolExecutor f7711B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static A2egSU f7712B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f7713B4ZgIw;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A4TApA f7714AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final GcSJYy.A4TApA f7715AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public volatile int f7716AmA8tU = 1;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AtomicBoolean f7717AzWtSf = new AtomicBoolean();

    /* renamed from: B25kr6, reason: collision with root package name */
    public final AtomicBoolean f7718B25kr6 = new AtomicBoolean();

    public static class A2egSU extends Handler {
        public A2egSU() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ADYaiT aDYaiT = (ADYaiT) message.obj;
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                aDYaiT.f7709A2egSU.getClass();
            } else {
                AMqCpz aMqCpz = aDYaiT.f7709A2egSU;
                Object obj = aDYaiT.f7710A4TApA[0];
                if (aMqCpz.f7717AzWtSf.get()) {
                    aMqCpz.A5SV6n(obj);
                } else {
                    aMqCpz.A4TApA(obj);
                }
                aMqCpz.f7716AmA8tU = 3;
            }
        }
    }

    static {
        AcNBzu.A4TApA a4TApA = new AcNBzu.A4TApA(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, r.b.d, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), a4TApA);
        f7711B2KMhB = threadPoolExecutor;
        f7713B4ZgIw = threadPoolExecutor;
        dufjS();
    }

    public AMqCpz() {
        A4TApA a4TApA = new A4TApA(this);
        this.f7714AcNBzu = a4TApA;
        this.f7715AlLFFp = new GcSJYy.A4TApA(this, a4TApA, 1);
    }

    private static /* synthetic */ void dufjS() {
        char[] charArray = "\u0080\u008c\u008eÍ\u0084\u0082\u008e\u0086Í\u0081\u008c\u009aÍ\u0090\u008b\u0086\u008f\u008fÍ©\u008d\u008a¡\u0091\u008a\u0087\u0084\u0086".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 227);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0080\u008f\u008a\u008d\u008a\u0097".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 227);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public abstract void A2egSU();

    public void A4TApA(Object obj) {
    }

    public void A5SV6n(Object obj) {
    }

    public final void ADYaiT(Object obj) {
        A2egSU a2egSU;
        synchronized (AMqCpz.class) {
            try {
                if (f7712B3GDIM == null) {
                    f7712B3GDIM = new A2egSU();
                }
                a2egSU = f7712B3GDIM;
            } catch (Throwable th) {
                throw th;
            }
        }
        a2egSU.obtainMessage(1, new ADYaiT(this, obj)).sendToTarget();
    }
}
