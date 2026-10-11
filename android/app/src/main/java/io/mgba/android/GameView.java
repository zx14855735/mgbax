package io.mgba.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView {
    private final Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    private final Rect src = new Rect();
    private final Rect dst = new Rect();

    public GameView(Context context) {
        this(context, null);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().setFormat(PixelFormat.OPAQUE);
        getHolder().setFixedSize(240, 160);
        setFocusable(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        if (w <= 0 || h <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        float scale = Math.min(w / 240f, h / 160f);
        setMeasuredDimension(Math.max(1, Math.round(240 * scale)), Math.max(1, Math.round(160 * scale)));
    }

    public void present(Bitmap bitmap) {
        SurfaceHolder holder = getHolder();
        Canvas canvas = holder.lockCanvas();
        if (canvas == null) {
            return;
        }
        try {
            if (bitmap != null && canvas.getWidth() == bitmap.getWidth() && canvas.getHeight() == bitmap.getHeight()) {
                canvas.drawBitmap(bitmap, 0, 0, null);
            } else {
                canvas.drawColor(Color.BLACK);
                if (bitmap != null) {
                    src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    fit(canvas.getWidth(), canvas.getHeight(), bitmap.getWidth(), bitmap.getHeight(), dst);
                    canvas.drawBitmap(bitmap, src, dst, paint);
                }
            }
        } finally {
            holder.unlockCanvasAndPost(canvas);
        }
    }

    private static void fit(int viewW, int viewH, int srcW, int srcH, Rect out) {
        if (viewW <= 0 || viewH <= 0 || srcW <= 0 || srcH <= 0) {
            out.set(0, 0, 0, 0);
            return;
        }
        float scale = Math.min(viewW / (float) srcW, viewH / (float) srcH);
        int w = Math.max(1, Math.round(srcW * scale));
        int h = Math.max(1, Math.round(srcH * scale));
        int left = (viewW - w) / 2;
        int top = (viewH - h) / 2;
        out.set(left, top, left + w, top + h);
    }
}
