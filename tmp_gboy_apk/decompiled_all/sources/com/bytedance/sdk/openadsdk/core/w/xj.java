package com.bytedance.sdk.openadsdk.core.w;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.a.p;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.a.x;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static boolean hf = false;
    private static volatile String u = null;
    private static AtomicBoolean w = new AtomicBoolean(false);
    private static long xj = -1;

    static {
        LLmUemQ();
    }

    private static /* synthetic */ void LLmUemQ() {
        char[] charArray = "éåç¤íëçï¤èåó¤ùâïææ¤ÀäãÈøãîíï".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 138);
        }
        String str = new String(charArray);
        char[] charArray2 = "éæãäãþ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 138);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean hf() {
        if (hf) {
            return true;
        }
        if (xj == -1) {
            return false;
        }
        boolean z = SystemClock.elapsedRealtime() - xj > 60000;
        hf = z;
        return z;
    }

    public static String w() {
        if (!TextUtils.isEmpty(u)) {
            return u;
        }
        String w2 = u.xj().w((String) null);
        u = w2;
        return w2;
    }

    public static void xj() {
        if (xj > -1) {
            return;
        }
        xj = SystemClock.elapsedRealtime();
    }

    public static JSONObject xj(Context context, int i) {
        return hf(context, i);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(31:2|3|4|(3:154|(1:156)|157)(3:8|(1:10)|11)|12|(3:150|(1:152)|153)(3:16|(1:18)|19)|20|21|(3:146|(1:148)|149)(3:25|(1:27)|28)|29|30|(1:32)(1:145)|33|(3:141|(1:143)|144)(3:37|(1:39)|40)|41|42|(3:137|(1:139)|140)(3:46|(1:48)|49)|50|(1:52)|53|(3:132|(1:134)(1:136)|135)(3:57|(1:59)|60)|61|(3:127|(1:129)(1:131)|130)(3:65|(1:67)|68)|69|(3:122|(1:124)(1:126)|125)(3:73|(1:75)|76)|77|(3:117|(1:119)(1:121)|120)(3:81|(1:83)(1:116)|84)|85|(3:112|(1:114)|115)(1:89)|90|91)|(2:93|(9:95|96|(1:98)|99|(1:101)|102|103|104|105))|111|96|(0)|99|(0)|102|103|104|105) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x038a, code lost:
    
        r2.put("device_score", -1);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0370 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #0 {all -> 0x0037, blocks: (B:3:0x0009, B:6:0x0022, B:8:0x002c, B:11:0x0033, B:14:0x004b, B:16:0x0055, B:19:0x005c, B:20:0x006d, B:23:0x007a, B:25:0x0084, B:28:0x008b, B:29:0x009c, B:32:0x00a8, B:35:0x00bb, B:37:0x00c5, B:40:0x00cc, B:41:0x00dd, B:44:0x0179, B:46:0x0183, B:49:0x018a, B:50:0x019b, B:52:0x025b, B:55:0x0268, B:57:0x0272, B:60:0x0279, B:63:0x028f, B:65:0x0299, B:68:0x02a0, B:71:0x02b6, B:73:0x02c0, B:76:0x02c7, B:79:0x02dd, B:81:0x02e7, B:84:0x02ef, B:87:0x0305, B:89:0x030f, B:90:0x0320, B:93:0x0330, B:95:0x033e, B:96:0x0349, B:98:0x035c, B:99:0x0361, B:101:0x0370, B:103:0x0375, B:104:0x038d, B:110:0x038a, B:111:0x0342, B:112:0x0313, B:115:0x031d, B:117:0x02f3, B:120:0x02fe, B:122:0x02cb, B:125:0x02d6, B:127:0x02a4, B:130:0x02af, B:132:0x027d, B:135:0x0288, B:137:0x018e, B:140:0x0198, B:141:0x00d0, B:144:0x00da, B:145:0x00b0, B:146:0x008f, B:149:0x0099, B:150:0x0060, B:153:0x006a, B:154:0x003a, B:157:0x0044), top: B:2:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x035c A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:3:0x0009, B:6:0x0022, B:8:0x002c, B:11:0x0033, B:14:0x004b, B:16:0x0055, B:19:0x005c, B:20:0x006d, B:23:0x007a, B:25:0x0084, B:28:0x008b, B:29:0x009c, B:32:0x00a8, B:35:0x00bb, B:37:0x00c5, B:40:0x00cc, B:41:0x00dd, B:44:0x0179, B:46:0x0183, B:49:0x018a, B:50:0x019b, B:52:0x025b, B:55:0x0268, B:57:0x0272, B:60:0x0279, B:63:0x028f, B:65:0x0299, B:68:0x02a0, B:71:0x02b6, B:73:0x02c0, B:76:0x02c7, B:79:0x02dd, B:81:0x02e7, B:84:0x02ef, B:87:0x0305, B:89:0x030f, B:90:0x0320, B:93:0x0330, B:95:0x033e, B:96:0x0349, B:98:0x035c, B:99:0x0361, B:101:0x0370, B:103:0x0375, B:104:0x038d, B:110:0x038a, B:111:0x0342, B:112:0x0313, B:115:0x031d, B:117:0x02f3, B:120:0x02fe, B:122:0x02cb, B:125:0x02d6, B:127:0x02a4, B:130:0x02af, B:132:0x027d, B:135:0x0288, B:137:0x018e, B:140:0x0198, B:141:0x00d0, B:144:0x00da, B:145:0x00b0, B:146:0x008f, B:149:0x0099, B:150:0x0060, B:153:0x006a, B:154:0x003a, B:157:0x0044), top: B:2:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject hf(android.content.Context r17, int r18) {
        /*
            Method dump skipped, instructions count: 917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.w.xj.hf(android.content.Context, int):org.json.JSONObject");
    }

    public static void xj(JSONObject jSONObject, int i) {
        if (!w.xj().xj(i)) {
            hf(jSONObject);
            return;
        }
        JSONArray e = u.xj().e();
        if (e != null) {
            if (e.length() > 0) {
                jSONObject.put("scheme_success_list", e);
            }
            if (w.get()) {
                return;
            }
            w.set(true);
            c.hf(new d("tt-scheme") { // from class: com.bytedance.sdk.openadsdk.core.w.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        xj.hf(null);
                    } catch (Exception unused) {
                    }
                    xj.w.set(false);
                }
            });
            return;
        }
        hf(jSONObject);
    }

    public static String[] xj(int i) {
        try {
            return tf.hf(!hf());
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String xj(String str, int i) {
        return p.xj(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(JSONObject jSONObject) {
        Set<String> vw = pz.hf().vw();
        if (vw == null || vw.size() <= 0) {
            return;
        }
        Map<String, Boolean> xj2 = x.xj(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : xj2.entrySet()) {
            String key = entry.getKey();
            if (vw.contains(key)) {
                String scheme = Uri.parse(key).getScheme();
                if (entry.getValue().booleanValue()) {
                    jSONArray.put(scheme);
                } else {
                    jSONArray2.put(scheme);
                }
            }
        }
        if (jSONObject != null && jSONArray.length() > 0) {
            jSONObject.put("scheme_success_list", jSONArray);
        }
        if (jSONObject != null && jSONArray2.length() > 0) {
            jSONObject.put("scheme_fail_list", jSONArray2);
        }
        if (jSONObject == null) {
            u.xj().xj(jSONArray);
        } else {
            c.hf(new d("tt-scheme-save") { // from class: com.bytedance.sdk.openadsdk.core.w.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    u.xj().xj(jSONArray);
                }
            });
        }
    }
}
