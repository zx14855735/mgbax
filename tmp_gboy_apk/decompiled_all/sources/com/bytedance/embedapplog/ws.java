package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ws {
    private static xj qt;
    private static final AtomicLong y = new AtomicLong(1000);
    private rg am;
    private long c;
    private long d = -1;
    private int f;
    private String g;
    private final aq hf;
    private String kd;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10111pl;
    private volatile boolean tf;
    private k u;
    private k w;
    private final wn xj;

    public static class xj extends da {
        private xj() {
        }
    }

    static {
        WwUTy();
    }

    public ws(aq aqVar, wn wnVar) {
        this.hf = aqVar;
        this.xj = wnVar;
    }

    private static /* synthetic */ void WwUTy() {
        char[] charArray = "üðò±øþòú±ýðæ±ì÷úóó±ÕñöÝíöûøú".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 159);
        }
        String str = new String(charArray);
        char[] charArray2 = "üóöñöë".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 159);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj kd() {
        if (qt == null) {
            qt = new xj();
        }
        qt.hf = System.currentTimeMillis();
        return qt;
    }

    public static long u() {
        return y.incrementAndGet();
    }

    public boolean hf() {
        return this.tf;
    }

    public boolean w() {
        return hf() && this.p == 0;
    }

    public String xj() {
        return this.kd;
    }

    public void hf(vl vlVar) {
        if (vlVar != null) {
            if (this.xj.ht()) {
                vlVar.f = com.bytedance.embedapplog.xj.kd();
            }
            vlVar.y = com.bytedance.embedapplog.xj.p();
            vlVar.c = com.bytedance.embedapplog.xj.tf();
            vlVar.u = this.kd;
            vlVar.w = u();
        }
    }

    public synchronized Bundle xj(long j, long j2) {
        Bundle bundle;
        if (this.xj.y() && w()) {
            long j3 = this.c;
            if (j3 > 0 && j - j3 > j2) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.f10111pl);
                int i = this.f + 1;
                this.f = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", (j - this.c) / 1000);
                bundle.putString("session_start_time", vl.hf(this.d));
                this.c = j;
            }
        }
        bundle = null;
        return bundle;
    }

    private synchronized void xj(vl vlVar, ArrayList<vl> arrayList, boolean z) {
        try {
            long j = vlVar instanceof xj ? -1L : vlVar.hf;
            this.kd = UUID.randomUUID().toString();
            y.set(1000L);
            this.d = j;
            this.tf = z;
            this.p = 0L;
            this.c = 0L;
            if (cu.hf) {
                cu.xj("startSession, " + this.kd + ", hadUi:" + z + " data:" + vlVar, null);
            }
            if (z) {
                Calendar calendar = Calendar.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append(calendar.get(1));
                sb.append(calendar.get(2));
                sb.append(calendar.get(5));
                String sb2 = sb.toString();
                if (TextUtils.isEmpty(this.g)) {
                    this.g = this.xj.w();
                    this.f10111pl = this.xj.u();
                }
                if (!sb2.equals(this.g)) {
                    this.g = sb2;
                    this.f10111pl = 1;
                } else {
                    this.f10111pl++;
                }
                this.xj.xj(sb2, this.f10111pl);
                this.f = 0;
                this.c = vlVar.hf;
            }
            if (j != -1) {
                rg rgVar = new rg(false);
                rgVar.u = this.kd;
                rgVar.w = u();
                rgVar.hf = this.d;
                rgVar.am = !this.tf;
                rgVar.g = this.hf.w();
                rgVar.f10107pl = this.hf.hf();
                rgVar.y = com.bytedance.embedapplog.xj.p();
                rgVar.c = com.bytedance.embedapplog.xj.tf();
                if (this.xj.ht()) {
                    rgVar.f = com.bytedance.embedapplog.xj.kd();
                }
                arrayList.add(rgVar);
                this.am = rgVar;
                if (cu.hf) {
                    cu.xj("gen launch, " + rgVar.u + ", hadUi:" + z, null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean xj(vl vlVar) {
        if (vlVar instanceof k) {
            return ((k) vlVar).tf();
        }
        return false;
    }

    public boolean xj(vl vlVar, ArrayList<vl> arrayList) {
        boolean z = vlVar instanceof k;
        boolean xj2 = xj(vlVar);
        boolean z2 = true;
        if (this.d == -1) {
            xj(vlVar, arrayList, xj(vlVar));
        } else if (!this.tf && xj2) {
            xj(vlVar, arrayList, true);
        } else {
            long j = this.p;
            if (j == 0 || vlVar.hf <= this.xj.dk() + j) {
                if (this.d > vlVar.hf + 7200000) {
                    xj(vlVar, arrayList, xj2);
                } else {
                    z2 = false;
                }
            } else if (!no.hf() && no.xj()) {
                xj(vlVar, arrayList, xj2);
            }
        }
        if (z) {
            k kVar = (k) vlVar;
            if (kVar.tf()) {
                this.p = 0L;
                arrayList.add(vlVar);
                if (TextUtils.isEmpty(kVar.g)) {
                    k kVar2 = this.u;
                    if (kVar2 != null && (kVar.hf - kVar2.hf) - kVar2.f10105pl < 500) {
                        kVar.g = kVar2.am;
                    } else {
                        k kVar3 = this.w;
                        if (kVar3 != null && (kVar.hf - kVar3.hf) - kVar3.f10105pl < 500) {
                            kVar.g = kVar3.am;
                        }
                    }
                }
            } else {
                Bundle xj3 = xj(vlVar.hf, 0L);
                if (xj3 != null) {
                    com.bytedance.embedapplog.xj.xj("play_session", xj3);
                }
                this.p = kVar.hf;
                arrayList.add(vlVar);
                if (kVar.p()) {
                    this.w = kVar;
                } else {
                    this.u = kVar;
                    this.w = null;
                }
            }
        } else if (!(vlVar instanceof xj)) {
            arrayList.add(vlVar);
        }
        hf(vlVar);
        return z2;
    }
}
