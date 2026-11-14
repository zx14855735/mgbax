package com.bytedance.msdk.w.y.xj;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.w.f.c;
import com.bytedance.msdk.xj.kd.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private List<Integer> p;
    private AtomicInteger w = new AtomicInteger(-1);
    private AtomicBoolean u = new AtomicBoolean();
    public final Map<Integer, Boolean> xj = new HashMap();
    public final Map<Integer, Boolean> hf = new HashMap();
    private final Map<Integer, AtomicInteger> kd = new HashMap();
    private final AtomicInteger y = new AtomicInteger();
    private final AtomicInteger c = new AtomicInteger();
    private final AtomicInteger f = new AtomicInteger();
    private final List<String> d = new CopyOnWriteArrayList();
    private final AtomicInteger tf = new AtomicInteger(-1000);

    public synchronized boolean c() {
        AtomicInteger atomicInteger = this.kd.get(0);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized boolean d() {
        return this.c.get() == 0;
    }

    public synchronized boolean f() {
        return this.y.get() == 0;
    }

    public synchronized int hf() {
        return this.w.get();
    }

    public synchronized boolean kd(int i) {
        Boolean bool = this.hf.get(Integer.valueOf(i));
        if (bool != null) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public synchronized int p() {
        return this.tf.get();
    }

    public synchronized void pl() {
        this.w.set(-1);
        this.u.set(false);
        this.xj.clear();
        this.hf.clear();
        this.kd.clear();
        this.y.set(0);
        this.d.clear();
        this.tf.set(-1000);
    }

    public synchronized boolean tf() {
        return this.f.get() == 0;
    }

    public synchronized void u(int i) {
        this.hf.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean w() {
        return hf() > 0;
    }

    public List<Integer> xj() {
        return this.p;
    }

    public synchronized boolean y() {
        AtomicInteger atomicInteger = this.kd.get(-100);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized void d(int i) {
        this.f.set(i);
    }

    public synchronized void f(int i) {
        this.c.set(i);
    }

    public synchronized void hf(int i) {
        try {
            if (this.tf.get() < i) {
                this.tf.set(i);
            }
            this.xj.put(Integer.valueOf(i), Boolean.TRUE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean w(int i) {
        Boolean bool = this.xj.get(Integer.valueOf(i));
        if (bool != null) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public void xj(List<Integer> list) {
        this.p = list;
    }

    public synchronized void u() {
        this.u.set(true);
    }

    public synchronized void xj(int i) {
        this.w.set(i);
    }

    public synchronized boolean kd() {
        return this.u.get();
    }

    public synchronized void xj(int i, int i2) {
        this.kd.put(Integer.valueOf(i), new AtomicInteger(i2));
    }

    public synchronized void c(int i) {
        this.y.set(i);
    }

    public synchronized int y(int i) {
        AtomicInteger atomicInteger = this.kd.get(Integer.valueOf(i));
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public synchronized void xj(int i, String str) {
        try {
            AtomicInteger atomicInteger = this.kd.get(Integer.valueOf(i));
            if (atomicInteger != null && atomicInteger.get() != 0) {
                atomicInteger.decrementAndGet();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.d.add(str);
            if (i < -100 && this.c.get() != 0) {
                this.c.decrementAndGet();
            }
            if (i > 0 && this.f.get() != 0) {
                this.f.decrementAndGet();
            }
            if (this.y.get() != 0) {
                this.y.decrementAndGet();
            } else {
                w.u(MediationConstant.TAG, "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void xj(List<tf> list, List<tf> list2, List<tf> list3) {
        int i;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    List<tf> hf = c.hf(list);
                    int i2 = 0;
                    if (q.xj(hf)) {
                        i = 0;
                    } else {
                        i = hf.size();
                        for (tf tfVar : hf) {
                            Iterator<String> it = this.d.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    String next = it.next();
                                    if (!TextUtils.isEmpty(next) && tfVar != null && next.equals(tfVar.yo())) {
                                        i--;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (i < 0) {
                        i = 0;
                    }
                    this.f.set(i);
                    int size = list.size();
                    if (list2 != null) {
                        size += list2.size();
                    }
                    if (list3 != null) {
                        size += list3.size();
                    }
                    for (tf tfVar2 : list) {
                        Iterator<String> it2 = this.d.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                String next2 = it2.next();
                                if (!TextUtils.isEmpty(next2) && tfVar2 != null && next2.equals(tfVar2.yo())) {
                                    size--;
                                    break;
                                }
                            }
                        }
                    }
                    if (!q.xj(list2)) {
                        for (tf tfVar3 : list2) {
                            Iterator<String> it3 = this.d.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    String next3 = it3.next();
                                    if (!TextUtils.isEmpty(next3) && tfVar3 != null && next3.equals(tfVar3.yo())) {
                                        size--;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (!q.xj(list3)) {
                        for (tf tfVar4 : list3) {
                            Iterator<String> it4 = this.d.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    String next4 = it4.next();
                                    if (!TextUtils.isEmpty(next4) && tfVar4 != null && next4.equals(tfVar4.yo())) {
                                        size--;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (size >= 0) {
                        i2 = size;
                    }
                    this.y.set(i2);
                }
            } finally {
            }
        }
    }
}
