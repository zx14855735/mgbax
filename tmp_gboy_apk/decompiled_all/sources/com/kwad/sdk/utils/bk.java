package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bykv.vk.component.ttvideo.player.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class bk {
    private static bk bfG;
    private SensorManager bfH;

    public static bk Tt() {
        if (bfG == null) {
            synchronized (bk.class) {
                try {
                    if (bfG == null) {
                        bfG = new bk();
                    }
                } finally {
                }
            }
        }
        return bfG;
    }

    private static boolean Tu() {
        return !bc.useSensorManagerDisable();
    }

    private boolean Tv() {
        boolean Tu = Tu();
        A2egSU.B9tovu("checkEnableSensor enable:", "SensorManagerWrapper", Tu);
        if (Tu) {
            return true;
        }
        this.bfH = null;
        return false;
    }

    private SensorManager dY(Context context) {
        if (this.bfH == null) {
            this.bfH = (SensorManager) context.getSystemService("sensor");
        }
        return this.bfH;
    }

    public final SensorManager checkAndObtainSensorManager(Context context) {
        if (Tv()) {
            return dY(context);
        }
        return null;
    }

    public final Sensor getDefaultSensor(Context context, int i) {
        com.kwad.components.ad.reward.A2egSU.A4TApA(i, "getDefaultSensor type:", "SensorManagerWrapper");
        if (Tv()) {
            return dY(context).getDefaultSensor(i);
        }
        return null;
    }

    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "registerListener sensor:" + sensor + ", listener: " + sensorEventListener);
        if (!Tv()) {
            return false;
        }
        try {
            return dY(context).registerListener(sensorEventListener, sensor, i);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void unregisterListener(SensorEventListener sensorEventListener) {
        SensorManager sensorManager;
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "unregisterListener listener:" + sensorEventListener);
        if (Tv() && (sensorManager = this.bfH) != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }
}
