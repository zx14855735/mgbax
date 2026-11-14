package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pz implements SensorEventListener {
    private static volatile pz xj;
    private final SensorManager hf;
    private volatile Sensor kd;
    private volatile Sensor u;
    private volatile Sensor w;
    private volatile Sensor y;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicBoolean tf = new AtomicBoolean(false);
    private final Map<SensorEventListener, Object> p = new ConcurrentHashMap();

    private pz(Context context) {
        this.hf = (SensorManager) context.getSystemService("sensor");
    }

    private Sensor hf() {
        if (this.w == null) {
            synchronized (pz.class) {
                try {
                    if (this.w == null) {
                        this.w = this.hf.getDefaultSensor(1);
                    }
                } finally {
                }
            }
        }
        return this.w;
    }

    private Sensor kd() {
        if (this.y == null) {
            synchronized (pz.class) {
                try {
                    if (this.y == null) {
                        this.y = this.hf.getDefaultSensor(10);
                    }
                } finally {
                }
            }
        }
        return this.y;
    }

    private Sensor u() {
        if (this.kd == null) {
            synchronized (pz.class) {
                try {
                    if (this.kd == null) {
                        this.kd = this.hf.getDefaultSensor(4);
                    }
                } finally {
                }
            }
        }
        return this.kd;
    }

    private Sensor w() {
        if (this.u == null) {
            synchronized (pz.class) {
                try {
                    if (this.u == null) {
                        this.u = this.hf.getDefaultSensor(15);
                    }
                } finally {
                }
            }
        }
        return this.u;
    }

    public static pz xj(Context context) {
        if (xj == null) {
            synchronized (pz.class) {
                try {
                    if (xj == null) {
                        xj = new pz(context);
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorEventListener key;
        for (Map.Entry<SensorEventListener, Object> entry : this.p.entrySet()) {
            if (entry != null && (key = entry.getKey()) != null) {
                key.onSensorChanged(sensorEvent);
            }
        }
    }

    public Sensor xj(int i) {
        if (i == 1) {
            return hf();
        }
        if (i == 4) {
            return u();
        }
        if (i == 10) {
            return kd();
        }
        if (i != 15) {
            return null;
        }
        return w();
    }

    public boolean xj(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        this.p.put(sensorEventListener, 0);
        if (sensor == this.w) {
            if (!this.c.getAndSet(true)) {
                return this.hf.registerListener(this, sensor, i);
            }
        } else if (sensor == this.u) {
            if (!this.f.getAndSet(true)) {
                return this.hf.registerListener(this, sensor, i);
            }
        } else if (sensor == this.kd) {
            if (!this.d.getAndSet(true)) {
                return this.hf.registerListener(this, sensor, i);
            }
        } else if (sensor == this.y && !this.tf.getAndSet(true)) {
            return this.hf.registerListener(this, sensor, i);
        }
        return true;
    }

    public void xj(SensorEventListener sensorEventListener) {
        this.p.remove(sensorEventListener);
        pl.xj("TMe", "--==---- unreg shake size: " + this.p.size());
        if (this.p.isEmpty()) {
            try {
                this.hf.unregisterListener(this);
            } catch (Throwable th) {
                pl.xj(th);
            }
            this.c.set(false);
            this.f.set(false);
            this.d.set(false);
            this.tf.set(false);
        }
    }

    public int xj() {
        return this.p.size();
    }
}
