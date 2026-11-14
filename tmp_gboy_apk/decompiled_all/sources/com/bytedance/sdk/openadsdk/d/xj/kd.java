package com.bytedance.sdk.openadsdk.d.xj;

import com.bytedance.sdk.component.xj.e;
import com.bytedance.sdk.component.xj.u;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private WeakReference<j> xj;

    public kd(j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
    }

    public static void xj(e eVar, final j jVar) {
        eVar.xj("openPrivacy", new u.hf() { // from class: com.bytedance.sdk.openadsdk.d.xj.kd.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new kd(j.this);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        j jVar;
        ws f;
        WeakReference<j> weakReference = this.xj;
        if (weakReference == null || (jVar = weakReference.get()) == null || (f = jVar.f()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.xj(yVar.getContext(), f);
        jVar.l();
    }
}
