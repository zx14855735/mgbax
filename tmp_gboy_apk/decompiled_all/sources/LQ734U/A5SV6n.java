package LQ734U;

import HIguqb.AaHO0E;
import HIguqb.AlLFFp;
import android.os.RemoteException;
import android.util.SparseIntArray;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends A2egSU {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final int[] f4827B25kr6 = {21, 32, 22, 16, 19, 64, 20, r.b.d, AdEventType.AD_RENDER_SUCCESS, 4, 108, 8, 96, 2, 97, 1, 99, ProxyCacheUtils.DEFAULT_BUFFER_SIZE, 100, f.a.c, 102, 512, 103, 256, 104, 512, 105, 256};

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final HIguqb.ADYaiT f4828AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public SparseIntArray f4829AzWtSf;

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e A[Catch: Exception -> 0x0068, TryCatch #0 {Exception -> 0x0068, blocks: (B:3:0x000a, B:6:0x002d, B:8:0x0043, B:11:0x004a, B:13:0x005e, B:14:0x006a, B:15:0x0071), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: Exception -> 0x0068, TryCatch #0 {Exception -> 0x0068, blocks: (B:3:0x000a, B:6:0x002d, B:8:0x0043, B:11:0x004a, B:13:0x005e, B:14:0x006a, B:15:0x0071), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public A5SV6n(com.game.boy.activity.EmulatorActivity r9) {
        /*
            r8 = this;
            r8.<init>()
            HIguqb.ADYaiT r0 = new HIguqb.ADYaiT
            r0.<init>(r9)
            r8.f4828AmA8tU = r0
            java.lang.Class<HIguqb.ADYaiT> r1 = HIguqb.ADYaiT.class
            java.lang.String r2 = "mIsBound"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch: java.lang.Exception -> L68
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.Exception -> L68
            boolean r4 = r2.getBoolean(r0)     // Catch: java.lang.Exception -> L68
            java.lang.String r5 = "mServiceConnection"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r5)     // Catch: java.lang.Exception -> L68
            r1.setAccessible(r3)     // Catch: java.lang.Exception -> L68
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Exception -> L68
            android.content.ServiceConnection r1 = (android.content.ServiceConnection) r1     // Catch: java.lang.Exception -> L68
            if (r4 != 0) goto L72
            if (r1 == 0) goto L72
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Exception -> L68
            java.lang.Class<HIguqb.AlLFFp> r5 = HIguqb.AlLFFp.class
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Exception -> L68
            r4.<init>(r5)     // Catch: java.lang.Exception -> L68
            android.content.pm.PackageManager r5 = r9.getPackageManager()     // Catch: java.lang.Exception -> L68
            r6 = 0
            java.util.List r5 = r5.queryIntentServices(r4, r6)     // Catch: java.lang.Exception -> L68
            if (r5 == 0) goto L5b
            int r7 = r5.size()     // Catch: java.lang.Exception -> L68
            if (r7 == r3) goto L4a
            goto L5b
        L4a:
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> L68
            android.content.pm.ResolveInfo r5 = (android.content.pm.ResolveInfo) r5     // Catch: java.lang.Exception -> L68
            android.content.pm.ServiceInfo r5 = r5.serviceInfo     // Catch: java.lang.Exception -> L68
            java.lang.String r6 = r5.packageName     // Catch: java.lang.Exception -> L68
            java.lang.String r5 = r5.name     // Catch: java.lang.Exception -> L68
            android.content.Intent r4 = r4.setClassName(r6, r5)     // Catch: java.lang.Exception -> L68
            goto L5c
        L5b:
            r4 = 0
        L5c:
            if (r4 == 0) goto L6a
            r9.startService(r4)     // Catch: java.lang.Exception -> L68
            r9.bindService(r4, r1, r3)     // Catch: java.lang.Exception -> L68
            r2.setBoolean(r0, r3)     // Catch: java.lang.Exception -> L68
            goto L72
        L68:
            r9 = move-exception
            goto L7b
        L6a:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L68
            java.lang.String r0 = "MOGA pivot app is not installed."
            r9.<init>(r0)     // Catch: java.lang.Exception -> L68
            throw r9     // Catch: java.lang.Exception -> L68
        L72:
            android.os.Handler r9 = new android.os.Handler
            r9.<init>()
            r0.A5SV6n(r8, r9)
            return
        L7b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: LQ734U.A5SV6n.<init>(com.game.boy.activity.EmulatorActivity):void");
    }

    @Override // LQ734U.A2egSU
    public final void A5SV6n() {
        HIguqb.ADYaiT aDYaiT = this.f4828AmA8tU;
        aDYaiT.A5SV6n(null, null);
        AlLFFp alLFFp = aDYaiT.f3368AYUAbz;
        if (alLFFp != null) {
            try {
                ((AaHO0E) alLFFp).AcNBzu(aDYaiT.f3367ASJ6gh, aDYaiT.f3362A2egSU);
            } catch (RemoteException unused) {
            }
        }
        if (aDYaiT.f3365ADYaiT) {
            aDYaiT.f3363A4TApA.unbindService(aDYaiT.f3369AZOQYO);
            aDYaiT.f3365ADYaiT = false;
        }
    }

    @Override // LQ734U.A2egSU
    public final void ADYaiT() {
        HIguqb.ADYaiT aDYaiT = this.f4828AmA8tU;
        aDYaiT.f3362A2egSU = 5;
        aDYaiT.A4TApA(5);
        aDYaiT.A2egSU();
    }

    @Override // LQ734U.A2egSU
    public final void AMqCpz() {
        HIguqb.ADYaiT aDYaiT = this.f4828AmA8tU;
        aDYaiT.f3362A2egSU = 6;
        aDYaiT.A4TApA(6);
        aDYaiT.A2egSU();
    }
}
