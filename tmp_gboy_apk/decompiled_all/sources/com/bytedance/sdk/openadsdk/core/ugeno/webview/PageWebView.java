package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.pz;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.am.kd;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.widget.xj.hf;
import com.bytedance.sdk.openadsdk.core.widget.xj.w;
import com.bytedance.sdk.openadsdk.core.yo.u;
import com.bytedance.sdk.openadsdk.x.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PageWebView extends FrameLayout implements u {
    private static final SparseArray<WeakReference<DownloadListener>> xj = new SparseArray<>();
    private SSWebView hf;
    private j kd;
    private ws u;
    private Context w;
    private am y;

    static {
        LXRXKyj();
    }

    public PageWebView(Context context) {
        super(context);
        this.w = context;
        SSWebView sSWebView = new SSWebView(context);
        this.hf = sSWebView;
        sSWebView.setMaterialMeta(ff.xj(this.u));
        addView(this.hf);
    }

    private static /* synthetic */ void LXRXKyj() {
        char[] charArray = "½±³ð¹¿³»ð¼±§ð\u00ad¶»²²ð\u0094°·\u009c¬·º¹»".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 222);
        }
        String str = new String(charArray);
        char[] charArray2 = "½²·°·ª".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 222);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        hf.xj(this.w).xj(false).hf(false).xj(this.hf);
        SSWebView sSWebView = this.hf;
        if (sSWebView != null) {
            pz.xj(sSWebView, ai.w, ws.u(this.u));
        }
        this.hf.setMixedContentMode(0);
        if (jSONObject == null || (weakReference = xj.get(jSONObject.hashCode())) == null || weakReference.get() == null) {
            return;
        }
        this.hf.setDownloadListener(weakReference.get());
    }

    public void hf(final JSONObject jSONObject) {
        c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PageWebView.this.w(jSONObject);
            }
        });
    }

    public void setMeta(ws wsVar) {
        this.u = wsVar;
        SSWebView sSWebView = this.hf;
        if (sSWebView != null) {
            sSWebView.setMaterialMeta(ff.xj(wsVar));
        }
    }

    public void setUGenContext(am amVar) {
        this.y = amVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.u
    public void xj(boolean z, JSONArray jSONArray) {
    }

    public static void xj(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener == null || jSONObject == null) {
            return;
        }
        xj.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
    }

    public static void xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            xj.remove(jSONObject.hashCode());
        }
    }

    public void xj() {
        Map<String, Object> hf;
        if (this.hf == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.u);
        this.kd = new j(this.w);
        am amVar = this.y;
        if (amVar != null && (hf = amVar.hf()) != null && hf.containsKey("key_reward_page")) {
            Object obj = hf.get("key_reward_page");
            if (obj instanceof Map) {
                this.kd.xj((Map<String, Object>) obj);
            }
        }
        this.kd.hf(this.hf).xj(this.u).w(arrayList).hf(this.u.ho()).u(this.u.jf()).w(7).xj(wo.hf(this.u)).kd(wo.zg(this.u)).xj(this.hf).xj(true).hf(tf.xj(this.u)).xj((u) this);
        this.hf.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.w, this.kd, this.u.ho(), new kd(this.u, this.hf), null));
        this.hf.setWebChromeClient(new w(this.kd));
    }

    public void xj(String str) {
        SSWebView sSWebView = this.hf;
        if (sSWebView != null) {
            sSWebView.loadUrl(str);
        }
    }
}
