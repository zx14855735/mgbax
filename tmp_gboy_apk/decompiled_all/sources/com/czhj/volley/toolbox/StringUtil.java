package com.czhj.volley.toolbox;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class StringUtil {
    public static String clsName = null;
    public static String cn = "q1vljpre1fq";
    public static String dc = "gf1vljpre1fq";
    public static String rtb = "uwefdooedfn1vljpre1fq";
    public static String s = "vljpre";
    public static String sad = "vljpreDg";
    public static String service = "dgvhuylfh1vljpre1fq";
    public static String tb_service = "wp1vljpre1fq";
    public static String tp = "wudfnws1vljpre1fq";
    public static String track = "wudfn1vljpre1fq";
    public static Map<String, String> urlMap;

    static {
        HashMap hashMap = new HashMap();
        urlMap = hashMap;
        clsName = "frp1f}km";
        hashMap.put(decode(service), "adservice.sigmob.cn");
        urlMap.put(decode(dc), "dc.sigmob.cn");
        urlMap.put(decode(track), "track.sigmob.cn");
        urlMap.put(decode(tp), "tracktp.sigmob.cn");
        urlMap.put(decode(cn), "n.sigmob.cn");
        urlMap.put(decode(rtb), "rtbcallback.sigmob.cn");
        urlMap.put(decode(tb_service), "tm.sigmob.cn");
        iJjk();
    }

    public static String decode(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - 3);
        }
        return new String(bytes);
    }

    public static String getUrl(String str) {
        if (StringUtil.class.getName().startsWith(decode(clsName))) {
            return str;
        }
        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(str) && str.contains(key)) {
                try {
                    String host = new URL(str).getHost();
                    if (host != null && host.toLowerCase().equals(key)) {
                        return str.replace(key, value);
                    }
                } catch (Throwable unused) {
                    return str.replace(key, value);
                }
            }
        }
        return str;
    }

    private static /* synthetic */ void iJjk() {
        char[] charArray = "§«©ê£¥©¡ê¦«½ê·¬¡¨¨ê\u008eª\u00ad\u0086¶\u00ad £¡".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 196);
        }
        String str = new String(charArray);
        char[] charArray2 = "§¨\u00adª\u00ad°".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 196);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String scheme() {
        return decode(sad);
    }
}
