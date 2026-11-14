package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.util.xj;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static final xj xj = new xj.C0047xj().xj("https://log.snssdk.com/service/2/device_register_only/").xj(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"}).hf(new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"}).hf("https://log.snssdk.com/service/2/log_settings/").xj();
    private static final xj hf = new xj.C0047xj().xj("https://toblog.ctobsnssdk.com/service/2/device_register_only/").xj(new String[]{"https://toblog.ctobsnssdk.com/service/2/app_log/", "https://tobapplog.ctobsnssdk.com/service/2/app_log/"}).hf("https://toblog.ctobsnssdk.com/service/2/log_settings/").w("https://toblog.ctobsnssdk.com/service/2/abtest_config/").u("https://success.ctobsnssdk.com/service/2/app_log/").xj();

    static {
        shJZg();
    }

    private static /* synthetic */ void shJZg() {
        char[] charArray = "©¥§ä\u00ad«§¯ä¨¥³ä¹¢¯¦¦ä\u0080¤£\u0088¸£®\u00ad¯".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 202);
        }
        String str = new String(charArray);
        char[] charArray2 = "©¦£¤£¾".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 202);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static final xj xj(int i) {
        return hf;
    }
}
