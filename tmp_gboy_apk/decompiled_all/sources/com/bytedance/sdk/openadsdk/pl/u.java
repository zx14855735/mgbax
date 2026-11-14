package com.bytedance.sdk.openadsdk.pl;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.tf;
import com.bytedance.sdk.component.hf.xj.y;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.et.kd;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.pl.xj.xj;
import com.sigmob.sdk.archives.tar.e;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements xj {
    public static final AtomicInteger xj = new AtomicInteger(0);
    private String y;
    private List<com.bytedance.sdk.openadsdk.pl.xj.xj> u = new ArrayList();
    private HashMap<String, HashMap<String, byte[]>> kd = new HashMap<>();
    public AtomicInteger hf = new AtomicInteger(0);
    final ExecutorService w = c.xj();

    static {
        NLPjcPu();
    }

    private u(w wVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        u uVar;
        String str5;
        String str6;
        JSONObject jSONObject2;
        String str7;
        String str8;
        if (wVar != null) {
            if (wVar.xj()) {
                uVar = this;
                str5 = str;
                str6 = str2;
                jSONObject2 = jSONObject;
                str7 = str3;
                str8 = str4;
                com.bytedance.sdk.openadsdk.pl.xj.hf hfVar = new com.bytedance.sdk.openadsdk.pl.xj.hf(uVar, str5, str6, jSONObject2, str7, str8);
                hfVar.hf();
                uVar.u.add(hfVar);
            } else {
                uVar = this;
                str5 = str;
                str6 = str2;
                jSONObject2 = jSONObject;
                str7 = str3;
                str8 = str4;
            }
            if (wVar.hf()) {
                String str9 = str8;
                String str10 = str7;
                JSONObject jSONObject3 = jSONObject2;
                com.bytedance.sdk.openadsdk.pl.xj.w wVar2 = new com.bytedance.sdk.openadsdk.pl.xj.w(this, str5, str6, jSONObject3, str10, str9);
                uVar = this;
                str8 = str9;
                wVar2.hf();
                uVar.u.add(wVar2);
            }
            uVar.y = str8;
            xj.incrementAndGet();
            xj((WebView) null, uVar.y);
        }
    }

    private static /* synthetic */ void NLPjcPu() {
        char[] charArray = "øôöµüúöþµùôâµèóþ÷÷µÑõòÙéòÿüþ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 155);
        }
        String str = new String(charArray);
        char[] charArray2 = "ø÷òõòï".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 155);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean w() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj
    public AtomicInteger hf() {
        return this.hf;
    }

    public void u() {
        if (!this.u.isEmpty()) {
            Iterator<com.bytedance.sdk.openadsdk.pl.xj.xj> it = this.u.iterator();
            while (it.hasNext()) {
                it.next().w();
            }
        }
        this.u.clear();
    }

    public WebResourceResponse hf(WebView webView, final hf hfVar, WebResourceResponse webResourceResponse) {
        String hf;
        if (hfVar != null && (hf = hfVar.hf()) != null && TextUtils.equals(hf, "get")) {
            if (pz.hf().yy() == 1) {
                WebResourceResponse xj2 = xj(pz.getContext(), this.y, hfVar);
                if (xj2 != null) {
                    xj2.getResponseHeaders().put("Access-Control-Allow-Origin", "*");
                    return xj2;
                }
            } else {
                xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pl.u.2
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.xj(pz.getContext(), u.this.y, hfVar);
                    }
                });
            }
        }
        return webResourceResponse;
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj
    public HashMap<String, HashMap<String, byte[]>> xj() {
        return this.kd;
    }

    public static w xj(ws wsVar, Context context) {
        boolean z = false;
        boolean z2 = wsVar.gy() == 1;
        boolean xj2 = com.bytedance.sdk.openadsdk.core.y.hf.xj(wsVar.hf() / 100.0f, false);
        boolean z3 = pz.hf().tj() == 1;
        boolean z4 = am.u(context) || !(pz.hf().wn() == 1);
        boolean w = w();
        boolean z5 = z2 && z3 && z4 && w;
        if (xj2 && z3 && w) {
            z = true;
        }
        w wVar = new w();
        wVar.xj(z5);
        wVar.hf(z);
        return wVar;
    }

    public static String hf(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context).getAbsolutePath());
        return CtFAbx.B25kr6(sb, File.separator, ".lp_cache");
    }

    public static u xj(Context context, ws wsVar, String str) {
        JSONObject jb;
        w xj2 = xj(wsVar, context);
        if ((!xj2.xj() && !xj2.hf()) || (jb = wsVar.jb()) == null) {
            return null;
        }
        String optString = jb.optString("cid");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        String optString2 = jb.optString("req_id");
        if (TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new u(xj2, optString, optString2, jb, wsVar.jf(), str);
    }

    public WebResourceResponse xj(WebView webView, hf hfVar, WebResourceResponse webResourceResponse) {
        Iterator<com.bytedance.sdk.openadsdk.pl.xj.xj> it = this.u.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().xj(webView)) {
                z = true;
            }
        }
        return !z ? webResourceResponse : hf(webView, hfVar, webResourceResponse);
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj
    public void xj(final Runnable runnable) {
        this.w.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pl.u.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (u.this.w) {
                    try {
                        runnable.run();
                    } finally {
                    }
                }
            }
        });
    }

    public WebResourceResponse xj(final Context context, final String str, final hf hfVar) {
        WebResourceResponse webResourceResponse;
        final Pair<WebResourceResponse, WebResourceResponse> xj2;
        final Pair<WebResourceResponse, tf> xj3 = xj(hfVar);
        if (xj3 == null || (webResourceResponse = (WebResourceResponse) xj3.first) == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.openadsdk.pl.xj.xj> it = this.u.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().xj((tf) xj3.second)) {
                z = true;
            }
        }
        if (!z || (xj2 = xj(webResourceResponse)) == null) {
            return null;
        }
        for (final com.bytedance.sdk.openadsdk.pl.xj.xj xjVar : this.u) {
            xjVar.xj(hfVar, (WebResourceResponse) xj2.second, (tf) xj3.second, new xj.InterfaceC0203xj() { // from class: com.bytedance.sdk.openadsdk.pl.u.3
                @Override // com.bytedance.sdk.openadsdk.pl.xj.xj.InterfaceC0203xj
                public void xj(boolean z2, final Map<String, Object> map) {
                    if (z2) {
                        u.this.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pl.u.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AtomicBoolean atomicBoolean = xjVar.kd;
                                    if (atomicBoolean == null || atomicBoolean.get()) {
                                        return;
                                    }
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    u.this.xj(context, str, hfVar, (WebResourceResponse) xj2.second, (tf) xj3.second, map, xjVar);
                                } catch (Throwable th) {
                                    pl.xj(th);
                                }
                            }
                        });
                    }
                }
            });
        }
        return (WebResourceResponse) xj2.first;
    }

    public void xj(Context context, String str, hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, Map<String, Object> map, com.bytedance.sdk.openadsdk.pl.xj.xj xjVar) {
        if (xjVar.xj(tfVar)) {
            pz.hf().tu();
            if (pz.hf().tu() == 1) {
                xjVar.xj(context, str, hfVar, webResourceResponse, tfVar, map);
            } else {
                xjVar.hf(context, str, hfVar, webResourceResponse, tfVar, map);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.util.Pair<android.webkit.WebResourceResponse, android.webkit.WebResourceResponse> xj(android.webkit.WebResourceResponse r13) {
        /*
            r12 = this;
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.io.InputStream r0 = r13.getData()     // Catch: java.lang.Exception -> L26
            int r0 = com.bytedance.sdk.openadsdk.pl.hf.hf.xj(r0, r1)     // Catch: java.lang.Exception -> L26
            r3 = -1
            if (r0 == r3) goto L29
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L26
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L26
            r3.<init>(r0)     // Catch: java.lang.Exception -> L26
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L24
            byte[] r4 = r1.toByteArray()     // Catch: java.lang.Exception -> L24
            r0.<init>(r4)     // Catch: java.lang.Exception -> L24
            goto L38
        L24:
            r0 = move-exception
            goto L2c
        L26:
            r0 = move-exception
            r3 = r2
            goto L2c
        L29:
            r0 = r2
            r3 = r0
            goto L38
        L2c:
            com.bytedance.sdk.component.utils.pl.xj(r0)
            r1.close()     // Catch: java.lang.Throwable -> L33
            goto L37
        L33:
            r0 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r0)
        L37:
            r0 = r2
        L38:
            boolean r1 = w()
            if (r1 == 0) goto L8b
            android.webkit.WebResourceResponse r4 = new android.webkit.WebResourceResponse
            java.lang.String r5 = r13.getMimeType()
            java.lang.String r6 = r13.getEncoding()
            int r7 = r13.getStatusCode()
            java.lang.String r8 = r13.getReasonPhrase()
            java.util.Map r9 = r13.getResponseHeaders()
            r1 = 0
            if (r3 != 0) goto L5e
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            byte[] r2 = new byte[r1]
            r3.<init>(r2)
        L5e:
            r10 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10)
            android.webkit.WebResourceResponse r5 = new android.webkit.WebResourceResponse
            java.lang.String r6 = r13.getMimeType()
            java.lang.String r7 = r13.getEncoding()
            int r8 = r13.getStatusCode()
            java.lang.String r9 = r13.getReasonPhrase()
            java.util.Map r10 = r13.getResponseHeaders()
            if (r0 != 0) goto L81
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            byte[] r13 = new byte[r1]
            r0.<init>(r13)
        L81:
            r11 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            android.util.Pair r13 = new android.util.Pair
            r13.<init>(r4, r5)
            return r13
        L8b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.pl.u.xj(android.webkit.WebResourceResponse):android.util.Pair");
    }

    private Pair<WebResourceResponse, tf> xj(hf hfVar) {
        if (w() && hfVar != null) {
            try {
                com.bytedance.sdk.component.hf.xj.pl y = kd.xj().hf().y();
                am.xj xjVar = new am.xj();
                Map<String, String> w = hfVar.w();
                if (w != null) {
                    for (String str : w.keySet()) {
                        xjVar.hf(str, w.get(str));
                    }
                }
                xjVar.xj(hfVar.xj().toString());
                zg hf = y.xj(xjVar.hf()).hf();
                int w2 = hf.w();
                if (w2 == 200) {
                    HashMap hashMap = new HashMap();
                    y c = hf.c();
                    if (c != null) {
                        for (int i = 0; i < c.xj(); i++) {
                            hashMap.put(c.xj(i), c.hf(i));
                        }
                    }
                    InputStream w3 = hf.y().w();
                    tf xj2 = xj(hashMap);
                    return new Pair<>(new WebResourceResponse(xj2.xj() + "/" + xj2.hf(), xj2.w() == null ? null : xj2.w().toString(), w2, xj(w2), hashMap, w3), xj2);
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.sdk.component.hf.xj.tf xj(java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L2f
            java.lang.String r0 = "Content-Type"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L11
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L11:
            java.lang.String r0 = "content-type"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L20
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L20:
            java.lang.String r0 = "CONTENT-TYPE"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L2f
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L2f:
            r3 = 0
        L30:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L38
            java.lang.String r3 = "text/html; charset=UTF-8"
        L38:
            com.bytedance.sdk.component.hf.xj.tf r3 = com.bytedance.sdk.component.hf.xj.tf.xj(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.pl.u.xj(java.util.Map):com.bytedance.sdk.component.hf.xj.tf");
    }

    public static void xj(Context context) {
        if (w()) {
            try {
                File file = new File(hf(context));
                if (System.currentTimeMillis() - file.lastModified() <= 3000 || !file.exists()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.pl.hf.xj.hf(hf(context));
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    public void xj(WebView webView, String str) {
        if (com.bytedance.sdk.component.utils.am.xj(str)) {
            this.hf.incrementAndGet();
            this.hf.get();
            Iterator<com.bytedance.sdk.openadsdk.pl.xj.xj> it = this.u.iterator();
            while (it.hasNext()) {
                it.next().xj(str);
            }
        }
    }

    private String xj(int i) {
        if (i == 100) {
            return "Continue";
        }
        if (i != 101) {
            switch (i) {
                case 200:
                    return cb.k;
                case 201:
                    return "Created";
                case 202:
                    return "Accepted";
                case 203:
                    return "Non-Authoritative Information";
                case 204:
                    return "No Content";
                case 205:
                    return "Reset Content";
                case 206:
                    return "Partial Content";
                default:
                    switch (i) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL /* 400 */:
                            return "Bad Request";
                        case 401:
                            return "Unauthorized";
                        case 402:
                            return "Payment Required";
                        case 403:
                            return "Forbidden";
                        case 404:
                            return "Not Found";
                        case 405:
                            return "Method Not Allowed";
                        case 406:
                            return "Not Acceptable";
                        case 407:
                            return "Proxy Authentication Required";
                        case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                            return "Request Time-out";
                        case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                            return "Conflict";
                        case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                            return "Gone";
                        case TTAdConstant.IMAGE_CODE /* 411 */:
                            return "Length Required";
                        case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                            return "Precondition Failed";
                        case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                            return "Request Entity Too Large";
                        case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                            return "Request-URI Too Large";
                        case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                            return "Unsupported Media Type";
                        case 416:
                            return "Requested range not satisfiable";
                        case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                            return "Expectation Failed";
                        default:
                            switch (i) {
                                case 500:
                                    return "Internal Server Error";
                                case MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE /* 501 */:
                                    return "Not Implemented";
                                case 502:
                                    return "Bad Gateway";
                                case 503:
                                    return "Service Unavailable";
                                case e.E /* 504 */:
                                    return "Gateway Time-out";
                                case 505:
                                    return "HTTP Version not supported";
                                default:
                                    return "";
                            }
                    }
            }
        }
        return "Switching Protocols";
    }
}
