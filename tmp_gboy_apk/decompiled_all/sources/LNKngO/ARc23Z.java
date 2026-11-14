package LNKngO;

import KpHwm4.AZkASS;
import KpHwm4.AaHO0E;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;
import com.game.boy.emu.gba.Console;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z implements SensorEventListener, A2egSU, A5SV6n, AZkASS {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AaHO0E f4810AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Console f4811AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final SensorManager f4812AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Sensor f4813AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Display f4814B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public float f4815B2KMhB = 20.0f;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f4816B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f4817B4ZgIw;

    public ARc23Z(SensorManager sensorManager, WindowManager windowManager, AaHO0E aaHO0E) {
        this.f4812AmA8tU = sensorManager;
        this.f4813AzWtSf = sensorManager.getDefaultSensor(1);
        this.f4814B25kr6 = windowManager.getDefaultDisplay();
        this.f4810AcNBzu = aaHO0E;
        aaHO0E.f4295A4TApA = this;
        this.f4811AlLFFp = aaHO0E.f4307AzWtSf.f11100A2egSU;
    }

    @Override // LNKngO.A5SV6n
    public final void a(int i) {
        this.f4815B2KMhB = (i * 3) + 5;
    }

    @Override // KpHwm4.AZkASS
    public final void b() {
        this.f4812AmA8tU.unregisterListener(this);
    }

    @Override // LNKngO.A2egSU
    public final void c() {
        b();
        this.f4810AcNBzu.f4295A4TApA = null;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSensorChanged(android.hardware.SensorEvent r5) {
        /*
            r4 = this;
            android.view.Display r0 = r4.f4814B25kr6
            int r0 = r0.getRotation()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L27
            r3 = 2
            if (r0 == r3) goto L1f
            r3 = 3
            if (r0 == r3) goto L18
            float[] r5 = r5.values
            r0 = r5[r1]
            r5 = r5[r2]
        L16:
            float r5 = -r5
            goto L2f
        L18:
            float[] r5 = r5.values
            r0 = r5[r2]
            r5 = r5[r1]
            goto L2f
        L1f:
            float[] r5 = r5.values
            r0 = r5[r1]
            float r0 = -r0
            r5 = r5[r2]
            goto L2f
        L27:
            float[] r5 = r5.values
            r0 = r5[r2]
            float r0 = -r0
            r5 = r5[r1]
            goto L16
        L2f:
            float r1 = r4.f4815B2KMhB
            float r0 = r0 * r1
            int r0 = (int) r0
            r2 = -150(0xffffffffffffff6a, float:NaN)
            r3 = 150(0x96, float:2.1E-43)
            if (r0 <= r3) goto L3d
            r0 = 150(0x96, float:2.1E-43)
            goto L41
        L3d:
            if (r0 >= r2) goto L41
            r0 = -150(0xffffffffffffff6a, float:NaN)
        L41:
            float r1 = r1 * r5
            int r5 = (int) r1
            if (r5 <= r3) goto L49
            r2 = 150(0x96, float:2.1E-43)
            goto L4d
        L49:
            if (r5 >= r2) goto L4c
            goto L4d
        L4c:
            r2 = r5
        L4d:
            int r5 = r4.f4816B3GDIM
            if (r0 != r5) goto L57
            int r5 = r4.f4817B4ZgIw
            if (r2 == r5) goto L56
            goto L57
        L56:
            return
        L57:
            com.game.boy.emu.gba.Console r5 = r4.f4811AlLFFp
            r5.setTiltValue(r0, r2)
            r4.f4816B3GDIM = r0
            r4.f4817B4ZgIw = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: LNKngO.ARc23Z.onSensorChanged(android.hardware.SensorEvent):void");
    }

    @Override // KpHwm4.AZkASS
    public final void a() {
        this.f4817B4ZgIw = 0;
        this.f4816B3GDIM = 0;
        this.f4812AmA8tU.registerListener(this, this.f4813AzWtSf, 1);
    }
}
