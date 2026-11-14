package com.sigmob.sdk.base.blurkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final float f13040a = 1.0f;
    private static a b;
    private static RenderScript c;

    private Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap((int) (bitmap.getWidth() * f), (int) (bitmap.getHeight() * f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return createBitmap;
    }

    public Bitmap a(Bitmap bitmap, int i) {
        try {
            Allocation createFromBitmap = Allocation.createFromBitmap(c, bitmap);
            Allocation createTyped = Allocation.createTyped(c, createFromBitmap.getType());
            RenderScript renderScript = c;
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setRadius(i);
            create.setInput(createFromBitmap);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
        } catch (Throwable unused) {
        }
        return bitmap;
    }

    public Bitmap a(Bitmap bitmap, int i, float f) {
        return a(a(bitmap, f), i);
    }

    private Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private Bitmap a(View view, float f) {
        Bitmap createBitmap = Bitmap.createBitmap((int) (view.getWidth() * f), (int) (view.getHeight() * f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        canvas.setMatrix(matrix);
        view.draw(canvas);
        return createBitmap;
    }

    public Bitmap a(View view, int i) {
        return a(a(view), i);
    }

    public Bitmap a(View view, int i, float f) {
        return a(a(view, f), i);
    }

    public static a a() {
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        throw new RuntimeException("BlurKit not initialized!");
    }

    public static void a(Context context) {
        if (b != null) {
            return;
        }
        b = new a();
        c = RenderScript.create(context.getApplicationContext());
    }
}
