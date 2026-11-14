package com.ss.android.socialbase.downloader.y;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    private int c;
    private JSONObject f;
    int hf;
    private volatile long kd;
    private final AtomicLong u;
    private final long w;
    volatile g xj;
    private long y;

    public d(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.u = atomicLong;
        this.hf = 0;
        this.w = j;
        atomicLong.set(j);
        this.kd = j;
        if (j2 >= j) {
            this.y = j2;
        } else {
            this.y = -1L;
        }
    }

    public int c() {
        return this.c;
    }

    public void d() {
        this.hf--;
    }

    public void f() {
        this.hf++;
    }

    public long hf() {
        long j = this.y;
        if (j >= this.w) {
            return (j - kd()) + 1;
        }
        return -1L;
    }

    public long kd() {
        g gVar = this.xj;
        if (gVar != null) {
            long u = gVar.u();
            if (u > this.kd) {
                return u;
            }
        }
        return this.kd;
    }

    public JSONObject p() {
        JSONObject jSONObject = this.f;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.f = jSONObject;
        }
        jSONObject.put("st", w());
        jSONObject.put("cu", u());
        jSONObject.put("en", y());
        return jSONObject;
    }

    public int tf() {
        return this.hf;
    }

    public String toString() {
        return "Segment{startOffset=" + this.w + ",\t currentOffset=" + this.u + ",\t currentOffsetRead=" + kd() + ",\t endOffset=" + this.y + '}';
    }

    public long u() {
        long j = this.u.get();
        long j2 = this.y;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long w() {
        return this.w;
    }

    public long xj() {
        return this.u.get() - this.w;
    }

    public long y() {
        return this.y;
    }

    public void w(long j) {
        if (j >= this.w) {
            this.y = j;
            return;
        }
        com.bytedance.sdk.component.utils.pl.hf("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.y = j;
        }
    }

    public void xj(long j) {
        long j2 = this.w;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.y;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.u.set(j);
    }

    public void hf(long j) {
        this.u.addAndGet(j);
    }

    public void u(long j) {
        if (j >= this.u.get()) {
            this.kd = j;
        }
    }

    public void hf(int i) {
        this.hf = i;
    }

    public void xj(int i) {
        this.c = i;
    }

    public static String xj(List<d> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<d>() { // from class: com.ss.android.socialbase.downloader.y.d.1
            @Override // java.util.Comparator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int compare(d dVar, d dVar2) {
                return (int) (dVar.w() - dVar2.w());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public d(d dVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.u = atomicLong;
        this.hf = 0;
        this.w = dVar.w;
        this.y = dVar.y;
        atomicLong.set(dVar.u.get());
        this.kd = atomicLong.get();
        this.c = dVar.c;
    }

    public d(JSONObject jSONObject) {
        this.u = new AtomicLong();
        this.hf = 0;
        this.w = jSONObject.optLong("st");
        w(jSONObject.optLong("en"));
        xj(jSONObject.optLong("cu"));
        u(u());
    }
}
