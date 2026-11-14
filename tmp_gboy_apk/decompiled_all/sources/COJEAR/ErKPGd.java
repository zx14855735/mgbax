package COJEAR;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ErKPGd extends F32kj0 {

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static boolean f1730AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static Method f1731AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static Class f1732AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static Field f1733AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static Field f1734AcNBzu;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final WindowInsets f1735A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public BV3sI0.A5SV6n[] f1736ADYaiT;
    public BV3sI0.A5SV6n AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public FG7pZc f1737ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public BV3sI0.A5SV6n f1738ASJ6gh;

    public ErKPGd(FG7pZc fG7pZc, WindowInsets windowInsets) {
        super(fG7pZc);
        this.AMqCpz = null;
        this.f1735A5SV6n = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private BV3sI0.A5SV6n B3GDIM(int i, boolean z) {
        BV3sI0.A5SV6n a5SV6n = BV3sI0.A5SV6n.AMqCpz;
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                a5SV6n = BV3sI0.A5SV6n.A2egSU(a5SV6n, B4ZgIw(i2, z));
            }
        }
        return a5SV6n;
    }

    private BV3sI0.A5SV6n B7CMnp() {
        FG7pZc fG7pZc = this.f1737ARc23Z;
        return fG7pZc != null ? fG7pZc.f1747A2egSU.AYUAbz() : BV3sI0.A5SV6n.AMqCpz;
    }

    private BV3sI0.A5SV6n B9tovu(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f1730AYUAbz) {
            BChYOn();
        }
        Method method = f1731AZOQYO;
        if (method != null && f1732AZkASS != null && f1733AaHO0E != null) {
            try {
                Object invoke = method.invoke(view, new Object[0]);
                if (invoke != null) {
                    Rect rect = (Rect) f1733AaHO0E.get(f1734AcNBzu.get(invoke));
                    if (rect != null) {
                        return BV3sI0.A5SV6n.A4TApA(rect.left, rect.top, rect.right, rect.bottom);
                    }
                }
            } catch (ReflectiveOperationException e) {
                e.getMessage();
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void BChYOn() {
        try {
            f1731AZOQYO = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f1732AZkASS = cls;
            f1733AaHO0E = cls.getDeclaredField("mVisibleInsets");
            f1734AcNBzu = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f1733AaHO0E.setAccessible(true);
            f1734AcNBzu.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            e.getMessage();
        }
        f1730AYUAbz = true;
    }

    @Override // COJEAR.F32kj0
    public void ADYaiT(View view) {
        BV3sI0.A5SV6n B9tovu2 = B9tovu(view);
        if (B9tovu2 == null) {
            B9tovu2 = BV3sI0.A5SV6n.AMqCpz;
        }
        BI9f7h(B9tovu2);
    }

    @Override // COJEAR.F32kj0
    public BV3sI0.A5SV6n ARc23Z(int i) {
        return B3GDIM(i, false);
    }

    @Override // COJEAR.F32kj0
    public final BV3sI0.A5SV6n AZkASS() {
        if (this.AMqCpz == null) {
            WindowInsets windowInsets = this.f1735A5SV6n;
            this.AMqCpz = BV3sI0.A5SV6n.A4TApA(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.AMqCpz;
    }

    @Override // COJEAR.F32kj0
    public FG7pZc AcNBzu(int i, int i2, int i3, int i4) {
        EdQ5bb edQ5bb = new EdQ5bb(FG7pZc.ASJ6gh(null, this.f1735A5SV6n));
        BV3sI0.A5SV6n AMqCpz = FG7pZc.AMqCpz(AZkASS(), i, i2, i3, i4);
        EmJGcg emJGcg = edQ5bb.f1721A2egSU;
        emJGcg.ASJ6gh(AMqCpz);
        emJGcg.AMqCpz(FG7pZc.AMqCpz(AYUAbz(), i, i2, i3, i4));
        return emJGcg.A4TApA();
    }

    @Override // COJEAR.F32kj0
    public boolean AmA8tU() {
        return this.f1735A5SV6n.isRound();
    }

    @Override // COJEAR.F32kj0
    public void AzWtSf(BV3sI0.A5SV6n[] a5SV6nArr) {
        this.f1736ADYaiT = a5SV6nArr;
    }

    @Override // COJEAR.F32kj0
    public void B25kr6(FG7pZc fG7pZc) {
        this.f1737ARc23Z = fG7pZc;
    }

    public BV3sI0.A5SV6n B4ZgIw(int i, boolean z) {
        BV3sI0.A5SV6n AYUAbz2;
        int i2;
        if (i == 1) {
            return z ? BV3sI0.A5SV6n.A4TApA(0, Math.max(B7CMnp().f1483A4TApA, AZkASS().f1483A4TApA), 0, 0) : BV3sI0.A5SV6n.A4TApA(0, AZkASS().f1483A4TApA, 0, 0);
        }
        if (i == 2) {
            if (z) {
                BV3sI0.A5SV6n B7CMnp2 = B7CMnp();
                BV3sI0.A5SV6n AYUAbz3 = AYUAbz();
                return BV3sI0.A5SV6n.A4TApA(Math.max(B7CMnp2.f1482A2egSU, AYUAbz3.f1482A2egSU), 0, Math.max(B7CMnp2.f1484A5SV6n, AYUAbz3.f1484A5SV6n), Math.max(B7CMnp2.f1485ADYaiT, AYUAbz3.f1485ADYaiT));
            }
            BV3sI0.A5SV6n AZkASS2 = AZkASS();
            FG7pZc fG7pZc = this.f1737ARc23Z;
            AYUAbz2 = fG7pZc != null ? fG7pZc.f1747A2egSU.AYUAbz() : null;
            int i3 = AZkASS2.f1485ADYaiT;
            if (AYUAbz2 != null) {
                i3 = Math.min(i3, AYUAbz2.f1485ADYaiT);
            }
            return BV3sI0.A5SV6n.A4TApA(AZkASS2.f1482A2egSU, 0, AZkASS2.f1484A5SV6n, i3);
        }
        BV3sI0.A5SV6n a5SV6n = BV3sI0.A5SV6n.AMqCpz;
        if (i == 8) {
            BV3sI0.A5SV6n[] a5SV6nArr = this.f1736ADYaiT;
            AYUAbz2 = a5SV6nArr != null ? a5SV6nArr[com.bumptech.glide.AMqCpz.C4FrIb(8)] : null;
            if (AYUAbz2 != null) {
                return AYUAbz2;
            }
            BV3sI0.A5SV6n AZkASS3 = AZkASS();
            BV3sI0.A5SV6n B7CMnp3 = B7CMnp();
            int i4 = AZkASS3.f1485ADYaiT;
            if (i4 > B7CMnp3.f1485ADYaiT) {
                return BV3sI0.A5SV6n.A4TApA(0, 0, 0, i4);
            }
            BV3sI0.A5SV6n a5SV6n2 = this.f1738ASJ6gh;
            return (a5SV6n2 == null || a5SV6n2.equals(a5SV6n) || (i2 = this.f1738ASJ6gh.f1485ADYaiT) <= B7CMnp3.f1485ADYaiT) ? a5SV6n : BV3sI0.A5SV6n.A4TApA(0, 0, 0, i2);
        }
        if (i == 16) {
            return AZOQYO();
        }
        if (i == 32) {
            return ASJ6gh();
        }
        if (i == 64) {
            return AaHO0E();
        }
        if (i != 128) {
            return a5SV6n;
        }
        FG7pZc fG7pZc2 = this.f1737ARc23Z;
        AcNBzu AMqCpz = fG7pZc2 != null ? fG7pZc2.f1747A2egSU.AMqCpz() : AMqCpz();
        if (AMqCpz == null) {
            return a5SV6n;
        }
        int i5 = Build.VERSION.SDK_INT;
        return BV3sI0.A5SV6n.A4TApA(i5 >= 28 ? AaHO0E.ADYaiT(AMqCpz.f1633A2egSU) : 0, i5 >= 28 ? AaHO0E.ARc23Z(AMqCpz.f1633A2egSU) : 0, i5 >= 28 ? AaHO0E.AMqCpz(AMqCpz.f1633A2egSU) : 0, i5 >= 28 ? AaHO0E.A5SV6n(AMqCpz.f1633A2egSU) : 0);
    }

    public void BI9f7h(BV3sI0.A5SV6n a5SV6n) {
        this.f1738ASJ6gh = a5SV6n;
    }

    @Override // COJEAR.F32kj0
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.f1738ASJ6gh, ((ErKPGd) obj).f1738ASJ6gh);
        }
        return false;
    }
}
