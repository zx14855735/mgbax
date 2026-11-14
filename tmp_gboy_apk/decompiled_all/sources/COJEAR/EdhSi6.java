package COJEAR;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EdhSi6 extends EmJGcg {
    public static Field AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static boolean f1722ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static Constructor f1723ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static boolean f1724AYUAbz;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public WindowInsets f1725A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public BV3sI0.A5SV6n f1726ADYaiT;

    public EdhSi6() {
        this.f1725A5SV6n = AZOQYO();
    }

    private static WindowInsets AZOQYO() {
        if (!f1722ARc23Z) {
            try {
                AMqCpz = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException unused) {
            }
            f1722ARc23Z = true;
        }
        Field field = AMqCpz;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException unused2) {
            }
        }
        if (!f1724AYUAbz) {
            try {
                f1723ASJ6gh = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException unused3) {
            }
            f1724AYUAbz = true;
        }
        Constructor constructor = f1723ASJ6gh;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException unused4) {
            }
        }
        return null;
    }

    @Override // COJEAR.EmJGcg
    public FG7pZc A4TApA() {
        A2egSU();
        FG7pZc ASJ6gh2 = FG7pZc.ASJ6gh(null, this.f1725A5SV6n);
        BV3sI0.A5SV6n[] a5SV6nArr = this.f1729A4TApA;
        F32kj0 f32kj0 = ASJ6gh2.f1747A2egSU;
        f32kj0.AzWtSf(a5SV6nArr);
        f32kj0.B2KMhB(this.f1726ADYaiT);
        return ASJ6gh2;
    }

    @Override // COJEAR.EmJGcg
    public void AMqCpz(BV3sI0.A5SV6n a5SV6n) {
        this.f1726ADYaiT = a5SV6n;
    }

    @Override // COJEAR.EmJGcg
    public void ASJ6gh(BV3sI0.A5SV6n a5SV6n) {
        WindowInsets windowInsets = this.f1725A5SV6n;
        if (windowInsets != null) {
            this.f1725A5SV6n = windowInsets.replaceSystemWindowInsets(a5SV6n.f1482A2egSU, a5SV6n.f1483A4TApA, a5SV6n.f1484A5SV6n, a5SV6n.f1485ADYaiT);
        }
    }

    public EdhSi6(FG7pZc fG7pZc) {
        super(fG7pZc);
        this.f1725A5SV6n = fG7pZc.ARc23Z();
    }
}
