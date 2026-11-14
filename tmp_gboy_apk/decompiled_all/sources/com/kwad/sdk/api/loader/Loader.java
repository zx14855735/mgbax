package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private IKsAdSDK ayN;
    private m ayO;
    private final AtomicBoolean mHasInit;

    public static class a {
        private static final Loader ayP = new Loader(0);

        static {
            aCWOOu();
        }

        private static /* synthetic */ void aCWOOu() {
            char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'N');
            }
            String str = new String(charArray);
            char[] charArray2 = "-\"' ':".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'N');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ Loader(byte b) {
        this();
    }

    private static void B(Context context, String str) {
        j.A(context, str);
    }

    private static void Fc() {
        try {
            int ER = com.kwad.sdk.api.c.ER();
            if (ER > 0) {
                try {
                    f.bf(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(f.bf(mContext));
                    f.bf(mContext).cH(ER);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                Object invoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
                if (invoke == null) {
                    throw new RuntimeException("Can not get sdk form " + classLoader);
                }
                iKsAdSDK = (IKsAdSDK) invoke;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return iKsAdSDK;
    }

    private boolean bl(Context context) {
        try {
            String bg = i.bg(context);
            String bh = i.bh(context);
            if (TextUtils.isEmpty(bg) && TextUtils.isEmpty(bh)) {
                return false;
            }
            if (!TextUtils.isEmpty(bh) && i.L(bh, bg)) {
                i.r(context, bh);
                B(context, bg);
                i.s(context, "");
                bg = bh;
            }
            return !TextUtils.isEmpty(bg);
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
            return false;
        }
    }

    private static void bm(Context context) {
        try {
            String bi = i.bi(context);
            boolean b = b.b(context, i.ays, false);
            if (!TextUtils.isEmpty(bi) && bi.equals(BuildConfig.VERSION_NAME) && !b) {
                return;
            }
            String bg = i.bg(context);
            i.r(context, "");
            i.s(context, "");
            b.a(context, i.ays, false);
            j.j(j.w(context, bg));
            i.t(context, BuildConfig.VERSION_NAME);
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
        }
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get()) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        if (context == null) {
            context = c.EX();
        }
        KsAdSDK.init(context, SdkConfig.create(b.getString(context, "sdkconfig")));
    }

    public static Loader get() {
        return a.ayP;
    }

    public Context getContext() {
        return mContext;
    }

    public ClassLoader getExternalClassLoader() {
        m mVar = this.ayO;
        ClassLoader classLoader = mVar != null ? mVar.getClassLoader() : null;
        if (com.kwad.sdk.api.a.axM.booleanValue()) {
            classLoader = this.ayN.getClass().getClassLoader();
            Objects.toString(classLoader);
        }
        Objects.toString(classLoader);
        return classLoader;
    }

    public Resources getExternalResource() {
        m mVar = this.ayO;
        if (mVar != null) {
            return mVar.EY();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        m mVar = this.ayO;
        return mVar != null ? mVar.getClassLoader() : getClass().getClassLoader();
    }

    public IKsAdSDK init(Context context, ClassLoader classLoader) {
        if (this.mHasInit.get()) {
            return this.ayN;
        }
        mContext = context.getApplicationContext();
        bm(context);
        if (bl(context)) {
            this.ayO = m.a(context, classLoader, i.bg(context));
        }
        boolean booleanValue = com.kwad.sdk.api.a.axM.booleanValue();
        m mVar = this.ayO;
        if (mVar == null && booleanValue) {
            ClassLoader initDex = DexLoader.initDex(context, classLoader);
            if (initDex == null) {
                return null;
            }
            initDex.toString();
            IKsAdSDK a2 = a(initDex);
            this.ayN = a2;
            Objects.toString(a2);
        } else if (mVar == null) {
            IKsAdSDK a3 = a(getClass().getClassLoader());
            this.ayN = a3;
            a3.setIsExternal(false);
        } else {
            IKsAdSDK EZ = mVar.EZ();
            this.ayN = EZ;
            EZ.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.ayN);
        if (this.ayO != null) {
            Fc();
        }
        this.mHasInit.set(true);
        return this.ayN;
    }

    public boolean isExternalLoaded() {
        return this.ayO != null;
    }

    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.ayN.newComponentProxy(cls, obj);
    }

    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.ayN.newInstance(cls);
    }

    public void rest() {
        this.mHasInit.set(false);
        mContext = null;
        this.ayN = null;
        this.ayO = null;
    }

    private Loader() {
        this.ayO = null;
        this.mHasInit = new AtomicBoolean(false);
    }
}
