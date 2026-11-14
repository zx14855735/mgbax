package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f12197a;

    public ar(Context context) {
        if (Engine.loadSuccess) {
            try {
                String klm = Engine.getInstance(context).klm(56, context.getPackageName());
                if (TextUtils.isEmpty(klm)) {
                    return;
                }
                this.f12197a = new JSONObject(klm);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f12197a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
