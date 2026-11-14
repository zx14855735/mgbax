package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ra.q;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public static void hf(Context context) {
        Vibrator w = w(context);
        if (w != null) {
            w.cancel();
        }
    }

    private static boolean kd(Context context) {
        Vibrator w = w(context);
        return w != null && w.hasVibrator();
    }

    private static boolean u(Context context) {
        return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0;
    }

    public static Vibrator w(Context context) {
        try {
            return (Vibrator) context.getSystemService("vibrator");
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean xj(Context context) {
        return u(context) && kd(context);
    }

    public static void xj(Context context, q qVar) {
        new xj(context, qVar).hf();
    }

    public static void xj(JSONObject jSONObject, Context context, ws wsVar) {
        q xj;
        if (jSONObject == null || context == null) {
            return;
        }
        String optString = jSONObject.optString(f.f13353a);
        JSONArray optJSONArray = jSONObject.optJSONArray("pattern");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            xj(context, new q(optString, optJSONArray));
        } else {
            if (TextUtils.isEmpty(optString) || wsVar == null || (xj = wsVar.xj(optString)) == null) {
                return;
            }
            xj(context, xj);
        }
    }
}
