package ExjC7D;

import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA implements Handler.Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final HashMap f2561AcNBzu = new HashMap();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Handler f2562AlLFFp = new Handler(Looper.getMainLooper(), this);

    public final FpcJKS.A4TApA A2egSU(FragmentManager fragmentManager) {
        FpcJKS.A4TApA a4TApA = (FpcJKS.A4TApA) fragmentManager.findFragmentByTag("me.ykrank.androidlifecycle.manager");
        if (a4TApA != null) {
            return a4TApA;
        }
        HashMap hashMap = this.f2561AcNBzu;
        FpcJKS.A4TApA a4TApA2 = (FpcJKS.A4TApA) hashMap.get(fragmentManager);
        if (a4TApA2 != null) {
            return a4TApA2;
        }
        FpcJKS.A4TApA a4TApA3 = new FpcJKS.A4TApA();
        hashMap.put(fragmentManager, a4TApA3);
        fragmentManager.beginTransaction().add(a4TApA3, "me.ykrank.androidlifecycle.manager").commitAllowingStateLoss();
        this.f2562AlLFFp.obtainMessage(1, fragmentManager).sendToTarget();
        return a4TApA3;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        FragmentManager fragmentManager;
        Object remove;
        boolean z = true;
        if (message.what != 1) {
            remove = null;
            z = false;
            fragmentManager = null;
        } else {
            FragmentManager fragmentManager2 = (FragmentManager) message.obj;
            fragmentManager = fragmentManager2;
            remove = this.f2561AcNBzu.remove(fragmentManager2);
        }
        if (z && remove == null && Log.isLoggable("AndroidLifeCycle", 5)) {
            Objects.toString(fragmentManager);
        }
        return z;
    }
}
