package com.sigmob.sdk.base.services;

import ADYaiT.B4ZgIw;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.v;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.services.f;
import com.sigmob.sdk.base.utils.s;
import java.util.Date;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements f.a {
    private static final String c = "BuriedPointConfig";

    /* renamed from: a, reason: collision with root package name */
    a f13208a;
    g b = g.STOP;

    public b() {
        if (this.f13208a == null) {
            this.f13208a = new a();
        }
    }

    public static void b() {
        try {
            j();
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        s.b(com.sigmob.sdk.b.e(), c, n.c, Constants.sdf.format(new Date()));
    }

    private static List<PackageInfo> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return AppPackageUtil.getPackageManager(context).getInstalledPackages(0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Context context) {
        try {
            List<PackageInfo> d = d(context);
            if (com.sigmob.sdk.base.utils.e.a(d)) {
                return;
            }
            for (int i = 0; i < d.size(); i++) {
                PackageInfo packageInfo = d.get(i);
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    ae.a(packageInfo, 0);
                }
            }
            s.b(context, c, n.b, Constants.sdf.format(new Date()));
        } catch (Throwable th) {
            SigmobLog.e("update app info", th);
        }
    }

    private static void i() {
        Context e = com.sigmob.sdk.b.e();
        if (c(e)) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new B4ZgIw(e, 3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
    
        if (r1 == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void j() {
        /*
            com.sigmob.sdk.base.i r0 = com.sigmob.sdk.base.i.a()     // Catch: java.lang.Throwable -> L45
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L4b
            com.sigmob.windad.WindAds r0 = com.sigmob.windad.WindAds.sharedAds()     // Catch: java.lang.Throwable -> L45
            com.sigmob.windad.WindAdOptions r0 = r0.getOptions()     // Catch: java.lang.Throwable -> L45
            com.sigmob.sdk.base.o r1 = com.sigmob.sdk.base.o.a()     // Catch: java.lang.Throwable -> L45
            int r2 = r1.ae()     // Catch: java.lang.Throwable -> L45
            boolean r3 = r1.j()     // Catch: java.lang.Throwable -> L45
            boolean r1 = r1.T()     // Catch: java.lang.Throwable -> L45
            r4 = 0
            if (r3 == 0) goto L26
            goto L3f
        L26:
            r3 = 1
            if (r2 == r3) goto L3e
            r5 = 2
            if (r2 == r5) goto L3f
            if (r0 == 0) goto L39
            com.sigmob.windad.WindCustomController r0 = r0.getCustomController()     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L39
            boolean r0 = r0.isCanUseAppList()     // Catch: java.lang.Throwable -> L45
            goto L3a
        L39:
            r0 = 1
        L3a:
            if (r0 == 0) goto L3f
            if (r1 != 0) goto L3f
        L3e:
            r4 = 1
        L3f:
            if (r4 == 0) goto L4b
            i()     // Catch: java.lang.Throwable -> L45
            return
        L45:
            r0 = move-exception
            java.lang.String r1 = "BuriedPointManager getInstance"
            com.czhj.sdk.logger.SigmobLog.e(r1, r0)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.b.j():void");
    }

    public void a(Context context) {
        if (o.a().ad()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.K));
        if (Build.VERSION.SDK_INT >= 27) {
            intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.L));
        }
        intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.I));
        intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.H));
        intentFilter.addAction(com.sigmob.sdk.base.utils.b.a(n.J));
        intentFilter.addDataScheme("package");
        v.a(context, this.f13208a, intentFilter);
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public g f() {
        return this.b;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public void g() {
        if (this.b == g.RUNNING) {
            b(com.sigmob.sdk.b.e());
            this.b = g.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public Error h() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(o oVar, Context context) {
        int i;
        List<String> V = oVar.V();
        if (com.sigmob.sdk.base.utils.e.a(V)) {
            return;
        }
        for (String str : V) {
            boolean z = false;
            if (oVar.L()) {
                z = v.a(context, str);
            } else if (oVar.M()) {
                z = v.b(context, str);
                i = 1;
                ae.a(str, z, i);
            }
            i = 0;
            ae.a(str, z, i);
        }
        c();
    }

    @SuppressLint({"SimpleDateFormat"})
    private static boolean c(Context context) {
        return s.a(context, c, n.b, "").equals(Constants.sdf.format(new Date()));
    }

    public static void d() {
        Context e = com.sigmob.sdk.b.e();
        boolean i = i.a().i();
        if (e == null || !i) {
            return;
        }
        o a2 = o.a();
        if (a() || !a2.N().booleanValue()) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new A2egSU(a2, e));
    }

    public void b(Context context) {
        context.unregisterReceiver(this.f13208a);
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public boolean e() {
        g gVar = this.b;
        g gVar2 = g.RUNNING;
        if (gVar == gVar2) {
            return false;
        }
        a(com.sigmob.sdk.b.e());
        this.b = gVar2;
        return true;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static boolean a() {
        return s.a(com.sigmob.sdk.b.e(), c, n.c, "").equals(Constants.sdf.format(new Date()));
    }
}
