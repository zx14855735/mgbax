package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.u.tf;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends com.bytedance.sdk.openadsdk.core.widget.xj.u {
    private final com.bytedance.sdk.openadsdk.am.f d;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.hf.g f10385pl;
    private ws tf;
    public ArrayList<Integer> xj;

    public y(Context context, j jVar, ws wsVar, com.bytedance.sdk.openadsdk.core.am.kd kdVar, boolean z, com.bytedance.sdk.openadsdk.am.f fVar, com.bytedance.sdk.component.adexpress.hf.g gVar) {
        super(context, jVar, wsVar.ho(), kdVar);
        this.xj = new ArrayList<>();
        this.tf = wsVar;
        this.p = z;
        this.d = fVar;
        this.f10385pl = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u() {
        if (hl.y(this.tf) != null) {
            return hl.y(this.tf).p();
        }
        if (hl.c(this.tf) != null) {
            return "v3";
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.y = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.c = false;
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.component.adexpress.hf.g gVar = this.f10385pl;
        if (gVar == null || !gVar.io()) {
            return;
        }
        com.bytedance.sdk.component.utils.p.xj(webView, "javascript:window.SDK_INJECT_DATA=" + this.f10385pl.kd());
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.w("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public int xj() {
        Iterator<Integer> it = this.xj.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() == 3 || next.intValue() == 2 || next.intValue() == -1) {
                return next.intValue();
            }
        }
        return TextUtils.isEmpty(u()) ? -1 : 1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|2|(1:4)|5|(2:7|(8:9|10|11|12|(1:16)|(4:20|(1:22)|23|24)|27|28))|33|10|11|12|(2:14|16)|(5:18|20|(0)|23|24)|27|28|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        com.bytedance.sdk.component.utils.pl.w("ExpressClient", "shouldInterceptRequest error2", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057 A[Catch: all -> 0x0049, TryCatch #1 {all -> 0x0049, blocks: (B:12:0x002f, B:14:0x0034, B:16:0x003b, B:18:0x004d, B:20:0x0053, B:22:0x0057, B:23:0x005a), top: B:11:0x002f }] */
    @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r9, java.lang.String r10) {
        /*
            r8 = this;
            com.bytedance.sdk.openadsdk.am.f r0 = r8.d     // Catch: java.lang.Throwable -> L8
            if (r0 == 0) goto Lc
            r0.f(r10)     // Catch: java.lang.Throwable -> L8
            goto Lc
        L8:
            r0 = move-exception
            r1 = r8
            r6 = r10
            goto L5f
        Lc:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8
            com.bytedance.sdk.openadsdk.core.ra.ws r0 = r8.tf     // Catch: java.lang.Throwable -> L8
            com.bytedance.sdk.openadsdk.core.nativeexpress.y$1 r1 = new com.bytedance.sdk.openadsdk.core.nativeexpress.y$1     // Catch: java.lang.Throwable -> L8
            r1.<init>()     // Catch: java.lang.Throwable -> L8
            com.bytedance.sdk.component.adexpress.xj.hf.xj r0 = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj.xj(r9, r0, r10, r1)     // Catch: java.lang.Throwable -> L8
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8
            if (r0 == 0) goto L2c
            android.webkit.WebResourceResponse r1 = r0.xj()     // Catch: java.lang.Throwable -> L8
            if (r1 == 0) goto L2c
            r1 = 1
            r7 = 1
        L29:
            r1 = r8
            r6 = r10
            goto L2f
        L2c:
            r1 = 2
            r7 = 2
            goto L29
        L2f:
            r1.xj(r2, r4, r6, r7)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L4b
            int r10 = r0.getType()     // Catch: java.lang.Throwable -> L49
            r2 = 5
            if (r10 == r2) goto L4b
            java.util.ArrayList<java.lang.Integer> r10 = r1.xj     // Catch: java.lang.Throwable -> L49
            int r2 = r0.getType()     // Catch: java.lang.Throwable -> L49
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L49
            r10.add(r2)     // Catch: java.lang.Throwable -> L49
            goto L4b
        L49:
            r0 = move-exception
            goto L5f
        L4b:
            if (r0 == 0) goto L66
            android.webkit.WebResourceResponse r10 = r0.xj()     // Catch: java.lang.Throwable -> L49
            if (r10 == 0) goto L66
            com.bytedance.sdk.openadsdk.am.f r10 = r1.d     // Catch: java.lang.Throwable -> L49
            if (r10 == 0) goto L5a
            r10.d(r6)     // Catch: java.lang.Throwable -> L49
        L5a:
            android.webkit.WebResourceResponse r9 = r0.xj()     // Catch: java.lang.Throwable -> L49
            return r9
        L5f:
            java.lang.String r10 = "ExpressClient"
            java.lang.String r2 = "shouldInterceptRequest error2"
            com.bytedance.sdk.component.utils.pl.w(r10, r2, r0)
        L66:
            android.webkit.WebResourceResponse r9 = super.shouldInterceptRequest(r9, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.y.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
    }

    private void xj(long j, long j2, String str, int i) {
        com.bytedance.sdk.openadsdk.core.am.kd kdVar = this.kd;
        if (kdVar == null || kdVar.w() == null) {
            return;
        }
        tf.xj xj = com.bytedance.sdk.component.adexpress.u.tf.xj(str);
        if (xj == tf.xj.HTML) {
            this.kd.w().xj(str, j, j2, i);
        } else if (xj == tf.xj.JS) {
            this.kd.w().hf(str, j, j2, i);
        }
    }
}
