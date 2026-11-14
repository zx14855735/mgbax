package com.bytedance.msdk.kd;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.dk;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends xj {
    private static final SimpleDateFormat u = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    static {
        MjBAo();
    }

    public c(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    private static /* synthetic */ void MjBAo() {
        char[] charArray = "w{y:suyq:v{m:g|qxx:^z}Vf}psq".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 20);
        }
        String str = new String(charArray);
        char[] charArray2 = "wx}z}`".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 20);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static JSONObject hf(Context context, u uVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("event", uVar.xj);
            jSONObject2.putOpt("params", jSONObject);
            jSONObject2.putOpt("nt", Integer.valueOf(dk.kd()));
            jSONObject2.putOpt("datetime", u.format(new Date()));
            return jSONObject2;
        } catch (Exception e) {
            try {
                JSONObject optJSONObject = jSONObject2.optJSONObject("params");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("event_extra");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject3 = new JSONObject(optString);
                        jSONObject3.putOpt("v3_err_msg", e.toString());
                        optJSONObject.putOpt("event_extra", jSONObject3.toString());
                    }
                }
                if (uVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("v3_eventId", uVar.ht.get("event_id"));
                    jSONObject4.putOpt("v3_err_msg", e.toString());
                    ai.xj(jSONObject4);
                }
            } catch (Throwable unused) {
            }
            return jSONObject2;
        }
    }

    public static c xj(Context context, u uVar, JSONObject jSONObject) {
        return new c(UUID.randomUUID().toString(), hf(context, uVar, jSONObject));
    }

    @Override // com.bytedance.msdk.kd.xj
    public String toString() {
        return "AdEventV3{localId='" + this.xj + "', event=" + this.hf + '}';
    }
}
