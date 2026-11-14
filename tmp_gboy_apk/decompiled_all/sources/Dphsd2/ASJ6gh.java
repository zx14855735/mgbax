package Dphsd2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.widget.Button;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends GradientDrawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2444A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Button f2445A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ AppInfoViewActivity f2446A5SV6n;

    public /* synthetic */ ASJ6gh(AppInfoViewActivity appInfoViewActivity, Button button, int i) {
        this.f2444A2egSU = i;
        this.f2446A5SV6n = appInfoViewActivity;
        this.f2445A4TApA = button;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        AppInfoViewActivity appInfoViewActivity = this.f2446A5SV6n;
        Button button = this.f2445A4TApA;
        switch (this.f2444A2egSU) {
            case 0:
                super.draw(canvas);
                Paint paint = new Paint();
                int i = button.getLayoutParams().width;
                int i2 = button.getLayoutParams().height;
                paint.setColor(Color.parseColor("#7c7c7c"));
                paint.setStyle(Paint.Style.STROKE);
                H0qugq.AZOQYO azoqyo = AppInfoViewActivity.f9605B2KMhB;
                paint.setStrokeWidth(appInfoViewActivity.A2egSU(1.0f));
                float f = i;
                float f2 = f / 2.0f;
                float A2egSU2 = appInfoViewActivity.A2egSU(4.0f);
                float f3 = 0.0f + A2egSU2;
                float f4 = (i2 / 2.0f) + A2egSU2;
                canvas.drawLine(0.0f, f3, f2, f4, paint);
                canvas.drawLine(f2, f4, f, f3, paint);
                break;
            default:
                super.draw(canvas);
                Paint paint2 = new Paint();
                int i3 = button.getLayoutParams().width;
                int i4 = button.getLayoutParams().height;
                H0qugq.AZOQYO azoqyo2 = AppInfoViewActivity.f9605B2KMhB;
                int A2egSU3 = appInfoViewActivity.A2egSU(6.0f);
                paint2.setColor(Color.parseColor("#7c7c7c"));
                paint2.setStyle(Paint.Style.STROKE);
                paint2.setStrokeWidth(appInfoViewActivity.A2egSU(1.0f));
                float f5 = A2egSU3;
                float f6 = i3 - A2egSU3;
                float f7 = i4 - A2egSU3;
                canvas.drawLine(f5, f5, f6, f7, paint2);
                canvas.drawLine(f5, f7, f6, f5, paint2);
                break;
        }
    }
}
