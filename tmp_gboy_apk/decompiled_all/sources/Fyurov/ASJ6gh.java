package Fyurov;

import android.content.Context;
import android.hardware.SensorManager;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alliance.ssp.ad.bean.Shake;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public H3v3Sq.A2egSU f2916A2egSU = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public SensorManager f2917A4TApA = null;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public KCxDWD.A5SV6n f2918A5SV6n = null;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Shake f2919ADYaiT;
    public Double AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public Double f2920ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public Double f2921ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f2922AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final FrameLayout f2923AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Context f2924AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final ARc23Z f2925AaHO0E;

    public ASJ6gh(Context context, int i, int i2, Shake shake, ARc23Z aRc23Z) {
        this.f2924AZkASS = context;
        float f = i2;
        if (context == null) {
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        int i4 = (int) f;
        this.f2919ADYaiT = shake;
        this.f2925AaHO0E = aRc23Z;
        if (i == 1) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i4, i4));
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(2131231425);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ImageView imageView2 = new ImageView(context);
            double d = i4;
            int i5 = (int) (0.435d * d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i5);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) (d * 0.37d);
            imageView2.setLayoutParams(layoutParams);
            imageView2.setImageResource(2131231424);
            frameLayout.addView(imageView);
            frameLayout.addView(imageView2);
            this.f2923AZOQYO = frameLayout;
            A5SV6n(imageView2);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(i4, i4));
            ImageView imageView3 = new ImageView(context);
            double d2 = i4;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (0.746d * d2), (int) (0.259d * d2));
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = (int) (0.545d * d2);
            imageView3.setLayoutParams(layoutParams2);
            imageView3.setImageResource(2131231439);
            ImageView imageView4 = new ImageView(context);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (0.272d * d2), (int) (0.428d * d2));
            layoutParams3.gravity = 81;
            layoutParams3.bottomMargin = (int) (0.454d * d2);
            imageView4.setLayoutParams(layoutParams3);
            imageView4.setImageResource(2131231440);
            ImageView imageView5 = new ImageView(context);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i4, (int) (d2 * 0.337d));
            layoutParams4.gravity = 81;
            imageView5.setLayoutParams(layoutParams4);
            imageView5.setImageResource(2131231441);
            frameLayout2.addView(imageView3);
            frameLayout2.addView(imageView4);
            frameLayout2.addView(imageView5);
            this.f2923AZOQYO = frameLayout2;
            A5SV6n(imageView4);
            return;
        }
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(i4, i4));
        ImageView imageView6 = new ImageView(context);
        double d3 = i4;
        int i6 = (int) (0.435d * d3);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i6, i6);
        layoutParams5.gravity = 81;
        layoutParams5.bottomMargin = (int) (0.37d * d3);
        imageView6.setLayoutParams(layoutParams5);
        imageView6.setImageResource(2131231424);
        TextView textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 81;
        textView.setTextColor(-1);
        textView.setText("摇一摇");
        textView.setTextSize(12.0f);
        if (i4 <= 180) {
            textView.setTextSize(9.0f);
        } else if (i4 <= 240) {
            textView.setTextSize(10.0f);
        } else if (i4 <= 300) {
            textView.setTextSize(11.0f);
        }
        layoutParams6.bottomMargin = (int) (d3 * 0.12d);
        textView.setLayoutParams(layoutParams6);
        frameLayout3.addView(imageView6);
        frameLayout3.addView(textView);
        this.f2923AZOQYO = frameLayout3;
        A5SV6n(imageView6);
    }

    public static void A5SV6n(ImageView imageView) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 20.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setStartOffset(0L);
        RotateAnimation rotateAnimation2 = new RotateAnimation(20.0f, -20.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation2.setDuration(300L);
        rotateAnimation2.setStartOffset(150L);
        RotateAnimation rotateAnimation3 = new RotateAnimation(-20.0f, 20.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation3.setDuration(300L);
        rotateAnimation3.setStartOffset(450L);
        RotateAnimation rotateAnimation4 = new RotateAnimation(20.0f, -20.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation4.setDuration(300L);
        rotateAnimation4.setStartOffset(750L);
        RotateAnimation rotateAnimation5 = new RotateAnimation(-20.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation5.setDuration(150L);
        rotateAnimation5.setStartOffset(1050L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(rotateAnimation2);
        animationSet.addAnimation(rotateAnimation3);
        animationSet.addAnimation(rotateAnimation4);
        animationSet.addAnimation(rotateAnimation5);
        GJee0v.AZkASS.f3040ADYaiT.f3042A4TApA.scheduleAtFixedRate(new AMqCpz(imageView, animationSet, 0), 400L, 1600L, TimeUnit.MILLISECONDS);
    }

    public final void A2egSU() {
        H3v3Sq.A2egSU a2egSU = this.f2916A2egSU;
        if (a2egSU != null) {
            a2egSU.f3277BV3sI0 = 3;
            SensorManager sensorManager = this.f2917A4TApA;
            if (sensorManager != null) {
                sensorManager.unregisterListener(a2egSU);
            }
        }
    }

    public final void A4TApA(double d, double d2, double d3, int i) {
        SensorManager sensorManager;
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        H3v3Sq.A2egSU a2egSU = this.f2916A2egSU;
        if (a2egSU == null || (sensorManager = this.f2917A4TApA) == null || this.f2918A5SV6n == null || this.f2924AZkASS == null) {
            return;
        }
        sensorManager.unregisterListener(a2egSU);
        H3v3Sq.A2egSU a2egSU2 = new H3v3Sq.A2egSU(this.f2918A5SV6n, d, d2, d3 * 1000.0d, i);
        this.f2916A2egSU = a2egSU2;
        SensorManager sensorManager2 = this.f2917A4TApA;
        sensorManager2.registerListener(a2egSU2, sensorManager2.getDefaultSensor(10), 3);
        SensorManager sensorManager3 = this.f2917A4TApA;
        sensorManager3.registerListener(this.f2916A2egSU, sensorManager3.getDefaultSensor(4), 3);
    }

    public final void ADYaiT() {
        Shake shake;
        Context context = this.f2924AZkASS;
        if (context == null || (shake = this.f2919ADYaiT) == null || this.f2925AaHO0E == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        double d = shake.acceleration;
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        this.AMqCpz = Double.valueOf(d);
        this.f2920ARc23Z = Double.valueOf(shake.rotationAngle);
        double d2 = shake.operationTime;
        this.f2921ASJ6gh = Double.valueOf(d2);
        this.f2921ASJ6gh = Double.valueOf(d2 * 1000.0d);
        int i3 = shake.direction;
        this.f2922AYUAbz = i3;
        if (i3 < 0) {
            this.f2922AYUAbz = 0;
        }
        KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(20, this);
        this.f2918A5SV6n = a5SV6n;
        this.f2916A2egSU = new H3v3Sq.A2egSU(a5SV6n, this.AMqCpz.doubleValue(), this.f2920ARc23Z.doubleValue(), this.f2921ASJ6gh.doubleValue(), this.f2922AYUAbz);
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f2917A4TApA = sensorManager;
        if (sensorManager != null) {
            try {
                sensorManager.registerListener(this.f2916A2egSU, sensorManager.getDefaultSensor(10), 3);
                SensorManager sensorManager2 = this.f2917A4TApA;
                sensorManager2.registerListener(this.f2916A2egSU, sensorManager2.getDefaultSensor(4), 3);
            } catch (Exception unused) {
            }
        }
    }

    public final void AMqCpz() {
        H3v3Sq.A2egSU a2egSU = this.f2916A2egSU;
        if (a2egSU != null) {
            a2egSU.f3277BV3sI0 = 2;
            a2egSU.f3265B2KMhB = false;
            a2egSU.f3266B3GDIM = false;
            a2egSU.f3267B4ZgIw = 0L;
            a2egSU.f3268B7CMnp = 0L;
            a2egSU.f3278BmvVmW = 0;
            a2egSU.f3279BniPrB = 0.0d;
            a2egSU.BpkvW3 = false;
            a2egSU.f3282CASmeH = 0.0d;
            a2egSU.f3284COJEAR = 0;
            a2egSU.f3283CNPG0E = false;
            a2egSU.f3281C4FrIb = false;
            SensorManager sensorManager = this.f2917A4TApA;
            if (sensorManager != null) {
                sensorManager.registerListener(a2egSU, sensorManager.getDefaultSensor(10), 3);
                SensorManager sensorManager2 = this.f2917A4TApA;
                sensorManager2.registerListener(this.f2916A2egSU, sensorManager2.getDefaultSensor(4), 3);
            }
        }
    }

    public final void ARc23Z() {
        H3v3Sq.A2egSU a2egSU;
        SensorManager sensorManager = this.f2917A4TApA;
        if (sensorManager == null || (a2egSU = this.f2916A2egSU) == null) {
            return;
        }
        sensorManager.unregisterListener(a2egSU);
        this.f2917A4TApA = null;
        this.f2916A2egSU = null;
    }
}
