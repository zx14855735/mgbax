package com.octopus.ad.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.view.View;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.model.c;
import com.octopus.ad.widget.ShakeView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static volatile long f12712a;
    private static SensorManager b;
    private View A;
    private float B;
    private Context c;
    private double d;
    private double e;
    private double f;
    private int g;
    private int h;
    private int k;
    private ShakeView m;
    private a n;
    private View z;
    private int i = 0;
    private int j = 0;
    private int l = 0;
    private boolean o = false;
    private String p = "50%";
    private String q = "60%";
    private String r = "140";
    private String s = "140";
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private final float[] C = new float[3];
    private int D = 2;
    private final SensorEventListener E = new SensorEventListener() { // from class: com.octopus.ad.utils.l.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0166  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSensorChanged(android.hardware.SensorEvent r23) {
            /*
                Method dump skipped, instructions count: 607
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.utils.l.AnonymousClass1.onSensorChanged(android.hardware.SensorEvent):void");
        }
    };

    public interface a {
        void a(com.octopus.ad.model.d dVar);
    }

    public l(Context context) {
        this.c = context;
        b = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        f();
    }

    public static /* synthetic */ int d(l lVar) {
        int i = lVar.i;
        lVar.i = i + 1;
        return i;
    }

    public static /* synthetic */ int i(l lVar) {
        int i = lVar.j;
        lVar.j = i + 1;
        return i;
    }

    public float a(float f, float f2) {
        return (f != f2 || f > 15.0f) ? f : (15.0f + f) - ((int) f);
    }

    private void g() {
        SensorManager sensorManager = b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.E);
        }
    }

    private void h() {
        ShakeView shakeView = this.m;
        if (shakeView != null) {
            shakeView.b();
            ViewUtil.removeChildFromParent(this.m);
            this.m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        Context context;
        View view = this.z;
        int width = view != null ? view.getWidth() : 0;
        return (width > 0 || (context = this.c) == null) ? width : ViewUtil.getScreenWidth(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        Context context;
        View view = this.z;
        int height = view != null ? view.getHeight() : 0;
        return (height > 0 || (context = this.c) == null) ? height : ViewUtil.getScreenHeight(context);
    }

    private void f() {
        a(1.5d);
        b(1.5d);
        c(35.0d);
        c(2);
        a(1);
    }

    public void c(double d) {
        this.f = d;
    }

    public void b(double d) {
        this.e = d;
    }

    public void c(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.k = i;
    }

    public void c() {
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.o = false;
        this.i = 0;
        this.j = 0;
        this.l = 0;
        this.n = null;
        this.c = null;
        this.m = null;
        this.A = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(float f, float f2, float f3, double d) {
        return Math.sqrt(Math.pow(((double) f3) / 9.8d, 2.0d) + (Math.pow(((double) f2) / 9.8d, 2.0d) + Math.pow(((double) f) / 9.8d, 2.0d))) > d;
    }

    public void b() {
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.o = false;
        this.i = 0;
        this.j = 0;
        this.l = 0;
    }

    public void a(String str, String str2, String str3, String str4) {
        this.p = str;
        this.q = str2;
        this.r = str3;
        this.s = str4;
    }

    public void a(c.u uVar) {
        if (uVar == null) {
            return;
        }
        a(uVar.d());
        b(uVar.d());
        c(uVar.f());
        c(uVar.c());
        b(uVar.h());
        a(1);
    }

    public void a(double d) {
        this.d = d;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f, float f2, float f3, double d) {
        return Math.sqrt(Math.pow(((double) f3) / 9.8d, 2.0d) + (Math.pow(((double) f2) / 9.8d, 2.0d) + Math.pow(((double) f) / 9.8d, 2.0d))) > d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double a(float f, float f2, float f3) {
        return Math.sqrt(Math.pow(f3, 2.0d) + Math.pow(f2, 2.0d) + Math.pow(f, 2.0d));
    }

    public void a(com.octopus.ad.model.d dVar) {
        View view = this.A;
        if (view == null || !view.isShown()) {
            b();
            return;
        }
        if (System.currentTimeMillis() - f12712a > 1000) {
            StringBuilder sb = new StringBuilder("enter callBackShakeHappened and mShakeStateListener != null ? ");
            sb.append(this.n != null);
            sb.append(",!isCallBack = ");
            sb.append(!this.o);
            com.octopus.ad.utils.b.f.a("OctopusAd", sb.toString());
            if (this.n == null || this.o) {
                return;
            }
            com.octopus.ad.utils.b.f.a("OctopusAd", "callback onShakeHappened()");
            this.n.a(dVar);
            this.o = true;
            int i = this.D;
            if (i == 1) {
                g();
                c();
            } else if (i == 2) {
                a();
            } else if (i == 3) {
                a(2000L);
            }
            f12712a = System.currentTimeMillis();
            return;
        }
        b();
    }

    public void a(View view) {
        try {
            this.A = view;
            SensorManager sensorManager = b;
            if (sensorManager != null) {
                sensorManager.registerListener(this.E, sensorManager.getDefaultSensor(1), 2);
                SensorManager sensorManager2 = b;
                sensorManager2.registerListener(this.E, sensorManager2.getDefaultSensor(4), 2);
            }
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a() {
        com.octopus.ad.utils.b.f.a("OctopusAd", "enter unRegisterShakeListenerAndSetDefault");
        h();
        g();
        c();
    }

    private void a(long j) {
        new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.utils.l.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.b();
                } catch (Exception e) {
                    com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        }, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View a(android.view.View r19, android.view.View r20, float r21, java.lang.String r22, com.octopus.ad.internal.p r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.utils.l.a(android.view.View, android.view.View, float, java.lang.String, com.octopus.ad.internal.p, boolean):android.view.View");
    }
}
