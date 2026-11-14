package com.bytedance.embedapplog;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class io {
    protected final Context hf;
    protected final pz u;
    protected final x w;
    protected final List<Future<q>> xj = new ArrayList();

    public io(Context context, pz pzVar, x xVar) {
        this.u = pzVar;
        this.w = xVar;
        this.hf = context;
    }

    public abstract List<String> xj();

    public boolean xj(JSONObject jSONObject) {
        return false;
    }

    public void xj(jk jkVar, Long l) {
        this.xj.add(j.xj(new ht(jkVar, l)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0008 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[Catch: Exception -> 0x0043, TryCatch #0 {Exception -> 0x0043, blocks: (B:6:0x001a, B:11:0x0029, B:22:0x0075, B:26:0x0056, B:28:0x0065, B:29:0x0039, B:32:0x0045), top: B:5:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(java.util.Map<java.lang.String, org.json.JSONObject> r6, long r7) {
        /*
            r5 = this;
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L8:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L96
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r2 = r5.xj()     // Catch: java.lang.Exception -> L43
            java.lang.Object r3 = r0.getKey()     // Catch: java.lang.Exception -> L43
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Exception -> L43
            if (r2 != 0) goto L29
            goto L8
        L29:
            int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L43
            r3 = 3073450(0x2ee5aa, float:4.306821E-39)
            r4 = 1
            if (r2 == r3) goto L45
            r3 = 3073698(0x2ee6a2, float:4.307168E-39)
            if (r2 == r3) goto L39
            goto L4f
        L39:
            java.lang.String r2 = "d_i0"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L43
            if (r1 == 0) goto L4f
            r1 = 1
            goto L50
        L43:
            r0 = move-exception
            goto L7d
        L45:
            java.lang.String r2 = "d_a0"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L43
            if (r1 == 0) goto L4f
            r1 = 0
            goto L50
        L4f:
            r1 = -1
        L50:
            if (r1 == 0) goto L65
            if (r1 == r4) goto L56
            r0 = 0
            goto L73
        L56:
            com.bytedance.embedapplog.dk r1 = new com.bytedance.embedapplog.dk     // Catch: java.lang.Exception -> L43
            android.content.Context r2 = r5.hf     // Catch: java.lang.Exception -> L43
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Exception -> L43
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch: java.lang.Exception -> L43
            r1.<init>(r2, r0)     // Catch: java.lang.Exception -> L43
        L63:
            r0 = r1
            goto L73
        L65:
            com.bytedance.embedapplog.ra r1 = new com.bytedance.embedapplog.ra     // Catch: java.lang.Exception -> L43
            android.content.Context r2 = r5.hf     // Catch: java.lang.Exception -> L43
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Exception -> L43
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch: java.lang.Exception -> L43
            r1.<init>(r2, r0)     // Catch: java.lang.Exception -> L43
            goto L63
        L73:
            if (r0 == 0) goto L8
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Exception -> L43
            r5.xj(r0, r1)     // Catch: java.lang.Exception -> L43
            goto L8
        L7d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error "
            r1.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "__kite"
            com.bytedance.embedapplog.v.u(r1, r0)
            goto L8
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.io.xj(java.util.Map, long):void");
    }
}
