package com.sigmob.sdk.base.common;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.IntentActions;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    protected Context f13143a;
    protected String b;
    protected RelativeLayout c;
    protected k d;
    protected g e;
    private ImageView f;
    private RelativeLayout g;
    private final WeakReference<Activity> h;
    private a i;

    public interface a {
        void onAdClicked();
    }

    public j(Activity activity, String str, k kVar) {
        this.f13143a = activity.getApplicationContext();
        this.h = new WeakReference<>(activity);
        this.b = str;
        this.d = kVar;
        this.c = new RelativeLayout(this.f13143a);
    }

    private void a() {
        ViewGroup viewGroup;
        View childAt;
        Activity c = com.sigmob.sdk.b.c();
        ViewGroup m = m();
        if (c == null || m == null || (viewGroup = (ViewGroup) c.getWindow().findViewById(R.id.content)) == null || (childAt = viewGroup.getChildAt(0)) == null) {
            return;
        }
        com.sigmob.sdk.base.blurkit.a.a(this.f13143a);
        Bitmap a2 = com.sigmob.sdk.base.blurkit.a.a().a(childAt, 25);
        if (this.f == null) {
            this.f = new ImageView(this.f13143a);
        }
        this.f.setImageBitmap(a2);
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public void b() {
        WindowManager.LayoutParams attributes = n().getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        n().getWindow().setAttributes(attributes);
    }

    public void c() {
        try {
            a();
            ImageView imageView = this.f;
            if (imageView == null) {
                return;
            }
            this.c.addView(imageView, 0, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ImageView imageView = this.f;
        if (imageView == null) {
            return;
        }
        try {
            com.sigmob.sdk.base.utils.r.a(imageView);
            this.f = null;
        } catch (Throwable unused) {
        }
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public void h() {
        this.d = null;
        if (Build.VERSION.SDK_INT >= 23) {
            Activity n = n();
            if (com.sigmob.sdk.base.utils.q.b(n)) {
                n.getWindow().getDecorView().setOnApplyWindowInsetsListener(null);
            }
        }
        if (com.sigmob.sdk.base.utils.q.b(this.c)) {
            this.c.removeAllViews();
        }
    }

    public abstract void i();

    public boolean j() {
        return true;
    }

    public k k() {
        return this.d;
    }

    public Context l() {
        return this.f13143a;
    }

    public ViewGroup m() {
        RelativeLayout relativeLayout = this.g;
        return relativeLayout == null ? this.c : relativeLayout;
    }

    public Activity n() {
        Activity c = com.sigmob.sdk.base.utils.r.c(this.c);
        if (c != null) {
            return c;
        }
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public abstract void o();

    public void a(int i, int i2, Intent intent) {
    }

    public void a(Context context, int i, Bundle bundle) {
        g gVar;
        if (bundle == null) {
            return;
        }
        try {
            if (bundle.getBoolean(com.sigmob.sdk.base.n.y, false)) {
                int i2 = context.getResources().getDisplayMetrics().widthPixels;
                int i3 = context.getResources().getDisplayMetrics().heightPixels;
                if (i == 6) {
                    int min = (Math.min(i2, i3) * 85) / 100;
                    gVar = new g((min * 16) / 9, min);
                } else {
                    int min2 = (Math.min(i2, i3) * 85) / 100;
                    gVar = new g(min2, (min2 * 16) / 9);
                }
                this.e = gVar;
                this.g = new RelativeLayout(context);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e.a(), this.e.b());
                layoutParams.addRule(13);
                this.g.setLayoutParams(layoutParams);
                this.c.removeAllViews();
                this.c.addView(this.g);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Activity n = n();
        if (n == null) {
            return;
        }
        n.getWindow().getDecorView().setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a(String str) {
        String str2 = this.b;
        if (str2 == null) {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
            return;
        }
        BaseBroadcastReceiver.a(this.f13143a, str2, str);
        if (com.sigmob.sdk.base.utils.q.b(this.i) && com.sigmob.sdk.base.utils.o.b(str) && str.equals(IntentActions.ACTION_INTERSTITIAL_CLICK)) {
            this.i.onAdClicked();
        }
    }

    public void a(String str, int i) {
        String str2 = this.b;
        if (str2 == null) {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        } else {
            BaseBroadcastReceiver.a(this.f13143a, str2, str, i);
        }
    }

    public void a(String str, Map<String, Object> map) {
        String str2 = this.b;
        if (str2 == null) {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        } else {
            BaseBroadcastReceiver.a(this.f13143a, str2, map, str, 0);
        }
    }

    public boolean a(Dialog dialog) {
        if (dialog == null) {
            return false;
        }
        return dialog.isShowing();
    }
}
