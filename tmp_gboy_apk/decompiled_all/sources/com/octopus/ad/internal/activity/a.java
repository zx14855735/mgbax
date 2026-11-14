package com.octopus.ad.internal.activity;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.octopus.ad.AdActivity;
import com.octopus.ad.R;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.internal.video.AdVideoView;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import com.octopus.ad.internal.view.b;
import com.octopus.ad.internal.view.d;
import com.octopus.ad.utils.b.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements AdActivity.a {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f12425a;
    private com.octopus.ad.internal.view.a b;
    private b c;
    private FrameLayout d;
    private FrameLayout.LayoutParams e;
    private long f;
    private InterstitialAdViewImpl g;

    public a(Activity activity) {
        this.f12425a = activity;
    }

    @Override // com.octopus.ad.AdActivity.a
    public void a() {
        InterstitialAdViewImpl interstitialAdViewImpl = InterstitialAdViewImpl.t;
        if (interstitialAdViewImpl == null || interstitialAdViewImpl.getAdQueue() == null) {
            this.f12425a.finish();
            return;
        }
        d peek = InterstitialAdViewImpl.t.getAdQueue().peek();
        if (peek == null || peek.c() == null) {
            this.f12425a.finish();
            return;
        }
        try {
            WindowManager.LayoutParams attributes = this.f12425a.getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            this.f12425a.getWindow().setAttributes(attributes);
            com.octopus.ad.internal.view.a c = peek.c();
            if (c.q()) {
                this.f12425a.setTheme(R.style.OctopusDialogStyle);
            } else {
                this.f12425a.setTheme(R.style.OctopusDialogStyleTran);
            }
            if (c.p()) {
                this.f12425a.setTheme(R.style.OctopusTheme_Black);
                ViewUtil.hideSystemTitleBarUI(this.f12425a);
            }
            this.d = new FrameLayout(this.f12425a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
            this.e = layoutParams;
            this.d.setLayoutParams(layoutParams);
            this.f12425a.setContentView(this.d);
            this.f = this.f12425a.getIntent().getLongExtra("TIME", System.currentTimeMillis());
            a(InterstitialAdViewImpl.t);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            this.f12425a.finish();
        }
    }

    @Override // com.octopus.ad.AdActivity.a
    public void b() {
        com.octopus.ad.internal.view.a aVar = this.b;
        if (aVar != null) {
            AdVideoView adVideoView = aVar.d;
            if (adVideoView != null) {
                adVideoView.n();
            }
            InterstitialAdViewImpl interstitialAdViewImpl = this.g;
            if (interstitialAdViewImpl != null) {
                interstitialAdViewImpl.onResumeLifeCycle();
            }
        }
    }

    @Override // com.octopus.ad.AdActivity.a
    public void c() {
        com.octopus.ad.internal.view.a aVar = this.b;
        if (aVar != null) {
            AdVideoView adVideoView = aVar.d;
            if (adVideoView != null) {
                adVideoView.m();
            }
            InterstitialAdViewImpl interstitialAdViewImpl = this.g;
            if (interstitialAdViewImpl != null) {
                interstitialAdViewImpl.onPauseLifeCycle();
            }
        }
    }

    @Override // com.octopus.ad.AdActivity.a
    public void d() {
        com.octopus.ad.internal.view.a aVar = this.b;
        if (aVar != null) {
            ViewUtil.removeChildFromParent(aVar.c);
            this.b.k();
            AdVideoView adVideoView = this.b.d;
            if (adVideoView != null) {
                adVideoView.k();
            }
        }
        InterstitialAdViewImpl interstitialAdViewImpl = this.g;
        if (interstitialAdViewImpl != null) {
            interstitialAdViewImpl.setAdImplementation(null);
            this.g.onDestroyLifeCycle();
            this.g.destroy();
            this.g = null;
        }
        this.f12425a.finish();
    }

    @Override // com.octopus.ad.AdActivity.a
    public void e() {
    }

    public void f() {
        b c;
        b bVar;
        com.octopus.ad.internal.view.a aVar = this.b;
        if (aVar == null || (c = aVar.c()) == (bVar = this.c)) {
            return;
        }
        this.d.removeView(bVar.getView());
        if (c instanceof AdVideoView) {
            this.d.addView(c.getView(), new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.d.addView(c.getView(), new ViewGroup.LayoutParams(-1, -1));
        }
        this.c = c;
        c.l();
    }

    private void a(InterstitialAdViewImpl interstitialAdViewImpl) {
        int i;
        int creativeWidth;
        float creativeHeight;
        float f;
        this.g = interstitialAdViewImpl;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setAdImplementation(this);
        this.d.setBackgroundColor(this.g.getBackgroundColor());
        this.d.removeAllViews();
        if (this.g.getParent() != null) {
            ((ViewGroup) this.g.getParent()).removeAllViews();
        }
        d poll = this.g.getAdQueue().poll();
        while (poll != null && (this.f - poll.a() > q.s || this.f - poll.a() < 0)) {
            HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.too_old));
            poll = this.g.getAdQueue().poll();
        }
        if (poll == null || poll.c() == null) {
            return;
        }
        com.octopus.ad.internal.view.a c = poll.c();
        this.b = c;
        if (c.a() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.b.a()).setBaseContext(this.f12425a);
            AdVideoView adVideoView = this.b.d;
            if (adVideoView != null) {
                ((MutableContextWrapper) adVideoView.getContext()).setBaseContext(this.f12425a);
            }
        }
        if ((this.b.getCreativeWidth() != 1 || this.b.getCreativeHeight() != 1) && this.f12425a.getResources().getConfiguration().orientation != 2) {
            try {
                i = this.g.getAdParameters().b().getApplicationInfo().targetSdkVersion;
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
                i = 0;
            }
            if (i <= 26 || Build.VERSION.SDK_INT != 26) {
                AdActivity.a(this.f12425a, this.b.s());
            }
        }
        this.c = this.b.c();
        View view = this.b.c().getView();
        if (view instanceof AdVideoView) {
            FrameLayout frameLayout = new FrameLayout(this.f12425a);
            frameLayout.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
            frameLayout.addView(view, this.e);
            view = frameLayout;
        }
        if (this.b.p()) {
            this.d.addView(view, this.e);
        } else {
            if (this.f12425a.getRequestedOrientation() == 0) {
                creativeWidth = (int) (this.b.getCreativeHeight() * q.a().o);
                creativeHeight = this.b.getCreativeWidth();
                f = q.a().p;
            } else {
                creativeWidth = (int) (this.b.getCreativeWidth() * q.a().o);
                creativeHeight = this.b.getCreativeHeight();
                f = q.a().p;
            }
            int i2 = (int) (creativeHeight * f);
            int screenWidth = ViewUtil.getScreenWidth(this.b.a());
            if (creativeWidth > screenWidth || creativeWidth <= 0) {
                creativeWidth = screenWidth;
            }
            int screenHeight = ViewUtil.getScreenHeight(this.b.a());
            if (i2 > screenHeight || i2 <= 0) {
                i2 = screenHeight;
            }
            this.d.addView(view, new FrameLayout.LayoutParams(creativeWidth, i2, 17));
            this.d.setLayoutParams(new FrameLayout.LayoutParams(screenWidth, screenHeight, 17));
        }
        this.c.l();
    }
}
