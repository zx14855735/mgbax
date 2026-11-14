package com.octopus.ad.internal.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.octopus.ad.internal.j;
import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.ImageManager;
import com.octopus.ad.internal.utilities.StringUtil;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.internal.video.AdVideoView;
import com.octopus.ad.internal.view.e;
import com.octopus.ad.model.g;
import com.octopus.ad.utils.ThreadUtils;
import com.octopus.ad.utils.d;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public AdViewImpl f12591a;
    public FrameLayout c;
    private final Context f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean e = false;
    public ServerResponse b = null;
    public AdVideoView d = null;
    private int o = -1;
    private boolean p = true;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private int t = 0;

    /* renamed from: com.octopus.ad.internal.view.a$2, reason: invalid class name */
    public class AnonymousClass2 implements ImageManager.BitmapLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f12593a;

        public AnonymousClass2(ImageView imageView) {
            this.f12593a = imageView;
        }

        @Override // com.octopus.ad.internal.utilities.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
            AdViewImpl adViewImpl = a.this.f12591a;
            if (adViewImpl != null) {
                adViewImpl.b(false);
                a.this.f12591a.o();
            }
        }

        @Override // com.octopus.ad.internal.utilities.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(final Bitmap bitmap) {
            com.octopus.ad.utils.d.a(a.this.f, bitmap, new d.a() { // from class: com.octopus.ad.internal.view.a.2.1
                @Override // com.octopus.ad.utils.d.a
                public void a(final Bitmap bitmap2) {
                    ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.view.a.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (bitmap2 != null) {
                                    AnonymousClass2.this.f12593a.setBackground(new BitmapDrawable(a.this.f.getResources(), bitmap2));
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AnonymousClass2.this.f12593a.setImageBitmap(bitmap);
                                AdViewImpl adViewImpl = a.this.f12591a;
                                if (adViewImpl != null) {
                                    adViewImpl.b(true);
                                    a.this.f12591a.o();
                                }
                            } catch (Exception unused) {
                                AdViewImpl adViewImpl2 = a.this.f12591a;
                                if (adViewImpl2 != null) {
                                    adViewImpl2.b(false);
                                    a.this.f12591a.o();
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    public a(AdViewImpl adViewImpl) {
        this.f = new MutableContextWrapper(adViewImpl.getContext());
        this.f12591a = adViewImpl;
        adViewImpl.setAdWebView(this);
    }

    public b c() {
        AdVideoView adVideoView;
        return (!this.s || (adVideoView = this.d) == null) ? this : adVideoView;
    }

    public boolean d() {
        return this.b.ab() == g.a.ADP_REWARD ? this.b.m().get(this.o).first == j.VIDEO : this.o == 0;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.m;
    }

    @Override // com.octopus.ad.internal.view.b
    public a getAdWebView() {
        return this;
    }

    @Override // com.octopus.ad.internal.view.b
    public int getCreativeHeight() {
        return this.j;
    }

    @Override // com.octopus.ad.internal.view.b
    public int getCreativeWidth() {
        return this.i;
    }

    @Override // com.octopus.ad.internal.view.b
    public View getView() {
        return this.c;
    }

    public int h() {
        return this.n;
    }

    public boolean i() {
        return this.p;
    }

    @Override // com.octopus.ad.internal.view.b
    public boolean j() {
        return this.e;
    }

    @Override // com.octopus.ad.internal.view.b
    public void k() {
        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                AdViewImpl adViewImpl;
                a aVar = a.this;
                if (aVar.c == null || (adViewImpl = aVar.f12591a) == null || adViewImpl.getMediaType() == p.SPLASH) {
                    return;
                }
                a.this.c.removeAllViews();
                ViewUtil.removeChildFromParent(a.this.c);
            }
        });
    }

    @Override // com.octopus.ad.internal.view.b
    public void l() {
        AdViewImpl adViewImpl;
        FrameLayout frameLayout = this.c;
        if (frameLayout == null || (adViewImpl = this.f12591a) == null) {
            return;
        }
        adViewImpl.d(frameLayout);
        this.f12591a.c(this.c);
        this.f12591a.e(this.c);
        p mediaType = this.f12591a.getMediaType();
        p pVar = p.INTERSTITIAL;
        if (mediaType == pVar || this.f12591a.getMediaType() == p.FULLSCREEN) {
            this.f12591a.a(g(), h(), this.c);
        }
        p mediaType2 = this.f12591a.getMediaType();
        p pVar2 = p.REWARD;
        if (mediaType2 == pVar2) {
            this.f12591a.a(h(), g(), h());
        }
        if (this.f12591a.getAdDispatcher() != null) {
            if (this.f12591a.getMediaType() == pVar || this.f12591a.getMediaType() == p.FULLSCREEN || this.f12591a.getMediaType() == pVar2) {
                t();
            }
        }
    }

    @Override // com.octopus.ad.internal.view.b
    public void m() {
    }

    @Override // com.octopus.ad.internal.view.b
    public void n() {
    }

    @Override // com.octopus.ad.internal.view.b
    public void o() {
        k();
    }

    public boolean p() {
        return this.q;
    }

    public boolean q() {
        return this.r;
    }

    public void r() {
        this.e = true;
    }

    public int s() {
        return this.l;
    }

    public void t() {
        AdViewImpl adViewImpl;
        ServerResponse serverResponse = this.b;
        if (serverResponse == null || (adViewImpl = this.f12591a) == null) {
            return;
        }
        serverResponse.a(adViewImpl.g(), new com.octopus.ad.a() { // from class: com.octopus.ad.internal.view.a.4
            @Override // com.octopus.ad.a
            public void a(boolean z) {
                AdViewImpl adViewImpl2 = a.this.f12591a;
                if (adViewImpl2 == null || adViewImpl2.getAdDispatcher() == null) {
                    return;
                }
                a.this.f12591a.getAdDispatcher().a(z);
            }
        });
    }

    public int u() {
        return this.k;
    }

    private void g(int i) {
        this.i = i;
    }

    private void h(int i) {
        this.j = i;
    }

    public Context a() {
        return this.f;
    }

    public HashMap<String, Object> b() {
        ServerResponse serverResponse = this.b;
        if (serverResponse == null) {
            return null;
        }
        return serverResponse.v();
    }

    public void c(int i) {
        this.t = i;
    }

    public void d(int i) {
        this.g = i;
    }

    public void e(int i) {
        this.h = i;
    }

    public void f(int i) {
        this.k = i;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(ServerResponse serverResponse) {
        int i;
        if (serverResponse == null) {
            return;
        }
        this.b = serverResponse;
        h(serverResponse.n());
        g(serverResponse.o());
        d(serverResponse.F());
        e(serverResponse.E());
        f(serverResponse.H());
        if (serverResponse.B()) {
            this.m = serverResponse.C();
        } else {
            this.m = -1;
        }
        if (serverResponse.D() != 0) {
            this.n = serverResponse.D();
        } else {
            this.n = -1;
        }
        if (this.m == -1 && this.n == -1 && serverResponse.ab() != g.a.ADP_REWARD) {
            this.m = 0;
        } else {
            int i2 = this.m;
            if (i2 != -1 && (i = this.n) != -1 && i2 > i) {
                this.m = i;
            }
        }
        this.p = serverResponse.z();
        this.q = serverResponse.w();
        this.r = serverResponse.x();
        this.l = serverResponse.G();
        this.o = -1;
        boolean Q = serverResponse.Q();
        FrameLayout frameLayout = new FrameLayout(this.f);
        this.c = frameLayout;
        this.c.setOnTouchListener(new e(frameLayout, Q, new e.a() { // from class: com.octopus.ad.internal.view.a.1
            @Override // com.octopus.ad.internal.view.e.a
            public void a(View view, com.octopus.ad.model.d dVar) {
                a aVar = a.this;
                aVar.a(aVar.t, dVar);
            }
        }));
        b(0);
    }

    public boolean b(int i) {
        int creativeHeight;
        int creativeWidth;
        ServerResponse serverResponse = this.b;
        if (serverResponse != null && this.o != i) {
            if (!serverResponse.m().isEmpty() && this.b.m().size() > i) {
                Pair<j, String> pair = this.b.m().get(i);
                if (StringUtil.isEmpty((String) pair.second)) {
                    r();
                    return false;
                }
                if (pair.first == j.VIDEO) {
                    if (this.d == null) {
                        this.d = new AdVideoView(this);
                    }
                    this.d.a((String) pair.second);
                    this.s = true;
                } else {
                    float n = q.a().n();
                    float o = q.a().o();
                    float p = q.a().p();
                    if (getCreativeWidth() == -1 && getCreativeHeight() == -1) {
                        creativeWidth = -1;
                        creativeHeight = -1;
                    } else {
                        creativeHeight = (int) ((getCreativeHeight() * p) + 0.5f);
                        creativeWidth = (int) ((getCreativeWidth() * p) + 0.5f);
                    }
                    if (e() == 0 && f() == 0) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17);
                        if (this.b.l() == p.SPLASH) {
                            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
                            FrameLayout frameLayout = this.c;
                            if (frameLayout != null) {
                                frameLayout.setLayoutParams(layoutParams2);
                            }
                        } else {
                            a(layoutParams);
                        }
                    } else {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 8388659);
                        layoutParams3.setMargins((int) ((e() * n) + 0.5f), (int) ((f() * o) + 0.5f), 0, 0);
                        if (this.b.l() == p.SPLASH) {
                            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1, 17);
                            FrameLayout frameLayout2 = this.c;
                            if (frameLayout2 != null) {
                                frameLayout2.setLayoutParams(layoutParams4);
                            }
                        } else {
                            a(layoutParams3);
                        }
                    }
                    AdViewImpl adViewImpl = this.f12591a;
                    if (adViewImpl != null) {
                        adViewImpl.p = true;
                    }
                    ImageView imageView = new ImageView(this.f);
                    ImageManager.with(this.f).getBitmap((String) pair.second, new AnonymousClass2(imageView));
                    FrameLayout frameLayout3 = this.c;
                    if (frameLayout3 != null) {
                        frameLayout3.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                    this.s = false;
                }
                this.o = i;
                return true;
            }
            r();
        }
        return false;
    }

    public boolean a(int i) {
        return b(this.o + i);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.c;
        if (frameLayout != null) {
            AdViewImpl adViewImpl = this.f12591a;
            if (adViewImpl instanceof SplashAdViewImpl) {
                if (((SplashAdViewImpl) adViewImpl).getResizeAdToFitContainer()) {
                    this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                    return;
                } else {
                    this.c.setLayoutParams(layoutParams);
                    return;
                }
            }
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    public void a(int i, com.octopus.ad.model.d dVar) {
        AdViewImpl adViewImpl;
        if (this.b == null || (adViewImpl = this.f12591a) == null || adViewImpl.getAdDispatcher() == null || this.c == null) {
            return;
        }
        if (this.f12591a.g()) {
            this.f12591a.getAdDispatcher().b();
        }
        this.f12591a.setIsClicked(true);
        this.b.a(this.f12591a.getOpensNativeBrowser());
        this.b.a(this.f12591a.getSplashParent() == null ? this.c : this.f12591a.getSplashParent(), i, this.f12591a.g(), dVar);
    }
}
