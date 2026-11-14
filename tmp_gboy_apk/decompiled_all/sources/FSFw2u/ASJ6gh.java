package FSFw2u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2684AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ boolean f2685AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f2686AmA8tU;

    public /* synthetic */ ASJ6gh(boolean z, Object obj, int i) {
        this.f2684AcNBzu = i;
        this.f2686AmA8tU = obj;
        this.f2685AlLFFp = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0043, code lost:
    
        if (com.bumptech.glide.A5SV6n.DcUJf1().equals(r0.getPackageName()) == false) goto L13;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r6 = this;
            int r0 = r6.f2684AcNBzu
            switch(r0) {
                case 0: goto L95;
                case 1: goto L8b;
                default: goto L5;
            }
        L5:
            K1Z3yj.A2egSU r0 = K1Z3yj.A2egSU.B9tovu()
            java.lang.Object r1 = r6.f2686AmA8tU
            android.content.Context r1 = (android.content.Context) r1
            r0.getClass()
            r2 = 1
            GnQT2j.A2egSU r3 = new GnQT2j.A2egSU     // Catch: java.lang.Throwable -> L25
            com.bytedance.sdk.openadsdk.api.plugin.xj r4 = new com.bytedance.sdk.openadsdk.api.plugin.xj     // Catch: java.lang.Throwable -> L25
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L25
            java.lang.String r1 = "npth_log.db"
            r5 = 0
            r3.<init>(r4, r1, r5, r2)     // Catch: java.lang.Throwable -> L25
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L25
            r0.f4175AmA8tU = r1     // Catch: java.lang.Throwable -> L25
            goto L28
        L25:
            com.bumptech.glide.AMqCpz.C2rE4F()
        L28:
            K1qm5H.A2egSU r1 = new K1qm5H.A2egSU
            r1.<init>()
            r0.f4174AlLFFp = r1
            java.lang.Object r0 = r6.f2686AmA8tU
            android.content.Context r0 = (android.content.Context) r0
            ADYaiT.DUi7mC r1 = JrXYwF.A5SV6n.f4151A5SV6n     // Catch: java.lang.Exception -> L46
            java.lang.Object r1 = r1.f239AlLFFp     // Catch: java.lang.Exception -> L46
            java.lang.String r1 = com.bumptech.glide.A5SV6n.DcUJf1()     // Catch: java.lang.Exception -> L46
            java.lang.String r3 = r0.getPackageName()     // Catch: java.lang.Exception -> L46
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L46
            if (r1 != 0) goto L46
            goto L56
        L46:
            android.os.Handler r1 = K7mCWO.A2egSU.A2egSU()
            JtTqUo.A4TApA r3 = new JtTqUo.A4TApA
            r3.<init>()
            r3.f4167AlLFFp = r0
            r0 = 0
            long r4 = (long) r0
            r1.postDelayed(r3, r4)
        L56:
            boolean r0 = r6.f2685AlLFFp
            if (r0 == 0) goto L8a
            java.lang.Object r0 = r6.f2686AmA8tU
            android.content.Context r0 = (android.content.Context) r0
            KCxDWD.A5SV6n r1 = KCxDWD.A5SV6n.f4239AmA8tU
            if (r1 != 0) goto L78
            java.lang.Class<KCxDWD.A5SV6n> r1 = KCxDWD.A5SV6n.class
            monitor-enter(r1)
            KCxDWD.A5SV6n r3 = KCxDWD.A5SV6n.f4239AmA8tU     // Catch: java.lang.Throwable -> L72
            if (r3 != 0) goto L74
            KCxDWD.A5SV6n r3 = new KCxDWD.A5SV6n     // Catch: java.lang.Throwable -> L72
            r4 = 0
            r3.<init>(r0, r4)     // Catch: java.lang.Throwable -> L72
            KCxDWD.A5SV6n.f4239AmA8tU = r3     // Catch: java.lang.Throwable -> L72
            goto L74
        L72:
            r0 = move-exception
            goto L76
        L74:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L72
            goto L78
        L76:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L72
            throw r0
        L78:
            KCxDWD.A5SV6n r0 = KCxDWD.A5SV6n.f4239AmA8tU
            java.lang.Object r0 = r0.f4241AlLFFp
            KCxDWD.A4TApA r0 = (KCxDWD.A4TApA) r0
            boolean r1 = r0.f4237A5SV6n
            if (r1 == 0) goto L83
            goto L8a
        L83:
            KCxDWD.A2egSU r1 = new KCxDWD.A2egSU
            r1.<init>(r0)
            r0.f4237A5SV6n = r2
        L8a:
            return
        L8b:
            java.lang.Object r0 = r6.f2686AmA8tU
            FSFw2u.AZkASS r0 = (FSFw2u.AZkASS) r0
            boolean r1 = r6.f2685AlLFFp
            r0.EGM26s(r1)
            return
        L95:
            java.lang.Object r0 = r6.f2686AmA8tU
            FSFw2u.AZkASS r0 = (FSFw2u.AZkASS) r0
            boolean r1 = r6.f2685AlLFFp
            r0.EGM26s(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: FSFw2u.ASJ6gh.run():void");
    }
}
