package com.bytedance.sdk.component.y.w;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.y.am;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.jk;
import com.bytedance.sdk.component.y.pl;
import com.bytedance.sdk.component.y.q;
import com.bytedance.sdk.component.y.tf;
import com.bytedance.sdk.component.y.u.d;
import com.bytedance.sdk.component.y.zg;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements pl {
    private boolean ai;
    private boolean am;
    private Bitmap.Config c;
    private int d;
    private com.bytedance.sdk.component.y.w.xj dk;
    private int e;
    private com.bytedance.sdk.component.y.hf et;
    private int f;
    private volatile boolean g;
    private String hf;
    private int ht;

    /* renamed from: io, reason: collision with root package name */
    private int f10257io;
    private jk j;
    private boolean jk;
    private dk kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private WeakReference<ImageView> f10258pl;
    private com.bytedance.sdk.component.y.f pz;
    private ExecutorService q;
    private boolean qt;
    private y ra;
    private tf tf;
    private String u;
    private final Handler v;
    private String w;
    private int x;
    Future<?> xj;
    private ImageView.ScaleType y;
    private Queue<d> yo;
    private boolean z;
    private q zg;

    public class xj implements dk {
        private dk hf;

        public xj(dk dkVar) {
            this.hf = dkVar;
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onFailed(final int i, final String str, final Throwable th) {
            if (w.this.e == 5) {
                w.this.v.post(new Runnable() { // from class: com.bytedance.sdk.component.y.w.w.xj.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (xj.this.hf != null) {
                            xj.this.hf.onFailed(i, str, th);
                        }
                    }
                });
                return;
            }
            dk dkVar = this.hf;
            if (dkVar != null) {
                dkVar.onFailed(i, str, th);
            }
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onSuccess(final zg zgVar) {
            Bitmap coverterTo;
            final ImageView imageView = (ImageView) w.this.f10258pl.get();
            if (imageView != null && w.this.p != 3 && xj(imageView) && (zgVar.getResult() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) zgVar.getResult();
                w.this.v.post(new Runnable() { // from class: com.bytedance.sdk.component.y.w.w.xj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (w.this.tf != null && (zgVar.getResult() instanceof Bitmap) && (coverterTo = w.this.tf.coverterTo((Bitmap) zgVar.getResult())) != null) {
                    zgVar.setResult(coverterTo);
                }
            } catch (Throwable unused) {
            }
            if (w.this.e == 5) {
                w.this.v.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.y.w.w.xj.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (xj.this.hf != null) {
                            xj.this.hf.onSuccess(zgVar);
                        }
                    }
                });
                return;
            }
            dk dkVar = this.hf;
            if (dkVar != null) {
                dkVar.onSuccess(zgVar);
            }
        }

        private boolean xj(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(w.this.w)) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public pl e() {
        try {
            y yVar = this.ra;
            if (yVar == null) {
                dk dkVar = this.kd;
                if (dkVar != null) {
                    dkVar.onFailed(1005, "not init !", null);
                    return this;
                }
            } else {
                ExecutorService y = this.q == null ? yVar.y() : null;
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.y.w.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d dVar;
                        while (!w.this.g && (dVar = (d) w.this.yo.poll()) != null) {
                            try {
                                if (w.this.zg != null) {
                                    w.this.zg.onStepStart(dVar.xj(), w.this);
                                }
                                dVar.xj(w.this);
                                if (w.this.zg != null) {
                                    w.this.zg.onStepEnd(dVar.xj(), w.this);
                                }
                            } catch (Throwable th) {
                                w.this.xj(2000, th.getMessage(), th);
                                if (w.this.zg != null) {
                                    w.this.zg.onStepEnd("exception", w.this);
                                    return;
                                }
                                return;
                            }
                        }
                        if (w.this.g) {
                            w.this.xj(1003, "canceled", null);
                        }
                    }
                };
                if (this.z) {
                    runnable.run();
                    return this;
                }
                ExecutorService executorService = this.q;
                if (executorService != null) {
                    this.xj = executorService.submit(runnable);
                    return this;
                }
                if (y != null) {
                    this.xj = y.submit(runnable);
                    return this;
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("ImageRequest", e.getMessage());
        }
        return this;
    }

    public boolean am() {
        return this.ai;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public boolean cancelRequest() {
        this.g = true;
        Future<?> future = this.xj;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }

    public com.bytedance.sdk.component.y.hf g() {
        return this.et;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public Bitmap.Config getBitmapConfig() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public int getHeight() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public String getMemoryCacheKey() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public String getRawCacheKey() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public ImageView.ScaleType getScaleType() {
        return this.y;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public String getUrl() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.y.pl
    public int getWidth() {
        return this.f;
    }

    public com.bytedance.sdk.component.y.w.xj p() {
        return this.dk;
    }

    public y pl() {
        return this.ra;
    }

    public jk qt() {
        return this.j;
    }

    public String zg() {
        return getRawCacheKey();
    }

    public static class hf implements am {
        private String am;
        private int c;
        private tf e;
        private int f;
        private boolean g;
        private ImageView hf;
        private boolean ht;
        private boolean jk;
        private ImageView.ScaleType kd;
        private q p;

        /* renamed from: pl, reason: collision with root package name */
        private boolean f10259pl;
        private ExecutorService pz;
        private com.bytedance.sdk.component.y.hf qt;
        private jk ra;
        private String u;
        private int v;
        private String w;
        private dk xj;
        private Bitmap.Config y;
        private int yo;
        private y zg;
        private int d = 1;
        private int tf = 5;

        public hf(y yVar) {
            this.zg = yVar;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am cache(com.bytedance.sdk.component.y.hf hfVar) {
            this.qt = hfVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am cacheDir(String str) {
            this.am = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am config(Bitmap.Config config) {
            this.y = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am converter(tf tfVar) {
            this.e = tfVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am from(String str) {
            this.u = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am headers(boolean z) {
            this.f10259pl = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am height(int i) {
            this.f = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am key(String str) {
            this.w = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am loadSetp(jk jkVar) {
            this.ra = jkVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am maxHeight(int i) {
            this.v = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am maxWidth(int i) {
            this.yo = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am requestTime(boolean z) {
            this.g = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am runIn(ExecutorService executorService) {
            this.pz = executorService;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am scaleType(ImageView.ScaleType scaleType) {
            this.kd = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am sync(boolean z) {
            this.ht = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public pl to(dk dkVar, int i) {
            this.tf = i;
            return to(dkVar);
        }

        @Override // com.bytedance.sdk.component.y.am
        public am track(q qVar) {
            this.p = qVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am type(int i) {
            this.d = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public am width(int i) {
            this.c = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.y.am
        public pl to(dk dkVar) {
            this.xj = dkVar;
            return new w(this).e();
        }

        @Override // com.bytedance.sdk.component.y.am
        public pl to(ImageView imageView) {
            this.hf = imageView;
            return new w(this).e();
        }
    }

    private w(hf hfVar) {
        this.yo = new LinkedBlockingQueue();
        this.v = new Handler(Looper.getMainLooper());
        this.jk = true;
        this.hf = hfVar.u;
        this.kd = new xj(hfVar.xj);
        this.f10258pl = new WeakReference<>(hfVar.hf);
        this.y = hfVar.kd;
        this.c = hfVar.y;
        this.f = hfVar.c;
        this.d = hfVar.f;
        this.p = hfVar.d;
        this.e = hfVar.tf;
        this.zg = hfVar.p;
        this.et = xj(hfVar);
        if (!TextUtils.isEmpty(hfVar.w)) {
            hf(hfVar.w);
            xj(hfVar.w);
        }
        this.am = hfVar.f10259pl;
        this.qt = hfVar.g;
        this.ra = hfVar.zg;
        this.tf = hfVar.e;
        this.x = hfVar.v;
        this.f10257io = hfVar.yo;
        this.q = hfVar.pz;
        this.ai = hfVar.jk;
        this.z = hfVar.ht;
        this.j = hfVar.ra;
        this.yo.add(new com.bytedance.sdk.component.y.u.w());
    }

    public boolean c() {
        return this.qt;
    }

    public com.bytedance.sdk.component.y.f d() {
        return this.pz;
    }

    public boolean f() {
        return this.jk;
    }

    public int hf() {
        return this.x;
    }

    public int kd() {
        return this.p;
    }

    public int tf() {
        return this.ht;
    }

    public Bitmap.Config u() {
        return this.c;
    }

    public dk w() {
        return this.kd;
    }

    public boolean y() {
        return this.am;
    }

    private com.bytedance.sdk.component.y.hf xj(hf hfVar) {
        if (hfVar.qt != null) {
            return hfVar.qt;
        }
        if (!TextUtils.isEmpty(hfVar.am)) {
            return com.bytedance.sdk.component.y.w.xj.xj.xj(new File(hfVar.am));
        }
        return com.bytedance.sdk.component.y.w.xj.xj.xj();
    }

    public void hf(String str) {
        WeakReference<ImageView> weakReference = this.f10258pl;
        if (weakReference != null && weakReference.get() != null) {
            this.f10258pl.get().setTag(1094453505, str);
        }
        this.w = str;
    }

    public int xj() {
        return this.f10257io;
    }

    public void xj(String str) {
        this.u = str;
    }

    public void xj(boolean z) {
        this.jk = z;
    }

    public void xj(com.bytedance.sdk.component.y.f fVar) {
        this.pz = fVar;
    }

    public void xj(int i) {
        this.ht = i;
    }

    public void xj(com.bytedance.sdk.component.y.w.xj xjVar) {
        this.dk = xjVar;
    }

    public boolean xj(d dVar) {
        if (this.g) {
            return false;
        }
        return this.yo.add(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, String str, Throwable th) {
        new com.bytedance.sdk.component.y.u.f(i, str, th).xj(this);
        this.yo.clear();
    }
}
