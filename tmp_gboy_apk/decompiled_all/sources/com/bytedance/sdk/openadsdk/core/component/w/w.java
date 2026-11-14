package com.bytedance.sdk.openadsdk.core.component.w;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.jk;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.x.c;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends com.bytedance.sdk.openadsdk.zg.w.xj implements LazeLayout.xj<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.xj<NativeVideoTsView> {
    private final ws c;
    private LazeLayout d;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf f;
    private Bitmap hf;
    private u kd;
    private UpieImageView p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj f10342pl;
    private volatile WeakReference<NativeVideoTsView> tf;
    private com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj u;
    private int w;
    private boolean xj;
    private final Context y;

    public w(Context context, ws wsVar, int i, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        super(new u(context, wsVar, i, hfVar));
        this.d = null;
        this.tf = null;
        this.f10342pl = new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(null) { // from class: com.bytedance.sdk.openadsdk.core.component.w.w.3
            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void hf(View view, g gVar) {
                NativeVideoTsView io2 = w.this.kd.io();
                if (io2 != null) {
                    io2.tf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(View view, g gVar) {
                NativeVideoTsView io2 = w.this.kd.io();
                if (io2 != null) {
                    io2.tf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(g gVar) {
                NativeVideoTsView io2 = w.this.kd.io();
                if (io2 != null) {
                    io2.v();
                }
            }
        };
        this.f = hfVar;
        u uVar = (u) io();
        this.kd = uVar;
        this.c = wsVar;
        this.y = context;
        ((com.bytedance.sdk.openadsdk.core.dk.u) uVar.en()).xj(this.f10342pl);
        if (context == null || this.kd.z() || !com.bytedance.sdk.openadsdk.kd.xj.f(wsVar)) {
            return;
        }
        this.p = new UpieImageView(context, com.bytedance.sdk.openadsdk.kd.xj.d(wsVar), null);
    }

    private void ai() {
        int i = this.w;
        if (i >= 200) {
            this.w = 200;
        } else if (i <= 20) {
            this.w = 20;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.xj, com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void dk() {
        NativeVideoTsView nativeVideoTsView;
        super.dk();
        if (this.tf != null && (nativeVideoTsView = this.tf.get()) != null) {
            nativeVideoTsView.v();
        }
        LazeLayout lazeLayout = this.d;
        if (lazeLayout != null) {
            lazeLayout.xj();
        }
        UpieImageView upieImageView = this.p;
        if (upieImageView != null) {
            upieImageView.setOnClickListener(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public kd et() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.xj, com.bytedance.sdk.openadsdk.zg.w.hf.g
    public View pz() {
        NativeVideoTsView nativeVideoTsView = null;
        if (this.c == null || this.y == null) {
            return null;
        }
        if (this.kd.z()) {
            if (!c.xj()) {
                try {
                    nativeVideoTsView = hf(this.y);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsView != null) {
                    xj(nativeVideoTsView);
                }
                return nativeVideoTsView;
            }
            this.d = new LazeLayout(this.y, this, this);
        } else if (this.p != null) {
            com.bytedance.sdk.openadsdk.core.dk.u uVar = (com.bytedance.sdk.openadsdk.core.dk.u) this.kd.en();
            if (uVar != null && uVar.u() != null) {
                uVar.u().xj(this.p);
            }
            return this.p;
        }
        com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.c).xj(this.kd.x()).hf(this.kd.ai());
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.xj
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView hf(Context context) {
        NativeVideoTsView xj = this.kd.xj(true);
        xj.setControllerStatusCallBack(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.w.w.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
            public void xj(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                w.this.kd.xj.xj = z;
                w.this.kd.xj.kd = j;
                w.this.kd.xj.y = j2;
                w.this.kd.xj.c = j3;
                w.this.kd.xj.u = z2;
                w.this.kd.xj.f = z3;
            }
        });
        xj.setAdCreativeClickListener(new NativeVideoTsView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.w.w.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xj
            public void xj(View view, int i) {
                jk u = ((com.bytedance.sdk.openadsdk.core.dk.u) w.this.kd.en()).u();
                if (u != null) {
                    u.xj(view, i);
                }
            }
        });
        xj.setVideoAdLoadListener(this.kd);
        xj.setVideoAdInteractionListener(this.kd);
        int d = wo.d(this.c);
        xj.setIsAutoPlay(xj(d));
        xj.setIsQuiet(pz.hf().u(d));
        NativeDrawVideoTsView nativeDrawVideoTsView = (NativeDrawVideoTsView) xj;
        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.xj);
        Bitmap bitmap = this.hf;
        if (bitmap != null) {
            nativeDrawVideoTsView.xj(bitmap, this.w);
        }
        xj.setDrawVideoListener(this.u);
        this.tf = new WeakReference<>(xj);
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.xj
    public void xj(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.xj(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar, com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar) {
        View pz;
        try {
            xj(viewGroup, (List<View>) null, list, list2, list3, (View) null, xjVar);
            if (uVar != null) {
                View findViewById = viewGroup.findViewById(uVar.pl());
                if (findViewById != null && y() != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ((ViewGroup) findViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(y());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = r.w(viewGroup.getContext(), 38.0f);
                        layoutParams.height = r.w(viewGroup.getContext(), 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) findViewById).addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(y());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(uVar.c());
                if (frameLayout != null && (pz = pz()) != null) {
                    r.f(pz);
                    frameLayout.removeAllViews();
                    frameLayout.addView(pz, -1, -1);
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar) {
        u uVar = this.kd;
        if (uVar != null) {
            uVar.xj(hfVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.d
    public void xj(boolean z) {
        this.xj = z;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.d
    public void xj(Bitmap bitmap, int i) {
        this.hf = bitmap;
        this.w = i;
        ai();
    }

    private boolean xj(int i) {
        int c = pz.hf().c(i);
        if (3 == c) {
            return false;
        }
        if (1 != c || !am.u(this.y)) {
            if (2 == c) {
                if (!am.kd(this.y) && !am.u(this.y)) {
                    am.y(this.y);
                }
                return true;
            }
            if (5 == c && !am.u(this.y)) {
                am.y(this.y);
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.d
    public void xj(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar) {
        this.u = xjVar;
    }
}
