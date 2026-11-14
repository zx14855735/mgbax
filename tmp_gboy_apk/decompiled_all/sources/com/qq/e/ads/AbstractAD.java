package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class AbstractAD<T> {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final AtomicBoolean f12727B2KMhB = new AtomicBoolean(true);

    /* renamed from: AzWtSf, reason: collision with root package name */
    public volatile boolean f12731AzWtSf;

    /* renamed from: a, reason: collision with root package name */
    protected T f12733a;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public volatile boolean f12729AlLFFp = false;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public volatile boolean f12730AmA8tU = false;

    /* renamed from: B25kr6, reason: collision with root package name */
    public volatile long f12732B25kr6 = -1;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Handler f12728AcNBzu = new Handler(Looper.getMainLooper());

    static {
        dPdHxp();
    }

    private static /* synthetic */ void dPdHxp() {
        char[] charArray = "\u000f\u0003\u0001B\u000b\r\u0001\tB\u000e\u0003\u0015B\u001f\u0004\t\u0000\u0000B&\u0002\u0005.\u001e\u0005\b\u000b\t".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'l');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000f\u0000\u0005\u0002\u0005\u0018".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'l');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(final Context context, final String str, final String str2) {
        this.f12731AzWtSf = true;
        if (!a.b().d()) {
            a(2003);
            return;
        }
        final String a2 = a.b().a();
        if (com.qq.e.comm.a.a(context)) {
            this.f12730AmA8tU = true;
            a.g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = a.b().c().getPOFactory();
                        AbstractAD.this.f12728AcNBzu.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 == null) {
                                        AbstractAD.this.f12729AlLFFp = true;
                                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    AbstractAD abstractAD = AbstractAD.this;
                                    abstractAD.f12733a = (T) abstractAD.a(context, pOFactory2, a2, str, str2);
                                    AbstractAD.this.f12729AlLFFp = true;
                                    AbstractAD abstractAD2 = AbstractAD.this;
                                    if (abstractAD2.f12733a == null) {
                                        abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                        return;
                                    }
                                    if (abstractAD2.f12732B25kr6 > 0) {
                                        try {
                                            GlobalSetting.getSettings().putOpt("gdtwict", Long.valueOf(SystemClock.elapsedRealtime() - abstractAD2.f12732B25kr6));
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    AbstractAD abstractAD3 = AbstractAD.this;
                                    abstractAD3.a((AbstractAD) abstractAD3.f12733a);
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                    AbstractAD.this.f12729AlLFFp = true;
                                    AbstractAD.this.a(2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                        AbstractAD.this.f12729AlLFFp = true;
                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                    }
                }
            });
        } else {
            GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            a(4002);
        }
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            A2egSU(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    public abstract void a(T t);

    public abstract void b(int i);

    public final boolean b() {
        if (!this.f12729AlLFFp && f12727B2KMhB.compareAndSet(true, false)) {
            this.f12732B25kr6 = SystemClock.elapsedRealtime();
        }
        return this.f12729AlLFFp;
    }

    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            A2egSU(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    public final void a(final int i) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i);
        } else {
            this.f12728AcNBzu.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i);
                }
            });
        }
    }

    public final boolean a() {
        return this.f12731AzWtSf && this.f12730AmA8tU;
    }

    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }
}
