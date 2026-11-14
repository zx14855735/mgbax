package com.bytedance.sdk.component.adexpress.kd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.xj.et;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static int c = 10;
    private static volatile kd d = null;
    private static final byte[] kd = new byte[0];
    private static int y = 10;
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final List<SSWebView> xj = new ArrayList();
    private final List<SSWebView> hf = new ArrayList();
    private final WeakHashMap<com.bytedance.sdk.component.g.w, w> w = new WeakHashMap<>();
    private final WeakHashMap<com.bytedance.sdk.component.g.w, u> u = new WeakHashMap<>();

    static {
        xUxmV();
    }

    private kd() {
        com.bytedance.sdk.component.adexpress.xj.xj.w w = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w();
        if (w != null) {
            y = w.f();
            c = w.d();
        }
    }

    private static /* synthetic */ void xUxmV() {
        char[] charArray = "\u009b\u0097\u0095Ö\u009f\u0099\u0095\u009dÖ\u009a\u0097\u0081Ö\u008b\u0090\u009d\u0094\u0094Ö²\u0096\u0091º\u008a\u0091\u009c\u009f\u009d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 248);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009b\u0094\u0091\u0096\u0091\u008c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 248);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static kd xj() {
        if (d == null) {
            synchronized (kd.class) {
                try {
                    if (d == null) {
                        d = new kd();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    @UiThread
    public void hf(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.G_();
        y(sSWebView);
        xj(sSWebView);
    }

    public boolean kd(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    public void u(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.xj.size() >= y) {
            sSWebView.destroy();
        } else {
            if (this.xj.contains(sSWebView)) {
                return;
            }
            this.xj.add(sSWebView);
            w();
        }
    }

    @UiThread
    public void w(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.G_();
        y(sSWebView);
        u(sSWebView);
    }

    public void y(SSWebView sSWebView) {
        w wVar;
        if (sSWebView == null || (wVar = this.w.get(sSWebView)) == null) {
            return;
        }
        wVar.xj(null);
    }

    public int kd() {
        return u() + this.xj.size();
    }

    public SSWebView hf(Context context, String str) {
        SSWebView remove;
        if (w() <= 0 || (remove = this.xj.remove(0)) == null) {
            return null;
        }
        w();
        return remove;
    }

    public int w() {
        return this.xj.size();
    }

    public int u() {
        return this.hf.size();
    }

    public void hf() {
        for (SSWebView sSWebView : this.xj) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.xj.clear();
        for (SSWebView sSWebView2 : this.hf) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.hf.clear();
        synchronized (this.u) {
            this.u.clear();
        }
    }

    public SSWebView xj(Context context, String str) {
        SSWebView remove;
        if (u() <= 0 || (remove = this.hf.remove(0)) == null) {
            return null;
        }
        this.hf.size();
        return remove;
    }

    public void xj(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.hf.size() >= c) {
            sSWebView.destroy();
        } else {
            if (this.hf.contains(sSWebView)) {
                return;
            }
            this.hf.add(sSWebView);
            this.hf.size();
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void xj(SSWebView sSWebView, hf hfVar) {
        if (sSWebView == null || hfVar == null) {
            return;
        }
        w wVar = this.w.get(sSWebView);
        if (wVar != null) {
            wVar.xj(hfVar);
        } else {
            wVar = new w(hfVar);
            this.w.put(sSWebView, wVar);
        }
        sSWebView.addJavascriptInterface(wVar, "SDK_INJECT_GLOBAL");
    }

    private static void xj(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f.hf().post(runnable);
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void xj(final com.bytedance.sdk.component.g.w wVar, et etVar, final String str) {
        final u uVar;
        if (wVar == null || etVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.u) {
            try {
                uVar = this.u.get(wVar);
                if (uVar != null) {
                    uVar.xj(etVar);
                } else {
                    uVar = new u(etVar);
                    this.u.put(wVar, uVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        xj(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.kd.kd.1
            @Override // java.lang.Runnable
            public void run() {
                wVar.addJavascriptInterface(uVar, str);
            }
        });
    }

    public void xj(final com.bytedance.sdk.component.g.w wVar, final String str) {
        if (wVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.u) {
            try {
                u uVar = this.u.get(wVar);
                if (uVar != null) {
                    uVar.xj(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        xj(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.kd.kd.2
            @Override // java.lang.Runnable
            public void run() {
                wVar.removeJavascriptInterface(str);
            }
        });
    }
}
