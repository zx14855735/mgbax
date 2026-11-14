package ADYaiT;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class B4ZgIw implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f87AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Context f88AlLFFp;

    public /* synthetic */ B4ZgIw(Context context, int i) {
        this.f87AcNBzu = i;
        this.f88AlLFFp = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.f87AcNBzu
            switch(r0) {
                case 0: goto L35;
                case 1: goto L19;
                case 2: goto Lb;
                default: goto L5;
            }
        L5:
            android.content.Context r0 = r11.f88AlLFFp
            com.sigmob.sdk.base.services.b.A4TApA(r0)
            return
        Lb:
            DUi7mC.ADYaiT r0 = new DUi7mC.ADYaiT
            r0.<init>()
            ADYaiT.BmvVmW r1 = DUi7mC.ARc23Z.f2171A2egSU
            r2 = 0
            android.content.Context r3 = r11.f88AlLFFp
            DUi7mC.ARc23Z.B4ZgIw(r3, r0, r1, r2)
            return
        L19:
            java.util.concurrent.ThreadPoolExecutor r4 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r6 = 1
            r7 = 0
            r5 = 0
            r4.<init>(r5, r6, r7, r9, r10)
            ADYaiT.B4ZgIw r0 = new ADYaiT.B4ZgIw
            android.content.Context r1 = r11.f88AlLFFp
            r2 = 2
            r0.<init>(r1, r2)
            r4.execute(r0)
            return
        L35:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 33
            if (r0 < r2) goto Lb5
            android.content.ComponentName r3 = new android.content.ComponentName
            android.content.Context r4 = r11.f88AlLFFp
            java.lang.String r5 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            r3.<init>(r4, r5)
            android.content.pm.PackageManager r5 = r4.getPackageManager()
            int r5 = r5.getComponentEnabledSetting(r3)
            if (r5 == r1) goto Lb5
            java.lang.String r5 = "locale"
            if (r0 < r2) goto L8e
            B25kr6.AMqCpz r0 = ADYaiT.BJ7GGh.f103B3GDIM
            r0.getClass()
            B25kr6.A2egSU r2 = new B25kr6.A2egSU
            r2.<init>(r0)
        L5d:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L7c
            java.lang.Object r0 = r2.next()
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
            ADYaiT.BJ7GGh r0 = (ADYaiT.BJ7GGh) r0
            if (r0 == 0) goto L5d
            ADYaiT.CkXcdM r0 = (ADYaiT.CkXcdM) r0
            android.content.Context r0 = r0.f157BChYOn
            if (r0 == 0) goto L5d
            java.lang.Object r0 = r0.getSystemService(r5)
            goto L7d
        L7c:
            r0 = 0
        L7d:
            if (r0 == 0) goto L93
            android.os.LocaleList r0 = ADYaiT.B9tovu.A2egSU(r0)
            C2rE4F.AYUAbz r2 = new C2rE4F.AYUAbz
            C2rE4F.AaHO0E r6 = new C2rE4F.AaHO0E
            r6.<init>(r0)
            r2.<init>(r6)
            goto L95
        L8e:
            C2rE4F.AYUAbz r2 = ADYaiT.BJ7GGh.f99AmA8tU
            if (r2 == 0) goto L93
            goto L95
        L93:
            C2rE4F.AYUAbz r2 = C2rE4F.AYUAbz.f1537A4TApA
        L95:
            C2rE4F.AZkASS r0 = r2.f1538A2egSU
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lae
            java.lang.String r0 = androidx.core.app.AaHO0E.AMqCpz(r4)
            java.lang.Object r2 = r4.getSystemService(r5)
            if (r2 == 0) goto Lae
            android.os.LocaleList r0 = ADYaiT.B7CMnp.A2egSU(r0)
            ADYaiT.B9tovu.A4TApA(r2, r0)
        Lae:
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            r0.setComponentEnabledSetting(r3, r1, r1)
        Lb5:
            ADYaiT.BJ7GGh.f102B2KMhB = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.B4ZgIw.run():void");
    }
}
