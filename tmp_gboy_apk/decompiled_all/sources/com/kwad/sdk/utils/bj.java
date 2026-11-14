package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.utils.bi;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bj implements SensorEventListener {
    private boolean bfA;
    private boolean bfB;
    private final bi.b bfC;
    private final b bfx;
    private final b bfy;
    private final b bfz;

    public static class a {
        private static final bj bfE = new bj(0);

        static {
            nVcv();
        }

        private static /* synthetic */ void nVcv() {
            char[] charArray = "¦ª¨ë¢¤¨ ë§ª¼ë¶\u00ad ©©ë\u008f«¬\u0087·¬¡¢ ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 197);
            }
            String str = new String(charArray);
            char[] charArray2 = "¦©¬«¬±".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 197);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class b {
        private SensorEvent bfF;
        private long timestamp;

        private b() {
        }

        public final void U(List<com.kwad.sdk.l.a.e> list) {
            if (this.bfF == null) {
                return;
            }
            com.kwad.sdk.l.a.e eVar = new com.kwad.sdk.l.a.e();
            eVar.sensorType = this.bfF.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f : this.bfF.values) {
                eVar.bbN.add(Float.valueOf(f));
            }
            list.add(eVar);
        }

        public final void b(SensorEvent sensorEvent) {
            this.bfF = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public /* synthetic */ bj(byte b2) {
        this();
    }

    public static bj Tp() {
        return a.bfE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Tr() {
        if (this.bfB) {
            bi.To().a(this);
            this.bfB = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void register() {
        if (!this.bfA && !this.bfB) {
            this.bfB = true;
            try {
                bi.To().a(3, 3, this, this.bfC);
                bi.To().a(2, 3, this, this.bfC);
                bi.To().a(4, 3, this, this.bfC);
            } catch (Throwable unused) {
                this.bfA = true;
            }
        }
    }

    public final synchronized List<com.kwad.sdk.l.a.e> Tq() {
        try {
            if (!s.RK()) {
                return null;
            }
            com.kwad.sdk.core.c.b.Ji();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                register();
            }
            ArrayList arrayList = new ArrayList();
            this.bfx.U(arrayList);
            this.bfy.U(arrayList);
            this.bfz.U(arrayList);
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.bfx.b(sensorEvent);
        } else if (type == 4) {
            this.bfy.b(sensorEvent);
        } else {
            if (type != 9) {
                return;
            }
            this.bfz.b(sensorEvent);
        }
    }

    private bj() {
        byte b2 = 0;
        this.bfx = new b(b2);
        this.bfy = new b(b2);
        this.bfz = new b(b2);
        this.bfA = false;
        this.bfC = new bi.b() { // from class: com.kwad.sdk.utils.bj.2
            @Override // com.kwad.sdk.utils.bi.b
            public final void onFailed() {
                bj.a(bj.this, true);
            }
        };
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bj.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bj.this.Tr();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (s.RK()) {
                    bj.this.register();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(bj bjVar, boolean z) {
        bjVar.bfA = true;
        return true;
    }
}
