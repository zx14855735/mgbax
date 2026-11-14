package LNKngO;

import KpHwm4.AZkASS;
import KpHwm4.AaHO0E;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.game.boy.emu.gba.Console;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements SensorEventListener, A2egSU, A5SV6n, AZkASS {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AaHO0E f4792AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Console f4793AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final SensorManager f4794AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Sensor f4795AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f4796B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public float f4797B2KMhB = 80.0f;

    public A4TApA(SensorManager sensorManager, AaHO0E aaHO0E) {
        this.f4794AmA8tU = sensorManager;
        this.f4795AzWtSf = sensorManager.getDefaultSensor(4);
        this.f4792AcNBzu = aaHO0E;
        aaHO0E.f4295A4TApA = this;
        this.f4793AlLFFp = aaHO0E.f4307AzWtSf.f11100A2egSU;
    }

    @Override // LNKngO.A5SV6n
    public final void a(int i) {
        this.f4797B2KMhB = (i * 10) + 30;
    }

    @Override // KpHwm4.AZkASS
    public final void b() {
        this.f4794AmA8tU.unregisterListener(this);
    }

    @Override // LNKngO.A2egSU
    public final void c() {
        b();
        this.f4792AcNBzu.f4295A4TApA = null;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = -((int) (sensorEvent.values[2] * this.f4797B2KMhB));
        if (i > 2047) {
            i = 2047;
        }
        if (i < -2048) {
            i = -2048;
        }
        if (this.f4796B25kr6 != i) {
            this.f4796B25kr6 = i;
            this.f4793AlLFFp.setGyroValue(i);
        }
    }

    @Override // KpHwm4.AZkASS
    public final void a() {
        this.f4794AmA8tU.registerListener(this, this.f4795AzWtSf, 1);
    }
}
