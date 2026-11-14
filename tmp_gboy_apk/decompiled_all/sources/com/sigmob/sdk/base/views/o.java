package com.sigmob.sdk.base.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class o extends g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13314a = "o";
    private final com.sigmob.sdk.base.views.b b;
    private a c;

    public interface a {
        void onWebViewClick(MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    public class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        MotionEvent f13315a;
        private boolean c;

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.c = true;
                this.f13315a = MotionEvent.obtain(motionEvent);
                return false;
            }
            if (action == 1 && this.c) {
                this.c = false;
                if (o.this.c != null) {
                    o.this.c.onWebViewClick(this.f13315a, motionEvent);
                }
            }
            return false;
        }
    }

    private o(Context context, String str, boolean z, boolean z2) {
        super(context);
        j();
        com.sigmob.sdk.base.utils.h.a(f13314a, getSettings());
        a(true);
        setBackgroundColor(0);
        if (z) {
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            com.sigmob.sdk.base.views.b bVar = new com.sigmob.sdk.base.views.b(getContext().getApplicationContext(), 1);
            this.b = bVar;
            bVar.a(str);
            bVar.b(com.sigmob.sdk.base.k.h());
            addView(bVar, layoutParams);
        } else {
            this.b = null;
        }
        setOnTouchListener(new b());
    }

    private void j() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    @Override // com.sigmob.sdk.base.views.g, android.webkit.WebView
    public void destroy() {
        SigmobLog.d("CreativeWebView destroy() callSigmobLog.d( \"CreativeWebView destroy() called\");ed");
        super.destroy();
        removeAllViews();
    }

    public void setLogoClickListener(View.OnClickListener onClickListener) {
        com.sigmob.sdk.base.views.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.setOnClickListener(onClickListener);
    }

    public void setWebViewClickListener(a aVar) {
        this.c = aVar;
    }

    public static o a(Context context, String str, boolean z, boolean z2) {
        Preconditions.NoThrow.checkNotNull(context);
        return new o(context, str, z, z2);
    }

    public void a(String str) {
        File b2 = com.sigmob.sdk.base.utils.k.b(str, Md5Util.md5(str) + ".html");
        if (b2 != null && !TextUtils.isEmpty(b2.getAbsolutePath())) {
            loadUrl("file://" + b2.getAbsolutePath());
        } else {
            loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "utf-8", null);
        }
    }
}
