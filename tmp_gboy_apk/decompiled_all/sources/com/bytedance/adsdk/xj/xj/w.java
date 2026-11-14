package com.bytedance.adsdk.xj.xj;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.xj.xj.xj.d;
import com.bytedance.sdk.component.utils.pl;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class w<Decoder extends d<?, ?>> extends Drawable implements hf, d.xj {
    private static final String xj = "w";
    private Bitmap c;
    private final Runnable d;
    private final Handler f;
    private final Paint hf;
    private final Matrix kd;
    private final Set<WeakReference<Drawable.Callback>> p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10095pl;
    private boolean tf;
    private final DrawFilter u;
    private final Decoder w;
    private final Set<Object> y;

    public w(com.bytedance.adsdk.xj.xj.w.hf hfVar) {
        Paint paint = new Paint();
        this.hf = paint;
        this.u = new PaintFlagsDrawFilter(0, 3);
        this.kd = new Matrix();
        this.y = new HashSet();
        this.f = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.adsdk.xj.xj.w.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(w.this.y).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(w.this.y).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        };
        this.d = new Runnable() { // from class: com.bytedance.adsdk.xj.xj.w.2
            @Override // java.lang.Runnable
            public void run() {
                w.this.invalidateSelf();
            }
        };
        this.tf = true;
        this.p = new HashSet();
        this.f10095pl = false;
        paint.setAntiAlias(true);
        this.w = hf(hfVar, this);
    }

    private void kd() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        Iterator it = new HashSet(this.p).iterator();
        boolean z = false;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.p.remove((WeakReference) it2.next());
        }
        if (z) {
            return;
        }
        this.p.add(new WeakReference<>(callback));
    }

    private void u() {
        this.w.hf(this);
        if (this.tf) {
            this.w.d();
        } else {
            this.w.kd();
        }
    }

    private void w() {
        this.w.xj(this);
        if (this.tf) {
            this.w.f();
        } else {
            if (this.w.tf()) {
                return;
            }
            this.w.f();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.c;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.u);
        canvas.drawBitmap(this.c, this.kd, this.hf);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f10095pl) {
            return -1;
        }
        try {
            return this.w.y().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f10095pl) {
            return -1;
        }
        try {
            return this.w.y().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public abstract Decoder hf(com.bytedance.adsdk.xj.xj.w.hf hfVar, d.xj xjVar);

    @Override // com.bytedance.adsdk.xj.xj.xj.d.xj
    public void hf(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.c;
            if (bitmap == null || bitmap.isRecycled()) {
                this.c = Bitmap.createBitmap(this.w.y().width() / this.w.pl(), this.w.y().height() / this.w.pl(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.c.getByteCount()) {
                pl.u(xj, "onRender:Buffer not large enough for pixels");
            } else {
                this.c.copyPixelsFromBuffer(byteBuffer);
                this.f.post(this.d);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.p).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.w.tf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.hf.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean hf = this.w.hf(getBounds().width(), getBounds().height());
        this.kd.setScale(((getBounds().width() * 1.0f) * this.w.pl()) / this.w.y().width(), ((getBounds().height() * 1.0f) * this.w.pl()) / this.w.y().height());
        if (hf) {
            this.c = Bitmap.createBitmap(this.w.y().width() / this.w.pl(), this.w.y().height() / this.w.pl(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.hf.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        kd();
        if (this.tf) {
            if (z) {
                if (!isRunning()) {
                    w();
                }
            } else if (isRunning()) {
                u();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.w.tf()) {
            this.w.d();
        }
        this.w.p();
        w();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        u();
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.d.xj
    public void xj() {
        Message.obtain(this.f, 1).sendToTarget();
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.d.xj
    public void hf() {
        Message.obtain(this.f, 2).sendToTarget();
    }
}
