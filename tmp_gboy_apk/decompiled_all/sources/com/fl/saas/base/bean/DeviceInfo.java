package com.fl.saas.base.bean;

import A5SV6n.A2egSU;
import android.os.Build;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.OaidUtils;
import java.lang.reflect.Method;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DeviceInfo {
    private static final String os = "Android";
    private String boot_mark;
    private String update_mark;
    private String verCodeOfAG;
    private String verCodeOfHms;
    private static final String osv = DeviceUtil.getDeviceSystemVersion();
    private static final int devicetype = DeviceUtil.isTablet() ? 1 : 0;
    private static final String brand = DeviceUtil.getDeviceBrand();
    private static final float density = DeviceUtil.getScreenDensity();
    private final String connectiontype = DeviceUtil.getNetworkType();
    private final String carrier = DeviceUtil.getOperators();
    private final int orientation = DeviceUtil.getOrientation();
    private final int sw = DeviceUtil.getMobileWidth();
    private final int sh = DeviceUtil.getMobileHeight();
    private final String model = DeviceUtil.getDeviceModel();
    private final String imei = DeviceUtil.getImei();
    private final String oaid = OaidUtils.getOaid();
    private final String androidid = DeviceUtil.getAndroidID();
    private final String mac = DeviceUtil.getMacAddress();
    private final String mark = DeviceUtil.getDeviceMANUFACTURER();
    private final int api_level = Build.VERSION.SDK_INT;

    static {
        HmHf();
    }

    public DeviceInfo() {
        try {
            this.boot_mark = DeviceUtil.getBootMark();
            this.update_mark = DeviceUtil.getUpdateMark();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.verCodeOfHms = DeviceUtil.directGetHmsVersionCode();
        this.verCodeOfAG = DeviceUtil.directGetAgVersionCode();
    }

    private static /* synthetic */ void HmHf() {
        char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '{');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '{');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static DeviceInfo create() {
        return new DeviceInfo();
    }
}
