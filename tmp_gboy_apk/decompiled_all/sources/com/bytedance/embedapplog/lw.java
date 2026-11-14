package com.bytedance.embedapplog;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class lw extends n {
    private final Context kd;
    private final wn y;

    public lw(Context context, wn wnVar) {
        super(false, false);
        this.kd = context;
        this.y = wnVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v11 java.lang.String, still in use, count: 2, list:
          (r1v11 java.lang.String) from 0x0020: INVOKE (r1v11 java.lang.String) STATIC call: android.text.TextUtils.isEmpty(java.lang.CharSequence):boolean A[Catch: Exception -> 0x0018, MD:(java.lang.CharSequence):boolean (c), TRY_LEAVE, WRAPPED] (LINE:33)
          (r1v11 java.lang.String) from 0x002d: PHI (r1v2 java.lang.String) = (r1v1 java.lang.String), (r1v11 java.lang.String), (r1v14 java.lang.String) binds: [B:40:0x002c, B:39:0x0024, B:7:0x000b] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:125)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x002c -> B:8:0x002d). Please report as a decompilation issue!!! */
    @Override // com.bytedance.embedapplog.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean xj(org.json.JSONObject r9) {
        /*
            r8 = this;
            r0 = 0
            com.bytedance.embedapplog.wn r1 = r8.y     // Catch: java.lang.Exception -> L18
            if (r1 == 0) goto L2c
            boolean r1 = r1.n()     // Catch: java.lang.Exception -> L18
            if (r1 == 0) goto L1a
            android.content.Context r1 = r8.kd     // Catch: java.lang.Exception -> L18
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L18
            java.lang.String r2 = "android_id"
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r2)     // Catch: java.lang.Exception -> L18
            goto L2d
        L18:
            r1 = move-exception
            goto L27
        L1a:
            com.bytedance.embedapplog.wn r1 = r8.y     // Catch: java.lang.Exception -> L18
            java.lang.String r1 = r1.yy()     // Catch: java.lang.Exception -> L18
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L18
            if (r2 != 0) goto L2c
            goto L2d
        L27:
            java.lang.String r2 = ""
            com.bytedance.embedapplog.cu.w(r2, r1)
        L2c:
            r1 = r0
        L2d:
            boolean r2 = com.bytedance.embedapplog.aq.xj(r1)
            r3 = 1
            java.lang.String r4 = "openudid"
            if (r2 == 0) goto L3e
            java.lang.String r2 = "9774d56d682e549c"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto Lb4
        L3e:
            android.content.Context r1 = r8.kd
            java.lang.String r2 = "snssdk_openudid"
            r5 = 0
            android.content.SharedPreferences r1 = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(r1, r2, r5)
            java.lang.String r2 = "custom_b"
            java.lang.String r6 = r1.getString(r2, r0)
            java.lang.String r6 = com.bytedance.embedapplog.vm.hf(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L5c
            java.lang.String r0 = r1.getString(r4, r0)
            goto L5d
        L5c:
            r0 = r6
        L5d:
            boolean r6 = com.bytedance.embedapplog.aq.xj(r0)
            if (r6 != 0) goto Lb3
            java.security.SecureRandom r0 = new java.security.SecureRandom
            r0.<init>()
            java.math.BigInteger r6 = new java.math.BigInteger
            r7 = 64
            r6.<init>(r7, r0)
            r0 = 16
            java.lang.String r0 = r6.toString(r0)
            char r5 = r0.charAt(r5)
            r6 = 45
            if (r5 != r6) goto L81
            java.lang.String r0 = r0.substring(r3)
        L81:
            int r5 = r0.length()
            int r5 = 13 - r5
            if (r5 <= 0) goto L9f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
        L8e:
            if (r5 <= 0) goto L98
            r7 = 70
            r6.append(r7)
            int r5 = r5 + (-1)
            goto L8e
        L98:
            r6.append(r0)
            java.lang.String r0 = r6.toString()
        L9f:
            java.lang.String r5 = "openudid.dat"
            java.lang.String r0 = r8.xj(r5, r0)     // Catch: java.lang.Exception -> La5
        La5:
            java.lang.String r5 = com.bytedance.embedapplog.vm.xj(r0)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.putString(r2, r5)
            r1.apply()
        Lb3:
            r1 = r0
        Lb4:
            r9.put(r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.lw.xj(org.json.JSONObject):boolean");
    }
}
