package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class EmojiCompatInitializer implements DXnQ0V.A4TApA {
    @Override // DXnQ0V.A4TApA
    public final List A2egSU() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // DXnQ0V.A4TApA
    public final Object A4TApA(Context context) {
        AzWtSf azWtSf = new AzWtSf(new NOd7IU.AmA8tU(context, 10));
        azWtSf.f8655A4TApA = 1;
        if (AmA8tU.f8658AaHO0E == null) {
            synchronized (AmA8tU.f8657AZkASS) {
                try {
                    if (AmA8tU.f8658AaHO0E == null) {
                        AmA8tU.f8658AaHO0E = new AmA8tU(azWtSf);
                    }
                } finally {
                }
            }
        }
        A5SV6n(context);
        return Boolean.TRUE;
    }

    public final void A5SV6n(Context context) {
        Object obj;
        DXnQ0V.A2egSU A5SV6n2 = DXnQ0V.A2egSU.A5SV6n(context);
        A5SV6n2.getClass();
        synchronized (DXnQ0V.A2egSU.AMqCpz) {
            try {
                obj = A5SV6n2.f2200A2egSU.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = A5SV6n2.A4TApA(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final androidx.lifecycle.AzWtSf lifecycle = ((androidx.lifecycle.B9tovu) obj).getLifecycle();
        lifecycle.A2egSU(new androidx.lifecycle.AMqCpz() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.AMqCpz
            public final void onResume() {
                EmojiCompatInitializer.this.getClass();
                (Build.VERSION.SDK_INT >= 28 ? A4TApA.A2egSU(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new JrXYwF.A2egSU(6), 500L);
                lifecycle.A5SV6n(this);
            }
        });
    }
}
