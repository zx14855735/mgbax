package com.bytedance.sdk.component.panglearmor.hf;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.component.panglearmor.y;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.am;
import com.kwad.components.core.s.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements SensorEventListener {
    private static volatile u xj;
    private Sensor am;
    private Sensor qt;
    private volatile xj v;
    private volatile boolean hf = false;
    private final List<Float> w = new ArrayList(1);
    private final List<Float> u = new ArrayList(1);
    private final List<Float> kd = new ArrayList(1);
    private final List<Float> y = new ArrayList(1);
    private final List<Float> c = new ArrayList(1);
    private final List<Float> f = new ArrayList(1);
    private final int d = 0;
    private final int tf = 1;
    private final int p = 2;

    /* renamed from: pl, reason: collision with root package name */
    private final int f10212pl = 16;
    private final int g = 32;
    private long zg = 0;
    private volatile boolean e = false;
    private volatile AtomicInteger yo = new AtomicInteger(0);
    private volatile int jk = 0;

    public interface xj {
        void xj(JSONObject jSONObject);
    }

    private u() {
        this.am = null;
        this.qt = null;
        SensorManager sensorManager = (SensorManager) y.u().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            try {
                this.am = sensorManager.getDefaultSensor(1);
                this.qt = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.yo.incrementAndGet();
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (this.w.size() > 0) {
                y();
                return;
            }
            this.w.add(Float.valueOf(sensorEvent.values[0]));
            this.u.add(Float.valueOf(sensorEvent.values[1]));
            this.kd.add(Float.valueOf(sensorEvent.values[2]));
            return;
        }
        if (type != 2) {
            return;
        }
        if (this.y.size() > 0) {
            y();
            return;
        }
        this.y.add(Float.valueOf(sensorEvent.values[0]));
        this.c.add(Float.valueOf(sensorEvent.values[1]));
        this.f.add(Float.valueOf(sensorEvent.values[2]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.w.clear();
        this.u.clear();
        this.kd.clear();
        this.y.clear();
        this.c.clear();
        this.f.clear();
    }

    private void kd() {
        this.yo = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) y.u().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            Sensor sensor = this.am;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.qt;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    private synchronized void y() {
        if (!this.hf && this.w.size() > 0 && this.y.size() > 0) {
            this.hf = true;
            kd();
            c.hf(new d("har") { // from class: com.bytedance.sdk.component.panglearmor.hf.u.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] xj2 = w.xj(u.this.w, u.this.u, u.this.kd, u.this.y, u.this.c, u.this.f);
                        u.this.xj(xj2);
                        long currentTimeMillis = System.currentTimeMillis();
                        long y = kd.xj().y();
                        long c = kd.xj().c();
                        int w = (int) (((kd.xj().w() / 1000) / 60) / 60);
                        if (w <= 0) {
                            w = 1;
                        }
                        jSONObject.put("azimuth_unit", y);
                        jSONObject.put("angle_unit", c);
                        LinkedList<JSONObject> xj3 = hf.xj().xj(0L);
                        jSONObject.put("active", Arrays.toString(w.xj(xj3, w)));
                        com.bytedance.sdk.component.panglearmor.hf.xj.xj().xj(w);
                        jSONObject.put("screen", Arrays.toString(com.bytedance.sdk.component.panglearmor.hf.xj.xj().w()));
                        jSONObject.put("network", Arrays.toString(com.bytedance.sdk.component.panglearmor.hf.xj.xj().hf()));
                        jSONObject.put("support_net", com.bytedance.sdk.component.panglearmor.hf.xj.xj().u());
                        jSONObject.put("sim_status", com.bytedance.sdk.component.panglearmor.hf.xj.xj().kd());
                        int[][] xj4 = w.xj(xj3, y, c);
                        jSONObject.put("ax", Arrays.toString(xj4[0]));
                        jSONObject.put("ay", Arrays.toString(xj4[1]));
                        jSONObject.put("az", Arrays.toString(xj4[2]));
                        int[][] xj5 = w.xj(hf.xj().xj(10800000L), y, c);
                        jSONObject.put("ax3", Arrays.toString(xj5[0]));
                        jSONObject.put("ay3", Arrays.toString(xj5[1]));
                        jSONObject.put("az3", Arrays.toString(xj5[2]));
                        int[][] xj6 = w.xj(hf.xj().xj(21600000L), y, c);
                        jSONObject.put("ax6", Arrays.toString(xj6[0]));
                        jSONObject.put("ay6", Arrays.toString(xj6[1]));
                        jSONObject.put("az6", Arrays.toString(xj6[2]));
                        jSONObject.put("angleAvg", Arrays.toString(xj2));
                        jSONObject.put("timestamp", currentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (u.this.v != null) {
                        u.this.v.xj(jSONObject);
                    }
                    u.this.c();
                    u.this.e = false;
                }
            });
        } else {
            if (this.yo.get() > 3) {
                kd();
                c();
                this.e = false;
            }
        }
    }

    public synchronized boolean hf() {
        int i;
        int i2;
        boolean registerListener;
        boolean registerListener2;
        try {
            this.jk = 0;
            if (this.e) {
                return false;
            }
            if (this.am == null || this.qt == null) {
                this.jk |= this.am == null ? 2 : 0;
                int i3 = this.jk;
                if (this.qt == null) {
                    i = i3;
                    i2 = 16;
                } else {
                    i = i3;
                    i2 = 0;
                }
            } else {
                this.e = false;
                SensorManager sensorManager = (SensorManager) y.u().getApplicationContext().getSystemService("sensor");
                i2 = 1;
                if (sensorManager != null) {
                    try {
                        registerListener = sensorManager.registerListener(this, this.am, 1);
                        registerListener2 = sensorManager.registerListener(this, this.qt, 1);
                    } catch (Exception unused) {
                        i = this.jk;
                        i2 = 32;
                    }
                    if (registerListener && registerListener2) {
                        this.e = true;
                        this.hf = false;
                        return this.e;
                    }
                    this.jk |= 32;
                    kd();
                    c();
                    return this.e;
                }
                i = this.jk;
            }
            this.jk = i | i2;
            return this.e;
        } catch (Throwable th) {
            throw th;
        }
    }

    public long u() {
        return this.zg;
    }

    public boolean w() {
        return this.e;
    }

    public static u xj() {
        if (xj == null) {
            synchronized (u.class) {
                try {
                    if (xj == null) {
                        xj = new u();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(xj xjVar) {
        this.v = xjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(float[] fArr) {
        this.zg = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(t.TAG, u());
            jSONObject.put("val", new JSONArray(fArr));
            hf.xj().xj(jSONObject, "sp_angle");
            hf.xj().xj(am.w(y.u()));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
