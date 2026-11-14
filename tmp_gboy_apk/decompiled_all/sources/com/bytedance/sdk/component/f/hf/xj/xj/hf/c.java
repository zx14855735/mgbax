package com.bytedance.sdk.component.f.hf.xj.xj.hf;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends hf {
    protected com.bytedance.sdk.component.f.xj.kd hf;
    private com.bytedance.sdk.component.f.hf.u.hf.xj u;
    protected List<String> w;

    public c(Context context, com.bytedance.sdk.component.f.hf.u.hf.xj xjVar, com.bytedance.sdk.component.f.xj.kd kdVar) {
        super(context, kdVar, xjVar == null ? com.bytedance.sdk.component.f.hf.u.hf.xj.w() : xjVar);
        this.w = new ArrayList();
        this.u = xjVar;
        this.hf = kdVar;
        if (xjVar == null) {
            this.u = com.bytedance.sdk.component.f.hf.u.hf.xj.w();
        }
    }

    public static String kd(String str) {
        return CtFAbx.BI9f7h("ALTER TABLE ", str, " ADD COLUMN encrypt INTEGER default 0");
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.w
    public String delete(List<com.bytedance.sdk.component.f.xj.hf> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().w());
        }
        com.bytedance.sdk.component.f.hf.w.xj.xj(list, this.hf, xj());
        String xj = com.bytedance.sdk.component.f.hf.xj.xj.hf.xj(getContext(), "DELETE FROM " + xj() + " WHERE " + xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, (List<?>) linkedList, 1000, true), this.hf);
        xj(linkedList);
        return xj;
    }

    public byte hf() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.hf
    public com.bytedance.sdk.component.f.xj.kd u() {
        return this.hf;
    }

    public byte w() {
        return (byte) 2;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj
    public boolean xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return com.bytedance.sdk.component.f.hf.w.xj.u(hfVar);
    }

    private void u(List<com.bytedance.sdk.component.f.xj.hf> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().w());
        }
        com.bytedance.sdk.component.f.hf.xj.xj.hf.xj(getContext(), "UPDATE " + xj() + " SET retry = retry+1 WHERE " + xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, (List<?>) linkedList, 1000, true), this.hf);
    }

    public void w(List<String> list) {
        xj();
        list.size();
        com.bytedance.sdk.component.f.hf.xj.xj.hf.xj(getContext(), "DELETE FROM " + xj() + " WHERE " + xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, (List<?>) list, 1000, true), this.hf);
        com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.qt(), list.size(), this.hf);
        xj(list);
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.hf
    public String xj() {
        return this.hf.hf().u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b6, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00bf, code lost:
    
        if (r11.w.isEmpty() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c1, code lost:
    
        w(r11.w);
        r11.w.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00cf, code lost:
    
        if (com.bytedance.sdk.component.f.hf.w.xj.xj(r14) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d1, code lost:
    
        if (r15 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00d3, code lost:
    
        xj(r12, 5, com.baidu.mobads.sdk.internal.bn.d);
     */
    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.bytedance.sdk.component.f.xj.hf> xj(int r12, java.lang.String r13, int r14, boolean r15) {
        /*
            r11 = this;
            android.content.Context r0 = r11.getContext()
            com.bytedance.sdk.component.f.xj.kd r1 = r11.hf
            long r0 = com.bytedance.sdk.component.f.hf.hf.xj.xj(r12, r0, r1)
            r2 = 0
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 <= 0) goto L18
            r2 = 100
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 <= 0) goto L1a
            r0 = r2
            goto L1a
        L18:
            r0 = 1
        L1a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r13)
            java.lang.String r13 = " DESC limit "
            r12.append(r13)
            r12.append(r0)
            java.lang.String r9 = r12.toString()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List<java.lang.String> r13 = r11.w
            r13.clear()
            android.content.Context r2 = r11.getContext()
            java.lang.String r3 = r11.xj()
            java.lang.String r13 = "id"
            java.lang.String r0 = "value"
            java.lang.String r1 = "encrypt"
            java.lang.String[] r4 = new java.lang.String[]{r13, r0, r1}
            r8 = 0
            com.bytedance.sdk.component.f.xj.kd r10 = r11.hf
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r2 = com.bytedance.sdk.component.f.hf.xj.xj.hf.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r2 == 0) goto Lfa
        L56:
            r3 = 604800000(0x240c8400, double:2.988109026E-315)
            r5 = 5
            boolean r6 = r2.moveToNext()     // Catch: java.lang.Throwable -> Ld7
            if (r6 == 0) goto Lb6
            int r6 = r2.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L56
            java.lang.String r6 = r2.getString(r6)     // Catch: java.lang.Throwable -> L56
            int r7 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = r2.getString(r7)     // Catch: java.lang.Throwable -> L56
            int r8 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L56
            int r8 = r2.getInt(r8)     // Catch: java.lang.Throwable -> L56
            r9 = 1
            if (r8 != r9) goto L85
            com.bytedance.sdk.component.f.xj.kd r8 = r11.hf     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.component.f.xj.u r8 = r8.u()     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = r8.xj(r7)     // Catch: java.lang.Throwable -> L56
        L85:
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L56
            if (r8 == 0) goto L91
            java.util.List<java.lang.String> r3 = r11.w     // Catch: java.lang.Throwable -> L56
            r3.add(r6)     // Catch: java.lang.Throwable -> L56
            goto L56
        L91:
            int r8 = r12.size()     // Catch: java.lang.Throwable -> L56
            r9 = 100
            if (r8 <= r9) goto L9a
            goto Lb6
        L9a:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L56
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.component.f.hf.u.xj.xj r4 = new com.bytedance.sdk.component.f.hf.u.xj.xj     // Catch: java.lang.Throwable -> L56
            r4.<init>(r6, r3)     // Catch: java.lang.Throwable -> L56
            byte r3 = r11.w()     // Catch: java.lang.Throwable -> L56
            r4.hf(r3)     // Catch: java.lang.Throwable -> L56
            byte r3 = r11.hf()     // Catch: java.lang.Throwable -> L56
            r4.xj(r3)     // Catch: java.lang.Throwable -> L56
            r12.add(r4)     // Catch: java.lang.Throwable -> L56
            goto L56
        Lb6:
            r2.close()     // Catch: java.lang.Exception -> Lfa
            java.util.List<java.lang.String> r13 = r11.w     // Catch: java.lang.Exception -> Lfa
            boolean r13 = r13.isEmpty()     // Catch: java.lang.Exception -> Lfa
            if (r13 != 0) goto Lcb
            java.util.List<java.lang.String> r13 = r11.w     // Catch: java.lang.Exception -> Lfa
            r11.w(r13)     // Catch: java.lang.Exception -> Lfa
            java.util.List<java.lang.String> r13 = r11.w     // Catch: java.lang.Exception -> Lfa
            r13.clear()     // Catch: java.lang.Exception -> Lfa
        Lcb:
            boolean r13 = com.bytedance.sdk.component.f.hf.w.xj.xj(r14)     // Catch: java.lang.Exception -> Lfa
            if (r13 == 0) goto Lfa
            if (r15 != 0) goto Lfa
            r11.xj(r12, r5, r3)     // Catch: java.lang.Exception -> Lfa
            goto Lfa
        Ld7:
            r0 = move-exception
            r13 = r0
            r2.close()     // Catch: java.lang.Exception -> Lf9
            java.util.List<java.lang.String> r0 = r11.w     // Catch: java.lang.Exception -> Lf9
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> Lf9
            if (r0 != 0) goto Lee
            java.util.List<java.lang.String> r0 = r11.w     // Catch: java.lang.Exception -> Lf9
            r11.w(r0)     // Catch: java.lang.Exception -> Lf9
            java.util.List<java.lang.String> r0 = r11.w     // Catch: java.lang.Exception -> Lf9
            r0.clear()     // Catch: java.lang.Exception -> Lf9
        Lee:
            boolean r14 = com.bytedance.sdk.component.f.hf.w.xj.xj(r14)     // Catch: java.lang.Exception -> Lf9
            if (r14 == 0) goto Lf9
            if (r15 != 0) goto Lf9
            r11.xj(r12, r5, r3)     // Catch: java.lang.Exception -> Lf9
        Lf9:
            throw r13
        Lfa:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.xj.xj.hf.c.xj(int, java.lang.String, int, boolean):java.util.List");
    }

    public static String u(String str) {
        return CtFAbx.BI9f7h("CREATE TABLE IF NOT EXISTS ", str, " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)");
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.w
    public List<com.bytedance.sdk.component.f.xj.hf> xj(String str, int i, boolean z) {
        com.bytedance.sdk.component.f.hf.u.hf.xj xjVar = this.u;
        if (xjVar == null) {
            return new ArrayList();
        }
        return xj(xjVar.hf(), str, i, z);
    }

    private void xj(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Context context = getContext();
        String xj = xj();
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i);
        com.bytedance.sdk.component.f.hf.xj.xj.hf.delete(context, xj, "gen_time <? OR retry >?", new String[]{sb2, sb3.toString()}, this.hf);
    }

    public void xj(List<com.bytedance.sdk.component.f.xj.hf> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            u(list);
            xj(i, j);
        } catch (Exception unused) {
        }
    }

    private static String xj(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String xj = xj(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            A2egSU.BIYEnU(sb, str, str2, "('", xj);
            sb.append("')");
        }
        return xj(sb.toString(), CtFAbx.AlLFFp(str, str2, "('')"));
    }

    private static String xj(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
