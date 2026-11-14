package IQ76hF;

import I3HV03.BJ7GGh;
import MOpbMP.B2KMhB;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements Handler.Callback {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final Hdahpu.AZOQYO f3945B3GDIM = new Hdahpu.AZOQYO(17);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public volatile com.bumptech.glide.AzWtSf f3946AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final HashMap f3947AlLFFp = new HashMap();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final HashMap f3948AmA8tU = new HashMap();

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Handler f3949AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Hdahpu.AZOQYO f3950B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ARc23Z f3951B2KMhB;

    static {
        MCxGxE();
    }

    public AaHO0E(NGepWW.A2egSU a2egSU) {
        new B25kr6.ADYaiT();
        new B25kr6.ADYaiT();
        new Bundle();
        this.f3950B25kr6 = f3945B3GDIM;
        this.f3949AzWtSf = new Handler(Looper.getMainLooper(), this);
        this.f3951B2KMhB = (BJ7GGh.f3848AYUAbz && BJ7GGh.f3847ASJ6gh) ? ((Map) a2egSU.f5658AlLFFp).containsKey(com.bumptech.glide.AMqCpz.class) ? new AMqCpz() : new Hdahpu.AZOQYO(16) : new Hdahpu.AZOQYO(14);
    }

    public static Activity A2egSU(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return A2egSU(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static /* synthetic */ void MCxGxE() {
        char[] charArray = "fjh+bdh`+gj|+vm`ii+OklGwlab`".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 5);
        }
        String str = new String(charArray);
        char[] charArray2 = "filklq".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 5);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final com.bumptech.glide.AzWtSf A4TApA(Activity activity) {
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return A5SV6n(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return ADYaiT((FragmentActivity) activity);
        }
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f3951B2KMhB.getClass();
        FragmentManager fragmentManager = activity.getFragmentManager();
        Activity A2egSU2 = A2egSU(activity);
        boolean z = A2egSU2 == null || !A2egSU2.isFinishing();
        AZkASS AMqCpz = AMqCpz(fragmentManager);
        com.bumptech.glide.AzWtSf azWtSf = AMqCpz.f3943AzWtSf;
        if (azWtSf != null) {
            return azWtSf;
        }
        com.bumptech.glide.A4TApA A4TApA2 = com.bumptech.glide.A4TApA.A4TApA(activity);
        this.f3950B25kr6.getClass();
        com.bumptech.glide.AzWtSf azWtSf2 = new com.bumptech.glide.AzWtSf(A4TApA2, AMqCpz.f3940AcNBzu, AMqCpz.f3941AlLFFp, activity);
        if (z) {
            azWtSf2.onStart();
        }
        AMqCpz.f3943AzWtSf = azWtSf2;
        return azWtSf2;
    }

    public final com.bumptech.glide.AzWtSf A5SV6n(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return ADYaiT((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return A4TApA((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return A5SV6n(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f3946AcNBzu == null) {
            synchronized (this) {
                try {
                    if (this.f3946AcNBzu == null) {
                        com.bumptech.glide.A4TApA A4TApA2 = com.bumptech.glide.A4TApA.A4TApA(context.getApplicationContext());
                        Hdahpu.AZOQYO azoqyo = this.f3950B25kr6;
                        Hdahpu.AZOQYO azoqyo2 = new Hdahpu.AZOQYO(13);
                        Hdahpu.AZOQYO azoqyo3 = new Hdahpu.AZOQYO(15);
                        Context applicationContext = context.getApplicationContext();
                        azoqyo.getClass();
                        this.f3946AcNBzu = new com.bumptech.glide.AzWtSf(A4TApA2, azoqyo2, azoqyo3, applicationContext);
                    }
                } finally {
                }
            }
        }
        return this.f3946AcNBzu;
    }

    public final com.bumptech.glide.AzWtSf ADYaiT(FragmentActivity fragmentActivity) {
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return A5SV6n(fragmentActivity.getApplicationContext());
        }
        if (fragmentActivity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f3951B2KMhB.getClass();
        CtxOCS supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Activity A2egSU2 = A2egSU(fragmentActivity);
        return ASJ6gh(fragmentActivity, supportFragmentManager, null, A2egSU2 == null || !A2egSU2.isFinishing());
    }

    public final AZkASS AMqCpz(FragmentManager fragmentManager) {
        AZkASS aZkASS = (AZkASS) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (aZkASS != null) {
            return aZkASS;
        }
        HashMap hashMap = this.f3947AlLFFp;
        AZkASS aZkASS2 = (AZkASS) hashMap.get(fragmentManager);
        if (aZkASS2 != null) {
            return aZkASS2;
        }
        AZkASS aZkASS3 = new AZkASS();
        hashMap.put(fragmentManager, aZkASS3);
        fragmentManager.beginTransaction().add(aZkASS3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f3949AzWtSf.obtainMessage(1, fragmentManager).sendToTarget();
        return aZkASS3;
    }

    public final AzWtSf ARc23Z(CtxOCS ctxOCS, B2KMhB b2KMhB) {
        AzWtSf azWtSf = (AzWtSf) ctxOCS.BTvldC("com.bumptech.glide.manager");
        if (azWtSf != null) {
            return azWtSf;
        }
        HashMap hashMap = this.f3948AmA8tU;
        AzWtSf azWtSf2 = (AzWtSf) hashMap.get(ctxOCS);
        if (azWtSf2 == null) {
            azWtSf2 = new AzWtSf();
            azWtSf2.f3962B2KMhB = b2KMhB;
            if (b2KMhB != null && b2KMhB.getContext() != null) {
                Fragment fragment = b2KMhB;
                while (fragment.getParentFragment() != null) {
                    fragment = fragment.getParentFragment();
                }
                CtxOCS fragmentManager = fragment.getFragmentManager();
                if (fragmentManager != null) {
                    azWtSf2.AZkASS(b2KMhB.getContext(), fragmentManager);
                }
            }
            hashMap.put(ctxOCS, azWtSf2);
            androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(ctxOCS);
            a2egSU.AZOQYO(0, azWtSf2, "com.bumptech.glide.manager", 1);
            a2egSU.B2KMhB(true);
            this.f3949AzWtSf.obtainMessage(2, ctxOCS).sendToTarget();
        }
        return azWtSf2;
    }

    public final com.bumptech.glide.AzWtSf ASJ6gh(Context context, CtxOCS ctxOCS, B2KMhB b2KMhB, boolean z) {
        AzWtSf ARc23Z2 = ARc23Z(ctxOCS, b2KMhB);
        com.bumptech.glide.AzWtSf azWtSf = ARc23Z2.f3961B25kr6;
        if (azWtSf != null) {
            return azWtSf;
        }
        com.bumptech.glide.A4TApA A4TApA2 = com.bumptech.glide.A4TApA.A4TApA(context);
        this.f3950B25kr6.getClass();
        com.bumptech.glide.AzWtSf azWtSf2 = new com.bumptech.glide.AzWtSf(A4TApA2, ARc23Z2.f3957AcNBzu, ARc23Z2.f3958AlLFFp, context);
        if (z) {
            azWtSf2.onStart();
        }
        ARc23Z2.f3961B25kr6 = azWtSf2;
        return azWtSf2;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        Object obj3;
        int i = message.what;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f3947AlLFFp.remove(obj);
        } else {
            if (i != 2) {
                obj3 = null;
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Objects.toString(obj2);
                }
                return z;
            }
            obj = (CtxOCS) message.obj;
            remove = this.f3948AmA8tU.remove(obj);
        }
        Object obj4 = remove;
        obj2 = obj;
        obj3 = obj4;
        if (z) {
            Objects.toString(obj2);
        }
        return z;
    }
}
