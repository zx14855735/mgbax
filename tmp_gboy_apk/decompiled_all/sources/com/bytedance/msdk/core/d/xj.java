package com.bytedance.msdk.core.d;

import ADYaiT.CtFAbx;
import JrXYwF.A4TApA;
import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kuaishou.weapon.p0.t;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.videoAd.j;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    protected final ai hf;
    protected final Map<String, String> xj = new HashMap();

    public xj(String str) {
        this.hf = ai.xj(str, com.bytedance.msdk.core.hf.getContext());
        w();
    }

    private void w(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.hf.xj(str, d + "_" + System.currentTimeMillis());
        xj(str);
    }

    public void hf() {
        Map<String, ?> hf = this.hf.hf();
        if (hf != null) {
            for (Map.Entry<String, ?> entry : hf.entrySet()) {
                if (entry != null) {
                    xj(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
        }
    }

    public abstract boolean hf(String str, JSONObject jSONObject, Map<String, Object> map);

    public abstract Map<String, String> xj();

    public abstract JSONObject xj(com.bytedance.msdk.core.tf.w wVar);

    public abstract void xj(String str, int i, String str2);

    public abstract void xj(String str, String str2);

    public void xj(String str, String str2, String str3, double d) {
        String AcNBzu2 = CtFAbx.AcNBzu(str, str2);
        this.hf.xj(AcNBzu2, str3 + "_" + d);
    }

    private void hf(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.hf.xj(str, d + "_" + System.currentTimeMillis());
        xj(str);
    }

    private String w(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String hf = this.hf.hf(str);
            if (!TextUtils.isEmpty(hf) && !Constants.FAIL.equals(hf)) {
                String[] split = hf.split("_");
                String str2 = split[0];
                String str3 = split[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str3.matches("[0-9]+")) {
                        try {
                            if (com.bytedance.msdk.core.hf.hf().xj(System.currentTimeMillis() - Long.parseLong(str3))) {
                                return str2;
                            }
                            this.hf.y(str);
                        } catch (NumberFormatException unused) {
                            this.hf.y(str);
                            A4TApA.EH1KK8("自定义上报 saveTime format exception valueTimestamp ".concat(hf));
                        }
                    } else {
                        this.hf.y(str);
                        A4TApA.EH1KK8("自定义上报 saveTime is not number valueTimestamp ".concat(hf));
                    }
                }
            }
        }
        return Constants.FAIL;
    }

    public void xj(int i, String str, int i2, double d) {
        if (i2 == 1) {
            xj(i, str, d);
        } else if (i2 == 3) {
            hf(i, str, d);
        } else if (i2 == 2) {
            w(i, str, d);
        }
    }

    private String hf(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String hf = this.hf.hf(str);
            if (!TextUtils.isEmpty(hf) && !Constants.FAIL.equals(hf)) {
                String[] split = hf.split("_");
                String str2 = split[0];
                String str3 = split[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (com.bytedance.msdk.core.hf.hf().xj(System.currentTimeMillis() - Long.parseLong(str3))) {
                        return str2;
                    }
                    this.hf.y(str);
                }
            }
        }
        return Constants.FAIL;
    }

    public double xj(int i, String str, int i2) {
        if (i2 == 1) {
            return BigDecimal.valueOf(Double.parseDouble(xj(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 3) {
            return BigDecimal.valueOf(Double.parseDouble(hf(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 2) {
            return BigDecimal.valueOf(Double.parseDouble(w(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0d;
    }

    public void xj(double d, double d2, String str, String str2) {
        if (this.hf == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        xj(str, "_last_post_cpm_", str2, d);
        xj(str, "_last_bidding_cpm_", str2, d2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0125 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double[] xj(int r19, double r20, double r22, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.d.xj.xj(int, double, double, java.lang.String, java.lang.String):double[]");
    }

    public String hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(this.xj.get(String.valueOf(c)));
        }
        return sb.toString();
    }

    public void w() {
        this.xj.put(Constants.FAIL, t.f);
        this.xj.put("1", t.l);
        this.xj.put("2", "c");
        this.xj.put("3", t.t);
        this.xj.put("4", "e");
        this.xj.put("5", "f");
        this.xj.put("6", "g");
        this.xj.put("7", "h");
        this.xj.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, "i");
        this.xj.put("9", j.f);
        this.xj.put(".", t.f12297a);
    }

    private synchronized void xj(int i, String str, double d) {
        String str2 = "label_size_" + str;
        int hf = this.hf.hf(str2, 0) + 1;
        String xj = xj(str, hf);
        String xj2 = xj(str, d);
        xj(xj, i, xj2);
        this.hf.xj(xj, xj2);
        this.hf.xj(str2, hf);
    }

    private String xj(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            double[] dArr = new double[2];
            Iterator<Map.Entry<String, String>> it = xj().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (next != null) {
                    String value = next.getValue();
                    if (!TextUtils.isEmpty(value) && value.contains(str)) {
                        String[] split = value.split("_");
                        String str2 = split[0];
                        String str3 = split[1];
                        String str4 = split[2];
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                            if (com.bytedance.msdk.core.hf.hf().xj(System.currentTimeMillis() - Long.parseLong(str4))) {
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = Double.parseDouble(str3) + dArr[1];
                            } else {
                                it.remove();
                                this.hf.y(next.getKey());
                                String str5 = "label_size_" + str;
                                ai aiVar = this.hf;
                                aiVar.xj(str5, aiVar.w(str5) - 1);
                            }
                        }
                    }
                }
            }
            return xj(dArr);
        }
        return Constants.FAIL;
    }

    public void xj(String str) {
        for (int w = this.hf.w(CtFAbx.BChYOn("label_size_", str)); w > 0; w--) {
            try {
                String xj = xj(str, w);
                this.hf.y(xj);
                xj().remove(xj);
            } catch (Throwable th) {
                com.bytedance.msdk.xj.kd.w.u("CalculateLabelValueImpl", "clearFromSpByRit,ignore:" + th.toString());
            }
        }
    }

    private String xj(String str, int i) {
        return "cpm_key_" + str + "_" + i;
    }

    private String xj(String str, double d) {
        return str + "_" + d + "_" + System.currentTimeMillis();
    }

    public String xj(double[] dArr) {
        double d = dArr[0];
        if (d != 0.0d) {
            return new BigDecimal(dArr[1] / d).setScale(2, RoundingMode.HALF_UP).toString();
        }
        return "-1.0";
    }

    public static String xj(int i) {
        switch (i) {
            case 1:
                return "banner";
            case 2:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 3:
            case 4:
                return MediationConstant.RIT_TYPE_SPLASH;
            case 5:
                return "native";
            case 6:
            default:
                return null;
            case 7:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            case 8:
                return "fullscreenVideo";
            case 9:
                return MediationConstant.RIT_TYPE_DRAW;
            case 10:
                return MediationConstant.RIT_TYPE_INTERSTITIAL_FULL;
        }
    }

    public void xj(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.bytedance.msdk.core.hf.hf().vm() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (hf(str, jSONObject2, map == null ? new HashMap<>() : map)) {
            try {
                jSONObject.putOpt("label", jSONObject2);
                if (map == null || map.get("cost_time") == null) {
                    return;
                }
                jSONObject.put("uvalueExcTime", map.get("cost_time"));
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
    }
}
