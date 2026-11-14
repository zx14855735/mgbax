package com.bytedance.sdk.component.utils;

import android.annotation.TargetApi;
import android.os.Looper;
import android.webkit.WebView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p {
    private static final xj xj = new hf();

    @TargetApi(19)
    public static class hf extends xj {
        private hf() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.p.xj
        public void xj(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            p.hf(new Runnable() { // from class: com.bytedance.sdk.component.utils.p.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (str2 != null && str2.startsWith("javascript:")) {
                        try {
                            webView.evaluateJavascript(str, null);
                            return;
                        } catch (Throwable th) {
                            boolean z = th instanceof IllegalStateException;
                        }
                    }
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static class xj {
        private xj() {
        }

        public void xj(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            p.hf(new Runnable() { // from class: com.bytedance.sdk.component.utils.p.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    static {
        NvsoOLH();
    }

    private static /* synthetic */ void NvsoOLH() {
        char[] charArray = "\u009e\u0092\u0090Ó\u009a\u009c\u0090\u0098Ó\u009f\u0092\u0084Ó\u008e\u0095\u0098\u0091\u0091Ó·\u0093\u0094¿\u008f\u0094\u0099\u009a\u0098".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 253);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009e\u0091\u0094\u0093\u0094\u0089".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 253);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f.hf().post(runnable);
        }
    }

    @Deprecated
    public static void xj(WebView webView, String str) {
        xj.xj(webView, str);
    }

    public static void xj(com.bytedance.sdk.component.g.w wVar, String str) {
        xj.xj(wVar.getWebView(), str);
    }
}
