package com.kwad.sdk.commercial.h;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ksad.annotation.invoker.InvokeBy;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.i.g;
import com.kwad.sdk.i.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a implements com.kwad.sdk.core.d.a.a {
    private final AtomicBoolean mHasInit;

    /* renamed from: com.kwad.sdk.commercial.h.a$a, reason: collision with other inner class name */
    public static final class C0350a {
        private static final a aAM = new a(0);

        static {
            BwUnePj();
        }

        private static /* synthetic */ void BwUnePj() {
            char[] charArray = "\u009e\u0092\u0090Ó\u009a\u009c\u0090\u0098Ó\u009f\u0092\u0084Ó\u008e\u0095\u0098\u0091\u0091Ó·\u0093\u0094¿\u008f\u0094\u0099\u009a\u0098".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 253);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u009e\u0091\u0094\u0093\u0094\u0089".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 253);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a FP() {
        return C0350a.aAM;
    }

    @InvokeBy(invokerClass = c.class, methodId = "registerLogger")
    public static void register() {
        c.a(FP());
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        h.OS().f(t.t, str, str2);
    }

    public final void df(String str) {
        try {
            if (this.mHasInit.get()) {
                return;
            }
            Context Re = ServiceProvider.Re();
            final f fVar = (f) ServiceProvider.get(f.class);
            h.OS().a(str, g.ON().gr(ServiceProvider.getSDKConfig().appId).gs(ServiceProvider.getSdkVersion()).gt(bd.getOaid()).gw(bd.dA(Re)).gu(bd.getDeviceId()).gv(bd.dB(Re)).n(fVar.Db()).bP(com.kwad.sdk.components.g.encryptDisable()).gx(fVar.Da()).i(fVar.Dd()).o(fVar.Dc()), new com.kwad.sdk.i.f() { // from class: com.kwad.sdk.commercial.h.a.1
                @Override // com.kwad.sdk.i.f
                public final void a(String str2, Map<String, String> map, String str3) {
                    fVar.a(str2, map, str3);
                }

                @Override // com.kwad.sdk.i.f
                public final String av(String str2) {
                    return fVar.av(str2);
                }
            });
            b.Ji();
            b.a(new d() { // from class: com.kwad.sdk.commercial.h.a.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    com.kwad.sdk.utils.h.schedule(new bg() { // from class: com.kwad.sdk.commercial.h.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            h.OS().OT();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }
            });
            this.mHasInit.set(true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        h.OS().f("e", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        h.OS().f("i", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th) {
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        h.OS().f(t.c, str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        h.OS().f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }

    private a() {
        this.mHasInit = new AtomicBoolean(false);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z) {
        h.OS().f(t.c, str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z) {
        h.OS().f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }
}
