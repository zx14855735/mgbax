package P94amq;

import android.graphics.Paint;
import android.graphics.Path;
import com.sigmob.sdk.base.blurkit.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final int[] f7004AZOQYO = new int[3];

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final float[] f7005AZkASS = {0.0f, 0.5f, 1.0f};

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final int[] f7006AaHO0E = new int[4];

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final float[] f7007AcNBzu = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Paint f7008A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Paint f7009A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Paint f7010A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f7011ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f7012ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Path f7013ASJ6gh = new Path();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final Paint f7014AYUAbz;

    public A2egSU() {
        Paint paint = new Paint();
        this.f7014AYUAbz = paint;
        this.f7008A2egSU = new Paint();
        A2egSU(d.f13043a);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f7009A4TApA = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f7010A5SV6n = new Paint(paint2);
    }

    public final void A2egSU(int i) {
        this.f7011ADYaiT = BV3sI0.A2egSU.AMqCpz(i, 68);
        this.AMqCpz = BV3sI0.A2egSU.AMqCpz(i, 20);
        this.f7012ARc23Z = BV3sI0.A2egSU.AMqCpz(i, 0);
        this.f7008A2egSU.setColor(this.f7011ADYaiT);
    }
}
