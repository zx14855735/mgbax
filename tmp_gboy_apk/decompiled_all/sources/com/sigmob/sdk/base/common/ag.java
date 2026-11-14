package com.sigmob.sdk.base.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ag implements SensorEventListener {
    private static final String c = "SensorManagerHelper";
    private static volatile ag d;

    /* renamed from: a, reason: collision with root package name */
    public final Set<SensorEventListener> f13104a = new CopyOnWriteArraySet();
    public boolean b = false;
    private final SensorManager e;

    private ag(Context context) {
        this.e = (SensorManager) context.getSystemService("sensor");
    }

    public static ag a(Context context) {
        if (d == null) {
            synchronized (ag.class) {
                try {
                    if (d == null) {
                        d = new ag(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return d;
    }

    private void b() {
        if (this.b || this.f13104a.isEmpty()) {
            return;
        }
        this.e.unregisterListener(this);
        try {
            com.sigmob.sdk.base.utils.i.c(c, "startListeningIfNeeded: registeredSensors = " + a(new int[]{4, 1, 10, 2}), new Object[0]);
            this.b = true;
        } catch (Exception unused) {
        }
    }

    private void c() {
        if (this.b && this.f13104a.isEmpty()) {
            this.e.unregisterListener(this);
            this.b = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Iterator<SensorEventListener> it = this.f13104a.iterator();
        while (it.hasNext()) {
            it.next().onAccuracyChanged(sensor, i);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Iterator<SensorEventListener> it = this.f13104a.iterator();
        while (it.hasNext()) {
            it.next().onSensorChanged(sensorEvent);
        }
    }

    private List<Integer> a(int[] iArr) {
        if (this.e == null || iArr == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            Sensor defaultSensor = this.e.getDefaultSensor(i);
            if (defaultSensor != null) {
                this.e.registerListener(this, defaultSensor, 3);
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public void b(SensorEventListener sensorEventListener) {
        if (this.f13104a.remove(sensorEventListener)) {
            c();
        }
    }

    public void a() {
        if (this.b) {
            this.e.unregisterListener(this);
            this.b = false;
        }
        this.f13104a.clear();
        d = null;
    }

    public void a(SensorEventListener sensorEventListener) {
        if (this.f13104a.add(sensorEventListener)) {
            b();
        }
    }
}
