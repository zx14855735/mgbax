package com.czhj.devicehelper.cnoaid.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.czhj.devicehelper.honor.identifier.a;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.reflect.Method;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class g implements com.czhj.devicehelper.cnoaid.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10498a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private boolean c;

    public g(Context context) {
        this.f10498a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.czhj.devicehelper.cnoaid.c cVar) {
        String str;
        try {
            if (this.c) {
                a.C0213a a2 = com.czhj.devicehelper.honor.identifier.a.a(this.f10498a);
                if (a2 == null) {
                    return;
                } else {
                    str = a2.f10526a;
                }
            } else {
                Method method = Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class);
                if (method == null) {
                    return;
                }
                Object invoke = method.invoke(null, this.f10498a);
                if (invoke == null) {
                    a(cVar, new com.czhj.devicehelper.cnoaid.f("HIDeviceIDHelper info is null"));
                    return;
                }
                Object obj = invoke.getClass().getField(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a).get(invoke);
                if (!(obj instanceof String)) {
                    return;
                } else {
                    str = (String) obj;
                }
            }
            a(cVar, str);
        } catch (Throwable th) {
            a(cVar, new com.czhj.devicehelper.cnoaid.f(th));
        }
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(final com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f10498a == null || cVar == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.b(cVar);
            }
        });
    }

    private void a(final com.czhj.devicehelper.cnoaid.c cVar, final com.czhj.devicehelper.cnoaid.f fVar) {
        this.b.post(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.g.3
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(fVar);
            }
        });
    }

    private void a(final com.czhj.devicehelper.cnoaid.c cVar, final String str) {
        this.b.post(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.g.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(str);
            }
        });
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        if (this.f10498a == null) {
            return false;
        }
        try {
            Object invoke = Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient").getMethod("isAdvertisingIdAvailable", Context.class).invoke(null, this.f10498a);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            SigmobLog.e("HIDeviceIDHelper isAdvertisingIdAvailable error ", th);
            try {
                boolean b = com.czhj.devicehelper.honor.identifier.a.b(this.f10498a);
                this.c = true;
                return b;
            } catch (Throwable unused) {
            }
        }
    }
}
