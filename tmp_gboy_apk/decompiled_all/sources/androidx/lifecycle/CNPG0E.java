package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CNPG0E extends Fragment {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final /* synthetic */ int f9008AlLFFp = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public NGepWW.A2egSU f9009AcNBzu;

    public static final class A2egSU implements Application.ActivityLifecycleCallbacks {
        public static final CASmeH Companion = new CASmeH();

        static {
            DUqCL();
        }

        private static /* synthetic */ void DUqCL() {
            char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'i');
            }
            String str = new String(charArray);
            char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'i');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            activity.registerActivityLifecycleCallbacks(new A2egSU());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            int i = CNPG0E.f9008AlLFFp;
            C4FrIb.A2egSU(activity, AlLFFp.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            int i = CNPG0E.f9008AlLFFp;
            C4FrIb.A2egSU(activity, AlLFFp.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            int i = CNPG0E.f9008AlLFFp;
            C4FrIb.A2egSU(activity, AlLFFp.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            int i = CNPG0E.f9008AlLFFp;
            C4FrIb.A2egSU(activity, AlLFFp.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            int i = CNPG0E.f9008AlLFFp;
            C4FrIb.A2egSU(activity, AlLFFp.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            int i = CNPG0E.f9008AlLFFp;
            C4FrIb.A2egSU(activity, AlLFFp.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            RXb0Sz.ARc23Z.AMqCpz(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        }
    }

    public final void A2egSU(AlLFFp alLFFp) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            RXb0Sz.ARc23Z.ADYaiT(activity, TTDownloadField.TT_ACTIVITY);
            C4FrIb.A2egSU(activity, alLFFp);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        A2egSU(AlLFFp.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        A2egSU(AlLFFp.ON_DESTROY);
        this.f9009AcNBzu = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        A2egSU(AlLFFp.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        NGepWW.A2egSU a2egSU = this.f9009AcNBzu;
        if (a2egSU != null) {
            ((C2rE4F) a2egSU.f5658AlLFFp).A2egSU();
        }
        A2egSU(AlLFFp.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        NGepWW.A2egSU a2egSU = this.f9009AcNBzu;
        if (a2egSU != null) {
            C2rE4F c2rE4F = (C2rE4F) a2egSU.f5658AlLFFp;
            int i = c2rE4F.f9000AcNBzu + 1;
            c2rE4F.f9000AcNBzu = i;
            if (i == 1 && c2rE4F.f9003AzWtSf) {
                c2rE4F.f9005B2KMhB.ARc23Z(AlLFFp.ON_START);
                c2rE4F.f9003AzWtSf = false;
            }
        }
        A2egSU(AlLFFp.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        A2egSU(AlLFFp.ON_STOP);
    }
}
