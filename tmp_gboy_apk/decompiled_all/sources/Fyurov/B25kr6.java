package Fyurov;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 extends View {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Paint f2955AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Paint f2956AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f2957AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final float f2958AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ B2KMhB f2959B25kr6;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B25kr6(B2KMhB b2KMhB, Context context) {
        super(context);
        this.f2959B25kr6 = b2KMhB;
        this.f2957AmA8tU = 0.0f;
        this.f2958AzWtSf = 30.0f;
        Paint paint = new Paint(1);
        this.f2955AcNBzu = paint;
        paint.setColor(Color.parseColor("#53000000"));
        Paint paint2 = new Paint(1);
        this.f2956AlLFFp = paint2;
        paint2.setColor(-1);
        this.f2956AlLFFp.setStyle(Paint.Style.STROKE);
        this.f2956AlLFFp.setStrokeWidth((int) ((2.0f * b2KMhB.f2960A2egSU.getResources().getDisplayMetrics().density) + 0.5f));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        float f = (int) ((this.f2957AmA8tU * this.f2959B25kr6.f2960A2egSU.getResources().getDisplayMetrics().density) + 0.5f);
        double d = width;
        double d2 = 0.1d * d;
        float f2 = this.f2958AzWtSf;
        float f3 = f * 1.0f;
        float f4 = (float) (((f2 + d2) - f3) + d2);
        Path path = new Path();
        float f5 = height;
        path.moveTo(-2.0f, f5);
        path.lineTo(-2.0f, f4);
        float f6 = width + 2;
        path.quadTo(width / 2, (-(f2 + f3)) + ((float) (d * 0.06d)), f6, f4);
        path.lineTo(f6, f5);
        path.close();
        canvas.drawPath(path, this.f2955AcNBzu);
        canvas.drawPath(path, this.f2956AlLFFp);
    }
}
