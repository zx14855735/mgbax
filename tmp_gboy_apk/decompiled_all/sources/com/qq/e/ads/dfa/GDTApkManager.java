package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class GDTApkManager {

    /* renamed from: A2egSU, reason: collision with root package name */
    public DFA f12776A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final boolean f12777A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f12778A5SV6n = false;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final AtomicInteger f12779ADYaiT = new AtomicInteger(0);
    public final Context AMqCpz;

    public GDTApkManager(Context context, final IGDTApkListener iGDTApkListener) {
        this.f12777A4TApA = false;
        if (a.b().d()) {
            if (TextUtils.isEmpty(a.b().a()) || context == null) {
                GDTLogger.e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
            } else {
                if (!com.qq.e.comm.a.a(context)) {
                    GDTLogger.e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
                    return;
                }
                this.f12777A4TApA = true;
                this.AMqCpz = context;
                a.g.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = a.b().c().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    try {
                                        if (pOFactory != null) {
                                            GDTApkManager.this.f12776A2egSU = a.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                            GDTApkManager.this.f12778A5SV6n = true;
                                            while (GDTApkManager.this.f12779ADYaiT.getAndDecrement() > 0) {
                                                GDTApkManager.this.loadGDTApk();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            GDTLogger.e("初始化错误：初始化时发生异常", th);
                                        } finally {
                                            GDTApkManager.this.f12778A5SV6n = true;
                                        }
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.e("初始化错误：初始化时发生异常", th);
                        }
                    }
                });
            }
        }
    }

    public final void loadGDTApk() {
        if (this.f12777A4TApA) {
            if (!this.f12778A5SV6n) {
                this.f12779ADYaiT.incrementAndGet();
                return;
            }
            DFA dfa = this.f12776A2egSU;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.f12776A2egSU;
        if (dfa != null) {
            dfa.startInstall(this.AMqCpz, gDTApk);
        }
    }
}
