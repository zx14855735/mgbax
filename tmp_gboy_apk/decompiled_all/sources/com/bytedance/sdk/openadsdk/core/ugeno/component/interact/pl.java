package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl extends com.bytedance.adsdk.ugeno.hf.w<InteractWebView> {
    private Map<String, Object> my;
    private String xj;

    public pl(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InteractWebView xj() {
        InteractWebView interactWebView = new InteractWebView(this.hf);
        this.kd = interactWebView;
        return interactWebView;
    }

    public void f() {
        if (TextUtils.isEmpty(this.xj)) {
            this.xj = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.kd).loadUrl(this.xj);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        Map<String, Object> hf = this.d.hf();
        this.my = hf;
        ((InteractWebView) this.kd).setUGenExtraMap(hf);
        ((InteractWebView) this.kd).setUGenContext(this.d);
        ((InteractWebView) this.kd).y();
        ((InteractWebView) this.kd).c();
        JSONObject tf = tf();
        if (tf != null) {
            com.bytedance.sdk.component.widget.hf.xj xjVar = new com.bytedance.sdk.component.widget.hf.xj();
            xjVar.xj(tf.optInt("meta_hashcode", 0));
            ((InteractWebView) this.kd).setMaterialMeta(xjVar);
        }
        f();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        if (str.equals("src")) {
            if (TextUtils.isEmpty(this.xj) || !this.xj.startsWith(Constants.HTTP)) {
                this.xj = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
            } else {
                this.xj = str2;
            }
        }
    }
}
