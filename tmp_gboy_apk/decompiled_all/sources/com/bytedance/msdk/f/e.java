package com.bytedance.msdk.f;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e {
    private static String hf(String str, String str2) {
        try {
            return xj.xj(str.getBytes(StandardCharsets.UTF_8), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean xj() {
        Map<String, Object> io2 = com.bytedance.msdk.core.xj.p().io();
        Map<String, Object> et = com.bytedance.msdk.core.xj.p().et();
        if (io2 != null) {
            try {
                if (io2.get("eefo") instanceof Boolean) {
                    return ((Boolean) io2.get("eefo")).booleanValue();
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (et == null || !(et.get("eefo") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) et.get("eefo")).booleanValue();
    }

    public static String xj(com.bytedance.msdk.api.w wVar) {
        if (wVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, wVar.d());
            jSONObject.put("custom_adn_name", wVar.tf());
            jSONObject.put("slot_id", wVar.p());
            jSONObject.put("level_tag", wVar.am());
            jSONObject.put("ecpm", wVar.g());
            jSONObject.put("bidding_type", wVar.qt());
            jSONObject.put("error_msg", wVar.zg());
            jSONObject.put(PointParamKey.REQUEST_ID, wVar.e());
            jSONObject.put("ad_rit_type", wVar.hf());
            jSONObject.put("ad_sub_rit_type", wVar.w());
            jSONObject.put("segment_id", wVar.u());
            jSONObject.put("abtest_id", wVar.c());
            jSONObject.put("channel", wVar.kd());
            jSONObject.put("sub_channel", wVar.y());
            jSONObject.put("scenario_id", wVar.f());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        try {
            String xj = xj(16);
            String hf = hf(jSONObject2, xj);
            String xj2 = xj(xj, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7aAsZzOAmVVuIl0EZtpY\nPkJGdr82VIOzPBDYNEOBK0tfk/oSWyY8yZDpeYuhNuSPySmhaN8Apn3HGfL1Eq6t\nSE3OdAovRJjnilU/5ugSM/nr5yMy6WRvJUskvQ9F3PF9MLez8ZJxVDb4tgUXjq2S\n1QKSP+NwAKdY+P/H8SD5evamqCpvzO1IwpqznNI2HGAo/Kdm5OQ+Yq47A31dDUSH\nVF/TTzTfae8j6lanqgz9DmFs+kqoy253aXlz8H0z8J3VpmOGvnOUiS00Hg5SILV0\nsoXtS9JKK/V3gXmbXWyFvZhuIvLqk3C8AdyZuDdy1GAI3GjI4wjtiMd11zSTECrV\ntQIDAQAB");
            return String.format("%04d", Integer.valueOf(xj2.length())) + xj2 + hf;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String xj(String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, generatePublic);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String xj(int i) {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i2 = 0; i2 < i; i2++) {
            int nextInt = secureRandom.nextInt(3);
            if (nextInt == 0) {
                sb.append(secureRandom.nextInt(10));
            } else if (nextInt == 1) {
                sb.append((char) (secureRandom.nextInt(25) + 65));
            } else if (nextInt == 2) {
                sb.append((char) (secureRandom.nextInt(25) + 97));
            }
        }
        return sb.toString();
    }
}
