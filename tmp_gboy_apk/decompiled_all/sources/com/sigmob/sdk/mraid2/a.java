package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.views.at;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class a extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, com.sigmob.sdk.mraid.n> f13535a = new LinkedHashMap();
    private static final String b = "BaseWebView2";
    private final Map<String, APKStatusBroadcastReceiver> c;
    private com.sigmob.sdk.base.views.g d;

    /* renamed from: com.sigmob.sdk.mraid2.a$a, reason: collision with other inner class name */
    public class C0460a {
        public C0460a() {
        }

        @JavascriptInterface
        public int cancelDownloadTaskByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && !a.this.getAdUnitList().isEmpty()) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Objects.toString(baseAdUnit);
            Context context = a.this.getContext();
            if (context == null || baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.o.c(context, baseAdUnit);
        }

        @JavascriptInterface
        public int getApKDownloadProcessId(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && !a.this.getAdUnitList().isEmpty()) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Objects.toString(baseAdUnit);
            if (baseAdUnit == null) {
                baseAdUnit = a.this.getAdUnitList().get(0);
            }
            Context context = a.this.getContext();
            if (context == null || baseAdUnit == null) {
                return -1;
            }
            long[] a2 = baseAdUnit.getApkDownloadType() == 0 ? com.sigmob.sdk.base.common.q.a(context, baseAdUnit.getDownloadId()) : com.sigmob.sdk.base.common.o.d(context, baseAdUnit);
            int i2 = (int) a2[2];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        return i2 != 8 ? -1 : 100;
                    }
                    return -2;
                }
                long j = a2[0];
                long j2 = a2[1];
                if (j2 != 0 && j != 0) {
                    return (int) ((j * 100) / j2);
                }
            }
            return 0;
        }

        @JavascriptInterface
        public int pauseDownloadByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && !a.this.getAdUnitList().isEmpty()) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Objects.toString(baseAdUnit);
            if (a.this.getContext() == null || baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.o.a(a.this.getContext(), baseAdUnit);
        }

        @JavascriptInterface
        public void registerDownloadEvent(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && !a.this.getAdUnitList().isEmpty()) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Objects.toString(baseAdUnit);
            if (baseAdUnit == null) {
                baseAdUnit = a.this.getAdUnitList().get(0);
            }
            a.this.a(baseAdUnit);
        }

        @JavascriptInterface
        public int resumeDownloadByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && !a.this.getAdUnitList().isEmpty()) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Objects.toString(baseAdUnit);
            Context context = a.this.getContext();
            if (context == null || baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.o.b(context, baseAdUnit);
        }
    }

    static {
        ukXv();
    }

    public a(Context context) {
        super(context);
        this.c = new HashMap();
        com.sigmob.sdk.base.views.g a2 = at.a().a(context);
        this.d = a2;
        if (a2 == null) {
            this.d = new com.sigmob.sdk.base.views.g(context);
        }
        this.d.addJavascriptInterface(new C0460a(), "sigandroidapk");
        addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    }

    private static /* synthetic */ void ukXv() {
        char[] charArray = "W[Y\u001aSUYQ\u001aV[M\u001aG\\QXX\u001a~Z]vF]PSQ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '4');
        }
        String str = new String(charArray);
        char[] charArray2 = "WX]Z]@".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '4');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void a() {
        if (!this.c.isEmpty()) {
            for (APKStatusBroadcastReceiver aPKStatusBroadcastReceiver : this.c.values()) {
                aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            }
            this.c.clear();
        }
        if (com.sigmob.sdk.base.utils.e.b(f13535a)) {
            for (com.sigmob.sdk.mraid.n nVar : f13535a.values()) {
                if (nVar != null) {
                    nVar.b();
                }
            }
            f13535a.clear();
        }
        if (this.d != null) {
            at.a().a(this.d);
            this.d = null;
        }
        removeAllViews();
    }

    public void b() {
        b("download_start");
    }

    public void c() {
        b("download_fail");
    }

    public void d() {
        b("download_pause");
    }

    public void e() {
        b(PointCategory.DOWNLOAD_END);
    }

    public void f() {
        b(com.sigmob.sdk.base.common.a.E);
    }

    public void g() {
        b("install_end");
    }

    public abstract List<BaseAdUnit> getAdUnitList();

    public WebSettings getSettings() {
        return this.d.getSettings();
    }

    public void h() {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.reload();
    }

    public void i() {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.stopLoading();
    }

    public void j() {
        this.d.resumeTimers();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        this.d.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        this.d.setBackgroundColor(i);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.setWebViewClient(webViewClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        a("mraidbridge.notifyApkDownloadStateEvent(\"" + str + "\");", (ValueCallback) null);
    }

    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null && this.c.get(baseAdUnit.getUuid()) == null) {
            APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = new APKStatusBroadcastReceiver(new com.sigmob.sdk.base.common.b() { // from class: com.sigmob.sdk.mraid2.a.1
                @Override // com.sigmob.sdk.base.common.b
                public void a(boolean z) {
                    if (z) {
                        a.this.f();
                    } else {
                        a.this.c();
                    }
                }

                @Override // com.sigmob.sdk.base.common.b
                public void b(boolean z) {
                    if (z) {
                        a.this.g();
                    } else {
                        a.this.c();
                    }
                }

                @Override // com.sigmob.sdk.base.common.b
                public void c(boolean z, long j) {
                    a.this.d();
                }

                @Override // com.sigmob.sdk.base.common.b
                public void a(boolean z, long j) {
                    if (z) {
                        a.this.b();
                    } else {
                        a.this.c();
                    }
                }

                @Override // com.sigmob.sdk.base.common.b
                public void b(boolean z, long j) {
                    if (z) {
                        a.this.e();
                    } else {
                        a.this.c();
                    }
                }
            }, baseAdUnit.getUuid());
            aPKStatusBroadcastReceiver.a(aPKStatusBroadcastReceiver);
            this.c.put(baseAdUnit.getUuid(), aPKStatusBroadcastReceiver);
        }
    }

    public void b(String str) {
        post(new ADYaiT(this, 1, str));
    }

    public void a(Object obj, String str) {
        this.d.addJavascriptInterface(obj, str);
    }

    public void b(String str, ValueCallback valueCallback) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.evaluateJavascript(str, valueCallback);
    }

    public void a(String str) {
        this.d.loadUrl(str);
    }

    public void a(String str, ValueCallback valueCallback) {
        if (this.d == null) {
            return;
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        this.d.evaluateJavascript(str, valueCallback);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void a(boolean z) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.a(z);
    }
}
