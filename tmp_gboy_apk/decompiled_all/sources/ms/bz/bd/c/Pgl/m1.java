package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class m1 implements SensorEventListener {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static volatile m1 f14022B2KMhB;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final SensorManager f14023AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f14024AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f14025AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public float[] f14026AzWtSf = new float[3];

    /* renamed from: B25kr6, reason: collision with root package name */
    public ArrayList f14027B25kr6 = new ArrayList();

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28ecfe", new byte[]{115, 116, 70}));
        f14022B2KMhB = null;
    }

    public m1(Context context) {
        this.f14023AcNBzu = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f14023AcNBzu = (SensorManager) applicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "79826e", new byte[]{com.sigmob.sdk.archives.tar.e.M, 62, 69, 85, 6, 96}));
        }
    }

    public static m1 A5SV6n(Context context) {
        if (f14022B2KMhB == null) {
            synchronized (m1.class) {
                try {
                    if (f14022B2KMhB == null) {
                        f14022B2KMhB = new m1(context);
                    }
                } finally {
                }
            }
        }
        return f14022B2KMhB;
    }

    public final synchronized void A2egSU() {
        try {
            SensorManager sensorManager = this.f14023AcNBzu;
            if (sensorManager != null) {
                int i = this.f14024AlLFFp - 1;
                this.f14024AlLFFp = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2ba200", new byte[]{com.sigmob.sdk.archives.tar.e.H, 115, 17, 121, 26});
        }
    }

    public final synchronized void A4TApA() {
        try {
            SensorManager sensorManager = this.f14023AcNBzu;
            if (sensorManager != null) {
                if (this.f14024AlLFFp == 0) {
                    if (!this.f14023AcNBzu.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f14024AlLFFp++;
            }
        } catch (Exception unused) {
        }
    }

    public final JSONArray ADYaiT() {
        try {
            if (pble.A4TApA() == null) {
                return null;
            }
            A4TApA();
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.f14025AmA8tU == 0 && i < 10) {
                        try {
                            i++;
                            wait(1000L);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return new JSONArray();
            } catch (Exception unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d1d471", new byte[]{102, 32, 20, Byte.MAX_VALUE, 15});
                return new JSONArray();
            } finally {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.f14026AzWtSf[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.f14026AzWtSf[1]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.f14026AzWtSf[2]).setScale(2, 4));
                A2egSU();
                this.f14025AmA8tU = 0;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.f14026AzWtSf = sensorEvent.values;
        this.f14025AmA8tU = 1;
    }
}
