package com.bytedance.sdk.component.f.hf.xj;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements kd {
    private final u hf;
    private com.bytedance.sdk.component.f.hf.hf.w.w kd;
    private com.bytedance.sdk.component.f.xj.kd u;
    private final Queue<String> w;
    private final kd xj;

    public w(com.bytedance.sdk.component.f.xj.kd kdVar, com.bytedance.sdk.component.f.hf.hf.w.w wVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.w = concurrentLinkedQueue;
        this.u = kdVar;
        this.kd = wVar;
        this.xj = new y(concurrentLinkedQueue, kdVar);
        this.hf = new u(this.u);
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public List<com.bytedance.sdk.component.f.xj.hf> xj(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, List<String> list) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {all -> 0x0012, blocks: (B:3:0x0001, B:5:0x0009, B:9:0x001b, B:14:0x0014), top: B:2:0x0001 }] */
    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void xj(com.bytedance.sdk.component.f.xj.hf r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.bytedance.sdk.component.f.xj.kd r0 = r1.u     // Catch: java.lang.Throwable -> L12
            boolean r0 = com.bytedance.sdk.component.f.hf.w.xj.d(r2, r0)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            com.bytedance.sdk.component.f.hf.hf.w.w r0 = r1.kd     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.u()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L19
            goto L14
        L12:
            r2 = move-exception
            goto L22
        L14:
            com.bytedance.sdk.component.f.hf.xj.kd r0 = r1.xj     // Catch: java.lang.Throwable -> L12
            r0.xj(r2)     // Catch: java.lang.Throwable -> L12
        L19:
            if (r2 == 0) goto L20
            com.bytedance.sdk.component.f.hf.xj.u r0 = r1.hf     // Catch: java.lang.Throwable -> L12
            r0.xj(r2)     // Catch: java.lang.Throwable -> L12
        L20:
            monitor-exit(r1)
            return
        L22:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.xj.w.xj(com.bytedance.sdk.component.f.xj.hf):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:2|(3:3|4|(2:7|5))|8|9|10|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0079, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
    
        r7 = new com.bytedance.sdk.component.f.hf.xj.hf();
        r7.xj(false);
        r7.xj("db exception:" + r6.getMessage());
        com.bytedance.sdk.component.f.hf.w.w.w(r6.getMessage(), r5.u);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a0, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        r2 = new com.bytedance.sdk.component.f.hf.xj.hf();
        r2.xj(false);
        r2.xj("mem exception:" + r1.getMessage());
        com.bytedance.sdk.component.f.hf.w.w.w(r1.getMessage(), r5.u);
     */
    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.bytedance.sdk.component.f.hf.xj.hf xj(int r6, java.util.List<com.bytedance.sdk.component.f.xj.hf> r7, int r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.util.Iterator r1 = r7.iterator()     // Catch: java.lang.Throwable -> L1c
        L6:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L43
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L1c
            com.bytedance.sdk.component.f.xj.hf r2 = (com.bytedance.sdk.component.f.xj.hf) r2     // Catch: java.lang.Throwable -> L1c
            java.util.Queue<java.lang.String> r3 = r5.w     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = r2.w()     // Catch: java.lang.Throwable -> L1c
            r3.remove(r2)     // Catch: java.lang.Throwable -> L1c
            goto L6
        L1c:
            r1 = move-exception
            com.bytedance.sdk.component.f.hf.xj.hf r2 = new com.bytedance.sdk.component.f.hf.xj.hf     // Catch: java.lang.Throwable -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L77
            r2.xj(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            java.lang.String r4 = "sending exception:"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r4 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            r3.append(r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L77
            r2.xj(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            com.bytedance.sdk.component.f.xj.kd r2 = r5.u     // Catch: java.lang.Throwable -> L77
            com.bytedance.sdk.component.f.hf.w.w.w(r1, r2)     // Catch: java.lang.Throwable -> L77
        L43:
            com.bytedance.sdk.component.f.hf.xj.kd r1 = r5.xj     // Catch: java.lang.Throwable -> L49
            r1.xj(r6, r7, r8)     // Catch: java.lang.Throwable -> L49
            goto L70
        L49:
            r1 = move-exception
            com.bytedance.sdk.component.f.hf.xj.hf r2 = new com.bytedance.sdk.component.f.hf.xj.hf     // Catch: java.lang.Throwable -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L77
            r2.xj(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            java.lang.String r4 = "mem exception:"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r4 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            r3.append(r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L77
            r2.xj(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            com.bytedance.sdk.component.f.xj.kd r2 = r5.u     // Catch: java.lang.Throwable -> L77
            com.bytedance.sdk.component.f.hf.w.w.w(r1, r2)     // Catch: java.lang.Throwable -> L77
        L70:
            com.bytedance.sdk.component.f.hf.xj.u r1 = r5.hf     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            com.bytedance.sdk.component.f.hf.xj.hf r6 = r1.xj(r6, r7, r8)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            goto La1
        L77:
            r6 = move-exception
            goto La3
        L79:
            r6 = move-exception
            com.bytedance.sdk.component.f.hf.xj.hf r7 = new com.bytedance.sdk.component.f.hf.xj.hf     // Catch: java.lang.Throwable -> L77
            r7.<init>()     // Catch: java.lang.Throwable -> L77
            r7.xj(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = "db exception:"
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r6.getMessage()     // Catch: java.lang.Throwable -> L77
            r8.append(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L77
            r7.xj(r8)     // Catch: java.lang.Throwable -> L77
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L77
            com.bytedance.sdk.component.f.xj.kd r8 = r5.u     // Catch: java.lang.Throwable -> L77
            com.bytedance.sdk.component.f.hf.w.w.w(r6, r8)     // Catch: java.lang.Throwable -> L77
            r6 = r7
        La1:
            monitor-exit(r5)
            return r6
        La3:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.xj.w.xj(int, java.util.List, int):com.bytedance.sdk.component.f.hf.xj.hf");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public synchronized List<com.bytedance.sdk.component.f.xj.hf> xj(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, String str) {
        List<com.bytedance.sdk.component.f.xj.hf> list;
        try {
            List<com.bytedance.sdk.component.f.xj.hf> xj = this.xj.xj(i, hfVar, z, (List<String>) null);
            if (xj != 0 && xj.size() != 0) {
                int size = xj.size();
                list = xj;
                if (com.bytedance.sdk.component.f.hf.w.xj.xj(i)) {
                    List<com.bytedance.sdk.component.f.xj.hf> xj2 = this.hf.xj((com.bytedance.sdk.component.f.xj.hf) xj.get(0), size, i, z);
                    list = xj;
                    if (xj2 != null) {
                        list = xj;
                        if (xj2.size() != 0) {
                            xj2.size();
                            HashMap hashMap = new HashMap();
                            for (com.bytedance.sdk.component.f.xj.hf hfVar2 : xj2) {
                                hashMap.put(hfVar2.w(), hfVar2);
                            }
                            ArrayList arrayList = new ArrayList(this.w);
                            arrayList.size();
                            for (com.bytedance.sdk.component.f.xj.hf hfVar3 : xj2) {
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (TextUtils.equals(hfVar3.w(), (String) it.next())) {
                                            hashMap.remove(hfVar3.w());
                                            break;
                                        }
                                    }
                                }
                            }
                            for (com.bytedance.sdk.component.f.xj.hf hfVar4 : xj) {
                                hashMap.put(hfVar4.w(), hfVar4);
                            }
                            xj.clear();
                            Set keySet = hashMap.keySet();
                            hashMap.size();
                            Iterator it2 = keySet.iterator();
                            while (it2.hasNext()) {
                                xj.add(hashMap.get((String) it2.next()));
                            }
                            xj2.clear();
                            list = xj;
                        }
                    }
                }
            } else {
                ArrayList arrayList2 = new ArrayList(this.w);
                int size2 = arrayList2.size();
                List<com.bytedance.sdk.component.f.xj.hf> xj3 = this.hf.xj(i, hfVar, z, arrayList2);
                if (xj3 != 0 && xj3.size() != 0) {
                    xj3.size();
                    HashMap hashMap2 = new HashMap();
                    for (com.bytedance.sdk.component.f.xj.hf hfVar5 : xj3) {
                        hashMap2.put(hfVar5.w(), hfVar5);
                    }
                    if (size2 != 0) {
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            String str2 = (String) it3.next();
                            if (hashMap2.get(str2) != null) {
                                hashMap2.remove(str2);
                            }
                        }
                    }
                    xj3.clear();
                    Set keySet2 = hashMap2.keySet();
                    hashMap2.size();
                    Iterator it4 = keySet2.iterator();
                    while (it4.hasNext()) {
                        xj3.add(hashMap2.get((String) it4.next()));
                    }
                }
                list = xj3;
            }
            if (list != null && !list.isEmpty()) {
                list.size();
                Iterator<com.bytedance.sdk.component.f.xj.hf> it5 = list.iterator();
                while (it5.hasNext()) {
                    this.w.offer(it5.next().w());
                }
                return list;
            }
            return new ArrayList();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public synchronized boolean xj(int i, String str, com.bytedance.sdk.component.f.xj.hf hfVar) {
        if (this.xj.xj(i, str, hfVar)) {
            com.bytedance.sdk.component.f.hf.w.w.hf("_opt", "cacheManager check result : memory meet ".concat(String.valueOf(str)), this.u);
            return true;
        }
        if (!com.bytedance.sdk.component.f.hf.w.xj.xj(i) || !this.hf.xj(i, str, hfVar)) {
            return false;
        }
        com.bytedance.sdk.component.f.hf.w.w.hf("_opt", "cacheManager check result : db meet ".concat(String.valueOf(str)), this.u);
        return true;
    }
}
