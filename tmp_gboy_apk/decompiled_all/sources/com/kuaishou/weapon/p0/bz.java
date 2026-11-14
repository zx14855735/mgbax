package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class bz {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f12228a;

    public bz(Context context) {
        if (Engine.loadSuccess) {
            String fgh = Engine.getInstance(context).fgh();
            if (TextUtils.isEmpty(fgh)) {
                return;
            }
            try {
                this.f12228a = new JSONObject(fgh);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f12228a;
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
