package IJPJ4E;

import HSHyT0.B3GDIM;
import HXc4pW.AlLFFp;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.AzWtSf;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HPJABZ.ADYaiT f3905A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Handler f3906A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f3907A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final AzWtSf f3908ADYaiT;
    public final HZUvgL.ADYaiT AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f3909ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f3910ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public RequestBuilder f3911AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public AMqCpz f3912AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f3913AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public AMqCpz f3914AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Bitmap f3915AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AMqCpz f3916AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f3917AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f3918AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f3919B25kr6;

    public AYUAbz(com.bumptech.glide.A4TApA a4TApA, HPJABZ.ADYaiT aDYaiT, int i, int i2, Bitmap bitmap) {
        HwAeAU.ADYaiT aDYaiT2 = HwAeAU.ADYaiT.f3802A4TApA;
        HZUvgL.ADYaiT aDYaiT3 = a4TApA.f9875AcNBzu;
        AzWtSf ARc23Z2 = com.bumptech.glide.A4TApA.ARc23Z(a4TApA.getContext());
        RequestBuilder A2egSU2 = com.bumptech.glide.A4TApA.ARc23Z(a4TApA.getContext()).A2egSU(Bitmap.class).A2egSU(AzWtSf.f9947BChYOn).A2egSU(((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().ADYaiT(AlLFFp.f3556A4TApA)).B7CMnp()).B25kr6(true)).AZOQYO(i, i2));
        this.f3907A5SV6n = new ArrayList();
        this.f3908ADYaiT = ARc23Z2;
        Handler handler = new Handler(Looper.getMainLooper(), new ASJ6gh(0, this));
        this.AMqCpz = aDYaiT3;
        this.f3906A4TApA = handler;
        this.f3911AYUAbz = A2egSU2;
        this.f3905A2egSU = aDYaiT;
        A5SV6n(aDYaiT2, bitmap);
    }

    public final void A2egSU() {
        int i;
        if (!this.f3909ARc23Z || this.f3910ASJ6gh) {
            return;
        }
        AMqCpz aMqCpz = this.f3916AlLFFp;
        if (aMqCpz != null) {
            this.f3916AlLFFp = null;
            A4TApA(aMqCpz);
            return;
        }
        this.f3910ASJ6gh = true;
        HPJABZ.ADYaiT aDYaiT = this.f3905A2egSU;
        int i2 = aDYaiT.f3448AcNBzu.f3426A5SV6n;
        long uptimeMillis = SystemClock.uptimeMillis() + ((i2 <= 0 || (i = aDYaiT.f3447AaHO0E) < 0) ? 0 : (i < 0 || i >= i2) ? -1 : ((HPJABZ.A2egSU) r3.AMqCpz.get(i)).f3421AZOQYO);
        int i3 = (aDYaiT.f3447AaHO0E + 1) % aDYaiT.f3448AcNBzu.f3426A5SV6n;
        aDYaiT.f3447AaHO0E = i3;
        this.f3914AaHO0E = new AMqCpz(i3, uptimeMillis, this.f3906A4TApA);
        RequestBuilder BmvVmW2 = this.f3911AYUAbz.A2egSU((RequestOptions) new RequestOptions().AmA8tU(new IssTRV.ADYaiT(Double.valueOf(Math.random())))).BmvVmW(aDYaiT);
        BmvVmW2.BPw6Q8(this.f3914AaHO0E, null, BmvVmW2, ItGa5w.ARc23Z.f4079A2egSU);
    }

    public final void A4TApA(AMqCpz aMqCpz) {
        this.f3910ASJ6gh = false;
        boolean z = this.f3913AZkASS;
        Handler handler = this.f3906A4TApA;
        if (z) {
            handler.obtainMessage(2, aMqCpz).sendToTarget();
            return;
        }
        if (!this.f3909ARc23Z) {
            this.f3916AlLFFp = aMqCpz;
            return;
        }
        if (aMqCpz.f3902B3GDIM != null) {
            Bitmap bitmap = this.f3915AcNBzu;
            if (bitmap != null) {
                this.AMqCpz.A4TApA(bitmap);
                this.f3915AcNBzu = null;
            }
            AMqCpz aMqCpz2 = this.f3912AZOQYO;
            this.f3912AZOQYO = aMqCpz;
            ArrayList arrayList = this.f3907A5SV6n;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                A4TApA a4TApA = (A4TApA) ((ARc23Z) arrayList.get(size));
                Object callback = a4TApA.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    a4TApA.stop();
                    a4TApA.invalidateSelf();
                } else {
                    a4TApA.invalidateSelf();
                    AMqCpz aMqCpz3 = ((AYUAbz) a4TApA.f3888AcNBzu.f2321A4TApA).f3912AZOQYO;
                    if ((aMqCpz3 != null ? aMqCpz3.f3900B25kr6 : -1) == r5.f3905A2egSU.f3448AcNBzu.f3426A5SV6n - 1) {
                        a4TApA.f3893B2KMhB++;
                    }
                    int i = a4TApA.f3894B3GDIM;
                    if (i != -1 && a4TApA.f3893B2KMhB >= i) {
                        a4TApA.stop();
                    }
                }
            }
            if (aMqCpz2 != null) {
                handler.obtainMessage(2, aMqCpz2).sendToTarget();
            }
        }
        A2egSU();
    }

    public final void A5SV6n(B3GDIM b3gdim, Bitmap bitmap) {
        ItGa5w.ARc23Z.A5SV6n(b3gdim, "Argument must not be null");
        ItGa5w.ARc23Z.A5SV6n(bitmap, "Argument must not be null");
        this.f3915AcNBzu = bitmap;
        this.f3911AYUAbz = this.f3911AYUAbz.A2egSU(new RequestOptions().B2KMhB(b3gdim, true));
        this.f3917AmA8tU = ItGa5w.AlLFFp.A5SV6n(bitmap);
        this.f3918AzWtSf = bitmap.getWidth();
        this.f3919B25kr6 = bitmap.getHeight();
    }
}
