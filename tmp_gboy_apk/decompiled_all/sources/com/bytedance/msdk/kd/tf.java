package com.bytedance.msdk.kd;

import android.content.Context;
import android.os.Looper;
import com.bytedance.msdk.f.dk;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements com.bytedance.sdk.component.f.xj.u {
    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean am() {
        return false;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public com.bytedance.sdk.component.f.xj.xj.hf c() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public Executor d() {
        return com.bytedance.msdk.xj.kd.y.y();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public Executor f() {
        return com.bytedance.msdk.xj.kd.y.y();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean g() {
        return false;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public String hf() {
        return "mediation_log";
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public String kd() {
        return "gromore-no-webview";
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public com.bytedance.sdk.component.f.hf.w p() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public com.bytedance.sdk.component.f.xj.f pl() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public Looper qt() {
        return com.bytedance.sdk.component.tf.hf.xj.xj().hf().getLooper();
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public int tf() {
        return 2;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean u() {
        return true;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean w() {
        return false;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public com.bytedance.sdk.component.f.xj.hf xj(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean y() {
        return false;
    }

    public static String w(String str) {
        return com.bytedance.msdk.f.xj.hf(str, com.bytedance.msdk.f.hf.xj());
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public String hf(String str) {
        return com.bytedance.msdk.f.xj.xj(str, com.bytedance.msdk.f.hf.xj());
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public void xj(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean xj() {
        return false;
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public boolean xj(Context context) {
        return dk.xj(context);
    }

    @Override // com.bytedance.sdk.component.f.xj.u
    public String xj(String str) {
        return w(str);
    }
}
