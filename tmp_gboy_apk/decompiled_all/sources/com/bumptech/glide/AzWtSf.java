package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.request.RequestOptions;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements ComponentCallbacks2, IQ76hF.AYUAbz {

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final RequestOptions f9947BChYOn;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A4TApA f9948AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Context f9949AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final IQ76hF.ASJ6gh f9950AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final IQ76hF.AlLFFp f9951AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final IQ76hF.AcNBzu f9952B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final IQ76hF.B25kr6 f9953B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final LLYwnm.AMqCpz f9954B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final IQ76hF.A4TApA f9955B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final CopyOnWriteArrayList f9956B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public RequestOptions f9957B9tovu;

    static {
        RequestOptions requestOptions = (RequestOptions) new RequestOptions().A5SV6n(Bitmap.class);
        requestOptions.f3997BTvldC = true;
        f9947BChYOn = requestOptions;
        ((RequestOptions) new RequestOptions().A5SV6n(IJPJ4E.A4TApA.class)).f3997BTvldC = true;
        aXWox();
    }

    public AzWtSf(A4TApA a4TApA, IQ76hF.ASJ6gh aSJ6gh, IQ76hF.AcNBzu acNBzu, Context context) {
        RequestOptions requestOptions;
        IQ76hF.AlLFFp alLFFp = new IQ76hF.AlLFFp();
        IQ76hF.ADYaiT aDYaiT = a4TApA.f9881B3GDIM;
        this.f9953B2KMhB = new IQ76hF.B25kr6();
        LLYwnm.AMqCpz aMqCpz = new LLYwnm.AMqCpz(27, this);
        this.f9954B3GDIM = aMqCpz;
        this.f9948AcNBzu = a4TApA;
        this.f9950AmA8tU = aSJ6gh;
        this.f9952B25kr6 = acNBzu;
        this.f9951AzWtSf = alLFFp;
        this.f9949AlLFFp = context;
        Context applicationContext = context.getApplicationContext();
        I3HV03.A4TApA a4TApA2 = new I3HV03.A4TApA(this, alLFFp, 19, false);
        aDYaiT.getClass();
        boolean z = BPw6Q8.ASJ6gh.A2egSU(applicationContext, g.b) == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        IQ76hF.A4TApA a5SV6n = z ? new IQ76hF.A5SV6n(applicationContext, a4TApA2) : new IQ76hF.AZOQYO();
        this.f9955B4ZgIw = a5SV6n;
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aSJ6gh.ASJ6gh(this);
        } else {
            ItGa5w.AlLFFp.AMqCpz().post(aMqCpz);
        }
        aSJ6gh.ASJ6gh(a5SV6n);
        this.f9956B7CMnp = new CopyOnWriteArrayList(a4TApA.f9877AmA8tU.AMqCpz);
        ARc23Z aRc23Z = a4TApA.f9877AmA8tU;
        synchronized (aRc23Z) {
            try {
                if (aRc23Z.f9927AZkASS == null) {
                    aRc23Z.f9922ADYaiT.getClass();
                    RequestOptions requestOptions2 = new RequestOptions();
                    requestOptions2.f3997BTvldC = true;
                    aRc23Z.f9927AZkASS = requestOptions2;
                }
                requestOptions = aRc23Z.f9927AZkASS;
            } catch (Throwable th) {
                throw th;
            }
        }
        AmA8tU(requestOptions);
        a4TApA.ADYaiT(this);
    }

    private static /* synthetic */ void aXWox() {
        char[] charArray = "%)+h!'+#h$)?h5.#**h\f(/\u00044/\"!#".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'F');
        }
        String str = new String(charArray);
        char[] charArray2 = "%*/(/2".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'F');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final RequestBuilder A2egSU(Class cls) {
        return new RequestBuilder(this.f9948AcNBzu, this, cls, this.f9949AlLFFp);
    }

    public final void A5SV6n(IlwJBd.AYUAbz aYUAbz) {
        if (aYUAbz == null) {
            return;
        }
        boolean AzWtSf2 = AzWtSf(aYUAbz);
        IhMMDv.A5SV6n AYUAbz2 = aYUAbz.AYUAbz();
        if (AzWtSf2) {
            return;
        }
        A4TApA a4TApA = this.f9948AcNBzu;
        synchronized (a4TApA.f9882B4ZgIw) {
            try {
                Iterator it = a4TApA.f9882B4ZgIw.iterator();
                while (it.hasNext()) {
                    if (((AzWtSf) it.next()).AzWtSf(aYUAbz)) {
                        return;
                    }
                }
                if (AYUAbz2 != null) {
                    aYUAbz.ARc23Z(null);
                    AYUAbz2.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final RequestBuilder AaHO0E(String str) {
        return A2egSU(Drawable.class).BmvVmW(str);
    }

    public final synchronized void AcNBzu() {
        IQ76hF.AlLFFp alLFFp = this.f9951AzWtSf;
        alLFFp.f3954A5SV6n = true;
        Iterator it = ItGa5w.AlLFFp.ADYaiT(alLFFp.f3952A2egSU).iterator();
        while (it.hasNext()) {
            IhMMDv.A5SV6n a5SV6n = (IhMMDv.A5SV6n) it.next();
            if (a5SV6n.isRunning()) {
                a5SV6n.pause();
                alLFFp.f3953A4TApA.add(a5SV6n);
            }
        }
    }

    public final synchronized void AlLFFp() {
        IQ76hF.AlLFFp alLFFp = this.f9951AzWtSf;
        alLFFp.f3954A5SV6n = false;
        Iterator it = ItGa5w.AlLFFp.ADYaiT(alLFFp.f3952A2egSU).iterator();
        while (it.hasNext()) {
            IhMMDv.A5SV6n a5SV6n = (IhMMDv.A5SV6n) it.next();
            if (!a5SV6n.AaHO0E() && !a5SV6n.isRunning()) {
                a5SV6n.AZOQYO();
            }
        }
        alLFFp.f3953A4TApA.clear();
    }

    public final synchronized void AmA8tU(RequestOptions requestOptions) {
        RequestOptions requestOptions2 = (RequestOptions) requestOptions.clone();
        if (requestOptions2.f3997BTvldC && !requestOptions2.f3998BV3sI0) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        requestOptions2.f3998BV3sI0 = true;
        requestOptions2.f3997BTvldC = true;
        this.f9957B9tovu = requestOptions2;
    }

    public final synchronized boolean AzWtSf(IlwJBd.AYUAbz aYUAbz) {
        IhMMDv.A5SV6n AYUAbz2 = aYUAbz.AYUAbz();
        if (AYUAbz2 == null) {
            return true;
        }
        if (!this.f9951AzWtSf.A2egSU(AYUAbz2)) {
            return false;
        }
        this.f9953B2KMhB.f3963AcNBzu.remove(aYUAbz);
        aYUAbz.ARc23Z(null);
        return true;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // IQ76hF.AYUAbz
    public final synchronized void onDestroy() {
        try {
            this.f9953B2KMhB.onDestroy();
            Iterator it = ItGa5w.AlLFFp.ADYaiT(this.f9953B2KMhB.f3963AcNBzu).iterator();
            while (it.hasNext()) {
                A5SV6n((IlwJBd.AYUAbz) it.next());
            }
            this.f9953B2KMhB.f3963AcNBzu.clear();
            IQ76hF.AlLFFp alLFFp = this.f9951AzWtSf;
            Iterator it2 = ItGa5w.AlLFFp.ADYaiT(alLFFp.f3952A2egSU).iterator();
            while (it2.hasNext()) {
                alLFFp.A2egSU((IhMMDv.A5SV6n) it2.next());
            }
            alLFFp.f3953A4TApA.clear();
            this.f9950AmA8tU.A4TApA(this);
            this.f9950AmA8tU.A4TApA(this.f9955B4ZgIw);
            ItGa5w.AlLFFp.AMqCpz().removeCallbacks(this.f9954B3GDIM);
            this.f9948AcNBzu.AMqCpz(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // IQ76hF.AYUAbz
    public final synchronized void onStart() {
        AlLFFp();
        this.f9953B2KMhB.onStart();
    }

    @Override // IQ76hF.AYUAbz
    public final synchronized void onStop() {
        AcNBzu();
        this.f9953B2KMhB.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f9951AzWtSf + ", treeNode=" + this.f9952B25kr6 + "}";
    }
}
