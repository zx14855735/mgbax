package LQ734U;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements SensorEventListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AMqCpz f4830AcNBzu;

    public ADYaiT(AMqCpz aMqCpz) {
        this.f4830AcNBzu = aMqCpz;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSensorChanged(android.hardware.SensorEvent r9) {
        /*
            r8 = this;
            LQ734U.AMqCpz r0 = r8.f4830AcNBzu
            C4FrIb.AmA8tU r1 = r0.f4824AlLFFp
            if (r1 != 0) goto L7
            return
        L7:
            android.view.Display r1 = r0.f4835AmA8tU
            int r1 = r1.getOrientation()
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L2d
            if (r1 == r3) goto L25
            if (r1 == r2) goto L1e
            float[] r9 = r9.values
            r1 = r9[r3]
            float r1 = -r1
            r9 = r9[r4]
            goto L35
        L1e:
            float[] r9 = r9.values
            r1 = r9[r4]
            r9 = r9[r3]
            goto L35
        L25:
            float[] r9 = r9.values
            r1 = r9[r3]
            r9 = r9[r4]
        L2b:
            float r9 = -r9
            goto L35
        L2d:
            float[] r9 = r9.values
            r1 = r9[r4]
            float r1 = -r1
            r9 = r9[r3]
            goto L2b
        L35:
            float r5 = r0.f4837B25kr6
            float r6 = -r5
            r7 = 0
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 >= 0) goto L42
            int[] r1 = r0.f4838B2KMhB
            r7 = r1[r7]
            goto L4a
        L42:
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L4a
            int[] r1 = r0.f4838B2KMhB
            r7 = r1[r4]
        L4a:
            float r1 = -r5
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L55
            int[] r9 = r0.f4838B2KMhB
            r9 = r9[r2]
        L53:
            r7 = r7 | r9
            goto L5e
        L55:
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 <= 0) goto L5e
            int[] r9 = r0.f4838B2KMhB
            r9 = r9[r3]
            goto L53
        L5e:
            r0.A2egSU(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: LQ734U.ADYaiT.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
