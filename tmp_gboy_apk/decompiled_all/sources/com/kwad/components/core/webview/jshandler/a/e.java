package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.local.LocalWriteResult;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private static SimpleDateFormat aiH = new SimpleDateFormat("yyyyMMddHHmmss");
    private final WeakReference<Context> aiG;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aiJ;
        private byte[] aiK;
        private String aiL;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            String[] split = this.aiJ.split(";base64,");
            if (split.length >= 2) {
                String str = split[0];
                if (str.startsWith("data:")) {
                    this.aiL = str.substring(5);
                }
                this.aiK = com.kwad.sdk.core.a.c.Jc().decode(split[1]);
            }
        }

        public final byte[] wo() {
            return this.aiK;
        }

        public final String wp() {
            return this.aiL;
        }
    }

    static {
        vcHxP();
    }

    public e(Context context) {
        this.aiG = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifySuccess function callback: " + cVar);
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(null);
                }
            }
        });
    }

    private static /* synthetic */ void vcHxP() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "saveImage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, final com.kwad.sdk.core.webview.c.c cVar) {
        final Context context = this.aiG.get();
        if (context == null) {
            return;
        }
        h.execute(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    com.kwad.sdk.core.d.c.d("SaveImageHandler", "saveImageData mime type: " + aVar.wp());
                    LocalWriteResult a2 = com.kwad.sdk.core.local.b.a(context, aVar.wp(), aVar.wo(), "ksad_image_" + e.aiH.format(new Date()));
                    if (LocalWriteResult.SUCCESS.equals(a2)) {
                        e.this.b(cVar);
                    } else if (LocalWriteResult.FAIL.equals(a2)) {
                        e.this.a(cVar, "write error", -1);
                    } else {
                        e.this.a(cVar, "permission denied", -2);
                    }
                } catch (Throwable th) {
                    e.this.a(cVar, "error_" + th.getMessage(), -3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar, final String str, final int i) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifyError msg: " + str);
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(i, str);
                }
            }
        });
    }
}
