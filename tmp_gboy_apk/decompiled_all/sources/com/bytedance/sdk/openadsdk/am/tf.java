package com.bytedance.sdk.openadsdk.am;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf {
    public static xj xj;
    private static SensorManager y;
    protected static final float[] hf = new float[3];
    protected static final float[] w = new float[3];
    protected static final float[] u = new float[9];
    protected static final float[] kd = new float[3];

    static {
        OksKiF();
    }

    private static /* synthetic */ void OksKiF() {
        char[] charArray = "w{y:suyq:v{m:g|qxx:^z}Vf}psq".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 20);
        }
        String str = new String(charArray);
        char[] charArray2 = "wx}z}`".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 20);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (xj()) {
                return;
            }
            xj xjVar = xj;
            if (xjVar == null || !xjVar.w()) {
                SensorManager xj2 = xj(context);
                xj2.registerListener(sensorEventListener, xj2.getDefaultSensor(4), xj(i));
            }
        } catch (Throwable th) {
            c.xj("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void u(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (xj()) {
                return;
            }
            xj xjVar = xj;
            if (xjVar == null || !xjVar.w()) {
                SensorManager xj2 = xj(context);
                xj2.registerListener(sensorEventListener, xj2.getDefaultSensor(1), xj(i));
                xj2.registerListener(sensorEventListener, xj2.getDefaultSensor(2), xj(i));
            }
        } catch (Throwable th) {
            c.xj("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void w(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (xj()) {
                return;
            }
            xj xjVar = xj;
            if (xjVar == null || !xjVar.w()) {
                SensorManager xj2 = xj(context);
                xj2.registerListener(sensorEventListener, xj2.getDefaultSensor(10), xj(i));
            }
        } catch (Throwable th) {
            c.xj("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    private static int xj(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    public static void xj(xj xjVar) {
        xj = xjVar;
    }

    private static SensorManager xj(Context context) {
        if (y == null) {
            synchronized (tf.class) {
                try {
                    if (y == null) {
                        y = (SensorManager) context.getSystemService("sensor");
                    }
                } finally {
                }
            }
        }
        return y;
    }

    private static boolean xj() {
        xj xjVar = xj;
        return xjVar == null || !xjVar.hf();
    }

    public static void xj(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (xj()) {
                return;
            }
            xj xjVar = xj;
            if (xjVar == null || !xjVar.w()) {
                SensorManager xj2 = xj(context);
                xj2.registerListener(sensorEventListener, xj2.getDefaultSensor(1), xj(i));
            }
        } catch (Throwable th) {
            c.xj("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void xj(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            xj(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            c.xj("SensorHub", "stopListen error", th);
        }
    }

    public static void xj(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }
}
