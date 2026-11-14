package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ht implements SensorEventListener {
    private static ra wa;
    private Sensor am;
    private boolean bl;
    private volatile long c;
    private int dk;
    private Sensor e;
    private JSONObject ff;
    private volatile long hf;

    /* renamed from: io, reason: collision with root package name */
    private float f10222io;
    private float kd;
    private Context lw;
    private pz p;
    private w qd;
    private Sensor qt;
    private float r;
    private float tj;
    private float u;
    private int v;
    private float w;
    private float ws;
    private float yo;
    private Sensor zg;
    private final long xj = 2000;
    private boolean y = false;
    private float f = 13.0f;
    private float d = 50.0f;
    private int tf = 0;

    /* renamed from: pl, reason: collision with root package name */
    private xj f10223pl = null;
    private hf g = null;
    private final long jk = 500;
    private volatile long pz = 0;
    private volatile boolean ht = false;
    private volatile boolean ra = false;
    private final float et = 1.0E-9f;
    private float[] x = new float[3];
    private long ai = 0;
    private float q = 0.0f;
    private float z = 4.0f;
    private float j = 0.0f;
    private float[] en = new float[3];
    private final float l = 0.0f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f10221a = false;
    private boolean wo = false;
    private boolean b = false;
    private boolean eu = false;
    private int n = 0;
    private int yy = 0;
    private int hl = 0;
    private int vm = 0;
    private int dc = 0;
    private int wn = 0;
    private boolean aq = false;
    private int tu = 0;
    private int s = 0;
    private float dq = 0.0f;

    public interface hf {
        void xj(float f, float f2, float f3);
    }

    public interface w {
        void xj();
    }

    public interface xj {
        void xj(int i);
    }

    public ht(Context context, int i, boolean z) {
        this.p = null;
        this.bl = z;
        this.dk = i;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.lw = applicationContext;
        if (applicationContext == null) {
            return;
        }
        pl.xj("xgc_cus", "cus:" + z);
        if (z) {
            this.p = pz.xj(this.lw);
        }
    }

    private void c() {
        this.n = 0;
        this.yy = 0;
        this.hl = 0;
    }

    private void d() {
        xj xjVar = this.f10223pl;
        if (xjVar != null) {
            xjVar.xj(getType());
        }
        this.hf = System.currentTimeMillis();
    }

    private boolean f() {
        return this.yo > this.f;
    }

    private int getType() {
        return this.dk == 2 ? 2 : 1;
    }

    private boolean hf() {
        pz pzVar = this.p;
        if (pzVar == null) {
            return false;
        }
        try {
            if (this.tf == 4) {
                return w();
            }
            if (this.am == null) {
                this.am = pzVar.xj(1);
            }
            boolean xj2 = this.p.xj(this, this.am, 3);
            y();
            return xj2;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void kd() {
        pz pzVar = this.p;
        if (pzVar == null) {
            return;
        }
        pzVar.xj(this);
    }

    private void tf() {
        xj xjVar = this.f10223pl;
        if (xjVar != null) {
            xjVar.xj(getType());
        }
        this.hf = System.currentTimeMillis();
        this.pz = 0L;
        this.ra = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        if (this.p == null || this.aq) {
            return false;
        }
        int i = this.dk;
        if (i == 1) {
            return hf();
        }
        if (i == 2) {
            return w();
        }
        return false;
    }

    private boolean w() {
        int i;
        pz pzVar = this.p;
        boolean z = false;
        if (pzVar == null) {
            return false;
        }
        try {
            if (this.v == 0) {
                if (this.qt == null) {
                    this.qt = pzVar.xj(15);
                }
                this.y = false;
                z = this.p.xj(this, this.qt, 1);
            }
            int i2 = this.v;
            if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 7) {
                if (this.zg == null) {
                    this.zg = this.p.xj(4);
                }
                float f = this.z;
                if (f != 0.0f && ((i = this.v) == 2 || i == 4)) {
                    this.dq = (float) Math.pow(f, 2.0d);
                    if (this.e == null) {
                        this.e = this.p.xj(10);
                    }
                    this.p.xj(this, this.e, 1);
                }
                z = this.p.xj(this, this.zg, 1);
            }
            c();
        } catch (Throwable unused) {
        }
        return z;
    }

    private float xj(double d) {
        if (d <= 0.0d || d > 180.0d) {
            d = 50.0d;
        }
        return (float) d;
    }

    private int y(float f) {
        return f < 0.0f ? 1 : 2;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        w wVar = this.qd;
        if (wVar != null) {
            wVar.xj();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.f10223pl == null || System.currentTimeMillis() - this.hf <= 2000) {
                return;
            }
            int i = this.tf;
            if (i == 1) {
                double sqrt = Math.sqrt(Math.pow(abs3, 2.0d) + Math.pow(abs2, 2.0d) + Math.pow(abs, 2.0d));
                xj(sqrt > ((double) this.f), sqrt);
                return;
            } else if (i == 2) {
                hf(Math.sqrt(Math.pow((double) abs3, 2.0d) + (Math.pow((double) abs2, 2.0d) + Math.pow((double) abs, 2.0d))) > ((double) this.f), sensorEvent);
                return;
            } else if (i == 3) {
                xj(Math.sqrt(Math.pow((double) abs3, 2.0d) + (Math.pow((double) abs2, 2.0d) + Math.pow((double) abs, 2.0d))) > ((double) this.f), sensorEvent);
                return;
            } else {
                double xj2 = xj(abs, abs2, abs3);
                xj(xj2 > ((double) this.f), xj2);
                return;
            }
        }
        if (type == 4) {
            int i2 = this.v;
            if (i2 == 3) {
                hf(sensorEvent);
                return;
            } else {
                if (i2 == 2 || i2 == 4 || i2 == 7) {
                    xj(sensorEvent);
                    return;
                }
                return;
            }
        }
        if (type == 10) {
            float[] fArr2 = sensorEvent.values;
            this.j = (float) (Math.pow(fArr2[2], 2.0d) + Math.pow(fArr2[1], 2.0d) + Math.pow(fArr2[0], 2.0d));
            return;
        }
        if (type != 15) {
            return;
        }
        float abs4 = Math.abs(fArr[0]);
        float abs5 = Math.abs(fArr[1]);
        float abs6 = Math.abs(fArr[2]);
        hf hfVar = this.g;
        if (hfVar != null) {
            hfVar.xj(fArr[0], fArr[1], fArr[2]);
        }
        if (abs4 == 0.0f && abs5 == 0.0f && abs6 == 0.0f) {
            return;
        }
        if (!this.y) {
            this.y = true;
            this.w = abs4;
            this.u = abs5;
            this.kd = abs6;
            return;
        }
        float abs7 = Math.abs(abs4 - this.w) * 180.0f;
        float abs8 = Math.abs(abs5 - this.u) * 180.0f;
        float abs9 = Math.abs(abs6 - this.kd) * 180.0f;
        if (!this.f10221a) {
            float f = this.d;
            if ((abs7 > f || abs8 > f || abs9 > f) && this.f10223pl != null && System.currentTimeMillis() - this.c > 2000) {
                this.f10223pl.xj(getType());
                this.c = System.currentTimeMillis();
                this.y = false;
                return;
            }
            return;
        }
        boolean z = this.wo && abs7 > this.r;
        boolean z2 = this.b && abs8 > this.ws;
        boolean z3 = this.eu && abs9 > this.tj;
        if ((z || z2 || z3) && this.f10223pl != null && System.currentTimeMillis() - this.c > 2000) {
            this.f10223pl.xj(getType());
            this.c = System.currentTimeMillis();
            this.y = false;
        }
    }

    private boolean xj(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private void y() {
        this.pz = 0L;
        this.ht = false;
        this.ra = false;
        this.n = 0;
        this.yy = 0;
        this.hl = 0;
        this.vm = 0;
        this.dc = 0;
        this.wn = 0;
    }

    private boolean xj(int i, int i2) {
        return (i | i2) == 3;
    }

    public void kd(int i) {
        this.tf = i;
    }

    private void c(float f) {
        if (!xj(this.v == 7, f) || System.currentTimeMillis() - this.c <= 2000) {
            return;
        }
        hf(false);
        xj xjVar = this.f10223pl;
        if (xjVar != null) {
            xjVar.xj(getType());
        }
        this.c = System.currentTimeMillis();
    }

    private void kd(float f) {
        if (System.currentTimeMillis() - this.pz >= 500) {
            this.ht = false;
            tf();
        } else if (f >= this.yo) {
            this.ht = true;
            tf();
        }
    }

    private boolean xj(int i, int i2, int i3) {
        return i2 == 3 && (i | i3) == 3;
    }

    public void u(int i) {
        this.aq = true;
        hf(i);
    }

    public void xj(boolean z) {
        Context context;
        StringBuilder sb = new StringBuilder("cus:");
        sb.append(z);
        sb.append(" m:");
        sb.append(this.bl);
        sb.append(" equ:");
        sb.append(this.p != null);
        pl.xj("xgcc", sb.toString());
        if (!z) {
            pz pzVar = this.p;
            if (pzVar != null) {
                pzVar.xj(this);
                this.p = null;
                return;
            }
            return;
        }
        if (this.bl || this.p != null || (context = this.lw) == null) {
            return;
        }
        this.p = pz.xj(context);
    }

    private void u(float f) {
        if (!xj(this.v == 4, f) || System.currentTimeMillis() - this.c <= 2000) {
            return;
        }
        xj xjVar = this.f10223pl;
        if (xjVar != null) {
            xjVar.xj(getType());
        }
        this.c = System.currentTimeMillis();
    }

    public void hf(int i) {
        kd();
        ra raVar = wa;
        if (raVar != null) {
            raVar.xj(i, hashCode());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void hf(android.hardware.SensorEvent r10) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.ht.hf(android.hardware.SensorEvent):void");
    }

    public void y(int i) {
        pz pzVar = this.p;
        if (pzVar == null) {
            return;
        }
        if (i == 3 || i == 2 || i == 4 || i == 7) {
            if (this.zg == null && pzVar != null) {
                this.zg = pzVar.xj(4);
            }
            if (this.zg != null) {
                this.v = i;
                return;
            }
        }
        this.v = 0;
    }

    public void xj(xj xjVar) {
        this.f10223pl = xjVar;
    }

    public void xj(hf hfVar) {
        this.g = hfVar;
    }

    public static void xj(ra raVar) {
        wa = raVar;
    }

    public boolean xj(int i) {
        ra raVar;
        if (i > 0 && (raVar = wa) != null && !raVar.xj(i)) {
            wa.xj(i, hashCode(), new Runnable() { // from class: com.bytedance.sdk.component.utils.ht.1
                @Override // java.lang.Runnable
                public void run() {
                    ht.this.u();
                }
            });
            return true;
        }
        return u();
    }

    public void w(int i) {
        this.aq = false;
        xj(i);
    }

    private void xj(SensorEvent sensorEvent) {
        if (this.ai != 0) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = (sensorEvent.timestamp - r0) * 1.0E-9f;
            float f5 = this.q;
            if (f5 != 0.0f) {
                if (hf(f5, f) && hf(this.q, f2) && hf(this.q, f3)) {
                    xj(f, f2, f3, f4);
                } else {
                    hf(true);
                }
            } else {
                float f6 = this.dq;
                if (f6 != 0.0f && this.j >= f6) {
                    hf(true);
                } else {
                    xj(f, f2, f3, f4);
                }
            }
            if (this.v == 7) {
                c(this.d);
            } else {
                u(this.d);
            }
            hf hfVar = this.g;
            if (hfVar != null) {
                float[] fArr2 = this.en;
                hfVar.xj(fArr2[0], fArr2[1], fArr2[2]);
            }
        }
        this.ai = sensorEvent.timestamp;
    }

    public void w(JSONObject jSONObject) {
        if (this.dk != 1) {
            return;
        }
        if (jSONObject == null) {
            this.tu = 0;
            this.s = 0;
        } else {
            this.tu = jSONObject.optInt("double_direct_conf", 0);
            this.s = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void w(float f) {
        this.yo = f;
    }

    private boolean hf(float f, float f2) {
        return Math.abs(f2) < f;
    }

    private void hf(boolean z) {
        float[] fArr = this.en;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    private boolean xj(boolean z, float f) {
        float abs = Math.abs((float) Math.toDegrees(this.en[0]));
        float abs2 = Math.abs((float) Math.toDegrees(this.en[1]));
        float abs3 = Math.abs((float) Math.toDegrees(this.en[2]));
        if (this.f10221a) {
            boolean z2 = this.wo && xj(abs, this.r);
            boolean z3 = this.b && xj(abs2, this.ws);
            boolean z4 = this.eu && xj(abs3, this.tj);
            if (z2 || z3 || z4) {
                return xj(z, z2, z3, z4);
            }
        } else {
            boolean xj2 = xj(abs, f);
            boolean xj3 = xj(abs2, f);
            boolean xj4 = xj(abs3, f);
            if (xj2 || xj3 || xj4) {
                return xj(z, xj2, xj3, xj4);
            }
        }
        return false;
    }

    public void hf(float f) {
        this.d = f;
    }

    public void hf(JSONObject jSONObject) {
        if (this.dk != 2) {
            return;
        }
        if (jSONObject == null) {
            this.s = 0;
        } else {
            this.s = jSONObject.optInt("double_direct_match", 0);
        }
    }

    private void hf(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int xj2 = xj(fArr[0], this.n);
            int xj3 = xj(fArr[1], this.yy);
            int xj4 = xj(fArr[2], this.hl);
            if (hf(xj2, xj3, xj4, true)) {
                xj(xj2, xj3, xj4, true);
                d();
            } else if (this.s == 1) {
                this.n = xj2;
                this.yy = xj3;
                this.hl = xj4;
            } else {
                this.n = xj2 | this.n;
                this.yy |= xj3;
                this.hl = xj4 | this.hl;
            }
        }
    }

    private void xj(float f, float f2, float f3, float f4) {
        float[] fArr = this.en;
        fArr[0] = (f * f4) + fArr[0];
        fArr[1] = (f2 * f4) + fArr[1];
        fArr[2] = (f3 * f4) + fArr[2];
    }

    public void xj(float f) {
        this.f = f;
    }

    public void xj(w wVar) {
        this.qd = wVar;
    }

    public void xj(JSONObject jSONObject) {
        if (this.dk != 2) {
            return;
        }
        this.ff = jSONObject;
        if (jSONObject == null) {
            this.wo = false;
            this.b = false;
            this.eu = false;
        } else {
            this.wo = jSONObject.has("x_threshold");
            this.r = xj(this.ff.optDouble("x_threshold", 50.0d));
            this.b = this.ff.has("y_threshold");
            this.ws = xj(this.ff.optDouble("y_threshold", 50.0d));
            this.eu = this.ff.has("z_threshold");
            this.tj = xj(this.ff.optDouble("z_threshold", 50.0d));
        }
        this.f10221a = this.wo || this.b || this.eu;
    }

    private boolean hf(int i, int i2, int i3, boolean z) {
        boolean xj2;
        boolean xj3;
        boolean xj4;
        int i4 = this.tu;
        if (i4 == 1) {
            int i5 = this.hl;
            return z ? xj(i3, i5) : xj(i3, i5, this.wn);
        }
        if (i4 == 2) {
            int i6 = this.yy;
            return z ? xj(i2, i6) : xj(i2, i6, this.dc);
        }
        if (i4 == 4) {
            int i7 = this.n;
            return z ? xj(i, i7) : xj(i, i7, this.vm);
        }
        if (i4 == 7) {
            return z ? xj(i, this.n) && xj(i2, this.yy) && xj(i3, this.hl) : xj(i, this.n, this.vm) && xj(i2, this.yy, this.dc) && xj(i3, this.hl, this.wn);
        }
        if (z) {
            xj2 = xj(i, this.n);
            xj3 = xj(i2, this.yy);
            xj4 = xj(i3, this.hl);
        } else {
            xj2 = xj(i, this.n, this.vm);
            xj3 = xj(i2, this.yy, this.dc);
            xj4 = xj(i3, this.hl, this.wn);
        }
        return xj2 || xj3 || xj4;
    }

    public boolean xj() {
        return this.ht;
    }

    private float xj(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }

    private void xj(boolean z, double d) {
        if (!f() && z) {
            d();
            return;
        }
        if (z) {
            this.pz = System.currentTimeMillis();
            this.ra = true;
            kd((float) d);
        } else {
            if (!this.ra || System.currentTimeMillis() - this.pz < 500) {
                return;
            }
            this.ht = false;
            tf();
        }
    }

    private void xj(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int xj2 = xj(fArr[0], this.n);
            int xj3 = xj(fArr[1], this.yy);
            int xj4 = xj(fArr[2], this.hl);
            if (hf(xj2, xj3, xj4, false)) {
                xj(xj2, xj3, xj4, true);
                d();
                return;
            }
            this.n |= xj2;
            if (xj2 <= 0) {
                xj2 = this.vm;
            }
            this.vm = xj2;
            this.yy |= xj3;
            if (xj3 <= 0) {
                xj3 = this.dc;
            }
            this.dc = xj3;
            this.hl |= xj4;
            if (xj4 <= 0) {
                xj4 = this.wn;
            }
            this.wn = xj4;
        }
    }

    private boolean xj(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z) {
            hf(false);
            return true;
        }
        int y = z2 ? y(this.en[0]) : 0;
        int y2 = z3 ? y(this.en[1]) : 0;
        int y3 = z4 ? y(this.en[2]) : 0;
        if (this.v != 7) {
            hf(false);
        }
        if (!xj(y, this.n) && !xj(y2, this.yy) && !xj(y3, this.hl)) {
            if (this.s != 1) {
                xj(y, y2, y3, false);
            } else if (z2 || z3 || z4) {
                this.n = y;
                this.yy = y2;
                this.hl = y3;
            }
            return false;
        }
        xj(y, y2, y3, true);
        return true;
    }

    private void xj(int i, int i2, int i3, boolean z) {
        if (z) {
            this.n = 0;
            this.yy = 0;
            this.hl = 0;
            this.vm = 0;
            this.dc = 0;
            this.wn = 0;
            return;
        }
        if (i == 0) {
            i = this.n;
        }
        this.n = i;
        if (i2 == 0) {
            i2 = this.yy;
        }
        this.yy = i2;
        if (i3 == 0) {
            i3 = this.hl;
        }
        this.hl = i3;
    }

    private int xj(float f, int i) {
        if (f != 0.0f) {
            return y(f);
        }
        if (i == 0) {
            return 0;
        }
        return i == 2 ? 1 : 2;
    }
}
