package com.kwad.components.core.offline.b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.offline.b.a.k;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.e.c;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b {
    private static final AtomicBoolean mHasInit = new AtomicBoolean();

    static {
        ddtmy();
    }

    @ForInvoker(methodId = "initOC")
    public static void ay(Context context) {
        com.kwad.components.offline.a.b.aN(context);
        com.kwad.components.offline.b.b.aN(context);
        com.kwad.components.offline.c.b.aN(context);
        com.kwad.components.offline.d.b.aN(context);
        c.aN(context);
    }

    private static /* synthetic */ void ddtmy() {
        char[] charArray = "yuw4}{w\u007f4xuc4ir\u007fvv4PtsXhs~}\u007f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 26);
        }
        String str = new String(charArray);
        char[] charArray2 = "yvstsn".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 26);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void init(final Context context) {
        AtomicBoolean atomicBoolean = mHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new k());
        h.execute(new bg() { // from class: com.kwad.components.core.offline.b.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.ay(context);
            }
        });
    }
}
