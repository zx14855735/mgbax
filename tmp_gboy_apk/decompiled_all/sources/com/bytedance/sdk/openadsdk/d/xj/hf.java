package com.bytedance.sdk.openadsdk.d.xj;

import com.bytedance.sdk.component.xj.e;
import com.bytedance.sdk.component.xj.u;
import com.bytedance.sdk.openadsdk.core.j;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class hf extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private static WeakReference<xj> xj;
    private WeakReference<j> hf;

    public interface xj {
        void xj();

        void xj(int i);
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
    }

    private hf(j jVar) {
        this.hf = new WeakReference<>(jVar);
    }

    public static void xj(e eVar, final j jVar) {
        eVar.xj("onClickBrowseCloseCallback", new u.hf() { // from class: com.bytedance.sdk.openadsdk.d.xj.hf.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new hf(j.this);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        WeakReference<xj> weakReference = xj;
        xj xjVar = weakReference != null ? weakReference.get() : null;
        if (this.hf == null || jSONObject == null) {
            if (xjVar != null) {
                xjVar.xj();
                return;
            }
            return;
        }
        int optInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (optInt == Integer.MIN_VALUE) {
            if (xjVar != null) {
                xjVar.xj();
            }
        } else if (xjVar != null) {
            xjVar.xj(optInt);
        }
    }

    public static void xj(xj xjVar) {
        xj = new WeakReference<>(xjVar);
    }
}
