package com.bytedance.sdk.component.tf.xj;

import com.bytedance.sdk.component.tf.p;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements Comparable<w>, Runnable {
    private long f;
    private y u;
    public final Runnable w;
    public static final AtomicInteger xj = new AtomicInteger(0);
    public static boolean hf = false;
    private boolean kd = true;
    private boolean y = true;
    private final long c = System.currentTimeMillis();
    private int d = 0;
    private int tf = 0;

    static {
        fPCRX();
    }

    public w(Runnable runnable) {
        this.w = runnable;
    }

    private static /* synthetic */ void fPCRX() {
        char[] charArray = "ùõ÷´ýû÷ÿ´øõã´éòÿöö´ÐôóØèóþýÿ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 154);
        }
        String str = new String(charArray);
        char[] charArray2 = "ùöóôóî".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 154);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void w(boolean z) {
        y yVar = this.u;
        if (yVar != null) {
            yVar.xj(this, z);
        }
    }

    public void hf() {
        this.f = System.currentTimeMillis() - this.c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(13:3|4|5|6|7|(1:9)(1:40)|10|(1:14)|15|16|17|18|(1:36)(2:20|(2:26|(2:28|29)(4:(1:31)(1:35)|32|33|34))(1:24)))(1:45)|44|7|(0)(0)|10|(2:12|14)|15|16|17|18|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0081, code lost:
    
        r3 = new java.lang.Object[1];
        r3[r16] = r0;
        com.bytedance.sdk.component.utils.pl.hf("BizRunnable", r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r19 = this;
            r1 = r19
            r2 = 1
            r3 = 0
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            int r5 = r4.getPriority()
            java.lang.Runnable r0 = r1.w
            boolean r6 = r0 instanceof com.bytedance.sdk.component.tf.d
            java.lang.String r7 = "BizRunnable"
            if (r6 == 0) goto L32
            r6 = r0
            com.bytedance.sdk.component.tf.d r6 = (com.bytedance.sdk.component.tf.d) r6
            int r0 = r6.getPriority()
            r8 = 10
            int r0 = java.lang.Math.min(r0, r8)
            r4.setPriority(r0)     // Catch: java.lang.Throwable -> L27
            r8 = r6
            r6 = r0
            goto L34
        L27:
            r0 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r3] = r0
            com.bytedance.sdk.component.utils.pl.hf(r7, r8)
        L2f:
            r8 = r6
            r6 = r5
            goto L34
        L32:
            r6 = 0
            goto L2f
        L34:
            com.bytedance.sdk.component.tf.p r0 = com.bytedance.sdk.component.tf.p.hf
            boolean r9 = r0.jk()
            if (r9 == 0) goto L5b
            java.util.concurrent.ThreadPoolExecutor r10 = r0.d()
            int r10 = r10.getActiveCount()
            java.util.concurrent.ThreadPoolExecutor r0 = r0.tf()
            int r0 = r0.getActiveCount()
            long r11 = java.lang.System.currentTimeMillis()
            long r13 = r1.f
            long r13 = r11 - r13
            r16 = 0
            long r2 = r1.c
            long r13 = r13 - r2
            r2 = r0
            goto L62
        L5b:
            r16 = 0
            r11 = 0
            r13 = r11
            r2 = 0
            r10 = 0
        L62:
            java.lang.Runnable r0 = r1.w
            r0.run()
            long r17 = java.lang.System.currentTimeMillis()
            long r17 = r17 - r11
            boolean r0 = r1.kd
            if (r0 != 0) goto L7b
            int r0 = r1.d
            r3 = 2
            if (r0 != r3) goto L7b
            java.util.concurrent.atomic.AtomicInteger r0 = com.bytedance.sdk.component.tf.xj.w.xj
            r0.decrementAndGet()
        L7b:
            r4.setPriority(r5)     // Catch: java.lang.Throwable -> L80
        L7e:
            r3 = 0
            goto L8a
        L80:
            r0 = move-exception
            r15 = 1
            java.lang.Object[] r3 = new java.lang.Object[r15]
            r3[r16] = r0
            com.bytedance.sdk.component.utils.pl.hf(r7, r3)
            goto L7e
        L8a:
            r1.w(r3)
            if (r9 != 0) goto L90
            goto Lcd
        L90:
            boolean r0 = r1.xj(r13)
            if (r0 != 0) goto La0
            com.bytedance.sdk.component.tf.p r0 = com.bytedance.sdk.component.tf.p.hf
            long r3 = r0.v()
            int r0 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r0 <= 0) goto Lcd
        La0:
            java.lang.String r0 = "event"
            java.lang.Object r0 = com.bytedance.sdk.openadsdk.ats.w.xj(r0)
            com.bytedance.sdk.component.u.c r0 = (com.bytedance.sdk.component.u.c) r0
            if (r0 != 0) goto Lb0
            java.lang.String r0 = "IEvent service is null"
            com.bytedance.sdk.component.utils.pl.hf(r7, r0)
            return
        Lb0:
            if (r8 == 0) goto Lbf
            java.lang.String r3 = r8.getName()
        Lb6:
            r9 = r2
            r7 = r6
            r8 = r10
            r4 = r17
            r10 = r0
            r6 = r3
            r2 = r13
            goto Lca
        Lbf:
            java.lang.Runnable r3 = r1.w
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            goto Lb6
        Lca:
            r1.xj(r2, r4, r6, r7, r8, r9, r10)
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tf.xj.w.run():void");
    }

    public int u() {
        return this.d;
    }

    public void xj(y yVar) {
        this.u = yVar;
    }

    public void hf(boolean z) {
        this.y = z;
    }

    public Runnable xj() {
        return this.w;
    }

    private boolean xj(long j) {
        return this.tf == 1 ? j > p.hf.e() : j > p.hf.yo();
    }

    public boolean w() {
        return this.y;
    }

    private void xj(long j, long j2, String str, int i, int i2, int i3, com.bytedance.sdk.component.u.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.c);
            jSONObject.put("is_wrap", this.w instanceof w);
            jSONObject.put("is_oom", hf);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.f);
            jSONObject.put("pool_type", this.d);
            jSONObject.put("origin_pool_type", this.tf);
            jSONObject.put("run_cost", j2);
            jSONObject.put("task_name", str);
            jSONObject.put("thread_name", Thread.currentThread().getName());
            p pVar = p.hf;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", pVar.am());
            jSONObject.put("auto_size", com.bytedance.sdk.component.tf.c.kd());
            jSONObject.put("pri_task_in_little", xj.get());
            jSONObject.put("core_count", pVar.f());
            jSONObject.put("max_pool_size", pVar.p());
            jSONObject.put("use_little_pool", pVar.zg());
        } catch (Exception unused) {
        }
        cVar.onStatsEvent("task_run_cost", jSONObject);
    }

    public w(Runnable runnable, y yVar) {
        this.w = runnable;
        this.u = yVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(w wVar) {
        Class<?> cls = this.w.getClass();
        Class<?> cls2 = wVar.w.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.w;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = wVar.w;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void xj(boolean z) {
        this.kd = z;
    }

    public void xj(int i) {
        int i2 = this.d;
        if (i2 == 0) {
            this.tf = i;
        } else {
            this.tf = i2;
        }
        this.d = i;
    }
}
