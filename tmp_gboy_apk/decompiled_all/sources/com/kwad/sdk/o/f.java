package com.kwad.sdk.o;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Resources auh;
    private Resources biQ;
    private i biR;
    private boolean biS;
    private ClassLoader biT;
    private boolean biU;
    private final AtomicBoolean mHasInit;

    public static class a {
        private static final f biV = new f(0);

        static {
            eZBo();
        }

        private static /* synthetic */ void eZBo() {
            char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 135);
            }
            String str = new String(charArray);
            char[] charArray2 = "äëîéîó".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 135);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    private boolean Dv() {
        boolean CT = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT();
        if (!this.biU || CT) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dv();
        }
        return false;
    }

    private static boolean Dw() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dw();
    }

    public static f UK() {
        return a.biV;
    }

    private boolean UM() {
        Context Re = ServiceProvider.Re();
        if (m.ez(Re)) {
            this.auh = Re.getResources();
            return true;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
        return false;
    }

    private boolean UN() {
        boolean z;
        Object a2;
        try {
            Context Re = ServiceProvider.Re();
            if (!m.ez(Re)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
                return false;
            }
            Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
            Resources resources = null;
            Object invoke = cls.getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (a2 = z.a(field, invoke)) != null) {
                    for (Field field2 : a2.getClass().getDeclaredFields()) {
                        z = false;
                        if (field2.getType() == Resources.class) {
                            try {
                                field2.setAccessible(true);
                                String x = com.kwad.sdk.o.a.x(Re, u.bg(Re));
                                if (TextUtils.isEmpty(x)) {
                                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "find dynamicFile failed");
                                } else {
                                    resources = com.kwad.library.b.b.b.a(Re, Re.getResources(), x);
                                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "use merge res ");
                                }
                                if (resources == null) {
                                    resources = (Resources) field2.get(a2);
                                }
                                Resources resources2 = Re.getResources();
                                i iVar = new i(resources, resources2);
                                z.a(field2, a2, iVar);
                                this.auh = resources2;
                                this.biQ = resources;
                                this.biR = iVar;
                                return true;
                            } catch (Throwable th) {
                                th = th;
                                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                                return z;
                            }
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public final boolean Tn() {
        return this.mHasInit.get();
    }

    public final boolean UL() {
        return this.biU;
    }

    public final ClassLoader getClassLoader() {
        return this.biT;
    }

    public final Resources getResources() {
        boolean CT = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT();
        com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "getResources mIsInnerDexMode: " + this.biU + ", mHostResources: " + this.auh + ", isExternal: " + CT);
        return (!this.biU || CT) ? this.biR : this.auh;
    }

    public final void init() {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT()) {
                if (Dv() && UN()) {
                    this.biT = getClass().getClassLoader();
                    j.cx(Dw());
                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", toString());
                    this.biS = true;
                } else {
                    this.biS = false;
                }
            } else if (this.biU) {
                j.cx(true);
                UM();
                this.biT = getClass().getClassLoader();
                this.biS = true;
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.mHasInit.set(true);
    }

    public String toString() {
        return "KSPlugin{mHostResources=" + this.auh + ", mResResources=" + this.biQ + ", mPluginResources=" + this.biR + ", mEnable=" + this.biS + '}';
    }

    private f() {
        this.mHasInit = new AtomicBoolean(false);
        this.biU = com.kwad.framework.a.a.apj.booleanValue();
    }
}
