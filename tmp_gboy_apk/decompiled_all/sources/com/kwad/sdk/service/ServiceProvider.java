package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.a.e;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ServiceProvider {
    private static List<Throwable> OD;

    @SuppressLint({"StaticFieldLeak"})
    private static Context bdj;

    @SuppressLint({"StaticFieldLeak"})
    private static Context bdk;
    private static boolean bdl;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    public enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        static {
            RsFOFu();
        }

        ServiceProviderDelegate() {
        }

        private static /* synthetic */ void RsFOFu() {
            char[] charArray = "\u0013\u001f\u001d^\u0017\u0011\u001d\u0015^\u0012\u001f\t^\u0003\u0018\u0015\u001c\u001c^:\u001e\u00192\u0002\u0019\u0014\u0017\u0015".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'p');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0013\u001c\u0019\u001e\u0019\u0004".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'p');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }

    public static void Rd() {
        bdl = true;
    }

    @Deprecated
    public static Context Re() {
        return mContext;
    }

    private static void b(Throwable th) {
        if (OD == null) {
            OD = new CopyOnWriteArrayList();
        }
        OD.add(th);
    }

    public static void cx(Context context) {
        bdj = context;
        mContext = m.eA(context);
    }

    public static void f(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = OD;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        OD.clear();
        OD = null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static String getAppId() {
        return b.getAppId();
    }

    public static String getAppName() {
        return b.getAppName();
    }

    public static Context getContext() {
        if (bdl) {
            return Re();
        }
        if (bdk == null) {
            bdk = m.wrapContextIfNeed(mContext);
        }
        return bdk;
    }

    public static SdkConfig getSDKConfig() {
        return b.getSDKConfig();
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }
}
