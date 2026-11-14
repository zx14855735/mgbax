package com.bytedance.msdk.core.admanager;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.xj.kd.w;
import com.bytedance.msdk.xj.xj.u;
import com.bytedance.msdk.y.hf.hf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final String[] hf;
    private static final ArrayList<String> u;
    private static final ArrayList<String> w;
    private static final ArrayList<C0054xj> xj = new ArrayList<>();

    /* renamed from: com.bytedance.msdk.core.admanager.xj$xj, reason: collision with other inner class name */
    public static class C0054xj {
        int hf;
        String w;
        String xj;

        public C0054xj(String str, int i, String str2) {
            this.xj = str;
            this.hf = i;
            this.w = str2;
        }
    }

    static {
        String[] strArr = {"TTTransparentActivity", "openadsdk", "com.bykv", "com.qq", "com.kwad", "baidu", "mbridge", "sigmob", MediationConstant.ADN_UNITY, MediationConstant.ADN_KLEVIN};
        hf = strArr;
        w = new ArrayList<>(Arrays.asList(strArr));
        u = new ArrayList<>();
        SRhFHUB();
    }

    private static /* synthetic */ void SRhFHUB() {
        char[] charArray = "\u0003\u000f\rN\u0007\u0001\r\u0005N\u0002\u000f\u0019N\u0013\b\u0005\f\fN*\u000e\t\"\u0012\t\u0004\u0007\u0005".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '`');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0003\f\t\u000e\t\u0014".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '`');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static boolean hf(String str, String str2) {
        return w(str, str2) >= 0;
    }

    private static int w(String str, String str2) {
        String substring = str2.substring(2);
        if (str.startsWith(t.c) || str.startsWith("V")) {
            str = str.substring(1);
        }
        return str.compareTo(substring);
    }

    public static boolean xj(String str, int i, int i2) {
        ArrayList<C0054xj> arrayList = xj;
        if (arrayList.size() <= 0) {
            return TextUtils.equals("baidu", str);
        }
        Iterator<C0054xj> it = arrayList.iterator();
        while (it.hasNext()) {
            C0054xj next = it.next();
            if (next != null && TextUtils.equals(next.xj, str) && i2 == next.hf) {
                String str2 = next.w;
                u xj2 = hf.xj().xj(str);
                String hf2 = xj2 != null ? xj2.hf() : null;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(hf2)) {
                    if (str2.startsWith("<=")) {
                        return xj(hf2, str2);
                    }
                    if (str2.startsWith(">=")) {
                        return hf(hf2, str2);
                    }
                }
            }
        }
        return false;
    }

    public static boolean hf(String str) {
        w.hf(MediationConstant.TAG, "--==--- activityStr: ".concat(String.valueOf(str)));
        Iterator<String> it = w.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return w(str);
            }
        }
        return false;
    }

    private static boolean w(String str) {
        ArrayList<String> arrayList = u;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean xj(String str, String str2) {
        return w(str, str2) <= 0;
    }

    public static void xj(String str) {
        ArrayList<String> arrayList;
        List asList;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                w.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("act_str");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            w.add(optString);
                        }
                    }
                }
                u.clear();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("not_act_str");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        String optString2 = optJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(optString2)) {
                            u.add(optString2);
                        }
                    }
                }
                xj.clear();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("not_support");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        JSONObject optJSONObject = optJSONArray3.optJSONObject(i3);
                        if (optJSONObject != null) {
                            xj.add(new C0054xj(optJSONObject.optString(SplashAd.KEY_BIDFAIL_ADN), optJSONObject.optInt("subtype"), optJSONObject.optString("versions")));
                        }
                    }
                }
                arrayList = w;
                asList = Arrays.asList(hf);
            } catch (JSONException e) {
                pl.xj(e);
                arrayList = w;
                asList = Arrays.asList(hf);
            }
            arrayList.addAll(asList);
        } catch (Throwable th) {
            w.addAll(Arrays.asList(hf));
            throw th;
        }
    }
}
