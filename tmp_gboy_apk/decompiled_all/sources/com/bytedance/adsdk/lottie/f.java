package com.bytedance.adsdk.lottie;

import ADYaiT.CtFAbx;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.u.ht;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.IntRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private RectF f10039a;
    private Bitmap ai;
    private u am;
    private Matrix b;
    private boolean c;
    private hf d;
    private boolean dk;
    private boolean e;
    private Paint en;
    private v et;
    private LottieAnimationView eu;
    private boolean f;
    private Rect ff;
    private String g;
    w hf;
    private boolean ht;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10040io;
    private RectF j;
    private com.bytedance.adsdk.lottie.model.layer.u jk;
    private final com.bytedance.adsdk.lottie.kd.y kd;
    private Rect l;
    private final ValueAnimator.AnimatorUpdateListener p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.hf.hf f10041pl;
    private int pz;
    private Canvas q;
    private com.bytedance.adsdk.lottie.hf.xj qt;
    private Matrix r;
    private boolean ra;
    private final ArrayList<xj> tf;
    private boolean tj;
    private y u;
    private boolean v;
    jk w;
    private RectF wo;
    private pz ws;
    private final Matrix x;
    String xj;
    private boolean y;
    private boolean yo;
    private Rect z;
    private Map<String, Typeface> zg;

    public enum hf {
        NONE,
        PLAY,
        RESUME;

        static {
            oNaT();
        }

        private static /* synthetic */ void oNaT() {
            char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 6);
            }
            String str = new String(charArray);
            char[] charArray2 = "ejohor".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 6);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface xj {
        void xj(y yVar);
    }

    public f(LottieAnimationView lottieAnimationView) {
        com.bytedance.adsdk.lottie.kd.y yVar = new com.bytedance.adsdk.lottie.kd.y();
        this.kd = yVar;
        this.y = true;
        this.c = false;
        this.f = false;
        this.d = hf.NONE;
        this.tf = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.jk != null) {
                    f.this.jk.xj(f.this.kd.y());
                }
            }
        };
        this.p = animatorUpdateListener;
        this.yo = false;
        this.v = true;
        this.pz = 255;
        this.et = v.AUTOMATIC;
        this.f10040io = false;
        this.x = new Matrix();
        this.tj = false;
        this.eu = lottieAnimationView;
        yVar.addUpdateListener(animatorUpdateListener);
    }

    private com.bytedance.adsdk.lottie.hf.xj a() {
        if (getCallback() == null) {
            return null;
        }
        if (this.qt == null) {
            com.bytedance.adsdk.lottie.hf.xj xjVar = new com.bytedance.adsdk.lottie.hf.xj(getCallback(), this.hf);
            this.qt = xjVar;
            String str = this.xj;
            if (str != null) {
                xjVar.xj(str);
            }
        }
        return this.qt;
    }

    private void en() {
        y yVar = this.u;
        if (yVar == null) {
            return;
        }
        this.f10040io = this.et.xj(Build.VERSION.SDK_INT, yVar.xj(), yVar.hf());
    }

    private com.bytedance.adsdk.lottie.hf.hf ff() {
        com.bytedance.adsdk.lottie.hf.hf hfVar = this.f10041pl;
        if (hfVar != null && !hfVar.xj(getContext())) {
            this.f10041pl = null;
        }
        if (this.f10041pl == null) {
            this.f10041pl = new com.bytedance.adsdk.lottie.hf.hf(getCallback(), this.g, this.am, this.u.e());
        }
        return this.f10041pl;
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private boolean l() {
        return this.y || this.c;
    }

    private boolean r() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }

    private void wo() {
        if (this.q != null) {
            return;
        }
        this.q = new Canvas();
        this.wo = new RectF();
        this.r = new Matrix();
        this.b = new Matrix();
        this.z = new Rect();
        this.j = new RectF();
        this.en = new com.bytedance.adsdk.lottie.xj.xj();
        this.l = new Rect();
        this.ff = new Rect();
        this.f10039a = new RectF();
    }

    public void ai() {
        this.tf.clear();
        this.kd.cancel();
        if (isVisible()) {
            return;
        }
        this.d = hf.NONE;
    }

    @MainThread
    public void am() {
        if (this.jk == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.7
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar) {
                    f.this.am();
                }
            });
            return;
        }
        en();
        if (l() || ht() == 0) {
            if (isVisible()) {
                this.kd.am();
                this.d = hf.NONE;
            } else {
                this.d = hf.RESUME;
            }
        }
        if (l()) {
            return;
        }
        w((int) (e() < 0.0f ? qt() : zg()));
        this.kd.pl();
        if (isVisible()) {
            return;
        }
        this.d = hf.NONE;
    }

    public v c() {
        return this.f10040io ? v.SOFTWARE : v.HARDWARE;
    }

    public yo d() {
        y yVar = this.u;
        if (yVar != null) {
            return yVar.w();
        }
        return null;
    }

    public boolean dk() {
        if (isVisible()) {
            return this.kd.isRunning();
        }
        hf hfVar = this.d;
        return hfVar == hf.PLAY || hfVar == hf.RESUME;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        kd.xj("Drawable#draw");
        try {
            if (this.f10040io) {
                xj(canvas, this.jk);
            } else {
                xj(canvas);
            }
        } catch (Throwable th) {
            com.bytedance.adsdk.lottie.kd.kd.hf("Lottie crashed in draw!", th);
        }
        this.tj = false;
        kd.hf("Drawable#draw");
    }

    public float e() {
        return this.kd.tf();
    }

    public jk et() {
        return this.w;
    }

    public boolean f() {
        return this.f10040io;
    }

    @MainThread
    public void g() {
        this.tf.clear();
        this.kd.pl();
        if (isVisible()) {
            return;
        }
        this.d = hf.NONE;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.pz;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        y yVar = this.u;
        if (yVar == null) {
            return -1;
        }
        return yVar.u().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        y yVar = this.u;
        if (yVar == null) {
            return -1;
        }
        return yVar.u().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int ht() {
        return this.kd.getRepeatCount();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.tj) {
            return;
        }
        this.tj = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean io() {
        return this.zg == null && this.w == null && this.u.qt().size() > 0;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return ra();
    }

    public RectF j() {
        return this.wo;
    }

    public int jk() {
        return (int) this.kd.c();
    }

    public String kd() {
        return this.g;
    }

    public void p() {
        if (this.kd.isRunning()) {
            this.kd.cancel();
            if (!isVisible()) {
                this.d = hf.NONE;
            }
        }
        this.u = null;
        com.bytedance.adsdk.lottie.model.layer.u uVar = this.jk;
        if (uVar != null) {
            xj(uVar);
        }
        this.jk = null;
        this.f10041pl = null;
        this.kd.f();
        invalidateSelf();
    }

    @MainThread
    public void pl() {
        if (this.jk == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.6
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar) {
                    f.this.pl();
                }
            });
            return;
        }
        en();
        if (l() || ht() == 0) {
            if (isVisible()) {
                this.kd.p();
                this.d = hf.NONE;
            } else {
                this.d = hf.PLAY;
            }
        }
        if (l()) {
            return;
        }
        w((int) (e() < 0.0f ? qt() : zg()));
        this.kd.pl();
        if (isVisible()) {
            return;
        }
        this.d = hf.NONE;
    }

    @SuppressLint({"WrongConstant"})
    public int pz() {
        return this.kd.getRepeatMode();
    }

    public void q() {
        this.tf.clear();
        this.kd.g();
        if (isVisible()) {
            return;
        }
        this.d = hf.NONE;
    }

    public float qt() {
        return this.kd.qt();
    }

    public boolean ra() {
        com.bytedance.adsdk.lottie.kd.y yVar = this.kd;
        if (yVar == null) {
            return false;
        }
        return yVar.isRunning();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.pz = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.bytedance.adsdk.lottie.kd.kd.hf("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            hf hfVar = this.d;
            if (hfVar == hf.PLAY) {
                pl();
                return visible;
            }
            if (hfVar == hf.RESUME) {
                am();
                return visible;
            }
        } else {
            if (this.kd.isRunning()) {
                q();
                this.d = hf.RESUME;
                return visible;
            }
            if (isVisible) {
                this.d = hf.NONE;
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        pl();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        g();
    }

    public boolean tf() {
        return this.dk;
    }

    public boolean u() {
        return this.v;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void v() {
        this.kd.removeAllListeners();
    }

    public com.bytedance.adsdk.lottie.model.layer.u w() {
        return this.jk;
    }

    public y x() {
        return this.u;
    }

    public boolean y() {
        return this.yo;
    }

    public void yo() {
        this.kd.removeAllUpdateListeners();
        this.kd.addUpdateListener(this.p);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float z() {
        return this.kd.y();
    }

    public float zg() {
        return this.kd.zg();
    }

    public void c(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
        this.kd.w(z);
    }

    public LottieAnimationView hf() {
        return this.eu;
    }

    public void kd(boolean z) {
        this.dk = z;
    }

    public void u(boolean z) {
        if (this.ra == z) {
            return;
        }
        this.ra = z;
        com.bytedance.adsdk.lottie.model.layer.u uVar = this.jk;
        if (uVar != null) {
            uVar.xj(z);
        }
    }

    public void w(boolean z) {
        this.ht = z;
        y yVar = this.u;
        if (yVar != null) {
            yVar.hf(z);
        }
    }

    public void xj(pz pzVar) {
        this.ws = pzVar;
    }

    public void y(boolean z) {
        this.f = z;
    }

    public void c(String str) {
        this.xj = str;
        com.bytedance.adsdk.lottie.hf.xj a2 = a();
        if (a2 != null) {
            a2.xj(str);
        }
    }

    public void hf(boolean z) {
        this.yo = z;
    }

    public void kd(int i) {
        this.kd.setRepeatCount(i);
    }

    public pz xj() {
        return this.ws;
    }

    public d y(String str) {
        y yVar = this.u;
        if (yVar == null) {
            return null;
        }
        return yVar.e().get(str);
    }

    public void hf(final int i) {
        if (this.u == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.10
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar) {
                    f.this.hf(i);
                }
            });
        } else {
            this.kd.hf(i + 0.99f);
        }
    }

    public Bitmap kd(String str) {
        com.bytedance.adsdk.lottie.hf.hf ff = ff();
        if (ff != null) {
            return ff.xj(str);
        }
        return null;
    }

    public void xj(boolean z, Context context) {
        if (this.e == z) {
            return;
        }
        this.e = z;
        if (this.u != null) {
            xj(context);
        }
    }

    public void w(final String str) {
        y yVar = this.u;
        if (yVar == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.13
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar2) {
                    f.this.w(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.y w = yVar.w(str);
        if (w != null) {
            hf((int) (w.xj + w.hf));
            return;
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("Cannot find marker with name ", str, "."));
    }

    public void u(final String str) {
        y yVar = this.u;
        if (yVar == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.2
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar2) {
                    f.this.u(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.y w = yVar.w(str);
        if (w != null) {
            int i = (int) w.xj;
            xj(i, ((int) w.hf) + i);
            return;
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("Cannot find marker with name ", str, "."));
    }

    public void hf(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        y yVar = this.u;
        if (yVar == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.11
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar2) {
                    f.this.hf(f);
                }
            });
        } else {
            this.kd.hf(com.bytedance.adsdk.lottie.kd.f.xj(yVar.y(), this.u.c(), f));
        }
    }

    public void xj(boolean z) {
        if (z != this.v) {
            this.v = z;
            com.bytedance.adsdk.lottie.model.layer.u uVar = this.jk;
            if (uVar != null) {
                uVar.hf(z);
            }
            invalidateSelf();
        }
    }

    public void hf(final String str) {
        y yVar = this.u;
        if (yVar == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.12
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar2) {
                    f.this.hf(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.y w = yVar.w(str);
        if (w != null) {
            xj((int) w.xj);
            return;
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("Cannot find marker with name ", str, "."));
    }

    public void xj(String str) {
        this.g = str;
    }

    public boolean xj(y yVar, Context context) {
        if (this.u == yVar) {
            return false;
        }
        this.tj = true;
        p();
        this.u = yVar;
        xj(context);
        this.kd.xj(yVar);
        u(this.kd.getAnimatedFraction());
        Iterator it = new ArrayList(this.tf).iterator();
        while (it.hasNext()) {
            xj xjVar = (xj) it.next();
            if (xjVar != null) {
                xjVar.xj(yVar);
            }
            it.remove();
        }
        this.tf.clear();
        yVar.hf(this.ht);
        en();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void w(float f) {
        this.kd.w(f);
    }

    public void w(final int i) {
        if (this.u == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.4
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar) {
                    f.this.w(i);
                }
            });
        } else {
            this.kd.xj(i);
        }
    }

    public void u(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.u == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.5
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar) {
                    f.this.u(f);
                }
            });
            return;
        }
        kd.xj("Drawable#setProgress");
        this.kd.xj(this.u.xj(f));
        kd.hf("Drawable#setProgress");
    }

    public void hf(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kd.removeUpdateListener(animatorUpdateListener);
    }

    public void hf(Animator.AnimatorListener animatorListener) {
        this.kd.removeListener(animatorListener);
    }

    private void hf(int i, int i2) {
        Bitmap bitmap = this.ai;
        if (bitmap != null && bitmap.getWidth() >= i && this.ai.getHeight() >= i2) {
            if (this.ai.getWidth() > i || this.ai.getHeight() > i2) {
                Bitmap createBitmap = Bitmap.createBitmap(this.ai, 0, 0, i, i2);
                this.ai = createBitmap;
                this.q.setBitmap(createBitmap);
                this.tj = true;
                return;
            }
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.ai = createBitmap2;
        this.q.setBitmap(createBitmap2);
        this.tj = true;
    }

    public void u(int i) {
        this.kd.setRepeatMode(i);
    }

    public void xj(v vVar) {
        this.et = vVar;
        en();
    }

    private void xj(Context context) {
        y yVar = this.u;
        if (yVar == null) {
            return;
        }
        com.bytedance.adsdk.lottie.model.layer.u uVar = this.jk;
        if (uVar != null) {
            xj(uVar);
        }
        com.bytedance.adsdk.lottie.model.layer.u uVar2 = new com.bytedance.adsdk.lottie.model.layer.u(this, ht.xj(yVar), yVar.am(), yVar, context);
        this.jk = uVar2;
        if (this.ra) {
            uVar2.xj(true);
        }
        this.jk.hf(this.v);
    }

    private void xj(com.bytedance.adsdk.lottie.model.layer.u uVar) {
        if (uVar != null) {
            uVar.w();
            List<com.bytedance.adsdk.lottie.model.layer.w> am = uVar.am();
            if (am != null) {
                for (com.bytedance.adsdk.lottie.model.layer.w wVar : am) {
                    if (wVar instanceof com.bytedance.adsdk.lottie.model.layer.u) {
                        xj((com.bytedance.adsdk.lottie.model.layer.u) wVar);
                    } else if (wVar != null) {
                        wVar.w();
                    }
                }
            }
        }
    }

    public void xj(final int i) {
        if (this.u == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.8
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar) {
                    f.this.xj(i);
                }
            });
        } else {
            this.kd.xj(i);
        }
    }

    public void xj(final float f) {
        y yVar = this.u;
        if (yVar == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.9
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar2) {
                    f.this.xj(f);
                }
            });
        } else {
            xj((int) com.bytedance.adsdk.lottie.kd.f.xj(yVar.y(), this.u.c(), f));
        }
    }

    public void xj(final int i, final int i2) {
        if (this.u == null) {
            this.tf.add(new xj() { // from class: com.bytedance.adsdk.lottie.f.3
                @Override // com.bytedance.adsdk.lottie.f.xj
                public void xj(y yVar) {
                    f.this.xj(i, i2);
                }
            });
        } else {
            this.kd.xj(i, i2 + 0.99f);
        }
    }

    public void xj(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kd.addUpdateListener(animatorUpdateListener);
    }

    public void xj(Animator.AnimatorListener animatorListener) {
        this.kd.addListener(animatorListener);
    }

    public void xj(Boolean bool) {
        this.y = bool.booleanValue();
    }

    public void xj(u uVar) {
        this.am = uVar;
        com.bytedance.adsdk.lottie.hf.hf hfVar = this.f10041pl;
        if (hfVar != null) {
            hfVar.xj(uVar);
        }
    }

    public void xj(w wVar) {
        this.hf = wVar;
        com.bytedance.adsdk.lottie.hf.xj xjVar = this.qt;
        if (xjVar != null) {
            xjVar.xj(wVar);
        }
    }

    public void xj(Map<String, Typeface> map) {
        if (map == this.zg) {
            return;
        }
        this.zg = map;
        invalidateSelf();
    }

    public void xj(jk jkVar) {
        this.w = jkVar;
    }

    public Bitmap xj(String str, Bitmap bitmap) {
        com.bytedance.adsdk.lottie.hf.hf ff = ff();
        if (ff == null) {
            com.bytedance.adsdk.lottie.kd.kd.hf("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap xj2 = ff.xj(str, bitmap);
        invalidateSelf();
        return xj2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface xj(com.bytedance.adsdk.lottie.model.w wVar) {
        Map<String, Typeface> map = this.zg;
        if (map != null) {
            String xj2 = wVar.xj();
            if (map.containsKey(xj2)) {
                return map.get(xj2);
            }
            String hf2 = wVar.hf();
            if (map.containsKey(hf2)) {
                return map.get(hf2);
            }
            String str = wVar.xj() + "-" + wVar.w();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.lottie.hf.xj a2 = a();
        if (a2 != null) {
            return a2.xj(wVar);
        }
        return null;
    }

    private void xj(Canvas canvas) {
        com.bytedance.adsdk.lottie.model.layer.u uVar = this.jk;
        y yVar = this.u;
        if (uVar == null || yVar == null) {
            return;
        }
        this.x.reset();
        if (!getBounds().isEmpty()) {
            this.x.preScale(r2.width() / yVar.u().width(), r2.height() / yVar.u().height());
            this.x.preTranslate(r2.left, r2.top);
        }
        uVar.xj(canvas, this.x, this.pz);
    }

    private void xj(Canvas canvas, com.bytedance.adsdk.lottie.model.layer.u uVar) {
        if (this.u == null || uVar == null) {
            return;
        }
        wo();
        canvas.getMatrix(this.r);
        canvas.getClipBounds(this.z);
        xj(this.z, this.j);
        this.r.mapRect(this.j);
        xj(this.j, this.z);
        if (this.v) {
            this.wo.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            uVar.xj(this.wo, (Matrix) null, false);
        }
        this.r.mapRect(this.wo);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        xj(this.wo, width, height);
        if (!r()) {
            RectF rectF = this.wo;
            Rect rect = this.z;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int ceil = (int) Math.ceil(this.wo.width());
        int ceil2 = (int) Math.ceil(this.wo.height());
        if (ceil == 0 || ceil2 == 0) {
            return;
        }
        hf(ceil, ceil2);
        if (this.tj) {
            this.x.set(this.r);
            this.x.preScale(width, height);
            Matrix matrix = this.x;
            RectF rectF2 = this.wo;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.ai.eraseColor(0);
            uVar.xj(this.q, this.x, this.pz);
            this.r.invert(this.b);
            this.b.mapRect(this.f10039a, this.wo);
            xj(this.f10039a, this.ff);
        }
        this.l.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.ai, this.l, this.ff, this.en);
    }

    private void xj(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void xj(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void xj(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }
}
