package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends View {

    /* renamed from: a, reason: collision with root package name */
    private Path f13286a;
    private Path b;
    private Paint c;

    public f(Context context) {
        super(context);
        this.f13286a = new Path();
        this.b = new Path();
        Paint paint = new Paint();
        this.c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.c.setColor(-1);
        this.c.setAntiAlias(true);
        this.c.setAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT);
        a();
    }

    private void a() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                f.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                f.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int width = getWidth();
        int width2 = getWidth();
        if (width <= 0 || width2 <= 0) {
            return;
        }
        int min = Math.min(width, width2);
        this.c.reset();
        this.f13286a.reset();
        this.b.reset();
        this.c.setStrokeWidth(Dips.dipsToIntPixels(1.0f, getContext()));
        float f = min;
        float f2 = width / 2.0f;
        float f3 = width2 / 2.0f;
        Path path = this.f13286a;
        Path.Direction direction = Path.Direction.CCW;
        path.addCircle(f2, f3, 0.45f * f, direction);
        this.b.addCircle(f2, f3, f * 0.35f, direction);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c.setColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.c.setAlpha(102);
        this.c.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.f13286a, this.c);
        this.c.setColor(-1);
        this.c.setAlpha(76);
        this.c.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.f13286a, this.c);
        this.c.setAlpha(127);
        canvas.drawPath(this.b, this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
