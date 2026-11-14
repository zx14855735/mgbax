package IhMMDv;

import HXc4pW.BI9f7h;
import ItGa5w.AlLFFp;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements Future, IlwJBd.AYUAbz, ARc23Z {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Object f4006AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public A5SV6n f4007AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f4008AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f4009AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f4010B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public BI9f7h f4011B2KMhB;

    static {
        QlYdxrO();
    }

    private static /* synthetic */ void QlYdxrO() {
        char[] charArray = "R^\\\u001fVP\\T\u001fS^H\u001fBYT]]\u001f{_XsCXUVT".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '1');
        }
        String str = new String(charArray);
        char[] charArray2 = "R]X_XE".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '1');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // IhMMDv.ARc23Z
    public final synchronized boolean A2egSU(BI9f7h bI9f7h) {
        this.f4010B25kr6 = true;
        this.f4011B2KMhB = bI9f7h;
        notifyAll();
        return false;
    }

    @Override // IlwJBd.AYUAbz
    public final void A4TApA(ASJ6gh aSJ6gh) {
    }

    @Override // IhMMDv.ARc23Z
    public final synchronized void A5SV6n(Object obj) {
        this.f4009AzWtSf = true;
        this.f4006AcNBzu = obj;
        notifyAll();
    }

    @Override // IlwJBd.AYUAbz
    public final synchronized void ADYaiT(Object obj, IsbtnO.A4TApA a4TApA) {
    }

    @Override // IlwJBd.AYUAbz
    public final synchronized void AMqCpz(Drawable drawable) {
    }

    @Override // IlwJBd.AYUAbz
    public final synchronized void ARc23Z(A5SV6n a5SV6n) {
        this.f4007AlLFFp = a5SV6n;
    }

    @Override // IlwJBd.AYUAbz
    public final void ASJ6gh(Drawable drawable) {
    }

    @Override // IlwJBd.AYUAbz
    public final synchronized A5SV6n AYUAbz() {
        return this.f4007AlLFFp;
    }

    @Override // IlwJBd.AYUAbz
    public final void AZOQYO(Drawable drawable) {
    }

    @Override // IlwJBd.AYUAbz
    public final void AZkASS(ASJ6gh aSJ6gh) {
        aSJ6gh.AcNBzu(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final synchronized Object AaHO0E(Long l) {
        if (!isDone()) {
            char[] cArr = AlLFFp.f4092A2egSU;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalArgumentException("You must call this method on a background thread");
            }
        }
        if (this.f4008AmA8tU) {
            throw new CancellationException();
        }
        if (this.f4010B25kr6) {
            throw new ExecutionException(this.f4011B2KMhB);
        }
        if (this.f4009AzWtSf) {
            return this.f4006AcNBzu;
        }
        if (l == null) {
            wait(0L);
        } else if (l.longValue() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = l.longValue() + currentTimeMillis;
            while (!isDone() && currentTimeMillis < longValue) {
                wait(longValue - currentTimeMillis);
                currentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.f4010B25kr6) {
            throw new ExecutionException(this.f4011B2KMhB);
        }
        if (this.f4008AmA8tU) {
            throw new CancellationException();
        }
        if (this.f4009AzWtSf) {
            return this.f4006AcNBzu;
        }
        throw new TimeoutException();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f4008AmA8tU = true;
                notifyAll();
                A5SV6n a5SV6n = null;
                if (z) {
                    A5SV6n a5SV6n2 = this.f4007AlLFFp;
                    this.f4007AlLFFp = null;
                    a5SV6n = a5SV6n2;
                }
                if (a5SV6n != null) {
                    a5SV6n.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        try {
            return AaHO0E(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isCancelled() {
        return this.f4008AmA8tU;
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isDone() {
        boolean z;
        if (!this.f4008AmA8tU && !this.f4009AzWtSf) {
            z = this.f4010B25kr6;
        }
        return z;
    }

    @Override // IQ76hF.AYUAbz
    public final void onDestroy() {
    }

    @Override // IQ76hF.AYUAbz
    public final void onStart() {
    }

    @Override // IQ76hF.AYUAbz
    public final void onStop() {
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return AaHO0E(Long.valueOf(timeUnit.toMillis(j)));
    }
}
