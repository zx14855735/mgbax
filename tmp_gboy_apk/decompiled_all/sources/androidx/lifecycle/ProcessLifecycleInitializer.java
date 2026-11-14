package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ProcessLifecycleInitializer implements DXnQ0V.A4TApA {
    @Override // DXnQ0V.A4TApA
    public final List A2egSU() {
        return RD2OKB.B9tovu.f7846AcNBzu;
    }

    @Override // DXnQ0V.A4TApA
    public final Object A4TApA(Context context) {
        RXb0Sz.ARc23Z.AMqCpz(context, "context");
        DXnQ0V.A2egSU A5SV6n2 = DXnQ0V.A2egSU.A5SV6n(context);
        RXb0Sz.ARc23Z.ADYaiT(A5SV6n2, "getInstance(context)");
        if (!A5SV6n2.f2201A4TApA.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!B3GDIM.f8983A2egSU.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            RXb0Sz.ARc23Z.A5SV6n(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new B2KMhB());
        }
        C2rE4F c2rE4F = C2rE4F.f8999B7CMnp;
        c2rE4F.getClass();
        c2rE4F.f9004B25kr6 = new Handler();
        c2rE4F.f9005B2KMhB.ARc23Z(AlLFFp.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        RXb0Sz.ARc23Z.A5SV6n(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new BpkvW3(c2rE4F));
        return c2rE4F;
    }
}
