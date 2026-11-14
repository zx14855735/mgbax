package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.y;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RawRes;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LottieAnimationView extends ImageView {
    private static final tf<Throwable> hf = new tf<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.1
        @Override // com.bytedance.adsdk.lottie.tf
        public void xj(Throwable th) {
            if (com.bytedance.adsdk.lottie.kd.d.xj(th)) {
                com.bytedance.adsdk.lottie.kd.kd.xj("Unable to load composition.", th);
            } else {
                com.bytedance.adsdk.lottie.kd.kd.xj("Unable to parse composition:", th);
            }
        }
    };
    private static final String xj = "LottieAnimationView";

    /* renamed from: a, reason: collision with root package name */
    private xj f10034a;
    private int ai;
    private final Set<Object> am;
    private final f c;

    @RawRes
    private int d;
    private com.bytedance.adsdk.lottie.model.layer.y dk;
    private final Handler e;
    private int en;
    private List<com.bytedance.adsdk.lottie.model.layer.y> et;
    private String f;
    private hf ff;
    private final Set<u> g;
    private volatile int ht;

    /* renamed from: io, reason: collision with root package name */
    private int f10035io;
    private JSONArray j;
    private Handler jk;
    private tf<Throwable> kd;
    private final Runnable l;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10036pl;
    private long pz;
    private int q;
    private g<y> qt;
    private final Runnable ra;
    private boolean tf;
    private final tf<Throwable> u;
    private int v;
    private final tf<y> w;
    private int x;
    private int y;
    private final Handler yo;
    private String z;
    private y zg;

    /* renamed from: com.bytedance.adsdk.lottie.LottieAnimationView$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            xj = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xj[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface hf {
        void xj(String str, JSONArray jSONArray);
    }

    public enum u {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION;

        static {
            ofIHegT();
        }

        private static /* synthetic */ void ofIHegT() {
            char[] charArray = "ñýÿ¼õóÿ÷¼ðýë¼áú÷þþ¼ØüûÐàûöõ÷".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 146);
            }
            String str = new String(charArray);
            char[] charArray2 = "ñþûüûæ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 146);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class w extends View.BaseSavedState {
        public static final Parcelable.Creator<w> CREATOR = new Parcelable.Creator<w>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.w.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public w createFromParcel(Parcel parcel) {
                return new w(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public w[] newArray(int i) {
                return new w[i];
            }
        };
        int c;
        int hf;
        String kd;
        boolean u;
        float w;
        String xj;
        int y;

        static {
            EMyDhV();
        }

        private static /* synthetic */ void EMyDhV() {
            char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ ' ');
            }
            String str = new String(charArray);
            char[] charArray2 = "CLINIT".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ ' ');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.xj);
            parcel.writeFloat(this.w);
            parcel.writeInt(this.u ? 1 : 0);
            parcel.writeString(this.kd);
            parcel.writeInt(this.y);
            parcel.writeInt(this.c);
        }

        public w(Parcelable parcelable) {
            super(parcelable);
        }

        private w(Parcel parcel) {
            super(parcel);
            this.xj = parcel.readString();
            this.w = parcel.readFloat();
            this.u = parcel.readInt() == 1;
            this.kd = parcel.readString();
            this.y = parcel.readInt();
            this.c = parcel.readInt();
        }
    }

    public interface xj {
        void hf(Map<String, Object> map);

        void xj(Map<String, Object> map);
    }

    static {
        HNcqZwG();
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.w = new tf<y>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.7
            @Override // com.bytedance.adsdk.lottie.tf
            public void xj(y yVar) {
                LottieAnimationView.this.setComposition(yVar);
            }
        };
        this.u = new tf<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.8
            @Override // com.bytedance.adsdk.lottie.tf
            public void xj(Throwable th) {
                if (LottieAnimationView.this.y != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.y);
                }
                (LottieAnimationView.this.kd == null ? LottieAnimationView.hf : LottieAnimationView.this.kd).xj(th);
            }
        };
        this.y = 0;
        this.c = new f(this);
        this.tf = false;
        this.p = false;
        this.f10036pl = true;
        this.g = new HashSet();
        this.am = new HashSet();
        this.e = new Handler(Looper.getMainLooper());
        this.yo = new Handler(Looper.getMainLooper());
        this.v = 0;
        this.pz = 0L;
        this.ht = 0;
        this.ra = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4
            @Override // java.lang.Runnable
            public void run() {
                LottieAnimationView.this.zg();
                if (LottieAnimationView.this.ht == 0) {
                    return;
                }
                if (LottieAnimationView.this.isShown()) {
                    if (LottieAnimationView.this.ht == 1) {
                        LottieAnimationView.this.ht = 2;
                        LottieAnimationView.this.yo();
                        return;
                    }
                    return;
                }
                if (LottieAnimationView.this.ht == 2) {
                    LottieAnimationView.this.ht = 1;
                    LottieAnimationView.this.v();
                }
            }
        };
        this.l = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.utils.pl.xj("TMe", "--==--- timer callback, timer: " + LottieAnimationView.this.f10035io + ", " + LottieAnimationView.this.x);
                if (LottieAnimationView.this.f10035io > LottieAnimationView.this.x) {
                    LottieAnimationView.pz(LottieAnimationView.this);
                    LottieAnimationView.this.jk();
                    LottieAnimationView.this.invalidate();
                    LottieAnimationView.this.yo();
                    return;
                }
                LottieAnimationView.this.ht = 0;
                LottieAnimationView.this.e();
                if (LottieAnimationView.this.ai < 0 || LottieAnimationView.this.q < 0) {
                    com.bytedance.sdk.component.utils.pl.xj("TMe", "--==--- timer end, frame invalid: " + LottieAnimationView.this.ai + "," + LottieAnimationView.this.q);
                } else {
                    com.bytedance.sdk.component.utils.pl.xj("TMe", "--==--- timer end, play anim, startframe: " + LottieAnimationView.this.ai);
                    LottieAnimationView.this.hf();
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setFrame(lottieAnimationView.ai);
                    LottieAnimationView.this.xj(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (LottieAnimationView.this.getFrame() < LottieAnimationView.this.q - 1 || LottieAnimationView.this.getFrame() >= LottieAnimationView.this.q + 2) {
                                return;
                            }
                            com.bytedance.sdk.component.utils.pl.xj("TMe", "--==--- timer end, play anim, endframe: " + LottieAnimationView.this.q);
                            LottieAnimationView.this.hf(this);
                            LottieAnimationView.this.c();
                        }
                    });
                }
                if ((!TextUtils.isEmpty(LottieAnimationView.this.z) || (LottieAnimationView.this.j != null && LottieAnimationView.this.j.length() > 0)) && LottieAnimationView.this.ff != null) {
                    LottieAnimationView.this.ff.xj(LottieAnimationView.this.z, LottieAnimationView.this.j);
                }
            }
        };
        d();
    }

    private static /* synthetic */ void HNcqZwG() {
        char[] charArray = "\u009d\u0091\u0093Ð\u0099\u009f\u0093\u009bÐ\u009c\u0091\u0087Ð\u008d\u0096\u009b\u0092\u0092Ð´\u0090\u0097¼\u008c\u0097\u009a\u0099\u009b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 254);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009d\u0092\u0097\u0090\u0097\u008a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 254);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private y.xj getArea() {
        y x;
        f fVar = this.c;
        if (fVar == null || (x = fVar.x()) == null) {
            return null;
        }
        return x.tf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public y.hf getGlobalConfig() {
        y x;
        f fVar = this.c;
        if (fVar == null || (x = fVar.x()) == null) {
            return null;
        }
        return x.pl();
    }

    private y.w getGlobalEvent() {
        y x;
        f fVar = this.c;
        if (fVar == null || (x = fVar.x()) == null) {
            return null;
        }
        return x.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        y x;
        f fVar = this.c;
        if (fVar == null || (x = fVar.x()) == null) {
            return null;
        }
        return x.d();
    }

    public static /* synthetic */ int kd(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.v;
        lottieAnimationView.v = i + 1;
        return i;
    }

    public static /* synthetic */ int pz(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.f10035io;
        lottieAnimationView.f10035io = i - 1;
        return i;
    }

    private void setCompositionTask(g<y> gVar) {
        this.g.add(u.SET_ANIMATION);
        pz();
        am();
        this.qt = gVar.xj(this.w).w(this.u);
    }

    public boolean getClipToCompositionBounds() {
        return this.c.u();
    }

    public y getComposition() {
        return this.zg;
    }

    public long getDuration() {
        y yVar = this.zg;
        if (yVar != null) {
            return (long) yVar.kd();
        }
        return 0L;
    }

    public int getFrame() {
        return this.c.jk();
    }

    public String getImageAssetsFolder() {
        return this.c.kd();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.c.y();
    }

    public float getMaxFrame() {
        return this.c.zg();
    }

    public float getMinFrame() {
        return this.c.qt();
    }

    public yo getPerformanceTracker() {
        return this.c.d();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.c.z();
    }

    public v getRenderMode() {
        return this.c.c();
    }

    public int getRepeatCount() {
        return this.c.ht();
    }

    public int getRepeatMode() {
        return this.c.pz();
    }

    public float getSpeed() {
        return this.c.e();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof f) && ((f) drawable).c() == v.SOFTWARE) {
            this.c.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.c;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.p) {
            return;
        }
        this.c.pl();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
        e();
        Handler handler = this.jk;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        u();
        w();
        y();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof w)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        w wVar = (w) parcelable;
        super.onRestoreInstanceState(wVar.getSuperState());
        this.f = wVar.xj;
        Set<u> set = this.g;
        u uVar = u.SET_ANIMATION;
        if (!set.contains(uVar) && !TextUtils.isEmpty(this.f)) {
            setAnimation(this.f);
        }
        this.d = wVar.hf;
        if (!this.g.contains(uVar) && (i = this.d) != 0) {
            setAnimation(i);
        }
        if (!this.g.contains(u.SET_PROGRESS)) {
            xj(wVar.w, false);
        }
        if (!this.g.contains(u.PLAY_OPTION) && wVar.u) {
            xj();
        }
        if (!this.g.contains(u.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(wVar.kd);
        }
        if (!this.g.contains(u.SET_REPEAT_MODE)) {
            setRepeatMode(wVar.y);
        }
        if (this.g.contains(u.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(wVar.c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        w wVar = new w(super.onSaveInstanceState());
        wVar.xj = this.f;
        wVar.hf = this.d;
        wVar.w = this.c.z();
        wVar.u = this.c.dk();
        wVar.kd = this.c.kd();
        wVar.y = this.c.pz();
        wVar.c = this.c.ht();
        return wVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        if (r3 <= (r4 + r0.f)) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.LottieAnimationView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAnimation(@RawRes int i) {
        this.d = i;
        this.f = null;
        setCompositionTask(xj(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        xj(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f10036pl ? c.xj(getContext(), str) : c.xj(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.c.kd(z);
    }

    public void setCacheComposition(boolean z) {
        this.f10036pl = z;
    }

    public void setClipToCompositionBounds(boolean z) {
        this.c.xj(z);
    }

    public void setComposition(y yVar) {
        this.c.setCallback(this);
        this.zg = yVar;
        this.tf = true;
        boolean xj2 = this.c.xj(yVar, getContext().getApplicationContext());
        this.tf = false;
        if (getDrawable() != this.c || xj2) {
            if (!xj2) {
                ht();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.am.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.c.c(str);
    }

    public void setFailureListener(tf<Throwable> tfVar) {
        this.kd = tfVar;
    }

    public void setFallbackResource(int i) {
        this.y = i;
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.lottie.w wVar) {
        this.c.xj(wVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.c.xj(map);
    }

    public void setFrame(int i) {
        this.c.w(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.c.c(z);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.lottie.u uVar) {
        this.c.xj(uVar);
    }

    public void setImageAssetsFolder(String str) {
        this.c.xj(str);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        am();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        am();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        am();
        super.setImageResource(i);
    }

    public void setLottieAnimListener(xj xjVar) {
        this.f10034a = xjVar;
    }

    public void setLottieClicklistener(hf hfVar) {
        this.ff = hfVar;
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.c.hf(z);
    }

    public void setMaxFrame(int i) {
        this.c.hf(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.c.hf(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.c.u(str);
    }

    public void setMinFrame(int i) {
        this.c.xj(i);
    }

    public void setMinProgress(float f) {
        this.c.xj(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.c.u(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.c.w(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        xj(f, true);
    }

    public void setRenderMode(v vVar) {
        this.c.xj(vVar);
    }

    public void setRepeatCount(int i) {
        this.g.add(u.SET_REPEAT_COUNT);
        this.c.kd(i);
    }

    public void setRepeatMode(int i) {
        this.g.add(u.SET_REPEAT_MODE);
        this.c.u(i);
    }

    public void setSafeMode(boolean z) {
        this.c.y(z);
    }

    public void setSpeed(float f) {
        this.c.w(f);
    }

    public void setTextDelegate(jk jkVar) {
        this.c.xj(jkVar);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.c.f(z);
    }

    public void setViewDelegate(pz pzVar) {
        this.c.xj(pzVar);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        f fVar;
        if (!this.tf && drawable == (fVar = this.c) && fVar.ra()) {
            c();
        } else if (!this.tf && (drawable instanceof f)) {
            f fVar2 = (f) drawable;
            if (fVar2.ra()) {
                fVar2.q();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    private void am() {
        g<y> gVar = this.qt;
        if (gVar != null) {
            gVar.hf(this.w);
            this.qt.u(this.u);
        }
    }

    private void d() {
        setSaveEnabled(false);
        this.f10036pl = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        xj(0.0f, false);
        xj(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.c.xj(Boolean.valueOf(com.bytedance.adsdk.lottie.kd.d.xj(getContext()) != 0.0f));
        tf();
        p();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.yo.removeCallbacksAndMessages(null);
    }

    private void g() {
        xj(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                jk et;
                final long elapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.pz;
                LottieAnimationView.this.hf(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (et = LottieAnimationView.this.c.et()) != null) {
                    try {
                        int parseInt = Integer.parseInt(et.xj(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.pz > 0) {
                            long elapsedRealtime2 = (LottieAnimationView.this.pz + parseInt) - SystemClock.elapsedRealtime();
                            com.bytedance.sdk.component.utils.pl.xj("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(elapsedRealtime2)));
                            if (elapsedRealtime2 > 0) {
                                LottieAnimationView.this.c();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.jk == null) {
                                    LottieAnimationView.this.jk = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.jk.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.jk.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.bytedance.sdk.component.utils.pl.xj("TMe", "--==-- lottie real start play");
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.xj();
                                        LottieAnimationView.this.xj(elapsedRealtime);
                                    }
                                }, elapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
                LottieAnimationView.this.xj(elapsedRealtime);
            }
        });
    }

    private void hf(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float width2 = this.c.getBounds().width();
        float height2 = this.c.getBounds().height();
        if (width == 0.0f || height == 0.0f || width2 == 0.0f || height2 == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass6.xj[getScaleType().ordinal()];
        if (i == 1) {
            xj(matrix, width, height, width2, height2);
        } else if (i == 2) {
            hf(matrix, width, height, width2, height2);
        } else if (i == 3) {
            w(matrix, width, height, width2, height2);
        } else if (i == 4) {
            u(matrix, width, height, width2, height2);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void ht() {
        boolean kd = kd();
        setImageDrawable(null);
        setImageDrawable(this.c);
        if (kd) {
            this.c.am();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        String[] split;
        if (this.et == null) {
            com.bytedance.adsdk.lottie.model.layer.y yVar = this.dk;
            if (yVar != null) {
                if (this.en == 1) {
                    yVar.xj(hf(this.f10035io));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f10035io);
                yVar.xj(sb.toString());
                return;
            }
            return;
        }
        String hf2 = hf(this.f10035io);
        if (TextUtils.isEmpty(hf2) || (split = hf2.split(":")) == null || split.length != 3) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            com.bytedance.adsdk.lottie.model.layer.y yVar2 = this.et.get(i);
            if (yVar2 != null) {
                yVar2.xj(split[i]);
            }
        }
    }

    private void p() {
        xj(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Map<String, Object> map;
                int i;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                LottieAnimationView.kd(LottieAnimationView.this);
                y.hf globalConfig = LottieAnimationView.this.getGlobalConfig();
                if (globalConfig != null && (i = globalConfig.u) > 0 && i > LottieAnimationView.this.v) {
                    LottieAnimationView.this.qt();
                    LottieAnimationView.this.xj();
                    LottieAnimationView.this.setProgress(0.0f);
                    return;
                }
                LottieAnimationView.this.hf(this);
                if (LottieAnimationView.this.f10034a != null) {
                    if (globalConfig == null || (map = globalConfig.w) == null) {
                        map = null;
                    }
                    LottieAnimationView.this.f10034a.hf(map);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl() {
        final y.hf globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.kd <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.y) && globalConfig.c == null) {
            return;
        }
        int i = globalConfig.kd;
        if (i > getMaxFrame()) {
            i = (int) getMaxFrame();
        }
        final float maxFrame = i / getMaxFrame();
        xj(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame) {
                    return;
                }
                LottieAnimationView.this.hf(this);
                if (LottieAnimationView.this.ff != null) {
                    hf hfVar = LottieAnimationView.this.ff;
                    y.hf hfVar2 = globalConfig;
                    hfVar.xj(hfVar2.y, hfVar2.c);
                }
            }
        });
    }

    private void pz() {
        this.zg = null;
        this.c.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void qt() {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.LottieAnimationView.qt():void");
    }

    private void tf() {
        xj(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LottieAnimationView.this.hf(this);
                LottieAnimationView.this.qt();
                LottieAnimationView.this.pl();
            }
        });
    }

    private void u(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 >= f || f4 >= f2) {
            if (f3 / f4 >= f / f2) {
                float f5 = f / f3;
                matrix.preScale(f5, f5);
                matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
                return;
            } else {
                float f6 = f2 / f4;
                matrix.preScale(f6, f6);
                matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f3 / f4 >= f / f2) {
            float f7 = f / f3;
            matrix.preScale(f7, f7);
            matrix.postTranslate(0.0f, (f2 - (f4 * f7)) / 2.0f);
        } else {
            float f8 = f2 / f4;
            matrix.preScale(f8, f8);
            matrix.postTranslate((f - (f3 * f8)) / 2.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.e.removeCallbacksAndMessages(null);
    }

    private void w(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo() {
        v();
        this.e.postDelayed(this.l, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg() {
        e();
        this.yo.postDelayed(this.ra, 500L);
    }

    @MainThread
    public void c() {
        this.p = false;
        this.c.q();
    }

    public boolean kd() {
        return this.c.ra();
    }

    public void setMaxFrame(String str) {
        this.c.w(str);
    }

    public void setMinFrame(String str) {
        this.c.hf(str);
    }

    @MainThread
    public void y() {
        this.g.add(u.PLAY_OPTION);
        this.c.ai();
    }

    private com.bytedance.adsdk.lottie.model.layer.y w(String str) {
        com.bytedance.adsdk.lottie.model.layer.u w2;
        f fVar = this.c;
        if (fVar == null || (w2 = fVar.w()) == null) {
            return null;
        }
        return xj(w2, str);
    }

    public void setAnimation(String str) {
        this.f = str;
        this.d = 0;
        setCompositionTask(hf(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j) {
        Map<String, Object> map;
        y.hf globalConfig = getGlobalConfig();
        if (this.f10034a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(MediationConstant.EXTRA_DURATION, Long.valueOf(j));
            if (globalConfig != null && (map = globalConfig.hf) != null && !map.isEmpty()) {
                hashMap.putAll(globalConfig.hf);
            }
            this.f10034a.xj(hashMap);
        }
    }

    public void w() {
        this.c.yo();
    }

    public void u() {
        this.c.v();
    }

    private d xj(String str) {
        f fVar;
        y x;
        Map<String, d> e;
        if (TextUtils.isEmpty(str) || (fVar = this.c) == null || (x = fVar.x()) == null || (e = x.e()) == null) {
            return null;
        }
        return e.get(str);
    }

    private void hf(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 < f && f4 < f2) {
            matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
            return;
        }
        if (f3 / f4 >= f / f2) {
            float f5 = f / f3;
            matrix.preScale(f5, f5);
            matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
        } else {
            float f6 = f2 / f4;
            matrix.preScale(f6, f6);
            matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
        }
    }

    private void xj(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i < 0 || i2 < 0) {
                return;
            }
            com.bytedance.sdk.component.utils.pl.xj("TMe", "--==--- inel enter, play anim, startframe: " + i);
            v();
            xj();
            setFrame(i);
            xj(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.13
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i2 - 1 || LottieAnimationView.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    com.bytedance.sdk.component.utils.pl.xj("TMe", "--==--- inel enter, play anim end, endframe: " + i2 + ", realFrame: " + LottieAnimationView.this.getFrame());
                    LottieAnimationView.this.hf(this);
                    LottieAnimationView.this.c();
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    private g<y> hf(final String str) {
        if (isInEditMode()) {
            return new g<>(new Callable<pl<y>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public pl<y> call() {
                    return LottieAnimationView.this.f10036pl ? c.w(LottieAnimationView.this.getContext(), str) : c.w(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.f10036pl ? c.hf(getContext(), str) : c.hf(getContext(), str, (String) null);
    }

    private String hf(int i) {
        int i2 = i / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int i3 = i % SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int i4 = i3 / 60;
        int i5 = i3 % 60;
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            sb.append(Constants.FAIL);
        }
        sb.append(i2);
        sb.append(":");
        if (i4 < 10) {
            sb.append(Constants.FAIL);
        }
        sb.append(i4);
        sb.append(":");
        if (i5 < 10) {
            sb.append(Constants.FAIL);
        }
        sb.append(i5);
        return sb.toString();
    }

    private void xj(String str, String str2, JSONArray jSONArray) {
        hf hfVar;
        y.w globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.xj;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.w;
            }
        }
        if ((!TextUtils.isEmpty(str2) || (jSONArray != null && jSONArray.length() > 0)) && (hfVar = this.ff) != null) {
            hfVar.xj(str2, jSONArray);
        }
    }

    private void xj(y.xj xjVar) {
        xjVar.kd = com.bytedance.adsdk.lottie.kd.d.xj("x", xjVar.xj, getWidth());
        xjVar.y = com.bytedance.adsdk.lottie.kd.d.xj("y", xjVar.hf, getHeight());
        xjVar.c = com.bytedance.adsdk.lottie.kd.d.xj((String) null, xjVar.w, getWidth());
        xjVar.f = com.bytedance.adsdk.lottie.kd.d.xj((String) null, xjVar.u, getHeight());
    }

    @MainThread
    public void hf() {
        this.g.add(u.PLAY_OPTION);
        this.c.am();
    }

    public void hf(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.c.hf(animatorUpdateListener);
    }

    private com.bytedance.adsdk.lottie.model.layer.w xj(MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.u w2;
        f fVar = this.c;
        if (fVar == null || (w2 = fVar.w()) == null) {
            return null;
        }
        return xj(w2, motionEvent);
    }

    public void hf(Animator.AnimatorListener animatorListener) {
        this.c.hf(animatorListener);
    }

    private com.bytedance.adsdk.lottie.model.layer.w xj(com.bytedance.adsdk.lottie.model.layer.u uVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.w xj2;
        for (com.bytedance.adsdk.lottie.model.layer.w wVar : uVar.am()) {
            if (wVar instanceof com.bytedance.adsdk.lottie.model.layer.u) {
                if (wVar.tf() && wVar.f() > 0.0f) {
                    RectF rectF = new RectF();
                    wVar.xj(rectF, wVar.y(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (xj2 = xj((com.bytedance.adsdk.lottie.model.layer.u) wVar, motionEvent)) != null) {
                        return xj2;
                    }
                }
            } else if (wVar.tf() && wVar.f() > 0.0f) {
                RectF rectF2 = new RectF();
                f fVar = this.c;
                if (fVar != null && fVar.f()) {
                    wVar.xj(rectF2, wVar.y(), true);
                    RectF j = this.c.j();
                    if (j != null) {
                        xj(rectF2, j);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    wVar.xj(rectF3, wVar.y(), true);
                    hf(rectF2, rectF3);
                }
                if (xj(motionEvent, rectF2)) {
                    return wVar;
                }
            }
        }
        return null;
    }

    private boolean xj(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void xj(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        if (width == 0.0f || height == 0.0f || width2 == 0.0f || height2 == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass6.xj[getScaleType().ordinal()];
        if (i == 1) {
            xj(matrix, width, height, width2, height2);
        } else if (i == 2) {
            hf(matrix, width, height, width2, height2);
        } else if (i == 3) {
            w(matrix, width, height, width2, height2);
        } else if (i == 4) {
            u(matrix, width, height, width2, height2);
        }
        matrix.mapRect(rectF);
    }

    private void xj(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 / f4 >= f / f2) {
            float f5 = f2 / f4;
            matrix.preScale(f5, f5);
            matrix.postTranslate(-(((f3 * f5) - f) / 2.0f), 0.0f);
        } else {
            float f6 = f / f3;
            matrix.preScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f4 * f6) - f2) / 2.0f));
        }
    }

    public void xj(boolean z, Context context) {
        this.c.xj(z, context);
    }

    private g<y> xj(@RawRes final int i) {
        if (isInEditMode()) {
            return new g<>(new Callable<pl<y>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.14
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public pl<y> call() {
                    return LottieAnimationView.this.f10036pl ? c.hf(LottieAnimationView.this.getContext(), i) : c.hf(LottieAnimationView.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.f10036pl ? c.xj(getContext(), i) : c.xj(getContext(), i, (String) null);
    }

    public void xj(String str, String str2) {
        xj(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void xj(InputStream inputStream, String str) {
        setCompositionTask(c.xj(inputStream, str));
    }

    private com.bytedance.adsdk.lottie.model.layer.y xj(com.bytedance.adsdk.lottie.model.layer.u uVar, String str) {
        for (com.bytedance.adsdk.lottie.model.layer.w wVar : uVar.am()) {
            if (wVar instanceof com.bytedance.adsdk.lottie.model.layer.u) {
                com.bytedance.adsdk.lottie.model.layer.y xj2 = xj((com.bytedance.adsdk.lottie.model.layer.u) wVar, str);
                if (xj2 != null) {
                    return xj2;
                }
            } else if (TextUtils.equals(str, wVar.p()) && (wVar instanceof com.bytedance.adsdk.lottie.model.layer.y)) {
                return (com.bytedance.adsdk.lottie.model.layer.y) wVar;
            }
        }
        return null;
    }

    @MainThread
    public void xj() {
        if (this.pz == 0) {
            this.pz = SystemClock.elapsedRealtime();
        }
        this.g.add(u.PLAY_OPTION);
        this.c.pl();
    }

    public void xj(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.c.xj(animatorUpdateListener);
    }

    public void xj(Animator.AnimatorListener animatorListener) {
        this.c.xj(animatorListener);
    }

    @Deprecated
    public void xj(boolean z) {
        this.c.kd(z ? -1 : 0);
    }

    public Bitmap xj(String str, Bitmap bitmap) {
        return this.c.xj(str, bitmap);
    }

    private void xj(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        if (z) {
            this.g.add(u.SET_PROGRESS);
        }
        this.c.u(f);
    }
}
