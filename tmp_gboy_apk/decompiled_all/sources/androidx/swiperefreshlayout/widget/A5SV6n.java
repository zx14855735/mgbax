package androidx.swiperefreshlayout.widget;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final RectF f9490A2egSU = new RectF();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Paint f9491A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Paint f9492A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Paint f9493ADYaiT;
    public float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float f9494ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f9495ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f9496AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int[] f9497AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f9498AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public float f9499AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public float f9500AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f9501AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f9502AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Path f9503AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public float f9504B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public float f9505B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f9506B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f9507B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f9508B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f9509B9tovu;

    public A5SV6n() {
        Paint paint = new Paint();
        this.f9491A4TApA = paint;
        Paint paint2 = new Paint();
        this.f9492A5SV6n = paint2;
        Paint paint3 = new Paint();
        this.f9493ADYaiT = paint3;
        this.AMqCpz = 0.0f;
        this.f9494ARc23Z = 0.0f;
        this.f9495ASJ6gh = 0.0f;
        this.f9496AYUAbz = 5.0f;
        this.f9504B25kr6 = 1.0f;
        this.f9508B7CMnp = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void A2egSU(int i) {
        this.f9498AZkASS = i;
        this.f9509B9tovu = this.f9497AZOQYO[i];
    }
}
