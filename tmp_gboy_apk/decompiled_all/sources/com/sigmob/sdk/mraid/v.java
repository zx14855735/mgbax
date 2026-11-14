package com.sigmob.sdk.mraid;

import android.content.Context;
import android.os.Build;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class v extends com.sigmob.sdk.base.views.g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13500a = 1;
    private a b;
    private boolean c;

    public interface a {
        void onVisibilityChanged(boolean z);
    }

    public v(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT <= 22) {
            this.c = getVisibility() == 0;
        }
    }

    private void setMraidViewable(boolean z) {
        if (this.c == z) {
            return;
        }
        this.c = z;
        a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.onVisibilityChanged(z);
    }

    @Override // com.sigmob.sdk.base.views.g, android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.b = null;
    }

    public boolean j() {
        return this.c;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            return;
        }
        setMraidViewable(false);
    }

    public void setVisibilityChangedListener(a aVar) {
        this.b = aVar;
    }
}
