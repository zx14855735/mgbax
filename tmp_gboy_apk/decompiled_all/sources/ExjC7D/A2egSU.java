package ExjC7D;

import FpcJKS.A5SV6n;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.AMqCpz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile A2egSU f2559A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A4TApA f2560A2egSU = new A4TApA();

    public static A2egSU A2egSU() {
        if (f2559A4TApA == null) {
            synchronized (A2egSU.class) {
                try {
                    if (f2559A4TApA == null) {
                        f2559A4TApA = new A2egSU();
                    }
                } finally {
                }
            }
        }
        return f2559A4TApA;
    }

    public static FpcJKS.A2egSU A4TApA(Context context) {
        AMqCpz.ARc23Z();
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        try {
            if (context instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                A4TApA a4TApA = A2egSU().f2560A2egSU;
                int i = Fmmv0E.A2egSU.f2873A2egSU;
                a4TApA.getClass();
                if (A5SV6n(fragmentActivity)) {
                    return null;
                }
                AMqCpz.ARc23Z();
                if (fragmentActivity.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                CtxOCS supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                A5SV6n a5SV6n = (A5SV6n) supportFragmentManager.BTvldC("me.ykrank.androidlifecycle.manager");
                if (a5SV6n == null) {
                    a5SV6n = new A5SV6n();
                    androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(supportFragmentManager);
                    a2egSU.AZOQYO(0, a5SV6n, "me.ykrank.androidlifecycle.manager", 1);
                    a2egSU.ARc23Z();
                }
                if (a5SV6n.f2880AcNBzu == null) {
                    a5SV6n.f2882AmA8tU = 1;
                    FpcJKS.A2egSU a2egSU2 = new FpcJKS.A2egSU();
                    a5SV6n.f2880AcNBzu = a2egSU2;
                    a5SV6n.f2881AlLFFp = a2egSU2.f2875A2egSU;
                }
                FpcJKS.A2egSU a2egSU3 = a5SV6n.f2880AcNBzu;
                if (a2egSU3 != null) {
                    return a2egSU3;
                }
                throw new NullPointerException("Argument must not be null");
            }
            if (!(context instanceof Activity)) {
                if (context instanceof ContextWrapper) {
                    return A4TApA(((ContextWrapper) context).getBaseContext());
                }
                StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("Illegal type of context:");
                AMqCpz.append(context.toString());
                throw new IllegalArgumentException(AMqCpz.toString());
            }
            Activity activity = (Activity) context;
            A4TApA a4TApA2 = A2egSU().f2560A2egSU;
            int i2 = Fmmv0E.A2egSU.f2873A2egSU;
            a4TApA2.getClass();
            if (A5SV6n(activity)) {
                return null;
            }
            AMqCpz.ARc23Z();
            if (activity.isDestroyed()) {
                throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
            }
            FpcJKS.A4TApA A2egSU2 = a4TApA2.A2egSU(activity.getFragmentManager());
            if (A2egSU2.f2876AcNBzu == null) {
                A2egSU2.f2878AmA8tU = 1;
                FpcJKS.A2egSU a2egSU4 = new FpcJKS.A2egSU();
                A2egSU2.f2876AcNBzu = a2egSU4;
                A2egSU2.f2877AlLFFp = a2egSU4.f2875A2egSU;
            }
            FpcJKS.A2egSU a2egSU5 = A2egSU2.f2876AcNBzu;
            if (a2egSU5 != null) {
                return a2egSU5;
            }
            throw new NullPointerException("Argument must not be null");
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean A5SV6n(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
