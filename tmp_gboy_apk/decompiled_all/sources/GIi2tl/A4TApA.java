package GIi2tl;

import ADYaiT.CtFAbx;
import AZOQYO.ARc23Z;
import EY4UKY.ADYaiT;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends View {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Paint f3017AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Paint f3018AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Path f3019AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Path f3020AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Context f3021B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final float f3022B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f3023B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f3024B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final int f3025B7CMnp;

    public A4TApA(Context context) {
        super(context);
        this.f3023B3GDIM = 1;
        this.f3024B4ZgIw = 1;
        this.f3025B7CMnp = 1;
        this.f3021B25kr6 = context;
        this.f3022B2KMhB = 4.0f;
        try {
            Paint paint = new Paint(1);
            this.f3017AcNBzu = paint;
            paint.setColor(Color.parseColor((String) ARc23Z.f361B3GDIM.f363AcNBzu));
            Paint paint2 = new Paint(1);
            this.f3018AlLFFp = paint2;
            paint2.setColor(0);
            this.f3018AlLFFp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            RectF rectF = new RectF(0.0f, 0.0f, 500.0f, 500.0f);
            Path path = new Path();
            this.f3019AmA8tU = path;
            Path.Direction direction = Path.Direction.CW;
            path.addRect(rectF, direction);
            Path path2 = new Path();
            this.f3020AzWtSf = path2;
            path2.addRoundRect(rectF, com.bumptech.glide.A5SV6n.A2egSU(context, 4.0f), com.bumptech.glide.A5SV6n.A2egSU(context, 4.0f), direction);
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("OverlapShapeView 001: "), new ADYaiT(), "004", e);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f = this.f3022B2KMhB;
        Context context = this.f3021B25kr6;
        super.onDraw(canvas);
        try {
            int width = getWidth();
            int height = getHeight();
            this.f3019AmA8tU.reset();
            float f2 = height;
            Path.Direction direction = Path.Direction.CW;
            this.f3019AmA8tU.addRect(0.0f, 0.0f, width, f2, direction);
            this.f3020AzWtSf = new Path();
            this.f3020AzWtSf.addRoundRect(new RectF(this.f3024B4ZgIw, this.f3025B7CMnp, width - this.f3023B3GDIM, f2), com.bumptech.glide.A5SV6n.A2egSU(context, f), com.bumptech.glide.A5SV6n.A2egSU(context, f), direction);
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
            canvas.drawPath(this.f3019AmA8tU, this.f3017AcNBzu);
            canvas.drawPath(this.f3020AzWtSf, this.f3018AlLFFp);
            canvas.restoreToCount(saveLayer);
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("OverlapShapeView 002: "), new ADYaiT(), "004", e);
        }
    }
}
