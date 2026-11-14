package EY4UKY;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ARc23Z {
    public static AMqCpz A2egSU(Activity activity) {
        AMqCpz aMqCpz = new AMqCpz();
        aMqCpz.f2536AcNBzu = null;
        if (ExjC7D.A2egSU.A5SV6n(activity)) {
            return aMqCpz;
        }
        WeakReference weakReference = new WeakReference(activity);
        aMqCpz.f2536AcNBzu = weakReference;
        ExjC7D.A2egSU.A5SV6n((Activity) weakReference.get());
        return aMqCpz;
    }
}
