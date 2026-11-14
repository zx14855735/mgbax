package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.sdk.component.utils.jk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FlowLightView extends View {
    private LinearGradient am;
    private int c;
    private int[] d;
    private int f;
    private PorterDuff.Mode g;
    Rect hf;
    private int kd;
    private Paint p;

    /* renamed from: pl, reason: collision with root package name */
    private Xfermode f10196pl;
    private final List<xj> qt;
    private Bitmap tf;
    private int u;
    private int w;
    Rect xj;
    private int y;

    public static class xj {
        private int hf = 0;
        private final int xj;

        public xj(int i) {
            this.xj = i;
        }

        public void xj() {
            this.hf += this.xj;
        }
    }

    public FlowLightView(Context context) {
        super(context);
        this.g = PorterDuff.Mode.DST_IN;
        this.qt = new ArrayList();
        xj();
    }

    private void xj() {
        this.w = jk.kd(getContext(), "tt_splash_unlock_image_arrow");
        this.u = Color.parseColor("#00ffffff");
        this.kd = Color.parseColor("#ffffffff");
        int parseColor = Color.parseColor("#00ffffff");
        this.y = parseColor;
        this.c = 10;
        this.f = 40;
        this.d = new int[]{this.u, this.kd, parseColor};
        setLayerType(1, null);
        this.p = new Paint(1);
        this.tf = BitmapFactory.decodeResource(getResources(), this.w);
        this.f10196pl = new PorterDuffXfermode(this.g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.tf, this.xj, this.hf, this.p);
        canvas.save();
        Iterator<xj> it = this.qt.iterator();
        while (it.hasNext()) {
            xj next = it.next();
            this.am = new LinearGradient(next.hf, 0.0f, next.hf + this.f, this.c, this.d, (float[]) null, Shader.TileMode.CLAMP);
            this.p.setColor(-1);
            this.p.setShader(this.am);
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.p);
            this.p.setShader(null);
            next.xj();
            if (next.hf > getWidth()) {
                it.remove();
            }
            canvas = canvas2;
        }
        Canvas canvas3 = canvas;
        this.p.setXfermode(this.f10196pl);
        canvas3.drawBitmap(this.tf, this.xj, this.hf, this.p);
        this.p.setXfermode(null);
        canvas3.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.tf == null) {
            return;
        }
        this.xj = new Rect(0, 0, this.tf.getWidth(), this.tf.getHeight());
        this.hf = new Rect(0, 0, getWidth(), getHeight());
    }

    public void xj(int i) {
        this.qt.add(new xj(i));
        postInvalidate();
    }
}
