package com.sigmob.sdk.base.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.models.SensorEntity;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    public static String f13110a = "am";
    private static ag b;

    /* renamed from: com.sigmob.sdk.base.common.am$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13111a;

        static {
            int[] iArr = new int[c.values().length];
            f13111a = iArr;
            try {
                iArr[c.SLOPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13111a[c.SWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13111a[c.WRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class a implements SensorEventListener {
        static int[] e = {25, 60, 50, 45, 35, 25, 20, 15, 10, 5, 1};
        static float[] f = {4.0f, 10.0f, 8.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.8f, 1.5f, 1.0f};
        static int[] g = {15, 15, 13, 11, 10, 8, 6, 4, 3, 2, 1};
        static float[] h = {35.0f, 35.0f, 30.0f, 25.0f, 20.0f, 15.0f, 12.0f, 8.0f, 5.0f, 2.0f, 1.0f};
        private static float o = 40.0f;
        private boolean A;
        private float B;
        private long D;
        private Integer E;
        private boolean F;
        private boolean G;
        private Timer H;
        public int b;
        public int c;
        public int d;
        Float k;
        private SensorEvent l;
        private SensorEvent m;
        private SensorEvent n;
        private b p;
        private float q;
        private float r;
        private float s;
        private long t;
        private boolean u;
        private final c v;
        private long w;
        private float x;
        private float y;
        private float z;

        /* renamed from: a, reason: collision with root package name */
        protected int f13112a = 0;
        float[] i = new float[9];
        float[] j = new float[3];
        private int C = 100;
        private final long I = -1;
        private long J = -1;

        public a(Context context, b bVar, c cVar) {
            if (am.b == null && com.sigmob.sdk.base.utils.q.b(context)) {
                ag unused = am.b = ag.a(context);
            }
            this.p = bVar;
            this.v = cVar;
        }

        private void d() {
            SigmobLogger.d(am.f13110a, "cancelTimer", new Object[0]);
            Timer timer = this.H;
            if (timer == null) {
                return;
            }
            timer.cancel();
            this.H = null;
        }

        public void b() {
            if (am.b != null) {
                am.b.b(this);
            }
            this.y = 0.0f;
            this.z = 0.0f;
            this.x = 0.0f;
            this.w = 0L;
            this.q = 0.0f;
            this.r = 0.0f;
            this.s = 0.0f;
            this.B = 0.0f;
            this.D = 0L;
            this.k = null;
        }

        public void c() {
            b();
            d();
            this.p = null;
        }

        public void e(int i) {
            this.c = i;
        }

        public void f(int i) {
            this.d = i;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            SigmobLogger.d(am.f13110a, "onAccuracyChanged: sensor = " + sensor.toString() + ", i = " + i, new Object[0]);
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x027b  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x02b2  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x02c5  */
        /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:116:0x027e  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x038f  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x039f  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x03af  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x03c4  */
        /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSensorChanged(android.hardware.SensorEvent r25) {
            /*
                Method dump skipped, instructions count: 1113
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.am.a.onSensorChanged(android.hardware.SensorEvent):void");
        }

        private boolean e() {
            long j = this.J;
            boolean z = j == -1 || j >= ((long) this.c);
            boolean z2 = System.currentTimeMillis() - this.D >= 2000;
            boolean z3 = z && z2;
            SigmobLogger.d(am.f13110a, "overWidgetIntervalTime: type = " + this.v.name() + ", foregroundDuration = " + this.J + ", widgetIntervalTime = " + this.c + ", canProceedToJump = " + z + ", isIntervalMet = " + z2 + ", result = " + z3, new Object[0]);
            return z3;
        }

        public void b(int i) {
            this.E = Integer.valueOf(i);
        }

        public void c(int i) {
            this.f13112a = i;
        }

        public void d(int i) {
            this.b = i;
        }

        public void a() {
            if (am.b != null) {
                am.b.b(this);
                am.b.a(this);
            }
            this.k = null;
        }

        public void a(int i) {
            if (i > 0) {
                this.C = i;
            }
        }

        private void a(SensorEvent sensorEvent, SensorEvent sensorEvent2) {
            float f2;
            int intValue;
            if (sensorEvent == null || sensorEvent2 == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[2];
            float[] fArr2 = sensorEvent2.values;
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            float f8 = fArr2[2];
            if (this.u) {
                f2 = f4;
                r15 = this.w > 0 ? Math.toDegrees((((sensorEvent2.timestamp - this.w) * 1.0f) / 1.0E9f) * ((float) Math.sqrt(Math.pow(f8, 2.0d) + Math.pow(f7, 2.0d) + Math.pow(f6, 2.0d)))) : 0.0d;
                this.w = sensorEvent2.timestamp;
            } else {
                f2 = f4;
                this.w = 0L;
            }
            double d = r15;
            float sqrt = (float) Math.sqrt(Math.pow(f5, 2.0d) + Math.pow(f2, 2.0d) + Math.pow(f3, 2.0d));
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.t;
            if (Math.abs(this.q) < Math.abs(f3)) {
                this.q = f3;
            }
            if (Math.abs(this.r) < Math.abs(f2)) {
                this.r = f2;
            }
            if (Math.abs(this.s) < Math.abs(f5)) {
                this.s = f5;
            }
            Integer num = this.E;
            if (num == null) {
                int i = this.f13112a;
                if (i <= 0 || i > 10) {
                    this.f13112a = 1;
                }
                intValue = g[this.f13112a];
            } else {
                intValue = num.intValue();
            }
            o = intValue;
            if (sqrt <= 0.1d) {
                this.t = System.currentTimeMillis();
                return;
            }
            float f9 = h[this.f13112a];
            boolean z = sqrt > o;
            if (!this.u) {
                this.u = true;
                this.t = currentTimeMillis;
                SigmobLogger.d(am.f13110a, "handleAccelerometerData(start): acceleration = " + sqrt, new Object[0]);
                if (com.sigmob.sdk.base.utils.q.b(this.p)) {
                    this.p.a();
                    return;
                }
                return;
            }
            if (d > f9 && z) {
                if (f8 >= 0.0f) {
                    this.F = true;
                } else {
                    this.G = true;
                }
                SigmobLogger.d(am.f13110a, "handleAccelerometerData: currentRotationAngle = " + d + ", rotationAngleValue = " + f9 + ", shakeLeftOver = " + this.F + ", shakeRightOver = " + this.G, new Object[0]);
            }
            if (com.sigmob.sdk.base.utils.q.b(Boolean.valueOf(e()))) {
                return;
            }
            int i2 = this.b;
            if (i2 != 1 || !this.F || !this.G) {
                if (i2 != 0) {
                    return;
                }
                if (!this.F && !this.G) {
                    return;
                }
            }
            if (!z || j < this.d) {
                return;
            }
            this.u = false;
            SigmobLogger.d(am.f13110a, "handleAccelerometerData(end): acceleration = " + sqrt + ", sensitivity = " + o + ", currentDuration = " + j + ", shakeTriggerType = " + this.b + ", shakeTimeThreshold = " + this.d, new Object[0]);
            SigmobLog.d("handleAccelerometerData: shake end");
            this.q = 0.0f;
            this.r = 0.0f;
            this.s = 0.0f;
            this.F = false;
            this.G = false;
            HashMap hashMap = new HashMap();
            hashMap.put("x_max_acc", Float.valueOf(this.q * ((float) this.C)));
            hashMap.put("y_max_acc", Float.valueOf(this.r * ((float) this.C)));
            hashMap.put("z_max_acc", Float.valueOf(this.s * ((float) this.C)));
            a(hashMap);
        }

        public void a(SensorEntity sensorEntity) {
            this.f13112a = sensorEntity == null ? 0 : sensorEntity.level;
            this.b = sensorEntity == null ? 0 : sensorEntity.shakeTriggerType;
            this.c = sensorEntity == null ? 0 : sensorEntity.widgetIntervalTime;
            this.d = sensorEntity != null ? sensorEntity.shakeTimeThreshold : 0;
        }

        private void a(Map<String, Number> map) {
            SigmobLogger.d(am.f13110a, "interactionCompleted: type = " + this.v.name() + ", foregroundDuration = " + this.J + ", widgetIntervalTime = " + this.c, new Object[0]);
            if (this.p == null || map == null) {
                return;
            }
            SigmobLogger.d(am.f13110a, "interactionCompleted: map = " + map, new Object[0]);
            this.p.a(map);
            this.J = 0L;
            d();
            if (this.c <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.H = timer;
            timer.schedule(new TimerTask() { // from class: com.sigmob.sdk.base.common.am.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    boolean c = com.sigmob.sdk.manager.a.c();
                    if (c) {
                        a.this.J += 1000;
                    }
                    SigmobLogger.d(am.f13110a, "interactionCompleted#run: foreground = " + c + ", foregroundDuration = " + a.this.J, new Object[0]);
                }
            }, 2000L, 1000L);
        }
    }

    public interface b {
        void a();

        void a(float f);

        void a(Map<String, Number> map);
    }

    public enum c {
        SWING,
        WRING,
        SLOPE,
        SHAKE;

        static {
            yepx();
        }

        private static /* synthetic */ void yepx() {
            char[] charArray = "48:y06:2y58.y$?2;;y\u001d9>\u0015%>302".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'W');
            }
            String str = new String(charArray);
            char[] charArray2 = "4;>9>#".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'W');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }
}
