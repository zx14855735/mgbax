package com.kwad.sdk.core.network;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class a<R extends f> {
    private static final ExecutorService sExecutors = GlobalThreadPools.Ll();
    private Future<?> mTask;

    static {
        CMmVF();
    }

    private static /* synthetic */ void CMmVF() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void cancel() {
        Future<?> future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }

    public abstract R createRequest();

    public void fetch() {
        this.mTask = getExecutor().submit(new bg() { // from class: com.kwad.sdk.core.network.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.fetchImpl();
            }
        });
    }

    public abstract void fetchImpl();

    public ExecutorService getExecutor() {
        return sExecutors;
    }

    public abstract void onResponse(R r, c cVar);
}
