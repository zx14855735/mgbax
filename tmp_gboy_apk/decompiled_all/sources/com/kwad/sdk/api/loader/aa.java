package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.s;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class aa {
    private static final AtomicBoolean ayZ = new AtomicBoolean();

    static {
        pHAqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Ff() {
        String cy = com.kwad.sdk.api.c.cy("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(cy) ? cy : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.c.EQ()) {
            return;
        }
        AtomicBoolean atomicBoolean = ayZ;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.aa.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    if (Math.abs(System.currentTimeMillis() - b.q(context, "lastUpdateTime")) < b.q(context, "interval") * 1000) {
                        return;
                    }
                    s.Fe().a(new ab() { // from class: com.kwad.sdk.api.loader.aa.1.1
                        @Override // com.kwad.sdk.api.loader.ab
                        public final String Fg() {
                            return aa.Ff();
                        }

                        @Override // com.kwad.sdk.api.loader.ab
                        public final IKsAdSDK Fh() {
                            return iKsAdSDK;
                        }

                        @Override // com.kwad.sdk.api.loader.ab
                        public final Context getContext() {
                            return context;
                        }
                    }, new s.c<Boolean>() { // from class: com.kwad.sdk.api.loader.aa.1.2
                        private static void c(Boolean bool) {
                        }

                        @Override // com.kwad.sdk.api.loader.s.c
                        public final /* synthetic */ void k(Boolean bool) {
                            c(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void bn(Context context) {
        i.r(context, "");
    }

    private static /* synthetic */ void pHAqx() {
        char[] charArray = "($&e,*&.e)$2e8#.''e\u0001%\"\t9\"/,.".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'K');
        }
        String str = new String(charArray);
        char[] charArray2 = "('\"%\"?".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'K');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
