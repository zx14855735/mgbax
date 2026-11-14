package com.fl.saas.base.bean;

import A5SV6n.A2egSU;
import com.fl.saas.config.utils.DeviceUtil;
import java.lang.reflect.Method;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AppInfo {
    private static final String name = DeviceUtil.getAppName();
    private static final String bundle = DeviceUtil.getMyPackageName();
    private static final String version = DeviceUtil.getVersionName();
    private final String id = DeviceUtil.appId;
    private final String channel = DeviceUtil.channelId;
    private final String sub_channel = DeviceUtil.subChannel;
    private final int orientation = 3;

    static {
        cMpw();
    }

    private static /* synthetic */ void cMpw() {
        char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'N');
        }
        String str = new String(charArray);
        char[] charArray2 = "-\"' ':".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'N');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AppInfo create() {
        return new AppInfo();
    }
}
