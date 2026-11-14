package IhMMDv;

import HSHyT0.AZkASS;
import HSHyT0.AmA8tU;
import HSHyT0.B3GDIM;
import HXc4pW.AlLFFp;
import I3HV03.B25kr6;
import I3HV03.B2KMhB;
import I3HV03.BChYOn;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.AZOQYO;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU implements Cloneable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f3981AcNBzu;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f3985B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f3986B2KMhB;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f3991BChYOn;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f3993BIYEnU;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f3997BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f3998BV3sI0;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f4000BniPrB;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f3982AlLFFp = 1.0f;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public AlLFFp f3983AmA8tU = AlLFFp.f3558ADYaiT;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AZOQYO f3984AzWtSf = AZOQYO.f9931AmA8tU;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f3987B3GDIM = true;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f3988B4ZgIw = -1;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f3989B7CMnp = -1;

    /* renamed from: B9tovu, reason: collision with root package name */
    public AZkASS f3990B9tovu = IssTRV.A5SV6n.f4068A4TApA;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f3992BI9f7h = true;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public AmA8tU f3994BJ7GGh = new AmA8tU();

    /* renamed from: BNL6CD, reason: collision with root package name */
    public ItGa5w.A5SV6n f3995BNL6CD = new ItGa5w.A5SV6n();

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public Class f3996BPw6Q8 = Object.class;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f3999BmvVmW = true;

    public static boolean ASJ6gh(int i, int i2) {
        return (i & i2) != 0;
    }

    public A2egSU A2egSU(A2egSU a2egSU) {
        if (this.f3998BV3sI0) {
            return clone().A2egSU(a2egSU);
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 2)) {
            this.f3982AlLFFp = a2egSU.f3982AlLFFp;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 1048576)) {
            this.f4000BniPrB = a2egSU.f4000BniPrB;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 4)) {
            this.f3983AmA8tU = a2egSU.f3983AmA8tU;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 8)) {
            this.f3984AzWtSf = a2egSU.f3984AzWtSf;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 16)) {
            this.f3985B25kr6 = 0;
            this.f3981AcNBzu &= -33;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 32)) {
            this.f3985B25kr6 = a2egSU.f3985B25kr6;
            this.f3981AcNBzu &= -17;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 64)) {
            this.f3986B2KMhB = 0;
            this.f3981AcNBzu &= -129;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, r.b.d)) {
            this.f3986B2KMhB = a2egSU.f3986B2KMhB;
            this.f3981AcNBzu &= -65;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 256)) {
            this.f3987B3GDIM = a2egSU.f3987B3GDIM;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 512)) {
            this.f3989B7CMnp = a2egSU.f3989B7CMnp;
            this.f3988B4ZgIw = a2egSU.f3988B4ZgIw;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 1024)) {
            this.f3990B9tovu = a2egSU.f3990B9tovu;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, f.a.c)) {
            this.f3996BPw6Q8 = a2egSU.f3996BPw6Q8;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, ProxyCacheUtils.DEFAULT_BUFFER_SIZE)) {
            this.f3993BIYEnU = 0;
            this.f3981AcNBzu &= -16385;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, f.a.d)) {
            this.f3993BIYEnU = a2egSU.f3993BIYEnU;
            this.f3981AcNBzu &= -8193;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 65536)) {
            this.f3992BI9f7h = a2egSU.f3992BI9f7h;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
            this.f3991BChYOn = a2egSU.f3991BChYOn;
        }
        if (ASJ6gh(a2egSU.f3981AcNBzu, 2048)) {
            this.f3995BNL6CD.putAll(a2egSU.f3995BNL6CD);
            this.f3999BmvVmW = a2egSU.f3999BmvVmW;
        }
        if (!this.f3992BI9f7h) {
            this.f3995BNL6CD.clear();
            int i = this.f3981AcNBzu;
            this.f3991BChYOn = false;
            this.f3981AcNBzu = i & (-133121);
            this.f3999BmvVmW = true;
        }
        this.f3981AcNBzu |= a2egSU.f3981AcNBzu;
        this.f3994BJ7GGh.f3470A4TApA.ASJ6gh(a2egSU.f3994BJ7GGh.f3470A4TApA);
        AcNBzu();
        return this;
    }

    @Override // 
    /* renamed from: A4TApA, reason: merged with bridge method [inline-methods] */
    public A2egSU clone() {
        try {
            A2egSU a2egSU = (A2egSU) super.clone();
            AmA8tU amA8tU = new AmA8tU();
            a2egSU.f3994BJ7GGh = amA8tU;
            amA8tU.f3470A4TApA.ASJ6gh(this.f3994BJ7GGh.f3470A4TApA);
            ItGa5w.A5SV6n a5SV6n = new ItGa5w.A5SV6n();
            a2egSU.f3995BNL6CD = a5SV6n;
            a5SV6n.putAll(this.f3995BNL6CD);
            a2egSU.f3997BTvldC = false;
            a2egSU.f3998BV3sI0 = false;
            return a2egSU;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final A2egSU A5SV6n(Class cls) {
        if (this.f3998BV3sI0) {
            return clone().A5SV6n(cls);
        }
        this.f3996BPw6Q8 = cls;
        this.f3981AcNBzu |= f.a.c;
        AcNBzu();
        return this;
    }

    public final A2egSU ADYaiT(AlLFFp alLFFp) {
        if (this.f3998BV3sI0) {
            return clone().ADYaiT(alLFFp);
        }
        ItGa5w.ARc23Z.A5SV6n(alLFFp, "Argument must not be null");
        this.f3983AmA8tU = alLFFp;
        this.f3981AcNBzu |= 4;
        AcNBzu();
        return this;
    }

    public final A2egSU AMqCpz(int i) {
        if (this.f3998BV3sI0) {
            return clone().AMqCpz(i);
        }
        this.f3985B25kr6 = i;
        this.f3981AcNBzu = (this.f3981AcNBzu | 32) & (-17);
        AcNBzu();
        return this;
    }

    public final A2egSU ARc23Z(int i) {
        if (this.f3998BV3sI0) {
            return clone().ARc23Z(i);
        }
        this.f3993BIYEnU = i;
        this.f3981AcNBzu = (this.f3981AcNBzu | f.a.d) & (-8193);
        AcNBzu();
        return this;
    }

    public final A2egSU AYUAbz(B2KMhB b2KMhB, I3HV03.ASJ6gh aSJ6gh) {
        if (this.f3998BV3sI0) {
            return clone().AYUAbz(b2KMhB, aSJ6gh);
        }
        HSHyT0.AlLFFp alLFFp = B2KMhB.f3830ARc23Z;
        ItGa5w.ARc23Z.A5SV6n(b2KMhB, "Argument must not be null");
        AlLFFp(alLFFp, b2KMhB);
        return B2KMhB(aSJ6gh, false);
    }

    public final A2egSU AZOQYO(int i, int i2) {
        if (this.f3998BV3sI0) {
            return clone().AZOQYO(i, i2);
        }
        this.f3989B7CMnp = i;
        this.f3988B4ZgIw = i2;
        this.f3981AcNBzu |= 512;
        AcNBzu();
        return this;
    }

    public final A2egSU AZkASS(int i) {
        if (this.f3998BV3sI0) {
            return clone().AZkASS(i);
        }
        this.f3986B2KMhB = i;
        this.f3981AcNBzu = (this.f3981AcNBzu | r.b.d) & (-65);
        AcNBzu();
        return this;
    }

    public final A2egSU AaHO0E() {
        AZOQYO azoqyo = AZOQYO.f9932AzWtSf;
        if (this.f3998BV3sI0) {
            return clone().AaHO0E();
        }
        this.f3984AzWtSf = azoqyo;
        this.f3981AcNBzu |= 8;
        AcNBzu();
        return this;
    }

    public final void AcNBzu() {
        if (this.f3997BTvldC) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public final A2egSU AlLFFp(HSHyT0.AlLFFp alLFFp, B2KMhB b2KMhB) {
        if (this.f3998BV3sI0) {
            return clone().AlLFFp(alLFFp, b2KMhB);
        }
        ItGa5w.ARc23Z.A4TApA(alLFFp);
        ItGa5w.ARc23Z.A4TApA(b2KMhB);
        this.f3994BJ7GGh.f3470A4TApA.put(alLFFp, b2KMhB);
        AcNBzu();
        return this;
    }

    public final A2egSU AmA8tU(AZkASS aZkASS) {
        if (this.f3998BV3sI0) {
            return clone().AmA8tU(aZkASS);
        }
        this.f3990B9tovu = aZkASS;
        this.f3981AcNBzu |= 1024;
        AcNBzu();
        return this;
    }

    public final A2egSU AzWtSf(float f) {
        if (this.f3998BV3sI0) {
            return clone().AzWtSf(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f3982AlLFFp = f;
        this.f3981AcNBzu |= 2;
        AcNBzu();
        return this;
    }

    public final A2egSU B25kr6(boolean z) {
        if (this.f3998BV3sI0) {
            return clone().B25kr6(true);
        }
        this.f3987B3GDIM = !z;
        this.f3981AcNBzu |= 256;
        AcNBzu();
        return this;
    }

    public final A2egSU B2KMhB(B3GDIM b3gdim, boolean z) {
        if (this.f3998BV3sI0) {
            return clone().B2KMhB(b3gdim, z);
        }
        BChYOn bChYOn = new BChYOn(b3gdim, z);
        B4ZgIw(Bitmap.class, b3gdim, z);
        B4ZgIw(Drawable.class, bChYOn, z);
        B4ZgIw(BitmapDrawable.class, bChYOn, z);
        B4ZgIw(IJPJ4E.A4TApA.class, new IJPJ4E.ADYaiT(b3gdim), z);
        AcNBzu();
        return this;
    }

    public final A2egSU B3GDIM(B25kr6 b25kr6, I3HV03.AZkASS aZkASS) {
        if (this.f3998BV3sI0) {
            return clone().B3GDIM(b25kr6, aZkASS);
        }
        HSHyT0.AlLFFp alLFFp = B2KMhB.f3830ARc23Z;
        ItGa5w.ARc23Z.A5SV6n(b25kr6, "Argument must not be null");
        AlLFFp(alLFFp, b25kr6);
        return B2KMhB(aZkASS, true);
    }

    public final A2egSU B4ZgIw(Class cls, B3GDIM b3gdim, boolean z) {
        if (this.f3998BV3sI0) {
            return clone().B4ZgIw(cls, b3gdim, z);
        }
        ItGa5w.ARc23Z.A4TApA(b3gdim);
        this.f3995BNL6CD.put(cls, b3gdim);
        int i = this.f3981AcNBzu;
        this.f3992BI9f7h = true;
        this.f3981AcNBzu = 67584 | i;
        this.f3999BmvVmW = false;
        if (z) {
            this.f3981AcNBzu = i | 198656;
            this.f3991BChYOn = true;
        }
        AcNBzu();
        return this;
    }

    public final A2egSU B7CMnp() {
        if (this.f3998BV3sI0) {
            return clone().B7CMnp();
        }
        this.f4000BniPrB = true;
        this.f3981AcNBzu |= 1048576;
        AcNBzu();
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof A2egSU)) {
            return false;
        }
        A2egSU a2egSU = (A2egSU) obj;
        if (Float.compare(a2egSU.f3982AlLFFp, this.f3982AlLFFp) != 0 || this.f3985B25kr6 != a2egSU.f3985B25kr6) {
            return false;
        }
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        return this.f3986B2KMhB == a2egSU.f3986B2KMhB && this.f3993BIYEnU == a2egSU.f3993BIYEnU && this.f3987B3GDIM == a2egSU.f3987B3GDIM && this.f3988B4ZgIw == a2egSU.f3988B4ZgIw && this.f3989B7CMnp == a2egSU.f3989B7CMnp && this.f3991BChYOn == a2egSU.f3991BChYOn && this.f3992BI9f7h == a2egSU.f3992BI9f7h && this.f3983AmA8tU.equals(a2egSU.f3983AmA8tU) && this.f3984AzWtSf == a2egSU.f3984AzWtSf && this.f3994BJ7GGh.equals(a2egSU.f3994BJ7GGh) && this.f3995BNL6CD.equals(a2egSU.f3995BNL6CD) && this.f3996BPw6Q8.equals(a2egSU.f3996BPw6Q8) && ItGa5w.AlLFFp.A2egSU(this.f3990B9tovu, a2egSU.f3990B9tovu);
    }

    public final int hashCode() {
        float f = this.f3982AlLFFp;
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        return ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ARc23Z(0, ItGa5w.AlLFFp.ARc23Z(0, ItGa5w.AlLFFp.ARc23Z(this.f3992BI9f7h ? 1 : 0, ItGa5w.AlLFFp.ARc23Z(this.f3991BChYOn ? 1 : 0, ItGa5w.AlLFFp.ARc23Z(this.f3989B7CMnp, ItGa5w.AlLFFp.ARc23Z(this.f3988B4ZgIw, ItGa5w.AlLFFp.ARc23Z(this.f3987B3GDIM ? 1 : 0, ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ARc23Z(this.f3993BIYEnU, ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ARc23Z(this.f3986B2KMhB, ItGa5w.AlLFFp.ASJ6gh(ItGa5w.AlLFFp.ARc23Z(this.f3985B25kr6, ItGa5w.AlLFFp.ARc23Z(Float.floatToIntBits(f), 17)), null)), null)), null)))))))), this.f3983AmA8tU), this.f3984AzWtSf), this.f3994BJ7GGh), this.f3995BNL6CD), this.f3996BPw6Q8), this.f3990B9tovu), null);
    }
}
