package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bi;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private com.kwad.sdk.core.g.a aNR;
    private a aNS;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean aNM = true;
    private long aNN = 0;
    private double aNO = 9.999999717180685E-10d;
    private double[] aNP = {0.0d, 0.0d, 0.0d};
    private double[] aNQ = {0.0d, 0.0d, 0.0d};
    private final bi.b aNT = new bi.b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.bi.b
        public final void onFailed() {
            if (c.this.aNR != null) {
                c.this.aNR.cd();
            }
        }
    };

    public class a implements SensorEventListener {
        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (c.this.aNN != 0) {
                double d = c.this.aNO * (sensorEvent.timestamp - c.this.aNN);
                double[] dArr = c.this.aNQ;
                dArr[0] = Math.toDegrees(f * d) + dArr[0];
                double[] dArr2 = c.this.aNQ;
                dArr2[1] = Math.toDegrees(f2 * d) + dArr2[1];
                double[] dArr3 = c.this.aNQ;
                dArr3[2] = Math.toDegrees(f3 * d) + dArr3[2];
                c.this.KU();
                c.this.KV();
            }
            c.this.aNN = sensorEvent.timestamp;
        }

        public /* synthetic */ a(c cVar, byte b) {
            this();
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private void KS() {
        Arrays.fill(this.aNP, 0.0d);
        Arrays.fill(this.aNQ, 0.0d);
        this.aNN = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        if (this.aNM) {
            if (Math.abs(this.aNQ[0]) > Math.abs(this.aNP[0])) {
                this.aNP[0] = this.aNQ[0];
            }
            if (Math.abs(this.aNQ[1]) > Math.abs(this.aNP[1])) {
                this.aNP[1] = this.aNQ[1];
            }
            if (Math.abs(this.aNQ[2]) > Math.abs(this.aNP[2])) {
                this.aNP[2] = this.aNQ[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.aNM || (rotateInfo = this.rotateInfo) == null || this.aNR == null) {
            return;
        }
        if (!a(0, r0.rotateDegree, rotateInfo.x.direction)) {
            if (!a(1, r0.rotateDegree, this.rotateInfo.y.direction)) {
                if (!a(2, r0.rotateDegree, this.rotateInfo.z.direction)) {
                    return;
                }
            }
        }
        this.aNM = false;
        this.aNR.r(KW());
    }

    private String KW() {
        return "{\"x\": " + this.aNP[0] + ",\"y\":" + this.aNP[1] + ",\"z\":" + this.aNP[2] + "}";
    }

    public final synchronized void KT() {
        KS();
        this.aNM = true;
    }

    public final void bP(Context context) {
        if (context == null) {
            return;
        }
        KS();
        this.aNM = true;
        if (this.aNS == null) {
            this.aNS = new a(this, (byte) 0);
        }
        bi.To().a(2, 2, this.aNS, this.aNT);
    }

    public final synchronized void bQ(Context context) {
        if (context != null) {
            if (this.aNS != null) {
                bi.To().a(this.aNS);
                this.aNS = null;
            }
        }
    }

    public final void b(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(com.kwad.sdk.core.g.a aVar) {
        this.aNR = aVar;
    }

    private boolean a(int i, double d, int i2) {
        if (d <= 0.0d || Math.abs(this.aNQ[i]) < d) {
            return false;
        }
        double d2 = this.aNQ[i];
        return (d2 <= 0.0d || i2 != 1) && (d2 >= 0.0d || i2 != 2);
    }
}
