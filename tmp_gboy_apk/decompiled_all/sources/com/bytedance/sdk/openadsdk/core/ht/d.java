package com.bytedance.sdk.openadsdk.core.ht;

import android.content.Context;
import android.os.Looper;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.openadsdk.core.pz;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d implements com.bytedance.sdk.component.f.xj.u {
    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean am() {
        return pz.hf().jk();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public com.bytedance.sdk.component.f.xj.xj.hf c() {
        return new tf(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w());
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public Executor d() {
        return com.bytedance.sdk.component.tf.c.xj();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean g() {
        return false;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public String hf() {
        return "csj_";
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public String kd() {
        return com.bytedance.sdk.openadsdk.core.a.tf.g();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public com.bytedance.sdk.component.f.hf.w p() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public com.bytedance.sdk.component.f.xj.f pl() {
        return xj.xj;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public Looper qt() {
        return com.bytedance.sdk.component.tf.hf.xj.xj().hf().getLooper();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public int tf() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean u() {
        return com.bytedance.sdk.openadsdk.core.j.d.xj();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean w() {
        return pz.hf().pz();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean xj() {
        return false;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean y() {
        return true;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    /* renamed from: zg, reason: merged with bridge method [inline-methods] */
    public ExecutorService f() {
        return com.bytedance.sdk.component.tf.c.hf();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public String hf(String str) {
        return com.bytedance.sdk.component.utils.xj.hf(str);
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public com.bytedance.sdk.component.f.xj.hf xj(JSONObject jSONObject) {
        try {
            jSONObject.put("is_new", true);
            jSONObject.put("sdk_session_id", hf.xj);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.bytedance.sdk.component.f.hf.u.xj.xj xjVar = new com.bytedance.sdk.component.f.hf.u.xj.xj(UUID.randomUUID().toString(), com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("new_adlog_monitor").hf(jSONObject.toString()).xj());
        xjVar.w((byte) 0);
        xjVar.hf((byte) 2);
        xjVar.xj((byte) 1);
        return xjVar;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean xj(Context context) {
        return com.bytedance.sdk.component.utils.am.xj(context);
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public String xj(String str) {
        return com.bytedance.sdk.component.utils.xj.w(str);
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public void xj(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean ft = pz.hf().ft();
        if (jSONObject2 != null && jSONObject2.optInt(cb.o) == 1 && ft) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(jSONObject, jSONObject2);
    }
}
