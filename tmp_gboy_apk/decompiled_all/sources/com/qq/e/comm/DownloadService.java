package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadService extends Service {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public SVSD f12890AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f12891AlLFFp = false;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final LinkedList f12892AmA8tU = new LinkedList();

    class a implements Runnable {

        /* renamed from: AcNBzu, reason: collision with root package name */
        public final /* synthetic */ com.qq.e.comm.managers.a f12893AcNBzu;

        /* renamed from: com.qq.e.comm.DownloadService$a$a, reason: collision with other inner class name */
        public class RunnableC0445a implements Runnable {

            /* renamed from: AcNBzu, reason: collision with root package name */
            public final /* synthetic */ SVSD f12895AcNBzu;

            public RunnableC0445a(SVSD svsd) {
                this.f12895AcNBzu = svsd;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                SVSD svsd = this.f12895AcNBzu;
                try {
                    svsd.onCreate();
                    while (true) {
                        b bVar = (b) DownloadService.this.f12892AmA8tU.poll();
                        if (bVar == null) {
                            DownloadService.this.f12890AcNBzu = svsd;
                            return;
                        }
                        svsd.onStartCommand(bVar.f12897A2egSU, bVar.f12898A4TApA, bVar.f12899A5SV6n);
                    }
                } catch (Throwable th) {
                    GDTLogger.w("DownloadService初始化异常", th);
                }
            }
        }

        public a(com.qq.e.comm.managers.a aVar) {
            this.f12893AcNBzu = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SVSD aPKDownloadServiceDelegate = this.f12893AcNBzu.c().getPOFactory().getAPKDownloadServiceDelegate(DownloadService.this);
                if (aPKDownloadServiceDelegate == null) {
                    GDTLogger.w("DownloadService初始化异常");
                } else {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0445a(aPKDownloadServiceDelegate));
                }
            } catch (Throwable th) {
                GDTLogger.w("DownloadService初始化异常", th);
            }
        }
    }

    public static class b {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final Intent f12897A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public final int f12898A4TApA;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public final int f12899A5SV6n;

        public b(int i, int i2, Intent intent) {
            this.f12897A2egSU = intent;
            this.f12898A4TApA = i;
            this.f12899A5SV6n = i2;
        }
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("GDT_APPID", com.qq.e.comm.managers.a.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    public final boolean A2egSU(boolean z) {
        if (this.f12890AcNBzu != null) {
            return true;
        }
        com.qq.e.comm.managers.a b2 = com.qq.e.comm.managers.a.b();
        if (b2.d()) {
            if (z) {
                try {
                    SVSD aPKDownloadServiceDelegate = b2.c().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f12890AcNBzu = aPKDownloadServiceDelegate;
                    aPKDownloadServiceDelegate.onCreate();
                    return true;
                } catch (Throwable th) {
                    GDTLogger.w("DownloadService初始化异常", th);
                    return false;
                }
            }
            if (!this.f12891AlLFFp) {
                this.f12891AlLFFp = true;
                com.qq.e.comm.managers.a.g.submit(new a(b2));
                return false;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        SVSD svsd = this.f12890AcNBzu;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID")) || !A2egSU(true)) {
            return null;
        }
        return this.f12890AcNBzu.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f12890AcNBzu;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.f12890AcNBzu;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f12890AcNBzu;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f12890AcNBzu;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID"))) {
            GDTLogger.w("Service onStartCommand 出现异常");
            return 2;
        }
        if (A2egSU(false)) {
            return this.f12890AcNBzu.onStartCommand(intent, i, i2);
        }
        this.f12892AmA8tU.add(new b(i, i2, intent));
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f12890AcNBzu;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        SVSD svsd = this.f12890AcNBzu;
        if (svsd != null) {
            svsd.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f12890AcNBzu;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
