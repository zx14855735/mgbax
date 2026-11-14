package com.sigmob.sdk.base.views;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private final BaseAdUnit f13252a;
    private final a b;

    public interface a {
        void a();

        void b();
    }

    public af(BaseAdUnit baseAdUnit, a aVar) {
        this.f13252a = baseAdUnit;
        this.b = aVar;
    }

    @JavascriptInterface
    public boolean canInstall(String str) {
        if (this.f13252a == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f13252a.getApkMd5())) {
                str = "";
            } else {
                str = this.f13252a.getApkMd5() + ".apk";
            }
            if (!TextUtils.isEmpty(this.f13252a.getApkName())) {
                str = this.f13252a.getApkName();
            }
        }
        return this.f13252a.canInstall(str);
    }

    @JavascriptInterface
    public boolean canOpen(String str) {
        BaseAdUnit baseAdUnit;
        return (!TextUtils.isEmpty(str) || (baseAdUnit = this.f13252a) == null) ? com.sigmob.sdk.base.o.a().b(str).booleanValue() : baseAdUnit.canOpen();
    }

    @JavascriptInterface
    public int getInteractionType() {
        BaseAdUnit baseAdUnit = this.f13252a;
        if (baseAdUnit == null) {
            return 0;
        }
        return baseAdUnit.getInteractionType();
    }

    @JavascriptInterface
    public int getSubInteractionType() {
        BaseAdUnit baseAdUnit = this.f13252a;
        if (baseAdUnit == null) {
            return 0;
        }
        return baseAdUnit.getsubInteractionType();
    }

    @JavascriptInterface
    public void hideSystemUI() {
        if (com.sigmob.sdk.base.utils.q.b(this.b)) {
            this.b.b();
        }
    }

    @JavascriptInterface
    public boolean isOpenListReport() {
        com.sigmob.sdk.base.o a2 = com.sigmob.sdk.base.o.a();
        return (a2.V().isEmpty() || com.sigmob.sdk.base.services.b.a() || !a2.N().booleanValue()) ? false : true;
    }

    @JavascriptInterface
    public void onOpenListReport() {
        com.sigmob.sdk.base.services.b.c();
    }

    @JavascriptInterface
    public void showSystemUI() {
        if (com.sigmob.sdk.base.utils.q.b(this.b)) {
            this.b.a();
        }
    }
}
